package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.firebase.inappmessaging.display.internal.layout.util.BackButtonHandler;

public class FiamRelativeLayout extends RelativeLayout implements BackButtonLayout {
  private BackButtonHandler mBackHandler;
  
  public FiamRelativeLayout(Context paramContext) {
    super(paramContext);
  }
  
  public FiamRelativeLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public FiamRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @RequiresApi(21)
  public FiamRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    Boolean bool = this.mBackHandler.dispatchKeyEvent(paramKeyEvent);
    return (bool != null) ? bool.booleanValue() : super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void setDismissListener(View.OnClickListener paramOnClickListener) {
    this.mBackHandler = new BackButtonHandler((ViewGroup)this, paramOnClickListener);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\layout\FiamRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */