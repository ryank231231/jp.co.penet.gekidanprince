package com.google.android.gms.common.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

public class GoogleApiAvailabilityCache {
  private final SparseIntArray zaor = new SparseIntArray();
  
  private GoogleApiAvailabilityLight zaos;
  
  public GoogleApiAvailabilityCache() {
    this((GoogleApiAvailabilityLight)GoogleApiAvailability.getInstance());
  }
  
  public GoogleApiAvailabilityCache(@NonNull GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight) {
    Preconditions.checkNotNull(paramGoogleApiAvailabilityLight);
    this.zaos = paramGoogleApiAvailabilityLight;
  }
  
  public void flush() {
    this.zaor.clear();
  }
  
  public int getClientAvailability(@NonNull Context paramContext, @NonNull Api.Client paramClient) {
    int m;
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramClient);
    if (!paramClient.requiresGooglePlayServices())
      return 0; 
    int i = paramClient.getMinApkVersion();
    int j = this.zaor.get(i, -1);
    if (j != -1)
      return j; 
    int k = 0;
    while (true) {
      m = j;
      if (k < this.zaor.size()) {
        m = this.zaor.keyAt(k);
        if (m > i && this.zaor.get(m) == 0) {
          m = 0;
          break;
        } 
        k++;
        continue;
      } 
      break;
    } 
    k = m;
    if (m == -1)
      k = this.zaos.isGooglePlayServicesAvailable(paramContext, i); 
    this.zaor.put(i, k);
    return k;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\GoogleApiAvailabilityCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */