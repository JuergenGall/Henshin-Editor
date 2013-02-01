/**
 * 
 */
package de.tub.tfs.henshin.editor.commands.transformation_unit;

import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.gef.commands.CompoundCommand;

import de.tub.tfs.henshin.model.layout.HenshinLayoutPackage;
import de.tub.tfs.henshin.model.layout.SubUnitLayout;
import de.tub.tfs.muvitor.commands.SetEObjectFeatureValueCommand;

/**
 * @author nam
 * 
 */
public class ChangeSubUnitCounterCommand extends CompoundCommand {

	public ChangeSubUnitCounterCommand(int newCounter, final SubUnitLayout model) {
		int diff = newCounter - model.getCounter();

		if (diff > 0) {
			for (int i = 0; i < diff; i++) {
				add(new AddTransformationUnitCommand(
						(Unit) model.getParent(),
						(Unit) model.getModel(), model.getIndex()));
			}
		} else {
			for (int i = 0; i > diff; i--) {
				add(new RemoveTransformationUnitCommand(
						(Unit) model.getParent(),
						(Unit) model.getModel(), model.getIndex()));
			}
		}

		add(new SetEObjectFeatureValueCommand(model, newCounter,
				HenshinLayoutPackage.SUB_UNIT_LAYOUT__COUNTER));
	}
}
