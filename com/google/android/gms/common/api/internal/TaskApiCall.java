package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {
  private final Feature[] zakd = null;
  
  private final boolean zakk = false;
  
  @Deprecated
  @KeepForSdk
  public TaskApiCall() {}
  
  @KeepForSdk
  private TaskApiCall(Feature[] paramArrayOfFeature, boolean paramBoolean) {}
  
  @KeepForSdk
  public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder() {
    return new Builder<A, ResultT>(null);
  }
  
  @KeepForSdk
  protected abstract void doExecute(A paramA, TaskCompletionSource<ResultT> paramTaskCompletionSource) throws RemoteException;
  
  @KeepForSdk
  public boolean shouldAutoResolveMissingFeatures() {
    return this.zakk;
  }
  
  @Nullable
  public final Feature[] zabt() {
    return this.zakd;
  }
  
  @KeepForSdk
  public static class Builder<A extends Api.AnyClient, ResultT> {
    private Feature[] zakd;
    
    private boolean zakk = true;
    
    private RemoteCall<A, TaskCompletionSource<ResultT>> zakl;
    
    private Builder() {}
    
    @KeepForSdk
    public TaskApiCall<A, ResultT> build() {
      boolean bool;
      if (this.zakl != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "execute parameter required");
      return new zack(this, this.zakd, this.zakk);
    }
    
    @Deprecated
    @KeepForSdk
    public Builder<A, ResultT> execute(BiConsumer<A, TaskCompletionSource<ResultT>> param1BiConsumer) {
      this.zakl = new zacj(param1BiConsumer);
      return this;
    }
    
    @KeepForSdk
    public Builder<A, ResultT> run(RemoteCall<A, TaskCompletionSource<ResultT>> param1RemoteCall) {
      this.zakl = param1RemoteCall;
      return this;
    }
    
    @KeepForSdk
    public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean param1Boolean) {
      this.zakk = param1Boolean;
      return this;
    }
    
    @KeepForSdk
    public Builder<A, ResultT> setFeatures(Feature... param1VarArgs) {
      this.zakd = param1VarArgs;
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\TaskApiCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */