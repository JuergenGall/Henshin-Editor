/**
 * MoveSubtreeCommand.java
 * created on 15.07.2012 12:20:24
 */
package de.tub.tfs.henshin.editor.commands.graph;

import org.eclipse.gef.commands.Command;

import de.tub.tfs.henshin.model.layout.NodeLayout;

/**
 * @author huuloi
 *
 */
public class MoveSubtreeCommand extends Command {

	private NodeLayout nodeLayout;
	
	private int oldX;
	
	private int oldY;
	
	private int x;
	
	private int y;

	public MoveSubtreeCommand(NodeLayout nodeLayout, int x, int y) {
		this.nodeLayout = nodeLayout;
		this.x = nodeLayout.getX() + x;
		this.y = nodeLayout.getY() + y;
	}
	
	@Override
	public void execute() {
		oldX = nodeLayout.getX();
		oldY = nodeLayout.getY();

		nodeLayout.setX(x);
		nodeLayout.setY(y);
	}
	
	@Override
	public void undo() {
		nodeLayout.setX(oldX);
		nodeLayout.setY(oldY);
	}
	
	@Override
	public void redo() {
		execute();
	}
}
