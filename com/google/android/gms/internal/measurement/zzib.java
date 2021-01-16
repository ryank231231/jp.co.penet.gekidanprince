package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;

final class zzib extends zzia {
  final int zzb(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
    while (paramInt2 < paramInt3 && paramArrayOfbyte[paramInt2] >= 0)
      paramInt2++; 
    paramInt1 = paramInt2;
    if (paramInt2 >= paramInt3)
      return 0; 
    while (true) {
      if (paramInt1 >= paramInt3)
        return 0; 
      paramInt2 = paramInt1 + 1;
      paramInt1 = paramArrayOfbyte[paramInt1];
      if (paramInt1 < 0) {
        if (paramInt1 < -32) {
          if (paramInt2 >= paramInt3)
            return paramInt1; 
          if (paramInt1 >= -62) {
            paramInt1 = paramInt2 + 1;
            if (paramArrayOfbyte[paramInt2] > -65)
              return -1; 
            continue;
          } 
          return -1;
        } 
        if (paramInt1 < -16) {
          if (paramInt2 >= paramInt3 - 1)
            return zzhy.zzi(paramArrayOfbyte, paramInt2, paramInt3); 
          int j = paramInt2 + 1;
          paramInt2 = paramArrayOfbyte[paramInt2];
          if (paramInt2 <= -65 && (paramInt1 != -32 || paramInt2 >= -96) && (paramInt1 != -19 || paramInt2 < -96)) {
            paramInt1 = j + 1;
            if (paramArrayOfbyte[j] > -65)
              return -1; 
            continue;
          } 
          return -1;
        } 
        if (paramInt2 >= paramInt3 - 2)
          return zzhy.zzi(paramArrayOfbyte, paramInt2, paramInt3); 
        int i = paramInt2 + 1;
        paramInt2 = paramArrayOfbyte[paramInt2];
        if (paramInt2 <= -65 && (paramInt1 << 28) + paramInt2 + 112 >> 30 == 0) {
          paramInt1 = i + 1;
          if (paramArrayOfbyte[i] <= -65 && paramArrayOfbyte[paramInt1] <= -65) {
            paramInt1++;
            continue;
          } 
        } 
        return -1;
      } 
      paramInt1 = paramInt2;
    } 
  }
  
  final int zzb(CharSequence paramCharSequence, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    int i = paramCharSequence.length();
    int j = paramInt2 + paramInt1;
    paramInt2 = 0;
    while (paramInt2 < i) {
      int k = paramInt2 + paramInt1;
      if (k < j) {
        char c = paramCharSequence.charAt(paramInt2);
        if (c < '') {
          paramArrayOfbyte[k] = (byte)(byte)c;
          paramInt2++;
        } 
      } 
    } 
    if (paramInt2 == i)
      return paramInt1 + i; 
    paramInt1 += paramInt2;
    while (paramInt2 < i) {
      char c = paramCharSequence.charAt(paramInt2);
      if (c < '' && paramInt1 < j) {
        paramArrayOfbyte[paramInt1] = (byte)(byte)c;
        paramInt1++;
      } else if (c < 'ࠀ' && paramInt1 <= j - 2) {
        int k = paramInt1 + 1;
        paramArrayOfbyte[paramInt1] = (byte)(byte)(c >>> 6 | 0x3C0);
        paramInt1 = k + 1;
        paramArrayOfbyte[k] = (byte)(byte)(c & 0x3F | 0x80);
      } else if ((c < '?' || '?' < c) && paramInt1 <= j - 3) {
        int k = paramInt1 + 1;
        paramArrayOfbyte[paramInt1] = (byte)(byte)(c >>> 12 | 0x1E0);
        paramInt1 = k + 1;
        paramArrayOfbyte[k] = (byte)(byte)(c >>> 6 & 0x3F | 0x80);
        paramArrayOfbyte[paramInt1] = (byte)(byte)(c & 0x3F | 0x80);
        paramInt1++;
      } else if (paramInt1 <= j - 4) {
        int k = paramInt2 + 1;
        if (k != paramCharSequence.length()) {
          char c1 = paramCharSequence.charAt(k);
          if (Character.isSurrogatePair(c, c1)) {
            paramInt2 = Character.toCodePoint(c, c1);
            int m = paramInt1 + 1;
            paramArrayOfbyte[paramInt1] = (byte)(byte)(paramInt2 >>> 18 | 0xF0);
            paramInt1 = m + 1;
            paramArrayOfbyte[m] = (byte)(byte)(paramInt2 >>> 12 & 0x3F | 0x80);
            m = paramInt1 + 1;
            paramArrayOfbyte[paramInt1] = (byte)(byte)(paramInt2 >>> 6 & 0x3F | 0x80);
            paramInt1 = m + 1;
            paramArrayOfbyte[m] = (byte)(byte)(paramInt2 & 0x3F | 0x80);
            paramInt2 = k;
          } else {
            paramInt2 = k;
            throw new zzic(paramInt2 - 1, i);
          } 
        } else {
          throw new zzic(paramInt2 - 1, i);
        } 
      } else {
        if ('?' <= c && c <= '?') {
          int k = paramInt2 + 1;
          if (k == paramCharSequence.length() || !Character.isSurrogatePair(c, paramCharSequence.charAt(k)))
            throw new zzic(paramInt2, i); 
        } 
        paramCharSequence = new StringBuilder(37);
        paramCharSequence.append("Failed writing ");
        paramCharSequence.append(c);
        paramCharSequence.append(" at index ");
        paramCharSequence.append(paramInt1);
        throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
      } 
      paramInt2++;
    } 
    return paramInt1;
  }
  
  final void zzb(CharSequence paramCharSequence, ByteBuffer paramByteBuffer) {
    zzc(paramCharSequence, paramByteBuffer);
  }
  
  final String zzh(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws zzfh {
    if ((paramInt1 | paramInt2 | paramArrayOfbyte.length - paramInt1 - paramInt2) >= 0) {
      int i = paramInt1 + paramInt2;
      char[] arrayOfChar = new char[paramInt2];
      paramInt2 = 0;
      while (paramInt1 < i) {
        byte b = paramArrayOfbyte[paramInt1];
        if (zzhz.zzh(b)) {
          paramInt1++;
          zzhz.zzb(b, arrayOfChar, paramInt2);
          paramInt2++;
        } 
      } 
      int j = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = j;
      while (paramInt2 < i) {
        j = paramInt2 + 1;
        byte b = paramArrayOfbyte[paramInt2];
        if (zzhz.zzh(b)) {
          paramInt2 = paramInt1 + 1;
          zzhz.zzb(b, arrayOfChar, paramInt1);
          paramInt1 = paramInt2;
          paramInt2 = j;
          while (paramInt2 < i) {
            b = paramArrayOfbyte[paramInt2];
            if (zzhz.zzh(b)) {
              paramInt2++;
              zzhz.zzb(b, arrayOfChar, paramInt1);
              paramInt1++;
            } 
          } 
          continue;
        } 
        if (zzhz.zzi(b)) {
          if (j < i) {
            zzhz.zzb(b, paramArrayOfbyte[j], arrayOfChar, paramInt1);
            paramInt2 = j + 1;
            paramInt1++;
            continue;
          } 
          throw zzfh.zznc();
        } 
        if (zzhz.zzj(b)) {
          if (j < i - 1) {
            paramInt2 = j + 1;
            zzhz.zzb(b, paramArrayOfbyte[j], paramArrayOfbyte[paramInt2], arrayOfChar, paramInt1);
            paramInt2++;
            paramInt1++;
            continue;
          } 
          throw zzfh.zznc();
        } 
        if (j < i - 2) {
          paramInt2 = j + 1;
          byte b1 = paramArrayOfbyte[j];
          j = paramInt2 + 1;
          zzhz.zzb(b, b1, paramArrayOfbyte[paramInt2], paramArrayOfbyte[j], arrayOfChar, paramInt1);
          paramInt2 = j + 1;
          paramInt1 = paramInt1 + 1 + 1;
          continue;
        } 
        throw zzfh.zznc();
      } 
      return new String(arrayOfChar, 0, paramInt1);
    } 
    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[] { Integer.valueOf(paramArrayOfbyte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */