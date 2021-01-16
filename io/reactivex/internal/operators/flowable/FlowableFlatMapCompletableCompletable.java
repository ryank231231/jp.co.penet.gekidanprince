package io.reactivex.internal.operators.flowable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapCompletableCompletable<T> extends Completable implements FuseToFlowable<T> {
  final boolean delayErrors;
  
  final Function<? super T, ? extends CompletableSource> mapper;
  
  final int maxConcurrency;
  
  final Flowable<T> source;
  
  public FlowableFlatMapCompletableCompletable(Flowable<T> paramFlowable, Function<? super T, ? extends CompletableSource> paramFunction, boolean paramBoolean, int paramInt) {
    this.source = paramFlowable;
    this.mapper = paramFunction;
    this.delayErrors = paramBoolean;
    this.maxConcurrency = paramInt;
  }
  
  public Flowable<T> fuseToFlowable() {
    return RxJavaPlugins.onAssembly(new FlowableFlatMapCompletable<T>(this.source, this.mapper, this.delayErrors, this.maxConcurrency));
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    this.source.subscribe(new FlatMapCompletableMainSubscriber<T>(paramCompletableObserver, this.mapper, this.delayErrors, this.maxConcurrency));
  }
  
  static final class FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
    private static final long serialVersionUID = 8443155186132538303L;
    
    final CompletableObserver actual;
    
    final boolean delayErrors;
    
    volatile boolean disposed;
    
    final AtomicThrowable errors;
    
    final Function<? super T, ? extends CompletableSource> mapper;
    
    final int maxConcurrency;
    
    Subscription s;
    
    final CompositeDisposable set;
    
    FlatMapCompletableMainSubscriber(CompletableObserver param1CompletableObserver, Function<? super T, ? extends CompletableSource> param1Function, boolean param1Boolean, int param1Int) {
      this.actual = param1CompletableObserver;
      this.mapper = param1Function;
      this.delayErrors = param1Boolean;
      this.errors = new AtomicThrowable();
      this.set = new CompositeDisposable();
      this.maxConcurrency = param1Int;
      lazySet(1);
    }
    
    public void dispose() {
      this.disposed = true;
      this.s.cancel();
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
      return this.set.isDisposed();
    }
    
    public void onComplete() {
      if (decrementAndGet() == 0) {
        Throwable throwable = this.errors.terminate();
        if (throwable != null) {
          this.actual.onError(throwable);
        } else {
          this.actual.onComplete();
        } 
      } else if (this.maxConcurrency != Integer.MAX_VALUE) {
        this.s.request(1L);
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.errors.addThrowable(param1Throwable)) {
        if (this.delayErrors) {
          if (decrementAndGet() == 0) {
            param1Throwable = this.errors.terminate();
            this.actual.onError(param1Throwable);
          } else if (this.maxConcurrency != Integer.MAX_VALUE) {
            this.s.request(1L);
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
        this.s.cancel();
        onError(throwable);
        return;
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
        int i = this.maxConcurrency;
        if (i == Integer.MAX_VALUE) {
          param1Subscription.request(Long.MAX_VALUE);
        } else {
          param1Subscription.request(i);
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
        FlowableFlatMapCompletableCompletable.FlatMapCompletableMainSubscriber.this.innerComplete(this);
      }
      
      public void onError(Throwable param2Throwable) {
        FlowableFlatMapCompletableCompletable.FlatMapCompletableMainSubscriber.this.innerError(this, param2Throwable);
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableFlatMapCompletableCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */