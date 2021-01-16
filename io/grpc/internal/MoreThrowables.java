package io.grpc.internal;

import com.google.common.base.Preconditions;

public final class MoreThrowables {
  public static void throwIfUnchecked(Throwable paramThrowable) {
    Preconditions.checkNotNull(paramThrowable);
    if (!(paramThrowable instanceof RuntimeException)) {
      if (!(paramThrowable instanceof Error))
        return; 
      throw (Error)paramThrowable;
    } 
    throw (RuntimeException)paramThrowable;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\MoreThrowables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */