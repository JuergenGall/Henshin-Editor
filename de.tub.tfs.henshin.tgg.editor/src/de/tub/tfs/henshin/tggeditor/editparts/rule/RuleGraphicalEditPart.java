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
package de.tub.tfs.henshin.tggeditor.editparts.rule;

import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.gef.EditPolicy;

import de.tub.tfs.henshin.tgg.TripleGraph;
import de.tub.tfs.henshin.tggeditor.editparts.graphical.GraphEditPart;
import de.tub.tfs.henshin.tggeditor.editpolicies.graphical.NodeGraphicalEditPolicy;
import de.tub.tfs.henshin.tggeditor.editpolicies.graphical.RuleGraphicalEditPolicy;
import de.tub.tfs.henshin.tggeditor.editpolicies.rule.RuleXYLayoutEditPolicy;


/**
 * The GraphEditPart class of Rules.
 */
public class RuleGraphicalEditPart extends GraphEditPart {
	
	/** The model */
	Rule rule;

	/**
	 * Instantiates a new rule graph edit part.
	 *
	 * @param model the model
	 */
	public RuleGraphicalEditPart(Rule model) {
		super((TripleGraph) model.getRhs());
		registerAdapter(model.getRhs());
		registerAdapter(model);
		this.rule = model;
		
		cleanUpRule();
		

	}
	
	private void cleanUpRule() {
		// remove invalid mappings
		List<Mapping> invalidMappings = new Vector<Mapping>();
		for (Mapping m: rule.getMappings()){
			if(m.getImage()==null || m.getOrigin()==null)
				invalidMappings.add(m);
		}
		rule.getMappings().removeAll(invalidMappings);
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new RuleXYLayoutEditPolicy());
		installEditPolicy(EditPolicy.NODE_ROLE, new RuleGraphicalEditPolicy());
	}
	
	@Override
	protected void setFigureNameLabel(){
		nameLabel.setText(rule.getName());
	}
	
	@Override
	protected void notifyChanged(Notification notification) {
		if (notification.getNotifier() instanceof Rule) {
			final int featureId = notification.getFeatureID(HenshinPackage.class);
			switch (featureId){
				case HenshinPackage.RULE__NAME:
					setFigureNameLabel();
					refreshVisuals();
				default:
					break; 
			}
		}
		super.notifyChanged(notification);
	}
	

}