/*******************************************************************************
 * Copyright (c) 2012, 2013 Henshin developers.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Henshin developers - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package de.tub.tfs.henshin.tggeditor.commands.move;

import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.tub.tfs.henshin.tggeditor.util.EdgeReferences;
import de.tub.tfs.henshin.tggeditor.util.dialogs.DialogUtil;


/**
 * The Class ReconnectedEdgeCommand.
 *
 * @author Johann
 */
public class ReconnectedEdgeCommand extends Command {

	/** The edge. */
	private Edge edge;
	
	/** The old source. */
	private Node oldSource;
	
	/** The old target. */
	private Node oldTarget;
	
	/** The old type. */
	private EReference oldType;
	
	/** The source. */
	private Node source;
	
	/** The target. */
	private Node target;
	
	/** The e references. */
	private List<EReference> eReferences;

	/**
	 * Instantiates a new reconnected edge command.
	 *
	 * @param edge the edge
	 * @param source the source
	 * @param target the target
	 */
	public ReconnectedEdgeCommand(Edge edge, Node source, Node target) {
		this.edge = edge;
		this.target = target;
		this.source = source;
		this.oldSource = edge.getSource();
		this.oldTarget = edge.getTarget();
		this.oldType = edge.getType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		eReferences = EdgeReferences.getSourceToTargetReferences(source,
				target);
		return eReferences.size() > 0
				|| (edge.getSource() == source && edge.getTarget() == target);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {

		if (canExecute()) {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			EReference type = null;
			List<EReference> references=EdgeReferences.getSourceToTargetReferences(source, target);
			if (references.contains(edge.getType())) {
				type = edge.getType();
			} else {
				type = DialogUtil.runEdgeTypeSelectionDialog(shell, references);
			}
			if (type != null) {
				edge.getSource().getOutgoing().remove(edge);
				edge.getTarget().getIncoming().remove(edge);
				edge.setSource(source);
				edge.setTarget(target);
				edge.setType(type);
				super.execute();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		edge.getSource().getOutgoing().remove(edge);
		edge.getTarget().getIncoming().remove(edge);
		edge.setSource(oldSource);
		edge.setTarget(oldTarget);
		edge.setType(oldType);
		super.undo();
	}

}
