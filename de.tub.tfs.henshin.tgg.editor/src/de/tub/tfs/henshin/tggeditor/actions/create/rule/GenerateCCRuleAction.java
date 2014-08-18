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
package de.tub.tfs.henshin.tggeditor.actions.create.rule;

import org.eclipse.emf.henshin.model.IndependentUnit;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.ui.IWorkbenchPart;

import de.tub.tfs.henshin.tggeditor.commands.create.rule.GenerateCCRuleCommand;
import de.tub.tfs.henshin.tggeditor.commands.create.rule.ProcessRuleCommand;


/**
 * The class GenerateCCRuleAction generates the Consistency-Creating-Rule from a TGG Rule. The Action
 * is registered in the Contextmenu of the Tree Editor.
 * @see GenerateCCRuleToolBarAction
 * @see ProcessRuleCommand
 */
public class GenerateCCRuleAction extends GenerateOpRuleAction {

	/**
	 * The fully qualified ID.
	 */
	public static final String ID = "de.tub.tfs.henshin.tggeditor.actions.create.rule.GenerateCCRuleAction";
	
	/**
	 * the constructor
	 * @param part
	 */
	public GenerateCCRuleAction(IWorkbenchPart part) {
		super(part);
		DESC 	= "Generate CC_Rule";
		TOOLTIP = "Generates the concistency creating rule for this TGG Rule";
		setId(ID);
		setText(DESC);
		setToolTipText(TOOLTIP);
	}


	@Override
	protected void setCommand(Rule rule, IndependentUnit container) {
		command = new GenerateCCRuleCommand(rule,container);		
	}

}
