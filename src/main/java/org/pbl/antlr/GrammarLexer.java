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
		BOOL=9, RELATIONALOP=10, EQULITYOP=11, STRING=12, COMMA=13, LPAREN=14, 
		RPAREN=15, SEMI=16, EQ=17, NEQ=18, GT=19, LT=20, GTE=21, LTE=22, IF=23, 
		ELSE=24, THEN=25, PRINT=26, TVA=27, FUNC=28, ID=29, NUM=30, COMMENT=31, 
		WS=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "INT_TYPE", "DOUBLE_TYPE", 
			"BOOL", "RELATIONALOP", "EQULITYOP", "STRING", "COMMA", "LPAREN", "RPAREN", 
			"SEMI", "EQ", "NEQ", "GT", "LT", "GTE", "LTE", "IF", "ELSE", "THEN", 
			"PRINT", "TVA", "FUNC", "ID", "NUM", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'='", "'*'", "'/'", "'+'", "'-'", "'INTEGER'", "'DOUBLE'", 
			null, null, null, null, "','", "'('", "')'", "';'", "'=='", "'!='", "'>'", 
			"'<'", "'>='", "'<='", "'if'", "'else'", "'then'", "'print'", "'tva'", 
			"'function'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "INT_TYPE", "DOUBLE_TYPE", 
			"BOOL", "RELATIONALOP", "EQULITYOP", "STRING", "COMMA", "LPAREN", "RPAREN", 
			"SEMI", "EQ", "NEQ", "GT", "LT", "GTE", "LTE", "IF", "ELSE", "THEN", 
			"PRINT", "TVA", "FUNC", "ID", "NUM", "COMMENT", "WS"
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
		"\u0004\u0000 \u00d8\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0003\bf\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tl\b\t\u0001"+
		"\n\u0001\n\u0003\np\b\n\u0001\u000b\u0001\u000b\u0005\u000bt\b\u000b\n"+
		"\u000b\f\u000bw\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c"+
		"\u0001\u001c\u0005\u001c\u00b5\b\u001c\n\u001c\f\u001c\u00b8\t\u001c\u0001"+
		"\u001d\u0004\u001d\u00bb\b\u001d\u000b\u001d\f\u001d\u00bc\u0001\u001d"+
		"\u0001\u001d\u0004\u001d\u00c1\b\u001d\u000b\u001d\f\u001d\u00c2\u0003"+
		"\u001d\u00c5\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0005"+
		"\u001e\u00cb\b\u001e\n\u001e\f\u001e\u00ce\t\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0004\u001f\u00d3\b\u001f\u000b\u001f\f\u001f\u00d4\u0001"+
		"\u001f\u0001\u001f\u0000\u0000 \u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013"+
		"\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d"+
		";\u001e=\u001f? \u0001\u0000\u0006\u0001\u0000\"\"\u0001\u0000az\u0004"+
		"\u000009AZ__az\u0001\u000009\u0002\u0000\n\n\r\r\u0003\u0000\t\n\r\r "+
		" \u00e3\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001"+
		"\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000"+
		"\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000"+
		"\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003"+
		"\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000"+
		"\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000"+
		"\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0001A"+
		"\u0001\u0000\u0000\u0000\u0003C\u0001\u0000\u0000\u0000\u0005E\u0001\u0000"+
		"\u0000\u0000\u0007G\u0001\u0000\u0000\u0000\tI\u0001\u0000\u0000\u0000"+
		"\u000bK\u0001\u0000\u0000\u0000\rM\u0001\u0000\u0000\u0000\u000fU\u0001"+
		"\u0000\u0000\u0000\u0011e\u0001\u0000\u0000\u0000\u0013k\u0001\u0000\u0000"+
		"\u0000\u0015o\u0001\u0000\u0000\u0000\u0017q\u0001\u0000\u0000\u0000\u0019"+
		"z\u0001\u0000\u0000\u0000\u001b|\u0001\u0000\u0000\u0000\u001d~\u0001"+
		"\u0000\u0000\u0000\u001f\u0080\u0001\u0000\u0000\u0000!\u0082\u0001\u0000"+
		"\u0000\u0000#\u0085\u0001\u0000\u0000\u0000%\u0088\u0001\u0000\u0000\u0000"+
		"\'\u008a\u0001\u0000\u0000\u0000)\u008c\u0001\u0000\u0000\u0000+\u008f"+
		"\u0001\u0000\u0000\u0000-\u0092\u0001\u0000\u0000\u0000/\u0095\u0001\u0000"+
		"\u0000\u00001\u009a\u0001\u0000\u0000\u00003\u009f\u0001\u0000\u0000\u0000"+
		"5\u00a5\u0001\u0000\u0000\u00007\u00a9\u0001\u0000\u0000\u00009\u00b2"+
		"\u0001\u0000\u0000\u0000;\u00ba\u0001\u0000\u0000\u0000=\u00c6\u0001\u0000"+
		"\u0000\u0000?\u00d2\u0001\u0000\u0000\u0000AB\u0005:\u0000\u0000B\u0002"+
		"\u0001\u0000\u0000\u0000CD\u0005=\u0000\u0000D\u0004\u0001\u0000\u0000"+
		"\u0000EF\u0005*\u0000\u0000F\u0006\u0001\u0000\u0000\u0000GH\u0005/\u0000"+
		"\u0000H\b\u0001\u0000\u0000\u0000IJ\u0005+\u0000\u0000J\n\u0001\u0000"+
		"\u0000\u0000KL\u0005-\u0000\u0000L\f\u0001\u0000\u0000\u0000MN\u0005I"+
		"\u0000\u0000NO\u0005N\u0000\u0000OP\u0005T\u0000\u0000PQ\u0005E\u0000"+
		"\u0000QR\u0005G\u0000\u0000RS\u0005E\u0000\u0000ST\u0005R\u0000\u0000"+
		"T\u000e\u0001\u0000\u0000\u0000UV\u0005D\u0000\u0000VW\u0005O\u0000\u0000"+
		"WX\u0005U\u0000\u0000XY\u0005B\u0000\u0000YZ\u0005L\u0000\u0000Z[\u0005"+
		"E\u0000\u0000[\u0010\u0001\u0000\u0000\u0000\\]\u0005T\u0000\u0000]^\u0005"+
		"R\u0000\u0000^_\u0005U\u0000\u0000_f\u0005E\u0000\u0000`a\u0005F\u0000"+
		"\u0000ab\u0005A\u0000\u0000bc\u0005L\u0000\u0000cd\u0005S\u0000\u0000"+
		"df\u0005E\u0000\u0000e\\\u0001\u0000\u0000\u0000e`\u0001\u0000\u0000\u0000"+
		"f\u0012\u0001\u0000\u0000\u0000gl\u0003%\u0012\u0000hl\u0003\'\u0013\u0000"+
		"il\u0003)\u0014\u0000jl\u0003+\u0015\u0000kg\u0001\u0000\u0000\u0000k"+
		"h\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kj\u0001\u0000\u0000"+
		"\u0000l\u0014\u0001\u0000\u0000\u0000mp\u0003!\u0010\u0000np\u0003#\u0011"+
		"\u0000om\u0001\u0000\u0000\u0000on\u0001\u0000\u0000\u0000p\u0016\u0001"+
		"\u0000\u0000\u0000qu\u0005\"\u0000\u0000rt\b\u0000\u0000\u0000sr\u0001"+
		"\u0000\u0000\u0000tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000"+
		"uv\u0001\u0000\u0000\u0000vx\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000"+
		"\u0000xy\u0005\"\u0000\u0000y\u0018\u0001\u0000\u0000\u0000z{\u0005,\u0000"+
		"\u0000{\u001a\u0001\u0000\u0000\u0000|}\u0005(\u0000\u0000}\u001c\u0001"+
		"\u0000\u0000\u0000~\u007f\u0005)\u0000\u0000\u007f\u001e\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0005;\u0000\u0000\u0081 \u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0005=\u0000\u0000\u0083\u0084\u0005=\u0000\u0000\u0084\"\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0005!\u0000\u0000\u0086\u0087\u0005=\u0000"+
		"\u0000\u0087$\u0001\u0000\u0000\u0000\u0088\u0089\u0005>\u0000\u0000\u0089"+
		"&\u0001\u0000\u0000\u0000\u008a\u008b\u0005<\u0000\u0000\u008b(\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0005>\u0000\u0000\u008d\u008e\u0005=\u0000"+
		"\u0000\u008e*\u0001\u0000\u0000\u0000\u008f\u0090\u0005<\u0000\u0000\u0090"+
		"\u0091\u0005=\u0000\u0000\u0091,\u0001\u0000\u0000\u0000\u0092\u0093\u0005"+
		"i\u0000\u0000\u0093\u0094\u0005f\u0000\u0000\u0094.\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0005e\u0000\u0000\u0096\u0097\u0005l\u0000\u0000\u0097"+
		"\u0098\u0005s\u0000\u0000\u0098\u0099\u0005e\u0000\u0000\u00990\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0005t\u0000\u0000\u009b\u009c\u0005h\u0000"+
		"\u0000\u009c\u009d\u0005e\u0000\u0000\u009d\u009e\u0005n\u0000\u0000\u009e"+
		"2\u0001\u0000\u0000\u0000\u009f\u00a0\u0005p\u0000\u0000\u00a0\u00a1\u0005"+
		"r\u0000\u0000\u00a1\u00a2\u0005i\u0000\u0000\u00a2\u00a3\u0005n\u0000"+
		"\u0000\u00a3\u00a4\u0005t\u0000\u0000\u00a44\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0005t\u0000\u0000\u00a6\u00a7\u0005v\u0000\u0000\u00a7\u00a8\u0005"+
		"a\u0000\u0000\u00a86\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005f\u0000"+
		"\u0000\u00aa\u00ab\u0005u\u0000\u0000\u00ab\u00ac\u0005n\u0000\u0000\u00ac"+
		"\u00ad\u0005c\u0000\u0000\u00ad\u00ae\u0005t\u0000\u0000\u00ae\u00af\u0005"+
		"i\u0000\u0000\u00af\u00b0\u0005o\u0000\u0000\u00b0\u00b1\u0005n\u0000"+
		"\u0000\u00b18\u0001\u0000\u0000\u0000\u00b2\u00b6\u0007\u0001\u0000\u0000"+
		"\u00b3\u00b5\u0007\u0002\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7:\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b9\u00bb\u0007\u0003\u0000\u0000\u00ba"+
		"\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc"+
		"\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd"+
		"\u00c4\u0001\u0000\u0000\u0000\u00be\u00c0\u0005.\u0000\u0000\u00bf\u00c1"+
		"\u0007\u0003\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4\u00be"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5<\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c7\u0005/\u0000\u0000\u00c7\u00c8\u0005/\u0000"+
		"\u0000\u00c8\u00cc\u0001\u0000\u0000\u0000\u00c9\u00cb\b\u0004\u0000\u0000"+
		"\u00ca\u00c9\u0001\u0000\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000"+
		"\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000"+
		"\u00cd\u00cf\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000"+
		"\u00cf\u00d0\u0006\u001e\u0000\u0000\u00d0>\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d3\u0007\u0005\u0000\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d7\u0006\u001f\u0000\u0000\u00d7@\u0001\u0000\u0000\u0000\u000b\u0000"+
		"ekou\u00b6\u00bc\u00c2\u00c4\u00cc\u00d4\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}