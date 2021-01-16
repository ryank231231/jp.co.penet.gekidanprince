package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public interface FutureCallback<V> {
  void onFailure(Throwable paramThrowable);
  
  void onSuccess(@Nullable V paramV);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\FutureCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */