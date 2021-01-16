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
import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Ints {
  public static final int BYTES = 4;
  
  public static final int MAX_POWER_OF_TWO = 1073741824;
  
  public static List<Integer> asList(int... paramVarArgs) {
    return (paramVarArgs.length == 0) ? Collections.emptyList() : new IntArrayAsList(paramVarArgs);
  }
  
  public static int checkedCast(long paramLong) {
    int i = (int)paramLong;
    if (i == paramLong)
      return i; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Out of range: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static int compare(int paramInt1, int paramInt2) {
    if (paramInt1 < paramInt2) {
      paramInt1 = -1;
    } else if (paramInt1 > paramInt2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    } 
    return paramInt1;
  }
  
  public static int[] concat(int[]... paramVarArgs) {
    int i = paramVarArgs.length;
    byte b = 0;
    int j = 0;
    while (b < i) {
      j += (paramVarArgs[b]).length;
      b++;
    } 
    int[] arrayOfInt = new int[j];
    i = paramVarArgs.length;
    b = 0;
    j = 0;
    while (b < i) {
      int[] arrayOfInt1 = paramVarArgs[b];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt, j, arrayOfInt1.length);
      j += arrayOfInt1.length;
      b++;
    } 
    return arrayOfInt;
  }
  
  public static boolean contains(int[] paramArrayOfint, int paramInt) {
    int i = paramArrayOfint.length;
    for (byte b = 0; b < i; b++) {
      if (paramArrayOfint[b] == paramInt)
        return true; 
    } 
    return false;
  }
  
  public static int[] ensureCapacity(int[] paramArrayOfint, int paramInt1, int paramInt2) {
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
    int[] arrayOfInt = paramArrayOfint;
    if (paramArrayOfint.length < paramInt1)
      arrayOfInt = Arrays.copyOf(paramArrayOfint, paramInt1 + paramInt2); 
    return arrayOfInt;
  }
  
  @GwtIncompatible
  public static int fromByteArray(byte[] paramArrayOfbyte) {
    boolean bool;
    if (paramArrayOfbyte.length >= 4) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "array too small: %s < %s", paramArrayOfbyte.length, 4);
    return fromBytes(paramArrayOfbyte[0], paramArrayOfbyte[1], paramArrayOfbyte[2], paramArrayOfbyte[3]);
  }
  
  @GwtIncompatible
  public static int fromBytes(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4) {
    return paramByte1 << 24 | (paramByte2 & 0xFF) << 16 | (paramByte3 & 0xFF) << 8 | paramByte4 & 0xFF;
  }
  
  public static int hashCode(int paramInt) {
    return paramInt;
  }
  
  public static int indexOf(int[] paramArrayOfint, int paramInt) {
    return indexOf(paramArrayOfint, paramInt, 0, paramArrayOfint.length);
  }
  
  private static int indexOf(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3) {
    while (paramInt2 < paramInt3) {
      if (paramArrayOfint[paramInt2] == paramInt1)
        return paramInt2; 
      paramInt2++;
    } 
    return -1;
  }
  
  public static int indexOf(int[] paramArrayOfint1, int[] paramArrayOfint2) {
    Preconditions.checkNotNull(paramArrayOfint1, "array");
    Preconditions.checkNotNull(paramArrayOfint2, "target");
    if (paramArrayOfint2.length == 0)
      return 0; 
    byte b = 0;
    label17: while (b < paramArrayOfint1.length - paramArrayOfint2.length + 1) {
      for (byte b1 = 0; b1 < paramArrayOfint2.length; b1++) {
        if (paramArrayOfint1[b + b1] != paramArrayOfint2[b1]) {
          b++;
          continue label17;
        } 
      } 
      return b;
    } 
    return -1;
  }
  
  public static String join(String paramString, int... paramVarArgs) {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * 5);
    stringBuilder.append(paramVarArgs[0]);
    for (byte b = 1; b < paramVarArgs.length; b++) {
      stringBuilder.append(paramString);
      stringBuilder.append(paramVarArgs[b]);
    } 
    return stringBuilder.toString();
  }
  
  public static int lastIndexOf(int[] paramArrayOfint, int paramInt) {
    return lastIndexOf(paramArrayOfint, paramInt, 0, paramArrayOfint.length);
  }
  
  private static int lastIndexOf(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3) {
    while (--paramInt3 >= paramInt2) {
      if (paramArrayOfint[paramInt3] == paramInt1)
        return paramInt3; 
      paramInt3--;
    } 
    return -1;
  }
  
  public static Comparator<int[]> lexicographicalComparator() {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static int max(int... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    int j;
    for (j = paramVarArgs[0]; b < paramVarArgs.length; j = i) {
      i = j;
      if (paramVarArgs[b] > j)
        i = paramVarArgs[b]; 
      b++;
    } 
    return j;
  }
  
  public static int min(int... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    for (i = paramVarArgs[0]; b < paramVarArgs.length; i = j) {
      int j = i;
      if (paramVarArgs[b] < i)
        j = paramVarArgs[b]; 
      b++;
    } 
    return i;
  }
  
  public static int saturatedCast(long paramLong) {
    return (paramLong > 2147483647L) ? Integer.MAX_VALUE : ((paramLong < -2147483648L) ? Integer.MIN_VALUE : (int)paramLong);
  }
  
  @Beta
  public static Converter<String, Integer> stringConverter() {
    return IntConverter.INSTANCE;
  }
  
  public static int[] toArray(Collection<? extends Number> paramCollection) {
    if (paramCollection instanceof IntArrayAsList)
      return ((IntArrayAsList)paramCollection).toIntArray(); 
    Object[] arrayOfObject = paramCollection.toArray();
    int i = arrayOfObject.length;
    int[] arrayOfInt = new int[i];
    for (byte b = 0; b < i; b++)
      arrayOfInt[b] = ((Number)Preconditions.checkNotNull(arrayOfObject[b])).intValue(); 
    return arrayOfInt;
  }
  
  @GwtIncompatible
  public static byte[] toByteArray(int paramInt) {
    return new byte[] { (byte)(paramInt >> 24), (byte)(paramInt >> 16), (byte)(paramInt >> 8), (byte)paramInt };
  }
  
  @CheckForNull
  @Nullable
  @Beta
  public static Integer tryParse(String paramString) {
    return tryParse(paramString, 10);
  }
  
  @CheckForNull
  @Nullable
  @Beta
  public static Integer tryParse(String paramString, int paramInt) {
    Long long_ = Longs.tryParse(paramString, paramInt);
    return (long_ == null || long_.longValue() != long_.intValue()) ? null : Integer.valueOf(long_.intValue());
  }
  
  @GwtCompatible
  private static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0L;
    
    final int[] array;
    
    final int end;
    
    final int start;
    
    IntArrayAsList(int[] param1ArrayOfint) {
      this(param1ArrayOfint, 0, param1ArrayOfint.length);
    }
    
    IntArrayAsList(int[] param1ArrayOfint, int param1Int1, int param1Int2) {
      this.array = param1ArrayOfint;
      this.start = param1Int1;
      this.end = param1Int2;
    }
    
    public boolean contains(Object param1Object) {
      boolean bool;
      if (param1Object instanceof Integer && Ints.indexOf(this.array, ((Integer)param1Object).intValue(), this.start, this.end) != -1) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof IntArrayAsList) {
        param1Object = param1Object;
        int i = size();
        if (param1Object.size() != i)
          return false; 
        for (byte b = 0; b < i; b++) {
          if (this.array[this.start + b] != ((IntArrayAsList)param1Object).array[((IntArrayAsList)param1Object).start + b])
            return false; 
        } 
        return true;
      } 
      return super.equals(param1Object);
    }
    
    public Integer get(int param1Int) {
      Preconditions.checkElementIndex(param1Int, size());
      return Integer.valueOf(this.array[this.start + param1Int]);
    }
    
    public int hashCode() {
      int i = this.start;
      int j = 1;
      while (i < this.end) {
        j = j * 31 + Ints.hashCode(this.array[i]);
        i++;
      } 
      return j;
    }
    
    public int indexOf(Object param1Object) {
      if (param1Object instanceof Integer) {
        int i = Ints.indexOf(this.array, ((Integer)param1Object).intValue(), this.start, this.end);
        if (i >= 0)
          return i - this.start; 
      } 
      return -1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public int lastIndexOf(Object param1Object) {
      if (param1Object instanceof Integer) {
        int i = Ints.lastIndexOf(this.array, ((Integer)param1Object).intValue(), this.start, this.end);
        if (i >= 0)
          return i - this.start; 
      } 
      return -1;
    }
    
    public Integer set(int param1Int, Integer param1Integer) {
      Preconditions.checkElementIndex(param1Int, size());
      int[] arrayOfInt = this.array;
      int i = this.start;
      int j = arrayOfInt[i + param1Int];
      arrayOfInt[i + param1Int] = ((Integer)Preconditions.checkNotNull(param1Integer)).intValue();
      return Integer.valueOf(j);
    }
    
    public int size() {
      return this.end - this.start;
    }
    
    public List<Integer> subList(int param1Int1, int param1Int2) {
      Preconditions.checkPositionIndexes(param1Int1, param1Int2, size());
      if (param1Int1 == param1Int2)
        return Collections.emptyList(); 
      int[] arrayOfInt = this.array;
      int i = this.start;
      return new IntArrayAsList(arrayOfInt, param1Int1 + i, i + param1Int2);
    }
    
    int[] toIntArray() {
      int i = size();
      int[] arrayOfInt = new int[i];
      System.arraycopy(this.array, this.start, arrayOfInt, 0, i);
      return arrayOfInt;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(size() * 5);
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
  
  private static final class IntConverter extends Converter<String, Integer> implements Serializable {
    static final IntConverter INSTANCE = new IntConverter();
    
    private static final long serialVersionUID = 1L;
    
    private Object readResolve() {
      return INSTANCE;
    }
    
    protected String doBackward(Integer param1Integer) {
      return param1Integer.toString();
    }
    
    protected Integer doForward(String param1String) {
      return Integer.decode(param1String);
    }
    
    public String toString() {
      return "Ints.stringConverter()";
    }
  }
  
  private enum LexicographicalComparator implements Comparator<int[]> {
    INSTANCE;
    
    static {
    
    }
    
    public int compare(int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
      int i = Math.min(param1ArrayOfint1.length, param1ArrayOfint2.length);
      for (byte b = 0; b < i; b++) {
        int j = Ints.compare(param1ArrayOfint1[b], param1ArrayOfint2[b]);
        if (j != 0)
          return j; 
      } 
      return param1ArrayOfint1.length - param1ArrayOfint2.length;
    }
    
    public String toString() {
      return "Ints.lexicographicalComparator()";
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\primitives\Ints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */