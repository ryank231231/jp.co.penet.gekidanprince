package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Beta
@GwtIncompatible
public final class Quantiles {
  private static void checkIndex(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0 && paramInt1 <= paramInt2)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Quantile indexes must be between 0 and the scale, which is ");
    stringBuilder.append(paramInt2);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private static int chooseNextSelection(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramInt1 == paramInt2)
      return paramInt1; 
    int i = paramInt3 + paramInt4;
    paramInt4 = i >>> 1;
    while (paramInt2 > paramInt1 + 1) {
      paramInt3 = paramInt1 + paramInt2 >>> 1;
      if (paramArrayOfint[paramInt3] > paramInt4) {
        paramInt2 = paramInt3;
        continue;
      } 
      if (paramArrayOfint[paramInt3] < paramInt4) {
        paramInt1 = paramInt3;
        continue;
      } 
      return paramInt3;
    } 
    return (i - paramArrayOfint[paramInt1] - paramArrayOfint[paramInt2] > 0) ? paramInt2 : paramInt1;
  }
  
  private static boolean containsNaN(double... paramVarArgs) {
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      if (Double.isNaN(paramVarArgs[b]))
        return true; 
    } 
    return false;
  }
  
  private static double interpolate(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
    return (paramDouble1 == Double.NEGATIVE_INFINITY) ? ((paramDouble2 == Double.POSITIVE_INFINITY) ? Double.NaN : Double.NEGATIVE_INFINITY) : ((paramDouble2 == Double.POSITIVE_INFINITY) ? Double.POSITIVE_INFINITY : (paramDouble1 + (paramDouble2 - paramDouble1) * paramDouble3 / paramDouble4));
  }
  
  private static double[] intsToDoubles(int[] paramArrayOfint) {
    int i = paramArrayOfint.length;
    double[] arrayOfDouble = new double[i];
    for (byte b = 0; b < i; b++)
      arrayOfDouble[b] = paramArrayOfint[b]; 
    return arrayOfDouble;
  }
  
  private static double[] longsToDoubles(long[] paramArrayOflong) {
    int i = paramArrayOflong.length;
    double[] arrayOfDouble = new double[i];
    for (byte b = 0; b < i; b++)
      arrayOfDouble[b] = paramArrayOflong[b]; 
    return arrayOfDouble;
  }
  
  public static ScaleAndIndex median() {
    return scale(2).index(1);
  }
  
  private static void movePivotToStartOfSlice(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
    boolean bool2;
    boolean bool3;
    boolean bool1 = true;
    int i = paramInt1 + paramInt2 >>> 1;
    if (paramArrayOfdouble[paramInt2] < paramArrayOfdouble[i]) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramArrayOfdouble[i] < paramArrayOfdouble[paramInt1]) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (paramArrayOfdouble[paramInt2] >= paramArrayOfdouble[paramInt1])
      bool1 = false; 
    if (bool2 == bool3) {
      swap(paramArrayOfdouble, i, paramInt1);
    } else if (bool2 != bool1) {
      swap(paramArrayOfdouble, paramInt1, paramInt2);
    } 
  }
  
  private static int partition(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
    movePivotToStartOfSlice(paramArrayOfdouble, paramInt1, paramInt2);
    double d = paramArrayOfdouble[paramInt1];
    int i;
    for (i = paramInt2; paramInt2 > paramInt1; i = j) {
      int j = i;
      if (paramArrayOfdouble[paramInt2] > d) {
        swap(paramArrayOfdouble, i, paramInt2);
        j = i - 1;
      } 
      paramInt2--;
    } 
    swap(paramArrayOfdouble, paramInt1, i);
    return i;
  }
  
  public static Scale percentiles() {
    return scale(100);
  }
  
  public static Scale quartiles() {
    return scale(4);
  }
  
  public static Scale scale(int paramInt) {
    return new Scale(paramInt);
  }
  
  private static void selectAllInPlace(int[] paramArrayOfint, int paramInt1, int paramInt2, double[] paramArrayOfdouble, int paramInt3, int paramInt4) {
    int i = chooseNextSelection(paramArrayOfint, paramInt1, paramInt2, paramInt3, paramInt4);
    int j = paramArrayOfint[i];
    selectInPlace(j, paramArrayOfdouble, paramInt3, paramInt4);
    int k;
    for (k = i - 1; k >= paramInt1 && paramArrayOfint[k] == j; k--);
    if (k >= paramInt1)
      selectAllInPlace(paramArrayOfint, paramInt1, k, paramArrayOfdouble, paramInt3, j - 1); 
    for (paramInt1 = i + 1; paramInt1 <= paramInt2 && paramArrayOfint[paramInt1] == j; paramInt1++);
    if (paramInt1 <= paramInt2)
      selectAllInPlace(paramArrayOfint, paramInt1, paramInt2, paramArrayOfdouble, j + 1, paramInt4); 
  }
  
  private static void selectInPlace(int paramInt1, double[] paramArrayOfdouble, int paramInt2, int paramInt3) {
    int i = paramInt2;
    int j = paramInt3;
    if (paramInt1 == paramInt2) {
      paramInt1 = paramInt2 + 1;
      for (j = paramInt2; paramInt1 <= paramInt3; j = i) {
        i = j;
        if (paramArrayOfdouble[j] > paramArrayOfdouble[paramInt1])
          i = paramInt1; 
        paramInt1++;
      } 
      if (j != paramInt2)
        swap(paramArrayOfdouble, j, paramInt2); 
      return;
    } 
    while (j > i) {
      paramInt3 = partition(paramArrayOfdouble, i, j);
      paramInt2 = j;
      if (paramInt3 >= paramInt1)
        paramInt2 = paramInt3 - 1; 
      j = paramInt2;
      if (paramInt3 <= paramInt1) {
        i = paramInt3 + 1;
        j = paramInt2;
      } 
    } 
  }
  
  private static void swap(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
    double d = paramArrayOfdouble[paramInt1];
    paramArrayOfdouble[paramInt1] = paramArrayOfdouble[paramInt2];
    paramArrayOfdouble[paramInt2] = d;
  }
  
  public static final class Scale {
    private final int scale;
    
    private Scale(int param1Int) {
      boolean bool;
      if (param1Int > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "Quantile scale must be positive");
      this.scale = param1Int;
    }
    
    public Quantiles.ScaleAndIndex index(int param1Int) {
      return new Quantiles.ScaleAndIndex(this.scale, param1Int);
    }
    
    public Quantiles.ScaleAndIndexes indexes(Collection<Integer> param1Collection) {
      return new Quantiles.ScaleAndIndexes(this.scale, Ints.toArray(param1Collection));
    }
    
    public Quantiles.ScaleAndIndexes indexes(int... param1VarArgs) {
      return new Quantiles.ScaleAndIndexes(this.scale, (int[])param1VarArgs.clone());
    }
  }
  
  public static final class ScaleAndIndex {
    private final int index;
    
    private final int scale;
    
    private ScaleAndIndex(int param1Int1, int param1Int2) {
      Quantiles.checkIndex(param1Int2, param1Int1);
      this.scale = param1Int1;
      this.index = param1Int2;
    }
    
    public double compute(Collection<? extends Number> param1Collection) {
      return computeInPlace(Doubles.toArray(param1Collection));
    }
    
    public double compute(double... param1VarArgs) {
      return computeInPlace((double[])param1VarArgs.clone());
    }
    
    public double compute(int... param1VarArgs) {
      return computeInPlace(Quantiles.intsToDoubles(param1VarArgs));
    }
    
    public double compute(long... param1VarArgs) {
      return computeInPlace(Quantiles.longsToDoubles(param1VarArgs));
    }
    
    public double computeInPlace(double... param1VarArgs) {
      boolean bool;
      if (param1VarArgs.length > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "Cannot calculate quantiles of an empty dataset");
      if (Quantiles.containsNaN(param1VarArgs))
        return Double.NaN; 
      long l = this.index * (param1VarArgs.length - 1);
      int i = (int)LongMath.divide(l, this.scale, RoundingMode.DOWN);
      int j = (int)(l - i * this.scale);
      Quantiles.selectInPlace(i, param1VarArgs, 0, param1VarArgs.length - 1);
      if (j == 0)
        return param1VarArgs[i]; 
      int k = i + 1;
      Quantiles.selectInPlace(k, param1VarArgs, k, param1VarArgs.length - 1);
      return Quantiles.interpolate(param1VarArgs[i], param1VarArgs[k], j, this.scale);
    }
  }
  
  public static final class ScaleAndIndexes {
    private final int[] indexes;
    
    private final int scale;
    
    private ScaleAndIndexes(int param1Int, int[] param1ArrayOfint) {
      int i = param1ArrayOfint.length;
      for (byte b = 0; b < i; b++)
        Quantiles.checkIndex(param1ArrayOfint[b], param1Int); 
      this.scale = param1Int;
      this.indexes = param1ArrayOfint;
    }
    
    public Map<Integer, Double> compute(Collection<? extends Number> param1Collection) {
      return computeInPlace(Doubles.toArray(param1Collection));
    }
    
    public Map<Integer, Double> compute(double... param1VarArgs) {
      return computeInPlace((double[])param1VarArgs.clone());
    }
    
    public Map<Integer, Double> compute(int... param1VarArgs) {
      return computeInPlace(Quantiles.intsToDoubles(param1VarArgs));
    }
    
    public Map<Integer, Double> compute(long... param1VarArgs) {
      return computeInPlace(Quantiles.longsToDoubles(param1VarArgs));
    }
    
    public Map<Integer, Double> computeInPlace(double... param1VarArgs) {
      HashMap<Object, Object> hashMap;
      boolean bool;
      int i = param1VarArgs.length;
      int j = 0;
      int k = 0;
      if (i > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "Cannot calculate quantiles of an empty dataset");
      if (Quantiles.containsNaN(param1VarArgs)) {
        hashMap = new HashMap<Object, Object>();
        int[] arrayOfInt = this.indexes;
        i = arrayOfInt.length;
        while (k < i) {
          hashMap.put(Integer.valueOf(arrayOfInt[k]), Double.valueOf(Double.NaN));
          k++;
        } 
        return (Map)Collections.unmodifiableMap(hashMap);
      } 
      int[] arrayOfInt2 = this.indexes;
      int[] arrayOfInt1 = new int[arrayOfInt2.length];
      int[] arrayOfInt3 = new int[arrayOfInt2.length];
      arrayOfInt2 = new int[arrayOfInt2.length * 2];
      i = 0;
      k = 0;
      while (true) {
        int[] arrayOfInt = this.indexes;
        if (i < arrayOfInt.length) {
          long l = arrayOfInt[i] * (hashMap.length - 1);
          int m = (int)LongMath.divide(l, this.scale, RoundingMode.DOWN);
          int n = (int)(l - m * this.scale);
          arrayOfInt1[i] = m;
          arrayOfInt3[i] = n;
          arrayOfInt2[k] = m;
          int i1 = k + 1;
          k = i1;
          if (n != 0) {
            arrayOfInt2[i1] = m + 1;
            k = i1 + 1;
          } 
          i++;
          continue;
        } 
        Arrays.sort(arrayOfInt2, 0, k);
        Quantiles.selectAllInPlace(arrayOfInt2, 0, k - 1, (double[])hashMap, 0, hashMap.length - 1);
        HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
        k = j;
        while (true) {
          arrayOfInt = this.indexes;
          if (k < arrayOfInt.length) {
            j = arrayOfInt1[k];
            i = arrayOfInt3[k];
            if (i == 0) {
              hashMap1.put(Integer.valueOf(arrayOfInt[k]), Double.valueOf(hashMap[j]));
            } else {
              hashMap1.put(Integer.valueOf(arrayOfInt[k]), Double.valueOf(Quantiles.interpolate(hashMap[j], hashMap[j + 1], i, this.scale)));
            } 
            k++;
            continue;
          } 
          return (Map)Collections.unmodifiableMap(hashMap1);
        } 
        break;
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\math\Quantiles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */