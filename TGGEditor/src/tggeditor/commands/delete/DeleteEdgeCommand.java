package tggeditor.commands.delete;

import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.gef.commands.CompoundCommand;

import tgg.EdgeLayout;
import tgg.TGG;
import tggeditor.util.EdgeUtil;
import tggeditor.util.NodeUtil;

import de.tub.tfs.muvitor.commands.SimpleDeleteEObjectCommand;

/**
 * The class DeleteEdgeCommand deletes a edge in a graph and its layout.
 */
public class DeleteEdgeCommand extends CompoundCommand {

	/** The edge. */
	private Edge edge;
	
	/** The graph. */
	private Graph graph;
	
	/** The source. */
	private Node source;
	
	/** The target. */
	private Node target;
	
	/**
	 * The edge layout.
	 */
	private EdgeLayout edgeLayout;
	/**
	 * Whether the edge was deleted by this command.
	 */
	private boolean edgeDeletionPerformed;
	
	/**
	 * Instantiates a new delete edge command.
	 *
	 * @param edge the already created, but new, edge
	 */
	public DeleteEdgeCommand(Edge edge) {
		if (edge != null) {
			this.edge = edge;
			this.graph = edge.getGraph();
			this.source = edge.getSource();
			this.target = edge.getTarget();	
			edgeDeletionPerformed=false;
			

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.CompoundCommand#execute()
	 */
	@Override
	public void execute() {
			// if edge is still existing when this command shall be executed, then perform the deletion commands
			if (edge.getGraph()!=null){
				source.getOutgoing().remove(edge);
				target.getIncoming().remove(edge);
				add(new SimpleDeleteEObjectCommand(edge));
				TGG layoutSystem=NodeUtil.getLayoutSystem(source.getGraph());
				if (layoutSystem!=null){
					edgeLayout = EdgeUtil.getEdgeLayout(edge, layoutSystem);
					add(new SimpleDeleteEObjectCommand(edgeLayout));
				}
				edgeDeletionPerformed=true;				
			}
			super.execute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.CompoundCommand#canExecute()
	 */
	@Override
	public boolean canExecute() {
		if (graph != null && edge != null && source != null
				&& target != null)
		return true;
		else return false;
	}

	@Override
	public boolean canUndo() {
		// return super.canUndo();
		if (graph != null && edge != null && source != null
				&& target != null)
		return true;
		else return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.CompoundCommand#undo()
	 */
	@Override
	public void undo() {
		super.undo();
		if (edgeDeletionPerformed){
			source.getOutgoing().add(edge);
			target.getIncoming().add(edge);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.CompoundCommand#redo()
	 */
	@Override
	public void redo() {
	execute();
	super.redo();
	}
}