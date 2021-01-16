package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidgetContainer;
import android.support.constraint.solver.widgets.Guideline;
import android.support.constraint.solver.widgets.ResolutionAnchor;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
  static final boolean ALLOWS_EMBEDDED = false;
  
  private static final boolean DEBUG = false;
  
  public static final int DESIGN_INFO_ID = 0;
  
  private static final String TAG = "ConstraintLayout";
  
  private static final boolean USE_CONSTRAINTS_HELPER = true;
  
  public static final String VERSION = "ConstraintLayout-1.1.2";
  
  SparseArray<View> mChildrenByIds = new SparseArray();
  
  private ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList<ConstraintHelper>(4);
  
  private ConstraintSet mConstraintSet = null;
  
  private int mConstraintSetId = -1;
  
  private HashMap<String, Integer> mDesignIds = new HashMap<String, Integer>();
  
  private boolean mDirtyHierarchy = true;
  
  private int mLastMeasureHeight = -1;
  
  int mLastMeasureHeightMode = 0;
  
  int mLastMeasureHeightSize = -1;
  
  private int mLastMeasureWidth = -1;
  
  int mLastMeasureWidthMode = 0;
  
  int mLastMeasureWidthSize = -1;
  
  ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
  
  private int mMaxHeight = Integer.MAX_VALUE;
  
  private int mMaxWidth = Integer.MAX_VALUE;
  
  private Metrics mMetrics;
  
  private int mMinHeight = 0;
  
  private int mMinWidth = 0;
  
  private int mOptimizationLevel = 3;
  
  private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<ConstraintWidget>(100);
  
  public ConstraintLayout(Context paramContext) {
    super(paramContext);
    init((AttributeSet)null);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private final ConstraintWidget getTargetWidget(int paramInt) {
    ConstraintWidget constraintWidget;
    if (paramInt == 0)
      return (ConstraintWidget)this.mLayoutWidget; 
    View view = (View)this.mChildrenByIds.get(paramInt);
    if (view == this)
      return (ConstraintWidget)this.mLayoutWidget; 
    if (view == null) {
      view = null;
    } else {
      constraintWidget = ((LayoutParams)view.getLayoutParams()).widget;
    } 
    return constraintWidget;
  }
  
  private void init(AttributeSet paramAttributeSet) {
    this.mLayoutWidget.setCompanionWidget(this);
    this.mChildrenByIds.put(getId(), this);
    this.mConstraintSet = null;
    if (paramAttributeSet != null) {
      TypedArray typedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i = typedArray.getIndexCount();
      for (byte b = 0; b < i; b++) {
        int j = typedArray.getIndex(b);
        if (j == R.styleable.ConstraintLayout_Layout_android_minWidth) {
          this.mMinWidth = typedArray.getDimensionPixelOffset(j, this.mMinWidth);
        } else if (j == R.styleable.ConstraintLayout_Layout_android_minHeight) {
          this.mMinHeight = typedArray.getDimensionPixelOffset(j, this.mMinHeight);
        } else if (j == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
          this.mMaxWidth = typedArray.getDimensionPixelOffset(j, this.mMaxWidth);
        } else if (j == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
          this.mMaxHeight = typedArray.getDimensionPixelOffset(j, this.mMaxHeight);
        } else if (j == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
          this.mOptimizationLevel = typedArray.getInt(j, this.mOptimizationLevel);
        } else if (j == R.styleable.ConstraintLayout_Layout_constraintSet) {
          j = typedArray.getResourceId(j, 0);
          try {
            ConstraintSet constraintSet = new ConstraintSet();
            this();
            this.mConstraintSet = constraintSet;
            this.mConstraintSet.load(getContext(), j);
          } catch (android.content.res.Resources.NotFoundException notFoundException) {
            this.mConstraintSet = null;
          } 
          this.mConstraintSetId = j;
        } 
      } 
      typedArray.recycle();
    } 
    this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
  }
  
  private void internalMeasureChildren(int paramInt1, int paramInt2) {
    int i = getPaddingTop() + getPaddingBottom();
    int j = getPaddingLeft() + getPaddingRight();
    int k = getChildCount();
    for (byte b = 0; b < k; b++) {
      View view = getChildAt(b);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        ConstraintWidget constraintWidget = layoutParams.widget;
        if (!layoutParams.isGuideline && !layoutParams.isHelper) {
          int i1;
          int i2;
          int i3;
          boolean bool;
          constraintWidget.setVisibility(view.getVisibility());
          int m = layoutParams.width;
          int n = layoutParams.height;
          if (layoutParams.horizontalDimensionFixed || layoutParams.verticalDimensionFixed || (!layoutParams.horizontalDimensionFixed && layoutParams.matchConstraintDefaultWidth == 1) || layoutParams.width == -1 || (!layoutParams.verticalDimensionFixed && (layoutParams.matchConstraintDefaultHeight == 1 || layoutParams.height == -1))) {
            i1 = 1;
          } else {
            i1 = 0;
          } 
          if (i1) {
            boolean bool1;
            if (m == 0) {
              i2 = getChildMeasureSpec(paramInt1, j, -2);
              i1 = 1;
            } else if (m == -1) {
              i2 = getChildMeasureSpec(paramInt1, j, -1);
              i1 = 0;
            } else {
              if (m == -2) {
                i1 = 1;
              } else {
                i1 = 0;
              } 
              i2 = getChildMeasureSpec(paramInt1, j, m);
            } 
            if (n == 0) {
              i3 = getChildMeasureSpec(paramInt2, i, -2);
              bool = true;
            } else if (n == -1) {
              i3 = getChildMeasureSpec(paramInt2, i, -1);
              bool = false;
            } else {
              if (n == -2) {
                bool = true;
              } else {
                bool = false;
              } 
              i3 = getChildMeasureSpec(paramInt2, i, n);
            } 
            view.measure(i2, i3);
            Metrics metrics = this.mMetrics;
            if (metrics != null)
              metrics.measures++; 
            if (m == -2) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            constraintWidget.setWidthWrapContent(bool1);
            if (n == -2) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            constraintWidget.setHeightWrapContent(bool1);
            i3 = view.getMeasuredWidth();
            i2 = view.getMeasuredHeight();
          } else {
            i1 = 0;
            bool = false;
            i2 = n;
            i3 = m;
          } 
          constraintWidget.setWidth(i3);
          constraintWidget.setHeight(i2);
          if (i1)
            constraintWidget.setWrapWidth(i3); 
          if (bool)
            constraintWidget.setWrapHeight(i2); 
          if (layoutParams.needsBaseline) {
            i1 = view.getBaseline();
            if (i1 != -1)
              constraintWidget.setBaselineDistance(i1); 
          } 
        } 
      } 
    } 
  }
  
  private void internalMeasureDimensions(int paramInt1, int paramInt2) {
    ConstraintLayout constraintLayout = this;
    int i = getPaddingTop() + getPaddingBottom();
    int j = getPaddingLeft() + getPaddingRight();
    int k = getChildCount();
    int m = 0;
    while (true) {
      long l = 1L;
      if (m < k) {
        View view = constraintLayout.getChildAt(m);
        if (view.getVisibility() != 8) {
          LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
          ConstraintWidget constraintWidget = layoutParams.widget;
          if (!layoutParams.isGuideline && !layoutParams.isHelper) {
            constraintWidget.setVisibility(view.getVisibility());
            int n = layoutParams.width;
            int i1 = layoutParams.height;
            if (n == 0 || i1 == 0) {
              constraintWidget.getResolutionWidth().invalidate();
              constraintWidget.getResolutionHeight().invalidate();
            } else {
              int i2;
              boolean bool1;
              boolean bool2;
              if (n == -2) {
                i2 = 1;
              } else {
                i2 = 0;
              } 
              int i3 = getChildMeasureSpec(paramInt1, j, n);
              if (i1 == -2) {
                bool1 = true;
              } else {
                bool1 = false;
              } 
              view.measure(i3, getChildMeasureSpec(paramInt2, i, i1));
              Metrics metrics = constraintLayout.mMetrics;
              if (metrics != null)
                metrics.measures++; 
              if (n == -2) {
                bool2 = true;
              } else {
                bool2 = false;
              } 
              constraintWidget.setWidthWrapContent(bool2);
              if (i1 == -2) {
                bool2 = true;
              } else {
                bool2 = false;
              } 
              constraintWidget.setHeightWrapContent(bool2);
              n = view.getMeasuredWidth();
              i1 = view.getMeasuredHeight();
              constraintWidget.setWidth(n);
              constraintWidget.setHeight(i1);
              if (i2)
                constraintWidget.setWrapWidth(n); 
              if (bool1)
                constraintWidget.setWrapHeight(i1); 
              if (layoutParams.needsBaseline) {
                i2 = view.getBaseline();
                if (i2 != -1)
                  constraintWidget.setBaselineDistance(i2); 
              } 
              if (layoutParams.horizontalDimensionFixed && layoutParams.verticalDimensionFixed) {
                constraintWidget.getResolutionWidth().resolve(n);
                constraintWidget.getResolutionHeight().resolve(i1);
              } 
            } 
          } 
        } 
        m++;
        continue;
      } 
      constraintLayout.mLayoutWidget.solveGraph();
      byte b = 0;
      while (b < k) {
        ConstraintLayout constraintLayout1;
        View view = constraintLayout.getChildAt(b);
        if (view.getVisibility() == 8) {
          constraintLayout1 = constraintLayout;
        } else {
          LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
          ConstraintWidget constraintWidget = layoutParams.widget;
          if (!layoutParams.isGuideline) {
            if (layoutParams.isHelper) {
              constraintLayout1 = constraintLayout;
            } else {
              constraintWidget.setVisibility(view.getVisibility());
              int n = ((LayoutParams)constraintLayout1).width;
              int i1 = ((LayoutParams)constraintLayout1).height;
              if (n != 0 && i1 != 0) {
                constraintLayout1 = constraintLayout;
              } else {
                int i2;
                boolean bool;
                ResolutionAnchor resolutionAnchor1 = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
                ResolutionAnchor resolutionAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getResolutionNode();
                if (constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).getTarget() != null && constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget() != null) {
                  bool = true;
                } else {
                  bool = false;
                } 
                ResolutionAnchor resolutionAnchor3 = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
                ResolutionAnchor resolutionAnchor4 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getResolutionNode();
                if (constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).getTarget() != null && constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget() != null) {
                  i2 = 1;
                } else {
                  i2 = 0;
                } 
                if (n == 0 && i1 == 0 && bool && i2) {
                  l = 1L;
                  constraintLayout1 = constraintLayout;
                } else {
                  int i3;
                  boolean bool1;
                  int i5;
                  if (constraintLayout.mLayoutWidget.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    i3 = 1;
                  } else {
                    i3 = 0;
                  } 
                  if (constraintLayout.mLayoutWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    m = 1;
                  } else {
                    m = 0;
                  } 
                  if (!i3)
                    constraintWidget.getResolutionWidth().invalidate(); 
                  if (m == 0)
                    constraintWidget.getResolutionHeight().invalidate(); 
                  if (n == 0) {
                    if (i3 && constraintWidget.isSpreadWidth() && bool && resolutionAnchor1.isResolved() && resolutionAnchor2.isResolved()) {
                      n = (int)(resolutionAnchor2.getResolvedValue() - resolutionAnchor1.getResolvedValue());
                      constraintWidget.getResolutionWidth().resolve(n);
                      i4 = getChildMeasureSpec(paramInt1, j, n);
                      bool = false;
                      i5 = i3;
                    } else {
                      i4 = getChildMeasureSpec(paramInt1, j, -2);
                      bool = true;
                      i5 = 0;
                    } 
                  } else if (n == -1) {
                    i4 = getChildMeasureSpec(paramInt1, j, -1);
                    bool = false;
                    i5 = i3;
                  } else {
                    if (n == -2) {
                      bool = true;
                    } else {
                      bool = false;
                    } 
                    i4 = getChildMeasureSpec(paramInt1, j, n);
                    i5 = i3;
                  } 
                  if (i1 == 0) {
                    if (m != 0 && constraintWidget.isSpreadHeight() && i2 && resolutionAnchor3.isResolved() && resolutionAnchor4.isResolved()) {
                      i1 = (int)(resolutionAnchor4.getResolvedValue() - resolutionAnchor3.getResolvedValue());
                      constraintWidget.getResolutionHeight().resolve(i1);
                      i3 = getChildMeasureSpec(paramInt2, i, i1);
                      i2 = m;
                      m = i3;
                      i3 = 0;
                    } else {
                      m = getChildMeasureSpec(paramInt2, i, -2);
                      i3 = 1;
                      i2 = 0;
                    } 
                  } else if (i1 == -1) {
                    i3 = getChildMeasureSpec(paramInt2, i, -1);
                    i2 = m;
                    m = i3;
                    i3 = 0;
                  } else {
                    if (i1 == -2) {
                      i3 = 1;
                    } else {
                      i3 = 0;
                    } 
                    int i6 = getChildMeasureSpec(paramInt2, i, i1);
                    i2 = m;
                    m = i6;
                  } 
                  view.measure(i4, m);
                  constraintLayout = this;
                  Metrics metrics = constraintLayout.mMetrics;
                  if (metrics != null)
                    metrics.measures++; 
                  long l1 = 1L;
                  if (n == -2) {
                    bool1 = true;
                  } else {
                    bool1 = false;
                  } 
                  constraintWidget.setWidthWrapContent(bool1);
                  if (i1 == -2) {
                    bool1 = true;
                  } else {
                    bool1 = false;
                  } 
                  constraintWidget.setHeightWrapContent(bool1);
                  int i4 = view.getMeasuredWidth();
                  m = view.getMeasuredHeight();
                  constraintWidget.setWidth(i4);
                  constraintWidget.setHeight(m);
                  if (bool)
                    constraintWidget.setWrapWidth(i4); 
                  if (i3 != 0)
                    constraintWidget.setWrapHeight(m); 
                  if (i5 != 0) {
                    constraintWidget.getResolutionWidth().resolve(i4);
                  } else {
                    constraintWidget.getResolutionWidth().remove();
                  } 
                  if (i2 != 0) {
                    constraintWidget.getResolutionHeight().resolve(m);
                  } else {
                    constraintWidget.getResolutionHeight().remove();
                  } 
                  if (((LayoutParams)constraintLayout1).needsBaseline) {
                    m = view.getBaseline();
                    constraintLayout1 = constraintLayout;
                    l = l1;
                    if (m != -1) {
                      constraintWidget.setBaselineDistance(m);
                      constraintLayout1 = constraintLayout;
                      l = l1;
                    } 
                  } else {
                    constraintLayout1 = constraintLayout;
                    l = l1;
                  } 
                } 
              } 
            } 
          } else {
            constraintLayout1 = constraintLayout;
          } 
        } 
        b++;
        constraintLayout = constraintLayout1;
      } 
      return;
    } 
  }
  
  private void setChildrenConstraints() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual isInEditMode : ()Z
    //   4: istore_1
    //   5: aload_0
    //   6: invokevirtual getChildCount : ()I
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_3
    //   12: iload_1
    //   13: ifeq -> 112
    //   16: iconst_0
    //   17: istore #4
    //   19: iload #4
    //   21: iload_2
    //   22: if_icmpge -> 112
    //   25: aload_0
    //   26: iload #4
    //   28: invokevirtual getChildAt : (I)Landroid/view/View;
    //   31: astore #5
    //   33: aload_0
    //   34: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   37: aload #5
    //   39: invokevirtual getId : ()I
    //   42: invokevirtual getResourceName : (I)Ljava/lang/String;
    //   45: astore #6
    //   47: aload_0
    //   48: iconst_0
    //   49: aload #6
    //   51: aload #5
    //   53: invokevirtual getId : ()I
    //   56: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   59: invokevirtual setDesignInformation : (ILjava/lang/Object;Ljava/lang/Object;)V
    //   62: aload #6
    //   64: bipush #47
    //   66: invokevirtual indexOf : (I)I
    //   69: istore #7
    //   71: aload #6
    //   73: astore #8
    //   75: iload #7
    //   77: iconst_m1
    //   78: if_icmpeq -> 92
    //   81: aload #6
    //   83: iload #7
    //   85: iconst_1
    //   86: iadd
    //   87: invokevirtual substring : (I)Ljava/lang/String;
    //   90: astore #8
    //   92: aload_0
    //   93: aload #5
    //   95: invokevirtual getId : ()I
    //   98: invokespecial getTargetWidget : (I)Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   101: aload #8
    //   103: invokevirtual setDebugName : (Ljava/lang/String;)V
    //   106: iinc #4, 1
    //   109: goto -> 19
    //   112: iconst_0
    //   113: istore #4
    //   115: iload #4
    //   117: iload_2
    //   118: if_icmpge -> 152
    //   121: aload_0
    //   122: aload_0
    //   123: iload #4
    //   125: invokevirtual getChildAt : (I)Landroid/view/View;
    //   128: invokevirtual getViewWidget : (Landroid/view/View;)Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   131: astore #8
    //   133: aload #8
    //   135: ifnonnull -> 141
    //   138: goto -> 146
    //   141: aload #8
    //   143: invokevirtual reset : ()V
    //   146: iinc #4, 1
    //   149: goto -> 115
    //   152: aload_0
    //   153: getfield mConstraintSetId : I
    //   156: iconst_m1
    //   157: if_icmpeq -> 215
    //   160: iconst_0
    //   161: istore #4
    //   163: iload #4
    //   165: iload_2
    //   166: if_icmpge -> 215
    //   169: aload_0
    //   170: iload #4
    //   172: invokevirtual getChildAt : (I)Landroid/view/View;
    //   175: astore #8
    //   177: aload #8
    //   179: invokevirtual getId : ()I
    //   182: aload_0
    //   183: getfield mConstraintSetId : I
    //   186: if_icmpne -> 209
    //   189: aload #8
    //   191: instanceof android/support/constraint/Constraints
    //   194: ifeq -> 209
    //   197: aload_0
    //   198: aload #8
    //   200: checkcast android/support/constraint/Constraints
    //   203: invokevirtual getConstraintSet : ()Landroid/support/constraint/ConstraintSet;
    //   206: putfield mConstraintSet : Landroid/support/constraint/ConstraintSet;
    //   209: iinc #4, 1
    //   212: goto -> 163
    //   215: aload_0
    //   216: getfield mConstraintSet : Landroid/support/constraint/ConstraintSet;
    //   219: astore #8
    //   221: aload #8
    //   223: ifnull -> 232
    //   226: aload #8
    //   228: aload_0
    //   229: invokevirtual applyToInternal : (Landroid/support/constraint/ConstraintLayout;)V
    //   232: aload_0
    //   233: getfield mLayoutWidget : Landroid/support/constraint/solver/widgets/ConstraintWidgetContainer;
    //   236: invokevirtual removeAllChildren : ()V
    //   239: aload_0
    //   240: getfield mConstraintHelpers : Ljava/util/ArrayList;
    //   243: invokevirtual size : ()I
    //   246: istore #7
    //   248: iload #7
    //   250: ifle -> 285
    //   253: iconst_0
    //   254: istore #4
    //   256: iload #4
    //   258: iload #7
    //   260: if_icmpge -> 285
    //   263: aload_0
    //   264: getfield mConstraintHelpers : Ljava/util/ArrayList;
    //   267: iload #4
    //   269: invokevirtual get : (I)Ljava/lang/Object;
    //   272: checkcast android/support/constraint/ConstraintHelper
    //   275: aload_0
    //   276: invokevirtual updatePreLayout : (Landroid/support/constraint/ConstraintLayout;)V
    //   279: iinc #4, 1
    //   282: goto -> 256
    //   285: iconst_0
    //   286: istore #4
    //   288: iload #4
    //   290: iload_2
    //   291: if_icmpge -> 325
    //   294: aload_0
    //   295: iload #4
    //   297: invokevirtual getChildAt : (I)Landroid/view/View;
    //   300: astore #8
    //   302: aload #8
    //   304: instanceof android/support/constraint/Placeholder
    //   307: ifeq -> 319
    //   310: aload #8
    //   312: checkcast android/support/constraint/Placeholder
    //   315: aload_0
    //   316: invokevirtual updatePreLayout : (Landroid/support/constraint/ConstraintLayout;)V
    //   319: iinc #4, 1
    //   322: goto -> 288
    //   325: iconst_0
    //   326: istore #9
    //   328: iload_3
    //   329: istore #4
    //   331: iload #9
    //   333: iload_2
    //   334: if_icmpge -> 2098
    //   337: aload_0
    //   338: iload #9
    //   340: invokevirtual getChildAt : (I)Landroid/view/View;
    //   343: astore #5
    //   345: aload_0
    //   346: aload #5
    //   348: invokevirtual getViewWidget : (Landroid/view/View;)Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   351: astore #6
    //   353: aload #6
    //   355: ifnonnull -> 365
    //   358: iload #4
    //   360: istore #7
    //   362: goto -> 2088
    //   365: aload #5
    //   367: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   370: checkcast android/support/constraint/ConstraintLayout$LayoutParams
    //   373: astore #8
    //   375: aload #8
    //   377: invokevirtual validate : ()V
    //   380: aload #8
    //   382: getfield helped : Z
    //   385: ifeq -> 398
    //   388: aload #8
    //   390: iload #4
    //   392: putfield helped : Z
    //   395: goto -> 468
    //   398: iload_1
    //   399: ifeq -> 468
    //   402: aload_0
    //   403: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   406: aload #5
    //   408: invokevirtual getId : ()I
    //   411: invokevirtual getResourceName : (I)Ljava/lang/String;
    //   414: astore #10
    //   416: aload_0
    //   417: iload #4
    //   419: aload #10
    //   421: aload #5
    //   423: invokevirtual getId : ()I
    //   426: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   429: invokevirtual setDesignInformation : (ILjava/lang/Object;Ljava/lang/Object;)V
    //   432: aload #10
    //   434: aload #10
    //   436: ldc_w 'id/'
    //   439: invokevirtual indexOf : (Ljava/lang/String;)I
    //   442: iconst_3
    //   443: iadd
    //   444: invokevirtual substring : (I)Ljava/lang/String;
    //   447: astore #10
    //   449: aload_0
    //   450: aload #5
    //   452: invokevirtual getId : ()I
    //   455: invokespecial getTargetWidget : (I)Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   458: aload #10
    //   460: invokevirtual setDebugName : (Ljava/lang/String;)V
    //   463: goto -> 468
    //   466: astore #10
    //   468: aload #6
    //   470: aload #5
    //   472: invokevirtual getVisibility : ()I
    //   475: invokevirtual setVisibility : (I)V
    //   478: aload #8
    //   480: getfield isInPlaceholder : Z
    //   483: ifeq -> 493
    //   486: aload #6
    //   488: bipush #8
    //   490: invokevirtual setVisibility : (I)V
    //   493: aload #6
    //   495: aload #5
    //   497: invokevirtual setCompanionWidget : (Ljava/lang/Object;)V
    //   500: aload_0
    //   501: getfield mLayoutWidget : Landroid/support/constraint/solver/widgets/ConstraintWidgetContainer;
    //   504: aload #6
    //   506: invokevirtual add : (Landroid/support/constraint/solver/widgets/ConstraintWidget;)V
    //   509: aload #8
    //   511: getfield verticalDimensionFixed : Z
    //   514: ifeq -> 525
    //   517: aload #8
    //   519: getfield horizontalDimensionFixed : Z
    //   522: ifne -> 535
    //   525: aload_0
    //   526: getfield mVariableDimensionsWidgets : Ljava/util/ArrayList;
    //   529: aload #6
    //   531: invokevirtual add : (Ljava/lang/Object;)Z
    //   534: pop
    //   535: aload #8
    //   537: getfield isGuideline : Z
    //   540: ifeq -> 663
    //   543: aload #6
    //   545: checkcast android/support/constraint/solver/widgets/Guideline
    //   548: astore #6
    //   550: aload #8
    //   552: getfield resolvedGuideBegin : I
    //   555: istore #7
    //   557: aload #8
    //   559: getfield resolvedGuideEnd : I
    //   562: istore_3
    //   563: aload #8
    //   565: getfield resolvedGuidePercent : F
    //   568: fstore #11
    //   570: getstatic android/os/Build$VERSION.SDK_INT : I
    //   573: bipush #17
    //   575: if_icmpge -> 598
    //   578: aload #8
    //   580: getfield guideBegin : I
    //   583: istore #7
    //   585: aload #8
    //   587: getfield guideEnd : I
    //   590: istore_3
    //   591: aload #8
    //   593: getfield guidePercent : F
    //   596: fstore #11
    //   598: fload #11
    //   600: ldc_w -1.0
    //   603: fcmpl
    //   604: ifeq -> 621
    //   607: aload #6
    //   609: fload #11
    //   611: invokevirtual setGuidePercent : (F)V
    //   614: iload #4
    //   616: istore #7
    //   618: goto -> 2088
    //   621: iload #7
    //   623: iconst_m1
    //   624: if_icmpeq -> 641
    //   627: aload #6
    //   629: iload #7
    //   631: invokevirtual setGuideBegin : (I)V
    //   634: iload #4
    //   636: istore #7
    //   638: goto -> 2088
    //   641: iload #4
    //   643: istore #7
    //   645: iload_3
    //   646: iconst_m1
    //   647: if_icmpeq -> 2088
    //   650: aload #6
    //   652: iload_3
    //   653: invokevirtual setGuideEnd : (I)V
    //   656: iload #4
    //   658: istore #7
    //   660: goto -> 2088
    //   663: aload #8
    //   665: getfield leftToLeft : I
    //   668: iconst_m1
    //   669: if_icmpne -> 829
    //   672: aload #8
    //   674: getfield leftToRight : I
    //   677: iconst_m1
    //   678: if_icmpne -> 829
    //   681: aload #8
    //   683: getfield rightToLeft : I
    //   686: iconst_m1
    //   687: if_icmpne -> 829
    //   690: aload #8
    //   692: getfield rightToRight : I
    //   695: iconst_m1
    //   696: if_icmpne -> 829
    //   699: aload #8
    //   701: getfield startToStart : I
    //   704: iconst_m1
    //   705: if_icmpne -> 829
    //   708: aload #8
    //   710: getfield startToEnd : I
    //   713: iconst_m1
    //   714: if_icmpne -> 829
    //   717: aload #8
    //   719: getfield endToStart : I
    //   722: iconst_m1
    //   723: if_icmpne -> 829
    //   726: aload #8
    //   728: getfield endToEnd : I
    //   731: iconst_m1
    //   732: if_icmpne -> 829
    //   735: aload #8
    //   737: getfield topToTop : I
    //   740: iconst_m1
    //   741: if_icmpne -> 829
    //   744: aload #8
    //   746: getfield topToBottom : I
    //   749: iconst_m1
    //   750: if_icmpne -> 829
    //   753: aload #8
    //   755: getfield bottomToTop : I
    //   758: iconst_m1
    //   759: if_icmpne -> 829
    //   762: aload #8
    //   764: getfield bottomToBottom : I
    //   767: iconst_m1
    //   768: if_icmpne -> 829
    //   771: aload #8
    //   773: getfield baselineToBaseline : I
    //   776: iconst_m1
    //   777: if_icmpne -> 829
    //   780: aload #8
    //   782: getfield editorAbsoluteX : I
    //   785: iconst_m1
    //   786: if_icmpne -> 829
    //   789: aload #8
    //   791: getfield editorAbsoluteY : I
    //   794: iconst_m1
    //   795: if_icmpne -> 829
    //   798: aload #8
    //   800: getfield circleConstraint : I
    //   803: iconst_m1
    //   804: if_icmpne -> 829
    //   807: aload #8
    //   809: getfield width : I
    //   812: iconst_m1
    //   813: if_icmpeq -> 829
    //   816: iload #4
    //   818: istore #7
    //   820: aload #8
    //   822: getfield height : I
    //   825: iconst_m1
    //   826: if_icmpne -> 2088
    //   829: aload #8
    //   831: getfield resolvedLeftToLeft : I
    //   834: istore #12
    //   836: aload #8
    //   838: getfield resolvedLeftToRight : I
    //   841: istore #13
    //   843: aload #8
    //   845: getfield resolvedRightToLeft : I
    //   848: istore #7
    //   850: aload #8
    //   852: getfield resolvedRightToRight : I
    //   855: istore #4
    //   857: aload #8
    //   859: getfield resolveGoneLeftMargin : I
    //   862: istore_3
    //   863: aload #8
    //   865: getfield resolveGoneRightMargin : I
    //   868: istore #14
    //   870: aload #8
    //   872: getfield resolvedHorizontalBias : F
    //   875: fstore #11
    //   877: getstatic android/os/Build$VERSION.SDK_INT : I
    //   880: bipush #17
    //   882: if_icmpge -> 1144
    //   885: aload #8
    //   887: getfield leftToLeft : I
    //   890: istore_3
    //   891: aload #8
    //   893: getfield leftToRight : I
    //   896: istore #4
    //   898: aload #8
    //   900: getfield rightToLeft : I
    //   903: istore #13
    //   905: aload #8
    //   907: getfield rightToRight : I
    //   910: istore #12
    //   912: aload #8
    //   914: getfield goneLeftMargin : I
    //   917: istore #14
    //   919: aload #8
    //   921: getfield goneRightMargin : I
    //   924: istore #7
    //   926: aload #8
    //   928: getfield horizontalBias : F
    //   931: fstore #11
    //   933: iload_3
    //   934: iconst_m1
    //   935: if_icmpne -> 995
    //   938: iload #4
    //   940: iconst_m1
    //   941: if_icmpne -> 995
    //   944: aload #8
    //   946: getfield startToStart : I
    //   949: iconst_m1
    //   950: if_icmpeq -> 970
    //   953: aload #8
    //   955: getfield startToStart : I
    //   958: istore #15
    //   960: iload #4
    //   962: istore_3
    //   963: iload #15
    //   965: istore #4
    //   967: goto -> 1005
    //   970: aload #8
    //   972: getfield startToEnd : I
    //   975: iconst_m1
    //   976: if_icmpeq -> 995
    //   979: aload #8
    //   981: getfield startToEnd : I
    //   984: istore #15
    //   986: iload_3
    //   987: istore #4
    //   989: iload #15
    //   991: istore_3
    //   992: goto -> 1005
    //   995: iload #4
    //   997: istore #15
    //   999: iload_3
    //   1000: istore #4
    //   1002: iload #15
    //   1004: istore_3
    //   1005: iload #13
    //   1007: iconst_m1
    //   1008: if_icmpne -> 1111
    //   1011: iload #12
    //   1013: iconst_m1
    //   1014: if_icmpne -> 1111
    //   1017: aload #8
    //   1019: getfield endToStart : I
    //   1022: iconst_m1
    //   1023: if_icmpeq -> 1066
    //   1026: aload #8
    //   1028: getfield endToStart : I
    //   1031: istore #13
    //   1033: iload #14
    //   1035: istore #15
    //   1037: iload #7
    //   1039: istore #14
    //   1041: iload #12
    //   1043: istore #16
    //   1045: iload #13
    //   1047: istore #7
    //   1049: iload_3
    //   1050: istore #13
    //   1052: iload #4
    //   1054: istore #12
    //   1056: iload #16
    //   1058: istore #4
    //   1060: iload #15
    //   1062: istore_3
    //   1063: goto -> 1144
    //   1066: aload #8
    //   1068: getfield endToEnd : I
    //   1071: iconst_m1
    //   1072: if_icmpeq -> 1111
    //   1075: aload #8
    //   1077: getfield endToEnd : I
    //   1080: istore #16
    //   1082: iload #14
    //   1084: istore #15
    //   1086: iload #7
    //   1088: istore #14
    //   1090: iload #13
    //   1092: istore #7
    //   1094: iload_3
    //   1095: istore #13
    //   1097: iload #4
    //   1099: istore #12
    //   1101: iload #16
    //   1103: istore #4
    //   1105: iload #15
    //   1107: istore_3
    //   1108: goto -> 1144
    //   1111: iload #14
    //   1113: istore #15
    //   1115: iload #7
    //   1117: istore #14
    //   1119: iload #12
    //   1121: istore #16
    //   1123: iload #13
    //   1125: istore #7
    //   1127: iload_3
    //   1128: istore #13
    //   1130: iload #4
    //   1132: istore #12
    //   1134: iload #16
    //   1136: istore #4
    //   1138: iload #15
    //   1140: istore_3
    //   1141: goto -> 1144
    //   1144: aload #8
    //   1146: getfield circleConstraint : I
    //   1149: iconst_m1
    //   1150: if_icmpeq -> 1189
    //   1153: aload_0
    //   1154: aload #8
    //   1156: getfield circleConstraint : I
    //   1159: invokespecial getTargetWidget : (I)Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1162: astore #5
    //   1164: aload #5
    //   1166: ifnull -> 1750
    //   1169: aload #6
    //   1171: aload #5
    //   1173: aload #8
    //   1175: getfield circleAngle : F
    //   1178: aload #8
    //   1180: getfield circleRadius : I
    //   1183: invokevirtual connectCircularConstraint : (Landroid/support/constraint/solver/widgets/ConstraintWidget;FI)V
    //   1186: goto -> 1750
    //   1189: iload #12
    //   1191: iconst_m1
    //   1192: if_icmpeq -> 1237
    //   1195: aload_0
    //   1196: iload #12
    //   1198: invokespecial getTargetWidget : (I)Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1201: astore #5
    //   1203: aload #5
    //   1205: ifnull -> 1230
    //   1208: aload #6
    //   1210: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1213: aload #5
    //   1215: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1218: aload #8
    //   1220: getfield leftMargin : I
    //   1223: iload_3
    //   1224: invokevirtual immediateConnect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;II)V
    //   1227: goto -> 1230
    //   1230: iload #4
    //   1232: istore #12
    //   1234: goto -> 1287
    //   1237: iload #4
    //   1239: istore #12
    //   1241: iload #13
    //   1243: iconst_m1
    //   1244: if_icmpeq -> 1287
    //   1247: aload_0
    //   1248: iload #13
    //   1250: invokespecial getTargetWidget : (I)Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1253: astore #5
    //   1255: iload #4
    //   1257: istore #12
    //   1259: aload #5
    //   1261: ifnull -> 1287
    //   1264: aload #6
    //   1266: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1269: aload #5
    //   1271: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1274: aload #8
    //   1276: getfield leftMargin : I
    //   1279: iload_3
    //   1280: invokevirtual immediateConnect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;II)V
    //   1283: iload #4
    //   1285: istore #12
    //   1287: iload #7
    //   1289: iconst_m1
    //   1290: if_icmpeq -> 1329
    //   1293: aload_0
    //   1294: iload #7
    //   1296: invokespecial getTargetWidget : (I)Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1299: astore #5
    //   1301: aload #5
    //   1303: ifnull -> 1368
    //   1306: aload #6
    //   1308: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1311: aload #5
    //   1313: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1316: aload #8
    //   1318: getfield rightMargin : I
    //   1321: iload #14
    //   1323: invokevirtual immediateConnect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;II)V
    //   1326: goto -> 1368
    //   1329: iload #12
    //   1331: iconst_m1
    //   1332: if_icmpeq -> 1368
    //   1335: aload_0
    //   1336: iload #12
    //   1338: invokespecial getTargetWidget : (I)Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1341: astore #5
    //   1343: aload #5
    //   1345: ifnull -> 1368
    //   1348: aload #6
    //   1350: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1353: aload #5
    //   1355: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1358: aload #8
    //   1360: getfield rightMargin : I
    //   1363: iload #14
    //   1365: invokevirtual immediateConnect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;II)V
    //   1368: aload #8
    //   1370: getfield topToTop : I
    //   1373: iconst_m1
    //   1374: if_icmpeq -> 1419
    //   1377: aload_0
    //   1378: aload #8
    //   1380: getfield topToTop : I
    //   1383: invokespecial getTargetWidget : (I)Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1386: astore #5
    //   1388: aload #5
    //   1390: ifnull -> 1467
    //   1393: aload #6
    //   1395: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1398: aload #5
    //   1400: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1403: aload #8
    //   1405: getfield topMargin : I
    //   1408: aload #8
    //   1410: getfield goneTopMargin : I
    //   1413: invokevirtual immediateConnect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;II)V
    //   1416: goto -> 1467
    //   1419: aload #8
    //   1421: getfield topToBottom : I
    //   1424: iconst_m1
    //   1425: if_icmpeq -> 1467
    //   1428: aload_0
    //   1429: aload #8
    //   1431: getfield topToBottom : I
    //   1434: invokespecial getTargetWidget : (I)Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1437: astore #5
    //   1439: aload #5
    //   1441: ifnull -> 1467
    //   1444: aload #6
    //   1446: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1449: aload #5
    //   1451: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1454: aload #8
    //   1456: getfield topMargin : I
    //   1459: aload #8
    //   1461: getfield goneTopMargin : I
    //   1464: invokevirtual immediateConnect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;II)V
    //   1467: aload #8
    //   1469: getfield bottomToTop : I
    //   1472: iconst_m1
    //   1473: if_icmpeq -> 1518
    //   1476: aload_0
    //   1477: aload #8
    //   1479: getfield bottomToTop : I
    //   1482: invokespecial getTargetWidget : (I)Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1485: astore #5
    //   1487: aload #5
    //   1489: ifnull -> 1566
    //   1492: aload #6
    //   1494: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1497: aload #5
    //   1499: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1502: aload #8
    //   1504: getfield bottomMargin : I
    //   1507: aload #8
    //   1509: getfield goneBottomMargin : I
    //   1512: invokevirtual immediateConnect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;II)V
    //   1515: goto -> 1566
    //   1518: aload #8
    //   1520: getfield bottomToBottom : I
    //   1523: iconst_m1
    //   1524: if_icmpeq -> 1566
    //   1527: aload_0
    //   1528: aload #8
    //   1530: getfield bottomToBottom : I
    //   1533: invokespecial getTargetWidget : (I)Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1536: astore #5
    //   1538: aload #5
    //   1540: ifnull -> 1566
    //   1543: aload #6
    //   1545: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1548: aload #5
    //   1550: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1553: aload #8
    //   1555: getfield bottomMargin : I
    //   1558: aload #8
    //   1560: getfield goneBottomMargin : I
    //   1563: invokevirtual immediateConnect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;Landroid/support/constraint/solver/widgets/ConstraintWidget;Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;II)V
    //   1566: aload #8
    //   1568: getfield baselineToBaseline : I
    //   1571: iconst_m1
    //   1572: if_icmpeq -> 1695
    //   1575: aload_0
    //   1576: getfield mChildrenByIds : Landroid/util/SparseArray;
    //   1579: aload #8
    //   1581: getfield baselineToBaseline : I
    //   1584: invokevirtual get : (I)Ljava/lang/Object;
    //   1587: checkcast android/view/View
    //   1590: astore #10
    //   1592: aload_0
    //   1593: aload #8
    //   1595: getfield baselineToBaseline : I
    //   1598: invokespecial getTargetWidget : (I)Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1601: astore #5
    //   1603: aload #5
    //   1605: ifnull -> 1695
    //   1608: aload #10
    //   1610: ifnull -> 1695
    //   1613: aload #10
    //   1615: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1618: instanceof android/support/constraint/ConstraintLayout$LayoutParams
    //   1621: ifeq -> 1695
    //   1624: aload #10
    //   1626: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1629: checkcast android/support/constraint/ConstraintLayout$LayoutParams
    //   1632: astore #10
    //   1634: aload #8
    //   1636: iconst_1
    //   1637: putfield needsBaseline : Z
    //   1640: aload #10
    //   1642: iconst_1
    //   1643: putfield needsBaseline : Z
    //   1646: aload #6
    //   1648: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BASELINE : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1651: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1654: aload #5
    //   1656: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BASELINE : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1659: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1662: iconst_0
    //   1663: iconst_m1
    //   1664: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Strength.STRONG : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Strength;
    //   1667: iconst_0
    //   1668: iconst_1
    //   1669: invokevirtual connect : (Landroid/support/constraint/solver/widgets/ConstraintAnchor;IILandroid/support/constraint/solver/widgets/ConstraintAnchor$Strength;IZ)Z
    //   1672: pop
    //   1673: aload #6
    //   1675: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1678: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1681: invokevirtual reset : ()V
    //   1684: aload #6
    //   1686: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1689: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1692: invokevirtual reset : ()V
    //   1695: fload #11
    //   1697: fconst_0
    //   1698: fcmpl
    //   1699: iflt -> 1718
    //   1702: fload #11
    //   1704: ldc_w 0.5
    //   1707: fcmpl
    //   1708: ifeq -> 1718
    //   1711: aload #6
    //   1713: fload #11
    //   1715: invokevirtual setHorizontalBiasPercent : (F)V
    //   1718: aload #8
    //   1720: getfield verticalBias : F
    //   1723: fconst_0
    //   1724: fcmpl
    //   1725: iflt -> 1750
    //   1728: aload #8
    //   1730: getfield verticalBias : F
    //   1733: ldc_w 0.5
    //   1736: fcmpl
    //   1737: ifeq -> 1750
    //   1740: aload #6
    //   1742: aload #8
    //   1744: getfield verticalBias : F
    //   1747: invokevirtual setVerticalBiasPercent : (F)V
    //   1750: iload_1
    //   1751: ifeq -> 1787
    //   1754: aload #8
    //   1756: getfield editorAbsoluteX : I
    //   1759: iconst_m1
    //   1760: if_icmpne -> 1772
    //   1763: aload #8
    //   1765: getfield editorAbsoluteY : I
    //   1768: iconst_m1
    //   1769: if_icmpeq -> 1787
    //   1772: aload #6
    //   1774: aload #8
    //   1776: getfield editorAbsoluteX : I
    //   1779: aload #8
    //   1781: getfield editorAbsoluteY : I
    //   1784: invokevirtual setOrigin : (II)V
    //   1787: aload #8
    //   1789: getfield horizontalDimensionFixed : Z
    //   1792: ifne -> 1864
    //   1795: aload #8
    //   1797: getfield width : I
    //   1800: iconst_m1
    //   1801: if_icmpne -> 1847
    //   1804: aload #6
    //   1806: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_PARENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1809: invokevirtual setHorizontalDimensionBehaviour : (Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;)V
    //   1812: aload #6
    //   1814: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.LEFT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1817: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1820: aload #8
    //   1822: getfield leftMargin : I
    //   1825: putfield mMargin : I
    //   1828: aload #6
    //   1830: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1833: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1836: aload #8
    //   1838: getfield rightMargin : I
    //   1841: putfield mMargin : I
    //   1844: goto -> 1882
    //   1847: aload #6
    //   1849: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1852: invokevirtual setHorizontalDimensionBehaviour : (Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;)V
    //   1855: aload #6
    //   1857: iconst_0
    //   1858: invokevirtual setWidth : (I)V
    //   1861: goto -> 1882
    //   1864: aload #6
    //   1866: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.FIXED : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1869: invokevirtual setHorizontalDimensionBehaviour : (Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;)V
    //   1872: aload #6
    //   1874: aload #8
    //   1876: getfield width : I
    //   1879: invokevirtual setWidth : (I)V
    //   1882: aload #8
    //   1884: getfield verticalDimensionFixed : Z
    //   1887: ifne -> 1959
    //   1890: aload #8
    //   1892: getfield height : I
    //   1895: iconst_m1
    //   1896: if_icmpne -> 1942
    //   1899: aload #6
    //   1901: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_PARENT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1904: invokevirtual setVerticalDimensionBehaviour : (Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;)V
    //   1907: aload #6
    //   1909: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.TOP : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1912: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1915: aload #8
    //   1917: getfield topMargin : I
    //   1920: putfield mMargin : I
    //   1923: aload #6
    //   1925: getstatic android/support/constraint/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;
    //   1928: invokevirtual getAnchor : (Landroid/support/constraint/solver/widgets/ConstraintAnchor$Type;)Landroid/support/constraint/solver/widgets/ConstraintAnchor;
    //   1931: aload #8
    //   1933: getfield bottomMargin : I
    //   1936: putfield mMargin : I
    //   1939: goto -> 1977
    //   1942: aload #6
    //   1944: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1947: invokevirtual setVerticalDimensionBehaviour : (Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;)V
    //   1950: aload #6
    //   1952: iconst_0
    //   1953: invokevirtual setHeight : (I)V
    //   1956: goto -> 1977
    //   1959: aload #6
    //   1961: getstatic android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour.FIXED : Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1964: invokevirtual setVerticalDimensionBehaviour : (Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;)V
    //   1967: aload #6
    //   1969: aload #8
    //   1971: getfield height : I
    //   1974: invokevirtual setHeight : (I)V
    //   1977: iconst_0
    //   1978: istore #7
    //   1980: aload #8
    //   1982: getfield dimensionRatio : Ljava/lang/String;
    //   1985: ifnull -> 1998
    //   1988: aload #6
    //   1990: aload #8
    //   1992: getfield dimensionRatio : Ljava/lang/String;
    //   1995: invokevirtual setDimensionRatio : (Ljava/lang/String;)V
    //   1998: aload #6
    //   2000: aload #8
    //   2002: getfield horizontalWeight : F
    //   2005: invokevirtual setHorizontalWeight : (F)V
    //   2008: aload #6
    //   2010: aload #8
    //   2012: getfield verticalWeight : F
    //   2015: invokevirtual setVerticalWeight : (F)V
    //   2018: aload #6
    //   2020: aload #8
    //   2022: getfield horizontalChainStyle : I
    //   2025: invokevirtual setHorizontalChainStyle : (I)V
    //   2028: aload #6
    //   2030: aload #8
    //   2032: getfield verticalChainStyle : I
    //   2035: invokevirtual setVerticalChainStyle : (I)V
    //   2038: aload #6
    //   2040: aload #8
    //   2042: getfield matchConstraintDefaultWidth : I
    //   2045: aload #8
    //   2047: getfield matchConstraintMinWidth : I
    //   2050: aload #8
    //   2052: getfield matchConstraintMaxWidth : I
    //   2055: aload #8
    //   2057: getfield matchConstraintPercentWidth : F
    //   2060: invokevirtual setHorizontalMatchStyle : (IIIF)V
    //   2063: aload #6
    //   2065: aload #8
    //   2067: getfield matchConstraintDefaultHeight : I
    //   2070: aload #8
    //   2072: getfield matchConstraintMinHeight : I
    //   2075: aload #8
    //   2077: getfield matchConstraintMaxHeight : I
    //   2080: aload #8
    //   2082: getfield matchConstraintPercentHeight : F
    //   2085: invokevirtual setVerticalMatchStyle : (IIIF)V
    //   2088: iinc #9, 1
    //   2091: iload #7
    //   2093: istore #4
    //   2095: goto -> 331
    //   2098: return
    //   2099: astore #8
    //   2101: goto -> 106
    // Exception table:
    //   from	to	target	type
    //   33	71	2099	android/content/res/Resources$NotFoundException
    //   81	92	2099	android/content/res/Resources$NotFoundException
    //   92	106	2099	android/content/res/Resources$NotFoundException
    //   402	463	466	android/content/res/Resources$NotFoundException
  }
  
  private void setSelfDimensionBehaviour(int paramInt1, int paramInt2) {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int k = getPaddingTop();
    int m = getPaddingBottom();
    int n = getPaddingLeft();
    int i1 = getPaddingRight();
    ConstraintWidget.DimensionBehaviour dimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.FIXED;
    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
    getLayoutParams();
    if (i != Integer.MIN_VALUE) {
      if (i != 0) {
        if (i != 1073741824) {
          paramInt1 = 0;
        } else {
          paramInt1 = Math.min(this.mMaxWidth, paramInt1) - n + i1;
        } 
      } else {
        dimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        paramInt1 = 0;
      } 
    } else {
      dimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    } 
    if (j != Integer.MIN_VALUE) {
      if (j != 0) {
        if (j != 1073741824) {
          paramInt2 = 0;
        } else {
          paramInt2 = Math.min(this.mMaxHeight, paramInt2) - k + m;
        } 
      } else {
        dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        paramInt2 = 0;
      } 
    } else {
      dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    } 
    this.mLayoutWidget.setMinWidth(0);
    this.mLayoutWidget.setMinHeight(0);
    this.mLayoutWidget.setHorizontalDimensionBehaviour(dimensionBehaviour1);
    this.mLayoutWidget.setWidth(paramInt1);
    this.mLayoutWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
    this.mLayoutWidget.setHeight(paramInt2);
    this.mLayoutWidget.setMinWidth(this.mMinWidth - getPaddingLeft() - getPaddingRight());
    this.mLayoutWidget.setMinHeight(this.mMinHeight - getPaddingTop() - getPaddingBottom());
  }
  
  private void updateHierarchy() {
    boolean bool2;
    int i = getChildCount();
    boolean bool1 = false;
    byte b = 0;
    while (true) {
      bool2 = bool1;
      if (b < i) {
        if (getChildAt(b).isLayoutRequested()) {
          bool2 = true;
          break;
        } 
        b++;
        continue;
      } 
      break;
    } 
    if (bool2) {
      this.mVariableDimensionsWidgets.clear();
      setChildrenConstraints();
    } 
  }
  
  private void updatePostMeasures() {
    int i = getChildCount();
    boolean bool = false;
    byte b;
    for (b = 0; b < i; b++) {
      View view = getChildAt(b);
      if (view instanceof Placeholder)
        ((Placeholder)view).updatePostMeasure(this); 
    } 
    i = this.mConstraintHelpers.size();
    if (i > 0)
      for (b = bool; b < i; b++)
        ((ConstraintHelper)this.mConstraintHelpers.get(b)).updatePostMeasure(this);  
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT < 14)
      onViewAdded(paramView); 
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void dispatchDraw(Canvas paramCanvas) {
    super.dispatchDraw(paramCanvas);
    if (isInEditMode()) {
      int i = getChildCount();
      float f1 = getWidth();
      float f2 = getHeight();
      for (byte b = 0; b < i; b++) {
        View view = getChildAt(b);
        if (view.getVisibility() != 8) {
          Object object = view.getTag();
          if (object != null && object instanceof String) {
            object = ((String)object).split(",");
            if (object.length == 4) {
              int j = Integer.parseInt((String)object[0]);
              int k = Integer.parseInt((String)object[1]);
              int m = Integer.parseInt((String)object[2]);
              int n = Integer.parseInt((String)object[3]);
              j = (int)(j / 1080.0F * f1);
              k = (int)(k / 1920.0F * f2);
              m = (int)(m / 1080.0F * f1);
              n = (int)(n / 1920.0F * f2);
              object = new Paint();
              object.setColor(-65536);
              float f3 = j;
              float f4 = k;
              float f5 = (j + m);
              paramCanvas.drawLine(f3, f4, f5, f4, (Paint)object);
              float f6 = (k + n);
              paramCanvas.drawLine(f5, f4, f5, f6, (Paint)object);
              paramCanvas.drawLine(f5, f6, f3, f6, (Paint)object);
              paramCanvas.drawLine(f3, f6, f3, f4, (Paint)object);
              object.setColor(-16711936);
              paramCanvas.drawLine(f3, f4, f5, f6, (Paint)object);
              paramCanvas.drawLine(f3, f6, f5, f4, (Paint)object);
            } 
          } 
        } 
      } 
    } 
  }
  
  public void fillMetrics(Metrics paramMetrics) {
    this.mMetrics = paramMetrics;
    this.mLayoutWidget.fillMetrics(paramMetrics);
  }
  
  protected LayoutParams generateDefaultLayoutParams() {
    return new LayoutParams(-2, -2);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (ViewGroup.LayoutParams)new LayoutParams(paramLayoutParams);
  }
  
  public Object getDesignInformation(int paramInt, Object paramObject) {
    if (paramInt == 0 && paramObject instanceof String) {
      paramObject = paramObject;
      HashMap<String, Integer> hashMap = this.mDesignIds;
      if (hashMap != null && hashMap.containsKey(paramObject))
        return this.mDesignIds.get(paramObject); 
    } 
    return null;
  }
  
  public int getMaxHeight() {
    return this.mMaxHeight;
  }
  
  public int getMaxWidth() {
    return this.mMaxWidth;
  }
  
  public int getMinHeight() {
    return this.mMinHeight;
  }
  
  public int getMinWidth() {
    return this.mMinWidth;
  }
  
  public int getOptimizationLevel() {
    return this.mLayoutWidget.getOptimizationLevel();
  }
  
  public View getViewById(int paramInt) {
    return (View)this.mChildrenByIds.get(paramInt);
  }
  
  public final ConstraintWidget getViewWidget(View paramView) {
    ConstraintWidget constraintWidget;
    if (paramView == this)
      return (ConstraintWidget)this.mLayoutWidget; 
    if (paramView == null) {
      paramView = null;
    } else {
      constraintWidget = ((LayoutParams)paramView.getLayoutParams()).widget;
    } 
    return constraintWidget;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt3 = getChildCount();
    paramBoolean = isInEditMode();
    paramInt2 = 0;
    for (paramInt1 = 0; paramInt1 < paramInt3; paramInt1++) {
      View view = getChildAt(paramInt1);
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      ConstraintWidget constraintWidget = layoutParams.widget;
      if ((view.getVisibility() != 8 || layoutParams.isGuideline || layoutParams.isHelper || paramBoolean) && !layoutParams.isInPlaceholder) {
        int i = constraintWidget.getDrawX();
        paramInt4 = constraintWidget.getDrawY();
        int j = constraintWidget.getWidth() + i;
        int k = constraintWidget.getHeight() + paramInt4;
        view.layout(i, paramInt4, j, k);
        if (view instanceof Placeholder) {
          View view1 = ((Placeholder)view).getContent();
          if (view1 != null) {
            view1.setVisibility(0);
            view1.layout(i, paramInt4, j, k);
          } 
        } 
      } 
    } 
    paramInt3 = this.mConstraintHelpers.size();
    if (paramInt3 > 0)
      for (paramInt1 = paramInt2; paramInt1 < paramInt3; paramInt1++)
        ((ConstraintHelper)this.mConstraintHelpers.get(paramInt1)).updatePostLayout(this);  
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    boolean bool;
    System.currentTimeMillis();
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    if (this.mLastMeasureWidth != -1)
      n = this.mLastMeasureHeight; 
    if (i == 1073741824 && k == 1073741824 && j == this.mLastMeasureWidth)
      n = this.mLastMeasureHeight; 
    if (i == this.mLastMeasureWidthMode && k == this.mLastMeasureHeightMode) {
      n = 1;
    } else {
      n = 0;
    } 
    if (n && j == this.mLastMeasureWidthSize)
      bool = this.mLastMeasureHeightSize; 
    if (n && i == Integer.MIN_VALUE && k == 1073741824 && j >= this.mLastMeasureWidth)
      bool = this.mLastMeasureHeight; 
    if (n && i == 1073741824 && k == Integer.MIN_VALUE && j == this.mLastMeasureWidth)
      n = this.mLastMeasureHeight; 
    this.mLastMeasureWidthMode = i;
    this.mLastMeasureHeightMode = k;
    this.mLastMeasureWidthSize = j;
    this.mLastMeasureHeightSize = m;
    int n = getPaddingLeft();
    j = getPaddingTop();
    this.mLayoutWidget.setX(n);
    this.mLayoutWidget.setY(j);
    this.mLayoutWidget.setMaxWidth(this.mMaxWidth);
    this.mLayoutWidget.setMaxHeight(this.mMaxHeight);
    if (Build.VERSION.SDK_INT >= 17) {
      boolean bool1;
      ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
      if (getLayoutDirection() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      constraintWidgetContainer.setRtl(bool1);
    } 
    setSelfDimensionBehaviour(paramInt1, paramInt2);
    int i1 = this.mLayoutWidget.getWidth();
    int i2 = this.mLayoutWidget.getHeight();
    if (this.mDirtyHierarchy) {
      this.mDirtyHierarchy = false;
      updateHierarchy();
    } 
    if ((this.mOptimizationLevel & 0x8) == 8) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      this.mLayoutWidget.preOptimize();
      this.mLayoutWidget.optimizeForDimensions(i1, i2);
      internalMeasureDimensions(paramInt1, paramInt2);
    } else {
      internalMeasureChildren(paramInt1, paramInt2);
    } 
    updatePostMeasures();
    if (getChildCount() > 0)
      solveLinearSystem("First pass"); 
    int i3 = this.mVariableDimensionsWidgets.size();
    int i4 = j + getPaddingBottom();
    int i5 = n + getPaddingRight();
    if (i3 > 0) {
      boolean bool1;
      boolean bool2;
      if (this.mLayoutWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (this.mLayoutWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      m = Math.max(this.mLayoutWidget.getWidth(), this.mMinWidth);
      n = Math.max(this.mLayoutWidget.getHeight(), this.mMinHeight);
      byte b = 0;
      i = 0;
      j = 0;
      while (b < i3) {
        ConstraintWidget constraintWidget = this.mVariableDimensionsWidgets.get(b);
        View view = (View)constraintWidget.getCompanionWidget();
        if (view != null) {
          LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
          if (!layoutParams.isHelper && !layoutParams.isGuideline && view.getVisibility() != 8 && (!bool || !constraintWidget.getResolutionWidth().isResolved() || !constraintWidget.getResolutionHeight().isResolved())) {
            if (layoutParams.width == -2 && layoutParams.horizontalDimensionFixed) {
              k = getChildMeasureSpec(paramInt1, i5, layoutParams.width);
            } else {
              k = View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824);
            } 
            if (layoutParams.height == -2 && layoutParams.verticalDimensionFixed) {
              i6 = getChildMeasureSpec(paramInt2, i4, layoutParams.height);
            } else {
              i6 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
            } 
            view.measure(k, i6);
            Metrics metrics = this.mMetrics;
            if (metrics != null)
              metrics.additionalMeasures++; 
            int i7 = view.getMeasuredWidth();
            int i6 = view.getMeasuredHeight();
            k = i;
            i = m;
            if (i7 != constraintWidget.getWidth()) {
              constraintWidget.setWidth(i7);
              if (bool)
                constraintWidget.getResolutionWidth().resolve(i7); 
              i = m;
              if (bool1) {
                i = m;
                if (constraintWidget.getRight() > m)
                  i = Math.max(m, constraintWidget.getRight() + constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin()); 
              } 
              k = 1;
            } 
            if (i6 != constraintWidget.getHeight()) {
              constraintWidget.setHeight(i6);
              if (bool)
                constraintWidget.getResolutionHeight().resolve(i6); 
              if (bool2) {
                k = constraintWidget.getBottom();
                m = n;
                if (k > m)
                  n = Math.max(m, constraintWidget.getBottom() + constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin()); 
              } 
              k = 1;
            } 
            if (layoutParams.needsBaseline) {
              i6 = view.getBaseline();
              m = k;
              if (i6 != -1) {
                m = k;
                if (i6 != constraintWidget.getBaselineDistance()) {
                  constraintWidget.setBaselineDistance(i6);
                  m = 1;
                } 
              } 
            } else {
              m = k;
            } 
            if (Build.VERSION.SDK_INT >= 11) {
              j = combineMeasuredStates(j, view.getMeasuredState());
              k = i;
            } else {
              k = i;
            } 
            continue;
          } 
        } 
        k = m;
        m = i;
        continue;
        b++;
        i = m;
        m = k;
      } 
      k = j;
      if (i != 0) {
        this.mLayoutWidget.setWidth(i1);
        this.mLayoutWidget.setHeight(i2);
        if (bool)
          this.mLayoutWidget.solveGraph(); 
        solveLinearSystem("2nd pass");
        if (this.mLayoutWidget.getWidth() < m) {
          this.mLayoutWidget.setWidth(m);
          j = 1;
        } else {
          j = 0;
        } 
        if (this.mLayoutWidget.getHeight() < n) {
          this.mLayoutWidget.setHeight(n);
          j = 1;
        } 
        if (j != 0)
          solveLinearSystem("3rd pass"); 
      } 
      j = 0;
      while (true) {
        n = k;
        if (j < i3) {
          ConstraintWidget constraintWidget = this.mVariableDimensionsWidgets.get(j);
          View view = (View)constraintWidget.getCompanionWidget();
          if (view != null && (view.getMeasuredWidth() != constraintWidget.getWidth() || view.getMeasuredHeight() != constraintWidget.getHeight()) && constraintWidget.getVisibility() != 8) {
            view.measure(View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824));
            Metrics metrics = this.mMetrics;
            if (metrics != null)
              metrics.additionalMeasures++; 
          } 
          j++;
          continue;
        } 
        break;
      } 
    } else {
      n = 0;
    } 
    j = this.mLayoutWidget.getWidth() + i5;
    m = this.mLayoutWidget.getHeight() + i4;
    if (Build.VERSION.SDK_INT >= 11) {
      paramInt1 = resolveSizeAndState(j, paramInt1, n);
      n = resolveSizeAndState(m, paramInt2, n << 16);
      paramInt2 = Math.min(this.mMaxWidth, paramInt1 & 0xFFFFFF);
      n = Math.min(this.mMaxHeight, n & 0xFFFFFF);
      paramInt1 = paramInt2;
      if (this.mLayoutWidget.isWidthMeasuredTooSmall())
        paramInt1 = paramInt2 | 0x1000000; 
      paramInt2 = n;
      if (this.mLayoutWidget.isHeightMeasuredTooSmall())
        paramInt2 = n | 0x1000000; 
      setMeasuredDimension(paramInt1, paramInt2);
      this.mLastMeasureWidth = paramInt1;
      this.mLastMeasureHeight = paramInt2;
    } else {
      setMeasuredDimension(j, m);
      this.mLastMeasureWidth = j;
      this.mLastMeasureHeight = m;
    } 
  }
  
  public void onViewAdded(View paramView) {
    if (Build.VERSION.SDK_INT >= 14)
      super.onViewAdded(paramView); 
    ConstraintWidget constraintWidget = getViewWidget(paramView);
    if (paramView instanceof Guideline && !(constraintWidget instanceof Guideline)) {
      LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
      layoutParams.widget = (ConstraintWidget)new Guideline();
      layoutParams.isGuideline = true;
      ((Guideline)layoutParams.widget).setOrientation(layoutParams.orientation);
    } 
    if (paramView instanceof ConstraintHelper) {
      ConstraintHelper constraintHelper = (ConstraintHelper)paramView;
      constraintHelper.validateParams();
      ((LayoutParams)paramView.getLayoutParams()).isHelper = true;
      if (!this.mConstraintHelpers.contains(constraintHelper))
        this.mConstraintHelpers.add(constraintHelper); 
    } 
    this.mChildrenByIds.put(paramView.getId(), paramView);
    this.mDirtyHierarchy = true;
  }
  
  public void onViewRemoved(View paramView) {
    if (Build.VERSION.SDK_INT >= 14)
      super.onViewRemoved(paramView); 
    this.mChildrenByIds.remove(paramView.getId());
    ConstraintWidget constraintWidget = getViewWidget(paramView);
    this.mLayoutWidget.remove(constraintWidget);
    this.mConstraintHelpers.remove(paramView);
    this.mVariableDimensionsWidgets.remove(constraintWidget);
    this.mDirtyHierarchy = true;
  }
  
  public void removeView(View paramView) {
    super.removeView(paramView);
    if (Build.VERSION.SDK_INT < 14)
      onViewRemoved(paramView); 
  }
  
  public void requestLayout() {
    super.requestLayout();
    this.mDirtyHierarchy = true;
    this.mLastMeasureWidth = -1;
    this.mLastMeasureHeight = -1;
    this.mLastMeasureWidthSize = -1;
    this.mLastMeasureHeightSize = -1;
    this.mLastMeasureWidthMode = 0;
    this.mLastMeasureHeightMode = 0;
  }
  
  public void setConstraintSet(ConstraintSet paramConstraintSet) {
    this.mConstraintSet = paramConstraintSet;
  }
  
  public void setDesignInformation(int paramInt, Object paramObject1, Object paramObject2) {
    if (paramInt == 0 && paramObject1 instanceof String && paramObject2 instanceof Integer) {
      if (this.mDesignIds == null)
        this.mDesignIds = new HashMap<String, Integer>(); 
      String str = (String)paramObject1;
      paramInt = str.indexOf("/");
      paramObject1 = str;
      if (paramInt != -1)
        paramObject1 = str.substring(paramInt + 1); 
      paramInt = ((Integer)paramObject2).intValue();
      this.mDesignIds.put(paramObject1, Integer.valueOf(paramInt));
    } 
  }
  
  public void setId(int paramInt) {
    this.mChildrenByIds.remove(getId());
    super.setId(paramInt);
    this.mChildrenByIds.put(getId(), this);
  }
  
  public void setMaxHeight(int paramInt) {
    if (paramInt == this.mMaxHeight)
      return; 
    this.mMaxHeight = paramInt;
    requestLayout();
  }
  
  public void setMaxWidth(int paramInt) {
    if (paramInt == this.mMaxWidth)
      return; 
    this.mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setMinHeight(int paramInt) {
    if (paramInt == this.mMinHeight)
      return; 
    this.mMinHeight = paramInt;
    requestLayout();
  }
  
  public void setMinWidth(int paramInt) {
    if (paramInt == this.mMinWidth)
      return; 
    this.mMinWidth = paramInt;
    requestLayout();
  }
  
  public void setOptimizationLevel(int paramInt) {
    this.mLayoutWidget.setOptimizationLevel(paramInt);
  }
  
  public boolean shouldDelayChildPressedState() {
    return false;
  }
  
  protected void solveLinearSystem(String paramString) {
    this.mLayoutWidget.layout();
    Metrics metrics = this.mMetrics;
    if (metrics != null)
      metrics.resolutions++; 
  }
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    public static final int BASELINE = 5;
    
    public static final int BOTTOM = 4;
    
    public static final int CHAIN_PACKED = 2;
    
    public static final int CHAIN_SPREAD = 0;
    
    public static final int CHAIN_SPREAD_INSIDE = 1;
    
    public static final int END = 7;
    
    public static final int HORIZONTAL = 0;
    
    public static final int LEFT = 1;
    
    public static final int MATCH_CONSTRAINT = 0;
    
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    
    public static final int PARENT_ID = 0;
    
    public static final int RIGHT = 2;
    
    public static final int START = 6;
    
    public static final int TOP = 3;
    
    public static final int UNSET = -1;
    
    public static final int VERTICAL = 1;
    
    public int baselineToBaseline = -1;
    
    public int bottomToBottom = -1;
    
    public int bottomToTop = -1;
    
    public float circleAngle = 0.0F;
    
    public int circleConstraint = -1;
    
    public int circleRadius = 0;
    
    public boolean constrainedHeight = false;
    
    public boolean constrainedWidth = false;
    
    public String dimensionRatio = null;
    
    int dimensionRatioSide = 1;
    
    float dimensionRatioValue = 0.0F;
    
    public int editorAbsoluteX = -1;
    
    public int editorAbsoluteY = -1;
    
    public int endToEnd = -1;
    
    public int endToStart = -1;
    
    public int goneBottomMargin = -1;
    
    public int goneEndMargin = -1;
    
    public int goneLeftMargin = -1;
    
    public int goneRightMargin = -1;
    
    public int goneStartMargin = -1;
    
    public int goneTopMargin = -1;
    
    public int guideBegin = -1;
    
    public int guideEnd = -1;
    
    public float guidePercent = -1.0F;
    
    public boolean helped = false;
    
    public float horizontalBias = 0.5F;
    
    public int horizontalChainStyle = 0;
    
    boolean horizontalDimensionFixed = true;
    
    public float horizontalWeight = -1.0F;
    
    boolean isGuideline = false;
    
    boolean isHelper = false;
    
    boolean isInPlaceholder = false;
    
    public int leftToLeft = -1;
    
    public int leftToRight = -1;
    
    public int matchConstraintDefaultHeight = 0;
    
    public int matchConstraintDefaultWidth = 0;
    
    public int matchConstraintMaxHeight = 0;
    
    public int matchConstraintMaxWidth = 0;
    
    public int matchConstraintMinHeight = 0;
    
    public int matchConstraintMinWidth = 0;
    
    public float matchConstraintPercentHeight = 1.0F;
    
    public float matchConstraintPercentWidth = 1.0F;
    
    boolean needsBaseline = false;
    
    public int orientation = -1;
    
    int resolveGoneLeftMargin = -1;
    
    int resolveGoneRightMargin = -1;
    
    int resolvedGuideBegin;
    
    int resolvedGuideEnd;
    
    float resolvedGuidePercent;
    
    float resolvedHorizontalBias = 0.5F;
    
    int resolvedLeftToLeft = -1;
    
    int resolvedLeftToRight = -1;
    
    int resolvedRightToLeft = -1;
    
    int resolvedRightToRight = -1;
    
    public int rightToLeft = -1;
    
    public int rightToRight = -1;
    
    public int startToEnd = -1;
    
    public int startToStart = -1;
    
    public int topToBottom = -1;
    
    public int topToTop = -1;
    
    public float verticalBias = 0.5F;
    
    public int verticalChainStyle = 0;
    
    boolean verticalDimensionFixed = true;
    
    public float verticalWeight = -1.0F;
    
    ConstraintWidget widget = new ConstraintWidget();
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: aload_2
      //   3: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;)V
      //   6: aload_0
      //   7: iconst_m1
      //   8: putfield guideBegin : I
      //   11: aload_0
      //   12: iconst_m1
      //   13: putfield guideEnd : I
      //   16: aload_0
      //   17: ldc -1.0
      //   19: putfield guidePercent : F
      //   22: aload_0
      //   23: iconst_m1
      //   24: putfield leftToLeft : I
      //   27: aload_0
      //   28: iconst_m1
      //   29: putfield leftToRight : I
      //   32: aload_0
      //   33: iconst_m1
      //   34: putfield rightToLeft : I
      //   37: aload_0
      //   38: iconst_m1
      //   39: putfield rightToRight : I
      //   42: aload_0
      //   43: iconst_m1
      //   44: putfield topToTop : I
      //   47: aload_0
      //   48: iconst_m1
      //   49: putfield topToBottom : I
      //   52: aload_0
      //   53: iconst_m1
      //   54: putfield bottomToTop : I
      //   57: aload_0
      //   58: iconst_m1
      //   59: putfield bottomToBottom : I
      //   62: aload_0
      //   63: iconst_m1
      //   64: putfield baselineToBaseline : I
      //   67: aload_0
      //   68: iconst_m1
      //   69: putfield circleConstraint : I
      //   72: aload_0
      //   73: iconst_0
      //   74: putfield circleRadius : I
      //   77: aload_0
      //   78: fconst_0
      //   79: putfield circleAngle : F
      //   82: aload_0
      //   83: iconst_m1
      //   84: putfield startToEnd : I
      //   87: aload_0
      //   88: iconst_m1
      //   89: putfield startToStart : I
      //   92: aload_0
      //   93: iconst_m1
      //   94: putfield endToStart : I
      //   97: aload_0
      //   98: iconst_m1
      //   99: putfield endToEnd : I
      //   102: aload_0
      //   103: iconst_m1
      //   104: putfield goneLeftMargin : I
      //   107: aload_0
      //   108: iconst_m1
      //   109: putfield goneTopMargin : I
      //   112: aload_0
      //   113: iconst_m1
      //   114: putfield goneRightMargin : I
      //   117: aload_0
      //   118: iconst_m1
      //   119: putfield goneBottomMargin : I
      //   122: aload_0
      //   123: iconst_m1
      //   124: putfield goneStartMargin : I
      //   127: aload_0
      //   128: iconst_m1
      //   129: putfield goneEndMargin : I
      //   132: aload_0
      //   133: ldc 0.5
      //   135: putfield horizontalBias : F
      //   138: aload_0
      //   139: ldc 0.5
      //   141: putfield verticalBias : F
      //   144: aload_0
      //   145: aconst_null
      //   146: putfield dimensionRatio : Ljava/lang/String;
      //   149: aload_0
      //   150: fconst_0
      //   151: putfield dimensionRatioValue : F
      //   154: aload_0
      //   155: iconst_1
      //   156: putfield dimensionRatioSide : I
      //   159: aload_0
      //   160: ldc -1.0
      //   162: putfield horizontalWeight : F
      //   165: aload_0
      //   166: ldc -1.0
      //   168: putfield verticalWeight : F
      //   171: aload_0
      //   172: iconst_0
      //   173: putfield horizontalChainStyle : I
      //   176: aload_0
      //   177: iconst_0
      //   178: putfield verticalChainStyle : I
      //   181: aload_0
      //   182: iconst_0
      //   183: putfield matchConstraintDefaultWidth : I
      //   186: aload_0
      //   187: iconst_0
      //   188: putfield matchConstraintDefaultHeight : I
      //   191: aload_0
      //   192: iconst_0
      //   193: putfield matchConstraintMinWidth : I
      //   196: aload_0
      //   197: iconst_0
      //   198: putfield matchConstraintMinHeight : I
      //   201: aload_0
      //   202: iconst_0
      //   203: putfield matchConstraintMaxWidth : I
      //   206: aload_0
      //   207: iconst_0
      //   208: putfield matchConstraintMaxHeight : I
      //   211: aload_0
      //   212: fconst_1
      //   213: putfield matchConstraintPercentWidth : F
      //   216: aload_0
      //   217: fconst_1
      //   218: putfield matchConstraintPercentHeight : F
      //   221: aload_0
      //   222: iconst_m1
      //   223: putfield editorAbsoluteX : I
      //   226: aload_0
      //   227: iconst_m1
      //   228: putfield editorAbsoluteY : I
      //   231: aload_0
      //   232: iconst_m1
      //   233: putfield orientation : I
      //   236: aload_0
      //   237: iconst_0
      //   238: putfield constrainedWidth : Z
      //   241: aload_0
      //   242: iconst_0
      //   243: putfield constrainedHeight : Z
      //   246: aload_0
      //   247: iconst_1
      //   248: putfield horizontalDimensionFixed : Z
      //   251: aload_0
      //   252: iconst_1
      //   253: putfield verticalDimensionFixed : Z
      //   256: aload_0
      //   257: iconst_0
      //   258: putfield needsBaseline : Z
      //   261: aload_0
      //   262: iconst_0
      //   263: putfield isGuideline : Z
      //   266: aload_0
      //   267: iconst_0
      //   268: putfield isHelper : Z
      //   271: aload_0
      //   272: iconst_0
      //   273: putfield isInPlaceholder : Z
      //   276: aload_0
      //   277: iconst_m1
      //   278: putfield resolvedLeftToLeft : I
      //   281: aload_0
      //   282: iconst_m1
      //   283: putfield resolvedLeftToRight : I
      //   286: aload_0
      //   287: iconst_m1
      //   288: putfield resolvedRightToLeft : I
      //   291: aload_0
      //   292: iconst_m1
      //   293: putfield resolvedRightToRight : I
      //   296: aload_0
      //   297: iconst_m1
      //   298: putfield resolveGoneLeftMargin : I
      //   301: aload_0
      //   302: iconst_m1
      //   303: putfield resolveGoneRightMargin : I
      //   306: aload_0
      //   307: ldc 0.5
      //   309: putfield resolvedHorizontalBias : F
      //   312: aload_0
      //   313: new android/support/constraint/solver/widgets/ConstraintWidget
      //   316: dup
      //   317: invokespecial <init> : ()V
      //   320: putfield widget : Landroid/support/constraint/solver/widgets/ConstraintWidget;
      //   323: aload_0
      //   324: iconst_0
      //   325: putfield helped : Z
      //   328: aload_1
      //   329: aload_2
      //   330: getstatic android/support/constraint/R$styleable.ConstraintLayout_Layout : [I
      //   333: invokevirtual obtainStyledAttributes : (Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
      //   336: astore_1
      //   337: aload_1
      //   338: invokevirtual getIndexCount : ()I
      //   341: istore_3
      //   342: iconst_0
      //   343: istore #4
      //   345: iload #4
      //   347: iload_3
      //   348: if_icmpge -> 2040
      //   351: aload_1
      //   352: iload #4
      //   354: invokevirtual getIndex : (I)I
      //   357: istore #5
      //   359: getstatic android/support/constraint/ConstraintLayout$LayoutParams$Table.map : Landroid/util/SparseIntArray;
      //   362: iload #5
      //   364: invokevirtual get : (I)I
      //   367: tableswitch default -> 584, 0 -> 2034, 1 -> 2020, 2 -> 1984, 3 -> 1967, 4 -> 1919, 5 -> 1902, 6 -> 1885, 7 -> 1868, 8 -> 1832, 9 -> 1796, 10 -> 1760, 11 -> 1724, 12 -> 1688, 13 -> 1652, 14 -> 1616, 15 -> 1580, 16 -> 1544, 17 -> 1508, 18 -> 1472, 19 -> 1436, 20 -> 1400, 21 -> 1383, 22 -> 1366, 23 -> 1349, 24 -> 1332, 25 -> 1315, 26 -> 1298, 27 -> 1281, 28 -> 1264, 29 -> 1247, 30 -> 1230, 31 -> 1198, 32 -> 1166, 33 -> 1124, 34 -> 1082, 35 -> 1061, 36 -> 1019, 37 -> 977, 38 -> 956, 39 -> 2034, 40 -> 2034, 41 -> 2034, 42 -> 2034, 43 -> 584, 44 -> 683, 45 -> 666, 46 -> 649, 47 -> 635, 48 -> 621, 49 -> 604, 50 -> 587
      //   584: goto -> 2034
      //   587: aload_0
      //   588: aload_1
      //   589: iload #5
      //   591: aload_0
      //   592: getfield editorAbsoluteY : I
      //   595: invokevirtual getDimensionPixelOffset : (II)I
      //   598: putfield editorAbsoluteY : I
      //   601: goto -> 2034
      //   604: aload_0
      //   605: aload_1
      //   606: iload #5
      //   608: aload_0
      //   609: getfield editorAbsoluteX : I
      //   612: invokevirtual getDimensionPixelOffset : (II)I
      //   615: putfield editorAbsoluteX : I
      //   618: goto -> 2034
      //   621: aload_0
      //   622: aload_1
      //   623: iload #5
      //   625: iconst_0
      //   626: invokevirtual getInt : (II)I
      //   629: putfield verticalChainStyle : I
      //   632: goto -> 2034
      //   635: aload_0
      //   636: aload_1
      //   637: iload #5
      //   639: iconst_0
      //   640: invokevirtual getInt : (II)I
      //   643: putfield horizontalChainStyle : I
      //   646: goto -> 2034
      //   649: aload_0
      //   650: aload_1
      //   651: iload #5
      //   653: aload_0
      //   654: getfield verticalWeight : F
      //   657: invokevirtual getFloat : (IF)F
      //   660: putfield verticalWeight : F
      //   663: goto -> 2034
      //   666: aload_0
      //   667: aload_1
      //   668: iload #5
      //   670: aload_0
      //   671: getfield horizontalWeight : F
      //   674: invokevirtual getFloat : (IF)F
      //   677: putfield horizontalWeight : F
      //   680: goto -> 2034
      //   683: aload_0
      //   684: aload_1
      //   685: iload #5
      //   687: invokevirtual getString : (I)Ljava/lang/String;
      //   690: putfield dimensionRatio : Ljava/lang/String;
      //   693: aload_0
      //   694: ldc_w NaN
      //   697: putfield dimensionRatioValue : F
      //   700: aload_0
      //   701: iconst_m1
      //   702: putfield dimensionRatioSide : I
      //   705: aload_0
      //   706: getfield dimensionRatio : Ljava/lang/String;
      //   709: astore_2
      //   710: aload_2
      //   711: ifnull -> 2034
      //   714: aload_2
      //   715: invokevirtual length : ()I
      //   718: istore #6
      //   720: aload_0
      //   721: getfield dimensionRatio : Ljava/lang/String;
      //   724: bipush #44
      //   726: invokevirtual indexOf : (I)I
      //   729: istore #5
      //   731: iload #5
      //   733: ifle -> 795
      //   736: iload #5
      //   738: iload #6
      //   740: iconst_1
      //   741: isub
      //   742: if_icmpge -> 795
      //   745: aload_0
      //   746: getfield dimensionRatio : Ljava/lang/String;
      //   749: iconst_0
      //   750: iload #5
      //   752: invokevirtual substring : (II)Ljava/lang/String;
      //   755: astore_2
      //   756: aload_2
      //   757: ldc_w 'W'
      //   760: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
      //   763: ifeq -> 774
      //   766: aload_0
      //   767: iconst_0
      //   768: putfield dimensionRatioSide : I
      //   771: goto -> 789
      //   774: aload_2
      //   775: ldc_w 'H'
      //   778: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
      //   781: ifeq -> 789
      //   784: aload_0
      //   785: iconst_1
      //   786: putfield dimensionRatioSide : I
      //   789: iinc #5, 1
      //   792: goto -> 798
      //   795: iconst_0
      //   796: istore #5
      //   798: aload_0
      //   799: getfield dimensionRatio : Ljava/lang/String;
      //   802: bipush #58
      //   804: invokevirtual indexOf : (I)I
      //   807: istore #7
      //   809: iload #7
      //   811: iflt -> 928
      //   814: iload #7
      //   816: iload #6
      //   818: iconst_1
      //   819: isub
      //   820: if_icmpge -> 928
      //   823: aload_0
      //   824: getfield dimensionRatio : Ljava/lang/String;
      //   827: iload #5
      //   829: iload #7
      //   831: invokevirtual substring : (II)Ljava/lang/String;
      //   834: astore #8
      //   836: aload_0
      //   837: getfield dimensionRatio : Ljava/lang/String;
      //   840: iload #7
      //   842: iconst_1
      //   843: iadd
      //   844: invokevirtual substring : (I)Ljava/lang/String;
      //   847: astore_2
      //   848: aload #8
      //   850: invokevirtual length : ()I
      //   853: ifle -> 2034
      //   856: aload_2
      //   857: invokevirtual length : ()I
      //   860: ifle -> 2034
      //   863: aload #8
      //   865: invokestatic parseFloat : (Ljava/lang/String;)F
      //   868: fstore #9
      //   870: aload_2
      //   871: invokestatic parseFloat : (Ljava/lang/String;)F
      //   874: fstore #10
      //   876: fload #9
      //   878: fconst_0
      //   879: fcmpl
      //   880: ifle -> 2034
      //   883: fload #10
      //   885: fconst_0
      //   886: fcmpl
      //   887: ifle -> 2034
      //   890: aload_0
      //   891: getfield dimensionRatioSide : I
      //   894: iconst_1
      //   895: if_icmpne -> 913
      //   898: aload_0
      //   899: fload #10
      //   901: fload #9
      //   903: fdiv
      //   904: invokestatic abs : (F)F
      //   907: putfield dimensionRatioValue : F
      //   910: goto -> 2034
      //   913: aload_0
      //   914: fload #9
      //   916: fload #10
      //   918: fdiv
      //   919: invokestatic abs : (F)F
      //   922: putfield dimensionRatioValue : F
      //   925: goto -> 2034
      //   928: aload_0
      //   929: getfield dimensionRatio : Ljava/lang/String;
      //   932: iload #5
      //   934: invokevirtual substring : (I)Ljava/lang/String;
      //   937: astore_2
      //   938: aload_2
      //   939: invokevirtual length : ()I
      //   942: ifle -> 2034
      //   945: aload_0
      //   946: aload_2
      //   947: invokestatic parseFloat : (Ljava/lang/String;)F
      //   950: putfield dimensionRatioValue : F
      //   953: goto -> 2034
      //   956: aload_0
      //   957: fconst_0
      //   958: aload_1
      //   959: iload #5
      //   961: aload_0
      //   962: getfield matchConstraintPercentHeight : F
      //   965: invokevirtual getFloat : (IF)F
      //   968: invokestatic max : (FF)F
      //   971: putfield matchConstraintPercentHeight : F
      //   974: goto -> 2034
      //   977: aload_0
      //   978: aload_1
      //   979: iload #5
      //   981: aload_0
      //   982: getfield matchConstraintMaxHeight : I
      //   985: invokevirtual getDimensionPixelSize : (II)I
      //   988: putfield matchConstraintMaxHeight : I
      //   991: goto -> 2034
      //   994: astore_2
      //   995: aload_1
      //   996: iload #5
      //   998: aload_0
      //   999: getfield matchConstraintMaxHeight : I
      //   1002: invokevirtual getInt : (II)I
      //   1005: bipush #-2
      //   1007: if_icmpne -> 2034
      //   1010: aload_0
      //   1011: bipush #-2
      //   1013: putfield matchConstraintMaxHeight : I
      //   1016: goto -> 2034
      //   1019: aload_0
      //   1020: aload_1
      //   1021: iload #5
      //   1023: aload_0
      //   1024: getfield matchConstraintMinHeight : I
      //   1027: invokevirtual getDimensionPixelSize : (II)I
      //   1030: putfield matchConstraintMinHeight : I
      //   1033: goto -> 2034
      //   1036: astore_2
      //   1037: aload_1
      //   1038: iload #5
      //   1040: aload_0
      //   1041: getfield matchConstraintMinHeight : I
      //   1044: invokevirtual getInt : (II)I
      //   1047: bipush #-2
      //   1049: if_icmpne -> 2034
      //   1052: aload_0
      //   1053: bipush #-2
      //   1055: putfield matchConstraintMinHeight : I
      //   1058: goto -> 2034
      //   1061: aload_0
      //   1062: fconst_0
      //   1063: aload_1
      //   1064: iload #5
      //   1066: aload_0
      //   1067: getfield matchConstraintPercentWidth : F
      //   1070: invokevirtual getFloat : (IF)F
      //   1073: invokestatic max : (FF)F
      //   1076: putfield matchConstraintPercentWidth : F
      //   1079: goto -> 2034
      //   1082: aload_0
      //   1083: aload_1
      //   1084: iload #5
      //   1086: aload_0
      //   1087: getfield matchConstraintMaxWidth : I
      //   1090: invokevirtual getDimensionPixelSize : (II)I
      //   1093: putfield matchConstraintMaxWidth : I
      //   1096: goto -> 2034
      //   1099: astore_2
      //   1100: aload_1
      //   1101: iload #5
      //   1103: aload_0
      //   1104: getfield matchConstraintMaxWidth : I
      //   1107: invokevirtual getInt : (II)I
      //   1110: bipush #-2
      //   1112: if_icmpne -> 2034
      //   1115: aload_0
      //   1116: bipush #-2
      //   1118: putfield matchConstraintMaxWidth : I
      //   1121: goto -> 2034
      //   1124: aload_0
      //   1125: aload_1
      //   1126: iload #5
      //   1128: aload_0
      //   1129: getfield matchConstraintMinWidth : I
      //   1132: invokevirtual getDimensionPixelSize : (II)I
      //   1135: putfield matchConstraintMinWidth : I
      //   1138: goto -> 2034
      //   1141: astore_2
      //   1142: aload_1
      //   1143: iload #5
      //   1145: aload_0
      //   1146: getfield matchConstraintMinWidth : I
      //   1149: invokevirtual getInt : (II)I
      //   1152: bipush #-2
      //   1154: if_icmpne -> 2034
      //   1157: aload_0
      //   1158: bipush #-2
      //   1160: putfield matchConstraintMinWidth : I
      //   1163: goto -> 2034
      //   1166: aload_0
      //   1167: aload_1
      //   1168: iload #5
      //   1170: iconst_0
      //   1171: invokevirtual getInt : (II)I
      //   1174: putfield matchConstraintDefaultHeight : I
      //   1177: aload_0
      //   1178: getfield matchConstraintDefaultHeight : I
      //   1181: iconst_1
      //   1182: if_icmpne -> 2034
      //   1185: ldc_w 'ConstraintLayout'
      //   1188: ldc_w 'layout_constraintHeight_default="wrap" is deprecated.\\nUse layout_height="WRAP_CONTENT" and layout_constrainedHeight="true" instead.'
      //   1191: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
      //   1194: pop
      //   1195: goto -> 2034
      //   1198: aload_0
      //   1199: aload_1
      //   1200: iload #5
      //   1202: iconst_0
      //   1203: invokevirtual getInt : (II)I
      //   1206: putfield matchConstraintDefaultWidth : I
      //   1209: aload_0
      //   1210: getfield matchConstraintDefaultWidth : I
      //   1213: iconst_1
      //   1214: if_icmpne -> 2034
      //   1217: ldc_w 'ConstraintLayout'
      //   1220: ldc_w 'layout_constraintWidth_default="wrap" is deprecated.\\nUse layout_width="WRAP_CONTENT" and layout_constrainedWidth="true" instead.'
      //   1223: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
      //   1226: pop
      //   1227: goto -> 2034
      //   1230: aload_0
      //   1231: aload_1
      //   1232: iload #5
      //   1234: aload_0
      //   1235: getfield verticalBias : F
      //   1238: invokevirtual getFloat : (IF)F
      //   1241: putfield verticalBias : F
      //   1244: goto -> 2034
      //   1247: aload_0
      //   1248: aload_1
      //   1249: iload #5
      //   1251: aload_0
      //   1252: getfield horizontalBias : F
      //   1255: invokevirtual getFloat : (IF)F
      //   1258: putfield horizontalBias : F
      //   1261: goto -> 2034
      //   1264: aload_0
      //   1265: aload_1
      //   1266: iload #5
      //   1268: aload_0
      //   1269: getfield constrainedHeight : Z
      //   1272: invokevirtual getBoolean : (IZ)Z
      //   1275: putfield constrainedHeight : Z
      //   1278: goto -> 2034
      //   1281: aload_0
      //   1282: aload_1
      //   1283: iload #5
      //   1285: aload_0
      //   1286: getfield constrainedWidth : Z
      //   1289: invokevirtual getBoolean : (IZ)Z
      //   1292: putfield constrainedWidth : Z
      //   1295: goto -> 2034
      //   1298: aload_0
      //   1299: aload_1
      //   1300: iload #5
      //   1302: aload_0
      //   1303: getfield goneEndMargin : I
      //   1306: invokevirtual getDimensionPixelSize : (II)I
      //   1309: putfield goneEndMargin : I
      //   1312: goto -> 2034
      //   1315: aload_0
      //   1316: aload_1
      //   1317: iload #5
      //   1319: aload_0
      //   1320: getfield goneStartMargin : I
      //   1323: invokevirtual getDimensionPixelSize : (II)I
      //   1326: putfield goneStartMargin : I
      //   1329: goto -> 2034
      //   1332: aload_0
      //   1333: aload_1
      //   1334: iload #5
      //   1336: aload_0
      //   1337: getfield goneBottomMargin : I
      //   1340: invokevirtual getDimensionPixelSize : (II)I
      //   1343: putfield goneBottomMargin : I
      //   1346: goto -> 2034
      //   1349: aload_0
      //   1350: aload_1
      //   1351: iload #5
      //   1353: aload_0
      //   1354: getfield goneRightMargin : I
      //   1357: invokevirtual getDimensionPixelSize : (II)I
      //   1360: putfield goneRightMargin : I
      //   1363: goto -> 2034
      //   1366: aload_0
      //   1367: aload_1
      //   1368: iload #5
      //   1370: aload_0
      //   1371: getfield goneTopMargin : I
      //   1374: invokevirtual getDimensionPixelSize : (II)I
      //   1377: putfield goneTopMargin : I
      //   1380: goto -> 2034
      //   1383: aload_0
      //   1384: aload_1
      //   1385: iload #5
      //   1387: aload_0
      //   1388: getfield goneLeftMargin : I
      //   1391: invokevirtual getDimensionPixelSize : (II)I
      //   1394: putfield goneLeftMargin : I
      //   1397: goto -> 2034
      //   1400: aload_0
      //   1401: aload_1
      //   1402: iload #5
      //   1404: aload_0
      //   1405: getfield endToEnd : I
      //   1408: invokevirtual getResourceId : (II)I
      //   1411: putfield endToEnd : I
      //   1414: aload_0
      //   1415: getfield endToEnd : I
      //   1418: iconst_m1
      //   1419: if_icmpne -> 2034
      //   1422: aload_0
      //   1423: aload_1
      //   1424: iload #5
      //   1426: iconst_m1
      //   1427: invokevirtual getInt : (II)I
      //   1430: putfield endToEnd : I
      //   1433: goto -> 2034
      //   1436: aload_0
      //   1437: aload_1
      //   1438: iload #5
      //   1440: aload_0
      //   1441: getfield endToStart : I
      //   1444: invokevirtual getResourceId : (II)I
      //   1447: putfield endToStart : I
      //   1450: aload_0
      //   1451: getfield endToStart : I
      //   1454: iconst_m1
      //   1455: if_icmpne -> 2034
      //   1458: aload_0
      //   1459: aload_1
      //   1460: iload #5
      //   1462: iconst_m1
      //   1463: invokevirtual getInt : (II)I
      //   1466: putfield endToStart : I
      //   1469: goto -> 2034
      //   1472: aload_0
      //   1473: aload_1
      //   1474: iload #5
      //   1476: aload_0
      //   1477: getfield startToStart : I
      //   1480: invokevirtual getResourceId : (II)I
      //   1483: putfield startToStart : I
      //   1486: aload_0
      //   1487: getfield startToStart : I
      //   1490: iconst_m1
      //   1491: if_icmpne -> 2034
      //   1494: aload_0
      //   1495: aload_1
      //   1496: iload #5
      //   1498: iconst_m1
      //   1499: invokevirtual getInt : (II)I
      //   1502: putfield startToStart : I
      //   1505: goto -> 2034
      //   1508: aload_0
      //   1509: aload_1
      //   1510: iload #5
      //   1512: aload_0
      //   1513: getfield startToEnd : I
      //   1516: invokevirtual getResourceId : (II)I
      //   1519: putfield startToEnd : I
      //   1522: aload_0
      //   1523: getfield startToEnd : I
      //   1526: iconst_m1
      //   1527: if_icmpne -> 2034
      //   1530: aload_0
      //   1531: aload_1
      //   1532: iload #5
      //   1534: iconst_m1
      //   1535: invokevirtual getInt : (II)I
      //   1538: putfield startToEnd : I
      //   1541: goto -> 2034
      //   1544: aload_0
      //   1545: aload_1
      //   1546: iload #5
      //   1548: aload_0
      //   1549: getfield baselineToBaseline : I
      //   1552: invokevirtual getResourceId : (II)I
      //   1555: putfield baselineToBaseline : I
      //   1558: aload_0
      //   1559: getfield baselineToBaseline : I
      //   1562: iconst_m1
      //   1563: if_icmpne -> 2034
      //   1566: aload_0
      //   1567: aload_1
      //   1568: iload #5
      //   1570: iconst_m1
      //   1571: invokevirtual getInt : (II)I
      //   1574: putfield baselineToBaseline : I
      //   1577: goto -> 2034
      //   1580: aload_0
      //   1581: aload_1
      //   1582: iload #5
      //   1584: aload_0
      //   1585: getfield bottomToBottom : I
      //   1588: invokevirtual getResourceId : (II)I
      //   1591: putfield bottomToBottom : I
      //   1594: aload_0
      //   1595: getfield bottomToBottom : I
      //   1598: iconst_m1
      //   1599: if_icmpne -> 2034
      //   1602: aload_0
      //   1603: aload_1
      //   1604: iload #5
      //   1606: iconst_m1
      //   1607: invokevirtual getInt : (II)I
      //   1610: putfield bottomToBottom : I
      //   1613: goto -> 2034
      //   1616: aload_0
      //   1617: aload_1
      //   1618: iload #5
      //   1620: aload_0
      //   1621: getfield bottomToTop : I
      //   1624: invokevirtual getResourceId : (II)I
      //   1627: putfield bottomToTop : I
      //   1630: aload_0
      //   1631: getfield bottomToTop : I
      //   1634: iconst_m1
      //   1635: if_icmpne -> 2034
      //   1638: aload_0
      //   1639: aload_1
      //   1640: iload #5
      //   1642: iconst_m1
      //   1643: invokevirtual getInt : (II)I
      //   1646: putfield bottomToTop : I
      //   1649: goto -> 2034
      //   1652: aload_0
      //   1653: aload_1
      //   1654: iload #5
      //   1656: aload_0
      //   1657: getfield topToBottom : I
      //   1660: invokevirtual getResourceId : (II)I
      //   1663: putfield topToBottom : I
      //   1666: aload_0
      //   1667: getfield topToBottom : I
      //   1670: iconst_m1
      //   1671: if_icmpne -> 2034
      //   1674: aload_0
      //   1675: aload_1
      //   1676: iload #5
      //   1678: iconst_m1
      //   1679: invokevirtual getInt : (II)I
      //   1682: putfield topToBottom : I
      //   1685: goto -> 2034
      //   1688: aload_0
      //   1689: aload_1
      //   1690: iload #5
      //   1692: aload_0
      //   1693: getfield topToTop : I
      //   1696: invokevirtual getResourceId : (II)I
      //   1699: putfield topToTop : I
      //   1702: aload_0
      //   1703: getfield topToTop : I
      //   1706: iconst_m1
      //   1707: if_icmpne -> 2034
      //   1710: aload_0
      //   1711: aload_1
      //   1712: iload #5
      //   1714: iconst_m1
      //   1715: invokevirtual getInt : (II)I
      //   1718: putfield topToTop : I
      //   1721: goto -> 2034
      //   1724: aload_0
      //   1725: aload_1
      //   1726: iload #5
      //   1728: aload_0
      //   1729: getfield rightToRight : I
      //   1732: invokevirtual getResourceId : (II)I
      //   1735: putfield rightToRight : I
      //   1738: aload_0
      //   1739: getfield rightToRight : I
      //   1742: iconst_m1
      //   1743: if_icmpne -> 2034
      //   1746: aload_0
      //   1747: aload_1
      //   1748: iload #5
      //   1750: iconst_m1
      //   1751: invokevirtual getInt : (II)I
      //   1754: putfield rightToRight : I
      //   1757: goto -> 2034
      //   1760: aload_0
      //   1761: aload_1
      //   1762: iload #5
      //   1764: aload_0
      //   1765: getfield rightToLeft : I
      //   1768: invokevirtual getResourceId : (II)I
      //   1771: putfield rightToLeft : I
      //   1774: aload_0
      //   1775: getfield rightToLeft : I
      //   1778: iconst_m1
      //   1779: if_icmpne -> 2034
      //   1782: aload_0
      //   1783: aload_1
      //   1784: iload #5
      //   1786: iconst_m1
      //   1787: invokevirtual getInt : (II)I
      //   1790: putfield rightToLeft : I
      //   1793: goto -> 2034
      //   1796: aload_0
      //   1797: aload_1
      //   1798: iload #5
      //   1800: aload_0
      //   1801: getfield leftToRight : I
      //   1804: invokevirtual getResourceId : (II)I
      //   1807: putfield leftToRight : I
      //   1810: aload_0
      //   1811: getfield leftToRight : I
      //   1814: iconst_m1
      //   1815: if_icmpne -> 2034
      //   1818: aload_0
      //   1819: aload_1
      //   1820: iload #5
      //   1822: iconst_m1
      //   1823: invokevirtual getInt : (II)I
      //   1826: putfield leftToRight : I
      //   1829: goto -> 2034
      //   1832: aload_0
      //   1833: aload_1
      //   1834: iload #5
      //   1836: aload_0
      //   1837: getfield leftToLeft : I
      //   1840: invokevirtual getResourceId : (II)I
      //   1843: putfield leftToLeft : I
      //   1846: aload_0
      //   1847: getfield leftToLeft : I
      //   1850: iconst_m1
      //   1851: if_icmpne -> 2034
      //   1854: aload_0
      //   1855: aload_1
      //   1856: iload #5
      //   1858: iconst_m1
      //   1859: invokevirtual getInt : (II)I
      //   1862: putfield leftToLeft : I
      //   1865: goto -> 2034
      //   1868: aload_0
      //   1869: aload_1
      //   1870: iload #5
      //   1872: aload_0
      //   1873: getfield guidePercent : F
      //   1876: invokevirtual getFloat : (IF)F
      //   1879: putfield guidePercent : F
      //   1882: goto -> 2034
      //   1885: aload_0
      //   1886: aload_1
      //   1887: iload #5
      //   1889: aload_0
      //   1890: getfield guideEnd : I
      //   1893: invokevirtual getDimensionPixelOffset : (II)I
      //   1896: putfield guideEnd : I
      //   1899: goto -> 2034
      //   1902: aload_0
      //   1903: aload_1
      //   1904: iload #5
      //   1906: aload_0
      //   1907: getfield guideBegin : I
      //   1910: invokevirtual getDimensionPixelOffset : (II)I
      //   1913: putfield guideBegin : I
      //   1916: goto -> 2034
      //   1919: aload_0
      //   1920: aload_1
      //   1921: iload #5
      //   1923: aload_0
      //   1924: getfield circleAngle : F
      //   1927: invokevirtual getFloat : (IF)F
      //   1930: ldc_w 360.0
      //   1933: frem
      //   1934: putfield circleAngle : F
      //   1937: aload_0
      //   1938: getfield circleAngle : F
      //   1941: fstore #9
      //   1943: fload #9
      //   1945: fconst_0
      //   1946: fcmpg
      //   1947: ifge -> 2034
      //   1950: aload_0
      //   1951: ldc_w 360.0
      //   1954: fload #9
      //   1956: fsub
      //   1957: ldc_w 360.0
      //   1960: frem
      //   1961: putfield circleAngle : F
      //   1964: goto -> 2034
      //   1967: aload_0
      //   1968: aload_1
      //   1969: iload #5
      //   1971: aload_0
      //   1972: getfield circleRadius : I
      //   1975: invokevirtual getDimensionPixelSize : (II)I
      //   1978: putfield circleRadius : I
      //   1981: goto -> 2034
      //   1984: aload_0
      //   1985: aload_1
      //   1986: iload #5
      //   1988: aload_0
      //   1989: getfield circleConstraint : I
      //   1992: invokevirtual getResourceId : (II)I
      //   1995: putfield circleConstraint : I
      //   1998: aload_0
      //   1999: getfield circleConstraint : I
      //   2002: iconst_m1
      //   2003: if_icmpne -> 2034
      //   2006: aload_0
      //   2007: aload_1
      //   2008: iload #5
      //   2010: iconst_m1
      //   2011: invokevirtual getInt : (II)I
      //   2014: putfield circleConstraint : I
      //   2017: goto -> 2034
      //   2020: aload_0
      //   2021: aload_1
      //   2022: iload #5
      //   2024: aload_0
      //   2025: getfield orientation : I
      //   2028: invokevirtual getInt : (II)I
      //   2031: putfield orientation : I
      //   2034: iinc #4, 1
      //   2037: goto -> 345
      //   2040: aload_1
      //   2041: invokevirtual recycle : ()V
      //   2044: aload_0
      //   2045: invokevirtual validate : ()V
      //   2048: return
      //   2049: astore_2
      //   2050: goto -> 2034
      // Exception table:
      //   from	to	target	type
      //   863	876	2049	java/lang/NumberFormatException
      //   890	910	2049	java/lang/NumberFormatException
      //   913	925	2049	java/lang/NumberFormatException
      //   945	953	2049	java/lang/NumberFormatException
      //   977	991	994	java/lang/Exception
      //   1019	1033	1036	java/lang/Exception
      //   1082	1096	1099	java/lang/Exception
      //   1124	1138	1141	java/lang/Exception
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
      this.guideBegin = param1LayoutParams.guideBegin;
      this.guideEnd = param1LayoutParams.guideEnd;
      this.guidePercent = param1LayoutParams.guidePercent;
      this.leftToLeft = param1LayoutParams.leftToLeft;
      this.leftToRight = param1LayoutParams.leftToRight;
      this.rightToLeft = param1LayoutParams.rightToLeft;
      this.rightToRight = param1LayoutParams.rightToRight;
      this.topToTop = param1LayoutParams.topToTop;
      this.topToBottom = param1LayoutParams.topToBottom;
      this.bottomToTop = param1LayoutParams.bottomToTop;
      this.bottomToBottom = param1LayoutParams.bottomToBottom;
      this.baselineToBaseline = param1LayoutParams.baselineToBaseline;
      this.circleConstraint = param1LayoutParams.circleConstraint;
      this.circleRadius = param1LayoutParams.circleRadius;
      this.circleAngle = param1LayoutParams.circleAngle;
      this.startToEnd = param1LayoutParams.startToEnd;
      this.startToStart = param1LayoutParams.startToStart;
      this.endToStart = param1LayoutParams.endToStart;
      this.endToEnd = param1LayoutParams.endToEnd;
      this.goneLeftMargin = param1LayoutParams.goneLeftMargin;
      this.goneTopMargin = param1LayoutParams.goneTopMargin;
      this.goneRightMargin = param1LayoutParams.goneRightMargin;
      this.goneBottomMargin = param1LayoutParams.goneBottomMargin;
      this.goneStartMargin = param1LayoutParams.goneStartMargin;
      this.goneEndMargin = param1LayoutParams.goneEndMargin;
      this.horizontalBias = param1LayoutParams.horizontalBias;
      this.verticalBias = param1LayoutParams.verticalBias;
      this.dimensionRatio = param1LayoutParams.dimensionRatio;
      this.dimensionRatioValue = param1LayoutParams.dimensionRatioValue;
      this.dimensionRatioSide = param1LayoutParams.dimensionRatioSide;
      this.horizontalWeight = param1LayoutParams.horizontalWeight;
      this.verticalWeight = param1LayoutParams.verticalWeight;
      this.horizontalChainStyle = param1LayoutParams.horizontalChainStyle;
      this.verticalChainStyle = param1LayoutParams.verticalChainStyle;
      this.constrainedWidth = param1LayoutParams.constrainedWidth;
      this.constrainedHeight = param1LayoutParams.constrainedHeight;
      this.matchConstraintDefaultWidth = param1LayoutParams.matchConstraintDefaultWidth;
      this.matchConstraintDefaultHeight = param1LayoutParams.matchConstraintDefaultHeight;
      this.matchConstraintMinWidth = param1LayoutParams.matchConstraintMinWidth;
      this.matchConstraintMaxWidth = param1LayoutParams.matchConstraintMaxWidth;
      this.matchConstraintMinHeight = param1LayoutParams.matchConstraintMinHeight;
      this.matchConstraintMaxHeight = param1LayoutParams.matchConstraintMaxHeight;
      this.matchConstraintPercentWidth = param1LayoutParams.matchConstraintPercentWidth;
      this.matchConstraintPercentHeight = param1LayoutParams.matchConstraintPercentHeight;
      this.editorAbsoluteX = param1LayoutParams.editorAbsoluteX;
      this.editorAbsoluteY = param1LayoutParams.editorAbsoluteY;
      this.orientation = param1LayoutParams.orientation;
      this.horizontalDimensionFixed = param1LayoutParams.horizontalDimensionFixed;
      this.verticalDimensionFixed = param1LayoutParams.verticalDimensionFixed;
      this.needsBaseline = param1LayoutParams.needsBaseline;
      this.isGuideline = param1LayoutParams.isGuideline;
      this.resolvedLeftToLeft = param1LayoutParams.resolvedLeftToLeft;
      this.resolvedLeftToRight = param1LayoutParams.resolvedLeftToRight;
      this.resolvedRightToLeft = param1LayoutParams.resolvedRightToLeft;
      this.resolvedRightToRight = param1LayoutParams.resolvedRightToRight;
      this.resolveGoneLeftMargin = param1LayoutParams.resolveGoneLeftMargin;
      this.resolveGoneRightMargin = param1LayoutParams.resolveGoneRightMargin;
      this.resolvedHorizontalBias = param1LayoutParams.resolvedHorizontalBias;
      this.widget = param1LayoutParams.widget;
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public void reset() {
      ConstraintWidget constraintWidget = this.widget;
      if (constraintWidget != null)
        constraintWidget.reset(); 
    }
    
    @TargetApi(17)
    public void resolveLayoutDirection(int param1Int) {
      int i = this.leftMargin;
      int j = this.rightMargin;
      super.resolveLayoutDirection(param1Int);
      this.resolvedRightToLeft = -1;
      this.resolvedRightToRight = -1;
      this.resolvedLeftToLeft = -1;
      this.resolvedLeftToRight = -1;
      this.resolveGoneLeftMargin = -1;
      this.resolveGoneRightMargin = -1;
      this.resolveGoneLeftMargin = this.goneLeftMargin;
      this.resolveGoneRightMargin = this.goneRightMargin;
      this.resolvedHorizontalBias = this.horizontalBias;
      this.resolvedGuideBegin = this.guideBegin;
      this.resolvedGuideEnd = this.guideEnd;
      this.resolvedGuidePercent = this.guidePercent;
      param1Int = getLayoutDirection();
      int k = 0;
      if (1 == param1Int) {
        param1Int = 1;
      } else {
        param1Int = 0;
      } 
      if (param1Int != 0) {
        param1Int = this.startToEnd;
        if (param1Int != -1) {
          this.resolvedRightToLeft = param1Int;
          param1Int = 1;
        } else {
          int m = this.startToStart;
          param1Int = k;
          if (m != -1) {
            this.resolvedRightToRight = m;
            param1Int = 1;
          } 
        } 
        k = this.endToStart;
        if (k != -1) {
          this.resolvedLeftToRight = k;
          param1Int = 1;
        } 
        k = this.endToEnd;
        if (k != -1) {
          this.resolvedLeftToLeft = k;
          param1Int = 1;
        } 
        k = this.goneStartMargin;
        if (k != -1)
          this.resolveGoneRightMargin = k; 
        k = this.goneEndMargin;
        if (k != -1)
          this.resolveGoneLeftMargin = k; 
        if (param1Int != 0)
          this.resolvedHorizontalBias = 1.0F - this.horizontalBias; 
        if (this.isGuideline && this.orientation == 1) {
          float f = this.guidePercent;
          if (f != -1.0F) {
            this.resolvedGuidePercent = 1.0F - f;
            this.resolvedGuideBegin = -1;
            this.resolvedGuideEnd = -1;
          } else {
            param1Int = this.guideBegin;
            if (param1Int != -1) {
              this.resolvedGuideEnd = param1Int;
              this.resolvedGuideBegin = -1;
              this.resolvedGuidePercent = -1.0F;
            } else {
              param1Int = this.guideEnd;
              if (param1Int != -1) {
                this.resolvedGuideBegin = param1Int;
                this.resolvedGuideEnd = -1;
                this.resolvedGuidePercent = -1.0F;
              } 
            } 
          } 
        } 
      } else {
        param1Int = this.startToEnd;
        if (param1Int != -1)
          this.resolvedLeftToRight = param1Int; 
        param1Int = this.startToStart;
        if (param1Int != -1)
          this.resolvedLeftToLeft = param1Int; 
        param1Int = this.endToStart;
        if (param1Int != -1)
          this.resolvedRightToLeft = param1Int; 
        param1Int = this.endToEnd;
        if (param1Int != -1)
          this.resolvedRightToRight = param1Int; 
        param1Int = this.goneStartMargin;
        if (param1Int != -1)
          this.resolveGoneLeftMargin = param1Int; 
        param1Int = this.goneEndMargin;
        if (param1Int != -1)
          this.resolveGoneRightMargin = param1Int; 
      } 
      if (this.endToStart == -1 && this.endToEnd == -1 && this.startToStart == -1 && this.startToEnd == -1) {
        param1Int = this.rightToLeft;
        if (param1Int != -1) {
          this.resolvedRightToLeft = param1Int;
          if (this.rightMargin <= 0 && j > 0)
            this.rightMargin = j; 
        } else {
          param1Int = this.rightToRight;
          if (param1Int != -1) {
            this.resolvedRightToRight = param1Int;
            if (this.rightMargin <= 0 && j > 0)
              this.rightMargin = j; 
          } 
        } 
        param1Int = this.leftToLeft;
        if (param1Int != -1) {
          this.resolvedLeftToLeft = param1Int;
          if (this.leftMargin <= 0 && i > 0)
            this.leftMargin = i; 
        } else {
          param1Int = this.leftToRight;
          if (param1Int != -1) {
            this.resolvedLeftToRight = param1Int;
            if (this.leftMargin <= 0 && i > 0)
              this.leftMargin = i; 
          } 
        } 
      } 
    }
    
    public void validate() {
      this.isGuideline = false;
      this.horizontalDimensionFixed = true;
      this.verticalDimensionFixed = true;
      if (this.width == -2 && this.constrainedWidth) {
        this.horizontalDimensionFixed = false;
        this.matchConstraintDefaultWidth = 1;
      } 
      if (this.height == -2 && this.constrainedHeight) {
        this.verticalDimensionFixed = false;
        this.matchConstraintDefaultHeight = 1;
      } 
      if (this.width == 0 || this.width == -1) {
        this.horizontalDimensionFixed = false;
        if (this.width == 0 && this.matchConstraintDefaultWidth == 1) {
          this.width = -2;
          this.constrainedWidth = true;
        } 
      } 
      if (this.height == 0 || this.height == -1) {
        this.verticalDimensionFixed = false;
        if (this.height == 0 && this.matchConstraintDefaultHeight == 1) {
          this.height = -2;
          this.constrainedHeight = true;
        } 
      } 
      if (this.guidePercent != -1.0F || this.guideBegin != -1 || this.guideEnd != -1) {
        this.isGuideline = true;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        if (!(this.widget instanceof Guideline))
          this.widget = (ConstraintWidget)new Guideline(); 
        ((Guideline)this.widget).setOrientation(this.orientation);
      } 
    }
    
    private static class Table {
      public static final int ANDROID_ORIENTATION = 1;
      
      public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
      
      public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
      
      public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
      
      public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
      
      public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
      
      public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
      
      public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
      
      public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
      
      public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
      
      public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
      
      public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
      
      public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
      
      public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
      
      public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
      
      public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
      
      public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
      
      public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
      
      public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
      
      public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
      
      public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
      
      public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
      
      public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
      
      public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
      
      public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
      
      public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
      
      public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
      
      public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
      
      public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
      
      public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
      
      public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
      
      public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
      
      public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
      
      public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
      
      public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
      
      public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
      
      public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
      
      public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
      
      public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
      
      public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
      
      public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
      
      public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
      
      public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
      
      public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
      
      public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
      
      public static final int LAYOUT_GONE_MARGIN_END = 26;
      
      public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
      
      public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
      
      public static final int LAYOUT_GONE_MARGIN_START = 25;
      
      public static final int LAYOUT_GONE_MARGIN_TOP = 22;
      
      public static final int UNUSED = 0;
      
      public static final SparseIntArray map = new SparseIntArray();
      
      static {
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
        map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
        map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
        map.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
      }
    }
  }
  
  private static class Table {
    public static final int ANDROID_ORIENTATION = 1;
    
    public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
    
    public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
    
    public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
    
    public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
    
    public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
    
    public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
    
    public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
    
    public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
    
    public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
    
    public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
    
    public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
    
    public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
    
    public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
    
    public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
    
    public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
    
    public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
    
    public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
    
    public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
    
    public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
    
    public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
    
    public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
    
    public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
    
    public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
    
    public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
    
    public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
    
    public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
    
    public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
    
    public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
    
    public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
    
    public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
    
    public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
    
    public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
    
    public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
    
    public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
    
    public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
    
    public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
    
    public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
    
    public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
    
    public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
    
    public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
    
    public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
    
    public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
    
    public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
    
    public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
    
    public static final int LAYOUT_GONE_MARGIN_END = 26;
    
    public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
    
    public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
    
    public static final int LAYOUT_GONE_MARGIN_START = 25;
    
    public static final int LAYOUT_GONE_MARGIN_TOP = 22;
    
    public static final int UNUSED = 0;
    
    public static final SparseIntArray map = new SparseIntArray();
    
    static {
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
      map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
      map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
      map.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
      map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
      map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
      map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
      map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
      map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
      map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\constraint\ConstraintLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */