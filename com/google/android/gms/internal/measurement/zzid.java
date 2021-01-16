package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;

final class zzid extends zzia {
  private static int zza(byte[] paramArrayOfbyte, int paramInt1, long paramLong, int paramInt2) {
    switch (paramInt2) {
      default:
        throw new AssertionError();
      case 2:
        return zzhy.zzd(paramInt1, zzhw.zza(paramArrayOfbyte, paramLong), zzhw.zza(paramArrayOfbyte, paramLong + 1L));
      case 1:
        return zzhy.zzs(paramInt1, zzhw.zza(paramArrayOfbyte, paramLong));
      case 0:
        break;
    } 
    return zzhy.zzbi(paramInt1);
  }
  
  final int zzb(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
    // Byte code:
    //   0: iload_3
    //   1: iload #4
    //   3: ior
    //   4: aload_2
    //   5: arraylength
    //   6: iload #4
    //   8: isub
    //   9: ior
    //   10: iflt -> 389
    //   13: iload_3
    //   14: i2l
    //   15: lstore #5
    //   17: iload #4
    //   19: i2l
    //   20: lload #5
    //   22: lsub
    //   23: l2i
    //   24: istore_3
    //   25: iload_3
    //   26: bipush #16
    //   28: if_icmpge -> 36
    //   31: iconst_0
    //   32: istore_1
    //   33: goto -> 73
    //   36: lload #5
    //   38: lstore #7
    //   40: iconst_0
    //   41: istore_1
    //   42: iload_1
    //   43: iload_3
    //   44: if_icmpge -> 71
    //   47: aload_2
    //   48: lload #7
    //   50: invokestatic zza : ([BJ)B
    //   53: ifge -> 59
    //   56: goto -> 73
    //   59: iinc #1, 1
    //   62: lload #7
    //   64: lconst_1
    //   65: ladd
    //   66: lstore #7
    //   68: goto -> 42
    //   71: iload_3
    //   72: istore_1
    //   73: iload_3
    //   74: iload_1
    //   75: isub
    //   76: istore_3
    //   77: lload #5
    //   79: iload_1
    //   80: i2l
    //   81: ladd
    //   82: lstore #7
    //   84: iload_3
    //   85: istore_1
    //   86: iconst_0
    //   87: istore #4
    //   89: iload_1
    //   90: istore_3
    //   91: iload #4
    //   93: istore_1
    //   94: iload_3
    //   95: ifle -> 137
    //   98: lload #7
    //   100: lconst_1
    //   101: ladd
    //   102: lstore #5
    //   104: aload_2
    //   105: lload #7
    //   107: invokestatic zza : ([BJ)B
    //   110: istore #4
    //   112: iload #4
    //   114: istore_1
    //   115: lload #5
    //   117: lstore #7
    //   119: iload #4
    //   121: iflt -> 137
    //   124: iinc #3, -1
    //   127: lload #5
    //   129: lstore #7
    //   131: iload #4
    //   133: istore_1
    //   134: goto -> 94
    //   137: iload_3
    //   138: ifne -> 143
    //   141: iconst_0
    //   142: ireturn
    //   143: iinc #3, -1
    //   146: iload_1
    //   147: bipush #-32
    //   149: if_icmpge -> 194
    //   152: iload_3
    //   153: ifne -> 158
    //   156: iload_1
    //   157: ireturn
    //   158: iinc #3, -1
    //   161: iload_1
    //   162: bipush #-62
    //   164: if_icmplt -> 192
    //   167: aload_2
    //   168: lload #7
    //   170: invokestatic zza : ([BJ)B
    //   173: bipush #-65
    //   175: if_icmple -> 181
    //   178: goto -> 192
    //   181: lload #7
    //   183: lconst_1
    //   184: ladd
    //   185: lstore #7
    //   187: iload_3
    //   188: istore_1
    //   189: goto -> 86
    //   192: iconst_m1
    //   193: ireturn
    //   194: iload_1
    //   195: bipush #-16
    //   197: if_icmpge -> 291
    //   200: iload_3
    //   201: iconst_2
    //   202: if_icmpge -> 214
    //   205: aload_2
    //   206: iload_1
    //   207: lload #7
    //   209: iload_3
    //   210: invokestatic zza : ([BIJI)I
    //   213: ireturn
    //   214: iinc #3, -2
    //   217: lload #7
    //   219: lconst_1
    //   220: ladd
    //   221: lstore #5
    //   223: aload_2
    //   224: lload #7
    //   226: invokestatic zza : ([BJ)B
    //   229: istore #4
    //   231: iload #4
    //   233: bipush #-65
    //   235: if_icmpgt -> 289
    //   238: iload_1
    //   239: bipush #-32
    //   241: if_icmpne -> 251
    //   244: iload #4
    //   246: bipush #-96
    //   248: if_icmplt -> 289
    //   251: iload_1
    //   252: bipush #-19
    //   254: if_icmpne -> 264
    //   257: iload #4
    //   259: bipush #-96
    //   261: if_icmpge -> 289
    //   264: aload_2
    //   265: lload #5
    //   267: invokestatic zza : ([BJ)B
    //   270: bipush #-65
    //   272: if_icmple -> 278
    //   275: goto -> 289
    //   278: lload #5
    //   280: lconst_1
    //   281: ladd
    //   282: lstore #7
    //   284: iload_3
    //   285: istore_1
    //   286: goto -> 86
    //   289: iconst_m1
    //   290: ireturn
    //   291: iload_3
    //   292: iconst_3
    //   293: if_icmpge -> 305
    //   296: aload_2
    //   297: iload_1
    //   298: lload #7
    //   300: iload_3
    //   301: invokestatic zza : ([BIJI)I
    //   304: ireturn
    //   305: iinc #3, -3
    //   308: lload #7
    //   310: lconst_1
    //   311: ladd
    //   312: lstore #5
    //   314: aload_2
    //   315: lload #7
    //   317: invokestatic zza : ([BJ)B
    //   320: istore #4
    //   322: iload #4
    //   324: bipush #-65
    //   326: if_icmpgt -> 387
    //   329: iload_1
    //   330: bipush #28
    //   332: ishl
    //   333: iload #4
    //   335: bipush #112
    //   337: iadd
    //   338: iadd
    //   339: bipush #30
    //   341: ishr
    //   342: ifne -> 387
    //   345: lload #5
    //   347: lconst_1
    //   348: ladd
    //   349: lstore #7
    //   351: aload_2
    //   352: lload #5
    //   354: invokestatic zza : ([BJ)B
    //   357: bipush #-65
    //   359: if_icmpgt -> 387
    //   362: aload_2
    //   363: lload #7
    //   365: invokestatic zza : ([BJ)B
    //   368: bipush #-65
    //   370: if_icmple -> 376
    //   373: goto -> 387
    //   376: lload #7
    //   378: lconst_1
    //   379: ladd
    //   380: lstore #7
    //   382: iload_3
    //   383: istore_1
    //   384: goto -> 86
    //   387: iconst_m1
    //   388: ireturn
    //   389: new java/lang/ArrayIndexOutOfBoundsException
    //   392: dup
    //   393: ldc 'Array length=%d, index=%d, limit=%d'
    //   395: iconst_3
    //   396: anewarray java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: aload_2
    //   402: arraylength
    //   403: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   406: aastore
    //   407: dup
    //   408: iconst_1
    //   409: iload_3
    //   410: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   413: aastore
    //   414: dup
    //   415: iconst_2
    //   416: iload #4
    //   418: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   421: aastore
    //   422: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   425: invokespecial <init> : (Ljava/lang/String;)V
    //   428: athrow
  }
  
  final int zzb(CharSequence paramCharSequence, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    long l1 = paramInt1;
    long l2 = paramInt2 + l1;
    int i = paramCharSequence.length();
    if (i <= paramInt2 && paramArrayOfbyte.length - paramInt2 >= paramInt1) {
      paramInt2 = 0;
      while (paramInt2 < i) {
        paramInt1 = paramCharSequence.charAt(paramInt2);
        if (paramInt1 < 128) {
          zzhw.zza(paramArrayOfbyte, l1, (byte)paramInt1);
          paramInt2++;
          l1 = 1L + l1;
        } 
      } 
      paramInt1 = paramInt2;
      long l = l1;
      if (paramInt2 == i)
        return (int)l1; 
      while (paramInt1 < i) {
        char c1 = paramCharSequence.charAt(paramInt1);
        if (c1 < '' && l < l2) {
          zzhw.zza(paramArrayOfbyte, l, (byte)c1);
          l1 = l + 1L;
        } else if (c1 < 'ࠀ' && l <= l2 - 2L) {
          long l3 = l + 1L;
          zzhw.zza(paramArrayOfbyte, l, (byte)(c1 >>> 6 | 0x3C0));
          l1 = l3 + 1L;
          zzhw.zza(paramArrayOfbyte, l3, (byte)(c1 & 0x3F | 0x80));
        } else if ((c1 < '?' || '?' < c1) && l <= l2 - 3L) {
          l1 = l + 1L;
          zzhw.zza(paramArrayOfbyte, l, (byte)(c1 >>> 12 | 0x1E0));
          l = l1 + 1L;
          zzhw.zza(paramArrayOfbyte, l1, (byte)(c1 >>> 6 & 0x3F | 0x80));
          zzhw.zza(paramArrayOfbyte, l, (byte)(c1 & 0x3F | 0x80));
          l1 = l + 1L;
        } else if (l <= l2 - 4L) {
          paramInt2 = paramInt1 + 1;
          if (paramInt2 != i) {
            char c2 = paramCharSequence.charAt(paramInt2);
            paramInt1 = paramInt2;
            if (Character.isSurrogatePair(c1, c2)) {
              paramInt1 = Character.toCodePoint(c1, c2);
              long l3 = l + 1L;
              zzhw.zza(paramArrayOfbyte, l, (byte)(paramInt1 >>> 18 | 0xF0));
              l1 = l3 + 1L;
              zzhw.zza(paramArrayOfbyte, l3, (byte)(paramInt1 >>> 12 & 0x3F | 0x80));
              l = l1 + 1L;
              zzhw.zza(paramArrayOfbyte, l1, (byte)(paramInt1 >>> 6 & 0x3F | 0x80));
              l1 = l + 1L;
              zzhw.zza(paramArrayOfbyte, l, (byte)(paramInt1 & 0x3F | 0x80));
              paramInt1 = paramInt2;
            } else {
              throw new zzic(paramInt1 - 1, i);
            } 
          } else {
            throw new zzic(paramInt1 - 1, i);
          } 
        } else {
          if ('?' <= c1 && c1 <= '?') {
            paramInt2 = paramInt1 + 1;
            if (paramInt2 == i || !Character.isSurrogatePair(c1, paramCharSequence.charAt(paramInt2)))
              throw new zzic(paramInt1, i); 
          } 
          paramCharSequence = new StringBuilder(46);
          paramCharSequence.append("Failed writing ");
          paramCharSequence.append(c1);
          paramCharSequence.append(" at index ");
          paramCharSequence.append(l);
          throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
        } 
        paramInt1++;
        l = l1;
      } 
      return (int)l;
    } 
    char c = paramCharSequence.charAt(i - 1);
    paramCharSequence = new StringBuilder(37);
    paramCharSequence.append("Failed writing ");
    paramCharSequence.append(c);
    paramCharSequence.append(" at index ");
    paramCharSequence.append(paramInt1 + paramInt2);
    throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
  }
  
  final void zzb(CharSequence paramCharSequence, ByteBuffer paramByteBuffer) {
    long l1 = zzhw.zzb(paramByteBuffer);
    long l2 = paramByteBuffer.position() + l1;
    long l3 = paramByteBuffer.limit() + l1;
    int i = paramCharSequence.length();
    if (i <= l3 - l2) {
      long l4;
      int k = 0;
      while (true) {
        l4 = 1L;
        if (k < i) {
          char c1 = paramCharSequence.charAt(k);
          if (c1 < '') {
            zzhw.zza(l2, (byte)c1);
            k++;
            l2 = 1L + l2;
            continue;
          } 
        } 
        break;
      } 
      long l5 = l2;
      int m = k;
      if (k == i) {
        paramByteBuffer.position((int)(l2 - l1));
        return;
      } 
      while (m < i) {
        char c1 = paramCharSequence.charAt(m);
        if (c1 < '' && l5 < l3) {
          l2 = l5 + l4;
          zzhw.zza(l5, (byte)c1);
        } else if (c1 < 'ࠀ' && l5 <= l3 - 2L) {
          l2 = l5 + l4;
          zzhw.zza(l5, (byte)(c1 >>> 6 | 0x3C0));
          zzhw.zza(l2, (byte)(c1 & 0x3F | 0x80));
          l2 += l4;
        } else if ((c1 < '?' || '?' < c1) && l5 <= l3 - 3L) {
          l2 = l5 + l4;
          zzhw.zza(l5, (byte)(c1 >>> 12 | 0x1E0));
          l4 = l2 + l4;
          zzhw.zza(l2, (byte)(c1 >>> 6 & 0x3F | 0x80));
          zzhw.zza(l4, (byte)(c1 & 0x3F | 0x80));
          l2 = l4 + 1L;
          l4 = 1L;
        } else if (l5 <= l3 - 4L) {
          k = m + 1;
          if (k != i) {
            char c2 = paramCharSequence.charAt(k);
            if (Character.isSurrogatePair(c1, c2)) {
              m = Character.toCodePoint(c1, c2);
              l2 = l5 + 1L;
              zzhw.zza(l5, (byte)(m >>> 18 | 0xF0));
              l4 = l2 + 1L;
              zzhw.zza(l2, (byte)(m >>> 12 & 0x3F | 0x80));
              l2 = l4 + 1L;
              zzhw.zza(l4, (byte)(m >>> 6 & 0x3F | 0x80));
              l4 = 1L;
              zzhw.zza(l2, (byte)(m & 0x3F | 0x80));
              m = k;
              l2++;
            } else {
              m = k;
              throw new zzic(m - 1, i);
            } 
          } else {
            throw new zzic(m - 1, i);
          } 
        } else {
          if ('?' <= c1 && c1 <= '?') {
            k = m + 1;
            if (k == i || !Character.isSurrogatePair(c1, paramCharSequence.charAt(k)))
              throw new zzic(m, i); 
          } 
          paramCharSequence = new StringBuilder(46);
          paramCharSequence.append("Failed writing ");
          paramCharSequence.append(c1);
          paramCharSequence.append(" at index ");
          paramCharSequence.append(l5);
          throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
        } 
        m++;
        l5 = l2;
      } 
      paramByteBuffer.position((int)(l5 - l1));
      return;
    } 
    char c = paramCharSequence.charAt(i - 1);
    int j = paramByteBuffer.limit();
    paramCharSequence = new StringBuilder(37);
    paramCharSequence.append("Failed writing ");
    paramCharSequence.append(c);
    paramCharSequence.append(" at index ");
    paramCharSequence.append(j);
    throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
  }
  
  final String zzh(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws zzfh {
    if ((paramInt1 | paramInt2 | paramArrayOfbyte.length - paramInt1 - paramInt2) >= 0) {
      int i = paramInt1 + paramInt2;
      char[] arrayOfChar = new char[paramInt2];
      paramInt2 = 0;
      while (paramInt1 < i) {
        byte b = zzhw.zza(paramArrayOfbyte, paramInt1);
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
        byte b = zzhw.zza(paramArrayOfbyte, paramInt2);
        if (zzhz.zzh(b)) {
          paramInt2 = paramInt1 + 1;
          zzhz.zzb(b, arrayOfChar, paramInt1);
          paramInt1 = paramInt2;
          paramInt2 = j;
          while (paramInt2 < i) {
            byte b1 = zzhw.zza(paramArrayOfbyte, paramInt2);
            if (zzhz.zzh(b1)) {
              paramInt2++;
              zzhz.zzb(b1, arrayOfChar, paramInt1);
              paramInt1++;
            } 
          } 
          continue;
        } 
        if (zzhz.zzi(b)) {
          if (j < i) {
            zzhz.zzb(b, zzhw.zza(paramArrayOfbyte, j), arrayOfChar, paramInt1);
            paramInt2 = j + 1;
            paramInt1++;
            continue;
          } 
          throw zzfh.zznc();
        } 
        if (zzhz.zzj(b)) {
          if (j < i - 1) {
            paramInt2 = j + 1;
            zzhz.zzb(b, zzhw.zza(paramArrayOfbyte, j), zzhw.zza(paramArrayOfbyte, paramInt2), arrayOfChar, paramInt1);
            paramInt2++;
            paramInt1++;
            continue;
          } 
          throw zzfh.zznc();
        } 
        if (j < i - 2) {
          paramInt2 = j + 1;
          byte b1 = zzhw.zza(paramArrayOfbyte, j);
          j = paramInt2 + 1;
          zzhz.zzb(b, b1, zzhw.zza(paramArrayOfbyte, paramInt2), zzhw.zza(paramArrayOfbyte, j), arrayOfChar, paramInt1);
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


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */