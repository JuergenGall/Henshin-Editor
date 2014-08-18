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
package de.tub.tfs.henshin.tggeditor.editparts.tree.graphical;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.emf.henshin.model.Module;

import de.tub.tfs.henshin.tgg.TGG;
import de.tub.tfs.henshin.tgg.TggPackage;
import de.tub.tfs.henshin.tgg.TripleGraph;

/**
 * A folder for graphs in the tree editor.
 */

public class GraphFolder extends EObjectImpl {
	private TGG sys;
	private List<Graph> graphs;
	
	@Override
	public EClass eClass() {
		return TggPackage.Literals.TGG;
	}
	
	@Override
	public Resource eResource() {
		// TODO Auto-generated method stub
		return sys.eResource();
	}
	
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve, boolean coreType)
	{
		if (eFeature.equals(HenshinPackage.Literals.MODULE__INSTANCES)){
			return sys.eGet(eFeature, resolve);
		}
		int featureID = eDerivedStructuralFeatureID(eFeature);
		if (featureID >= 0)
		{
			return eGet(featureID, resolve, coreType);
		}
		else
		{
			return eOpenGet(eFeature, resolve);
		}
	}
	public GraphFolder(TGG sys){
		this.sys = sys;
		graphs = this.sys.getInstances();		
	}

	public List<Graph> getGraphs(){
		return this.graphs;
	}

	public void update() {
		graphs = this.sys.getInstances();
		eNotify(new ENotificationImpl(this, Notification.ADD, 0, null, null));
	}
	
}
