package io.reactivex.exceptions;

import io.reactivex.annotations.Beta;

@Beta
public final class UndeliverableException extends IllegalStateException {
  private static final long serialVersionUID = 1644750035281290266L;
  
  public UndeliverableException(Throwable paramThrowable) {
    super(paramThrowable);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\exceptions\UndeliverableException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */