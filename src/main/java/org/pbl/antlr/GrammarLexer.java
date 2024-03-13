// Generated from Grammar.g4 by ANTLR 4.13.1

  package org.pbl.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, INT_TYPE=7, DOUBLE_TYPE=8, 
		BOOL=9, RELATIONALOP=10, EQULITYOP=11, COMMA=12, LPAREN=13, RPAREN=14, 
		SEMI=15, EQ=16, NEQ=17, GT=18, LT=19, GTE=20, LTE=21, IF=22, ELSE=23, 
		THEN=24, PRINT=25, TVA=26, FUNC=27, ID=28, NUM=29, COMMENT=30, WS=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "INT_TYPE", "DOUBLE_TYPE", 
			"BOOL", "RELATIONALOP", "EQULITYOP", "COMMA", "LPAREN", "RPAREN", "SEMI", 
			"EQ", "NEQ", "GT", "LT", "GTE", "LTE", "IF", "ELSE", "THEN", "PRINT", 
			"TVA", "FUNC", "ID", "NUM", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'='", "'*'", "'/'", "'+'", "'-'", "'INTEGER'", "'DOUBLE'", 
			null, null, null, "','", "'('", "')'", "';'", "'=='", "'!='", "'>'", 
			"'<'", "'>='", "'<='", "'if'", "'else'", "'then'", "'print'", "'tva'", 
			"'function'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "INT_TYPE", "DOUBLE_TYPE", 
			"BOOL", "RELATIONALOP", "EQULITYOP", "COMMA", "LPAREN", "RPAREN", "SEMI", 
			"EQ", "NEQ", "GT", "LT", "GTE", "LTE", "IF", "ELSE", "THEN", "PRINT", 
			"TVA", "FUNC", "ID", "NUM", "COMMENT", "WS"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001f\u00cd\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bd\b"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tj\b\t\u0001\n\u0001\n\u0003"+
		"\nn\b\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0005\u001b\u00aa\b\u001b\n"+
		"\u001b\f\u001b\u00ad\t\u001b\u0001\u001c\u0004\u001c\u00b0\b\u001c\u000b"+
		"\u001c\f\u001c\u00b1\u0001\u001c\u0001\u001c\u0004\u001c\u00b6\b\u001c"+
		"\u000b\u001c\f\u001c\u00b7\u0003\u001c\u00ba\b\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u00c0\b\u001d\n\u001d\f\u001d"+
		"\u00c3\t\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0004\u001e\u00c8\b"+
		"\u001e\u000b\u001e\f\u001e\u00c9\u0001\u001e\u0001\u001e\u0000\u0000\u001f"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f\u0001\u0000\u0005"+
		"\u0001\u0000az\u0004\u000009AZ__az\u0001\u000009\u0002\u0000\n\n\r\r\u0003"+
		"\u0000\t\n\r\r  \u00d7\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u0000"+
		"7\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001"+
		"\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0001?\u0001\u0000\u0000"+
		"\u0000\u0003A\u0001\u0000\u0000\u0000\u0005C\u0001\u0000\u0000\u0000\u0007"+
		"E\u0001\u0000\u0000\u0000\tG\u0001\u0000\u0000\u0000\u000bI\u0001\u0000"+
		"\u0000\u0000\rK\u0001\u0000\u0000\u0000\u000fS\u0001\u0000\u0000\u0000"+
		"\u0011c\u0001\u0000\u0000\u0000\u0013i\u0001\u0000\u0000\u0000\u0015m"+
		"\u0001\u0000\u0000\u0000\u0017o\u0001\u0000\u0000\u0000\u0019q\u0001\u0000"+
		"\u0000\u0000\u001bs\u0001\u0000\u0000\u0000\u001du\u0001\u0000\u0000\u0000"+
		"\u001fw\u0001\u0000\u0000\u0000!z\u0001\u0000\u0000\u0000#}\u0001\u0000"+
		"\u0000\u0000%\u007f\u0001\u0000\u0000\u0000\'\u0081\u0001\u0000\u0000"+
		"\u0000)\u0084\u0001\u0000\u0000\u0000+\u0087\u0001\u0000\u0000\u0000-"+
		"\u008a\u0001\u0000\u0000\u0000/\u008f\u0001\u0000\u0000\u00001\u0094\u0001"+
		"\u0000\u0000\u00003\u009a\u0001\u0000\u0000\u00005\u009e\u0001\u0000\u0000"+
		"\u00007\u00a7\u0001\u0000\u0000\u00009\u00af\u0001\u0000\u0000\u0000;"+
		"\u00bb\u0001\u0000\u0000\u0000=\u00c7\u0001\u0000\u0000\u0000?@\u0005"+
		":\u0000\u0000@\u0002\u0001\u0000\u0000\u0000AB\u0005=\u0000\u0000B\u0004"+
		"\u0001\u0000\u0000\u0000CD\u0005*\u0000\u0000D\u0006\u0001\u0000\u0000"+
		"\u0000EF\u0005/\u0000\u0000F\b\u0001\u0000\u0000\u0000GH\u0005+\u0000"+
		"\u0000H\n\u0001\u0000\u0000\u0000IJ\u0005-\u0000\u0000J\f\u0001\u0000"+
		"\u0000\u0000KL\u0005I\u0000\u0000LM\u0005N\u0000\u0000MN\u0005T\u0000"+
		"\u0000NO\u0005E\u0000\u0000OP\u0005G\u0000\u0000PQ\u0005E\u0000\u0000"+
		"QR\u0005R\u0000\u0000R\u000e\u0001\u0000\u0000\u0000ST\u0005D\u0000\u0000"+
		"TU\u0005O\u0000\u0000UV\u0005U\u0000\u0000VW\u0005B\u0000\u0000WX\u0005"+
		"L\u0000\u0000XY\u0005E\u0000\u0000Y\u0010\u0001\u0000\u0000\u0000Z[\u0005"+
		"T\u0000\u0000[\\\u0005R\u0000\u0000\\]\u0005U\u0000\u0000]d\u0005E\u0000"+
		"\u0000^_\u0005F\u0000\u0000_`\u0005A\u0000\u0000`a\u0005L\u0000\u0000"+
		"ab\u0005S\u0000\u0000bd\u0005E\u0000\u0000cZ\u0001\u0000\u0000\u0000c"+
		"^\u0001\u0000\u0000\u0000d\u0012\u0001\u0000\u0000\u0000ej\u0003#\u0011"+
		"\u0000fj\u0003%\u0012\u0000gj\u0003\'\u0013\u0000hj\u0003)\u0014\u0000"+
		"ie\u0001\u0000\u0000\u0000if\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000"+
		"\u0000ih\u0001\u0000\u0000\u0000j\u0014\u0001\u0000\u0000\u0000kn\u0003"+
		"\u001f\u000f\u0000ln\u0003!\u0010\u0000mk\u0001\u0000\u0000\u0000ml\u0001"+
		"\u0000\u0000\u0000n\u0016\u0001\u0000\u0000\u0000op\u0005,\u0000\u0000"+
		"p\u0018\u0001\u0000\u0000\u0000qr\u0005(\u0000\u0000r\u001a\u0001\u0000"+
		"\u0000\u0000st\u0005)\u0000\u0000t\u001c\u0001\u0000\u0000\u0000uv\u0005"+
		";\u0000\u0000v\u001e\u0001\u0000\u0000\u0000wx\u0005=\u0000\u0000xy\u0005"+
		"=\u0000\u0000y \u0001\u0000\u0000\u0000z{\u0005!\u0000\u0000{|\u0005="+
		"\u0000\u0000|\"\u0001\u0000\u0000\u0000}~\u0005>\u0000\u0000~$\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0005<\u0000\u0000\u0080&\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0005>\u0000\u0000\u0082\u0083\u0005=\u0000\u0000\u0083("+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0005<\u0000\u0000\u0085\u0086\u0005"+
		"=\u0000\u0000\u0086*\u0001\u0000\u0000\u0000\u0087\u0088\u0005i\u0000"+
		"\u0000\u0088\u0089\u0005f\u0000\u0000\u0089,\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0005e\u0000\u0000\u008b\u008c\u0005l\u0000\u0000\u008c\u008d\u0005"+
		"s\u0000\u0000\u008d\u008e\u0005e\u0000\u0000\u008e.\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0005t\u0000\u0000\u0090\u0091\u0005h\u0000\u0000\u0091"+
		"\u0092\u0005e\u0000\u0000\u0092\u0093\u0005n\u0000\u0000\u00930\u0001"+
		"\u0000\u0000\u0000\u0094\u0095\u0005p\u0000\u0000\u0095\u0096\u0005r\u0000"+
		"\u0000\u0096\u0097\u0005i\u0000\u0000\u0097\u0098\u0005n\u0000\u0000\u0098"+
		"\u0099\u0005t\u0000\u0000\u00992\u0001\u0000\u0000\u0000\u009a\u009b\u0005"+
		"t\u0000\u0000\u009b\u009c\u0005v\u0000\u0000\u009c\u009d\u0005a\u0000"+
		"\u0000\u009d4\u0001\u0000\u0000\u0000\u009e\u009f\u0005f\u0000\u0000\u009f"+
		"\u00a0\u0005u\u0000\u0000\u00a0\u00a1\u0005n\u0000\u0000\u00a1\u00a2\u0005"+
		"c\u0000\u0000\u00a2\u00a3\u0005t\u0000\u0000\u00a3\u00a4\u0005i\u0000"+
		"\u0000\u00a4\u00a5\u0005o\u0000\u0000\u00a5\u00a6\u0005n\u0000\u0000\u00a6"+
		"6\u0001\u0000\u0000\u0000\u00a7\u00ab\u0007\u0000\u0000\u0000\u00a8\u00aa"+
		"\u0007\u0001\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ad"+
		"\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0001\u0000\u0000\u0000\u00ac8\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001"+
		"\u0000\u0000\u0000\u00ae\u00b0\u0007\u0002\u0000\u0000\u00af\u00ae\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00af\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b9\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b5\u0005.\u0000\u0000\u00b4\u00b6\u0007\u0002"+
		"\u0000\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000"+
		"\u0000\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000\u00b9\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba:\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bc\u0005/\u0000\u0000\u00bc\u00bd\u0005/\u0000\u0000\u00bd"+
		"\u00c1\u0001\u0000\u0000\u0000\u00be\u00c0\b\u0003\u0000\u0000\u00bf\u00be"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000\u0000\u00c1\u00bf"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c5"+
		"\u0006\u001d\u0000\u0000\u00c5<\u0001\u0000\u0000\u0000\u00c6\u00c8\u0007"+
		"\u0004\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001"+
		"\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cc\u0006"+
		"\u001e\u0000\u0000\u00cc>\u0001\u0000\u0000\u0000\n\u0000cim\u00ab\u00b1"+
		"\u00b7\u00b9\u00c1\u00c9\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}