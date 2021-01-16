package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;

public class Optimizer {
  static final int FLAG_CHAIN_DANGLING = 1;
  
  static final int FLAG_RECOMPUTE_BOUNDS = 2;
  
  static final int FLAG_USE_OPTIMIZE = 0;
  
  public static final int OPTIMIZATION_BARRIER = 2;
  
  public static final int OPTIMIZATION_CHAIN = 4;
  
  public static final int OPTIMIZATION_DIMENSIONS = 8;
  
  public static final int OPTIMIZATION_DIRECT = 1;
  
  public static final int OPTIMIZATION_NONE = 0;
  
  public static final int OPTIMIZATION_RATIO = 16;
  
  public static final int OPTIMIZATION_STANDARD = 3;
  
  static boolean[] flags = new boolean[3];
  
  static void analyze(int paramInt, ConstraintWidget paramConstraintWidget) {
    int i;
    paramConstraintWidget.updateResolutionNodes();
    ResolutionAnchor resolutionAnchor1 = paramConstraintWidget.mLeft.getResolutionNode();
    ResolutionAnchor resolutionAnchor2 = paramConstraintWidget.mTop.getResolutionNode();
    ResolutionAnchor resolutionAnchor3 = paramConstraintWidget.mRight.getResolutionNode();
    ResolutionAnchor resolutionAnchor4 = paramConstraintWidget.mBottom.getResolutionNode();
    if ((paramInt & 0x8) == 8) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    if (paramConstraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(paramConstraintWidget, 0)) {
      i = 1;
    } else {
      i = 0;
    } 
    if (resolutionAnchor1.type != 4 && resolutionAnchor3.type != 4)
      if (paramConstraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || (i && paramConstraintWidget.getVisibility() == 8)) {
        if (paramConstraintWidget.mLeft.mTarget == null && paramConstraintWidget.mRight.mTarget == null) {
          resolutionAnchor1.setType(1);
          resolutionAnchor3.setType(1);
          if (paramInt != 0) {
            resolutionAnchor3.dependsOn(resolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
          } else {
            resolutionAnchor3.dependsOn(resolutionAnchor1, paramConstraintWidget.getWidth());
          } 
        } else if (paramConstraintWidget.mLeft.mTarget != null && paramConstraintWidget.mRight.mTarget == null) {
          resolutionAnchor1.setType(1);
          resolutionAnchor3.setType(1);
          if (paramInt != 0) {
            resolutionAnchor3.dependsOn(resolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
          } else {
            resolutionAnchor3.dependsOn(resolutionAnchor1, paramConstraintWidget.getWidth());
          } 
        } else if (paramConstraintWidget.mLeft.mTarget == null && paramConstraintWidget.mRight.mTarget != null) {
          resolutionAnchor1.setType(1);
          resolutionAnchor3.setType(1);
          resolutionAnchor1.dependsOn(resolutionAnchor3, -paramConstraintWidget.getWidth());
          if (paramInt != 0) {
            resolutionAnchor1.dependsOn(resolutionAnchor3, -1, paramConstraintWidget.getResolutionWidth());
          } else {
            resolutionAnchor1.dependsOn(resolutionAnchor3, -paramConstraintWidget.getWidth());
          } 
        } else if (paramConstraintWidget.mLeft.mTarget != null && paramConstraintWidget.mRight.mTarget != null) {
          resolutionAnchor1.setType(2);
          resolutionAnchor3.setType(2);
          if (paramInt != 0) {
            paramConstraintWidget.getResolutionWidth().addDependent(resolutionAnchor1);
            paramConstraintWidget.getResolutionWidth().addDependent(resolutionAnchor3);
            resolutionAnchor1.setOpposite(resolutionAnchor3, -1, paramConstraintWidget.getResolutionWidth());
            resolutionAnchor3.setOpposite(resolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
          } else {
            resolutionAnchor1.setOpposite(resolutionAnchor3, -paramConstraintWidget.getWidth());
            resolutionAnchor3.setOpposite(resolutionAnchor1, paramConstraintWidget.getWidth());
          } 
        } 
      } else if (i) {
        i = paramConstraintWidget.getWidth();
        resolutionAnchor1.setType(1);
        resolutionAnchor3.setType(1);
        if (paramConstraintWidget.mLeft.mTarget == null && paramConstraintWidget.mRight.mTarget == null) {
          if (paramInt != 0) {
            resolutionAnchor3.dependsOn(resolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
          } else {
            resolutionAnchor3.dependsOn(resolutionAnchor1, i);
          } 
        } else if (paramConstraintWidget.mLeft.mTarget != null && paramConstraintWidget.mRight.mTarget == null) {
          if (paramInt != 0) {
            resolutionAnchor3.dependsOn(resolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
          } else {
            resolutionAnchor3.dependsOn(resolutionAnchor1, i);
          } 
        } else if (paramConstraintWidget.mLeft.mTarget == null && paramConstraintWidget.mRight.mTarget != null) {
          if (paramInt != 0) {
            resolutionAnchor1.dependsOn(resolutionAnchor3, -1, paramConstraintWidget.getResolutionWidth());
          } else {
            resolutionAnchor1.dependsOn(resolutionAnchor3, -i);
          } 
        } else if (paramConstraintWidget.mLeft.mTarget != null && paramConstraintWidget.mRight.mTarget != null) {
          if (paramInt != 0) {
            paramConstraintWidget.getResolutionWidth().addDependent(resolutionAnchor1);
            paramConstraintWidget.getResolutionWidth().addDependent(resolutionAnchor3);
          } 
          if (paramConstraintWidget.mDimensionRatio == 0.0F) {
            resolutionAnchor1.setType(3);
            resolutionAnchor3.setType(3);
            resolutionAnchor1.setOpposite(resolutionAnchor3, 0.0F);
            resolutionAnchor3.setOpposite(resolutionAnchor1, 0.0F);
          } else {
            resolutionAnchor1.setType(2);
            resolutionAnchor3.setType(2);
            resolutionAnchor1.setOpposite(resolutionAnchor3, -i);
            resolutionAnchor3.setOpposite(resolutionAnchor1, i);
            paramConstraintWidget.setWidth(i);
          } 
        } 
      }  
    if (paramConstraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(paramConstraintWidget, 1)) {
      i = 1;
    } else {
      i = 0;
    } 
    if (resolutionAnchor2.type != 4 && resolutionAnchor4.type != 4) {
      if (paramConstraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || (i != 0 && paramConstraintWidget.getVisibility() == 8)) {
        if (paramConstraintWidget.mTop.mTarget == null && paramConstraintWidget.mBottom.mTarget == null) {
          resolutionAnchor2.setType(1);
          resolutionAnchor4.setType(1);
          if (paramInt != 0) {
            resolutionAnchor4.dependsOn(resolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
          } else {
            resolutionAnchor4.dependsOn(resolutionAnchor2, paramConstraintWidget.getHeight());
          } 
          if (paramConstraintWidget.mBaseline.mTarget != null) {
            paramConstraintWidget.mBaseline.getResolutionNode().setType(1);
            resolutionAnchor2.dependsOn(1, paramConstraintWidget.mBaseline.getResolutionNode(), -paramConstraintWidget.mBaselineDistance);
          } 
        } else if (paramConstraintWidget.mTop.mTarget != null && paramConstraintWidget.mBottom.mTarget == null) {
          resolutionAnchor2.setType(1);
          resolutionAnchor4.setType(1);
          if (paramInt != 0) {
            resolutionAnchor4.dependsOn(resolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
          } else {
            resolutionAnchor4.dependsOn(resolutionAnchor2, paramConstraintWidget.getHeight());
          } 
          if (paramConstraintWidget.mBaselineDistance > 0)
            paramConstraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionAnchor2, paramConstraintWidget.mBaselineDistance); 
        } else if (paramConstraintWidget.mTop.mTarget == null && paramConstraintWidget.mBottom.mTarget != null) {
          resolutionAnchor2.setType(1);
          resolutionAnchor4.setType(1);
          if (paramInt != 0) {
            resolutionAnchor2.dependsOn(resolutionAnchor4, -1, paramConstraintWidget.getResolutionHeight());
          } else {
            resolutionAnchor2.dependsOn(resolutionAnchor4, -paramConstraintWidget.getHeight());
          } 
          if (paramConstraintWidget.mBaselineDistance > 0)
            paramConstraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionAnchor2, paramConstraintWidget.mBaselineDistance); 
        } else if (paramConstraintWidget.mTop.mTarget != null && paramConstraintWidget.mBottom.mTarget != null) {
          resolutionAnchor2.setType(2);
          resolutionAnchor4.setType(2);
          if (paramInt != 0) {
            resolutionAnchor2.setOpposite(resolutionAnchor4, -1, paramConstraintWidget.getResolutionHeight());
            resolutionAnchor4.setOpposite(resolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
            paramConstraintWidget.getResolutionHeight().addDependent(resolutionAnchor2);
            paramConstraintWidget.getResolutionWidth().addDependent(resolutionAnchor4);
          } else {
            resolutionAnchor2.setOpposite(resolutionAnchor4, -paramConstraintWidget.getHeight());
            resolutionAnchor4.setOpposite(resolutionAnchor2, paramConstraintWidget.getHeight());
          } 
          if (paramConstraintWidget.mBaselineDistance > 0)
            paramConstraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionAnchor2, paramConstraintWidget.mBaselineDistance); 
        } 
        return;
      } 
      if (i != 0) {
        i = paramConstraintWidget.getHeight();
        resolutionAnchor2.setType(1);
        resolutionAnchor4.setType(1);
        if (paramConstraintWidget.mTop.mTarget == null && paramConstraintWidget.mBottom.mTarget == null) {
          if (paramInt != 0) {
            resolutionAnchor4.dependsOn(resolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
          } else {
            resolutionAnchor4.dependsOn(resolutionAnchor2, i);
          } 
        } else if (paramConstraintWidget.mTop.mTarget != null && paramConstraintWidget.mBottom.mTarget == null) {
          if (paramInt != 0) {
            resolutionAnchor4.dependsOn(resolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
          } else {
            resolutionAnchor4.dependsOn(resolutionAnchor2, i);
          } 
        } else if (paramConstraintWidget.mTop.mTarget == null && paramConstraintWidget.mBottom.mTarget != null) {
          if (paramInt != 0) {
            resolutionAnchor2.dependsOn(resolutionAnchor4, -1, paramConstraintWidget.getResolutionHeight());
          } else {
            resolutionAnchor2.dependsOn(resolutionAnchor4, -i);
          } 
        } else if (paramConstraintWidget.mTop.mTarget != null && paramConstraintWidget.mBottom.mTarget != null) {
          if (paramInt != 0) {
            paramConstraintWidget.getResolutionHeight().addDependent(resolutionAnchor2);
            paramConstraintWidget.getResolutionWidth().addDependent(resolutionAnchor4);
          } 
          if (paramConstraintWidget.mDimensionRatio == 0.0F) {
            resolutionAnchor2.setType(3);
            resolutionAnchor4.setType(3);
            resolutionAnchor2.setOpposite(resolutionAnchor4, 0.0F);
            resolutionAnchor4.setOpposite(resolutionAnchor2, 0.0F);
          } else {
            resolutionAnchor2.setType(2);
            resolutionAnchor4.setType(2);
            resolutionAnchor2.setOpposite(resolutionAnchor4, -i);
            resolutionAnchor4.setOpposite(resolutionAnchor2, i);
            paramConstraintWidget.setHeight(i);
            if (paramConstraintWidget.mBaselineDistance > 0)
              paramConstraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionAnchor2, paramConstraintWidget.mBaselineDistance); 
          } 
        } 
      } 
    } 
  }
  
  static boolean applyChainOptimized(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt1, int paramInt2, ChainHead paramChainHead) {
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
    //   54: astore #4
    //   56: aload_0
    //   57: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   60: iload_2
    //   61: aaload
    //   62: astore_0
    //   63: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   66: astore_0
    //   67: iload_2
    //   68: ifne -> 127
    //   71: aload #9
    //   73: getfield mHorizontalChainStyle : I
    //   76: ifne -> 85
    //   79: iconst_1
    //   80: istore #12
    //   82: goto -> 88
    //   85: iconst_0
    //   86: istore #12
    //   88: aload #9
    //   90: getfield mHorizontalChainStyle : I
    //   93: iconst_1
    //   94: if_icmpne -> 103
    //   97: iconst_1
    //   98: istore #13
    //   100: goto -> 106
    //   103: iconst_0
    //   104: istore #13
    //   106: aload #9
    //   108: getfield mHorizontalChainStyle : I
    //   111: iconst_2
    //   112: if_icmpne -> 121
    //   115: iconst_1
    //   116: istore #14
    //   118: goto -> 180
    //   121: iconst_0
    //   122: istore #14
    //   124: goto -> 180
    //   127: aload #9
    //   129: getfield mVerticalChainStyle : I
    //   132: ifne -> 141
    //   135: iconst_1
    //   136: istore #12
    //   138: goto -> 144
    //   141: iconst_0
    //   142: istore #12
    //   144: aload #9
    //   146: getfield mVerticalChainStyle : I
    //   149: iconst_1
    //   150: if_icmpne -> 159
    //   153: iconst_1
    //   154: istore #13
    //   156: goto -> 162
    //   159: iconst_0
    //   160: istore #13
    //   162: aload #9
    //   164: getfield mVerticalChainStyle : I
    //   167: iconst_2
    //   168: if_icmpne -> 177
    //   171: iconst_1
    //   172: istore #14
    //   174: goto -> 180
    //   177: iconst_0
    //   178: istore #14
    //   180: aload #5
    //   182: astore #4
    //   184: iconst_0
    //   185: istore #15
    //   187: iconst_0
    //   188: istore #16
    //   190: iconst_0
    //   191: istore #17
    //   193: fconst_0
    //   194: fstore #18
    //   196: fconst_0
    //   197: fstore #19
    //   199: iload #16
    //   201: ifne -> 522
    //   204: iload #17
    //   206: istore #20
    //   208: fload #18
    //   210: fstore #21
    //   212: fload #19
    //   214: fstore #22
    //   216: aload #4
    //   218: invokevirtual getVisibility : ()I
    //   221: bipush #8
    //   223: if_icmpeq -> 318
    //   226: iload #17
    //   228: iconst_1
    //   229: iadd
    //   230: istore #20
    //   232: iload_2
    //   233: ifne -> 250
    //   236: fload #18
    //   238: aload #4
    //   240: invokevirtual getWidth : ()I
    //   243: i2f
    //   244: fadd
    //   245: fstore #22
    //   247: goto -> 261
    //   250: fload #18
    //   252: aload #4
    //   254: invokevirtual getHeight : ()I
    //   257: i2f
    //   258: fadd
    //   259: fstore #22
    //   261: fload #22
    //   263: fstore #21
    //   265: aload #4
    //   267: aload #7
    //   269: if_acmpeq -> 288
    //   272: fload #22
    //   274: aload #4
    //   276: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   279: iload_3
    //   280: aaload
    //   281: invokevirtual getMargin : ()I
    //   284: i2f
    //   285: fadd
    //   286: fstore #21
    //   288: fload #19
    //   290: aload #4
    //   292: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   295: iload_3
    //   296: aaload
    //   297: invokevirtual getMargin : ()I
    //   300: i2f
    //   301: fadd
    //   302: aload #4
    //   304: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   307: iload_3
    //   308: iconst_1
    //   309: iadd
    //   310: aaload
    //   311: invokevirtual getMargin : ()I
    //   314: i2f
    //   315: fadd
    //   316: fstore #22
    //   318: aload #4
    //   320: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   323: iload_3
    //   324: aaload
    //   325: astore_0
    //   326: iload #15
    //   328: istore #17
    //   330: aload #4
    //   332: invokevirtual getVisibility : ()I
    //   335: bipush #8
    //   337: if_icmpeq -> 423
    //   340: iload #15
    //   342: istore #17
    //   344: aload #4
    //   346: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   349: iload_2
    //   350: aaload
    //   351: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   354: if_acmpne -> 423
    //   357: iload #15
    //   359: iconst_1
    //   360: iadd
    //   361: istore #17
    //   363: iload_2
    //   364: ifne -> 395
    //   367: aload #4
    //   369: getfield mMatchConstraintDefaultWidth : I
    //   372: ifeq -> 377
    //   375: iconst_0
    //   376: ireturn
    //   377: aload #4
    //   379: getfield mMatchConstraintMinWidth : I
    //   382: ifne -> 393
    //   385: aload #4
    //   387: getfield mMatchConstraintMaxWidth : I
    //   390: ifeq -> 423
    //   393: iconst_0
    //   394: ireturn
    //   395: aload #4
    //   397: getfield mMatchConstraintDefaultHeight : I
    //   400: ifeq -> 405
    //   403: iconst_0
    //   404: ireturn
    //   405: aload #4
    //   407: getfield mMatchConstraintMinHeight : I
    //   410: ifne -> 421
    //   413: aload #4
    //   415: getfield mMatchConstraintMaxHeight : I
    //   418: ifeq -> 423
    //   421: iconst_0
    //   422: ireturn
    //   423: aload #4
    //   425: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   428: iload_3
    //   429: iconst_1
    //   430: iadd
    //   431: aaload
    //   432: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   435: astore_0
    //   436: aload_0
    //   437: ifnull -> 485
    //   440: aload_0
    //   441: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   444: astore_0
    //   445: aload_0
    //   446: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   449: iload_3
    //   450: aaload
    //   451: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   454: ifnull -> 480
    //   457: aload_0
    //   458: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   461: iload_3
    //   462: aaload
    //   463: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   466: getfield mOwner : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   469: aload #4
    //   471: if_acmpeq -> 477
    //   474: goto -> 480
    //   477: goto -> 487
    //   480: aconst_null
    //   481: astore_0
    //   482: goto -> 487
    //   485: aconst_null
    //   486: astore_0
    //   487: aload_0
    //   488: ifnull -> 494
    //   491: goto -> 500
    //   494: iconst_1
    //   495: istore #16
    //   497: aload #4
    //   499: astore_0
    //   500: iload #17
    //   502: istore #15
    //   504: aload_0
    //   505: astore #4
    //   507: iload #20
    //   509: istore #17
    //   511: fload #21
    //   513: fstore #18
    //   515: fload #22
    //   517: fstore #19
    //   519: goto -> 199
    //   522: aload #5
    //   524: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   527: iload_3
    //   528: aaload
    //   529: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   532: astore #9
    //   534: aload #6
    //   536: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   539: astore_0
    //   540: iload_3
    //   541: iconst_1
    //   542: iadd
    //   543: istore #20
    //   545: aload_0
    //   546: iload #20
    //   548: aaload
    //   549: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   552: astore_0
    //   553: aload #9
    //   555: getfield target : Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   558: ifnull -> 1734
    //   561: aload_0
    //   562: getfield target : Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   565: ifnonnull -> 571
    //   568: goto -> 1734
    //   571: aload #9
    //   573: getfield target : Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   576: getfield state : I
    //   579: iconst_1
    //   580: if_icmpeq -> 596
    //   583: aload_0
    //   584: getfield target : Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   587: getfield state : I
    //   590: iconst_1
    //   591: if_icmpeq -> 596
    //   594: iconst_0
    //   595: ireturn
    //   596: iload #15
    //   598: ifle -> 610
    //   601: iload #15
    //   603: iload #17
    //   605: if_icmpeq -> 610
    //   608: iconst_0
    //   609: ireturn
    //   610: iload #14
    //   612: ifne -> 634
    //   615: iload #12
    //   617: ifne -> 634
    //   620: iload #13
    //   622: ifeq -> 628
    //   625: goto -> 634
    //   628: fconst_0
    //   629: fstore #21
    //   631: goto -> 684
    //   634: aload #7
    //   636: ifnull -> 655
    //   639: aload #7
    //   641: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   644: iload_3
    //   645: aaload
    //   646: invokevirtual getMargin : ()I
    //   649: i2f
    //   650: fstore #22
    //   652: goto -> 658
    //   655: fconst_0
    //   656: fstore #22
    //   658: fload #22
    //   660: fstore #21
    //   662: aload #8
    //   664: ifnull -> 684
    //   667: fload #22
    //   669: aload #8
    //   671: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   674: iload #20
    //   676: aaload
    //   677: invokevirtual getMargin : ()I
    //   680: i2f
    //   681: fadd
    //   682: fstore #21
    //   684: aload #9
    //   686: getfield target : Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   689: getfield resolvedOffset : F
    //   692: fstore #23
    //   694: aload_0
    //   695: getfield target : Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   698: getfield resolvedOffset : F
    //   701: fstore #22
    //   703: fload #23
    //   705: fload #22
    //   707: fcmpg
    //   708: ifge -> 724
    //   711: fload #22
    //   713: fload #23
    //   715: fsub
    //   716: fload #18
    //   718: fsub
    //   719: fstore #22
    //   721: goto -> 734
    //   724: fload #23
    //   726: fload #22
    //   728: fsub
    //   729: fload #18
    //   731: fsub
    //   732: fstore #22
    //   734: iload #15
    //   736: ifle -> 1105
    //   739: iload #15
    //   741: iload #17
    //   743: if_icmpne -> 1105
    //   746: aload #4
    //   748: invokevirtual getParent : ()Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   751: ifnull -> 772
    //   754: aload #4
    //   756: invokevirtual getParent : ()Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   759: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   762: iload_2
    //   763: aaload
    //   764: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   767: if_acmpne -> 772
    //   770: iconst_0
    //   771: ireturn
    //   772: fload #22
    //   774: fload #18
    //   776: fadd
    //   777: fload #19
    //   779: fsub
    //   780: fstore #18
    //   782: fload #18
    //   784: fstore #22
    //   786: iload #12
    //   788: ifeq -> 801
    //   791: fload #18
    //   793: fload #19
    //   795: fload #21
    //   797: fsub
    //   798: fsub
    //   799: fstore #22
    //   801: aload #7
    //   803: astore_0
    //   804: fload #23
    //   806: fstore #21
    //   808: iload #12
    //   810: ifeq -> 870
    //   813: fload #23
    //   815: aload #7
    //   817: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   820: iload #20
    //   822: aaload
    //   823: invokevirtual getMargin : ()I
    //   826: i2f
    //   827: fadd
    //   828: fstore #19
    //   830: aload #7
    //   832: getfield mListNextVisibleWidget : [Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   835: iload_2
    //   836: aaload
    //   837: astore #4
    //   839: aload #7
    //   841: astore_0
    //   842: fload #19
    //   844: fstore #21
    //   846: aload #4
    //   848: ifnull -> 870
    //   851: fload #19
    //   853: aload #4
    //   855: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   858: iload_3
    //   859: aaload
    //   860: invokevirtual getMargin : ()I
    //   863: i2f
    //   864: fadd
    //   865: fstore #21
    //   867: aload #7
    //   869: astore_0
    //   870: aload_0
    //   871: ifnull -> 1103
    //   874: getstatic android/support/constraint/solver/LinearSystem.sMetrics : Landroid/support/constraint/solver/Metrics;
    //   877: ifnull -> 931
    //   880: getstatic android/support/constraint/solver/LinearSystem.sMetrics : Landroid/support/constraint/solver/Metrics;
    //   883: astore #4
    //   885: aload #4
    //   887: aload #4
    //   889: getfield nonresolvedWidgets : J
    //   892: lconst_1
    //   893: lsub
    //   894: putfield nonresolvedWidgets : J
    //   897: getstatic android/support/constraint/solver/LinearSystem.sMetrics : Landroid/support/constraint/solver/Metrics;
    //   900: astore #4
    //   902: aload #4
    //   904: aload #4
    //   906: getfield resolvedWidgets : J
    //   909: lconst_1
    //   910: ladd
    //   911: putfield resolvedWidgets : J
    //   914: getstatic android/support/constraint/solver/LinearSystem.sMetrics : Landroid/support/constraint/solver/Metrics;
    //   917: astore #4
    //   919: aload #4
    //   921: aload #4
    //   923: getfield chainConnectionResolved : J
    //   926: lconst_1
    //   927: ladd
    //   928: putfield chainConnectionResolved : J
    //   931: aload_0
    //   932: getfield mListNextVisibleWidget : [Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   935: iload_2
    //   936: aaload
    //   937: astore #4
    //   939: aload #4
    //   941: ifnonnull -> 956
    //   944: aload_0
    //   945: aload #8
    //   947: if_acmpne -> 953
    //   950: goto -> 956
    //   953: goto -> 1097
    //   956: fload #22
    //   958: iload #15
    //   960: i2f
    //   961: fdiv
    //   962: fstore #19
    //   964: fload #10
    //   966: fconst_0
    //   967: fcmpl
    //   968: ifle -> 985
    //   971: aload_0
    //   972: getfield mWeight : [F
    //   975: iload_2
    //   976: faload
    //   977: fload #22
    //   979: fmul
    //   980: fload #10
    //   982: fdiv
    //   983: fstore #19
    //   985: fload #21
    //   987: aload_0
    //   988: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   991: iload_3
    //   992: aaload
    //   993: invokevirtual getMargin : ()I
    //   996: i2f
    //   997: fadd
    //   998: fstore #21
    //   1000: aload_0
    //   1001: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1004: iload_3
    //   1005: aaload
    //   1006: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1009: aload #9
    //   1011: getfield resolvedTarget : Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1014: fload #21
    //   1016: invokevirtual resolve : (Landroid/support/constraint/solver/widgets/ResolutionAnchor;F)V
    //   1019: aload_0
    //   1020: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1023: iload #20
    //   1025: aaload
    //   1026: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1029: astore #5
    //   1031: aload #9
    //   1033: getfield resolvedTarget : Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1036: astore #7
    //   1038: fload #21
    //   1040: fload #19
    //   1042: fadd
    //   1043: fstore #21
    //   1045: aload #5
    //   1047: aload #7
    //   1049: fload #21
    //   1051: invokevirtual resolve : (Landroid/support/constraint/solver/widgets/ResolutionAnchor;F)V
    //   1054: aload_0
    //   1055: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1058: iload_3
    //   1059: aaload
    //   1060: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1063: aload_1
    //   1064: invokevirtual addResolvedValue : (Landroid/support/constraint/solver/LinearSystem;)V
    //   1067: aload_0
    //   1068: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1071: iload #20
    //   1073: aaload
    //   1074: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1077: aload_1
    //   1078: invokevirtual addResolvedValue : (Landroid/support/constraint/solver/LinearSystem;)V
    //   1081: fload #21
    //   1083: aload_0
    //   1084: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1087: iload #20
    //   1089: aaload
    //   1090: invokevirtual getMargin : ()I
    //   1093: i2f
    //   1094: fadd
    //   1095: fstore #21
    //   1097: aload #4
    //   1099: astore_0
    //   1100: goto -> 870
    //   1103: iconst_1
    //   1104: ireturn
    //   1105: fload #22
    //   1107: fload #18
    //   1109: fcmpg
    //   1110: ifge -> 1115
    //   1113: iconst_0
    //   1114: ireturn
    //   1115: iload #14
    //   1117: ifeq -> 1366
    //   1120: fload #23
    //   1122: fload #22
    //   1124: fload #21
    //   1126: fsub
    //   1127: aload #5
    //   1129: invokevirtual getHorizontalBiasPercent : ()F
    //   1132: fmul
    //   1133: fadd
    //   1134: fstore #21
    //   1136: aload #7
    //   1138: ifnull -> 1363
    //   1141: getstatic android/support/constraint/solver/LinearSystem.sMetrics : Landroid/support/constraint/solver/Metrics;
    //   1144: ifnull -> 1189
    //   1147: getstatic android/support/constraint/solver/LinearSystem.sMetrics : Landroid/support/constraint/solver/Metrics;
    //   1150: astore_0
    //   1151: aload_0
    //   1152: aload_0
    //   1153: getfield nonresolvedWidgets : J
    //   1156: lconst_1
    //   1157: lsub
    //   1158: putfield nonresolvedWidgets : J
    //   1161: getstatic android/support/constraint/solver/LinearSystem.sMetrics : Landroid/support/constraint/solver/Metrics;
    //   1164: astore_0
    //   1165: aload_0
    //   1166: aload_0
    //   1167: getfield resolvedWidgets : J
    //   1170: lconst_1
    //   1171: ladd
    //   1172: putfield resolvedWidgets : J
    //   1175: getstatic android/support/constraint/solver/LinearSystem.sMetrics : Landroid/support/constraint/solver/Metrics;
    //   1178: astore_0
    //   1179: aload_0
    //   1180: aload_0
    //   1181: getfield chainConnectionResolved : J
    //   1184: lconst_1
    //   1185: ladd
    //   1186: putfield chainConnectionResolved : J
    //   1189: aload #7
    //   1191: getfield mListNextVisibleWidget : [Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1194: iload_2
    //   1195: aaload
    //   1196: astore_0
    //   1197: aload_0
    //   1198: ifnonnull -> 1212
    //   1201: fload #21
    //   1203: fstore #22
    //   1205: aload #7
    //   1207: aload #8
    //   1209: if_acmpne -> 1353
    //   1212: iload_2
    //   1213: ifne -> 1227
    //   1216: aload #7
    //   1218: invokevirtual getWidth : ()I
    //   1221: i2f
    //   1222: fstore #22
    //   1224: goto -> 1235
    //   1227: aload #7
    //   1229: invokevirtual getHeight : ()I
    //   1232: i2f
    //   1233: fstore #22
    //   1235: fload #21
    //   1237: aload #7
    //   1239: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1242: iload_3
    //   1243: aaload
    //   1244: invokevirtual getMargin : ()I
    //   1247: i2f
    //   1248: fadd
    //   1249: fstore #21
    //   1251: aload #7
    //   1253: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1256: iload_3
    //   1257: aaload
    //   1258: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1261: aload #9
    //   1263: getfield resolvedTarget : Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1266: fload #21
    //   1268: invokevirtual resolve : (Landroid/support/constraint/solver/widgets/ResolutionAnchor;F)V
    //   1271: aload #7
    //   1273: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1276: iload #20
    //   1278: aaload
    //   1279: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1282: astore #4
    //   1284: aload #9
    //   1286: getfield resolvedTarget : Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1289: astore #5
    //   1291: fload #21
    //   1293: fload #22
    //   1295: fadd
    //   1296: fstore #21
    //   1298: aload #4
    //   1300: aload #5
    //   1302: fload #21
    //   1304: invokevirtual resolve : (Landroid/support/constraint/solver/widgets/ResolutionAnchor;F)V
    //   1307: aload #7
    //   1309: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1312: iload_3
    //   1313: aaload
    //   1314: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1317: aload_1
    //   1318: invokevirtual addResolvedValue : (Landroid/support/constraint/solver/LinearSystem;)V
    //   1321: aload #7
    //   1323: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1326: iload #20
    //   1328: aaload
    //   1329: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1332: aload_1
    //   1333: invokevirtual addResolvedValue : (Landroid/support/constraint/solver/LinearSystem;)V
    //   1336: fload #21
    //   1338: aload #7
    //   1340: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1343: iload #20
    //   1345: aaload
    //   1346: invokevirtual getMargin : ()I
    //   1349: i2f
    //   1350: fadd
    //   1351: fstore #22
    //   1353: aload_0
    //   1354: astore #7
    //   1356: fload #22
    //   1358: fstore #21
    //   1360: goto -> 1136
    //   1363: goto -> 1732
    //   1366: iload #12
    //   1368: ifne -> 1382
    //   1371: iload #13
    //   1373: ifeq -> 1379
    //   1376: goto -> 1382
    //   1379: goto -> 1732
    //   1382: iload #12
    //   1384: ifeq -> 1397
    //   1387: fload #22
    //   1389: fload #21
    //   1391: fsub
    //   1392: fstore #19
    //   1394: goto -> 1413
    //   1397: fload #22
    //   1399: fstore #19
    //   1401: iload #13
    //   1403: ifeq -> 1413
    //   1406: fload #22
    //   1408: fload #21
    //   1410: fsub
    //   1411: fstore #19
    //   1413: fload #19
    //   1415: iload #17
    //   1417: iconst_1
    //   1418: iadd
    //   1419: i2f
    //   1420: fdiv
    //   1421: fstore #21
    //   1423: iload #13
    //   1425: ifeq -> 1453
    //   1428: iload #17
    //   1430: iconst_1
    //   1431: if_icmple -> 1447
    //   1434: fload #19
    //   1436: iload #17
    //   1438: iconst_1
    //   1439: isub
    //   1440: i2f
    //   1441: fdiv
    //   1442: fstore #21
    //   1444: goto -> 1453
    //   1447: fload #19
    //   1449: fconst_2
    //   1450: fdiv
    //   1451: fstore #21
    //   1453: fload #23
    //   1455: fload #21
    //   1457: fadd
    //   1458: fstore #22
    //   1460: fload #22
    //   1462: fstore #19
    //   1464: iload #13
    //   1466: ifeq -> 1495
    //   1469: fload #22
    //   1471: fstore #19
    //   1473: iload #17
    //   1475: iconst_1
    //   1476: if_icmple -> 1495
    //   1479: aload #7
    //   1481: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1484: iload_3
    //   1485: aaload
    //   1486: invokevirtual getMargin : ()I
    //   1489: i2f
    //   1490: fload #23
    //   1492: fadd
    //   1493: fstore #19
    //   1495: fload #19
    //   1497: fstore #22
    //   1499: aload #7
    //   1501: astore_0
    //   1502: iload #12
    //   1504: ifeq -> 1538
    //   1507: fload #19
    //   1509: fstore #22
    //   1511: aload #7
    //   1513: astore_0
    //   1514: aload #7
    //   1516: ifnull -> 1538
    //   1519: fload #19
    //   1521: aload #7
    //   1523: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1526: iload_3
    //   1527: aaload
    //   1528: invokevirtual getMargin : ()I
    //   1531: i2f
    //   1532: fadd
    //   1533: fstore #22
    //   1535: aload #7
    //   1537: astore_0
    //   1538: aload_0
    //   1539: ifnull -> 1732
    //   1542: getstatic android/support/constraint/solver/LinearSystem.sMetrics : Landroid/support/constraint/solver/Metrics;
    //   1545: ifnull -> 1599
    //   1548: getstatic android/support/constraint/solver/LinearSystem.sMetrics : Landroid/support/constraint/solver/Metrics;
    //   1551: astore #4
    //   1553: aload #4
    //   1555: aload #4
    //   1557: getfield nonresolvedWidgets : J
    //   1560: lconst_1
    //   1561: lsub
    //   1562: putfield nonresolvedWidgets : J
    //   1565: getstatic android/support/constraint/solver/LinearSystem.sMetrics : Landroid/support/constraint/solver/Metrics;
    //   1568: astore #4
    //   1570: aload #4
    //   1572: aload #4
    //   1574: getfield resolvedWidgets : J
    //   1577: lconst_1
    //   1578: ladd
    //   1579: putfield resolvedWidgets : J
    //   1582: getstatic android/support/constraint/solver/LinearSystem.sMetrics : Landroid/support/constraint/solver/Metrics;
    //   1585: astore #4
    //   1587: aload #4
    //   1589: aload #4
    //   1591: getfield chainConnectionResolved : J
    //   1594: lconst_1
    //   1595: ladd
    //   1596: putfield chainConnectionResolved : J
    //   1599: aload_0
    //   1600: getfield mListNextVisibleWidget : [Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1603: iload_2
    //   1604: aaload
    //   1605: astore #4
    //   1607: aload #4
    //   1609: ifnonnull -> 1622
    //   1612: fload #22
    //   1614: fstore #19
    //   1616: aload_0
    //   1617: aload #8
    //   1619: if_acmpne -> 1722
    //   1622: iload_2
    //   1623: ifne -> 1636
    //   1626: aload_0
    //   1627: invokevirtual getWidth : ()I
    //   1630: i2f
    //   1631: fstore #19
    //   1633: goto -> 1643
    //   1636: aload_0
    //   1637: invokevirtual getHeight : ()I
    //   1640: i2f
    //   1641: fstore #19
    //   1643: aload_0
    //   1644: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1647: iload_3
    //   1648: aaload
    //   1649: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1652: aload #9
    //   1654: getfield resolvedTarget : Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1657: fload #22
    //   1659: invokevirtual resolve : (Landroid/support/constraint/solver/widgets/ResolutionAnchor;F)V
    //   1662: aload_0
    //   1663: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1666: iload #20
    //   1668: aaload
    //   1669: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1672: aload #9
    //   1674: getfield resolvedTarget : Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1677: fload #22
    //   1679: fload #19
    //   1681: fadd
    //   1682: invokevirtual resolve : (Landroid/support/constraint/solver/widgets/ResolutionAnchor;F)V
    //   1685: aload_0
    //   1686: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1689: iload_3
    //   1690: aaload
    //   1691: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1694: aload_1
    //   1695: invokevirtual addResolvedValue : (Landroid/support/constraint/solver/LinearSystem;)V
    //   1698: aload_0
    //   1699: getfield mListAnchors : [Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1702: iload #20
    //   1704: aaload
    //   1705: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1708: aload_1
    //   1709: invokevirtual addResolvedValue : (Landroid/support/constraint/solver/LinearSystem;)V
    //   1712: fload #22
    //   1714: fload #19
    //   1716: fload #21
    //   1718: fadd
    //   1719: fadd
    //   1720: fstore #19
    //   1722: aload #4
    //   1724: astore_0
    //   1725: fload #19
    //   1727: fstore #22
    //   1729: goto -> 1538
    //   1732: iconst_1
    //   1733: ireturn
    //   1734: iconst_0
    //   1735: ireturn
  }
  
  static void checkMatchParent(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget) {
    if (paramConstraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && paramConstraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
      int i = paramConstraintWidget.mLeft.mMargin;
      int j = paramConstraintWidgetContainer.getWidth() - paramConstraintWidget.mRight.mMargin;
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
      paramConstraintWidget.mHorizontalResolution = 2;
      paramConstraintWidget.setHorizontalDimension(i, j);
    } 
    if (paramConstraintWidgetContainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && paramConstraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
      int j = paramConstraintWidget.mTop.mMargin;
      int i = paramConstraintWidgetContainer.getHeight() - paramConstraintWidget.mBottom.mMargin;
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, j);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, i);
      if (paramConstraintWidget.mBaselineDistance > 0 || paramConstraintWidget.getVisibility() == 8) {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + j);
      } 
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.setVerticalDimension(j, i);
    } 
  }
  
  private static boolean optimizableMatchConstraint(ConstraintWidget paramConstraintWidget, int paramInt) {
    ConstraintWidget.DimensionBehaviour[] arrayOfDimensionBehaviour;
    if (paramConstraintWidget.mListDimensionBehaviors[paramInt] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
      return false; 
    float f = paramConstraintWidget.mDimensionRatio;
    boolean bool = true;
    if (f != 0.0F) {
      arrayOfDimensionBehaviour = paramConstraintWidget.mListDimensionBehaviors;
      if (paramInt == 0) {
        paramInt = bool;
      } else {
        paramInt = 0;
      } 
      return (arrayOfDimensionBehaviour[paramInt] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) ? false : false;
    } 
    if (paramInt == 0) {
      if (((ConstraintWidget)arrayOfDimensionBehaviour).mMatchConstraintDefaultWidth != 0)
        return false; 
      if (((ConstraintWidget)arrayOfDimensionBehaviour).mMatchConstraintMinWidth != 0 || ((ConstraintWidget)arrayOfDimensionBehaviour).mMatchConstraintMaxWidth != 0)
        return false; 
    } else {
      if (((ConstraintWidget)arrayOfDimensionBehaviour).mMatchConstraintDefaultHeight != 0)
        return false; 
      if (((ConstraintWidget)arrayOfDimensionBehaviour).mMatchConstraintMinHeight != 0 || ((ConstraintWidget)arrayOfDimensionBehaviour).mMatchConstraintMaxHeight != 0)
        return false; 
    } 
    return true;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\constraint\solver\widgets\Optimizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */