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
package de.tub.tfs.henshin.tggeditor.views.graphview;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.NamedElement;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.part.IPage;

import de.tub.tfs.henshin.tggeditor.actions.execution.ExecuteBPpgToolBarAction;
import de.tub.tfs.henshin.tggeditor.actions.execution.ExecuteBTRulesToolBarAction;
import de.tub.tfs.henshin.tggeditor.actions.execution.ExecuteCCRulesToolBarAction;
import de.tub.tfs.henshin.tggeditor.actions.execution.ExecuteFPpgToolBarAction;
import de.tub.tfs.henshin.tggeditor.actions.execution.ExecuteFTRulesToolBarAction;
import de.tub.tfs.henshin.tggeditor.actions.execution.RemoveMarkersToolBarAction;
import de.tub.tfs.henshin.tggeditor.actions.validate.GraphValidToolBarAction;
import de.tub.tfs.muvitor.ui.MuvitorPageBookView;

public class GraphicalView extends MuvitorPageBookView {

	@Override
	protected String calculatePartName() {
		if(getModel().eContainer() instanceof NestedCondition){
			return "NAC: " + ((NamedElement) getModel()).getName();
		}else{
			return "Graph: " + ((NamedElement) getModel()).getName();
		}
	}

	@Override
	protected IPage createPageForModel(EObject forModel) {				
		GraphicalPage page = new GraphicalPage(this);
		IToolBarManager toolBar = getViewSite().getActionBars().getToolBarManager();
		toolBar.add(new GraphValidToolBarAction(this, (GraphicalPage) page));
		toolBar.add(new ExecuteFTRulesToolBarAction(this, (GraphicalPage) page));
		toolBar.add(new ExecuteBTRulesToolBarAction(this, (GraphicalPage) page));
		toolBar.add(new ExecuteCCRulesToolBarAction(this, (GraphicalPage) page));
		toolBar.add(new RemoveMarkersToolBarAction(this, (GraphicalPage) page));
		toolBar.add(new ExecuteFPpgToolBarAction(this, (GraphicalPage) page));
		toolBar.add(new ExecuteBPpgToolBarAction(this, (GraphicalPage) page));
		return page;
	}

}
