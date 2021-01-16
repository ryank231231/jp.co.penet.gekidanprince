package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.MotionEvent;
import android.view.View;

class BrowserActionsFallbackMenuDialog extends Dialog {
  private static final long ENTER_ANIMATION_DURATION_MS = 250L;
  
  private static final long EXIT_ANIMATION_DURATION_MS = 150L;
  
  private final View mContentView;
  
  BrowserActionsFallbackMenuDialog(Context paramContext, View paramView) {
    super(paramContext);
    this.mContentView = paramView;
  }
  
  private void startAnimation(final boolean isEnterAnimation) {
    float f2;
    long l;
    float f1 = 0.0F;
    if (isEnterAnimation) {
      f2 = 0.0F;
    } else {
      f2 = 1.0F;
    } 
    if (isEnterAnimation)
      f1 = 1.0F; 
    if (isEnterAnimation) {
      l = 250L;
    } else {
      l = 150L;
    } 
    this.mContentView.setScaleX(f2);
    this.mContentView.setScaleY(f2);
    this.mContentView.animate().scaleX(f1).scaleY(f1).setDuration(l).setInterpolator((TimeInterpolator)new LinearOutSlowInInterpolator()).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter() {
          public void onAnimationEnd(Animator param1Animator) {
            if (!isEnterAnimation)
              BrowserActionsFallbackMenuDialog.this.dismiss(); 
          }
        }).start();
  }
  
  public void dismiss() {
    startAnimation(false);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() == 0) {
      dismiss();
      return true;
    } 
    return false;
  }
  
  public void show() {
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    startAnimation(true);
    super.show();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\androidx\browser\browseractions\BrowserActionsFallbackMenuDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */