package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface ISignInButtonCreator extends IInterface {
  IObjectWrapper newSignInButton(IObjectWrapper paramIObjectWrapper, int paramInt1, int paramInt2) throws RemoteException;
  
  IObjectWrapper newSignInButtonFromConfig(IObjectWrapper paramIObjectWrapper, SignInButtonConfig paramSignInButtonConfig) throws RemoteException;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\ISignInButtonCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */