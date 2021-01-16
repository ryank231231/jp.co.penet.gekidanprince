package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
  private static final long K0 = -4348849565147123417L;
  
  private static final long K1 = -5435081209227447693L;
  
  private static final long K2 = -7286425919675154353L;
  
  @VisibleForTesting
  static long fingerprint(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return (paramInt2 <= 32) ? ((paramInt2 <= 16) ? hashLength0to16(paramArrayOfbyte, paramInt1, paramInt2) : hashLength17to32(paramArrayOfbyte, paramInt1, paramInt2)) : ((paramInt2 <= 64) ? hashLength33To64(paramArrayOfbyte, paramInt1, paramInt2) : hashLength65Plus(paramArrayOfbyte, paramInt1, paramInt2));
  }
  
  private static long hashLength0to16(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramInt2 >= 8) {
      long l1 = (paramInt2 * 2) - 7286425919675154353L;
      long l2 = LittleEndianByteArray.load64(paramArrayOfbyte, paramInt1) - 7286425919675154353L;
      long l3 = LittleEndianByteArray.load64(paramArrayOfbyte, paramInt1 + paramInt2 - 8);
      return hashLength16(Long.rotateRight(l3, 37) * l1 + l2, (Long.rotateRight(l2, 25) + l3) * l1, l1);
    } 
    if (paramInt2 >= 4) {
      long l2 = (paramInt2 * 2);
      long l1 = LittleEndianByteArray.load32(paramArrayOfbyte, paramInt1);
      return hashLength16(paramInt2 + ((l1 & 0xFFFFFFFFL) << 3L), LittleEndianByteArray.load32(paramArrayOfbyte, paramInt1 + paramInt2 - 4) & 0xFFFFFFFFL, l2 - 7286425919675154353L);
    } 
    if (paramInt2 > 0) {
      byte b1 = paramArrayOfbyte[paramInt1];
      byte b2 = paramArrayOfbyte[(paramInt2 >> 1) + paramInt1];
      paramInt1 = paramArrayOfbyte[paramInt1 + paramInt2 - 1];
      return shiftMix(((b1 & 0xFF) + ((b2 & 0xFF) << 8)) * -7286425919675154353L ^ (paramInt2 + ((paramInt1 & 0xFF) << 2)) * -4348849565147123417L) * -7286425919675154353L;
    } 
    return -7286425919675154353L;
  }
  
  private static long hashLength16(long paramLong1, long paramLong2, long paramLong3) {
    paramLong1 = (paramLong1 ^ paramLong2) * paramLong3;
    paramLong1 = (paramLong1 ^ paramLong1 >>> 47L ^ paramLong2) * paramLong3;
    return (paramLong1 ^ paramLong1 >>> 47L) * paramLong3;
  }
  
  private static long hashLength17to32(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    long l1 = (paramInt2 * 2) - 7286425919675154353L;
    long l2 = LittleEndianByteArray.load64(paramArrayOfbyte, paramInt1) * -5435081209227447693L;
    long l3 = LittleEndianByteArray.load64(paramArrayOfbyte, paramInt1 + 8);
    paramInt1 += paramInt2;
    long l4 = LittleEndianByteArray.load64(paramArrayOfbyte, paramInt1 - 8) * l1;
    return hashLength16(LittleEndianByteArray.load64(paramArrayOfbyte, paramInt1 - 16) * -7286425919675154353L + Long.rotateRight(l2 + l3, 43) + Long.rotateRight(l4, 30), l2 + Long.rotateRight(l3 - 7286425919675154353L, 18) + l4, l1);
  }
  
  private static long hashLength33To64(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    long l1 = (paramInt2 * 2) - 7286425919675154353L;
    long l2 = LittleEndianByteArray.load64(paramArrayOfbyte, paramInt1) * -7286425919675154353L;
    long l3 = LittleEndianByteArray.load64(paramArrayOfbyte, paramInt1 + 8);
    paramInt2 = paramInt1 + paramInt2;
    long l4 = LittleEndianByteArray.load64(paramArrayOfbyte, paramInt2 - 8) * l1;
    long l5 = LittleEndianByteArray.load64(paramArrayOfbyte, paramInt2 - 16);
    l5 = Long.rotateRight(l2 + l3, 43) + Long.rotateRight(l4, 30) + l5 * -7286425919675154353L;
    l4 = hashLength16(l5, l4 + Long.rotateRight(l3 - 7286425919675154353L, 18) + l2, l1);
    l3 = LittleEndianByteArray.load64(paramArrayOfbyte, paramInt1 + 16) * l1;
    long l6 = LittleEndianByteArray.load64(paramArrayOfbyte, paramInt1 + 24);
    l5 = (l5 + LittleEndianByteArray.load64(paramArrayOfbyte, paramInt2 - 32)) * l1;
    return hashLength16((l4 + LittleEndianByteArray.load64(paramArrayOfbyte, paramInt2 - 24)) * l1 + Long.rotateRight(l3 + l6, 43) + Long.rotateRight(l5, 30), l3 + Long.rotateRight(l6 + l2, 18) + l5, l1);
  }
  
  private static long hashLength65Plus(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    long l1 = shiftMix(-7956866745689871395L) * -7286425919675154353L;
    long[] arrayOfLong1 = new long[2];
    long[] arrayOfLong2 = new long[2];
    long l2 = 95310865018149119L + LittleEndianByteArray.load64(paramArrayOfbyte, paramInt1);
    int i = paramInt2 - 1;
    paramInt2 = paramInt1 + i / 64 * 64;
    i &= 0x3F;
    int j = paramInt2 + i - 63;
    long l3 = 2480279821605975764L;
    while (true) {
      long l = Long.rotateRight(l2 + l3 + arrayOfLong1[0] + LittleEndianByteArray.load64(paramArrayOfbyte, paramInt1 + 8), 37);
      l2 = Long.rotateRight(l3 + arrayOfLong1[1] + LittleEndianByteArray.load64(paramArrayOfbyte, paramInt1 + 48), 42);
      l3 = l * -5435081209227447693L ^ arrayOfLong2[1];
      l2 = l2 * -5435081209227447693L + arrayOfLong1[0] + LittleEndianByteArray.load64(paramArrayOfbyte, paramInt1 + 40);
      l = Long.rotateRight(l1 + arrayOfLong2[0], 33) * -5435081209227447693L;
      weakHashLength32WithSeeds(paramArrayOfbyte, paramInt1, arrayOfLong1[1] * -5435081209227447693L, l3 + arrayOfLong2[0], arrayOfLong1);
      weakHashLength32WithSeeds(paramArrayOfbyte, paramInt1 + 32, l + arrayOfLong2[1], l2 + LittleEndianByteArray.load64(paramArrayOfbyte, paramInt1 + 16), arrayOfLong2);
      paramInt1 += 64;
      if (paramInt1 == paramInt2) {
        l1 = ((l3 & 0xFFL) << 1L) - 5435081209227447693L;
        arrayOfLong2[0] = arrayOfLong2[0] + i;
        arrayOfLong1[0] = arrayOfLong1[0] + arrayOfLong2[0];
        arrayOfLong2[0] = arrayOfLong2[0] + arrayOfLong1[0];
        l = Long.rotateRight(l + l2 + arrayOfLong1[0] + LittleEndianByteArray.load64(paramArrayOfbyte, j + 8), 37);
        long l4 = Long.rotateRight(l2 + arrayOfLong1[1] + LittleEndianByteArray.load64(paramArrayOfbyte, j + 48), 42);
        l2 = l * l1 ^ arrayOfLong2[1] * 9L;
        l = l4 * l1 + arrayOfLong1[0] * 9L + LittleEndianByteArray.load64(paramArrayOfbyte, j + 40);
        l3 = Long.rotateRight(l3 + arrayOfLong2[0], 33) * l1;
        weakHashLength32WithSeeds(paramArrayOfbyte, j, arrayOfLong1[1] * l1, l2 + arrayOfLong2[0], arrayOfLong1);
        weakHashLength32WithSeeds(paramArrayOfbyte, j + 32, l3 + arrayOfLong2[1], LittleEndianByteArray.load64(paramArrayOfbyte, j + 16) + l, arrayOfLong2);
        return hashLength16(hashLength16(arrayOfLong1[0], arrayOfLong2[0], l1) + shiftMix(l) * -4348849565147123417L + l2, hashLength16(arrayOfLong1[1], arrayOfLong2[1], l1) + l3, l1);
      } 
      l1 = l3;
      l3 = l2;
      l2 = l;
    } 
  }
  
  private static long shiftMix(long paramLong) {
    return paramLong ^ paramLong >>> 47L;
  }
  
  private static void weakHashLength32WithSeeds(byte[] paramArrayOfbyte, int paramInt, long paramLong1, long paramLong2, long[] paramArrayOflong) {
    long l1 = LittleEndianByteArray.load64(paramArrayOfbyte, paramInt);
    long l2 = LittleEndianByteArray.load64(paramArrayOfbyte, paramInt + 8);
    long l3 = LittleEndianByteArray.load64(paramArrayOfbyte, paramInt + 16);
    long l4 = LittleEndianByteArray.load64(paramArrayOfbyte, paramInt + 24);
    paramLong1 += l1;
    paramLong2 = Long.rotateRight(paramLong2 + paramLong1 + l4, 21);
    l3 = l2 + paramLong1 + l3;
    l2 = Long.rotateRight(l3, 44);
    paramArrayOflong[0] = l3 + l4;
    paramArrayOflong[1] = paramLong2 + l2 + paramLong1;
  }
  
  public int bits() {
    return 64;
  }
  
  public HashCode hashBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    return HashCode.fromLong(fingerprint(paramArrayOfbyte, paramInt1, paramInt2));
  }
  
  public String toString() {
    return "Hashing.farmHashFingerprint64()";
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\FarmHashFingerprint64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */