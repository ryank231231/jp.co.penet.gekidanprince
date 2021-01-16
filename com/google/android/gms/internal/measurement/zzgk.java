package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

final class zzgk {
  static String zza(zzgh paramzzgh, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("# ");
    stringBuilder.append(paramString);
    zza(paramzzgh, stringBuilder, 0);
    return stringBuilder.toString();
  }
  
  private static void zza(zzgh paramzzgh, StringBuilder paramStringBuilder, int paramInt) {
    // Byte code:
    //   0: new java/util/HashMap
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_3
    //   8: new java/util/HashMap
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: astore #4
    //   17: new java/util/TreeSet
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: astore #5
    //   26: aload_0
    //   27: invokevirtual getClass : ()Ljava/lang/Class;
    //   30: invokevirtual getDeclaredMethods : ()[Ljava/lang/reflect/Method;
    //   33: astore #6
    //   35: aload #6
    //   37: arraylength
    //   38: istore #7
    //   40: iconst_0
    //   41: istore #8
    //   43: iload #8
    //   45: iload #7
    //   47: if_icmpge -> 127
    //   50: aload #6
    //   52: iload #8
    //   54: aaload
    //   55: astore #9
    //   57: aload #4
    //   59: aload #9
    //   61: invokevirtual getName : ()Ljava/lang/String;
    //   64: aload #9
    //   66: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   71: pop
    //   72: aload #9
    //   74: invokevirtual getParameterTypes : ()[Ljava/lang/Class;
    //   77: arraylength
    //   78: ifne -> 121
    //   81: aload_3
    //   82: aload #9
    //   84: invokevirtual getName : ()Ljava/lang/String;
    //   87: aload #9
    //   89: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: aload #9
    //   97: invokevirtual getName : ()Ljava/lang/String;
    //   100: ldc 'get'
    //   102: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   105: ifeq -> 121
    //   108: aload #5
    //   110: aload #9
    //   112: invokevirtual getName : ()Ljava/lang/String;
    //   115: invokeinterface add : (Ljava/lang/Object;)Z
    //   120: pop
    //   121: iinc #8, 1
    //   124: goto -> 43
    //   127: aload #5
    //   129: invokeinterface iterator : ()Ljava/util/Iterator;
    //   134: astore #9
    //   136: aload #9
    //   138: invokeinterface hasNext : ()Z
    //   143: ifeq -> 1073
    //   146: aload #9
    //   148: invokeinterface next : ()Ljava/lang/Object;
    //   153: checkcast java/lang/String
    //   156: astore #5
    //   158: aload #5
    //   160: ldc 'get'
    //   162: ldc ''
    //   164: invokevirtual replaceFirst : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   167: astore #10
    //   169: aload #10
    //   171: ldc 'List'
    //   173: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   176: ifeq -> 317
    //   179: aload #10
    //   181: ldc 'OrBuilderList'
    //   183: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   186: ifne -> 317
    //   189: aload #10
    //   191: ldc 'List'
    //   193: invokevirtual equals : (Ljava/lang/Object;)Z
    //   196: ifne -> 317
    //   199: aload #10
    //   201: iconst_0
    //   202: iconst_1
    //   203: invokevirtual substring : (II)Ljava/lang/String;
    //   206: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   209: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   212: astore #11
    //   214: aload #10
    //   216: iconst_1
    //   217: aload #10
    //   219: invokevirtual length : ()I
    //   222: iconst_4
    //   223: isub
    //   224: invokevirtual substring : (II)Ljava/lang/String;
    //   227: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   230: astore #6
    //   232: aload #6
    //   234: invokevirtual length : ()I
    //   237: ifeq -> 252
    //   240: aload #11
    //   242: aload #6
    //   244: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   247: astore #6
    //   249: goto -> 263
    //   252: new java/lang/String
    //   255: dup
    //   256: aload #11
    //   258: invokespecial <init> : (Ljava/lang/String;)V
    //   261: astore #6
    //   263: aload_3
    //   264: aload #5
    //   266: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   271: checkcast java/lang/reflect/Method
    //   274: astore #11
    //   276: aload #11
    //   278: ifnull -> 317
    //   281: aload #11
    //   283: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   286: ldc java/util/List
    //   288: invokevirtual equals : (Ljava/lang/Object;)Z
    //   291: ifeq -> 317
    //   294: aload_1
    //   295: iload_2
    //   296: aload #6
    //   298: invokestatic zzcs : (Ljava/lang/String;)Ljava/lang/String;
    //   301: aload #11
    //   303: aload_0
    //   304: iconst_0
    //   305: anewarray java/lang/Object
    //   308: invokestatic zza : (Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   311: invokestatic zzb : (Ljava/lang/StringBuilder;ILjava/lang/String;Ljava/lang/Object;)V
    //   314: goto -> 136
    //   317: aload #10
    //   319: ldc 'Map'
    //   321: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   324: ifeq -> 476
    //   327: aload #10
    //   329: ldc 'Map'
    //   331: invokevirtual equals : (Ljava/lang/Object;)Z
    //   334: ifne -> 476
    //   337: aload #10
    //   339: iconst_0
    //   340: iconst_1
    //   341: invokevirtual substring : (II)Ljava/lang/String;
    //   344: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   347: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   350: astore #11
    //   352: aload #10
    //   354: iconst_1
    //   355: aload #10
    //   357: invokevirtual length : ()I
    //   360: iconst_3
    //   361: isub
    //   362: invokevirtual substring : (II)Ljava/lang/String;
    //   365: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   368: astore #6
    //   370: aload #6
    //   372: invokevirtual length : ()I
    //   375: ifeq -> 390
    //   378: aload #11
    //   380: aload #6
    //   382: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   385: astore #6
    //   387: goto -> 401
    //   390: new java/lang/String
    //   393: dup
    //   394: aload #11
    //   396: invokespecial <init> : (Ljava/lang/String;)V
    //   399: astore #6
    //   401: aload_3
    //   402: aload #5
    //   404: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   409: checkcast java/lang/reflect/Method
    //   412: astore #5
    //   414: aload #5
    //   416: ifnull -> 476
    //   419: aload #5
    //   421: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   424: ldc java/util/Map
    //   426: invokevirtual equals : (Ljava/lang/Object;)Z
    //   429: ifeq -> 476
    //   432: aload #5
    //   434: ldc java/lang/Deprecated
    //   436: invokevirtual isAnnotationPresent : (Ljava/lang/Class;)Z
    //   439: ifne -> 476
    //   442: aload #5
    //   444: invokevirtual getModifiers : ()I
    //   447: invokestatic isPublic : (I)Z
    //   450: ifeq -> 476
    //   453: aload_1
    //   454: iload_2
    //   455: aload #6
    //   457: invokestatic zzcs : (Ljava/lang/String;)Ljava/lang/String;
    //   460: aload #5
    //   462: aload_0
    //   463: iconst_0
    //   464: anewarray java/lang/Object
    //   467: invokestatic zza : (Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   470: invokestatic zzb : (Ljava/lang/StringBuilder;ILjava/lang/String;Ljava/lang/Object;)V
    //   473: goto -> 136
    //   476: aload #10
    //   478: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   481: astore #6
    //   483: aload #6
    //   485: invokevirtual length : ()I
    //   488: ifeq -> 503
    //   491: ldc 'set'
    //   493: aload #6
    //   495: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   498: astore #6
    //   500: goto -> 514
    //   503: new java/lang/String
    //   506: dup
    //   507: ldc 'set'
    //   509: invokespecial <init> : (Ljava/lang/String;)V
    //   512: astore #6
    //   514: aload #4
    //   516: aload #6
    //   518: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   523: checkcast java/lang/reflect/Method
    //   526: ifnull -> 136
    //   529: aload #10
    //   531: ldc 'Bytes'
    //   533: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   536: ifeq -> 599
    //   539: aload #10
    //   541: iconst_0
    //   542: aload #10
    //   544: invokevirtual length : ()I
    //   547: iconst_5
    //   548: isub
    //   549: invokevirtual substring : (II)Ljava/lang/String;
    //   552: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   555: astore #6
    //   557: aload #6
    //   559: invokevirtual length : ()I
    //   562: ifeq -> 577
    //   565: ldc 'get'
    //   567: aload #6
    //   569: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   572: astore #6
    //   574: goto -> 588
    //   577: new java/lang/String
    //   580: dup
    //   581: ldc 'get'
    //   583: invokespecial <init> : (Ljava/lang/String;)V
    //   586: astore #6
    //   588: aload_3
    //   589: aload #6
    //   591: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   596: ifne -> 136
    //   599: aload #10
    //   601: iconst_0
    //   602: iconst_1
    //   603: invokevirtual substring : (II)Ljava/lang/String;
    //   606: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   609: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   612: astore #5
    //   614: aload #10
    //   616: iconst_1
    //   617: invokevirtual substring : (I)Ljava/lang/String;
    //   620: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   623: astore #6
    //   625: aload #6
    //   627: invokevirtual length : ()I
    //   630: ifeq -> 645
    //   633: aload #5
    //   635: aload #6
    //   637: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   640: astore #6
    //   642: goto -> 656
    //   645: new java/lang/String
    //   648: dup
    //   649: aload #5
    //   651: invokespecial <init> : (Ljava/lang/String;)V
    //   654: astore #6
    //   656: aload #10
    //   658: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   661: astore #5
    //   663: aload #5
    //   665: invokevirtual length : ()I
    //   668: ifeq -> 683
    //   671: ldc 'get'
    //   673: aload #5
    //   675: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   678: astore #5
    //   680: goto -> 694
    //   683: new java/lang/String
    //   686: dup
    //   687: ldc 'get'
    //   689: invokespecial <init> : (Ljava/lang/String;)V
    //   692: astore #5
    //   694: aload_3
    //   695: aload #5
    //   697: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   702: checkcast java/lang/reflect/Method
    //   705: astore #11
    //   707: aload #10
    //   709: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   712: astore #5
    //   714: aload #5
    //   716: invokevirtual length : ()I
    //   719: ifeq -> 734
    //   722: ldc 'has'
    //   724: aload #5
    //   726: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   729: astore #5
    //   731: goto -> 745
    //   734: new java/lang/String
    //   737: dup
    //   738: ldc 'has'
    //   740: invokespecial <init> : (Ljava/lang/String;)V
    //   743: astore #5
    //   745: aload_3
    //   746: aload #5
    //   748: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   753: checkcast java/lang/reflect/Method
    //   756: astore #5
    //   758: aload #11
    //   760: ifnull -> 136
    //   763: aload #11
    //   765: aload_0
    //   766: iconst_0
    //   767: anewarray java/lang/Object
    //   770: invokestatic zza : (Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   773: astore #10
    //   775: aload #5
    //   777: ifnonnull -> 1035
    //   780: aload #10
    //   782: instanceof java/lang/Boolean
    //   785: ifeq -> 811
    //   788: aload #10
    //   790: checkcast java/lang/Boolean
    //   793: invokevirtual booleanValue : ()Z
    //   796: ifne -> 805
    //   799: iconst_1
    //   800: istore #12
    //   802: goto -> 1018
    //   805: iconst_0
    //   806: istore #12
    //   808: goto -> 1018
    //   811: aload #10
    //   813: instanceof java/lang/Integer
    //   816: ifeq -> 842
    //   819: aload #10
    //   821: checkcast java/lang/Integer
    //   824: invokevirtual intValue : ()I
    //   827: ifne -> 836
    //   830: iconst_1
    //   831: istore #12
    //   833: goto -> 1018
    //   836: iconst_0
    //   837: istore #12
    //   839: goto -> 1018
    //   842: aload #10
    //   844: instanceof java/lang/Float
    //   847: ifeq -> 875
    //   850: aload #10
    //   852: checkcast java/lang/Float
    //   855: invokevirtual floatValue : ()F
    //   858: fconst_0
    //   859: fcmpl
    //   860: ifne -> 869
    //   863: iconst_1
    //   864: istore #12
    //   866: goto -> 1018
    //   869: iconst_0
    //   870: istore #12
    //   872: goto -> 1018
    //   875: aload #10
    //   877: instanceof java/lang/Double
    //   880: ifeq -> 908
    //   883: aload #10
    //   885: checkcast java/lang/Double
    //   888: invokevirtual doubleValue : ()D
    //   891: dconst_0
    //   892: dcmpl
    //   893: ifne -> 902
    //   896: iconst_1
    //   897: istore #12
    //   899: goto -> 1018
    //   902: iconst_0
    //   903: istore #12
    //   905: goto -> 1018
    //   908: aload #10
    //   910: instanceof java/lang/String
    //   913: ifeq -> 928
    //   916: aload #10
    //   918: ldc ''
    //   920: invokevirtual equals : (Ljava/lang/Object;)Z
    //   923: istore #12
    //   925: goto -> 1018
    //   928: aload #10
    //   930: instanceof com/google/android/gms/internal/measurement/zzdp
    //   933: ifeq -> 949
    //   936: aload #10
    //   938: getstatic com/google/android/gms/internal/measurement/zzdp.zzaby : Lcom/google/android/gms/internal/measurement/zzdp;
    //   941: invokevirtual equals : (Ljava/lang/Object;)Z
    //   944: istore #12
    //   946: goto -> 1018
    //   949: aload #10
    //   951: instanceof com/google/android/gms/internal/measurement/zzgh
    //   954: ifeq -> 984
    //   957: aload #10
    //   959: aload #10
    //   961: checkcast com/google/android/gms/internal/measurement/zzgh
    //   964: invokeinterface zzmm : ()Lcom/google/android/gms/internal/measurement/zzgh;
    //   969: if_acmpne -> 978
    //   972: iconst_1
    //   973: istore #12
    //   975: goto -> 1018
    //   978: iconst_0
    //   979: istore #12
    //   981: goto -> 1018
    //   984: aload #10
    //   986: instanceof java/lang/Enum
    //   989: ifeq -> 1015
    //   992: aload #10
    //   994: checkcast java/lang/Enum
    //   997: invokevirtual ordinal : ()I
    //   1000: ifne -> 1009
    //   1003: iconst_1
    //   1004: istore #12
    //   1006: goto -> 1018
    //   1009: iconst_0
    //   1010: istore #12
    //   1012: goto -> 1018
    //   1015: iconst_0
    //   1016: istore #12
    //   1018: iload #12
    //   1020: ifne -> 1029
    //   1023: iconst_1
    //   1024: istore #12
    //   1026: goto -> 1053
    //   1029: iconst_0
    //   1030: istore #12
    //   1032: goto -> 1053
    //   1035: aload #5
    //   1037: aload_0
    //   1038: iconst_0
    //   1039: anewarray java/lang/Object
    //   1042: invokestatic zza : (Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1045: checkcast java/lang/Boolean
    //   1048: invokevirtual booleanValue : ()Z
    //   1051: istore #12
    //   1053: iload #12
    //   1055: ifeq -> 136
    //   1058: aload_1
    //   1059: iload_2
    //   1060: aload #6
    //   1062: invokestatic zzcs : (Ljava/lang/String;)Ljava/lang/String;
    //   1065: aload #10
    //   1067: invokestatic zzb : (Ljava/lang/StringBuilder;ILjava/lang/String;Ljava/lang/Object;)V
    //   1070: goto -> 136
    //   1073: aload_0
    //   1074: instanceof com/google/android/gms/internal/measurement/zzez$zzc
    //   1077: ifeq -> 1129
    //   1080: aload_0
    //   1081: checkcast com/google/android/gms/internal/measurement/zzez$zzc
    //   1084: getfield zzagt : Lcom/google/android/gms/internal/measurement/zzeq;
    //   1087: invokevirtual iterator : ()Ljava/util/Iterator;
    //   1090: astore #6
    //   1092: aload #6
    //   1094: invokeinterface hasNext : ()Z
    //   1099: ifne -> 1105
    //   1102: goto -> 1129
    //   1105: aload #6
    //   1107: invokeinterface next : ()Ljava/lang/Object;
    //   1112: checkcast java/util/Map$Entry
    //   1115: invokeinterface getKey : ()Ljava/lang/Object;
    //   1120: pop
    //   1121: new java/lang/NoSuchMethodError
    //   1124: dup
    //   1125: invokespecial <init> : ()V
    //   1128: athrow
    //   1129: aload_0
    //   1130: checkcast com/google/android/gms/internal/measurement/zzez
    //   1133: astore_0
    //   1134: aload_0
    //   1135: getfield zzagn : Lcom/google/android/gms/internal/measurement/zzhr;
    //   1138: ifnull -> 1150
    //   1141: aload_0
    //   1142: getfield zzagn : Lcom/google/android/gms/internal/measurement/zzhr;
    //   1145: aload_1
    //   1146: iload_2
    //   1147: invokevirtual zzb : (Ljava/lang/StringBuilder;I)V
    //   1150: return
  }
  
  static final void zzb(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject) {
    if (paramObject instanceof List) {
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext())
        zzb(paramStringBuilder, paramInt, paramString, paramObject.next()); 
      return;
    } 
    if (paramObject instanceof Map) {
      paramObject = ((Map)paramObject).entrySet().iterator();
      while (paramObject.hasNext())
        zzb(paramStringBuilder, paramInt, paramString, paramObject.next()); 
      return;
    } 
    paramStringBuilder.append('\n');
    boolean bool = false;
    byte b = 0;
    int i;
    for (i = 0; i < paramInt; i++)
      paramStringBuilder.append(' '); 
    paramStringBuilder.append(paramString);
    if (paramObject instanceof String) {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(zzhm.zzd(zzdp.zzcn((String)paramObject)));
      paramStringBuilder.append('"');
      return;
    } 
    if (paramObject instanceof zzdp) {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(zzhm.zzd((zzdp)paramObject));
      paramStringBuilder.append('"');
      return;
    } 
    if (paramObject instanceof zzez) {
      paramStringBuilder.append(" {");
      zza((zzez)paramObject, paramStringBuilder, paramInt + 2);
      paramStringBuilder.append("\n");
      for (i = b; i < paramInt; i++)
        paramStringBuilder.append(' '); 
      paramStringBuilder.append("}");
      return;
    } 
    if (paramObject instanceof Map.Entry) {
      paramStringBuilder.append(" {");
      Map.Entry entry = (Map.Entry)paramObject;
      i = paramInt + 2;
      zzb(paramStringBuilder, i, "key", entry.getKey());
      zzb(paramStringBuilder, i, "value", entry.getValue());
      paramStringBuilder.append("\n");
      for (i = bool; i < paramInt; i++)
        paramStringBuilder.append(' '); 
      paramStringBuilder.append("}");
      return;
    } 
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject.toString());
  }
  
  private static final String zzcs(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < paramString.length(); b++) {
      char c = paramString.charAt(b);
      if (Character.isUpperCase(c))
        stringBuilder.append("_"); 
      stringBuilder.append(Character.toLowerCase(c));
    } 
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */