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
public final class Floats {
  public static final int BYTES = 4;
  
  public static List<Float> asList(float... paramVarArgs) {
    return (paramVarArgs.length == 0) ? Collections.emptyList() : new FloatArrayAsList(paramVarArgs);
  }
  
  public static int compare(float paramFloat1, float paramFloat2) {
    return Float.compare(paramFloat1, paramFloat2);
  }
  
  public static float[] concat(float[]... paramVarArgs) {
    int i = paramVarArgs.length;
    byte b = 0;
    int j = 0;
    while (b < i) {
      j += (paramVarArgs[b]).length;
      b++;
    } 
    float[] arrayOfFloat = new float[j];
    i = paramVarArgs.length;
    b = 0;
    j = 0;
    while (b < i) {
      float[] arrayOfFloat1 = paramVarArgs[b];
      System.arraycopy(arrayOfFloat1, 0, arrayOfFloat, j, arrayOfFloat1.length);
      j += arrayOfFloat1.length;
      b++;
    } 
    return arrayOfFloat;
  }
  
  public static boolean contains(float[] paramArrayOffloat, float paramFloat) {
    int i = paramArrayOffloat.length;
    for (byte b = 0; b < i; b++) {
      if (paramArrayOffloat[b] == paramFloat)
        return true; 
    } 
    return false;
  }
  
  public static float[] ensureCapacity(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
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
    float[] arrayOfFloat = paramArrayOffloat;
    if (paramArrayOffloat.length < paramInt1)
      arrayOfFloat = Arrays.copyOf(paramArrayOffloat, paramInt1 + paramInt2); 
    return arrayOfFloat;
  }
  
  public static int hashCode(float paramFloat) {
    return Float.valueOf(paramFloat).hashCode();
  }
  
  public static int indexOf(float[] paramArrayOffloat, float paramFloat) {
    return indexOf(paramArrayOffloat, paramFloat, 0, paramArrayOffloat.length);
  }
  
  private static int indexOf(float[] paramArrayOffloat, float paramFloat, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      if (paramArrayOffloat[paramInt1] == paramFloat)
        return paramInt1; 
      paramInt1++;
    } 
    return -1;
  }
  
  public static int indexOf(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
    Preconditions.checkNotNull(paramArrayOffloat1, "array");
    Preconditions.checkNotNull(paramArrayOffloat2, "target");
    if (paramArrayOffloat2.length == 0)
      return 0; 
    byte b = 0;
    label17: while (b < paramArrayOffloat1.length - paramArrayOffloat2.length + 1) {
      for (byte b1 = 0; b1 < paramArrayOffloat2.length; b1++) {
        if (paramArrayOffloat1[b + b1] != paramArrayOffloat2[b1]) {
          b++;
          continue label17;
        } 
      } 
      return b;
    } 
    return -1;
  }
  
  public static boolean isFinite(float paramFloat) {
    boolean bool2;
    boolean bool1 = true;
    if (Float.NEGATIVE_INFINITY < paramFloat) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramFloat >= Float.POSITIVE_INFINITY)
      bool1 = false; 
    return bool2 & bool1;
  }
  
  public static String join(String paramString, float... paramVarArgs) {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * 12);
    stringBuilder.append(paramVarArgs[0]);
    for (byte b = 1; b < paramVarArgs.length; b++) {
      stringBuilder.append(paramString);
      stringBuilder.append(paramVarArgs[b]);
    } 
    return stringBuilder.toString();
  }
  
  public static int lastIndexOf(float[] paramArrayOffloat, float paramFloat) {
    return lastIndexOf(paramArrayOffloat, paramFloat, 0, paramArrayOffloat.length);
  }
  
  private static int lastIndexOf(float[] paramArrayOffloat, float paramFloat, int paramInt1, int paramInt2) {
    while (--paramInt2 >= paramInt1) {
      if (paramArrayOffloat[paramInt2] == paramFloat)
        return paramInt2; 
      paramInt2--;
    } 
    return -1;
  }
  
  public static Comparator<float[]> lexicographicalComparator() {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static float max(float... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    float f = paramVarArgs[0];
    while (b < paramVarArgs.length) {
      f = Math.max(f, paramVarArgs[b]);
      b++;
    } 
    return f;
  }
  
  public static float min(float... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    float f = paramVarArgs[0];
    while (b < paramVarArgs.length) {
      f = Math.min(f, paramVarArgs[b]);
      b++;
    } 
    return f;
  }
  
  @Beta
  public static Converter<String, Float> stringConverter() {
    return FloatConverter.INSTANCE;
  }
  
  public static float[] toArray(Collection<? extends Number> paramCollection) {
    if (paramCollection instanceof FloatArrayAsList)
      return ((FloatArrayAsList)paramCollection).toFloatArray(); 
    Object[] arrayOfObject = paramCollection.toArray();
    int i = arrayOfObject.length;
    float[] arrayOfFloat = new float[i];
    for (byte b = 0; b < i; b++)
      arrayOfFloat[b] = ((Number)Preconditions.checkNotNull(arrayOfObject[b])).floatValue(); 
    return arrayOfFloat;
  }
  
  @CheckForNull
  @Nullable
  @Beta
  @GwtIncompatible
  public static Float tryParse(String paramString) {
    if (Doubles.FLOATING_POINT_PATTERN.matcher(paramString).matches())
      try {
        float f = Float.parseFloat(paramString);
        return Float.valueOf(f);
      } catch (NumberFormatException numberFormatException) {} 
    return null;
  }
  
  @GwtCompatible
  private static class FloatArrayAsList extends AbstractList<Float> implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0L;
    
    final float[] array;
    
    final int end;
    
    final int start;
    
    FloatArrayAsList(float[] param1ArrayOffloat) {
      this(param1ArrayOffloat, 0, param1ArrayOffloat.length);
    }
    
    FloatArrayAsList(float[] param1ArrayOffloat, int param1Int1, int param1Int2) {
      this.array = param1ArrayOffloat;
      this.start = param1Int1;
      this.end = param1Int2;
    }
    
    public boolean contains(Object param1Object) {
      boolean bool;
      if (param1Object instanceof Float && Floats.indexOf(this.array, ((Float)param1Object).floatValue(), this.start, this.end) != -1) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof FloatArrayAsList) {
        param1Object = param1Object;
        int i = size();
        if (param1Object.size() != i)
          return false; 
        for (byte b = 0; b < i; b++) {
          if (this.array[this.start + b] != ((FloatArrayAsList)param1Object).array[((FloatArrayAsList)param1Object).start + b])
            return false; 
        } 
        return true;
      } 
      return super.equals(param1Object);
    }
    
    public Float get(int param1Int) {
      Preconditions.checkElementIndex(param1Int, size());
      return Float.valueOf(this.array[this.start + param1Int]);
    }
    
    public int hashCode() {
      int i = this.start;
      int j = 1;
      while (i < this.end) {
        j = j * 31 + Floats.hashCode(this.array[i]);
        i++;
      } 
      return j;
    }
    
    public int indexOf(Object param1Object) {
      if (param1Object instanceof Float) {
        int i = Floats.indexOf(this.array, ((Float)param1Object).floatValue(), this.start, this.end);
        if (i >= 0)
          return i - this.start; 
      } 
      return -1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public int lastIndexOf(Object param1Object) {
      if (param1Object instanceof Float) {
        int i = Floats.lastIndexOf(this.array, ((Float)param1Object).floatValue(), this.start, this.end);
        if (i >= 0)
          return i - this.start; 
      } 
      return -1;
    }
    
    public Float set(int param1Int, Float param1Float) {
      Preconditions.checkElementIndex(param1Int, size());
      float[] arrayOfFloat = this.array;
      int i = this.start;
      float f = arrayOfFloat[i + param1Int];
      arrayOfFloat[i + param1Int] = ((Float)Preconditions.checkNotNull(param1Float)).floatValue();
      return Float.valueOf(f);
    }
    
    public int size() {
      return this.end - this.start;
    }
    
    public List<Float> subList(int param1Int1, int param1Int2) {
      Preconditions.checkPositionIndexes(param1Int1, param1Int2, size());
      if (param1Int1 == param1Int2)
        return Collections.emptyList(); 
      float[] arrayOfFloat = this.array;
      int i = this.start;
      return new FloatArrayAsList(arrayOfFloat, param1Int1 + i, i + param1Int2);
    }
    
    float[] toFloatArray() {
      int i = size();
      float[] arrayOfFloat = new float[i];
      System.arraycopy(this.array, this.start, arrayOfFloat, 0, i);
      return arrayOfFloat;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(size() * 12);
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
  
  private static final class FloatConverter extends Converter<String, Float> implements Serializable {
    static final FloatConverter INSTANCE = new FloatConverter();
    
    private static final long serialVersionUID = 1L;
    
    private Object readResolve() {
      return INSTANCE;
    }
    
    protected String doBackward(Float param1Float) {
      return param1Float.toString();
    }
    
    protected Float doForward(String param1String) {
      return Float.valueOf(param1String);
    }
    
    public String toString() {
      return "Floats.stringConverter()";
    }
  }
  
  private enum LexicographicalComparator implements Comparator<float[]> {
    INSTANCE;
    
    static {
    
    }
    
    public int compare(float[] param1ArrayOffloat1, float[] param1ArrayOffloat2) {
      int i = Math.min(param1ArrayOffloat1.length, param1ArrayOffloat2.length);
      for (byte b = 0; b < i; b++) {
        int j = Float.compare(param1ArrayOffloat1[b], param1ArrayOffloat2[b]);
        if (j != 0)
          return j; 
      } 
      return param1ArrayOffloat1.length - param1ArrayOffloat2.length;
    }
    
    public String toString() {
      return "Floats.lexicographicalComparator()";
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\primitives\Floats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */