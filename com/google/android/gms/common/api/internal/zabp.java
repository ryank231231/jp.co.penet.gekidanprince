package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;

public final class zabp<O extends Api.ApiOptions> extends zaag {
  private final GoogleApi<O> zajg;
  
  public zabp(GoogleApi<O> paramGoogleApi) {
    super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
    this.zajg = paramGoogleApi;
  }
  
  public final <A extends Api.AnyClient, R extends com.google.android.gms.common.api.Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T paramT) {
    return (T)this.zajg.doRead((BaseImplementation.ApiMethodImpl)paramT);
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends com.google.android.gms.common.api.Result, A>> T execute(@NonNull T paramT) {
    return (T)this.zajg.doWrite((BaseImplementation.ApiMethodImpl)paramT);
  }
  
  public final Context getContext() {
    return this.zajg.getApplicationContext();
  }
  
  public final Looper getLooper() {
    return this.zajg.getLooper();
  }
  
  public final void zaa(zacm paramzacm) {}
  
  public final void zab(zacm paramzacm) {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zabp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */