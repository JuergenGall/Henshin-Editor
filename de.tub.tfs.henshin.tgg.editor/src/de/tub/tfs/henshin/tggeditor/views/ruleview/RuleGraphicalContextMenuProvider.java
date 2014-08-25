/*******************************************************************************
 *******************************************************************************/
package de.tub.tfs.henshin.tggeditor.views.ruleview;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IMenuManager;

import de.tub.tfs.henshin.tggeditor.actions.AbstractTggActionFactory;
import de.tub.tfs.henshin.tggeditor.actions.DeleteNacMappingsAction;
import de.tub.tfs.henshin.tggeditor.actions.EditAttributeAction;
import de.tub.tfs.henshin.tggeditor.actions.create.graph.CreateAttributeAction;
import de.tub.tfs.henshin.tggeditor.actions.create.rule.CreatePrototypeRulesAction;
import de.tub.tfs.henshin.tggeditor.actions.create.rule.CreateRuleAction;
import de.tub.tfs.henshin.tggeditor.actions.create.rule.NewMarkerAction;
import de.tub.tfs.henshin.tggeditor.actions.create.rule.NewMarkerUnspecifiedAction;
import de.tub.tfs.muvitor.ui.ContextMenuProviderWithActionRegistry;

public class RuleGraphicalContextMenuProvider extends
		ContextMenuProviderWithActionRegistry {

	public RuleGraphicalContextMenuProvider(EditPartViewer viewer) {
		super(viewer);
	}

	@Override
	public void buildContextMenu(IMenuManager menu) {		
		String group = GEFActionConstants.GROUP_EDIT;
		dynamicAppendActionToGroup(menu, CreateRuleAction.ID, group);
		dynamicAppendActionToGroup(menu, CreatePrototypeRulesAction.ID, group);
		dynamicAppendActionToGroup(menu, DeleteNacMappingsAction.ID, group);
		dynamicAppendActionToGroup(menu, NewMarkerUnspecifiedAction.ID, group);
		dynamicAppendActionToGroup(menu, NewMarkerAction.ID, group);
		dynamicAppendActionToGroup(menu, CreateAttributeAction.ID, group);
		dynamicAppendActionToGroup(menu, EditAttributeAction.ID, group);
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IExtensionPoint ep = reg.getExtensionPoint("de.tub.tfs.henshin.tgg.editor.graph.actions");
		IExtension[] extensions = ep.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IExtension ext = extensions[i];
			IConfigurationElement[] ce = 
					ext.getConfigurationElements();
			for (int j = 0; j < ce.length; j++) {

				try {
					AbstractTggActionFactory obj = (AbstractTggActionFactory) ce[j].createExecutableExtension("class");

					dynamicAppendActionToGroup(menu,obj.getActionID(),group);

				} catch (CoreException e) {
				}


			}
		}
		
		menu.add(new org.eclipse.jface.action.Separator("de.tub.tfs.henshin.tgg.MoveTripleGraphSep"));
		group = "de.tub.tfs.henshin.tgg.MoveTripleGraphSep";
		
		
	}

}
