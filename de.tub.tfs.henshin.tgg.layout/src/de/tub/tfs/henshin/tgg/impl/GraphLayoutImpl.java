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
package de.tub.tfs.henshin.tgg.impl;

import de.tub.tfs.henshin.tgg.GraphLayout;
import de.tub.tfs.henshin.tgg.TggPackage;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.henshin.model.Graph;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.tub.tfs.henshin.tgg.impl.GraphLayoutImpl#getDividerX <em>Divider X</em>}</li>
 *   <li>{@link de.tub.tfs.henshin.tgg.impl.GraphLayoutImpl#getMaxY <em>Max Y</em>}</li>
 *   <li>{@link de.tub.tfs.henshin.tgg.impl.GraphLayoutImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link de.tub.tfs.henshin.tgg.impl.GraphLayoutImpl#isIsSC <em>Is SC</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphLayoutImpl extends EObjectImpl implements GraphLayout {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphLayoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TggPackage.Literals.GRAPH_LAYOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDividerX() {
		return (Integer)eGet(TggPackage.Literals.GRAPH_LAYOUT__DIVIDER_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDividerX(int newDividerX) {
		eSet(TggPackage.Literals.GRAPH_LAYOUT__DIVIDER_X, newDividerX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxY() {
		return (Integer)eGet(TggPackage.Literals.GRAPH_LAYOUT__MAX_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxY(int newMaxY) {
		eSet(TggPackage.Literals.GRAPH_LAYOUT__MAX_Y, newMaxY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph() {
		return (Graph)eGet(TggPackage.Literals.GRAPH_LAYOUT__GRAPH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(Graph newGraph) {
		eSet(TggPackage.Literals.GRAPH_LAYOUT__GRAPH, newGraph);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSC() {
		return (Boolean)eGet(TggPackage.Literals.GRAPH_LAYOUT__IS_SC, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSC(boolean newIsSC) {
		eSet(TggPackage.Literals.GRAPH_LAYOUT__IS_SC, newIsSC);
	}

} //GraphLayoutImpl
