package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

public final class zai<O extends Api.ApiOptions> {
  private final Api<O> mApi;
  
  private final O zabh;
  
  private final boolean zact = true;
  
  private final int zacu;
  
  private zai(Api<O> paramApi) {
    this.mApi = paramApi;
    this.zabh = null;
    this.zacu = System.identityHashCode(this);
  }
  
  private zai(Api<O> paramApi, O paramO) {
    this.mApi = paramApi;
    this.zabh = paramO;
    this.zacu = Objects.hashCode(new Object[] { this.mApi, this.zabh });
  }
  
  public static <O extends Api.ApiOptions> zai<O> zaa(Api<O> paramApi) {
    return new zai<O>(paramApi);
  }
  
  public static <O extends Api.ApiOptions> zai<O> zaa(Api<O> paramApi, O paramO) {
    return new zai<O>(paramApi, paramO);
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zai))
      return false; 
    paramObject = paramObject;
    return (!this.zact && !((zai)paramObject).zact && Objects.equal(this.mApi, ((zai)paramObject).mApi) && Objects.equal(this.zabh, ((zai)paramObject).zabh));
  }
  
  public final int hashCode() {
    return this.zacu;
  }
  
  public final String zan() {
    return this.mApi.getName();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */