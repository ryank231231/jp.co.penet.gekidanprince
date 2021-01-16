package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public final class PairedStats implements Serializable {
  private static final int BYTES = 88;
  
  private static final long serialVersionUID = 0L;
  
  private final double sumOfProductsOfDeltas;
  
  private final Stats xStats;
  
  private final Stats yStats;
  
  PairedStats(Stats paramStats1, Stats paramStats2, double paramDouble) {
    this.xStats = paramStats1;
    this.yStats = paramStats2;
    this.sumOfProductsOfDeltas = paramDouble;
  }
  
  private static double ensureInUnitRange(double paramDouble) {
    return (paramDouble >= 1.0D) ? 1.0D : ((paramDouble <= -1.0D) ? -1.0D : paramDouble);
  }
  
  private static double ensurePositive(double paramDouble) {
    return (paramDouble > 0.0D) ? paramDouble : Double.MIN_VALUE;
  }
  
  public static PairedStats fromByteArray(byte[] paramArrayOfbyte) {
    boolean bool;
    Preconditions.checkNotNull(paramArrayOfbyte);
    if (paramArrayOfbyte.length == 88) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Expected PairedStats.BYTES = %s, got %s", 88, paramArrayOfbyte.length);
    ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte).order(ByteOrder.LITTLE_ENDIAN);
    return new PairedStats(Stats.readFrom(byteBuffer), Stats.readFrom(byteBuffer), byteBuffer.getDouble());
  }
  
  public long count() {
    return this.xStats.count();
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool1 = false;
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    boolean bool2 = bool1;
    if (this.xStats.equals(((PairedStats)paramObject).xStats)) {
      bool2 = bool1;
      if (this.yStats.equals(((PairedStats)paramObject).yStats)) {
        bool2 = bool1;
        if (Double.doubleToLongBits(this.sumOfProductsOfDeltas) == Double.doubleToLongBits(((PairedStats)paramObject).sumOfProductsOfDeltas))
          bool2 = true; 
      } 
    } 
    return bool2;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas) });
  }
  
  public LinearTransformation leastSquaresFit() {
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
  
  public double pearsonsCorrelationCoefficient() {
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
    double d1 = xStats().sumOfSquaresOfDeltas();
    double d2 = yStats().sumOfSquaresOfDeltas();
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
  
  public double sampleCovariance() {
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
  
  double sumOfProductsOfDeltas() {
    return this.sumOfProductsOfDeltas;
  }
  
  public byte[] toByteArray() {
    ByteBuffer byteBuffer = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
    this.xStats.writeTo(byteBuffer);
    this.yStats.writeTo(byteBuffer);
    byteBuffer.putDouble(this.sumOfProductsOfDeltas);
    return byteBuffer.array();
  }
  
  public String toString() {
    return (count() > 0L) ? MoreObjects.toStringHelper(this).add("xStats", this.xStats).add("yStats", this.yStats).add("populationCovariance", populationCovariance()).toString() : MoreObjects.toStringHelper(this).add("xStats", this.xStats).add("yStats", this.yStats).toString();
  }
  
  public Stats xStats() {
    return this.xStats;
  }
  
  public Stats yStats() {
    return this.yStats;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\math\PairedStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */