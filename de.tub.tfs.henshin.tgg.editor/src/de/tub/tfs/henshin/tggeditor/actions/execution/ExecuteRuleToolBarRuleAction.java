/*******************************************************************************
 *******************************************************************************/
package de.tub.tfs.henshin.tggeditor.actions.execution;

import de.tub.tfs.henshin.tgg.TGGRule;
import de.tub.tfs.henshin.tggeditor.views.ruleview.RuleGraphicalPage;
import de.tub.tfs.muvitor.ui.MuvitorPageBookView;



/**
 * The Class ExecuteRuleToolBarRuleAction is shown in the toolbar of the rule editor.
 * Gives a selection when more than one graph is available. Executes the 
 * ExecuteRuleCommand
 * @see de.tub.tfs.henshin.tggeditor.commands.ExecuteRuleCommand
 */
public class ExecuteRuleToolBarRuleAction extends ExecuteRuleAction {
	
	/**
	 * Instantiates a new execute rule tool bar rule action.
	 *
	 * @param part the part
	 * @param rulePage the rule page
	 */
	public ExecuteRuleToolBarRuleAction(MuvitorPageBookView part, RuleGraphicalPage rulePage) {
		super(part.getEditor());
		rule=(TGGRule) rulePage.getCastedModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see henshineditor.actions.CreateNACAction#calculateEnabled()
	 */
	@Override
	protected boolean calculateEnabled() {
		return true;
	}

	/* (non-Javadoc)
	 * @see henshineditor.actions.rule.ExecuteRuleAction#run()
	 */
	@Override
	public void run() {
		graph=null;
		super.run();
	}
	
	
}
