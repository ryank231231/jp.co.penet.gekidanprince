package com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils {
  private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
  
  private static final String UTC_ID = "UTC";
  
  private static boolean checkOffset(String paramString, int paramInt, char paramChar) {
    boolean bool;
    if (paramInt < paramString.length() && paramString.charAt(paramInt) == paramChar) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static String format(Date paramDate) {
    return format(paramDate, false, TIMEZONE_UTC);
  }
  
  public static String format(Date paramDate, boolean paramBoolean) {
    return format(paramDate, paramBoolean, TIMEZONE_UTC);
  }
  
  public static String format(Date paramDate, boolean paramBoolean, TimeZone paramTimeZone) {
    int i;
    int j;
    GregorianCalendar gregorianCalendar = new GregorianCalendar(paramTimeZone, Locale.US);
    gregorianCalendar.setTime(paramDate);
    if (paramBoolean) {
      i = 4;
    } else {
      i = 0;
    } 
    if (paramTimeZone.getRawOffset() == 0) {
      j = 1;
    } else {
      j = 6;
    } 
    StringBuilder stringBuilder = new StringBuilder(19 + i + j);
    padInt(stringBuilder, gregorianCalendar.get(1), 4);
    byte b = 45;
    stringBuilder.append('-');
    padInt(stringBuilder, gregorianCalendar.get(2) + 1, 2);
    stringBuilder.append('-');
    padInt(stringBuilder, gregorianCalendar.get(5), 2);
    stringBuilder.append('T');
    padInt(stringBuilder, gregorianCalendar.get(11), 2);
    stringBuilder.append(':');
    padInt(stringBuilder, gregorianCalendar.get(12), 2);
    stringBuilder.append(':');
    padInt(stringBuilder, gregorianCalendar.get(13), 2);
    if (paramBoolean) {
      stringBuilder.append('.');
      padInt(stringBuilder, gregorianCalendar.get(14), 3);
    } 
    int k = paramTimeZone.getOffset(gregorianCalendar.getTimeInMillis());
    if (k != 0) {
      int m;
      j = k / 60000;
      i = Math.abs(j / 60);
      j = Math.abs(j % 60);
      if (k < 0) {
        m = b;
      } else {
        k = 43;
        m = k;
      } 
      stringBuilder.append(m);
      padInt(stringBuilder, i, 2);
      stringBuilder.append(':');
      padInt(stringBuilder, j, 2);
    } else {
      stringBuilder.append('Z');
    } 
    return stringBuilder.toString();
  }
  
  private static int indexOfNonDigit(String paramString, int paramInt) {
    while (paramInt < paramString.length()) {
      char c = paramString.charAt(paramInt);
      if (c < '0' || c > '9')
        return paramInt; 
      paramInt++;
    } 
    return paramString.length();
  }
  
  private static void padInt(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
    String str = Integer.toString(paramInt1);
    for (paramInt1 = paramInt2 - str.length(); paramInt1 > 0; paramInt1--)
      paramStringBuilder.append('0'); 
    paramStringBuilder.append(str);
  }
  
  public static Date parse(String paramString, ParsePosition paramParsePosition) throws ParseException {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getIndex : ()I
    //   4: istore_2
    //   5: iload_2
    //   6: iconst_4
    //   7: iadd
    //   8: istore_3
    //   9: aload_0
    //   10: iload_2
    //   11: iload_3
    //   12: invokestatic parseInt : (Ljava/lang/String;II)I
    //   15: istore #4
    //   17: iload_3
    //   18: istore_2
    //   19: aload_0
    //   20: iload_3
    //   21: bipush #45
    //   23: invokestatic checkOffset : (Ljava/lang/String;IC)Z
    //   26: ifeq -> 33
    //   29: iload_3
    //   30: iconst_1
    //   31: iadd
    //   32: istore_2
    //   33: iload_2
    //   34: iconst_2
    //   35: iadd
    //   36: istore_3
    //   37: aload_0
    //   38: iload_2
    //   39: iload_3
    //   40: invokestatic parseInt : (Ljava/lang/String;II)I
    //   43: istore #5
    //   45: iload_3
    //   46: istore_2
    //   47: aload_0
    //   48: iload_3
    //   49: bipush #45
    //   51: invokestatic checkOffset : (Ljava/lang/String;IC)Z
    //   54: ifeq -> 61
    //   57: iload_3
    //   58: iconst_1
    //   59: iadd
    //   60: istore_2
    //   61: iload_2
    //   62: iconst_2
    //   63: iadd
    //   64: istore_3
    //   65: aload_0
    //   66: iload_2
    //   67: iload_3
    //   68: invokestatic parseInt : (Ljava/lang/String;II)I
    //   71: istore #6
    //   73: aload_0
    //   74: iload_3
    //   75: bipush #84
    //   77: invokestatic checkOffset : (Ljava/lang/String;IC)Z
    //   80: istore #7
    //   82: iload #7
    //   84: ifne -> 124
    //   87: aload_0
    //   88: invokevirtual length : ()I
    //   91: iload_3
    //   92: if_icmpgt -> 124
    //   95: new java/util/GregorianCalendar
    //   98: astore #8
    //   100: aload #8
    //   102: iload #4
    //   104: iload #5
    //   106: iconst_1
    //   107: isub
    //   108: iload #6
    //   110: invokespecial <init> : (III)V
    //   113: aload_1
    //   114: iload_3
    //   115: invokevirtual setIndex : (I)V
    //   118: aload #8
    //   120: invokevirtual getTime : ()Ljava/util/Date;
    //   123: areturn
    //   124: iload #7
    //   126: ifeq -> 366
    //   129: iload_3
    //   130: iconst_1
    //   131: iadd
    //   132: istore_2
    //   133: iload_2
    //   134: iconst_2
    //   135: iadd
    //   136: istore_3
    //   137: aload_0
    //   138: iload_2
    //   139: iload_3
    //   140: invokestatic parseInt : (Ljava/lang/String;II)I
    //   143: istore #9
    //   145: iload_3
    //   146: istore_2
    //   147: aload_0
    //   148: iload_3
    //   149: bipush #58
    //   151: invokestatic checkOffset : (Ljava/lang/String;IC)Z
    //   154: ifeq -> 161
    //   157: iload_3
    //   158: iconst_1
    //   159: iadd
    //   160: istore_2
    //   161: iload_2
    //   162: iconst_2
    //   163: iadd
    //   164: istore #10
    //   166: aload_0
    //   167: iload_2
    //   168: iload #10
    //   170: invokestatic parseInt : (Ljava/lang/String;II)I
    //   173: istore #11
    //   175: iload #10
    //   177: istore_3
    //   178: aload_0
    //   179: iload #10
    //   181: bipush #58
    //   183: invokestatic checkOffset : (Ljava/lang/String;IC)Z
    //   186: ifeq -> 194
    //   189: iload #10
    //   191: iconst_1
    //   192: iadd
    //   193: istore_3
    //   194: aload_0
    //   195: invokevirtual length : ()I
    //   198: iload_3
    //   199: if_icmple -> 358
    //   202: aload_0
    //   203: iload_3
    //   204: invokevirtual charAt : (I)C
    //   207: istore_2
    //   208: iload_2
    //   209: bipush #90
    //   211: if_icmpeq -> 358
    //   214: iload_2
    //   215: bipush #43
    //   217: if_icmpeq -> 358
    //   220: iload_2
    //   221: bipush #45
    //   223: if_icmpeq -> 358
    //   226: iload_3
    //   227: iconst_2
    //   228: iadd
    //   229: istore_2
    //   230: aload_0
    //   231: iload_3
    //   232: iload_2
    //   233: invokestatic parseInt : (Ljava/lang/String;II)I
    //   236: istore #10
    //   238: bipush #59
    //   240: istore_3
    //   241: iload #10
    //   243: bipush #59
    //   245: if_icmple -> 261
    //   248: iload #10
    //   250: bipush #63
    //   252: if_icmpge -> 261
    //   255: iload_3
    //   256: istore #10
    //   258: goto -> 261
    //   261: aload_0
    //   262: iload_2
    //   263: bipush #46
    //   265: invokestatic checkOffset : (Ljava/lang/String;IC)Z
    //   268: ifeq -> 351
    //   271: iload_2
    //   272: iconst_1
    //   273: iadd
    //   274: istore #12
    //   276: aload_0
    //   277: iload #12
    //   279: iconst_1
    //   280: iadd
    //   281: invokestatic indexOfNonDigit : (Ljava/lang/String;I)I
    //   284: istore_3
    //   285: iload_3
    //   286: iload #12
    //   288: iconst_3
    //   289: iadd
    //   290: invokestatic min : (II)I
    //   293: istore #13
    //   295: aload_0
    //   296: iload #12
    //   298: iload #13
    //   300: invokestatic parseInt : (Ljava/lang/String;II)I
    //   303: istore_2
    //   304: iload #13
    //   306: iload #12
    //   308: isub
    //   309: tableswitch default -> 332, 1 -> 343, 2 -> 335
    //   332: goto -> 348
    //   335: iload_2
    //   336: bipush #10
    //   338: imul
    //   339: istore_2
    //   340: goto -> 348
    //   343: iload_2
    //   344: bipush #100
    //   346: imul
    //   347: istore_2
    //   348: goto -> 377
    //   351: iload_2
    //   352: istore_3
    //   353: iconst_0
    //   354: istore_2
    //   355: goto -> 377
    //   358: iconst_0
    //   359: istore_2
    //   360: iconst_0
    //   361: istore #10
    //   363: goto -> 377
    //   366: iconst_0
    //   367: istore #9
    //   369: iconst_0
    //   370: istore #11
    //   372: iconst_0
    //   373: istore_2
    //   374: iconst_0
    //   375: istore #10
    //   377: aload_0
    //   378: invokevirtual length : ()I
    //   381: iload_3
    //   382: if_icmple -> 800
    //   385: aload_0
    //   386: iload_3
    //   387: invokevirtual charAt : (I)C
    //   390: istore #14
    //   392: iload #14
    //   394: bipush #90
    //   396: if_icmpne -> 410
    //   399: getstatic com/google/gson/internal/bind/util/ISO8601Utils.TIMEZONE_UTC : Ljava/util/TimeZone;
    //   402: astore #8
    //   404: iinc #3, 1
    //   407: goto -> 710
    //   410: iload #14
    //   412: bipush #43
    //   414: if_icmpeq -> 479
    //   417: iload #14
    //   419: bipush #45
    //   421: if_icmpne -> 427
    //   424: goto -> 479
    //   427: new java/lang/IndexOutOfBoundsException
    //   430: astore #8
    //   432: new java/lang/StringBuilder
    //   435: astore #15
    //   437: aload #15
    //   439: invokespecial <init> : ()V
    //   442: aload #15
    //   444: ldc 'Invalid time zone indicator ''
    //   446: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload #15
    //   452: iload #14
    //   454: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload #15
    //   460: ldc '''
    //   462: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload #8
    //   468: aload #15
    //   470: invokevirtual toString : ()Ljava/lang/String;
    //   473: invokespecial <init> : (Ljava/lang/String;)V
    //   476: aload #8
    //   478: athrow
    //   479: aload_0
    //   480: iload_3
    //   481: invokevirtual substring : (I)Ljava/lang/String;
    //   484: astore #8
    //   486: aload #8
    //   488: invokevirtual length : ()I
    //   491: iconst_5
    //   492: if_icmplt -> 498
    //   495: goto -> 531
    //   498: new java/lang/StringBuilder
    //   501: astore #15
    //   503: aload #15
    //   505: invokespecial <init> : ()V
    //   508: aload #15
    //   510: aload #8
    //   512: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload #15
    //   518: ldc '00'
    //   520: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload #15
    //   526: invokevirtual toString : ()Ljava/lang/String;
    //   529: astore #8
    //   531: iload_3
    //   532: aload #8
    //   534: invokevirtual length : ()I
    //   537: iadd
    //   538: istore_3
    //   539: ldc '+0000'
    //   541: aload #8
    //   543: invokevirtual equals : (Ljava/lang/Object;)Z
    //   546: ifne -> 705
    //   549: ldc '+00:00'
    //   551: aload #8
    //   553: invokevirtual equals : (Ljava/lang/Object;)Z
    //   556: ifeq -> 562
    //   559: goto -> 705
    //   562: new java/lang/StringBuilder
    //   565: astore #15
    //   567: aload #15
    //   569: invokespecial <init> : ()V
    //   572: aload #15
    //   574: ldc 'GMT'
    //   576: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload #15
    //   582: aload #8
    //   584: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload #15
    //   590: invokevirtual toString : ()Ljava/lang/String;
    //   593: astore #15
    //   595: aload #15
    //   597: invokestatic getTimeZone : (Ljava/lang/String;)Ljava/util/TimeZone;
    //   600: astore #8
    //   602: aload #8
    //   604: invokevirtual getID : ()Ljava/lang/String;
    //   607: astore #16
    //   609: aload #16
    //   611: aload #15
    //   613: invokevirtual equals : (Ljava/lang/Object;)Z
    //   616: ifne -> 702
    //   619: aload #16
    //   621: ldc ':'
    //   623: ldc ''
    //   625: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   628: aload #15
    //   630: invokevirtual equals : (Ljava/lang/Object;)Z
    //   633: ifeq -> 639
    //   636: goto -> 702
    //   639: new java/lang/IndexOutOfBoundsException
    //   642: astore #16
    //   644: new java/lang/StringBuilder
    //   647: astore #17
    //   649: aload #17
    //   651: invokespecial <init> : ()V
    //   654: aload #17
    //   656: ldc 'Mismatching time zone indicator: '
    //   658: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: aload #17
    //   664: aload #15
    //   666: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: aload #17
    //   672: ldc ' given, resolves to '
    //   674: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: pop
    //   678: aload #17
    //   680: aload #8
    //   682: invokevirtual getID : ()Ljava/lang/String;
    //   685: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload #16
    //   691: aload #17
    //   693: invokevirtual toString : ()Ljava/lang/String;
    //   696: invokespecial <init> : (Ljava/lang/String;)V
    //   699: aload #16
    //   701: athrow
    //   702: goto -> 710
    //   705: getstatic com/google/gson/internal/bind/util/ISO8601Utils.TIMEZONE_UTC : Ljava/util/TimeZone;
    //   708: astore #8
    //   710: new java/util/GregorianCalendar
    //   713: astore #15
    //   715: aload #15
    //   717: aload #8
    //   719: invokespecial <init> : (Ljava/util/TimeZone;)V
    //   722: aload #15
    //   724: iconst_0
    //   725: invokevirtual setLenient : (Z)V
    //   728: aload #15
    //   730: iconst_1
    //   731: iload #4
    //   733: invokevirtual set : (II)V
    //   736: aload #15
    //   738: iconst_2
    //   739: iload #5
    //   741: iconst_1
    //   742: isub
    //   743: invokevirtual set : (II)V
    //   746: aload #15
    //   748: iconst_5
    //   749: iload #6
    //   751: invokevirtual set : (II)V
    //   754: aload #15
    //   756: bipush #11
    //   758: iload #9
    //   760: invokevirtual set : (II)V
    //   763: aload #15
    //   765: bipush #12
    //   767: iload #11
    //   769: invokevirtual set : (II)V
    //   772: aload #15
    //   774: bipush #13
    //   776: iload #10
    //   778: invokevirtual set : (II)V
    //   781: aload #15
    //   783: bipush #14
    //   785: iload_2
    //   786: invokevirtual set : (II)V
    //   789: aload_1
    //   790: iload_3
    //   791: invokevirtual setIndex : (I)V
    //   794: aload #15
    //   796: invokevirtual getTime : ()Ljava/util/Date;
    //   799: areturn
    //   800: new java/lang/IllegalArgumentException
    //   803: astore #8
    //   805: aload #8
    //   807: ldc 'No time zone indicator'
    //   809: invokespecial <init> : (Ljava/lang/String;)V
    //   812: aload #8
    //   814: athrow
    //   815: astore #8
    //   817: goto -> 827
    //   820: astore #8
    //   822: goto -> 827
    //   825: astore #8
    //   827: aload_0
    //   828: ifnonnull -> 836
    //   831: aconst_null
    //   832: astore_0
    //   833: goto -> 874
    //   836: new java/lang/StringBuilder
    //   839: dup
    //   840: invokespecial <init> : ()V
    //   843: astore #15
    //   845: aload #15
    //   847: bipush #34
    //   849: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: aload #15
    //   855: aload_0
    //   856: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: aload #15
    //   862: ldc '''
    //   864: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: pop
    //   868: aload #15
    //   870: invokevirtual toString : ()Ljava/lang/String;
    //   873: astore_0
    //   874: aload #8
    //   876: invokevirtual getMessage : ()Ljava/lang/String;
    //   879: astore #16
    //   881: aload #16
    //   883: ifnull -> 898
    //   886: aload #16
    //   888: astore #15
    //   890: aload #16
    //   892: invokevirtual isEmpty : ()Z
    //   895: ifeq -> 944
    //   898: new java/lang/StringBuilder
    //   901: dup
    //   902: invokespecial <init> : ()V
    //   905: astore #15
    //   907: aload #15
    //   909: ldc '('
    //   911: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: pop
    //   915: aload #15
    //   917: aload #8
    //   919: invokevirtual getClass : ()Ljava/lang/Class;
    //   922: invokevirtual getName : ()Ljava/lang/String;
    //   925: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: aload #15
    //   931: ldc ')'
    //   933: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: pop
    //   937: aload #15
    //   939: invokevirtual toString : ()Ljava/lang/String;
    //   942: astore #15
    //   944: new java/lang/StringBuilder
    //   947: dup
    //   948: invokespecial <init> : ()V
    //   951: astore #16
    //   953: aload #16
    //   955: ldc 'Failed to parse date ['
    //   957: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: pop
    //   961: aload #16
    //   963: aload_0
    //   964: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: pop
    //   968: aload #16
    //   970: ldc ']: '
    //   972: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: pop
    //   976: aload #16
    //   978: aload #15
    //   980: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: pop
    //   984: new java/text/ParseException
    //   987: dup
    //   988: aload #16
    //   990: invokevirtual toString : ()Ljava/lang/String;
    //   993: aload_1
    //   994: invokevirtual getIndex : ()I
    //   997: invokespecial <init> : (Ljava/lang/String;I)V
    //   1000: astore_0
    //   1001: aload_0
    //   1002: aload #8
    //   1004: invokevirtual initCause : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   1007: pop
    //   1008: aload_0
    //   1009: athrow
    // Exception table:
    //   from	to	target	type
    //   0	5	825	java/lang/IndexOutOfBoundsException
    //   0	5	820	java/lang/NumberFormatException
    //   0	5	815	java/lang/IllegalArgumentException
    //   9	17	825	java/lang/IndexOutOfBoundsException
    //   9	17	820	java/lang/NumberFormatException
    //   9	17	815	java/lang/IllegalArgumentException
    //   19	29	825	java/lang/IndexOutOfBoundsException
    //   19	29	820	java/lang/NumberFormatException
    //   19	29	815	java/lang/IllegalArgumentException
    //   37	45	825	java/lang/IndexOutOfBoundsException
    //   37	45	820	java/lang/NumberFormatException
    //   37	45	815	java/lang/IllegalArgumentException
    //   47	57	825	java/lang/IndexOutOfBoundsException
    //   47	57	820	java/lang/NumberFormatException
    //   47	57	815	java/lang/IllegalArgumentException
    //   65	82	825	java/lang/IndexOutOfBoundsException
    //   65	82	820	java/lang/NumberFormatException
    //   65	82	815	java/lang/IllegalArgumentException
    //   87	124	825	java/lang/IndexOutOfBoundsException
    //   87	124	820	java/lang/NumberFormatException
    //   87	124	815	java/lang/IllegalArgumentException
    //   137	145	825	java/lang/IndexOutOfBoundsException
    //   137	145	820	java/lang/NumberFormatException
    //   137	145	815	java/lang/IllegalArgumentException
    //   147	157	825	java/lang/IndexOutOfBoundsException
    //   147	157	820	java/lang/NumberFormatException
    //   147	157	815	java/lang/IllegalArgumentException
    //   166	175	825	java/lang/IndexOutOfBoundsException
    //   166	175	820	java/lang/NumberFormatException
    //   166	175	815	java/lang/IllegalArgumentException
    //   178	189	825	java/lang/IndexOutOfBoundsException
    //   178	189	820	java/lang/NumberFormatException
    //   178	189	815	java/lang/IllegalArgumentException
    //   194	208	825	java/lang/IndexOutOfBoundsException
    //   194	208	820	java/lang/NumberFormatException
    //   194	208	815	java/lang/IllegalArgumentException
    //   230	238	825	java/lang/IndexOutOfBoundsException
    //   230	238	820	java/lang/NumberFormatException
    //   230	238	815	java/lang/IllegalArgumentException
    //   261	271	825	java/lang/IndexOutOfBoundsException
    //   261	271	820	java/lang/NumberFormatException
    //   261	271	815	java/lang/IllegalArgumentException
    //   276	304	825	java/lang/IndexOutOfBoundsException
    //   276	304	820	java/lang/NumberFormatException
    //   276	304	815	java/lang/IllegalArgumentException
    //   377	392	825	java/lang/IndexOutOfBoundsException
    //   377	392	820	java/lang/NumberFormatException
    //   377	392	815	java/lang/IllegalArgumentException
    //   399	404	825	java/lang/IndexOutOfBoundsException
    //   399	404	820	java/lang/NumberFormatException
    //   399	404	815	java/lang/IllegalArgumentException
    //   427	479	825	java/lang/IndexOutOfBoundsException
    //   427	479	820	java/lang/NumberFormatException
    //   427	479	815	java/lang/IllegalArgumentException
    //   479	495	825	java/lang/IndexOutOfBoundsException
    //   479	495	820	java/lang/NumberFormatException
    //   479	495	815	java/lang/IllegalArgumentException
    //   498	531	825	java/lang/IndexOutOfBoundsException
    //   498	531	820	java/lang/NumberFormatException
    //   498	531	815	java/lang/IllegalArgumentException
    //   531	559	825	java/lang/IndexOutOfBoundsException
    //   531	559	820	java/lang/NumberFormatException
    //   531	559	815	java/lang/IllegalArgumentException
    //   562	636	825	java/lang/IndexOutOfBoundsException
    //   562	636	820	java/lang/NumberFormatException
    //   562	636	815	java/lang/IllegalArgumentException
    //   639	702	825	java/lang/IndexOutOfBoundsException
    //   639	702	820	java/lang/NumberFormatException
    //   639	702	815	java/lang/IllegalArgumentException
    //   705	710	825	java/lang/IndexOutOfBoundsException
    //   705	710	820	java/lang/NumberFormatException
    //   705	710	815	java/lang/IllegalArgumentException
    //   710	800	825	java/lang/IndexOutOfBoundsException
    //   710	800	820	java/lang/NumberFormatException
    //   710	800	815	java/lang/IllegalArgumentException
    //   800	815	825	java/lang/IndexOutOfBoundsException
    //   800	815	820	java/lang/NumberFormatException
    //   800	815	815	java/lang/IllegalArgumentException
  }
  
  private static int parseInt(String paramString, int paramInt1, int paramInt2) throws NumberFormatException {
    if (paramInt1 >= 0 && paramInt2 <= paramString.length() && paramInt1 <= paramInt2) {
      int i;
      int j;
      if (paramInt1 < paramInt2) {
        i = paramInt1 + 1;
        j = Character.digit(paramString.charAt(paramInt1), 10);
        if (j >= 0) {
          j = -j;
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid number: ");
          stringBuilder.append(paramString.substring(paramInt1, paramInt2));
          throw new NumberFormatException(stringBuilder.toString());
        } 
      } else {
        i = paramInt1;
        j = 0;
      } 
      while (i < paramInt2) {
        int k = Character.digit(paramString.charAt(i), 10);
        if (k >= 0) {
          j = j * 10 - k;
          i++;
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid number: ");
        stringBuilder.append(paramString.substring(paramInt1, paramInt2));
        throw new NumberFormatException(stringBuilder.toString());
      } 
      return -j;
    } 
    throw new NumberFormatException(paramString);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\gson\internal\bin\\util\ISO8601Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */