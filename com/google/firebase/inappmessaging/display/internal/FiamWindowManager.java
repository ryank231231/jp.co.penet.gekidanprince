package com.google.firebase.inappmessaging.display.internal;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import javax.inject.Singleton;

@Singleton
public class FiamWindowManager {
  static final int DEFAULT_TYPE = 1003;
  
  private BindingWrapper bindingWrapper;
  
  private Point getDisplaySize(@NonNull Activity paramActivity) {
    Point point = new Point();
    Display display = getWindowManager(paramActivity).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      display.getRealSize(point);
    } else {
      display.getSize(point);
    } 
    return point;
  }
  
  private Rect getInsetDimensions(@NonNull Activity paramActivity) {
    Rect rect1 = new Rect();
    Rect rect2 = getVisibleFrame(paramActivity);
    Point point = getDisplaySize(paramActivity);
    rect1.top = rect2.top;
    rect1.left = rect2.left;
    rect1.right = point.x - rect2.right;
    rect1.bottom = point.y - rect2.bottom;
    return rect1;
  }
  
  private WindowManager.LayoutParams getLayoutParams(@NonNull InAppMessageLayoutConfig paramInAppMessageLayoutConfig, @NonNull Activity paramActivity) {
    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(paramInAppMessageLayoutConfig.windowWidth().intValue(), paramInAppMessageLayoutConfig.windowHeight().intValue(), 1003, paramInAppMessageLayoutConfig.windowFlag().intValue(), -3);
    Rect rect = getInsetDimensions(paramActivity);
    if ((paramInAppMessageLayoutConfig.viewWindowGravity().intValue() & 0x30) == 48)
      layoutParams.y = rect.top; 
    layoutParams.dimAmount = 0.3F;
    layoutParams.gravity = paramInAppMessageLayoutConfig.viewWindowGravity().intValue();
    layoutParams.windowAnimations = 0;
    return layoutParams;
  }
  
  private SwipeDismissTouchListener getSwipeListener(InAppMessageLayoutConfig paramInAppMessageLayoutConfig, final BindingWrapper bindingWrapper, final WindowManager windowManager, final WindowManager.LayoutParams layoutParams) {
    SwipeDismissTouchListener.DismissCallbacks dismissCallbacks = new SwipeDismissTouchListener.DismissCallbacks() {
        public boolean canDismiss(Object param1Object) {
          return true;
        }
        
        public void onDismiss(View param1View, Object param1Object) {
          if (bindingWrapper.getDismissListener() != null)
            bindingWrapper.getDismissListener().onClick(param1View); 
        }
      };
    return (paramInAppMessageLayoutConfig.windowWidth().intValue() == -1) ? new SwipeDismissTouchListener(bindingWrapper.getDialogView(), null, dismissCallbacks) : new SwipeDismissTouchListener(bindingWrapper.getDialogView(), null, dismissCallbacks) {
        protected float getTranslationX() {
          return layoutParams.x;
        }
        
        protected void setTranslationX(float param1Float) {
          layoutParams.x = (int)param1Float;
          windowManager.updateViewLayout((View)bindingWrapper.getRootView(), (ViewGroup.LayoutParams)layoutParams);
        }
      };
  }
  
  private Rect getVisibleFrame(@NonNull Activity paramActivity) {
    Rect rect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
    return rect;
  }
  
  private WindowManager getWindowManager(@NonNull Activity paramActivity) {
    return (WindowManager)paramActivity.getSystemService("window");
  }
  
  public void destroy(@NonNull Activity paramActivity) {
    if (isFiamDisplayed()) {
      getWindowManager(paramActivity).removeViewImmediate((View)this.bindingWrapper.getRootView());
      this.bindingWrapper = null;
    } 
  }
  
  public boolean isFiamDisplayed() {
    boolean bool;
    if (this.bindingWrapper != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void show(@NonNull BindingWrapper paramBindingWrapper, @NonNull Activity paramActivity) {
    if (isFiamDisplayed()) {
      Logging.loge("Fiam already active. Cannot show new Fiam.");
      return;
    } 
    InAppMessageLayoutConfig inAppMessageLayoutConfig = paramBindingWrapper.getConfig();
    WindowManager.LayoutParams layoutParams = getLayoutParams(inAppMessageLayoutConfig, paramActivity);
    WindowManager windowManager = getWindowManager(paramActivity);
    windowManager.addView((View)paramBindingWrapper.getRootView(), (ViewGroup.LayoutParams)layoutParams);
    Rect rect = getInsetDimensions(paramActivity);
    Logging.logdPair("Inset (top, bottom)", rect.top, rect.bottom);
    Logging.logdPair("Inset (left, right)", rect.left, rect.right);
    if (paramBindingWrapper.canSwipeToDismiss()) {
      SwipeDismissTouchListener swipeDismissTouchListener = getSwipeListener(inAppMessageLayoutConfig, paramBindingWrapper, windowManager, layoutParams);
      paramBindingWrapper.getDialogView().setOnTouchListener(swipeDismissTouchListener);
    } 
    this.bindingWrapper = paramBindingWrapper;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\FiamWindowManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */