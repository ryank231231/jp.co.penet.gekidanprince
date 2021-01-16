package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ResourceObserver<T> implements Observer<T>, Disposable {
  private final ListCompositeDisposable resources = new ListCompositeDisposable();
  
  private final AtomicReference<Disposable> s = new AtomicReference<Disposable>();
  
  public final void add(@NonNull Disposable paramDisposable) {
    ObjectHelper.requireNonNull(paramDisposable, "resource is null");
    this.resources.add(paramDisposable);
  }
  
  public final void dispose() {
    if (DisposableHelper.dispose(this.s))
      this.resources.dispose(); 
  }
  
  public final boolean isDisposed() {
    return DisposableHelper.isDisposed(this.s.get());
  }
  
  protected void onStart() {}
  
  public final void onSubscribe(Disposable paramDisposable) {
    if (EndConsumerHelper.setOnce(this.s, paramDisposable, getClass()))
      onStart(); 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\observers\ResourceObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */