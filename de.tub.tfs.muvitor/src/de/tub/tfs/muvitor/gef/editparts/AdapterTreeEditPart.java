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
package de.tub.tfs.muvitor.gef.editparts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.TreeEditPart;
import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.gef.tools.DragTreeItemsTracker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.views.properties.IPropertySource;

import de.tub.tfs.muvitor.gef.directedit.IDirectEditPart;
import de.tub.tfs.muvitor.gef.directedit.MuvitorTreeDirectEditManager;
import de.tub.tfs.muvitor.gef.directedit.MuvitorTreeDirectEditPolicy;
import de.tub.tfs.muvitor.properties.EObjectPropertySource;
import de.tub.tfs.muvitor.ui.MuvitorTreeEditor;
import de.tub.tfs.muvitor.ui.utils.MuvitorNotifierService;

/**
 * This edit part is a convenience implementation with the following frequently
 * used features for EObjects:
 * 
 * <ul>
 * <li>On activation of this edit part, an EMF adapter is being installed on a
 * this edit parts' model, listening for model changes and passing the
 * notifications to {@link #notifyChanged(Notification)} and to the
 * {@link MuvitorNotifierService}. More adapters can freely be installed which
 * will be removed on deactivation.
 * <li>In {@link #createPropertySource()} an default
 * {@link EObjectPropertySource} showing all model features is created for this
 * edit part. {@link #getAdapter(Class)} provides the property source the the
 * properties view. Subclasses may override both.
 * <li>This edit part is prepared for GEF direct editing. Subclasses just need
 * to implement {@link IDirectEditPart} to enable this feature.
 * <li> {@link #performDirectEdit()} and {@link #performOpen()} may be overridden
 * to handle direct edit or open requests differently. By default,
 * {@link #performOpen()} will try to open a view with the model,
 * {@link #performDirectEdit()} will try to directly edit the property of the
 * specified feature ID specified by implementing {@link IDirectEditPart}.
 * </ul>
 * 
 * @author Tony Modica
 */
abstract public class AdapterTreeEditPart<T extends EObject> extends
	AbstractTreeEditPart {

	
    /**
     * The {@link Adapter}s that have been associated to some {@link EObject}s.
     * 
     * @see #registerAdapter(Adapter, EObject)
     */
    final private Map<Adapter, EObject> adapters = new HashMap<Adapter, EObject>();

    /**
     * By default, an Adapter will be installed on the model, passing the
     * notifications to {@link #notifyChanged(Notification)} and to the
     * {@link MuvitorNotifierService}.
     * 
     * @param model
     *            the model of this editpart
     */
    public AdapterTreeEditPart(final T model) {
	super(model);
	installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
		new MuvitorTreeDirectEditPolicy());
	registerAdapter(new AdapterImpl() {
	    @SuppressWarnings("synthetic-access")
	    @Override
	    public final void notifyChanged(final Notification msg) {
		AdapterTreeEditPart.this.notifyChanged(msg);
		final int featureId = msg.getFeatureID(EcorePackage.class);
		switch (featureId) {
		case EcorePackage.ENAMED_ELEMENT__NAME:
		    refreshVisuals();
		    break;
		}
		MuvitorNotifierService.notifyListeners(msg);
	    }
	});
    }

    /**
     * Removes this edit part's adapters from the model. Subclasses may override
     * but must call super implementation!
     * 
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#deactivate()
     */
    @Override
    public void deactivate() {
	if (isActive()) {
	    for (final Entry<Adapter, EObject> entry : adapters.entrySet()) {
		entry.getValue().eAdapters().remove(entry.getKey());
	    }
	    super.deactivate();
	}
    }

    /**
     * Subclasses may override but must call super implementation!
     * 
     * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Object getAdapter(final Class key) {
	if (IPropertySource.class == key) {
	    return createPropertySource();
	}
	return super.getAdapter(key);
    }

    /**
     * Convenient method that casts the model to the appropriate type.
     * 
     * @return The model of this EditPart appropriately casted.
     */
    @SuppressWarnings("unchecked")
    public final T getCastedModel() {
	return (T) getModel();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gef.editparts.AbstractTreeEditPart#getDragTracker(org.eclipse
     * .gef.Request)
     */
    @Override
    public DragTracker getDragTracker(final Request req) {
	return new DragTreeItemsTracker(this);
    }

    /**
     * Handles the standard GEF requests "direct edit" and "open" on this edit
     * part.
     * 
     * @see #performDirectEdit()
     * @see #performOpen()
     * @see org.eclipse.gef.editparts.AbstractEditPart#performRequest(org.eclipse.gef.Request)
     */
    @Override
    public void performRequest(final Request request) {
	if (RequestConstants.REQ_DIRECT_EDIT == request.getType()
		&& checkTreeItem()) {
	    performDirectEdit();
	} else if (RequestConstants.REQ_OPEN == request.getType()) {
	    performOpen();
	}
    }

    /**
     * Convenience method to register a custom {@link Adapter} on this
     * editpart's model.
     * 
     * @param adapter
     *            an {@link Adapter} to register on this editpart's model
     * @see #registerAdapter(Adapter, EObject)
     */
    public final void registerAdapter(final Adapter adapter) {
	registerAdapter(adapter, getCastedModel());
    }

    /**
     * Via this method subclasses can install custom {@link Adapter}s in
     * {@link #activate()} listening to changes on a specific {@link EObject}.
     * All registered adapters will be deregistered by default in
     * {@link #deactivate()}.
     * 
     * @param adapter
     *            an {@link Adapter} to register on the model
     * @param model
     *            an {@link EObject} to observe with the passed adapter
     */
    public final void registerAdapter(final Adapter adapter, final EObject model) {
	adapters.put(adapter, model);
	model.eAdapters().add(adapter);
    }

    /**
     * Convenience method to let {@link #notifyChanged(Notification)} receive
     * notifications from additional EObjects. This method registers an
     * {@link Adapter} on some EObject that just forwards its notifications.
     * 
     * @param adapter
     *            an {@link Adapter} to register on this editpart's model
     * @see #registerAdapter(Adapter, EObject)
     */
    public final void registerAdapter(final EObject model) {
	registerAdapter(new AdapterImpl() {
	    @Override
	    public void notifyChanged(final Notification msg) {
		AdapterTreeEditPart.this.notifyChanged(msg);

		MuvitorNotifierService.notifyListeners(msg);
	    }
	}, model);
    }

    /**
     * This forces the top element to be shown as a tree element.
     * 
     * @see org.eclipse.gef.editparts.AbstractTreeEditPart#setWidget(org.eclipse.swt.widgets.Widget)
     */
    @Override
    public final void setWidget(final Widget widget) {
	if (widget instanceof Tree) {
	    final TreeItem item = new TreeItem((Tree) widget, SWT.MULTI); //
	    // create the treeitem for the root
	    super.setWidget(item);
	} else {
	    super.setWidget(widget);
	}
    }

    /**
     * Gets the model object, for which a graphical view will be opened. This is
     * per default the contained model itself, but could also be something else
     * (e.g the model of the parent {@link EditPart}).
     * 
     * @return the model object for the graphical viewer.
     * 
     * @see #performOpen()
     */
    protected EObject getGraphicalViewModel() {
	return getCastedModel();
    }

    /**
     * Creates a default {@link EObjectPropertySource} showing all model
     * features for this edit part. Subclasses may override.
     * 
     * @return the property source for this edit part
     */
    protected IPropertySource createPropertySource() {
	return new EObjectPropertySource(getCastedModel());
    }

    /**
     * By default, if the model is an {@link ENamedElement}, the text of this
     * tree edit part will be its name.
     */
    @Override
    protected String getText() {
	if (getCastedModel() instanceof ENamedElement) {
	    return ((ENamedElement) getCastedModel()).getName();
	}
	return super.getText();
    }

    /**
     * By default, an Adapter will be registered with this editpart's model that
     * passes notifications to this method, which subclasses are expected to
     * override. This can be extended to receive notifications from other
     * EObjects as well with {@link #registerAdapter(EObject)}.
     */
    protected void notifyChanged(final Notification notification) {
	refresh();
    }

    /**
     * Creates and opens a {@link MuvitorTreeDirectEditManager} by default,
     * handling direct editing, if this edit part implements
     * {@link IDirectEditPart}. Subclasses may override to perform some other
     * action here.
     */
    protected void performDirectEdit() {
	if (this instanceof IDirectEditPart) {
	    new MuvitorTreeDirectEditManager(this).show();
	}
    }

    /**
     * Used to check before a view could be opened for the model object.
     * Subclasses may override.
     * 
     * @return {@code true} per default
     */
    protected boolean canShowView() {
	return true;
    }

    /**
     * Calls MuvitorTreeEditor.showView(getCastedModel) and expands the
     * {@link TreeItem} widget by default. Subclasses may override to perform
     * some other actions here.
     */
    protected void performOpen() {
	Object myWidget = getWidget();
	boolean hasView = canShowView();

	if (myWidget != null) {
	    if (myWidget instanceof TreeItem) {
		boolean isExpanded = ((TreeItem) myWidget).getExpanded();

		((TreeItem) myWidget).setExpanded((hasView && true)
			|| !isExpanded);
	    }
	}

	if (hasView) {
	    MuvitorTreeEditor.showView(getGraphicalViewModel());
	}
    }

    /**
     * Finds a child {@link TreeEditPart} for a given model object.
     * 
     * @param model
     *            the child model object
     * @return the child {@link TreeEditPart}, if found or {@code null},
     *         otherwise
     */
    protected AbstractTreeEditPart findEditPartFor(Object model) {
	for (Object child : getChildren()) {
	    AbstractTreeEditPart castedChild = (AbstractTreeEditPart) child;

	    if (castedChild.getModel() == model) {
		return castedChild;
	    }
	}

	return null;
    }
    
}

