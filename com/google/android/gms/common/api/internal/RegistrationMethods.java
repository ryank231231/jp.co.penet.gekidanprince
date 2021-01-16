package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class RegistrationMethods<A extends Api.AnyClient, L> {
  public final RegisterListenerMethod<A, L> zajy;
  
  public final UnregisterListenerMethod<A, L> zajz;
  
  private RegistrationMethods(RegisterListenerMethod<A, L> paramRegisterListenerMethod, UnregisterListenerMethod<A, L> paramUnregisterListenerMethod) {
    this.zajy = paramRegisterListenerMethod;
    this.zajz = paramUnregisterListenerMethod;
  }
  
  @KeepForSdk
  public static <A extends Api.AnyClient, L> Builder<A, L> builder() {
    return new Builder<A, L>(null);
  }
  
  @KeepForSdk
  public static class Builder<A extends Api.AnyClient, L> {
    private boolean zajv = true;
    
    private RemoteCall<A, TaskCompletionSource<Void>> zaka;
    
    private RemoteCall<A, TaskCompletionSource<Boolean>> zakb;
    
    private ListenerHolder<L> zakc;
    
    private Feature[] zakd;
    
    private Builder() {}
    
    @KeepForSdk
    public RegistrationMethods<A, L> build() {
      boolean bool2;
      RemoteCall<A, TaskCompletionSource<Void>> remoteCall = this.zaka;
      boolean bool1 = true;
      if (remoteCall != null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "Must set register function");
      if (this.zakb != null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "Must set unregister function");
      if (this.zakc != null) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "Must set holder");
      return new RegistrationMethods<A, L>(new zaca(this, this.zakc, this.zakd, this.zajv), new zacb(this, this.zakc.getListenerKey()), null);
    }
    
    @KeepForSdk
    public Builder<A, L> register(RemoteCall<A, TaskCompletionSource<Void>> param1RemoteCall) {
      this.zaka = param1RemoteCall;
      return this;
    }
    
    @Deprecated
    @KeepForSdk
    public Builder<A, L> register(BiConsumer<A, TaskCompletionSource<Void>> param1BiConsumer) {
      this.zaka = new zaby(param1BiConsumer);
      return this;
    }
    
    @KeepForSdk
    public Builder<A, L> setAutoResolveMissingFeatures(boolean param1Boolean) {
      this.zajv = param1Boolean;
      return this;
    }
    
    @KeepForSdk
    public Builder<A, L> setFeatures(Feature[] param1ArrayOfFeature) {
      this.zakd = param1ArrayOfFeature;
      return this;
    }
    
    @KeepForSdk
    public Builder<A, L> unregister(RemoteCall<A, TaskCompletionSource<Boolean>> param1RemoteCall) {
      this.zakb = param1RemoteCall;
      return this;
    }
    
    @Deprecated
    @KeepForSdk
    public Builder<A, L> unregister(BiConsumer<A, TaskCompletionSource<Boolean>> param1BiConsumer) {
      this.zaka = new zabz(this);
      return this;
    }
    
    @KeepForSdk
    public Builder<A, L> withHolder(ListenerHolder<L> param1ListenerHolder) {
      this.zakc = param1ListenerHolder;
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\RegistrationMethods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */