package com.google.firebase.inappmessaging.display.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class ResizableImageView extends AppCompatImageView {
  private int mDensityDpi;
  
  public ResizableImageView(Context paramContext) {
    super(paramContext);
    init(paramContext);
  }
  
  public ResizableImageView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ResizableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private Dimensions bound(int paramInt1, int paramInt2) {
    int i = getMaxWidth();
    int j = getMaxHeight();
    int k = paramInt1;
    int m = paramInt2;
    if (paramInt1 > i) {
      Logging.logdNumber("Image: capping width", i);
      m = paramInt2 * i / paramInt1;
      k = i;
    } 
    paramInt2 = k;
    paramInt1 = m;
    if (m > j) {
      Logging.logdNumber("Image: capping height", j);
      paramInt2 = k * j / m;
      paramInt1 = j;
    } 
    return new Dimensions(paramInt2, paramInt1);
  }
  
  private void checkMinDim() {
    int i = Math.max(getMinimumWidth(), getSuggestedMinimumWidth());
    int j = Math.max(getMinimumHeight(), getSuggestedMinimumHeight());
    int k = getMeasuredWidth();
    int m = getMeasuredHeight();
    float f1 = i;
    float f2 = j;
    Logging.logdPair("Image: min width, height", f1, f2);
    float f3 = k;
    float f4 = m;
    Logging.logdPair("Image: actual width, height", f3, f4);
    float f5 = 1.0F;
    if (k < i) {
      f1 /= f3;
    } else {
      f1 = 1.0F;
    } 
    if (m < j)
      f5 = f2 / f4; 
    if (f1 <= f5)
      f1 = f5; 
    if (f1 > 1.0D) {
      j = (int)Math.ceil((f3 * f1));
      i = (int)Math.ceil((f4 * f1));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Measured dimension (");
      stringBuilder.append(k);
      stringBuilder.append("x");
      stringBuilder.append(m);
      stringBuilder.append(") too small.  Resizing to ");
      stringBuilder.append(j);
      stringBuilder.append("x");
      stringBuilder.append(i);
      Logging.logd(stringBuilder.toString());
      Dimensions dimensions = bound(j, i);
      setMeasuredDimension(dimensions.w, dimensions.h);
    } 
  }
  
  private void init(@NonNull Context paramContext) {
    this.mDensityDpi = (int)((paramContext.getResources().getDisplayMetrics()).density * 160.0F);
  }
  
  private void scalePxToDp(Drawable paramDrawable) {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    Logging.logdPair("Image: intrinsic width, height", i, j);
    Dimensions dimensions = bound((int)Math.ceil((i * this.mDensityDpi / 160)), (int)Math.ceil((j * this.mDensityDpi / 160)));
    Logging.logdPair("Image: new target dimensions", dimensions.w, dimensions.h);
    setMeasuredDimension(dimensions.w, dimensions.h);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (Build.VERSION.SDK_INT > 16) {
      Drawable drawable = getDrawable();
      boolean bool = getAdjustViewBounds();
      if (drawable != null && bool) {
        scalePxToDp(drawable);
        checkMinDim();
      } 
    } 
  }
  
  private static class Dimensions {
    final int h;
    
    final int w;
    
    private Dimensions(int param1Int1, int param1Int2) {
      this.w = param1Int1;
      this.h = param1Int2;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\ResizableImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */