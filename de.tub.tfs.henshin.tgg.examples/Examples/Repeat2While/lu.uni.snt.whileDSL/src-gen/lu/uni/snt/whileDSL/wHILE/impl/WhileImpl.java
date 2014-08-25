/**
 */
package lu.uni.snt.whileDSL.wHILE.impl;

import lu.uni.snt.whileDSL.wHILE.Expr;
import lu.uni.snt.whileDSL.wHILE.Fgmnt_LST_Elem;
import lu.uni.snt.whileDSL.wHILE.WHILEPackage;
import lu.uni.snt.whileDSL.wHILE.While;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>While</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link lu.uni.snt.whileDSL.wHILE.impl.WhileImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link lu.uni.snt.whileDSL.wHILE.impl.WhileImpl#getFgmnt <em>Fgmnt</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WhileImpl extends Fgmnt_LST_ElemImpl implements While
{
  /**
	 * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getExpr()
	 * @generated
	 * @ordered
	 */
  protected Expr expr;

  /**
	 * The cached value of the '{@link #getFgmnt() <em>Fgmnt</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFgmnt()
	 * @generated
	 * @ordered
	 */
  protected Fgmnt_LST_Elem fgmnt;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected WhileImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return WHILEPackage.Literals.WHILE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Expr getExpr()
  {
		return expr;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetExpr(Expr newExpr, NotificationChain msgs)
  {
		Expr oldExpr = expr;
		expr = newExpr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WHILEPackage.WHILE__EXPR, oldExpr, newExpr);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setExpr(Expr newExpr)
  {
		if (newExpr != expr) {
			NotificationChain msgs = null;
			if (expr != null)
				msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WHILEPackage.WHILE__EXPR, null, msgs);
			if (newExpr != null)
				msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WHILEPackage.WHILE__EXPR, null, msgs);
			msgs = basicSetExpr(newExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WHILEPackage.WHILE__EXPR, newExpr, newExpr));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Fgmnt_LST_Elem getFgmnt()
  {
		return fgmnt;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetFgmnt(Fgmnt_LST_Elem newFgmnt, NotificationChain msgs)
  {
		Fgmnt_LST_Elem oldFgmnt = fgmnt;
		fgmnt = newFgmnt;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WHILEPackage.WHILE__FGMNT, oldFgmnt, newFgmnt);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFgmnt(Fgmnt_LST_Elem newFgmnt)
  {
		if (newFgmnt != fgmnt) {
			NotificationChain msgs = null;
			if (fgmnt != null)
				msgs = ((InternalEObject)fgmnt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WHILEPackage.WHILE__FGMNT, null, msgs);
			if (newFgmnt != null)
				msgs = ((InternalEObject)newFgmnt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WHILEPackage.WHILE__FGMNT, null, msgs);
			msgs = basicSetFgmnt(newFgmnt, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WHILEPackage.WHILE__FGMNT, newFgmnt, newFgmnt));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case WHILEPackage.WHILE__EXPR:
				return basicSetExpr(null, msgs);
			case WHILEPackage.WHILE__FGMNT:
				return basicSetFgmnt(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case WHILEPackage.WHILE__EXPR:
				return getExpr();
			case WHILEPackage.WHILE__FGMNT:
				return getFgmnt();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case WHILEPackage.WHILE__EXPR:
				setExpr((Expr)newValue);
				return;
			case WHILEPackage.WHILE__FGMNT:
				setFgmnt((Fgmnt_LST_Elem)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eUnset(int featureID)
  {
		switch (featureID) {
			case WHILEPackage.WHILE__EXPR:
				setExpr((Expr)null);
				return;
			case WHILEPackage.WHILE__FGMNT:
				setFgmnt((Fgmnt_LST_Elem)null);
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case WHILEPackage.WHILE__EXPR:
				return expr != null;
			case WHILEPackage.WHILE__FGMNT:
				return fgmnt != null;
		}
		return super.eIsSet(featureID);
	}

} //WhileImpl
