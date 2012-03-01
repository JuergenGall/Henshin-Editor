package agg.attribute.parser.javaExpr;

/* Generated By:JavaCC: Do not edit this line. JexParserTokenManager.java */

/**
 * @version $Id: JexParserTokenManager.java,v 1.8 2010/09/23 08:15:01 olga Exp $
 * @author $Author: olga $
 */
public class JexParserTokenManager implements JexParserConstants {

	static final long serialVersionUID = 1L;

	protected static final String jjadd_escapes(String str) {
		String retval = "";
		char ch;
		for (int i = 0; i < str.length(); i++) {
			if ((ch = str.charAt(i)) == 0)
				continue;
			if (ch == '\b') {
				retval += "\\b";
			} else if (ch == '\t') {
				retval += "\\t";
			} else if (ch == '\n') {
				retval += "\\n";
			} else if (ch == '\f') {
				retval += "\\f";
			} else if (ch == '\r') {
				retval += "\\r";
			} else if (ch == '\"') {
				retval += "\\\"";
			} else if (ch == '\'') {
				retval += "\\\'";
			} else if (ch == '\\') {
				retval += "\\\\";
			} else if (ch < 0x20 || ch > 0x7e) {
				String s = "0000" + Integer.toString(ch, 16);
				retval += "\\u" + s.substring(s.length() - 4, s.length());
			} else {
				retval += ch;
			}
		}
		return retval;
	}

	static final long[] jjbitVec0 = { 0x1L, 0x0L, 0xffffffffffffffffL,
			0xffffffffffffffffL };

	@SuppressWarnings("unused")
	static private final void jjMoveNfa_0(int[] oldStates, int[] newStates) {
		int j, k;
		// MainLoop :
		for (;;) {
			if (curChar < 64) {
				int i = jjnewStateCnt;
				jjnewStateCnt = 0;
				jjround++;
				long l = 1L << curChar;
				do {
					switch (oldStates[--i]) {
					case 0:
						if ((0x3fe000000000000L & l) != 0L) {
							if (jjcurKind > 6)
								jjcurKind = 6;
							jjnextStates = jjstates0;
							break;
						} 
						continue;
					case 1:
						if ((0x3ff000000000000L & l) != 0L) {
							if (jjcurKind > 6)
								jjcurKind = 6;
							jjnextStates = jjstates0;
							break;
						}
						continue;
					case 46:
						if ((0x3ff000000000000L & l) != 0L) {
							if (jjcurKind > 6)
								jjcurKind = 6;
							jjnextStates = jjstates32;
							break;
						}
						continue;
					case 47:
						if ((0xff000000000000L & l) != 0L) {
							if (jjcurKind > 6)
								jjcurKind = 6;
							jjnextStates = jjstates34;
							break;
						}
						continue;
					case 30:
						if ((0x3ff000000000000L & l) != 0L) {
							jjnextStates = jjstates22;
							break;
						} 
						continue;
					case 31:
						if ((0x400000000000L & l) != 0L) {
							if (jjcurKind > 10)
								jjcurKind = 10;
							jjnextStates = jjstates21;
							break;
						} 
						continue;
					case 32:
						if ((0x3ff000000000000L & l) != 0L) {
							if (jjcurKind > 10)
								jjcurKind = 10;
							jjnextStates = jjstates21;
							break;
						} 
						continue;
					case 34:
						if ((0x280000000000L & l) != 0L) {
							jjnextStates = jjstates19;
							break;
						} 
						continue;
					case 35:
						if ((0x3ff000000000000L & l) != 0L) {
							if (jjcurKind > 10)
								jjcurKind = 10;
							jjnextStates = jjstates18;
							break;
						} 
						continue;
					case 3:
						if ((0x400000000000L & l) != 0L) {
							jjnextStates = jjstates5;
							break;
						} 
						continue;
					case 4:
						if ((0x3ff000000000000L & l) != 0L) {
							if (jjcurKind > 10)
								jjcurKind = 10;
							jjnextStates = jjstates4;
							break;
						} 
						continue;
					case 6:
						if ((0x280000000000L & l) != 0L) {
							jjnextStates = jjstates2;
							break;
						} 
						continue;
					case 7:
						if ((0x3ff000000000000L & l) != 0L) {
							if (jjcurKind > 10)
								jjcurKind = 10;
							jjnextStates = jjstates1;
							break;
						} 
						continue;
					case 36:
						if ((0x3ff000000000000L & l) != 0L) {
							jjnextStates = jjstates26;
							break;
						} 
						continue;
					case 38:
						if ((0x280000000000L & l) != 0L) {
							jjnextStates = jjstates24;
							break;
						} 
						continue;
					case 39:
						if ((0x3ff000000000000L & l) != 0L) {
							if (jjcurKind > 10)
								jjcurKind = 10;
							jjnextStates = jjstates23;
							break;
						} 
						continue;
					case 40:
						if ((0x3ff000000000000L & l) != 0L) {
							jjnextStates = jjstates30;
							break;
						} 
						continue;
					case 42:
						if ((0x280000000000L & l) != 0L) {
							jjnextStates = jjstates28;
							break;
						} 
						continue;
					case 43:
						if ((0x3ff000000000000L & l) != 0L) {
							jjnextStates = jjstates27;
							break;
						} 
						continue;
					case 9:
						if ((0x8000000000L & l) != 0L) {
							newStates[jjnewStateCnt + 0] = 10;
							newStates[jjnewStateCnt + 1] = 12;
							jjnewStateCnt += 2;
							
						} 
						continue;
					case 10:
						if ((0xffffff7fffffdbffL & l) != 0L) {
							jjnextStates = jjstates6;
							break;
						} 
						continue;
					case 13:
						if ((0x8400000000L & l) != 0L) {
							jjnextStates = jjstates6;
							break;
						} 
						continue;
					case 14:
						if ((0xff000000000000L & l) != 0L) {
							jjnextStates = jjstates7;
							break;
						} 
						continue;
					case 15:
						if ((0xff000000000000L & l) != 0L) {
							jjnextStates = jjstates6;
							break;
						} 
						continue;
					case 16:
						if ((0xf000000000000L & l) != 0L) {
							newStates[jjnewStateCnt + 0] = 17;
							jjnewStateCnt += 1;
							
						} 
						continue;
					case 17:
						if ((0xff000000000000L & l) != 0L) {
							jjnextStates = jjstates8;
							break;
						} 
						continue;
					case 11:
						if ((0x8000000000L & l) != 0L) {
							if (jjcurKind > 12)
								jjcurKind = 12;
							
						} 	
						continue;
					case 18:
						if ((0x400000000L & l) != 0L) {
							jjnextStates = jjstates12;
							break;
						} 
						continue;
					case 19:
						if ((0xfffffffbffffdbffL & l) != 0L) {
							jjnextStates = jjstates12;
							break;
						} 
						continue;
					case 21:
						if ((0x8400000000L & l) != 0L) {
							jjnextStates = jjstates12;
							break;
						} 
						continue;
					case 23:
						if ((0xff000000000000L & l) != 0L) {
							jjnextStates = jjstates13;
							break;
						} 
						continue;
					case 24:
						if ((0xff000000000000L & l) != 0L) {
							jjnextStates = jjstates12;
							break;
						} 
						continue;
					case 25:
						if ((0xf000000000000L & l) != 0L) {
							newStates[jjnewStateCnt + 0] = 26;
							jjnewStateCnt += 1;
							continue;
						} 
						continue;
					case 26:
						if ((0xff000000000000L & l) != 0L) {
							jjnextStates = jjstates14;
							break;
						} 
						continue;
					case 22:
						if ((0x400000000L & l) != 0L) {
							if (jjcurKind > 13)
								jjcurKind = 13;
							
						} 
						continue;
					case 28:
						if ((0x3ff000000000000L & l) != 0L) {
							if (jjcurKind > 48)
								jjcurKind = 48;
							newStates[jjnewStateCnt + 0] = 28;
							jjnewStateCnt += 1;
							
						}
						continue;
					case 29:
						if ((0x3ff000000000000L & l) != 0L) {
							jjnextStates = jjstates31;
							break;
						} 
						continue;
					case 44:
						if ((0x1000000000000L & l) != 0L) {
							if (jjcurKind > 6)
								jjcurKind = 6;
							jjnextStates = jjstates35;
							break;
						} 
						continue;
					default:
						continue;
					}
					j = jjnextStates.length;
					do {
						if (jjrounds[k = jjnextStates[--j]] != jjround) {
							jjrounds[k] = jjround;
							newStates[jjnewStateCnt++] = k;
						}
					} while (j != 0);
				} while (i != 0);
			} else if (curChar < 128) {
				int i = jjnewStateCnt;
				jjnewStateCnt = 0;
				jjround++;
				long l = 1L << (curChar & 077);
				do {
					switch (oldStates[--i]) {
					case 2:
						if ((0x100000001000L & l) != 0L) {
							if (jjcurKind > 6)
								jjcurKind = 6;
							
						} 
						continue;
					case 45:
						if ((0x100000001000000L & l) != 0L) {
							jjnextStates = jjstates33;
							break;
						} 
						continue;
					case 46:
						if ((0x7e0000007eL & l) != 0L) {
							if (jjcurKind > 6)
								jjcurKind = 6;
							jjnextStates = jjstates32;
							break;
						} 
						continue;
					case 33:
						if ((0x2000000020L & l) != 0L) {
							newStates[jjnewStateCnt + 0] = 34;
							newStates[jjnewStateCnt + 1] = 35;
							jjnewStateCnt += 2;
							
						} 
						continue;
					case 5:
						if ((0x2000000020L & l) != 0L) {
							newStates[jjnewStateCnt + 0] = 6;
							newStates[jjnewStateCnt + 1] = 7;
							jjnewStateCnt += 2;
							
						} 
						continue;
					case 8:
						if ((0x5000000050L & l) != 0L) {
							if (jjcurKind > 10)
								jjcurKind = 10;
							
						} 
						continue;
					case 37:
						if ((0x2000000020L & l) != 0L) {
							newStates[jjnewStateCnt + 0] = 38;
							newStates[jjnewStateCnt + 1] = 39;
							jjnewStateCnt += 2;
							
						} 
						continue;
					case 41:
						if ((0x2000000020L & l) != 0L) {
							newStates[jjnewStateCnt + 0] = 42;
							newStates[jjnewStateCnt + 1] = 43;
							jjnewStateCnt += 2;
							
						} 
						continue;
					case 10:
						if ((0xffffffffefffffffL & l) != 0L) {
							jjnextStates = jjstates6;
							break;
						} 
						continue;
					case 12:
						if ((0x10000000L & l) != 0L) {
							newStates[jjnewStateCnt + 0] = 13;
							newStates[jjnewStateCnt + 1] = 14;
							newStates[jjnewStateCnt + 2] = 16;
							jjnewStateCnt += 3;
							
						} 
						continue;
					case 13:
						if ((0x14404410000000L & l) != 0L) {
							jjnextStates = jjstates6;
							break;
						} 
						continue;
					case 19:
						if ((0xffffffffefffffffL & l) != 0L) {
							jjnextStates = jjstates12;
							break;
						} 
						continue;
					case 20:
						if ((0x10000000L & l) != 0L) {
							newStates[jjnewStateCnt + 0] = 21;
							newStates[jjnewStateCnt + 1] = 23;
							newStates[jjnewStateCnt + 2] = 25;
							jjnewStateCnt += 3;
							
						} 
						continue;
					case 21:
						if ((0x14404410000000L & l) != 0L) {
							jjnextStates = jjstates12;
							break;
						} 
						continue;
					case 27:
						if ((0x7fffffe87fffffeL & l) != 0L) {
							if (jjcurKind > 48)
								jjcurKind = 48;
							jjnextStates = jjstates17;
							break;
						} 
						continue;
					case 28:
						if ((0x7fffffe87fffffeL & l) != 0L) {
							if (jjcurKind > 48)
								jjcurKind = 48;
							jjnextStates = jjstates17;
							break;
						} 
						continue;
					default:
						continue;
					}
					j = jjnextStates.length;
					do {
						if (jjrounds[k = jjnextStates[--j]] != jjround) {
							jjrounds[k] = jjround;
							newStates[jjnewStateCnt++] = k;
						}
					} while (j != 0);
				} while (i != 0);
			} else {
				int i = jjnewStateCnt;
				jjnewStateCnt = 0;
				jjround++;
				int i2 = (curChar & 0xff) >> 6;
				int i1 = ((curChar >> 8) & 0xff) >> 6;
				long l2 = 1L << (curChar & 077);
				long l1 = 1L << ((curChar >> 8) & 077);
				Outer: do {
					switch (oldStates[--i]) {
					case 10:
						MatchLoop: for (;;) {
							switch ((curChar >> 8)) {
							case 0:
								if ((jjbitVec0[i2] & l2) == 0L)
									continue Outer;
								break MatchLoop;
							default:
								break;
							}
							continue Outer;
						}
						newStates[jjnewStateCnt + 0] = 11;
						jjnewStateCnt += 1;
						continue;
					case 19:
						MatchLoop: for (;;) {
							switch ((curChar >> 8)) {
							case 0:
								if ((jjbitVec0[i2] & l2) == 0L)
									continue Outer;
								break MatchLoop;
							default:
								break;
							}
							continue Outer;
						}
						newStates[jjnewStateCnt + 0] = 19;
						newStates[jjnewStateCnt + 1] = 20;
						newStates[jjnewStateCnt + 2] = 22;
						jjnewStateCnt += 3;
						continue;
					default:
						continue;
					}
				} while (i != 0);
			}
			return;
		}
	}

	static int[] StopStringLiteralDfa_0(int pos, long active0) {
		switch (pos) {
		case 0:
			if ((active0 & 0x400000L) != 0L)
				return jjstates5;
			if ((active0 & 0xf00000000000L) != 0L) {
				matchedToken.kind = 48;
				return jjstates17;
			}
			return null;
		case 1:
			if ((active0 & 0xf00000000000L) != 0L) {
				if (jjmatchedPos != 1) {
					matchedToken.kind = 48;
					jjmatchedPos = 1;
				}
				return jjstates17;
			}
			return null;
		case 2:
			if ((active0 & 0xe00000000000L) != 0L) {
				if (jjmatchedPos != 2) {
					matchedToken.kind = 48;
					jjmatchedPos = 2;
				}
				return jjstates17;
			}
			if ((active0 & 0x100000000000L) != 0L)
				return jjstates17;
			return null;
		case 3:
			if ((active0 & 0x400000000000L) != 0L) {
				if (jjmatchedPos != 3) {
					matchedToken.kind = 48;
					jjmatchedPos = 3;
				}
				return jjstates17;
			}
			if ((active0 & 0xa00000000000L) != 0L)
				return jjstates17;
			return null;
		case 4:
			if ((active0 & 0x400000000000L) != 0L)
				return jjstates17;
			return null;
		default:
			return null;
		}
	}

	static void jjStartNfa_0(int pos, long active0) {
		if ((jjstartStateSet = StopStringLiteralDfa_0(pos, active0)) != null) {
			jjnewStateCnt = jjstartStateSet.length;
			jjMoveNfa_0(jjstartStateSet, jjstateSet2);
			if (jjcurKind != 2147483647) {
				matchedToken.kind = jjcurKind;
				jjmatchedPos = pos + 1;
				jjcurKind = 2147483647;
			}
		}
		return;
	}

	static long jjnewActive_00 = 0L, jjoldActive_00 = 0L;

	static private final void jjMoveStringLiteralDfa0_0()
			throws java.io.IOException {
		ReturnLoop: for (;;) {
			MainLoop: for (;;) {
				switch (curChar) {
				case 94:
					matchedToken.kind = 29;
					break ReturnLoop;
				case 93:
					matchedToken.kind = 19;
					break ReturnLoop;
				case 91:
					matchedToken.kind = 18;
					break ReturnLoop;
				case 63:
					matchedToken.kind = 24;
					break ReturnLoop;
				case 62:
					matchedToken.kind = 34;
					jjoldActive_00 = 0x1000000000L;
					break;
				case 61:
					jjoldActive_00 = 0x80000000L;
					break;
				case 60:
					matchedToken.kind = 33;
					jjoldActive_00 = 0x800000000L;
					break;
				case 59:
					matchedToken.kind = 20;
					break ReturnLoop;
				case 58:
					matchedToken.kind = 25;
					break ReturnLoop;
				case 47:
					matchedToken.kind = 40;
					break ReturnLoop;
				case 46:
					matchedToken.kind = 22;
					jjstartStateSet = jjstates5;
					break MainLoop;
				case 45:
					matchedToken.kind = 38;
					break ReturnLoop;
				case 44:
					matchedToken.kind = 21;
					break ReturnLoop;
				case 43:
					matchedToken.kind = 37;
					break ReturnLoop;
				case 42:
					matchedToken.kind = 39;
					break ReturnLoop;
				case 41:
					matchedToken.kind = 15;
					break ReturnLoop;
				case 40:
					matchedToken.kind = 14;
					break ReturnLoop;
				case 38:
					matchedToken.kind = 30;
					jjoldActive_00 = 0x8000000L;
					break;
				case 37:
					matchedToken.kind = 41;
					break ReturnLoop;
				case 36:
					matchedToken.kind = 23;
					break ReturnLoop;
				case 33:
					matchedToken.kind = 43;
					jjoldActive_00 = 0x100000000L;
					break;
				case 32:
					matchedToken.kind = 1;
					break ReturnLoop;
				case 126:
					matchedToken.kind = 42;
					break ReturnLoop;
				case 125:
					matchedToken.kind = 17;
					break ReturnLoop;
				case 124:
					matchedToken.kind = 28;
					jjoldActive_00 = 0x4000000L;
					break;
				case 123:
					matchedToken.kind = 16;
					break ReturnLoop;
				case 116:
					jjoldActive_00 = 0x200000000000L;
					break;
				case 13:
					matchedToken.kind = 4;
					break ReturnLoop;
				case 12:
					matchedToken.kind = 5;
					break ReturnLoop;
				case 10:
					matchedToken.kind = 3;
					break ReturnLoop;
				case 110:
					jjoldActive_00 = 0x900000000000L;
					break;
				case 9:
					matchedToken.kind = 2;
					break ReturnLoop;
				case 102:
					jjoldActive_00 = 0x400000000000L;
					break;
				default:
					curPos = 1;
					if (curChar < 128)
						if ((jjstartStateSet = jjinitStates_0[curChar]) == null)
							return;
						
					jjstartStateSet = jjallInitStates_0;
					jjnewStateCnt = jjstartStateSet.length;
					jjMoveNfa_0(jjstartStateSet, jjstateSet2);
					if (jjcurKind != 2147483647) {
						matchedToken.kind = jjcurKind;
						jjcurKind = 2147483647;
					}
					return;
				}
				try {
					curChar = input_stream.readChar();
				} catch (java.io.IOException e) {
					StopStringLiteralDfa_0(0, jjoldActive_00);
					curPos = 1;
					throw e;
				}
				jjMoveStringLiteralDfa1_0();
				return;
			}
			curPos = 1;
			curChar = input_stream.readChar();
			jjnewStateCnt = jjstartStateSet.length;
			jjMoveNfa_0(jjstartStateSet, jjstateSet2);
			if (jjcurKind != 2147483647) {
				matchedToken.kind = jjcurKind;
				jjmatchedPos = 1;
				jjcurKind = 2147483647;
			}
			curPos = 2;
			return;
		}
		curPos = 1;
		return;
	}

	static private final void jjMoveStringLiteralDfa1_0()
			throws java.io.IOException {
		ReturnLoop: for (;;) {
			// MainLoop:
			for (;;) {
				StartNfaLoop: for (;;) {
					switch (curChar) {
					case 97:
						if (((jjnewActive_00 = jjoldActive_00 & 0x400000000000L)) == 0L)
							break StartNfaLoop;
						break;
					case 61:
						if ((jjoldActive_00 & 0x80000000L) != 0L) {
							matchedToken.kind = 31;
							break ReturnLoop;
						} else if ((jjoldActive_00 & 0x100000000L) != 0L) {
							matchedToken.kind = 32;
							break ReturnLoop;
						} else if ((jjoldActive_00 & 0x800000000L) != 0L) {
							matchedToken.kind = 35;
							break ReturnLoop;
						} else if ((jjoldActive_00 & 0x1000000000L) != 0L) {
							matchedToken.kind = 36;
							break ReturnLoop;
						}
						break StartNfaLoop;
					case 38:
						if ((jjoldActive_00 & 0x8000000L) != 0L) {
							matchedToken.kind = 27;
							break ReturnLoop;
						}
						break StartNfaLoop;
					case 124:
						if ((jjoldActive_00 & 0x4000000L) != 0L) {
							matchedToken.kind = 26;
							break ReturnLoop;
						}
						break StartNfaLoop;
					case 117:
						if (((jjnewActive_00 = jjoldActive_00 & 0x800000000000L)) == 0L)
							break StartNfaLoop;
						break;
					case 114:
						if (((jjnewActive_00 = jjoldActive_00 & 0x200000000000L)) == 0L)
							break StartNfaLoop;
						break;
					case 101:
						if (((jjnewActive_00 = jjoldActive_00 & 0x100000000000L)) == 0L)
							break StartNfaLoop;
						break;
					default:
						break StartNfaLoop;
					}
					try {
						curChar = input_stream.readChar();
					} catch (java.io.IOException e) {
						StopStringLiteralDfa_0(1, jjnewActive_00);
						curPos = 2;
						throw e;
					}
					jjMoveStringLiteralDfa2_0();
					return;
				}
				jjStartNfa_0(0, jjoldActive_00);
				curPos = 2;
				return;
			}
		}
		jjmatchedPos = 1;
		curPos = 2;
		return;
	}

	static private final void jjMoveStringLiteralDfa2_0()
			throws java.io.IOException {
		// ReturnLoop:
		for (;;) {
			MainLoop: for (;;) {
				StartNfaLoop: for (;;) {
					switch (curChar) {
					case 119:
						if ((jjnewActive_00 & 0x100000000000L) != 0L) {
							matchedToken.kind = 44;
							jjstartStateSet = jjstates17;
							break MainLoop;
						}
						break StartNfaLoop;
					case 117:
						if (((jjoldActive_00 = jjnewActive_00 & 0x200000000000L)) == 0L)
							break StartNfaLoop;
						break;
					case 108:
						if (((jjoldActive_00 = jjnewActive_00 & 0xc00000000000L)) == 0L)
							break StartNfaLoop;
						break;
					default:
						break StartNfaLoop;
					}
					try {
						curChar = input_stream.readChar();
					} catch (java.io.IOException e) {
						StopStringLiteralDfa_0(2, jjoldActive_00);
						curPos = 3;
						throw e;
					}
					jjMoveStringLiteralDfa3_0();
					return;
				}
				jjStartNfa_0(1, jjnewActive_00);
				curPos = 3;
				return;
			}
			jjmatchedPos = 2;
			curPos = 3;
			curChar = input_stream.readChar();
			jjnewStateCnt = jjstartStateSet.length;
			jjMoveNfa_0(jjstartStateSet, jjstateSet2);
			if (jjcurKind != 2147483647) {
				matchedToken.kind = jjcurKind;
				jjmatchedPos = 3;
				jjcurKind = 2147483647;
			}
			curPos = 4;
			return;
		}
	}

	static private final void jjMoveStringLiteralDfa3_0()
			throws java.io.IOException {
		// ReturnLoop:
		for (;;) {
			MainLoop: for (;;) {
				StartNfaLoop: for (;;) {
					switch (curChar) {
					case 115:
						if (((jjnewActive_00 = jjoldActive_00 & 0x400000000000L)) == 0L)
							break StartNfaLoop;
						break;
					case 108:
						if ((jjoldActive_00 & 0x800000000000L) != 0L) {
							matchedToken.kind = 47;
							jjstartStateSet = jjstates17;
							break MainLoop;
						}
						break StartNfaLoop;
					case 101:
						if ((jjoldActive_00 & 0x200000000000L) != 0L) {
							matchedToken.kind = 45;
							jjstartStateSet = jjstates17;
							break MainLoop;
						}
						break StartNfaLoop;
					default:
						break StartNfaLoop;
					}
					try {
						curChar = input_stream.readChar();
					} catch (java.io.IOException e) {
						StopStringLiteralDfa_0(3, jjnewActive_00);
						curPos = 4;
						throw e;
					}
					jjMoveStringLiteralDfa4_0();
					return;
				}
				jjStartNfa_0(2, jjoldActive_00);
				curPos = 4;
				return;
			}
			jjmatchedPos = 3;
			curPos = 4;
			curChar = input_stream.readChar();
			jjnewStateCnt = jjstartStateSet.length;
			jjMoveNfa_0(jjstartStateSet, jjstateSet2);
			if (jjcurKind != 2147483647) {
				matchedToken.kind = jjcurKind;
				jjmatchedPos = 4;
				jjcurKind = 2147483647;
			}
			curPos = 5;
			return;
		}
	}

	static private final void jjMoveStringLiteralDfa4_0()
			throws java.io.IOException {
		// ReturnLoop:
		for (;;) {
			MainLoop: for (;;) {
				StartNfaLoop: for (;;) {
					switch (curChar) {
					case 101:
						if ((jjnewActive_00 & 0x400000000000L) != 0L) {
							matchedToken.kind = 46;
							jjstartStateSet = jjstates17;
							break MainLoop;
						}
						break StartNfaLoop;
					default:
						break StartNfaLoop;
					}
				}
				jjStartNfa_0(3, jjnewActive_00);
				curPos = 5;
				return;
			}
			jjmatchedPos = 4;
			curPos = 5;
			curChar = input_stream.readChar();
			jjnewStateCnt = jjstartStateSet.length;
			jjMoveNfa_0(jjstartStateSet, jjstateSet2);
			if (jjcurKind != 2147483647) {
				matchedToken.kind = jjcurKind;
				jjmatchedPos = 5;
				jjcurKind = 2147483647;
			}
			curPos = 6;
			return;
		}
	}

	static final int[] jjstates0 = { 1, 2, };

	static final int[] jjstates1 = { 7, 8, };

	static final int[] jjstates2 = { 7, };

	static final int[] jjstates3 = { 6, 7, };

	static final int[] jjstates4 = { 4, 5, 8, };

	static final int[] jjstates5 = { 4, };

	static final int[] jjstates6 = { 11, };

	static final int[] jjstates7 = { 15, 11, };

	static final int[] jjstates8 = { 15, };

	static final int[] jjstates9 = { 17, };

	static final int[] jjstates10 = { 13, 14, 16, };

	static final int[] jjstates11 = { 10, 12, };

	static final int[] jjstates12 = { 19, 20, 22, };

	static final int[] jjstates13 = { 19, 20, 24, 22, };

	static final int[] jjstates14 = { 24, };

	static final int[] jjstates15 = { 26, };

	static final int[] jjstates16 = { 21, 23, 25, };

	static final int[] jjstates17 = { 28, };

	static final int[] jjstates18 = { 35, 8, };

	static final int[] jjstates19 = { 35, };

	static final int[] jjstates20 = { 34, 35, };

	static final int[] jjstates21 = { 32, 33, 8, };

	static final int[] jjstates22 = { 30, 31, };

	static final int[] jjstates23 = { 39, 8, };

	static final int[] jjstates24 = { 39, };

	static final int[] jjstates25 = { 38, 39, };

	static final int[] jjstates26 = { 36, 37, };

	static final int[] jjstates27 = { 43, 8, };

	static final int[] jjstates28 = { 43, };

	static final int[] jjstates29 = { 42, 43, };

	static final int[] jjstates30 = { 40, 41, 8, };

	static final int[] jjstates31 = { 30, 31, 36, 37, 40, 41, 8, };

	static final int[] jjstates32 = { 46, 2, };

	static final int[] jjstates33 = { 46, };

	static final int[] jjstates34 = { 47, 2, };

	static final int[] jjstates35 = { 45, 47, 2, };

	static final int[] jjallInitStates_0 = { 0, 3, 9, 18, 27, 29, 44, };

	static final int[] jjstates36 = { 18, };

	static final int[] jjstates37 = { 9, };

	static final int[] jjstates38 = { 3, };

	static final int[] jjstates39 = { 29, 44, };

	static final int[] jjstates40 = { 0, 29, };

	static final int[] jjstates41 = { 27, };

	static final int[][] jjinitStates_0 = { jjallInitStates_0, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, jjstates36,
			null, null, null, null, jjstates37, null, null, null, null, null,
			null, jjstates38, null, jjstates39, jjstates40, jjstates40,
			jjstates40, jjstates40, jjstates40, jjstates40, jjstates40,
			jjstates40, jjstates40, null, null, null, null, null, null, null,
			jjstates41, jjstates41, jjstates41, jjstates41, jjstates41,
			jjstates41, jjstates41, jjstates41, jjstates41, jjstates41,
			jjstates41, jjstates41, jjstates41, jjstates41, jjstates41,
			jjstates41, jjstates41, jjstates41, jjstates41, jjstates41,
			jjstates41, jjstates41, jjstates41, jjstates41, jjstates41,
			jjstates41, null, null, null, null, jjstates41, null, jjstates41,
			jjstates41, jjstates41, jjstates41, jjstates41, jjstates41,
			jjstates41, jjstates41, jjstates41, jjstates41, jjstates41,
			jjstates41, jjstates41, jjstates41, jjstates41, jjstates41,
			jjstates41, jjstates41, jjstates41, jjstates41, jjstates41,
			jjstates41, jjstates41, jjstates41, jjstates41, jjstates41, null,
			null, null, null, null, };

	public static final String[] jjstrLiteralImages = { null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, "\50",
			"\51", "\173", "\175", "\133", "\135", "\73", "\54", "\56", "\44",
			"\77", "\72", "\174\174", "\46\46", "\174", "\136", "\46",
			"\75\75", "\41\75", "\74", "\76", "\74\75", "\76\75", "\53", "\55",
			"\52", "\57", "\45", "\176", "\41", "\156\145\167",
			"\164\162\165\145", "\146\141\154\163\145", "\156\165\154\154",
			null, null, null, };

	public static final String[] lexStateNames = { "DEFAULT", };

	static final long[] jjtoToken = { 0x1fffffffff440L, };

	static final long[] jjtoSkip = { 0x3eL, };

	static private ASCII_CharStream input_stream;

	static private int[] jjrounds = new int[48];

	static private int[] jjstateSet1 = new int[48];

	static private int[] jjstateSet2 = new int[48];

	static private int[] jjnextStates;

	static int curPos;

	static protected char curChar;

	static int jjcurKind = 2147483647;

	static JexParserTokenManager jjme;

	public JexParserTokenManager(ASCII_CharStream stream) {
		if (input_stream != null) {
			System.err
					.println("ERROR: Second call to constructor of static lexer.  You must");
			System.err
					.println("       either use ReInit() or set the JavaCC option STATIC to false");
			System.err.println("       during lexer generation.");
			throw new Error();
		}
		input_stream = stream;
		jjme = this;
	}

	public JexParserTokenManager(ASCII_CharStream stream, int lexState) {
		if (input_stream != null) {
			System.err
					.println("ERROR: Second call to constructor of static lexer.  You must");
			System.err
					.println("       either use ReInit() or set the JavaCC option STATIC to false");
			System.err.println("       during lexer generation.");
			throw new Error();
		}
		input_stream = stream;
		jjme = this;
		if (lexState >= 1 || lexState < 0) {
			System.out.println("Error: Ignoring invalid lexical state : "
					+ lexState + ". Starting lexer in DEFAULT state.");
			curLexState = defaultLexState;
		} else
			curLexState = lexState;
	}

	static public void ReInit(ASCII_CharStream stream) {
		int i;
		jjcurKind = 2147483647;
		curPos = jjmatchedPos = jjnewStateCnt = jjround = 0;
		jjstartStateSet = null;
		curChar = (char) 0;
		jjEOFSeen = false;
		curLexState = defaultLexState;
		input_stream = stream;
		for (i = 48; i-- > 0;)
			jjrounds[i] = 0;
	}

	static public void ReInit(ASCII_CharStream stream, int lexState) {
		int i;
		jjcurKind = 2147483647;
		curPos = jjmatchedPos = jjnewStateCnt = jjround = 0;
		jjstartStateSet = null;
		curChar = (char) 0;
		jjEOFSeen = false;
		if (lexState >= 1 || lexState < 0) {
			System.out.println("Error: Ignoring invalid lexical state : "
					+ lexState + ". Reinitialzing lexer in DEFAULT state.");
			curLexState = defaultLexState;
		} else
			curLexState = lexState;
		input_stream = stream;
		for (i = 48; i-- > 0;)
			jjrounds[i] = 0;
	}

	static public void SwitchTo(int lexState) {
		if (lexState >= 1 || lexState < 0)
			System.out.println("Error: Ignoring invalid lexical state : "
					+ lexState + ". State unchanged.");
		else
			curLexState = lexState;
	}

	static int curLexState = 0;

	static int defaultLexState = 0;

	static int jjnewStateCnt;

	static int jjround;

	static private boolean jjEOFSeen = false;

	static int[] jjtmpStates = jjstateSet1;

	static int jjmatchedPos;

	static Token matchedToken;

	static Token jjspecialToken;

	static private int[] jjstartStateSet;

	static public Token getNextToken() throws ParseError {
		// System.out.println("getNextToken...");
		matchedToken = new Token();

		EOFLoop: for (;;) {
			try {
				curChar = input_stream.BeginToken();
			} catch (java.io.IOException e) {
				matchedToken.endLine = matchedToken.beginLine = input_stream
						.getBeginLine();
				matchedToken.endColumn = matchedToken.beginColumn = input_stream
						.getBeginColumn();
				matchedToken.kind = 0;
				matchedToken.image = "";
				return matchedToken;
			}

			try {
				for (;;) {
					matchedToken.kind = 2147483647;
					jjmatchedPos = 0;
					jjMoveStringLiteralDfa0_0();
					while (jjnewStateCnt != 0) {
						curChar = input_stream.readChar();
						jjMoveNfa_0(jjstateSet1 = jjstateSet2,
								jjstateSet2 = jjtmpStates);
						jjtmpStates = jjstateSet1;
						if (jjcurKind != 2147483647) {
							matchedToken.kind = jjcurKind;
							jjcurKind = 2147483647;
							jjmatchedPos = curPos++;
						} else
							curPos++;
					}

					if (matchedToken.kind != 2147483647) {
						if (jjmatchedPos + 1 < curPos)
							input_stream.backup(curPos - jjmatchedPos - 1);

						if ((jjtoToken[matchedToken.kind >> 6] & (1L << (matchedToken.kind & 077))) != 0L) {
							if ((matchedToken.image = jjstrLiteralImages[matchedToken.kind]) == null)
								matchedToken.image = input_stream.GetImage();
							matchedToken.beginLine = input_stream
									.getBeginLine();
							matchedToken.beginColumn = input_stream
									.getBeginColumn();
							matchedToken.endLine = input_stream.getEndLine();
							matchedToken.endColumn = input_stream
									.getEndColumn();
							return matchedToken;
						} 
						continue EOFLoop;
					
					} 
					jjme.error_line = input_stream.getEndLine();
					jjme.error_column = input_stream.getEndColumn();
					input_stream.backup(1);
					jjme.error_after = curPos <= 1 ? ""
									: jjadd_escapes(input_stream.GetImage());
					jjme.LexicalError();
					throw new ParseError();			
				}
			} catch (java.io.IOException e) {
				switch (curLexState) {
				default:
					break;
				}
				if (matchedToken.kind != 2147483647 && matchedToken.kind != 0) {
					if (jjmatchedPos + 1 < curPos)
						input_stream.backup(curPos - jjmatchedPos - 1);

					if ((jjtoToken[matchedToken.kind >> 6] & (1L << (matchedToken.kind & 077))) != 0L) {
						if ((matchedToken.image = jjstrLiteralImages[matchedToken.kind]) == null)
							matchedToken.image = input_stream.GetImage();
						matchedToken.beginLine = input_stream.getBeginLine();
						matchedToken.beginColumn = input_stream
								.getBeginColumn();
						matchedToken.endLine = input_stream.getEndLine();
						matchedToken.endColumn = input_stream.getEndColumn();
						return matchedToken;
					} 
					continue EOFLoop;
					
				}

				jjme.error_line = input_stream.getEndLine();
				jjme.error_column = input_stream.getEndColumn();
				input_stream.backup(1);
				jjEOFSeen = true;
				jjme.error_after = curPos <= 1 ? ""
						: jjadd_escapes(input_stream.GetImage());
				jjme.LexicalError();

				throw new ParseError();
			}
		}
	}

	protected int error_line, error_column;

	protected String error_after;

	protected void LexicalError() {
		System.err.println("Lexical error at line "
				+ this.error_line
				+ ", column "
				+ this.error_column
				+ ".  Encountered: "
				+ (jjEOFSeen ? "<EOF>" : ("\""
						+ jjadd_escapes(String.valueOf(curChar)) + "\"")
						+ " (" + (int) curChar + "), ") + "after : \""
				+ jjme.error_after + "\"");
	}
}
/*
 * $Log: JexParserTokenManager.java,v $
 * Revision 1.8  2010/09/23 08:15:01  olga
 * tuning
 *
 * Revision 1.7  2010/03/08 15:38:21  olga
 * code optimizing
 *
 * Revision 1.6  2007/09/10 13:05:47  olga
 * In this update:
 * - package xerces2.5.0 is not used anymore;
 * - class com.objectspace.jgl.Pair is replaced by the agg own generic class agg.util.Pair;
 * - bugs fixed in:  usage of PACs in rules;  match completion;
 * 	usage of static method calls in attr. conditions
 * - graph editing: added some new features
 * Revision 1.5 2007/05/07 07:59:37 olga
 * CSP: extentions of CSP variables concept
 * 
 * Revision 1.4 2007/02/19 09:11:01 olga Bug during loading file fixed. Type
 * editor tuning
 * 
 * Revision 1.3 2006/12/13 13:32:58 enrico reimplemented code
 * 
 * Revision 1.2 2006/08/09 07:42:18 olga API docu
 * 
 * Revision 1.1 2005/08/25 11:56:52 enrico *** empty log message ***
 * 
 * Revision 1.1 2005/05/30 12:58:01 olga Version with Eclipse
 * 
 * Revision 1.2 2003/03/05 18:24:16 komm sorted/optimized import statements
 * 
 * Revision 1.1.1.1 2002/07/11 12:17:04 olga Imported sources
 * 
 * Revision 1.8 2000/04/05 12:10:57 shultzke serialVersionUID aus V1.0.0
 * generiert
 * 
 * Revision 1.7 2000/03/14 10:59:45 shultzke Transformieren von Variablen auf
 * Variablen sollte jetzt funktionieren Ueber das Design der Copy-Methode des
 * abstrakten Syntaxbaumes sollte unbedingt diskutiert werden.
 * 
 */