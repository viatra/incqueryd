/*
* generated by Xtext
*/
package hu.bme.mit.incqueryd.mondixschema.language.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class MondixSchemaGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class SchemaElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Schema");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cSchemaAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cSchemaKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Assignment cRelationsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cRelationsRelationParserRuleCall_3_0 = (RuleCall)cRelationsAssignment_3.eContents().get(0);
		
		//Schema:
		//	{Schema} "schema" name=ID relations+=Relation*;
		public ParserRule getRule() { return rule; }

		//{Schema} "schema" name=ID relations+=Relation*
		public Group getGroup() { return cGroup; }

		//{Schema}
		public Action getSchemaAction_0() { return cSchemaAction_0; }

		//"schema"
		public Keyword getSchemaKeyword_1() { return cSchemaKeyword_1; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }

		//relations+=Relation*
		public Assignment getRelationsAssignment_3() { return cRelationsAssignment_3; }

		//Relation
		public RuleCall getRelationsRelationParserRuleCall_3_0() { return cRelationsRelationParserRuleCall_3_0; }
	}

	public class RelationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Relation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRelationAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cRelationKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cColumnsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cColumnsColumnParserRuleCall_4_0 = (RuleCall)cColumnsAssignment_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//Relation:
		//	{Relation} "relation" name=ID "{" columns+=Column* "}";
		public ParserRule getRule() { return rule; }

		//{Relation} "relation" name=ID "{" columns+=Column* "}"
		public Group getGroup() { return cGroup; }

		//{Relation}
		public Action getRelationAction_0() { return cRelationAction_0; }

		//"relation"
		public Keyword getRelationKeyword_1() { return cRelationKeyword_1; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }

		//columns+=Column*
		public Assignment getColumnsAssignment_4() { return cColumnsAssignment_4; }

		//Column
		public RuleCall getColumnsColumnParserRuleCall_4_0() { return cColumnsColumnParserRuleCall_4_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}

	public class ColumnElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Column");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cColumnAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cColumnKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		
		//Column:
		//	{Column} "column" name=ID;
		public ParserRule getRule() { return rule; }

		//{Column} "column" name=ID
		public Group getGroup() { return cGroup; }

		//{Column}
		public Action getColumnAction_0() { return cColumnAction_0; }

		//"column"
		public Keyword getColumnKeyword_1() { return cColumnKeyword_1; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
	}
	
	
	private SchemaElements pSchema;
	private RelationElements pRelation;
	private ColumnElements pColumn;
	
	private final Grammar grammar;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public MondixSchemaGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("hu.bme.mit.incqueryd.mondixschema.language.MondixSchema".equals(grammar.getName())) {
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

	
	//Schema:
	//	{Schema} "schema" name=ID relations+=Relation*;
	public SchemaElements getSchemaAccess() {
		return (pSchema != null) ? pSchema : (pSchema = new SchemaElements());
	}
	
	public ParserRule getSchemaRule() {
		return getSchemaAccess().getRule();
	}

	//Relation:
	//	{Relation} "relation" name=ID "{" columns+=Column* "}";
	public RelationElements getRelationAccess() {
		return (pRelation != null) ? pRelation : (pRelation = new RelationElements());
	}
	
	public ParserRule getRelationRule() {
		return getRelationAccess().getRule();
	}

	//Column:
	//	{Column} "column" name=ID;
	public ColumnElements getColumnAccess() {
		return (pColumn != null) ? pColumn : (pColumn = new ColumnElements());
	}
	
	public ParserRule getColumnRule() {
		return getColumnAccess().getRule();
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
