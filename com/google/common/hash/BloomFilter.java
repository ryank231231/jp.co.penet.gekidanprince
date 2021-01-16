package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.annotation.Nullable;

@Beta
public final class BloomFilter<T> implements Predicate<T>, Serializable {
  private final BloomFilterStrategies.BitArray bits;
  
  private final Funnel<? super T> funnel;
  
  private final int numHashFunctions;
  
  private final Strategy strategy;
  
  private BloomFilter(BloomFilterStrategies.BitArray paramBitArray, int paramInt, Funnel<? super T> paramFunnel, Strategy paramStrategy) {
    boolean bool2;
    boolean bool1 = true;
    if (paramInt > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "numHashFunctions (%s) must be > 0", paramInt);
    if (paramInt <= 255) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "numHashFunctions (%s) must be <= 255", paramInt);
    this.bits = (BloomFilterStrategies.BitArray)Preconditions.checkNotNull(paramBitArray);
    this.numHashFunctions = paramInt;
    this.funnel = (Funnel<? super T>)Preconditions.checkNotNull(paramFunnel);
    this.strategy = (Strategy)Preconditions.checkNotNull(paramStrategy);
  }
  
  public static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, int paramInt) {
    return create(paramFunnel, paramInt);
  }
  
  public static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, int paramInt, double paramDouble) {
    return create(paramFunnel, paramInt, paramDouble);
  }
  
  public static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, long paramLong) {
    return create(paramFunnel, paramLong, 0.03D);
  }
  
  public static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, long paramLong, double paramDouble) {
    return create(paramFunnel, paramLong, paramDouble, BloomFilterStrategies.MURMUR128_MITZ_64);
  }
  
  @VisibleForTesting
  static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, long paramLong, double paramDouble, Strategy paramStrategy) {
    boolean bool2;
    Preconditions.checkNotNull(paramFunnel);
    boolean bool1 = true;
    if (paramLong >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "Expected insertions (%s) must be >= 0", paramLong);
    if (paramDouble > 0.0D) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "False positive probability (%s) must be > 0.0", Double.valueOf(paramDouble));
    if (paramDouble < 1.0D) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "False positive probability (%s) must be < 1.0", Double.valueOf(paramDouble));
    Preconditions.checkNotNull(paramStrategy);
    long l = paramLong;
    if (paramLong == 0L)
      l = 1L; 
    paramLong = optimalNumOfBits(l, paramDouble);
    int i = optimalNumOfHashFunctions(l, paramLong);
    try {
      BloomFilterStrategies.BitArray bitArray = new BloomFilterStrategies.BitArray();
      this(paramLong);
      return new BloomFilter<T>(bitArray, i, paramFunnel, paramStrategy);
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not create BloomFilter of ");
      stringBuilder.append(paramLong);
      stringBuilder.append(" bits");
      throw new IllegalArgumentException(stringBuilder.toString(), illegalArgumentException);
    } 
  }
  
  @VisibleForTesting
  static long optimalNumOfBits(long paramLong, double paramDouble) {
    double d = paramDouble;
    if (paramDouble == 0.0D)
      d = Double.MIN_VALUE; 
    paramDouble = -paramLong;
    d = Math.log(d);
    Double.isNaN(paramDouble);
    return (long)(paramDouble * d / Math.log(2.0D) * Math.log(2.0D));
  }
  
  @VisibleForTesting
  static int optimalNumOfHashFunctions(long paramLong1, long paramLong2) {
    double d1 = paramLong2;
    double d2 = paramLong1;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return Math.max(1, (int)Math.round(d1 / d2 * Math.log(2.0D)));
  }
  
  public static <T> BloomFilter<T> readFrom(InputStream paramInputStream, Funnel<T> paramFunnel) throws IOException {
    Preconditions.checkNotNull(paramInputStream, "InputStream");
    Preconditions.checkNotNull(paramFunnel, "Funnel");
    int i = -1;
    try {
      DataInputStream dataInputStream = new DataInputStream();
      this(paramInputStream);
      byte b = dataInputStream.readByte();
      try {
        int j = UnsignedBytes.toInt(dataInputStream.readByte());
        b3 = i;
        try {
          int k = dataInputStream.readInt();
          b3 = k;
          BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[b];
          b3 = k;
          long[] arrayOfLong = new long[k];
          i = 0;
          while (true) {
            b3 = k;
            if (i < arrayOfLong.length) {
              b3 = k;
              arrayOfLong[i] = dataInputStream.readLong();
              i++;
              continue;
            } 
            b3 = k;
            BloomFilterStrategies.BitArray bitArray = new BloomFilterStrategies.BitArray();
            b3 = k;
            this(arrayOfLong);
            b3 = k;
            return new BloomFilter<T>(bitArray, j, paramFunnel, bloomFilterStrategies);
          } 
        } catch (RuntimeException runtimeException) {
          i = b3;
          b3 = j;
        } 
      } catch (RuntimeException runtimeException) {
        b3 = b;
      } 
    } catch (RuntimeException runtimeException) {
      b3 = -1;
    } 
    byte b2 = -1;
    byte b1 = b3;
    byte b3 = b2;
  }
  
  private Object writeReplace() {
    return new SerialForm(this);
  }
  
  @Deprecated
  public boolean apply(T paramT) {
    return mightContain(paramT);
  }
  
  @VisibleForTesting
  long bitSize() {
    return this.bits.bitSize();
  }
  
  public BloomFilter<T> copy() {
    return new BloomFilter(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof BloomFilter) {
      paramObject = paramObject;
      if (this.numHashFunctions != ((BloomFilter)paramObject).numHashFunctions || !this.funnel.equals(((BloomFilter)paramObject).funnel) || !this.bits.equals(((BloomFilter)paramObject).bits) || !this.strategy.equals(((BloomFilter)paramObject).strategy))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public double expectedFpp() {
    double d1 = this.bits.bitCount();
    double d2 = bitSize();
    Double.isNaN(d1);
    Double.isNaN(d2);
    return Math.pow(d1 / d2, this.numHashFunctions);
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits });
  }
  
  public boolean isCompatible(BloomFilter<T> paramBloomFilter) {
    boolean bool;
    Preconditions.checkNotNull(paramBloomFilter);
    if (this != paramBloomFilter && this.numHashFunctions == paramBloomFilter.numHashFunctions && bitSize() == paramBloomFilter.bitSize() && this.strategy.equals(paramBloomFilter.strategy) && this.funnel.equals(paramBloomFilter.funnel)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean mightContain(T paramT) {
    return this.strategy.mightContain(paramT, this.funnel, this.numHashFunctions, this.bits);
  }
  
  @CanIgnoreReturnValue
  public boolean put(T paramT) {
    return this.strategy.put(paramT, this.funnel, this.numHashFunctions, this.bits);
  }
  
  public void putAll(BloomFilter<T> paramBloomFilter) {
    boolean bool;
    Preconditions.checkNotNull(paramBloomFilter);
    if (this != paramBloomFilter) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Cannot combine a BloomFilter with itself.");
    if (this.numHashFunctions == paramBloomFilter.numHashFunctions) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "BloomFilters must have the same number of hash functions (%s != %s)", this.numHashFunctions, paramBloomFilter.numHashFunctions);
    if (bitSize() == paramBloomFilter.bitSize()) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), paramBloomFilter.bitSize());
    Preconditions.checkArgument(this.strategy.equals(paramBloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, paramBloomFilter.strategy);
    Preconditions.checkArgument(this.funnel.equals(paramBloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, paramBloomFilter.funnel);
    this.bits.putAll(paramBloomFilter.bits);
  }
  
  public void writeTo(OutputStream paramOutputStream) throws IOException {
    paramOutputStream = new DataOutputStream(paramOutputStream);
    paramOutputStream.writeByte(SignedBytes.checkedCast(this.strategy.ordinal()));
    paramOutputStream.writeByte(UnsignedBytes.checkedCast(this.numHashFunctions));
    paramOutputStream.writeInt(this.bits.data.length);
    long[] arrayOfLong = this.bits.data;
    int i = arrayOfLong.length;
    for (byte b = 0; b < i; b++)
      paramOutputStream.writeLong(arrayOfLong[b]); 
  }
  
  private static class SerialForm<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    final long[] data;
    
    final Funnel<? super T> funnel;
    
    final int numHashFunctions;
    
    final BloomFilter.Strategy strategy;
    
    SerialForm(BloomFilter<T> param1BloomFilter) {
      this.data = param1BloomFilter.bits.data;
      this.numHashFunctions = param1BloomFilter.numHashFunctions;
      this.funnel = param1BloomFilter.funnel;
      this.strategy = param1BloomFilter.strategy;
    }
    
    Object readResolve() {
      return new BloomFilter(new BloomFilterStrategies.BitArray(this.data), this.numHashFunctions, this.funnel, this.strategy);
    }
  }
  
  static interface Strategy extends Serializable {
    <T> boolean mightContain(T param1T, Funnel<? super T> param1Funnel, int param1Int, BloomFilterStrategies.BitArray param1BitArray);
    
    int ordinal();
    
    <T> boolean put(T param1T, Funnel<? super T> param1Funnel, int param1Int, BloomFilterStrategies.BitArray param1BitArray);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\BloomFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */