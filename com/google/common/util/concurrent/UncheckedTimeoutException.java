package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;

@GwtIncompatible
public class UncheckedTimeoutException extends RuntimeException {
  private static final long serialVersionUID = 0L;
  
  public UncheckedTimeoutException() {}
  
  public UncheckedTimeoutException(@Nullable String paramString) {
    super(paramString);
  }
  
  public UncheckedTimeoutException(@Nullable String paramString, @Nullable Throwable paramThrowable) {
    super(paramString, paramThrowable);
  }
  
  public UncheckedTimeoutException(@Nullable Throwable paramThrowable) {
    super(paramThrowable);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\UncheckedTimeoutException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */