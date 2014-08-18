/*******************************************************************************
 * Copyright (c) 2012, 2014 Henshin developers.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Henshin developers - initial API and implementation
 *******************************************************************************/
package de.tub.tfs.henshin.tggeditor.actions.create.graph;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import de.tub.tfs.henshin.tgg.TGG;
import de.tub.tfs.henshin.tgg.interpreter.util.RuleUtil;
import de.tub.tfs.henshin.tggeditor.commands.create.CreateAttributeCommand;
import de.tub.tfs.henshin.tggeditor.editparts.graphical.TNodeObjectEditPart;
import de.tub.tfs.henshin.tggeditor.util.AttributeTypes;
import de.tub.tfs.henshin.tggeditor.util.GraphicalNodeUtil;
import de.tub.tfs.henshin.tggeditor.util.dialogs.DialogUtil;


public class CreateAttributeAction extends SelectionAction {
	
	public static final String ID ="tggeditor.actions.create.CreateAttributeAction";
	private Node node;

	public CreateAttributeAction(IWorkbenchPart part) {
		super(part);
		setId(ID);
		setText("Create Attribute");
		setToolTipText("Create Attribute in the selected Node");
	}

	@Override
	protected boolean calculateEnabled() {
		List<?> selectedObjects = getSelectedObjects();
		if (selectedObjects.size() != 1) {
			return false;
		}
		Object selectedObject = selectedObjects.get(0);
				
		if ((selectedObject instanceof EditPart)) {
			EditPart editpart = (EditPart) selectedObject;
			if ((editpart instanceof TNodeObjectEditPart)) {
				node = (Node) editpart.getModel();
				
				TGG tgg = GraphicalNodeUtil.getLayoutSystem(node);
				if (tgg==null) return false;

				if(RuleUtil.graphIsOpRuleRHS(node.getGraph()))
					return false;

				
				if (!AttributeTypes.getFreeAttributeTypes(node).isEmpty())
				return true;
			}
		}
		return false;
	}
	
	@Override 
	public void run() {
		SimpleEntry<EAttribute, String> result = DialogUtil
				.runAttributeCreationDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().getActivePart().getSite().getShell(), node);
		
		if (result.getKey() != null && result.getValue() != null) {
			CreateAttributeCommand c = new CreateAttributeCommand(node, result.getValue());			
			c.setLabel(result.getKey().getName()+":"+result.getValue());
			c.setAttributeType(result.getKey());
			c.execute();
		}
	}

}
