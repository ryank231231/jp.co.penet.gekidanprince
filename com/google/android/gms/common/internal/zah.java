package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class zah extends zaa implements ISignInButtonCreator {
  zah(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
  }
  
  public final IObjectWrapper newSignInButton(IObjectWrapper paramIObjectWrapper, int paramInt1, int paramInt2) throws RemoteException {
    Parcel parcel = zaa();
    zac.zaa(parcel, (IInterface)paramIObjectWrapper);
    parcel.writeInt(paramInt1);
    parcel.writeInt(paramInt2);
    parcel = zaa(1, parcel);
    paramIObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
    parcel.recycle();
    return paramIObjectWrapper;
  }
  
  public final IObjectWrapper newSignInButtonFromConfig(IObjectWrapper paramIObjectWrapper, SignInButtonConfig paramSignInButtonConfig) throws RemoteException {
    Parcel parcel2 = zaa();
    zac.zaa(parcel2, (IInterface)paramIObjectWrapper);
    zac.zaa(parcel2, (Parcelable)paramSignInButtonConfig);
    Parcel parcel1 = zaa(2, parcel2);
    IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel1.readStrongBinder());
    parcel1.recycle();
    return iObjectWrapper;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\zah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */