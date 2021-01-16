package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.PlatformVersion;

public abstract class zab {
  private final int type;
  
  public zab(int paramInt) {
    this.type = paramInt;
  }
  
  private static Status zaa(RemoteException paramRemoteException) {
    StringBuilder stringBuilder = new StringBuilder();
    if (PlatformVersion.isAtLeastIceCreamSandwichMR1() && paramRemoteException instanceof android.os.TransactionTooLargeException)
      stringBuilder.append("TransactionTooLargeException: "); 
    stringBuilder.append(paramRemoteException.getLocalizedMessage());
    return new Status(8, stringBuilder.toString());
  }
  
  public abstract void zaa(@NonNull Status paramStatus);
  
  public abstract void zaa(GoogleApiManager.zaa<?> paramzaa) throws DeadObjectException;
  
  public abstract void zaa(@NonNull zaab paramzaab, boolean paramBoolean);
  
  public abstract void zaa(@NonNull RuntimeException paramRuntimeException);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */