package io.reactivex.exceptions;

import io.reactivex.annotations.Beta;
import io.reactivex.annotations.NonNull;

@Beta
public final class OnErrorNotImplementedException extends RuntimeException {
  private static final long serialVersionUID = -6298857009889503852L;
  
  public OnErrorNotImplementedException(String paramString, @NonNull Throwable paramThrowable) {
    super(paramString, paramThrowable);
  }
  
  public OnErrorNotImplementedException(@NonNull Throwable paramThrowable) {
    super(str, paramThrowable);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\exceptions\OnErrorNotImplementedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */