package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import java.util.BitSet;

@GwtCompatible(emulated = true)
public abstract class CharMatcher implements Predicate<Character> {
  @Deprecated
  public static final CharMatcher ANY;
  
  @Deprecated
  public static final CharMatcher ASCII;
  
  @Deprecated
  public static final CharMatcher BREAKING_WHITESPACE;
  
  @Deprecated
  public static final CharMatcher DIGIT;
  
  private static final int DISTINCT_CHARS = 65536;
  
  @Deprecated
  public static final CharMatcher INVISIBLE;
  
  @Deprecated
  public static final CharMatcher JAVA_DIGIT;
  
  @Deprecated
  public static final CharMatcher JAVA_ISO_CONTROL;
  
  @Deprecated
  public static final CharMatcher JAVA_LETTER;
  
  @Deprecated
  public static final CharMatcher JAVA_LETTER_OR_DIGIT;
  
  @Deprecated
  public static final CharMatcher JAVA_LOWER_CASE;
  
  @Deprecated
  public static final CharMatcher JAVA_UPPER_CASE;
  
  @Deprecated
  public static final CharMatcher NONE;
  
  @Deprecated
  public static final CharMatcher SINGLE_WIDTH;
  
  @Deprecated
  public static final CharMatcher WHITESPACE = whitespace();
  
  static {
    BREAKING_WHITESPACE = breakingWhitespace();
    ASCII = ascii();
    DIGIT = digit();
    JAVA_DIGIT = javaDigit();
    JAVA_LETTER = javaLetter();
    JAVA_LETTER_OR_DIGIT = javaLetterOrDigit();
    JAVA_UPPER_CASE = javaUpperCase();
    JAVA_LOWER_CASE = javaLowerCase();
    JAVA_ISO_CONTROL = javaIsoControl();
    INVISIBLE = invisible();
    SINGLE_WIDTH = singleWidth();
    ANY = any();
    NONE = none();
  }
  
  public static CharMatcher any() {
    return Any.INSTANCE;
  }
  
  public static CharMatcher anyOf(CharSequence paramCharSequence) {
    switch (paramCharSequence.length()) {
      default:
        return new AnyOf(paramCharSequence);
      case 2:
        return isEither(paramCharSequence.charAt(0), paramCharSequence.charAt(1));
      case 1:
        return is(paramCharSequence.charAt(0));
      case 0:
        break;
    } 
    return none();
  }
  
  public static CharMatcher ascii() {
    return Ascii.INSTANCE;
  }
  
  public static CharMatcher breakingWhitespace() {
    return BreakingWhitespace.INSTANCE;
  }
  
  public static CharMatcher digit() {
    return Digit.INSTANCE;
  }
  
  private String finishCollapseFrom(CharSequence paramCharSequence, int paramInt1, int paramInt2, char paramChar, StringBuilder paramStringBuilder, boolean paramBoolean) {
    boolean bool;
    for (bool = paramBoolean; paramInt1 < paramInt2; bool = paramBoolean) {
      char c = paramCharSequence.charAt(paramInt1);
      if (matches(c)) {
        paramBoolean = bool;
        if (!bool) {
          paramStringBuilder.append(paramChar);
          paramBoolean = true;
        } 
      } else {
        paramStringBuilder.append(c);
        paramBoolean = false;
      } 
      paramInt1++;
    } 
    return paramStringBuilder.toString();
  }
  
  public static CharMatcher forPredicate(Predicate<? super Character> paramPredicate) {
    if (paramPredicate instanceof CharMatcher) {
      paramPredicate = paramPredicate;
    } else {
      paramPredicate = new ForPredicate(paramPredicate);
    } 
    return (CharMatcher)paramPredicate;
  }
  
  public static CharMatcher inRange(char paramChar1, char paramChar2) {
    return new InRange(paramChar1, paramChar2);
  }
  
  public static CharMatcher invisible() {
    return Invisible.INSTANCE;
  }
  
  public static CharMatcher is(char paramChar) {
    return new Is(paramChar);
  }
  
  private static IsEither isEither(char paramChar1, char paramChar2) {
    return new IsEither(paramChar1, paramChar2);
  }
  
  public static CharMatcher isNot(char paramChar) {
    return new IsNot(paramChar);
  }
  
  @GwtIncompatible
  private static boolean isSmall(int paramInt1, int paramInt2) {
    boolean bool;
    if (paramInt1 <= 1023 && paramInt2 > paramInt1 * 4 * 16) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static CharMatcher javaDigit() {
    return JavaDigit.INSTANCE;
  }
  
  public static CharMatcher javaIsoControl() {
    return JavaIsoControl.INSTANCE;
  }
  
  public static CharMatcher javaLetter() {
    return JavaLetter.INSTANCE;
  }
  
  public static CharMatcher javaLetterOrDigit() {
    return JavaLetterOrDigit.INSTANCE;
  }
  
  public static CharMatcher javaLowerCase() {
    return JavaLowerCase.INSTANCE;
  }
  
  public static CharMatcher javaUpperCase() {
    return JavaUpperCase.INSTANCE;
  }
  
  public static CharMatcher none() {
    return None.INSTANCE;
  }
  
  public static CharMatcher noneOf(CharSequence paramCharSequence) {
    return anyOf(paramCharSequence).negate();
  }
  
  @GwtIncompatible
  private static CharMatcher precomputedPositive(int paramInt, BitSet paramBitSet, String paramString) {
    char c;
    switch (paramInt) {
      default:
        if (isSmall(paramInt, paramBitSet.length()))
          return SmallCharMatcher.from(paramBitSet, paramString); 
        break;
      case 2:
        c = (char)paramBitSet.nextSetBit(0);
        return isEither(c, (char)paramBitSet.nextSetBit(c + 1));
      case 1:
        return is((char)paramBitSet.nextSetBit(0));
      case 0:
        return none();
    } 
    return new BitSetMatcher(paramBitSet, paramString);
  }
  
  private static String showCharacter(char paramChar) {
    char[] arrayOfChar = new char[6];
    arrayOfChar[0] = '\\';
    arrayOfChar[1] = 'u';
    arrayOfChar[2] = Character.MIN_VALUE;
    arrayOfChar[3] = Character.MIN_VALUE;
    arrayOfChar[4] = Character.MIN_VALUE;
    arrayOfChar[5] = Character.MIN_VALUE;
    boolean bool = false;
    char c = paramChar;
    for (paramChar = bool; paramChar < '\004'; paramChar++) {
      arrayOfChar[5 - paramChar] = "0123456789ABCDEF".charAt(c & 0xF);
      c = (char)(c >> 4);
    } 
    return String.copyValueOf(arrayOfChar);
  }
  
  public static CharMatcher singleWidth() {
    return SingleWidth.INSTANCE;
  }
  
  public static CharMatcher whitespace() {
    return Whitespace.INSTANCE;
  }
  
  public CharMatcher and(CharMatcher paramCharMatcher) {
    return new And(this, paramCharMatcher);
  }
  
  @Deprecated
  public boolean apply(Character paramCharacter) {
    return matches(paramCharacter.charValue());
  }
  
  public String collapseFrom(CharSequence paramCharSequence, char paramChar) {
    int i = paramCharSequence.length();
    int j;
    for (j = 0; j < i; j = k + 1) {
      char c = paramCharSequence.charAt(j);
      int k = j;
      if (matches(c))
        if (c == paramChar && (j == i - 1 || !matches(paramCharSequence.charAt(j + 1)))) {
          k = j + 1;
        } else {
          StringBuilder stringBuilder = new StringBuilder(i);
          stringBuilder.append(paramCharSequence, 0, j);
          stringBuilder.append(paramChar);
          return finishCollapseFrom(paramCharSequence, j + 1, i, paramChar, stringBuilder, true);
        }  
    } 
    return paramCharSequence.toString();
  }
  
  public int countIn(CharSequence paramCharSequence) {
    byte b = 0;
    int i;
    for (i = 0; b < paramCharSequence.length(); i = j) {
      int j = i;
      if (matches(paramCharSequence.charAt(b)))
        j = i + 1; 
      b++;
    } 
    return i;
  }
  
  public int indexIn(CharSequence paramCharSequence) {
    return indexIn(paramCharSequence, 0);
  }
  
  public int indexIn(CharSequence paramCharSequence, int paramInt) {
    int i = paramCharSequence.length();
    Preconditions.checkPositionIndex(paramInt, i);
    while (paramInt < i) {
      if (matches(paramCharSequence.charAt(paramInt)))
        return paramInt; 
      paramInt++;
    } 
    return -1;
  }
  
  public int lastIndexIn(CharSequence paramCharSequence) {
    for (int i = paramCharSequence.length() - 1; i >= 0; i--) {
      if (matches(paramCharSequence.charAt(i)))
        return i; 
    } 
    return -1;
  }
  
  public abstract boolean matches(char paramChar);
  
  public boolean matchesAllOf(CharSequence paramCharSequence) {
    for (int i = paramCharSequence.length() - 1; i >= 0; i--) {
      if (!matches(paramCharSequence.charAt(i)))
        return false; 
    } 
    return true;
  }
  
  public boolean matchesAnyOf(CharSequence paramCharSequence) {
    return matchesNoneOf(paramCharSequence) ^ true;
  }
  
  public boolean matchesNoneOf(CharSequence paramCharSequence) {
    boolean bool;
    if (indexIn(paramCharSequence) == -1) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public CharMatcher negate() {
    return new Negated(this);
  }
  
  public CharMatcher or(CharMatcher paramCharMatcher) {
    return new Or(this, paramCharMatcher);
  }
  
  public CharMatcher precomputed() {
    return Platform.precomputeCharMatcher(this);
  }
  
  @GwtIncompatible
  CharMatcher precomputedInternal() {
    String str2;
    BitSet bitSet = new BitSet();
    setBits(bitSet);
    int i = bitSet.cardinality();
    if (i * 2 <= 65536)
      return precomputedPositive(i, bitSet, toString()); 
    bitSet.flip(0, 65536);
    final String description = toString();
    if (str1.endsWith(".negate()")) {
      str2 = str1.substring(0, str1.length() - 9);
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(".negate()");
      str2 = stringBuilder.toString();
    } 
    return new NegatedFastMatcher(precomputedPositive(65536 - i, bitSet, str2)) {
        public String toString() {
          return description;
        }
      };
  }
  
  public String removeFrom(CharSequence paramCharSequence) {
    paramCharSequence = paramCharSequence.toString();
    int i = indexIn(paramCharSequence);
    if (i == -1)
      return (String)paramCharSequence; 
    char[] arrayOfChar = paramCharSequence.toCharArray();
    byte b = 1;
    label15: while (true) {
      i++;
      while (true) {
        if (i == arrayOfChar.length)
          return new String(arrayOfChar, 0, i - b); 
        if (matches(arrayOfChar[i])) {
          b++;
          continue label15;
        } 
        arrayOfChar[i - b] = arrayOfChar[i];
        i++;
      } 
      break;
    } 
  }
  
  public String replaceFrom(CharSequence paramCharSequence, char paramChar) {
    paramCharSequence = paramCharSequence.toString();
    int i = indexIn(paramCharSequence);
    if (i == -1)
      return (String)paramCharSequence; 
    char[] arrayOfChar = paramCharSequence.toCharArray();
    arrayOfChar[i] = (char)paramChar;
    while (true) {
      int j = i + 1;
      if (j < arrayOfChar.length) {
        i = j;
        if (matches(arrayOfChar[j])) {
          arrayOfChar[j] = (char)paramChar;
          i = j;
        } 
        continue;
      } 
      return new String(arrayOfChar);
    } 
  }
  
  public String replaceFrom(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
    int i = paramCharSequence2.length();
    if (i == 0)
      return removeFrom(paramCharSequence1); 
    int j = 0;
    if (i == 1)
      return replaceFrom(paramCharSequence1, paramCharSequence2.charAt(0)); 
    paramCharSequence1 = paramCharSequence1.toString();
    i = indexIn(paramCharSequence1);
    if (i == -1)
      return (String)paramCharSequence1; 
    int k = paramCharSequence1.length();
    StringBuilder stringBuilder = new StringBuilder(k * 3 / 2 + 16);
    while (true) {
      stringBuilder.append(paramCharSequence1, j, i);
      stringBuilder.append(paramCharSequence2);
      int m = i + 1;
      int n = indexIn(paramCharSequence1, m);
      i = n;
      j = m;
      if (n == -1) {
        stringBuilder.append(paramCharSequence1, m, k);
        return stringBuilder.toString();
      } 
    } 
  }
  
  public String retainFrom(CharSequence paramCharSequence) {
    return negate().removeFrom(paramCharSequence);
  }
  
  @GwtIncompatible
  void setBits(BitSet paramBitSet) {
    for (char c = '￿'; c >= '\000'; c--) {
      if (matches((char)c))
        paramBitSet.set(c); 
    } 
  }
  
  public String toString() {
    return super.toString();
  }
  
  public String trimAndCollapseFrom(CharSequence paramCharSequence, char paramChar) {
    int i = paramCharSequence.length();
    int j = i - 1;
    byte b;
    for (b = 0; b < i && matches(paramCharSequence.charAt(b)); b++);
    for (i = j; i > b && matches(paramCharSequence.charAt(i)); i--);
    if (b == 0 && i == j) {
      paramCharSequence = collapseFrom(paramCharSequence, paramChar);
    } else {
      paramCharSequence = finishCollapseFrom(paramCharSequence, b, ++i, paramChar, new StringBuilder(i - b), false);
    } 
    return (String)paramCharSequence;
  }
  
  public String trimFrom(CharSequence paramCharSequence) {
    int i = paramCharSequence.length();
    byte b;
    for (b = 0; b < i && matches(paramCharSequence.charAt(b)); b++);
    while (--i > b && matches(paramCharSequence.charAt(i)))
      i--; 
    return paramCharSequence.subSequence(b, i + 1).toString();
  }
  
  public String trimLeadingFrom(CharSequence paramCharSequence) {
    int i = paramCharSequence.length();
    for (byte b = 0; b < i; b++) {
      if (!matches(paramCharSequence.charAt(b)))
        return paramCharSequence.subSequence(b, i).toString(); 
    } 
    return "";
  }
  
  public String trimTrailingFrom(CharSequence paramCharSequence) {
    for (int i = paramCharSequence.length() - 1; i >= 0; i--) {
      if (!matches(paramCharSequence.charAt(i)))
        return paramCharSequence.subSequence(0, i + 1).toString(); 
    } 
    return "";
  }
  
  private static final class And extends CharMatcher {
    final CharMatcher first;
    
    final CharMatcher second;
    
    And(CharMatcher param1CharMatcher1, CharMatcher param1CharMatcher2) {
      this.first = Preconditions.<CharMatcher>checkNotNull(param1CharMatcher1);
      this.second = Preconditions.<CharMatcher>checkNotNull(param1CharMatcher2);
    }
    
    public boolean matches(char param1Char) {
      boolean bool;
      if (this.first.matches(param1Char) && this.second.matches(param1Char)) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    @GwtIncompatible
    void setBits(BitSet param1BitSet) {
      BitSet bitSet1 = new BitSet();
      this.first.setBits(bitSet1);
      BitSet bitSet2 = new BitSet();
      this.second.setBits(bitSet2);
      bitSet1.and(bitSet2);
      param1BitSet.or(bitSet1);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharMatcher.and(");
      stringBuilder.append(this.first);
      stringBuilder.append(", ");
      stringBuilder.append(this.second);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static final class Any extends NamedFastMatcher {
    static final Any INSTANCE = new Any();
    
    private Any() {
      super("CharMatcher.any()");
    }
    
    public CharMatcher and(CharMatcher param1CharMatcher) {
      return Preconditions.<CharMatcher>checkNotNull(param1CharMatcher);
    }
    
    public String collapseFrom(CharSequence param1CharSequence, char param1Char) {
      if (param1CharSequence.length() == 0) {
        param1CharSequence = "";
      } else {
        param1CharSequence = String.valueOf(param1Char);
      } 
      return (String)param1CharSequence;
    }
    
    public int countIn(CharSequence param1CharSequence) {
      return param1CharSequence.length();
    }
    
    public int indexIn(CharSequence param1CharSequence) {
      boolean bool;
      if (param1CharSequence.length() == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int indexIn(CharSequence param1CharSequence, int param1Int) {
      int i = param1CharSequence.length();
      Preconditions.checkPositionIndex(param1Int, i);
      int j = param1Int;
      if (param1Int == i)
        j = -1; 
      return j;
    }
    
    public int lastIndexIn(CharSequence param1CharSequence) {
      return param1CharSequence.length() - 1;
    }
    
    public boolean matches(char param1Char) {
      return true;
    }
    
    public boolean matchesAllOf(CharSequence param1CharSequence) {
      Preconditions.checkNotNull(param1CharSequence);
      return true;
    }
    
    public boolean matchesNoneOf(CharSequence param1CharSequence) {
      boolean bool;
      if (param1CharSequence.length() == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public CharMatcher negate() {
      return none();
    }
    
    public CharMatcher or(CharMatcher param1CharMatcher) {
      Preconditions.checkNotNull(param1CharMatcher);
      return this;
    }
    
    public String removeFrom(CharSequence param1CharSequence) {
      Preconditions.checkNotNull(param1CharSequence);
      return "";
    }
    
    public String replaceFrom(CharSequence param1CharSequence, char param1Char) {
      char[] arrayOfChar = new char[param1CharSequence.length()];
      Arrays.fill(arrayOfChar, param1Char);
      return new String(arrayOfChar);
    }
    
    public String replaceFrom(CharSequence param1CharSequence1, CharSequence param1CharSequence2) {
      StringBuilder stringBuilder = new StringBuilder(param1CharSequence1.length() * param1CharSequence2.length());
      for (byte b = 0; b < param1CharSequence1.length(); b++)
        stringBuilder.append(param1CharSequence2); 
      return stringBuilder.toString();
    }
    
    public String trimFrom(CharSequence param1CharSequence) {
      Preconditions.checkNotNull(param1CharSequence);
      return "";
    }
  }
  
  private static final class AnyOf extends CharMatcher {
    private final char[] chars;
    
    public AnyOf(CharSequence param1CharSequence) {
      this.chars = param1CharSequence.toString().toCharArray();
      Arrays.sort(this.chars);
    }
    
    public boolean matches(char param1Char) {
      boolean bool;
      if (Arrays.binarySearch(this.chars, param1Char) >= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    @GwtIncompatible
    void setBits(BitSet param1BitSet) {
      char[] arrayOfChar = this.chars;
      int i = arrayOfChar.length;
      for (byte b = 0; b < i; b++)
        param1BitSet.set(arrayOfChar[b]); 
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder("CharMatcher.anyOf(\"");
      char[] arrayOfChar = this.chars;
      int i = arrayOfChar.length;
      for (byte b = 0; b < i; b++)
        stringBuilder.append(CharMatcher.showCharacter(arrayOfChar[b])); 
      stringBuilder.append("\")");
      return stringBuilder.toString();
    }
  }
  
  private static final class Ascii extends NamedFastMatcher {
    static final Ascii INSTANCE = new Ascii();
    
    Ascii() {
      super("CharMatcher.ascii()");
    }
    
    public boolean matches(char param1Char) {
      boolean bool;
      if (param1Char <= '') {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
  }
  
  @GwtIncompatible
  private static final class BitSetMatcher extends NamedFastMatcher {
    private final BitSet table;
    
    private BitSetMatcher(BitSet param1BitSet, String param1String) {
      super(param1String);
      BitSet bitSet = param1BitSet;
      if (param1BitSet.length() + 64 < param1BitSet.size())
        bitSet = (BitSet)param1BitSet.clone(); 
      this.table = bitSet;
    }
    
    public boolean matches(char param1Char) {
      return this.table.get(param1Char);
    }
    
    void setBits(BitSet param1BitSet) {
      param1BitSet.or(this.table);
    }
  }
  
  private static final class BreakingWhitespace extends CharMatcher {
    static final CharMatcher INSTANCE = new BreakingWhitespace();
    
    public boolean matches(char param1Char) {
      boolean bool = true;
      if (param1Char != ' ' && param1Char != '' && param1Char != ' ')
        if (param1Char != ' ') {
          if (param1Char != ' ' && param1Char != '　')
            switch (param1Char) {
              default:
                switch (param1Char) {
                  default:
                    if (param1Char < ' ' || param1Char > ' ')
                      bool = false; 
                    return bool;
                  case ' ':
                  case ' ':
                    break;
                } 
                break;
              case '\t':
              case '\n':
              case '\013':
              case '\f':
              case '\r':
                break;
            }  
        } else {
          return false;
        }  
      return true;
    }
    
    public String toString() {
      return "CharMatcher.breakingWhitespace()";
    }
  }
  
  private static final class Digit extends RangesMatcher {
    static final Digit INSTANCE = new Digit();
    
    private static final String ZEROES = "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０";
    
    private Digit() {
      super("CharMatcher.digit()", zeroes(), nines());
    }
    
    private static char[] nines() {
      char[] arrayOfChar = new char[31];
      for (byte b = 0; b < 31; b++)
        arrayOfChar[b] = (char)(char)("0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".charAt(b) + 9); 
      return arrayOfChar;
    }
    
    private static char[] zeroes() {
      return "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
    }
  }
  
  static abstract class FastMatcher extends CharMatcher {
    public CharMatcher negate() {
      return new CharMatcher.NegatedFastMatcher(this);
    }
    
    public final CharMatcher precomputed() {
      return this;
    }
  }
  
  private static final class ForPredicate extends CharMatcher {
    private final Predicate<? super Character> predicate;
    
    ForPredicate(Predicate<? super Character> param1Predicate) {
      this.predicate = Preconditions.<Predicate<? super Character>>checkNotNull(param1Predicate);
    }
    
    public boolean apply(Character param1Character) {
      return this.predicate.apply(Preconditions.checkNotNull(param1Character));
    }
    
    public boolean matches(char param1Char) {
      return this.predicate.apply(Character.valueOf(param1Char));
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharMatcher.forPredicate(");
      stringBuilder.append(this.predicate);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static final class InRange extends FastMatcher {
    private final char endInclusive;
    
    private final char startInclusive;
    
    InRange(char param1Char1, char param1Char2) {
      boolean bool;
      if (param1Char2 >= param1Char1) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool);
      this.startInclusive = (char)param1Char1;
      this.endInclusive = (char)param1Char2;
    }
    
    public boolean matches(char param1Char) {
      boolean bool;
      if (this.startInclusive <= param1Char && param1Char <= this.endInclusive) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    @GwtIncompatible
    void setBits(BitSet param1BitSet) {
      param1BitSet.set(this.startInclusive, this.endInclusive + 1);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharMatcher.inRange('");
      stringBuilder.append(CharMatcher.showCharacter(this.startInclusive));
      stringBuilder.append("', '");
      stringBuilder.append(CharMatcher.showCharacter(this.endInclusive));
      stringBuilder.append("')");
      return stringBuilder.toString();
    }
  }
  
  private static final class Invisible extends RangesMatcher {
    static final Invisible INSTANCE = new Invisible();
    
    private static final String RANGE_ENDS = "  ­؄؜۝܏ ᠎‏ ⁤⁦⁧⁨⁩⁯　﻿￹￻";
    
    private static final String RANGE_STARTS = "\000­؀؜۝܏ ᠎   ⁦⁧⁨⁩⁪　?﻿￹￺";
    
    private Invisible() {
      super("CharMatcher.invisible()", "\000­؀؜۝܏ ᠎   ⁦⁧⁨⁩⁪　?﻿￹￺".toCharArray(), "  ­؄؜۝܏ ᠎‏ ⁤⁦⁧⁨⁩⁯　﻿￹￻".toCharArray());
    }
  }
  
  private static final class Is extends FastMatcher {
    private final char match;
    
    Is(char param1Char) {
      this.match = (char)param1Char;
    }
    
    public CharMatcher and(CharMatcher param1CharMatcher) {
      if (param1CharMatcher.matches(this.match)) {
        param1CharMatcher = this;
      } else {
        param1CharMatcher = none();
      } 
      return param1CharMatcher;
    }
    
    public boolean matches(char param1Char) {
      boolean bool;
      if (param1Char == this.match) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public CharMatcher negate() {
      return isNot(this.match);
    }
    
    public CharMatcher or(CharMatcher param1CharMatcher) {
      if (!param1CharMatcher.matches(this.match))
        param1CharMatcher = super.or(param1CharMatcher); 
      return param1CharMatcher;
    }
    
    public String replaceFrom(CharSequence param1CharSequence, char param1Char) {
      return param1CharSequence.toString().replace(this.match, param1Char);
    }
    
    @GwtIncompatible
    void setBits(BitSet param1BitSet) {
      param1BitSet.set(this.match);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharMatcher.is('");
      stringBuilder.append(CharMatcher.showCharacter(this.match));
      stringBuilder.append("')");
      return stringBuilder.toString();
    }
  }
  
  private static final class IsEither extends FastMatcher {
    private final char match1;
    
    private final char match2;
    
    IsEither(char param1Char1, char param1Char2) {
      this.match1 = (char)param1Char1;
      this.match2 = (char)param1Char2;
    }
    
    public boolean matches(char param1Char) {
      return (param1Char == this.match1 || param1Char == this.match2);
    }
    
    @GwtIncompatible
    void setBits(BitSet param1BitSet) {
      param1BitSet.set(this.match1);
      param1BitSet.set(this.match2);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharMatcher.anyOf(\"");
      stringBuilder.append(CharMatcher.showCharacter(this.match1));
      stringBuilder.append(CharMatcher.showCharacter(this.match2));
      stringBuilder.append("\")");
      return stringBuilder.toString();
    }
  }
  
  private static final class IsNot extends FastMatcher {
    private final char match;
    
    IsNot(char param1Char) {
      this.match = (char)param1Char;
    }
    
    public CharMatcher and(CharMatcher param1CharMatcher) {
      CharMatcher charMatcher = param1CharMatcher;
      if (param1CharMatcher.matches(this.match))
        charMatcher = super.and(param1CharMatcher); 
      return charMatcher;
    }
    
    public boolean matches(char param1Char) {
      boolean bool;
      if (param1Char != this.match) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public CharMatcher negate() {
      return is(this.match);
    }
    
    public CharMatcher or(CharMatcher param1CharMatcher) {
      if (param1CharMatcher.matches(this.match)) {
        param1CharMatcher = any();
      } else {
        param1CharMatcher = this;
      } 
      return param1CharMatcher;
    }
    
    @GwtIncompatible
    void setBits(BitSet param1BitSet) {
      param1BitSet.set(0, this.match);
      param1BitSet.set(this.match + 1, 65536);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharMatcher.isNot('");
      stringBuilder.append(CharMatcher.showCharacter(this.match));
      stringBuilder.append("')");
      return stringBuilder.toString();
    }
  }
  
  private static final class JavaDigit extends CharMatcher {
    static final JavaDigit INSTANCE = new JavaDigit();
    
    public boolean matches(char param1Char) {
      return Character.isDigit(param1Char);
    }
    
    public String toString() {
      return "CharMatcher.javaDigit()";
    }
  }
  
  private static final class JavaIsoControl extends NamedFastMatcher {
    static final JavaIsoControl INSTANCE = new JavaIsoControl();
    
    private JavaIsoControl() {
      super("CharMatcher.javaIsoControl()");
    }
    
    public boolean matches(char param1Char) {
      return (param1Char <= '\037' || (param1Char >= '' && param1Char <= ''));
    }
  }
  
  private static final class JavaLetter extends CharMatcher {
    static final JavaLetter INSTANCE = new JavaLetter();
    
    public boolean matches(char param1Char) {
      return Character.isLetter(param1Char);
    }
    
    public String toString() {
      return "CharMatcher.javaLetter()";
    }
  }
  
  private static final class JavaLetterOrDigit extends CharMatcher {
    static final JavaLetterOrDigit INSTANCE = new JavaLetterOrDigit();
    
    public boolean matches(char param1Char) {
      return Character.isLetterOrDigit(param1Char);
    }
    
    public String toString() {
      return "CharMatcher.javaLetterOrDigit()";
    }
  }
  
  private static final class JavaLowerCase extends CharMatcher {
    static final JavaLowerCase INSTANCE = new JavaLowerCase();
    
    public boolean matches(char param1Char) {
      return Character.isLowerCase(param1Char);
    }
    
    public String toString() {
      return "CharMatcher.javaLowerCase()";
    }
  }
  
  private static final class JavaUpperCase extends CharMatcher {
    static final JavaUpperCase INSTANCE = new JavaUpperCase();
    
    public boolean matches(char param1Char) {
      return Character.isUpperCase(param1Char);
    }
    
    public String toString() {
      return "CharMatcher.javaUpperCase()";
    }
  }
  
  static abstract class NamedFastMatcher extends FastMatcher {
    private final String description;
    
    NamedFastMatcher(String param1String) {
      this.description = Preconditions.<String>checkNotNull(param1String);
    }
    
    public final String toString() {
      return this.description;
    }
  }
  
  private static class Negated extends CharMatcher {
    final CharMatcher original;
    
    Negated(CharMatcher param1CharMatcher) {
      this.original = Preconditions.<CharMatcher>checkNotNull(param1CharMatcher);
    }
    
    public int countIn(CharSequence param1CharSequence) {
      return param1CharSequence.length() - this.original.countIn(param1CharSequence);
    }
    
    public boolean matches(char param1Char) {
      return this.original.matches(param1Char) ^ true;
    }
    
    public boolean matchesAllOf(CharSequence param1CharSequence) {
      return this.original.matchesNoneOf(param1CharSequence);
    }
    
    public boolean matchesNoneOf(CharSequence param1CharSequence) {
      return this.original.matchesAllOf(param1CharSequence);
    }
    
    public CharMatcher negate() {
      return this.original;
    }
    
    @GwtIncompatible
    void setBits(BitSet param1BitSet) {
      BitSet bitSet = new BitSet();
      this.original.setBits(bitSet);
      bitSet.flip(0, 65536);
      param1BitSet.or(bitSet);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.original);
      stringBuilder.append(".negate()");
      return stringBuilder.toString();
    }
  }
  
  static class NegatedFastMatcher extends Negated {
    NegatedFastMatcher(CharMatcher param1CharMatcher) {
      super(param1CharMatcher);
    }
    
    public final CharMatcher precomputed() {
      return this;
    }
  }
  
  private static final class None extends NamedFastMatcher {
    static final None INSTANCE = new None();
    
    private None() {
      super("CharMatcher.none()");
    }
    
    public CharMatcher and(CharMatcher param1CharMatcher) {
      Preconditions.checkNotNull(param1CharMatcher);
      return this;
    }
    
    public String collapseFrom(CharSequence param1CharSequence, char param1Char) {
      return param1CharSequence.toString();
    }
    
    public int countIn(CharSequence param1CharSequence) {
      Preconditions.checkNotNull(param1CharSequence);
      return 0;
    }
    
    public int indexIn(CharSequence param1CharSequence) {
      Preconditions.checkNotNull(param1CharSequence);
      return -1;
    }
    
    public int indexIn(CharSequence param1CharSequence, int param1Int) {
      Preconditions.checkPositionIndex(param1Int, param1CharSequence.length());
      return -1;
    }
    
    public int lastIndexIn(CharSequence param1CharSequence) {
      Preconditions.checkNotNull(param1CharSequence);
      return -1;
    }
    
    public boolean matches(char param1Char) {
      return false;
    }
    
    public boolean matchesAllOf(CharSequence param1CharSequence) {
      boolean bool;
      if (param1CharSequence.length() == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean matchesNoneOf(CharSequence param1CharSequence) {
      Preconditions.checkNotNull(param1CharSequence);
      return true;
    }
    
    public CharMatcher negate() {
      return any();
    }
    
    public CharMatcher or(CharMatcher param1CharMatcher) {
      return Preconditions.<CharMatcher>checkNotNull(param1CharMatcher);
    }
    
    public String removeFrom(CharSequence param1CharSequence) {
      return param1CharSequence.toString();
    }
    
    public String replaceFrom(CharSequence param1CharSequence, char param1Char) {
      return param1CharSequence.toString();
    }
    
    public String replaceFrom(CharSequence param1CharSequence1, CharSequence param1CharSequence2) {
      Preconditions.checkNotNull(param1CharSequence2);
      return param1CharSequence1.toString();
    }
    
    public String trimFrom(CharSequence param1CharSequence) {
      return param1CharSequence.toString();
    }
    
    public String trimLeadingFrom(CharSequence param1CharSequence) {
      return param1CharSequence.toString();
    }
    
    public String trimTrailingFrom(CharSequence param1CharSequence) {
      return param1CharSequence.toString();
    }
  }
  
  private static final class Or extends CharMatcher {
    final CharMatcher first;
    
    final CharMatcher second;
    
    Or(CharMatcher param1CharMatcher1, CharMatcher param1CharMatcher2) {
      this.first = Preconditions.<CharMatcher>checkNotNull(param1CharMatcher1);
      this.second = Preconditions.<CharMatcher>checkNotNull(param1CharMatcher2);
    }
    
    public boolean matches(char param1Char) {
      return (this.first.matches(param1Char) || this.second.matches(param1Char));
    }
    
    @GwtIncompatible
    void setBits(BitSet param1BitSet) {
      this.first.setBits(param1BitSet);
      this.second.setBits(param1BitSet);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharMatcher.or(");
      stringBuilder.append(this.first);
      stringBuilder.append(", ");
      stringBuilder.append(this.second);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static class RangesMatcher extends CharMatcher {
    private final String description;
    
    private final char[] rangeEnds;
    
    private final char[] rangeStarts;
    
    RangesMatcher(String param1String, char[] param1ArrayOfchar1, char[] param1ArrayOfchar2) {
      boolean bool;
      this.description = param1String;
      this.rangeStarts = param1ArrayOfchar1;
      this.rangeEnds = param1ArrayOfchar2;
      if (param1ArrayOfchar1.length == param1ArrayOfchar2.length) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool);
      int i;
      for (i = 0; i < param1ArrayOfchar1.length; i = j) {
        if (param1ArrayOfchar1[i] <= param1ArrayOfchar2[i]) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.checkArgument(bool);
        int j = i + 1;
        if (j < param1ArrayOfchar1.length) {
          if (param1ArrayOfchar2[i] < param1ArrayOfchar1[j]) {
            bool = true;
          } else {
            bool = false;
          } 
          Preconditions.checkArgument(bool);
        } 
      } 
    }
    
    public boolean matches(char param1Char) {
      int i = Arrays.binarySearch(this.rangeStarts, param1Char);
      boolean bool = true;
      if (i >= 0)
        return true; 
      i = (i ^ 0xFFFFFFFF) - 1;
      if (i < 0 || param1Char > this.rangeEnds[i])
        bool = false; 
      return bool;
    }
    
    public String toString() {
      return this.description;
    }
  }
  
  private static final class SingleWidth extends RangesMatcher {
    static final SingleWidth INSTANCE = new SingleWidth();
    
    private SingleWidth() {
      super("CharMatcher.singleWidth()", "\000־א׳؀ݐ฀Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ๿₯℺﷿﻿ￜ".toCharArray());
    }
  }
  
  @VisibleForTesting
  static final class Whitespace extends NamedFastMatcher {
    static final Whitespace INSTANCE = new Whitespace();
    
    static final int MULTIPLIER = 1682554634;
    
    static final int SHIFT = Integer.numberOfLeadingZeros(31);
    
    static final String TABLE = " 　\r   　 \013　   　 \t     \f 　 　　 \n 　";
    
    static {
    
    }
    
    Whitespace() {
      super("CharMatcher.whitespace()");
    }
    
    public boolean matches(char param1Char) {
      boolean bool;
      if (" 　\r   　 \013　   　 \t     \f 　 　　 \n 　".charAt(1682554634 * param1Char >>> SHIFT) == param1Char) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    @GwtIncompatible
    void setBits(BitSet param1BitSet) {
      for (byte b = 0; b < 32; b++)
        param1BitSet.set(" 　\r   　 \013　   　 \t     \f 　 　　 \n 　".charAt(b)); 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\CharMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */