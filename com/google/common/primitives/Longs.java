package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
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

@GwtCompatible
public final class Longs {
  public static final int BYTES = 8;
  
  public static final long MAX_POWER_OF_TWO = 4611686018427387904L;
  
  private static final byte[] asciiDigits = createAsciiDigits();
  
  public static List<Long> asList(long... paramVarArgs) {
    return (paramVarArgs.length == 0) ? Collections.emptyList() : new LongArrayAsList(paramVarArgs);
  }
  
  public static int compare(long paramLong1, long paramLong2) {
    boolean bool;
    if (paramLong1 < paramLong2) {
      bool = true;
    } else if (paramLong1 > paramLong2) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static long[] concat(long[]... paramVarArgs) {
    int i = paramVarArgs.length;
    byte b = 0;
    int j = 0;
    while (b < i) {
      j += (paramVarArgs[b]).length;
      b++;
    } 
    long[] arrayOfLong = new long[j];
    i = paramVarArgs.length;
    b = 0;
    j = 0;
    while (b < i) {
      long[] arrayOfLong1 = paramVarArgs[b];
      System.arraycopy(arrayOfLong1, 0, arrayOfLong, j, arrayOfLong1.length);
      j += arrayOfLong1.length;
      b++;
    } 
    return arrayOfLong;
  }
  
  public static boolean contains(long[] paramArrayOflong, long paramLong) {
    int i = paramArrayOflong.length;
    for (byte b = 0; b < i; b++) {
      if (paramArrayOflong[b] == paramLong)
        return true; 
    } 
    return false;
  }
  
  private static byte[] createAsciiDigits() {
    byte b2;
    byte[] arrayOfByte = new byte[128];
    Arrays.fill(arrayOfByte, (byte)-1);
    byte b1 = 0;
    byte b = 0;
    while (true) {
      b2 = b1;
      if (b <= 9) {
        arrayOfByte[b + 48] = (byte)(byte)b;
        b++;
        continue;
      } 
      break;
    } 
    while (b2 <= 26) {
      b = (byte)(b2 + 10);
      arrayOfByte[b2 + 65] = (byte)b;
      arrayOfByte[b2 + 97] = (byte)b;
      b2++;
    } 
    return arrayOfByte;
  }
  
  private static int digit(char paramChar) {
    byte b;
    if (paramChar < '') {
      b = asciiDigits[paramChar];
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static long[] ensureCapacity(long[] paramArrayOflong, int paramInt1, int paramInt2) {
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
    long[] arrayOfLong = paramArrayOflong;
    if (paramArrayOflong.length < paramInt1)
      arrayOfLong = Arrays.copyOf(paramArrayOflong, paramInt1 + paramInt2); 
    return arrayOfLong;
  }
  
  public static long fromByteArray(byte[] paramArrayOfbyte) {
    boolean bool;
    if (paramArrayOfbyte.length >= 8) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "array too small: %s < %s", paramArrayOfbyte.length, 8);
    return fromBytes(paramArrayOfbyte[0], paramArrayOfbyte[1], paramArrayOfbyte[2], paramArrayOfbyte[3], paramArrayOfbyte[4], paramArrayOfbyte[5], paramArrayOfbyte[6], paramArrayOfbyte[7]);
  }
  
  public static long fromBytes(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8) {
    long l = paramByte1;
    return (paramByte2 & 0xFFL) << 48L | (l & 0xFFL) << 56L | (paramByte3 & 0xFFL) << 40L | (paramByte4 & 0xFFL) << 32L | (paramByte5 & 0xFFL) << 24L | (paramByte6 & 0xFFL) << 16L | (paramByte7 & 0xFFL) << 8L | paramByte8 & 0xFFL;
  }
  
  public static int hashCode(long paramLong) {
    return (int)(paramLong ^ paramLong >>> 32L);
  }
  
  public static int indexOf(long[] paramArrayOflong, long paramLong) {
    return indexOf(paramArrayOflong, paramLong, 0, paramArrayOflong.length);
  }
  
  private static int indexOf(long[] paramArrayOflong, long paramLong, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      if (paramArrayOflong[paramInt1] == paramLong)
        return paramInt1; 
      paramInt1++;
    } 
    return -1;
  }
  
  public static int indexOf(long[] paramArrayOflong1, long[] paramArrayOflong2) {
    Preconditions.checkNotNull(paramArrayOflong1, "array");
    Preconditions.checkNotNull(paramArrayOflong2, "target");
    if (paramArrayOflong2.length == 0)
      return 0; 
    byte b = 0;
    label17: while (b < paramArrayOflong1.length - paramArrayOflong2.length + 1) {
      for (byte b1 = 0; b1 < paramArrayOflong2.length; b1++) {
        if (paramArrayOflong1[b + b1] != paramArrayOflong2[b1]) {
          b++;
          continue label17;
        } 
      } 
      return b;
    } 
    return -1;
  }
  
  public static String join(String paramString, long... paramVarArgs) {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * 10);
    stringBuilder.append(paramVarArgs[0]);
    for (byte b = 1; b < paramVarArgs.length; b++) {
      stringBuilder.append(paramString);
      stringBuilder.append(paramVarArgs[b]);
    } 
    return stringBuilder.toString();
  }
  
  public static int lastIndexOf(long[] paramArrayOflong, long paramLong) {
    return lastIndexOf(paramArrayOflong, paramLong, 0, paramArrayOflong.length);
  }
  
  private static int lastIndexOf(long[] paramArrayOflong, long paramLong, int paramInt1, int paramInt2) {
    while (--paramInt2 >= paramInt1) {
      if (paramArrayOflong[paramInt2] == paramLong)
        return paramInt2; 
      paramInt2--;
    } 
    return -1;
  }
  
  public static Comparator<long[]> lexicographicalComparator() {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static long max(long... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    long l;
    for (l = paramVarArgs[0]; b < paramVarArgs.length; l = l1) {
      long l1 = l;
      if (paramVarArgs[b] > l)
        l1 = paramVarArgs[b]; 
      b++;
    } 
    return l;
  }
  
  public static long min(long... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    long l;
    for (l = paramVarArgs[0]; b < paramVarArgs.length; l = l1) {
      long l1 = l;
      if (paramVarArgs[b] < l)
        l1 = paramVarArgs[b]; 
      b++;
    } 
    return l;
  }
  
  @Beta
  public static Converter<String, Long> stringConverter() {
    return LongConverter.INSTANCE;
  }
  
  public static long[] toArray(Collection<? extends Number> paramCollection) {
    if (paramCollection instanceof LongArrayAsList)
      return ((LongArrayAsList)paramCollection).toLongArray(); 
    Object[] arrayOfObject = paramCollection.toArray();
    int i = arrayOfObject.length;
    long[] arrayOfLong = new long[i];
    for (byte b = 0; b < i; b++)
      arrayOfLong[b] = ((Number)Preconditions.checkNotNull(arrayOfObject[b])).longValue(); 
    return arrayOfLong;
  }
  
  public static byte[] toByteArray(long paramLong) {
    byte[] arrayOfByte = new byte[8];
    for (byte b = 7; b >= 0; b--) {
      arrayOfByte[b] = (byte)(byte)(int)(0xFFL & paramLong);
      paramLong >>= 8L;
    } 
    return arrayOfByte;
  }
  
  @CheckForNull
  @Nullable
  @Beta
  public static Long tryParse(String paramString) {
    return tryParse(paramString, 10);
  }
  
  @CheckForNull
  @Nullable
  @Beta
  public static Long tryParse(String paramString, int paramInt) {
    if (((String)Preconditions.checkNotNull(paramString)).isEmpty())
      return null; 
    if (paramInt >= 2 && paramInt <= 36) {
      byte b = 0;
      if (paramString.charAt(0) == '-')
        b = 1; 
      if (b == paramString.length())
        return null; 
      int i = b + 1;
      int j = digit(paramString.charAt(b));
      if (j < 0 || j >= paramInt)
        return null; 
      long l1 = -j;
      long l2 = paramInt;
      long l3 = Long.MIN_VALUE / l2;
      while (i < paramString.length()) {
        j = digit(paramString.charAt(i));
        if (j < 0 || j >= paramInt || l1 < l3)
          return null; 
        long l = l1 * l2;
        l1 = j;
        if (l < l1 - Long.MIN_VALUE)
          return null; 
        l1 = l - l1;
        i++;
      } 
      return (b != 0) ? Long.valueOf(l1) : ((l1 == Long.MIN_VALUE) ? null : Long.valueOf(-l1));
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("radix must be between MIN_RADIX and MAX_RADIX but was ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private enum LexicographicalComparator implements Comparator<long[]> {
    INSTANCE;
    
    static {
    
    }
    
    public int compare(long[] param1ArrayOflong1, long[] param1ArrayOflong2) {
      int i = Math.min(param1ArrayOflong1.length, param1ArrayOflong2.length);
      for (byte b = 0; b < i; b++) {
        int j = Longs.compare(param1ArrayOflong1[b], param1ArrayOflong2[b]);
        if (j != 0)
          return j; 
      } 
      return param1ArrayOflong1.length - param1ArrayOflong2.length;
    }
    
    public String toString() {
      return "Longs.lexicographicalComparator()";
    }
  }
  
  @GwtCompatible
  private static class LongArrayAsList extends AbstractList<Long> implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0L;
    
    final long[] array;
    
    final int end;
    
    final int start;
    
    LongArrayAsList(long[] param1ArrayOflong) {
      this(param1ArrayOflong, 0, param1ArrayOflong.length);
    }
    
    LongArrayAsList(long[] param1ArrayOflong, int param1Int1, int param1Int2) {
      this.array = param1ArrayOflong;
      this.start = param1Int1;
      this.end = param1Int2;
    }
    
    public boolean contains(Object param1Object) {
      boolean bool;
      if (param1Object instanceof Long && Longs.indexOf(this.array, ((Long)param1Object).longValue(), this.start, this.end) != -1) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof LongArrayAsList) {
        param1Object = param1Object;
        int i = size();
        if (param1Object.size() != i)
          return false; 
        for (byte b = 0; b < i; b++) {
          if (this.array[this.start + b] != ((LongArrayAsList)param1Object).array[((LongArrayAsList)param1Object).start + b])
            return false; 
        } 
        return true;
      } 
      return super.equals(param1Object);
    }
    
    public Long get(int param1Int) {
      Preconditions.checkElementIndex(param1Int, size());
      return Long.valueOf(this.array[this.start + param1Int]);
    }
    
    public int hashCode() {
      int i = this.start;
      int j = 1;
      while (i < this.end) {
        j = j * 31 + Longs.hashCode(this.array[i]);
        i++;
      } 
      return j;
    }
    
    public int indexOf(Object param1Object) {
      if (param1Object instanceof Long) {
        int i = Longs.indexOf(this.array, ((Long)param1Object).longValue(), this.start, this.end);
        if (i >= 0)
          return i - this.start; 
      } 
      return -1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public int lastIndexOf(Object param1Object) {
      if (param1Object instanceof Long) {
        int i = Longs.lastIndexOf(this.array, ((Long)param1Object).longValue(), this.start, this.end);
        if (i >= 0)
          return i - this.start; 
      } 
      return -1;
    }
    
    public Long set(int param1Int, Long param1Long) {
      Preconditions.checkElementIndex(param1Int, size());
      long[] arrayOfLong = this.array;
      int i = this.start;
      long l = arrayOfLong[i + param1Int];
      arrayOfLong[i + param1Int] = ((Long)Preconditions.checkNotNull(param1Long)).longValue();
      return Long.valueOf(l);
    }
    
    public int size() {
      return this.end - this.start;
    }
    
    public List<Long> subList(int param1Int1, int param1Int2) {
      Preconditions.checkPositionIndexes(param1Int1, param1Int2, size());
      if (param1Int1 == param1Int2)
        return Collections.emptyList(); 
      long[] arrayOfLong = this.array;
      int i = this.start;
      return new LongArrayAsList(arrayOfLong, param1Int1 + i, i + param1Int2);
    }
    
    long[] toLongArray() {
      int i = size();
      long[] arrayOfLong = new long[i];
      System.arraycopy(this.array, this.start, arrayOfLong, 0, i);
      return arrayOfLong;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(size() * 10);
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
  
  private static final class LongConverter extends Converter<String, Long> implements Serializable {
    static final LongConverter INSTANCE = new LongConverter();
    
    private static final long serialVersionUID = 1L;
    
    private Object readResolve() {
      return INSTANCE;
    }
    
    protected String doBackward(Long param1Long) {
      return param1Long.toString();
    }
    
    protected Long doForward(String param1String) {
      return Long.decode(param1String);
    }
    
    public String toString() {
      return "Longs.stringConverter()";
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\primitives\Longs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */