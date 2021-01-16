package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;

class Chain {
  private static final boolean DEBUG = false;
  
  static void applyChainConstraints(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt) {
    int i;
    ChainHead[] arrayOfChainHead;
    byte b2;
    byte b1 = 0;
    if (paramInt == 0) {
      i = paramConstraintWidgetContainer.mHorizontalChainsSize;
      arrayOfChainHead = paramConstraintWidgetContainer.mHorizontalChainsArray;
      b2 = 0;
    } else {
      b2 = 2;
      i = paramConstraintWidgetContainer.mVerticalChainsSize;
      arrayOfChainHead = paramConstraintWidgetContainer.mVerticalChainsArray;
    } 
    while (b1 < i) {
      ChainHead chainHead = arrayOfChainHead[b1];
      chainHead.define();
      if (paramConstraintWidgetContainer.optimizeFor(4)) {
        if (!Optimizer.applyChainOptimized(paramConstraintWidgetContainer, paramLinearSystem, paramInt, b2, chainHead))
          applyChainConstraints(paramConstraintWidgetContainer, paramLinearSystem, paramInt, b2, chainHead); 
      } else {
        applyChainConstraints(paramConstraintWidgetContainer, paramLinearSystem, paramInt, b2, chainHead);
      } 
      b1++;
    } 
  }
  
  static void applyChainConstraints(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt1, int paramInt2, ChainHead paramChainHead) {
    // Byte code:
    //   0: aload #4
    //   2: getfield mFirst : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   5: astore #5
    //   7: aload #4
    //   9: getfield mLast : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   12: astore #6
    //   14: aload #4
    //   16: getfield mFirstVisibleWidget : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   19: astore #7
    //   21: aload #4
    //   23: getfield mLastVisibleWidget : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   26: astore #8
    //   28: aload #4
    //   30: getfield mHead : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   33: astore #9
    //   35: aload #4
    //   37: getfield mTotalWeight : F
    //   40: fstore #10
    //   42: aload #4
    //   44: getfield mFirstMatchConstraintWidget : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   47: astore #11
    //   49: aload #4
    //   51: getfield mLastMatchConstraintWidget : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   54: astore #11
    //   56: aload_0
    //   57: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   60: iload_2
    //   61: aaload
    //   62: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   65: if_acmpne -> 74
    //   68: iconst_1
    //   69: istore #12
    //   71: goto -> 77
    //   74: iconst_0
    //   75: istore #12
    //   77: iload_2
    //   78: ifne -> 160
    //   81: aload #9
    //   83: getfield mHorizontalChainStyle : I
    //   86: ifne -> 95
    //   89: iconst_1
    //   90: istore #13
    //   92: goto -> 98
    //   95: iconst_0
    //   96: istore #13
    //   98: aload #9
    //   100: getfield mHorizontalChainStyle : I
    //   103: iconst_1
    //   104: if_icmpne -> 113
    //   107: iconst_1
    //   108: istore #14
    //   110: goto -> 116
    //   113: iconst_0
    //   114: istore #14
    //   116: aload #9
    //   118: getfield mHorizontalChainStyle : I
    //   121: iconst_2
    //   122: if_icmpne -> 131
    //   125: iconst_1
    //   126: istore #15
    //   128: goto -> 134
    //   131: iconst_0
    //   132: istore #15
    //   134: iload #13
    //   136: istore #16
    //   138: aload #5
    //   140: astore #11
    //   142: iload #14
    //   144: istore #17
    //   146: iconst_0
    //   147: istore #13
    //   149: iload #15
    //   151: istore #18
    //   153: iload #16
    //   155: istore #14
    //   157: goto -> 236
    //   160: aload #9
    //   162: getfield mVerticalChainStyle : I
    //   165: ifne -> 174
    //   168: iconst_1
    //   169: istore #13
    //   171: goto -> 177
    //   174: iconst_0
    //   175: istore #13
    //   177: aload #9
    //   179: getfield mVerticalChainStyle : I
    //   182: iconst_1
    //   183: if_icmpne -> 192
    //   186: iconst_1
    //   187: istore #14
    //   189: goto -> 195
    //   192: iconst_0
    //   193: istore #14
    //   195: aload #9
    //   197: getfield mVerticalChainStyle : I
    //   200: iconst_2
    //   201: if_icmpne -> 210
    //   204: iconst_1
    //   205: istore #15
    //   207: goto -> 213
    //   210: iconst_0
    //   211: istore #15
    //   213: aload #5
    //   215: astore #11
    //   217: iconst_0
    //   218: istore #16
    //   220: iload #14
    //   222: istore #17
    //   224: iload #13
    //   226: istore #14
    //   228: iload #15
    //   230: istore #18
    //   232: iload #16
    //   234: istore #13
    //   236: aconst_null
    //   237: astore #19
    //   239: aconst_null
    //   240: astore #20
    //   242: iload #13
    //   244: ifne -> 621
    //   247: aload #11
    //   249: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   252: iload_3
    //   253: aaload
    //   254: astore #21
    //   256: iload #12
    //   258: ifne -> 275
    //   261: iload #18
    //   263: ifeq -> 269
    //   266: goto -> 275
    //   269: iconst_4
    //   270: istore #15
    //   272: goto -> 278
    //   275: iconst_1
    //   276: istore #15
    //   278: aload #21
    //   280: invokevirtual getMargin : ()I
    //   283: istore #16
    //   285: aload #21
    //   287: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   290: ifnull -> 316
    //   293: aload #11
    //   295: aload #5
    //   297: if_acmpeq -> 316
    //   300: iload #16
    //   302: aload #21
    //   304: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   307: invokevirtual getMargin : ()I
    //   310: iadd
    //   311: istore #16
    //   313: goto -> 316
    //   316: iload #18
    //   318: ifeq -> 342
    //   321: aload #11
    //   323: aload #5
    //   325: if_acmpeq -> 342
    //   328: aload #11
    //   330: aload #7
    //   332: if_acmpeq -> 342
    //   335: bipush #6
    //   337: istore #15
    //   339: goto -> 358
    //   342: iload #14
    //   344: ifeq -> 358
    //   347: iload #12
    //   349: ifeq -> 358
    //   352: iconst_4
    //   353: istore #15
    //   355: goto -> 358
    //   358: aload #21
    //   360: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   363: ifnull -> 442
    //   366: aload #11
    //   368: aload #7
    //   370: if_acmpne -> 396
    //   373: aload_1
    //   374: aload #21
    //   376: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   379: aload #21
    //   381: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   384: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   387: iload #16
    //   389: iconst_5
    //   390: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   393: goto -> 417
    //   396: aload_1
    //   397: aload #21
    //   399: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   402: aload #21
    //   404: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   407: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   410: iload #16
    //   412: bipush #6
    //   414: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   417: aload_1
    //   418: aload #21
    //   420: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   423: aload #21
    //   425: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   428: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   431: iload #16
    //   433: iload #15
    //   435: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   438: pop
    //   439: goto -> 442
    //   442: iload #12
    //   444: ifeq -> 527
    //   447: aload #11
    //   449: invokevirtual getVisibility : ()I
    //   452: bipush #8
    //   454: if_icmpeq -> 501
    //   457: aload #11
    //   459: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   462: iload_2
    //   463: aaload
    //   464: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   467: if_acmpne -> 501
    //   470: aload_1
    //   471: aload #11
    //   473: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   476: iload_3
    //   477: iconst_1
    //   478: iadd
    //   479: aaload
    //   480: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   483: aload #11
    //   485: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   488: iload_3
    //   489: aaload
    //   490: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   493: iconst_0
    //   494: iconst_5
    //   495: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   498: goto -> 501
    //   501: aload_1
    //   502: aload #11
    //   504: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   507: iload_3
    //   508: aaload
    //   509: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   512: aload_0
    //   513: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   516: iload_3
    //   517: aaload
    //   518: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   521: iconst_0
    //   522: bipush #6
    //   524: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   527: aload #11
    //   529: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   532: iload_3
    //   533: iconst_1
    //   534: iadd
    //   535: aaload
    //   536: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   539: astore #19
    //   541: aload #20
    //   543: astore #21
    //   545: aload #19
    //   547: ifnull -> 603
    //   550: aload #19
    //   552: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   555: astore #19
    //   557: aload #20
    //   559: astore #21
    //   561: aload #19
    //   563: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   566: iload_3
    //   567: aaload
    //   568: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   571: ifnull -> 603
    //   574: aload #19
    //   576: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   579: iload_3
    //   580: aaload
    //   581: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   584: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   587: aload #11
    //   589: if_acmpeq -> 599
    //   592: aload #20
    //   594: astore #21
    //   596: goto -> 603
    //   599: aload #19
    //   601: astore #21
    //   603: aload #21
    //   605: ifnull -> 615
    //   608: aload #21
    //   610: astore #11
    //   612: goto -> 618
    //   615: iconst_1
    //   616: istore #13
    //   618: goto -> 236
    //   621: aload #8
    //   623: ifnull -> 692
    //   626: aload #6
    //   628: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   631: astore #11
    //   633: iload_3
    //   634: iconst_1
    //   635: iadd
    //   636: istore #13
    //   638: aload #11
    //   640: iload #13
    //   642: aaload
    //   643: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   646: ifnull -> 692
    //   649: aload #8
    //   651: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   654: iload #13
    //   656: aaload
    //   657: astore #11
    //   659: aload_1
    //   660: aload #11
    //   662: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   665: aload #6
    //   667: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   670: iload #13
    //   672: aaload
    //   673: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   676: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   679: aload #11
    //   681: invokevirtual getMargin : ()I
    //   684: ineg
    //   685: iconst_5
    //   686: invokevirtual addLowerThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   689: goto -> 692
    //   692: iload #12
    //   694: ifeq -> 742
    //   697: aload_0
    //   698: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   701: astore_0
    //   702: iload_3
    //   703: iconst_1
    //   704: iadd
    //   705: istore #13
    //   707: aload_1
    //   708: aload_0
    //   709: iload #13
    //   711: aaload
    //   712: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   715: aload #6
    //   717: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   720: iload #13
    //   722: aaload
    //   723: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   726: aload #6
    //   728: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   731: iload #13
    //   733: aaload
    //   734: invokevirtual getMargin : ()I
    //   737: bipush #6
    //   739: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   742: aload #4
    //   744: getfield mWeightedMatchConstraintsWidgets : Ljava/util/ArrayList;
    //   747: astore_0
    //   748: aload_0
    //   749: ifnull -> 1041
    //   752: aload_0
    //   753: invokevirtual size : ()I
    //   756: istore #15
    //   758: iload #15
    //   760: iconst_1
    //   761: if_icmple -> 1041
    //   764: aload #4
    //   766: getfield mHasUndefinedWeights : Z
    //   769: ifeq -> 791
    //   772: aload #4
    //   774: getfield mHasComplexMatchWeights : Z
    //   777: ifne -> 791
    //   780: aload #4
    //   782: getfield mWidgetsMatchCount : I
    //   785: i2f
    //   786: fstore #22
    //   788: goto -> 795
    //   791: fload #10
    //   793: fstore #22
    //   795: aconst_null
    //   796: astore #11
    //   798: iconst_0
    //   799: istore #13
    //   801: fconst_0
    //   802: fstore #23
    //   804: iload #13
    //   806: iload #15
    //   808: if_icmpge -> 1041
    //   811: aload_0
    //   812: iload #13
    //   814: invokevirtual get : (I)Ljava/lang/Object;
    //   817: checkcast android/support/constraint/solver/widgets/ConstraintWidget
    //   820: astore #21
    //   822: aload #21
    //   824: getfield mWeight : [F
    //   827: iload_2
    //   828: faload
    //   829: fstore #10
    //   831: fload #10
    //   833: fconst_0
    //   834: fcmpg
    //   835: ifge -> 884
    //   838: aload #4
    //   840: getfield mHasComplexMatchWeights : Z
    //   843: ifeq -> 878
    //   846: aload_1
    //   847: aload #21
    //   849: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   852: iload_3
    //   853: iconst_1
    //   854: iadd
    //   855: aaload
    //   856: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   859: aload #21
    //   861: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   864: iload_3
    //   865: aaload
    //   866: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   869: iconst_0
    //   870: iconst_4
    //   871: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   874: pop
    //   875: goto -> 921
    //   878: fconst_1
    //   879: fstore #10
    //   881: goto -> 884
    //   884: fload #10
    //   886: fconst_0
    //   887: fcmpl
    //   888: ifne -> 928
    //   891: aload_1
    //   892: aload #21
    //   894: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   897: iload_3
    //   898: iconst_1
    //   899: iadd
    //   900: aaload
    //   901: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   904: aload #21
    //   906: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   909: iload_3
    //   910: aaload
    //   911: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   914: iconst_0
    //   915: bipush #6
    //   917: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   920: pop
    //   921: fload #23
    //   923: fstore #10
    //   925: goto -> 1031
    //   928: aload #11
    //   930: ifnull -> 1027
    //   933: aload #11
    //   935: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   938: iload_3
    //   939: aaload
    //   940: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   943: astore #20
    //   945: aload #11
    //   947: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   950: astore #11
    //   952: iload_3
    //   953: iconst_1
    //   954: iadd
    //   955: istore #12
    //   957: aload #11
    //   959: iload #12
    //   961: aaload
    //   962: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   965: astore #24
    //   967: aload #21
    //   969: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   972: iload_3
    //   973: aaload
    //   974: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   977: astore #25
    //   979: aload #21
    //   981: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   984: iload #12
    //   986: aaload
    //   987: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   990: astore #26
    //   992: aload_1
    //   993: invokevirtual createRow : ()Landroid/support/constraint/solver/ArrayRow;
    //   996: astore #11
    //   998: aload #11
    //   1000: fload #23
    //   1002: fload #22
    //   1004: fload #10
    //   1006: aload #20
    //   1008: aload #24
    //   1010: aload #25
    //   1012: aload #26
    //   1014: invokevirtual createRowEqualMatchDimensions : (FFFLandroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;)Landroid/support/constraint/solver/ArrayRow;
    //   1017: pop
    //   1018: aload_1
    //   1019: aload #11
    //   1021: invokevirtual addConstraint : (Landroid/support/constraint/solver/ArrayRow;)V
    //   1024: goto -> 1027
    //   1027: aload #21
    //   1029: astore #11
    //   1031: iinc #13, 1
    //   1034: fload #10
    //   1036: fstore #23
    //   1038: goto -> 804
    //   1041: aload #7
    //   1043: ifnull -> 1247
    //   1046: aload #7
    //   1048: aload #8
    //   1050: if_acmpeq -> 1058
    //   1053: iload #18
    //   1055: ifeq -> 1247
    //   1058: aload #5
    //   1060: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1063: iload_3
    //   1064: aaload
    //   1065: astore #21
    //   1067: aload #6
    //   1069: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1072: astore_0
    //   1073: iload_3
    //   1074: iconst_1
    //   1075: iadd
    //   1076: istore #13
    //   1078: aload_0
    //   1079: iload #13
    //   1081: aaload
    //   1082: astore #11
    //   1084: aload #5
    //   1086: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1089: iload_3
    //   1090: aaload
    //   1091: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1094: ifnull -> 1114
    //   1097: aload #5
    //   1099: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1102: iload_3
    //   1103: aaload
    //   1104: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1107: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1110: astore_0
    //   1111: goto -> 1116
    //   1114: aconst_null
    //   1115: astore_0
    //   1116: aload #6
    //   1118: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1121: iload #13
    //   1123: aaload
    //   1124: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1127: ifnull -> 1149
    //   1130: aload #6
    //   1132: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1135: iload #13
    //   1137: aaload
    //   1138: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1141: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1144: astore #4
    //   1146: goto -> 1152
    //   1149: aconst_null
    //   1150: astore #4
    //   1152: aload #7
    //   1154: aload #8
    //   1156: if_acmpne -> 1178
    //   1159: aload #7
    //   1161: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1164: iload_3
    //   1165: aaload
    //   1166: astore #21
    //   1168: aload #7
    //   1170: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1173: iload #13
    //   1175: aaload
    //   1176: astore #11
    //   1178: aload_0
    //   1179: ifnull -> 2237
    //   1182: aload #4
    //   1184: ifnull -> 2237
    //   1187: iload_2
    //   1188: ifne -> 1201
    //   1191: aload #9
    //   1193: getfield mHorizontalBiasPercent : F
    //   1196: fstore #10
    //   1198: goto -> 1208
    //   1201: aload #9
    //   1203: getfield mVerticalBiasPercent : F
    //   1206: fstore #10
    //   1208: aload #21
    //   1210: invokevirtual getMargin : ()I
    //   1213: istore_2
    //   1214: aload #11
    //   1216: invokevirtual getMargin : ()I
    //   1219: istore #13
    //   1221: aload_1
    //   1222: aload #21
    //   1224: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1227: aload_0
    //   1228: iload_2
    //   1229: fload #10
    //   1231: aload #4
    //   1233: aload #11
    //   1235: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1238: iload #13
    //   1240: iconst_5
    //   1241: invokevirtual addCentering : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;IFLandroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   1244: goto -> 2237
    //   1247: iload #14
    //   1249: ifeq -> 1711
    //   1252: aload #7
    //   1254: ifnull -> 1711
    //   1257: aload #4
    //   1259: getfield mWidgetsMatchCount : I
    //   1262: ifle -> 1284
    //   1265: aload #4
    //   1267: getfield mWidgetsCount : I
    //   1270: aload #4
    //   1272: getfield mWidgetsMatchCount : I
    //   1275: if_icmpne -> 1284
    //   1278: iconst_1
    //   1279: istore #12
    //   1281: goto -> 1287
    //   1284: iconst_0
    //   1285: istore #12
    //   1287: aload #7
    //   1289: astore_0
    //   1290: aload_0
    //   1291: astore #4
    //   1293: aload_0
    //   1294: astore #21
    //   1296: aload #4
    //   1298: ifnull -> 2237
    //   1301: aload #4
    //   1303: getfield mListNextVisibleWidget : [Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1306: iload_2
    //   1307: aaload
    //   1308: astore #25
    //   1310: aload #25
    //   1312: ifnonnull -> 1328
    //   1315: aload #4
    //   1317: aload #8
    //   1319: if_acmpne -> 1325
    //   1322: goto -> 1328
    //   1325: goto -> 1698
    //   1328: aload #4
    //   1330: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1333: iload_3
    //   1334: aaload
    //   1335: astore #9
    //   1337: aload #9
    //   1339: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1342: astore #26
    //   1344: aload #9
    //   1346: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1349: ifnull -> 1365
    //   1352: aload #9
    //   1354: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1357: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1360: astore #11
    //   1362: goto -> 1368
    //   1365: aconst_null
    //   1366: astore #11
    //   1368: aload #21
    //   1370: aload #4
    //   1372: if_acmpeq -> 1391
    //   1375: aload #21
    //   1377: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1380: iload_3
    //   1381: iconst_1
    //   1382: iadd
    //   1383: aaload
    //   1384: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1387: astore_0
    //   1388: goto -> 1443
    //   1391: aload #11
    //   1393: astore_0
    //   1394: aload #4
    //   1396: aload #7
    //   1398: if_acmpne -> 1443
    //   1401: aload #11
    //   1403: astore_0
    //   1404: aload #21
    //   1406: aload #4
    //   1408: if_acmpne -> 1443
    //   1411: aload #5
    //   1413: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1416: iload_3
    //   1417: aaload
    //   1418: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1421: ifnull -> 1441
    //   1424: aload #5
    //   1426: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1429: iload_3
    //   1430: aaload
    //   1431: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1434: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1437: astore_0
    //   1438: goto -> 1443
    //   1441: aconst_null
    //   1442: astore_0
    //   1443: aload #9
    //   1445: invokevirtual getMargin : ()I
    //   1448: istore #18
    //   1450: aload #4
    //   1452: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1455: astore #11
    //   1457: iload_3
    //   1458: iconst_1
    //   1459: iadd
    //   1460: istore #16
    //   1462: aload #11
    //   1464: iload #16
    //   1466: aaload
    //   1467: invokevirtual getMargin : ()I
    //   1470: istore #15
    //   1472: aload #25
    //   1474: ifnull -> 1509
    //   1477: aload #25
    //   1479: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1482: iload_3
    //   1483: aaload
    //   1484: astore #9
    //   1486: aload #9
    //   1488: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1491: astore #11
    //   1493: aload #4
    //   1495: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1498: iload #16
    //   1500: aaload
    //   1501: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1504: astore #20
    //   1506: goto -> 1553
    //   1509: aload #6
    //   1511: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1514: iload #16
    //   1516: aaload
    //   1517: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1520: astore #9
    //   1522: aload #9
    //   1524: ifnull -> 1537
    //   1527: aload #9
    //   1529: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1532: astore #11
    //   1534: goto -> 1540
    //   1537: aconst_null
    //   1538: astore #11
    //   1540: aload #4
    //   1542: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1545: iload #16
    //   1547: aaload
    //   1548: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1551: astore #20
    //   1553: iload #15
    //   1555: istore #13
    //   1557: aload #9
    //   1559: ifnull -> 1572
    //   1562: iload #15
    //   1564: aload #9
    //   1566: invokevirtual getMargin : ()I
    //   1569: iadd
    //   1570: istore #13
    //   1572: iload #18
    //   1574: istore #15
    //   1576: aload #21
    //   1578: ifnull -> 1597
    //   1581: iload #18
    //   1583: aload #21
    //   1585: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1588: iload #16
    //   1590: aaload
    //   1591: invokevirtual getMargin : ()I
    //   1594: iadd
    //   1595: istore #15
    //   1597: aload #26
    //   1599: ifnull -> 1698
    //   1602: aload_0
    //   1603: ifnull -> 1698
    //   1606: aload #11
    //   1608: ifnull -> 1698
    //   1611: aload #20
    //   1613: ifnull -> 1698
    //   1616: aload #4
    //   1618: aload #7
    //   1620: if_acmpne -> 1638
    //   1623: aload #7
    //   1625: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1628: iload_3
    //   1629: aaload
    //   1630: invokevirtual getMargin : ()I
    //   1633: istore #15
    //   1635: goto -> 1638
    //   1638: aload #4
    //   1640: aload #8
    //   1642: if_acmpne -> 1661
    //   1645: aload #8
    //   1647: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1650: iload #16
    //   1652: aaload
    //   1653: invokevirtual getMargin : ()I
    //   1656: istore #13
    //   1658: goto -> 1661
    //   1661: iload #12
    //   1663: ifeq -> 1673
    //   1666: bipush #6
    //   1668: istore #18
    //   1670: goto -> 1676
    //   1673: iconst_4
    //   1674: istore #18
    //   1676: aload_1
    //   1677: aload #26
    //   1679: aload_0
    //   1680: iload #15
    //   1682: ldc 0.5
    //   1684: aload #11
    //   1686: aload #20
    //   1688: iload #13
    //   1690: iload #18
    //   1692: invokevirtual addCentering : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;IFLandroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   1695: goto -> 1698
    //   1698: aload #25
    //   1700: astore_0
    //   1701: aload #4
    //   1703: astore #21
    //   1705: aload_0
    //   1706: astore #4
    //   1708: goto -> 1296
    //   1711: iload #17
    //   1713: ifeq -> 2237
    //   1716: aload #7
    //   1718: ifnull -> 2237
    //   1721: aload #4
    //   1723: getfield mWidgetsMatchCount : I
    //   1726: ifle -> 1748
    //   1729: aload #4
    //   1731: getfield mWidgetsCount : I
    //   1734: aload #4
    //   1736: getfield mWidgetsMatchCount : I
    //   1739: if_icmpne -> 1748
    //   1742: iconst_1
    //   1743: istore #13
    //   1745: goto -> 1751
    //   1748: iconst_0
    //   1749: istore #13
    //   1751: aload #7
    //   1753: astore #4
    //   1755: aload #4
    //   1757: astore_0
    //   1758: aload #4
    //   1760: astore #9
    //   1762: aload_0
    //   1763: ifnull -> 2080
    //   1766: aload_0
    //   1767: getfield mListNextVisibleWidget : [Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1770: iload_2
    //   1771: aaload
    //   1772: astore #4
    //   1774: aload_0
    //   1775: aload #7
    //   1777: if_acmpeq -> 2071
    //   1780: aload_0
    //   1781: aload #8
    //   1783: if_acmpeq -> 2071
    //   1786: aload #4
    //   1788: ifnull -> 2071
    //   1791: aload #4
    //   1793: aload #8
    //   1795: if_acmpne -> 1804
    //   1798: aconst_null
    //   1799: astore #4
    //   1801: goto -> 1804
    //   1804: aload_0
    //   1805: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1808: iload_3
    //   1809: aaload
    //   1810: astore #11
    //   1812: aload #11
    //   1814: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1817: astore #25
    //   1819: aload #11
    //   1821: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1824: ifnull -> 1837
    //   1827: aload #11
    //   1829: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1832: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1835: astore #21
    //   1837: aload #9
    //   1839: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1842: astore #21
    //   1844: iload_3
    //   1845: iconst_1
    //   1846: iadd
    //   1847: istore #18
    //   1849: aload #21
    //   1851: iload #18
    //   1853: aaload
    //   1854: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1857: astore #26
    //   1859: aload #11
    //   1861: invokevirtual getMargin : ()I
    //   1864: istore #12
    //   1866: aload_0
    //   1867: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1870: iload #18
    //   1872: aaload
    //   1873: invokevirtual getMargin : ()I
    //   1876: istore #15
    //   1878: aload #4
    //   1880: ifnull -> 1926
    //   1883: aload #4
    //   1885: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1888: iload_3
    //   1889: aaload
    //   1890: astore #20
    //   1892: aload #20
    //   1894: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1897: astore #21
    //   1899: aload #20
    //   1901: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1904: ifnull -> 1920
    //   1907: aload #20
    //   1909: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1912: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1915: astore #11
    //   1917: goto -> 1968
    //   1920: aconst_null
    //   1921: astore #11
    //   1923: goto -> 1968
    //   1926: aload_0
    //   1927: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1930: iload #18
    //   1932: aaload
    //   1933: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1936: astore #20
    //   1938: aload #20
    //   1940: ifnull -> 1953
    //   1943: aload #20
    //   1945: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1948: astore #21
    //   1950: goto -> 1956
    //   1953: aconst_null
    //   1954: astore #21
    //   1956: aload_0
    //   1957: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1960: iload #18
    //   1962: aaload
    //   1963: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   1966: astore #11
    //   1968: aload #20
    //   1970: ifnull -> 1986
    //   1973: iload #15
    //   1975: aload #20
    //   1977: invokevirtual getMargin : ()I
    //   1980: iadd
    //   1981: istore #15
    //   1983: goto -> 1986
    //   1986: aload #9
    //   1988: ifnull -> 2010
    //   1991: iload #12
    //   1993: aload #9
    //   1995: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1998: iload #18
    //   2000: aaload
    //   2001: invokevirtual getMargin : ()I
    //   2004: iadd
    //   2005: istore #12
    //   2007: goto -> 2010
    //   2010: iload #13
    //   2012: ifeq -> 2022
    //   2015: bipush #6
    //   2017: istore #18
    //   2019: goto -> 2025
    //   2022: iconst_4
    //   2023: istore #18
    //   2025: aload #25
    //   2027: ifnull -> 2068
    //   2030: aload #26
    //   2032: ifnull -> 2068
    //   2035: aload #21
    //   2037: ifnull -> 2068
    //   2040: aload #11
    //   2042: ifnull -> 2068
    //   2045: aload_1
    //   2046: aload #25
    //   2048: aload #26
    //   2050: iload #12
    //   2052: ldc 0.5
    //   2054: aload #21
    //   2056: aload #11
    //   2058: iload #15
    //   2060: iload #18
    //   2062: invokevirtual addCentering : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;IFLandroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   2065: goto -> 2071
    //   2068: goto -> 2071
    //   2071: aload_0
    //   2072: astore #9
    //   2074: aload #4
    //   2076: astore_0
    //   2077: goto -> 1762
    //   2080: aload #7
    //   2082: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2085: iload_3
    //   2086: aaload
    //   2087: astore_0
    //   2088: aload #5
    //   2090: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2093: iload_3
    //   2094: aaload
    //   2095: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2098: astore #4
    //   2100: aload #8
    //   2102: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2105: astore #11
    //   2107: iload_3
    //   2108: iconst_1
    //   2109: iadd
    //   2110: istore_2
    //   2111: aload #11
    //   2113: iload_2
    //   2114: aaload
    //   2115: astore #11
    //   2117: aload #6
    //   2119: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2122: iload_2
    //   2123: aaload
    //   2124: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2127: astore #21
    //   2129: aload #4
    //   2131: ifnull -> 2203
    //   2134: aload #7
    //   2136: aload #8
    //   2138: if_acmpeq -> 2163
    //   2141: aload_1
    //   2142: aload_0
    //   2143: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   2146: aload #4
    //   2148: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   2151: aload_0
    //   2152: invokevirtual getMargin : ()I
    //   2155: iconst_5
    //   2156: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   2159: pop
    //   2160: goto -> 2203
    //   2163: aload #21
    //   2165: ifnull -> 2203
    //   2168: aload_1
    //   2169: aload_0
    //   2170: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   2173: aload #4
    //   2175: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   2178: aload_0
    //   2179: invokevirtual getMargin : ()I
    //   2182: ldc 0.5
    //   2184: aload #11
    //   2186: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   2189: aload #21
    //   2191: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   2194: aload #11
    //   2196: invokevirtual getMargin : ()I
    //   2199: iconst_5
    //   2200: invokevirtual addCentering : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;IFLandroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   2203: aload #21
    //   2205: ifnull -> 2237
    //   2208: aload #7
    //   2210: aload #8
    //   2212: if_acmpeq -> 2237
    //   2215: aload_1
    //   2216: aload #11
    //   2218: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   2221: aload #21
    //   2223: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   2226: aload #11
    //   2228: invokevirtual getMargin : ()I
    //   2231: ineg
    //   2232: iconst_5
    //   2233: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   2236: pop
    //   2237: iload #14
    //   2239: ifne -> 2247
    //   2242: iload #17
    //   2244: ifeq -> 2450
    //   2247: aload #7
    //   2249: ifnull -> 2450
    //   2252: aload #7
    //   2254: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2257: iload_3
    //   2258: aaload
    //   2259: astore #21
    //   2261: aload #8
    //   2263: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2266: astore_0
    //   2267: iload_3
    //   2268: iconst_1
    //   2269: iadd
    //   2270: istore_2
    //   2271: aload_0
    //   2272: iload_2
    //   2273: aaload
    //   2274: astore #11
    //   2276: aload #21
    //   2278: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2281: ifnull -> 2297
    //   2284: aload #21
    //   2286: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2289: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   2292: astore #4
    //   2294: goto -> 2300
    //   2297: aconst_null
    //   2298: astore #4
    //   2300: aload #11
    //   2302: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2305: ifnull -> 2320
    //   2308: aload #11
    //   2310: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2313: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   2316: astore_0
    //   2317: goto -> 2322
    //   2320: aconst_null
    //   2321: astore_0
    //   2322: aload #6
    //   2324: aload #8
    //   2326: if_acmpeq -> 2361
    //   2329: aload #6
    //   2331: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2334: iload_2
    //   2335: aaload
    //   2336: astore #5
    //   2338: aload #19
    //   2340: astore_0
    //   2341: aload #5
    //   2343: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2346: ifnull -> 2358
    //   2349: aload #5
    //   2351: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2354: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   2357: astore_0
    //   2358: goto -> 2361
    //   2361: aload #7
    //   2363: aload #8
    //   2365: if_acmpne -> 2386
    //   2368: aload #7
    //   2370: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2373: iload_3
    //   2374: aaload
    //   2375: astore #21
    //   2377: aload #7
    //   2379: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2382: iload_2
    //   2383: aaload
    //   2384: astore #11
    //   2386: aload #4
    //   2388: ifnull -> 2450
    //   2391: aload_0
    //   2392: ifnull -> 2450
    //   2395: aload #21
    //   2397: invokevirtual getMargin : ()I
    //   2400: istore_3
    //   2401: aload #8
    //   2403: ifnonnull -> 2413
    //   2406: aload #6
    //   2408: astore #7
    //   2410: goto -> 2417
    //   2413: aload #8
    //   2415: astore #7
    //   2417: aload #7
    //   2419: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   2422: iload_2
    //   2423: aaload
    //   2424: invokevirtual getMargin : ()I
    //   2427: istore_2
    //   2428: aload_1
    //   2429: aload #21
    //   2431: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   2434: aload #4
    //   2436: iload_3
    //   2437: ldc 0.5
    //   2439: aload_0
    //   2440: aload #11
    //   2442: getfield mSolverVariable : Landroid/support/constraint/solver/SolverVariable;
    //   2445: iload_2
    //   2446: iconst_5
    //   2447: invokevirtual addCentering : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;IFLandroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   2450: return
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\constraint\solver\widgets\Chain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */