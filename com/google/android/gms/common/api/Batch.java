package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends BasePendingResult<BatchResult> {
  private final Object mLock = new Object();
  
  private int zaaz;
  
  private boolean zaba;
  
  private boolean zabb;
  
  private final PendingResult<?>[] zabc;
  
  private Batch(List<PendingResult<?>> paramList, GoogleApiClient paramGoogleApiClient) {
    super(paramGoogleApiClient);
    this.zaaz = paramList.size();
    this.zabc = (PendingResult<?>[])new PendingResult[this.zaaz];
    if (paramList.isEmpty()) {
      setResult(new BatchResult(Status.RESULT_SUCCESS, this.zabc));
      return;
    } 
    for (byte b = 0; b < paramList.size(); b++) {
      PendingResult<?> pendingResult = paramList.get(b);
      this.zabc[b] = pendingResult;
      pendingResult.addStatusListener(new zaa(this));
    } 
  }
  
  public final void cancel() {
    super.cancel();
    PendingResult<?>[] arrayOfPendingResult = this.zabc;
    int i = arrayOfPendingResult.length;
    for (byte b = 0; b < i; b++)
      arrayOfPendingResult[b].cancel(); 
  }
  
  public final BatchResult createFailedResult(Status paramStatus) {
    return new BatchResult(paramStatus, this.zabc);
  }
  
  public static final class Builder {
    private List<PendingResult<?>> zabe = new ArrayList<PendingResult<?>>();
    
    private GoogleApiClient zabf;
    
    public Builder(GoogleApiClient param1GoogleApiClient) {
      this.zabf = param1GoogleApiClient;
    }
    
    public final <R extends Result> BatchResultToken<R> add(PendingResult<R> param1PendingResult) {
      BatchResultToken<Result> batchResultToken = new BatchResultToken<Result>(this.zabe.size());
      this.zabe.add(param1PendingResult);
      return (BatchResultToken)batchResultToken;
    }
    
    public final Batch build() {
      return new Batch(this.zabe, this.zabf, null);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\Batch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */