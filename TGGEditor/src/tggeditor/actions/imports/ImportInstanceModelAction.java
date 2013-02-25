package tggeditor.actions.imports;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.FeatureMapUtil.FeatureEList;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.NamedElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import tgg.GraphLayout;
//import de.tub.tfs.henshin.editor.editparts.tree.SimpleListTreeEditpart;
import tggeditor.editparts.tree.TransformationSystemTreeEditPart;
import tggeditor.editparts.tree.graphical.GraphFolderTreeEditPart;
import tggeditor.util.GraphUtil;
//import de.tub.tfs.henshin.editor.util.IconUtil;

public class ImportInstanceModelAction extends SelectionAction {

	/** The Constant ID. */
	public static final String ID = "tggeditor.actions.ImportInstanceModelAction";

	/** the shell of the dialog */
	protected Shell shell;
	
	/** the transformation system, in which the instance shall be included */
	protected Module module;
	
	/** the URIs for the files to import */
	protected List<URI> urIs;
	
	/** the mapping between henshinGraph and instanceGraph  */
	protected HashMap<EObject,Node> instanceGraphToHenshinGraphMapping;
	
	/** the current object of the instance graph */
	protected EObject eObj;

	/** the current node of the henshin graph */
	protected Node node;

	/** the graph to be created in henshin*/
	protected Graph graph;
	
	public ImportInstanceModelAction(IWorkbenchPart part) {
		super(part);
		setId(ID);
		setText("Import an instance model.");
//		setImageDescriptor(IconUtil.getDescriptor("attr16.png"));
		setToolTipText("Import an instance model.");
	}

	@Override
	protected boolean calculateEnabled() {
		List<?> selectedObjs = getSelectedObjects();
		if (selectedObjs.size() != 1) {
			return false;
		}

		Object selected = selectedObjs.get(0);
		if (selected instanceof TransformationSystemTreeEditPart) {
			TransformationSystemTreeEditPart host = (TransformationSystemTreeEditPart) selected;
				module = (Module) host.getModel();
				return true;
		}
		else if (selected instanceof GraphFolderTreeEditPart) {
			GraphFolderTreeEditPart graphFolder = (GraphFolderTreeEditPart) selected;
			TransformationSystemTreeEditPart host = (TransformationSystemTreeEditPart) graphFolder.getParent();
				module = (Module) host.getModel();
				return true;
		}

		return false;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		instanceGraphToHenshinGraphMapping = new HashMap<EObject, Node>();

		boolean dialogSuccess = openImportDialog();
		if (!dialogSuccess)
			return;

		long startTime = System.currentTimeMillis();
		System.out.println("DEBUG: start instance import ");
		for (URI uri : urIs) {
			ResourceImpl r = (ResourceImpl) module.eResource()
					.getResourceSet().getResource(uri, true);
			r.unload();
			try {
				r.load(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			graph = HenshinFactory.eINSTANCE.createGraph();
			// HenshinGraph henshinGraph = new HenshinGraph(graph);

			if (r.getContents().isEmpty())
				continue;
			TreeIterator<EObject> itr = r.getAllContents();
			graph.setName(uri.segment(uri.segmentCount() - 1));
			
			
			
			// import all nodes without features first (otherwise, references
			// could be dangling)
			long amountNodes = 0;
			while (itr.hasNext()) {
				eObj = itr.next();
				createNode();
				amountNodes++;
			}



			
			itr = r.getAllContents();
			while (itr.hasNext()) {
				eObj = itr.next();
				// get node that was created in the loop before
				node = instanceGraphToHenshinGraphMapping.get(eObj);

				// iterate over all features of that node
				for (EStructuralFeature feat : eObj.eClass()
						.getEAllStructuralFeatures()) {
					// import references
					if (feat instanceof EReference) {
						createEdge((EReference) feat);
					}
					// import attribute values
					else if (feat instanceof EAttribute) {
						createAttribute((EAttribute) feat);
					}
				}
			}
			System.out
					.println("DEBUG: end instance import "
							+ ((System.currentTimeMillis() - startTime) / 1000d)
							+ " s");
			startTime = System.currentTimeMillis();
			module.getInstances().add(graph);
			
			// extend source component to rectangle with edge length sqrt(n) times 40 pixels per horizontal node, n is amount of nodes
			GraphLayout dividerSC = GraphUtil.getGraphLayout(graph, true);
			GraphLayout dividerCT = GraphUtil.getGraphLayout(graph, false);
			if(dividerSC!= null && dividerCT != null){
				double width = 350 + 200 * Math.sqrt((double)amountNodes);
				dividerCT.setDividerX((int) (width+200) );
				dividerSC.setDividerX((int) width );
			}
			
			System.out
					.println("DEBUG: graph added "
							+ ((System.currentTimeMillis() - startTime) / 1000d)
							+ " s");

		}

		shell.dispose();
		super.run();
	}

	/**
	 * @return
	 */
	protected boolean openImportDialog() {
		shell = new Shell();
		ResourceDialog dialog = new ResourceDialog(shell, "Please select the instance model you want to load.", SWT.OPEN + SWT.MULTI);
		
		int p = dialog.open();
		if (p == 1 || p == SWT.CANCEL){
			MessageDialog.open(SWT.ERROR, PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage()
						.getActivePart().getSite().getShell(), "No File selected.", "Please select a valid emf file to load an instance model.",SWT.SHEET );
			return false;
		}
		urIs = dialog.getURIs();
		if (urIs.isEmpty()){
			MessageDialog.open(SWT.ERROR, PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage()
						.getActivePart().getSite().getShell(), "No File selected.", "Please select a valid emf file to load an instance model.",SWT.SHEET );
			return false;
		}
		return true;
	}

	/**
	 * @param feat
	 */
	protected void createAttribute(EAttribute feat) {
		Attribute attr;
		if (feat.getEType().getName().equals("EFeatureMapEntry"))
			// do nothing, because this map summarizes all features
			return;

		if (!eObj.eIsSet(feat)) 
			// no value available, thus do not create an attribute
			return;

		// value is available
		
		// process attribute
		attr = HenshinFactory.eINSTANCE.createAttribute();
		attr.setNode(node);
		attr.setType((EAttribute) feat);

		if (attr.getType().getName().contains("name")
				&& !(eObj instanceof NamedElement)) {
			node.setName(attr.getValue());
		}

		if (feat.isMany()) {
			if (eObj.eIsSet(feat)) {
				// value of feature is set
				String valueString = eObj.eGet(feat).toString();
				// remove the square brackets of the array
				// TODO: remove only if the list contains one element
				if (valueString.length() > 1) {
					valueString = valueString.substring(1,
							valueString.length() - 1);
				}
				attr.setValue(valueString);
			} 
		} else if (eObj.eIsSet(feat)) {
			// feature is single valued
			attr.setValue(eObj.eGet(feat).toString());
		}
	}

	/**
	 * @param feat
	 */
	protected void createEdge(EReference feat) {
		if (eObj.eIsSet(feat)) {
			if (feat.isMany()) {
				List<EObject> list = (List<EObject>) eObj.eGet(feat);
				for (EObject ref : list) {
					Edge edge = HenshinFactory.eINSTANCE.createEdge();
					edge.setSource(node);
					if (instanceGraphToHenshinGraphMapping.containsKey(ref)) {
						edge.setTarget(instanceGraphToHenshinGraphMapping
								.get(ref));
					} else {
						edge.setTarget(createTargetNode(ref, graph));
					}
					edge.setType((EReference) feat);
					graph.getEdges().add(edge);
				}
			} else {
				EObject ref = (EObject) eObj.eGet(feat);
				Edge edge = HenshinFactory.eINSTANCE.createEdge();
				edge.setSource(node);
				if (instanceGraphToHenshinGraphMapping.containsKey(ref)) {
					edge.setTarget(instanceGraphToHenshinGraphMapping.get(ref));
				} else {
					edge.setTarget(createTargetNode(ref, graph));
				}
				edge.setType((EReference) feat);
				graph.getEdges().add(edge);
			}
		}
	}

	/**
	 */
	protected void createNode() {
		//henshinGraph.addEObject(eObj);
		Node node = HenshinFactory.eINSTANCE.createNode();
		node.setType(eObj.eClass());
		/*if (eObj instanceof NamedElement){
			node.setName(((NamedElement)eObj).getName());
		} else {
			node.setName("_DEBUG:_" + eObj.toString() + "_");
		}*/
		node.setName("");
		instanceGraphToHenshinGraphMapping.put(eObj, node);
		graph.getNodes().add(node);
	}

	protected HashMap<Graph, HashMap<EObject,Node>> graphToNodeMap = new HashMap<Graph, HashMap<EObject,Node>>();
	protected Node createTargetNode(EObject ref,Graph graph) {
		HashMap<EObject, Node> map = graphToNodeMap.get(graph);
		if (map == null)
			graphToNodeMap.put(graph, map = new HashMap<EObject, Node>());
		Node node = map.get(ref);
		if (node == null){
			node = HenshinFactory.eINSTANCE.createNode();
			node.setType(ref.eClass());
			node.setName(ref.toString());
			graph.getNodes().add(node);
			map.put(ref, node);
		}
		return node;
	}
}