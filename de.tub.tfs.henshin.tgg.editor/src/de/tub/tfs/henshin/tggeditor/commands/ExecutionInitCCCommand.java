package de.tub.tfs.henshin.tggeditor.commands;

import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.Node;

import de.tub.tfs.henshin.tgg.TNode;
import de.tub.tfs.henshin.tggeditor.util.GraphicalNodeUtil;

/**
 * The Class ExecutionInitCCCommand creates the initial marking for executing the operational CC rules on a given graph. 
 */
public class ExecutionInitCCCommand extends ExecutionInitCommand {

	/**
	 * The graph on which all the rules will be applied.
	 */
	protected Graph graph;
	
	/**the constructor
	 * @param graph {@link ExecutionInitCCCommand#graph}
	 * @param opRuleList {@link ExecutionInitCCCommand#opRuleList}
	 */
	public ExecutionInitCCCommand(Graph graph) {
		super(graph);
		this.graph = graph;
	}

	protected boolean isInMarkedComponent(TNode node){
		return true;
	};
}
