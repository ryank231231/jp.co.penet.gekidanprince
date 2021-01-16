package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
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

@GwtCompatible
public final class Booleans {
  public static List<Boolean> asList(boolean... paramVarArgs) {
    return (paramVarArgs.length == 0) ? Collections.emptyList() : new BooleanArrayAsList(paramVarArgs);
  }
  
  public static int compare(boolean paramBoolean1, boolean paramBoolean2) {
    byte b;
    if (paramBoolean1 == paramBoolean2) {
      b = 0;
    } else if (paramBoolean1) {
      b = 1;
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static boolean[] concat(boolean[]... paramVarArgs) {
    int i = paramVarArgs.length;
    byte b = 0;
    int j = 0;
    while (b < i) {
      j += (paramVarArgs[b]).length;
      b++;
    } 
    boolean[] arrayOfBoolean = new boolean[j];
    i = paramVarArgs.length;
    b = 0;
    j = 0;
    while (b < i) {
      boolean[] arrayOfBoolean1 = paramVarArgs[b];
      System.arraycopy(arrayOfBoolean1, 0, arrayOfBoolean, j, arrayOfBoolean1.length);
      j += arrayOfBoolean1.length;
      b++;
    } 
    return arrayOfBoolean;
  }
  
  public static boolean contains(boolean[] paramArrayOfboolean, boolean paramBoolean) {
    int i = paramArrayOfboolean.length;
    for (byte b = 0; b < i; b++) {
      if (paramArrayOfboolean[b] == paramBoolean)
        return true; 
    } 
    return false;
  }
  
  @Beta
  public static int countTrue(boolean... paramVarArgs) {
    int i = paramVarArgs.length;
    byte b = 0;
    int j;
    for (j = 0; b < i; j = k) {
      int k = j;
      if (paramVarArgs[b])
        k = j + 1; 
      b++;
    } 
    return j;
  }
  
  public static boolean[] ensureCapacity(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2) {
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
    boolean[] arrayOfBoolean = paramArrayOfboolean;
    if (paramArrayOfboolean.length < paramInt1)
      arrayOfBoolean = Arrays.copyOf(paramArrayOfboolean, paramInt1 + paramInt2); 
    return arrayOfBoolean;
  }
  
  public static int hashCode(boolean paramBoolean) {
    char c;
    if (paramBoolean) {
      c = 'ӏ';
    } else {
      c = 'ӕ';
    } 
    return c;
  }
  
  public static int indexOf(boolean[] paramArrayOfboolean, boolean paramBoolean) {
    return indexOf(paramArrayOfboolean, paramBoolean, 0, paramArrayOfboolean.length);
  }
  
  private static int indexOf(boolean[] paramArrayOfboolean, boolean paramBoolean, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      if (paramArrayOfboolean[paramInt1] == paramBoolean)
        return paramInt1; 
      paramInt1++;
    } 
    return -1;
  }
  
  public static int indexOf(boolean[] paramArrayOfboolean1, boolean[] paramArrayOfboolean2) {
    Preconditions.checkNotNull(paramArrayOfboolean1, "array");
    Preconditions.checkNotNull(paramArrayOfboolean2, "target");
    if (paramArrayOfboolean2.length == 0)
      return 0; 
    byte b = 0;
    label17: while (b < paramArrayOfboolean1.length - paramArrayOfboolean2.length + 1) {
      for (byte b1 = 0; b1 < paramArrayOfboolean2.length; b1++) {
        if (paramArrayOfboolean1[b + b1] != paramArrayOfboolean2[b1]) {
          b++;
          continue label17;
        } 
      } 
      return b;
    } 
    return -1;
  }
  
  public static String join(String paramString, boolean... paramVarArgs) {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * 7);
    stringBuilder.append(paramVarArgs[0]);
    for (byte b = 1; b < paramVarArgs.length; b++) {
      stringBuilder.append(paramString);
      stringBuilder.append(paramVarArgs[b]);
    } 
    return stringBuilder.toString();
  }
  
  public static int lastIndexOf(boolean[] paramArrayOfboolean, boolean paramBoolean) {
    return lastIndexOf(paramArrayOfboolean, paramBoolean, 0, paramArrayOfboolean.length);
  }
  
  private static int lastIndexOf(boolean[] paramArrayOfboolean, boolean paramBoolean, int paramInt1, int paramInt2) {
    while (--paramInt2 >= paramInt1) {
      if (paramArrayOfboolean[paramInt2] == paramBoolean)
        return paramInt2; 
      paramInt2--;
    } 
    return -1;
  }
  
  public static Comparator<boolean[]> lexicographicalComparator() {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static boolean[] toArray(Collection<Boolean> paramCollection) {
    if (paramCollection instanceof BooleanArrayAsList)
      return ((BooleanArrayAsList)paramCollection).toBooleanArray(); 
    Object[] arrayOfObject = paramCollection.toArray();
    int i = arrayOfObject.length;
    boolean[] arrayOfBoolean = new boolean[i];
    for (byte b = 0; b < i; b++)
      arrayOfBoolean[b] = ((Boolean)Preconditions.checkNotNull(arrayOfObject[b])).booleanValue(); 
    return arrayOfBoolean;
  }
  
  @GwtCompatible
  private static class BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0L;
    
    final boolean[] array;
    
    final int end;
    
    final int start;
    
    BooleanArrayAsList(boolean[] param1ArrayOfboolean) {
      this(param1ArrayOfboolean, 0, param1ArrayOfboolean.length);
    }
    
    BooleanArrayAsList(boolean[] param1ArrayOfboolean, int param1Int1, int param1Int2) {
      this.array = param1ArrayOfboolean;
      this.start = param1Int1;
      this.end = param1Int2;
    }
    
    public boolean contains(Object param1Object) {
      boolean bool;
      if (param1Object instanceof Boolean && Booleans.indexOf(this.array, ((Boolean)param1Object).booleanValue(), this.start, this.end) != -1) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof BooleanArrayAsList) {
        param1Object = param1Object;
        int i = size();
        if (param1Object.size() != i)
          return false; 
        for (byte b = 0; b < i; b++) {
          if (this.array[this.start + b] != ((BooleanArrayAsList)param1Object).array[((BooleanArrayAsList)param1Object).start + b])
            return false; 
        } 
        return true;
      } 
      return super.equals(param1Object);
    }
    
    public Boolean get(int param1Int) {
      Preconditions.checkElementIndex(param1Int, size());
      return Boolean.valueOf(this.array[this.start + param1Int]);
    }
    
    public int hashCode() {
      int i = this.start;
      int j = 1;
      while (i < this.end) {
        j = j * 31 + Booleans.hashCode(this.array[i]);
        i++;
      } 
      return j;
    }
    
    public int indexOf(Object param1Object) {
      if (param1Object instanceof Boolean) {
        int i = Booleans.indexOf(this.array, ((Boolean)param1Object).booleanValue(), this.start, this.end);
        if (i >= 0)
          return i - this.start; 
      } 
      return -1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public int lastIndexOf(Object param1Object) {
      if (param1Object instanceof Boolean) {
        int i = Booleans.lastIndexOf(this.array, ((Boolean)param1Object).booleanValue(), this.start, this.end);
        if (i >= 0)
          return i - this.start; 
      } 
      return -1;
    }
    
    public Boolean set(int param1Int, Boolean param1Boolean) {
      Preconditions.checkElementIndex(param1Int, size());
      boolean[] arrayOfBoolean = this.array;
      int i = this.start;
      boolean bool = arrayOfBoolean[i + param1Int];
      arrayOfBoolean[i + param1Int] = ((Boolean)Preconditions.checkNotNull(param1Boolean)).booleanValue();
      return Boolean.valueOf(bool);
    }
    
    public int size() {
      return this.end - this.start;
    }
    
    public List<Boolean> subList(int param1Int1, int param1Int2) {
      Preconditions.checkPositionIndexes(param1Int1, param1Int2, size());
      if (param1Int1 == param1Int2)
        return Collections.emptyList(); 
      boolean[] arrayOfBoolean = this.array;
      int i = this.start;
      return new BooleanArrayAsList(arrayOfBoolean, param1Int1 + i, i + param1Int2);
    }
    
    boolean[] toBooleanArray() {
      int i = size();
      boolean[] arrayOfBoolean = new boolean[i];
      System.arraycopy(this.array, this.start, arrayOfBoolean, 0, i);
      return arrayOfBoolean;
    }
    
    public String toString() {
      String str;
      StringBuilder stringBuilder = new StringBuilder(size() * 7);
      if (this.array[this.start]) {
        str = "[true";
      } else {
        str = "[false";
      } 
      stringBuilder.append(str);
      int i = this.start;
      while (++i < this.end) {
        if (this.array[i]) {
          str = ", true";
        } else {
          str = ", false";
        } 
        stringBuilder.append(str);
      } 
      stringBuilder.append(']');
      return stringBuilder.toString();
    }
  }
  
  private enum LexicographicalComparator implements Comparator<boolean[]> {
    INSTANCE;
    
    static {
    
    }
    
    public int compare(boolean[] param1ArrayOfboolean1, boolean[] param1ArrayOfboolean2) {
      int i = Math.min(param1ArrayOfboolean1.length, param1ArrayOfboolean2.length);
      for (byte b = 0; b < i; b++) {
        int j = Booleans.compare(param1ArrayOfboolean1[b], param1ArrayOfboolean2[b]);
        if (j != 0)
          return j; 
      } 
      return param1ArrayOfboolean1.length - param1ArrayOfboolean2.length;
    }
    
    public String toString() {
      return "Booleans.lexicographicalComparator()";
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\primitives\Booleans.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */