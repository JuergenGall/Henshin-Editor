/**
 * 
 */
package de.tub.tfs.henshin.editor.commands.transformation_unit;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.gef.commands.Command;

import de.tub.tfs.henshin.editor.internal.ConditionalUnitPart;
import de.tub.tfs.henshin.editor.util.SendNotify;
import de.tub.tfs.henshin.editor.util.TransformationUnitUtil;

/**
 * The Class AddTransformationUnitCommand.
 * 
 * @author Johann
 */
public class AddTransformationUnitCommand extends Command {

	/** The parent. */
	private final Unit parent;

	/** The feature. */
	private final EStructuralFeature feature;

	/** The transformation unit. */
	private Unit transformationUnit;

	/** The old transformation unit. */
	private Unit oldTransformationUnit;

	/** The index. */
	private int index;

	/**
	 * Instantiates a new adds the transformation unit command.
	 * 
	 * @param parent
	 *            the parent
	 * @param transformationUnit
	 *            the transformation unit
	 */
	public AddTransformationUnitCommand(Unit parent,
			Unit transformationUnit) {
		this(parent, transformationUnit, -1);
	}

	/**
	 * Instantiates a new adds the transformation unit command.
	 * 
	 * @param parent
	 *            the parent
	 * @param transformationUnit
	 *            the transformation unit
	 * @param index
	 *            the index
	 */
	public AddTransformationUnitCommand(Unit parent,
			Unit transformationUnit, int index) {
		super();
		this.feature = TransformationUnitUtil.getSubUnitsFeature(parent);
		if (parent instanceof ConditionalUnitPart) {
			this.parent = ((ConditionalUnitPart) parent).getModel();
		} else {
			this.parent = parent;
		}

		this.transformationUnit = transformationUnit;
		this.index = index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return feature != null && transformationUnit != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		if (feature.isMany()) {
			List<Unit> list = (List<Unit>) parent
					.eGet(feature);
//			if (!list.contains(transformationUnit)) {
				if (index >= 0 && index < list.size()) {
					list.add(index, transformationUnit);
				} else {
					list.add(transformationUnit);
				}
//			}
		} else {
			Object object = parent.eGet(feature);
			if (object != null) {
				oldTransformationUnit = (Unit) object;
			}
			parent.eSet(feature, transformationUnit);
		}
		SendNotify.sendSetTransformationUnitNotify(transformationUnit);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void undo() {
		if (feature.isMany()) {
			List<Unit> list = (List<Unit>) parent
					.eGet(feature);
			list.remove(transformationUnit);
		} else {
			parent.eSet(feature, oldTransformationUnit);
		}
		SendNotify.sendSetTransformationUnitNotify(transformationUnit);
	}

	/**
	 * Sets the transformation unit.
	 * 
	 * @param transformationUnit
	 *            the new transformation unit
	 */
	public synchronized void setTransformationUnit(
			Unit transformationUnit) {
		this.transformationUnit = transformationUnit;
	}

	/**
	 * Gets the parent.
	 * 
	 * @return the parent
	 */
	public Unit getParent() {
		return parent;
	}

}
