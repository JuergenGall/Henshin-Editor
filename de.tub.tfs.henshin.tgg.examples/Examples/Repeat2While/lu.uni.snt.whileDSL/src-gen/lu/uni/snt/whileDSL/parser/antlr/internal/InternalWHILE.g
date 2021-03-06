/*
* generated by Xtext
*/
grammar InternalWHILE;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package lu.uni.snt.whileDSL.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package lu.uni.snt.whileDSL.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import lu.uni.snt.whileDSL.services.WHILEGrammarAccess;

}

@parser::members {

 	private WHILEGrammarAccess grammarAccess;
 	
    public InternalWHILEParser(TokenStream input, WHILEGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "WProgram";	
   	}
   	
   	@Override
   	protected WHILEGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleWProgram
entryRuleWProgram returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getWProgramRule()); }
	 iv_ruleWProgram=ruleWProgram 
	 { $current=$iv_ruleWProgram.current; } 
	 EOF 
;

// Rule WProgram
ruleWProgram returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getWProgramAccess().getFstFgmnt_LST_ElemParserRuleCall_0()); 
	    }
		lv_fst_0_0=ruleFgmnt_LST_Elem		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getWProgramRule());
	        }
       		set(
       			$current, 
       			"fst",
        		lv_fst_0_0, 
        		"Fgmnt_LST_Elem");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleFgmnt_LST_Elem
entryRuleFgmnt_LST_Elem returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFgmnt_LST_ElemRule()); }
	 iv_ruleFgmnt_LST_Elem=ruleFgmnt_LST_Elem 
	 { $current=$iv_ruleFgmnt_LST_Elem.current; } 
	 EOF 
;

// Rule Fgmnt_LST_Elem
ruleFgmnt_LST_Elem returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    { 
        newCompositeNode(grammarAccess.getFgmnt_LST_ElemAccess().getWhileParserRuleCall_0_0()); 
    }
    this_While_0=ruleWhile
    { 
        $current = $this_While_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getFgmnt_LST_ElemAccess().getVar_DefParserRuleCall_0_1()); 
    }
    this_Var_Def_1=ruleVar_Def
    { 
        $current = $this_Var_Def_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getFgmnt_LST_ElemAccess().getFn_CallParserRuleCall_0_2()); 
    }
    this_Fn_Call_2=ruleFn_Call
    { 
        $current = $this_Fn_Call_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getFgmnt_LST_ElemAccess().getFn_DefParserRuleCall_0_3()); 
    }
    this_Fn_Def_3=ruleFn_Def
    { 
        $current = $this_Fn_Def_3.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getFgmnt_LST_ElemAccess().getCommentParserRuleCall_0_4()); 
    }
    this_Comment_4=ruleComment
    { 
        $current = $this_Comment_4.current; 
        afterParserOrEnumRuleCall();
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getFgmnt_LST_ElemAccess().getNextFgmnt_LST_ElemParserRuleCall_1_0()); 
	    }
		lv_next_5_0=ruleFgmnt_LST_Elem		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFgmnt_LST_ElemRule());
	        }
       		set(
       			$current, 
       			"next",
        		lv_next_5_0, 
        		"Fgmnt_LST_Elem");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleWhile
entryRuleWhile returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getWhileRule()); }
	 iv_ruleWhile=ruleWhile 
	 { $current=$iv_ruleWhile.current; } 
	 EOF 
;

// Rule While
ruleWhile returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='while' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getWhileAccess().getWhileKeyword_0());
    }
	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getWhileAccess().getLeftParenthesisKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getWhileAccess().getExprExprParserRuleCall_2_0()); 
	    }
		lv_expr_2_0=ruleExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getWhileRule());
	        }
       		set(
       			$current, 
       			"expr",
        		lv_expr_2_0, 
        		"Expr");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=')' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getWhileAccess().getRightParenthesisKeyword_3());
    }
	otherlv_4='{' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getWhileAccess().getLeftCurlyBracketKeyword_4());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getWhileAccess().getFgmntFgmnt_LST_ElemParserRuleCall_5_0()); 
	    }
		lv_fgmnt_5_0=ruleFgmnt_LST_Elem		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getWhileRule());
	        }
       		set(
       			$current, 
       			"fgmnt",
        		lv_fgmnt_5_0, 
        		"Fgmnt_LST_Elem");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_6='}' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getWhileAccess().getRightCurlyBracketKeyword_6());
    }
)
;





// Entry rule entryRuleVar_Def
entryRuleVar_Def returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVar_DefRule()); }
	 iv_ruleVar_Def=ruleVar_Def 
	 { $current=$iv_ruleVar_Def.current; } 
	 EOF 
;

// Rule Var_Def
ruleVar_Def returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getVar_DefAccess().getLeftVarParserRuleCall_0_0()); 
	    }
		lv_left_0_0=ruleVar		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVar_DefRule());
	        }
       		set(
       			$current, 
       			"left",
        		lv_left_0_0, 
        		"Var");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='=' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getVar_DefAccess().getEqualsSignKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVar_DefAccess().getRightExprParserRuleCall_2_0()); 
	    }
		lv_right_2_0=ruleExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVar_DefRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_2_0, 
        		"Expr");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=';' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getVar_DefAccess().getSemicolonKeyword_3());
    }
)
;





// Entry rule entryRuleFn_Call
entryRuleFn_Call returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFn_CallRule()); }
	 iv_ruleFn_Call=ruleFn_Call 
	 { $current=$iv_ruleFn_Call.current; } 
	 EOF 
;

// Rule Fn_Call
ruleFn_Call returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_nameF_0_0=RULE_ID
		{
			newLeafNode(lv_nameF_0_0, grammarAccess.getFn_CallAccess().getNameFIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFn_CallRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"nameF",
        		lv_nameF_0_0, 
        		"ID");
	    }

)
)	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getFn_CallAccess().getLeftParenthesisKeyword_1());
    }
	otherlv_2=')' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getFn_CallAccess().getRightParenthesisKeyword_2());
    }
	otherlv_3=';' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getFn_CallAccess().getSemicolonKeyword_3());
    }
)
;





// Entry rule entryRuleFn_Def
entryRuleFn_Def returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFn_DefRule()); }
	 iv_ruleFn_Def=ruleFn_Def 
	 { $current=$iv_ruleFn_Def.current; } 
	 EOF 
;

// Rule Fn_Def
ruleFn_Def returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='def' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getFn_DefAccess().getDefKeyword_0());
    }
(
(
		lv_nameF_1_0=RULE_ID
		{
			newLeafNode(lv_nameF_1_0, grammarAccess.getFn_DefAccess().getNameFIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFn_DefRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"nameF",
        		lv_nameF_1_0, 
        		"ID");
	    }

)
)	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getFn_DefAccess().getLeftParenthesisKeyword_2());
    }
	otherlv_3=')' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getFn_DefAccess().getRightParenthesisKeyword_3());
    }
	otherlv_4='{' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getFn_DefAccess().getLeftCurlyBracketKeyword_4());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFn_DefAccess().getBodyFgmnt_LST_ElemParserRuleCall_5_0()); 
	    }
		lv_body_5_0=ruleFgmnt_LST_Elem		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFn_DefRule());
	        }
       		set(
       			$current, 
       			"body",
        		lv_body_5_0, 
        		"Fgmnt_LST_Elem");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_6='}' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getFn_DefAccess().getRightCurlyBracketKeyword_6());
    }
	otherlv_7=';' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getFn_DefAccess().getSemicolonKeyword_7());
    }
)
;





// Entry rule entryRuleComment
entryRuleComment returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCommentRule()); }
	 iv_ruleComment=ruleComment 
	 { $current=$iv_ruleComment.current; } 
	 EOF 
;

// Rule Comment
ruleComment returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='/#' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getCommentAccess().getSolidusNumberSignKeyword_0());
    }
(
(
		lv_comment_1_0=RULE_STRING
		{
			newLeafNode(lv_comment_1_0, grammarAccess.getCommentAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCommentRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"comment",
        		lv_comment_1_0, 
        		"STRING");
	    }

)
)	otherlv_2='#/' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getCommentAccess().getNumberSignSolidusKeyword_2());
    }
)
;





// Entry rule entryRuleExpr
entryRuleExpr returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getExprRule()); }
	 iv_ruleExpr=ruleExpr 
	 { $current=$iv_ruleExpr.current; } 
	 EOF 
;

// Rule Expr
ruleExpr returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getExprAccess().getTypeExpr_TParserRuleCall_0()); 
	    }
		lv_type_0_0=ruleExpr_T		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getExprRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_0_0, 
        		"Expr_T");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleExpr_T
entryRuleExpr_T returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getExpr_TRule()); }
	 iv_ruleExpr_T=ruleExpr_T 
	 { $current=$iv_ruleExpr_T.current; } 
	 EOF 
;

// Rule Expr_T
ruleExpr_T returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getExpr_TAccess().getUnaryParserRuleCall_0()); 
    }
    this_Unary_0=ruleUnary
    { 
        $current = $this_Unary_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getExpr_TAccess().getBinaryParserRuleCall_1()); 
    }
    this_Binary_1=ruleBinary
    { 
        $current = $this_Binary_1.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleUnary
entryRuleUnary returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getUnaryRule()); }
	 iv_ruleUnary=ruleUnary 
	 { $current=$iv_ruleUnary.current; } 
	 EOF 
;

// Rule Unary
ruleUnary returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getUnaryAccess().getNegParserRuleCall_0()); 
    }
    this_Neg_0=ruleNeg
    { 
        $current = $this_Neg_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getUnaryAccess().getVarParserRuleCall_1()); 
    }
    this_Var_1=ruleVar
    { 
        $current = $this_Var_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getUnaryAccess().getInputParserRuleCall_2()); 
    }
    this_Input_2=ruleInput
    { 
        $current = $this_Input_2.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleBinary
entryRuleBinary returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getBinaryRule()); }
	 iv_ruleBinary=ruleBinary 
	 { $current=$iv_ruleBinary.current; } 
	 EOF 
;

// Rule Binary
ruleBinary returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='(' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getBinaryAccess().getLeftParenthesisKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getBinaryAccess().getFstExprParserRuleCall_1_0()); 
	    }
		lv_fst_1_0=ruleExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBinaryRule());
	        }
       		set(
       			$current, 
       			"fst",
        		lv_fst_1_0, 
        		"Expr");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
(
		lv_operator_2_1=	'&&' 
    {
        newLeafNode(lv_operator_2_1, grammarAccess.getBinaryAccess().getOperatorAmpersandAmpersandKeyword_2_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getBinaryRule());
	        }
       		setWithLastConsumed($current, "operator", lv_operator_2_1, null);
	    }

    |		lv_operator_2_2=	'||' 
    {
        newLeafNode(lv_operator_2_2, grammarAccess.getBinaryAccess().getOperatorVerticalLineVerticalLineKeyword_2_0_1());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getBinaryRule());
	        }
       		setWithLastConsumed($current, "operator", lv_operator_2_2, null);
	    }

    |		lv_operator_2_3=	'==' 
    {
        newLeafNode(lv_operator_2_3, grammarAccess.getBinaryAccess().getOperatorEqualsSignEqualsSignKeyword_2_0_2());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getBinaryRule());
	        }
       		setWithLastConsumed($current, "operator", lv_operator_2_3, null);
	    }

)

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getBinaryAccess().getSndExprParserRuleCall_3_0()); 
	    }
		lv_snd_3_0=ruleExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBinaryRule());
	        }
       		set(
       			$current, 
       			"snd",
        		lv_snd_3_0, 
        		"Expr");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4=')' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getBinaryAccess().getRightParenthesisKeyword_4());
    }
)
;





// Entry rule entryRuleNeg
entryRuleNeg returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNegRule()); }
	 iv_ruleNeg=ruleNeg 
	 { $current=$iv_ruleNeg.current; } 
	 EOF 
;

// Rule Neg
ruleNeg returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='!' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getNegAccess().getExclamationMarkKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNegAccess().getExprExprParserRuleCall_1_0()); 
	    }
		lv_expr_1_0=ruleExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNegRule());
	        }
       		set(
       			$current, 
       			"expr",
        		lv_expr_1_0, 
        		"Expr");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleVar
entryRuleVar returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVarRule()); }
	 iv_ruleVar=ruleVar 
	 { $current=$iv_ruleVar.current; } 
	 EOF 
;

// Rule Var
ruleVar returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		lv_label_0_0=RULE_ID
		{
			newLeafNode(lv_label_0_0, grammarAccess.getVarAccess().getLabelIDTerminalRuleCall_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVarRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"label",
        		lv_label_0_0, 
        		"ID");
	    }

)
)
;





// Entry rule entryRuleInput
entryRuleInput returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getInputRule()); }
	 iv_ruleInput=ruleInput 
	 { $current=$iv_ruleInput.current; } 
	 EOF 
;

// Rule Input
ruleInput returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getInputAccess().getInputAction_0(),
            $current);
    }
)	otherlv_1='input' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getInputAccess().getInputKeyword_1());
    }
	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getInputAccess().getLeftParenthesisKeyword_2());
    }
	otherlv_3=')' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getInputAccess().getRightParenthesisKeyword_3());
    }
)
;







RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


