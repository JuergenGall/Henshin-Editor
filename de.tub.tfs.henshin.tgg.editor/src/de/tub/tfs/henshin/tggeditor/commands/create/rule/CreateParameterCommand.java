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
package de.tub.tfs.henshin.tggeditor.commands.create.rule;

import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.gef.commands.Command;

public class CreateParameterCommand extends Command {
	/** The transformation unit. */
	private final Unit transformationUnit;
	
	/** The parameter. */
	protected Parameter parameter;
	
	
	/**
	 * Instantiates a new creates the parameter command.
	 *
	 * @param transformationUnit the transformation unit
	 * @param name the name
	 */
	public CreateParameterCommand(Unit transformationUnit,String name) {
		super();
		this.transformationUnit = transformationUnit;
		this.parameter = HenshinFactory.eINSTANCE.createParameter();
		this.parameter.setName(name);
	}

	

	/**
	 * Instantiates a new creates the parameter command.
	 *
	 * @param transformationUnit the transformation unit
	 * @param parameter the parameter
	 */
	public CreateParameterCommand(Unit transformationUnit, Parameter parameter) {
		super();
		this.transformationUnit = transformationUnit;
		this.parameter = parameter;
	}



	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return transformationUnit!=null && parameter!=null;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		transformationUnit.getParameters().add(parameter);
	}


	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		transformationUnit.getParameters().remove(parameter);
	}


	/**
	 * Gets the trans unit.
	 *
	 * @return the transUnit
	 */
	public synchronized Unit getTransUnit() {
		return transformationUnit;
	}


	/**
	 * Gets the parameter.
	 *
	 * @return the port
	 */
	public synchronized Parameter getParameter() {
		return parameter;
	}
}
