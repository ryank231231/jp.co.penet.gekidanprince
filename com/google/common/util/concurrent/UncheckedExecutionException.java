package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public class UncheckedExecutionException extends RuntimeException {
  private static final long serialVersionUID = 0L;
  
  protected UncheckedExecutionException() {}
  
  protected UncheckedExecutionException(@Nullable String paramString) {
    super(paramString);
  }
  
  public UncheckedExecutionException(@Nullable String paramString, @Nullable Throwable paramThrowable) {
    super(paramString, paramThrowable);
  }
  
  public UncheckedExecutionException(@Nullable Throwable paramThrowable) {
    super(paramThrowable);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\UncheckedExecutionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */