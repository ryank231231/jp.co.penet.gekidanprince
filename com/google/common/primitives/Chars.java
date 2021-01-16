package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Chars {
  public static final int BYTES = 2;
  
  public static List<Character> asList(char... paramVarArgs) {
    return (paramVarArgs.length == 0) ? Collections.emptyList() : new CharArrayAsList(paramVarArgs);
  }
  
  public static char checkedCast(long paramLong) {
    char c = (char)(int)paramLong;
    if (c == paramLong)
      return c; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Out of range: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static int compare(char paramChar1, char paramChar2) {
    return paramChar1 - paramChar2;
  }
  
  public static char[] concat(char[]... paramVarArgs) {
    int i = paramVarArgs.length;
    int j = 0;
    int k = 0;
    while (j < i) {
      k += (paramVarArgs[j]).length;
      j++;
    } 
    char[] arrayOfChar = new char[k];
    i = paramVarArgs.length;
    k = 0;
    j = 0;
    while (k < i) {
      char[] arrayOfChar1 = paramVarArgs[k];
      System.arraycopy(arrayOfChar1, 0, arrayOfChar, j, arrayOfChar1.length);
      j += arrayOfChar1.length;
      k++;
    } 
    return arrayOfChar;
  }
  
  public static boolean contains(char[] paramArrayOfchar, char paramChar) {
    int i = paramArrayOfchar.length;
    for (byte b = 0; b < i; b++) {
      if (paramArrayOfchar[b] == paramChar)
        return true; 
    } 
    return false;
  }
  
  public static char[] ensureCapacity(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    boolean bool2;
    boolean bool1 = true;
    if (paramInt1 >= 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "Invalid minLength: %s", paramInt1);
    if (paramInt2 >= 0) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "Invalid padding: %s", paramInt2);
    char[] arrayOfChar = paramArrayOfchar;
    if (paramArrayOfchar.length < paramInt1)
      arrayOfChar = Arrays.copyOf(paramArrayOfchar, paramInt1 + paramInt2); 
    return arrayOfChar;
  }
  
  @GwtIncompatible
  public static char fromByteArray(byte[] paramArrayOfbyte) {
    boolean bool;
    if (paramArrayOfbyte.length >= 2) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "array too small: %s < %s", paramArrayOfbyte.length, 2);
    return fromBytes(paramArrayOfbyte[0], paramArrayOfbyte[1]);
  }
  
  @GwtIncompatible
  public static char fromBytes(byte paramByte1, byte paramByte2) {
    return (char)(paramByte1 << 8 | paramByte2 & 0xFF);
  }
  
  public static int hashCode(char paramChar) {
    return paramChar;
  }
  
  public static int indexOf(char[] paramArrayOfchar, char paramChar) {
    return indexOf(paramArrayOfchar, paramChar, 0, paramArrayOfchar.length);
  }
  
  private static int indexOf(char[] paramArrayOfchar, char paramChar, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      if (paramArrayOfchar[paramInt1] == paramChar)
        return paramInt1; 
      paramInt1++;
    } 
    return -1;
  }
  
  public static int indexOf(char[] paramArrayOfchar1, char[] paramArrayOfchar2) {
    Preconditions.checkNotNull(paramArrayOfchar1, "array");
    Preconditions.checkNotNull(paramArrayOfchar2, "target");
    if (paramArrayOfchar2.length == 0)
      return 0; 
    byte b = 0;
    label17: while (b < paramArrayOfchar1.length - paramArrayOfchar2.length + 1) {
      for (byte b1 = 0; b1 < paramArrayOfchar2.length; b1++) {
        if (paramArrayOfchar1[b + b1] != paramArrayOfchar2[b1]) {
          b++;
          continue label17;
        } 
      } 
      return b;
    } 
    return -1;
  }
  
  public static String join(String paramString, char... paramVarArgs) {
    Preconditions.checkNotNull(paramString);
    int i = paramVarArgs.length;
    if (i == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder(paramString.length() * (i - 1) + i);
    stringBuilder.append(paramVarArgs[0]);
    for (byte b = 1; b < i; b++) {
      stringBuilder.append(paramString);
      stringBuilder.append(paramVarArgs[b]);
    } 
    return stringBuilder.toString();
  }
  
  public static int lastIndexOf(char[] paramArrayOfchar, char paramChar) {
    return lastIndexOf(paramArrayOfchar, paramChar, 0, paramArrayOfchar.length);
  }
  
  private static int lastIndexOf(char[] paramArrayOfchar, char paramChar, int paramInt1, int paramInt2) {
    while (--paramInt2 >= paramInt1) {
      if (paramArrayOfchar[paramInt2] == paramChar)
        return paramInt2; 
      paramInt2--;
    } 
    return -1;
  }
  
  public static Comparator<char[]> lexicographicalComparator() {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static char max(char... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    i = paramVarArgs[0];
    int j;
    for (j = i; b < paramVarArgs.length; j = i) {
      i = j;
      if (paramVarArgs[b] > j)
        i = paramVarArgs[b]; 
      b++;
    } 
    return j;
  }
  
  public static char min(char... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    i = paramVarArgs[0];
    int j;
    for (j = i; b < paramVarArgs.length; j = i) {
      i = j;
      if (paramVarArgs[b] < j)
        i = paramVarArgs[b]; 
      b++;
    } 
    return j;
  }
  
  public static char saturatedCast(long paramLong) {
    return (paramLong > 65535L) ? Character.MAX_VALUE : ((paramLong < 0L) ? Character.MIN_VALUE : (char)(int)paramLong);
  }
  
  public static char[] toArray(Collection<Character> paramCollection) {
    if (paramCollection instanceof CharArrayAsList)
      return ((CharArrayAsList)paramCollection).toCharArray(); 
    Object[] arrayOfObject = paramCollection.toArray();
    int i = arrayOfObject.length;
    char[] arrayOfChar = new char[i];
    for (byte b = 0; b < i; b++)
      arrayOfChar[b] = ((Character)Preconditions.checkNotNull(arrayOfObject[b])).charValue(); 
    return arrayOfChar;
  }
  
  @GwtIncompatible
  public static byte[] toByteArray(char paramChar) {
    return new byte[] { (byte)(paramChar >> 8), (byte)paramChar };
  }
  
  @GwtCompatible
  private static class CharArrayAsList extends AbstractList<Character> implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0L;
    
    final char[] array;
    
    final int end;
    
    final int start;
    
    CharArrayAsList(char[] param1ArrayOfchar) {
      this(param1ArrayOfchar, 0, param1ArrayOfchar.length);
    }
    
    CharArrayAsList(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
      this.array = param1ArrayOfchar;
      this.start = param1Int1;
      this.end = param1Int2;
    }
    
    public boolean contains(Object param1Object) {
      boolean bool;
      if (param1Object instanceof Character && Chars.indexOf(this.array, ((Character)param1Object).charValue(), this.start, this.end) != -1) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof CharArrayAsList) {
        param1Object = param1Object;
        int i = size();
        if (param1Object.size() != i)
          return false; 
        for (byte b = 0; b < i; b++) {
          if (this.array[this.start + b] != ((CharArrayAsList)param1Object).array[((CharArrayAsList)param1Object).start + b])
            return false; 
        } 
        return true;
      } 
      return super.equals(param1Object);
    }
    
    public Character get(int param1Int) {
      Preconditions.checkElementIndex(param1Int, size());
      return Character.valueOf(this.array[this.start + param1Int]);
    }
    
    public int hashCode() {
      int i = this.start;
      int j = 1;
      while (i < this.end) {
        j = j * 31 + Chars.hashCode(this.array[i]);
        i++;
      } 
      return j;
    }
    
    public int indexOf(Object param1Object) {
      if (param1Object instanceof Character) {
        int i = Chars.indexOf(this.array, ((Character)param1Object).charValue(), this.start, this.end);
        if (i >= 0)
          return i - this.start; 
      } 
      return -1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public int lastIndexOf(Object param1Object) {
      if (param1Object instanceof Character) {
        int i = Chars.lastIndexOf(this.array, ((Character)param1Object).charValue(), this.start, this.end);
        if (i >= 0)
          return i - this.start; 
      } 
      return -1;
    }
    
    public Character set(int param1Int, Character param1Character) {
      Preconditions.checkElementIndex(param1Int, size());
      char[] arrayOfChar = this.array;
      int i = this.start;
      char c = arrayOfChar[i + param1Int];
      arrayOfChar[i + param1Int] = ((Character)Preconditions.checkNotNull(param1Character)).charValue();
      return Character.valueOf(c);
    }
    
    public int size() {
      return this.end - this.start;
    }
    
    public List<Character> subList(int param1Int1, int param1Int2) {
      Preconditions.checkPositionIndexes(param1Int1, param1Int2, size());
      if (param1Int1 == param1Int2)
        return Collections.emptyList(); 
      char[] arrayOfChar = this.array;
      int i = this.start;
      return new CharArrayAsList(arrayOfChar, param1Int1 + i, i + param1Int2);
    }
    
    char[] toCharArray() {
      int i = size();
      char[] arrayOfChar = new char[i];
      System.arraycopy(this.array, this.start, arrayOfChar, 0, i);
      return arrayOfChar;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(size() * 3);
      stringBuilder.append('[');
      stringBuilder.append(this.array[this.start]);
      int i = this.start;
      while (++i < this.end) {
        stringBuilder.append(", ");
        stringBuilder.append(this.array[i]);
      } 
      stringBuilder.append(']');
      return stringBuilder.toString();
    }
  }
  
  private enum LexicographicalComparator implements Comparator<char[]> {
    INSTANCE;
    
    static {
    
    }
    
    public int compare(char[] param1ArrayOfchar1, char[] param1ArrayOfchar2) {
      int i = Math.min(param1ArrayOfchar1.length, param1ArrayOfchar2.length);
      for (byte b = 0; b < i; b++) {
        int j = Chars.compare(param1ArrayOfchar1[b], param1ArrayOfchar2[b]);
        if (j != 0)
          return j; 
      } 
      return param1ArrayOfchar1.length - param1ArrayOfchar2.length;
    }
    
    public String toString() {
      return "Chars.lexicographicalComparator()";
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\primitives\Chars.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */