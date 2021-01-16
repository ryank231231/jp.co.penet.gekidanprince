package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.util.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

public class zaae extends zal {
  private GoogleApiManager zabm;
  
  private final ArraySet<zai<?>> zafo = new ArraySet();
  
  private zaae(LifecycleFragment paramLifecycleFragment) {
    super(paramLifecycleFragment);
    this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
  }
  
  public static void zaa(Activity paramActivity, GoogleApiManager paramGoogleApiManager, zai<?> paramzai) {
    LifecycleFragment lifecycleFragment = getFragment(paramActivity);
    zaae zaae2 = lifecycleFragment.<zaae>getCallbackOrNull("ConnectionlessLifecycleHelper", zaae.class);
    zaae zaae1 = zaae2;
    if (zaae2 == null)
      zaae1 = new zaae(lifecycleFragment); 
    zaae1.zabm = paramGoogleApiManager;
    Preconditions.checkNotNull(paramzai, "ApiKey cannot be null");
    zaae1.zafo.add(paramzai);
    paramGoogleApiManager.zaa(zaae1);
  }
  
  private final void zaak() {
    if (!this.zafo.isEmpty())
      this.zabm.zaa(this); 
  }
  
  public void onResume() {
    super.onResume();
    zaak();
  }
  
  public void onStart() {
    super.onStart();
    zaak();
  }
  
  public void onStop() {
    super.onStop();
    this.zabm.zab(this);
  }
  
  protected final void zaa(ConnectionResult paramConnectionResult, int paramInt) {
    this.zabm.zaa(paramConnectionResult, paramInt);
  }
  
  final ArraySet<zai<?>> zaaj() {
    return this.zafo;
  }
  
  protected final void zao() {
    this.zabm.zao();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */