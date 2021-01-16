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
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Doubles {
  public static final int BYTES = 8;
  
  @GwtIncompatible
  static final Pattern FLOATING_POINT_PATTERN = fpPattern();
  
  public static List<Double> asList(double... paramVarArgs) {
    return (paramVarArgs.length == 0) ? Collections.emptyList() : new DoubleArrayAsList(paramVarArgs);
  }
  
  public static int compare(double paramDouble1, double paramDouble2) {
    return Double.compare(paramDouble1, paramDouble2);
  }
  
  public static double[] concat(double[]... paramVarArgs) {
    int i = paramVarArgs.length;
    byte b = 0;
    int j = 0;
    while (b < i) {
      j += (paramVarArgs[b]).length;
      b++;
    } 
    double[] arrayOfDouble = new double[j];
    i = paramVarArgs.length;
    b = 0;
    j = 0;
    while (b < i) {
      double[] arrayOfDouble1 = paramVarArgs[b];
      System.arraycopy(arrayOfDouble1, 0, arrayOfDouble, j, arrayOfDouble1.length);
      j += arrayOfDouble1.length;
      b++;
    } 
    return arrayOfDouble;
  }
  
  public static boolean contains(double[] paramArrayOfdouble, double paramDouble) {
    int i = paramArrayOfdouble.length;
    for (byte b = 0; b < i; b++) {
      if (paramArrayOfdouble[b] == paramDouble)
        return true; 
    } 
    return false;
  }
  
  public static double[] ensureCapacity(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
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
    double[] arrayOfDouble = paramArrayOfdouble;
    if (paramArrayOfdouble.length < paramInt1)
      arrayOfDouble = Arrays.copyOf(paramArrayOfdouble, paramInt1 + paramInt2); 
    return arrayOfDouble;
  }
  
  @GwtIncompatible
  private static Pattern fpPattern() {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("(?:\\d++(?:\\.\\d*+)?|\\.\\d++)");
    stringBuilder1.append("(?:[eE][+-]?\\d++)?[fFdD]?");
    String str1 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("0[xX]");
    stringBuilder2.append("(?:\\p{XDigit}++(?:\\.\\p{XDigit}*+)?|\\.\\p{XDigit}++)");
    stringBuilder2.append("[pP][+-]?\\d++[fFdD]?");
    String str2 = stringBuilder2.toString();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("[+-]?(?:NaN|Infinity|");
    stringBuilder3.append(str1);
    stringBuilder3.append("|");
    stringBuilder3.append(str2);
    stringBuilder3.append(")");
    return Pattern.compile(stringBuilder3.toString());
  }
  
  public static int hashCode(double paramDouble) {
    return Double.valueOf(paramDouble).hashCode();
  }
  
  public static int indexOf(double[] paramArrayOfdouble, double paramDouble) {
    return indexOf(paramArrayOfdouble, paramDouble, 0, paramArrayOfdouble.length);
  }
  
  private static int indexOf(double[] paramArrayOfdouble, double paramDouble, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      if (paramArrayOfdouble[paramInt1] == paramDouble)
        return paramInt1; 
      paramInt1++;
    } 
    return -1;
  }
  
  public static int indexOf(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2) {
    Preconditions.checkNotNull(paramArrayOfdouble1, "array");
    Preconditions.checkNotNull(paramArrayOfdouble2, "target");
    if (paramArrayOfdouble2.length == 0)
      return 0; 
    byte b = 0;
    label17: while (b < paramArrayOfdouble1.length - paramArrayOfdouble2.length + 1) {
      for (byte b1 = 0; b1 < paramArrayOfdouble2.length; b1++) {
        if (paramArrayOfdouble1[b + b1] != paramArrayOfdouble2[b1]) {
          b++;
          continue label17;
        } 
      } 
      return b;
    } 
    return -1;
  }
  
  public static boolean isFinite(double paramDouble) {
    boolean bool2;
    boolean bool1 = true;
    if (Double.NEGATIVE_INFINITY < paramDouble) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramDouble >= Double.POSITIVE_INFINITY)
      bool1 = false; 
    return bool2 & bool1;
  }
  
  public static String join(String paramString, double... paramVarArgs) {
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
  
  public static int lastIndexOf(double[] paramArrayOfdouble, double paramDouble) {
    return lastIndexOf(paramArrayOfdouble, paramDouble, 0, paramArrayOfdouble.length);
  }
  
  private static int lastIndexOf(double[] paramArrayOfdouble, double paramDouble, int paramInt1, int paramInt2) {
    while (--paramInt2 >= paramInt1) {
      if (paramArrayOfdouble[paramInt2] == paramDouble)
        return paramInt2; 
      paramInt2--;
    } 
    return -1;
  }
  
  public static Comparator<double[]> lexicographicalComparator() {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static double max(double... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    double d = paramVarArgs[0];
    while (b < paramVarArgs.length) {
      d = Math.max(d, paramVarArgs[b]);
      b++;
    } 
    return d;
  }
  
  public static double min(double... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    double d = paramVarArgs[0];
    while (b < paramVarArgs.length) {
      d = Math.min(d, paramVarArgs[b]);
      b++;
    } 
    return d;
  }
  
  @Beta
  public static Converter<String, Double> stringConverter() {
    return DoubleConverter.INSTANCE;
  }
  
  public static double[] toArray(Collection<? extends Number> paramCollection) {
    if (paramCollection instanceof DoubleArrayAsList)
      return ((DoubleArrayAsList)paramCollection).toDoubleArray(); 
    Object[] arrayOfObject = paramCollection.toArray();
    int i = arrayOfObject.length;
    double[] arrayOfDouble = new double[i];
    for (byte b = 0; b < i; b++)
      arrayOfDouble[b] = ((Number)Preconditions.checkNotNull(arrayOfObject[b])).doubleValue(); 
    return arrayOfDouble;
  }
  
  @CheckForNull
  @Nullable
  @Beta
  @GwtIncompatible
  public static Double tryParse(String paramString) {
    if (FLOATING_POINT_PATTERN.matcher(paramString).matches())
      try {
        double d = Double.parseDouble(paramString);
        return Double.valueOf(d);
      } catch (NumberFormatException numberFormatException) {} 
    return null;
  }
  
  @GwtCompatible
  private static class DoubleArrayAsList extends AbstractList<Double> implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0L;
    
    final double[] array;
    
    final int end;
    
    final int start;
    
    DoubleArrayAsList(double[] param1ArrayOfdouble) {
      this(param1ArrayOfdouble, 0, param1ArrayOfdouble.length);
    }
    
    DoubleArrayAsList(double[] param1ArrayOfdouble, int param1Int1, int param1Int2) {
      this.array = param1ArrayOfdouble;
      this.start = param1Int1;
      this.end = param1Int2;
    }
    
    public boolean contains(Object param1Object) {
      boolean bool;
      if (param1Object instanceof Double && Doubles.indexOf(this.array, ((Double)param1Object).doubleValue(), this.start, this.end) != -1) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof DoubleArrayAsList) {
        param1Object = param1Object;
        int i = size();
        if (param1Object.size() != i)
          return false; 
        for (byte b = 0; b < i; b++) {
          if (this.array[this.start + b] != ((DoubleArrayAsList)param1Object).array[((DoubleArrayAsList)param1Object).start + b])
            return false; 
        } 
        return true;
      } 
      return super.equals(param1Object);
    }
    
    public Double get(int param1Int) {
      Preconditions.checkElementIndex(param1Int, size());
      return Double.valueOf(this.array[this.start + param1Int]);
    }
    
    public int hashCode() {
      int i = this.start;
      int j = 1;
      while (i < this.end) {
        j = j * 31 + Doubles.hashCode(this.array[i]);
        i++;
      } 
      return j;
    }
    
    public int indexOf(Object param1Object) {
      if (param1Object instanceof Double) {
        int i = Doubles.indexOf(this.array, ((Double)param1Object).doubleValue(), this.start, this.end);
        if (i >= 0)
          return i - this.start; 
      } 
      return -1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public int lastIndexOf(Object param1Object) {
      if (param1Object instanceof Double) {
        int i = Doubles.lastIndexOf(this.array, ((Double)param1Object).doubleValue(), this.start, this.end);
        if (i >= 0)
          return i - this.start; 
      } 
      return -1;
    }
    
    public Double set(int param1Int, Double param1Double) {
      Preconditions.checkElementIndex(param1Int, size());
      double[] arrayOfDouble = this.array;
      int i = this.start;
      double d = arrayOfDouble[i + param1Int];
      arrayOfDouble[i + param1Int] = ((Double)Preconditions.checkNotNull(param1Double)).doubleValue();
      return Double.valueOf(d);
    }
    
    public int size() {
      return this.end - this.start;
    }
    
    public List<Double> subList(int param1Int1, int param1Int2) {
      Preconditions.checkPositionIndexes(param1Int1, param1Int2, size());
      if (param1Int1 == param1Int2)
        return Collections.emptyList(); 
      double[] arrayOfDouble = this.array;
      int i = this.start;
      return new DoubleArrayAsList(arrayOfDouble, param1Int1 + i, i + param1Int2);
    }
    
    double[] toDoubleArray() {
      int i = size();
      double[] arrayOfDouble = new double[i];
      System.arraycopy(this.array, this.start, arrayOfDouble, 0, i);
      return arrayOfDouble;
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
  
  private static final class DoubleConverter extends Converter<String, Double> implements Serializable {
    static final DoubleConverter INSTANCE = new DoubleConverter();
    
    private static final long serialVersionUID = 1L;
    
    private Object readResolve() {
      return INSTANCE;
    }
    
    protected String doBackward(Double param1Double) {
      return param1Double.toString();
    }
    
    protected Double doForward(String param1String) {
      return Double.valueOf(param1String);
    }
    
    public String toString() {
      return "Doubles.stringConverter()";
    }
  }
  
  private enum LexicographicalComparator implements Comparator<double[]> {
    INSTANCE;
    
    static {
    
    }
    
    public int compare(double[] param1ArrayOfdouble1, double[] param1ArrayOfdouble2) {
      int i = Math.min(param1ArrayOfdouble1.length, param1ArrayOfdouble2.length);
      for (byte b = 0; b < i; b++) {
        int j = Double.compare(param1ArrayOfdouble1[b], param1ArrayOfdouble2[b]);
        if (j != 0)
          return j; 
      } 
      return param1ArrayOfdouble1.length - param1ArrayOfdouble2.length;
    }
    
    public String toString() {
      return "Doubles.lexicographicalComparator()";
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\primitives\Doubles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */