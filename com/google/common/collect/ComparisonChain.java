package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ComparisonChain {
  private static final ComparisonChain ACTIVE = new ComparisonChain() {
      ComparisonChain classify(int param1Int) {
        ComparisonChain comparisonChain;
        if (param1Int < 0) {
          comparisonChain = ComparisonChain.LESS;
        } else if (param1Int > 0) {
          comparisonChain = ComparisonChain.GREATER;
        } else {
          comparisonChain = ComparisonChain.ACTIVE;
        } 
        return comparisonChain;
      }
      
      public ComparisonChain compare(double param1Double1, double param1Double2) {
        return classify(Double.compare(param1Double1, param1Double2));
      }
      
      public ComparisonChain compare(float param1Float1, float param1Float2) {
        return classify(Float.compare(param1Float1, param1Float2));
      }
      
      public ComparisonChain compare(int param1Int1, int param1Int2) {
        return classify(Ints.compare(param1Int1, param1Int2));
      }
      
      public ComparisonChain compare(long param1Long1, long param1Long2) {
        return classify(Longs.compare(param1Long1, param1Long2));
      }
      
      public ComparisonChain compare(Comparable<Comparable> param1Comparable1, Comparable param1Comparable2) {
        return classify(param1Comparable1.compareTo(param1Comparable2));
      }
      
      public <T> ComparisonChain compare(@Nullable T param1T1, @Nullable T param1T2, Comparator<T> param1Comparator) {
        return classify(param1Comparator.compare(param1T1, param1T2));
      }
      
      public ComparisonChain compareFalseFirst(boolean param1Boolean1, boolean param1Boolean2) {
        return classify(Booleans.compare(param1Boolean1, param1Boolean2));
      }
      
      public ComparisonChain compareTrueFirst(boolean param1Boolean1, boolean param1Boolean2) {
        return classify(Booleans.compare(param1Boolean2, param1Boolean1));
      }
      
      public int result() {
        return 0;
      }
    };
  
  private static final ComparisonChain GREATER;
  
  private static final ComparisonChain LESS = new InactiveComparisonChain(-1);
  
  static {
    GREATER = new InactiveComparisonChain(1);
  }
  
  private ComparisonChain() {}
  
  public static ComparisonChain start() {
    return ACTIVE;
  }
  
  public abstract ComparisonChain compare(double paramDouble1, double paramDouble2);
  
  public abstract ComparisonChain compare(float paramFloat1, float paramFloat2);
  
  public abstract ComparisonChain compare(int paramInt1, int paramInt2);
  
  public abstract ComparisonChain compare(long paramLong1, long paramLong2);
  
  @Deprecated
  public final ComparisonChain compare(Boolean paramBoolean1, Boolean paramBoolean2) {
    return compareFalseFirst(paramBoolean1.booleanValue(), paramBoolean2.booleanValue());
  }
  
  public abstract ComparisonChain compare(Comparable<?> paramComparable1, Comparable<?> paramComparable2);
  
  public abstract <T> ComparisonChain compare(@Nullable T paramT1, @Nullable T paramT2, Comparator<T> paramComparator);
  
  public abstract ComparisonChain compareFalseFirst(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract ComparisonChain compareTrueFirst(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract int result();
  
  private static final class InactiveComparisonChain extends ComparisonChain {
    final int result;
    
    InactiveComparisonChain(int param1Int) {
      this.result = param1Int;
    }
    
    public ComparisonChain compare(double param1Double1, double param1Double2) {
      return this;
    }
    
    public ComparisonChain compare(float param1Float1, float param1Float2) {
      return this;
    }
    
    public ComparisonChain compare(int param1Int1, int param1Int2) {
      return this;
    }
    
    public ComparisonChain compare(long param1Long1, long param1Long2) {
      return this;
    }
    
    public ComparisonChain compare(@Nullable Comparable param1Comparable1, @Nullable Comparable param1Comparable2) {
      return this;
    }
    
    public <T> ComparisonChain compare(@Nullable T param1T1, @Nullable T param1T2, @Nullable Comparator<T> param1Comparator) {
      return this;
    }
    
    public ComparisonChain compareFalseFirst(boolean param1Boolean1, boolean param1Boolean2) {
      return this;
    }
    
    public ComparisonChain compareTrueFirst(boolean param1Boolean1, boolean param1Boolean2) {
      return this;
    }
    
    public int result() {
      return this.result;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ComparisonChain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */