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
package de.tub.tfs.muvitor.ui;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;

import de.tub.tfs.muvitor.ui.utils.EMFModelManager;
import de.tub.tfs.muvitor.ui.utils.GenericUtils;

/**
 * This purely static utility class encapsulates and manages the access to
 * EObject models via their unique IDs (assigned by their XMLResource) and keeps
 * track of the {@link MuvitorTreeEditor}s showing those models. It is used
 * properly by {@link MuvitorTreeEditor}s and should not be needed elsewhere,
 * except for {@link #getIDForModel(EObject)} and possibly
 * {@link #getRealURIFragment(EObject)}.
 * 
 * @author Tony Modica
 * 
 */
public final class IDUtil {
	
	/**
	 * A map storing all running editors associated with their model root URIs.
	 */
	final private static HashMap<String, MuvitorTreeEditor> modelURI2editor = new HashMap<String, MuvitorTreeEditor>();
	
	/**
	 * Method for getting the editor that hosts an EObject model (or rather its
	 * root container).
	 * 
	 * @param model
	 *            the model to find the hosting editor for
	 * @return the editor whose model root is the root container of the passed
	 *         model
	 */
	static public final MuvitorTreeEditor getHostEditor(final EObject model) {
		// register the model root's ID with the editor
		if (model==null) return null;
		final EObject rootContainer = EcoreUtil.getRootContainer(model);
		final String uri = EcoreUtil.getURI(rootContainer).toString();
		final MuvitorTreeEditor editor = modelURI2editor.get(uri);
		if (editor == null) {
			//MuvitorActivator.logError("Model '" + model + "' has no hosting editor (yet)!", null);
		}
		return editor;
	}
	
	/**
	 * Convenience method for retrieving the unique ID this model has in its
	 * {@link XMLResource}.
	 * 
	 * @param model
	 *            The model to get an ID for
	 * @return The unique EObject ID for the model
	 * 
	 * @see #getModelForID(String)
	 */
	static public final String getIDForModel(final EObject model) {
		final XMLResource res = (XMLResource) model.eResource();
		
		final String id = res.getID(model);
		return id;
	}
	
	/**
	 * This method resolves an ID to an EObject model searching the models of
	 * all running {@link MuvitorTreeEditor}s.
	 * 
	 * @param id
	 *            an ID that has been retrieved before
	 * @return the EObject that has the id
	 */
	static public final EObject getModelForID(final String id) {
		// look in all running editors
		for (final MuvitorTreeEditor editor : modelURI2editor.values()) {
			final List<EObject> modelRoots = editor.getModelRoots();
			// look through all model roots
			for (final EObject modelRoot : modelRoots) {
				final XMLResource res = (XMLResource) modelRoot.eResource();
				if (res == null)
					return null; 
				final EObject model = res.getEObject(id);
				if (model != null) {
					return model;
				}
			}
		}
		return null;
	}
	
	/**
	 * Convenience method the get the real URI fragment for an EObject model.
	 * Because we set XMLResource to use unique IDs for its models (see
	 * {@link EMFModelManager}) it will return these IDs if asked for the
	 * URIFragment. To get the real URIFragment we have to set the ID to null
	 * temporarily, which does this method.
	 * 
	 * @param model
	 *            the model element to get the URI fragment from
	 * @return the real URI fragment of the model rather than its ID
	 */
	static public final String getRealURIFragment(final EObject model) {
		final XMLResource res = (XMLResource) model.eResource();
		if (res == null) {
			return null;
		}
		// store id of the model
		final String id = res.getID(model);
		// set id of model to null to get real uriFragment, XMLResource just
		// works like this
		res.setID(model, null);
		final String uriFragment = res.getURIFragment(model);
		// restore model id
		res.setID(model, id);
		return uriFragment;
	}
	
	/**
	 * Sets newly generated IDs for all EObject contained in the passed model
	 * root. root.
	 * 
	 * @param model
	 */
	static public final void refreshIDs(final EObject modelRoot) {
		final XMLResource res = (XMLResource) modelRoot.eResource();
		res.setID(modelRoot, EcoreUtil.generateUUID());
		for (final TreeIterator<EObject> it = modelRoot.eAllContents(); it.hasNext();) {
			res.setID(it.next(), EcoreUtil.generateUUID());
		}
	}
	
	/**
	 * Deregisters a {@link MuvitorTreeEditor}.
	 * 
	 * @param editor
	 *            the editor to be deregistered
	 */
	static final void deregisterEditor(final MuvitorTreeEditor editor) {
		GenericUtils.deleteValueFromMap(modelURI2editor, editor, false);
	}
	
	/**
	 * Associates the URI of the model roots with the hosting editor.
	 * 
	 * @param editor
	 */
	static public final void registerEditor(final MuvitorTreeEditor editor) {
		// remove a possible registration
		deregisterEditor(editor);
		// register the model roots' ID with the editor
		final List<EObject> models = editor.getModelRoots();
		for (final EObject model : models) {
			final String uri = EcoreUtil.getURI(model).toString();
			modelURI2editor.put(uri, editor);
		}
	}
	
}
