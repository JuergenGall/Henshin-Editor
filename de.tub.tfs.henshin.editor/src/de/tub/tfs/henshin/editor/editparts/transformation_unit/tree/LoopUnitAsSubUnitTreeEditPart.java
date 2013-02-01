/**
 * 
 */
package de.tub.tfs.henshin.editor.editparts.transformation_unit.tree;

import org.eclipse.emf.henshin.model.LoopUnit;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.gef.EditPolicy;

import de.tub.tfs.henshin.editor.editparts.transformation_unit.TransformationUnitAsSubUnitComponentEditPolicy;
import de.tub.tfs.henshin.editor.editparts.transformation_unit.graphical.LoopUnitTreeEditPart;

/**
 * @author nam
 * 
 */
public class LoopUnitAsSubUnitTreeEditPart extends LoopUnitTreeEditPart {

	private Unit parent;

	/**
	 * @param model
	 */
	public LoopUnitAsSubUnitTreeEditPart(Unit parent,
			LoopUnit model) {
		super(model);

		this.parent = parent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * henshineditor.editparts.tree.rule.RuleTreeEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new TransformationUnitAsSubUnitComponentEditPolicy(parent));
	}
}
