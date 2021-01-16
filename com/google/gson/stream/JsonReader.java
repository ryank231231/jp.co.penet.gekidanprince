package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class JsonReader implements Closeable {
  private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
  
  private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
  
  private static final int NUMBER_CHAR_DECIMAL = 3;
  
  private static final int NUMBER_CHAR_DIGIT = 2;
  
  private static final int NUMBER_CHAR_EXP_DIGIT = 7;
  
  private static final int NUMBER_CHAR_EXP_E = 5;
  
  private static final int NUMBER_CHAR_EXP_SIGN = 6;
  
  private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
  
  private static final int NUMBER_CHAR_NONE = 0;
  
  private static final int NUMBER_CHAR_SIGN = 1;
  
  private static final int PEEKED_BEGIN_ARRAY = 3;
  
  private static final int PEEKED_BEGIN_OBJECT = 1;
  
  private static final int PEEKED_BUFFERED = 11;
  
  private static final int PEEKED_DOUBLE_QUOTED = 9;
  
  private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
  
  private static final int PEEKED_END_ARRAY = 4;
  
  private static final int PEEKED_END_OBJECT = 2;
  
  private static final int PEEKED_EOF = 17;
  
  private static final int PEEKED_FALSE = 6;
  
  private static final int PEEKED_LONG = 15;
  
  private static final int PEEKED_NONE = 0;
  
  private static final int PEEKED_NULL = 7;
  
  private static final int PEEKED_NUMBER = 16;
  
  private static final int PEEKED_SINGLE_QUOTED = 8;
  
  private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
  
  private static final int PEEKED_TRUE = 5;
  
  private static final int PEEKED_UNQUOTED = 10;
  
  private static final int PEEKED_UNQUOTED_NAME = 14;
  
  private final char[] buffer = new char[1024];
  
  private final Reader in;
  
  private boolean lenient = false;
  
  private int limit = 0;
  
  private int lineNumber = 0;
  
  private int lineStart = 0;
  
  private int[] pathIndices;
  
  private String[] pathNames;
  
  int peeked = 0;
  
  private long peekedLong;
  
  private int peekedNumberLength;
  
  private String peekedString;
  
  private int pos = 0;
  
  private int[] stack = new int[32];
  
  private int stackSize = 0;
  
  static {
    JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() {
        public void promoteNameToValue(JsonReader param1JsonReader) throws IOException {
          if (param1JsonReader instanceof JsonTreeReader) {
            ((JsonTreeReader)param1JsonReader).promoteNameToValue();
            return;
          } 
          int i = param1JsonReader.peeked;
          int j = i;
          if (i == 0)
            j = param1JsonReader.doPeek(); 
          if (j == 13) {
            param1JsonReader.peeked = 9;
          } else if (j == 12) {
            param1JsonReader.peeked = 8;
          } else {
            if (j == 14) {
              param1JsonReader.peeked = 10;
              return;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected a name but was ");
            stringBuilder.append(param1JsonReader.peek());
            stringBuilder.append(param1JsonReader.locationString());
            throw new IllegalStateException(stringBuilder.toString());
          } 
        }
      };
  }
  
  public JsonReader(Reader paramReader) {
    int[] arrayOfInt = this.stack;
    int i = this.stackSize;
    this.stackSize = i + 1;
    arrayOfInt[i] = 6;
    this.pathNames = new String[32];
    this.pathIndices = new int[32];
    if (paramReader != null) {
      this.in = paramReader;
      return;
    } 
    throw new NullPointerException("in == null");
  }
  
  private void checkLenient() throws IOException {
    if (this.lenient)
      return; 
    throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
  }
  
  private void consumeNonExecutePrefix() throws IOException {
    nextNonWhitespace(true);
    int i = --this.pos;
    char[] arrayOfChar = NON_EXECUTE_PREFIX;
    if (i + arrayOfChar.length > this.limit && !fillBuffer(arrayOfChar.length))
      return; 
    i = 0;
    while (true) {
      arrayOfChar = NON_EXECUTE_PREFIX;
      if (i < arrayOfChar.length) {
        if (this.buffer[this.pos + i] != arrayOfChar[i])
          return; 
        i++;
        continue;
      } 
      this.pos += arrayOfChar.length;
      return;
    } 
  }
  
  private boolean fillBuffer(int paramInt) throws IOException {
    char[] arrayOfChar = this.buffer;
    int i = this.lineStart;
    int j = this.pos;
    this.lineStart = i - j;
    i = this.limit;
    if (i != j) {
      this.limit = i - j;
      System.arraycopy(arrayOfChar, j, arrayOfChar, 0, this.limit);
    } else {
      this.limit = 0;
    } 
    this.pos = 0;
    while (true) {
      Reader reader = this.in;
      j = this.limit;
      j = reader.read(arrayOfChar, j, arrayOfChar.length - j);
      if (j != -1) {
        this.limit += j;
        j = paramInt;
        if (this.lineNumber == 0) {
          i = this.lineStart;
          j = paramInt;
          if (i == 0) {
            j = paramInt;
            if (this.limit > 0) {
              j = paramInt;
              if (arrayOfChar[0] == '﻿') {
                this.pos++;
                this.lineStart = i + 1;
                j = paramInt + 1;
              } 
            } 
          } 
        } 
        paramInt = j;
        if (this.limit >= j)
          return true; 
        continue;
      } 
      return false;
    } 
  }
  
  private boolean isLiteral(char paramChar) throws IOException {
    switch (paramChar) {
      default:
        return true;
      case '#':
      case '/':
      case ';':
      case '=':
      case '\\':
        checkLenient();
        break;
      case '\t':
      case '\n':
      case '\f':
      case '\r':
      case ' ':
      case ',':
      case ':':
      case '[':
      case ']':
      case '{':
      case '}':
        break;
    } 
    return false;
  }
  
  private String locationString() {
    int i = this.lineNumber;
    int j = this.pos;
    int k = this.lineStart;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" at line ");
    stringBuilder.append(i + 1);
    stringBuilder.append(" column ");
    stringBuilder.append(j - k + 1);
    stringBuilder.append(" path ");
    stringBuilder.append(getPath());
    return stringBuilder.toString();
  }
  
  private int nextNonWhitespace(boolean paramBoolean) throws IOException {
    char[] arrayOfChar = this.buffer;
    int i = this.pos;
    int j = this.limit;
    while (true) {
      StringBuilder stringBuilder1;
      int m = i;
      int n = j;
      if (i == j) {
        this.pos = i;
        if (!fillBuffer(1)) {
          if (!paramBoolean)
            return -1; 
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("End of input");
          stringBuilder1.append(locationString());
          throw new EOFException(stringBuilder1.toString());
        } 
        m = this.pos;
        n = this.limit;
      } 
      i = m + 1;
      StringBuilder stringBuilder2 = stringBuilder1[m];
      if (stringBuilder2 == 10) {
        this.lineNumber++;
        this.lineStart = i;
      } else if (stringBuilder2 != 32 && stringBuilder2 != 13 && stringBuilder2 != 9) {
        int i1;
        int i2;
        if (stringBuilder2 == 47) {
          this.pos = i;
          if (i == n) {
            this.pos--;
            boolean bool = fillBuffer(2);
            this.pos++;
            if (!bool)
              return stringBuilder2; 
          } 
          checkLenient();
          n = this.pos;
          StringBuilder stringBuilder = stringBuilder1[n];
          if (stringBuilder != 42) {
            if (stringBuilder != 47)
              return stringBuilder2; 
            this.pos = n + 1;
            skipToEndOfLine();
            i1 = this.pos;
            i2 = this.limit;
            continue;
          } 
          this.pos = n + 1;
          if (skipTo("*/")) {
            i1 = this.pos + 2;
            i2 = this.limit;
            continue;
          } 
          throw syntaxError("Unterminated comment");
        } 
        if (i2 == 35) {
          this.pos = i1;
          checkLenient();
          skipToEndOfLine();
          i1 = this.pos;
          i2 = this.limit;
          continue;
        } 
        this.pos = i1;
        return i2;
      } 
      int k = n;
    } 
  }
  
  private String nextQuotedValue(char paramChar) throws IOException {
    char[] arrayOfChar = this.buffer;
    StringBuilder stringBuilder = new StringBuilder();
    while (true) {
      int i = this.pos;
      int j = this.limit;
      int k = i;
      while (i < j) {
        int m = i + 1;
        i = arrayOfChar[i];
        if (i == paramChar) {
          this.pos = m;
          stringBuilder.append(arrayOfChar, k, m - k - 1);
          return stringBuilder.toString();
        } 
        if (i == 92) {
          this.pos = m;
          stringBuilder.append(arrayOfChar, k, m - k - 1);
          stringBuilder.append(readEscapeCharacter());
          i = this.pos;
          j = this.limit;
          k = i;
          continue;
        } 
        if (i == 10) {
          this.lineNumber++;
          this.lineStart = m;
        } 
        i = m;
      } 
      stringBuilder.append(arrayOfChar, k, i - k);
      this.pos = i;
      if (fillBuffer(1))
        continue; 
      throw syntaxError("Unterminated string");
    } 
  }
  
  private String nextUnquotedValue() throws IOException {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: iconst_0
    //   5: istore_3
    //   6: aload_0
    //   7: getfield pos : I
    //   10: istore #4
    //   12: iload #4
    //   14: iload_3
    //   15: iadd
    //   16: aload_0
    //   17: getfield limit : I
    //   20: if_icmpge -> 185
    //   23: aload_0
    //   24: getfield buffer : [C
    //   27: iload #4
    //   29: iload_3
    //   30: iadd
    //   31: caload
    //   32: lookupswitch default -> 172, 9 -> 207, 10 -> 207, 12 -> 207, 13 -> 207, 32 -> 207, 35 -> 178, 44 -> 207, 47 -> 178, 58 -> 207, 59 -> 178, 61 -> 178, 91 -> 207, 92 -> 178, 93 -> 207, 123 -> 207, 125 -> 207
    //   172: iinc #3, 1
    //   175: goto -> 6
    //   178: aload_0
    //   179: invokespecial checkLenient : ()V
    //   182: goto -> 207
    //   185: iload_3
    //   186: aload_0
    //   187: getfield buffer : [C
    //   190: arraylength
    //   191: if_icmpge -> 213
    //   194: aload_0
    //   195: iload_3
    //   196: iconst_1
    //   197: iadd
    //   198: invokespecial fillBuffer : (I)Z
    //   201: ifeq -> 207
    //   204: goto -> 6
    //   207: aload_2
    //   208: astore #5
    //   210: goto -> 264
    //   213: aload_2
    //   214: astore #5
    //   216: aload_2
    //   217: ifnonnull -> 229
    //   220: new java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial <init> : ()V
    //   227: astore #5
    //   229: aload #5
    //   231: aload_0
    //   232: getfield buffer : [C
    //   235: aload_0
    //   236: getfield pos : I
    //   239: iload_3
    //   240: invokevirtual append : ([CII)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_0
    //   245: aload_0
    //   246: getfield pos : I
    //   249: iload_3
    //   250: iadd
    //   251: putfield pos : I
    //   254: aload_0
    //   255: iconst_1
    //   256: invokespecial fillBuffer : (I)Z
    //   259: ifne -> 325
    //   262: iload_1
    //   263: istore_3
    //   264: aload #5
    //   266: ifnonnull -> 290
    //   269: new java/lang/String
    //   272: dup
    //   273: aload_0
    //   274: getfield buffer : [C
    //   277: aload_0
    //   278: getfield pos : I
    //   281: iload_3
    //   282: invokespecial <init> : ([CII)V
    //   285: astore #5
    //   287: goto -> 312
    //   290: aload #5
    //   292: aload_0
    //   293: getfield buffer : [C
    //   296: aload_0
    //   297: getfield pos : I
    //   300: iload_3
    //   301: invokevirtual append : ([CII)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload #5
    //   307: invokevirtual toString : ()Ljava/lang/String;
    //   310: astore #5
    //   312: aload_0
    //   313: aload_0
    //   314: getfield pos : I
    //   317: iload_3
    //   318: iadd
    //   319: putfield pos : I
    //   322: aload #5
    //   324: areturn
    //   325: iconst_0
    //   326: istore_3
    //   327: aload #5
    //   329: astore_2
    //   330: goto -> 6
  }
  
  private int peekKeyword() throws IOException {
    String str1;
    String str2;
    char c = this.buffer[this.pos];
    if (c == 't' || c == 'T') {
      str1 = "true";
      str2 = "TRUE";
      c = '\005';
    } else if (c == 'f' || c == 'F') {
      str1 = "false";
      str2 = "FALSE";
      c = '\006';
    } else if (c == 'n' || c == 'N') {
      str1 = "null";
      str2 = "NULL";
      c = '\007';
    } else {
      return 0;
    } 
    int i = str1.length();
    for (byte b = 1; b < i; b++) {
      if (this.pos + b >= this.limit && !fillBuffer(b + 1))
        return 0; 
      char c1 = this.buffer[this.pos + b];
      if (c1 != str1.charAt(b) && c1 != str2.charAt(b))
        return 0; 
    } 
    if ((this.pos + i < this.limit || fillBuffer(i + 1)) && isLiteral(this.buffer[this.pos + i]))
      return 0; 
    this.pos += i;
    this.peeked = c;
    return c;
  }
  
  private int peekNumber() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield buffer : [C
    //   4: astore_1
    //   5: aload_0
    //   6: getfield pos : I
    //   9: istore_2
    //   10: aload_0
    //   11: getfield limit : I
    //   14: istore_3
    //   15: iconst_0
    //   16: istore #4
    //   18: iconst_0
    //   19: istore #5
    //   21: iconst_1
    //   22: istore #6
    //   24: lconst_0
    //   25: lstore #7
    //   27: iconst_0
    //   28: istore #9
    //   30: iload_2
    //   31: istore #10
    //   33: iload_3
    //   34: istore #11
    //   36: iload_2
    //   37: iload #4
    //   39: iadd
    //   40: iload_3
    //   41: if_icmpne -> 79
    //   44: iload #4
    //   46: aload_1
    //   47: arraylength
    //   48: if_icmpne -> 53
    //   51: iconst_0
    //   52: ireturn
    //   53: aload_0
    //   54: iload #4
    //   56: iconst_1
    //   57: iadd
    //   58: invokespecial fillBuffer : (I)Z
    //   61: ifne -> 67
    //   64: goto -> 304
    //   67: aload_0
    //   68: getfield pos : I
    //   71: istore #10
    //   73: aload_0
    //   74: getfield limit : I
    //   77: istore #11
    //   79: aload_1
    //   80: iload #10
    //   82: iload #4
    //   84: iadd
    //   85: caload
    //   86: istore #12
    //   88: iload #12
    //   90: bipush #43
    //   92: if_icmpeq -> 475
    //   95: iload #12
    //   97: bipush #69
    //   99: if_icmpeq -> 452
    //   102: iload #12
    //   104: bipush #101
    //   106: if_icmpeq -> 452
    //   109: iload #12
    //   111: tableswitch default -> 132, 45 -> 423, 46 -> 409
    //   132: iload #12
    //   134: bipush #48
    //   136: if_icmplt -> 295
    //   139: iload #12
    //   141: bipush #57
    //   143: if_icmple -> 149
    //   146: goto -> 295
    //   149: iload #5
    //   151: iconst_1
    //   152: if_icmpeq -> 280
    //   155: iload #5
    //   157: ifne -> 163
    //   160: goto -> 280
    //   163: iload #5
    //   165: iconst_2
    //   166: if_icmpne -> 242
    //   169: lload #7
    //   171: lconst_0
    //   172: lcmp
    //   173: ifne -> 178
    //   176: iconst_0
    //   177: ireturn
    //   178: ldc2_w 10
    //   181: lload #7
    //   183: lmul
    //   184: iload #12
    //   186: bipush #48
    //   188: isub
    //   189: i2l
    //   190: lsub
    //   191: lstore #13
    //   193: lload #7
    //   195: ldc2_w -922337203685477580
    //   198: lcmp
    //   199: ifgt -> 227
    //   202: lload #7
    //   204: ldc2_w -922337203685477580
    //   207: lcmp
    //   208: ifne -> 222
    //   211: lload #13
    //   213: lload #7
    //   215: lcmp
    //   216: ifge -> 222
    //   219: goto -> 227
    //   222: iconst_0
    //   223: istore_3
    //   224: goto -> 229
    //   227: iconst_1
    //   228: istore_3
    //   229: lload #13
    //   231: lstore #7
    //   233: iload_3
    //   234: iload #6
    //   236: iand
    //   237: istore #6
    //   239: goto -> 485
    //   242: iload #5
    //   244: iconst_3
    //   245: if_icmpne -> 254
    //   248: iconst_4
    //   249: istore #5
    //   251: goto -> 485
    //   254: iload #5
    //   256: iconst_5
    //   257: if_icmpeq -> 273
    //   260: iload #5
    //   262: bipush #6
    //   264: if_icmpne -> 270
    //   267: goto -> 273
    //   270: goto -> 485
    //   273: bipush #7
    //   275: istore #5
    //   277: goto -> 485
    //   280: iload #12
    //   282: bipush #48
    //   284: isub
    //   285: ineg
    //   286: i2l
    //   287: lstore #7
    //   289: iconst_2
    //   290: istore #5
    //   292: goto -> 485
    //   295: aload_0
    //   296: iload #12
    //   298: invokespecial isLiteral : (C)Z
    //   301: ifne -> 407
    //   304: iload #5
    //   306: iconst_2
    //   307: if_icmpne -> 368
    //   310: iload #6
    //   312: ifeq -> 368
    //   315: lload #7
    //   317: ldc2_w -9223372036854775808
    //   320: lcmp
    //   321: ifne -> 329
    //   324: iload #9
    //   326: ifeq -> 368
    //   329: iload #9
    //   331: ifeq -> 337
    //   334: goto -> 342
    //   337: lload #7
    //   339: lneg
    //   340: lstore #7
    //   342: aload_0
    //   343: lload #7
    //   345: putfield peekedLong : J
    //   348: aload_0
    //   349: aload_0
    //   350: getfield pos : I
    //   353: iload #4
    //   355: iadd
    //   356: putfield pos : I
    //   359: aload_0
    //   360: bipush #15
    //   362: putfield peeked : I
    //   365: bipush #15
    //   367: ireturn
    //   368: iload #5
    //   370: iconst_2
    //   371: if_icmpeq -> 392
    //   374: iload #5
    //   376: iconst_4
    //   377: if_icmpeq -> 392
    //   380: iload #5
    //   382: bipush #7
    //   384: if_icmpne -> 390
    //   387: goto -> 392
    //   390: iconst_0
    //   391: ireturn
    //   392: aload_0
    //   393: iload #4
    //   395: putfield peekedNumberLength : I
    //   398: aload_0
    //   399: bipush #16
    //   401: putfield peeked : I
    //   404: bipush #16
    //   406: ireturn
    //   407: iconst_0
    //   408: ireturn
    //   409: iload #5
    //   411: iconst_2
    //   412: if_icmpne -> 421
    //   415: iconst_3
    //   416: istore #5
    //   418: goto -> 485
    //   421: iconst_0
    //   422: ireturn
    //   423: iload #5
    //   425: ifne -> 437
    //   428: iconst_1
    //   429: istore #5
    //   431: iconst_1
    //   432: istore #9
    //   434: goto -> 485
    //   437: iload #5
    //   439: iconst_5
    //   440: if_icmpne -> 450
    //   443: bipush #6
    //   445: istore #5
    //   447: goto -> 485
    //   450: iconst_0
    //   451: ireturn
    //   452: iload #5
    //   454: iconst_2
    //   455: if_icmpeq -> 469
    //   458: iload #5
    //   460: iconst_4
    //   461: if_icmpne -> 467
    //   464: goto -> 469
    //   467: iconst_0
    //   468: ireturn
    //   469: iconst_5
    //   470: istore #5
    //   472: goto -> 485
    //   475: iload #5
    //   477: iconst_5
    //   478: if_icmpne -> 497
    //   481: bipush #6
    //   483: istore #5
    //   485: iinc #4, 1
    //   488: iload #10
    //   490: istore_2
    //   491: iload #11
    //   493: istore_3
    //   494: goto -> 30
    //   497: iconst_0
    //   498: ireturn
  }
  
  private void push(int paramInt) {
    int i = this.stackSize;
    int[] arrayOfInt1 = this.stack;
    if (i == arrayOfInt1.length) {
      int[] arrayOfInt3 = new int[i * 2];
      int[] arrayOfInt4 = new int[i * 2];
      String[] arrayOfString = new String[i * 2];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt3, 0, i);
      System.arraycopy(this.pathIndices, 0, arrayOfInt4, 0, this.stackSize);
      System.arraycopy(this.pathNames, 0, arrayOfString, 0, this.stackSize);
      this.stack = arrayOfInt3;
      this.pathIndices = arrayOfInt4;
      this.pathNames = arrayOfString;
    } 
    int[] arrayOfInt2 = this.stack;
    i = this.stackSize;
    this.stackSize = i + 1;
    arrayOfInt2[i] = paramInt;
  }
  
  private char readEscapeCharacter() throws IOException {
    if (this.pos != this.limit || fillBuffer(1)) {
      char c;
      char[] arrayOfChar = this.buffer;
      int i = this.pos;
      this.pos = i + 1;
      int j = arrayOfChar[i];
      if (j != 10) {
        if (j != 34 && j != 39 && j != 47 && j != 92) {
          if (j != 98) {
            if (j != 102) {
              if (j != 110) {
                if (j != 114) {
                  switch (j) {
                    default:
                      throw syntaxError("Invalid escape sequence");
                    case 'u':
                      if (this.pos + 4 <= this.limit || fillBuffer(4)) {
                        int k = 0;
                        int m = this.pos;
                        i = m;
                        j = k;
                        while (true) {
                          k = i;
                          if (k < m + 4) {
                            char c2 = this.buffer[k];
                            char c1 = (char)(j << 4);
                            if (c2 >= '0' && c2 <= '9') {
                              c1 = (char)(c1 + c2 - 48);
                            } else if (c2 >= 'a' && c2 <= 'f') {
                              c1 = (char)(c1 + c2 - 97 + 10);
                            } else if (c2 >= 'A') {
                              if (c2 <= 'F') {
                                c1 = (char)(c1 + c2 - 65 + 10);
                              } else {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("\\u");
                                stringBuilder.append(new String(this.buffer, this.pos, 4));
                                throw new NumberFormatException(stringBuilder.toString());
                              } 
                            } else {
                              continue;
                            } 
                            k++;
                            c = c1;
                            int n = k;
                            continue;
                          } 
                          this.pos += 4;
                          return c;
                        } 
                      } 
                      throw syntaxError("Unterminated escape sequence");
                    case 't':
                      break;
                  } 
                  return '\t';
                } 
                return '\r';
              } 
              return '\n';
            } 
            return '\f';
          } 
          return '\b';
        } 
      } else {
        this.lineNumber++;
        this.lineStart = this.pos;
      } 
      return c;
    } 
    throw syntaxError("Unterminated escape sequence");
  }
  
  private void skipQuotedValue(char paramChar) throws IOException {
    char[] arrayOfChar = this.buffer;
    while (true) {
      int i = this.pos;
      int j = this.limit;
      while (i < j) {
        int k = i + 1;
        i = arrayOfChar[i];
        if (i == paramChar) {
          this.pos = k;
          return;
        } 
        if (i == 92) {
          this.pos = k;
          readEscapeCharacter();
          i = this.pos;
          j = this.limit;
          continue;
        } 
        if (i == 10) {
          this.lineNumber++;
          this.lineStart = k;
        } 
        i = k;
      } 
      this.pos = i;
      if (fillBuffer(1))
        continue; 
      throw syntaxError("Unterminated string");
    } 
  }
  
  private boolean skipTo(String paramString) throws IOException {
    label19: while (true) {
      int i = this.pos;
      int j = paramString.length();
      int k = this.limit;
      byte b = 0;
      if (i + j <= k || fillBuffer(paramString.length())) {
        char[] arrayOfChar = this.buffer;
        i = this.pos;
        if (arrayOfChar[i] == '\n') {
          this.lineNumber++;
          this.lineStart = i + 1;
          continue;
        } 
        while (b < paramString.length()) {
          if (this.buffer[this.pos + b] != paramString.charAt(b)) {
            this.pos++;
            continue label19;
          } 
          b++;
        } 
        return true;
      } 
      return false;
    } 
  }
  
  private void skipToEndOfLine() throws IOException {
    while (this.pos < this.limit || fillBuffer(1)) {
      char[] arrayOfChar = this.buffer;
      int i = this.pos;
      this.pos = i + 1;
      i = arrayOfChar[i];
      if (i == 10) {
        this.lineNumber++;
        this.lineStart = this.pos;
        break;
      } 
      if (i == 13)
        break; 
    } 
  }
  
  private void skipUnquotedValue() throws IOException {
    do {
      byte b = 0;
      while (true) {
        int i = this.pos;
        if (i + b < this.limit) {
          switch (this.buffer[i + b]) {
            default:
              b++;
              continue;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
              checkLenient();
              break;
            case '\t':
              continue;
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
              break;
          } 
          this.pos += b;
          return;
        } 
        this.pos = i + b;
        break;
      } 
    } while (fillBuffer(1));
  }
  
  private IOException syntaxError(String paramString) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(locationString());
    throw new MalformedJsonException(stringBuilder.toString());
  }
  
  public void beginArray() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 3) {
      push(1);
      this.pathIndices[this.stackSize - 1] = 0;
      this.peeked = 0;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected BEGIN_ARRAY but was ");
    stringBuilder.append(peek());
    stringBuilder.append(locationString());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void beginObject() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 1) {
      push(3);
      this.peeked = 0;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected BEGIN_OBJECT but was ");
    stringBuilder.append(peek());
    stringBuilder.append(locationString());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void close() throws IOException {
    this.peeked = 0;
    this.stack[0] = 8;
    this.stackSize = 1;
    this.in.close();
  }
  
  int doPeek() throws IOException {
    int[] arrayOfInt = this.stack;
    int i = this.stackSize;
    int j = arrayOfInt[i - 1];
    if (j == 1) {
      arrayOfInt[i - 1] = 2;
    } else if (j == 2) {
      i = nextNonWhitespace(true);
      if (i != 44) {
        if (i != 59) {
          if (i == 93) {
            this.peeked = 4;
            return 4;
          } 
          throw syntaxError("Unterminated array");
        } 
        checkLenient();
      } 
    } else {
      if (j == 3 || j == 5) {
        this.stack[this.stackSize - 1] = 4;
        if (j == 5) {
          i = nextNonWhitespace(true);
          if (i != 44) {
            if (i != 59) {
              if (i == 125) {
                this.peeked = 2;
                return 2;
              } 
              throw syntaxError("Unterminated object");
            } 
            checkLenient();
          } 
        } 
        i = nextNonWhitespace(true);
        if (i != 34) {
          if (i != 39) {
            if (i != 125) {
              checkLenient();
              this.pos--;
              if (isLiteral((char)i)) {
                this.peeked = 14;
                return 14;
              } 
              throw syntaxError("Expected name");
            } 
            if (j != 5) {
              this.peeked = 2;
              return 2;
            } 
            throw syntaxError("Expected name");
          } 
          checkLenient();
          this.peeked = 12;
          return 12;
        } 
        this.peeked = 13;
        return 13;
      } 
      if (j == 4) {
        arrayOfInt[i - 1] = 5;
        i = nextNonWhitespace(true);
        if (i != 58)
          if (i == 61) {
            checkLenient();
            if (this.pos < this.limit || fillBuffer(1)) {
              char[] arrayOfChar = this.buffer;
              i = this.pos;
              if (arrayOfChar[i] == '>')
                this.pos = i + 1; 
            } 
          } else {
            throw syntaxError("Expected ':'");
          }  
      } else if (j == 6) {
        if (this.lenient)
          consumeNonExecutePrefix(); 
        this.stack[this.stackSize - 1] = 7;
      } else if (j == 7) {
        if (nextNonWhitespace(false) == -1) {
          this.peeked = 17;
          return 17;
        } 
        checkLenient();
        this.pos--;
      } else if (j == 8) {
        throw new IllegalStateException("JsonReader is closed");
      } 
    } 
    i = nextNonWhitespace(true);
    if (i != 34) {
      if (i != 39) {
        if (i != 44 && i != 59)
          if (i != 91) {
            if (i != 93) {
              if (i != 123) {
                this.pos--;
                j = peekKeyword();
                if (j != 0)
                  return j; 
                j = peekNumber();
                if (j != 0)
                  return j; 
                if (isLiteral(this.buffer[this.pos])) {
                  checkLenient();
                  this.peeked = 10;
                  return 10;
                } 
                throw syntaxError("Expected value");
              } 
              this.peeked = 1;
              return 1;
            } 
            if (j == 1) {
              this.peeked = 4;
              return 4;
            } 
          } else {
            this.peeked = 3;
            return 3;
          }  
        if (j == 1 || j == 2) {
          checkLenient();
          this.pos--;
          this.peeked = 7;
          return 7;
        } 
        throw syntaxError("Unexpected value");
      } 
      checkLenient();
      this.peeked = 8;
      return 8;
    } 
    this.peeked = 9;
    return 9;
  }
  
  public void endArray() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 4) {
      this.stackSize--;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      this.peeked = 0;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected END_ARRAY but was ");
    stringBuilder.append(peek());
    stringBuilder.append(locationString());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void endObject() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 2) {
      this.stackSize--;
      String[] arrayOfString = this.pathNames;
      j = this.stackSize;
      arrayOfString[j] = null;
      int[] arrayOfInt = this.pathIndices;
      arrayOfInt[--j] = arrayOfInt[j] + 1;
      this.peeked = 0;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected END_OBJECT but was ");
    stringBuilder.append(peek());
    stringBuilder.append(locationString());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public String getPath() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('$');
    int i = this.stackSize;
    for (byte b = 0; b < i; b++) {
      String[] arrayOfString;
      switch (this.stack[b]) {
        case 3:
        case 4:
        case 5:
          stringBuilder.append('.');
          arrayOfString = this.pathNames;
          if (arrayOfString[b] != null)
            stringBuilder.append(arrayOfString[b]); 
          break;
        case 1:
        case 2:
          stringBuilder.append('[');
          stringBuilder.append(this.pathIndices[b]);
          stringBuilder.append(']');
          break;
      } 
    } 
    return stringBuilder.toString();
  }
  
  public boolean hasNext() throws IOException {
    boolean bool;
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j != 2 && j != 4) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public final boolean isLenient() {
    return this.lenient;
  }
  
  public boolean nextBoolean() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 5) {
      this.peeked = 0;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      return true;
    } 
    if (j == 6) {
      this.peeked = 0;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      return false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected a boolean but was ");
    stringBuilder.append(peek());
    stringBuilder.append(locationString());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public double nextDouble() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 15) {
      this.peeked = 0;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      return this.peekedLong;
    } 
    if (j == 16) {
      this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
      this.pos += this.peekedNumberLength;
    } else if (j == 8 || j == 9) {
      int k;
      if (j == 8) {
        j = 39;
        k = j;
      } else {
        j = 34;
        k = j;
      } 
      this.peekedString = nextQuotedValue(k);
    } else if (j == 10) {
      this.peekedString = nextUnquotedValue();
    } else if (j != 11) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Expected a double but was ");
      stringBuilder1.append(peek());
      stringBuilder1.append(locationString());
      throw new IllegalStateException(stringBuilder1.toString());
    } 
    this.peeked = 11;
    double d = Double.parseDouble(this.peekedString);
    if (this.lenient || (!Double.isNaN(d) && !Double.isInfinite(d))) {
      this.peekedString = null;
      this.peeked = 0;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      return d;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("JSON forbids NaN and infinities: ");
    stringBuilder.append(d);
    stringBuilder.append(locationString());
    throw new MalformedJsonException(stringBuilder.toString());
  }
  
  public int nextInt() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 15) {
      long l = this.peekedLong;
      j = (int)l;
      if (l == j) {
        this.peeked = 0;
        int[] arrayOfInt = this.pathIndices;
        i = this.stackSize - 1;
        arrayOfInt[i] = arrayOfInt[i] + 1;
        return j;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Expected an int but was ");
      stringBuilder1.append(this.peekedLong);
      stringBuilder1.append(locationString());
      throw new NumberFormatException(stringBuilder1.toString());
    } 
    if (j == 16) {
      this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
      this.pos += this.peekedNumberLength;
    } else if (j == 8 || j == 9 || j == 10) {
      if (j == 10) {
        this.peekedString = nextUnquotedValue();
      } else {
        int k;
        if (j == 8) {
          j = 39;
          k = j;
        } else {
          j = 34;
          k = j;
        } 
        this.peekedString = nextQuotedValue(k);
      } 
      try {
        j = Integer.parseInt(this.peekedString);
        this.peeked = 0;
        int[] arrayOfInt = this.pathIndices;
        i = this.stackSize - 1;
        arrayOfInt[i] = arrayOfInt[i] + 1;
        return j;
      } catch (NumberFormatException numberFormatException) {}
    } else {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Expected an int but was ");
      stringBuilder1.append(peek());
      stringBuilder1.append(locationString());
      throw new IllegalStateException(stringBuilder1.toString());
    } 
    this.peeked = 11;
    double d = Double.parseDouble(this.peekedString);
    i = (int)d;
    if (i == d) {
      this.peekedString = null;
      this.peeked = 0;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      return i;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected an int but was ");
    stringBuilder.append(this.peekedString);
    stringBuilder.append(locationString());
    throw new NumberFormatException(stringBuilder.toString());
  }
  
  public long nextLong() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 15) {
      this.peeked = 0;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      return this.peekedLong;
    } 
    if (j == 16) {
      this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
      this.pos += this.peekedNumberLength;
    } else if (j == 8 || j == 9 || j == 10) {
      if (j == 10) {
        this.peekedString = nextUnquotedValue();
      } else {
        int k;
        if (j == 8) {
          j = 39;
          k = j;
        } else {
          j = 34;
          k = j;
        } 
        this.peekedString = nextQuotedValue(k);
      } 
      try {
        long l1 = Long.parseLong(this.peekedString);
        this.peeked = 0;
        int[] arrayOfInt = this.pathIndices;
        j = this.stackSize - 1;
        arrayOfInt[j] = arrayOfInt[j] + 1;
        return l1;
      } catch (NumberFormatException numberFormatException) {}
    } else {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Expected a long but was ");
      stringBuilder1.append(peek());
      stringBuilder1.append(locationString());
      throw new IllegalStateException(stringBuilder1.toString());
    } 
    this.peeked = 11;
    double d = Double.parseDouble(this.peekedString);
    long l = (long)d;
    if (l == d) {
      this.peekedString = null;
      this.peeked = 0;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      return l;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected a long but was ");
    stringBuilder.append(this.peekedString);
    stringBuilder.append(locationString());
    throw new NumberFormatException(stringBuilder.toString());
  }
  
  public String nextName() throws IOException {
    StringBuilder stringBuilder;
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 14) {
      String str = nextUnquotedValue();
    } else if (j == 12) {
      String str = nextQuotedValue('\'');
    } else {
      if (j == 13) {
        String str = nextQuotedValue('"');
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Expected a name but was ");
      stringBuilder.append(peek());
      stringBuilder.append(locationString());
      throw new IllegalStateException(stringBuilder.toString());
    } 
    this.peeked = 0;
    this.pathNames[this.stackSize - 1] = (String)stringBuilder;
    return (String)stringBuilder;
  }
  
  public void nextNull() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 7) {
      this.peeked = 0;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected null but was ");
    stringBuilder.append(peek());
    stringBuilder.append(locationString());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public String nextString() throws IOException {
    StringBuilder stringBuilder;
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 10) {
      String str = nextUnquotedValue();
    } else if (j == 8) {
      String str = nextQuotedValue('\'');
    } else if (j == 9) {
      String str = nextQuotedValue('"');
    } else if (j == 11) {
      String str = this.peekedString;
      this.peekedString = null;
    } else if (j == 15) {
      String str = Long.toString(this.peekedLong);
    } else {
      if (j == 16) {
        String str = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
        this.peeked = 0;
        int[] arrayOfInt1 = this.pathIndices;
        j = this.stackSize - 1;
        arrayOfInt1[j] = arrayOfInt1[j] + 1;
        return str;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Expected a string but was ");
      stringBuilder.append(peek());
      stringBuilder.append(locationString());
      throw new IllegalStateException(stringBuilder.toString());
    } 
    this.peeked = 0;
    int[] arrayOfInt = this.pathIndices;
    j = this.stackSize - 1;
    arrayOfInt[j] = arrayOfInt[j] + 1;
    return (String)stringBuilder;
  }
  
  public JsonToken peek() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    switch (j) {
      default:
        throw new AssertionError();
      case 17:
        return JsonToken.END_DOCUMENT;
      case 15:
      case 16:
        return JsonToken.NUMBER;
      case 12:
      case 13:
      case 14:
        return JsonToken.NAME;
      case 8:
      case 9:
      case 10:
      case 11:
        return JsonToken.STRING;
      case 7:
        return JsonToken.NULL;
      case 5:
      case 6:
        return JsonToken.BOOLEAN;
      case 4:
        return JsonToken.END_ARRAY;
      case 3:
        return JsonToken.BEGIN_ARRAY;
      case 2:
        return JsonToken.END_OBJECT;
      case 1:
        break;
    } 
    return JsonToken.BEGIN_OBJECT;
  }
  
  public final void setLenient(boolean paramBoolean) {
    this.lenient = paramBoolean;
  }
  
  public void skipValue() throws IOException {
    int i = 0;
    while (true) {
      int j = this.peeked;
      int k = j;
      if (j == 0)
        k = doPeek(); 
      if (k == 3) {
        push(1);
        j = i + 1;
      } else if (k == 1) {
        push(3);
        j = i + 1;
      } else if (k == 4) {
        this.stackSize--;
        j = i - 1;
      } else if (k == 2) {
        this.stackSize--;
        j = i - 1;
      } else if (k == 14 || k == 10) {
        skipUnquotedValue();
        j = i;
      } else if (k == 8 || k == 12) {
        skipQuotedValue('\'');
        j = i;
      } else if (k == 9 || k == 13) {
        skipQuotedValue('"');
        j = i;
      } else {
        j = i;
        if (k == 16) {
          this.pos += this.peekedNumberLength;
          j = i;
        } 
      } 
      this.peeked = 0;
      i = j;
      if (j == 0) {
        int[] arrayOfInt = this.pathIndices;
        j = this.stackSize;
        i = j - 1;
        arrayOfInt[i] = arrayOfInt[i] + 1;
        this.pathNames[j - 1] = "null";
        return;
      } 
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append(locationString());
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\gson\stream\JsonReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */