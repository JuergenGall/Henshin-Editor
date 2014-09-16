/*
* generated by Xtext
*/
package lu.uni.snt.repeat.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import lu.uni.snt.repeat.services.REPEATGrammarAccess;

public class REPEATParser extends AbstractContentAssistParser {
	
	@Inject
	private REPEATGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected lu.uni.snt.repeat.ui.contentassist.antlr.internal.InternalREPEATParser createParser() {
		lu.uni.snt.repeat.ui.contentassist.antlr.internal.InternalREPEATParser result = new lu.uni.snt.repeat.ui.contentassist.antlr.internal.InternalREPEATParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getStmnt_LST_ElemAccess().getAlternatives_0(), "rule__Stmnt_LST_Elem__Alternatives_0");
					put(grammarAccess.getLog_Expr_TAccess().getAlternatives(), "rule__Log_Expr_T__Alternatives");
					put(grammarAccess.getLog_Expr_UnaryAccess().getAlternatives(), "rule__Log_Expr_Unary__Alternatives");
					put(grammarAccess.getLog_Expr_BinaryAccess().getOperatorAlternatives_2_0(), "rule__Log_Expr_Binary__OperatorAlternatives_2_0");
					put(grammarAccess.getSourceAccess().getAlternatives(), "rule__Source__Alternatives");
					put(grammarAccess.getStmnt_LST_ElemAccess().getGroup(), "rule__Stmnt_LST_Elem__Group__0");
					put(grammarAccess.getRepeatAccess().getGroup(), "rule__Repeat__Group__0");
					put(grammarAccess.getAsgAccess().getGroup(), "rule__Asg__Group__0");
					put(grammarAccess.getReadAccess().getGroup(), "rule__Read__Group__0");
					put(grammarAccess.getCommentAccess().getGroup(), "rule__Comment__Group__0");
					put(grammarAccess.getLog_Expr_BinaryAccess().getGroup(), "rule__Log_Expr_Binary__Group__0");
					put(grammarAccess.getLog_NegAccess().getGroup(), "rule__Log_Neg__Group__0");
					put(grammarAccess.getRProgramAccess().getFstAssignment(), "rule__RProgram__FstAssignment");
					put(grammarAccess.getStmnt_LST_ElemAccess().getNextAssignment_1(), "rule__Stmnt_LST_Elem__NextAssignment_1");
					put(grammarAccess.getRepeatAccess().getStmntAssignment_1(), "rule__Repeat__StmntAssignment_1");
					put(grammarAccess.getRepeatAccess().getExprAssignment_3(), "rule__Repeat__ExprAssignment_3");
					put(grammarAccess.getAsgAccess().getLeftAssignment_0(), "rule__Asg__LeftAssignment_0");
					put(grammarAccess.getAsgAccess().getRightAssignment_2(), "rule__Asg__RightAssignment_2");
					put(grammarAccess.getReadAccess().getParamAssignment_1(), "rule__Read__ParamAssignment_1");
					put(grammarAccess.getCommentAccess().getCommentAssignment_1(), "rule__Comment__CommentAssignment_1");
					put(grammarAccess.getLog_ExprAccess().getTypeAssignment(), "rule__Log_Expr__TypeAssignment");
					put(grammarAccess.getLog_Expr_BinaryAccess().getFstAssignment_1(), "rule__Log_Expr_Binary__FstAssignment_1");
					put(grammarAccess.getLog_Expr_BinaryAccess().getOperatorAssignment_2(), "rule__Log_Expr_Binary__OperatorAssignment_2");
					put(grammarAccess.getLog_Expr_BinaryAccess().getSndAssignment_3(), "rule__Log_Expr_Binary__SndAssignment_3");
					put(grammarAccess.getLog_NegAccess().getExprAssignment_1(), "rule__Log_Neg__ExprAssignment_1");
					put(grammarAccess.getSymAccess().getSymAssignment(), "rule__Sym__SymAssignment");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			lu.uni.snt.repeat.ui.contentassist.antlr.internal.InternalREPEATParser typedParser = (lu.uni.snt.repeat.ui.contentassist.antlr.internal.InternalREPEATParser) parser;
			typedParser.entryRuleRProgram();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public REPEATGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(REPEATGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
