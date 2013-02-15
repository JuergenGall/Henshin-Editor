/** 
 * This class adds a Transformation Unit in AddTransformationUnitCommand 
 * and executes the command.
 */
package de.tub.tfs.henshin.editor.actions.transformation_unit;


import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.ui.PlatformUI;

import de.tub.tfs.henshin.editor.commands.transformation_unit.AddTransformationUnitCommand;
import de.tub.tfs.henshin.editor.util.DialogUtil;

/**
 * The Class AddTransformationUnitTool.
 * 
 * @author Johann
 */
public class AddTransformationUnitTool extends CreationTool {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.tools.AbstractTool#executeCurrentCommand()
	 */
	@Override
	protected void executeCurrentCommand() {
		AddTransformationUnitCommand currentCmd = (AddTransformationUnitCommand) getCurrentCommand();
		Unit transUnit = DialogUtil
				.runTransformationUnitChoiceForAddUnitDialog(PlatformUI
						.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().getActivePart().getSite().getShell(),
						currentCmd.getParent());
		if (transUnit != null && currentCmd != null) {
			currentCmd.setTransformationUnit(transUnit);
			super.executeCurrentCommand();
		}

	}

}
