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
		T__0=1, T__1=2, T__2=3, T__3=4, ID=5, NUM=6, COMMENT=7, WS=8, INT_TYPE=9, 
		DOUBLE_TYPE=10, COMMA=11, LPAREN=12, RPAREN=13, SEMI=14, FUNC=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "ID", "NUM", "COMMENT", "WS", "INT_TYPE", 
			"DOUBLE_TYPE", "COMMA", "LPAREN", "RPAREN", "SEMI", "FUNC"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'='", "'*'", "'+'", null, null, null, null, "'INTEGER'", 
			"'DOUBLE'", "','", "'('", "')'", "';'", "'function'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "ID", "NUM", "COMMENT", "WS", "INT_TYPE", 
			"DOUBLE_TYPE", "COMMA", "LPAREN", "RPAREN", "SEMI", "FUNC"
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
		"\u0004\u0000\u000fm\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0005\u0004*\b\u0004\n\u0004"+
		"\f\u0004-\t\u0004\u0001\u0005\u0004\u00050\b\u0005\u000b\u0005\f\u0005"+
		"1\u0001\u0005\u0001\u0005\u0004\u00056\b\u0005\u000b\u0005\f\u00057\u0003"+
		"\u0005:\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006@\b\u0006\n\u0006\f\u0006C\t\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0004\u0007H\b\u0007\u000b\u0007\f\u0007I\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0000\u0000\u000f\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u0001\u0000\u0005\u0001\u0000"+
		"az\u0004\u000009AZ__az\u0001\u000009\u0002\u0000\n\n\r\r\u0003\u0000\t"+
		"\n\r\r  r\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0001\u001f\u0001\u0000\u0000\u0000"+
		"\u0003!\u0001\u0000\u0000\u0000\u0005#\u0001\u0000\u0000\u0000\u0007%"+
		"\u0001\u0000\u0000\u0000\t\'\u0001\u0000\u0000\u0000\u000b/\u0001\u0000"+
		"\u0000\u0000\r;\u0001\u0000\u0000\u0000\u000fG\u0001\u0000\u0000\u0000"+
		"\u0011M\u0001\u0000\u0000\u0000\u0013U\u0001\u0000\u0000\u0000\u0015\\"+
		"\u0001\u0000\u0000\u0000\u0017^\u0001\u0000\u0000\u0000\u0019`\u0001\u0000"+
		"\u0000\u0000\u001bb\u0001\u0000\u0000\u0000\u001dd\u0001\u0000\u0000\u0000"+
		"\u001f \u0005:\u0000\u0000 \u0002\u0001\u0000\u0000\u0000!\"\u0005=\u0000"+
		"\u0000\"\u0004\u0001\u0000\u0000\u0000#$\u0005*\u0000\u0000$\u0006\u0001"+
		"\u0000\u0000\u0000%&\u0005+\u0000\u0000&\b\u0001\u0000\u0000\u0000\'+"+
		"\u0007\u0000\u0000\u0000(*\u0007\u0001\u0000\u0000)(\u0001\u0000\u0000"+
		"\u0000*-\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000"+
		"\u0000\u0000,\n\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000.0\u0007"+
		"\u0002\u0000\u0000/.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u0000"+
		"1/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000029\u0001\u0000\u0000"+
		"\u000035\u0005.\u0000\u000046\u0007\u0002\u0000\u000054\u0001\u0000\u0000"+
		"\u000067\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000"+
		"\u0000\u00008:\u0001\u0000\u0000\u000093\u0001\u0000\u0000\u00009:\u0001"+
		"\u0000\u0000\u0000:\f\u0001\u0000\u0000\u0000;<\u0005/\u0000\u0000<=\u0005"+
		"/\u0000\u0000=A\u0001\u0000\u0000\u0000>@\b\u0003\u0000\u0000?>\u0001"+
		"\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000"+
		"AB\u0001\u0000\u0000\u0000BD\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000"+
		"\u0000DE\u0006\u0006\u0000\u0000E\u000e\u0001\u0000\u0000\u0000FH\u0007"+
		"\u0004\u0000\u0000GF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000"+
		"\u0000KL\u0006\u0007\u0000\u0000L\u0010\u0001\u0000\u0000\u0000MN\u0005"+
		"I\u0000\u0000NO\u0005N\u0000\u0000OP\u0005T\u0000\u0000PQ\u0005E\u0000"+
		"\u0000QR\u0005G\u0000\u0000RS\u0005E\u0000\u0000ST\u0005R\u0000\u0000"+
		"T\u0012\u0001\u0000\u0000\u0000UV\u0005D\u0000\u0000VW\u0005O\u0000\u0000"+
		"WX\u0005U\u0000\u0000XY\u0005B\u0000\u0000YZ\u0005L\u0000\u0000Z[\u0005"+
		"E\u0000\u0000[\u0014\u0001\u0000\u0000\u0000\\]\u0005,\u0000\u0000]\u0016"+
		"\u0001\u0000\u0000\u0000^_\u0005(\u0000\u0000_\u0018\u0001\u0000\u0000"+
		"\u0000`a\u0005)\u0000\u0000a\u001a\u0001\u0000\u0000\u0000bc\u0005;\u0000"+
		"\u0000c\u001c\u0001\u0000\u0000\u0000de\u0005f\u0000\u0000ef\u0005u\u0000"+
		"\u0000fg\u0005n\u0000\u0000gh\u0005c\u0000\u0000hi\u0005t\u0000\u0000"+
		"ij\u0005i\u0000\u0000jk\u0005o\u0000\u0000kl\u0005n\u0000\u0000l\u001e"+
		"\u0001\u0000\u0000\u0000\u0007\u0000+179AI\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}