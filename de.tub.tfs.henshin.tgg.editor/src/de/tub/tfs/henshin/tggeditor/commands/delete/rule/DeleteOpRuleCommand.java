/*******************************************************************************
 *******************************************************************************/
package de.tub.tfs.henshin.tggeditor.commands.delete.rule;

import org.eclipse.emf.henshin.model.IndependentUnit;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.gef.commands.CompoundCommand;

import de.tub.tfs.muvitor.commands.SimpleDeleteEObjectCommand;

/**
 * The class DeleteFTRuleCommand deletes a forward translation rule.
 *
 */
public class DeleteOpRuleCommand extends CompoundCommand {

	private IndependentUnit cont = null;
	private Rule rule;

	/**
	 * Constructor
	 * @param Rule r
	 */
	public DeleteOpRuleCommand(Rule r, String ruleType){
		if (r.eContainer() == null)
			return;
		add(new SimpleDeleteEObjectCommand(r));
		this.rule = r;
	}

	public DeleteOpRuleCommand(Rule r,IndependentUnit container,String ruleType){
		if (r.eContainer() == null)
			return;
		add(new SimpleDeleteEObjectCommand(r));
		this.cont = container;
	}


	
	
	@Override
	public void execute() {
		super.execute();
		if (cont != null)
			cont.getSubUnits().remove(rule);
	}
}
