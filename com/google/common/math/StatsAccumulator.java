package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

@Beta
@GwtIncompatible
public final class StatsAccumulator {
  private long count = 0L;
  
  private double max = Double.NaN;
  
  private double mean = 0.0D;
  
  private double min = Double.NaN;
  
  private double sumOfSquaresOfDeltas = 0.0D;
  
  static double calculateNewMeanNonFinite(double paramDouble1, double paramDouble2) {
    return Doubles.isFinite(paramDouble1) ? paramDouble2 : ((Doubles.isFinite(paramDouble2) || paramDouble1 == paramDouble2) ? paramDouble1 : Double.NaN);
  }
  
  public void add(double paramDouble) {
    long l = this.count;
    if (l == 0L) {
      this.count = 1L;
      this.mean = paramDouble;
      this.min = paramDouble;
      this.max = paramDouble;
      if (!Doubles.isFinite(paramDouble))
        this.sumOfSquaresOfDeltas = Double.NaN; 
    } else {
      this.count = l + 1L;
      if (Doubles.isFinite(paramDouble) && Doubles.isFinite(this.mean)) {
        double d1 = this.mean;
        double d2 = paramDouble - d1;
        double d3 = this.count;
        Double.isNaN(d3);
        this.mean = d1 + d2 / d3;
        this.sumOfSquaresOfDeltas += d2 * (paramDouble - this.mean);
      } else {
        this.mean = calculateNewMeanNonFinite(this.mean, paramDouble);
        this.sumOfSquaresOfDeltas = Double.NaN;
      } 
      this.min = Math.min(this.min, paramDouble);
      this.max = Math.max(this.max, paramDouble);
    } 
  }
  
  public void addAll(Stats paramStats) {
    if (paramStats.count() == 0L)
      return; 
    long l = this.count;
    if (l == 0L) {
      this.count = paramStats.count();
      this.mean = paramStats.mean();
      this.sumOfSquaresOfDeltas = paramStats.sumOfSquaresOfDeltas();
      this.min = paramStats.min();
      this.max = paramStats.max();
    } else {
      this.count = l + paramStats.count();
      if (Doubles.isFinite(this.mean) && Doubles.isFinite(paramStats.mean())) {
        double d1 = paramStats.mean();
        double d2 = this.mean;
        d1 -= d2;
        double d3 = paramStats.count();
        Double.isNaN(d3);
        double d4 = this.count;
        Double.isNaN(d4);
        this.mean = d2 + d3 * d1 / d4;
        d2 = this.sumOfSquaresOfDeltas;
        double d5 = paramStats.sumOfSquaresOfDeltas();
        double d6 = paramStats.mean();
        d3 = this.mean;
        d4 = paramStats.count();
        Double.isNaN(d4);
        this.sumOfSquaresOfDeltas = d2 + d5 + d1 * (d6 - d3) * d4;
      } else {
        this.mean = calculateNewMeanNonFinite(this.mean, paramStats.mean());
        this.sumOfSquaresOfDeltas = Double.NaN;
      } 
      this.min = Math.min(this.min, paramStats.min());
      this.max = Math.max(this.max, paramStats.max());
    } 
  }
  
  public void addAll(Iterable<? extends Number> paramIterable) {
    Iterator<? extends Number> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      add(((Number)iterator.next()).doubleValue()); 
  }
  
  public void addAll(Iterator<? extends Number> paramIterator) {
    while (paramIterator.hasNext())
      add(((Number)paramIterator.next()).doubleValue()); 
  }
  
  public void addAll(double... paramVarArgs) {
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      add(paramVarArgs[b]); 
  }
  
  public void addAll(int... paramVarArgs) {
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      add(paramVarArgs[b]); 
  }
  
  public void addAll(long... paramVarArgs) {
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      add(paramVarArgs[b]); 
  }
  
  public long count() {
    return this.count;
  }
  
  public double max() {
    boolean bool;
    if (this.count != 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
    return this.max;
  }
  
  public double mean() {
    boolean bool;
    if (this.count != 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
    return this.mean;
  }
  
  public double min() {
    boolean bool;
    if (this.count != 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
    return this.min;
  }
  
  public final double populationStandardDeviation() {
    return Math.sqrt(populationVariance());
  }
  
  public final double populationVariance() {
    boolean bool;
    if (this.count != 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
    if (Double.isNaN(this.sumOfSquaresOfDeltas))
      return Double.NaN; 
    if (this.count == 1L)
      return 0.0D; 
    double d1 = DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas);
    double d2 = this.count;
    Double.isNaN(d2);
    return d1 / d2;
  }
  
  public final double sampleStandardDeviation() {
    return Math.sqrt(sampleVariance());
  }
  
  public final double sampleVariance() {
    boolean bool;
    if (this.count > 1L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
    if (Double.isNaN(this.sumOfSquaresOfDeltas))
      return Double.NaN; 
    double d1 = DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas);
    double d2 = (this.count - 1L);
    Double.isNaN(d2);
    return d1 / d2;
  }
  
  public Stats snapshot() {
    return new Stats(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
  }
  
  public final double sum() {
    double d1 = this.mean;
    double d2 = this.count;
    Double.isNaN(d2);
    return d1 * d2;
  }
  
  double sumOfSquaresOfDeltas() {
    return this.sumOfSquaresOfDeltas;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\math\StatsAccumulator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */