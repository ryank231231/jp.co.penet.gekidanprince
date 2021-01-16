package io.reactivex.disposables;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SerialDisposable implements Disposable {
  final AtomicReference<Disposable> resource = new AtomicReference<Disposable>();
  
  public SerialDisposable() {}
  
  public SerialDisposable(@Nullable Disposable paramDisposable) {}
  
  public void dispose() {
    DisposableHelper.dispose(this.resource);
  }
  
  @Nullable
  public Disposable get() {
    Disposable disposable = this.resource.get();
    return (disposable == DisposableHelper.DISPOSED) ? Disposables.disposed() : disposable;
  }
  
  public boolean isDisposed() {
    return DisposableHelper.isDisposed(this.resource.get());
  }
  
  public boolean replace(@Nullable Disposable paramDisposable) {
    return DisposableHelper.replace(this.resource, paramDisposable);
  }
  
  public boolean set(@Nullable Disposable paramDisposable) {
    return DisposableHelper.set(this.resource, paramDisposable);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\disposables\SerialDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */