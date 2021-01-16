package com.google.android.gms.internal.clearcut;

import java.lang.reflect.InvocationTargetException;

public final class zzga {
  public static <T extends zzfz> String zza(T paramT) {
    if (paramT == null)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer();
    try {
      StringBuffer stringBuffer1 = new StringBuffer();
      this();
      zza(null, paramT, stringBuffer1, stringBuffer);
      return stringBuffer.toString();
    } catch (IllegalAccessException illegalAccessException) {
      String str = String.valueOf(illegalAccessException.getMessage());
      return (str.length() != 0) ? "Error printing proto: ".concat(str) : new String("Error printing proto: ");
    } catch (InvocationTargetException invocationTargetException) {
      String str = String.valueOf(invocationTargetException.getMessage());
      return (str.length() != 0) ? "Error printing proto: ".concat(str) : new String("Error printing proto: ");
    } 
  }
  
  private static void zza(String paramString, Object paramObject, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2) throws IllegalAccessException, InvocationTargetException {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 820
    //   4: aload_1
    //   5: instanceof com/google/android/gms/internal/clearcut/zzfz
    //   8: ifeq -> 462
    //   11: aload_2
    //   12: invokevirtual length : ()I
    //   15: istore #4
    //   17: aload_0
    //   18: ifnull -> 50
    //   21: aload_3
    //   22: aload_2
    //   23: invokevirtual append : (Ljava/lang/StringBuffer;)Ljava/lang/StringBuffer;
    //   26: pop
    //   27: aload_3
    //   28: aload_0
    //   29: invokestatic zzl : (Ljava/lang/String;)Ljava/lang/String;
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   35: pop
    //   36: aload_3
    //   37: ldc ' <\\n'
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   42: pop
    //   43: aload_2
    //   44: ldc '  '
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   49: pop
    //   50: aload_1
    //   51: invokevirtual getClass : ()Ljava/lang/Class;
    //   54: astore #5
    //   56: aload #5
    //   58: invokevirtual getFields : ()[Ljava/lang/reflect/Field;
    //   61: astore #6
    //   63: aload #6
    //   65: arraylength
    //   66: istore #7
    //   68: iconst_0
    //   69: istore #8
    //   71: iload #8
    //   73: iload #7
    //   75: if_icmpge -> 244
    //   78: aload #6
    //   80: iload #8
    //   82: aaload
    //   83: astore #9
    //   85: aload #9
    //   87: invokevirtual getModifiers : ()I
    //   90: istore #10
    //   92: aload #9
    //   94: invokevirtual getName : ()Ljava/lang/String;
    //   97: astore #11
    //   99: ldc 'cachedSize'
    //   101: aload #11
    //   103: invokevirtual equals : (Ljava/lang/Object;)Z
    //   106: ifne -> 238
    //   109: iload #10
    //   111: iconst_1
    //   112: iand
    //   113: iconst_1
    //   114: if_icmpne -> 238
    //   117: iload #10
    //   119: bipush #8
    //   121: iand
    //   122: bipush #8
    //   124: if_icmpeq -> 238
    //   127: aload #11
    //   129: ldc '_'
    //   131: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   134: ifne -> 238
    //   137: aload #11
    //   139: ldc '_'
    //   141: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   144: ifne -> 238
    //   147: aload #9
    //   149: invokevirtual getType : ()Ljava/lang/Class;
    //   152: astore #12
    //   154: aload #9
    //   156: aload_1
    //   157: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   160: astore #9
    //   162: aload #12
    //   164: invokevirtual isArray : ()Z
    //   167: ifeq -> 229
    //   170: aload #12
    //   172: invokevirtual getComponentType : ()Ljava/lang/Class;
    //   175: getstatic java/lang/Byte.TYPE : Ljava/lang/Class;
    //   178: if_acmpeq -> 229
    //   181: aload #9
    //   183: ifnonnull -> 192
    //   186: iconst_0
    //   187: istore #10
    //   189: goto -> 199
    //   192: aload #9
    //   194: invokestatic getLength : (Ljava/lang/Object;)I
    //   197: istore #10
    //   199: iconst_0
    //   200: istore #13
    //   202: iload #13
    //   204: iload #10
    //   206: if_icmpge -> 238
    //   209: aload #11
    //   211: aload #9
    //   213: iload #13
    //   215: invokestatic get : (Ljava/lang/Object;I)Ljava/lang/Object;
    //   218: aload_2
    //   219: aload_3
    //   220: invokestatic zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/StringBuffer;Ljava/lang/StringBuffer;)V
    //   223: iinc #13, 1
    //   226: goto -> 202
    //   229: aload #11
    //   231: aload #9
    //   233: aload_2
    //   234: aload_3
    //   235: invokestatic zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/StringBuffer;Ljava/lang/StringBuffer;)V
    //   238: iinc #8, 1
    //   241: goto -> 71
    //   244: aload #5
    //   246: invokevirtual getMethods : ()[Ljava/lang/reflect/Method;
    //   249: astore #12
    //   251: aload #12
    //   253: arraylength
    //   254: istore #10
    //   256: iconst_0
    //   257: istore #8
    //   259: iload #8
    //   261: iload #10
    //   263: if_icmpge -> 438
    //   266: aload #12
    //   268: iload #8
    //   270: aaload
    //   271: invokevirtual getName : ()Ljava/lang/String;
    //   274: astore #6
    //   276: aload #6
    //   278: ldc 'set'
    //   280: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   283: ifeq -> 432
    //   286: aload #6
    //   288: iconst_3
    //   289: invokevirtual substring : (I)Ljava/lang/String;
    //   292: astore #11
    //   294: aload #11
    //   296: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   299: astore #6
    //   301: aload #6
    //   303: invokevirtual length : ()I
    //   306: ifeq -> 321
    //   309: ldc 'has'
    //   311: aload #6
    //   313: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   316: astore #6
    //   318: goto -> 332
    //   321: new java/lang/String
    //   324: dup
    //   325: ldc 'has'
    //   327: invokespecial <init> : (Ljava/lang/String;)V
    //   330: astore #6
    //   332: aload #5
    //   334: aload #6
    //   336: iconst_0
    //   337: anewarray java/lang/Class
    //   340: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   343: astore #6
    //   345: aload #6
    //   347: aload_1
    //   348: iconst_0
    //   349: anewarray java/lang/Object
    //   352: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   355: checkcast java/lang/Boolean
    //   358: invokevirtual booleanValue : ()Z
    //   361: ifeq -> 432
    //   364: aload #11
    //   366: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   369: astore #6
    //   371: aload #6
    //   373: invokevirtual length : ()I
    //   376: ifeq -> 391
    //   379: ldc 'get'
    //   381: aload #6
    //   383: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   386: astore #6
    //   388: goto -> 402
    //   391: new java/lang/String
    //   394: dup
    //   395: ldc 'get'
    //   397: invokespecial <init> : (Ljava/lang/String;)V
    //   400: astore #6
    //   402: aload #5
    //   404: aload #6
    //   406: iconst_0
    //   407: anewarray java/lang/Class
    //   410: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   413: astore #6
    //   415: aload #11
    //   417: aload #6
    //   419: aload_1
    //   420: iconst_0
    //   421: anewarray java/lang/Object
    //   424: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   427: aload_2
    //   428: aload_3
    //   429: invokestatic zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/StringBuffer;Ljava/lang/StringBuffer;)V
    //   432: iinc #8, 1
    //   435: goto -> 259
    //   438: aload_0
    //   439: ifnull -> 461
    //   442: aload_2
    //   443: iload #4
    //   445: invokevirtual setLength : (I)V
    //   448: aload_3
    //   449: aload_2
    //   450: invokevirtual append : (Ljava/lang/StringBuffer;)Ljava/lang/StringBuffer;
    //   453: pop
    //   454: aload_3
    //   455: ldc '>\\n'
    //   457: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   460: pop
    //   461: return
    //   462: aload_0
    //   463: invokestatic zzl : (Ljava/lang/String;)Ljava/lang/String;
    //   466: astore_0
    //   467: aload_3
    //   468: aload_2
    //   469: invokevirtual append : (Ljava/lang/StringBuffer;)Ljava/lang/StringBuffer;
    //   472: pop
    //   473: aload_3
    //   474: aload_0
    //   475: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   478: pop
    //   479: aload_3
    //   480: ldc ': '
    //   482: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   485: pop
    //   486: aload_1
    //   487: instanceof java/lang/String
    //   490: ifeq -> 662
    //   493: aload_1
    //   494: checkcast java/lang/String
    //   497: astore_1
    //   498: aload_1
    //   499: astore_0
    //   500: aload_1
    //   501: ldc 'http'
    //   503: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   506: ifne -> 538
    //   509: aload_1
    //   510: astore_0
    //   511: aload_1
    //   512: invokevirtual length : ()I
    //   515: sipush #200
    //   518: if_icmple -> 538
    //   521: aload_1
    //   522: iconst_0
    //   523: sipush #200
    //   526: invokevirtual substring : (II)Ljava/lang/String;
    //   529: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   532: ldc '[...]'
    //   534: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   537: astore_0
    //   538: aload_0
    //   539: invokevirtual length : ()I
    //   542: istore #10
    //   544: new java/lang/StringBuilder
    //   547: dup
    //   548: iload #10
    //   550: invokespecial <init> : (I)V
    //   553: astore_1
    //   554: iconst_0
    //   555: istore #8
    //   557: iload #8
    //   559: iload #10
    //   561: if_icmpge -> 638
    //   564: aload_0
    //   565: iload #8
    //   567: invokevirtual charAt : (I)C
    //   570: istore #14
    //   572: iload #14
    //   574: bipush #32
    //   576: if_icmplt -> 610
    //   579: iload #14
    //   581: bipush #126
    //   583: if_icmpgt -> 610
    //   586: iload #14
    //   588: bipush #34
    //   590: if_icmpeq -> 610
    //   593: iload #14
    //   595: bipush #39
    //   597: if_icmpeq -> 610
    //   600: aload_1
    //   601: iload #14
    //   603: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: goto -> 632
    //   610: aload_1
    //   611: ldc '\u%04x'
    //   613: iconst_1
    //   614: anewarray java/lang/Object
    //   617: dup
    //   618: iconst_0
    //   619: iload #14
    //   621: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   624: aastore
    //   625: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   628: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: iinc #8, 1
    //   635: goto -> 557
    //   638: aload_1
    //   639: invokevirtual toString : ()Ljava/lang/String;
    //   642: astore_0
    //   643: aload_3
    //   644: ldc '"'
    //   646: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   649: pop
    //   650: aload_3
    //   651: aload_0
    //   652: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   655: pop
    //   656: ldc '"'
    //   658: astore_0
    //   659: goto -> 681
    //   662: aload_1
    //   663: instanceof [B
    //   666: ifeq -> 807
    //   669: aload_1
    //   670: checkcast [B
    //   673: astore_0
    //   674: aload_0
    //   675: ifnonnull -> 690
    //   678: ldc '""'
    //   680: astore_0
    //   681: aload_3
    //   682: aload_0
    //   683: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   686: pop
    //   687: goto -> 813
    //   690: aload_3
    //   691: bipush #34
    //   693: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   696: pop
    //   697: iconst_0
    //   698: istore #8
    //   700: iload #8
    //   702: aload_0
    //   703: arraylength
    //   704: if_icmpge -> 797
    //   707: aload_0
    //   708: iload #8
    //   710: baload
    //   711: sipush #255
    //   714: iand
    //   715: istore #10
    //   717: iload #10
    //   719: bipush #92
    //   721: if_icmpeq -> 776
    //   724: iload #10
    //   726: bipush #34
    //   728: if_icmpne -> 734
    //   731: goto -> 776
    //   734: iload #10
    //   736: bipush #32
    //   738: if_icmplt -> 751
    //   741: iload #10
    //   743: bipush #127
    //   745: if_icmpge -> 751
    //   748: goto -> 783
    //   751: aload_3
    //   752: ldc '\%03o'
    //   754: iconst_1
    //   755: anewarray java/lang/Object
    //   758: dup
    //   759: iconst_0
    //   760: iload #10
    //   762: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   765: aastore
    //   766: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   769: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   772: pop
    //   773: goto -> 791
    //   776: aload_3
    //   777: bipush #92
    //   779: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   782: pop
    //   783: aload_3
    //   784: iload #10
    //   786: i2c
    //   787: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   790: pop
    //   791: iinc #8, 1
    //   794: goto -> 700
    //   797: aload_3
    //   798: bipush #34
    //   800: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   803: pop
    //   804: goto -> 813
    //   807: aload_3
    //   808: aload_1
    //   809: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   812: pop
    //   813: aload_3
    //   814: ldc '\\n'
    //   816: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   819: pop
    //   820: return
    //   821: astore #6
    //   823: goto -> 432
    // Exception table:
    //   from	to	target	type
    //   294	318	821	java/lang/NoSuchMethodException
    //   321	332	821	java/lang/NoSuchMethodException
    //   332	345	821	java/lang/NoSuchMethodException
    //   364	388	821	java/lang/NoSuchMethodException
    //   391	402	821	java/lang/NoSuchMethodException
    //   402	415	821	java/lang/NoSuchMethodException
  }
  
  private static String zzl(String paramString) {
    // Byte code:
    //   0: new java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_1
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: aload_0
    //   12: invokevirtual length : ()I
    //   15: if_icmpge -> 74
    //   18: aload_0
    //   19: iload_2
    //   20: invokevirtual charAt : (I)C
    //   23: istore_3
    //   24: iload_2
    //   25: ifne -> 48
    //   28: iload_3
    //   29: invokestatic toLowerCase : (C)C
    //   32: istore #4
    //   34: iload #4
    //   36: istore #5
    //   38: aload_1
    //   39: iload #5
    //   41: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   44: pop
    //   45: goto -> 68
    //   48: iload_3
    //   49: istore #5
    //   51: iload_3
    //   52: invokestatic isUpperCase : (C)Z
    //   55: ifeq -> 38
    //   58: aload_1
    //   59: bipush #95
    //   61: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   64: pop
    //   65: goto -> 28
    //   68: iinc #2, 1
    //   71: goto -> 10
    //   74: aload_1
    //   75: invokevirtual toString : ()Ljava/lang/String;
    //   78: areturn
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */