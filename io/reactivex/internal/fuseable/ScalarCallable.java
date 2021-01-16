package io.reactivex.internal.fuseable;

import java.util.concurrent.Callable;

public interface ScalarCallable<T> extends Callable<T> {
  T call();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\fuseable\ScalarCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */