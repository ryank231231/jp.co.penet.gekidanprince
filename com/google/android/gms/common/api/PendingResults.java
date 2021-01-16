package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public final class PendingResults {
  public static PendingResult<Status> canceledPendingResult() {
    StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
    statusPendingResult.cancel();
    return (PendingResult<Status>)statusPendingResult;
  }
  
  public static <R extends Result> PendingResult<R> canceledPendingResult(R paramR) {
    boolean bool;
    Preconditions.checkNotNull(paramR, "Result must not be null");
    if (paramR.getStatus().getStatusCode() == 16) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Status code must be CommonStatusCodes.CANCELED");
    zaa<R> zaa = new zaa<R>(paramR);
    zaa.cancel();
    return (PendingResult<R>)zaa;
  }
  
  @KeepForSdk
  public static <R extends Result> PendingResult<R> immediateFailedResult(R paramR, GoogleApiClient paramGoogleApiClient) {
    Preconditions.checkNotNull(paramR, "Result must not be null");
    Preconditions.checkArgument(paramR.getStatus().isSuccess() ^ true, "Status code must not be SUCCESS");
    zab<R> zab = new zab<R>(paramGoogleApiClient, paramR);
    zab.setResult((Result)paramR);
    return (PendingResult<R>)zab;
  }
  
  @KeepForSdk
  public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R paramR) {
    Preconditions.checkNotNull(paramR, "Result must not be null");
    zac<Result> zac = new zac<Result>(null);
    zac.setResult((Result)paramR);
    return (OptionalPendingResult<R>)new OptionalPendingResultImpl((PendingResult)zac);
  }
  
  @KeepForSdk
  public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R paramR, GoogleApiClient paramGoogleApiClient) {
    Preconditions.checkNotNull(paramR, "Result must not be null");
    zac<Result> zac = new zac<Result>(paramGoogleApiClient);
    zac.setResult((Result)paramR);
    return (OptionalPendingResult<R>)new OptionalPendingResultImpl((PendingResult)zac);
  }
  
  @KeepForSdk
  public static PendingResult<Status> immediatePendingResult(Status paramStatus) {
    Preconditions.checkNotNull(paramStatus, "Result must not be null");
    StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
    statusPendingResult.setResult(paramStatus);
    return (PendingResult<Status>)statusPendingResult;
  }
  
  @KeepForSdk
  public static PendingResult<Status> immediatePendingResult(Status paramStatus, GoogleApiClient paramGoogleApiClient) {
    Preconditions.checkNotNull(paramStatus, "Result must not be null");
    StatusPendingResult statusPendingResult = new StatusPendingResult(paramGoogleApiClient);
    statusPendingResult.setResult(paramStatus);
    return (PendingResult<Status>)statusPendingResult;
  }
  
  private static final class zaa<R extends Result> extends BasePendingResult<R> {
    private final R zach;
    
    public zaa(R param1R) {
      super(Looper.getMainLooper());
      this.zach = param1R;
    }
    
    protected final R createFailedResult(Status param1Status) {
      if (param1Status.getStatusCode() == this.zach.getStatus().getStatusCode())
        return this.zach; 
      throw new UnsupportedOperationException("Creating failed results is not supported");
    }
  }
  
  private static final class zab<R extends Result> extends BasePendingResult<R> {
    private final R zaci;
    
    public zab(GoogleApiClient param1GoogleApiClient, R param1R) {
      super(param1GoogleApiClient);
      this.zaci = param1R;
    }
    
    protected final R createFailedResult(Status param1Status) {
      return this.zaci;
    }
  }
  
  private static final class zac<R extends Result> extends BasePendingResult<R> {
    public zac(GoogleApiClient param1GoogleApiClient) {
      super(param1GoogleApiClient);
    }
    
    protected final R createFailedResult(Status param1Status) {
      throw new UnsupportedOperationException("Creating failed results is not supported");
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\PendingResults.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */