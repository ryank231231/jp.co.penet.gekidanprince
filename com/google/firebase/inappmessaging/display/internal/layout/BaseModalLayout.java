package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseModalLayout extends FrameLayout {
  private static final float DEFAULT_MAX_HEIGHT_PCT = -1.0F;
  
  private static final float DEFAULT_MAX_WIDTH_PCT = -1.0F;
  
  private DisplayMetrics mDisplay;
  
  private float mMaxHeightPct;
  
  private float mMaxWidthPct;
  
  private List<View> mVisibleChildren = new ArrayList<View>();
  
  public BaseModalLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.ModalLayout, 0, 0);
    try {
      this.mMaxWidthPct = typedArray.getFloat(R.styleable.ModalLayout_maxWidthPct, -1.0F);
      this.mMaxHeightPct = typedArray.getFloat(R.styleable.ModalLayout_maxHeightPct, -1.0F);
      typedArray.recycle();
      return;
    } finally {
      typedArray.recycle();
    } 
  }
  
  protected int calculateBaseHeight(int paramInt) {
    if (getMaxHeightPct() > 0.0F) {
      Logging.logd("Height: restrict by pct");
      paramInt = roundToNearest((int)((getDisplayMetrics()).heightPixels * getMaxHeightPct()), 4);
    } else {
      Logging.logd("Height: restrict by spec");
      paramInt = View.MeasureSpec.getSize(paramInt);
    } 
    return paramInt;
  }
  
  protected int calculateBaseWidth(int paramInt) {
    if (getMaxWidthPct() > 0.0F) {
      Logging.logd("Width: restrict by pct");
      paramInt = roundToNearest((int)((getDisplayMetrics()).widthPixels * getMaxWidthPct()), 4);
    } else {
      Logging.logd("Width: restrict by spec");
      paramInt = View.MeasureSpec.getSize(paramInt);
    } 
    return paramInt;
  }
  
  protected int dpToPixels(int paramInt) {
    return (int)Math.floor(TypedValue.applyDimension(1, paramInt, this.mDisplay));
  }
  
  @NonNull
  protected View findChildById(@IdRes int paramInt) {
    View view = findViewById(paramInt);
    if (view != null)
      return view; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No such child: ");
    stringBuilder.append(paramInt);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  protected int getDesiredHeight(View paramView) {
    return (paramView.getVisibility() == 8) ? 0 : paramView.getMeasuredHeight();
  }
  
  protected int getDesiredWidth(View paramView) {
    return (paramView.getVisibility() == 8) ? 0 : paramView.getMeasuredWidth();
  }
  
  protected DisplayMetrics getDisplayMetrics() {
    return this.mDisplay;
  }
  
  protected int getHeightWithMargins(View paramView) {
    if (paramView.getVisibility() == 8)
      return 0; 
    FrameLayout.LayoutParams layoutParams = getLayoutParams(paramView);
    return getDesiredHeight(paramView) + layoutParams.topMargin + layoutParams.bottomMargin;
  }
  
  protected FrameLayout.LayoutParams getLayoutParams(View paramView) {
    return (FrameLayout.LayoutParams)paramView.getLayoutParams();
  }
  
  protected int getMarginBottom(View paramView) {
    return (paramView.getVisibility() == 8) ? 0 : (getLayoutParams(paramView)).bottomMargin;
  }
  
  protected int getMarginTop(View paramView) {
    return (paramView.getVisibility() == 8) ? 0 : (getLayoutParams(paramView)).topMargin;
  }
  
  protected float getMaxHeightPct() {
    return this.mMaxHeightPct;
  }
  
  protected float getMaxWidthPct() {
    return this.mMaxWidthPct;
  }
  
  protected List<View> getVisibleChildren() {
    return this.mVisibleChildren;
  }
  
  protected int getWidthWithMargins(View paramView) {
    if (paramView.getVisibility() == 8)
      return 0; 
    FrameLayout.LayoutParams layoutParams = getLayoutParams(paramView);
    return getDesiredWidth(paramView) + layoutParams.leftMargin + layoutParams.rightMargin;
  }
  
  protected void layoutChild(View paramView, int paramInt1, int paramInt2) {
    layoutChild(paramView, paramInt1, paramInt2, paramInt1 + getDesiredWidth(paramView), paramInt2 + getDesiredHeight(paramView));
  }
  
  protected void layoutChild(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Logging.logdPair("\tleft, right", paramInt1, paramInt3);
    Logging.logdPair("\ttop, bottom", paramInt2, paramInt4);
    paramView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Logging.logdPair("\tdesired (w,h)", paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    super.measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    Logging.logdPair("\tactual  (w,h)", paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Logging.logdHeader("BEGIN LAYOUT");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onLayout: l: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(", t: ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(", r: ");
    stringBuilder.append(paramInt3);
    stringBuilder.append(", b: ");
    stringBuilder.append(paramInt4);
    Logging.logd(stringBuilder.toString());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    Logging.logdHeader("BEGIN MEASURE");
    Logging.logdPair("Display", (getDisplayMetrics()).widthPixels, (getDisplayMetrics()).heightPixels);
    this.mVisibleChildren.clear();
    for (paramInt1 = 0; paramInt1 < getChildCount(); paramInt1++) {
      View view = getChildAt(paramInt1);
      if (view.getVisibility() != 8) {
        this.mVisibleChildren.add(view);
      } else {
        Logging.logdNumber("Skipping GONE child", paramInt1);
      } 
    } 
  }
  
  protected int roundToNearest(int paramInt1, int paramInt2) {
    return paramInt2 * Math.round(paramInt1 / paramInt2);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\layout\BaseModalLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */