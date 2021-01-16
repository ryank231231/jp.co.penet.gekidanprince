package com.google.protobuf;

import java.nio.ByteBuffer;

final class Utf8 {
  private static final long ASCII_MASK_LONG = -9187201950435737472L;
  
  public static final int COMPLETE = 0;
  
  public static final int MALFORMED = -1;
  
  static final int MAX_BYTES_PER_CHAR = 3;
  
  private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
  
  private static final Processor processor;
  
  static {
    SafeProcessor safeProcessor;
    if (UnsafeProcessor.isAvailable()) {
      UnsafeProcessor unsafeProcessor = new UnsafeProcessor();
    } else {
      safeProcessor = new SafeProcessor();
    } 
    processor = safeProcessor;
  }
  
  static int encode(CharSequence paramCharSequence, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return processor.encodeUtf8(paramCharSequence, paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  static void encodeUtf8(CharSequence paramCharSequence, ByteBuffer paramByteBuffer) {
    processor.encodeUtf8(paramCharSequence, paramByteBuffer);
  }
  
  static int encodedLength(CharSequence paramCharSequence) {
    int k;
    int i = paramCharSequence.length();
    byte b;
    for (b = 0; b < i && paramCharSequence.charAt(b) < ''; b++);
    int j = i;
    while (true) {
      k = j;
      if (b < i) {
        k = paramCharSequence.charAt(b);
        if (k < 2048) {
          j += 127 - k >>> 31;
          b++;
          continue;
        } 
        k = j + encodedLengthGeneral(paramCharSequence, b);
      } 
      break;
    } 
    if (k >= i)
      return k; 
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("UTF-8 length does not fit in int: ");
    paramCharSequence.append(k + 4294967296L);
    throw new IllegalArgumentException(paramCharSequence.toString());
  }
  
  private static int encodedLengthGeneral(CharSequence paramCharSequence, int paramInt) {
    int i = paramCharSequence.length();
    int j = 0;
    while (paramInt < i) {
      int k;
      char c = paramCharSequence.charAt(paramInt);
      if (c < 'ࠀ') {
        j += 127 - c >>> 31;
        k = paramInt;
      } else {
        int m = j + 2;
        j = m;
        k = paramInt;
        if ('?' <= c) {
          j = m;
          k = paramInt;
          if (c <= '?')
            if (Character.codePointAt(paramCharSequence, paramInt) >= 65536) {
              k = paramInt + 1;
              j = m;
            } else {
              throw new UnpairedSurrogateException(paramInt, i);
            }  
        } 
      } 
      paramInt = k + 1;
    } 
    return j;
  }
  
  private static int estimateConsecutiveAscii(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
    int i;
    for (i = paramInt1; i < paramInt2 - 7 && (paramByteBuffer.getLong(i) & 0x8080808080808080L) == 0L; i += 8);
    return i - paramInt1;
  }
  
  private static int incompleteStateFor(int paramInt) {
    int i = paramInt;
    if (paramInt > -12)
      i = -1; 
    return i;
  }
  
  private static int incompleteStateFor(int paramInt1, int paramInt2) {
    if (paramInt1 > -12 || paramInt2 > -65)
      return -1; 
    paramInt1 ^= paramInt2 << 8;
    return paramInt1;
  }
  
  private static int incompleteStateFor(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt1 > -12 || paramInt2 > -65 || paramInt3 > -65) ? -1 : (paramInt1 ^ paramInt2 << 8 ^ paramInt3 << 16);
  }
  
  private static int incompleteStateFor(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3) {
    switch (paramInt3) {
      default:
        throw new AssertionError();
      case 2:
        return incompleteStateFor(paramInt1, paramByteBuffer.get(paramInt2), paramByteBuffer.get(paramInt2 + 1));
      case 1:
        return incompleteStateFor(paramInt1, paramByteBuffer.get(paramInt2));
      case 0:
        break;
    } 
    return incompleteStateFor(paramInt1);
  }
  
  private static int incompleteStateFor(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    byte b = paramArrayOfbyte[paramInt1 - 1];
    switch (paramInt2 - paramInt1) {
      default:
        throw new AssertionError();
      case 2:
        return incompleteStateFor(b, paramArrayOfbyte[paramInt1], paramArrayOfbyte[paramInt1 + 1]);
      case 1:
        return incompleteStateFor(b, paramArrayOfbyte[paramInt1]);
      case 0:
        break;
    } 
    return incompleteStateFor(b);
  }
  
  static boolean isValidUtf8(ByteBuffer paramByteBuffer) {
    return processor.isValidUtf8(paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining());
  }
  
  public static boolean isValidUtf8(byte[] paramArrayOfbyte) {
    return processor.isValidUtf8(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static boolean isValidUtf8(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return processor.isValidUtf8(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  static int partialIsValidUtf8(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3) {
    return processor.partialIsValidUtf8(paramInt1, paramByteBuffer, paramInt2, paramInt3);
  }
  
  public static int partialIsValidUtf8(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
    return processor.partialIsValidUtf8(paramInt1, paramArrayOfbyte, paramInt2, paramInt3);
  }
  
  static abstract class Processor {
    private static int partialIsValidUtf8(ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2) {
      for (param1Int1 += Utf8.estimateConsecutiveAscii(param1ByteBuffer, param1Int1, param1Int2);; param1Int1 = i) {
        if (param1Int1 >= param1Int2)
          return 0; 
        int i = param1Int1 + 1;
        param1Int1 = param1ByteBuffer.get(param1Int1);
        if (param1Int1 < 0) {
          if (param1Int1 < -32) {
            if (i >= param1Int2)
              return param1Int1; 
            if (param1Int1 < -62 || param1ByteBuffer.get(i) > -65)
              return -1; 
            param1Int1 = i + 1;
            continue;
          } 
          if (param1Int1 < -16) {
            if (i >= param1Int2 - 1)
              return Utf8.incompleteStateFor(param1ByteBuffer, param1Int1, i, param1Int2 - i); 
            int k = i + 1;
            i = param1ByteBuffer.get(i);
            if (i > -65 || (param1Int1 == -32 && i < -96) || (param1Int1 == -19 && i >= -96) || param1ByteBuffer.get(k) > -65)
              return -1; 
            param1Int1 = k + 1;
            continue;
          } 
          if (i >= param1Int2 - 2)
            return Utf8.incompleteStateFor(param1ByteBuffer, param1Int1, i, param1Int2 - i); 
          int j = i + 1;
          i = param1ByteBuffer.get(i);
          if (i <= -65 && (param1Int1 << 28) + i + 112 >> 30 == 0) {
            param1Int1 = j + 1;
            if (param1ByteBuffer.get(j) <= -65 && param1ByteBuffer.get(param1Int1) <= -65) {
              param1Int1++;
              continue;
            } 
          } 
          return -1;
        } 
      } 
    }
    
    abstract int encodeUtf8(CharSequence param1CharSequence, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2);
    
    final void encodeUtf8(CharSequence param1CharSequence, ByteBuffer param1ByteBuffer) {
      if (param1ByteBuffer.hasArray()) {
        int i = param1ByteBuffer.arrayOffset();
        param1ByteBuffer.position(Utf8.encode(param1CharSequence, param1ByteBuffer.array(), param1ByteBuffer.position() + i, param1ByteBuffer.remaining()) - i);
      } else if (param1ByteBuffer.isDirect()) {
        encodeUtf8Direct(param1CharSequence, param1ByteBuffer);
      } else {
        encodeUtf8Default(param1CharSequence, param1ByteBuffer);
      } 
    }
    
    final void encodeUtf8Default(CharSequence param1CharSequence, ByteBuffer param1ByteBuffer) {
      // Byte code:
      //   0: aload_1
      //   1: invokeinterface length : ()I
      //   6: istore_3
      //   7: aload_2
      //   8: invokevirtual position : ()I
      //   11: istore #4
      //   13: iconst_0
      //   14: istore #5
      //   16: iload #5
      //   18: iload_3
      //   19: if_icmpge -> 75
      //   22: iload #4
      //   24: istore #6
      //   26: iload #5
      //   28: istore #7
      //   30: aload_1
      //   31: iload #5
      //   33: invokeinterface charAt : (I)C
      //   38: istore #8
      //   40: iload #8
      //   42: sipush #128
      //   45: if_icmpge -> 75
      //   48: iload #4
      //   50: istore #6
      //   52: iload #5
      //   54: istore #7
      //   56: aload_2
      //   57: iload #4
      //   59: iload #5
      //   61: iadd
      //   62: iload #8
      //   64: i2b
      //   65: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   68: pop
      //   69: iinc #5, 1
      //   72: goto -> 16
      //   75: iload #5
      //   77: iload_3
      //   78: if_icmpne -> 100
      //   81: iload #4
      //   83: istore #6
      //   85: iload #5
      //   87: istore #7
      //   89: aload_2
      //   90: iload #4
      //   92: iload #5
      //   94: iadd
      //   95: invokevirtual position : (I)Ljava/nio/Buffer;
      //   98: pop
      //   99: return
      //   100: iload #4
      //   102: iload #5
      //   104: iadd
      //   105: istore #4
      //   107: iload #5
      //   109: iload_3
      //   110: if_icmpge -> 599
      //   113: iload #4
      //   115: istore #6
      //   117: iload #5
      //   119: istore #7
      //   121: aload_1
      //   122: iload #5
      //   124: invokeinterface charAt : (I)C
      //   129: istore #9
      //   131: iload #9
      //   133: sipush #128
      //   136: if_icmpge -> 160
      //   139: iload #4
      //   141: istore #6
      //   143: iload #5
      //   145: istore #7
      //   147: aload_2
      //   148: iload #4
      //   150: iload #9
      //   152: i2b
      //   153: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   156: pop
      //   157: goto -> 590
      //   160: iload #9
      //   162: sipush #2048
      //   165: if_icmpge -> 236
      //   168: iload #4
      //   170: iconst_1
      //   171: iadd
      //   172: istore #6
      //   174: iload #9
      //   176: bipush #6
      //   178: iushr
      //   179: sipush #192
      //   182: ior
      //   183: i2b
      //   184: istore #10
      //   186: iload #6
      //   188: istore #7
      //   190: aload_2
      //   191: iload #4
      //   193: iload #10
      //   195: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   198: pop
      //   199: iload #6
      //   201: istore #7
      //   203: aload_2
      //   204: iload #6
      //   206: iload #9
      //   208: bipush #63
      //   210: iand
      //   211: sipush #128
      //   214: ior
      //   215: i2b
      //   216: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   219: pop
      //   220: iload #6
      //   222: istore #4
      //   224: goto -> 590
      //   227: astore #11
      //   229: iload #7
      //   231: istore #6
      //   233: goto -> 615
      //   236: iload #9
      //   238: ldc 55296
      //   240: if_icmplt -> 496
      //   243: ldc 57343
      //   245: iload #9
      //   247: if_icmpge -> 253
      //   250: goto -> 496
      //   253: iload #5
      //   255: iconst_1
      //   256: iadd
      //   257: istore #7
      //   259: iload #7
      //   261: iload_3
      //   262: if_icmpeq -> 456
      //   265: iload #4
      //   267: istore #5
      //   269: aload_1
      //   270: iload #7
      //   272: invokeinterface charAt : (I)C
      //   277: istore #12
      //   279: iload #4
      //   281: istore #5
      //   283: iload #9
      //   285: iload #12
      //   287: invokestatic isSurrogatePair : (CC)Z
      //   290: ifeq -> 438
      //   293: iload #4
      //   295: istore #5
      //   297: iload #9
      //   299: iload #12
      //   301: invokestatic toCodePoint : (CC)I
      //   304: istore #13
      //   306: iload #4
      //   308: iconst_1
      //   309: iadd
      //   310: istore #8
      //   312: iload #13
      //   314: bipush #18
      //   316: iushr
      //   317: sipush #240
      //   320: ior
      //   321: i2b
      //   322: istore #10
      //   324: iload #8
      //   326: istore #5
      //   328: aload_2
      //   329: iload #4
      //   331: iload #10
      //   333: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   336: pop
      //   337: iload #8
      //   339: iconst_1
      //   340: iadd
      //   341: istore #6
      //   343: iload #13
      //   345: bipush #12
      //   347: iushr
      //   348: bipush #63
      //   350: iand
      //   351: sipush #128
      //   354: ior
      //   355: i2b
      //   356: istore #10
      //   358: iload #6
      //   360: istore #5
      //   362: aload_2
      //   363: iload #8
      //   365: iload #10
      //   367: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   370: pop
      //   371: iload #6
      //   373: iconst_1
      //   374: iadd
      //   375: istore #4
      //   377: iload #13
      //   379: bipush #6
      //   381: iushr
      //   382: bipush #63
      //   384: iand
      //   385: sipush #128
      //   388: ior
      //   389: i2b
      //   390: istore #10
      //   392: iload #4
      //   394: istore #5
      //   396: aload_2
      //   397: iload #6
      //   399: iload #10
      //   401: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   404: pop
      //   405: iload #4
      //   407: istore #5
      //   409: aload_2
      //   410: iload #4
      //   412: iload #13
      //   414: bipush #63
      //   416: iand
      //   417: sipush #128
      //   420: ior
      //   421: i2b
      //   422: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   425: pop
      //   426: iload #7
      //   428: istore #5
      //   430: goto -> 590
      //   433: astore #11
      //   435: goto -> 445
      //   438: iload #7
      //   440: istore #5
      //   442: goto -> 456
      //   445: iload #5
      //   447: istore #6
      //   449: iload #7
      //   451: istore #5
      //   453: goto -> 615
      //   456: iload #4
      //   458: istore #6
      //   460: iload #5
      //   462: istore #7
      //   464: new com/google/protobuf/Utf8$UnpairedSurrogateException
      //   467: astore #11
      //   469: iload #4
      //   471: istore #6
      //   473: iload #5
      //   475: istore #7
      //   477: aload #11
      //   479: iload #5
      //   481: iload_3
      //   482: invokespecial <init> : (II)V
      //   485: iload #4
      //   487: istore #6
      //   489: iload #5
      //   491: istore #7
      //   493: aload #11
      //   495: athrow
      //   496: iload #4
      //   498: iconst_1
      //   499: iadd
      //   500: istore #8
      //   502: iload #9
      //   504: bipush #12
      //   506: iushr
      //   507: sipush #224
      //   510: ior
      //   511: i2b
      //   512: istore #10
      //   514: iload #8
      //   516: istore #7
      //   518: aload_2
      //   519: iload #4
      //   521: iload #10
      //   523: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   526: pop
      //   527: iload #8
      //   529: iconst_1
      //   530: iadd
      //   531: istore #4
      //   533: iload #9
      //   535: bipush #6
      //   537: iushr
      //   538: bipush #63
      //   540: iand
      //   541: sipush #128
      //   544: ior
      //   545: i2b
      //   546: istore #10
      //   548: iload #4
      //   550: istore #6
      //   552: iload #5
      //   554: istore #7
      //   556: aload_2
      //   557: iload #8
      //   559: iload #10
      //   561: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   564: pop
      //   565: iload #4
      //   567: istore #6
      //   569: iload #5
      //   571: istore #7
      //   573: aload_2
      //   574: iload #4
      //   576: iload #9
      //   578: bipush #63
      //   580: iand
      //   581: sipush #128
      //   584: ior
      //   585: i2b
      //   586: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   589: pop
      //   590: iinc #5, 1
      //   593: iinc #4, 1
      //   596: goto -> 107
      //   599: iload #4
      //   601: istore #6
      //   603: iload #5
      //   605: istore #7
      //   607: aload_2
      //   608: iload #4
      //   610: invokevirtual position : (I)Ljava/nio/Buffer;
      //   613: pop
      //   614: return
      //   615: aload_2
      //   616: invokevirtual position : ()I
      //   619: istore #4
      //   621: iload #5
      //   623: iload #6
      //   625: aload_2
      //   626: invokevirtual position : ()I
      //   629: isub
      //   630: iconst_1
      //   631: iadd
      //   632: invokestatic max : (II)I
      //   635: istore #7
      //   637: new java/lang/StringBuilder
      //   640: dup
      //   641: invokespecial <init> : ()V
      //   644: astore_2
      //   645: aload_2
      //   646: ldc 'Failed writing '
      //   648: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   651: pop
      //   652: aload_2
      //   653: aload_1
      //   654: iload #5
      //   656: invokeinterface charAt : (I)C
      //   661: invokevirtual append : (C)Ljava/lang/StringBuilder;
      //   664: pop
      //   665: aload_2
      //   666: ldc ' at index '
      //   668: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   671: pop
      //   672: aload_2
      //   673: iload #4
      //   675: iload #7
      //   677: iadd
      //   678: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   681: pop
      //   682: new java/lang/ArrayIndexOutOfBoundsException
      //   685: dup
      //   686: aload_2
      //   687: invokevirtual toString : ()Ljava/lang/String;
      //   690: invokespecial <init> : (Ljava/lang/String;)V
      //   693: athrow
      //   694: astore #11
      //   696: iload #7
      //   698: istore #5
      //   700: goto -> 615
      //   703: astore #11
      //   705: goto -> 445
      // Exception table:
      //   from	to	target	type
      //   30	40	694	java/lang/IndexOutOfBoundsException
      //   56	69	694	java/lang/IndexOutOfBoundsException
      //   89	99	694	java/lang/IndexOutOfBoundsException
      //   121	131	694	java/lang/IndexOutOfBoundsException
      //   147	157	694	java/lang/IndexOutOfBoundsException
      //   190	199	227	java/lang/IndexOutOfBoundsException
      //   203	220	227	java/lang/IndexOutOfBoundsException
      //   269	279	703	java/lang/IndexOutOfBoundsException
      //   283	293	703	java/lang/IndexOutOfBoundsException
      //   297	306	703	java/lang/IndexOutOfBoundsException
      //   328	337	433	java/lang/IndexOutOfBoundsException
      //   362	371	703	java/lang/IndexOutOfBoundsException
      //   396	405	433	java/lang/IndexOutOfBoundsException
      //   409	426	433	java/lang/IndexOutOfBoundsException
      //   464	469	694	java/lang/IndexOutOfBoundsException
      //   477	485	694	java/lang/IndexOutOfBoundsException
      //   493	496	694	java/lang/IndexOutOfBoundsException
      //   518	527	227	java/lang/IndexOutOfBoundsException
      //   556	565	694	java/lang/IndexOutOfBoundsException
      //   573	590	694	java/lang/IndexOutOfBoundsException
      //   607	614	694	java/lang/IndexOutOfBoundsException
    }
    
    abstract void encodeUtf8Direct(CharSequence param1CharSequence, ByteBuffer param1ByteBuffer);
    
    final boolean isValidUtf8(ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2) {
      boolean bool = false;
      if (partialIsValidUtf8(0, param1ByteBuffer, param1Int1, param1Int2) == 0)
        bool = true; 
      return bool;
    }
    
    final boolean isValidUtf8(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      boolean bool = false;
      if (partialIsValidUtf8(0, param1ArrayOfbyte, param1Int1, param1Int2) == 0)
        bool = true; 
      return bool;
    }
    
    final int partialIsValidUtf8(int param1Int1, ByteBuffer param1ByteBuffer, int param1Int2, int param1Int3) {
      if (param1ByteBuffer.hasArray()) {
        int i = param1ByteBuffer.arrayOffset();
        return partialIsValidUtf8(param1Int1, param1ByteBuffer.array(), param1Int2 + i, i + param1Int3);
      } 
      return param1ByteBuffer.isDirect() ? partialIsValidUtf8Direct(param1Int1, param1ByteBuffer, param1Int2, param1Int3) : partialIsValidUtf8Default(param1Int1, param1ByteBuffer, param1Int2, param1Int3);
    }
    
    abstract int partialIsValidUtf8(int param1Int1, byte[] param1ArrayOfbyte, int param1Int2, int param1Int3);
    
    final int partialIsValidUtf8Default(int param1Int1, ByteBuffer param1ByteBuffer, int param1Int2, int param1Int3) {
      if (param1Int1 != 0) {
        if (param1Int2 >= param1Int3)
          return param1Int1; 
        byte b = (byte)param1Int1;
        if (b < -32) {
          if (b >= -62) {
            param1Int1 = param1Int2 + 1;
            if (param1ByteBuffer.get(param1Int2) > -65)
              return -1; 
          } else {
            return -1;
          } 
        } else if (b < -16) {
          byte b1 = (byte)(param1Int1 >> 8 ^ 0xFFFFFFFF);
          param1Int1 = b1;
          int i = param1Int2;
          if (b1 == 0) {
            i = param1Int2 + 1;
            param1Int1 = param1ByteBuffer.get(param1Int2);
            if (i >= param1Int3)
              return Utf8.incompleteStateFor(b, param1Int1); 
          } 
          if (param1Int1 <= -65 && (b != -32 || param1Int1 >= -96) && (b != -19 || param1Int1 < -96)) {
            param1Int1 = i + 1;
            if (param1ByteBuffer.get(i) > -65)
              return -1; 
          } else {
            return -1;
          } 
        } else {
          byte b1 = (byte)(param1Int1 >> 8 ^ 0xFFFFFFFF);
          int i = 0;
          if (b1 == 0) {
            int k = param1Int2 + 1;
            byte b2 = param1ByteBuffer.get(param1Int2);
            b1 = b2;
            param1Int2 = i;
            param1Int1 = k;
            if (k >= param1Int3)
              return Utf8.incompleteStateFor(b, b2); 
          } else {
            i = (byte)(param1Int1 >> 16);
            param1Int1 = param1Int2;
            param1Int2 = i;
          } 
          int j = param1Int2;
          i = param1Int1;
          if (param1Int2 == 0) {
            i = param1Int1 + 1;
            j = param1ByteBuffer.get(param1Int1);
            if (i >= param1Int3)
              return Utf8.incompleteStateFor(b, b1, j); 
          } 
          if (b1 > -65 || (b << 28) + b1 + 112 >> 30 != 0 || j > -65 || param1ByteBuffer.get(i) > -65)
            return -1; 
          param1Int1 = i + 1;
        } 
      } else {
        param1Int1 = param1Int2;
      } 
      return partialIsValidUtf8(param1ByteBuffer, param1Int1, param1Int3);
    }
    
    abstract int partialIsValidUtf8Direct(int param1Int1, ByteBuffer param1ByteBuffer, int param1Int2, int param1Int3);
  }
  
  static final class SafeProcessor extends Processor {
    private static int partialIsValidUtf8(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      while (param1Int1 < param1Int2 && param1ArrayOfbyte[param1Int1] >= 0)
        param1Int1++; 
      if (param1Int1 >= param1Int2) {
        param1Int1 = 0;
      } else {
        param1Int1 = partialIsValidUtf8NonAscii(param1ArrayOfbyte, param1Int1, param1Int2);
      } 
      return param1Int1;
    }
    
    private static int partialIsValidUtf8NonAscii(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      while (true) {
        if (param1Int1 >= param1Int2)
          return 0; 
        int i = param1Int1 + 1;
        param1Int1 = param1ArrayOfbyte[param1Int1];
        if (param1Int1 < 0) {
          if (param1Int1 < -32) {
            if (i >= param1Int2)
              return param1Int1; 
            if (param1Int1 >= -62) {
              param1Int1 = i + 1;
              if (param1ArrayOfbyte[i] > -65)
                return -1; 
              continue;
            } 
            return -1;
          } 
          if (param1Int1 < -16) {
            if (i >= param1Int2 - 1)
              return Utf8.incompleteStateFor(param1ArrayOfbyte, i, param1Int2); 
            int k = i + 1;
            i = param1ArrayOfbyte[i];
            if (i <= -65 && (param1Int1 != -32 || i >= -96) && (param1Int1 != -19 || i < -96)) {
              param1Int1 = k + 1;
              if (param1ArrayOfbyte[k] > -65)
                return -1; 
              continue;
            } 
            return -1;
          } 
          if (i >= param1Int2 - 2)
            return Utf8.incompleteStateFor(param1ArrayOfbyte, i, param1Int2); 
          int j = i + 1;
          i = param1ArrayOfbyte[i];
          if (i <= -65 && (param1Int1 << 28) + i + 112 >> 30 == 0) {
            param1Int1 = j + 1;
            if (param1ArrayOfbyte[j] <= -65 && param1ArrayOfbyte[param1Int1] <= -65) {
              param1Int1++;
              continue;
            } 
          } 
          return -1;
        } 
        param1Int1 = i;
      } 
    }
    
    int encodeUtf8(CharSequence param1CharSequence, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      int i = param1CharSequence.length();
      int j = param1Int2 + param1Int1;
      param1Int2 = 0;
      while (param1Int2 < i) {
        int k = param1Int2 + param1Int1;
        if (k < j) {
          char c = param1CharSequence.charAt(param1Int2);
          if (c < '') {
            param1ArrayOfbyte[k] = (byte)(byte)c;
            param1Int2++;
          } 
        } 
      } 
      if (param1Int2 == i)
        return param1Int1 + i; 
      param1Int1 += param1Int2;
      while (param1Int2 < i) {
        char c = param1CharSequence.charAt(param1Int2);
        if (c < '' && param1Int1 < j) {
          param1ArrayOfbyte[param1Int1] = (byte)(byte)c;
          param1Int1++;
        } else if (c < 'ࠀ' && param1Int1 <= j - 2) {
          int k = param1Int1 + 1;
          param1ArrayOfbyte[param1Int1] = (byte)(byte)(c >>> 6 | 0x3C0);
          param1Int1 = k + 1;
          param1ArrayOfbyte[k] = (byte)(byte)(c & 0x3F | 0x80);
        } else if ((c < '?' || '?' < c) && param1Int1 <= j - 3) {
          int k = param1Int1 + 1;
          param1ArrayOfbyte[param1Int1] = (byte)(byte)(c >>> 12 | 0x1E0);
          param1Int1 = k + 1;
          param1ArrayOfbyte[k] = (byte)(byte)(c >>> 6 & 0x3F | 0x80);
          param1ArrayOfbyte[param1Int1] = (byte)(byte)(c & 0x3F | 0x80);
          param1Int1++;
        } else if (param1Int1 <= j - 4) {
          int k = param1Int2 + 1;
          if (k != param1CharSequence.length()) {
            char c1 = param1CharSequence.charAt(k);
            if (Character.isSurrogatePair(c, c1)) {
              param1Int2 = Character.toCodePoint(c, c1);
              int m = param1Int1 + 1;
              param1ArrayOfbyte[param1Int1] = (byte)(byte)(param1Int2 >>> 18 | 0xF0);
              param1Int1 = m + 1;
              param1ArrayOfbyte[m] = (byte)(byte)(param1Int2 >>> 12 & 0x3F | 0x80);
              m = param1Int1 + 1;
              param1ArrayOfbyte[param1Int1] = (byte)(byte)(param1Int2 >>> 6 & 0x3F | 0x80);
              param1Int1 = m + 1;
              param1ArrayOfbyte[m] = (byte)(byte)(param1Int2 & 0x3F | 0x80);
              param1Int2 = k;
            } else {
              param1Int2 = k;
              throw new Utf8.UnpairedSurrogateException(param1Int2 - 1, i);
            } 
          } else {
            throw new Utf8.UnpairedSurrogateException(param1Int2 - 1, i);
          } 
        } else {
          if ('?' <= c && c <= '?') {
            int k = param1Int2 + 1;
            if (k == param1CharSequence.length() || !Character.isSurrogatePair(c, param1CharSequence.charAt(k)))
              throw new Utf8.UnpairedSurrogateException(param1Int2, i); 
          } 
          param1CharSequence = new StringBuilder();
          param1CharSequence.append("Failed writing ");
          param1CharSequence.append(c);
          param1CharSequence.append(" at index ");
          param1CharSequence.append(param1Int1);
          throw new ArrayIndexOutOfBoundsException(param1CharSequence.toString());
        } 
        param1Int2++;
      } 
      return param1Int1;
    }
    
    void encodeUtf8Direct(CharSequence param1CharSequence, ByteBuffer param1ByteBuffer) {
      encodeUtf8Default(param1CharSequence, param1ByteBuffer);
    }
    
    int partialIsValidUtf8(int param1Int1, byte[] param1ArrayOfbyte, int param1Int2, int param1Int3) {
      if (param1Int1 != 0) {
        if (param1Int2 >= param1Int3)
          return param1Int1; 
        byte b = (byte)param1Int1;
        if (b < -32) {
          if (b >= -62) {
            param1Int1 = param1Int2 + 1;
            if (param1ArrayOfbyte[param1Int2] > -65)
              return -1; 
          } else {
            return -1;
          } 
        } else if (b < -16) {
          byte b1 = (byte)(param1Int1 >> 8 ^ 0xFFFFFFFF);
          param1Int1 = b1;
          int i = param1Int2;
          if (b1 == 0) {
            i = param1Int2 + 1;
            param1Int1 = param1ArrayOfbyte[param1Int2];
            if (i >= param1Int3)
              return Utf8.incompleteStateFor(b, param1Int1); 
          } 
          if (param1Int1 <= -65 && (b != -32 || param1Int1 >= -96) && (b != -19 || param1Int1 < -96)) {
            param1Int1 = i + 1;
            if (param1ArrayOfbyte[i] > -65)
              return -1; 
          } else {
            return -1;
          } 
        } else {
          byte b1 = (byte)(param1Int1 >> 8 ^ 0xFFFFFFFF);
          int j = 0;
          if (b1 == 0) {
            int k = param1Int2 + 1;
            byte b2 = param1ArrayOfbyte[param1Int2];
            b1 = b2;
            param1Int2 = j;
            param1Int1 = k;
            if (k >= param1Int3)
              return Utf8.incompleteStateFor(b, b2); 
          } else {
            byte b2 = (byte)(param1Int1 >> 16);
            param1Int1 = param1Int2;
            param1Int2 = b2;
          } 
          j = param1Int2;
          int i = param1Int1;
          if (param1Int2 == 0) {
            i = param1Int1 + 1;
            j = param1ArrayOfbyte[param1Int1];
            if (i >= param1Int3)
              return Utf8.incompleteStateFor(b, b1, j); 
          } 
          if (b1 > -65 || (b << 28) + b1 + 112 >> 30 != 0 || j > -65 || param1ArrayOfbyte[i] > -65)
            return -1; 
          param1Int1 = i + 1;
        } 
      } else {
        param1Int1 = param1Int2;
      } 
      return partialIsValidUtf8(param1ArrayOfbyte, param1Int1, param1Int3);
    }
    
    int partialIsValidUtf8Direct(int param1Int1, ByteBuffer param1ByteBuffer, int param1Int2, int param1Int3) {
      return partialIsValidUtf8Default(param1Int1, param1ByteBuffer, param1Int2, param1Int3);
    }
  }
  
  static class UnpairedSurrogateException extends IllegalArgumentException {
    UnpairedSurrogateException(int param1Int1, int param1Int2) {
      super(stringBuilder.toString());
    }
  }
  
  static final class UnsafeProcessor extends Processor {
    static boolean isAvailable() {
      boolean bool;
      if (UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations()) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    private static int partialIsValidUtf8(long param1Long, int param1Int) {
      int i = unsafeEstimateConsecutiveAscii(param1Long, param1Int);
      param1Long += i;
      param1Int -= i;
      while (true) {
        long l;
        byte b = 0;
        i = param1Int;
        param1Int = b;
        while (true) {
          l = param1Long;
          if (i > 0) {
            l = param1Long + 1L;
            param1Int = UnsafeUtil.getByte(param1Long);
            if (param1Int >= 0) {
              i--;
              param1Long = l;
              continue;
            } 
          } 
          break;
        } 
        if (i == 0)
          return 0; 
        i--;
        if (param1Int < -32) {
          if (i == 0)
            return param1Int; 
          i--;
          if (param1Int < -62 || UnsafeUtil.getByte(l) > -65)
            return -1; 
          param1Long = 1L + l;
          param1Int = i;
          continue;
        } 
        if (param1Int < -16) {
          if (i < 2)
            return unsafeIncompleteStateFor(l, param1Int, i); 
          i -= 2;
          param1Long = l + 1L;
          b = UnsafeUtil.getByte(l);
          if (b > -65 || (param1Int == -32 && b < -96) || (param1Int == -19 && b >= -96) || UnsafeUtil.getByte(param1Long) > -65)
            return -1; 
          param1Long = 1L + param1Long;
          param1Int = i;
          continue;
        } 
        if (i < 3)
          return unsafeIncompleteStateFor(l, param1Int, i); 
        i -= 3;
        param1Long = l + 1L;
        b = UnsafeUtil.getByte(l);
        if (b <= -65 && (param1Int << 28) + b + 112 >> 30 == 0) {
          l = param1Long + 1L;
          if (UnsafeUtil.getByte(param1Long) > -65 || UnsafeUtil.getByte(l) > -65)
            break; 
          param1Long = 1L + l;
          param1Int = i;
          continue;
        } 
        break;
      } 
      return -1;
    }
    
    private static int partialIsValidUtf8(byte[] param1ArrayOfbyte, long param1Long, int param1Int) {
      int i = unsafeEstimateConsecutiveAscii(param1ArrayOfbyte, param1Long, param1Int);
      param1Int -= i;
      param1Long += i;
      while (true) {
        long l;
        byte b = 0;
        i = param1Int;
        param1Int = b;
        while (true) {
          l = param1Long;
          if (i > 0) {
            l = param1Long + 1L;
            param1Int = UnsafeUtil.getByte(param1ArrayOfbyte, param1Long);
            if (param1Int >= 0) {
              i--;
              param1Long = l;
              continue;
            } 
          } 
          break;
        } 
        if (i == 0)
          return 0; 
        i--;
        if (param1Int < -32) {
          if (i == 0)
            return param1Int; 
          i--;
          if (param1Int < -62 || UnsafeUtil.getByte(param1ArrayOfbyte, l) > -65)
            return -1; 
          param1Long = 1L + l;
          param1Int = i;
          continue;
        } 
        if (param1Int < -16) {
          if (i < 2)
            return unsafeIncompleteStateFor(param1ArrayOfbyte, param1Int, l, i); 
          i -= 2;
          param1Long = l + 1L;
          b = UnsafeUtil.getByte(param1ArrayOfbyte, l);
          if (b > -65 || (param1Int == -32 && b < -96) || (param1Int == -19 && b >= -96) || UnsafeUtil.getByte(param1ArrayOfbyte, param1Long) > -65)
            return -1; 
          param1Long = 1L + param1Long;
          param1Int = i;
          continue;
        } 
        if (i < 3)
          return unsafeIncompleteStateFor(param1ArrayOfbyte, param1Int, l, i); 
        i -= 3;
        param1Long = l + 1L;
        b = UnsafeUtil.getByte(param1ArrayOfbyte, l);
        if (b <= -65 && (param1Int << 28) + b + 112 >> 30 == 0) {
          l = param1Long + 1L;
          if (UnsafeUtil.getByte(param1ArrayOfbyte, param1Long) > -65 || UnsafeUtil.getByte(param1ArrayOfbyte, l) > -65)
            break; 
          param1Long = 1L + l;
          param1Int = i;
          continue;
        } 
        break;
      } 
      return -1;
    }
    
    private static int unsafeEstimateConsecutiveAscii(long param1Long, int param1Int) {
      if (param1Int < 16)
        return 0; 
      int i = (int)param1Long & 0x7;
      int j = i;
      while (j > 0) {
        if (UnsafeUtil.getByte(param1Long) < 0)
          return i - j; 
        j--;
        param1Long = 1L + param1Long;
      } 
      for (j = param1Int - i; j >= 8 && (UnsafeUtil.getLong(param1Long) & 0x8080808080808080L) == 0L; j -= 8)
        param1Long += 8L; 
      return param1Int - j;
    }
    
    private static int unsafeEstimateConsecutiveAscii(byte[] param1ArrayOfbyte, long param1Long, int param1Int) {
      if (param1Int < 16)
        return 0; 
      int i = (int)param1Long & 0x7;
      int j = i;
      while (j > 0) {
        if (UnsafeUtil.getByte(param1ArrayOfbyte, param1Long) < 0)
          return i - j; 
        j--;
        param1Long = 1L + param1Long;
      } 
      for (j = param1Int - i; j >= 8 && (UnsafeUtil.getLong(param1ArrayOfbyte, param1Long) & 0x8080808080808080L) == 0L; j -= 8)
        param1Long += 8L; 
      return param1Int - j;
    }
    
    private static int unsafeIncompleteStateFor(long param1Long, int param1Int1, int param1Int2) {
      switch (param1Int2) {
        default:
          throw new AssertionError();
        case 2:
          return Utf8.incompleteStateFor(param1Int1, UnsafeUtil.getByte(param1Long), UnsafeUtil.getByte(param1Long + 1L));
        case 1:
          return Utf8.incompleteStateFor(param1Int1, UnsafeUtil.getByte(param1Long));
        case 0:
          break;
      } 
      return Utf8.incompleteStateFor(param1Int1);
    }
    
    private static int unsafeIncompleteStateFor(byte[] param1ArrayOfbyte, int param1Int1, long param1Long, int param1Int2) {
      switch (param1Int2) {
        default:
          throw new AssertionError();
        case 2:
          return Utf8.incompleteStateFor(param1Int1, UnsafeUtil.getByte(param1ArrayOfbyte, param1Long), UnsafeUtil.getByte(param1ArrayOfbyte, param1Long + 1L));
        case 1:
          return Utf8.incompleteStateFor(param1Int1, UnsafeUtil.getByte(param1ArrayOfbyte, param1Long));
        case 0:
          break;
      } 
      return Utf8.incompleteStateFor(param1Int1);
    }
    
    int encodeUtf8(CharSequence param1CharSequence, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      long l1 = UnsafeUtil.getArrayBaseOffset() + param1Int1;
      long l2 = param1Int2 + l1;
      int i = param1CharSequence.length();
      if (i <= param1Int2 && param1ArrayOfbyte.length - param1Int2 >= param1Int1) {
        param1Int2 = 0;
        while (param1Int2 < i) {
          param1Int1 = param1CharSequence.charAt(param1Int2);
          if (param1Int1 < 128) {
            UnsafeUtil.putByte(param1ArrayOfbyte, l1, (byte)param1Int1);
            param1Int2++;
            l1 = 1L + l1;
          } 
        } 
        param1Int1 = param1Int2;
        long l = l1;
        if (param1Int2 == i)
          return (int)(l1 - UnsafeUtil.getArrayBaseOffset()); 
        while (param1Int1 < i) {
          char c = param1CharSequence.charAt(param1Int1);
          if (c < '' && l < l2) {
            UnsafeUtil.putByte(param1ArrayOfbyte, l, (byte)c);
            l1 = l + 1L;
          } else if (c < 'ࠀ' && l <= l2 - 2L) {
            long l3 = l + 1L;
            UnsafeUtil.putByte(param1ArrayOfbyte, l, (byte)(c >>> 6 | 0x3C0));
            l1 = l3 + 1L;
            UnsafeUtil.putByte(param1ArrayOfbyte, l3, (byte)(c & 0x3F | 0x80));
          } else if ((c < '?' || '?' < c) && l <= l2 - 3L) {
            l1 = l + 1L;
            UnsafeUtil.putByte(param1ArrayOfbyte, l, (byte)(c >>> 12 | 0x1E0));
            l = l1 + 1L;
            UnsafeUtil.putByte(param1ArrayOfbyte, l1, (byte)(c >>> 6 & 0x3F | 0x80));
            UnsafeUtil.putByte(param1ArrayOfbyte, l, (byte)(c & 0x3F | 0x80));
            l1 = l + 1L;
          } else if (l <= l2 - 4L) {
            param1Int2 = param1Int1 + 1;
            if (param1Int2 != i) {
              char c1 = param1CharSequence.charAt(param1Int2);
              param1Int1 = param1Int2;
              if (Character.isSurrogatePair(c, c1)) {
                param1Int1 = Character.toCodePoint(c, c1);
                l1 = l + 1L;
                UnsafeUtil.putByte(param1ArrayOfbyte, l, (byte)(param1Int1 >>> 18 | 0xF0));
                long l3 = l1 + 1L;
                UnsafeUtil.putByte(param1ArrayOfbyte, l1, (byte)(param1Int1 >>> 12 & 0x3F | 0x80));
                l = l3 + 1L;
                UnsafeUtil.putByte(param1ArrayOfbyte, l3, (byte)(param1Int1 >>> 6 & 0x3F | 0x80));
                l1 = l + 1L;
                UnsafeUtil.putByte(param1ArrayOfbyte, l, (byte)(param1Int1 & 0x3F | 0x80));
                param1Int1 = param1Int2;
              } else {
                throw new Utf8.UnpairedSurrogateException(param1Int1 - 1, i);
              } 
            } else {
              throw new Utf8.UnpairedSurrogateException(param1Int1 - 1, i);
            } 
          } else {
            if ('?' <= c && c <= '?') {
              param1Int2 = param1Int1 + 1;
              if (param1Int2 == i || !Character.isSurrogatePair(c, param1CharSequence.charAt(param1Int2)))
                throw new Utf8.UnpairedSurrogateException(param1Int1, i); 
            } 
            param1CharSequence = new StringBuilder();
            param1CharSequence.append("Failed writing ");
            param1CharSequence.append(c);
            param1CharSequence.append(" at index ");
            param1CharSequence.append(l);
            throw new ArrayIndexOutOfBoundsException(param1CharSequence.toString());
          } 
          param1Int1++;
          l = l1;
        } 
        return (int)(l - UnsafeUtil.getArrayBaseOffset());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed writing ");
      stringBuilder.append(param1CharSequence.charAt(i - 1));
      stringBuilder.append(" at index ");
      stringBuilder.append(param1Int1 + param1Int2);
      throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
    }
    
    void encodeUtf8Direct(CharSequence param1CharSequence, ByteBuffer param1ByteBuffer) {
      long l1 = UnsafeUtil.addressOffset(param1ByteBuffer);
      long l2 = param1ByteBuffer.position() + l1;
      long l3 = param1ByteBuffer.limit() + l1;
      int i = param1CharSequence.length();
      if (i <= l3 - l2) {
        long l4;
        int j = 0;
        while (true) {
          l4 = 1L;
          if (j < i) {
            char c = param1CharSequence.charAt(j);
            if (c < '') {
              UnsafeUtil.putByte(l2, (byte)c);
              j++;
              l2 = 1L + l2;
              continue;
            } 
          } 
          break;
        } 
        long l5 = l2;
        int k = j;
        if (j == i) {
          param1ByteBuffer.position((int)(l2 - l1));
          return;
        } 
        while (k < i) {
          char c = param1CharSequence.charAt(k);
          if (c < '' && l5 < l3) {
            l2 = l5 + l4;
            UnsafeUtil.putByte(l5, (byte)c);
          } else if (c < 'ࠀ' && l5 <= l3 - 2L) {
            l2 = l5 + l4;
            UnsafeUtil.putByte(l5, (byte)(c >>> 6 | 0x3C0));
            UnsafeUtil.putByte(l2, (byte)(c & 0x3F | 0x80));
            l2 += l4;
          } else if ((c < '?' || '?' < c) && l5 <= l3 - 3L) {
            l2 = l5 + l4;
            UnsafeUtil.putByte(l5, (byte)(c >>> 12 | 0x1E0));
            l4 = l2 + l4;
            UnsafeUtil.putByte(l2, (byte)(c >>> 6 & 0x3F | 0x80));
            UnsafeUtil.putByte(l4, (byte)(c & 0x3F | 0x80));
            l2 = l4 + 1L;
            l4 = 1L;
          } else if (l5 <= l3 - 4L) {
            j = k + 1;
            if (j != i) {
              char c1 = param1CharSequence.charAt(j);
              if (Character.isSurrogatePair(c, c1)) {
                k = Character.toCodePoint(c, c1);
                l4 = l5 + 1L;
                UnsafeUtil.putByte(l5, (byte)(k >>> 18 | 0xF0));
                l2 = l4 + 1L;
                UnsafeUtil.putByte(l4, (byte)(k >>> 12 & 0x3F | 0x80));
                l5 = l2 + 1L;
                UnsafeUtil.putByte(l2, (byte)(k >>> 6 & 0x3F | 0x80));
                l4 = 1L;
                UnsafeUtil.putByte(l5, (byte)(k & 0x3F | 0x80));
                l2 = l5 + 1L;
                k = j;
              } else {
                k = j;
                throw new Utf8.UnpairedSurrogateException(k - 1, i);
              } 
            } else {
              throw new Utf8.UnpairedSurrogateException(k - 1, i);
            } 
          } else {
            if ('?' <= c && c <= '?') {
              j = k + 1;
              if (j == i || !Character.isSurrogatePair(c, param1CharSequence.charAt(j)))
                throw new Utf8.UnpairedSurrogateException(k, i); 
            } 
            param1CharSequence = new StringBuilder();
            param1CharSequence.append("Failed writing ");
            param1CharSequence.append(c);
            param1CharSequence.append(" at index ");
            param1CharSequence.append(l5);
            throw new ArrayIndexOutOfBoundsException(param1CharSequence.toString());
          } 
          k++;
          l5 = l2;
        } 
        param1ByteBuffer.position((int)(l5 - l1));
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed writing ");
      stringBuilder.append(param1CharSequence.charAt(i - 1));
      stringBuilder.append(" at index ");
      stringBuilder.append(param1ByteBuffer.limit());
      throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
    }
    
    int partialIsValidUtf8(int param1Int1, byte[] param1ArrayOfbyte, int param1Int2, int param1Int3) {
      int i = param1ArrayOfbyte.length;
      boolean bool = false;
      if ((param1Int2 | param1Int3 | i - param1Int3) >= 0) {
        long l3;
        long l1 = UnsafeUtil.getArrayBaseOffset() + param1Int2;
        long l2 = UnsafeUtil.getArrayBaseOffset() + param1Int3;
        if (param1Int1 != 0) {
          if (l1 >= l2)
            return param1Int1; 
          i = (byte)param1Int1;
          if (i < -32) {
            if (i >= -62) {
              l3 = l1 + 1L;
              if (UnsafeUtil.getByte(param1ArrayOfbyte, l1) > -65)
                return -1; 
            } else {
              return -1;
            } 
          } else if (i < -16) {
            param1Int2 = (byte)(param1Int1 >> 8 ^ 0xFFFFFFFF);
            long l = l1;
            param1Int1 = param1Int2;
            if (param1Int2 == 0) {
              l = l1 + 1L;
              param1Int1 = UnsafeUtil.getByte(param1ArrayOfbyte, l1);
              if (l >= l2)
                return Utf8.incompleteStateFor(i, param1Int1); 
            } 
            if (param1Int1 <= -65 && (i != -32 || param1Int1 >= -96) && (i != -19 || param1Int1 < -96)) {
              l3 = l + 1L;
              if (UnsafeUtil.getByte(param1ArrayOfbyte, l) > -65)
                return -1; 
            } else {
              return -1;
            } 
          } else {
            param1Int2 = (byte)(param1Int1 >> 8 ^ 0xFFFFFFFF);
            if (param1Int2 == 0) {
              l3 = l1 + 1L;
              param1Int2 = UnsafeUtil.getByte(param1ArrayOfbyte, l1);
              if (l3 >= l2)
                return Utf8.incompleteStateFor(i, param1Int2); 
              l1 = l3;
              param1Int1 = bool;
            } else {
              param1Int1 = (byte)(param1Int1 >> 16);
            } 
            param1Int3 = param1Int1;
            long l = l1;
            if (param1Int1 == 0) {
              l = l1 + 1L;
              param1Int3 = UnsafeUtil.getByte(param1ArrayOfbyte, l1);
              if (l >= l2)
                return Utf8.incompleteStateFor(i, param1Int2, param1Int3); 
            } 
            if (param1Int2 <= -65 && (i << 28) + param1Int2 + 112 >> 30 == 0 && param1Int3 <= -65) {
              l3 = l + 1L;
              if (UnsafeUtil.getByte(param1ArrayOfbyte, l) > -65)
                return -1; 
            } else {
              return -1;
            } 
          } 
        } else {
          l3 = l1;
        } 
        return partialIsValidUtf8(param1ArrayOfbyte, l3, (int)(l2 - l3));
      } 
      throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(param1ArrayOfbyte.length), Integer.valueOf(param1Int2), Integer.valueOf(param1Int3) }));
    }
    
    int partialIsValidUtf8Direct(int param1Int1, ByteBuffer param1ByteBuffer, int param1Int2, int param1Int3) {
      int i = param1ByteBuffer.limit();
      boolean bool = false;
      if ((param1Int2 | param1Int3 | i - param1Int3) >= 0) {
        long l3;
        long l1 = UnsafeUtil.addressOffset(param1ByteBuffer) + param1Int2;
        long l2 = (param1Int3 - param1Int2) + l1;
        if (param1Int1 != 0) {
          if (l1 >= l2)
            return param1Int1; 
          i = (byte)param1Int1;
          if (i < -32) {
            if (i >= -62) {
              l3 = l1 + 1L;
              if (UnsafeUtil.getByte(l1) > -65)
                return -1; 
            } else {
              return -1;
            } 
          } else if (i < -16) {
            param1Int2 = (byte)(param1Int1 >> 8 ^ 0xFFFFFFFF);
            long l = l1;
            param1Int1 = param1Int2;
            if (param1Int2 == 0) {
              l = l1 + 1L;
              param1Int1 = UnsafeUtil.getByte(l1);
              if (l >= l2)
                return Utf8.incompleteStateFor(i, param1Int1); 
            } 
            if (param1Int1 <= -65 && (i != -32 || param1Int1 >= -96) && (i != -19 || param1Int1 < -96)) {
              l3 = l + 1L;
              if (UnsafeUtil.getByte(l) > -65)
                return -1; 
            } else {
              return -1;
            } 
          } else {
            param1Int2 = (byte)(param1Int1 >> 8 ^ 0xFFFFFFFF);
            if (param1Int2 == 0) {
              l3 = l1 + 1L;
              param1Int2 = UnsafeUtil.getByte(l1);
              if (l3 >= l2)
                return Utf8.incompleteStateFor(i, param1Int2); 
              l1 = l3;
              param1Int1 = bool;
            } else {
              param1Int1 = (byte)(param1Int1 >> 16);
            } 
            param1Int3 = param1Int1;
            long l = l1;
            if (param1Int1 == 0) {
              l = l1 + 1L;
              param1Int3 = UnsafeUtil.getByte(l1);
              if (l >= l2)
                return Utf8.incompleteStateFor(i, param1Int2, param1Int3); 
            } 
            if (param1Int2 <= -65 && (i << 28) + param1Int2 + 112 >> 30 == 0 && param1Int3 <= -65) {
              l3 = l + 1L;
              if (UnsafeUtil.getByte(l) > -65)
                return -1; 
            } else {
              return -1;
            } 
          } 
        } else {
          l3 = l1;
        } 
        return partialIsValidUtf8(l3, (int)(l2 - l3));
      } 
      throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(param1ByteBuffer.limit()), Integer.valueOf(param1Int2), Integer.valueOf(param1Int3) }));
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\Utf8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */