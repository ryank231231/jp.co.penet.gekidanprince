package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

public final class zae extends Drawable implements Drawable.Callback {
  private int mAlpha = 0;
  
  private int mFrom;
  
  private boolean zamy = true;
  
  private int zang = 0;
  
  private long zanh;
  
  private int zani;
  
  private int zanj = 255;
  
  private int zank;
  
  private boolean zanl;
  
  private zai zanm;
  
  private Drawable zann;
  
  private Drawable zano;
  
  private boolean zanp;
  
  private boolean zanq;
  
  private boolean zanr;
  
  private int zans;
  
  public zae(Drawable paramDrawable1, Drawable paramDrawable2) {
    this((zai)null);
    Drawable drawable2 = paramDrawable1;
    if (paramDrawable1 == null)
      drawable2 = zag.zacg(); 
    this.zann = drawable2;
    drawable2.setCallback(this);
    zai zai1 = this.zanm;
    int i = zai1.zanv;
    zai1.zanv = drawable2.getChangingConfigurations() | i;
    Drawable drawable1 = paramDrawable2;
    if (paramDrawable2 == null)
      drawable1 = zag.zacg(); 
    this.zano = drawable1;
    drawable1.setCallback(this);
    zai zai2 = this.zanm;
    i = zai2.zanv;
    zai2.zanv = drawable1.getChangingConfigurations() | i;
  }
  
  zae(zai paramzai) {
    this.zanm = new zai(paramzai);
  }
  
  private final boolean canConstantState() {
    if (!this.zanp) {
      boolean bool;
      if (this.zann.getConstantState() != null && this.zano.getConstantState() != null) {
        bool = true;
      } else {
        bool = false;
      } 
      this.zanq = bool;
      this.zanp = true;
    } 
    return this.zanq;
  }
  
  public final void draw(Canvas paramCanvas) {
    int i = this.zang;
    int j = 1;
    int k = 1;
    switch (i) {
      case 2:
        if (this.zanh >= 0L) {
          float f = (float)(SystemClock.uptimeMillis() - this.zanh) / this.zank;
          if (f >= 1.0F) {
            j = k;
          } else {
            j = 0;
          } 
          if (j)
            this.zang = 0; 
          f = Math.min(f, 1.0F);
          this.mAlpha = (int)(this.zani * f + 0.0F);
        } 
        break;
      case 1:
        this.zanh = SystemClock.uptimeMillis();
        this.zang = 2;
        j = 0;
        break;
    } 
    k = this.mAlpha;
    boolean bool = this.zamy;
    Drawable drawable1 = this.zann;
    Drawable drawable2 = this.zano;
    if (j != 0) {
      if (!bool || k == 0)
        drawable1.draw(paramCanvas); 
      j = this.zanj;
      if (k == j) {
        drawable2.setAlpha(j);
        drawable2.draw(paramCanvas);
      } 
      return;
    } 
    if (bool)
      drawable1.setAlpha(this.zanj - k); 
    drawable1.draw(paramCanvas);
    if (bool)
      drawable1.setAlpha(this.zanj); 
    if (k > 0) {
      drawable2.setAlpha(k);
      drawable2.draw(paramCanvas);
      drawable2.setAlpha(this.zanj);
    } 
    invalidateSelf();
  }
  
  public final int getChangingConfigurations() {
    return super.getChangingConfigurations() | this.zanm.mChangingConfigurations | this.zanm.zanv;
  }
  
  public final Drawable.ConstantState getConstantState() {
    if (canConstantState()) {
      this.zanm.mChangingConfigurations = getChangingConfigurations();
      return this.zanm;
    } 
    return null;
  }
  
  public final int getIntrinsicHeight() {
    return Math.max(this.zann.getIntrinsicHeight(), this.zano.getIntrinsicHeight());
  }
  
  public final int getIntrinsicWidth() {
    return Math.max(this.zann.getIntrinsicWidth(), this.zano.getIntrinsicWidth());
  }
  
  public final int getOpacity() {
    if (!this.zanr) {
      this.zans = Drawable.resolveOpacity(this.zann.getOpacity(), this.zano.getOpacity());
      this.zanr = true;
    } 
    return this.zans;
  }
  
  public final void invalidateDrawable(Drawable paramDrawable) {
    Drawable.Callback callback = getCallback();
    if (callback != null)
      callback.invalidateDrawable(this); 
  }
  
  public final Drawable mutate() {
    if (!this.zanl && super.mutate() == this)
      if (canConstantState()) {
        this.zann.mutate();
        this.zano.mutate();
        this.zanl = true;
      } else {
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
      }  
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect) {
    this.zann.setBounds(paramRect);
    this.zano.setBounds(paramRect);
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {
    Drawable.Callback callback = getCallback();
    if (callback != null)
      callback.scheduleDrawable(this, paramRunnable, paramLong); 
  }
  
  public final void setAlpha(int paramInt) {
    if (this.mAlpha == this.zanj)
      this.mAlpha = paramInt; 
    this.zanj = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {
    this.zann.setColorFilter(paramColorFilter);
    this.zano.setColorFilter(paramColorFilter);
  }
  
  public final void startTransition(int paramInt) {
    this.mFrom = 0;
    this.zani = this.zanj;
    this.mAlpha = 0;
    this.zank = 250;
    this.zang = 1;
    invalidateSelf();
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {
    Drawable.Callback callback = getCallback();
    if (callback != null)
      callback.unscheduleDrawable(this, paramRunnable); 
  }
  
  public final Drawable zacf() {
    return this.zano;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\base\zae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */