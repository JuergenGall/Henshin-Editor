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
/*
* generated by Xtext
*/
package lu.uni.snt.repeat;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class REPEATUiInjectorProvider implements IInjectorProvider {
	
	public Injector getInjector() {
		return lu.uni.snt.repeat.ui.internal.REPEATActivator.getInstance().getInjector("lu.uni.snt.repeat.REPEAT");
	}
	
}
