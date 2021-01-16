package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public final class Stats implements Serializable {
  static final int BYTES = 40;
  
  private static final long serialVersionUID = 0L;
  
  private final long count;
  
  private final double max;
  
  private final double mean;
  
  private final double min;
  
  private final double sumOfSquaresOfDeltas;
  
  Stats(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
    this.count = paramLong;
    this.mean = paramDouble1;
    this.sumOfSquaresOfDeltas = paramDouble2;
    this.min = paramDouble3;
    this.max = paramDouble4;
  }
  
  public static Stats fromByteArray(byte[] paramArrayOfbyte) {
    boolean bool;
    Preconditions.checkNotNull(paramArrayOfbyte);
    if (paramArrayOfbyte.length == 40) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Expected Stats.BYTES = %s remaining , got %s", 40, paramArrayOfbyte.length);
    return readFrom(ByteBuffer.wrap(paramArrayOfbyte).order(ByteOrder.LITTLE_ENDIAN));
  }
  
  public static double meanOf(Iterable<? extends Number> paramIterable) {
    return meanOf(paramIterable.iterator());
  }
  
  public static double meanOf(Iterator<? extends Number> paramIterator) {
    Preconditions.checkArgument(paramIterator.hasNext());
    double d = ((Number)paramIterator.next()).doubleValue();
    long l = 1L;
    while (paramIterator.hasNext()) {
      double d1 = ((Number)paramIterator.next()).doubleValue();
      l++;
      if (Doubles.isFinite(d1) && Doubles.isFinite(d)) {
        double d2 = l;
        Double.isNaN(d2);
        d += (d1 - d) / d2;
        continue;
      } 
      d = StatsAccumulator.calculateNewMeanNonFinite(d, d1);
    } 
    return d;
  }
  
  public static double meanOf(double... paramVarArgs) {
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
      double d1 = paramVarArgs[b];
      if (Doubles.isFinite(d1) && Doubles.isFinite(d)) {
        double d2 = (b + 1);
        Double.isNaN(d2);
        d += (d1 - d) / d2;
      } else {
        d = StatsAccumulator.calculateNewMeanNonFinite(d, d1);
      } 
      b++;
    } 
    return d;
  }
  
  public static double meanOf(int... paramVarArgs) {
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
      double d1 = paramVarArgs[b];
      if (Doubles.isFinite(d1) && Doubles.isFinite(d)) {
        Double.isNaN(d1);
        double d2 = (b + 1);
        Double.isNaN(d2);
        d += (d1 - d) / d2;
      } else {
        d = StatsAccumulator.calculateNewMeanNonFinite(d, d1);
      } 
      b++;
    } 
    return d;
  }
  
  public static double meanOf(long... paramVarArgs) {
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
      double d1 = paramVarArgs[b];
      if (Doubles.isFinite(d1) && Doubles.isFinite(d)) {
        Double.isNaN(d1);
        double d2 = (b + 1);
        Double.isNaN(d2);
        d += (d1 - d) / d2;
      } else {
        d = StatsAccumulator.calculateNewMeanNonFinite(d, d1);
      } 
      b++;
    } 
    return d;
  }
  
  public static Stats of(Iterable<? extends Number> paramIterable) {
    StatsAccumulator statsAccumulator = new StatsAccumulator();
    statsAccumulator.addAll(paramIterable);
    return statsAccumulator.snapshot();
  }
  
  public static Stats of(Iterator<? extends Number> paramIterator) {
    StatsAccumulator statsAccumulator = new StatsAccumulator();
    statsAccumulator.addAll(paramIterator);
    return statsAccumulator.snapshot();
  }
  
  public static Stats of(double... paramVarArgs) {
    StatsAccumulator statsAccumulator = new StatsAccumulator();
    statsAccumulator.addAll(paramVarArgs);
    return statsAccumulator.snapshot();
  }
  
  public static Stats of(int... paramVarArgs) {
    StatsAccumulator statsAccumulator = new StatsAccumulator();
    statsAccumulator.addAll(paramVarArgs);
    return statsAccumulator.snapshot();
  }
  
  public static Stats of(long... paramVarArgs) {
    StatsAccumulator statsAccumulator = new StatsAccumulator();
    statsAccumulator.addAll(paramVarArgs);
    return statsAccumulator.snapshot();
  }
  
  static Stats readFrom(ByteBuffer paramByteBuffer) {
    boolean bool;
    Preconditions.checkNotNull(paramByteBuffer);
    if (paramByteBuffer.remaining() >= 40) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Expected at least Stats.BYTES = %s remaining , got %s", 40, paramByteBuffer.remaining());
    return new Stats(paramByteBuffer.getLong(), paramByteBuffer.getDouble(), paramByteBuffer.getDouble(), paramByteBuffer.getDouble(), paramByteBuffer.getDouble());
  }
  
  public long count() {
    return this.count;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool1 = false;
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    boolean bool2 = bool1;
    if (this.count == ((Stats)paramObject).count) {
      bool2 = bool1;
      if (Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(((Stats)paramObject).mean)) {
        bool2 = bool1;
        if (Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(((Stats)paramObject).sumOfSquaresOfDeltas)) {
          bool2 = bool1;
          if (Double.doubleToLongBits(this.min) == Double.doubleToLongBits(((Stats)paramObject).min)) {
            bool2 = bool1;
            if (Double.doubleToLongBits(this.max) == Double.doubleToLongBits(((Stats)paramObject).max))
              bool2 = true; 
          } 
        } 
      } 
    } 
    return bool2;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max) });
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
  
  public double populationStandardDeviation() {
    return Math.sqrt(populationVariance());
  }
  
  public double populationVariance() {
    boolean bool;
    if (this.count > 0L) {
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
    double d2 = count();
    Double.isNaN(d2);
    return d1 / d2;
  }
  
  public double sampleStandardDeviation() {
    return Math.sqrt(sampleVariance());
  }
  
  public double sampleVariance() {
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
  
  public double sum() {
    double d1 = this.mean;
    double d2 = this.count;
    Double.isNaN(d2);
    return d1 * d2;
  }
  
  double sumOfSquaresOfDeltas() {
    return this.sumOfSquaresOfDeltas;
  }
  
  public byte[] toByteArray() {
    ByteBuffer byteBuffer = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
    writeTo(byteBuffer);
    return byteBuffer.array();
  }
  
  public String toString() {
    return (count() > 0L) ? MoreObjects.toStringHelper(this).add("count", this.count).add("mean", this.mean).add("populationStandardDeviation", populationStandardDeviation()).add("min", this.min).add("max", this.max).toString() : MoreObjects.toStringHelper(this).add("count", this.count).toString();
  }
  
  void writeTo(ByteBuffer paramByteBuffer) {
    boolean bool;
    Preconditions.checkNotNull(paramByteBuffer);
    if (paramByteBuffer.remaining() >= 40) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Expected at least Stats.BYTES = %s remaining , got %s", 40, paramByteBuffer.remaining());
    paramByteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\math\Stats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */