/**
 */
package TGG_correspondence.util;

import TGG_correspondence.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see TGG_correspondence.TGG_correspondencePackage
 * @generated
 */
public class TGG_correspondenceAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TGG_correspondencePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TGG_correspondenceAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TGG_correspondencePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TGG_correspondenceSwitch<Adapter> modelSwitch =
		new TGG_correspondenceSwitch<Adapter>() {
			@Override
			public Adapter caseCORR(CORR object) {
				return createCORRAdapter();
			}
			@Override
			public Adapter caseAbstractSource(AbstractSource object) {
				return createAbstractSourceAdapter();
			}
			@Override
			public Adapter caseAbstractTarget(AbstractTarget object) {
				return createAbstractTargetAdapter();
			}
			@Override
			public Adapter caseGenCORR(GenCORR object) {
				return createGenCORRAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link TGG_correspondence.CORR <em>CORR</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TGG_correspondence.CORR
	 * @generated
	 */
	public Adapter createCORRAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TGG_correspondence.AbstractSource <em>Abstract Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TGG_correspondence.AbstractSource
	 * @generated
	 */
	public Adapter createAbstractSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TGG_correspondence.AbstractTarget <em>Abstract Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TGG_correspondence.AbstractTarget
	 * @generated
	 */
	public Adapter createAbstractTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TGG_correspondence.GenCORR <em>Gen CORR</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TGG_correspondence.GenCORR
	 * @generated
	 */
	public Adapter createGenCORRAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TGG_correspondenceAdapterFactory
