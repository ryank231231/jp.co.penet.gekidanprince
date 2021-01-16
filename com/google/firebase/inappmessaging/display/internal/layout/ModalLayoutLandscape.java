package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ModalLayoutLandscape extends BaseModalLayout {
  private static final int ITEM_SPACING_DP = 24;
  
  private static final float MAX_IMG_WIDTH_PCT = 0.4F;
  
  private int barrierWidth;
  
  private View buttonChild;
  
  private View imageChild;
  
  private int leftContentHeight;
  
  private int rightContentHeight;
  
  private View scrollChild;
  
  private View titleChild;
  
  private int vertItemSpacing;
  
  public ModalLayoutLandscape(Context paramContext, @Nullable AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  protected void layoutCenterHorizontal(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = (paramInt3 - paramInt1) / 2;
    paramInt3 = paramView.getMeasuredWidth() / 2;
    paramInt1 += i;
    layoutChild(paramView, paramInt1 - paramInt3, paramInt2, paramInt1 + paramInt3, paramInt4);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int i = getPaddingLeft();
    int j = getPaddingTop();
    paramInt4 = getMeasuredWidth() - getPaddingRight();
    paramInt2 = this.leftContentHeight;
    paramInt1 = this.rightContentHeight;
    paramInt3 = 0;
    if (paramInt2 < paramInt1) {
      paramInt2 = (paramInt1 - paramInt2) / 2;
      paramInt1 = 0;
    } else {
      paramInt1 = (paramInt2 - paramInt1) / 2;
      paramInt2 = 0;
    } 
    Logging.logd("Layout image");
    paramInt2 = j + paramInt2;
    int k = getDesiredWidth(this.imageChild) + i;
    int m = getDesiredHeight(this.imageChild);
    layoutChild(this.imageChild, i, paramInt2, k, paramInt2 + m);
    paramInt2 = k + this.barrierWidth;
    Logging.logd("Layout getTitle");
    paramInt1 = j + paramInt1;
    j = getDesiredHeight(this.titleChild) + paramInt1;
    layoutChild(this.titleChild, paramInt2, paramInt1, paramInt4, j);
    Logging.logd("Layout getBody");
    if (this.titleChild.getVisibility() == 8) {
      paramInt1 = 0;
    } else {
      paramInt1 = this.vertItemSpacing;
    } 
    paramInt1 = j + paramInt1;
    j = getDesiredHeight(this.scrollChild) + paramInt1;
    layoutChild(this.scrollChild, paramInt2, paramInt1, paramInt4, j);
    Logging.logd("Layout button");
    if (this.scrollChild.getVisibility() == 8) {
      paramInt1 = paramInt3;
    } else {
      paramInt1 = this.vertItemSpacing;
    } 
    layoutChild(this.buttonChild, paramInt2, j + paramInt1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    this.imageChild = findChildById(R.id.image_view);
    this.titleChild = findChildById(R.id.message_title);
    this.scrollChild = findChildById(R.id.body_scroll);
    this.buttonChild = findChildById(R.id.button);
    int i = this.imageChild.getVisibility();
    boolean bool = false;
    if (i == 8) {
      i = 0;
    } else {
      i = dpToPixels(24);
    } 
    this.barrierWidth = i;
    this.vertItemSpacing = dpToPixels(24);
    List<View> list = Arrays.asList(new View[] { this.titleChild, this.scrollChild, this.buttonChild });
    i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingBottom() + getPaddingTop();
    paramInt1 = calculateBaseWidth(paramInt1);
    int k = calculateBaseHeight(paramInt2) - j;
    paramInt1 -= i;
    Logging.logd("Measuring image");
    MeasureUtils.measureAtMost(this.imageChild, (int)(paramInt1 * 0.4F), k);
    paramInt2 = getDesiredWidth(this.imageChild);
    int m = paramInt1 - this.barrierWidth + paramInt2;
    float f = paramInt2;
    Logging.logdPair("Max col widths (l, r)", f, m);
    Iterator<View> iterator2 = list.iterator();
    paramInt1 = 0;
    while (iterator2.hasNext()) {
      if (((View)iterator2.next()).getVisibility() != 8)
        paramInt1++; 
    } 
    paramInt1 = Math.max(0, (paramInt1 - 1) * this.vertItemSpacing);
    k -= paramInt1;
    Logging.logd("Measuring getTitle");
    MeasureUtils.measureAtMost(this.titleChild, m, k);
    Logging.logd("Measuring button");
    MeasureUtils.measureAtMost(this.buttonChild, m, k);
    Logging.logd("Measuring scroll view");
    int n = getDesiredHeight(this.titleChild);
    int i1 = getDesiredHeight(this.buttonChild);
    MeasureUtils.measureAtMost(this.scrollChild, m, k - n - i1);
    this.leftContentHeight = getDesiredHeight(this.imageChild);
    this.rightContentHeight = paramInt1;
    for (View view : list)
      this.rightContentHeight += getDesiredHeight(view); 
    j = Math.max(this.leftContentHeight + j, this.rightContentHeight + j);
    Iterator<View> iterator1 = list.iterator();
    for (paramInt1 = bool; iterator1.hasNext(); paramInt1 = Math.max(getDesiredWidth(iterator1.next()), paramInt1));
    Logging.logdPair("Measured columns (l, r)", f, paramInt1);
    paramInt1 = paramInt2 + paramInt1 + this.barrierWidth + i;
    Logging.logdPair("Measured dims", paramInt1, j);
    setMeasuredDimension(paramInt1, j);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\layout\ModalLayoutLandscape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */