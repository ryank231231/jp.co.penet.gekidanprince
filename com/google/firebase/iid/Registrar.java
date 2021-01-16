package com.google.firebase.iid;

import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import java.util.Arrays;
import java.util.List;

@Keep
@KeepForSdk
public final class Registrar implements ComponentRegistrar {
  @Keep
  public final List<Component<?>> getComponents() {
    return Arrays.asList((Component<?>[])new Component[] { Component.builder(FirebaseInstanceId.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(Subscriber.class)).factory(zzao.zzcn).alwaysEager().build(), Component.builder(FirebaseInstanceIdInternal.class).add(Dependency.required(FirebaseInstanceId.class)).factory(zzap.zzcn).build() });
  }
  
  private static final class zza implements FirebaseInstanceIdInternal {
    private final FirebaseInstanceId zzco;
    
    public zza(FirebaseInstanceId param1FirebaseInstanceId) {
      this.zzco = param1FirebaseInstanceId;
    }
    
    public final String getId() {
      return this.zzco.getId();
    }
    
    public final String getToken() {
      return this.zzco.getToken();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\Registrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */