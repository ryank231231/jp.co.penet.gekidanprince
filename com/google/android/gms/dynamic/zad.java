package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

final class zad implements DeferredLifecycleHelper.zaa {
  zad(DeferredLifecycleHelper paramDeferredLifecycleHelper, FrameLayout paramFrameLayout, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup) {}
  
  public final int getState() {
    return 2;
  }
  
  public final void zaa(LifecycleDelegate paramLifecycleDelegate) {
    this.zarl.removeAllViews();
    this.zarl.addView(DeferredLifecycleHelper.zab(this.zari).onCreateView(this.zarm, container, this.zark));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\dynamic\zad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */