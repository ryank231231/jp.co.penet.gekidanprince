package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.BaseGmsClient;

public final class zzat extends BaseGmsClient<zzam> {
  public zzat(Context paramContext, Looper paramLooper, BaseGmsClient.BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener) {
    super(paramContext, paramLooper, 93, paramBaseConnectionCallbacks, paramBaseOnConnectionFailedListener, null);
  }
  
  public final int getMinApkVersion() {
    return 12451000;
  }
  
  @NonNull
  protected final String getServiceDescriptor() {
    return "com.google.android.gms.measurement.internal.IMeasurementService";
  }
  
  @NonNull
  protected final String getStartServiceAction() {
    return "com.google.android.gms.measurement.START";
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */