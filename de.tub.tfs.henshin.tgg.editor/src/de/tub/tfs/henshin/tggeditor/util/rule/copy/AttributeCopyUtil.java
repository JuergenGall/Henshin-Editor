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
package de.tub.tfs.henshin.tggeditor.util.rule.copy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.henshin.model.Attribute;

import de.tub.tfs.henshin.tgg.TAttribute;

public class AttributeCopyUtil {
	
	//NEW
		public static Attribute copyAttribute(Attribute att) {
			Copier copier = new Copier();
			EObject result = copier.copy(att);
			copier.copyReferences();
			return (Attribute) result;
		}
		
		//NEW
		public static boolean isCopy(Attribute ar1, Attribute ar2) {
			if (ar1.getConstant()==null && ar2.getConstant()!=null) return false; 
			if (ar2.getConstant()==null && ar1.getConstant()!=null) return false;
			if (ar2.getConstant()!=null && ar1.getConstant()!=null && !ar1.getConstant().equals(ar2.getConstant()))
				return false;
			boolean samevalues = false;
			if (ar1.getValue()==null){
				samevalues = (ar2.getValue()==null);
			}else{
				samevalues = ar1.getValue().equals(ar2.getValue());
			}
			boolean result =
					samevalues && 
					ar1.getType().getName().equals(ar2.getType().getName());
			return result;
		}
		
		
		
		
}
