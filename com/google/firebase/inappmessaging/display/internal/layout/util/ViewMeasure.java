package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.View;
import android.widget.ScrollView;

public class ViewMeasure {
  private boolean flex;
  
  private int maxHeight;
  
  private int maxWidth;
  
  private View view;
  
  public ViewMeasure(View paramView, boolean paramBoolean) {
    this.view = paramView;
    this.flex = paramBoolean;
  }
  
  public int getDesiredHeight() {
    ScrollView scrollView;
    if (this.view.getVisibility() == 8)
      return 0; 
    View view = this.view;
    if (view instanceof ScrollView) {
      scrollView = (ScrollView)view;
      return scrollView.getPaddingBottom() + scrollView.getPaddingTop() + scrollView.getChildAt(0).getMeasuredHeight();
    } 
    return scrollView.getMeasuredHeight();
  }
  
  public int getDesiredWidth() {
    return (this.view.getVisibility() == 8) ? 0 : this.view.getMeasuredHeight();
  }
  
  public int getMaxHeight() {
    return this.maxHeight;
  }
  
  public int getMaxWidth() {
    return this.maxWidth;
  }
  
  public View getView() {
    return this.view;
  }
  
  public boolean isFlex() {
    return this.flex;
  }
  
  public void preMeasure(int paramInt1, int paramInt2) {
    MeasureUtils.measureAtMost(this.view, paramInt1, paramInt2);
  }
  
  public void setMaxDimens(int paramInt1, int paramInt2) {
    this.maxWidth = paramInt1;
    this.maxHeight = paramInt2;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\layou\\util\ViewMeasure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */