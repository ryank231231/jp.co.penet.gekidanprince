package io.reactivex.exceptions;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.util.ExceptionHelper;

public final class Exceptions {
  private Exceptions() {
    throw new IllegalStateException("No instances!");
  }
  
  @NonNull
  public static RuntimeException propagate(@NonNull Throwable paramThrowable) {
    throw ExceptionHelper.wrapOrThrow(paramThrowable);
  }
  
  public static void throwIfFatal(@NonNull Throwable paramThrowable) {
    if (!(paramThrowable instanceof VirtualMachineError)) {
      if (!(paramThrowable instanceof ThreadDeath)) {
        if (!(paramThrowable instanceof LinkageError))
          return; 
        throw (LinkageError)paramThrowable;
      } 
      throw (ThreadDeath)paramThrowable;
    } 
    throw (VirtualMachineError)paramThrowable;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\exceptions\Exceptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */