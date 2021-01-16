package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Callables {
  @Beta
  @GwtIncompatible
  public static <T> AsyncCallable<T> asAsyncCallable(final Callable<T> callable, final ListeningExecutorService listeningExecutorService) {
    Preconditions.checkNotNull(callable);
    Preconditions.checkNotNull(listeningExecutorService);
    return new AsyncCallable<T>() {
        public ListenableFuture<T> call() throws Exception {
          return listeningExecutorService.submit(callable);
        }
      };
  }
  
  public static <T> Callable<T> returning(@Nullable final T value) {
    return new Callable<T>() {
        public T call() {
          return (T)value;
        }
      };
  }
  
  @GwtIncompatible
  static Runnable threadRenaming(final Runnable task, final Supplier<String> nameSupplier) {
    Preconditions.checkNotNull(nameSupplier);
    Preconditions.checkNotNull(task);
    return new Runnable() {
        public void run() {
          Thread thread = Thread.currentThread();
          String str = thread.getName();
          boolean bool = Callables.trySetName((String)nameSupplier.get(), thread);
          try {
            task.run();
            return;
          } finally {
            if (bool)
              Callables.trySetName(str, thread); 
          } 
        }
      };
  }
  
  @GwtIncompatible
  static <T> Callable<T> threadRenaming(final Callable<T> callable, final Supplier<String> nameSupplier) {
    Preconditions.checkNotNull(nameSupplier);
    Preconditions.checkNotNull(callable);
    return new Callable<T>() {
        public T call() throws Exception {
          Thread thread = Thread.currentThread();
          String str = thread.getName();
          boolean bool = Callables.trySetName((String)nameSupplier.get(), thread);
          try {
            return (T)callable.call();
          } finally {
            if (bool)
              Callables.trySetName(str, thread); 
          } 
        }
      };
  }
  
  @GwtIncompatible
  private static boolean trySetName(String paramString, Thread paramThread) {
    try {
      paramThread.setName(paramString);
      return true;
    } catch (SecurityException securityException) {
      return false;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\Callables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */