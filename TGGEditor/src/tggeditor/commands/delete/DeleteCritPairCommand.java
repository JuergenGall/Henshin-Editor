package tggeditor.commands.delete;

import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.TransformationSystem;
import org.eclipse.gef.commands.CompoundCommand;

import tgg.CritPair;
import tgg.TGG;
import tggeditor.util.NodeUtil;
import de.tub.tfs.muvitor.commands.SimpleDeleteEObjectCommand;

public class DeleteCritPairCommand extends CompoundCommand {

	private CritPair _critPair;
	private TGG _tgg;
	private TransformationSystem _trafo;
	
	public DeleteCritPairCommand(CritPair critPair) {
		this._critPair = critPair;
		if (critPair.eContainer() != null && critPair.eContainer() instanceof TGG) {
			_tgg = (TGG) critPair.eContainer();
		}
		_trafo = critPair.getRule1().getTransformationSystem();
		
		add(new SimpleDeleteEObjectCommand(critPair));
	}
	
	public void execute() {
		
		// CritPair von tgg entfernen
		_tgg.getCritPairs().remove(_critPair);		
		//overlapping aus Instanzen des Trafo entfernen
		_trafo.getInstances().remove(_critPair.getOverlapping());
		
		
		super.execute();
	}
}
