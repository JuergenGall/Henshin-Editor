/**
 * 
 */
package de.tub.tfs.henshin.editor.commands.transformation_unit;

import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.gef.commands.Command;

/**
 * The Class SetActivatedCommand.
 * 
 * @author Johann
 */
public class SetActivatedCommand extends Command {

	/** The t unit. */
	private final Unit transformationUnit;

	/** The activated. */
	private final boolean status;

	/**
	 * Instantiates a new sets the activated command.
	 * 
	 * @param transformationUnit
	 *            the transformation unit
	 * @param status
	 *            the status
	 */
	public SetActivatedCommand(Unit transformationUnit,
			boolean status) {
		super();
		this.transformationUnit = transformationUnit;
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return transformationUnit.isActivated() != status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		transformationUnit.setActivated(status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		transformationUnit.setActivated(!status);
	}

}
