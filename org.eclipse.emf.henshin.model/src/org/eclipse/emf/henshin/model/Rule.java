/*******************************************************************************
 * Copyright (c) 2010 CWI Amsterdam, Technical University Berlin, 
 * Philipps-University Marburg and others. All rights reserved. 
 * This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Technical University Berlin - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.henshin.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.henshin.model.Rule#getLhs <em>Lhs</em>}</li>
 *   <li>{@link org.eclipse.emf.henshin.model.Rule#getRhs <em>Rhs</em>}</li>
 *   <li>{@link org.eclipse.emf.henshin.model.Rule#getAttributeConditions <em>Attribute Conditions</em>}</li>
 *   <li>{@link org.eclipse.emf.henshin.model.Rule#getMappings <em>Mappings</em>}</li>
 *   <li>{@link org.eclipse.emf.henshin.model.Rule#isCheckDangling <em>Check Dangling</em>}</li>
 *   <li>{@link org.eclipse.emf.henshin.model.Rule#isInjectiveMatching <em>Injective Matching</em>}</li>
 *   <li>{@link org.eclipse.emf.henshin.model.Rule#getMultiRules <em>Multi Rules</em>}</li>
 *   <li>{@link org.eclipse.emf.henshin.model.Rule#getMultiMappings <em>Multi Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.henshin.model.HenshinPackage#getRule()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='lhsAndRhsNotNull mappingsFromLeft2Right createdNodesNotAbstract createdEdgesNotDerived deletedEdgesNotDerived'"
 *        annotation="http://www.eclipse.org/emf/2010/Henshin/OCL lhsAndRhsNotNull='not lhs->isEmpty() and not rhs->isEmpty()' lhsAndRhsNotNull.Msg='_Ocl_Msg_Rule_lhsAndRhsNotNull' mappingsFromLeft2Right='mappings->forAll(mapping : Mapping | \r\n\tlhs.nodes->includes(mapping.origin)\r\n\tand\r\n\trhs.nodes->includes(mapping.image)\r\n)' mappingsFromLeft2Right.Msg='_Ocl_Msg_Rule_mappingsFromLeft2Right'"
 * @generated
 */
public interface Rule extends TransformationUnit {
	
	/**
	 * Returns the value of the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lhs</em>' containment reference.
	 * @see #setLhs(Graph)
	 * @see org.eclipse.emf.henshin.model.HenshinPackage#getRule_Lhs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Graph getLhs();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.henshin.model.Rule#getLhs <em>Lhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lhs</em>' containment reference.
	 * @see #getLhs()
	 * @generated
	 */
	void setLhs(Graph value);

	/**
	 * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhs</em>' containment reference.
	 * @see #setRhs(Graph)
	 * @see org.eclipse.emf.henshin.model.HenshinPackage#getRule_Rhs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Graph getRhs();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.henshin.model.Rule#getRhs <em>Rhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhs</em>' containment reference.
	 * @see #getRhs()
	 * @generated
	 */
	void setRhs(Graph value);

	/**
	 * Returns the value of the '<em><b>Attribute Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.henshin.model.AttributeCondition}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.henshin.model.AttributeCondition#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Conditions</em>' containment reference list.
	 * @see org.eclipse.emf.henshin.model.HenshinPackage#getRule_AttributeConditions()
	 * @see org.eclipse.emf.henshin.model.AttributeCondition#getRule
	 * @model opposite="rule" containment="true"
	 * @generated
	 */
	EList<AttributeCondition> getAttributeConditions();

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.henshin.model.Mapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see org.eclipse.emf.henshin.model.HenshinPackage#getRule_Mappings()
	 * @model containment="true"
	 * @generated NOT
	 */
	MappingList getMappings();

	/**
	 * <!-- begin-user-doc -->
	 * Get the {@link TransformationSystem} instance this rule is
	 * contained in or <code>null</code> if it is not part of a
	 * transformation system.
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	TransformationSystem getTransformationSystem();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Rule getKernelRule();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Rule getRootKernelRule();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Rule getMultiRule(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeEdge(Edge edge, boolean removeMapped);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeNode(Node node, boolean removeMapped);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Rule> getAllMultiRules();

	/**
	 * Returns the value of the '<em><b>Check Dangling</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check Dangling</em>' attribute.
	 * @see #setCheckDangling(boolean)
	 * @see org.eclipse.emf.henshin.model.HenshinPackage#getRule_CheckDangling()
	 * @model default="true"
	 * @generated
	 */
	boolean isCheckDangling();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.henshin.model.Rule#isCheckDangling <em>Check Dangling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check Dangling</em>' attribute.
	 * @see #isCheckDangling()
	 * @generated
	 */
	void setCheckDangling(boolean value);

	/**
	 * Returns the value of the '<em><b>Injective Matching</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Injective Matching</em>' attribute.
	 * @see #setInjectiveMatching(boolean)
	 * @see org.eclipse.emf.henshin.model.HenshinPackage#getRule_InjectiveMatching()
	 * @model default="true"
	 * @generated
	 */
	boolean isInjectiveMatching();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.henshin.model.Rule#isInjectiveMatching <em>Injective Matching</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Injective Matching</em>' attribute.
	 * @see #isInjectiveMatching()
	 * @generated
	 */
	void setInjectiveMatching(boolean value);

	/**
	 * Returns the value of the '<em><b>Multi Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.henshin.model.Rule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Rules</em>' containment reference list.
	 * @see org.eclipse.emf.henshin.model.HenshinPackage#getRule_MultiRules()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rule> getMultiRules();

	/**
	 * Returns the value of the '<em><b>Multi Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.henshin.model.Mapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Mappings</em>' containment reference list.
	 * @see org.eclipse.emf.henshin.model.HenshinPackage#getRule_MultiMappings()
	 * @model containment="true"
	 * @generated NOT
	 */
	MappingList getMultiMappings();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Node getNode(String nodename, boolean isLhs);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean containsMapping(Node sourceNode, Node targetNode);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean containsMultiMapping(Node sourceNode, Node targetNode);
	
} // Rule
