package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
public final class Bytes {
  public static List<Byte> asList(byte... paramVarArgs) {
    return (paramVarArgs.length == 0) ? Collections.emptyList() : new ByteArrayAsList(paramVarArgs);
  }
  
  public static byte[] concat(byte[]... paramVarArgs) {
    int i = paramVarArgs.length;
    byte b = 0;
    int j = 0;
    while (b < i) {
      j += (paramVarArgs[b]).length;
      b++;
    } 
    byte[] arrayOfByte = new byte[j];
    i = paramVarArgs.length;
    b = 0;
    j = 0;
    while (b < i) {
      byte[] arrayOfByte1 = paramVarArgs[b];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte, j, arrayOfByte1.length);
      j += arrayOfByte1.length;
      b++;
    } 
    return arrayOfByte;
  }
  
  public static boolean contains(byte[] paramArrayOfbyte, byte paramByte) {
    int i = paramArrayOfbyte.length;
    for (byte b = 0; b < i; b++) {
      if (paramArrayOfbyte[b] == paramByte)
        return true; 
    } 
    return false;
  }
  
  public static byte[] ensureCapacity(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
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
    byte[] arrayOfByte = paramArrayOfbyte;
    if (paramArrayOfbyte.length < paramInt1)
      arrayOfByte = Arrays.copyOf(paramArrayOfbyte, paramInt1 + paramInt2); 
    return arrayOfByte;
  }
  
  public static int hashCode(byte paramByte) {
    return paramByte;
  }
  
  public static int indexOf(byte[] paramArrayOfbyte, byte paramByte) {
    return indexOf(paramArrayOfbyte, paramByte, 0, paramArrayOfbyte.length);
  }
  
  private static int indexOf(byte[] paramArrayOfbyte, byte paramByte, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      if (paramArrayOfbyte[paramInt1] == paramByte)
        return paramInt1; 
      paramInt1++;
    } 
    return -1;
  }
  
  public static int indexOf(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    Preconditions.checkNotNull(paramArrayOfbyte1, "array");
    Preconditions.checkNotNull(paramArrayOfbyte2, "target");
    if (paramArrayOfbyte2.length == 0)
      return 0; 
    byte b = 0;
    label17: while (b < paramArrayOfbyte1.length - paramArrayOfbyte2.length + 1) {
      for (byte b1 = 0; b1 < paramArrayOfbyte2.length; b1++) {
        if (paramArrayOfbyte1[b + b1] != paramArrayOfbyte2[b1]) {
          b++;
          continue label17;
        } 
      } 
      return b;
    } 
    return -1;
  }
  
  public static int lastIndexOf(byte[] paramArrayOfbyte, byte paramByte) {
    return lastIndexOf(paramArrayOfbyte, paramByte, 0, paramArrayOfbyte.length);
  }
  
  private static int lastIndexOf(byte[] paramArrayOfbyte, byte paramByte, int paramInt1, int paramInt2) {
    while (--paramInt2 >= paramInt1) {
      if (paramArrayOfbyte[paramInt2] == paramByte)
        return paramInt2; 
      paramInt2--;
    } 
    return -1;
  }
  
  public static byte[] toArray(Collection<? extends Number> paramCollection) {
    if (paramCollection instanceof ByteArrayAsList)
      return ((ByteArrayAsList)paramCollection).toByteArray(); 
    Object[] arrayOfObject = paramCollection.toArray();
    int i = arrayOfObject.length;
    byte[] arrayOfByte = new byte[i];
    for (byte b = 0; b < i; b++)
      arrayOfByte[b] = ((Number)Preconditions.checkNotNull(arrayOfObject[b])).byteValue(); 
    return arrayOfByte;
  }
  
  @GwtCompatible
  private static class ByteArrayAsList extends AbstractList<Byte> implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0L;
    
    final byte[] array;
    
    final int end;
    
    final int start;
    
    ByteArrayAsList(byte[] param1ArrayOfbyte) {
      this(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
    }
    
    ByteArrayAsList(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      this.array = param1ArrayOfbyte;
      this.start = param1Int1;
      this.end = param1Int2;
    }
    
    public boolean contains(Object param1Object) {
      boolean bool;
      if (param1Object instanceof Byte && Bytes.indexOf(this.array, ((Byte)param1Object).byteValue(), this.start, this.end) != -1) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof ByteArrayAsList) {
        param1Object = param1Object;
        int i = size();
        if (param1Object.size() != i)
          return false; 
        for (byte b = 0; b < i; b++) {
          if (this.array[this.start + b] != ((ByteArrayAsList)param1Object).array[((ByteArrayAsList)param1Object).start + b])
            return false; 
        } 
        return true;
      } 
      return super.equals(param1Object);
    }
    
    public Byte get(int param1Int) {
      Preconditions.checkElementIndex(param1Int, size());
      return Byte.valueOf(this.array[this.start + param1Int]);
    }
    
    public int hashCode() {
      int i = this.start;
      int j = 1;
      while (i < this.end) {
        j = j * 31 + Bytes.hashCode(this.array[i]);
        i++;
      } 
      return j;
    }
    
    public int indexOf(Object param1Object) {
      if (param1Object instanceof Byte) {
        int i = Bytes.indexOf(this.array, ((Byte)param1Object).byteValue(), this.start, this.end);
        if (i >= 0)
          return i - this.start; 
      } 
      return -1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public int lastIndexOf(Object param1Object) {
      if (param1Object instanceof Byte) {
        int i = Bytes.lastIndexOf(this.array, ((Byte)param1Object).byteValue(), this.start, this.end);
        if (i >= 0)
          return i - this.start; 
      } 
      return -1;
    }
    
    public Byte set(int param1Int, Byte param1Byte) {
      Preconditions.checkElementIndex(param1Int, size());
      byte[] arrayOfByte = this.array;
      int i = this.start;
      byte b = arrayOfByte[i + param1Int];
      arrayOfByte[i + param1Int] = ((Byte)Preconditions.checkNotNull(param1Byte)).byteValue();
      return Byte.valueOf(b);
    }
    
    public int size() {
      return this.end - this.start;
    }
    
    public List<Byte> subList(int param1Int1, int param1Int2) {
      Preconditions.checkPositionIndexes(param1Int1, param1Int2, size());
      if (param1Int1 == param1Int2)
        return Collections.emptyList(); 
      byte[] arrayOfByte = this.array;
      int i = this.start;
      return new ByteArrayAsList(arrayOfByte, param1Int1 + i, i + param1Int2);
    }
    
    byte[] toByteArray() {
      int i = size();
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.array, this.start, arrayOfByte, 0, i);
      return arrayOfByte;
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
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\primitives\Bytes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */