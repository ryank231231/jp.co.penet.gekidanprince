package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

@GwtIncompatible
public class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {
  private final ExecutionList executionList = new ExecutionList();
  
  ListenableFutureTask(Runnable paramRunnable, @Nullable V paramV) {
    super(paramRunnable, paramV);
  }
  
  ListenableFutureTask(Callable<V> paramCallable) {
    super(paramCallable);
  }
  
  public static <V> ListenableFutureTask<V> create(Runnable paramRunnable, @Nullable V paramV) {
    return new ListenableFutureTask<V>(paramRunnable, paramV);
  }
  
  public static <V> ListenableFutureTask<V> create(Callable<V> paramCallable) {
    return new ListenableFutureTask<V>(paramCallable);
  }
  
  public void addListener(Runnable paramRunnable, Executor paramExecutor) {
    this.executionList.add(paramRunnable, paramExecutor);
  }
  
  protected void done() {
    this.executionList.execute();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\ListenableFutureTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */