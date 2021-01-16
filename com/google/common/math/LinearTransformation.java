package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;

@Beta
@GwtIncompatible
public abstract class LinearTransformation {
  public static LinearTransformation forNaN() {
    return NaNLinearTransformation.INSTANCE;
  }
  
  public static LinearTransformation horizontal(double paramDouble) {
    Preconditions.checkArgument(DoubleUtils.isFinite(paramDouble));
    return new RegularLinearTransformation(0.0D, paramDouble);
  }
  
  public static LinearTransformationBuilder mapping(double paramDouble1, double paramDouble2) {
    boolean bool;
    if (DoubleUtils.isFinite(paramDouble1) && DoubleUtils.isFinite(paramDouble2)) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    return new LinearTransformationBuilder(paramDouble1, paramDouble2);
  }
  
  public static LinearTransformation vertical(double paramDouble) {
    Preconditions.checkArgument(DoubleUtils.isFinite(paramDouble));
    return new VerticalLinearTransformation(paramDouble);
  }
  
  public abstract LinearTransformation inverse();
  
  public abstract boolean isHorizontal();
  
  public abstract boolean isVertical();
  
  public abstract double slope();
  
  public abstract double transform(double paramDouble);
  
  public static final class LinearTransformationBuilder {
    private final double x1;
    
    private final double y1;
    
    private LinearTransformationBuilder(double param1Double1, double param1Double2) {
      this.x1 = param1Double1;
      this.y1 = param1Double2;
    }
    
    public LinearTransformation and(double param1Double1, double param1Double2) {
      boolean bool = DoubleUtils.isFinite(param1Double1);
      boolean bool1 = true;
      if (bool && DoubleUtils.isFinite(param1Double2)) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool);
      double d = this.x1;
      if (param1Double1 == d) {
        if (param1Double2 != this.y1) {
          bool = bool1;
        } else {
          bool = false;
        } 
        Preconditions.checkArgument(bool);
        return new LinearTransformation.VerticalLinearTransformation(this.x1);
      } 
      return withSlope((param1Double2 - this.y1) / (param1Double1 - d));
    }
    
    public LinearTransformation withSlope(double param1Double) {
      Preconditions.checkArgument(Double.isNaN(param1Double) ^ true);
      return (LinearTransformation)(DoubleUtils.isFinite(param1Double) ? new LinearTransformation.RegularLinearTransformation(param1Double, this.y1 - this.x1 * param1Double) : new LinearTransformation.VerticalLinearTransformation(this.x1));
    }
  }
  
  private static final class NaNLinearTransformation extends LinearTransformation {
    static final NaNLinearTransformation INSTANCE = new NaNLinearTransformation();
    
    public LinearTransformation inverse() {
      return this;
    }
    
    public boolean isHorizontal() {
      return false;
    }
    
    public boolean isVertical() {
      return false;
    }
    
    public double slope() {
      return Double.NaN;
    }
    
    public String toString() {
      return "NaN";
    }
    
    public double transform(double param1Double) {
      return Double.NaN;
    }
  }
  
  private static final class RegularLinearTransformation extends LinearTransformation {
    @LazyInit
    LinearTransformation inverse;
    
    final double slope;
    
    final double yIntercept;
    
    RegularLinearTransformation(double param1Double1, double param1Double2) {
      this.slope = param1Double1;
      this.yIntercept = param1Double2;
      this.inverse = null;
    }
    
    RegularLinearTransformation(double param1Double1, double param1Double2, LinearTransformation param1LinearTransformation) {
      this.slope = param1Double1;
      this.yIntercept = param1Double2;
      this.inverse = param1LinearTransformation;
    }
    
    private LinearTransformation createInverse() {
      double d = this.slope;
      return (LinearTransformation)((d != 0.0D) ? new RegularLinearTransformation(1.0D / d, this.yIntercept * -1.0D / d, this) : new LinearTransformation.VerticalLinearTransformation(this.yIntercept, this));
    }
    
    public LinearTransformation inverse() {
      LinearTransformation linearTransformation1 = this.inverse;
      LinearTransformation linearTransformation2 = linearTransformation1;
      if (linearTransformation1 == null) {
        linearTransformation2 = createInverse();
        this.inverse = linearTransformation2;
      } 
      return linearTransformation2;
    }
    
    public boolean isHorizontal() {
      boolean bool;
      if (this.slope == 0.0D) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean isVertical() {
      return false;
    }
    
    public double slope() {
      return this.slope;
    }
    
    public String toString() {
      return String.format("y = %g * x + %g", new Object[] { Double.valueOf(this.slope), Double.valueOf(this.yIntercept) });
    }
    
    public double transform(double param1Double) {
      return param1Double * this.slope + this.yIntercept;
    }
  }
  
  private static final class VerticalLinearTransformation extends LinearTransformation {
    @LazyInit
    LinearTransformation inverse;
    
    final double x;
    
    VerticalLinearTransformation(double param1Double) {
      this.x = param1Double;
      this.inverse = null;
    }
    
    VerticalLinearTransformation(double param1Double, LinearTransformation param1LinearTransformation) {
      this.x = param1Double;
      this.inverse = param1LinearTransformation;
    }
    
    private LinearTransformation createInverse() {
      return new LinearTransformation.RegularLinearTransformation(0.0D, this.x, this);
    }
    
    public LinearTransformation inverse() {
      LinearTransformation linearTransformation1 = this.inverse;
      LinearTransformation linearTransformation2 = linearTransformation1;
      if (linearTransformation1 == null) {
        linearTransformation2 = createInverse();
        this.inverse = linearTransformation2;
      } 
      return linearTransformation2;
    }
    
    public boolean isHorizontal() {
      return false;
    }
    
    public boolean isVertical() {
      return true;
    }
    
    public double slope() {
      throw new IllegalStateException();
    }
    
    public String toString() {
      return String.format("x = %g", new Object[] { Double.valueOf(this.x) });
    }
    
    public double transform(double param1Double) {
      throw new IllegalStateException();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\math\LinearTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */