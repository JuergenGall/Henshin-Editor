package tggeditor.actions.create.rule;

import java.util.List;

import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.TransformationUnit;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchPart;

import tggeditor.commands.create.rule.CreateParameterCommand;
import tggeditor.editparts.rule.RuleGraphicalEditPart;
import tggeditor.editparts.rule.RuleNodeEditPart;
import tggeditor.editparts.tree.rule.RuleTreeEditPart;
import tggeditor.util.ModelUtil;
import tggeditor.util.ParameterUtil;
import tggeditor.util.validator.InputEditorValidators;
import tggeditor.util.validator.NameEditorValidator;
import tggeditor.util.validator.RuleNodeNameEditorValidator;

public class CreateParameterAction extends SelectionAction {

	public static final String ID ="tggeditor.actions.create.CreateParameterAction";
	/** The trans unit. */
	protected TransformationUnit transUnit;
	
	/** The node. */
	protected Node node;

	/**
	 * Instantiates a new creates the parameter action.
	 *
	 * @param part the part
	 */
	public CreateParameterAction(IWorkbenchPart part) {
		super(part);
		setId(ID);
		setText("Create parameter");
		setToolTipText("Create parameter");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
	 */
	@Override
	protected boolean calculateEnabled() {
		node = null;
		List<?> selectedObjects = getSelectedObjects();
		if (selectedObjects.size() != 1) {
			return false;
		}
		Object selectedObject = selectedObjects.get(0);

		if ((selectedObject instanceof EditPart)) {
			EditPart editpart = (EditPart) selectedObject;
			if (editpart.getModel() instanceof TransformationUnit) {
				transUnit = (TransformationUnit) editpart.getModel();
				return true;
			}
			if (editpart.getModel() instanceof Node
					&& ((editpart.getParent() instanceof RuleTreeEditPart) 
							|| (editpart instanceof RuleNodeEditPart 
									&& (editpart.getParent() instanceof RuleGraphicalEditPart)))) {
				// TODO Franky: only LHS 
				
				node = (Node) editpart.getModel();
				transUnit = (TransformationUnit) node.getGraph().eContainer();
				boolean enable = ParameterUtil.getParameter(node) == null;
				 
				if (transUnit instanceof Rule) {
					//if (ModelUtil.nodeInKernelRule(node)){
							//|| NodeUtil.getNodeLayout(node). isMulti()) {
					//	enable = true;
					//}
				}
				
				return enable;
			}

		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		String defaultVarName = ModelUtil.getNewChildDistinctName(
				transUnit, HenshinPackage.TRANSFORMATION_UNIT__PARAMETERS,
				"parameter");

		if (node != null) {
			String name=null;
			if (node.getName()!=null && !node.getName().isEmpty()){
				name = node.getName();
			}
			else{
				InputEditorValidators validators=new InputEditorValidators(new NameEditorValidator(transUnit,
						HenshinPackage.TRANSFORMATION_UNIT__PARAMETERS, true));
				validators.addValidator(new RuleNodeNameEditorValidator(node));
				InputDialog dialog = new InputDialog(getWorkbenchPart().getSite()
						.getShell(), "Node and parameter name Input",
						"Enter a name for the node and new parameter:", defaultVarName,validators
						);
				dialog.open();
				if (dialog.getReturnCode() == Window.OK) {
					name = dialog.getValue();
				}
			}
			if (name!=null){
				Command command = new CreateParameterAndRenameNodeCommand(transUnit,node, name);
				execute(command);
			}
			
		} 
		else {
			// asks the user for the new variable name, which has to be unique
			// in
			// current rule
			InputDialog dialog = new InputDialog(getWorkbenchPart().getSite()
					.getShell(), "Parameter Name Input",
					"Enter a name for the new parameter:", defaultVarName,
					new NameEditorValidator(transUnit,
							HenshinPackage.TRANSFORMATION_UNIT__PARAMETERS, true));
			dialog.open();
			
			if (dialog.getReturnCode() == Window.OK) {
				Command command;
				if (transUnit instanceof Rule) {
					/*final AmalgamationUnit aUnit = 
						ModelUtil.getAmalgamationUnit((Rule) transUnit);
					if (aUnit != null
							&& aUnit.getKernelRule() == transUnit) {
						return;
						command = new CreateKernelParameterCommand(
								transUnit, dialog.getValue());
					}
					else {*/
						command = new CreateParameterCommand(transUnit, dialog.getValue());
					//}
				}
				else {
					command = new CreateParameterCommand(transUnit, dialog.getValue());	
				}
				execute(command);

			}
		}
	}
}
