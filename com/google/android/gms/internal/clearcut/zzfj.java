package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;

final class zzfj extends zzfg {
  private static int zza(byte[] paramArrayOfbyte, int paramInt1, long paramLong, int paramInt2) {
    switch (paramInt2) {
      default:
        throw new AssertionError();
      case 2:
        return zzff.zze(paramInt1, zzfd.zza(paramArrayOfbyte, paramLong), zzfd.zza(paramArrayOfbyte, paramLong + 1L));
      case 1:
        return zzff.zzq(paramInt1, zzfd.zza(paramArrayOfbyte, paramLong));
      case 0:
        break;
    } 
    return zzff.zzan(paramInt1);
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
    //   10: iflt -> 387
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
    //   102: lstore #9
    //   104: aload_2
    //   105: lload #7
    //   107: invokestatic zza : ([BJ)B
    //   110: istore #4
    //   112: iload #4
    //   114: istore_1
    //   115: lload #9
    //   117: lstore #5
    //   119: iload #4
    //   121: iflt -> 141
    //   124: iinc #3, -1
    //   127: lload #9
    //   129: lstore #7
    //   131: iload #4
    //   133: istore_1
    //   134: goto -> 94
    //   137: lload #7
    //   139: lstore #5
    //   141: iload_3
    //   142: ifne -> 147
    //   145: iconst_0
    //   146: ireturn
    //   147: iinc #3, -1
    //   150: iload_1
    //   151: bipush #-32
    //   153: if_icmpge -> 198
    //   156: iload_3
    //   157: ifne -> 162
    //   160: iload_1
    //   161: ireturn
    //   162: iinc #3, -1
    //   165: iload_1
    //   166: bipush #-62
    //   168: if_icmplt -> 196
    //   171: lload #5
    //   173: lconst_1
    //   174: ladd
    //   175: lstore #7
    //   177: iload_3
    //   178: istore_1
    //   179: aload_2
    //   180: lload #5
    //   182: invokestatic zza : ([BJ)B
    //   185: bipush #-65
    //   187: if_icmple -> 193
    //   190: goto -> 196
    //   193: goto -> 86
    //   196: iconst_m1
    //   197: ireturn
    //   198: iload_1
    //   199: bipush #-16
    //   201: if_icmpge -> 295
    //   204: iload_3
    //   205: iconst_2
    //   206: if_icmpge -> 218
    //   209: aload_2
    //   210: iload_1
    //   211: lload #5
    //   213: iload_3
    //   214: invokestatic zza : ([BIJI)I
    //   217: ireturn
    //   218: iinc #3, -2
    //   221: lload #5
    //   223: lconst_1
    //   224: ladd
    //   225: lstore #7
    //   227: aload_2
    //   228: lload #5
    //   230: invokestatic zza : ([BJ)B
    //   233: istore #4
    //   235: iload #4
    //   237: bipush #-65
    //   239: if_icmpgt -> 293
    //   242: iload_1
    //   243: bipush #-32
    //   245: if_icmpne -> 255
    //   248: iload #4
    //   250: bipush #-96
    //   252: if_icmplt -> 293
    //   255: iload_1
    //   256: bipush #-19
    //   258: if_icmpne -> 268
    //   261: iload #4
    //   263: bipush #-96
    //   265: if_icmpge -> 293
    //   268: aload_2
    //   269: lload #7
    //   271: invokestatic zza : ([BJ)B
    //   274: bipush #-65
    //   276: if_icmple -> 282
    //   279: goto -> 293
    //   282: lload #7
    //   284: lconst_1
    //   285: ladd
    //   286: lstore #7
    //   288: iload_3
    //   289: istore_1
    //   290: goto -> 86
    //   293: iconst_m1
    //   294: ireturn
    //   295: iload_3
    //   296: iconst_3
    //   297: if_icmpge -> 309
    //   300: aload_2
    //   301: iload_1
    //   302: lload #5
    //   304: iload_3
    //   305: invokestatic zza : ([BIJI)I
    //   308: ireturn
    //   309: iinc #3, -3
    //   312: lload #5
    //   314: lconst_1
    //   315: ladd
    //   316: lstore #7
    //   318: aload_2
    //   319: lload #5
    //   321: invokestatic zza : ([BJ)B
    //   324: istore #4
    //   326: iload #4
    //   328: bipush #-65
    //   330: if_icmpgt -> 385
    //   333: iload_1
    //   334: bipush #28
    //   336: ishl
    //   337: iload #4
    //   339: bipush #112
    //   341: iadd
    //   342: iadd
    //   343: bipush #30
    //   345: ishr
    //   346: ifne -> 385
    //   349: lload #7
    //   351: lconst_1
    //   352: ladd
    //   353: lstore #5
    //   355: aload_2
    //   356: lload #7
    //   358: invokestatic zza : ([BJ)B
    //   361: bipush #-65
    //   363: if_icmpgt -> 385
    //   366: lload #5
    //   368: lconst_1
    //   369: ladd
    //   370: lstore #7
    //   372: iload_3
    //   373: istore_1
    //   374: aload_2
    //   375: lload #5
    //   377: invokestatic zza : ([BJ)B
    //   380: bipush #-65
    //   382: if_icmple -> 193
    //   385: iconst_m1
    //   386: ireturn
    //   387: new java/lang/ArrayIndexOutOfBoundsException
    //   390: dup
    //   391: ldc 'Array length=%d, index=%d, limit=%d'
    //   393: iconst_3
    //   394: anewarray java/lang/Object
    //   397: dup
    //   398: iconst_0
    //   399: aload_2
    //   400: arraylength
    //   401: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   404: aastore
    //   405: dup
    //   406: iconst_1
    //   407: iload_3
    //   408: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   411: aastore
    //   412: dup
    //   413: iconst_2
    //   414: iload #4
    //   416: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   419: aastore
    //   420: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   423: invokespecial <init> : (Ljava/lang/String;)V
    //   426: athrow
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
          zzfd.zza(paramArrayOfbyte, l1, (byte)paramInt1);
          paramInt2++;
          l1 = 1L + l1;
        } 
      } 
      paramInt1 = paramInt2;
      long l = l1;
      if (paramInt2 == i)
        return (int)l1; 
      while (true) {
        if (paramInt1 < i) {
          char c1 = paramCharSequence.charAt(paramInt1);
          if (c1 < '' && l < l2) {
            l1 = l + 1L;
            paramInt2 = c1;
          } else {
            if (c1 < 'ࠀ' && l <= l2 - 2L) {
              l1 = l + 1L;
              zzfd.zza(paramArrayOfbyte, l, (byte)(c1 >>> 6 | 0x3C0));
              l = l1 + 1L;
              zzfd.zza(paramArrayOfbyte, l1, (byte)(c1 & 0x3F | 0x80));
            } else {
              if ((c1 < '?' || '?' < c1) && l <= l2 - 3L) {
                l1 = l + 1L;
                zzfd.zza(paramArrayOfbyte, l, (byte)(c1 >>> 12 | 0x1E0));
                l = l1 + 1L;
                zzfd.zza(paramArrayOfbyte, l1, (byte)(c1 >>> 6 & 0x3F | 0x80));
                l1 = l + 1L;
                paramInt2 = c1 & 0x3F | 0x80;
              } else {
                if (l <= l2 - 4L) {
                  paramInt2 = paramInt1 + 1;
                  if (paramInt2 != i) {
                    char c2 = paramCharSequence.charAt(paramInt2);
                    paramInt1 = paramInt2;
                    if (Character.isSurrogatePair(c1, c2)) {
                      paramInt1 = Character.toCodePoint(c1, c2);
                      l1 = l + 1L;
                      zzfd.zza(paramArrayOfbyte, l, (byte)(paramInt1 >>> 18 | 0xF0));
                      l = l1 + 1L;
                      zzfd.zza(paramArrayOfbyte, l1, (byte)(paramInt1 >>> 12 & 0x3F | 0x80));
                      l1 = l + 1L;
                      zzfd.zza(paramArrayOfbyte, l, (byte)(paramInt1 >>> 6 & 0x3F | 0x80));
                      l = l1 + 1L;
                      zzfd.zza(paramArrayOfbyte, l1, (byte)(paramInt1 & 0x3F | 0x80));
                      paramInt1 = paramInt2;
                    } else {
                      throw new zzfi(paramInt1 - 1, i);
                    } 
                  } else {
                    throw new zzfi(paramInt1 - 1, i);
                  } 
                } else {
                  if ('?' <= c1 && c1 <= '?') {
                    paramInt2 = paramInt1 + 1;
                    if (paramInt2 == i || !Character.isSurrogatePair(c1, paramCharSequence.charAt(paramInt2)))
                      throw new zzfi(paramInt1, i); 
                  } 
                  paramCharSequence = new StringBuilder(46);
                  paramCharSequence.append("Failed writing ");
                  paramCharSequence.append(c1);
                  paramCharSequence.append(" at index ");
                  paramCharSequence.append(l);
                  throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
                } 
                paramInt1++;
              } 
              zzfd.zza(paramArrayOfbyte, l, (byte)paramInt2);
              l = l1;
            } 
            paramInt1++;
          } 
        } else {
          break;
        } 
        zzfd.zza(paramArrayOfbyte, l, (byte)paramInt2);
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
    // Byte code:
    //   0: aload_2
    //   1: invokestatic zzb : (Ljava/nio/ByteBuffer;)J
    //   4: lstore_3
    //   5: aload_2
    //   6: invokevirtual position : ()I
    //   9: i2l
    //   10: lload_3
    //   11: ladd
    //   12: lstore #5
    //   14: aload_2
    //   15: invokevirtual limit : ()I
    //   18: i2l
    //   19: lload_3
    //   20: ladd
    //   21: lstore #7
    //   23: aload_1
    //   24: invokeinterface length : ()I
    //   29: istore #9
    //   31: iload #9
    //   33: i2l
    //   34: lload #7
    //   36: lload #5
    //   38: lsub
    //   39: lcmp
    //   40: ifgt -> 634
    //   43: iconst_0
    //   44: istore #10
    //   46: lconst_1
    //   47: lstore #11
    //   49: iload #10
    //   51: iload #9
    //   53: if_icmpge -> 94
    //   56: aload_1
    //   57: iload #10
    //   59: invokeinterface charAt : (I)C
    //   64: istore #13
    //   66: iload #13
    //   68: sipush #128
    //   71: if_icmpge -> 94
    //   74: lload #5
    //   76: iload #13
    //   78: i2b
    //   79: invokestatic zza : (JB)V
    //   82: iinc #10, 1
    //   85: lconst_1
    //   86: lload #5
    //   88: ladd
    //   89: lstore #5
    //   91: goto -> 46
    //   94: lload #5
    //   96: lstore #14
    //   98: iload #10
    //   100: istore #13
    //   102: iload #10
    //   104: iload #9
    //   106: if_icmpne -> 120
    //   109: aload_2
    //   110: lload #5
    //   112: lload_3
    //   113: lsub
    //   114: l2i
    //   115: invokevirtual position : (I)Ljava/nio/Buffer;
    //   118: pop
    //   119: return
    //   120: lload #14
    //   122: lstore #5
    //   124: iload #13
    //   126: iload #9
    //   128: if_icmpge -> 109
    //   131: aload_1
    //   132: iload #13
    //   134: invokeinterface charAt : (I)C
    //   139: istore #16
    //   141: iload #16
    //   143: sipush #128
    //   146: if_icmpge -> 179
    //   149: lload #14
    //   151: lload #7
    //   153: lcmp
    //   154: ifge -> 179
    //   157: lload #14
    //   159: lload #11
    //   161: ladd
    //   162: lstore #5
    //   164: lload #14
    //   166: iload #16
    //   168: i2b
    //   169: invokestatic zza : (JB)V
    //   172: lload #11
    //   174: lstore #14
    //   176: goto -> 497
    //   179: iload #16
    //   181: sipush #2048
    //   184: if_icmpge -> 246
    //   187: lload #14
    //   189: lload #7
    //   191: ldc2_w 2
    //   194: lsub
    //   195: lcmp
    //   196: ifgt -> 246
    //   199: lload #14
    //   201: lload #11
    //   203: ladd
    //   204: lstore #5
    //   206: lload #14
    //   208: iload #16
    //   210: bipush #6
    //   212: iushr
    //   213: sipush #960
    //   216: ior
    //   217: i2b
    //   218: invokestatic zza : (JB)V
    //   221: lload #5
    //   223: iload #16
    //   225: bipush #63
    //   227: iand
    //   228: sipush #128
    //   231: ior
    //   232: i2b
    //   233: invokestatic zza : (JB)V
    //   236: lload #5
    //   238: lload #11
    //   240: ladd
    //   241: lstore #5
    //   243: goto -> 172
    //   246: iload #16
    //   248: ldc 55296
    //   250: if_icmplt -> 260
    //   253: ldc 57343
    //   255: iload #16
    //   257: if_icmpge -> 346
    //   260: lload #14
    //   262: lload #7
    //   264: ldc2_w 3
    //   267: lsub
    //   268: lcmp
    //   269: ifgt -> 346
    //   272: lload #14
    //   274: lload #11
    //   276: ladd
    //   277: lstore #5
    //   279: lload #14
    //   281: iload #16
    //   283: bipush #12
    //   285: iushr
    //   286: sipush #480
    //   289: ior
    //   290: i2b
    //   291: invokestatic zza : (JB)V
    //   294: lload #5
    //   296: lload #11
    //   298: ladd
    //   299: lstore #14
    //   301: lload #5
    //   303: iload #16
    //   305: bipush #6
    //   307: iushr
    //   308: bipush #63
    //   310: iand
    //   311: sipush #128
    //   314: ior
    //   315: i2b
    //   316: invokestatic zza : (JB)V
    //   319: lload #14
    //   321: iload #16
    //   323: bipush #63
    //   325: iand
    //   326: sipush #128
    //   329: ior
    //   330: i2b
    //   331: invokestatic zza : (JB)V
    //   334: lload #14
    //   336: lconst_1
    //   337: ladd
    //   338: lstore #5
    //   340: lconst_1
    //   341: lstore #14
    //   343: goto -> 176
    //   346: lload #14
    //   348: lload #7
    //   350: ldc2_w 4
    //   353: lsub
    //   354: lcmp
    //   355: ifgt -> 529
    //   358: iload #13
    //   360: iconst_1
    //   361: iadd
    //   362: istore #10
    //   364: iload #10
    //   366: iload #9
    //   368: if_icmpeq -> 515
    //   371: aload_1
    //   372: iload #10
    //   374: invokeinterface charAt : (I)C
    //   379: istore #17
    //   381: iload #16
    //   383: iload #17
    //   385: invokestatic isSurrogatePair : (CC)Z
    //   388: ifeq -> 511
    //   391: iload #16
    //   393: iload #17
    //   395: invokestatic toCodePoint : (CC)I
    //   398: istore #13
    //   400: lload #14
    //   402: lconst_1
    //   403: ladd
    //   404: lstore #11
    //   406: lload #14
    //   408: iload #13
    //   410: bipush #18
    //   412: iushr
    //   413: sipush #240
    //   416: ior
    //   417: i2b
    //   418: invokestatic zza : (JB)V
    //   421: lload #11
    //   423: lconst_1
    //   424: ladd
    //   425: lstore #5
    //   427: lload #11
    //   429: iload #13
    //   431: bipush #12
    //   433: iushr
    //   434: bipush #63
    //   436: iand
    //   437: sipush #128
    //   440: ior
    //   441: i2b
    //   442: invokestatic zza : (JB)V
    //   445: lload #5
    //   447: lconst_1
    //   448: ladd
    //   449: lstore #11
    //   451: lload #5
    //   453: iload #13
    //   455: bipush #6
    //   457: iushr
    //   458: bipush #63
    //   460: iand
    //   461: sipush #128
    //   464: ior
    //   465: i2b
    //   466: invokestatic zza : (JB)V
    //   469: lconst_1
    //   470: lstore #14
    //   472: lload #11
    //   474: iload #13
    //   476: bipush #63
    //   478: iand
    //   479: sipush #128
    //   482: ior
    //   483: i2b
    //   484: invokestatic zza : (JB)V
    //   487: iload #10
    //   489: istore #13
    //   491: lload #11
    //   493: lconst_1
    //   494: ladd
    //   495: lstore #5
    //   497: iinc #13, 1
    //   500: lload #14
    //   502: lstore #11
    //   504: lload #5
    //   506: lstore #14
    //   508: goto -> 120
    //   511: iload #10
    //   513: istore #13
    //   515: new com/google/android/gms/internal/clearcut/zzfi
    //   518: dup
    //   519: iload #13
    //   521: iconst_1
    //   522: isub
    //   523: iload #9
    //   525: invokespecial <init> : (II)V
    //   528: athrow
    //   529: ldc 55296
    //   531: iload #16
    //   533: if_icmpgt -> 584
    //   536: iload #16
    //   538: ldc 57343
    //   540: if_icmpgt -> 584
    //   543: iload #13
    //   545: iconst_1
    //   546: iadd
    //   547: istore #10
    //   549: iload #10
    //   551: iload #9
    //   553: if_icmpeq -> 572
    //   556: iload #16
    //   558: aload_1
    //   559: iload #10
    //   561: invokeinterface charAt : (I)C
    //   566: invokestatic isSurrogatePair : (CC)Z
    //   569: ifne -> 584
    //   572: new com/google/android/gms/internal/clearcut/zzfi
    //   575: dup
    //   576: iload #13
    //   578: iload #9
    //   580: invokespecial <init> : (II)V
    //   583: athrow
    //   584: new java/lang/StringBuilder
    //   587: dup
    //   588: bipush #46
    //   590: invokespecial <init> : (I)V
    //   593: astore_1
    //   594: aload_1
    //   595: ldc 'Failed writing '
    //   597: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload_1
    //   602: iload #16
    //   604: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload_1
    //   609: ldc ' at index '
    //   611: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload_1
    //   616: lload #14
    //   618: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: new java/lang/ArrayIndexOutOfBoundsException
    //   625: dup
    //   626: aload_1
    //   627: invokevirtual toString : ()Ljava/lang/String;
    //   630: invokespecial <init> : (Ljava/lang/String;)V
    //   633: athrow
    //   634: aload_1
    //   635: iload #9
    //   637: iconst_1
    //   638: isub
    //   639: invokeinterface charAt : (I)C
    //   644: istore #16
    //   646: aload_2
    //   647: invokevirtual limit : ()I
    //   650: istore #13
    //   652: new java/lang/StringBuilder
    //   655: dup
    //   656: bipush #37
    //   658: invokespecial <init> : (I)V
    //   661: astore_1
    //   662: aload_1
    //   663: ldc 'Failed writing '
    //   665: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload_1
    //   670: iload #16
    //   672: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: aload_1
    //   677: ldc ' at index '
    //   679: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload_1
    //   684: iload #13
    //   686: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   689: pop
    //   690: new java/lang/ArrayIndexOutOfBoundsException
    //   693: dup
    //   694: aload_1
    //   695: invokevirtual toString : ()Ljava/lang/String;
    //   698: invokespecial <init> : (Ljava/lang/String;)V
    //   701: athrow
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzfj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */