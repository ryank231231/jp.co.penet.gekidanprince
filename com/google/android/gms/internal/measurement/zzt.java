package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

public interface zzt extends IInterface {
  int id() throws RemoteException;
  
  void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong) throws RemoteException;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */