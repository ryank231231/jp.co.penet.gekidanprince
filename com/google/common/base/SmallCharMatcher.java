package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.BitSet;

@GwtIncompatible
final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {
  private static final int C1 = -862048943;
  
  private static final int C2 = 461845907;
  
  private static final double DESIRED_LOAD_FACTOR = 0.5D;
  
  static final int MAX_SIZE = 1023;
  
  private final boolean containsZero;
  
  private final long filter;
  
  private final char[] table;
  
  private SmallCharMatcher(char[] paramArrayOfchar, long paramLong, boolean paramBoolean, String paramString) {
    super(paramString);
    this.table = paramArrayOfchar;
    this.filter = paramLong;
    this.containsZero = paramBoolean;
  }
  
  private boolean checkFilter(int paramInt) {
    boolean bool;
    if (1L == (this.filter >> paramInt & 0x1L)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @VisibleForTesting
  static int chooseTableSize(int paramInt) {
    if (paramInt == 1)
      return 2; 
    int i = Integer.highestOneBit(paramInt - 1) << 1;
    while (true) {
      double d = i;
      Double.isNaN(d);
      if (d * 0.5D < paramInt) {
        i <<= 1;
        continue;
      } 
      return i;
    } 
  }
  
  static CharMatcher from(BitSet paramBitSet, String paramString) {
    int i = paramBitSet.cardinality();
    boolean bool = paramBitSet.get(0);
    char[] arrayOfChar = new char[chooseTableSize(i)];
    int j = arrayOfChar.length - 1;
    i = paramBitSet.nextSetBit(0);
    long l = 0L;
    label13: while (true) {
      int k = i;
      if (k != -1) {
        for (i = smear(k) & j;; i = i + 1 & j) {
          if (arrayOfChar[i] == '\000') {
            arrayOfChar[i] = (char)(char)k;
            i = paramBitSet.nextSetBit(k + 1);
            l = 1L << k | l;
            continue label13;
          } 
        } 
        break;
      } 
      return new SmallCharMatcher(arrayOfChar, l, bool, paramString);
    } 
  }
  
  static int smear(int paramInt) {
    return Integer.rotateLeft(paramInt * -862048943, 15) * 461845907;
  }
  
  public boolean matches(char paramChar) {
    if (paramChar == '\000')
      return this.containsZero; 
    if (!checkFilter(paramChar))
      return false; 
    int i = this.table.length - 1;
    int j = smear(paramChar) & i;
    int k = j;
    while (true) {
      char[] arrayOfChar = this.table;
      if (arrayOfChar[k] == '\000')
        return false; 
      if (arrayOfChar[k] == paramChar)
        return true; 
      int m = k + 1 & i;
      k = m;
      if (m == j)
        return false; 
    } 
  }
  
  void setBits(BitSet paramBitSet) {
    boolean bool = this.containsZero;
    byte b = 0;
    if (bool)
      paramBitSet.set(0); 
    char[] arrayOfChar = this.table;
    int i = arrayOfChar.length;
    while (b < i) {
      char c = arrayOfChar[b];
      if (c != '\000')
        paramBitSet.set(c); 
      b++;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\SmallCharMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */