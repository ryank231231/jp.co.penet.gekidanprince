package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearLayoutCompat extends ViewGroup {
  public static final int HORIZONTAL = 0;
  
  private static final int INDEX_BOTTOM = 2;
  
  private static final int INDEX_CENTER_VERTICAL = 0;
  
  private static final int INDEX_FILL = 3;
  
  private static final int INDEX_TOP = 1;
  
  public static final int SHOW_DIVIDER_BEGINNING = 1;
  
  public static final int SHOW_DIVIDER_END = 4;
  
  public static final int SHOW_DIVIDER_MIDDLE = 2;
  
  public static final int SHOW_DIVIDER_NONE = 0;
  
  public static final int VERTICAL = 1;
  
  private static final int VERTICAL_GRAVITY_COUNT = 4;
  
  private boolean mBaselineAligned = true;
  
  private int mBaselineAlignedChildIndex = -1;
  
  private int mBaselineChildTop = 0;
  
  private Drawable mDivider;
  
  private int mDividerHeight;
  
  private int mDividerPadding;
  
  private int mDividerWidth;
  
  private int mGravity = 8388659;
  
  private int[] mMaxAscent;
  
  private int[] mMaxDescent;
  
  private int mOrientation;
  
  private int mShowDividers;
  
  private int mTotalLength;
  
  private boolean mUseLargestChild;
  
  private float mWeightSum;
  
  public LinearLayoutCompat(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.LinearLayoutCompat, paramInt, 0);
    paramInt = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
    if (paramInt >= 0)
      setOrientation(paramInt); 
    paramInt = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
    if (paramInt >= 0)
      setGravity(paramInt); 
    boolean bool = tintTypedArray.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool)
      setBaselineAligned(bool); 
    this.mWeightSum = tintTypedArray.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0F);
    this.mBaselineAlignedChildIndex = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    this.mUseLargestChild = tintTypedArray.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
    setDividerDrawable(tintTypedArray.getDrawable(R.styleable.LinearLayoutCompat_divider));
    this.mShowDividers = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
    this.mDividerPadding = tintTypedArray.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
    tintTypedArray.recycle();
  }
  
  private void forceUniformHeight(int paramInt1, int paramInt2) {
    int i = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
    for (byte b = 0; b < paramInt1; b++) {
      View view = getVirtualChildAt(b);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.height == -1) {
          int j = layoutParams.width;
          layoutParams.width = view.getMeasuredWidth();
          measureChildWithMargins(view, paramInt2, 0, i, 0);
          layoutParams.width = j;
        } 
      } 
    } 
  }
  
  private void forceUniformWidth(int paramInt1, int paramInt2) {
    int i = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    for (byte b = 0; b < paramInt1; b++) {
      View view = getVirtualChildAt(b);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.width == -1) {
          int j = layoutParams.height;
          layoutParams.height = view.getMeasuredHeight();
          measureChildWithMargins(view, i, 0, paramInt2, 0);
          layoutParams.height = j;
        } 
      } 
    } 
  }
  
  private void setChildFrame(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramView.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  void drawDividersHorizontal(Canvas paramCanvas) {
    int i = getVirtualChildCount();
    boolean bool = ViewUtils.isLayoutRtl((View)this);
    int j;
    for (j = 0; j < i; j++) {
      View view = getVirtualChildAt(j);
      if (view != null && view.getVisibility() != 8 && hasDividerBeforeChildAt(j)) {
        int k;
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (bool) {
          k = view.getRight() + layoutParams.rightMargin;
        } else {
          k = view.getLeft() - layoutParams.leftMargin - this.mDividerWidth;
        } 
        drawVerticalDivider(paramCanvas, k);
      } 
    } 
    if (hasDividerBeforeChildAt(i)) {
      View view = getVirtualChildAt(i - 1);
      if (view == null) {
        if (bool) {
          j = getPaddingLeft();
        } else {
          j = getWidth() - getPaddingRight() - this.mDividerWidth;
        } 
      } else {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (bool) {
          j = view.getLeft() - layoutParams.leftMargin - this.mDividerWidth;
        } else {
          j = view.getRight() + layoutParams.rightMargin;
        } 
      } 
      drawVerticalDivider(paramCanvas, j);
    } 
  }
  
  void drawDividersVertical(Canvas paramCanvas) {
    int i = getVirtualChildCount();
    int j;
    for (j = 0; j < i; j++) {
      View view = getVirtualChildAt(j);
      if (view != null && view.getVisibility() != 8 && hasDividerBeforeChildAt(j)) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        drawHorizontalDivider(paramCanvas, view.getTop() - layoutParams.topMargin - this.mDividerHeight);
      } 
    } 
    if (hasDividerBeforeChildAt(i)) {
      View view = getVirtualChildAt(i - 1);
      if (view == null) {
        j = getHeight() - getPaddingBottom() - this.mDividerHeight;
      } else {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        j = view.getBottom() + layoutParams.bottomMargin;
      } 
      drawHorizontalDivider(paramCanvas, j);
    } 
  }
  
  void drawHorizontalDivider(Canvas paramCanvas, int paramInt) {
    this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, paramInt, getWidth() - getPaddingRight() - this.mDividerPadding, this.mDividerHeight + paramInt);
    this.mDivider.draw(paramCanvas);
  }
  
  void drawVerticalDivider(Canvas paramCanvas, int paramInt) {
    this.mDivider.setBounds(paramInt, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + paramInt, getHeight() - getPaddingBottom() - this.mDividerPadding);
    this.mDivider.draw(paramCanvas);
  }
  
  protected LayoutParams generateDefaultLayoutParams() {
    int i = this.mOrientation;
    return (i == 0) ? new LayoutParams(-2, -2) : ((i == 1) ? new LayoutParams(-1, -2) : null);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getBaseline() {
    if (this.mBaselineAlignedChildIndex < 0)
      return super.getBaseline(); 
    int i = getChildCount();
    int j = this.mBaselineAlignedChildIndex;
    if (i > j) {
      View view = getChildAt(j);
      int k = view.getBaseline();
      if (k == -1) {
        if (this.mBaselineAlignedChildIndex == 0)
          return -1; 
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
      } 
      i = this.mBaselineChildTop;
      j = i;
      if (this.mOrientation == 1) {
        int m = this.mGravity & 0x70;
        j = i;
        if (m != 48)
          if (m != 16) {
            if (m != 80) {
              j = i;
            } else {
              j = getBottom() - getTop() - getPaddingBottom() - this.mTotalLength;
            } 
          } else {
            j = i + (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - this.mTotalLength) / 2;
          }  
      } 
      return j + ((LayoutParams)view.getLayoutParams()).topMargin + k;
    } 
    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
  }
  
  public int getBaselineAlignedChildIndex() {
    return this.mBaselineAlignedChildIndex;
  }
  
  int getChildrenSkipCount(View paramView, int paramInt) {
    return 0;
  }
  
  public Drawable getDividerDrawable() {
    return this.mDivider;
  }
  
  public int getDividerPadding() {
    return this.mDividerPadding;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public int getDividerWidth() {
    return this.mDividerWidth;
  }
  
  public int getGravity() {
    return this.mGravity;
  }
  
  int getLocationOffset(View paramView) {
    return 0;
  }
  
  int getNextLocationOffset(View paramView) {
    return 0;
  }
  
  public int getOrientation() {
    return this.mOrientation;
  }
  
  public int getShowDividers() {
    return this.mShowDividers;
  }
  
  View getVirtualChildAt(int paramInt) {
    return getChildAt(paramInt);
  }
  
  int getVirtualChildCount() {
    return getChildCount();
  }
  
  public float getWeightSum() {
    return this.mWeightSum;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY})
  protected boolean hasDividerBeforeChildAt(int paramInt) {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramInt == 0) {
      if ((this.mShowDividers & 0x1) != 0)
        bool3 = true; 
      return bool3;
    } 
    if (paramInt == getChildCount()) {
      bool3 = bool1;
      if ((this.mShowDividers & 0x4) != 0)
        bool3 = true; 
      return bool3;
    } 
    if ((this.mShowDividers & 0x2) != 0) {
      paramInt--;
      while (true) {
        bool3 = bool2;
        if (paramInt >= 0) {
          if (getChildAt(paramInt).getVisibility() != 8) {
            bool3 = true;
            break;
          } 
          paramInt--;
          continue;
        } 
        break;
      } 
      return bool3;
    } 
    return false;
  }
  
  public boolean isBaselineAligned() {
    return this.mBaselineAligned;
  }
  
  public boolean isMeasureWithLargestChildEnabled() {
    return this.mUseLargestChild;
  }
  
  void layoutHorizontal(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    byte b1;
    byte b2;
    boolean bool1 = ViewUtils.isLayoutRtl((View)this);
    int i = getPaddingTop();
    int j = paramInt4 - paramInt2;
    int k = getPaddingBottom();
    int m = getPaddingBottom();
    int n = getVirtualChildCount();
    paramInt4 = this.mGravity;
    paramInt2 = paramInt4 & 0x70;
    boolean bool2 = this.mBaselineAligned;
    int[] arrayOfInt1 = this.mMaxAscent;
    int[] arrayOfInt2 = this.mMaxDescent;
    paramInt4 = GravityCompat.getAbsoluteGravity(0x800007 & paramInt4, ViewCompat.getLayoutDirection((View)this));
    if (paramInt4 != 1) {
      if (paramInt4 != 5) {
        paramInt1 = getPaddingLeft();
      } else {
        paramInt1 = getPaddingLeft() + paramInt3 - paramInt1 - this.mTotalLength;
      } 
    } else {
      paramInt1 = getPaddingLeft() + (paramInt3 - paramInt1 - this.mTotalLength) / 2;
    } 
    if (bool1) {
      b1 = n - 1;
      b2 = -1;
    } else {
      b1 = 0;
      b2 = 1;
    } 
    paramInt4 = 0;
    paramInt3 = i;
    int i1 = paramInt1;
    while (paramInt4 < n) {
      int i2 = b1 + b2 * paramInt4;
      View view = getVirtualChildAt(i2);
      if (view == null) {
        i1 += measureNullChild(i2);
      } else if (view.getVisibility() != 8) {
        int i3 = view.getMeasuredWidth();
        int i4 = view.getMeasuredHeight();
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (bool2 && layoutParams.height != -1) {
          paramInt1 = view.getBaseline();
        } else {
          paramInt1 = -1;
        } 
        int i5 = layoutParams.gravity;
        int i6 = i5;
        if (i5 < 0)
          i6 = paramInt2; 
        i6 &= 0x70;
        if (i6 != 16) {
          if (i6 != 48) {
            if (i6 != 80) {
              paramInt1 = paramInt3;
            } else {
              i6 = j - k - i4 - layoutParams.bottomMargin;
              if (paramInt1 != -1) {
                i5 = view.getMeasuredHeight();
                paramInt1 = i6 - arrayOfInt2[2] - i5 - paramInt1;
              } else {
                paramInt1 = i6;
              } 
            } 
          } else {
            i6 = layoutParams.topMargin + paramInt3;
            if (paramInt1 != -1) {
              paramInt1 = i6 + arrayOfInt1[1] - paramInt1;
            } else {
              paramInt1 = i6;
            } 
          } 
        } else {
          paramInt1 = (j - i - m - i4) / 2 + paramInt3 + layoutParams.topMargin - layoutParams.bottomMargin;
        } 
        i6 = i1;
        if (hasDividerBeforeChildAt(i2))
          i6 = i1 + this.mDividerWidth; 
        i1 = layoutParams.leftMargin + i6;
        setChildFrame(view, i1 + getLocationOffset(view), paramInt1, i3, i4);
        i6 = layoutParams.rightMargin;
        paramInt1 = getNextLocationOffset(view);
        paramInt4 += getChildrenSkipCount(view, i2);
        i1 += i3 + i6 + paramInt1;
      } 
      paramInt4++;
    } 
  }
  
  void layoutVertical(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = getPaddingLeft();
    int j = paramInt3 - paramInt1;
    int k = getPaddingRight();
    int m = getPaddingRight();
    int n = getVirtualChildCount();
    int i1 = this.mGravity;
    paramInt1 = i1 & 0x70;
    if (paramInt1 != 16) {
      if (paramInt1 != 80) {
        paramInt1 = getPaddingTop();
      } else {
        paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - this.mTotalLength;
      } 
    } else {
      paramInt1 = getPaddingTop() + (paramInt4 - paramInt2 - this.mTotalLength) / 2;
    } 
    for (paramInt2 = 0; paramInt2 < n; paramInt2++) {
      View view = getVirtualChildAt(paramInt2);
      if (view == null) {
        paramInt1 += measureNullChild(paramInt2);
      } else if (view.getVisibility() != 8) {
        int i2 = view.getMeasuredWidth();
        int i3 = view.getMeasuredHeight();
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        paramInt4 = layoutParams.gravity;
        paramInt3 = paramInt4;
        if (paramInt4 < 0)
          paramInt3 = i1 & 0x800007; 
        paramInt3 = GravityCompat.getAbsoluteGravity(paramInt3, ViewCompat.getLayoutDirection((View)this)) & 0x7;
        if (paramInt3 != 1) {
          if (paramInt3 != 5) {
            paramInt3 = layoutParams.leftMargin + i;
          } else {
            paramInt3 = j - k - i2 - layoutParams.rightMargin;
          } 
        } else {
          paramInt3 = (j - i - m - i2) / 2 + i + layoutParams.leftMargin - layoutParams.rightMargin;
        } 
        paramInt4 = paramInt1;
        if (hasDividerBeforeChildAt(paramInt2))
          paramInt4 = paramInt1 + this.mDividerHeight; 
        paramInt1 = paramInt4 + layoutParams.topMargin;
        setChildFrame(view, paramInt3, paramInt1 + getLocationOffset(view), i2, i3);
        paramInt3 = layoutParams.bottomMargin;
        paramInt4 = getNextLocationOffset(view);
        paramInt2 += getChildrenSkipCount(view, paramInt2);
        paramInt1 += i3 + paramInt3 + paramInt4;
      } 
    } 
  }
  
  void measureChildBeforeLayout(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    measureChildWithMargins(paramView, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  void measureHorizontal(int paramInt1, int paramInt2) {
    boolean bool3;
    this.mTotalLength = 0;
    int i = getVirtualChildCount();
    int j = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    if (this.mMaxAscent == null || this.mMaxDescent == null) {
      this.mMaxAscent = new int[4];
      this.mMaxDescent = new int[4];
    } 
    int[] arrayOfInt1 = this.mMaxAscent;
    int[] arrayOfInt2 = this.mMaxDescent;
    arrayOfInt1[3] = -1;
    arrayOfInt1[2] = -1;
    arrayOfInt1[1] = -1;
    arrayOfInt1[0] = -1;
    arrayOfInt2[3] = -1;
    arrayOfInt2[2] = -1;
    arrayOfInt2[1] = -1;
    arrayOfInt2[0] = -1;
    boolean bool1 = this.mBaselineAligned;
    boolean bool2 = this.mUseLargestChild;
    if (j == 1073741824) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    float f = 0.0F;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 1;
    boolean bool4 = false;
    while (m < i) {
      View view = getVirtualChildAt(m);
      if (view == null) {
        this.mTotalLength += measureNullChild(m);
      } else if (view.getVisibility() == 8) {
        m += getChildrenSkipCount(view, m);
      } else {
        if (hasDividerBeforeChildAt(m))
          this.mTotalLength += this.mDividerWidth; 
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        f += layoutParams.weight;
        if (j == 1073741824 && layoutParams.width == 0 && layoutParams.weight > 0.0F) {
          if (bool3) {
            this.mTotalLength += layoutParams.leftMargin + layoutParams.rightMargin;
          } else {
            int i12 = this.mTotalLength;
            this.mTotalLength = Math.max(i12, layoutParams.leftMargin + i12 + layoutParams.rightMargin);
          } 
          if (bool1) {
            int i12 = View.MeasureSpec.makeMeasureSpec(0, 0);
            view.measure(i12, i12);
          } else {
            i4 = 1;
          } 
        } else {
          int i13;
          if (layoutParams.width == 0 && layoutParams.weight > 0.0F) {
            layoutParams.width = -2;
            i12 = 0;
          } else {
            i12 = Integer.MIN_VALUE;
          } 
          if (f == 0.0F) {
            i13 = this.mTotalLength;
          } else {
            i13 = 0;
          } 
          measureChildBeforeLayout(view, m, paramInt1, i13, paramInt2, 0);
          if (i12 != Integer.MIN_VALUE)
            layoutParams.width = i12; 
          int i12 = view.getMeasuredWidth();
          if (bool3) {
            this.mTotalLength += layoutParams.leftMargin + i12 + layoutParams.rightMargin + getNextLocationOffset(view);
          } else {
            i13 = this.mTotalLength;
            this.mTotalLength = Math.max(i13, i13 + i12 + layoutParams.leftMargin + layoutParams.rightMargin + getNextLocationOffset(view));
          } 
          if (bool2)
            n = Math.max(i12, n); 
        } 
        int i8 = m;
        if (k != 1073741824 && layoutParams.height == -1) {
          m = 1;
          bool4 = true;
        } else {
          m = 0;
        } 
        int i9 = layoutParams.topMargin + layoutParams.bottomMargin;
        int i10 = view.getMeasuredHeight() + i9;
        int i11 = View.combineMeasuredStates(i5, view.getMeasuredState());
        if (bool1) {
          int i12 = view.getBaseline();
          if (i12 != -1) {
            if (layoutParams.gravity < 0) {
              i5 = this.mGravity;
            } else {
              i5 = layoutParams.gravity;
            } 
            i5 = ((i5 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
            arrayOfInt1[i5] = Math.max(arrayOfInt1[i5], i12);
            arrayOfInt2[i5] = Math.max(arrayOfInt2[i5], i10 - i12);
          } 
        } 
        i1 = Math.max(i1, i10);
        if (i6 && layoutParams.height == -1) {
          i6 = 1;
        } else {
          i6 = 0;
        } 
        if (layoutParams.weight > 0.0F) {
          if (m == 0)
            i9 = i10; 
          m = Math.max(i3, i9);
        } else {
          if (m != 0)
            i10 = i9; 
          i2 = Math.max(i2, i10);
          m = i3;
        } 
        i3 = getChildrenSkipCount(view, i8);
        i5 = i11;
        i8 = i3 + i8;
        i3 = m;
        m = i8;
      } 
      m++;
    } 
    m = i1;
    if (this.mTotalLength > 0 && hasDividerBeforeChildAt(i))
      this.mTotalLength += this.mDividerWidth; 
    if (arrayOfInt1[1] != -1 || arrayOfInt1[0] != -1 || arrayOfInt1[2] != -1 || arrayOfInt1[3] != -1)
      m = Math.max(m, Math.max(arrayOfInt1[3], Math.max(arrayOfInt1[0], Math.max(arrayOfInt1[1], arrayOfInt1[2]))) + Math.max(arrayOfInt2[3], Math.max(arrayOfInt2[0], Math.max(arrayOfInt2[1], arrayOfInt2[2])))); 
    if (bool2 && (j == Integer.MIN_VALUE || j == 0)) {
      this.mTotalLength = 0;
      for (i1 = 0; i1 < i; i1++) {
        View view = getVirtualChildAt(i1);
        if (view == null) {
          this.mTotalLength += measureNullChild(i1);
        } else if (view.getVisibility() == 8) {
          i1 += getChildrenSkipCount(view, i1);
        } else {
          LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
          if (bool3) {
            this.mTotalLength += layoutParams.leftMargin + n + layoutParams.rightMargin + getNextLocationOffset(view);
          } else {
            int i8 = this.mTotalLength;
            this.mTotalLength = Math.max(i8, i8 + n + layoutParams.leftMargin + layoutParams.rightMargin + getNextLocationOffset(view));
          } 
        } 
      } 
    } 
    this.mTotalLength += getPaddingLeft() + getPaddingRight();
    int i7 = View.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumWidth()), paramInt1, 0);
    i1 = (0xFFFFFF & i7) - this.mTotalLength;
    if (i4 || (i1 != 0 && f > 0.0F)) {
      float f1 = this.mWeightSum;
      if (f1 > 0.0F)
        f = f1; 
      arrayOfInt1[3] = -1;
      arrayOfInt1[2] = -1;
      arrayOfInt1[1] = -1;
      arrayOfInt1[0] = -1;
      arrayOfInt2[3] = -1;
      arrayOfInt2[2] = -1;
      arrayOfInt2[1] = -1;
      arrayOfInt2[0] = -1;
      this.mTotalLength = 0;
      i4 = i2;
      i2 = i5;
      n = -1;
      i5 = 0;
      i3 = i6;
      m = i;
      i6 = i1;
      for (i1 = i5; i1 < m; i1++) {
        View view = getVirtualChildAt(i1);
        if (view != null && view.getVisibility() != 8) {
          LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
          f1 = layoutParams.weight;
          if (f1 > 0.0F) {
            i = (int)(i6 * f1 / f);
            int i10 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height);
            if (layoutParams.width != 0 || j != 1073741824) {
              int i11 = view.getMeasuredWidth() + i;
              i5 = i11;
              if (i11 < 0)
                i5 = 0; 
              view.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), i10);
            } else {
              if (i > 0) {
                i5 = i;
              } else {
                i5 = 0;
              } 
              view.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), i10);
            } 
            i2 = View.combineMeasuredStates(i2, view.getMeasuredState() & 0xFF000000);
            f -= f1;
            i6 -= i;
          } 
          if (bool3) {
            this.mTotalLength += view.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin + getNextLocationOffset(view);
          } else {
            i5 = this.mTotalLength;
            this.mTotalLength = Math.max(i5, view.getMeasuredWidth() + i5 + layoutParams.leftMargin + layoutParams.rightMargin + getNextLocationOffset(view));
          } 
          if (k != 1073741824 && layoutParams.height == -1) {
            i5 = 1;
          } else {
            i5 = 0;
          } 
          int i9 = layoutParams.topMargin + layoutParams.bottomMargin;
          int i8 = view.getMeasuredHeight() + i9;
          i = Math.max(n, i8);
          if (i5 != 0) {
            n = i9;
          } else {
            n = i8;
          } 
          n = Math.max(i4, n);
          if (i3 != 0 && layoutParams.height == -1) {
            i3 = 1;
          } else {
            i3 = 0;
          } 
          if (bool1) {
            i5 = view.getBaseline();
            if (i5 != -1) {
              if (layoutParams.gravity < 0) {
                i4 = this.mGravity;
              } else {
                i4 = layoutParams.gravity;
              } 
              i4 = ((i4 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
              arrayOfInt1[i4] = Math.max(arrayOfInt1[i4], i5);
              arrayOfInt2[i4] = Math.max(arrayOfInt2[i4], i8 - i5);
            } 
          } 
          i4 = n;
          n = i;
        } 
      } 
      this.mTotalLength += getPaddingLeft() + getPaddingRight();
      if (arrayOfInt1[1] != -1 || arrayOfInt1[0] != -1 || arrayOfInt1[2] != -1 || arrayOfInt1[3] != -1) {
        i6 = Math.max(n, Math.max(arrayOfInt1[3], Math.max(arrayOfInt1[0], Math.max(arrayOfInt1[1], arrayOfInt1[2]))) + Math.max(arrayOfInt2[3], Math.max(arrayOfInt2[0], Math.max(arrayOfInt2[1], arrayOfInt2[2]))));
      } else {
        i6 = n;
      } 
      i5 = i2;
      i2 = i4;
      i4 = i3;
      i3 = m;
      m = i6;
    } else {
      i4 = Math.max(i2, i3);
      if (bool2 && j != 1073741824)
        for (i2 = 0; i2 < i; i2++) {
          View view = getVirtualChildAt(i2);
          if (view != null && view.getVisibility() != 8 && ((LayoutParams)view.getLayoutParams()).weight > 0.0F)
            view.measure(View.MeasureSpec.makeMeasureSpec(n, 1073741824), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824)); 
        }  
      i3 = i;
      i2 = i4;
      i4 = i6;
    } 
    if (i4 != 0 || k == 1073741824)
      i2 = m; 
    setMeasuredDimension(i7 | i5 & 0xFF000000, View.resolveSizeAndState(Math.max(i2 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), paramInt2, i5 << 16));
    if (bool4)
      forceUniformHeight(i3, paramInt1); 
  }
  
  int measureNullChild(int paramInt) {
    return 0;
  }
  
  void measureVertical(int paramInt1, int paramInt2) {
    this.mTotalLength = 0;
    int i = getVirtualChildCount();
    int j = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int m = this.mBaselineAlignedChildIndex;
    boolean bool = this.mUseLargestChild;
    float f = 0.0F;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i7 = 1;
    boolean bool1 = false;
    while (i5 < i) {
      View view = getVirtualChildAt(i5);
      if (view == null) {
        this.mTotalLength += measureNullChild(i5);
      } else if (view.getVisibility() == 8) {
        i5 += getChildrenSkipCount(view, i5);
      } else {
        if (hasDividerBeforeChildAt(i5))
          this.mTotalLength += this.mDividerHeight; 
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        f += layoutParams.weight;
        if (k == 1073741824 && layoutParams.height == 0 && layoutParams.weight > 0.0F) {
          i6 = this.mTotalLength;
          this.mTotalLength = Math.max(i6, layoutParams.topMargin + i6 + layoutParams.bottomMargin);
          i6 = 1;
        } else {
          if (layoutParams.height == 0 && layoutParams.weight > 0.0F) {
            layoutParams.height = -2;
            i10 = 0;
          } else {
            i10 = Integer.MIN_VALUE;
          } 
          if (f == 0.0F) {
            i11 = this.mTotalLength;
          } else {
            i11 = 0;
          } 
          measureChildBeforeLayout(view, i5, paramInt1, 0, paramInt2, i11);
          if (i10 != Integer.MIN_VALUE)
            layoutParams.height = i10; 
          int i11 = view.getMeasuredHeight();
          int i10 = this.mTotalLength;
          this.mTotalLength = Math.max(i10, i10 + i11 + layoutParams.topMargin + layoutParams.bottomMargin + getNextLocationOffset(view));
          if (bool)
            i2 = Math.max(i11, i2); 
        } 
        int i9 = i5;
        if (m >= 0 && m == i9 + 1)
          this.mBaselineChildTop = this.mTotalLength; 
        if (i9 >= m || layoutParams.weight <= 0.0F) {
          if (j != 1073741824 && layoutParams.width == -1) {
            i5 = 1;
            bool1 = true;
          } else {
            i5 = 0;
          } 
          int i10 = layoutParams.leftMargin + layoutParams.rightMargin;
          int i11 = view.getMeasuredWidth() + i10;
          int i12 = Math.max(i1, i11);
          int i13 = View.combineMeasuredStates(n, view.getMeasuredState());
          if (i7 && layoutParams.width == -1) {
            n = 1;
          } else {
            n = 0;
          } 
          if (layoutParams.weight > 0.0F) {
            if (i5 == 0)
              i10 = i11; 
            i7 = Math.max(i3, i10);
            i3 = i4;
          } else {
            if (i5 == 0)
              i10 = i11; 
            i4 = Math.max(i4, i10);
            i7 = i3;
            i3 = i4;
          } 
          i5 = getChildrenSkipCount(view, i9);
          i4 = n;
          i1 = i7;
          n = i13;
          i5 += i9;
          i10 = i12;
          i7 = i4;
          i4 = i3;
          i3 = i1;
          i1 = i10;
        } else {
          throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
        } 
      } 
      i5++;
    } 
    if (this.mTotalLength > 0 && hasDividerBeforeChildAt(i))
      this.mTotalLength += this.mDividerHeight; 
    if (bool) {
      i5 = k;
      if (i5 == Integer.MIN_VALUE || i5 == 0) {
        this.mTotalLength = 0;
        for (i5 = 0; i5 < i; i5++) {
          View view = getVirtualChildAt(i5);
          if (view == null) {
            this.mTotalLength += measureNullChild(i5);
          } else if (view.getVisibility() == 8) {
            i5 += getChildrenSkipCount(view, i5);
          } else {
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            int i9 = this.mTotalLength;
            this.mTotalLength = Math.max(i9, i9 + i2 + layoutParams.topMargin + layoutParams.bottomMargin + getNextLocationOffset(view));
          } 
        } 
      } 
    } 
    i5 = k;
    this.mTotalLength += getPaddingTop() + getPaddingBottom();
    int i8 = View.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumHeight()), paramInt2, 0);
    k = (0xFFFFFF & i8) - this.mTotalLength;
    if (i6 != 0 || (k != 0 && f > 0.0F)) {
      float f1 = this.mWeightSum;
      if (f1 > 0.0F)
        f = f1; 
      this.mTotalLength = 0;
      i2 = 0;
      i3 = i4;
      i4 = k;
      k = i1;
      while (i2 < i) {
        View view = getVirtualChildAt(i2);
        if (view.getVisibility() != 8) {
          LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
          f1 = layoutParams.weight;
          if (f1 > 0.0F) {
            i1 = (int)(i4 * f1 / f);
            int i11 = getPaddingLeft();
            int i10 = getPaddingRight();
            i6 = i4 - i1;
            i4 = layoutParams.leftMargin;
            int i12 = layoutParams.rightMargin;
            int i13 = layoutParams.width;
            f -= f1;
            i10 = getChildMeasureSpec(paramInt1, i11 + i10 + i4 + i12, i13);
            if (layoutParams.height != 0 || i5 != 1073741824) {
              i1 = view.getMeasuredHeight() + i1;
              i4 = i1;
              if (i1 < 0)
                i4 = 0; 
              view.measure(i10, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
            } else {
              if (i1 > 0) {
                i4 = i1;
              } else {
                i4 = 0;
              } 
              view.measure(i10, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
            } 
            n = View.combineMeasuredStates(n, view.getMeasuredState() & 0xFFFFFF00);
            i4 = i6;
          } 
          int i9 = layoutParams.leftMargin + layoutParams.rightMargin;
          i1 = view.getMeasuredWidth() + i9;
          i6 = Math.max(k, i1);
          if (j != 1073741824 && layoutParams.width == -1) {
            k = 1;
          } else {
            k = 0;
          } 
          if (k != 0) {
            k = i9;
          } else {
            k = i1;
          } 
          k = Math.max(i3, k);
          if (i7 != 0 && layoutParams.width == -1) {
            i3 = 1;
          } else {
            i3 = 0;
          } 
          i7 = this.mTotalLength;
          this.mTotalLength = Math.max(i7, view.getMeasuredHeight() + i7 + layoutParams.topMargin + layoutParams.bottomMargin + getNextLocationOffset(view));
          i7 = i3;
          i3 = k;
          k = i6;
        } 
        i2++;
      } 
      this.mTotalLength += getPaddingTop() + getPaddingBottom();
      i4 = i3;
      i3 = n;
      n = i4;
    } else {
      k = Math.max(i4, i3);
      if (bool && i5 != 1073741824)
        for (i3 = 0; i3 < i; i3++) {
          View view = getVirtualChildAt(i3);
          if (view != null && view.getVisibility() != 8 && ((LayoutParams)view.getLayoutParams()).weight > 0.0F)
            view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824)); 
        }  
      i3 = n;
      n = k;
      k = i1;
    } 
    if (i7 != 0 || j == 1073741824)
      n = k; 
    setMeasuredDimension(View.resolveSizeAndState(Math.max(n + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), paramInt1, i3), i8);
    if (bool1)
      forceUniformWidth(i, paramInt2); 
  }
  
  protected void onDraw(Canvas paramCanvas) {
    if (this.mDivider == null)
      return; 
    if (this.mOrientation == 1) {
      drawDividersVertical(paramCanvas);
    } else {
      drawDividersHorizontal(paramCanvas);
    } 
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.mOrientation == 1) {
      layoutVertical(paramInt1, paramInt2, paramInt3, paramInt4);
    } else {
      layoutHorizontal(paramInt1, paramInt2, paramInt3, paramInt4);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (this.mOrientation == 1) {
      measureVertical(paramInt1, paramInt2);
    } else {
      measureHorizontal(paramInt1, paramInt2);
    } 
  }
  
  public void setBaselineAligned(boolean paramBoolean) {
    this.mBaselineAligned = paramBoolean;
  }
  
  public void setBaselineAlignedChildIndex(int paramInt) {
    if (paramInt >= 0 && paramInt < getChildCount()) {
      this.mBaselineAlignedChildIndex = paramInt;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("base aligned child index out of range (0, ");
    stringBuilder.append(getChildCount());
    stringBuilder.append(")");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void setDividerDrawable(Drawable paramDrawable) {
    if (paramDrawable == this.mDivider)
      return; 
    this.mDivider = paramDrawable;
    boolean bool = false;
    if (paramDrawable != null) {
      this.mDividerWidth = paramDrawable.getIntrinsicWidth();
      this.mDividerHeight = paramDrawable.getIntrinsicHeight();
    } else {
      this.mDividerWidth = 0;
      this.mDividerHeight = 0;
    } 
    if (paramDrawable == null)
      bool = true; 
    setWillNotDraw(bool);
    requestLayout();
  }
  
  public void setDividerPadding(int paramInt) {
    this.mDividerPadding = paramInt;
  }
  
  public void setGravity(int paramInt) {
    if (this.mGravity != paramInt) {
      int i = paramInt;
      if ((0x800007 & paramInt) == 0)
        i = paramInt | 0x800003; 
      paramInt = i;
      if ((i & 0x70) == 0)
        paramInt = i | 0x30; 
      this.mGravity = paramInt;
      requestLayout();
    } 
  }
  
  public void setHorizontalGravity(int paramInt) {
    paramInt &= 0x800007;
    int i = this.mGravity;
    if ((0x800007 & i) != paramInt) {
      this.mGravity = paramInt | 0xFF7FFFF8 & i;
      requestLayout();
    } 
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean) {
    this.mUseLargestChild = paramBoolean;
  }
  
  public void setOrientation(int paramInt) {
    if (this.mOrientation != paramInt) {
      this.mOrientation = paramInt;
      requestLayout();
    } 
  }
  
  public void setShowDividers(int paramInt) {
    if (paramInt != this.mShowDividers)
      requestLayout(); 
    this.mShowDividers = paramInt;
  }
  
  public void setVerticalGravity(int paramInt) {
    paramInt &= 0x70;
    int i = this.mGravity;
    if ((i & 0x70) != paramInt) {
      this.mGravity = paramInt | i & 0xFFFFFF8F;
      requestLayout();
    } 
  }
  
  public void setWeightSum(float paramFloat) {
    this.mWeightSum = Math.max(0.0F, paramFloat);
  }
  
  public boolean shouldDelayChildPressedState() {
    return false;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface DividerMode {}
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    public int gravity = -1;
    
    public float weight;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
      this.weight = 0.0F;
    }
    
    public LayoutParams(int param1Int1, int param1Int2, float param1Float) {
      super(param1Int1, param1Int2);
      this.weight = param1Float;
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, R.styleable.LinearLayoutCompat_Layout);
      this.weight = typedArray.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
      this.gravity = typedArray.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
      typedArray.recycle();
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
      this.weight = param1LayoutParams.weight;
      this.gravity = param1LayoutParams.gravity;
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      super(param1MarginLayoutParams);
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface OrientationMode {}
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\v7\widget\LinearLayoutCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */