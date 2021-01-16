package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zacb extends UnregisterListenerMethod<A, L> {
  zacb(RegistrationMethods.Builder paramBuilder, ListenerHolder.ListenerKey<L> paramListenerKey) {
    super(paramListenerKey);
  }
  
  protected final void unregisterListener(A paramA, TaskCompletionSource<Boolean> paramTaskCompletionSource) throws RemoteException {
    RegistrationMethods.Builder.zab(this.zakg).accept(paramA, paramTaskCompletionSource);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zacb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */