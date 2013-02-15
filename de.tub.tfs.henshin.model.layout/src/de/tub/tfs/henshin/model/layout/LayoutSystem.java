/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.tub.tfs.henshin.model.layout;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layout System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.tub.tfs.henshin.model.layout.LayoutSystem#getLayouts <em>Layouts</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.tub.tfs.henshin.model.layout.HenshinLayoutPackage#getLayoutSystem()
 * @model
 * @generated
 */
public interface LayoutSystem extends EObject {
        /**
	 * Returns the value of the '<em><b>Layouts</b></em>' containment reference list.
	 * The list contents are of type {@link de.tub.tfs.henshin.model.layout.Layout}.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Layouts</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Layouts</em>' containment reference list.
	 * @see de.tub.tfs.henshin.model.layout.HenshinLayoutPackage#getLayoutSystem_Layouts()
	 * @model containment="true"
	 * @generated
	 */
        EList<Layout> getLayouts();

} // LayoutSystem
