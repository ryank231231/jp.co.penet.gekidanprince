package com.google.android.gms.common.api;

final class zaa implements PendingResult.StatusListener {
  zaa(Batch paramBatch) {}
  
  public final void onComplete(Status paramStatus) {
    synchronized (Batch.zaa(this.zabd)) {
      if (this.zabd.isCanceled())
        return; 
      if (paramStatus.isCanceled()) {
        Batch.zaa(this.zabd, true);
      } else if (!paramStatus.isSuccess()) {
        Batch.zab(this.zabd, true);
      } 
      Batch.zab(this.zabd);
      if (Batch.zac(this.zabd) == 0)
        if (Batch.zad(this.zabd)) {
          Batch.zae(this.zabd);
        } else {
          if (Batch.zaf(this.zabd)) {
            paramStatus = new Status();
            this(13);
          } else {
            paramStatus = Status.RESULT_SUCCESS;
          } 
          Batch batch = this.zabd;
          BatchResult batchResult = new BatchResult();
          this(paramStatus, (PendingResult<?>[])Batch.zag(this.zabd));
          batch.setResult(batchResult);
        }  
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */