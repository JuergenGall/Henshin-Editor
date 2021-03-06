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
/**
 */
package correspondece;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see correspondece.CorrespondeceFactory
 * @model kind="package"
 * @generated
 */
public interface CorrespondecePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "correspondece";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cor";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cor";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CorrespondecePackage eINSTANCE = correspondece.impl.CorrespondecePackageImpl.init();

	/**
	 * The meta object id for the '{@link correspondece.impl.CTImpl <em>CT</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see correspondece.impl.CTImpl
	 * @see correspondece.impl.CorrespondecePackageImpl#getCT()
	 * @generated
	 */
	int CT = 0;

	/**
	 * The feature id for the '<em><b>To Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CT__TO_CLASS = 0;

	/**
	 * The feature id for the '<em><b>To Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CT__TO_TABLE = 1;

	/**
	 * The number of structural features of the '<em>CT</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>CT</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link correspondece.impl.AFKImpl <em>AFK</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see correspondece.impl.AFKImpl
	 * @see correspondece.impl.CorrespondecePackageImpl#getAFK()
	 * @generated
	 */
	int AFK = 1;

	/**
	 * The feature id for the '<em><b>Ass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFK__ASS = 0;

	/**
	 * The feature id for the '<em><b>Fkey</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFK__FKEY = 1;

	/**
	 * The number of structural features of the '<em>AFK</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFK_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>AFK</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link correspondece.impl.ACImpl <em>AC</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see correspondece.impl.ACImpl
	 * @see correspondece.impl.CorrespondecePackageImpl#getAC()
	 * @generated
	 */
	int AC = 2;

	/**
	 * The feature id for the '<em><b>Atr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC__ATR = 0;

	/**
	 * The feature id for the '<em><b>Col</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC__COL = 1;

	/**
	 * The number of structural features of the '<em>AC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>AC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link correspondece.impl.CD2DBImpl <em>CD2DB</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see correspondece.impl.CD2DBImpl
	 * @see correspondece.impl.CorrespondecePackageImpl#getCD2DB()
	 * @generated
	 */
	int CD2DB = 3;

	/**
	 * The feature id for the '<em><b>Db2cd</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CD2DB__DB2CD = 0;

	/**
	 * The feature id for the '<em><b>Cd2db</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CD2DB__CD2DB = 1;

	/**
	 * The number of structural features of the '<em>CD2DB</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CD2DB_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>CD2DB</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CD2DB_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link correspondece.impl.A2TImpl <em>A2T</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see correspondece.impl.A2TImpl
	 * @see correspondece.impl.CorrespondecePackageImpl#getA2T()
	 * @generated
	 */
	int A2T = 4;

	/**
	 * The feature id for the '<em><b>Ass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A2T__ASS = 0;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A2T__TABLE = 1;

	/**
	 * The number of structural features of the '<em>A2T</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A2T_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>A2T</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A2T_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link correspondece.impl.GenericCorrImpl <em>Generic Corr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see correspondece.impl.GenericCorrImpl
	 * @see correspondece.impl.CorrespondecePackageImpl#getGenericCorr()
	 * @generated
	 */
	int GENERIC_CORR = 5;

	/**
	 * The feature id for the '<em><b>Src</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_CORR__SRC = 0;

	/**
	 * The feature id for the '<em><b>Tgt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_CORR__TGT = 1;

	/**
	 * The number of structural features of the '<em>Generic Corr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_CORR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Generic Corr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_CORR_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link correspondece.CT <em>CT</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CT</em>'.
	 * @see correspondece.CT
	 * @generated
	 */
	EClass getCT();

	/**
	 * Returns the meta object for the reference '{@link correspondece.CT#getToClass <em>To Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Class</em>'.
	 * @see correspondece.CT#getToClass()
	 * @see #getCT()
	 * @generated
	 */
	EReference getCT_ToClass();

	/**
	 * Returns the meta object for the reference '{@link correspondece.CT#getToTable <em>To Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Table</em>'.
	 * @see correspondece.CT#getToTable()
	 * @see #getCT()
	 * @generated
	 */
	EReference getCT_ToTable();

	/**
	 * Returns the meta object for class '{@link correspondece.AFK <em>AFK</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AFK</em>'.
	 * @see correspondece.AFK
	 * @generated
	 */
	EClass getAFK();

	/**
	 * Returns the meta object for the reference '{@link correspondece.AFK#getAss <em>Ass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ass</em>'.
	 * @see correspondece.AFK#getAss()
	 * @see #getAFK()
	 * @generated
	 */
	EReference getAFK_Ass();

	/**
	 * Returns the meta object for the reference '{@link correspondece.AFK#getFkey <em>Fkey</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Fkey</em>'.
	 * @see correspondece.AFK#getFkey()
	 * @see #getAFK()
	 * @generated
	 */
	EReference getAFK_Fkey();

	/**
	 * Returns the meta object for class '{@link correspondece.AC <em>AC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AC</em>'.
	 * @see correspondece.AC
	 * @generated
	 */
	EClass getAC();

	/**
	 * Returns the meta object for the reference '{@link correspondece.AC#getAtr <em>Atr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Atr</em>'.
	 * @see correspondece.AC#getAtr()
	 * @see #getAC()
	 * @generated
	 */
	EReference getAC_Atr();

	/**
	 * Returns the meta object for the reference '{@link correspondece.AC#getCol <em>Col</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Col</em>'.
	 * @see correspondece.AC#getCol()
	 * @see #getAC()
	 * @generated
	 */
	EReference getAC_Col();

	/**
	 * Returns the meta object for class '{@link correspondece.CD2DB <em>CD2DB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CD2DB</em>'.
	 * @see correspondece.CD2DB
	 * @generated
	 */
	EClass getCD2DB();

	/**
	 * Returns the meta object for the reference '{@link correspondece.CD2DB#getDb2cd <em>Db2cd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Db2cd</em>'.
	 * @see correspondece.CD2DB#getDb2cd()
	 * @see #getCD2DB()
	 * @generated
	 */
	EReference getCD2DB_Db2cd();

	/**
	 * Returns the meta object for the reference '{@link correspondece.CD2DB#getCd2db <em>Cd2db</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Cd2db</em>'.
	 * @see correspondece.CD2DB#getCd2db()
	 * @see #getCD2DB()
	 * @generated
	 */
	EReference getCD2DB_Cd2db();

	/**
	 * Returns the meta object for class '{@link correspondece.A2T <em>A2T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A2T</em>'.
	 * @see correspondece.A2T
	 * @generated
	 */
	EClass getA2T();

	/**
	 * Returns the meta object for the reference '{@link correspondece.A2T#getAss <em>Ass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ass</em>'.
	 * @see correspondece.A2T#getAss()
	 * @see #getA2T()
	 * @generated
	 */
	EReference getA2T_Ass();

	/**
	 * Returns the meta object for the reference '{@link correspondece.A2T#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see correspondece.A2T#getTable()
	 * @see #getA2T()
	 * @generated
	 */
	EReference getA2T_Table();

	/**
	 * Returns the meta object for class '{@link correspondece.GenericCorr <em>Generic Corr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Corr</em>'.
	 * @see correspondece.GenericCorr
	 * @generated
	 */
	EClass getGenericCorr();

	/**
	 * Returns the meta object for the reference '{@link correspondece.GenericCorr#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src</em>'.
	 * @see correspondece.GenericCorr#getSrc()
	 * @see #getGenericCorr()
	 * @generated
	 */
	EReference getGenericCorr_Src();

	/**
	 * Returns the meta object for the reference '{@link correspondece.GenericCorr#getTgt <em>Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tgt</em>'.
	 * @see correspondece.GenericCorr#getTgt()
	 * @see #getGenericCorr()
	 * @generated
	 */
	EReference getGenericCorr_Tgt();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CorrespondeceFactory getCorrespondeceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link correspondece.impl.CTImpl <em>CT</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see correspondece.impl.CTImpl
		 * @see correspondece.impl.CorrespondecePackageImpl#getCT()
		 * @generated
		 */
		EClass CT = eINSTANCE.getCT();

		/**
		 * The meta object literal for the '<em><b>To Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CT__TO_CLASS = eINSTANCE.getCT_ToClass();

		/**
		 * The meta object literal for the '<em><b>To Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CT__TO_TABLE = eINSTANCE.getCT_ToTable();

		/**
		 * The meta object literal for the '{@link correspondece.impl.AFKImpl <em>AFK</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see correspondece.impl.AFKImpl
		 * @see correspondece.impl.CorrespondecePackageImpl#getAFK()
		 * @generated
		 */
		EClass AFK = eINSTANCE.getAFK();

		/**
		 * The meta object literal for the '<em><b>Ass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AFK__ASS = eINSTANCE.getAFK_Ass();

		/**
		 * The meta object literal for the '<em><b>Fkey</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AFK__FKEY = eINSTANCE.getAFK_Fkey();

		/**
		 * The meta object literal for the '{@link correspondece.impl.ACImpl <em>AC</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see correspondece.impl.ACImpl
		 * @see correspondece.impl.CorrespondecePackageImpl#getAC()
		 * @generated
		 */
		EClass AC = eINSTANCE.getAC();

		/**
		 * The meta object literal for the '<em><b>Atr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AC__ATR = eINSTANCE.getAC_Atr();

		/**
		 * The meta object literal for the '<em><b>Col</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AC__COL = eINSTANCE.getAC_Col();

		/**
		 * The meta object literal for the '{@link correspondece.impl.CD2DBImpl <em>CD2DB</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see correspondece.impl.CD2DBImpl
		 * @see correspondece.impl.CorrespondecePackageImpl#getCD2DB()
		 * @generated
		 */
		EClass CD2DB = eINSTANCE.getCD2DB();

		/**
		 * The meta object literal for the '<em><b>Db2cd</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CD2DB__DB2CD = eINSTANCE.getCD2DB_Db2cd();

		/**
		 * The meta object literal for the '<em><b>Cd2db</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CD2DB__CD2DB = eINSTANCE.getCD2DB_Cd2db();

		/**
		 * The meta object literal for the '{@link correspondece.impl.A2TImpl <em>A2T</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see correspondece.impl.A2TImpl
		 * @see correspondece.impl.CorrespondecePackageImpl#getA2T()
		 * @generated
		 */
		EClass A2T = eINSTANCE.getA2T();

		/**
		 * The meta object literal for the '<em><b>Ass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A2T__ASS = eINSTANCE.getA2T_Ass();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A2T__TABLE = eINSTANCE.getA2T_Table();

		/**
		 * The meta object literal for the '{@link correspondece.impl.GenericCorrImpl <em>Generic Corr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see correspondece.impl.GenericCorrImpl
		 * @see correspondece.impl.CorrespondecePackageImpl#getGenericCorr()
		 * @generated
		 */
		EClass GENERIC_CORR = eINSTANCE.getGenericCorr();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_CORR__SRC = eINSTANCE.getGenericCorr_Src();

		/**
		 * The meta object literal for the '<em><b>Tgt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_CORR__TGT = eINSTANCE.getGenericCorr_Tgt();

	}

} //CorrespondecePackage
