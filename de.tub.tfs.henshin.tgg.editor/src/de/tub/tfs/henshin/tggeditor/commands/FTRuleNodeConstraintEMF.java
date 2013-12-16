package de.tub.tfs.henshin.tggeditor.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.matching.constraints.BinaryConstraint;
import org.eclipse.emf.henshin.interpreter.matching.constraints.DomainChange;
import org.eclipse.emf.henshin.interpreter.matching.constraints.DomainSlot;
import org.eclipse.emf.henshin.interpreter.matching.constraints.ReferenceConstraint;
import org.eclipse.emf.henshin.interpreter.matching.constraints.UnaryConstraint;
import org.eclipse.emf.henshin.interpreter.matching.constraints.Variable;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;

import de.tub.tfs.henshin.tgg.TAttribute;
import de.tub.tfs.henshin.tgg.TEdge;
import de.tub.tfs.henshin.tgg.TNode;
import de.tub.tfs.henshin.tgg.TRule;
import de.tub.tfs.henshin.tggeditor.util.NodeUtil;
import de.tub.tfs.henshin.tggeditor.util.RuleUtil;


/**
 * This class is for checking the correct mapping in a execution cycle of FTRules.
 * It is given to the {@link EmfEngine} of henshin. 
 * @see ExecuteFTRulesCommand
 * @see EmfEngine#registerUserConstraint(Class, Object...)
 */
public class FTRuleNodeConstraintEMF implements UnaryConstraint {

	/**
	 * This hashmap will be filled during the execution of all the {@link TRule}s in the 
	 * {@link ExecuteFTRulesCommand}. The hashmap contains all the already translated nodes 
	 * of the graph on which the {@link TRule}s are executed.
	 */
	private HashMap<EObject, Boolean> isTranslatedMap;
	private Set<EObject> sourceNodeMap;
	/**
	 * This hashmap will be filled during the execution of all the {@link TRule}s in the 
	 * {@link ExecuteFTRulesCommand}. The hashmap contains all the already translated edges 
	 * of the graph on which the {@link TRule}s are executed.
	 */
	private HashMap<EObject, HashMap<EAttribute,Boolean>> isTranslatedAttributeMap;
	/**
	 * This hashmap will be filled during the execution of all the {@link TRule}s in the 
	 * {@link ExecuteFTRulesCommand}. The hashmap contains all the already translated edges 
	 * of the graph on which the {@link TRule}s are executed.
	 * An edge is identified by the triple (source, type, target)
	 */
	private HashMap<EObject, HashMap<EReference, HashMap<EObject,Boolean>>> isTranslatedEdgeMap;

	
	
	/**
	 * The node which can be mapped to another node in the graph (see 
	 * {@link FTRuleConstraint#check(Node graphNode)}). The node could be a node in
	 * a {@link Rule} or in a nac.
	 */
	private Node ruleNode;

	
	
	
	/**
	 * Whether the node is marked to be translated before executing the rule.
	 */
	private Boolean ruleNodeIsTranslated;
	

	/**
	 * the constructor
	 * @param ruleNode see {@link FTRuleConstraint#ruleNode}
	 * @param isTranslatedMap see {@link FTRuleConstraint#isTranslatedMap}
	 */
	public FTRuleNodeConstraintEMF(Node ruleNode, 
			Set<EObject> sourceNodeMap,
			HashMap<EObject, Boolean> isTranslatedMap) {
		
		this.ruleNode = ruleNode;
		this.sourceNodeMap = sourceNodeMap;
		this.isTranslatedMap = isTranslatedMap;
		this.ruleNodeIsTranslated = NodeUtil.getNodeIsTranslated(this.ruleNode);
		if (ruleNodeIsTranslated == null)
			ruleNodeIsTranslated = true;

	}
	

	
	
	/** 
	 * Checks if the mapping in a {@link TRule}.
	 * @see org.eclipse.emf.henshin.interpreter.matching.constraints.HenshinUserConstraint#check(org.eclipse.emf.henshin.model.Node)
	 */
	@Override
	public boolean check(DomainSlot slot) {
		
		EObject graphNode = slot.getValue();
		if (isSourceNode(graphNode)) {
			if (this.ruleNode.eContainer().eContainer() instanceof Rule) {
				// case: node is context node, then graph node has to be translated already
				if (ruleNodeIsTranslated && isTranslatedMap.get(graphNode)) {
					// check attributes
					// moreover, all edges have to be checked to be consistent with translatedEdgeMap
					return true;
				}				
				else if (!ruleNodeIsTranslated && !isTranslatedMap.get(graphNode)) {
					// since node is not yet translated, 
					// also the adjacent edges and attributes are not yet translated and do not need to be checked
					return true;
				}
			}
			// for NAC nodes (evntl only not mapped from LHS to NAC graph ???)
			else if (isTranslatedMap.containsKey(graphNode)) {
					return true;
			}
			// else
			return false;
		}
		
		// for TARGET and CORRESPONDENCE 
		Node rhsNode=RuleUtil.getRHSNode(this.ruleNode);
		if (NodeUtil.isSourceNodeByPosition((TNode) rhsNode)) 
			return false;
		else
			return true;
	}

	/**
	 * Checks if a graphnode is a source node.
	 * @param graphNode
	 * @return true if it is a source node, else false
	 */

	private boolean isSourceNode(EObject graphNode) {
		return sourceNodeMap.contains(graphNode);
	}



}
