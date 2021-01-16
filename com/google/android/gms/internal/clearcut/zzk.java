package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class zzk {
  private static int zza(byte[] paramArrayOfbyte, int paramInt) {
    byte b1 = paramArrayOfbyte[paramInt];
    byte b2 = paramArrayOfbyte[paramInt + 1];
    byte b3 = paramArrayOfbyte[paramInt + 2];
    return (paramArrayOfbyte[paramInt + 3] & 0xFF) << 24 | b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16;
  }
  
  private static long zza(long paramLong1, long paramLong2, long paramLong3) {
    paramLong1 = (paramLong1 ^ paramLong2) * paramLong3;
    paramLong1 = (paramLong1 ^ paramLong1 >>> 47L ^ paramLong2) * paramLong3;
    return (paramLong1 ^ paramLong1 >>> 47L) * paramLong3;
  }
  
  public static long zza(byte[] paramArrayOfbyte) {
    int i = paramArrayOfbyte.length;
    if (i >= 0 && i <= paramArrayOfbyte.length) {
      if (i <= 32) {
        if (i <= 16) {
          if (i >= 8) {
            long l9 = (i << 1) - 7286425919675154353L;
            long l10 = zzb(paramArrayOfbyte, 0) - 7286425919675154353L;
            long l11 = zzb(paramArrayOfbyte, i + 0 - 8);
            return zza(Long.rotateRight(l11, 37) * l9 + l10, (Long.rotateRight(l10, 25) + l11) * l9, l9);
          } 
          if (i >= 4) {
            long l = (i << 1);
            return zza(((zza(paramArrayOfbyte, 0) & 0xFFFFFFFFL) << 3L) + i, zza(paramArrayOfbyte, i + 0 - 4) & 0xFFFFFFFFL, l - 7286425919675154353L);
          } 
          if (i > 0) {
            byte b1 = paramArrayOfbyte[0];
            byte b2 = paramArrayOfbyte[(i >> 1) + 0];
            byte b3 = paramArrayOfbyte[i - 1 + 0];
            long l = ((b1 & 0xFF) + ((b2 & 0xFF) << 8)) * -7286425919675154353L ^ (i + ((b3 & 0xFF) << 2)) * -4348849565147123417L;
            return (l ^ l >>> 47L) * -7286425919675154353L;
          } 
          return -7286425919675154353L;
        } 
        long l7 = (i << 1) - 7286425919675154353L;
        long l6 = zzb(paramArrayOfbyte, 0) * -5435081209227447693L;
        long l5 = zzb(paramArrayOfbyte, 8);
        int m = i + 0;
        long l4 = zzb(paramArrayOfbyte, m - 8) * l7;
        long l8 = zzb(paramArrayOfbyte, m - 16);
        return zza(Long.rotateRight(l6 + l5, 43) + Long.rotateRight(l4, 30) + l8 * -7286425919675154353L, l6 + Long.rotateRight(l5 - 7286425919675154353L, 18) + l4, l7);
      } 
      if (i <= 64) {
        long l4 = (i << 1) - 7286425919675154353L;
        long l5 = zzb(paramArrayOfbyte, 0) * -7286425919675154353L;
        long l8 = zzb(paramArrayOfbyte, 8);
        int m = i + 0;
        long l7 = zzb(paramArrayOfbyte, m - 8) * l4;
        long l6 = zzb(paramArrayOfbyte, m - 16);
        l6 = Long.rotateRight(l5 + l8, 43) + Long.rotateRight(l7, 30) + l6 * -7286425919675154353L;
        l8 = zza(l6, Long.rotateRight(-7286425919675154353L + l8, 18) + l5 + l7, l4);
        l7 = zzb(paramArrayOfbyte, 16) * l4;
        long l9 = zzb(paramArrayOfbyte, 24);
        l6 = (l6 + zzb(paramArrayOfbyte, m - 32)) * l4;
        return zza((l8 + zzb(paramArrayOfbyte, m - 24)) * l4 + Long.rotateRight(l7 + l9, 43) + Long.rotateRight(l6, 30), l7 + Long.rotateRight(l9 + l5, 18) + l6, l4);
      } 
      long l2 = 2480279821605975764L;
      long l1 = 1390051526045402406L;
      long[] arrayOfLong1 = new long[2];
      long[] arrayOfLong2 = new long[2];
      long l3 = zzb(paramArrayOfbyte, 0) + 95310865018149119L;
      int j = i - 1;
      i = (j / 64 << 6) + 0;
      j &= 0x3F;
      int k = i + j - 63;
      byte b = 0;
      while (true) {
        long l = Long.rotateRight(l3 + l2 + arrayOfLong1[0] + zzb(paramArrayOfbyte, b + 8), 37);
        l3 = Long.rotateRight(l2 + arrayOfLong1[1] + zzb(paramArrayOfbyte, b + 48), 42);
        l2 = l * -5435081209227447693L ^ arrayOfLong2[1];
        l3 = l3 * -5435081209227447693L + arrayOfLong1[0] + zzb(paramArrayOfbyte, b + 40);
        l = Long.rotateRight(l1 + arrayOfLong2[0], 33) * -5435081209227447693L;
        zza(paramArrayOfbyte, b, arrayOfLong1[1] * -5435081209227447693L, l2 + arrayOfLong2[0], arrayOfLong1);
        zza(paramArrayOfbyte, b + 32, l + arrayOfLong2[1], l3 + zzb(paramArrayOfbyte, b + 16), arrayOfLong2);
        b += 64;
        if (b == i) {
          l1 = -5435081209227447693L + ((0xFFL & l2) << 1L);
          arrayOfLong2[0] = arrayOfLong2[0] + j;
          arrayOfLong1[0] = arrayOfLong1[0] + arrayOfLong2[0];
          arrayOfLong2[0] = arrayOfLong2[0] + arrayOfLong1[0];
          long l4 = Long.rotateRight(l + l3 + arrayOfLong1[0] + zzb(paramArrayOfbyte, k + 8), 37);
          l = Long.rotateRight(l3 + arrayOfLong1[1] + zzb(paramArrayOfbyte, k + 48), 42);
          l3 = l4 * l1 ^ arrayOfLong2[1] * 9L;
          l = l * l1 + arrayOfLong1[0] * 9L + zzb(paramArrayOfbyte, k + 40);
          l2 = Long.rotateRight(l2 + arrayOfLong2[0], 33) * l1;
          zza(paramArrayOfbyte, k, arrayOfLong1[1] * l1, l3 + arrayOfLong2[0], arrayOfLong1);
          zza(paramArrayOfbyte, k + 32, arrayOfLong2[1] + l2, l + zzb(paramArrayOfbyte, k + 16), arrayOfLong2);
          return zza(zza(arrayOfLong1[0], arrayOfLong2[0], l1) + (l ^ l >>> 47L) * -4348849565147123417L + l3, zza(arrayOfLong1[1], arrayOfLong2[1], l1) + l2, l1);
        } 
        l1 = l2;
        l2 = l3;
        l3 = l;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder(67);
    stringBuilder.append("Out of bound index with offput: 0 and length: ");
    stringBuilder.append(i);
    throw new IndexOutOfBoundsException(stringBuilder.toString());
  }
  
  private static void zza(byte[] paramArrayOfbyte, int paramInt, long paramLong1, long paramLong2, long[] paramArrayOflong) {
    long l1 = zzb(paramArrayOfbyte, paramInt);
    long l2 = zzb(paramArrayOfbyte, paramInt + 8);
    long l3 = zzb(paramArrayOfbyte, paramInt + 16);
    long l4 = zzb(paramArrayOfbyte, paramInt + 24);
    paramLong1 += l1;
    paramLong2 = Long.rotateRight(paramLong2 + paramLong1 + l4, 21);
    l3 = l2 + paramLong1 + l3;
    l2 = Long.rotateRight(l3, 44);
    paramArrayOflong[0] = l3 + l4;
    paramArrayOflong[1] = paramLong2 + l2 + paramLong1;
  }
  
  private static long zzb(byte[] paramArrayOfbyte, int paramInt) {
    ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte, paramInt, 8);
    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    return byteBuffer.getLong();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */