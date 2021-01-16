package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

@Beta
@GwtCompatible
public final class ArrayBasedEscaperMap {
  private static final char[][] EMPTY_REPLACEMENT_ARRAY = new char[0][0];
  
  private final char[][] replacementArray;
  
  private ArrayBasedEscaperMap(char[][] paramArrayOfchar) {
    this.replacementArray = paramArrayOfchar;
  }
  
  public static ArrayBasedEscaperMap create(Map<Character, String> paramMap) {
    return new ArrayBasedEscaperMap(createReplacementArray(paramMap));
  }
  
  @VisibleForTesting
  static char[][] createReplacementArray(Map<Character, String> paramMap) {
    Preconditions.checkNotNull(paramMap);
    if (paramMap.isEmpty())
      return EMPTY_REPLACEMENT_ARRAY; 
    char[][] arrayOfChar = new char[((Character)Collections.max(paramMap.keySet())).charValue() + 1][];
    Iterator<Character> iterator = paramMap.keySet().iterator();
    while (iterator.hasNext()) {
      char c = ((Character)iterator.next()).charValue();
      arrayOfChar[c] = ((String)paramMap.get(Character.valueOf(c))).toCharArray();
    } 
    return arrayOfChar;
  }
  
  char[][] getReplacementArray() {
    return this.replacementArray;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\escape\ArrayBasedEscaperMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */