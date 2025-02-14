package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zaca extends RegisterListenerMethod<A, L> {
  zaca(RegistrationMethods.Builder paramBuilder, ListenerHolder<L> paramListenerHolder, Feature[] paramArrayOfFeature, boolean paramBoolean) {
    super(paramListenerHolder, paramArrayOfFeature, paramBoolean);
  }
  
  protected final void registerListener(A paramA, TaskCompletionSource<Void> paramTaskCompletionSource) throws RemoteException {
    RegistrationMethods.Builder.zaa(this.zakg).accept(paramA, paramTaskCompletionSource);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */