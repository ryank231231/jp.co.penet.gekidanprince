package com.google.android.gms.tasks;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.concurrent.Executor;

public abstract class Task<TResult> {
  @NonNull
  public Task<TResult> addOnCanceledListener(@NonNull Activity paramActivity, @NonNull OnCanceledListener paramOnCanceledListener) {
    throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
  }
  
  @NonNull
  public Task<TResult> addOnCanceledListener(@NonNull OnCanceledListener paramOnCanceledListener) {
    throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
  }
  
  @NonNull
  public Task<TResult> addOnCanceledListener(@NonNull Executor paramExecutor, @NonNull OnCanceledListener paramOnCanceledListener) {
    throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
  }
  
  @NonNull
  public Task<TResult> addOnCompleteListener(@NonNull Activity paramActivity, @NonNull OnCompleteListener<TResult> paramOnCompleteListener) {
    throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
  }
  
  @NonNull
  public Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> paramOnCompleteListener) {
    throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
  }
  
  @NonNull
  public Task<TResult> addOnCompleteListener(@NonNull Executor paramExecutor, @NonNull OnCompleteListener<TResult> paramOnCompleteListener) {
    throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
  }
  
  @NonNull
  public abstract Task<TResult> addOnFailureListener(@NonNull Activity paramActivity, @NonNull OnFailureListener paramOnFailureListener);
  
  @NonNull
  public abstract Task<TResult> addOnFailureListener(@NonNull OnFailureListener paramOnFailureListener);
  
  @NonNull
  public abstract Task<TResult> addOnFailureListener(@NonNull Executor paramExecutor, @NonNull OnFailureListener paramOnFailureListener);
  
  @NonNull
  public abstract Task<TResult> addOnSuccessListener(@NonNull Activity paramActivity, @NonNull OnSuccessListener<? super TResult> paramOnSuccessListener);
  
  @NonNull
  public abstract Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> paramOnSuccessListener);
  
  @NonNull
  public abstract Task<TResult> addOnSuccessListener(@NonNull Executor paramExecutor, @NonNull OnSuccessListener<? super TResult> paramOnSuccessListener);
  
  @NonNull
  public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> paramContinuation) {
    throw new UnsupportedOperationException("continueWith is not implemented");
  }
  
  @NonNull
  public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, TContinuationResult> paramContinuation) {
    throw new UnsupportedOperationException("continueWith is not implemented");
  }
  
  @NonNull
  public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> paramContinuation) {
    throw new UnsupportedOperationException("continueWithTask is not implemented");
  }
  
  @NonNull
  public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, Task<TContinuationResult>> paramContinuation) {
    throw new UnsupportedOperationException("continueWithTask is not implemented");
  }
  
  @Nullable
  public abstract Exception getException();
  
  @Nullable
  public abstract TResult getResult();
  
  @Nullable
  public abstract <X extends Throwable> TResult getResult(@NonNull Class<X> paramClass) throws X;
  
  public abstract boolean isCanceled();
  
  public abstract boolean isComplete();
  
  public abstract boolean isSuccessful();
  
  @NonNull
  public <TContinuationResult> Task<TContinuationResult> onSuccessTask(@NonNull SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation) {
    throw new UnsupportedOperationException("onSuccessTask is not implemented");
  }
  
  @NonNull
  public <TContinuationResult> Task<TContinuationResult> onSuccessTask(@NonNull Executor paramExecutor, @NonNull SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation) {
    throw new UnsupportedOperationException("onSuccessTask is not implemented");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\tasks\Task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */