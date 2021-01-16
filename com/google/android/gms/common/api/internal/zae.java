package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class zae<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> extends zab {
  private final A zacn;
  
  public zae(int paramInt, A paramA) {
    super(paramInt);
    this.zacn = paramA;
  }
  
  public final void zaa(@NonNull Status paramStatus) {
    this.zacn.setFailedResult(paramStatus);
  }
  
  public final void zaa(GoogleApiManager.zaa<?> paramzaa) throws DeadObjectException {
    try {
      this.zacn.run(paramzaa.zaab());
      return;
    } catch (RuntimeException runtimeException) {
      super.zaa(runtimeException);
      return;
    } 
  }
  
  public final void zaa(@NonNull zaab paramzaab, boolean paramBoolean) {
    paramzaab.zaa((BasePendingResult<? extends Result>)this.zacn, paramBoolean);
  }
  
  public final void zaa(@NonNull RuntimeException paramRuntimeException) {
    String str1 = paramRuntimeException.getClass().getSimpleName();
    String str2 = paramRuntimeException.getLocalizedMessage();
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 2 + String.valueOf(str2).length());
    stringBuilder.append(str1);
    stringBuilder.append(": ");
    stringBuilder.append(str2);
    Status status = new Status(10, stringBuilder.toString());
    this.zacn.setFailedResult(status);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */