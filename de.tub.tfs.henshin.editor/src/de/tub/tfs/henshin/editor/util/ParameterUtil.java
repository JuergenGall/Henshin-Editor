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
 * 
 */
package de.tub.tfs.henshin.editor.util;

import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;

/**
 * The Class PortUtil.
 */
public class ParameterUtil {

	/**
	 * Gets the parameter.
	 * 
	 * @param node
	 *            the node
	 * @return the parameter
	 */
	public static Parameter getParameter(Node node) {
		if (node.getName() != null && !node.getName().isEmpty()) {
			Rule rule = (Rule) node.getGraph().eContainer();
			for (Parameter parameter : rule.getParameters()) {
				if (parameter.getName().equals(node.getName())) {
					return parameter;
				}
			}
		}
		return null;
	}
}
