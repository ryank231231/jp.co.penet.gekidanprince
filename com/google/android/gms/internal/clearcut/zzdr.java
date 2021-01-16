package com.google.android.gms.internal.clearcut;

import java.util.List;
import java.util.Map;

final class zzdr {
  static String zza(zzdo paramzzdo, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("# ");
    stringBuilder.append(paramString);
    zza(paramzzdo, stringBuilder, 0);
    return stringBuilder.toString();
  }
  
  private static void zza(zzdo paramzzdo, StringBuilder paramStringBuilder, int paramInt) {
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
    //   143: ifeq -> 1024
    //   146: aload #9
    //   148: invokeinterface next : ()Ljava/lang/Object;
    //   153: checkcast java/lang/String
    //   156: astore #6
    //   158: aload #6
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
    //   230: astore #5
    //   232: aload #5
    //   234: invokevirtual length : ()I
    //   237: ifeq -> 252
    //   240: aload #11
    //   242: aload #5
    //   244: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   247: astore #5
    //   249: goto -> 263
    //   252: new java/lang/String
    //   255: dup
    //   256: aload #11
    //   258: invokespecial <init> : (Ljava/lang/String;)V
    //   261: astore #5
    //   263: aload_3
    //   264: aload #6
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
    //   296: aload #5
    //   298: invokestatic zzj : (Ljava/lang/String;)Ljava/lang/String;
    //   301: aload #11
    //   303: aload_0
    //   304: iconst_0
    //   305: anewarray java/lang/Object
    //   308: invokestatic zza : (Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   311: invokestatic zza : (Ljava/lang/StringBuilder;ILjava/lang/String;Ljava/lang/Object;)V
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
    //   350: astore #5
    //   352: aload #10
    //   354: iconst_1
    //   355: aload #10
    //   357: invokevirtual length : ()I
    //   360: iconst_3
    //   361: isub
    //   362: invokevirtual substring : (II)Ljava/lang/String;
    //   365: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   368: astore #11
    //   370: aload #11
    //   372: invokevirtual length : ()I
    //   375: ifeq -> 390
    //   378: aload #5
    //   380: aload #11
    //   382: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   385: astore #5
    //   387: goto -> 401
    //   390: new java/lang/String
    //   393: dup
    //   394: aload #5
    //   396: invokespecial <init> : (Ljava/lang/String;)V
    //   399: astore #5
    //   401: aload_3
    //   402: aload #6
    //   404: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   409: checkcast java/lang/reflect/Method
    //   412: astore #6
    //   414: aload #6
    //   416: ifnull -> 476
    //   419: aload #6
    //   421: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   424: ldc java/util/Map
    //   426: invokevirtual equals : (Ljava/lang/Object;)Z
    //   429: ifeq -> 476
    //   432: aload #6
    //   434: ldc java/lang/Deprecated
    //   436: invokevirtual isAnnotationPresent : (Ljava/lang/Class;)Z
    //   439: ifne -> 476
    //   442: aload #6
    //   444: invokevirtual getModifiers : ()I
    //   447: invokestatic isPublic : (I)Z
    //   450: ifeq -> 476
    //   453: aload_1
    //   454: iload_2
    //   455: aload #5
    //   457: invokestatic zzj : (Ljava/lang/String;)Ljava/lang/String;
    //   460: aload #6
    //   462: aload_0
    //   463: iconst_0
    //   464: anewarray java/lang/Object
    //   467: invokestatic zza : (Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   470: invokestatic zza : (Ljava/lang/StringBuilder;ILjava/lang/String;Ljava/lang/Object;)V
    //   473: goto -> 136
    //   476: aload #10
    //   478: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   481: astore #5
    //   483: aload #5
    //   485: invokevirtual length : ()I
    //   488: ifeq -> 503
    //   491: ldc 'set'
    //   493: aload #5
    //   495: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   498: astore #5
    //   500: goto -> 514
    //   503: new java/lang/String
    //   506: dup
    //   507: ldc 'set'
    //   509: invokespecial <init> : (Ljava/lang/String;)V
    //   512: astore #5
    //   514: aload #4
    //   516: aload #5
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
    //   555: astore #5
    //   557: aload #5
    //   559: invokevirtual length : ()I
    //   562: ifeq -> 577
    //   565: ldc 'get'
    //   567: aload #5
    //   569: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   572: astore #5
    //   574: goto -> 588
    //   577: new java/lang/String
    //   580: dup
    //   581: ldc 'get'
    //   583: invokespecial <init> : (Ljava/lang/String;)V
    //   586: astore #5
    //   588: aload_3
    //   589: aload #5
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
    //   640: astore #5
    //   642: goto -> 656
    //   645: new java/lang/String
    //   648: dup
    //   649: aload #5
    //   651: invokespecial <init> : (Ljava/lang/String;)V
    //   654: astore #5
    //   656: aload #10
    //   658: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   661: astore #6
    //   663: aload #6
    //   665: invokevirtual length : ()I
    //   668: ifeq -> 683
    //   671: ldc 'get'
    //   673: aload #6
    //   675: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   678: astore #6
    //   680: goto -> 694
    //   683: new java/lang/String
    //   686: dup
    //   687: ldc 'get'
    //   689: invokespecial <init> : (Ljava/lang/String;)V
    //   692: astore #6
    //   694: aload_3
    //   695: aload #6
    //   697: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   702: checkcast java/lang/reflect/Method
    //   705: astore #11
    //   707: aload #10
    //   709: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   712: astore #6
    //   714: aload #6
    //   716: invokevirtual length : ()I
    //   719: ifeq -> 734
    //   722: ldc 'has'
    //   724: aload #6
    //   726: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   729: astore #6
    //   731: goto -> 745
    //   734: new java/lang/String
    //   737: dup
    //   738: ldc 'has'
    //   740: invokespecial <init> : (Ljava/lang/String;)V
    //   743: astore #6
    //   745: aload_3
    //   746: aload #6
    //   748: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   753: checkcast java/lang/reflect/Method
    //   756: astore #6
    //   758: aload #11
    //   760: ifnull -> 136
    //   763: aload #11
    //   765: aload_0
    //   766: iconst_0
    //   767: anewarray java/lang/Object
    //   770: invokestatic zza : (Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   773: astore #10
    //   775: aload #6
    //   777: ifnonnull -> 986
    //   780: aload #10
    //   782: instanceof java/lang/Boolean
    //   785: ifeq -> 811
    //   788: aload #10
    //   790: checkcast java/lang/Boolean
    //   793: invokevirtual booleanValue : ()Z
    //   796: ifne -> 805
    //   799: iconst_1
    //   800: istore #12
    //   802: goto -> 969
    //   805: iconst_0
    //   806: istore #12
    //   808: goto -> 969
    //   811: aload #10
    //   813: instanceof java/lang/Integer
    //   816: ifeq -> 833
    //   819: aload #10
    //   821: checkcast java/lang/Integer
    //   824: invokevirtual intValue : ()I
    //   827: ifne -> 805
    //   830: goto -> 799
    //   833: aload #10
    //   835: instanceof java/lang/Float
    //   838: ifeq -> 857
    //   841: aload #10
    //   843: checkcast java/lang/Float
    //   846: invokevirtual floatValue : ()F
    //   849: fconst_0
    //   850: fcmpl
    //   851: ifne -> 805
    //   854: goto -> 799
    //   857: aload #10
    //   859: instanceof java/lang/Double
    //   862: ifeq -> 881
    //   865: aload #10
    //   867: checkcast java/lang/Double
    //   870: invokevirtual doubleValue : ()D
    //   873: dconst_0
    //   874: dcmpl
    //   875: ifne -> 805
    //   878: goto -> 799
    //   881: aload #10
    //   883: instanceof java/lang/String
    //   886: ifeq -> 905
    //   889: ldc ''
    //   891: astore #6
    //   893: aload #10
    //   895: aload #6
    //   897: invokevirtual equals : (Ljava/lang/Object;)Z
    //   900: istore #12
    //   902: goto -> 969
    //   905: aload #10
    //   907: instanceof com/google/android/gms/internal/clearcut/zzbb
    //   910: ifeq -> 921
    //   913: getstatic com/google/android/gms/internal/clearcut/zzbb.zzfi : Lcom/google/android/gms/internal/clearcut/zzbb;
    //   916: astore #6
    //   918: goto -> 893
    //   921: aload #10
    //   923: instanceof com/google/android/gms/internal/clearcut/zzdo
    //   926: ifeq -> 947
    //   929: aload #10
    //   931: aload #10
    //   933: checkcast com/google/android/gms/internal/clearcut/zzdo
    //   936: invokeinterface zzbe : ()Lcom/google/android/gms/internal/clearcut/zzdo;
    //   941: if_acmpne -> 805
    //   944: goto -> 799
    //   947: aload #10
    //   949: instanceof java/lang/Enum
    //   952: ifeq -> 805
    //   955: aload #10
    //   957: checkcast java/lang/Enum
    //   960: invokevirtual ordinal : ()I
    //   963: ifne -> 805
    //   966: goto -> 799
    //   969: iload #12
    //   971: ifne -> 980
    //   974: iconst_1
    //   975: istore #12
    //   977: goto -> 1004
    //   980: iconst_0
    //   981: istore #12
    //   983: goto -> 1004
    //   986: aload #6
    //   988: aload_0
    //   989: iconst_0
    //   990: anewarray java/lang/Object
    //   993: invokestatic zza : (Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   996: checkcast java/lang/Boolean
    //   999: invokevirtual booleanValue : ()Z
    //   1002: istore #12
    //   1004: iload #12
    //   1006: ifeq -> 136
    //   1009: aload_1
    //   1010: iload_2
    //   1011: aload #5
    //   1013: invokestatic zzj : (Ljava/lang/String;)Ljava/lang/String;
    //   1016: aload #10
    //   1018: invokestatic zza : (Ljava/lang/StringBuilder;ILjava/lang/String;Ljava/lang/Object;)V
    //   1021: goto -> 136
    //   1024: aload_0
    //   1025: instanceof com/google/android/gms/internal/clearcut/zzcg$zzd
    //   1028: ifeq -> 1135
    //   1031: aload_0
    //   1032: checkcast com/google/android/gms/internal/clearcut/zzcg$zzd
    //   1035: getfield zzjv : Lcom/google/android/gms/internal/clearcut/zzby;
    //   1038: invokevirtual iterator : ()Ljava/util/Iterator;
    //   1041: astore #4
    //   1043: aload #4
    //   1045: invokeinterface hasNext : ()Z
    //   1050: ifeq -> 1135
    //   1053: aload #4
    //   1055: invokeinterface next : ()Ljava/lang/Object;
    //   1060: checkcast java/util/Map$Entry
    //   1063: astore #5
    //   1065: aload #5
    //   1067: invokeinterface getKey : ()Ljava/lang/Object;
    //   1072: checkcast com/google/android/gms/internal/clearcut/zzcg$zze
    //   1075: getfield number : I
    //   1078: istore #8
    //   1080: new java/lang/StringBuilder
    //   1083: dup
    //   1084: bipush #13
    //   1086: invokespecial <init> : (I)V
    //   1089: astore #6
    //   1091: aload #6
    //   1093: ldc '['
    //   1095: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: pop
    //   1099: aload #6
    //   1101: iload #8
    //   1103: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1106: pop
    //   1107: aload #6
    //   1109: ldc ']'
    //   1111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: pop
    //   1115: aload_1
    //   1116: iload_2
    //   1117: aload #6
    //   1119: invokevirtual toString : ()Ljava/lang/String;
    //   1122: aload #5
    //   1124: invokeinterface getValue : ()Ljava/lang/Object;
    //   1129: invokestatic zza : (Ljava/lang/StringBuilder;ILjava/lang/String;Ljava/lang/Object;)V
    //   1132: goto -> 1043
    //   1135: aload_0
    //   1136: checkcast com/google/android/gms/internal/clearcut/zzcg
    //   1139: astore_0
    //   1140: aload_0
    //   1141: getfield zzjp : Lcom/google/android/gms/internal/clearcut/zzey;
    //   1144: ifnull -> 1156
    //   1147: aload_0
    //   1148: getfield zzjp : Lcom/google/android/gms/internal/clearcut/zzey;
    //   1151: aload_1
    //   1152: iload_2
    //   1153: invokevirtual zza : (Ljava/lang/StringBuilder;I)V
    //   1156: return
  }
  
  static final void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject) {
    if (paramObject instanceof List) {
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext())
        zza(paramStringBuilder, paramInt, paramString, paramObject.next()); 
      return;
    } 
    if (paramObject instanceof Map) {
      paramObject = ((Map)paramObject).entrySet().iterator();
      while (paramObject.hasNext())
        zza(paramStringBuilder, paramInt, paramString, paramObject.next()); 
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
      paramStringBuilder.append(zzet.zzc(zzbb.zzf((String)paramObject)));
      paramStringBuilder.append('"');
      return;
    } 
    if (paramObject instanceof zzbb) {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(zzet.zzc((zzbb)paramObject));
      paramStringBuilder.append('"');
      return;
    } 
    if (paramObject instanceof zzcg) {
      paramStringBuilder.append(" {");
      zza((zzcg)paramObject, paramStringBuilder, paramInt + 2);
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
      zza(paramStringBuilder, i, "key", entry.getKey());
      zza(paramStringBuilder, i, "value", entry.getValue());
      paramStringBuilder.append("\n");
      for (i = bool; i < paramInt; i++)
        paramStringBuilder.append(' '); 
      paramStringBuilder.append("}");
      return;
    } 
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject.toString());
  }
  
  private static final String zzj(String paramString) {
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


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzdr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */