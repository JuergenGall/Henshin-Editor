/*******************************************************************************
 *******************************************************************************/
package de.tub.tfs.henshin.tggeditor.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Node;

public class AttributeTypes {
	/**
	 * Gets the free attribute types.
	 *
	 * @param node the node
	 * @return the free attribute types
	 */
	public static List<EAttribute> getFreeAttributeTypes(Node node){
		List<EAttribute> eattributes = new ArrayList<EAttribute>();
		if (node.getType()!=null) {
			outer: for (int i=0;i<node.getType().getEAllAttributes().size();i++){
				EAttribute eO=node.getType().getEAllAttributes().get(i);

				for (Attribute attr:node.getAttributes()){
					if (attr.getType()!=null)
						if (attr.getType().equals(eO))
							continue outer;
							
				}
				
				eattributes.add((EAttribute) eO);
			}
		}
		return eattributes;
	}
	
	/**
	 * Gets the free attribute types.
	 *
	 * @param node the node
	 * @param eAttribute the e attribute
	 * @return the free attribute types
	 */
	public static List<EAttribute> getFreeAttributeTypes(Node node,EAttribute eAttribute ){
		List<EAttribute> eattributes = getFreeAttributeTypes(node);
		eattributes.add(0,eAttribute);
		return eattributes;
	}
}
