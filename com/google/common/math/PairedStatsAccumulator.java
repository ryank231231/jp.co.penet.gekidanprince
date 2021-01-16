package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;

@Beta
@GwtIncompatible
public final class PairedStatsAccumulator {
  private double sumOfProductsOfDeltas = 0.0D;
  
  private final StatsAccumulator xStats = new StatsAccumulator();
  
  private final StatsAccumulator yStats = new StatsAccumulator();
  
  private static double ensureInUnitRange(double paramDouble) {
    return (paramDouble >= 1.0D) ? 1.0D : ((paramDouble <= -1.0D) ? -1.0D : paramDouble);
  }
  
  private double ensurePositive(double paramDouble) {
    return (paramDouble > 0.0D) ? paramDouble : Double.MIN_VALUE;
  }
  
  public void add(double paramDouble1, double paramDouble2) {
    this.xStats.add(paramDouble1);
    if (Doubles.isFinite(paramDouble1) && Doubles.isFinite(paramDouble2)) {
      if (this.xStats.count() > 1L)
        this.sumOfProductsOfDeltas += (paramDouble1 - this.xStats.mean()) * (paramDouble2 - this.yStats.mean()); 
    } else {
      this.sumOfProductsOfDeltas = Double.NaN;
    } 
    this.yStats.add(paramDouble2);
  }
  
  public void addAll(PairedStats paramPairedStats) {
    if (paramPairedStats.count() == 0L)
      return; 
    this.xStats.addAll(paramPairedStats.xStats());
    if (this.yStats.count() == 0L) {
      this.sumOfProductsOfDeltas = paramPairedStats.sumOfProductsOfDeltas();
    } else {
      double d1 = this.sumOfProductsOfDeltas;
      double d2 = paramPairedStats.sumOfProductsOfDeltas();
      double d3 = paramPairedStats.xStats().mean();
      double d4 = this.xStats.mean();
      double d5 = paramPairedStats.yStats().mean();
      double d6 = this.yStats.mean();
      double d7 = paramPairedStats.count();
      Double.isNaN(d7);
      this.sumOfProductsOfDeltas = d1 + d2 + (d3 - d4) * (d5 - d6) * d7;
    } 
    this.yStats.addAll(paramPairedStats.yStats());
  }
  
  public long count() {
    return this.xStats.count();
  }
  
  public final LinearTransformation leastSquaresFit() {
    boolean bool2;
    long l = count();
    boolean bool1 = true;
    if (l > 1L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2);
    if (Double.isNaN(this.sumOfProductsOfDeltas))
      return LinearTransformation.forNaN(); 
    double d = this.xStats.sumOfSquaresOfDeltas();
    if (d > 0.0D)
      return (this.yStats.sumOfSquaresOfDeltas() > 0.0D) ? LinearTransformation.mapping(this.xStats.mean(), this.yStats.mean()).withSlope(this.sumOfProductsOfDeltas / d) : LinearTransformation.horizontal(this.yStats.mean()); 
    if (this.yStats.sumOfSquaresOfDeltas() > 0.0D) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2);
    return LinearTransformation.vertical(this.xStats.mean());
  }
  
  public final double pearsonsCorrelationCoefficient() {
    boolean bool2;
    long l = count();
    boolean bool1 = true;
    if (l > 1L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2);
    if (Double.isNaN(this.sumOfProductsOfDeltas))
      return Double.NaN; 
    double d1 = this.xStats.sumOfSquaresOfDeltas();
    double d2 = this.yStats.sumOfSquaresOfDeltas();
    if (d1 > 0.0D) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2);
    if (d2 > 0.0D) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2);
    d1 = ensurePositive(d1 * d2);
    return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(d1));
  }
  
  public double populationCovariance() {
    boolean bool;
    if (count() != 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
    double d1 = this.sumOfProductsOfDeltas;
    double d2 = count();
    Double.isNaN(d2);
    return d1 / d2;
  }
  
  public final double sampleCovariance() {
    boolean bool;
    if (count() > 1L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
    double d1 = this.sumOfProductsOfDeltas;
    double d2 = (count() - 1L);
    Double.isNaN(d2);
    return d1 / d2;
  }
  
  public PairedStats snapshot() {
    return new PairedStats(this.xStats.snapshot(), this.yStats.snapshot(), this.sumOfProductsOfDeltas);
  }
  
  public Stats xStats() {
    return this.xStats.snapshot();
  }
  
  public Stats yStats() {
    return this.yStats.snapshot();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\math\PairedStatsAccumulator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */