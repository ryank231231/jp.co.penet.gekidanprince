package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible(emulated = true)
public final class Shorts {
  public static final int BYTES = 2;
  
  public static final short MAX_POWER_OF_TWO = 16384;
  
  public static List<Short> asList(short... paramVarArgs) {
    return (paramVarArgs.length == 0) ? Collections.emptyList() : new ShortArrayAsList(paramVarArgs);
  }
  
  public static short checkedCast(long paramLong) {
    short s = (short)(int)paramLong;
    if (s == paramLong)
      return s; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Out of range: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static int compare(short paramShort1, short paramShort2) {
    return paramShort1 - paramShort2;
  }
  
  public static short[] concat(short[]... paramVarArgs) {
    int i = paramVarArgs.length;
    int j = 0;
    int k = 0;
    while (j < i) {
      k += (paramVarArgs[j]).length;
      j++;
    } 
    short[] arrayOfShort = new short[k];
    i = paramVarArgs.length;
    k = 0;
    j = 0;
    while (k < i) {
      short[] arrayOfShort1 = paramVarArgs[k];
      System.arraycopy(arrayOfShort1, 0, arrayOfShort, j, arrayOfShort1.length);
      j += arrayOfShort1.length;
      k++;
    } 
    return arrayOfShort;
  }
  
  public static boolean contains(short[] paramArrayOfshort, short paramShort) {
    int i = paramArrayOfshort.length;
    for (byte b = 0; b < i; b++) {
      if (paramArrayOfshort[b] == paramShort)
        return true; 
    } 
    return false;
  }
  
  public static short[] ensureCapacity(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
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
    short[] arrayOfShort = paramArrayOfshort;
    if (paramArrayOfshort.length < paramInt1)
      arrayOfShort = Arrays.copyOf(paramArrayOfshort, paramInt1 + paramInt2); 
    return arrayOfShort;
  }
  
  @GwtIncompatible
  public static short fromByteArray(byte[] paramArrayOfbyte) {
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
  public static short fromBytes(byte paramByte1, byte paramByte2) {
    return (short)(paramByte1 << 8 | paramByte2 & 0xFF);
  }
  
  public static int hashCode(short paramShort) {
    return paramShort;
  }
  
  public static int indexOf(short[] paramArrayOfshort, short paramShort) {
    return indexOf(paramArrayOfshort, paramShort, 0, paramArrayOfshort.length);
  }
  
  private static int indexOf(short[] paramArrayOfshort, short paramShort, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      if (paramArrayOfshort[paramInt1] == paramShort)
        return paramInt1; 
      paramInt1++;
    } 
    return -1;
  }
  
  public static int indexOf(short[] paramArrayOfshort1, short[] paramArrayOfshort2) {
    Preconditions.checkNotNull(paramArrayOfshort1, "array");
    Preconditions.checkNotNull(paramArrayOfshort2, "target");
    if (paramArrayOfshort2.length == 0)
      return 0; 
    byte b = 0;
    label17: while (b < paramArrayOfshort1.length - paramArrayOfshort2.length + 1) {
      for (byte b1 = 0; b1 < paramArrayOfshort2.length; b1++) {
        if (paramArrayOfshort1[b + b1] != paramArrayOfshort2[b1]) {
          b++;
          continue label17;
        } 
      } 
      return b;
    } 
    return -1;
  }
  
  public static String join(String paramString, short... paramVarArgs) {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * 6);
    stringBuilder.append(paramVarArgs[0]);
    for (byte b = 1; b < paramVarArgs.length; b++) {
      stringBuilder.append(paramString);
      stringBuilder.append(paramVarArgs[b]);
    } 
    return stringBuilder.toString();
  }
  
  public static int lastIndexOf(short[] paramArrayOfshort, short paramShort) {
    return lastIndexOf(paramArrayOfshort, paramShort, 0, paramArrayOfshort.length);
  }
  
  private static int lastIndexOf(short[] paramArrayOfshort, short paramShort, int paramInt1, int paramInt2) {
    while (--paramInt2 >= paramInt1) {
      if (paramArrayOfshort[paramInt2] == paramShort)
        return paramInt2; 
      paramInt2--;
    } 
    return -1;
  }
  
  public static Comparator<short[]> lexicographicalComparator() {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static short max(short... paramVarArgs) {
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
  
  public static short min(short... paramVarArgs) {
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
  
  public static short saturatedCast(long paramLong) {
    return (paramLong > 32767L) ? Short.MAX_VALUE : ((paramLong < -32768L) ? Short.MIN_VALUE : (short)(int)paramLong);
  }
  
  @Beta
  public static Converter<String, Short> stringConverter() {
    return ShortConverter.INSTANCE;
  }
  
  public static short[] toArray(Collection<? extends Number> paramCollection) {
    if (paramCollection instanceof ShortArrayAsList)
      return ((ShortArrayAsList)paramCollection).toShortArray(); 
    Object[] arrayOfObject = paramCollection.toArray();
    int i = arrayOfObject.length;
    short[] arrayOfShort = new short[i];
    for (byte b = 0; b < i; b++)
      arrayOfShort[b] = ((Number)Preconditions.checkNotNull(arrayOfObject[b])).shortValue(); 
    return arrayOfShort;
  }
  
  @GwtIncompatible
  public static byte[] toByteArray(short paramShort) {
    return new byte[] { (byte)(paramShort >> 8), (byte)paramShort };
  }
  
  private enum LexicographicalComparator implements Comparator<short[]> {
    INSTANCE;
    
    static {
    
    }
    
    public int compare(short[] param1ArrayOfshort1, short[] param1ArrayOfshort2) {
      int i = Math.min(param1ArrayOfshort1.length, param1ArrayOfshort2.length);
      for (byte b = 0; b < i; b++) {
        int j = Shorts.compare(param1ArrayOfshort1[b], param1ArrayOfshort2[b]);
        if (j != 0)
          return j; 
      } 
      return param1ArrayOfshort1.length - param1ArrayOfshort2.length;
    }
    
    public String toString() {
      return "Shorts.lexicographicalComparator()";
    }
  }
  
  @GwtCompatible
  private static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0L;
    
    final short[] array;
    
    final int end;
    
    final int start;
    
    ShortArrayAsList(short[] param1ArrayOfshort) {
      this(param1ArrayOfshort, 0, param1ArrayOfshort.length);
    }
    
    ShortArrayAsList(short[] param1ArrayOfshort, int param1Int1, int param1Int2) {
      this.array = param1ArrayOfshort;
      this.start = param1Int1;
      this.end = param1Int2;
    }
    
    public boolean contains(Object param1Object) {
      boolean bool;
      if (param1Object instanceof Short && Shorts.indexOf(this.array, ((Short)param1Object).shortValue(), this.start, this.end) != -1) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof ShortArrayAsList) {
        param1Object = param1Object;
        int i = size();
        if (param1Object.size() != i)
          return false; 
        for (byte b = 0; b < i; b++) {
          if (this.array[this.start + b] != ((ShortArrayAsList)param1Object).array[((ShortArrayAsList)param1Object).start + b])
            return false; 
        } 
        return true;
      } 
      return super.equals(param1Object);
    }
    
    public Short get(int param1Int) {
      Preconditions.checkElementIndex(param1Int, size());
      return Short.valueOf(this.array[this.start + param1Int]);
    }
    
    public int hashCode() {
      int i = this.start;
      int j = 1;
      while (i < this.end) {
        j = j * 31 + Shorts.hashCode(this.array[i]);
        i++;
      } 
      return j;
    }
    
    public int indexOf(Object param1Object) {
      if (param1Object instanceof Short) {
        int i = Shorts.indexOf(this.array, ((Short)param1Object).shortValue(), this.start, this.end);
        if (i >= 0)
          return i - this.start; 
      } 
      return -1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public int lastIndexOf(Object param1Object) {
      if (param1Object instanceof Short) {
        int i = Shorts.lastIndexOf(this.array, ((Short)param1Object).shortValue(), this.start, this.end);
        if (i >= 0)
          return i - this.start; 
      } 
      return -1;
    }
    
    public Short set(int param1Int, Short param1Short) {
      Preconditions.checkElementIndex(param1Int, size());
      short[] arrayOfShort = this.array;
      int i = this.start;
      short s = arrayOfShort[i + param1Int];
      arrayOfShort[i + param1Int] = ((Short)Preconditions.checkNotNull(param1Short)).shortValue();
      return Short.valueOf(s);
    }
    
    public int size() {
      return this.end - this.start;
    }
    
    public List<Short> subList(int param1Int1, int param1Int2) {
      Preconditions.checkPositionIndexes(param1Int1, param1Int2, size());
      if (param1Int1 == param1Int2)
        return Collections.emptyList(); 
      short[] arrayOfShort = this.array;
      int i = this.start;
      return new ShortArrayAsList(arrayOfShort, param1Int1 + i, i + param1Int2);
    }
    
    short[] toShortArray() {
      int i = size();
      short[] arrayOfShort = new short[i];
      System.arraycopy(this.array, this.start, arrayOfShort, 0, i);
      return arrayOfShort;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(size() * 6);
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
  
  private static final class ShortConverter extends Converter<String, Short> implements Serializable {
    static final ShortConverter INSTANCE = new ShortConverter();
    
    private static final long serialVersionUID = 1L;
    
    private Object readResolve() {
      return INSTANCE;
    }
    
    protected String doBackward(Short param1Short) {
      return param1Short.toString();
    }
    
    protected Short doForward(String param1String) {
      return Short.decode(param1String);
    }
    
    public String toString() {
      return "Shorts.stringConverter()";
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\primitives\Shorts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */