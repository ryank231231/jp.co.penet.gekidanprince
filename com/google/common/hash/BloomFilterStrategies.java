package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.Nullable;

enum BloomFilterStrategies implements BloomFilter.Strategy {
  MURMUR128_MITZ_32 {
    public <T> boolean mightContain(T param1T, Funnel<? super T> param1Funnel, int param1Int, BitArray param1BitArray) {
      long l1 = param1BitArray.bitSize();
      long l2 = Hashing.murmur3_128().<T>hashObject(param1T, param1Funnel).asLong();
      int i = (int)l2;
      int j = (int)(l2 >>> 32L);
      for (byte b = 1; b <= param1Int; b++) {
        int k = b * j + i;
        int m = k;
        if (k < 0)
          m = k ^ 0xFFFFFFFF; 
        if (!param1BitArray.get(m % l1))
          return false; 
      } 
      return true;
    }
    
    public <T> boolean put(T param1T, Funnel<? super T> param1Funnel, int param1Int, BitArray param1BitArray) {
      long l1 = param1BitArray.bitSize();
      long l2 = Hashing.murmur3_128().<T>hashObject(param1T, param1Funnel).asLong();
      int i = (int)l2;
      int j = (int)(l2 >>> 32L);
      byte b = 1;
      boolean bool = false;
      while (b <= param1Int) {
        int k = b * j + i;
        int m = k;
        if (k < 0)
          m = k ^ 0xFFFFFFFF; 
        bool |= param1BitArray.set(m % l1);
        b++;
      } 
      return bool;
    }
  },
  MURMUR128_MITZ_64 {
    private long lowerEight(byte[] param1ArrayOfbyte) {
      return Longs.fromBytes(param1ArrayOfbyte[7], param1ArrayOfbyte[6], param1ArrayOfbyte[5], param1ArrayOfbyte[4], param1ArrayOfbyte[3], param1ArrayOfbyte[2], param1ArrayOfbyte[1], param1ArrayOfbyte[0]);
    }
    
    private long upperEight(byte[] param1ArrayOfbyte) {
      return Longs.fromBytes(param1ArrayOfbyte[15], param1ArrayOfbyte[14], param1ArrayOfbyte[13], param1ArrayOfbyte[12], param1ArrayOfbyte[11], param1ArrayOfbyte[10], param1ArrayOfbyte[9], param1ArrayOfbyte[8]);
    }
    
    public <T> boolean mightContain(T param1T, Funnel<? super T> param1Funnel, int param1Int, BitArray param1BitArray) {
      long l1 = param1BitArray.bitSize();
      byte[] arrayOfByte = Hashing.murmur3_128().<T>hashObject(param1T, param1Funnel).getBytesInternal();
      long l2 = lowerEight(arrayOfByte);
      long l3 = upperEight(arrayOfByte);
      for (byte b = 0; b < param1Int; b++) {
        if (!param1BitArray.get((Long.MAX_VALUE & l2) % l1))
          return false; 
        l2 += l3;
      } 
      return true;
    }
    
    public <T> boolean put(T param1T, Funnel<? super T> param1Funnel, int param1Int, BitArray param1BitArray) {
      long l1 = param1BitArray.bitSize();
      byte[] arrayOfByte = Hashing.murmur3_128().<T>hashObject(param1T, param1Funnel).getBytesInternal();
      long l2 = lowerEight(arrayOfByte);
      long l3 = upperEight(arrayOfByte);
      byte b = 0;
      boolean bool = false;
      while (b < param1Int) {
        bool |= param1BitArray.set((Long.MAX_VALUE & l2) % l1);
        l2 += l3;
        b++;
      } 
      return bool;
    }
  };
  
  static {
    $VALUES = new BloomFilterStrategies[] { MURMUR128_MITZ_32, MURMUR128_MITZ_64 };
  }
  
  static final class BitArray {
    long bitCount;
    
    final long[] data;
    
    BitArray(long param1Long) {
      this(new long[Ints.checkedCast(LongMath.divide(param1Long, 64L, RoundingMode.CEILING))]);
    }
    
    BitArray(long[] param1ArrayOflong) {
      boolean bool;
      int i = param1ArrayOflong.length;
      byte b = 0;
      if (i > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "data length is zero!");
      this.data = param1ArrayOflong;
      long l = 0L;
      i = param1ArrayOflong.length;
      while (b < i) {
        l += Long.bitCount(param1ArrayOflong[b]);
        b++;
      } 
      this.bitCount = l;
    }
    
    long bitCount() {
      return this.bitCount;
    }
    
    long bitSize() {
      return this.data.length * 64L;
    }
    
    BitArray copy() {
      return new BitArray((long[])this.data.clone());
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof BitArray) {
        param1Object = param1Object;
        return Arrays.equals(this.data, ((BitArray)param1Object).data);
      } 
      return false;
    }
    
    boolean get(long param1Long) {
      boolean bool;
      long l = this.data[(int)(param1Long >>> 6L)];
      if ((1L << (int)param1Long & l) != 0L) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int hashCode() {
      return Arrays.hashCode(this.data);
    }
    
    void putAll(BitArray param1BitArray) {
      boolean bool;
      int i = this.data.length;
      int j = param1BitArray.data.length;
      byte b = 0;
      if (i == j) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "BitArrays must be of equal length (%s != %s)", this.data.length, param1BitArray.data.length);
      this.bitCount = 0L;
      while (true) {
        long[] arrayOfLong = this.data;
        if (b < arrayOfLong.length) {
          arrayOfLong[b] = arrayOfLong[b] | param1BitArray.data[b];
          this.bitCount += Long.bitCount(arrayOfLong[b]);
          b++;
          continue;
        } 
        break;
      } 
    }
    
    boolean set(long param1Long) {
      if (!get(param1Long)) {
        long[] arrayOfLong = this.data;
        int i = (int)(param1Long >>> 6L);
        long l = arrayOfLong[i];
        arrayOfLong[i] = 1L << (int)param1Long | l;
        this.bitCount++;
        return true;
      } 
      return false;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\BloomFilterStrategies.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */