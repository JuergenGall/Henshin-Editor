/*******************************************************************************
 * Copyright (c) 2012, 2013 Henshin developers.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Henshin developers - initial API and implementation
 *******************************************************************************/
package de.tub.tfs.henshin.tggeditor.actions.imports;

import java.util.HashMap;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.SAXXMLHandler;
import org.eclipse.emf.ecore.xmi.impl.XMLLoadImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

final class ContextXMLLoad extends XMLLoadImpl {

	private HashMap<EObject, Context> contexts = new HashMap<EObject, Context>();
	
	public HashMap<EObject, Context> getContexts() {
		return contexts;
	}
	
	public ContextXMLLoad(XMLHelper helper) {
		super(helper);
	}

	@Override
	protected DefaultHandler makeDefaultHandler() {
		// TODO Auto-generated method stub
		return new SAXXMLHandler(resource,
				helper, options) {


			@Override
			protected void processObject(EObject object) {
				super.processObject(object);
				Context.handleContext(contexts, object);
			}


		};
	}

}