package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

public class BackButtonHandler {
  private View.OnClickListener listener;
  
  private ViewGroup viewGroup;
  
  public BackButtonHandler(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener) {
    this.viewGroup = paramViewGroup;
    this.listener = paramOnClickListener;
  }
  
  @Nullable
  public Boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    if (paramKeyEvent != null && paramKeyEvent.getKeyCode() == 4 && paramKeyEvent.getAction() == 1) {
      View.OnClickListener onClickListener = this.listener;
      if (onClickListener != null) {
        onClickListener.onClick((View)this.viewGroup);
        return Boolean.valueOf(true);
      } 
      return Boolean.valueOf(false);
    } 
    return null;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\layou\\util\BackButtonHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */