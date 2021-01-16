package com.google.firebase.components;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class ComponentDiscoveryService extends Service {
  @Nullable
  public IBinder onBind(Intent paramIntent) {
    return null;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\components\ComponentDiscoveryService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */