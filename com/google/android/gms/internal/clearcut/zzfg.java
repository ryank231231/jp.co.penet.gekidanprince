package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;

abstract class zzfg {
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
    //   102: if_icmpge -> 567
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
    //   146: goto -> 558
    //   149: iload #8
    //   151: sipush #2048
    //   154: if_icmpge -> 222
    //   157: iload_3
    //   158: iconst_1
    //   159: iadd
    //   160: istore #5
    //   162: iload #8
    //   164: bipush #6
    //   166: iushr
    //   167: sipush #192
    //   170: ior
    //   171: i2b
    //   172: istore #9
    //   174: iload #5
    //   176: istore #6
    //   178: aload_1
    //   179: iload_3
    //   180: iload #9
    //   182: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   185: pop
    //   186: iload #5
    //   188: istore #6
    //   190: aload_1
    //   191: iload #5
    //   193: iload #8
    //   195: bipush #63
    //   197: iand
    //   198: sipush #128
    //   201: ior
    //   202: i2b
    //   203: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   206: pop
    //   207: iload #5
    //   209: istore_3
    //   210: goto -> 558
    //   213: astore #10
    //   215: iload #6
    //   217: istore #5
    //   219: goto -> 581
    //   222: iload #8
    //   224: ldc 55296
    //   226: if_icmplt -> 470
    //   229: ldc 57343
    //   231: iload #8
    //   233: if_icmpge -> 239
    //   236: goto -> 470
    //   239: iload #4
    //   241: iconst_1
    //   242: iadd
    //   243: istore #6
    //   245: iload #6
    //   247: iload_2
    //   248: if_icmpeq -> 433
    //   251: iload_3
    //   252: istore #4
    //   254: aload_0
    //   255: iload #6
    //   257: invokeinterface charAt : (I)C
    //   262: istore #11
    //   264: iload_3
    //   265: istore #4
    //   267: iload #8
    //   269: iload #11
    //   271: invokestatic isSurrogatePair : (CC)Z
    //   274: ifeq -> 415
    //   277: iload_3
    //   278: istore #4
    //   280: iload #8
    //   282: iload #11
    //   284: invokestatic toCodePoint : (CC)I
    //   287: istore #12
    //   289: iload_3
    //   290: iconst_1
    //   291: iadd
    //   292: istore #7
    //   294: iload #12
    //   296: bipush #18
    //   298: iushr
    //   299: sipush #240
    //   302: ior
    //   303: i2b
    //   304: istore #9
    //   306: iload #7
    //   308: istore #4
    //   310: aload_1
    //   311: iload_3
    //   312: iload #9
    //   314: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   317: pop
    //   318: iload #7
    //   320: iconst_1
    //   321: iadd
    //   322: istore #5
    //   324: iload #12
    //   326: bipush #12
    //   328: iushr
    //   329: bipush #63
    //   331: iand
    //   332: sipush #128
    //   335: ior
    //   336: i2b
    //   337: istore #9
    //   339: iload #5
    //   341: istore #4
    //   343: aload_1
    //   344: iload #7
    //   346: iload #9
    //   348: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   351: pop
    //   352: iload #5
    //   354: iconst_1
    //   355: iadd
    //   356: istore_3
    //   357: iload #12
    //   359: bipush #6
    //   361: iushr
    //   362: bipush #63
    //   364: iand
    //   365: sipush #128
    //   368: ior
    //   369: i2b
    //   370: istore #9
    //   372: iload_3
    //   373: istore #4
    //   375: aload_1
    //   376: iload #5
    //   378: iload #9
    //   380: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   383: pop
    //   384: iload_3
    //   385: istore #4
    //   387: aload_1
    //   388: iload_3
    //   389: iload #12
    //   391: bipush #63
    //   393: iand
    //   394: sipush #128
    //   397: ior
    //   398: i2b
    //   399: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   402: pop
    //   403: iload #6
    //   405: istore #4
    //   407: goto -> 558
    //   410: astore #10
    //   412: goto -> 422
    //   415: iload #6
    //   417: istore #4
    //   419: goto -> 433
    //   422: iload #4
    //   424: istore #5
    //   426: iload #6
    //   428: istore #4
    //   430: goto -> 581
    //   433: iload_3
    //   434: istore #5
    //   436: iload #4
    //   438: istore #6
    //   440: new com/google/android/gms/internal/clearcut/zzfi
    //   443: astore #10
    //   445: iload_3
    //   446: istore #5
    //   448: iload #4
    //   450: istore #6
    //   452: aload #10
    //   454: iload #4
    //   456: iload_2
    //   457: invokespecial <init> : (II)V
    //   460: iload_3
    //   461: istore #5
    //   463: iload #4
    //   465: istore #6
    //   467: aload #10
    //   469: athrow
    //   470: iload_3
    //   471: iconst_1
    //   472: iadd
    //   473: istore #7
    //   475: iload #8
    //   477: bipush #12
    //   479: iushr
    //   480: sipush #224
    //   483: ior
    //   484: i2b
    //   485: istore #9
    //   487: iload #7
    //   489: istore #6
    //   491: aload_1
    //   492: iload_3
    //   493: iload #9
    //   495: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   498: pop
    //   499: iload #7
    //   501: iconst_1
    //   502: iadd
    //   503: istore_3
    //   504: iload #8
    //   506: bipush #6
    //   508: iushr
    //   509: bipush #63
    //   511: iand
    //   512: sipush #128
    //   515: ior
    //   516: i2b
    //   517: istore #9
    //   519: iload_3
    //   520: istore #5
    //   522: iload #4
    //   524: istore #6
    //   526: aload_1
    //   527: iload #7
    //   529: iload #9
    //   531: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   534: pop
    //   535: iload_3
    //   536: istore #5
    //   538: iload #4
    //   540: istore #6
    //   542: aload_1
    //   543: iload_3
    //   544: iload #8
    //   546: bipush #63
    //   548: iand
    //   549: sipush #128
    //   552: ior
    //   553: i2b
    //   554: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
    //   557: pop
    //   558: iinc #4, 1
    //   561: iinc #3, 1
    //   564: goto -> 99
    //   567: iload_3
    //   568: istore #5
    //   570: iload #4
    //   572: istore #6
    //   574: aload_1
    //   575: iload_3
    //   576: invokevirtual position : (I)Ljava/nio/Buffer;
    //   579: pop
    //   580: return
    //   581: aload_1
    //   582: invokevirtual position : ()I
    //   585: istore_3
    //   586: iload #4
    //   588: iload #5
    //   590: aload_1
    //   591: invokevirtual position : ()I
    //   594: isub
    //   595: iconst_1
    //   596: iadd
    //   597: invokestatic max : (II)I
    //   600: istore #6
    //   602: aload_0
    //   603: iload #4
    //   605: invokeinterface charAt : (I)C
    //   610: istore #11
    //   612: new java/lang/StringBuilder
    //   615: dup
    //   616: bipush #37
    //   618: invokespecial <init> : (I)V
    //   621: astore_0
    //   622: aload_0
    //   623: ldc 'Failed writing '
    //   625: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload_0
    //   630: iload #11
    //   632: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload_0
    //   637: ldc ' at index '
    //   639: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload_0
    //   644: iload_3
    //   645: iload #6
    //   647: iadd
    //   648: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: new java/lang/ArrayIndexOutOfBoundsException
    //   655: dup
    //   656: aload_0
    //   657: invokevirtual toString : ()Ljava/lang/String;
    //   660: invokespecial <init> : (Ljava/lang/String;)V
    //   663: athrow
    //   664: astore #10
    //   666: iload #6
    //   668: istore #4
    //   670: goto -> 581
    //   673: astore #10
    //   675: goto -> 422
    // Exception table:
    //   from	to	target	type
    //   28	38	664	java/lang/IndexOutOfBoundsException
    //   53	65	664	java/lang/IndexOutOfBoundsException
    //   84	93	664	java/lang/IndexOutOfBoundsException
    //   112	122	664	java/lang/IndexOutOfBoundsException
    //   137	146	664	java/lang/IndexOutOfBoundsException
    //   178	186	213	java/lang/IndexOutOfBoundsException
    //   190	207	213	java/lang/IndexOutOfBoundsException
    //   254	264	673	java/lang/IndexOutOfBoundsException
    //   267	277	673	java/lang/IndexOutOfBoundsException
    //   280	289	673	java/lang/IndexOutOfBoundsException
    //   310	318	410	java/lang/IndexOutOfBoundsException
    //   343	352	673	java/lang/IndexOutOfBoundsException
    //   375	384	410	java/lang/IndexOutOfBoundsException
    //   387	403	410	java/lang/IndexOutOfBoundsException
    //   440	445	664	java/lang/IndexOutOfBoundsException
    //   452	460	664	java/lang/IndexOutOfBoundsException
    //   467	470	664	java/lang/IndexOutOfBoundsException
    //   491	499	213	java/lang/IndexOutOfBoundsException
    //   526	535	664	java/lang/IndexOutOfBoundsException
    //   542	558	664	java/lang/IndexOutOfBoundsException
    //   574	580	664	java/lang/IndexOutOfBoundsException
  }
  
  abstract int zzb(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3);
  
  abstract int zzb(CharSequence paramCharSequence, byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  abstract void zzb(CharSequence paramCharSequence, ByteBuffer paramByteBuffer);
  
  final boolean zze(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return (zzb(0, paramArrayOfbyte, paramInt1, paramInt2) == 0);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */