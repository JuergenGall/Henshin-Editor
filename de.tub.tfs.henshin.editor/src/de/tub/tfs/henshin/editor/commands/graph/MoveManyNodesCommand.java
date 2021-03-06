/*******************************************************************************
 * Copyright (c) 2010-2015 Henshin developers. All rights reserved. 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TU Berlin, University of Luxembourg, SES S.A.
 *******************************************************************************/
/**
 * 
 */
package de.tub.tfs.henshin.editor.commands.graph;

import java.util.List;

import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;

import de.tub.tfs.henshin.editor.editparts.graph.graphical.NodeEditPart;
import de.tub.tfs.henshin.editor.editparts.graph.graphical.SubtreeEditPart;

/**
 * The Class MoveManyNodesCommand.
 * 
 * @author Johann
 */
public class MoveManyNodesCommand extends CompoundCommand {

	/**
	 * f�gt alle von der �nderung betroffenen Elemente in die Command ein.
	 * 
	 * @param editparts
	 *            Liste aller betroffenen Elemente
	 * @param request
	 *            the request
	 */
	public MoveManyNodesCommand(List<?> editparts, ChangeBoundsRequest request) {
		super();
		for (Object nE : editparts) {
			if (nE instanceof NodeEditPart)
				add(new MoveNodeCommand((NodeEditPart) nE, request));
			if (nE instanceof SubtreeEditPart) {
				SubtreeEditPart subtreeEditPart = (SubtreeEditPart) nE;
				add(new MoveSubtreeCommand(subtreeEditPart.getLayoutModel(), request.getMoveDelta().x, request.getMoveDelta().y));
			}
		}
	}

}
