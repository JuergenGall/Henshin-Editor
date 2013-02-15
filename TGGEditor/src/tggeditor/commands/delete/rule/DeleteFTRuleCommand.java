package tggeditor.commands.delete.rule;

import java.util.List;

import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.TransformationSystem;
import org.eclipse.gef.commands.CompoundCommand;

import tgg.TGG;
import tgg.TRule;
import tggeditor.util.NodeUtil;

/**
 * The class DeleteFTRuleCommand deletes a forward translation rule.
 *
 */
public class DeleteFTRuleCommand extends CompoundCommand {
		/**
		 * Transformation system
		 */
		private TransformationSystem sys;
		/**
		 * Layout system to which the FT rule belongs.
		 */
		private TGG tgg;
		/**
		 * FT rule
		 */
		private TRule tRule;	
		/**
		 * rule from which the FT rule is derived
		 */
		private Rule rule;

		/**
		 * Constructor
		 * @param Rule r
		 */
		public DeleteFTRuleCommand(Rule r){
			rule = r;
			tRule = getTRule(rule);
			sys = rule.getTransformationSystem();
			tgg= NodeUtil.getLayoutSystem(rule);
			add(new DeleteRuleCommand(rule));
		}

		/**
		 * Returns the FT rule which is derived from the rule
		 * @param rule
		 * @return TRUle
		 */
		private TRule getTRule(Rule rule){
			TGG tgg  = NodeUtil.getLayoutSystem(rule);
			List<TRule> tRules = tgg.getTRules();
			for(TRule tr: tRules){
				if(tr.getRule() == rule)
					return tr;
			}
			return null;
		}
		
		/**
		 * Calculate if it's executable.
		 *  @see org.eclipse.gef.commands.Command#canExecute()
		 */		
		@Override
		public boolean canExecute() {
			return tRule != null && tgg != null && super.canExecute();
		}

		/**
		 * Delete a FT rule from the tgg and the corresponding rule from the transformation system.
		 * @see org.eclipse.gef.commands.CompoundCommand#execute()
		 */
		@Override
		public void execute() {
			tgg.getTRules().remove(tRule);
			sys.getRules().remove(rule); // this is needed to notify the tree viewer of the update
			super.execute();
		}
		

		@Override
		public boolean canUndo() {
			return true;
		}

		/**
		 * Undo delete.
		 * @see org.eclipse.gef.commands.Command#undo()
		 */
		@Override
		public void undo() {
			tgg.getTRules().add(tRule);
			sys.getRules().add(rule); // this is needed to notify the tree viewer of the update
		}
	
		/**
		 * Redo delete.
		 * @see org.eclipse.gef.commands.Command#redo()
		 */
		@Override
		public void redo() {
			execute();
		}
		
}
