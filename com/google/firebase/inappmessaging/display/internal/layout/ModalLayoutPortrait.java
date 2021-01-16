package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;
import com.google.firebase.inappmessaging.display.internal.layout.util.VerticalViewGroupMeasure;
import com.google.firebase.inappmessaging.display.internal.layout.util.ViewMeasure;
import java.util.Iterator;

public class ModalLayoutPortrait extends BaseModalLayout {
  private static final int ITEM_SPACING_DP = 24;
  
  private int vertItemSpacing;
  
  private VerticalViewGroupMeasure vgm = new VerticalViewGroupMeasure();
  
  public ModalLayoutPortrait(Context paramContext, @Nullable AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean isFlex(View paramView) {
    return (paramView.getId() == R.id.body_scroll || paramView.getId() == R.id.image_view);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = getPaddingTop();
    int i = getPaddingLeft();
    int j = getVisibleChildren().size();
    for (paramInt4 = 0; paramInt4 < j; paramInt4++) {
      View view = getVisibleChildren().get(paramInt4);
      FrameLayout.LayoutParams layoutParams = getLayoutParams(view);
      int k = view.getMeasuredHeight();
      int m = view.getMeasuredWidth();
      int n = k + paramInt2;
      if ((layoutParams.gravity & 0x1) == 1) {
        k = (paramInt3 - paramInt1) / 2;
        int i1 = m / 2;
        m = k - i1;
        k += i1;
      } else {
        k = i + m;
        m = i;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Layout child ");
      stringBuilder.append(paramInt4);
      Logging.logd(stringBuilder.toString());
      Logging.logdPair("\t(top, bottom)", paramInt2, n);
      Logging.logdPair("\t(left, right)", m, k);
      view.layout(m, paramInt2, k, n);
      m = paramInt2 + view.getMeasuredHeight();
      paramInt2 = m;
      if (paramInt4 < j - 1)
        paramInt2 = m + this.vertItemSpacing; 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    this.vertItemSpacing = dpToPixels(24);
    int i = getPaddingRight();
    int j = getPaddingLeft();
    int k = getPaddingBottom();
    int m = getPaddingTop();
    int n = calculateBaseWidth(paramInt1);
    int i1 = calculateBaseHeight(paramInt2);
    paramInt2 = k + m + (getVisibleChildren().size() - 1) * this.vertItemSpacing;
    this.vgm.reset(n, i1);
    boolean bool = false;
    for (paramInt1 = 0; paramInt1 < getChildCount(); paramInt1++) {
      View view = getChildAt(paramInt1);
      this.vgm.add(view, isFlex(view));
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Screen dimens: ");
    stringBuilder.append(getDisplayMetrics());
    Logging.logd(stringBuilder.toString());
    Logging.logdPair("Max pct", getMaxWidthPct(), getMaxHeightPct());
    float f = n;
    Logging.logdPair("Base dimens", f, i1);
    for (ViewMeasure viewMeasure : this.vgm.getViews()) {
      Logging.logd("Pre-measure child");
      viewMeasure.preMeasure(n, i1);
    } 
    paramInt1 = this.vgm.getTotalHeight() + paramInt2;
    Logging.logdNumber("Total reserved height", paramInt2);
    Logging.logdNumber("Total desired height", paramInt1);
    if (paramInt1 > i1)
      bool = true; 
    stringBuilder = new StringBuilder();
    stringBuilder.append("Total height constrained: ");
    stringBuilder.append(bool);
    Logging.logd(stringBuilder.toString());
    if (bool) {
      paramInt1 = this.vgm.getTotalFixedHeight();
      this.vgm.allocateSpace(i1 - paramInt2 - paramInt1);
    } 
    Iterator<ViewMeasure> iterator = this.vgm.getViews().iterator();
    for (paramInt1 = paramInt2; iterator.hasNext(); paramInt1 += getDesiredHeight(viewMeasure.getView())) {
      ViewMeasure viewMeasure = iterator.next();
      Logging.logd("Measuring child");
      MeasureUtils.measureAtMost(viewMeasure.getView(), n - i + j, viewMeasure.getMaxHeight());
    } 
    Logging.logdPair("Measured dims", f, paramInt1);
    setMeasuredDimension(n, paramInt1);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\layout\ModalLayoutPortrait.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */