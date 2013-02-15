package tggeditor.commands;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.TransformationSystem;
import org.eclipse.gef.commands.Command;

import tgg.CritPair;
import tgg.EdgeLayout;
import tgg.NodeLayout;
import tgg.TGG;
import tgg.TGGFactory;
import tggeditor.TggAggInfo;
import tggeditor.commands.delete.rule.DeleteRuleCommand;
import tggeditor.util.GraphUtil;
import tggeditor.util.NodeTypes;
import tggeditor.util.NodeUtil;
import tggeditor.util.RuleUtil;
import de.tub.tfs.henshin.analysis.CriticalPair;

public class CheckForCritPairCommand extends Command {

	private Rule _firstRule;
	private Rule _secondRule;
	private TransformationSystem _trafo;
	private TGG layoutSystem;
	private TggAggInfo _aggInfo;

	public CheckForCritPairCommand(Rule firstRule, Rule secondRule, TggAggInfo aggInfo) {
		_aggInfo = aggInfo;
		_firstRule = firstRule;
		_secondRule = secondRule;
		_trafo = _firstRule.getTransformationSystem();
		layoutSystem = NodeUtil.getLayoutSystem(_firstRule);
	}
	
	@Override
	public boolean canExecute() {
		return (_firstRule != null && _secondRule != null && _trafo != null);
	}
	
	
	@Override
	public void execute() {
		//_aggInfo.isCritical(_firstRule, _secondRule);
		
		Rule first = RuleUtil.copyRule(_firstRule);
		Rule second = RuleUtil.copyRule(_secondRule);
		_aggInfo = new TggAggInfo(_trafo);
		_aggInfo.extendDueToTGG(layoutSystem);
		List<CriticalPair> critPairList = _aggInfo.getConflictOverlappings(first, second);
//		List<CriticalPair> critPairList = _aggInfo.getConflictOverlappings(_firstRule, _secondRule);
		
		if (critPairList != null && !critPairList.isEmpty()) {
			
			for (CriticalPair critPair : critPairList) {
				
			List<Mapping> mappingsOverToR1 = critPair.getMappingsOverlappingToRule1();
			List<Mapping> mappingsOverToR2 = critPair.getMappingsOverlappingToRule2();
			List<Mapping> mappingsR1ToR2 = critPair.getMappingsRule1ToRule2();
			Graph over = critPair.getOverlapping();
		
			CritPair newCrit = TGGFactory.eINSTANCE.createCritPair();
				newCrit.setName("CP"+(critPairList.indexOf(critPair)+1));
			newCrit.setOverlapping(over);
			newCrit.setRule1(critPair.getRule1());
			newCrit.setRule2(critPair.getRule2());
			newCrit.getMappingsOverToRule1().addAll(mappingsOverToR1);
			newCrit.getMappingsOverToRule2().addAll(mappingsOverToR2);
			newCrit.getMappingsRule1ToRule2().addAll(mappingsR1ToR2);
			//newCrit.getCriticalObjects().addAll(critPair.getCriticalObjects());
			layoutSystem.getCritPairs().add(newCrit);
			
			_trafo.getInstances().add(over);
			
				changeToTGGGraph(over);
				
				markCriticalObjects(over, _aggInfo.getCriticalObjects().get(critPair));
				
				System.out.println("Adding CritPair "+newCrit.getName()+" for "+_firstRule.getName()+" with "+_secondRule.getName()+" finished.");
		}
		} else {
			//Remove created Objects from copying rules from transformation system and tgg

			DeleteRuleCommand c1 = new DeleteRuleCommand(first);
			DeleteRuleCommand c2 = new DeleteRuleCommand(second);
			c1.execute();
			c2.execute();
		}
		super.execute();
	}
	
	private void markCriticalObjects(Graph graph, List<EObject> criticalObjects) {
		if (!criticalObjects.isEmpty()) {
			for (EObject eObj : criticalObjects) {
				if (eObj instanceof Node && graph.getNodes().contains((Node)eObj)) {
					NodeLayout nodeLayout = NodeUtil.getNodeLayout((Node)eObj);
					nodeLayout.setCritical(true);
				}
			}
		}
	}
	
	private void changeToTGGGraph(Graph graph) {
		//create NodeLayouts
		int  s=0, c=0, t = 0;
		for (Node n : graph.getNodes()) {
			NodeLayout nL = NodeUtil.getNodeLayout(n);
			
			if (nL != null) {
				//if (p.getCriticalObjects().contains(n))
				//	nL.setCritical(true);
				if (NodeUtil.isSourceNode(layoutSystem, n.getType())) {
					s++;
					nL.setX(GraphUtil.getMinXCoordinateForNodeGraphType(NodeTypes.getNodeGraphType(n)) +10*s);
					nL.setY(50*s);
				}
				else if (NodeUtil.isCorrespNode(layoutSystem, n.getType())) {
					c++;
					nL.setX(GraphUtil.getMinXCoordinateForNodeGraphType(NodeTypes.getNodeGraphType(n)) +10*c);
					nL.setY(50*c);
				}
				else {
					t++;
					nL.setX(GraphUtil.getMinXCoordinateForNodeGraphType(NodeTypes.getNodeGraphType(n)) +10+t);
					nL.setY(50*t);;
				}
			}
		}
	}
}
