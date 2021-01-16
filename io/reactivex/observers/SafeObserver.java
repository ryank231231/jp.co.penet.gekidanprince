package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class SafeObserver<T> implements Observer<T>, Disposable {
  final Observer<? super T> actual;
  
  boolean done;
  
  Disposable s;
  
  public SafeObserver(@NonNull Observer<? super T> paramObserver) {
    this.actual = paramObserver;
  }
  
  public void dispose() {
    this.s.dispose();
  }
  
  public boolean isDisposed() {
    return this.s.isDisposed();
  }
  
  public void onComplete() {
    if (this.done)
      return; 
    this.done = true;
    if (this.s == null) {
      onCompleteNoSubscription();
      return;
    } 
    try {
      this.actual.onComplete();
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError(throwable);
    } 
  }
  
  void onCompleteNoSubscription() {
    NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
    try {
      this.actual.onSubscribe((Disposable)EmptyDisposable.INSTANCE);
      try {
        this.actual.onError(nullPointerException);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { nullPointerException, throwable }));
      } 
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { nullPointerException, throwable }));
      return;
    } 
  }
  
  public void onError(@NonNull Throwable paramThrowable) {
    if (this.done) {
      RxJavaPlugins.onError(paramThrowable);
      return;
    } 
    this.done = true;
    if (this.s == null) {
      NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
      try {
        this.actual.onSubscribe((Disposable)EmptyDisposable.INSTANCE);
        try {
          Observer<? super T> observer = this.actual;
          CompositeException compositeException = new CompositeException();
          this(new Throwable[] { paramThrowable, nullPointerException });
          observer.onError((Throwable)compositeException);
        } catch (Throwable throwable1) {
          Exceptions.throwIfFatal(throwable1);
          RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { paramThrowable, nullPointerException, throwable1 }));
        } 
        return;
      } catch (Throwable throwable1) {
        Exceptions.throwIfFatal(throwable1);
        RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { paramThrowable, nullPointerException, throwable1 }));
        return;
      } 
    } 
    Throwable throwable = paramThrowable;
    if (paramThrowable == null)
      throwable = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."); 
    try {
      this.actual.onError(throwable);
    } catch (Throwable throwable1) {
      Exceptions.throwIfFatal(throwable1);
      RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { throwable, throwable1 }));
    } 
  }
  
  public void onNext(@NonNull T paramT) {
    NullPointerException nullPointerException;
    if (this.done)
      return; 
    if (this.s == null) {
      onNextNoSubscription();
      return;
    } 
    if (paramT == null) {
      nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
      try {
        this.s.dispose();
        onError(nullPointerException);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        onError((Throwable)new CompositeException(new Throwable[] { nullPointerException, throwable }));
        return;
      } 
    } 
    try {
      this.actual.onNext(nullPointerException);
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      try {
        this.s.dispose();
        onError(throwable);
        return;
      } catch (Throwable throwable1) {
        Exceptions.throwIfFatal(throwable1);
        onError((Throwable)new CompositeException(new Throwable[] { throwable, throwable1 }));
        return;
      } 
    } 
  }
  
  void onNextNoSubscription() {
    this.done = true;
    NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
    try {
      this.actual.onSubscribe((Disposable)EmptyDisposable.INSTANCE);
      try {
        this.actual.onError(nullPointerException);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { nullPointerException, throwable }));
      } 
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { nullPointerException, throwable }));
      return;
    } 
  }
  
  public void onSubscribe(@NonNull Disposable paramDisposable) {
    if (DisposableHelper.validate(this.s, paramDisposable)) {
      this.s = paramDisposable;
      try {
        this.actual.onSubscribe(this);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.done = true;
        try {
          paramDisposable.dispose();
          RxJavaPlugins.onError(throwable);
        } catch (Throwable throwable1) {
          Exceptions.throwIfFatal(throwable1);
          RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { throwable, throwable1 }));
          return;
        } 
      } 
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\observers\SafeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */