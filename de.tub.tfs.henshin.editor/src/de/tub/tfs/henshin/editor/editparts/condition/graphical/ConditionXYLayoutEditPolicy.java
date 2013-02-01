package de.tub.tfs.henshin.editor.editparts.condition.graphical;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.henshin.model.BinaryFormula;
import org.eclipse.emf.henshin.model.Formula;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.UnaryFormula;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.AlignmentRequest;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import de.tub.tfs.henshin.editor.commands.condition.CreateConditionCommand;

/**
 * The Class ConditionXYLayoutEditPolicy.
 */
public class ConditionXYLayoutEditPolicy extends XYLayoutEditPolicy implements
		EditPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#
	 * createChangeConstraintCommand(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	@Override
	protected Command createChangeConstraintCommand(
			ChangeBoundsRequest request, EditPart child, Object constraint) {
		// TODO Auto-generated method stub
		return super.createChangeConstraintCommand(request, child, constraint);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse
	 * .gef.requests.CreateRequest)
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		Command command = null;
		if (request.getNewObject() instanceof Formula
				&& canMove((Formula) request.getNewObject())) {
			final Formula formula = (Formula) request.getNewObject();
			final Graph graph = (Graph) getHost().getModel();
			@SuppressWarnings("unused")
			final Rectangle constraint = (Rectangle) getConstraintFor(request);

			command = new CreateConditionCommand(graph, formula);
		}
		return command;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#
	 * getMoveChildrenCommand(org.eclipse.gef.Request)
	 */
	@Override
	protected Command getMoveChildrenCommand(Request request) {
		// ChangeBoundsRequest req = (ChangeBoundsRequest) request;
		// List<?> editparts = req.getEditParts();
		// Command move = new MoveManyNodesCommand(editparts, req);
		// return move;
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#
	 * getAlignChildrenCommand(org.eclipse.gef.requests.AlignmentRequest)
	 */
	@Override
	protected Command getAlignChildrenCommand(AlignmentRequest request) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#getAddCommand
	 * (org.eclipse.gef.Request)
	 */
	@Override
	protected Command getAddCommand(Request generic) {
		return null;
	}

	private boolean canMove(Formula formula) {
		if (formula.eContainer() instanceof Graph
				&& (formula instanceof BinaryFormula || formula instanceof UnaryFormula)) {
			return true;
		}

		return false;
	}
}
