package tggeditor.commands.create;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.gef.commands.Command;

import tgg.NodeLayout;
import tgg.TGG;
import tgg.TGGFactory;
import tgg.TRule;
import tggeditor.util.GraphUtil;
import tggeditor.util.NodeTypes;
import tggeditor.util.NodeTypes.NodeGraphType;
import tggeditor.util.NodeUtil;

/**
 * The class CreateNodeCommand creates a node in a graph.
 */
public class CreateNodeCommand extends Command {
	
	private static final String LABEL = "Create Node ";
	
	public static final int Y_DEFAULT = 30;
	
	/** The graph. */
	private final Graph graph;
	
	/** The node. */
	private Node node;
	
	/** The node layout. */
	private NodeLayout nodeLayout;
	
	/** The type, e.g. classdiagram, class, table. */
	private EClass type;
	
	/** The layout system. */
	private TGG layout;
	
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;
	
	/** The node graph type, whether source, correspondence or target */
	private NodeGraphType nodeGraphType;

	/**
	 * name of the node
	 */
	private String name = "";
	
	/**the constructor
	 * @param graph the graph in which the node is to be created
	 * @param name the name of the new node
	 * @param location the location for the nodelayout
	 */
	public CreateNodeCommand(Graph graph, String name, Point location) {
		this.graph = graph;
		this.node = HenshinFactory.eINSTANCE.createNode();
		this.nodeGraphType = NodeGraphType.DEFAULT;
		setName(name);
		
		setLocation(location);

		this.layout = NodeUtil.getLayoutSystem(graph);
	}

	
	/**the constructor
	 * @param n the already created node
	 * @param graph the graph in which the node is to be created
	 * @param location the location for the nodelayout
	 * @param nodeGraphType the nodeGraphType can be source, target or correspondence
	 */
	public CreateNodeCommand(Node n, Graph graph, Point location, NodeGraphType nodeGraphType) {
		this.graph = graph;
		this.node = n;
		setLocation(location);
		this.nodeGraphType = nodeGraphType;
		type = n.getType();

		this.layout = NodeUtil.getLayoutSystem(graph);
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		if (type != null) {
			node.setType(type);
		}
		
		nodeLayout = getNodeLayout();
		nodeLayout.setX(x);
		nodeLayout.setY(y);
		node.setName(name);
//		nodeLayout.setEnabled(enabled);
//		nodeLayout.setColor(0);
		
		graph.getNodes().add(node);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		graph.getNodes().remove(node);
		layout.getNodelayouts().remove(nodeLayout);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		/*if(nodeLayout.getLhsnode().equals(node)) {
			//no node creating in LHS Graph
			return false;
		}*/
		List<Rule> ftrules = new ArrayList<Rule>();
		for (TRule ft : layout.getTRules()) {
			ftrules.add(ft.getRule());
		}
		
		return ftrules.contains(graph.getContainerRule()) ? 
				graph.eContainer() instanceof NestedCondition : 
					(graph != null && typeFitsToGraphtype());
	}


	/**Checks if the already set type (classdiagram/class/table) fits to the nodeGraphType (source/
	 * correspondence/target). Needed for the Tools which create already typed nodes. 
	 * @return true if everything is okay
	 */
	private boolean typeFitsToGraphtype() {
		boolean ret = true;
		if (type != null) {
			EPackage ePackage = null;
			if (nodeGraphType == NodeGraphType.CORRESPONDENCE) {
				ePackage = layout.getCorresp();
			}
			if (nodeGraphType == NodeGraphType.SOURCE) {
				ePackage = layout.getSource();
			}
			if (nodeGraphType == NodeGraphType.TARGET) {
				ePackage = layout.getTarget();
			}
			if (ePackage != null) {
				ret = NodeTypes.getNodeTypesVonEPackage(ePackage, false).contains(type);
			} else {
				ret = false;
			}
		}
		return ret;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return graph != null;
	}

	/**
	 * Sets the node type.
	 *
	 * @param type the new node type
	 */
	public void setNodeType(EClass type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		layout.getNodelayouts().add(nodeLayout);
		graph.getNodes().add(node);
	}
	
	/**
	 * Gets the created node.
	 * @return the created node
	 */
	public Node getNode() {
		return node;
	}
	
	/**
	 * Gets the graph.
	 * @return the graph
	 */
	public Graph getGraph() {
		return this.graph;
	}
	
	/**
	 * @return the nodeLayout
	 */
	public NodeLayout getNodeLayout() {
		EList<NodeLayout> l = this.layout.getNodelayouts();
		for (NodeLayout nl: l) {
			if (nl.getNode() == node) {
				nodeLayout = nl;
				break;
			}
		}

		if (nodeLayout == null) {
			nodeLayout = TGGFactory.eINSTANCE.createNodeLayout();
			nodeLayout.setNode(this.node);
			l.add(nodeLayout);
		}		
		
		return nodeLayout;
	}
	
	/**
	 * @return the tgg layout model
	 */
	public TGG getLayoutModel() {
		return this.layout;
	}
	
	/**
	 * @return the location
	 */
	public Point getLocation() {
		return new Point(this.x, this.y);
	}
	
	/**
	 * @param name the name for the node
	 */
	public void setName(final String name) {
		this.name = name;
		setLabel(LABEL + "'" + name + "'");
	}
	
	/**
	 * @return the nodeGraphType (source/correspondece/target)
	 */
	public NodeGraphType getNodeGraphType() {
		return nodeGraphType;
	}
	
	/**
	 * @param location the location for the nodelayout
	 */
	public void setLocation(Point location) {
		if(location != null) {
			this.x = location.x;
			this.y = location.y;
		} else {
			this.x = GraphUtil.getMinXCoordinateForNodeGraphType(nodeGraphType);
			this.y = Y_DEFAULT;
		}
	}
}