package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

final class zai extends Drawable.ConstantState {
  int mChangingConfigurations;
  
  int zanv;
  
  zai(zai paramzai) {
    if (paramzai != null) {
      this.mChangingConfigurations = paramzai.mChangingConfigurations;
      this.zanv = paramzai.zanv;
    } 
  }
  
  public final int getChangingConfigurations() {
    return this.mChangingConfigurations;
  }
  
  public final Drawable newDrawable() {
    return new zae(this);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\base\zai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */