package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRepeatWhen<T> extends AbstractObservableWithUpstream<T, T> {
  final Function<? super Observable<Object>, ? extends ObservableSource<?>> handler;
  
  public ObservableRepeatWhen(ObservableSource<T> paramObservableSource, Function<? super Observable<Object>, ? extends ObservableSource<?>> paramFunction) {
    super(paramObservableSource);
    this.handler = paramFunction;
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver) {
    Subject subject = PublishSubject.create().toSerialized();
    try {
      ObservableSource observableSource = (ObservableSource)ObjectHelper.requireNonNull(this.handler.apply(subject), "The handler returned a null ObservableSource");
      RepeatWhenObserver<T> repeatWhenObserver = new RepeatWhenObserver<T>(paramObserver, subject, this.source);
      paramObserver.onSubscribe(repeatWhenObserver);
      observableSource.subscribe(repeatWhenObserver.inner);
      repeatWhenObserver.subscribeNext();
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramObserver);
      return;
    } 
  }
  
  static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
    private static final long serialVersionUID = 802743776666017014L;
    
    volatile boolean active;
    
    final Observer<? super T> actual;
    
    final AtomicReference<Disposable> d;
    
    final AtomicThrowable error;
    
    final InnerRepeatObserver inner;
    
    final Subject<Object> signaller;
    
    final ObservableSource<T> source;
    
    final AtomicInteger wip;
    
    RepeatWhenObserver(Observer<? super T> param1Observer, Subject<Object> param1Subject, ObservableSource<T> param1ObservableSource) {
      this.actual = param1Observer;
      this.signaller = param1Subject;
      this.source = param1ObservableSource;
      this.wip = new AtomicInteger();
      this.error = new AtomicThrowable();
      this.inner = new InnerRepeatObserver();
      this.d = new AtomicReference<Disposable>();
    }
    
    public void dispose() {
      DisposableHelper.dispose(this.d);
      DisposableHelper.dispose(this.inner);
    }
    
    void innerComplete() {
      DisposableHelper.dispose(this.d);
      HalfSerializer.onComplete(this.actual, this, this.error);
    }
    
    void innerError(Throwable param1Throwable) {
      DisposableHelper.dispose(this.d);
      HalfSerializer.onError(this.actual, param1Throwable, this, this.error);
    }
    
    void innerNext() {
      subscribeNext();
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(this.d.get());
    }
    
    public void onComplete() {
      this.active = false;
      this.signaller.onNext(Integer.valueOf(0));
    }
    
    public void onError(Throwable param1Throwable) {
      DisposableHelper.dispose(this.inner);
      HalfSerializer.onError(this.actual, param1Throwable, this, this.error);
    }
    
    public void onNext(T param1T) {
      HalfSerializer.onNext(this.actual, param1T, this, this.error);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.replace(this.d, param1Disposable);
    }
    
    void subscribeNext() {
      if (this.wip.getAndIncrement() == 0)
        do {
          if (isDisposed())
            return; 
          if (this.active)
            continue; 
          this.active = true;
          this.source.subscribe(this);
        } while (this.wip.decrementAndGet() != 0); 
    }
    
    final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
      private static final long serialVersionUID = 3254781284376480842L;
      
      public void onComplete() {
        ObservableRepeatWhen.RepeatWhenObserver.this.innerComplete();
      }
      
      public void onError(Throwable param2Throwable) {
        ObservableRepeatWhen.RepeatWhenObserver.this.innerError(param2Throwable);
      }
      
      public void onNext(Object param2Object) {
        ObservableRepeatWhen.RepeatWhenObserver.this.innerNext();
      }
      
      public void onSubscribe(Disposable param2Disposable) {
        DisposableHelper.setOnce(this, param2Disposable);
      }
    }
  }
  
  final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
    private static final long serialVersionUID = 3254781284376480842L;
    
    public void onComplete() {
      this.this$0.innerComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.this$0.innerError(param1Throwable);
    }
    
    public void onNext(Object param1Object) {
      this.this$0.innerNext();
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.setOnce(this, param1Disposable);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableRepeatWhen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */