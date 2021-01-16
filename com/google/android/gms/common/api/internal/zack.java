package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zack extends TaskApiCall<A, ResultT> {
  zack(TaskApiCall.Builder paramBuilder, Feature[] paramArrayOfFeature, boolean paramBoolean) {
    super(paramArrayOfFeature, paramBoolean, null);
  }
  
  protected final void doExecute(A paramA, TaskCompletionSource<ResultT> paramTaskCompletionSource) throws RemoteException {
    TaskApiCall.Builder.zaa(this.zakm).accept(paramA, paramTaskCompletionSource);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */