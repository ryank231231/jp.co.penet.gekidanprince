package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class SignInButtonCreator extends RemoteCreator<ISignInButtonCreator> {
  private static final SignInButtonCreator zape = new SignInButtonCreator();
  
  private SignInButtonCreator() {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View createView(Context paramContext, int paramInt1, int paramInt2) throws RemoteCreator.RemoteCreatorException {
    return zape.zaa(paramContext, paramInt1, paramInt2);
  }
  
  private final View zaa(Context paramContext, int paramInt1, int paramInt2) throws RemoteCreator.RemoteCreatorException {
    try {
      SignInButtonConfig signInButtonConfig = new SignInButtonConfig();
      this(paramInt1, paramInt2, null);
      IObjectWrapper iObjectWrapper = ObjectWrapper.wrap(paramContext);
      return (View)ObjectWrapper.unwrap(((ISignInButtonCreator)getRemoteCreatorInstance(paramContext)).newSignInButtonFromConfig(iObjectWrapper, signInButtonConfig));
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder(64);
      stringBuilder.append("Could not get button with size ");
      stringBuilder.append(paramInt1);
      stringBuilder.append(" and color ");
      stringBuilder.append(paramInt2);
      throw new RemoteCreator.RemoteCreatorException(stringBuilder.toString(), exception);
    } 
  }
  
  public final ISignInButtonCreator getRemoteCreator(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
    return (iInterface instanceof ISignInButtonCreator) ? (ISignInButtonCreator)iInterface : new zah(paramIBinder);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\SignInButtonCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */