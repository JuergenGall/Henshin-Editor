/*******************************************************************************
 *******************************************************************************/
package de.tub.tfs.henshin.tggeditor.commands;

import java.util.List;

import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.Rule;


/**
 * The Class ExecuteFTRulesCommand executes all the given Rules ({@link TRule}) on a given graph. For the
 * execution are mainly the classes from org.eclipse.emf.henshin.interpreter used. The mapping 
 * of the RuleApplication will be checked with the class {@link FTRuleConstraint}.
 * There will be also the layouts for nodes and edges created.
 */
public class ExecuteCCRulesCommand extends ExecuteOpRulesCommand {

	/**the constructor
	 * @param graph {@link ExecuteCCRulesCommand#graph}
	 * @param fTRuleList {@link ExecuteCCRulesCommand#opRuleList}
	 */
	public ExecuteCCRulesCommand(Graph graph, List<Rule> fTRuleList) {
		super(graph,fTRuleList);
		consistencyType = "TGG";
		consistencyTypeLowerCase = "tgg";
	}
}