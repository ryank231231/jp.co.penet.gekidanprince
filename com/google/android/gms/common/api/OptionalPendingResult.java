package com.google.android.gms.common.api;

public abstract class OptionalPendingResult<R extends Result> extends PendingResult<R> {
  public abstract R get();
  
  public abstract boolean isDone();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\OptionalPendingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */