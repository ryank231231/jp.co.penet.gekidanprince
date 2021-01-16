package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;

public interface IResolveAccountCallbacks extends IInterface {
  void onAccountResolutionComplete(ResolveAccountResponse paramResolveAccountResponse) throws RemoteException;
  
  public static abstract class Stub extends zab implements IResolveAccountCallbacks {
    public Stub() {
      super("com.google.android.gms.common.internal.IResolveAccountCallbacks");
    }
    
    public static IResolveAccountCallbacks asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
      return (iInterface instanceof IResolveAccountCallbacks) ? (IResolveAccountCallbacks)iInterface : new Proxy(param1IBinder);
    }
    
    protected boolean dispatchTransaction(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 == 2) {
        onAccountResolutionComplete((ResolveAccountResponse)zac.zaa(param1Parcel1, ResolveAccountResponse.CREATOR));
        param1Parcel2.writeNoException();
        return true;
      } 
      return false;
    }
    
    public static class Proxy extends zaa implements IResolveAccountCallbacks {
      Proxy(IBinder param2IBinder) {
        super(param2IBinder, "com.google.android.gms.common.internal.IResolveAccountCallbacks");
      }
      
      public void onAccountResolutionComplete(ResolveAccountResponse param2ResolveAccountResponse) throws RemoteException {
        Parcel parcel = zaa();
        zac.zaa(parcel, (Parcelable)param2ResolveAccountResponse);
        zab(2, parcel);
      }
    }
  }
  
  public static class Proxy extends zaa implements IResolveAccountCallbacks {
    Proxy(IBinder param1IBinder) {
      super(param1IBinder, "com.google.android.gms.common.internal.IResolveAccountCallbacks");
    }
    
    public void onAccountResolutionComplete(ResolveAccountResponse param1ResolveAccountResponse) throws RemoteException {
      Parcel parcel = zaa();
      zac.zaa(parcel, (Parcelable)param1ResolveAccountResponse);
      zab(2, parcel);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\IResolveAccountCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */