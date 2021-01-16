package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapCompletableCompletable<T> extends Completable implements FuseToObservable<T> {
  final boolean delayErrors;
  
  final Function<? super T, ? extends CompletableSource> mapper;
  
  final ObservableSource<T> source;
  
  public ObservableFlatMapCompletableCompletable(ObservableSource<T> paramObservableSource, Function<? super T, ? extends CompletableSource> paramFunction, boolean paramBoolean) {
    this.source = paramObservableSource;
    this.mapper = paramFunction;
    this.delayErrors = paramBoolean;
  }
  
  public Observable<T> fuseToObservable() {
    return RxJavaPlugins.onAssembly(new ObservableFlatMapCompletable<T>(this.source, this.mapper, this.delayErrors));
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    this.source.subscribe(new FlatMapCompletableMainObserver<T>(paramCompletableObserver, this.mapper, this.delayErrors));
  }
  
  static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements Disposable, Observer<T> {
    private static final long serialVersionUID = 8443155186132538303L;
    
    final CompletableObserver actual;
    
    Disposable d;
    
    final boolean delayErrors;
    
    volatile boolean disposed;
    
    final AtomicThrowable errors;
    
    final Function<? super T, ? extends CompletableSource> mapper;
    
    final CompositeDisposable set;
    
    FlatMapCompletableMainObserver(CompletableObserver param1CompletableObserver, Function<? super T, ? extends CompletableSource> param1Function, boolean param1Boolean) {
      this.actual = param1CompletableObserver;
      this.mapper = param1Function;
      this.delayErrors = param1Boolean;
      this.errors = new AtomicThrowable();
      this.set = new CompositeDisposable();
      lazySet(1);
    }
    
    public void dispose() {
      this.disposed = true;
      this.d.dispose();
      this.set.dispose();
    }
    
    void innerComplete(InnerObserver param1InnerObserver) {
      this.set.delete(param1InnerObserver);
      onComplete();
    }
    
    void innerError(InnerObserver param1InnerObserver, Throwable param1Throwable) {
      this.set.delete(param1InnerObserver);
      onError(param1Throwable);
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onComplete() {
      if (decrementAndGet() == 0) {
        Throwable throwable = this.errors.terminate();
        if (throwable != null) {
          this.actual.onError(throwable);
        } else {
          this.actual.onComplete();
        } 
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.errors.addThrowable(param1Throwable)) {
        if (this.delayErrors) {
          if (decrementAndGet() == 0) {
            param1Throwable = this.errors.terminate();
            this.actual.onError(param1Throwable);
          } 
        } else {
          dispose();
          if (getAndSet(0) > 0) {
            param1Throwable = this.errors.terminate();
            this.actual.onError(param1Throwable);
          } 
        } 
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(T param1T) {
      try {
        CompletableSource completableSource = (CompletableSource)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper returned a null CompletableSource");
        getAndIncrement();
        InnerObserver innerObserver = new InnerObserver();
        if (!this.disposed && this.set.add(innerObserver))
          completableSource.subscribe(innerObserver); 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.d.dispose();
        onError(throwable);
        return;
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
      private static final long serialVersionUID = 8606673141535671828L;
      
      public void dispose() {
        DisposableHelper.dispose(this);
      }
      
      public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
      }
      
      public void onComplete() {
        ObservableFlatMapCompletableCompletable.FlatMapCompletableMainObserver.this.innerComplete(this);
      }
      
      public void onError(Throwable param2Throwable) {
        ObservableFlatMapCompletableCompletable.FlatMapCompletableMainObserver.this.innerError(this, param2Throwable);
      }
      
      public void onSubscribe(Disposable param2Disposable) {
        DisposableHelper.setOnce(this, param2Disposable);
      }
    }
  }
  
  final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
    private static final long serialVersionUID = 8606673141535671828L;
    
    public void dispose() {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(get());
    }
    
    public void onComplete() {
      this.this$0.innerComplete(this);
    }
    
    public void onError(Throwable param1Throwable) {
      this.this$0.innerError(this, param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.setOnce(this, param1Disposable);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableFlatMapCompletableCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */