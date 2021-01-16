package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public final class SettableFuture<V> extends AbstractFuture.TrustedFuture<V> {
  public static <V> SettableFuture<V> create() {
    return new SettableFuture<V>();
  }
  
  @CanIgnoreReturnValue
  public boolean set(@Nullable V paramV) {
    return super.set(paramV);
  }
  
  @CanIgnoreReturnValue
  public boolean setException(Throwable paramThrowable) {
    return super.setException(paramThrowable);
  }
  
  @Beta
  @CanIgnoreReturnValue
  public boolean setFuture(ListenableFuture<? extends V> paramListenableFuture) {
    return super.setFuture(paramListenableFuture);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\SettableFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */