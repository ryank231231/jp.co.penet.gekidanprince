package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;

public final class zak extends LruCache<Object, Drawable> {
  public zak() {
    super(10);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\base\zak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */