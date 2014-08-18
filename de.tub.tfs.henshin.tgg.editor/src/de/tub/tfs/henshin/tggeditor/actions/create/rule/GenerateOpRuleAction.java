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
package de.tub.tfs.henshin.tggeditor.actions.create.rule;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.IndependentUnit;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import de.tub.tfs.henshin.tgg.TGG;
import de.tub.tfs.henshin.tgg.TGGRule;
import de.tub.tfs.henshin.tgg.interpreter.util.RuleUtil;
import de.tub.tfs.henshin.tggeditor.commands.create.rule.GenerateOpRuleCommand;
import de.tub.tfs.henshin.tggeditor.commands.create.rule.ProcessRuleCommand;
import de.tub.tfs.henshin.tggeditor.editparts.tree.rule.RuleTreeEditPart;
import de.tub.tfs.henshin.tggeditor.util.GraphicalNodeUtil;


/**
 * The class GenerateOpRuleAction generates Translation-Rule from a simple Rule. The Action
 * is registered in the Contextmenu of the Tree Editor.
 * @see GenerateOpRuleToolBarAction
 * @see ProcessRuleCommand
 */
public abstract class GenerateOpRuleAction extends SelectionAction {

	/** The Constant DESC for the description. */
	protected String DESC = "Generate Op_Rule";

	/** The Constant TOOLTIP for the tooltip. */
	protected String TOOLTIP = "Generates Operational Rule for this TGG Rule";

	protected GenerateOpRuleCommand command;
	
	/**
	 * The rule which is used as base for the FT-Rule.
	 */
	protected TGGRule rule;
	
	/**
	 * the constructor
	 * @param part
	 */
	public GenerateOpRuleAction(IWorkbenchPart part) {
		super(part);
	}

	/** Is only enabled for the context menu of a rule.
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
	 */
	@Override
	protected boolean calculateEnabled() {
		List<?> selectedObjects = getSelectedObjects();
		if (selectedObjects.size() != 1) {
			return false;
		}
		Object selectedObject = selectedObjects.get(0);
		if ((selectedObject instanceof EditPart)) {
			EditPart editpart = (EditPart) selectedObject;
			if (editpart instanceof RuleTreeEditPart) {
				rule = (TGGRule) editpart.getModel();
				TGG layoutSystem = GraphicalNodeUtil.getLayoutSystem(rule);
				if(layoutSystem == null) return false;
				//NEW Gerard generalization from FT to op
				if (!GenerateOpRulesAction.calcInProgress)
					if(rule==null || !RuleUtil.TGG_RULE.equals(rule.getMarkerType())) {
						return false;
				}
				return true;
			}
		}
		return false;
	}
	
	/** 
	 * Executes the GenerateFTRuleCommand.
	 * @see ProcessRuleCommand
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		IndependentUnit container = findContainer((IndependentUnit) ((Module)EcoreUtil.getRootContainer(rule)).getUnit("RuleFolder")  ,rule);
		setCommand(rule, container);
		super.execute(command);
	}
	
	protected abstract void setCommand(Rule rule, IndependentUnit container);
	
	/**
	 * Gets the rule.
	 *
	 * @return the rule
	 */
	private Rule getRule() {
		//TODO 
		//NEW by Jerry: What if rule==null like in run? one has to get the module from somewhere else
		// ANSWER by Frank: method is not in use any more
//		return DialogUtil.runRuleChoiceDialog(getWorkbenchPart().getSite()
//				.getShell(),ModelUtil.getRules(rule.getModule()) );
		return null;
	}
	
	private IndependentUnit findContainer(IndependentUnit ftFolder, Object obj) {
		for (Unit unit : ftFolder.getSubUnits()) {
			if (unit instanceof IndependentUnit) {
				IndependentUnit u = findContainer((IndependentUnit) unit, obj);
				if (u != null)
					return u;
			} else if (unit.equals(obj))
				return ftFolder;
		}

		return null;
		
		
	}

}
