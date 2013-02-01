/**
 * 
 */
package de.tub.tfs.henshin.editor.commands.transSys;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.gef.commands.Command;

/**
 * The Class ImportEcorModellCommand.
 * 
 * @author Johann
 */
public class ImportEcorModellCommand extends Command {

	/** The EPackage. */
	private EPackage ePackage;

	/** The transformation system. */
	private Module transformationSystem;

	/**
	 * Instantiates a new import ecor model command.
	 * 
	 * @param transformationSystem
	 *            the transformation system
	 * @param epackge
	 *            the epackge
	 */
	public ImportEcorModellCommand(Module transformationSystem,
			EPackage epackge) {
		super();
		this.ePackage = epackge;
		this.transformationSystem = transformationSystem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return transformationSystem != null && ePackage != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		transformationSystem.getImports().add(ePackage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		transformationSystem.getImports().remove(ePackage);
	}

}
