/*******************************************************************************
 *******************************************************************************/
package de.tub.tfs.henshin.tggeditor.actions.execution;

import de.tub.tfs.henshin.tggeditor.views.graphview.GraphicalPage;
import de.tub.tfs.muvitor.ui.MuvitorPageBookView;

public class ExecuteCCRulesToolBarAction extends ExecuteCCRulesAction {
	
	/**
	 * Instantiates a new execute rule tool bar rule action.
	 *
	 * @param part the part
	 * @param page the graph page
	 */
	public ExecuteCCRulesToolBarAction(MuvitorPageBookView part, GraphicalPage page) {
		super(part.getEditor());
		graph=page.getCastedModel();
	}
	
	/* (non-Javadoc)
	 * @see tggeditor.actions.execution.ExecuteFTRulesAction#calculateEnabled()
	 */
	@Override
	protected boolean calculateEnabled() {
		return true;
	}
	


}
