package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

public class AccountAccessor extends IAccountAccessor.Stub {
  @KeepForSdk
  public static Account getAccountBinderSafe(IAccountAccessor paramIAccountAccessor) {
    if (paramIAccountAccessor != null) {
      long l = Binder.clearCallingIdentity();
      try {
        Account account = paramIAccountAccessor.getAccount();
        Binder.restoreCallingIdentity(l);
      } catch (RemoteException remoteException) {
        Log.w("AccountAccessor", "Remote account accessor probably died");
        Binder.restoreCallingIdentity(l);
        remoteException = null;
      } finally {}
      return (Account)paramIAccountAccessor;
    } 
    paramIAccountAccessor = null;
  }
  
  public boolean equals(Object paramObject) {
    throw new NoSuchMethodError();
  }
  
  public final Account getAccount() {
    throw new NoSuchMethodError();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\AccountAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */