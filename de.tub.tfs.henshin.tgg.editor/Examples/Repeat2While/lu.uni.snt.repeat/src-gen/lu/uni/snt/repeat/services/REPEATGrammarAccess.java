/*
* generated by Xtext
*/
package lu.uni.snt.repeat.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class REPEATGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class RProgramElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RProgram");
		private final Assignment cFstAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cFstStmnt_LST_ElemParserRuleCall_0 = (RuleCall)cFstAssignment.eContents().get(0);
		
		//RProgram:
		//	fst=Stmnt_LST_Elem;
		public ParserRule getRule() { return rule; }

		//fst=Stmnt_LST_Elem
		public Assignment getFstAssignment() { return cFstAssignment; }

		//Stmnt_LST_Elem
		public RuleCall getFstStmnt_LST_ElemParserRuleCall_0() { return cFstStmnt_LST_ElemParserRuleCall_0; }
	}

	public class Stmnt_LST_ElemElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Stmnt_LST_Elem");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final RuleCall cRepeatParserRuleCall_0_0 = (RuleCall)cAlternatives_0.eContents().get(0);
		private final RuleCall cAsgParserRuleCall_0_1 = (RuleCall)cAlternatives_0.eContents().get(1);
		private final RuleCall cReadParserRuleCall_0_2 = (RuleCall)cAlternatives_0.eContents().get(2);
		private final RuleCall cCommentParserRuleCall_0_3 = (RuleCall)cAlternatives_0.eContents().get(3);
		private final Assignment cNextAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNextStmnt_LST_ElemParserRuleCall_1_0 = (RuleCall)cNextAssignment_1.eContents().get(0);
		
		//Stmnt_LST_Elem:
		//	(Repeat | Asg | Read | Comment) next=Stmnt_LST_Elem?;
		public ParserRule getRule() { return rule; }

		//(Repeat | Asg | Read | Comment) next=Stmnt_LST_Elem?
		public Group getGroup() { return cGroup; }

		//Repeat | Asg | Read | Comment
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//Repeat
		public RuleCall getRepeatParserRuleCall_0_0() { return cRepeatParserRuleCall_0_0; }

		//Asg
		public RuleCall getAsgParserRuleCall_0_1() { return cAsgParserRuleCall_0_1; }

		//Read
		public RuleCall getReadParserRuleCall_0_2() { return cReadParserRuleCall_0_2; }

		//Comment
		public RuleCall getCommentParserRuleCall_0_3() { return cCommentParserRuleCall_0_3; }

		//next=Stmnt_LST_Elem?
		public Assignment getNextAssignment_1() { return cNextAssignment_1; }

		//Stmnt_LST_Elem
		public RuleCall getNextStmnt_LST_ElemParserRuleCall_1_0() { return cNextStmnt_LST_ElemParserRuleCall_1_0; }
	}

	public class RepeatElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Repeat");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cREPEATKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cStmntAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cStmntStmnt_LST_ElemParserRuleCall_1_0 = (RuleCall)cStmntAssignment_1.eContents().get(0);
		private final Keyword cUNTILKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cExprAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cExprLog_ExprParserRuleCall_3_0 = (RuleCall)cExprAssignment_3.eContents().get(0);
		
		//Repeat:
		//	"REPEAT" stmnt=Stmnt_LST_Elem "UNTIL" expr=Log_Expr;
		public ParserRule getRule() { return rule; }

		//"REPEAT" stmnt=Stmnt_LST_Elem "UNTIL" expr=Log_Expr
		public Group getGroup() { return cGroup; }

		//"REPEAT"
		public Keyword getREPEATKeyword_0() { return cREPEATKeyword_0; }

		//stmnt=Stmnt_LST_Elem
		public Assignment getStmntAssignment_1() { return cStmntAssignment_1; }

		//Stmnt_LST_Elem
		public RuleCall getStmntStmnt_LST_ElemParserRuleCall_1_0() { return cStmntStmnt_LST_ElemParserRuleCall_1_0; }

		//"UNTIL"
		public Keyword getUNTILKeyword_2() { return cUNTILKeyword_2; }

		//expr=Log_Expr
		public Assignment getExprAssignment_3() { return cExprAssignment_3; }

		//Log_Expr
		public RuleCall getExprLog_ExprParserRuleCall_3_0() { return cExprLog_ExprParserRuleCall_3_0; }
	}

	public class AsgElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Asg");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cLeftAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cLeftSymParserRuleCall_0_0 = (RuleCall)cLeftAssignment_0.eContents().get(0);
		private final Keyword cColonEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRightAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cRightSymParserRuleCall_2_0 = (RuleCall)cRightAssignment_2.eContents().get(0);
		
		//Asg:
		//	left=Sym ":=" right=Sym;
		public ParserRule getRule() { return rule; }

		//left=Sym ":=" right=Sym
		public Group getGroup() { return cGroup; }

		//left=Sym
		public Assignment getLeftAssignment_0() { return cLeftAssignment_0; }

		//Sym
		public RuleCall getLeftSymParserRuleCall_0_0() { return cLeftSymParserRuleCall_0_0; }

		//":="
		public Keyword getColonEqualsSignKeyword_1() { return cColonEqualsSignKeyword_1; }

		//right=Sym
		public Assignment getRightAssignment_2() { return cRightAssignment_2; }

		//Sym
		public RuleCall getRightSymParserRuleCall_2_0() { return cRightSymParserRuleCall_2_0; }
	}

	public class ReadElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Read");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cREADKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cParamAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cParamSymParserRuleCall_1_0 = (RuleCall)cParamAssignment_1.eContents().get(0);
		
		//Read:
		//	"READ" param=Sym;
		public ParserRule getRule() { return rule; }

		//"READ" param=Sym
		public Group getGroup() { return cGroup; }

		//"READ"
		public Keyword getREADKeyword_0() { return cREADKeyword_0; }

		//param=Sym
		public Assignment getParamAssignment_1() { return cParamAssignment_1; }

		//Sym
		public RuleCall getParamSymParserRuleCall_1_0() { return cParamSymParserRuleCall_1_0; }
	}

	public class CommentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Comment");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSolidusNumberSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cCommentAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cCommentSTRINGTerminalRuleCall_1_0 = (RuleCall)cCommentAssignment_1.eContents().get(0);
		private final Keyword cNumberSignSolidusKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//Comment:
		//	"/#" comment=STRING "#/";
		public ParserRule getRule() { return rule; }

		//"/#" comment=STRING "#/"
		public Group getGroup() { return cGroup; }

		//"/#"
		public Keyword getSolidusNumberSignKeyword_0() { return cSolidusNumberSignKeyword_0; }

		//comment=STRING
		public Assignment getCommentAssignment_1() { return cCommentAssignment_1; }

		//STRING
		public RuleCall getCommentSTRINGTerminalRuleCall_1_0() { return cCommentSTRINGTerminalRuleCall_1_0; }

		//"#/"
		public Keyword getNumberSignSolidusKeyword_2() { return cNumberSignSolidusKeyword_2; }
	}

	public class Log_ExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Log_Expr");
		private final Assignment cTypeAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cTypeLog_Expr_TParserRuleCall_0 = (RuleCall)cTypeAssignment.eContents().get(0);
		
		//Log_Expr:
		//	type=Log_Expr_T;
		public ParserRule getRule() { return rule; }

		//type=Log_Expr_T
		public Assignment getTypeAssignment() { return cTypeAssignment; }

		//Log_Expr_T
		public RuleCall getTypeLog_Expr_TParserRuleCall_0() { return cTypeLog_Expr_TParserRuleCall_0; }
	}

	public class Log_Expr_TElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Log_Expr_T");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cLog_Expr_UnaryParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cLog_Expr_BinaryParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Log_Expr_T:
		//	Log_Expr_Unary | Log_Expr_Binary;
		public ParserRule getRule() { return rule; }

		//Log_Expr_Unary | Log_Expr_Binary
		public Alternatives getAlternatives() { return cAlternatives; }

		//Log_Expr_Unary
		public RuleCall getLog_Expr_UnaryParserRuleCall_0() { return cLog_Expr_UnaryParserRuleCall_0; }

		//Log_Expr_Binary
		public RuleCall getLog_Expr_BinaryParserRuleCall_1() { return cLog_Expr_BinaryParserRuleCall_1; }
	}

	public class Log_Expr_UnaryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Log_Expr_Unary");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cLog_NegParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cSymParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Log_Expr_Unary:
		//	Log_Neg | Sym;
		public ParserRule getRule() { return rule; }

		//Log_Neg | Sym
		public Alternatives getAlternatives() { return cAlternatives; }

		//Log_Neg
		public RuleCall getLog_NegParserRuleCall_0() { return cLog_NegParserRuleCall_0; }

		//Sym
		public RuleCall getSymParserRuleCall_1() { return cSymParserRuleCall_1; }
	}

	public class Log_Expr_BinaryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Log_Expr_Binary");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cFstAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cFstLog_ExprParserRuleCall_1_0 = (RuleCall)cFstAssignment_1.eContents().get(0);
		private final Assignment cOperatorAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Alternatives cOperatorAlternatives_2_0 = (Alternatives)cOperatorAssignment_2.eContents().get(0);
		private final Keyword cOperatorANDKeyword_2_0_0 = (Keyword)cOperatorAlternatives_2_0.eContents().get(0);
		private final Keyword cOperatorORKeyword_2_0_1 = (Keyword)cOperatorAlternatives_2_0.eContents().get(1);
		private final Keyword cOperatorEQKeyword_2_0_2 = (Keyword)cOperatorAlternatives_2_0.eContents().get(2);
		private final Assignment cSndAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cSndLog_ExprParserRuleCall_3_0 = (RuleCall)cSndAssignment_3.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//Log_Expr_Binary:
		//	"(" fst=Log_Expr operator=("AND" | "OR" | "EQ") snd=Log_Expr ")";
		public ParserRule getRule() { return rule; }

		//"(" fst=Log_Expr operator=("AND" | "OR" | "EQ") snd=Log_Expr ")"
		public Group getGroup() { return cGroup; }

		//"("
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }

		//fst=Log_Expr
		public Assignment getFstAssignment_1() { return cFstAssignment_1; }

		//Log_Expr
		public RuleCall getFstLog_ExprParserRuleCall_1_0() { return cFstLog_ExprParserRuleCall_1_0; }

		//operator=("AND" | "OR" | "EQ")
		public Assignment getOperatorAssignment_2() { return cOperatorAssignment_2; }

		//"AND" | "OR" | "EQ"
		public Alternatives getOperatorAlternatives_2_0() { return cOperatorAlternatives_2_0; }

		//"AND"
		public Keyword getOperatorANDKeyword_2_0_0() { return cOperatorANDKeyword_2_0_0; }

		//"OR"
		public Keyword getOperatorORKeyword_2_0_1() { return cOperatorORKeyword_2_0_1; }

		//"EQ"
		public Keyword getOperatorEQKeyword_2_0_2() { return cOperatorEQKeyword_2_0_2; }

		//snd=Log_Expr
		public Assignment getSndAssignment_3() { return cSndAssignment_3; }

		//Log_Expr
		public RuleCall getSndLog_ExprParserRuleCall_3_0() { return cSndLog_ExprParserRuleCall_3_0; }

		//")"
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
	}

	public class Log_NegElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Log_Neg");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cNOTKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cExprAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExprLog_ExprParserRuleCall_1_0 = (RuleCall)cExprAssignment_1.eContents().get(0);
		
		//Log_Neg:
		//	"NOT" expr=Log_Expr;
		public ParserRule getRule() { return rule; }

		//"NOT" expr=Log_Expr
		public Group getGroup() { return cGroup; }

		//"NOT"
		public Keyword getNOTKeyword_0() { return cNOTKeyword_0; }

		//expr=Log_Expr
		public Assignment getExprAssignment_1() { return cExprAssignment_1; }

		//Log_Expr
		public RuleCall getExprLog_ExprParserRuleCall_1_0() { return cExprLog_ExprParserRuleCall_1_0; }
	}

	public class SymElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Sym");
		private final Assignment cSymAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cSymIDTerminalRuleCall_0 = (RuleCall)cSymAssignment.eContents().get(0);
		
		//Sym:
		//	sym=ID;
		public ParserRule getRule() { return rule; }

		//sym=ID
		public Assignment getSymAssignment() { return cSymAssignment; }

		//ID
		public RuleCall getSymIDTerminalRuleCall_0() { return cSymIDTerminalRuleCall_0; }
	}

	public class SourceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Source");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cRProgramParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cStmnt_LST_ElemParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cLog_ExprParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cLog_Expr_TParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//Source:
		//	RProgram | Stmnt_LST_Elem | Log_Expr | Log_Expr_T;
		public ParserRule getRule() { return rule; }

		//RProgram | Stmnt_LST_Elem | Log_Expr | Log_Expr_T
		public Alternatives getAlternatives() { return cAlternatives; }

		//RProgram
		public RuleCall getRProgramParserRuleCall_0() { return cRProgramParserRuleCall_0; }

		//Stmnt_LST_Elem
		public RuleCall getStmnt_LST_ElemParserRuleCall_1() { return cStmnt_LST_ElemParserRuleCall_1; }

		//Log_Expr
		public RuleCall getLog_ExprParserRuleCall_2() { return cLog_ExprParserRuleCall_2; }

		//Log_Expr_T
		public RuleCall getLog_Expr_TParserRuleCall_3() { return cLog_Expr_TParserRuleCall_3; }
	}
	
	
	private RProgramElements pRProgram;
	private Stmnt_LST_ElemElements pStmnt_LST_Elem;
	private RepeatElements pRepeat;
	private AsgElements pAsg;
	private ReadElements pRead;
	private CommentElements pComment;
	private Log_ExprElements pLog_Expr;
	private Log_Expr_TElements pLog_Expr_T;
	private Log_Expr_UnaryElements pLog_Expr_Unary;
	private Log_Expr_BinaryElements pLog_Expr_Binary;
	private Log_NegElements pLog_Neg;
	private SymElements pSym;
	private SourceElements pSource;
	
	private final Grammar grammar;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public REPEATGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("lu.uni.snt.repeat.REPEAT".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//RProgram:
	//	fst=Stmnt_LST_Elem;
	public RProgramElements getRProgramAccess() {
		return (pRProgram != null) ? pRProgram : (pRProgram = new RProgramElements());
	}
	
	public ParserRule getRProgramRule() {
		return getRProgramAccess().getRule();
	}

	//Stmnt_LST_Elem:
	//	(Repeat | Asg | Read | Comment) next=Stmnt_LST_Elem?;
	public Stmnt_LST_ElemElements getStmnt_LST_ElemAccess() {
		return (pStmnt_LST_Elem != null) ? pStmnt_LST_Elem : (pStmnt_LST_Elem = new Stmnt_LST_ElemElements());
	}
	
	public ParserRule getStmnt_LST_ElemRule() {
		return getStmnt_LST_ElemAccess().getRule();
	}

	//Repeat:
	//	"REPEAT" stmnt=Stmnt_LST_Elem "UNTIL" expr=Log_Expr;
	public RepeatElements getRepeatAccess() {
		return (pRepeat != null) ? pRepeat : (pRepeat = new RepeatElements());
	}
	
	public ParserRule getRepeatRule() {
		return getRepeatAccess().getRule();
	}

	//Asg:
	//	left=Sym ":=" right=Sym;
	public AsgElements getAsgAccess() {
		return (pAsg != null) ? pAsg : (pAsg = new AsgElements());
	}
	
	public ParserRule getAsgRule() {
		return getAsgAccess().getRule();
	}

	//Read:
	//	"READ" param=Sym;
	public ReadElements getReadAccess() {
		return (pRead != null) ? pRead : (pRead = new ReadElements());
	}
	
	public ParserRule getReadRule() {
		return getReadAccess().getRule();
	}

	//Comment:
	//	"/#" comment=STRING "#/";
	public CommentElements getCommentAccess() {
		return (pComment != null) ? pComment : (pComment = new CommentElements());
	}
	
	public ParserRule getCommentRule() {
		return getCommentAccess().getRule();
	}

	//Log_Expr:
	//	type=Log_Expr_T;
	public Log_ExprElements getLog_ExprAccess() {
		return (pLog_Expr != null) ? pLog_Expr : (pLog_Expr = new Log_ExprElements());
	}
	
	public ParserRule getLog_ExprRule() {
		return getLog_ExprAccess().getRule();
	}

	//Log_Expr_T:
	//	Log_Expr_Unary | Log_Expr_Binary;
	public Log_Expr_TElements getLog_Expr_TAccess() {
		return (pLog_Expr_T != null) ? pLog_Expr_T : (pLog_Expr_T = new Log_Expr_TElements());
	}
	
	public ParserRule getLog_Expr_TRule() {
		return getLog_Expr_TAccess().getRule();
	}

	//Log_Expr_Unary:
	//	Log_Neg | Sym;
	public Log_Expr_UnaryElements getLog_Expr_UnaryAccess() {
		return (pLog_Expr_Unary != null) ? pLog_Expr_Unary : (pLog_Expr_Unary = new Log_Expr_UnaryElements());
	}
	
	public ParserRule getLog_Expr_UnaryRule() {
		return getLog_Expr_UnaryAccess().getRule();
	}

	//Log_Expr_Binary:
	//	"(" fst=Log_Expr operator=("AND" | "OR" | "EQ") snd=Log_Expr ")";
	public Log_Expr_BinaryElements getLog_Expr_BinaryAccess() {
		return (pLog_Expr_Binary != null) ? pLog_Expr_Binary : (pLog_Expr_Binary = new Log_Expr_BinaryElements());
	}
	
	public ParserRule getLog_Expr_BinaryRule() {
		return getLog_Expr_BinaryAccess().getRule();
	}

	//Log_Neg:
	//	"NOT" expr=Log_Expr;
	public Log_NegElements getLog_NegAccess() {
		return (pLog_Neg != null) ? pLog_Neg : (pLog_Neg = new Log_NegElements());
	}
	
	public ParserRule getLog_NegRule() {
		return getLog_NegAccess().getRule();
	}

	//Sym:
	//	sym=ID;
	public SymElements getSymAccess() {
		return (pSym != null) ? pSym : (pSym = new SymElements());
	}
	
	public ParserRule getSymRule() {
		return getSymAccess().getRule();
	}

	//Source:
	//	RProgram | Stmnt_LST_Elem | Log_Expr | Log_Expr_T;
	public SourceElements getSourceAccess() {
		return (pSource != null) ? pSource : (pSource = new SourceElements());
	}
	
	public ParserRule getSourceRule() {
		return getSourceAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
