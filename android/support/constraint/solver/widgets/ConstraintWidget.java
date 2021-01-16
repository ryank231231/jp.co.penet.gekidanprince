package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;

public class ConstraintWidget {
  protected static final int ANCHOR_BASELINE = 4;
  
  protected static final int ANCHOR_BOTTOM = 3;
  
  protected static final int ANCHOR_LEFT = 0;
  
  protected static final int ANCHOR_RIGHT = 1;
  
  protected static final int ANCHOR_TOP = 2;
  
  private static final boolean AUTOTAG_CENTER = false;
  
  public static final int CHAIN_PACKED = 2;
  
  public static final int CHAIN_SPREAD = 0;
  
  public static final int CHAIN_SPREAD_INSIDE = 1;
  
  public static float DEFAULT_BIAS = 0.5F;
  
  static final int DIMENSION_HORIZONTAL = 0;
  
  static final int DIMENSION_VERTICAL = 1;
  
  protected static final int DIRECT = 2;
  
  public static final int GONE = 8;
  
  public static final int HORIZONTAL = 0;
  
  public static final int INVISIBLE = 4;
  
  public static final int MATCH_CONSTRAINT_PERCENT = 2;
  
  public static final int MATCH_CONSTRAINT_RATIO = 3;
  
  public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
  
  public static final int MATCH_CONSTRAINT_SPREAD = 0;
  
  public static final int MATCH_CONSTRAINT_WRAP = 1;
  
  protected static final int SOLVER = 1;
  
  public static final int UNKNOWN = -1;
  
  public static final int VERTICAL = 1;
  
  public static final int VISIBLE = 0;
  
  private static final int WRAP = -2;
  
  protected ArrayList<ConstraintAnchor> mAnchors = new ArrayList<ConstraintAnchor>();
  
  ConstraintAnchor mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
  
  int mBaselineDistance = 0;
  
  ConstraintAnchor mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
  
  boolean mBottomHasCentered;
  
  ConstraintAnchor mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
  
  ConstraintAnchor mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
  
  ConstraintAnchor mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
  
  private float mCircleConstraintAngle = 0.0F;
  
  private Object mCompanionWidget;
  
  private int mContainerItemSkip;
  
  private String mDebugName;
  
  protected float mDimensionRatio = 0.0F;
  
  protected int mDimensionRatioSide = -1;
  
  int mDistToBottom;
  
  int mDistToLeft;
  
  int mDistToRight;
  
  int mDistToTop;
  
  private int mDrawHeight = 0;
  
  private int mDrawWidth = 0;
  
  private int mDrawX = 0;
  
  private int mDrawY = 0;
  
  int mHeight = 0;
  
  float mHorizontalBiasPercent;
  
  boolean mHorizontalChainFixedPosition;
  
  int mHorizontalChainStyle;
  
  ConstraintWidget mHorizontalNextWidget;
  
  public int mHorizontalResolution = -1;
  
  boolean mHorizontalWrapVisited;
  
  boolean mIsHeightWrapContent;
  
  boolean mIsWidthWrapContent;
  
  ConstraintAnchor mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
  
  boolean mLeftHasCentered;
  
  protected ConstraintAnchor[] mListAnchors = new ConstraintAnchor[] { this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter };
  
  protected DimensionBehaviour[] mListDimensionBehaviors = new DimensionBehaviour[] { DimensionBehaviour.FIXED, DimensionBehaviour.FIXED };
  
  protected ConstraintWidget[] mListNextMatchConstraintsWidget;
  
  protected ConstraintWidget[] mListNextVisibleWidget;
  
  int mMatchConstraintDefaultHeight = 0;
  
  int mMatchConstraintDefaultWidth = 0;
  
  int mMatchConstraintMaxHeight = 0;
  
  int mMatchConstraintMaxWidth = 0;
  
  int mMatchConstraintMinHeight = 0;
  
  int mMatchConstraintMinWidth = 0;
  
  float mMatchConstraintPercentHeight = 1.0F;
  
  float mMatchConstraintPercentWidth = 1.0F;
  
  private int[] mMaxDimension = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
  
  protected int mMinHeight;
  
  protected int mMinWidth;
  
  protected int mOffsetX = 0;
  
  protected int mOffsetY = 0;
  
  ConstraintWidget mParent = null;
  
  ResolutionDimension mResolutionHeight;
  
  ResolutionDimension mResolutionWidth;
  
  float mResolvedDimensionRatio = 1.0F;
  
  int mResolvedDimensionRatioSide = -1;
  
  int[] mResolvedMatchConstraintDefault = new int[2];
  
  ConstraintAnchor mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
  
  boolean mRightHasCentered;
  
  ConstraintAnchor mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
  
  boolean mTopHasCentered;
  
  private String mType;
  
  float mVerticalBiasPercent;
  
  boolean mVerticalChainFixedPosition;
  
  int mVerticalChainStyle;
  
  ConstraintWidget mVerticalNextWidget;
  
  public int mVerticalResolution = -1;
  
  boolean mVerticalWrapVisited;
  
  private int mVisibility;
  
  float[] mWeight;
  
  int mWidth = 0;
  
  private int mWrapHeight;
  
  private int mWrapWidth;
  
  protected int mX = 0;
  
  protected int mY = 0;
  
  public ConstraintWidget() {
    float f = DEFAULT_BIAS;
    this.mHorizontalBiasPercent = f;
    this.mVerticalBiasPercent = f;
    this.mContainerItemSkip = 0;
    this.mVisibility = 0;
    this.mDebugName = null;
    this.mType = null;
    this.mHorizontalChainStyle = 0;
    this.mVerticalChainStyle = 0;
    this.mWeight = new float[] { -1.0F, -1.0F };
    this.mListNextMatchConstraintsWidget = new ConstraintWidget[] { null, null };
    this.mListNextVisibleWidget = new ConstraintWidget[] { null, null };
    this.mHorizontalNextWidget = null;
    this.mVerticalNextWidget = null;
    addAnchors();
  }
  
  public ConstraintWidget(int paramInt1, int paramInt2) {
    this(0, 0, paramInt1, paramInt2);
  }
  
  public ConstraintWidget(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    float f = DEFAULT_BIAS;
    this.mHorizontalBiasPercent = f;
    this.mVerticalBiasPercent = f;
    this.mContainerItemSkip = 0;
    this.mVisibility = 0;
    this.mDebugName = null;
    this.mType = null;
    this.mHorizontalChainStyle = 0;
    this.mVerticalChainStyle = 0;
    this.mWeight = new float[] { -1.0F, -1.0F };
    this.mListNextMatchConstraintsWidget = new ConstraintWidget[] { null, null };
    this.mListNextVisibleWidget = new ConstraintWidget[] { null, null };
    this.mHorizontalNextWidget = null;
    this.mVerticalNextWidget = null;
    this.mX = paramInt1;
    this.mY = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
    addAnchors();
    forceUpdateDrawPosition();
  }
  
  private void addAnchors() {
    this.mAnchors.add(this.mLeft);
    this.mAnchors.add(this.mTop);
    this.mAnchors.add(this.mRight);
    this.mAnchors.add(this.mBottom);
    this.mAnchors.add(this.mCenterX);
    this.mAnchors.add(this.mCenterY);
    this.mAnchors.add(this.mCenter);
    this.mAnchors.add(this.mBaseline);
  }
  
  private void applyConstraints(LinearSystem paramLinearSystem, boolean paramBoolean1, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, DimensionBehaviour paramDimensionBehaviour, boolean paramBoolean2, ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, float paramFloat2, boolean paramBoolean5) {
    // Byte code:
    //   0: aload_1
    //   1: aload #7
    //   3: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   6: astore #21
    //   8: aload_1
    //   9: aload #8
    //   11: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   14: astore #22
    //   16: aload_1
    //   17: aload #7
    //   19: invokevirtual getTarget : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   22: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   25: astore #23
    //   27: aload_1
    //   28: aload #8
    //   30: invokevirtual getTarget : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   33: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   36: astore #24
    //   38: aload_1
    //   39: getfield graphOptimizer : Z
    //   42: ifeq -> 128
    //   45: aload #7
    //   47: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   50: getfield state : I
    //   53: iconst_1
    //   54: if_icmpne -> 128
    //   57: aload #8
    //   59: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   62: getfield state : I
    //   65: iconst_1
    //   66: if_icmpne -> 128
    //   69: invokestatic getMetrics : ()Landroid/support/constraint/solver/Metrics;
    //   72: ifnull -> 89
    //   75: invokestatic getMetrics : ()Landroid/support/constraint/solver/Metrics;
    //   78: astore_3
    //   79: aload_3
    //   80: aload_3
    //   81: getfield resolvedWidgets : J
    //   84: lconst_1
    //   85: ladd
    //   86: putfield resolvedWidgets : J
    //   89: aload #7
    //   91: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   94: aload_1
    //   95: invokevirtual addResolvedValue : (Landroid/support/constraint/solver/LinearSystem;)V
    //   98: aload #8
    //   100: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   103: aload_1
    //   104: invokevirtual addResolvedValue : (Landroid/support/constraint/solver/LinearSystem;)V
    //   107: iload #15
    //   109: ifne -> 127
    //   112: iload_2
    //   113: ifeq -> 127
    //   116: aload_1
    //   117: aload #4
    //   119: aload #22
    //   121: iconst_0
    //   122: bipush #6
    //   124: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   127: return
    //   128: invokestatic getMetrics : ()Landroid/support/constraint/solver/Metrics;
    //   131: ifnull -> 154
    //   134: invokestatic getMetrics : ()Landroid/support/constraint/solver/Metrics;
    //   137: astore #25
    //   139: aload #25
    //   141: aload #25
    //   143: getfield nonresolvedWidgets : J
    //   146: lconst_1
    //   147: ladd
    //   148: putfield nonresolvedWidgets : J
    //   151: goto -> 154
    //   154: aload #7
    //   156: invokevirtual isConnected : ()Z
    //   159: istore #26
    //   161: aload #8
    //   163: invokevirtual isConnected : ()Z
    //   166: istore #27
    //   168: aload_0
    //   169: getfield mCenter : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   172: invokevirtual isConnected : ()Z
    //   175: istore #28
    //   177: iload #26
    //   179: ifeq -> 188
    //   182: iconst_1
    //   183: istore #29
    //   185: goto -> 191
    //   188: iconst_0
    //   189: istore #29
    //   191: iload #29
    //   193: istore #30
    //   195: iload #27
    //   197: ifeq -> 206
    //   200: iload #29
    //   202: iconst_1
    //   203: iadd
    //   204: istore #30
    //   206: iload #30
    //   208: istore #29
    //   210: iload #28
    //   212: ifeq -> 221
    //   215: iload #30
    //   217: iconst_1
    //   218: iadd
    //   219: istore #29
    //   221: iload #14
    //   223: ifeq -> 232
    //   226: iconst_3
    //   227: istore #30
    //   229: goto -> 236
    //   232: iload #16
    //   234: istore #30
    //   236: getstatic android/support/constraint/solver/widgets/ConstraintWidget$1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintWidget$DimensionBehaviour : [I
    //   239: aload #5
    //   241: invokevirtual ordinal : ()I
    //   244: iaload
    //   245: tableswitch default -> 276, 1 -> 312, 2 -> 306, 3 -> 300, 4 -> 282
    //   276: iconst_0
    //   277: istore #16
    //   279: goto -> 315
    //   282: iload #30
    //   284: iconst_4
    //   285: if_icmpne -> 294
    //   288: iconst_0
    //   289: istore #16
    //   291: goto -> 315
    //   294: iconst_1
    //   295: istore #16
    //   297: goto -> 315
    //   300: iconst_0
    //   301: istore #16
    //   303: goto -> 315
    //   306: iconst_0
    //   307: istore #16
    //   309: goto -> 315
    //   312: iconst_0
    //   313: istore #16
    //   315: aload_0
    //   316: getfield mVisibility : I
    //   319: bipush #8
    //   321: if_icmpne -> 333
    //   324: iconst_0
    //   325: istore #10
    //   327: iconst_0
    //   328: istore #16
    //   330: goto -> 333
    //   333: iload #20
    //   335: ifeq -> 390
    //   338: iload #26
    //   340: ifne -> 364
    //   343: iload #27
    //   345: ifne -> 364
    //   348: iload #28
    //   350: ifne -> 364
    //   353: aload_1
    //   354: aload #21
    //   356: iload #9
    //   358: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;I)V
    //   361: goto -> 390
    //   364: iload #26
    //   366: ifeq -> 390
    //   369: iload #27
    //   371: ifne -> 390
    //   374: aload_1
    //   375: aload #21
    //   377: aload #23
    //   379: aload #7
    //   381: invokevirtual getMargin : ()I
    //   384: bipush #6
    //   386: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   389: pop
    //   390: iload #16
    //   392: ifne -> 477
    //   395: iload #6
    //   397: ifeq -> 453
    //   400: aload_1
    //   401: aload #22
    //   403: aload #21
    //   405: iconst_0
    //   406: iconst_3
    //   407: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   410: pop
    //   411: iload #11
    //   413: ifle -> 431
    //   416: aload_1
    //   417: aload #22
    //   419: aload #21
    //   421: iload #11
    //   423: bipush #6
    //   425: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   428: goto -> 431
    //   431: iload #12
    //   433: ldc 2147483647
    //   435: if_icmpge -> 466
    //   438: aload_1
    //   439: aload #22
    //   441: aload #21
    //   443: iload #12
    //   445: bipush #6
    //   447: invokevirtual addLowerThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   450: goto -> 466
    //   453: aload_1
    //   454: aload #22
    //   456: aload #21
    //   458: iload #10
    //   460: bipush #6
    //   462: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   465: pop
    //   466: iload #17
    //   468: istore #12
    //   470: iload #18
    //   472: istore #10
    //   474: goto -> 884
    //   477: iload #17
    //   479: bipush #-2
    //   481: if_icmpne -> 491
    //   484: iload #10
    //   486: istore #9
    //   488: goto -> 495
    //   491: iload #17
    //   493: istore #9
    //   495: iload #18
    //   497: istore #12
    //   499: iload #18
    //   501: bipush #-2
    //   503: if_icmpne -> 510
    //   506: iload #10
    //   508: istore #12
    //   510: iload #9
    //   512: ifle -> 558
    //   515: iload_2
    //   516: ifeq -> 534
    //   519: aload_1
    //   520: aload #22
    //   522: aload #21
    //   524: iload #9
    //   526: bipush #6
    //   528: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   531: goto -> 546
    //   534: aload_1
    //   535: aload #22
    //   537: aload #21
    //   539: iload #9
    //   541: bipush #6
    //   543: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   546: iload #10
    //   548: iload #9
    //   550: invokestatic max : (II)I
    //   553: istore #10
    //   555: goto -> 558
    //   558: iload #12
    //   560: ifle -> 605
    //   563: iload_2
    //   564: ifeq -> 581
    //   567: aload_1
    //   568: aload #22
    //   570: aload #21
    //   572: iload #12
    //   574: iconst_1
    //   575: invokevirtual addLowerThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   578: goto -> 593
    //   581: aload_1
    //   582: aload #22
    //   584: aload #21
    //   586: iload #12
    //   588: bipush #6
    //   590: invokevirtual addLowerThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   593: iload #10
    //   595: iload #12
    //   597: invokestatic min : (II)I
    //   600: istore #18
    //   602: goto -> 609
    //   605: iload #10
    //   607: istore #18
    //   609: iload #30
    //   611: iconst_1
    //   612: if_icmpne -> 670
    //   615: iload_2
    //   616: ifeq -> 635
    //   619: aload_1
    //   620: aload #22
    //   622: aload #21
    //   624: iload #18
    //   626: bipush #6
    //   628: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   631: pop
    //   632: goto -> 795
    //   635: iload #15
    //   637: ifeq -> 655
    //   640: aload_1
    //   641: aload #22
    //   643: aload #21
    //   645: iload #18
    //   647: iconst_4
    //   648: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   651: pop
    //   652: goto -> 795
    //   655: aload_1
    //   656: aload #22
    //   658: aload #21
    //   660: iload #18
    //   662: iconst_1
    //   663: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   666: pop
    //   667: goto -> 795
    //   670: iload #30
    //   672: iconst_2
    //   673: if_icmpne -> 795
    //   676: aload #7
    //   678: invokevirtual getType : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   681: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   684: if_acmpeq -> 736
    //   687: aload #7
    //   689: invokevirtual getType : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   692: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   695: if_acmpne -> 701
    //   698: goto -> 736
    //   701: aload_1
    //   702: aload_0
    //   703: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   706: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   709: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   712: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   715: astore #5
    //   717: aload_1
    //   718: aload_0
    //   719: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   722: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   725: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   728: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   731: astore #25
    //   733: goto -> 768
    //   736: aload_1
    //   737: aload_0
    //   738: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   741: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   744: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   747: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   750: astore #5
    //   752: aload_1
    //   753: aload_0
    //   754: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   757: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   760: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   763: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   766: astore #25
    //   768: aload_1
    //   769: aload_1
    //   770: invokevirtual createRow : ()Landroid/support/constraint/solver/ArrayRow;
    //   773: aload #22
    //   775: aload #21
    //   777: aload #25
    //   779: aload #5
    //   781: fload #19
    //   783: invokevirtual createRowDimensionRatio : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;F)Landroid/support/constraint/solver/ArrayRow;
    //   786: invokevirtual addConstraint : (Landroid/support/constraint/solver/ArrayRow;)V
    //   789: iconst_0
    //   790: istore #10
    //   792: goto -> 799
    //   795: iload #16
    //   797: istore #10
    //   799: iload #12
    //   801: istore #17
    //   803: iload #10
    //   805: ifeq -> 872
    //   808: iload #29
    //   810: iconst_2
    //   811: if_icmpeq -> 872
    //   814: iload #14
    //   816: ifne -> 872
    //   819: iload #9
    //   821: iload #18
    //   823: invokestatic max : (II)I
    //   826: istore #10
    //   828: iload #17
    //   830: ifle -> 845
    //   833: iload #17
    //   835: iload #10
    //   837: invokestatic min : (II)I
    //   840: istore #10
    //   842: goto -> 845
    //   845: aload_1
    //   846: aload #22
    //   848: aload #21
    //   850: iload #10
    //   852: bipush #6
    //   854: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   857: pop
    //   858: iconst_0
    //   859: istore #16
    //   861: iload #17
    //   863: istore #10
    //   865: iload #9
    //   867: istore #12
    //   869: goto -> 884
    //   872: iload #10
    //   874: istore #16
    //   876: iload #9
    //   878: istore #12
    //   880: iload #17
    //   882: istore #10
    //   884: aload #23
    //   886: astore #5
    //   888: iload #20
    //   890: ifeq -> 1441
    //   893: iload #15
    //   895: ifeq -> 901
    //   898: goto -> 1441
    //   901: iload #26
    //   903: ifne -> 942
    //   906: iload #27
    //   908: ifne -> 942
    //   911: iload #28
    //   913: ifne -> 942
    //   916: iload_2
    //   917: ifeq -> 936
    //   920: aload_1
    //   921: aload #4
    //   923: aload #22
    //   925: iconst_0
    //   926: iconst_5
    //   927: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   930: aload #22
    //   932: astore_3
    //   933: goto -> 1426
    //   936: aload #22
    //   938: astore_3
    //   939: goto -> 1426
    //   942: iload #26
    //   944: ifeq -> 978
    //   947: iload #27
    //   949: ifne -> 978
    //   952: iload_2
    //   953: ifeq -> 972
    //   956: aload_1
    //   957: aload #4
    //   959: aload #22
    //   961: iconst_0
    //   962: iconst_5
    //   963: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   966: aload #22
    //   968: astore_3
    //   969: goto -> 1426
    //   972: aload #22
    //   974: astore_3
    //   975: goto -> 1426
    //   978: iload #26
    //   980: ifne -> 1030
    //   983: iload #27
    //   985: ifeq -> 1030
    //   988: aload_1
    //   989: aload #22
    //   991: aload #24
    //   993: aload #8
    //   995: invokevirtual getMargin : ()I
    //   998: ineg
    //   999: bipush #6
    //   1001: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   1004: pop
    //   1005: iload_2
    //   1006: ifeq -> 1024
    //   1009: aload_1
    //   1010: aload #21
    //   1012: aload_3
    //   1013: iconst_0
    //   1014: iconst_5
    //   1015: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   1018: aload #22
    //   1020: astore_3
    //   1021: goto -> 1426
    //   1024: aload #22
    //   1026: astore_3
    //   1027: goto -> 1426
    //   1030: iload #26
    //   1032: ifeq -> 1423
    //   1035: iload #27
    //   1037: ifeq -> 1423
    //   1040: iload #16
    //   1042: ifeq -> 1282
    //   1045: iload_2
    //   1046: ifeq -> 1068
    //   1049: iload #11
    //   1051: ifne -> 1068
    //   1054: aload_1
    //   1055: aload #22
    //   1057: aload #21
    //   1059: iconst_0
    //   1060: bipush #6
    //   1062: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   1065: goto -> 1068
    //   1068: iload #30
    //   1070: ifne -> 1175
    //   1073: iload #10
    //   1075: ifgt -> 1096
    //   1078: iload #12
    //   1080: ifle -> 1086
    //   1083: goto -> 1096
    //   1086: bipush #6
    //   1088: istore #11
    //   1090: iconst_0
    //   1091: istore #9
    //   1093: goto -> 1102
    //   1096: iconst_4
    //   1097: istore #11
    //   1099: iconst_1
    //   1100: istore #9
    //   1102: aload_1
    //   1103: aload #21
    //   1105: aload #5
    //   1107: aload #7
    //   1109: invokevirtual getMargin : ()I
    //   1112: iload #11
    //   1114: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   1117: pop
    //   1118: aload_1
    //   1119: aload #22
    //   1121: aload #24
    //   1123: aload #8
    //   1125: invokevirtual getMargin : ()I
    //   1128: ineg
    //   1129: iload #11
    //   1131: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   1134: pop
    //   1135: iload #10
    //   1137: ifgt -> 1154
    //   1140: iload #12
    //   1142: ifle -> 1148
    //   1145: goto -> 1154
    //   1148: iconst_0
    //   1149: istore #10
    //   1151: goto -> 1157
    //   1154: iconst_1
    //   1155: istore #10
    //   1157: iload #9
    //   1159: istore #12
    //   1161: iconst_5
    //   1162: istore #9
    //   1164: iload #10
    //   1166: istore #11
    //   1168: iload #12
    //   1170: istore #10
    //   1172: goto -> 1324
    //   1175: iconst_1
    //   1176: istore #11
    //   1178: iload #30
    //   1180: iconst_1
    //   1181: if_icmpne -> 1194
    //   1184: bipush #6
    //   1186: istore #9
    //   1188: iconst_1
    //   1189: istore #10
    //   1191: goto -> 1324
    //   1194: iload #30
    //   1196: iconst_3
    //   1197: if_icmpne -> 1270
    //   1200: iload #14
    //   1202: ifne -> 1225
    //   1205: aload_0
    //   1206: getfield mResolvedDimensionRatioSide : I
    //   1209: iconst_m1
    //   1210: if_icmpeq -> 1225
    //   1213: iload #10
    //   1215: ifgt -> 1225
    //   1218: bipush #6
    //   1220: istore #9
    //   1222: goto -> 1228
    //   1225: iconst_4
    //   1226: istore #9
    //   1228: aload_1
    //   1229: aload #21
    //   1231: aload #5
    //   1233: aload #7
    //   1235: invokevirtual getMargin : ()I
    //   1238: iload #9
    //   1240: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   1243: pop
    //   1244: aload_1
    //   1245: aload #22
    //   1247: aload #24
    //   1249: aload #8
    //   1251: invokevirtual getMargin : ()I
    //   1254: ineg
    //   1255: iload #9
    //   1257: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   1260: pop
    //   1261: iconst_5
    //   1262: istore #9
    //   1264: iconst_1
    //   1265: istore #10
    //   1267: goto -> 1324
    //   1270: iconst_5
    //   1271: istore #9
    //   1273: iconst_0
    //   1274: istore #11
    //   1276: iconst_0
    //   1277: istore #10
    //   1279: goto -> 1324
    //   1282: iconst_1
    //   1283: istore #11
    //   1285: iload_2
    //   1286: ifeq -> 1318
    //   1289: aload_1
    //   1290: aload #21
    //   1292: aload #5
    //   1294: aload #7
    //   1296: invokevirtual getMargin : ()I
    //   1299: iconst_5
    //   1300: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   1303: aload_1
    //   1304: aload #22
    //   1306: aload #24
    //   1308: aload #8
    //   1310: invokevirtual getMargin : ()I
    //   1313: ineg
    //   1314: iconst_5
    //   1315: invokevirtual addLowerThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   1318: iconst_5
    //   1319: istore #9
    //   1321: iconst_0
    //   1322: istore #10
    //   1324: iload #11
    //   1326: ifeq -> 1358
    //   1329: aload_1
    //   1330: aload #21
    //   1332: aload #5
    //   1334: aload #7
    //   1336: invokevirtual getMargin : ()I
    //   1339: fload #13
    //   1341: aload #24
    //   1343: aload #22
    //   1345: aload #8
    //   1347: invokevirtual getMargin : ()I
    //   1350: iload #9
    //   1352: invokevirtual addCentering : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;IFLandroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   1355: goto -> 1358
    //   1358: iload #10
    //   1360: ifeq -> 1397
    //   1363: aload_1
    //   1364: aload #21
    //   1366: aload #5
    //   1368: aload #7
    //   1370: invokevirtual getMargin : ()I
    //   1373: bipush #6
    //   1375: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   1378: aload_1
    //   1379: aload #22
    //   1381: aload #24
    //   1383: aload #8
    //   1385: invokevirtual getMargin : ()I
    //   1388: ineg
    //   1389: bipush #6
    //   1391: invokevirtual addLowerThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   1394: goto -> 1397
    //   1397: iload_2
    //   1398: ifeq -> 1417
    //   1401: aload_1
    //   1402: aload #21
    //   1404: aload_3
    //   1405: iconst_0
    //   1406: bipush #6
    //   1408: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   1411: aload #22
    //   1413: astore_3
    //   1414: goto -> 1426
    //   1417: aload #22
    //   1419: astore_3
    //   1420: goto -> 1426
    //   1423: aload #22
    //   1425: astore_3
    //   1426: iload_2
    //   1427: ifeq -> 1440
    //   1430: aload_1
    //   1431: aload #4
    //   1433: aload_3
    //   1434: iconst_0
    //   1435: bipush #6
    //   1437: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   1440: return
    //   1441: iload #29
    //   1443: iconst_2
    //   1444: if_icmpge -> 1472
    //   1447: iload_2
    //   1448: ifeq -> 1472
    //   1451: aload_1
    //   1452: aload #21
    //   1454: aload_3
    //   1455: iconst_0
    //   1456: bipush #6
    //   1458: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   1461: aload_1
    //   1462: aload #4
    //   1464: aload #22
    //   1466: iconst_0
    //   1467: bipush #6
    //   1469: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   1472: return
  }
  
  public void addToSolver(LinearSystem paramLinearSystem) {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   5: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   8: astore_2
    //   9: aload_1
    //   10: aload_0
    //   11: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   14: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   17: astore_3
    //   18: aload_1
    //   19: aload_0
    //   20: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   23: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   26: astore #4
    //   28: aload_1
    //   29: aload_0
    //   30: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   33: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   36: astore #5
    //   38: aload_1
    //   39: aload_0
    //   40: getfield mBaseline : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   43: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   46: astore #6
    //   48: aload_0
    //   49: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   52: astore #7
    //   54: aload #7
    //   56: ifnull -> 508
    //   59: aload #7
    //   61: ifnull -> 83
    //   64: aload #7
    //   66: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   69: iconst_0
    //   70: aaload
    //   71: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   74: if_acmpne -> 83
    //   77: iconst_1
    //   78: istore #8
    //   80: goto -> 86
    //   83: iconst_0
    //   84: istore #8
    //   86: aload_0
    //   87: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   90: astore #7
    //   92: aload #7
    //   94: ifnull -> 116
    //   97: aload #7
    //   99: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   102: iconst_1
    //   103: aaload
    //   104: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   107: if_acmpne -> 116
    //   110: iconst_1
    //   111: istore #9
    //   113: goto -> 119
    //   116: iconst_0
    //   117: istore #9
    //   119: aload_0
    //   120: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   123: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   126: ifnull -> 185
    //   129: aload_0
    //   130: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   133: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   136: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   139: aload_0
    //   140: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   143: if_acmpeq -> 185
    //   146: aload_0
    //   147: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   150: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   153: ifnull -> 185
    //   156: aload_0
    //   157: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   160: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   163: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   166: aload_0
    //   167: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   170: if_acmpne -> 185
    //   173: aload_0
    //   174: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   177: checkcast android/support/constraint/solver/widgets/ConstraintWidgetContainer
    //   180: aload_0
    //   181: iconst_0
    //   182: invokevirtual addChain : (Landroid/support/constraint/solver/widgets/ConstraintWidget;I)V
    //   185: aload_0
    //   186: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   189: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   192: ifnull -> 212
    //   195: aload_0
    //   196: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   199: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   202: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   205: aload_0
    //   206: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   209: if_acmpeq -> 239
    //   212: aload_0
    //   213: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   216: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   219: ifnull -> 245
    //   222: aload_0
    //   223: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   226: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   229: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   232: aload_0
    //   233: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   236: if_acmpne -> 245
    //   239: iconst_1
    //   240: istore #10
    //   242: goto -> 248
    //   245: iconst_0
    //   246: istore #10
    //   248: aload_0
    //   249: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   252: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   255: ifnull -> 314
    //   258: aload_0
    //   259: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   262: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   265: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   268: aload_0
    //   269: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   272: if_acmpeq -> 314
    //   275: aload_0
    //   276: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   279: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   282: ifnull -> 314
    //   285: aload_0
    //   286: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   289: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   292: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   295: aload_0
    //   296: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   299: if_acmpne -> 314
    //   302: aload_0
    //   303: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   306: checkcast android/support/constraint/solver/widgets/ConstraintWidgetContainer
    //   309: aload_0
    //   310: iconst_1
    //   311: invokevirtual addChain : (Landroid/support/constraint/solver/widgets/ConstraintWidget;I)V
    //   314: aload_0
    //   315: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   318: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   321: ifnull -> 341
    //   324: aload_0
    //   325: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   328: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   331: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   334: aload_0
    //   335: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   338: if_acmpeq -> 368
    //   341: aload_0
    //   342: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   345: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   348: ifnull -> 374
    //   351: aload_0
    //   352: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   355: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   358: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   361: aload_0
    //   362: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   365: if_acmpne -> 374
    //   368: iconst_1
    //   369: istore #11
    //   371: goto -> 377
    //   374: iconst_0
    //   375: istore #11
    //   377: iload #8
    //   379: ifeq -> 429
    //   382: aload_0
    //   383: getfield mVisibility : I
    //   386: bipush #8
    //   388: if_icmpeq -> 429
    //   391: aload_0
    //   392: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   395: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   398: ifnonnull -> 429
    //   401: aload_0
    //   402: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   405: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   408: ifnonnull -> 429
    //   411: aload_1
    //   412: aload_1
    //   413: aload_0
    //   414: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   417: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   420: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   423: aload_3
    //   424: iconst_0
    //   425: iconst_1
    //   426: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   429: iload #9
    //   431: ifeq -> 489
    //   434: aload_0
    //   435: getfield mVisibility : I
    //   438: bipush #8
    //   440: if_icmpeq -> 489
    //   443: aload_0
    //   444: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   447: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   450: ifnonnull -> 489
    //   453: aload_0
    //   454: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   457: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   460: ifnonnull -> 489
    //   463: aload_0
    //   464: getfield mBaseline : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   467: ifnonnull -> 489
    //   470: aload_1
    //   471: aload_1
    //   472: aload_0
    //   473: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   476: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   479: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   482: aload #5
    //   484: iconst_0
    //   485: iconst_1
    //   486: invokevirtual addGreaterThan : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)V
    //   489: iload #11
    //   491: istore #12
    //   493: iload #8
    //   495: istore #11
    //   497: iload #9
    //   499: istore #8
    //   501: iload #12
    //   503: istore #9
    //   505: goto -> 520
    //   508: iconst_0
    //   509: istore #11
    //   511: iconst_0
    //   512: istore #8
    //   514: iconst_0
    //   515: istore #10
    //   517: iconst_0
    //   518: istore #9
    //   520: aload_0
    //   521: getfield mWidth : I
    //   524: istore #13
    //   526: aload_0
    //   527: getfield mMinWidth : I
    //   530: istore #14
    //   532: iload #13
    //   534: istore #15
    //   536: iload #13
    //   538: iload #14
    //   540: if_icmpge -> 547
    //   543: iload #14
    //   545: istore #15
    //   547: aload_0
    //   548: getfield mHeight : I
    //   551: istore #16
    //   553: aload_0
    //   554: getfield mMinHeight : I
    //   557: istore #13
    //   559: iload #16
    //   561: istore #14
    //   563: iload #16
    //   565: iload #13
    //   567: if_icmpge -> 574
    //   570: iload #13
    //   572: istore #14
    //   574: aload_0
    //   575: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   578: iconst_0
    //   579: aaload
    //   580: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   583: if_acmpeq -> 592
    //   586: iconst_1
    //   587: istore #12
    //   589: goto -> 595
    //   592: iconst_0
    //   593: istore #12
    //   595: aload_0
    //   596: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   599: iconst_1
    //   600: aaload
    //   601: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   604: if_acmpeq -> 613
    //   607: iconst_1
    //   608: istore #17
    //   610: goto -> 616
    //   613: iconst_0
    //   614: istore #17
    //   616: aload_0
    //   617: aload_0
    //   618: getfield mDimensionRatioSide : I
    //   621: putfield mResolvedDimensionRatioSide : I
    //   624: aload_0
    //   625: getfield mDimensionRatio : F
    //   628: fstore #18
    //   630: aload_0
    //   631: fload #18
    //   633: putfield mResolvedDimensionRatio : F
    //   636: aload_0
    //   637: getfield mMatchConstraintDefaultWidth : I
    //   640: istore #19
    //   642: aload_0
    //   643: getfield mMatchConstraintDefaultHeight : I
    //   646: istore #20
    //   648: fload #18
    //   650: fconst_0
    //   651: fcmpl
    //   652: ifle -> 1009
    //   655: aload_0
    //   656: getfield mVisibility : I
    //   659: bipush #8
    //   661: if_icmpeq -> 1009
    //   664: iload #19
    //   666: istore #16
    //   668: aload_0
    //   669: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   672: iconst_0
    //   673: aaload
    //   674: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   677: if_acmpne -> 692
    //   680: iload #19
    //   682: istore #16
    //   684: iload #19
    //   686: ifne -> 692
    //   689: iconst_3
    //   690: istore #16
    //   692: iload #20
    //   694: istore #13
    //   696: aload_0
    //   697: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   700: iconst_1
    //   701: aaload
    //   702: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   705: if_acmpne -> 720
    //   708: iload #20
    //   710: istore #13
    //   712: iload #20
    //   714: ifne -> 720
    //   717: iconst_3
    //   718: istore #13
    //   720: aload_0
    //   721: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   724: iconst_0
    //   725: aaload
    //   726: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   729: if_acmpne -> 771
    //   732: aload_0
    //   733: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   736: iconst_1
    //   737: aaload
    //   738: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   741: if_acmpne -> 771
    //   744: iload #16
    //   746: iconst_3
    //   747: if_icmpne -> 771
    //   750: iload #13
    //   752: iconst_3
    //   753: if_icmpne -> 771
    //   756: aload_0
    //   757: iload #11
    //   759: iload #8
    //   761: iload #12
    //   763: iload #17
    //   765: invokevirtual setupDimensionRatio : (ZZZZ)V
    //   768: goto -> 983
    //   771: aload_0
    //   772: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   775: iconst_0
    //   776: aaload
    //   777: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   780: if_acmpne -> 866
    //   783: iload #16
    //   785: iconst_3
    //   786: if_icmpne -> 866
    //   789: aload_0
    //   790: iconst_0
    //   791: putfield mResolvedDimensionRatioSide : I
    //   794: aload_0
    //   795: getfield mResolvedDimensionRatio : F
    //   798: aload_0
    //   799: getfield mHeight : I
    //   802: i2f
    //   803: fmul
    //   804: f2i
    //   805: istore #20
    //   807: aload_0
    //   808: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   811: iconst_1
    //   812: aaload
    //   813: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   816: if_acmpeq -> 840
    //   819: iload #20
    //   821: istore #16
    //   823: iload #14
    //   825: istore #20
    //   827: iload #13
    //   829: istore #14
    //   831: iconst_4
    //   832: istore #15
    //   834: iconst_0
    //   835: istore #13
    //   837: goto -> 1036
    //   840: iload #16
    //   842: istore #15
    //   844: iload #14
    //   846: istore #19
    //   848: iload #13
    //   850: istore #14
    //   852: iconst_1
    //   853: istore #13
    //   855: iload #20
    //   857: istore #16
    //   859: iload #19
    //   861: istore #20
    //   863: goto -> 1036
    //   866: aload_0
    //   867: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   870: iconst_1
    //   871: aaload
    //   872: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   875: if_acmpne -> 983
    //   878: iload #13
    //   880: iconst_3
    //   881: if_icmpne -> 983
    //   884: aload_0
    //   885: iconst_1
    //   886: putfield mResolvedDimensionRatioSide : I
    //   889: aload_0
    //   890: getfield mDimensionRatioSide : I
    //   893: iconst_m1
    //   894: if_icmpne -> 907
    //   897: aload_0
    //   898: fconst_1
    //   899: aload_0
    //   900: getfield mResolvedDimensionRatio : F
    //   903: fdiv
    //   904: putfield mResolvedDimensionRatio : F
    //   907: aload_0
    //   908: getfield mResolvedDimensionRatio : F
    //   911: aload_0
    //   912: getfield mWidth : I
    //   915: i2f
    //   916: fmul
    //   917: f2i
    //   918: istore #20
    //   920: aload_0
    //   921: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   924: iconst_0
    //   925: aaload
    //   926: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   929: if_acmpeq -> 957
    //   932: iload #16
    //   934: istore #14
    //   936: iload #15
    //   938: istore #16
    //   940: iconst_4
    //   941: istore #19
    //   943: iconst_0
    //   944: istore #13
    //   946: iload #14
    //   948: istore #15
    //   950: iload #19
    //   952: istore #14
    //   954: goto -> 1036
    //   957: iload #16
    //   959: istore #14
    //   961: iload #15
    //   963: istore #16
    //   965: iconst_1
    //   966: istore #19
    //   968: iload #14
    //   970: istore #15
    //   972: iload #13
    //   974: istore #14
    //   976: iload #19
    //   978: istore #13
    //   980: goto -> 1036
    //   983: iload #16
    //   985: istore #19
    //   987: iload #15
    //   989: istore #16
    //   991: iload #14
    //   993: istore #20
    //   995: iload #13
    //   997: istore #14
    //   999: iconst_1
    //   1000: istore #13
    //   1002: iload #19
    //   1004: istore #15
    //   1006: goto -> 1036
    //   1009: iload #14
    //   1011: istore #13
    //   1013: iload #20
    //   1015: istore #14
    //   1017: iconst_0
    //   1018: istore #21
    //   1020: iload #13
    //   1022: istore #20
    //   1024: iload #15
    //   1026: istore #16
    //   1028: iload #21
    //   1030: istore #13
    //   1032: iload #19
    //   1034: istore #15
    //   1036: aload_0
    //   1037: getfield mResolvedMatchConstraintDefault : [I
    //   1040: astore #7
    //   1042: aload #7
    //   1044: iconst_0
    //   1045: iload #15
    //   1047: iastore
    //   1048: aload #7
    //   1050: iconst_1
    //   1051: iload #14
    //   1053: iastore
    //   1054: iload #13
    //   1056: ifeq -> 1085
    //   1059: aload_0
    //   1060: getfield mResolvedDimensionRatioSide : I
    //   1063: istore #19
    //   1065: iload #19
    //   1067: ifeq -> 1079
    //   1070: iload #19
    //   1072: iconst_m1
    //   1073: if_icmpne -> 1085
    //   1076: goto -> 1079
    //   1079: iconst_1
    //   1080: istore #12
    //   1082: goto -> 1088
    //   1085: iconst_0
    //   1086: istore #12
    //   1088: aload_0
    //   1089: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1092: iconst_0
    //   1093: aaload
    //   1094: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1097: if_acmpne -> 1113
    //   1100: aload_0
    //   1101: instanceof android/support/constraint/solver/widgets/ConstraintWidgetContainer
    //   1104: ifeq -> 1113
    //   1107: iconst_1
    //   1108: istore #17
    //   1110: goto -> 1116
    //   1113: iconst_0
    //   1114: istore #17
    //   1116: aload_0
    //   1117: getfield mCenter : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1120: invokevirtual isConnected : ()Z
    //   1123: iconst_1
    //   1124: ixor
    //   1125: istore #22
    //   1127: aload_0
    //   1128: getfield mHorizontalResolution : I
    //   1131: iconst_2
    //   1132: if_icmpeq -> 1261
    //   1135: aload_0
    //   1136: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1139: astore #7
    //   1141: aload #7
    //   1143: ifnull -> 1160
    //   1146: aload_1
    //   1147: aload #7
    //   1149: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1152: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   1155: astore #7
    //   1157: goto -> 1163
    //   1160: aconst_null
    //   1161: astore #7
    //   1163: aload_0
    //   1164: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1167: astore #23
    //   1169: aload #23
    //   1171: ifnull -> 1188
    //   1174: aload_1
    //   1175: aload #23
    //   1177: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1180: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   1183: astore #23
    //   1185: goto -> 1191
    //   1188: aconst_null
    //   1189: astore #23
    //   1191: aload_0
    //   1192: aload_1
    //   1193: iload #11
    //   1195: aload #23
    //   1197: aload #7
    //   1199: aload_0
    //   1200: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1203: iconst_0
    //   1204: aaload
    //   1205: iload #17
    //   1207: aload_0
    //   1208: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1211: aload_0
    //   1212: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1215: aload_0
    //   1216: getfield mX : I
    //   1219: iload #16
    //   1221: aload_0
    //   1222: getfield mMinWidth : I
    //   1225: aload_0
    //   1226: getfield mMaxDimension : [I
    //   1229: iconst_0
    //   1230: iaload
    //   1231: aload_0
    //   1232: getfield mHorizontalBiasPercent : F
    //   1235: iload #12
    //   1237: iload #10
    //   1239: iload #15
    //   1241: aload_0
    //   1242: getfield mMatchConstraintMinWidth : I
    //   1245: aload_0
    //   1246: getfield mMatchConstraintMaxWidth : I
    //   1249: aload_0
    //   1250: getfield mMatchConstraintPercentWidth : F
    //   1253: iload #22
    //   1255: invokespecial applyConstraints : (Landroid/support/constraint/solver/LinearSystem;ZLandroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;ZLandroid/support/constraint/solver/widgets/ConstraintAnchor;Landroid/support/constraint/solver/widgets/ConstraintAnchor;IIIIFZZIIIFZ)V
    //   1258: goto -> 1261
    //   1261: aload #4
    //   1263: astore #7
    //   1265: aload_3
    //   1266: astore #23
    //   1268: aload_0
    //   1269: astore_3
    //   1270: aload_3
    //   1271: getfield mVerticalResolution : I
    //   1274: iconst_2
    //   1275: if_icmpne -> 1279
    //   1278: return
    //   1279: aload_3
    //   1280: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1283: iconst_1
    //   1284: aaload
    //   1285: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1288: if_acmpne -> 1304
    //   1291: aload_3
    //   1292: instanceof android/support/constraint/solver/widgets/ConstraintWidgetContainer
    //   1295: ifeq -> 1304
    //   1298: iconst_1
    //   1299: istore #10
    //   1301: goto -> 1307
    //   1304: iconst_0
    //   1305: istore #10
    //   1307: iload #13
    //   1309: ifeq -> 1336
    //   1312: aload_3
    //   1313: getfield mResolvedDimensionRatioSide : I
    //   1316: istore #15
    //   1318: iload #15
    //   1320: iconst_1
    //   1321: if_icmpeq -> 1330
    //   1324: iload #15
    //   1326: iconst_m1
    //   1327: if_icmpne -> 1336
    //   1330: iconst_1
    //   1331: istore #11
    //   1333: goto -> 1339
    //   1336: iconst_0
    //   1337: istore #11
    //   1339: aload_3
    //   1340: getfield mBaselineDistance : I
    //   1343: ifle -> 1432
    //   1346: aload_3
    //   1347: getfield mBaseline : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1350: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1353: getfield state : I
    //   1356: iconst_1
    //   1357: if_icmpne -> 1374
    //   1360: aload_3
    //   1361: getfield mBaseline : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1364: invokevirtual getResolutionNode : ()Landroid/support/constraint/solver/widgets/ResolutionAnchor;
    //   1367: aload_1
    //   1368: invokevirtual addResolvedValue : (Landroid/support/constraint/solver/LinearSystem;)V
    //   1371: goto -> 1432
    //   1374: aload_1
    //   1375: astore #4
    //   1377: aload #4
    //   1379: aload #6
    //   1381: aload #7
    //   1383: aload_0
    //   1384: invokevirtual getBaselineDistance : ()I
    //   1387: bipush #6
    //   1389: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   1392: pop
    //   1393: aload_3
    //   1394: getfield mBaseline : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1397: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1400: ifnull -> 1432
    //   1403: aload #4
    //   1405: aload #6
    //   1407: aload #4
    //   1409: aload_3
    //   1410: getfield mBaseline : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1413: getfield mTarget : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1416: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   1419: iconst_0
    //   1420: bipush #6
    //   1422: invokevirtual addEquality : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;II)Landroid/support/constraint/solver/ArrayRow;
    //   1425: pop
    //   1426: iconst_0
    //   1427: istore #12
    //   1429: goto -> 1436
    //   1432: iload #22
    //   1434: istore #12
    //   1436: aload_1
    //   1437: astore #24
    //   1439: aload #7
    //   1441: astore #4
    //   1443: aload_3
    //   1444: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1447: astore #6
    //   1449: aload #6
    //   1451: ifnull -> 1469
    //   1454: aload #24
    //   1456: aload #6
    //   1458: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1461: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   1464: astore #6
    //   1466: goto -> 1472
    //   1469: aconst_null
    //   1470: astore #6
    //   1472: aload_3
    //   1473: getfield mParent : Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1476: astore #7
    //   1478: aload #7
    //   1480: ifnull -> 1498
    //   1483: aload #24
    //   1485: aload #7
    //   1487: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1490: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroid/support/constraint/solver/SolverVariable;
    //   1493: astore #7
    //   1495: goto -> 1501
    //   1498: aconst_null
    //   1499: astore #7
    //   1501: aload_0
    //   1502: aload_1
    //   1503: iload #8
    //   1505: aload #7
    //   1507: aload #6
    //   1509: aload_3
    //   1510: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1513: iconst_1
    //   1514: aaload
    //   1515: iload #10
    //   1517: aload_3
    //   1518: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1521: aload_3
    //   1522: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1525: aload_3
    //   1526: getfield mY : I
    //   1529: iload #20
    //   1531: aload_3
    //   1532: getfield mMinHeight : I
    //   1535: aload_3
    //   1536: getfield mMaxDimension : [I
    //   1539: iconst_1
    //   1540: iaload
    //   1541: aload_3
    //   1542: getfield mVerticalBiasPercent : F
    //   1545: iload #11
    //   1547: iload #9
    //   1549: iload #14
    //   1551: aload_3
    //   1552: getfield mMatchConstraintMinHeight : I
    //   1555: aload_3
    //   1556: getfield mMatchConstraintMaxHeight : I
    //   1559: aload_3
    //   1560: getfield mMatchConstraintPercentHeight : F
    //   1563: iload #12
    //   1565: invokespecial applyConstraints : (Landroid/support/constraint/solver/LinearSystem;ZLandroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;ZLandroid/support/constraint/solver/widgets/ConstraintAnchor;Landroid/support/constraint/solver/widgets/ConstraintAnchor;IIIIFZZIIIFZ)V
    //   1568: iload #13
    //   1570: ifeq -> 1627
    //   1573: aload_0
    //   1574: astore #6
    //   1576: aload #6
    //   1578: getfield mResolvedDimensionRatioSide : I
    //   1581: iconst_1
    //   1582: if_icmpne -> 1606
    //   1585: aload_1
    //   1586: aload #5
    //   1588: aload #4
    //   1590: aload #23
    //   1592: aload_2
    //   1593: aload #6
    //   1595: getfield mResolvedDimensionRatio : F
    //   1598: bipush #6
    //   1600: invokevirtual addRatio : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;FI)V
    //   1603: goto -> 1627
    //   1606: aload_1
    //   1607: aload #23
    //   1609: aload_2
    //   1610: aload #5
    //   1612: aload #4
    //   1614: aload #6
    //   1616: getfield mResolvedDimensionRatio : F
    //   1619: bipush #6
    //   1621: invokevirtual addRatio : (Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;Landroid/support/constraint/solver/SolverVariable;FI)V
    //   1624: goto -> 1627
    //   1627: aload_0
    //   1628: astore #6
    //   1630: aload #6
    //   1632: getfield mCenter : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1635: invokevirtual isConnected : ()Z
    //   1638: ifeq -> 1680
    //   1641: aload_1
    //   1642: aload #6
    //   1644: aload #6
    //   1646: getfield mCenter : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1649: invokevirtual getTarget : ()Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1652: invokevirtual getOwner : ()Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1655: aload #6
    //   1657: getfield mCircleConstraintAngle : F
    //   1660: ldc_w 90.0
    //   1663: fadd
    //   1664: f2d
    //   1665: invokestatic toRadians : (D)D
    //   1668: d2f
    //   1669: aload #6
    //   1671: getfield mCenter : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1674: invokevirtual getMargin : ()I
    //   1677: invokevirtual addCenterPoint : (Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintWidget;FI)V
    //   1680: return
  }
  
  public boolean allowedInBarrier() {
    boolean bool;
    if (this.mVisibility != 8) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void analyze(int paramInt) {
    Optimizer.analyze(paramInt, this);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2) {
    connect(paramType1, paramConstraintWidget, paramType2, 0, ConstraintAnchor.Strength.STRONG);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt) {
    connect(paramType1, paramConstraintWidget, paramType2, paramInt, ConstraintAnchor.Strength.STRONG);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt, ConstraintAnchor.Strength paramStrength) {
    connect(paramType1, paramConstraintWidget, paramType2, paramInt, paramStrength, 0);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt1, ConstraintAnchor.Strength paramStrength, int paramInt2) {
    ConstraintAnchor constraintAnchor;
    ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
    boolean bool = false;
    if (paramType1 == type) {
      if (paramType2 == ConstraintAnchor.Type.CENTER) {
        constraintAnchor = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor constraintAnchor3 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor constraintAnchor1 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor constraintAnchor2 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        bool = true;
        if ((constraintAnchor != null && constraintAnchor.isConnected()) || (constraintAnchor3 != null && constraintAnchor3.isConnected())) {
          paramInt1 = 0;
        } else {
          connect(ConstraintAnchor.Type.LEFT, paramConstraintWidget, ConstraintAnchor.Type.LEFT, 0, paramStrength, paramInt2);
          connect(ConstraintAnchor.Type.RIGHT, paramConstraintWidget, ConstraintAnchor.Type.RIGHT, 0, paramStrength, paramInt2);
          paramInt1 = 1;
        } 
        if ((constraintAnchor1 != null && constraintAnchor1.isConnected()) || (constraintAnchor2 != null && constraintAnchor2.isConnected())) {
          bool = false;
        } else {
          connect(ConstraintAnchor.Type.TOP, paramConstraintWidget, ConstraintAnchor.Type.TOP, 0, paramStrength, paramInt2);
          connect(ConstraintAnchor.Type.BOTTOM, paramConstraintWidget, ConstraintAnchor.Type.BOTTOM, 0, paramStrength, paramInt2);
        } 
        if (paramInt1 != 0 && bool) {
          getAnchor(ConstraintAnchor.Type.CENTER).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.CENTER), 0, paramInt2);
        } else if (paramInt1 != 0) {
          getAnchor(ConstraintAnchor.Type.CENTER_X).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_X), 0, paramInt2);
        } else if (bool) {
          getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0, paramInt2);
        } 
      } else {
        if (constraintAnchor == ConstraintAnchor.Type.LEFT || constraintAnchor == ConstraintAnchor.Type.RIGHT) {
          connect(ConstraintAnchor.Type.LEFT, paramConstraintWidget, (ConstraintAnchor.Type)constraintAnchor, 0, paramStrength, paramInt2);
          paramType1 = ConstraintAnchor.Type.RIGHT;
          try {
            connect(paramType1, paramConstraintWidget, (ConstraintAnchor.Type)constraintAnchor, 0, paramStrength, paramInt2);
            getAnchor(ConstraintAnchor.Type.CENTER).connect(paramConstraintWidget.getAnchor((ConstraintAnchor.Type)constraintAnchor), 0, paramInt2);
            return;
          } catch (Throwable throwable) {
            throw throwable;
          } 
        } 
        if (constraintAnchor == ConstraintAnchor.Type.TOP || constraintAnchor == ConstraintAnchor.Type.BOTTOM) {
          connect(ConstraintAnchor.Type.TOP, paramConstraintWidget, (ConstraintAnchor.Type)constraintAnchor, 0, paramStrength, paramInt2);
          connect(ConstraintAnchor.Type.BOTTOM, paramConstraintWidget, (ConstraintAnchor.Type)constraintAnchor, 0, paramStrength, paramInt2);
          getAnchor(ConstraintAnchor.Type.CENTER).connect(paramConstraintWidget.getAnchor((ConstraintAnchor.Type)constraintAnchor), 0, paramInt2);
        } 
      } 
    } else {
      ConstraintAnchor constraintAnchor1;
      ConstraintAnchor constraintAnchor2;
      if (throwable == ConstraintAnchor.Type.CENTER_X && (constraintAnchor == ConstraintAnchor.Type.LEFT || constraintAnchor == ConstraintAnchor.Type.RIGHT)) {
        constraintAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT);
        constraintAnchor2 = paramConstraintWidget.getAnchor((ConstraintAnchor.Type)constraintAnchor);
        constraintAnchor = getAnchor(ConstraintAnchor.Type.RIGHT);
        constraintAnchor1.connect(constraintAnchor2, 0, paramInt2);
        constraintAnchor.connect(constraintAnchor2, 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintAnchor2, 0, paramInt2);
      } else if (constraintAnchor1 == ConstraintAnchor.Type.CENTER_Y && (constraintAnchor == ConstraintAnchor.Type.TOP || constraintAnchor == ConstraintAnchor.Type.BOTTOM)) {
        constraintAnchor1 = constraintAnchor2.getAnchor((ConstraintAnchor.Type)constraintAnchor);
        getAnchor(ConstraintAnchor.Type.TOP).connect(constraintAnchor1, 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintAnchor1, 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintAnchor1, 0, paramInt2);
      } else if (constraintAnchor1 == ConstraintAnchor.Type.CENTER_X && constraintAnchor == ConstraintAnchor.Type.CENTER_X) {
        getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintAnchor2.getAnchor(ConstraintAnchor.Type.LEFT), 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintAnchor2.getAnchor(ConstraintAnchor.Type.RIGHT), 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintAnchor2.getAnchor((ConstraintAnchor.Type)constraintAnchor), 0, paramInt2);
      } else if (constraintAnchor1 == ConstraintAnchor.Type.CENTER_Y && constraintAnchor == ConstraintAnchor.Type.CENTER_Y) {
        getAnchor(ConstraintAnchor.Type.TOP).connect(constraintAnchor2.getAnchor(ConstraintAnchor.Type.TOP), 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintAnchor2.getAnchor(ConstraintAnchor.Type.BOTTOM), 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintAnchor2.getAnchor((ConstraintAnchor.Type)constraintAnchor), 0, paramInt2);
      } else {
        ConstraintAnchor constraintAnchor3 = getAnchor((ConstraintAnchor.Type)constraintAnchor1);
        constraintAnchor2 = constraintAnchor2.getAnchor((ConstraintAnchor.Type)constraintAnchor);
        if (constraintAnchor3.isValidConnection(constraintAnchor2)) {
          if (constraintAnchor1 == ConstraintAnchor.Type.BASELINE) {
            constraintAnchor = getAnchor(ConstraintAnchor.Type.TOP);
            constraintAnchor1 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            if (constraintAnchor != null)
              constraintAnchor.reset(); 
            if (constraintAnchor1 != null)
              constraintAnchor1.reset(); 
            paramInt1 = bool;
          } else if (constraintAnchor1 == ConstraintAnchor.Type.TOP || constraintAnchor1 == ConstraintAnchor.Type.BOTTOM) {
            constraintAnchor = getAnchor(ConstraintAnchor.Type.BASELINE);
            if (constraintAnchor != null)
              constraintAnchor.reset(); 
            constraintAnchor = getAnchor(ConstraintAnchor.Type.CENTER);
            if (constraintAnchor.getTarget() != constraintAnchor2)
              constraintAnchor.reset(); 
            constraintAnchor = getAnchor((ConstraintAnchor.Type)constraintAnchor1).getOpposite();
            constraintAnchor1 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (constraintAnchor1.isConnected()) {
              constraintAnchor.reset();
              constraintAnchor1.reset();
            } 
          } else if (constraintAnchor1 == ConstraintAnchor.Type.LEFT || constraintAnchor1 == ConstraintAnchor.Type.RIGHT) {
            constraintAnchor = getAnchor(ConstraintAnchor.Type.CENTER);
            if (constraintAnchor.getTarget() != constraintAnchor2)
              constraintAnchor.reset(); 
            constraintAnchor = getAnchor((ConstraintAnchor.Type)constraintAnchor1).getOpposite();
            constraintAnchor1 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            if (constraintAnchor1.isConnected()) {
              constraintAnchor.reset();
              constraintAnchor1.reset();
            } 
          } 
          constraintAnchor3.connect(constraintAnchor2, paramInt1, paramStrength, paramInt2);
          constraintAnchor2.getOwner().connectedTo(constraintAnchor3.getOwner());
        } 
      } 
    } 
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt) {
    connect(paramConstraintAnchor1, paramConstraintAnchor2, paramInt, ConstraintAnchor.Strength.STRONG, 0);
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, int paramInt2) {
    connect(paramConstraintAnchor1, paramConstraintAnchor2, paramInt1, ConstraintAnchor.Strength.STRONG, paramInt2);
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, ConstraintAnchor.Strength paramStrength, int paramInt2) {
    if (paramConstraintAnchor1.getOwner() == this)
      connect(paramConstraintAnchor1.getType(), paramConstraintAnchor2.getOwner(), paramConstraintAnchor2.getType(), paramInt1, paramStrength, paramInt2); 
  }
  
  public void connectCircularConstraint(ConstraintWidget paramConstraintWidget, float paramFloat, int paramInt) {
    immediateConnect(ConstraintAnchor.Type.CENTER, paramConstraintWidget, ConstraintAnchor.Type.CENTER, paramInt, 0);
    this.mCircleConstraintAngle = paramFloat;
  }
  
  public void connectedTo(ConstraintWidget paramConstraintWidget) {}
  
  public void createObjectVariables(LinearSystem paramLinearSystem) {
    paramLinearSystem.createObjectVariable(this.mLeft);
    paramLinearSystem.createObjectVariable(this.mTop);
    paramLinearSystem.createObjectVariable(this.mRight);
    paramLinearSystem.createObjectVariable(this.mBottom);
    if (this.mBaselineDistance > 0)
      paramLinearSystem.createObjectVariable(this.mBaseline); 
  }
  
  public void disconnectUnlockedWidget(ConstraintWidget paramConstraintWidget) {
    ArrayList<ConstraintAnchor> arrayList = getAnchors();
    int i = arrayList.size();
    for (byte b = 0; b < i; b++) {
      ConstraintAnchor constraintAnchor = arrayList.get(b);
      if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == paramConstraintWidget && constraintAnchor.getConnectionCreator() == 2)
        constraintAnchor.reset(); 
    } 
  }
  
  public void disconnectWidget(ConstraintWidget paramConstraintWidget) {
    ArrayList<ConstraintAnchor> arrayList = getAnchors();
    int i = arrayList.size();
    for (byte b = 0; b < i; b++) {
      ConstraintAnchor constraintAnchor = arrayList.get(b);
      if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == paramConstraintWidget)
        constraintAnchor.reset(); 
    } 
  }
  
  public void forceUpdateDrawPosition() {
    int i = this.mX;
    int j = this.mY;
    int k = this.mWidth;
    int m = this.mHeight;
    this.mDrawX = i;
    this.mDrawY = j;
    this.mDrawWidth = k + i - i;
    this.mDrawHeight = m + j - j;
  }
  
  public ConstraintAnchor getAnchor(ConstraintAnchor.Type paramType) {
    switch (paramType) {
      default:
        throw new AssertionError(paramType.name());
      case null:
        return null;
      case null:
        return this.mCenterY;
      case null:
        return this.mCenterX;
      case null:
        return this.mCenter;
      case null:
        return this.mBaseline;
      case MATCH_CONSTRAINT:
        return this.mBottom;
      case MATCH_PARENT:
        return this.mRight;
      case WRAP_CONTENT:
        return this.mTop;
      case FIXED:
        break;
    } 
    return this.mLeft;
  }
  
  public ArrayList<ConstraintAnchor> getAnchors() {
    return this.mAnchors;
  }
  
  public int getBaselineDistance() {
    return this.mBaselineDistance;
  }
  
  public int getBottom() {
    return getY() + this.mHeight;
  }
  
  public Object getCompanionWidget() {
    return this.mCompanionWidget;
  }
  
  public int getContainerItemSkip() {
    return this.mContainerItemSkip;
  }
  
  public String getDebugName() {
    return this.mDebugName;
  }
  
  public float getDimensionRatio() {
    return this.mDimensionRatio;
  }
  
  public int getDimensionRatioSide() {
    return this.mDimensionRatioSide;
  }
  
  public int getDrawBottom() {
    return getDrawY() + this.mDrawHeight;
  }
  
  public int getDrawHeight() {
    return this.mDrawHeight;
  }
  
  public int getDrawRight() {
    return getDrawX() + this.mDrawWidth;
  }
  
  public int getDrawWidth() {
    return this.mDrawWidth;
  }
  
  public int getDrawX() {
    return this.mDrawX + this.mOffsetX;
  }
  
  public int getDrawY() {
    return this.mDrawY + this.mOffsetY;
  }
  
  public int getHeight() {
    return (this.mVisibility == 8) ? 0 : this.mHeight;
  }
  
  public float getHorizontalBiasPercent() {
    return this.mHorizontalBiasPercent;
  }
  
  public ConstraintWidget getHorizontalChainControlWidget() {
    ConstraintWidget constraintWidget;
    if (isInHorizontalChain()) {
      ConstraintWidget constraintWidget1 = this;
      ConstraintAnchor constraintAnchor = null;
      while (true) {
        constraintWidget = (ConstraintWidget)constraintAnchor;
        if (constraintAnchor == null) {
          constraintWidget = (ConstraintWidget)constraintAnchor;
          if (constraintWidget1 != null) {
            ConstraintWidget constraintWidget2;
            ConstraintAnchor constraintAnchor1;
            constraintWidget = (ConstraintWidget)constraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT);
            if (constraintWidget == null) {
              constraintWidget = null;
            } else {
              constraintWidget = (ConstraintWidget)constraintWidget.getTarget();
            } 
            if (constraintWidget == null) {
              constraintWidget = null;
            } else {
              constraintWidget2 = constraintWidget.getOwner();
            } 
            if (constraintWidget2 == getParent()) {
              constraintWidget2 = constraintWidget1;
              break;
            } 
            if (constraintWidget2 == null) {
              constraintAnchor1 = null;
            } else {
              constraintAnchor1 = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            } 
            if (constraintAnchor1 != null && constraintAnchor1.getOwner() != constraintWidget1) {
              ConstraintWidget constraintWidget3 = constraintWidget1;
              continue;
            } 
            constraintWidget1 = constraintWidget2;
            continue;
          } 
        } 
        break;
      } 
    } else {
      constraintWidget = null;
    } 
    return constraintWidget;
  }
  
  public int getHorizontalChainStyle() {
    return this.mHorizontalChainStyle;
  }
  
  public DimensionBehaviour getHorizontalDimensionBehaviour() {
    return this.mListDimensionBehaviors[0];
  }
  
  public int getInternalDrawBottom() {
    return this.mDrawY + this.mDrawHeight;
  }
  
  public int getInternalDrawRight() {
    return this.mDrawX + this.mDrawWidth;
  }
  
  int getInternalDrawX() {
    return this.mDrawX;
  }
  
  int getInternalDrawY() {
    return this.mDrawY;
  }
  
  public int getLeft() {
    return getX();
  }
  
  public int getMaxHeight() {
    return this.mMaxDimension[1];
  }
  
  public int getMaxWidth() {
    return this.mMaxDimension[0];
  }
  
  public int getMinHeight() {
    return this.mMinHeight;
  }
  
  public int getMinWidth() {
    return this.mMinWidth;
  }
  
  public int getOptimizerWrapHeight() {
    int i = this.mHeight;
    int j = i;
    if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
      if (this.mMatchConstraintDefaultHeight == 1) {
        i = Math.max(this.mMatchConstraintMinHeight, i);
      } else {
        i = this.mMatchConstraintMinHeight;
        if (i > 0) {
          this.mHeight = i;
        } else {
          i = 0;
        } 
      } 
      int k = this.mMatchConstraintMaxHeight;
      j = i;
      if (k > 0) {
        j = i;
        if (k < i)
          j = k; 
      } 
    } 
    return j;
  }
  
  public int getOptimizerWrapWidth() {
    int i = this.mWidth;
    int j = i;
    if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
      if (this.mMatchConstraintDefaultWidth == 1) {
        i = Math.max(this.mMatchConstraintMinWidth, i);
      } else {
        i = this.mMatchConstraintMinWidth;
        if (i > 0) {
          this.mWidth = i;
        } else {
          i = 0;
        } 
      } 
      int k = this.mMatchConstraintMaxWidth;
      j = i;
      if (k > 0) {
        j = i;
        if (k < i)
          j = k; 
      } 
    } 
    return j;
  }
  
  public ConstraintWidget getParent() {
    return this.mParent;
  }
  
  public ResolutionDimension getResolutionHeight() {
    if (this.mResolutionHeight == null)
      this.mResolutionHeight = new ResolutionDimension(); 
    return this.mResolutionHeight;
  }
  
  public ResolutionDimension getResolutionWidth() {
    if (this.mResolutionWidth == null)
      this.mResolutionWidth = new ResolutionDimension(); 
    return this.mResolutionWidth;
  }
  
  public int getRight() {
    return getX() + this.mWidth;
  }
  
  public WidgetContainer getRootWidgetContainer() {
    ConstraintWidget constraintWidget;
    for (constraintWidget = this; constraintWidget.getParent() != null; constraintWidget = constraintWidget.getParent());
    return (constraintWidget instanceof WidgetContainer) ? (WidgetContainer)constraintWidget : null;
  }
  
  protected int getRootX() {
    return this.mX + this.mOffsetX;
  }
  
  protected int getRootY() {
    return this.mY + this.mOffsetY;
  }
  
  public int getTop() {
    return getY();
  }
  
  public String getType() {
    return this.mType;
  }
  
  public float getVerticalBiasPercent() {
    return this.mVerticalBiasPercent;
  }
  
  public ConstraintWidget getVerticalChainControlWidget() {
    ConstraintWidget constraintWidget;
    if (isInVerticalChain()) {
      ConstraintWidget constraintWidget1 = this;
      ConstraintAnchor constraintAnchor = null;
      while (true) {
        constraintWidget = (ConstraintWidget)constraintAnchor;
        if (constraintAnchor == null) {
          constraintWidget = (ConstraintWidget)constraintAnchor;
          if (constraintWidget1 != null) {
            ConstraintWidget constraintWidget2;
            ConstraintAnchor constraintAnchor1;
            constraintWidget = (ConstraintWidget)constraintWidget1.getAnchor(ConstraintAnchor.Type.TOP);
            if (constraintWidget == null) {
              constraintWidget = null;
            } else {
              constraintWidget = (ConstraintWidget)constraintWidget.getTarget();
            } 
            if (constraintWidget == null) {
              constraintWidget = null;
            } else {
              constraintWidget2 = constraintWidget.getOwner();
            } 
            if (constraintWidget2 == getParent()) {
              constraintWidget2 = constraintWidget1;
              break;
            } 
            if (constraintWidget2 == null) {
              constraintAnchor1 = null;
            } else {
              constraintAnchor1 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            } 
            if (constraintAnchor1 != null && constraintAnchor1.getOwner() != constraintWidget1) {
              ConstraintWidget constraintWidget3 = constraintWidget1;
              continue;
            } 
            constraintWidget1 = constraintWidget2;
            continue;
          } 
        } 
        break;
      } 
    } else {
      constraintWidget = null;
    } 
    return constraintWidget;
  }
  
  public int getVerticalChainStyle() {
    return this.mVerticalChainStyle;
  }
  
  public DimensionBehaviour getVerticalDimensionBehaviour() {
    return this.mListDimensionBehaviors[1];
  }
  
  public int getVisibility() {
    return this.mVisibility;
  }
  
  public int getWidth() {
    return (this.mVisibility == 8) ? 0 : this.mWidth;
  }
  
  public int getWrapHeight() {
    return this.mWrapHeight;
  }
  
  public int getWrapWidth() {
    return this.mWrapWidth;
  }
  
  public int getX() {
    return this.mX;
  }
  
  public int getY() {
    return this.mY;
  }
  
  public boolean hasAncestor(ConstraintWidget paramConstraintWidget) {
    ConstraintWidget constraintWidget1 = getParent();
    if (constraintWidget1 == paramConstraintWidget)
      return true; 
    ConstraintWidget constraintWidget2 = constraintWidget1;
    if (constraintWidget1 == paramConstraintWidget.getParent())
      return false; 
    while (constraintWidget2 != null) {
      if (constraintWidget2 == paramConstraintWidget)
        return true; 
      if (constraintWidget2 == paramConstraintWidget.getParent())
        return true; 
      constraintWidget2 = constraintWidget2.getParent();
    } 
    return false;
  }
  
  public boolean hasBaseline() {
    boolean bool;
    if (this.mBaselineDistance > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void immediateConnect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt1, int paramInt2) {
    getAnchor(paramType1).connect(paramConstraintWidget.getAnchor(paramType2), paramInt1, paramInt2, ConstraintAnchor.Strength.STRONG, 0, true);
  }
  
  public boolean isFullyResolved() {
    return ((this.mLeft.getResolutionNode()).state == 1 && (this.mRight.getResolutionNode()).state == 1 && (this.mTop.getResolutionNode()).state == 1 && (this.mBottom.getResolutionNode()).state == 1);
  }
  
  public boolean isHeightWrapContent() {
    return this.mIsHeightWrapContent;
  }
  
  public boolean isInHorizontalChain() {
    return ((this.mLeft.mTarget != null && this.mLeft.mTarget.mTarget == this.mLeft) || (this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight));
  }
  
  public boolean isInVerticalChain() {
    return ((this.mTop.mTarget != null && this.mTop.mTarget.mTarget == this.mTop) || (this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom));
  }
  
  public boolean isInsideConstraintLayout() {
    ConstraintWidget constraintWidget1 = getParent();
    ConstraintWidget constraintWidget2 = constraintWidget1;
    if (constraintWidget1 == null)
      return false; 
    while (constraintWidget2 != null) {
      if (constraintWidget2 instanceof ConstraintWidgetContainer)
        return true; 
      constraintWidget2 = constraintWidget2.getParent();
    } 
    return false;
  }
  
  public boolean isRoot() {
    boolean bool;
    if (this.mParent == null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isRootContainer() {
    if (this instanceof ConstraintWidgetContainer) {
      ConstraintWidget constraintWidget = this.mParent;
      if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer))
        return true; 
    } 
    return false;
  }
  
  public boolean isSpreadHeight() {
    int i = this.mMatchConstraintDefaultHeight;
    boolean bool = true;
    if (i != 0 || this.mDimensionRatio != 0.0F || this.mMatchConstraintMinHeight != 0 || this.mMatchConstraintMaxHeight != 0 || this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT)
      bool = false; 
    return bool;
  }
  
  public boolean isSpreadWidth() {
    int i = this.mMatchConstraintDefaultWidth;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (i == 0) {
      bool2 = bool1;
      if (this.mDimensionRatio == 0.0F) {
        bool2 = bool1;
        if (this.mMatchConstraintMinWidth == 0) {
          bool2 = bool1;
          if (this.mMatchConstraintMaxWidth == 0) {
            bool2 = bool1;
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT)
              bool2 = true; 
          } 
        } 
      } 
    } 
    return bool2;
  }
  
  public boolean isWidthWrapContent() {
    return this.mIsWidthWrapContent;
  }
  
  public void reset() {
    this.mLeft.reset();
    this.mTop.reset();
    this.mRight.reset();
    this.mBottom.reset();
    this.mBaseline.reset();
    this.mCenterX.reset();
    this.mCenterY.reset();
    this.mCenter.reset();
    this.mParent = null;
    this.mCircleConstraintAngle = 0.0F;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mDimensionRatio = 0.0F;
    this.mDimensionRatioSide = -1;
    this.mX = 0;
    this.mY = 0;
    this.mDrawX = 0;
    this.mDrawY = 0;
    this.mDrawWidth = 0;
    this.mDrawHeight = 0;
    this.mOffsetX = 0;
    this.mOffsetY = 0;
    this.mBaselineDistance = 0;
    this.mMinWidth = 0;
    this.mMinHeight = 0;
    this.mWrapWidth = 0;
    this.mWrapHeight = 0;
    float f = DEFAULT_BIAS;
    this.mHorizontalBiasPercent = f;
    this.mVerticalBiasPercent = f;
    this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
    this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
    this.mCompanionWidget = null;
    this.mContainerItemSkip = 0;
    this.mVisibility = 0;
    this.mType = null;
    this.mHorizontalWrapVisited = false;
    this.mVerticalWrapVisited = false;
    this.mHorizontalChainStyle = 0;
    this.mVerticalChainStyle = 0;
    this.mHorizontalChainFixedPosition = false;
    this.mVerticalChainFixedPosition = false;
    float[] arrayOfFloat = this.mWeight;
    arrayOfFloat[0] = -1.0F;
    arrayOfFloat[1] = -1.0F;
    this.mHorizontalResolution = -1;
    this.mVerticalResolution = -1;
    int[] arrayOfInt = this.mMaxDimension;
    arrayOfInt[0] = Integer.MAX_VALUE;
    arrayOfInt[1] = Integer.MAX_VALUE;
    this.mMatchConstraintDefaultWidth = 0;
    this.mMatchConstraintDefaultHeight = 0;
    this.mMatchConstraintPercentWidth = 1.0F;
    this.mMatchConstraintPercentHeight = 1.0F;
    this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
    this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
    this.mMatchConstraintMinWidth = 0;
    this.mMatchConstraintMinHeight = 0;
    this.mResolvedDimensionRatioSide = -1;
    this.mResolvedDimensionRatio = 1.0F;
    ResolutionDimension resolutionDimension = this.mResolutionWidth;
    if (resolutionDimension != null)
      resolutionDimension.reset(); 
    resolutionDimension = this.mResolutionHeight;
    if (resolutionDimension != null)
      resolutionDimension.reset(); 
  }
  
  public void resetAllConstraints() {
    resetAnchors();
    setVerticalBiasPercent(DEFAULT_BIAS);
    setHorizontalBiasPercent(DEFAULT_BIAS);
    if (this instanceof ConstraintWidgetContainer)
      return; 
    if (getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT)
      if (getWidth() == getWrapWidth()) {
        setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
      } else if (getWidth() > getMinWidth()) {
        setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
      }  
    if (getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT)
      if (getHeight() == getWrapHeight()) {
        setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
      } else if (getHeight() > getMinHeight()) {
        setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
      }  
  }
  
  public void resetAnchor(ConstraintAnchor paramConstraintAnchor) {
    if (getParent() != null && getParent() instanceof ConstraintWidgetContainer && ((ConstraintWidgetContainer)getParent()).handlesInternalConstraints())
      return; 
    ConstraintAnchor constraintAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT);
    ConstraintAnchor constraintAnchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
    ConstraintAnchor constraintAnchor3 = getAnchor(ConstraintAnchor.Type.TOP);
    ConstraintAnchor constraintAnchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
    ConstraintAnchor constraintAnchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
    ConstraintAnchor constraintAnchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor constraintAnchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
    if (paramConstraintAnchor == constraintAnchor5) {
      if (constraintAnchor1.isConnected() && constraintAnchor2.isConnected() && constraintAnchor1.getTarget() == constraintAnchor2.getTarget()) {
        constraintAnchor1.reset();
        constraintAnchor2.reset();
      } 
      if (constraintAnchor3.isConnected() && constraintAnchor4.isConnected() && constraintAnchor3.getTarget() == constraintAnchor4.getTarget()) {
        constraintAnchor3.reset();
        constraintAnchor4.reset();
      } 
      this.mHorizontalBiasPercent = 0.5F;
      this.mVerticalBiasPercent = 0.5F;
    } else if (paramConstraintAnchor == constraintAnchor6) {
      if (constraintAnchor1.isConnected() && constraintAnchor2.isConnected() && constraintAnchor1.getTarget().getOwner() == constraintAnchor2.getTarget().getOwner()) {
        constraintAnchor1.reset();
        constraintAnchor2.reset();
      } 
      this.mHorizontalBiasPercent = 0.5F;
    } else if (paramConstraintAnchor == constraintAnchor7) {
      if (constraintAnchor3.isConnected() && constraintAnchor4.isConnected() && constraintAnchor3.getTarget().getOwner() == constraintAnchor4.getTarget().getOwner()) {
        constraintAnchor3.reset();
        constraintAnchor4.reset();
      } 
      this.mVerticalBiasPercent = 0.5F;
    } else if (paramConstraintAnchor == constraintAnchor1 || paramConstraintAnchor == constraintAnchor2) {
      if (constraintAnchor1.isConnected() && constraintAnchor1.getTarget() == constraintAnchor2.getTarget())
        constraintAnchor5.reset(); 
    } else if ((paramConstraintAnchor == constraintAnchor3 || paramConstraintAnchor == constraintAnchor4) && constraintAnchor3.isConnected() && constraintAnchor3.getTarget() == constraintAnchor4.getTarget()) {
      constraintAnchor5.reset();
    } 
    paramConstraintAnchor.reset();
  }
  
  public void resetAnchors() {
    ConstraintWidget constraintWidget = getParent();
    if (constraintWidget != null && constraintWidget instanceof ConstraintWidgetContainer && ((ConstraintWidgetContainer)getParent()).handlesInternalConstraints())
      return; 
    byte b = 0;
    int i = this.mAnchors.size();
    while (b < i) {
      ((ConstraintAnchor)this.mAnchors.get(b)).reset();
      b++;
    } 
  }
  
  public void resetAnchors(int paramInt) {
    ConstraintWidget constraintWidget = getParent();
    if (constraintWidget != null && constraintWidget instanceof ConstraintWidgetContainer && ((ConstraintWidgetContainer)getParent()).handlesInternalConstraints())
      return; 
    byte b = 0;
    int i = this.mAnchors.size();
    while (b < i) {
      ConstraintAnchor constraintAnchor = this.mAnchors.get(b);
      if (paramInt == constraintAnchor.getConnectionCreator()) {
        if (constraintAnchor.isVerticalAnchor()) {
          setVerticalBiasPercent(DEFAULT_BIAS);
        } else {
          setHorizontalBiasPercent(DEFAULT_BIAS);
        } 
        constraintAnchor.reset();
      } 
      b++;
    } 
  }
  
  public void resetResolutionNodes() {
    for (byte b = 0; b < 6; b++)
      this.mListAnchors[b].getResolutionNode().reset(); 
  }
  
  public void resetSolverVariables(Cache paramCache) {
    this.mLeft.resetSolverVariable(paramCache);
    this.mTop.resetSolverVariable(paramCache);
    this.mRight.resetSolverVariable(paramCache);
    this.mBottom.resetSolverVariable(paramCache);
    this.mBaseline.resetSolverVariable(paramCache);
    this.mCenter.resetSolverVariable(paramCache);
    this.mCenterX.resetSolverVariable(paramCache);
    this.mCenterY.resetSolverVariable(paramCache);
  }
  
  public void resolve() {}
  
  public void setBaselineDistance(int paramInt) {
    this.mBaselineDistance = paramInt;
  }
  
  public void setCompanionWidget(Object paramObject) {
    this.mCompanionWidget = paramObject;
  }
  
  public void setContainerItemSkip(int paramInt) {
    if (paramInt >= 0) {
      this.mContainerItemSkip = paramInt;
    } else {
      this.mContainerItemSkip = 0;
    } 
  }
  
  public void setDebugName(String paramString) {
    this.mDebugName = paramString;
  }
  
  public void setDebugSolverName(LinearSystem paramLinearSystem, String paramString) {
    this.mDebugName = paramString;
    SolverVariable solverVariable1 = paramLinearSystem.createObjectVariable(this.mLeft);
    SolverVariable solverVariable2 = paramLinearSystem.createObjectVariable(this.mTop);
    SolverVariable solverVariable3 = paramLinearSystem.createObjectVariable(this.mRight);
    SolverVariable solverVariable4 = paramLinearSystem.createObjectVariable(this.mBottom);
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramString);
    stringBuilder3.append(".left");
    solverVariable1.setName(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramString);
    stringBuilder3.append(".top");
    solverVariable2.setName(stringBuilder3.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramString);
    stringBuilder1.append(".right");
    solverVariable3.setName(stringBuilder1.toString());
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString);
    stringBuilder2.append(".bottom");
    solverVariable4.setName(stringBuilder2.toString());
    if (this.mBaselineDistance > 0) {
      solverVariable4 = paramLinearSystem.createObjectVariable(this.mBaseline);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(".baseline");
      solverVariable4.setName(stringBuilder.toString());
    } 
  }
  
  public void setDimension(int paramInt1, int paramInt2) {
    this.mWidth = paramInt1;
    paramInt1 = this.mWidth;
    int i = this.mMinWidth;
    if (paramInt1 < i)
      this.mWidth = i; 
    this.mHeight = paramInt2;
    paramInt1 = this.mHeight;
    paramInt2 = this.mMinHeight;
    if (paramInt1 < paramInt2)
      this.mHeight = paramInt2; 
  }
  
  public void setDimensionRatio(float paramFloat, int paramInt) {
    this.mDimensionRatio = paramFloat;
    this.mDimensionRatioSide = paramInt;
  }
  
  public void setDimensionRatio(String paramString) {
    float f;
    if (paramString == null || paramString.length() == 0) {
      this.mDimensionRatio = 0.0F;
      return;
    } 
    int i = -1;
    int j = paramString.length();
    int k = paramString.indexOf(',');
    byte b = 0;
    int m = i;
    int n = b;
    if (k > 0) {
      m = i;
      n = b;
      if (k < j - 1) {
        String str = paramString.substring(0, k);
        if (str.equalsIgnoreCase("W")) {
          m = 0;
        } else {
          m = i;
          if (str.equalsIgnoreCase("H"))
            m = 1; 
        } 
        n = k + 1;
      } 
    } 
    i = paramString.indexOf(':');
    if (i >= 0 && i < j - 1) {
      String str = paramString.substring(n, i);
      paramString = paramString.substring(i + 1);
      if (str.length() > 0 && paramString.length() > 0)
        try {
          float f1 = Float.parseFloat(str);
          float f2 = Float.parseFloat(paramString);
          if (f1 > 0.0F && f2 > 0.0F) {
            if (m == 1) {
              f2 = Math.abs(f2 / f1);
            } else {
              f2 = Math.abs(f1 / f2);
            } 
          } else {
            f2 = 0.0F;
          } 
          if (f2 > 0.0F) {
            this.mDimensionRatio = f2;
            this.mDimensionRatioSide = m;
          } 
          return;
        } catch (NumberFormatException numberFormatException) {} 
      f = 0.0F;
    } else {
      String str = numberFormatException.substring(n);
      if (str.length() > 0)
        try {
          float f1 = Float.parseFloat(str);
          if (f1 > 0.0F) {
            this.mDimensionRatio = f1;
            this.mDimensionRatioSide = m;
          } 
          return;
        } catch (NumberFormatException numberFormatException1) {} 
      f = 0.0F;
    } 
    if (f > 0.0F) {
      this.mDimensionRatio = f;
      this.mDimensionRatioSide = m;
    } 
  }
  
  public void setDrawHeight(int paramInt) {
    this.mDrawHeight = paramInt;
  }
  
  public void setDrawOrigin(int paramInt1, int paramInt2) {
    this.mDrawX = paramInt1 - this.mOffsetX;
    this.mDrawY = paramInt2 - this.mOffsetY;
    this.mX = this.mDrawX;
    this.mY = this.mDrawY;
  }
  
  public void setDrawWidth(int paramInt) {
    this.mDrawWidth = paramInt;
  }
  
  public void setDrawX(int paramInt) {
    this.mDrawX = paramInt - this.mOffsetX;
    this.mX = this.mDrawX;
  }
  
  public void setDrawY(int paramInt) {
    this.mDrawY = paramInt - this.mOffsetY;
    this.mY = this.mDrawY;
  }
  
  public void setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: iload_3
    //   1: iload_1
    //   2: isub
    //   3: istore #5
    //   5: iload #4
    //   7: iload_2
    //   8: isub
    //   9: istore_3
    //   10: aload_0
    //   11: iload_1
    //   12: putfield mX : I
    //   15: aload_0
    //   16: iload_2
    //   17: putfield mY : I
    //   20: aload_0
    //   21: getfield mVisibility : I
    //   24: bipush #8
    //   26: if_icmpne -> 40
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield mWidth : I
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield mHeight : I
    //   39: return
    //   40: aload_0
    //   41: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   44: iconst_0
    //   45: aaload
    //   46: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.FIXED : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   49: if_acmpne -> 66
    //   52: aload_0
    //   53: getfield mWidth : I
    //   56: istore_1
    //   57: iload #5
    //   59: iload_1
    //   60: if_icmpge -> 66
    //   63: goto -> 69
    //   66: iload #5
    //   68: istore_1
    //   69: aload_0
    //   70: getfield mListDimensionBehaviors : [Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   73: iconst_1
    //   74: aaload
    //   75: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.FIXED : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   78: if_acmpne -> 94
    //   81: aload_0
    //   82: getfield mHeight : I
    //   85: istore_2
    //   86: iload_3
    //   87: iload_2
    //   88: if_icmpge -> 94
    //   91: goto -> 96
    //   94: iload_3
    //   95: istore_2
    //   96: aload_0
    //   97: iload_1
    //   98: putfield mWidth : I
    //   101: aload_0
    //   102: iload_2
    //   103: putfield mHeight : I
    //   106: aload_0
    //   107: getfield mHeight : I
    //   110: istore_1
    //   111: aload_0
    //   112: getfield mMinHeight : I
    //   115: istore_2
    //   116: iload_1
    //   117: iload_2
    //   118: if_icmpge -> 126
    //   121: aload_0
    //   122: iload_2
    //   123: putfield mHeight : I
    //   126: aload_0
    //   127: getfield mWidth : I
    //   130: istore_1
    //   131: aload_0
    //   132: getfield mMinWidth : I
    //   135: istore_2
    //   136: iload_1
    //   137: iload_2
    //   138: if_icmpge -> 146
    //   141: aload_0
    //   142: iload_2
    //   143: putfield mWidth : I
    //   146: return
  }
  
  public void setGoneMargin(ConstraintAnchor.Type paramType, int paramInt) {
    switch (paramType) {
      default:
        return;
      case MATCH_CONSTRAINT:
        this.mBottom.mGoneMargin = paramInt;
      case MATCH_PARENT:
        this.mRight.mGoneMargin = paramInt;
      case WRAP_CONTENT:
        this.mTop.mGoneMargin = paramInt;
      case FIXED:
        break;
    } 
    this.mLeft.mGoneMargin = paramInt;
  }
  
  public void setHeight(int paramInt) {
    this.mHeight = paramInt;
    paramInt = this.mHeight;
    int i = this.mMinHeight;
    if (paramInt < i)
      this.mHeight = i; 
  }
  
  public void setHeightWrapContent(boolean paramBoolean) {
    this.mIsHeightWrapContent = paramBoolean;
  }
  
  public void setHorizontalBiasPercent(float paramFloat) {
    this.mHorizontalBiasPercent = paramFloat;
  }
  
  public void setHorizontalChainStyle(int paramInt) {
    this.mHorizontalChainStyle = paramInt;
  }
  
  public void setHorizontalDimension(int paramInt1, int paramInt2) {
    this.mX = paramInt1;
    this.mWidth = paramInt2 - paramInt1;
    paramInt1 = this.mWidth;
    paramInt2 = this.mMinWidth;
    if (paramInt1 < paramInt2)
      this.mWidth = paramInt2; 
  }
  
  public void setHorizontalDimensionBehaviour(DimensionBehaviour paramDimensionBehaviour) {
    this.mListDimensionBehaviors[0] = paramDimensionBehaviour;
    if (paramDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT)
      setWidth(this.mWrapWidth); 
  }
  
  public void setHorizontalMatchStyle(int paramInt1, int paramInt2, int paramInt3, float paramFloat) {
    this.mMatchConstraintDefaultWidth = paramInt1;
    this.mMatchConstraintMinWidth = paramInt2;
    this.mMatchConstraintMaxWidth = paramInt3;
    this.mMatchConstraintPercentWidth = paramFloat;
    if (paramFloat < 1.0F && this.mMatchConstraintDefaultWidth == 0)
      this.mMatchConstraintDefaultWidth = 2; 
  }
  
  public void setHorizontalWeight(float paramFloat) {
    this.mWeight[0] = paramFloat;
  }
  
  public void setMaxHeight(int paramInt) {
    this.mMaxDimension[1] = paramInt;
  }
  
  public void setMaxWidth(int paramInt) {
    this.mMaxDimension[0] = paramInt;
  }
  
  public void setMinHeight(int paramInt) {
    if (paramInt < 0) {
      this.mMinHeight = 0;
    } else {
      this.mMinHeight = paramInt;
    } 
  }
  
  public void setMinWidth(int paramInt) {
    if (paramInt < 0) {
      this.mMinWidth = 0;
    } else {
      this.mMinWidth = paramInt;
    } 
  }
  
  public void setOffset(int paramInt1, int paramInt2) {
    this.mOffsetX = paramInt1;
    this.mOffsetY = paramInt2;
  }
  
  public void setOrigin(int paramInt1, int paramInt2) {
    this.mX = paramInt1;
    this.mY = paramInt2;
  }
  
  public void setParent(ConstraintWidget paramConstraintWidget) {
    this.mParent = paramConstraintWidget;
  }
  
  public void setType(String paramString) {
    this.mType = paramString;
  }
  
  public void setVerticalBiasPercent(float paramFloat) {
    this.mVerticalBiasPercent = paramFloat;
  }
  
  public void setVerticalChainStyle(int paramInt) {
    this.mVerticalChainStyle = paramInt;
  }
  
  public void setVerticalDimension(int paramInt1, int paramInt2) {
    this.mY = paramInt1;
    this.mHeight = paramInt2 - paramInt1;
    paramInt2 = this.mHeight;
    paramInt1 = this.mMinHeight;
    if (paramInt2 < paramInt1)
      this.mHeight = paramInt1; 
  }
  
  public void setVerticalDimensionBehaviour(DimensionBehaviour paramDimensionBehaviour) {
    this.mListDimensionBehaviors[1] = paramDimensionBehaviour;
    if (paramDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT)
      setHeight(this.mWrapHeight); 
  }
  
  public void setVerticalMatchStyle(int paramInt1, int paramInt2, int paramInt3, float paramFloat) {
    this.mMatchConstraintDefaultHeight = paramInt1;
    this.mMatchConstraintMinHeight = paramInt2;
    this.mMatchConstraintMaxHeight = paramInt3;
    this.mMatchConstraintPercentHeight = paramFloat;
    if (paramFloat < 1.0F && this.mMatchConstraintDefaultHeight == 0)
      this.mMatchConstraintDefaultHeight = 2; 
  }
  
  public void setVerticalWeight(float paramFloat) {
    this.mWeight[1] = paramFloat;
  }
  
  public void setVisibility(int paramInt) {
    this.mVisibility = paramInt;
  }
  
  public void setWidth(int paramInt) {
    this.mWidth = paramInt;
    int i = this.mWidth;
    paramInt = this.mMinWidth;
    if (i < paramInt)
      this.mWidth = paramInt; 
  }
  
  public void setWidthWrapContent(boolean paramBoolean) {
    this.mIsWidthWrapContent = paramBoolean;
  }
  
  public void setWrapHeight(int paramInt) {
    this.mWrapHeight = paramInt;
  }
  
  public void setWrapWidth(int paramInt) {
    this.mWrapWidth = paramInt;
  }
  
  public void setX(int paramInt) {
    this.mX = paramInt;
  }
  
  public void setY(int paramInt) {
    this.mY = paramInt;
  }
  
  public void setupDimensionRatio(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    if (this.mResolvedDimensionRatioSide == -1)
      if (paramBoolean3 && !paramBoolean4) {
        this.mResolvedDimensionRatioSide = 0;
      } else if (!paramBoolean3 && paramBoolean4) {
        this.mResolvedDimensionRatioSide = 1;
        if (this.mDimensionRatioSide == -1)
          this.mResolvedDimensionRatio = 1.0F / this.mResolvedDimensionRatio; 
      }  
    if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
      this.mResolvedDimensionRatioSide = 1;
    } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
      this.mResolvedDimensionRatioSide = 0;
    } 
    if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected()))
      if (this.mTop.isConnected() && this.mBottom.isConnected()) {
        this.mResolvedDimensionRatioSide = 0;
      } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
        this.mResolvedDimensionRatio = 1.0F / this.mResolvedDimensionRatio;
        this.mResolvedDimensionRatioSide = 1;
      }  
    if (this.mResolvedDimensionRatioSide == -1)
      if (paramBoolean1 && !paramBoolean2) {
        this.mResolvedDimensionRatioSide = 0;
      } else if (!paramBoolean1 && paramBoolean2) {
        this.mResolvedDimensionRatio = 1.0F / this.mResolvedDimensionRatio;
        this.mResolvedDimensionRatioSide = 1;
      }  
    if (this.mResolvedDimensionRatioSide == -1)
      if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
        this.mResolvedDimensionRatioSide = 0;
      } else if (this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMinHeight > 0) {
        this.mResolvedDimensionRatio = 1.0F / this.mResolvedDimensionRatio;
        this.mResolvedDimensionRatioSide = 1;
      }  
    if (this.mResolvedDimensionRatioSide == -1 && paramBoolean1 && paramBoolean2) {
      this.mResolvedDimensionRatio = 1.0F / this.mResolvedDimensionRatio;
      this.mResolvedDimensionRatioSide = 1;
    } 
  }
  
  public String toString() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    if (this.mType != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("type: ");
      stringBuilder1.append(this.mType);
      stringBuilder1.append(" ");
      str = stringBuilder1.toString();
    } else {
      str = "";
    } 
    stringBuilder.append(str);
    if (this.mDebugName != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("id: ");
      stringBuilder1.append(this.mDebugName);
      stringBuilder1.append(" ");
      String str1 = stringBuilder1.toString();
    } else {
      str = "";
    } 
    stringBuilder.append(str);
    stringBuilder.append("(");
    stringBuilder.append(this.mX);
    stringBuilder.append(", ");
    stringBuilder.append(this.mY);
    stringBuilder.append(") - (");
    stringBuilder.append(this.mWidth);
    stringBuilder.append(" x ");
    stringBuilder.append(this.mHeight);
    stringBuilder.append(") wrap: (");
    stringBuilder.append(this.mWrapWidth);
    stringBuilder.append(" x ");
    stringBuilder.append(this.mWrapHeight);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public void updateDrawPosition() {
    int i = this.mX;
    int j = this.mY;
    int k = this.mWidth;
    int m = this.mHeight;
    this.mDrawX = i;
    this.mDrawY = j;
    this.mDrawWidth = k + i - i;
    this.mDrawHeight = m + j - j;
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem) {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield mLeft : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   5: invokevirtual getObjectVariableValue : (Ljava/lang/Object;)I
    //   8: istore_2
    //   9: aload_1
    //   10: aload_0
    //   11: getfield mTop : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   14: invokevirtual getObjectVariableValue : (Ljava/lang/Object;)I
    //   17: istore_3
    //   18: aload_1
    //   19: aload_0
    //   20: getfield mRight : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   23: invokevirtual getObjectVariableValue : (Ljava/lang/Object;)I
    //   26: istore #4
    //   28: aload_1
    //   29: aload_0
    //   30: getfield mBottom : Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   33: invokevirtual getObjectVariableValue : (Ljava/lang/Object;)I
    //   36: istore #5
    //   38: iload #4
    //   40: iload_2
    //   41: isub
    //   42: iflt -> 112
    //   45: iload #5
    //   47: iload_3
    //   48: isub
    //   49: iflt -> 112
    //   52: iload_2
    //   53: ldc_w -2147483648
    //   56: if_icmpeq -> 112
    //   59: iload_2
    //   60: ldc 2147483647
    //   62: if_icmpeq -> 112
    //   65: iload_3
    //   66: ldc_w -2147483648
    //   69: if_icmpeq -> 112
    //   72: iload_3
    //   73: ldc 2147483647
    //   75: if_icmpeq -> 112
    //   78: iload #4
    //   80: ldc_w -2147483648
    //   83: if_icmpeq -> 112
    //   86: iload #4
    //   88: ldc 2147483647
    //   90: if_icmpeq -> 112
    //   93: iload #5
    //   95: ldc_w -2147483648
    //   98: if_icmpeq -> 112
    //   101: iload #5
    //   103: istore #6
    //   105: iload #5
    //   107: ldc 2147483647
    //   109: if_icmpne -> 122
    //   112: iconst_0
    //   113: istore #6
    //   115: iconst_0
    //   116: istore_2
    //   117: iconst_0
    //   118: istore_3
    //   119: iconst_0
    //   120: istore #4
    //   122: aload_0
    //   123: iload_2
    //   124: iload_3
    //   125: iload #4
    //   127: iload #6
    //   129: invokevirtual setFrame : (IIII)V
    //   132: return
  }
  
  public void updateResolutionNodes() {
    for (byte b = 0; b < 6; b++)
      this.mListAnchors[b].getResolutionNode().update(); 
  }
  
  public enum ContentAlignment {
    BEGIN, BOTTOM, END, LEFT, MIDDLE, RIGHT, TOP, VERTICAL_MIDDLE;
    
    static {
      BOTTOM = new ContentAlignment("BOTTOM", 5);
      LEFT = new ContentAlignment("LEFT", 6);
      RIGHT = new ContentAlignment("RIGHT", 7);
      $VALUES = new ContentAlignment[] { BEGIN, MIDDLE, END, TOP, VERTICAL_MIDDLE, BOTTOM, LEFT, RIGHT };
    }
  }
  
  public enum DimensionBehaviour {
    FIXED, MATCH_CONSTRAINT, MATCH_PARENT, WRAP_CONTENT;
    
    static {
      $VALUES = new DimensionBehaviour[] { FIXED, WRAP_CONTENT, MATCH_CONSTRAINT, MATCH_PARENT };
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\constraint\solver\widgets\ConstraintWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */