package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public interface AsyncFunction<I, O> {
  ListenableFuture<O> apply(@Nullable I paramI) throws Exception;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\AsyncFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */