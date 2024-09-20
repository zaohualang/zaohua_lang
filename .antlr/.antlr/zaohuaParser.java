// Generated from e:/zaohua/zaohua_lang/.antlr/zaohua.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class zaohuaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, IF=5, ELSE=6, ELIF=7, FOR=8, FUNC=9, RETURN=10, 
		IN=11, TRUE=12, FALSE=13, PLUS=14, MINUS=15, MUL=16, DIV=17, MOD=18, EQ=19, 
		NEQ=20, GT=21, LT=22, GTE=23, LTE=24, ASSIGN=25, DECLARE_ASSIGN=26, COLON=27, 
		SEMI=28, COMMA=29, LPAREN=30, RPAREN=31, LBRACE=32, RBRACE=33, BOOLEAN=34, 
		ID=35, NUMBER=36, NEWLINE=37, STRING=38, LINE_COMMENT=39, WS=40;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_ifStatement = 2, RULE_elifStatement = 3, 
		RULE_elseStatement = 4, RULE_forStatement = 5, RULE_funcDeclaration = 6, 
		RULE_aliasDeclaration = 7, RULE_returnStatement = 8, RULE_assignment = 9, 
		RULE_declaration = 10, RULE_expressionStatement = 11, RULE_block = 12, 
		RULE_paramList = 13, RULE_param = 14, RULE_typeSpecifier = 15, RULE_expression = 16, 
		RULE_funcCall = 17, RULE_argumentList = 18, RULE_equalityExpression = 19, 
		RULE_relationalExpression = 20, RULE_additiveExpression = 21, RULE_multiplicativeExpression = 22, 
		RULE_primary = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "ifStatement", "elifStatement", "elseStatement", 
			"forStatement", "funcDeclaration", "aliasDeclaration", "returnStatement", 
			"assignment", "declaration", "expressionStatement", "block", "paramList", 
			"param", "typeSpecifier", "expression", "funcCall", "argumentList", "equalityExpression", 
			"relationalExpression", "additiveExpression", "multiplicativeExpression", 
			"primary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'float'", "'bool'", "'string'", "'if'", "'else'", "'elif'", 
			"'for'", "'func'", "'return'", "'in'", "'true'", "'false'", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'='", 
			"':='", "':'", "';'", "','", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "IF", "ELSE", "ELIF", "FOR", "FUNC", "RETURN", 
			"IN", "TRUE", "FALSE", "PLUS", "MINUS", "MUL", "DIV", "MOD", "EQ", "NEQ", 
			"GT", "LT", "GTE", "LTE", "ASSIGN", "DECLARE_ASSIGN", "COLON", "SEMI", 
			"COMMA", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "BOOLEAN", "ID", "NUMBER", 
			"NEWLINE", "STRING", "LINE_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "zaohua.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public zaohuaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(zaohuaParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 396210734880L) != 0)) {
				{
				{
				setState(48);
				statement();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public FuncDeclarationContext funcDeclaration() {
			return getRuleContext(FuncDeclarationContext.class,0);
		}
		public AliasDeclarationContext aliasDeclaration() {
			return getRuleContext(AliasDeclarationContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				ifStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				forStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				funcDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(59);
				aliasDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(60);
				returnStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(61);
				assignment();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(62);
				declaration();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(63);
				expressionStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(zaohuaParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(zaohuaParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElifStatementContext elifStatement() {
			return getRuleContext(ElifStatementContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(IF);
			setState(67);
			expression();
			setState(68);
			match(COLON);
			setState(69);
			block();
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELIF:
				{
				setState(70);
				elifStatement();
				}
				break;
			case ELSE:
				{
				setState(71);
				elseStatement();
				}
				break;
			case EOF:
			case IF:
			case FOR:
			case FUNC:
			case RETURN:
			case LPAREN:
			case RBRACE:
			case BOOLEAN:
			case ID:
			case NUMBER:
			case STRING:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElifStatementContext extends ParserRuleContext {
		public TerminalNode ELIF() { return getToken(zaohuaParser.ELIF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(zaohuaParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElifStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elifStatement; }
	}

	public final ElifStatementContext elifStatement() throws RecognitionException {
		ElifStatementContext _localctx = new ElifStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_elifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(ELIF);
			setState(75);
			expression();
			setState(76);
			match(COLON);
			setState(77);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(zaohuaParser.ELSE, 0); }
		public TerminalNode COLON() { return getToken(zaohuaParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(ELSE);
			setState(80);
			match(COLON);
			setState(81);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(zaohuaParser.FOR, 0); }
		public TerminalNode ID() { return getToken(zaohuaParser.ID, 0); }
		public TerminalNode IN() { return getToken(zaohuaParser.IN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(zaohuaParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(FOR);
			setState(84);
			match(ID);
			setState(85);
			match(IN);
			setState(86);
			expression();
			setState(87);
			match(COLON);
			setState(88);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDeclarationContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(zaohuaParser.FUNC, 0); }
		public TerminalNode ID() { return getToken(zaohuaParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(zaohuaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(zaohuaParser.RPAREN, 0); }
		public List<TerminalNode> COLON() { return getTokens(zaohuaParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(zaohuaParser.COLON, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public FuncDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDeclaration; }
	}

	public final FuncDeclarationContext funcDeclaration() throws RecognitionException {
		FuncDeclarationContext _localctx = new FuncDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(FUNC);
			setState(91);
			match(ID);
			setState(92);
			match(LPAREN);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(93);
				paramList();
				}
			}

			setState(96);
			match(RPAREN);
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(97);
				match(COLON);
				setState(98);
				typeSpecifier();
				}
				break;
			}
			setState(101);
			match(COLON);
			setState(102);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AliasDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(zaohuaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(zaohuaParser.ID, i);
		}
		public TerminalNode COLON() { return getToken(zaohuaParser.COLON, 0); }
		public TerminalNode SEMI() { return getToken(zaohuaParser.SEMI, 0); }
		public AliasDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasDeclaration; }
	}

	public final AliasDeclarationContext aliasDeclaration() throws RecognitionException {
		AliasDeclarationContext _localctx = new AliasDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_aliasDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(ID);
			setState(105);
			match(COLON);
			setState(106);
			match(ID);
			setState(107);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(zaohuaParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(zaohuaParser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(RETURN);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 396210733056L) != 0)) {
				{
				setState(110);
				expression();
				}
			}

			setState(113);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(zaohuaParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(zaohuaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(zaohuaParser.SEMI, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(ID);
			setState(116);
			match(ASSIGN);
			setState(117);
			expression();
			setState(118);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(zaohuaParser.ID, 0); }
		public TerminalNode DECLARE_ASSIGN() { return getToken(zaohuaParser.DECLARE_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(zaohuaParser.SEMI, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(ID);
			setState(121);
			match(DECLARE_ASSIGN);
			setState(122);
			expression();
			setState(123);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(zaohuaParser.SEMI, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			expression();
			setState(126);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(zaohuaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(zaohuaParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(LBRACE);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 396210734880L) != 0)) {
				{
				{
				setState(129);
				statement();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(zaohuaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(zaohuaParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			param();
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(138);
				match(COMMA);
				setState(139);
				param();
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(zaohuaParser.ID, 0); }
		public TerminalNode COLON() { return getToken(zaohuaParser.COLON, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(ID);
			setState(146);
			match(COLON);
			setState(147);
			typeSpecifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSpecifierContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(zaohuaParser.ID, 0); }
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 34359738398L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expression);
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				equalityExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				funcCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(zaohuaParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(zaohuaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(zaohuaParser.RPAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_funcCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(ID);
			setState(156);
			match(LPAREN);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 396210733056L) != 0)) {
				{
				setState(157);
				argumentList();
				}
			}

			setState(160);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(zaohuaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(zaohuaParser.COMMA, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			expression();
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(163);
				match(COMMA);
				setState(164);
				expression();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExpressionContext extends ParserRuleContext {
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<TerminalNode> EQ() { return getTokens(zaohuaParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(zaohuaParser.EQ, i);
		}
		public List<TerminalNode> NEQ() { return getTokens(zaohuaParser.NEQ); }
		public TerminalNode NEQ(int i) {
			return getToken(zaohuaParser.NEQ, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			relationalExpression();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQ || _la==NEQ) {
				{
				setState(175);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EQ:
					{
					setState(171);
					match(EQ);
					setState(172);
					relationalExpression();
					}
					break;
				case NEQ:
					{
					setState(173);
					match(NEQ);
					setState(174);
					relationalExpression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExpressionContext extends ParserRuleContext {
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> GT() { return getTokens(zaohuaParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(zaohuaParser.GT, i);
		}
		public List<TerminalNode> LT() { return getTokens(zaohuaParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(zaohuaParser.LT, i);
		}
		public List<TerminalNode> GTE() { return getTokens(zaohuaParser.GTE); }
		public TerminalNode GTE(int i) {
			return getToken(zaohuaParser.GTE, i);
		}
		public List<TerminalNode> LTE() { return getTokens(zaohuaParser.LTE); }
		public TerminalNode LTE(int i) {
			return getToken(zaohuaParser.LTE, i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			additiveExpression();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31457280L) != 0)) {
				{
				setState(189);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case GT:
					{
					setState(181);
					match(GT);
					setState(182);
					additiveExpression();
					}
					break;
				case LT:
					{
					setState(183);
					match(LT);
					setState(184);
					additiveExpression();
					}
					break;
				case GTE:
					{
					setState(185);
					match(GTE);
					setState(186);
					additiveExpression();
					}
					break;
				case LTE:
					{
					setState(187);
					match(LTE);
					setState(188);
					additiveExpression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExpressionContext extends ParserRuleContext {
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(zaohuaParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(zaohuaParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(zaohuaParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(zaohuaParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			multiplicativeExpression();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				setState(199);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(195);
					match(PLUS);
					setState(196);
					multiplicativeExpression();
					}
					break;
				case MINUS:
					{
					setState(197);
					match(MINUS);
					setState(198);
					multiplicativeExpression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public List<PrimaryContext> primary() {
			return getRuleContexts(PrimaryContext.class);
		}
		public PrimaryContext primary(int i) {
			return getRuleContext(PrimaryContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(zaohuaParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(zaohuaParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(zaohuaParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(zaohuaParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(zaohuaParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(zaohuaParser.MOD, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			primary();
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 458752L) != 0)) {
				{
				setState(211);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MUL:
					{
					setState(205);
					match(MUL);
					setState(206);
					primary();
					}
					break;
				case DIV:
					{
					setState(207);
					match(DIV);
					setState(208);
					primary();
					}
					break;
				case MOD:
					{
					setState(209);
					match(MOD);
					setState(210);
					primary();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(zaohuaParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(zaohuaParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(zaohuaParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(zaohuaParser.BOOLEAN, 0); }
		public TerminalNode LPAREN() { return getToken(zaohuaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(zaohuaParser.RPAREN, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_primary);
		try {
			setState(224);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				match(ID);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				match(NUMBER);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(218);
				match(STRING);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(219);
				match(BOOLEAN);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 5);
				{
				setState(220);
				match(LPAREN);
				setState(221);
				expression();
				setState(222);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001(\u00e3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0005\u0000"+
		"2\b\u0000\n\u0000\f\u00005\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001A\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002I\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006_\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006d\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0003"+
		"\bp\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0005\f\u0083\b\f\n\f\f\f\u0086\t\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0005\r\u008d\b\r\n\r\f\r\u0090\t\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u009a\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u009f\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0005\u0012\u00a6\b\u0012\n\u0012\f\u0012\u00a9\t\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u00b0\b\u0013"+
		"\n\u0013\f\u0013\u00b3\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005"+
		"\u0014\u00be\b\u0014\n\u0014\f\u0014\u00c1\t\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u00c8\b\u0015\n\u0015"+
		"\f\u0015\u00cb\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u00d4\b\u0016\n\u0016"+
		"\f\u0016\u00d7\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u00e1\b\u0017"+
		"\u0001\u0017\u0000\u0000\u0018\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.\u0000\u0001\u0002"+
		"\u0000\u0001\u0004##\u00eb\u00003\u0001\u0000\u0000\u0000\u0002@\u0001"+
		"\u0000\u0000\u0000\u0004B\u0001\u0000\u0000\u0000\u0006J\u0001\u0000\u0000"+
		"\u0000\bO\u0001\u0000\u0000\u0000\nS\u0001\u0000\u0000\u0000\fZ\u0001"+
		"\u0000\u0000\u0000\u000eh\u0001\u0000\u0000\u0000\u0010m\u0001\u0000\u0000"+
		"\u0000\u0012s\u0001\u0000\u0000\u0000\u0014x\u0001\u0000\u0000\u0000\u0016"+
		"}\u0001\u0000\u0000\u0000\u0018\u0080\u0001\u0000\u0000\u0000\u001a\u0089"+
		"\u0001\u0000\u0000\u0000\u001c\u0091\u0001\u0000\u0000\u0000\u001e\u0095"+
		"\u0001\u0000\u0000\u0000 \u0099\u0001\u0000\u0000\u0000\"\u009b\u0001"+
		"\u0000\u0000\u0000$\u00a2\u0001\u0000\u0000\u0000&\u00aa\u0001\u0000\u0000"+
		"\u0000(\u00b4\u0001\u0000\u0000\u0000*\u00c2\u0001\u0000\u0000\u0000,"+
		"\u00cc\u0001\u0000\u0000\u0000.\u00e0\u0001\u0000\u0000\u000002\u0003"+
		"\u0002\u0001\u000010\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u0000"+
		"31\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000046\u0001\u0000\u0000"+
		"\u000053\u0001\u0000\u0000\u000067\u0005\u0000\u0000\u00017\u0001\u0001"+
		"\u0000\u0000\u00008A\u0003\u0004\u0002\u00009A\u0003\n\u0005\u0000:A\u0003"+
		"\f\u0006\u0000;A\u0003\u000e\u0007\u0000<A\u0003\u0010\b\u0000=A\u0003"+
		"\u0012\t\u0000>A\u0003\u0014\n\u0000?A\u0003\u0016\u000b\u0000@8\u0001"+
		"\u0000\u0000\u0000@9\u0001\u0000\u0000\u0000@:\u0001\u0000\u0000\u0000"+
		"@;\u0001\u0000\u0000\u0000@<\u0001\u0000\u0000\u0000@=\u0001\u0000\u0000"+
		"\u0000@>\u0001\u0000\u0000\u0000@?\u0001\u0000\u0000\u0000A\u0003\u0001"+
		"\u0000\u0000\u0000BC\u0005\u0005\u0000\u0000CD\u0003 \u0010\u0000DE\u0005"+
		"\u001b\u0000\u0000EH\u0003\u0018\f\u0000FI\u0003\u0006\u0003\u0000GI\u0003"+
		"\b\u0004\u0000HF\u0001\u0000\u0000\u0000HG\u0001\u0000\u0000\u0000HI\u0001"+
		"\u0000\u0000\u0000I\u0005\u0001\u0000\u0000\u0000JK\u0005\u0007\u0000"+
		"\u0000KL\u0003 \u0010\u0000LM\u0005\u001b\u0000\u0000MN\u0003\u0018\f"+
		"\u0000N\u0007\u0001\u0000\u0000\u0000OP\u0005\u0006\u0000\u0000PQ\u0005"+
		"\u001b\u0000\u0000QR\u0003\u0018\f\u0000R\t\u0001\u0000\u0000\u0000ST"+
		"\u0005\b\u0000\u0000TU\u0005#\u0000\u0000UV\u0005\u000b\u0000\u0000VW"+
		"\u0003 \u0010\u0000WX\u0005\u001b\u0000\u0000XY\u0003\u0018\f\u0000Y\u000b"+
		"\u0001\u0000\u0000\u0000Z[\u0005\t\u0000\u0000[\\\u0005#\u0000\u0000\\"+
		"^\u0005\u001e\u0000\u0000]_\u0003\u001a\r\u0000^]\u0001\u0000\u0000\u0000"+
		"^_\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`c\u0005\u001f\u0000"+
		"\u0000ab\u0005\u001b\u0000\u0000bd\u0003\u001e\u000f\u0000ca\u0001\u0000"+
		"\u0000\u0000cd\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000ef\u0005"+
		"\u001b\u0000\u0000fg\u0003\u0018\f\u0000g\r\u0001\u0000\u0000\u0000hi"+
		"\u0005#\u0000\u0000ij\u0005\u001b\u0000\u0000jk\u0005#\u0000\u0000kl\u0005"+
		"\u001c\u0000\u0000l\u000f\u0001\u0000\u0000\u0000mo\u0005\n\u0000\u0000"+
		"np\u0003 \u0010\u0000on\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000"+
		"pq\u0001\u0000\u0000\u0000qr\u0005\u001c\u0000\u0000r\u0011\u0001\u0000"+
		"\u0000\u0000st\u0005#\u0000\u0000tu\u0005\u0019\u0000\u0000uv\u0003 \u0010"+
		"\u0000vw\u0005\u001c\u0000\u0000w\u0013\u0001\u0000\u0000\u0000xy\u0005"+
		"#\u0000\u0000yz\u0005\u001a\u0000\u0000z{\u0003 \u0010\u0000{|\u0005\u001c"+
		"\u0000\u0000|\u0015\u0001\u0000\u0000\u0000}~\u0003 \u0010\u0000~\u007f"+
		"\u0005\u001c\u0000\u0000\u007f\u0017\u0001\u0000\u0000\u0000\u0080\u0084"+
		"\u0005 \u0000\u0000\u0081\u0083\u0003\u0002\u0001\u0000\u0082\u0081\u0001"+
		"\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0087\u0001"+
		"\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u0088\u0005"+
		"!\u0000\u0000\u0088\u0019\u0001\u0000\u0000\u0000\u0089\u008e\u0003\u001c"+
		"\u000e\u0000\u008a\u008b\u0005\u001d\u0000\u0000\u008b\u008d\u0003\u001c"+
		"\u000e\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000"+
		"\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000"+
		"\u0000\u0000\u008f\u001b\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0005#\u0000\u0000\u0092\u0093\u0005\u001b\u0000"+
		"\u0000\u0093\u0094\u0003\u001e\u000f\u0000\u0094\u001d\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0007\u0000\u0000\u0000\u0096\u001f\u0001\u0000\u0000"+
		"\u0000\u0097\u009a\u0003&\u0013\u0000\u0098\u009a\u0003\"\u0011\u0000"+
		"\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000"+
		"\u009a!\u0001\u0000\u0000\u0000\u009b\u009c\u0005#\u0000\u0000\u009c\u009e"+
		"\u0005\u001e\u0000\u0000\u009d\u009f\u0003$\u0012\u0000\u009e\u009d\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a1\u0005\u001f\u0000\u0000\u00a1#\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a7\u0003 \u0010\u0000\u00a3\u00a4\u0005\u001d\u0000"+
		"\u0000\u00a4\u00a6\u0003 \u0010\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a9\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8%\u0001\u0000\u0000\u0000\u00a9"+
		"\u00a7\u0001\u0000\u0000\u0000\u00aa\u00b1\u0003(\u0014\u0000\u00ab\u00ac"+
		"\u0005\u0013\u0000\u0000\u00ac\u00b0\u0003(\u0014\u0000\u00ad\u00ae\u0005"+
		"\u0014\u0000\u0000\u00ae\u00b0\u0003(\u0014\u0000\u00af\u00ab\u0001\u0000"+
		"\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b2\'\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b4\u00bf\u0003*\u0015\u0000\u00b5\u00b6\u0005\u0015\u0000\u0000"+
		"\u00b6\u00be\u0003*\u0015\u0000\u00b7\u00b8\u0005\u0016\u0000\u0000\u00b8"+
		"\u00be\u0003*\u0015\u0000\u00b9\u00ba\u0005\u0017\u0000\u0000\u00ba\u00be"+
		"\u0003*\u0015\u0000\u00bb\u00bc\u0005\u0018\u0000\u0000\u00bc\u00be\u0003"+
		"*\u0015\u0000\u00bd\u00b5\u0001\u0000\u0000\u0000\u00bd\u00b7\u0001\u0000"+
		"\u0000\u0000\u00bd\u00b9\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000"+
		"\u0000\u0000\u00be\u00c1\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0)\u0001\u0000\u0000"+
		"\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c2\u00c9\u0003,\u0016\u0000"+
		"\u00c3\u00c4\u0005\u000e\u0000\u0000\u00c4\u00c8\u0003,\u0016\u0000\u00c5"+
		"\u00c6\u0005\u000f\u0000\u0000\u00c6\u00c8\u0003,\u0016\u0000\u00c7\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8\u00cb"+
		"\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca"+
		"\u0001\u0000\u0000\u0000\u00ca+\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001"+
		"\u0000\u0000\u0000\u00cc\u00d5\u0003.\u0017\u0000\u00cd\u00ce\u0005\u0010"+
		"\u0000\u0000\u00ce\u00d4\u0003.\u0017\u0000\u00cf\u00d0\u0005\u0011\u0000"+
		"\u0000\u00d0\u00d4\u0003.\u0017\u0000\u00d1\u00d2\u0005\u0012\u0000\u0000"+
		"\u00d2\u00d4\u0003.\u0017\u0000\u00d3\u00cd\u0001\u0000\u0000\u0000\u00d3"+
		"\u00cf\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d6-\u0001\u0000\u0000\u0000\u00d7\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d8\u00e1\u0005#\u0000\u0000\u00d9\u00e1\u0005"+
		"$\u0000\u0000\u00da\u00e1\u0005&\u0000\u0000\u00db\u00e1\u0005\"\u0000"+
		"\u0000\u00dc\u00dd\u0005\u001e\u0000\u0000\u00dd\u00de\u0003 \u0010\u0000"+
		"\u00de\u00df\u0005\u001f\u0000\u0000\u00df\u00e1\u0001\u0000\u0000\u0000"+
		"\u00e0\u00d8\u0001\u0000\u0000\u0000\u00e0\u00d9\u0001\u0000\u0000\u0000"+
		"\u00e0\u00da\u0001\u0000\u0000\u0000\u00e0\u00db\u0001\u0000\u0000\u0000"+
		"\u00e0\u00dc\u0001\u0000\u0000\u0000\u00e1/\u0001\u0000\u0000\u0000\u0014"+
		"3@H^co\u0084\u008e\u0099\u009e\u00a7\u00af\u00b1\u00bd\u00bf\u00c7\u00c9"+
		"\u00d3\u00d5\u00e0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}