package tggeditor.editparts.rule;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.henshin.model.And;
import org.eclipse.emf.henshin.model.Formula;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Not;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.gef.EditPolicy;

import tgg.NodeLayout;
import tgg.TGGPackage;
import tggeditor.editparts.graphical.NodeObjectEditPart;
import tggeditor.editpolicies.graphical.NodeComponentEditPolicy;
import tggeditor.editpolicies.graphical.NodeGraphicalEditPolicy;
import tggeditor.editpolicies.rule.RuleNodeXYLayoutEditPolicy;

/**
 * The class RuleNodeEditPart.
 */
public class RuleNodeEditPart extends NodeObjectEditPart {

	/** The NACs mappings. (NACs mappings only!!)*/
	protected List<Mapping> mappings;

	/** the lhs node belongs to model (which is the rhs node) */
	Node lhsNode;
	
	/**
	 * Instantiates a new rule node edit part.
	 *
	 * @param model the model
	 */
	public RuleNodeEditPart(Node model) {
		super(model);
		
		mappings = new ArrayList<Mapping>();
		
		setRuleMapping(model);	
		setNacMappings(model);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		super.createFigure();	
		return figure;
	}
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new RuleNodeXYLayoutEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new NodeComponentEditPolicy());
		installEditPolicy(EditPolicy.NODE_ROLE, new NodeGraphicalEditPolicy());
	}
	
	@Override
	protected void notifyChanged(Notification notification) {
		NodeLayout layoutModel = getLayoutModel();
		
		if (notification.getNotifier() instanceof NodeLayout){
			int featureId = notification.getFeatureID(TGGPackage.class);
			switch (featureId) {
			case TGGPackage.NODE_LAYOUT__X:
			case TGGPackage.NODE_LAYOUT__Y:
				refreshVisuals();
				break;
			case TGGPackage.NODE_LAYOUT__NEW:
				if (layoutModel.isNew()) {
					this.mappings.clear();
					this.lhsNode = null;					
				}
				else {
					this.lhsNode = layoutModel.getLhsnode();
					registerAdapter(lhsNode);	
					this.mappings.clear();
					this.setNacMappings((Node)getModel());
				}
				refreshVisuals();
				refreshFigureName();
				break;
			}
		}
		
		if (notification.getNotifier() instanceof Node) {
			int featureId = notification.getFeatureID(HenshinPackage.class);
			int type = notification.getEventType();
			final Object newValue = notification.getNewValue();
			final Object oldValue = notification.getOldValue();	
			switch (type) {
				case Notification.SET:
				case Notification.UNSET:	
					refreshFigureName();
					refreshVisuals();
					break;
				case Notification.ADD:
				case Notification.ADD_MANY:
					if (type == Notification.ADD && newValue instanceof Mapping) {
						final Mapping m = (Mapping) newValue;
						// NAC mapping only
						if (this.mapping != null 
//								&& m.getOrigin() == this.mapping.getOrigin()
								&& m.getImage() != getModel()) {
							if (!mappings.contains(m)) {
								mappings.add(m);
								if (this.index == -1) 
									this.index = this.mapping.getOrigin().getGraph().getNodes().indexOf(this.mapping.getOrigin());
								refreshFigureName();
								refreshVisuals();
								break;
							}
						}
					}
				break;
				case Notification.REMOVE:
				case Notification.REMOVE_MANY:
					if (type == Notification.REMOVE && oldValue instanceof Mapping) {
						final Mapping m = (Mapping) oldValue;	
						// NAC mapping only
						if (mappings.contains(m)
								&& m.getImage() != getModel()) {
							mappings.remove(m);
							if (mappings.size() == 0) {
								this.index = -1;
								refreshFigureName();
								refreshVisuals();
								break;
							}
						}
					}
				break;
			}
			
			switch (featureId) {
			case -1:
				refreshSourceConnections();
				refreshTargetConnections();
				refreshChildren();
				break;
			case HenshinPackage.NODE__NAME:
				if (lhsNode != null && !lhsNode.getName().equals(getCastedModel().getName())) {
					lhsNode.setName(getCastedModel().getName());
				}
				refreshFigureName();
				refreshVisuals();
				break;
			case HenshinPackage.NODE__TYPE:
				refreshVisuals();
				break;
			case HenshinPackage.NODE__INCOMING:
				refreshTargetConnections();
				break;
			case HenshinPackage.NODE__OUTGOING:
				refreshSourceConnections();
				break;
			case HenshinPackage.NODE__ATTRIBUTES:
				refreshChildren();
				refreshVisuals();
				break;
			}
		}
		
		if (notification.getNotifier() instanceof Mapping
				&& this.mapping != null) {
			int type = notification.getEventType();
			final Object newValue = notification.getNewValue();
			final Object oldValue = notification.getOldValue();				
			switch (type) {
				case Notification.SET:
					if (newValue instanceof Node) {
						final Mapping m = (Mapping) notification.getNotifier();
						// NAC mapping only
						if (m.getOrigin() == this.mapping.getOrigin()
								&& m.getImage() != getModel()) {
							if (!mappings.contains(m)) {
								mappings.add(m);
							}
							if (this.index == -1) 
								this.index = this.mapping.getOrigin().getGraph().getNodes().indexOf(this.mapping.getOrigin());
							refreshFigureName();
							refreshVisuals();
							break;
						}
					}
				break;
				case Notification.ADD:
				case Notification.ADD_MANY:
					if (newValue instanceof Mapping) {
						final Mapping m = (Mapping) newValue;
						// NAC mapping only
						if (m.getOrigin() == this.mapping.getOrigin()
								&& m.getImage() != getModel()) {
							if (!mappings.contains(m)) {
								mappings.add(m);
								if (this.index == -1) 
									this.index = this.mapping.getOrigin().getGraph().getNodes().indexOf(this.mapping.getOrigin());
								refreshFigureName();
								refreshVisuals();
								break;
							}
						}
					}
				break;
				case Notification.UNSET:
					if (newValue instanceof Node) {
						final Mapping m = (Mapping) notification.getNotifier();
						// NAC mapping only
						if (mappings.contains(m)
								&& m.getOrigin() == this.mapping.getOrigin()
								&& m.getImage() != getModel()) {
							mappings.remove(m);
							if (mappings.size() == 0) {
								this.index = -1;
								refreshFigureName();
								refreshVisuals();
								break;
							}
						}
					}
				break;
				case Notification.REMOVE:
				case Notification.REMOVE_MANY:
					if (oldValue instanceof Mapping) {
						final Mapping m = (Mapping) oldValue;	
						// NAC mapping only
						if (mappings.contains(m)
								&& m.getOrigin() == this.mapping.getOrigin()
								&& m.getImage() != getModel()) {
							mappings.remove(m);
							if (mappings.size() == 0) {
								this.index = -1;
								refreshFigureName();
								refreshVisuals();
								break;
							}
						}
					}
				break;
			}
		}
	}

	/**
	 * iterates over all rule mappings and sets the right mapping and lhs node
	 * @param model the node
	 */
	private void setRuleMapping(Node model) {
		EList<Mapping> maps = model.getGraph().getContainerRule().getMappings();
		for (Mapping m: maps) {
			if (m.getImage() == model) {
				this.mapping = m;
				lhsNode = this.mapping.getOrigin();
				break;
			}
		}
	}
	
	/**
	 * gets the rule mapping
	 * @return the rule mapping
	 */
	public Mapping getRuleMapping() {
		return this.mapping;
	}
	
	@Override
	public Mapping getNacMapping() {
		return null;
	}
	
	@Override
	protected void setNacMapping(Node model) {		
	}
	
	@Override
	public void setNacMapping(Mapping m) {		
	}
	
	/**
	 * sets the nac mappings belongs to model
	 * @param model the model
	 */
	private void setNacMappings(Node model) {
		NodeLayout layoutModel = getLayoutModel();
		if (getCastedModel().getGraph().eContainer() instanceof Rule
				&& !layoutModel.isNew()) {
			Formula f = ((Rule) getCastedModel().getGraph().eContainer()).getLhs().getFormula();
			if (f != null) {
				addNacMappings(f, model);
				if (this.mappings.size() > 0)
					this.index = model.getGraph().getNodes().indexOf(getModel());
			}
		}
	}
	
	/**
	 * adds nac mappings
	 * @param f the formula
	 * @param model the node
	 */
	private void addNacMappings(Formula f, Node model) {
		if (f instanceof And) {
			if (((And)f).getLeft() instanceof And)
				addNacMappings(((And)f).getLeft(), model);
			else 
				addNacMaps(((And)f).getLeft(), model);
			
			if (((And)f).getRight() instanceof And) 
				addNacMappings(((And)f).getRight(), model);
			else 
				addNacMaps(((And)f).getRight(), model);
		}		
		else 
			addNacMaps(f, model);
	}
	
	/**
	 * helper method for addNacMappings
	 * @param f the Formula
	 * @param model the model
	 */
	private void addNacMaps(Formula f, Node model) {
		EList<Mapping> maps = ((NestedCondition)((Not)f).getChild()).getMappings();
		for (Mapping m : maps) {
			if (m.getOrigin() == getLayoutModel().getLhsnode()) 
				this.mappings.add(m);
		}
	}
	
	/**
	 * adds a mapping to mappings
	 * @param m the new mapping
	 */
	public void addMapping(Mapping m) {
		if (!this.mappings.contains(m)) {
			this.mappings.add(m);
			registerAdapter(m);
		}
	}
	
	@Override
	protected void performOpen() {
		// do nothing
		System.out.println("");
	}
	
}
