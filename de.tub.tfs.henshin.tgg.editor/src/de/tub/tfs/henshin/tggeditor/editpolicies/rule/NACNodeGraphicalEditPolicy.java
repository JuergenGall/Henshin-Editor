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
package de.tub.tfs.henshin.tggeditor.editpolicies.rule;

import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;

import de.tub.tfs.henshin.tggeditor.editpolicies.graphical.NodeGraphicalEditPolicy;


public class NACNodeGraphicalEditPolicy extends NodeGraphicalEditPolicy {

	@Override
	protected Command getConnectionCreateCommand(final CreateConnectionRequest request) {
		final Object requestingObject = request.getNewObject();
		if(requestingObject instanceof Mapping){
			//??????????????????????
		//	if(getCastedModel().eContainer() instanceof NestedCondition){
				
			}
		//}
		return super.getConnectionCreateCommand(request);
	}

	
}
