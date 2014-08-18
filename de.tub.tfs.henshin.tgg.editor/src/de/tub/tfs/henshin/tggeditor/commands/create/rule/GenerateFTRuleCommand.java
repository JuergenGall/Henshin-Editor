package de.tub.tfs.henshin.tggeditor.commands.create.rule;

import org.eclipse.emf.henshin.model.IndependentUnit;
import org.eclipse.emf.henshin.model.Rule;

import de.tub.tfs.henshin.tgg.TNode;
import de.tub.tfs.henshin.tgg.TripleComponent;
import de.tub.tfs.henshin.tgg.interpreter.NodeUtil;
import de.tub.tfs.henshin.tgg.interpreter.RuleUtil;
import de.tub.tfs.henshin.tggeditor.commands.delete.rule.DeleteOpRuleCommand;

public class GenerateFTRuleCommand extends GenerateOpRuleCommand {

	public GenerateFTRuleCommand(Rule rule) {
		this(rule,null);
		
	}
	

	public GenerateFTRuleCommand(Rule rule,IndependentUnit unit) {
		super(rule,unit);
		prefix = "FT_";
		OP_RULE_CONTAINER_PREFIX = "FTRule_";
		OP_RULE_FOLDER = "FTRuleFolder";
		OP_RULES_PNG = "FTRules.png";
	}
	
	@Override
	protected void deleteTRule(Rule tr) {
		DeleteOpRuleCommand deleteCommand = new DeleteOpRuleCommand(
				tr,null,RuleUtil.TGG_FT_RULE);
		deleteCommand.execute();
	}


	@Override
	protected void addNodeProcessors(){
		// process all nodes in the source component
		nodeProcessors.put(TripleComponent.SOURCE, new OpRuleNodeProcessor());
	};

	
	
	@Override
	protected String getRuleMarker() {
		return RuleUtil.TGG_FT_RULE;
	}
	@Override
	protected boolean filterNode(TNode node) {
		return NodeUtil.isSourceNode(node);
	}
}
