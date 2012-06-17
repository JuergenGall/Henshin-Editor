package tggeditor.views.graphview;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.TransformationSystem;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.ui.actions.ActionFactory;

import tggeditor.actions.create.graph.CreateAttributeAction;
import tggeditor.editparts.graphical.GraphicalEditPartFactory;
import de.tub.tfs.muvitor.gef.palette.MuvitorPaletteRoot;
import de.tub.tfs.muvitor.ui.ContextMenuProviderWithActionRegistry;
import de.tub.tfs.muvitor.ui.MuvitorPage;
import de.tub.tfs.muvitor.ui.MuvitorPageBookView;

public class GraphicalPage extends MuvitorPage {

	private GraphicalPaletteRoot graphPaletteRoot;

	public GraphicalPage(MuvitorPageBookView view) {
		super(view);
	}

	@Override
	protected ContextMenuProviderWithActionRegistry createContextMenuProvider(
			EditPartViewer viewer) {
		return new GraphicalContextMenuProvider(viewer);
	}

	@Override
	protected void createCustomActions() {
		registerAction(new CreateAttributeAction(getEditor()));
        registerSharedActionAsHandler(ActionFactory.COPY.getId());
        registerSharedActionAsHandler(ActionFactory.CUT.getId());
        registerSharedActionAsHandler(ActionFactory.PASTE.getId()); 
	}

	@Override
	protected EditPartFactory createEditPartFactory() {
		return new GraphicalEditPartFactory();
	}

	@Override
	protected MuvitorPaletteRoot createPaletteRoot() {
		EObject parent = getCastedModel().eContainer();
		while (parent != null && !(parent instanceof TransformationSystem)) {
			parent = parent.eContainer();
		}

		if (parent != null && parent instanceof TransformationSystem) {
			graphPaletteRoot = new GraphicalPaletteRoot(
					(TransformationSystem) parent);
		}
		return graphPaletteRoot;
	}

	@Override
	protected EObject[] getViewerContents() {
		return new EObject[] { getModel() };
	}

	@Override
	protected void setupKeyHandler(KeyHandler kh) {
		// TODO Auto-generated method stub

	}

	public Graph getCastedModel() {
		return (Graph) getModel();
	}
}