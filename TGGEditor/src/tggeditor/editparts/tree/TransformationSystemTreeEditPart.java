package tggeditor.editparts.tree;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.emf.henshin.model.TransformationSystem;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.TreeItem;

import tggeditor.editparts.tree.critical.CheckedRulePairFolder;
import tggeditor.editparts.tree.graphical.GraphFolder;
import tggeditor.editparts.tree.rule.FTRules;
import tggeditor.editparts.tree.rule.RuleFolder;
import tggeditor.util.IconUtil;
import tggeditor.util.NodeUtil;

import de.tub.tfs.muvitor.gef.editparts.AdapterTreeEditPart;

public class TransformationSystemTreeEditPart extends AdapterTreeEditPart<TransformationSystem> {

	public TransformationSystemTreeEditPart(TransformationSystem model) {
		super(model);
	}
	
	@Override
	protected String getText() {
		//return getCastedModel().getName();
		return "Transformation System";
	}
	
	@Override
	protected List<EObject> getModelChildren() {
		List<EObject> list = new ArrayList<EObject>();
		list.add(new ImportFolder(getCastedModel()));
		list.add(new GraphFolder(getCastedModel()));
		list.add(new RuleFolder(getCastedModel()));			
		//FTRules ftRules = new FTRules(getCastedModel());
		list.add(new FTRules(getCastedModel()));
		list.add(new CheckedRulePairFolder(getCastedModel()));
		return list;
	}

	@Override
	protected void notifyChanged(Notification notification) {
		final int featureId = notification.getFeatureID(HenshinPackage.class);
		if(notification.getEventType() == 9)
			return ;
		
		switch (featureId){
			case HenshinPackage.TRANSFORMATION_SYSTEM__INSTANCES:
				refreshChildren();
				break;
			default:
				// check that the TGGLayout of the transformation system is present (e.g. can disappear when another editor is in use)
				if (NodeUtil.getLayoutSystem(getCastedModel()) != null)
				refresh();
				break;
		}
	}
	
	@Override
	protected Image getImage() {
		try {
			return IconUtil.getIcon("transformationsystem18.png");
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	protected void performOpen() {
		if (this.widget instanceof TreeItem) {
			TreeItem item = (TreeItem) this.widget;
			item.setExpanded(!item.getExpanded());	
		}	
	}
}
