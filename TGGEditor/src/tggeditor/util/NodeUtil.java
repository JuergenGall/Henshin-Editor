package tggeditor.util;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.henshin.model.Formula;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;

import tgg.GraphLayout;
import tgg.NodeLayout;
import tgg.TGG;
import tgg.TGGFactory;
import tggeditor.TreeEditor;
import tggeditor.figures.NodeFigure;
import tggeditor.util.NodeTypes.NodeGraphType;
import de.tub.tfs.muvitor.ui.IDUtil;

/**
 * The Class Nodeutil
 * Holds many helpful static functions for operating on nodes.
 */
public class NodeUtil {
	
	/**
	 * Gets the layout system which holds the given EObject
	 * 
	 * @param eobject the eobject
	 * @return the layout system
	 */
	public static TGG getLayoutSystem(EObject eobject) {
		if(!(IDUtil.getHostEditor(eobject) instanceof TreeEditor)) return null;
		TreeEditor editor = (TreeEditor) IDUtil.getHostEditor(eobject);
		if(editor == null) return null;
		return editor.getLayout();
	}

	/**
	 * Get the node layout of given node. If there's no node layout it creates one
	 * @param node
	 * @return the node layout linked to given node
	 */
	public static NodeLayout getNodeLayout(Node node) {
		TGG layoutModel = getLayoutSystem(node);
		if(layoutModel == null)return null;
		NodeLayout result = null;
		if (layoutModel != null) {
			result = findNodeLayout(node, layoutModel);
			if (result==null){
				result = createNodeLayout(node,layoutModel);
			}
		}
		return result;
	}
	
	/**
	 * get the mapping in rule of given node of rhs
	 * @param rhsNode
	 * @return
	 */
	public static Mapping getNodeMapping(Node rhsNode) {
		EList<Mapping> mappingList = rhsNode.getGraph().getContainerRule().getMappings();

		for (Mapping m : mappingList) {
			if (m.getImage() == rhsNode) {
				return m;
			}
		}
		return null;
	}
	
	/**
	 * checks if given node have a nac mapping
	 * @param node
	 * @return
	 */
	public static Boolean hasNodeNacMapping(Node node) {
		Formula formula = node.getGraph().getFormula();
		if (formula != null) {
			TreeIterator<EObject> iter = node.getGraph().getFormula().eAllContents();
			
			while (iter.hasNext()) {
				EObject o = iter.next();
				if (o instanceof NestedCondition) {
					NestedCondition nc = (NestedCondition)o;
					for (Mapping m : nc.getMappings()) {
						if (m.getOrigin() == node) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * get nac mapping of given node
	 * @param nc the nested condition with all mappings
	 * @param node
	 * @return (returns null if there's no mapping)
	 */
	public static Mapping getNodeNacMapping(NestedCondition nc, Node node) {
		
		EList<Mapping> list = nc.getMappings();
		for (Mapping m : list) {
			if (m.getImage() == node) {
				return m;
			}
		}
		
		return null;
	}
	
	/**
	 * searches all mappings belongs to given node
	 * @param rhsNode
	 * @return a set of Mappings belongs to the given rhsNode (empty list if there are no mapping)
	 */
	public static List<Mapping> getNodeNacMappings(Node rhsNode) {
		List<Mapping> nacMappings = new ArrayList<Mapping>();
		Mapping ruleMapping = getNodeMapping(rhsNode);
		
		if (ruleMapping != null) {
			Node lhsNode = ruleMapping.getOrigin();
			Formula formula = lhsNode.getGraph().getFormula();
			if (formula !=null) {
				TreeIterator<EObject> iter = ruleMapping.getOrigin().getGraph().getFormula().eAllContents();
	
				while (iter.hasNext()) {
					EObject o = iter.next();
					if (o instanceof NestedCondition) {
						NestedCondition nc = (NestedCondition)o;
						for (Mapping m : nc.getMappings()) {
							if (m.getOrigin() == lhsNode) {
								nacMappings.add(m);
							}
						}
					}
				}
			}
		}
		
		return nacMappings;
	}
	
	public static void deleteNodeNacMapping(Node node) {
		
	}
	 
	/**
	 * creates a new nodeLayout in given layoutSystem which is linked to given node
	 * @param node
	 * @param layoutSystem
	 * @return the created node layout
	 */
	private static NodeLayout createNodeLayout(Node node, TGG layoutSystem) {
		NodeLayout nodeLayout = TGGFactory.eINSTANCE.createNodeLayout();
		nodeLayout.setNode(node);
		layoutSystem.getNodelayouts().add(nodeLayout);
		return nodeLayout;
	}

	/**
	 * find node layout linked to given node in layoutSystem
	 * @param node 
	 * @param tgg the layoutSystem
	 * @return the nodeLyout which belongs to given node
	 */
	protected static NodeLayout findNodeLayout(Node node, TGG tgg) {
		for (NodeLayout nodeLayout : tgg.getNodelayouts()) {
			if (nodeLayout.getNode() == node || nodeLayout.getLhsnode() == node) {
				return nodeLayout;
			}
		}
		return null;
	}
	
	/**
	 * find all nodeLayouts to specific EPackage
	 * @param tgg the layoutSystem
	 * @param p EPackage for source, target oder correspondence
	 * @return a set node layouts with all nodeLayouts belongs to EPackage p
	 */
	public static Set<NodeLayout> getNodeLayouts(TGG tgg, EPackage p) {
		Set<NodeLayout> set = new HashSet<NodeLayout>();
		EList<NodeLayout> l = tgg.getNodelayouts();
		if (p != null) {
			for (NodeLayout nl : l) {
				if (p.eContents().contains(nl.getNode().getType())) {
					set.add(nl);
				}
			}
		}
		return set;
	}
	
	/**
	 * checks whether a specific EClass is a source type in given layoutSystem
	 * @param tgg the layoutSystem
	 * @param type the EClass for check
	 * @return true if specific EClass is a source type
	 */
	public static boolean isSourceNode(TGG tgg, EClass type) {
		if(tgg.getSource() != null)
		if (tgg.getSource().eContents().contains(type))
			return true;
		return false;
	}
	
	/**
	 * checks whether a specific EClass is a target type in given layoutSystem
	 * @param tgg the layoutSystem
	 * @param type the EClass for check
	 * @return true if specific EClass is a target type
	 */
	public static boolean isTargetNode(TGG tgg, EClass type) {
		if(tgg.getTarget() != null)
		if (tgg.getTarget().eContents().contains(type))
			return true;
		return false;
	}
	
	/**
	 * checks whether a specific EClass is a correspondence type in given layoutSystem
	 * @param tgg the layoutSystem
	 * @param type the EClass for check
	 * @return true if specific EClass is a correspondence type
	 */
	public static boolean isCorrespNode(TGG tgg, EClass type) {
		if(tgg.getCorresp() != null)
		if (tgg.getCorresp().eContents().contains(type))
			return true;
		return false;
	}
	
	/**
	 * Searches the graph layout of divider. If dividerSC is true it searches for 
	 * source-correspondence divider, if its false it searches for the correspondence-target divider.
	 * @param graph which is linked to its dividers
	 * @param dividerSC (search SC or CT divider?)
	 * @return graph layout of searched divider
	 */
	private static GraphLayout getGraphLayout(Graph graph, boolean dividerSC) {
		TGG layoutSystem = getLayoutSystem(graph);
		if (layoutSystem != null) {
			for (GraphLayout graphLayout : layoutSystem.getGraphlayouts()) {
				if (graphLayout.getGraph() == graph) {
					if (dividerSC == graphLayout.isIsSC())
						return graphLayout;
				}
			}
		}
		return null;
	}
	
	/**
	 * correct position of a node (in nodeFigure and nodeLayout) in relation to its NodeGraphType
	 * and the divider positions, this correction generates no notifications
	 * @param nodeFigure the figure of the node
	 */
	public static void correctNodeFigurePosition(NodeFigure nodeFigure) {
		if(nodeFigure == null)return;
		Node node = nodeFigure.getNode();
		NodeLayout nodeLayout = getNodeLayout(node);
		if(node == null || nodeLayout == null)return;
		GraphLayout divSC = NodeUtil.getGraphLayout((Graph)node.eContainer(), true);
		GraphLayout divCT = NodeUtil.getGraphLayout((Graph)node.eContainer(), false);
		if(divSC == null || divCT == null)return;
		int divSCx = divSC.getDividerX();
		int divCTx = divCT.getDividerX();
		int width = nodeFigure.getBounds().width;
		int leftX = nodeLayout.getX();
		int correctionValue = 0;
		NodeGraphType type = NodeTypes.getNodeGraphType(node);
		
		if (type == NodeGraphType.SOURCE) {
			if (leftX+width >= divSCx)
				correctionValue = divSCx - leftX - width - 5;
		}
		else if (type == NodeGraphType.CORRESPONDENCE) {
			if (leftX <= divSCx)
				correctionValue = divSCx - leftX + 5;
			else if (leftX+width >= divCTx)
				correctionValue = divCTx - leftX - width - 5;
		}
		else if (type == NodeGraphType.TARGET) {
			if (leftX <= divCTx)
				correctionValue = divCTx - leftX + 5;
		}
		if(correctionValue != 0) {
		  nodeLayout.eSetDeliver(false);
		  nodeLayout.setX(leftX + correctionValue);
		  nodeLayout.eSetDeliver(true);
		  nodeFigure.setLocation(new Point(nodeLayout.getX(), nodeLayout.getY()));
		}
	}
	
}
