package de.tub.tfs.henshin.tggeditor.editparts.tree.graphical;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.gef.EditPolicy;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.TreeItem;

import de.tub.tfs.henshin.tgg.GraphLayout;
import de.tub.tfs.henshin.tgg.TGG;
import de.tub.tfs.henshin.tgg.TggFactory;
import de.tub.tfs.henshin.tggeditor.editparts.tree.TGGTreeContainerEditPolicy;
import de.tub.tfs.henshin.tggeditor.editpolicies.graphical.GraphComponentEditPolicy;
import de.tub.tfs.henshin.tggeditor.util.GraphUtil;
import de.tub.tfs.henshin.tggeditor.util.IconUtil;
import de.tub.tfs.henshin.tggeditor.util.NodeUtil;
import de.tub.tfs.muvitor.gef.directedit.IDirectEditPart;
import de.tub.tfs.muvitor.gef.editparts.AdapterTreeEditPart;


public class GraphTreeEditPart extends AdapterTreeEditPart<Graph> implements IDirectEditPart {
	
	public GraphTreeEditPart(Graph model) {
		super(model);
		if (GraphUtil.getGraphLayout(getCastedModel(), true) == null) {
			TGG tgg = NodeUtil.getLayoutSystem(getCastedModel());
			if (tgg != null) {
				GraphLayout divSC = TggFactory.eINSTANCE.createGraphLayout();
				divSC.setIsSC(true);
				divSC.setDividerX(GraphUtil.center - GraphUtil.correstpondenceWidth/2);
				divSC.setGraph(model);
				GraphLayout divCT = TggFactory.eINSTANCE.createGraphLayout();
				divCT.setIsSC(false);
				divCT.setDividerX(GraphUtil.center + GraphUtil.correstpondenceWidth/2);
				divCT.setGraph(model);
				tgg.getGraphlayouts().add(divSC);
				tgg.getGraphlayouts().add(divCT);
			}
		}
	}
	
	@Override
	protected String getText() {
		if (getCastedModel() == null)
			return "";
		return getCastedModel().getName();
	}

	@Override
	protected List<EObject> getModelChildren() {
		List<EObject> list = new ArrayList<EObject>();
		list.addAll(getCastedModel().getNodes());
		list.addAll(getCastedModel().getEdges());
		return list;
	}

	@Override
	protected void notifyChanged(Notification notification) {
		final int featureId = notification.getFeatureID(HenshinPackage.class);
		switch (featureId){
			case HenshinPackage.GRAPH__NAME:
				refreshVisuals();
			case HenshinPackage.GRAPH__NODES:
			case HenshinPackage.GRAPH__EDGES:
			case HenshinPackage.GRAPH__FORMULA:
				refreshChildren();
			default:
				break; 
		}
		refreshVisuals();
		super.notifyChanged(notification);
	}

	@Override
	public int getDirectEditFeatureID() {
		return HenshinPackage.GRAPH__NAME;
	}

	@Override
	public ICellEditorValidator getDirectEditValidator() {
		return null;
	}
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new GraphComponentEditPolicy());
		installEditPolicy(EditPolicy.TREE_CONTAINER_ROLE,
				new TGGTreeContainerEditPolicy());	
	}

	@Override
	protected Image getImage() {
		try {
			return IconUtil.getIcon("graph18.png");
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	protected void performOpen() {
		if (getCastedModel().getRule() == null)
			super.performOpen();
		else {
			if (this.widget instanceof TreeItem) {
				TreeItem item = (TreeItem) this.widget;
				item.setExpanded(!item.getExpanded());	
			}
		}
	}
	
}