package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import java.util.Map;

public abstract class BindingWrapper {
  final InAppMessageLayoutConfig config;
  
  final LayoutInflater inflater;
  
  protected final InAppMessage message;
  
  protected BindingWrapper(InAppMessageLayoutConfig paramInAppMessageLayoutConfig, LayoutInflater paramLayoutInflater, InAppMessage paramInAppMessage) {
    this.config = paramInAppMessageLayoutConfig;
    this.inflater = paramLayoutInflater;
    this.message = paramInAppMessage;
  }
  
  public boolean canSwipeToDismiss() {
    return false;
  }
  
  @NonNull
  public InAppMessageLayoutConfig getConfig() {
    return this.config;
  }
  
  @NonNull
  public abstract View getDialogView();
  
  @Nullable
  public View.OnClickListener getDismissListener() {
    return null;
  }
  
  @NonNull
  public abstract ImageView getImageView();
  
  @NonNull
  public abstract ViewGroup getRootView();
  
  @Nullable
  public abstract ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> paramMap, View.OnClickListener paramOnClickListener);
  
  protected void setGradientDrawableBgColor(View paramView, String paramString) {
    if (paramView != null && paramString != null) {
      GradientDrawable gradientDrawable = (GradientDrawable)paramView.getBackground();
      try {
        gradientDrawable.setColor(Color.parseColor(paramString));
      } catch (IllegalArgumentException illegalArgumentException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error parsing background color: ");
        stringBuilder.append(illegalArgumentException.toString());
        Logging.loge(stringBuilder.toString());
      } 
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\bindingwrappers\BindingWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */