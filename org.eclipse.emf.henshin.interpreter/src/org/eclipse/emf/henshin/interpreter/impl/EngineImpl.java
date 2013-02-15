/*******************************************************************************
 * Copyright (c) 2010 CWI Amsterdam, Technical University Berlin, 
 * Philipps-University Marburg and others. All rights reserved. 
 * This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Technical University Berlin - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.henshin.interpreter.impl;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.interpreter.Change;
import org.eclipse.emf.henshin.interpreter.Change.CompoundChange;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.ChangeImpl.AttributeChangeImpl;
import org.eclipse.emf.henshin.interpreter.impl.ChangeImpl.CompoundChangeImpl;
import org.eclipse.emf.henshin.interpreter.impl.ChangeImpl.ObjectChangeImpl;
import org.eclipse.emf.henshin.interpreter.impl.ChangeImpl.ReferenceChangeImpl;
import org.eclipse.emf.henshin.interpreter.info.ConditionInfo;
import org.eclipse.emf.henshin.interpreter.info.RuleChangeInfo;
import org.eclipse.emf.henshin.interpreter.info.RuleInfo;
import org.eclipse.emf.henshin.interpreter.info.VariableInfo;
import org.eclipse.emf.henshin.interpreter.matching.conditions.AndFormula;
import org.eclipse.emf.henshin.interpreter.matching.conditions.ApplicationCondition;
import org.eclipse.emf.henshin.interpreter.matching.conditions.AttributeConditionHandler;
import org.eclipse.emf.henshin.interpreter.matching.conditions.IFormula;
import org.eclipse.emf.henshin.interpreter.matching.conditions.NotFormula;
import org.eclipse.emf.henshin.interpreter.matching.conditions.OrFormula;
import org.eclipse.emf.henshin.interpreter.matching.conditions.XorFormula;
import org.eclipse.emf.henshin.interpreter.matching.constraints.DomainSlot;
import org.eclipse.emf.henshin.interpreter.matching.constraints.Solution;
import org.eclipse.emf.henshin.interpreter.matching.constraints.SolutionFinder;
import org.eclipse.emf.henshin.interpreter.matching.constraints.UserConstraint;
import org.eclipse.emf.henshin.interpreter.matching.constraints.Variable;
import org.eclipse.emf.henshin.model.And;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Formula;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Not;
import org.eclipse.emf.henshin.model.Or;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Xor;

/**
 * The default implementation of {@link Engine}.
 * 
 * @author Christian Krause, Gregor Bonifer, Enrico Biermann
 */
public class EngineImpl implements Engine {
		
	// Options to be used:
	protected final Map<String,Object> options;

	// Script engine used to compute Java expressions in attributes:
	protected final ScriptEngine scriptEngine;

	// Cached information lookup map for each rule:
	protected final Map<Rule,RuleInfo> ruleInfos;

	// Cached graph options:
	protected final Map<Graph,MatchingOptions> graphOptions;
	
	// Whether to sort variables.
	protected boolean sortVariables;

	/**
	 * Default constructor.
	 */
	public EngineImpl() {
		ruleInfos = new HashMap<Rule, RuleInfo>();
		graphOptions = new HashMap<Graph,MatchingOptions>();
		options = new EngineOptions();
		sortVariables = true;
		scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.emf.henshin.interpreter.Engine#findMatches(org.eclipse.emf.henshin.model.Rule, org.eclipse.emf.henshin.interpreter.EGraph, org.eclipse.emf.henshin.interpreter.Match)
	 */
	@Override
	public Iterable<Match> findMatches(Rule rule, EGraph graph, Match partialMatch) {
		if (rule==null || graph==null) {
			throw new NullPointerException("Rule and graph must not be null");
		}
		if (partialMatch==null) {
			partialMatch = new MatchImpl(rule);
		}
		return new MatchGenerator(rule, graph, partialMatch);
	}

	/**
	 * Match generator. Delegates to {@link MatchFinder}.
	 */
	private final class MatchGenerator implements Iterable<Match> {

		// Rule to be matched:
		private final Rule rule; 

		// Object graph:
		private final EGraph graph;

		// A partial match:
		private final Match partialMatch;

		/**
		 * Default constructor.
		 * @param rule Rule to be matched.
		 * @param graph Object graph.
		 * @param partialMatch Partial match.
		 */
		public MatchGenerator(Rule rule, EGraph graph, Match partialMatch) {
			this.rule = rule;
			this.graph = graph;
			this.partialMatch = partialMatch;
		}

		/*
		 * (non-Javadoc)
		 * @see java.lang.Iterable#iterator()
		 */
		@Override
		public Iterator<Match> iterator() {
			return new MatchFinder(rule, graph, partialMatch, new HashSet<EObject>());
		}

	} // MatchGenerator

	/**
	 * Match finder. Uses {@link SolutionFinder} to find matches.
	 */
	private final class MatchFinder implements Iterator<Match> {

		// The next match:
		private Match nextMatch;
		
		// Flag indicating whether the next match was computed:
		private boolean computedNextMatch;
		
		// Target graph:
		private final EGraph graph;

		// Solution finder to be used
		private final SolutionFinder solutionFinder;

		// Rule to be matched:
		private final Rule rule;
		
		// Cached rule info:
		private final RuleInfo ruleInfo;

		// Used objects:
		private final Set<EObject> usedObjects;

		/**
		 * Default constructor.
		 * @param rule Rule to be matched.
		 * @param graph Object graph.
		 * @param partialMatch A partial match.
		 * @param usedObjects Used objects (for ensuring injectivity).
		 */
		public MatchFinder(Rule rule, EGraph graph, Match partialMatch, Set<EObject> usedObjects) {
			this.rule = rule;
			this.ruleInfo = getRuleInfo(rule);
			this.graph = graph;
			this.usedObjects = usedObjects;
			this.solutionFinder = createSolutionFinder(partialMatch);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			if (!computedNextMatch) {
				computeNextMatch();
				computedNextMatch = true;
			}
			return (nextMatch!=null);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public Match next() {
			hasNext();
			computedNextMatch = false;
			return nextMatch;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		/*
		 * Compute the next match.
		 */
		private void computeNextMatch() {

			// We definitely need a solution finder:
			if (solutionFinder==null) {
				nextMatch = null;
				return;
			}

			// Find the next solution:
			Solution solution = solutionFinder.getNextSolution();
			if (solution==null) {
				nextMatch = null;
				return;
			}

			// Create the new match:
			nextMatch = new MatchImpl(rule);
			Map<Node, Variable> node2var = ruleInfo.getVariableInfo().getNode2variable();
			
			// Parameter values:
			for (Entry<String,Object> entry : solution.parameterValues.entrySet()) {
				Parameter param = nextMatch.getUnit().getParameter(entry.getKey());
				if (param!=null) {
					nextMatch.setParameterValue(param, entry.getValue());
				}
			}
			
			// LHS node targets:
			for (Node node : rule.getLhs().getNodes()) {
				nextMatch.setNodeTarget(node, solution.objectMatches.get(node2var.get(node)));
			}

			// Now handle the multi-rules:
			for (Rule multiRule : rule.getMultiRules()) {

				// The used kernel objects:
				Set<EObject> usedKernelObjects = new HashSet<EObject>(usedObjects);
				usedKernelObjects.addAll(nextMatch.getNodeTargets());

				// Create the partial multi match:
				Match partialMultiMatch = new MatchImpl(multiRule);
				for (Parameter param : rule.getParameters()) {
					Parameter multiParam = multiRule.getParameter(param.getName());
					if (multiParam!=null) {
						partialMultiMatch.setParameterValue(multiParam, nextMatch.getParameterValue(param));
					}
				}
				for (Mapping mapping : multiRule.getMultiMappings()) {
					partialMultiMatch.setNodeTarget(mapping.getImage(),
							nextMatch.getNodeTarget(mapping.getOrigin()));
				}

				// Find all multi-matches:
				MatchFinder matchFinder = new MatchFinder(multiRule, graph, partialMultiMatch, usedKernelObjects);
				List<Match> nestedMatches = nextMatch.getNestedMatches(multiRule);
				while (matchFinder.hasNext()) {
					nestedMatches.add(matchFinder.next());
				}

			}
		}

		/*
		 * Create a solution finder.
		 */
		protected SolutionFinder createSolutionFinder(Match partialMatch) {

			// Get the required info objects:
			final RuleInfo ruleInfo = getRuleInfo(rule);
			final ConditionInfo conditionInfo = ruleInfo.getConditionInfo();
			final VariableInfo varInfo = ruleInfo.getVariableInfo();

			// Evaluates attribute conditions of the rule:
			AttributeConditionHandler conditionHandler = new AttributeConditionHandler(conditionInfo.getConditionParameters(), scriptEngine);

			/* The set "usedObjects" ensures injective matching by removing *
			 * already matched objects from other DomainSlots               */

			/* Create a domain map where all variables are mapped to slots. *
			 * Different variables may share one domain slot, if there is a *
			 * mapping between the nodes of the variables.                  */

			Map<Variable,DomainSlot> domainMap = new HashMap<Variable,DomainSlot>();
			
			for (Variable mainVariable : varInfo.getMainVariables()) {
				Node node = varInfo.getVariableForNode(mainVariable);
				MatchingOptions opt = getGraphOptions(node.getGraph());
				DomainSlot domainSlot = new DomainSlot(conditionHandler, usedObjects, opt.injective, opt.dangling, opt.deterministic);

				// Fix this slot?
				EObject target = partialMatch.getNodeTarget(node);
				if (target!=null) {
					domainSlot.fixInstantiation(target);
				}

				// Add the dependent variables to the domain map:
				for (Variable dependendVariable : varInfo.getDependendVariables(mainVariable)) {
					domainMap.put(dependendVariable, domainSlot);
				}
			}

			// Check if any of the conditions failed:
			for (Parameter param : rule.getParameters()) {
				Object value = partialMatch.getParameterValue(param);
				if (value!=null && !conditionHandler.setParameter(param.getName(), value)) {
					return null;
				}
			}

			// Sort the main variables based on the size of their domains:
			Map<Graph,List<Variable>> graphMap;
			if (sortVariables) {
				graphMap = new HashMap<Graph, List<Variable>>();
				for (Entry<Graph,List<Variable>> entry : ruleInfo.getVariableInfo().getGraph2variables().entrySet()) {
					List<Variable> sorted = new ArrayList<Variable>(entry.getValue());
					Collections.sort(sorted, new VariableComparator(graph, varInfo, partialMatch));  // sorting the variables
					graphMap.put(entry.getKey(), sorted);
				}
			} else {
				graphMap = ruleInfo.getVariableInfo().getGraph2variables();
			}

			// Now initialize the match finder:
			SolutionFinder solutionFinder = new SolutionFinder(graph, domainMap, conditionHandler);
			solutionFinder.variables = graphMap.get(rule.getLhs());
			solutionFinder.formula = initFormula(rule.getLhs().getFormula(), graph, graphMap, domainMap);
			return solutionFinder;

		}

		/*
		 * Initialize a formula.
		 */
		private IFormula initFormula(Formula formula, EGraph graph, Map<Graph,List<Variable>> graphMap, Map<Variable,DomainSlot> domainMap) {
			if (formula instanceof And) {
				And and = (And) formula;
				IFormula left = initFormula(and.getLeft(), graph, graphMap, domainMap);
				IFormula right = initFormula(and.getRight(), graph, graphMap, domainMap);
				return new AndFormula(left, right);
			}
			else if (formula instanceof Or) {
				Or or = (Or) formula;
				IFormula left = initFormula(or.getLeft(), graph, graphMap, domainMap);
				IFormula right = initFormula(or.getRight(), graph, graphMap, domainMap);
				return new OrFormula(left, right);
			}
			else if (formula instanceof Xor) {
				Xor xor = (Xor) formula;
				IFormula left = initFormula(xor.getLeft(), graph, graphMap, domainMap);
				IFormula right = initFormula(xor.getRight(), graph, graphMap, domainMap);
				return new XorFormula(left, right);
			}
			else if (formula instanceof Not) {
				Not not = (Not) formula;
				IFormula child = initFormula(not.getChild(), graph, graphMap, domainMap);
				return new NotFormula(child);
			}
			else if (formula instanceof NestedCondition) {
				NestedCondition nc = (NestedCondition) formula;
				return initApplicationCondition(nc, graph, graphMap, domainMap);
			}
			return IFormula.TRUE;
		}

		/*
		 * Initialize an application condition.
		 */
		private ApplicationCondition initApplicationCondition(NestedCondition nc, EGraph graph, Map<Graph, List<Variable>> graphMap, Map<Variable,DomainSlot> domainMap) {
			ApplicationCondition ac = new ApplicationCondition(graph, domainMap);
			ac.variables = graphMap.get(nc.getConclusion());
			ac.formula = initFormula(nc.getConclusion().getFormula(), graph, graphMap, domainMap);
			return ac;
		}

	} // MatchFinder
	
	/**
	 * Comparator for variables. Used to sort variables for optimal matching order.
	 */
	private class VariableComparator implements Comparator<Variable> {
		
		// Target graph:
		private final EGraph graph;
		
		// Variable info:
		private final VariableInfo varInfo;
		
		// Partial match:
		private final Match partialMatch;
		
		/**
		 * Constructor.
		 * @param graph Target graph
		 * @param varInfo Variable info.
		 * @param partialMatch Partial match.
		 */
		public VariableComparator(EGraph graph, VariableInfo varInfo, Match partialMatch) {
			this.graph = graph;
			this.varInfo = varInfo;
			this.partialMatch = partialMatch;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Variable v1, Variable v2) {
			
			// Get the corresponding nodes:
			Node n1 = varInfo.getVariableForNode(v1);
			if (n1==null) return 1;
			Node n2 = varInfo.getVariableForNode(v2);
			if (n2==null) return -1;

			// One of the nodes already matched or an attribute given as a parameter?
			if (partialMatch!=null) {
				if (isNodeMatched(n1)) return -1;
				if (isNodeMatched(n2)) return 1;
			}
			
			// Get the domain sizes (smaller number wins):
			int s = (graph.getDomainSize(v1.typeConstraint.type, v1.typeConstraint.strictTyping) - 
					 graph.getDomainSize(v2.typeConstraint.type, v2.typeConstraint.strictTyping));
			if (s!=0) return s;
			
			// Attribute count (larger number wins):
			int a = (n2.getAttributes().size() - n1.getAttributes().size());
			if (a!=0) return a;
			
			// Outgoing edge count (larger number wins):
			return n2.getOutgoing().size() - n1.getOutgoing().size();
			
		}
		
		private boolean isNodeMatched(Node node) {
			if (partialMatch.getNodeTarget(node)!=null) {
				return true;
			}
			for (Attribute attribute : node.getAttributes()) {
				String value = attribute.getValue();
				if (value!=null) {
					Parameter param = node.getGraph().getContainerRule().getParameter(value);
					if (param!=null && partialMatch.getParameterValue(param)!=null) {
						return true;
					}
				}
			}
			return false;
		}
		
	} // VariableComparator

	
	/*
	 * Get the cached rule info for a given rule.
	 */
	protected RuleInfo getRuleInfo(Rule rule) {
		RuleInfo ruleInfo = ruleInfos.get(rule);
		if (ruleInfo == null) {
			ruleInfo = new RuleInfo(rule, this);
			ruleInfos.put(rule, ruleInfo);
			
			for (Node node : rule.getLhs().getNodes()){
				this.createUserConstraints(ruleInfo, node);
			}
			
			// Check for missing factories:			
			for (Node node : ruleInfo.getChangeInfo().getCreatedNodes()) {
				if (node.getType()==null) {
					throw new RuntimeException("Missing type for " + node);
				}
				if (node.getType().getEPackage()==null || 
					node.getType().getEPackage().getEFactoryInstance()==null) {
					throw new RuntimeException("Missing factory for type '" + node.getType().getName() + 
							"'. Register the corresponding package, e.g. using PackageName.eINSTANCE.getName().");
				}
			}
		}
		return ruleInfo;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.emf.henshin.interpreter.Engine#createChange(org.eclipse.emf.henshin.model.Rule, org.eclipse.emf.henshin.interpreter.EGraph, org.eclipse.emf.henshin.interpreter.Match, org.eclipse.emf.henshin.interpreter.Match)
	 */
	@Override
	public Change createChange(Rule rule, EGraph graph, Match completeMatch, Match resultMatch) {

		// We need a result match:
		if (resultMatch==null) {
			resultMatch = new MatchImpl(rule, true);
		}

		// Create the object changes:
		CompoundChangeImpl complexChange = new CompoundChangeImpl(graph);
		createChanges(rule, graph, completeMatch, resultMatch, complexChange);
		return complexChange;

	}

	/*
	 * Recursively create the changes and result matches.
	 */
	public void createChanges(Rule rule, EGraph graph, Match completeMatch, Match resultMatch, CompoundChange complexChange) {

		// Get the rule change info and the object change list:
		RuleChangeInfo ruleChange = getRuleInfo(rule).getChangeInfo();
		List<Change> changes= complexChange.getChanges();

		for (Parameter param : rule.getParameters()) {
			Object value = completeMatch.getParameterValue(param);
			resultMatch.setParameterValue(param, value);
			scriptEngine.put(param.getName(), value);
		}

		// Created objects:
		for (Node node : ruleChange.getCreatedNodes()) {
			// We should not create objects that are already created by the kernel rule:
			if (rule.getMultiMappings().getOrigin(node)==null) {
				EClass type = node.getType();
				EObject createdObject = type.getEPackage().getEFactoryInstance().create(type);
				changes.add(new ObjectChangeImpl(graph, createdObject, true));
				resultMatch.setNodeTarget(node, createdObject);
			}
		}

		// Deleted objects:
		for (Node node : ruleChange.getDeletedNodes()) {	
			// We should not delete objects that are already deleted by the kernel rule:
			if (rule.getMultiMappings().getOrigin(node)==null) {
				EObject deletedObject = completeMatch.getNodeTarget(node);
				changes.add(new ObjectChangeImpl(graph, deletedObject, false));
				// TODO: Shouldn't we check the rule options?
				if (!rule.isCheckDangling()) {
					// TODO: What about outgoing edges?
					Collection<Setting> removedEdges = graph.getCrossReferenceAdapter().getInverseReferences(deletedObject);
					for (Setting edge : removedEdges) {
						changes.add(new ReferenceChangeImpl(graph, 
								edge.getEObject(), deletedObject, 
								(EReference) edge.getEStructuralFeature(), false));
					}
				}
			}
		}

		// Preserved objects:
		for (Node node : ruleChange.getPreservedNodes()) {
			Node lhsNode = rule.getMappings().getOrigin(node);
			resultMatch.setNodeTarget(node, completeMatch.getNodeTarget(lhsNode));
		}

		// Deleted edges:
		for (Edge edge : ruleChange.getDeletedEdges()) {
			// We should not delete edges that are already deleted by the kernel rule:
			if (rule.getMultiMappings().getOrigin(edge)==null) {			
				changes.add(new ReferenceChangeImpl(graph,
						completeMatch.getNodeTarget(edge.getSource()), 
						completeMatch.getNodeTarget(edge.getTarget()), 
						edge.getType(),
						false));
			}
		}

		// Created edges:
		for (Edge edge : ruleChange.getCreatedEdges()) {
			// We should not create edges that are already created by the kernel rule:
			if (rule.getMultiMappings().getOrigin(edge)==null) {
				changes.add(new ReferenceChangeImpl(graph,
						resultMatch.getNodeTarget(edge.getSource()),
						resultMatch.getNodeTarget(edge.getTarget()), 
						edge.getType(), 
						true));
			}
		}

		// Attribute changes:
		for (Attribute attribute : ruleChange.getAttributeChanges()) {
			EObject object = resultMatch.getNodeTarget(attribute.getNode());
			Object value = evalAttributeExpression(attribute);
			changes.add(new AttributeChangeImpl(graph, object, attribute.getType(), value));
		}

		// Now recursively for the multi-rules:
		for (Rule multiRule : rule.getMultiRules()) {
			for (Match multiMatch : completeMatch.getNestedMatches(multiRule)) {
				Match multiResultMatch = new MatchImpl(multiRule, true);
				for (Mapping mapping : multiRule.getMultiMappings()) {
					if (mapping.getImage().getGraph().isRhs()) {
						multiResultMatch.setNodeTarget(mapping.getImage(), 
							 resultMatch.getNodeTarget(mapping.getOrigin()));
					}
				}
				createChanges(multiRule, graph, multiMatch, multiResultMatch, complexChange);
				resultMatch.getNestedMatches(multiRule).add(multiResultMatch);
			}
		}

	}
	
	/*
	 * Evaluates a given JavaScript-Expression.
	 */
	public Object evalAttributeExpression(Attribute attribute) {

		/* If the attribute's type is an Enumeration, its value shall be rather
		 * checked against the Ecore model than against the JavaScript machine. */
		if ((attribute.getType()!=null) && (attribute.getType().getEType() instanceof EEnum)) {
			EEnum eenum = (EEnum) attribute.getType().getEType();
			return eenum.getEEnumLiteral(attribute.getValue());
		}

		// Try to evaluate the expression:
		try {
			Object value = scriptEngine.eval(attribute.getValue());
			if (value==null) {
				return null;
			}
			// Number format conversions:
			if (value instanceof Number) {
				EDataType type = attribute.getType().getEAttributeType();
				EcorePackage P = EcorePackage.eINSTANCE;
				if (type==P.getEByte() || type==P.getEByteObject()) {
					return ((Number) value).byteValue();
				}
				else if (type==P.getEInt() || type==P.getEIntegerObject()) {
					return ((Number) value).intValue();
				}
				else if (type==P.getELong() || type==P.getELongObject()) {
					return ((Number) value).longValue();
				}
				else if (type==P.getEFloat() || type==P.getEFloatObject()) {
					return ((Number) value).floatValue();
				}
				else if (type==P.getEDouble() || type==P.getEDoubleObject()) {
					return ((Number) value).doubleValue();
				}
			}
			// Generic attribute value creation:
			return EcoreUtil.createFromString(attribute.getType().getEAttributeType(), value.toString());
		}
		catch (ScriptException e) {
			throw new RuntimeException(e.getMessage());
		}

	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.emf.henshin.interpreter.Engine#getOptions()
	 */
	@Override
	public Map<String,Object> getOptions() {
		return options;
	}
	
	/*
	 * Data class for storing matching options.
	 */
	private static class MatchingOptions {
		boolean injective;
		boolean dangling;
		boolean deterministic;
	}
	
	/*
	 * Get the options for a specific rule graph.
	 * The graph should be either the LHS or a nested condition.
	 */
	protected MatchingOptions getGraphOptions(Graph graph) {
		MatchingOptions options = graphOptions.get(graph);
		if (options==null) {
			// Use the base options:
			options = new MatchingOptions();
			Rule rule = graph.getContainerRule();
			Boolean injective = (Boolean) this.options.get(OPTION_INJECTIVE_MATCHING);
			Boolean dangling = (Boolean) this.options.get(OPTION_CHECK_DANGLING);
			Boolean determistic = (Boolean) this.options.get(OPTION_DETERMINISTIC);
			options.injective = (injective!=null) ? injective.booleanValue() : rule.isInjectiveMatching();
			options.dangling = (dangling!=null) ? dangling.booleanValue() : rule.isCheckDangling();
			options.deterministic = (determistic==null || determistic.booleanValue());
			// Always use default values for nested conditions:
			if (graph!=rule.getLhs()) {
				options.injective = true;
				options.dangling = false;
				options.deterministic = true;
			}
			graphOptions.put(graph, options);
		}
		return options;
	}

	/**
	 * An options map which clears cached rule options.
	 * @see #getOptions()
	 */
	private class EngineOptions extends HashMap<String,Object> {
		private static final long serialVersionUID = 1L;

		/*
		 * (non-Javadoc)
		 * @see java.util.HashMap#put(java.lang.String, java.lang.Object)
		 */
		@Override
		public Object put(String key, Object value) {
			Object result = super.put(key, value);
			graphOptions.clear();
			updateSortVariablsFlag();
			return result;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.HashMap#putAll(java.util.Map)
		 */
		@Override
		public void putAll(Map<? extends String,? extends Object> map) {
			super.putAll(map);
			graphOptions.clear();
			updateSortVariablsFlag();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.HashMap#remove(java.lang.Object)
		 */
		@Override
		public Object remove(Object key) {
			Object result = super.remove(key);
			graphOptions.clear();
			updateSortVariablsFlag();			
			return result;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.util.HashMap#clear()
		 */
		@Override
		public void clear() {
			super.clear();
			graphOptions.clear();
			updateSortVariablsFlag();
		}
		
		private void updateSortVariablsFlag() {
			Boolean sort = (Boolean) get(OPTION_SORT_VARIABLES);
			sortVariables = (sort!=null) ? sort.booleanValue() : true;
		}

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.emf.henshin.interpreter.Engine#getScriptEngine()
	 */
	@Override
	public ScriptEngine getScriptEngine() {
		return scriptEngine;
	}


  	
	protected void createUserConstraints(RuleInfo var,Node node){
		
		
	}
  
  
}