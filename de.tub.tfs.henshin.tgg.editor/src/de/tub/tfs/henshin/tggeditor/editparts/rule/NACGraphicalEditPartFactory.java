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

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import de.tub.tfs.henshin.tgg.TAttribute;
import de.tub.tfs.henshin.tgg.TNode;
import de.tub.tfs.henshin.tgg.TripleGraph;
import de.tub.tfs.henshin.tggeditor.editparts.graphical.AttributeEditPart;
import de.tub.tfs.henshin.tggeditor.editparts.graphical.GraphEditPart;


public class NACGraphicalEditPartFactory implements EditPartFactory{

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof Graph && ((Graph) model).eContainer() instanceof NestedCondition) {
			return new NACGraphicalEditPart((Graph) model);
		}

		if(model instanceof TripleGraph){
			return new GraphEditPart((TripleGraph) model);
		}
		if(model instanceof Node){
			return new RuleNodeEditPart((TNode) model);
		}
		if(model instanceof TAttribute){
			return new AttributeEditPart((TAttribute) model);
		}
		if(model instanceof Edge){
			return new RuleEdgeEditPart((Edge) model);
		}

		Assert.isTrue( model == null, "NACGraphicalEditPartFactory could not create an EditPart for the model"+ model);
		return null;
	}

}
