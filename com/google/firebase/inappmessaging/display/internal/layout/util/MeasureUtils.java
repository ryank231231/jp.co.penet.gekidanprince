package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.View;
import com.google.firebase.inappmessaging.display.internal.Logging;

public class MeasureUtils {
  public static void measureAtMost(View paramView, int paramInt1, int paramInt2) {
    Logging.logdPair("\tdesired (w,h)", paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    if (paramView.getVisibility() == 8) {
      paramInt1 = 0;
      paramInt2 = 0;
    } 
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
    Logging.logdPair("\tactual (w,h)", paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\layou\\util\MeasureUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */