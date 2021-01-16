package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.BasicFuseableObserver;

@Experimental
public final class ObservableDoAfterNext<T> extends AbstractObservableWithUpstream<T, T> {
  final Consumer<? super T> onAfterNext;
  
  public ObservableDoAfterNext(ObservableSource<T> paramObservableSource, Consumer<? super T> paramConsumer) {
    super(paramObservableSource);
    this.onAfterNext = paramConsumer;
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe((Observer)new DoAfterObserver<T>(paramObserver, this.onAfterNext));
  }
  
  static final class DoAfterObserver<T> extends BasicFuseableObserver<T, T> {
    final Consumer<? super T> onAfterNext;
    
    DoAfterObserver(Observer<? super T> param1Observer, Consumer<? super T> param1Consumer) {
      super(param1Observer);
      this.onAfterNext = param1Consumer;
    }
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
      if (this.sourceMode == 0)
        try {
          this.onAfterNext.accept(param1T);
        } catch (Throwable throwable) {
          fail(throwable);
        }  
    }
    
    @Nullable
    public T poll() throws Exception {
      Object object = this.qs.poll();
      if (object != null)
        this.onAfterNext.accept(object); 
      return (T)object;
    }
    
    public int requestFusion(int param1Int) {
      return transitiveBoundaryFusion(param1Int);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableDoAfterNext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */