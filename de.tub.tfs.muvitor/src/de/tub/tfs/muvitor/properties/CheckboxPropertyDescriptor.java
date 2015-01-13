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
package de.tub.tfs.muvitor.properties;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.PropertyDescriptor;

/**
 * Property Descriptor for boolean values in the properties view.
 */
public class CheckboxPropertyDescriptor extends PropertyDescriptor {
	/**
	 * @param id
	 * @param displayName
	 */
	public CheckboxPropertyDescriptor(final Object id, final String displayName) {
		super(id, displayName);
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.ui.views.properties.IPropertyDescriptor#createPropertyEditor
	 * (org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public CellEditor createPropertyEditor(final Composite parent) {
		final CellEditor editor = new CheckboxCellEditor(parent);
		if (getValidator() != null) {
			editor.setValidator(getValidator());
		}
		return editor;
	}
	
}
