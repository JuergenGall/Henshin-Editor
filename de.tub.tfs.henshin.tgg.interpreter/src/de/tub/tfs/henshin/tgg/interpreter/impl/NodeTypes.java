/*******************************************************************************
 * Copyright (c) 2012, 2014 Henshin developers.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Henshin developers - initial API and implementation
 *******************************************************************************/

package de.tub.tfs.henshin.tgg.interpreter.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;

import de.tub.tfs.henshin.tgg.ImportedPackage;
import de.tub.tfs.henshin.tgg.TNode;
import de.tub.tfs.henshin.tgg.TggFactory;
import de.tub.tfs.henshin.tgg.TripleComponent;
import de.tub.tfs.henshin.tgg.interpreter.util.ExceptionUtil;
import de.tub.tfs.henshin.tgg.interpreter.util.NodeUtil;



/**
 * The Class NodeTypes.
 */
public class NodeTypes {
	
	/**
	 * Gets the node types.
	 *
	 * @param graph the graph
	 * @param withAbstract the with abstract
	 * @return the node types
	 */
	public static List<EClass> getNodeTypes(Graph graph,boolean withAbstract){
		List<EClass> eClasses = new Vector<EClass>();

		for (EPackage emodel:((Module) graph.eContainer()
				.eResource().getContents().get(0)).getImports()){
			eClasses.addAll(getNodeTypesOfEPackage(emodel,withAbstract));
		}
		return eClasses;
	}

	
	/**
	 * Gets the node types von e package.
	 *
	 * @param emodel the emodel
	 * @param withAbstract the with abstract
	 * @return the node types von e package
	 */
	public static List<EClass> getNodeTypesOfEPackage(EPackage emodel,boolean withAbstract){
		List<EClass> eClasses = new Vector<EClass>();

			Iterator<EObject> it = emodel.eAllContents();
			while (it.hasNext()) {
				EObject eO = it.next();
				if (eO instanceof EClass) {
					if (!((EClass) eO).isAbstract() || withAbstract) {
						eClasses.add((EClass) eO);
					}
				}
			}
		return eClasses;
	}

	/**
	 * Gets the node types of all epackages in the given list of imported Packages.
	 *
	 * @param emodels the list of imported packages
	 * @param withAbstract the with abstract
	 * @return the node types of the list of imported packages
	 */
	public static List<EClass> getNodeTypesOfImportedPackages(List<ImportedPackage> emodels,boolean withAbstract){
		List<EPackage> ePkgs = new Vector<EPackage>();
		for(ImportedPackage emodel:emodels){
			ePkgs.add(emodel.getPackage());
		}
		return getNodeTypesOfEPackages(ePkgs, withAbstract);
	}

	
	/**
	 * Gets the node types of all epackages in the given list.
	 *
	 * @param emodels the list of epackages
	 * @param withAbstract the with abstract
	 * @return the node types of the list of epackages
	 */
	public static List<EClass> getNodeTypesOfEPackages(List<EPackage> emodels,boolean withAbstract){
		List<EClass> eClasses = new Vector<EClass>();
		for(EPackage emodel:emodels){
			eClasses.addAll(getNodeTypesOfEPackage(emodel,withAbstract));
		}
		return eClasses;
	}

	
	/**
	 * Gets the edge types von e package.
	 *
	 * @param emodel the emodel
	 * @return the edge types von e package
	 */
	public static List<EReference> getEdgeTypesOfEPackage(EPackage emodel) {
		List<EReference> eReferences = new Vector<EReference>();
		
		Iterator<EObject> it = emodel.eAllContents();
		while (it.hasNext()) {
			EObject eO = it.next();
			if (eO instanceof EReference) {
				eReferences.add((EReference) eO);
			}
		}
		return eReferences;
	}


	
	/**
	 * Gets the edge types of the list of imported packages.
	 *
	 * @param impPkgs the list of imported packages
	 * @return the edge types of the list of imported packages
	 */
	public static List<EReference> getEdgeTypesOfImportedPackages(EList<ImportedPackage> impPkgs) {
		List<EPackage> pkgs = new Vector<EPackage>();
		for(ImportedPackage emodel:impPkgs){
			pkgs.add(emodel.getPackage());
		}
		return getEdgeTypesOfEPackages(pkgs);
	}
	
	
	/**
	 * Gets the edge types of the list of ecore packages.
	 *
	 * @param emodels the list of ecore packages
	 * @return the edge types of the list of ecore packages
	 */
	public static List<EReference> getEdgeTypesOfEPackages(List<EPackage> emodels) {
		List<EReference> eReferences = new Vector<EReference>();
		for(EPackage emodel:emodels){
			eReferences.addAll(getEdgeTypesOfEPackage(emodel));
		}
		return eReferences;
	}




	
	/**
	 * Gets the type of node.
	 *
	 * @param tgg
	 * @param node
	 * @return the node type
	 */
	public static TripleComponent getTripleComponent(Node node){

		if (NodeUtil.isSourceNode((TNode) node))
			return TripleComponent.SOURCE;
		if (NodeUtil.isCorrespondenceNode((TNode) node))
			return TripleComponent.CORRESPONDENCE;
		if (NodeUtil.isTargetNode((TNode) node))
			return TripleComponent.TARGET;
		// in all other cases
		return TripleComponent.SOURCE;
		
	}
	





	/**
	 * Can containment.
	 *
	 * @param node the node
	 * @return true, if successful
	 */
	public static boolean canContainment(Node node) {
		EPackage eP = node.getType().getEPackage();
		Iterator<EObject> it = eP.eAllContents();
		while (it.hasNext()) {
			EObject eO = it.next();
			if (eO instanceof EReference) {
				EReference ref = (EReference) eO;
				if (ref.isContainment()) {
					if (ref.getEReferenceType() == node.getType() || isExtended(node.getType(), ref.getEReferenceType())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	
	public static boolean isContainment(Node node){
		for (Edge edge:node.getIncoming()){
			if (edge.getType().isContainment()){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isExtended(EClass class1,EClass extendsClass){
		return class1.getEAllSuperTypes().contains(extendsClass);
	}
	
	/**
	 * @param ePackages
	 */
	private void setEPackages(List<EPackage> ePackages, EList<ImportedPackage> importedPackages) {
		for(ImportedPackage p: importedPackages){
			ePackages.add(p.getPackage());
		}
	}

	
	/**
	 * Computes a list of Epackages of a triple component from the list of imported packages
	 * @param impPackages
	 * @param nodeGraphType
	 * @return list of Epackages of the specified triple component 
	 */
	public static List<EPackage> getEPackagesOfComponent(EList<ImportedPackage> impPackages, TripleComponent component) {
		List<ImportedPackage> restrictedList = getImportedPackagesOfComponent(impPackages,component);
		return getEPackagesFromImportedPackages(restrictedList);
	}

	/**
	 * Computes a list of imported packages to a triple component
	 * @param impPackages
	 * @param component
	 * @return 
	 * @return
	 */
	public static List<ImportedPackage> getImportedPackagesOfComponent(EList<ImportedPackage> impPackages, TripleComponent component) {
		if(impPackages==null)
			{ExceptionUtil.error("Import packages are missing for retrieving the imported packages of the component"); return null;}
		List<ImportedPackage> restrictedList = new Vector<ImportedPackage>();
		ImportedPackage pkg;
		Iterator<ImportedPackage> iter = impPackages.iterator();
		while (iter.hasNext()) {
			pkg=iter.next();
		    if (pkg.getComponent() == component) 
		    		restrictedList.add(pkg);
		}
		return restrictedList;
	}

	

	public static boolean contains(EPackage epkg,List<ImportedPackage> pkgs){
		for (ImportedPackage pkg : pkgs) {
			if (pkg.getPackage().equals(epkg))
				return true;
		}		
		return false;
	}
	
	
	public static boolean contains(ImportedPackage pkg,EPackage epkg){
		return pkg.getPackage().equals(epkg);
	}





	public static List<EPackage> getEPackagesFromImportedPackages(
			List<ImportedPackage> importedPackages) {
		if(importedPackages==null)
			{ExceptionUtil.error("Imported packages are missing for retrieving the epackages"); return null;}
		// iterate over the imported packages and return the list of Epackages
		List<EPackage> ePkgs = new Vector<EPackage>();
		ImportedPackage pkg;
		Iterator<ImportedPackage> iter = importedPackages.iterator();
		while (iter.hasNext()) {
			pkg=iter.next();
	    	ePkgs.add(pkg.getPackage());
		}
		return ePkgs;
	}
	
	public static List<ImportedPackage> getImportedPackagesFromEPackages(
			List<EPackage> ePackages, TripleComponent component) {
		if(ePackages==null)
			{ExceptionUtil.error("EPackages are missing for retrieving the imported packages"); return null;}
		// iterate over the imported packages and return the list of Epackages
		List<ImportedPackage> importedPkgs = new Vector<ImportedPackage>();
		EPackage pkg;
		ImportedPackage importedPkg;
		Iterator<EPackage> iter = ePackages.iterator();
		while (iter.hasNext()) {
			pkg=iter.next();
			importedPkg = TggFactory.eINSTANCE.createImportedPackage();
			importedPkg.setComponent(component);
			importedPkg.setPackage(pkg);
	    	importedPkgs.add(importedPkg);
		}
		return importedPkgs;
	}
}
