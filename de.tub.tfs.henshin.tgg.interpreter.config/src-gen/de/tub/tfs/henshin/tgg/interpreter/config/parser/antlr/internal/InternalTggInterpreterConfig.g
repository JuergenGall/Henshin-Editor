/*
* generated by Xtext
*/
grammar InternalTggInterpreterConfig;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package de.tub.tfs.henshin.tgg.interpreter.config.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package de.tub.tfs.henshin.tgg.interpreter.config.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.tub.tfs.henshin.tgg.interpreter.config.services.TggInterpreterConfigGrammarAccess;

}

@parser::members {

 	private TggInterpreterConfigGrammarAccess grammarAccess;
 	
    public InternalTggInterpreterConfigParser(TokenStream input, TggInterpreterConfigGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "TggInterpreterConfig";	
   	}
   	
   	@Override
   	protected TggInterpreterConfigGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleTggInterpreterConfig
entryRuleTggInterpreterConfig returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTggInterpreterConfigRule()); }
	 iv_ruleTggInterpreterConfig=ruleTggInterpreterConfig 
	 { $current=$iv_ruleTggInterpreterConfig.current; } 
	 EOF 
;

// Rule TggInterpreterConfig
ruleTggInterpreterConfig returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((this_NL_0=RULE_NL
    { 
    newLeafNode(this_NL_0, grammarAccess.getTggInterpreterConfigAccess().getNLTerminalRuleCall_0()); 
    }
)?(	otherlv_1='AdditionalOptions' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTggInterpreterConfigAccess().getAdditionalOptionsKeyword_1_0());
    }
	otherlv_2='=' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getTggInterpreterConfigAccess().getEqualsSignKeyword_1_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTggInterpreterConfigAccess().getOptionsProcessingEntryParserRuleCall_1_2_0()); 
	    }
		lv_options_3_0=ruleProcessingEntry		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTggInterpreterConfigRule());
	        }
       		add(
       			$current, 
       			"options",
        		lv_options_3_0, 
        		"ProcessingEntry");
	        afterParserOrEnumRuleCall();
	    }

)
)+this_NL_4=RULE_NL
    { 
    newLeafNode(this_NL_4, grammarAccess.getTggInterpreterConfigAccess().getNLTerminalRuleCall_1_3()); 
    }
)*)
;





// Entry rule entryRuleProcessingEntry
entryRuleProcessingEntry returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getProcessingEntryRule()); }
	 iv_ruleProcessingEntry=ruleProcessingEntry 
	 { $current=$iv_ruleProcessingEntry.current; } 
	 EOF 
;

// Rule ProcessingEntry
ruleProcessingEntry returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((this_NL_0=RULE_NL
    { 
    newLeafNode(this_NL_0, grammarAccess.getProcessingEntryAccess().getNLTerminalRuleCall_0()); 
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getProcessingEntryAccess().getKeyKeyValueParserRuleCall_1_0()); 
	    }
		lv_key_1_0=rulekeyValue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getProcessingEntryRule());
	        }
       		set(
       			$current, 
       			"key",
        		lv_key_1_0, 
        		"keyValue");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='=' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getProcessingEntryAccess().getEqualsSignKeyword_2());
    }
	otherlv_3='>' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getProcessingEntryAccess().getGreaterThanSignKeyword_3());
    }
(this_NL_4=RULE_NL
    { 
    newLeafNode(this_NL_4, grammarAccess.getProcessingEntryAccess().getNLTerminalRuleCall_4()); 
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getProcessingEntryAccess().getValueScriptOrValueParserRuleCall_5_0()); 
	    }
		lv_value_5_0=ruleScriptOrValue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getProcessingEntryRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_5_0, 
        		"ScriptOrValue");
	        afterParserOrEnumRuleCall();
	    }

)
)(this_NL_6=RULE_NL
    { 
    newLeafNode(this_NL_6, grammarAccess.getProcessingEntryAccess().getNLTerminalRuleCall_6()); 
    }
)?(	otherlv_7=',' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getProcessingEntryAccess().getCommaKeyword_7());
    }
)?)
;





// Entry rule entryRuleScriptOrValue
entryRuleScriptOrValue returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getScriptOrValueRule()); } 
	 iv_ruleScriptOrValue=ruleScriptOrValue 
	 { $current=$iv_ruleScriptOrValue.current.getText(); }  
	 EOF 
;

// Rule ScriptOrValue
ruleScriptOrValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_JSSCRIPT_0=RULE_JSSCRIPT    {
		$current.merge(this_JSSCRIPT_0);
    }

    { 
    newLeafNode(this_JSSCRIPT_0, grammarAccess.getScriptOrValueAccess().getJSSCRIPTTerminalRuleCall_0()); 
    }

    |
    { 
        newCompositeNode(grammarAccess.getScriptOrValueAccess().getValueParserRuleCall_1()); 
    }
    this_value_1=rulevalue    {
		$current.merge(this_value_1);
    }

    { 
        afterParserOrEnumRuleCall();
    }
)
    ;





// Entry rule entryRulekeyValue
entryRulekeyValue returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getKeyValueRule()); } 
	 iv_rulekeyValue=rulekeyValue 
	 { $current=$iv_rulekeyValue.current.getText(); }  
	 EOF 
;

// Rule keyValue
rulekeyValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getKeyValueAccess().getIDTerminalRuleCall_0()); 
    }
(    this_ID_1=RULE_ID    {
		$current.merge(this_ID_1);
    }

    { 
    newLeafNode(this_ID_1, grammarAccess.getKeyValueAccess().getIDTerminalRuleCall_1_0()); 
    }

    |    this_WS_2=RULE_WS    {
		$current.merge(this_WS_2);
    }

    { 
    newLeafNode(this_WS_2, grammarAccess.getKeyValueAccess().getWSTerminalRuleCall_1_1()); 
    }
)*)
    ;





// Entry rule entryRulevalue
entryRulevalue returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getValueRule()); } 
	 iv_rulevalue=rulevalue 
	 { $current=$iv_rulevalue.current.getText(); }  
	 EOF 
;

// Rule value
rulevalue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getValueAccess().getIDTerminalRuleCall_0_0()); 
    }

    |
	kw='=' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getValueAccess().getEqualsSignKeyword_0_1()); 
    }

    |
	kw='>' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getValueAccess().getGreaterThanSignKeyword_0_2()); 
    }
)(    this_ID_3=RULE_ID    {
		$current.merge(this_ID_3);
    }

    { 
    newLeafNode(this_ID_3, grammarAccess.getValueAccess().getIDTerminalRuleCall_1_0()); 
    }

    |    this_WS_4=RULE_WS    {
		$current.merge(this_WS_4);
    }

    { 
    newLeafNode(this_WS_4, grammarAccess.getValueAccess().getWSTerminalRuleCall_1_1()); 
    }

    |
	kw='=' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getValueAccess().getEqualsSignKeyword_1_2()); 
    }

    |
	kw='>' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getValueAccess().getGreaterThanSignKeyword_1_3()); 
    }
)*)
    ;





RULE_JSSCRIPT : '{*' ( options {greedy=false;} : . )*'*}';

RULE_ID : ~(('\r'|'\n'|' '|'\t'|'='|'>')) ~(('\r'|'\n'|' '|'\t'|'='))*;

RULE_NL : ('\r'|'\n')+;

RULE_WS : (' '|'\t')+;

RULE_ANY_OTHER : .;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;


