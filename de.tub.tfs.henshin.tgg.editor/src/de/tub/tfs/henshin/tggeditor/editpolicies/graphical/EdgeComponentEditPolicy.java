/*******************************************************************************
 * Copyright (c) 2012, 2013 Henshin developers.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Henshin developers - initial API and implementation
 *******************************************************************************/
package de.tub.tfs.henshin.tggeditor.editpolicies.graphical;


import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import de.tub.tfs.henshin.tggeditor.commands.delete.DeleteEdgeCommand;


public class EdgeComponentEditPolicy extends ComponentEditPolicy implements
		EditPolicy {
	
	@Override
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		final Edge edge = (Edge) getHost().getModel();

		return new DeleteEdgeCommand(edge);
	}

}
