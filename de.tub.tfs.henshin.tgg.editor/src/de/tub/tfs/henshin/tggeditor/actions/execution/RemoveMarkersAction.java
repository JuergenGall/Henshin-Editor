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
package de.tub.tfs.henshin.tggeditor.actions.execution;

import java.util.List;

import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import de.tub.tfs.henshin.tggeditor.commands.ExecuteFTRulesCommand;
import de.tub.tfs.henshin.tggeditor.commands.RemoveMarkersCommand;
import de.tub.tfs.henshin.tggeditor.editparts.graphical.GraphEditPart;


/**
 * The class ExecuteFTRuleAction executes a FT Rule. The class is shown in the context menu of the
 * Tree Editor and enabled when a graph is selected and FT Rules are available. The 
 * ExecuteFTRuleCommand is used.
 * @see ExecuteFTRuleCommand
 */
public class RemoveMarkersAction extends SelectionAction {

	/** The fully qualified class ID. */
	public static final String ID = "henshineditor.actions.RemoveMarkerAction";
	
	/** The Constant DESC for the description. */
	protected String DESC = "Remove Markers";

	/** The Constant TOOLTIP for the tooltip. */
	protected String TOOLTIP = "Remove all markers within the Graph";


	/**
	 * The graph on which the rules should be executed.
	 */
	protected Graph graph;

	/**
	 * Instantiates a new execute rule action.
	 *
	 * @param part the part in which the action shall be registered
	 */
	public RemoveMarkersAction(IWorkbenchPart part) {
		super(part);
		setId(ID);
		setText(DESC);
		setDescription(DESC);
		setToolTipText(TOOLTIP);
	}


	/** Checks if clicked on a graph and there are TRules in the TGG Layoutsystem
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
	 */
	@Override
	protected boolean calculateEnabled() {
		graph = null;
		List<?> selectedObjects = getSelectedObjects();
		if (selectedObjects.size() != 1) {
			return false;
		}
		Object selecObject = selectedObjects.get(0);
		if(selecObject instanceof GraphEditPart)
				graph = ((GraphEditPart) selecObject).getCastedModel();
		return graph!=null;
	}

	
	/** Executed an {@link ExecuteFTRulesCommand}.
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		RemoveMarkersCommand command = new RemoveMarkersCommand(graph);
		execute(command);
	}


	
}
