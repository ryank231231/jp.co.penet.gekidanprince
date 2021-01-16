package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;

abstract class zzia {
  static void zzc(CharSequence paramCharSequence, ByteBuffer paramByteBuffer) {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface length : ()I
    //   6: istore_2
    //   7: aload_1
    //   8: invokevirtual position : ()I
    //   11: istore_3
    //   12: iconst_0
    //   13: istore #4
    //   15: iload #4
    //   17: iload_2
    //   18: if_icmpge -> 71
    //   21: iload_3
    //   22: istore #5
    //   24: iload #4
    //   26: istore #6
    //   28: aload_0
    //   29: iload #4
    //   31: invokeinterface charAt : (I)C
    //   36: istore #7
    //   38: iload #7
    //   40: sipush #128
    //   43: if_icmpge -> 71
    //   46: iload_3
    //   47: istore #5
    //   49: iload #4
    //   51: istore #6
    //   53: aload_1
    //   54: iload_3
    //   55: iload #4
    //   57: iadd
    //   58: iload #7
    //   60: i2b
    //   61: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   64: pop
    //   65: iinc #4, 1
    //   68: goto -> 15
    //   71: iload #4
    //   73: iload_2
    //   74: if_icmpne -> 94
    //   77: iload_3
    //   78: istore #5
    //   80: iload #4
    //   82: istore #6
    //   84: aload_1
    //   85: iload_3
    //   86: iload #4
    //   88: iadd
    //   89: invokevirtual position : (I)Ljava/nio/Buffer;
    //   92: pop
    //   93: return
    //   94: iload_3
    //   95: iload #4
    //   97: iadd
    //   98: istore_3
    //   99: iload #4
    //   101: iload_2
    //   102: if_icmpge -> 552
    //   105: iload_3
    //   106: istore #5
    //   108: iload #4
    //   110: istore #6
    //   112: aload_0
    //   113: iload #4
    //   115: invokeinterface charAt : (I)C
    //   120: istore #8
    //   122: iload #8
    //   124: sipush #128
    //   127: if_icmpge -> 149
    //   130: iload_3
    //   131: istore #5
    //   133: iload #4
    //   135: istore #6
    //   137: aload_1
    //   138: iload_3
    //   139: iload #8
    //   141: i2b
    //   142: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   145: pop
    //   146: goto -> 535
    //   149: iload #8
    //   151: sipush #2048
    //   154: if_icmpge -> 213
    //   157: iload_3
    //   158: iconst_1
    //   159: iadd
    //   160: istore #6
    //   162: iload #8
    //   164: bipush #6
    //   166: iushr
    //   167: sipush #192
    //   170: ior
    //   171: i2b
    //   172: istore #9
    //   174: aload_1
    //   175: iload_3
    //   176: iload #9
    //   178: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   181: pop
    //   182: aload_1
    //   183: iload #6
    //   185: iload #8
    //   187: bipush #63
    //   189: iand
    //   190: sipush #128
    //   193: ior
    //   194: i2b
    //   195: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   198: pop
    //   199: iload #6
    //   201: istore_3
    //   202: goto -> 535
    //   205: astore #10
    //   207: iload #6
    //   209: istore_3
    //   210: goto -> 566
    //   213: iload #8
    //   215: ldc 55296
    //   217: if_icmplt -> 451
    //   220: ldc 57343
    //   222: iload #8
    //   224: if_icmpge -> 230
    //   227: goto -> 451
    //   230: iload #4
    //   232: iconst_1
    //   233: iadd
    //   234: istore #6
    //   236: iload #6
    //   238: iload_2
    //   239: if_icmpeq -> 414
    //   242: aload_0
    //   243: iload #6
    //   245: invokeinterface charAt : (I)C
    //   250: istore #11
    //   252: iload #8
    //   254: iload #11
    //   256: invokestatic isSurrogatePair : (CC)Z
    //   259: ifeq -> 400
    //   262: iload #8
    //   264: iload #11
    //   266: invokestatic toCodePoint : (CC)I
    //   269: istore #5
    //   271: iload_3
    //   272: iconst_1
    //   273: iadd
    //   274: istore #4
    //   276: iload #5
    //   278: bipush #18
    //   280: iushr
    //   281: sipush #240
    //   284: ior
    //   285: i2b
    //   286: istore #9
    //   288: aload_1
    //   289: iload_3
    //   290: iload #9
    //   292: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   295: pop
    //   296: iload #4
    //   298: iconst_1
    //   299: iadd
    //   300: istore_3
    //   301: iload #5
    //   303: bipush #12
    //   305: iushr
    //   306: bipush #63
    //   308: iand
    //   309: sipush #128
    //   312: ior
    //   313: i2b
    //   314: istore #9
    //   316: aload_1
    //   317: iload #4
    //   319: iload #9
    //   321: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   324: pop
    //   325: iload_3
    //   326: iconst_1
    //   327: iadd
    //   328: istore #4
    //   330: iload #5
    //   332: bipush #6
    //   334: iushr
    //   335: bipush #63
    //   337: iand
    //   338: sipush #128
    //   341: ior
    //   342: i2b
    //   343: istore #9
    //   345: aload_1
    //   346: iload_3
    //   347: iload #9
    //   349: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   352: pop
    //   353: aload_1
    //   354: iload #4
    //   356: iload #5
    //   358: bipush #63
    //   360: iand
    //   361: sipush #128
    //   364: ior
    //   365: i2b
    //   366: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   369: pop
    //   370: iload #4
    //   372: istore_3
    //   373: iload #6
    //   375: istore #4
    //   377: goto -> 535
    //   380: astore #10
    //   382: iload #4
    //   384: istore_3
    //   385: goto -> 407
    //   388: astore #10
    //   390: iload #4
    //   392: istore_3
    //   393: iload #6
    //   395: istore #4
    //   397: goto -> 566
    //   400: iload #6
    //   402: istore #4
    //   404: goto -> 414
    //   407: iload #6
    //   409: istore #4
    //   411: goto -> 566
    //   414: iload_3
    //   415: istore #5
    //   417: iload #4
    //   419: istore #6
    //   421: new com/google/android/gms/internal/measurement/zzic
    //   424: astore #10
    //   426: iload_3
    //   427: istore #5
    //   429: iload #4
    //   431: istore #6
    //   433: aload #10
    //   435: iload #4
    //   437: iload_2
    //   438: invokespecial <init> : (II)V
    //   441: iload_3
    //   442: istore #5
    //   444: iload #4
    //   446: istore #6
    //   448: aload #10
    //   450: athrow
    //   451: iload_3
    //   452: iconst_1
    //   453: iadd
    //   454: istore #7
    //   456: iload #8
    //   458: bipush #12
    //   460: iushr
    //   461: sipush #224
    //   464: ior
    //   465: i2b
    //   466: istore #9
    //   468: aload_1
    //   469: iload_3
    //   470: iload #9
    //   472: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   475: pop
    //   476: iload #7
    //   478: iconst_1
    //   479: iadd
    //   480: istore_3
    //   481: iload #8
    //   483: bipush #6
    //   485: iushr
    //   486: bipush #63
    //   488: iand
    //   489: sipush #128
    //   492: ior
    //   493: i2b
    //   494: istore #9
    //   496: iload_3
    //   497: istore #5
    //   499: iload #4
    //   501: istore #6
    //   503: aload_1
    //   504: iload #7
    //   506: iload #9
    //   508: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   511: pop
    //   512: iload_3
    //   513: istore #5
    //   515: iload #4
    //   517: istore #6
    //   519: aload_1
    //   520: iload_3
    //   521: iload #8
    //   523: bipush #63
    //   525: iand
    //   526: sipush #128
    //   529: ior
    //   530: i2b
    //   531: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   534: pop
    //   535: iinc #4, 1
    //   538: iinc #3, 1
    //   541: goto -> 99
    //   544: astore #10
    //   546: iload #7
    //   548: istore_3
    //   549: goto -> 566
    //   552: iload_3
    //   553: istore #5
    //   555: iload #4
    //   557: istore #6
    //   559: aload_1
    //   560: iload_3
    //   561: invokevirtual position : (I)Ljava/nio/Buffer;
    //   564: pop
    //   565: return
    //   566: aload_1
    //   567: invokevirtual position : ()I
    //   570: istore #6
    //   572: iload #4
    //   574: iload_3
    //   575: aload_1
    //   576: invokevirtual position : ()I
    //   579: isub
    //   580: iconst_1
    //   581: iadd
    //   582: invokestatic max : (II)I
    //   585: istore_3
    //   586: aload_0
    //   587: iload #4
    //   589: invokeinterface charAt : (I)C
    //   594: istore #11
    //   596: new java/lang/StringBuilder
    //   599: dup
    //   600: bipush #37
    //   602: invokespecial <init> : (I)V
    //   605: astore_0
    //   606: aload_0
    //   607: ldc 'Failed writing '
    //   609: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload_0
    //   614: iload #11
    //   616: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload_0
    //   621: ldc ' at index '
    //   623: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: pop
    //   627: aload_0
    //   628: iload #6
    //   630: iload_3
    //   631: iadd
    //   632: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: new java/lang/ArrayIndexOutOfBoundsException
    //   639: dup
    //   640: aload_0
    //   641: invokevirtual toString : ()Ljava/lang/String;
    //   644: invokespecial <init> : (Ljava/lang/String;)V
    //   647: athrow
    //   648: astore #10
    //   650: iload #5
    //   652: istore_3
    //   653: iload #6
    //   655: istore #4
    //   657: goto -> 566
    //   660: astore #10
    //   662: goto -> 407
    //   665: astore #10
    //   667: goto -> 393
    // Exception table:
    //   from	to	target	type
    //   28	38	648	java/lang/IndexOutOfBoundsException
    //   53	65	648	java/lang/IndexOutOfBoundsException
    //   84	93	648	java/lang/IndexOutOfBoundsException
    //   112	122	648	java/lang/IndexOutOfBoundsException
    //   137	146	648	java/lang/IndexOutOfBoundsException
    //   174	199	205	java/lang/IndexOutOfBoundsException
    //   242	271	660	java/lang/IndexOutOfBoundsException
    //   288	296	388	java/lang/IndexOutOfBoundsException
    //   316	325	665	java/lang/IndexOutOfBoundsException
    //   345	370	380	java/lang/IndexOutOfBoundsException
    //   421	426	648	java/lang/IndexOutOfBoundsException
    //   433	441	648	java/lang/IndexOutOfBoundsException
    //   448	451	648	java/lang/IndexOutOfBoundsException
    //   468	476	544	java/lang/IndexOutOfBoundsException
    //   503	512	648	java/lang/IndexOutOfBoundsException
    //   519	535	648	java/lang/IndexOutOfBoundsException
    //   559	565	648	java/lang/IndexOutOfBoundsException
  }
  
  abstract int zzb(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3);
  
  abstract int zzb(CharSequence paramCharSequence, byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  abstract void zzb(CharSequence paramCharSequence, ByteBuffer paramByteBuffer);
  
  final boolean zzf(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return (zzb(0, paramArrayOfbyte, paramInt1, paramInt2) == 0);
  }
  
  abstract String zzh(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws zzfh;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */