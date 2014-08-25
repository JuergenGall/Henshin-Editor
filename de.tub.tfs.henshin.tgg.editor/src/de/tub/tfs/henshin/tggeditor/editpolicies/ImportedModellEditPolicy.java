/*******************************************************************************
 *******************************************************************************/
package de.tub.tfs.henshin.tggeditor.editpolicies;

import org.eclipse.emf.henshin.model.Module;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import de.tub.tfs.henshin.tgg.ImportedPackage;
import de.tub.tfs.henshin.tgg.TGG;
import de.tub.tfs.henshin.tggeditor.commands.delete.DeleteImportedModellCommand;


public class ImportedModellEditPolicy extends ComponentEditPolicy {

	private TGG tgg;
	
	public ImportedModellEditPolicy(TGG tgg) {
		this.tgg = tgg;
	}
	
	@Override
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		Module module = (Module) getHost().getParent().getParent().getModel();
		return new DeleteImportedModellCommand(((ImportedPackage) getHost().getModel()), tgg, module);
		
	}

	
}
