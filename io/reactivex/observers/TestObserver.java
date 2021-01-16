package io.reactivex.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements Observer<T>, Disposable, MaybeObserver<T>, SingleObserver<T>, CompletableObserver {
  private final Observer<? super T> actual;
  
  private QueueDisposable<T> qs;
  
  private final AtomicReference<Disposable> subscription = new AtomicReference<Disposable>();
  
  public TestObserver() {
    this(EmptyObserver.INSTANCE);
  }
  
  public TestObserver(Observer<? super T> paramObserver) {
    this.actual = paramObserver;
  }
  
  public static <T> TestObserver<T> create() {
    return new TestObserver<T>();
  }
  
  public static <T> TestObserver<T> create(Observer<? super T> paramObserver) {
    return new TestObserver<T>(paramObserver);
  }
  
  static String fusionModeToString(int paramInt) {
    StringBuilder stringBuilder;
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown(");
        stringBuilder.append(paramInt);
        stringBuilder.append(")");
        return stringBuilder.toString();
      case 2:
        return "ASYNC";
      case 1:
        return "SYNC";
      case 0:
        break;
    } 
    return "NONE";
  }
  
  final TestObserver<T> assertFuseable() {
    if (this.qs != null)
      return this; 
    throw new AssertionError("Upstream is not fuseable.");
  }
  
  final TestObserver<T> assertFusionMode(int paramInt) {
    int i = this.establishedFusionMode;
    if (i != paramInt) {
      if (this.qs != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fusion mode different. Expected: ");
        stringBuilder.append(fusionModeToString(paramInt));
        stringBuilder.append(", actual: ");
        stringBuilder.append(fusionModeToString(i));
        throw new AssertionError(stringBuilder.toString());
      } 
      throw fail("Upstream is not fuseable");
    } 
    return this;
  }
  
  final TestObserver<T> assertNotFuseable() {
    if (this.qs == null)
      return this; 
    throw new AssertionError("Upstream is fuseable.");
  }
  
  public final TestObserver<T> assertNotSubscribed() {
    if (this.subscription.get() == null) {
      if (this.errors.isEmpty())
        return this; 
      throw fail("Not subscribed but errors found");
    } 
    throw fail("Subscribed!");
  }
  
  public final TestObserver<T> assertOf(Consumer<? super TestObserver<T>> paramConsumer) {
    try {
      paramConsumer.accept(this);
      return this;
    } catch (Throwable throwable) {
      throw ExceptionHelper.wrapOrThrow(throwable);
    } 
  }
  
  public final TestObserver<T> assertSubscribed() {
    if (this.subscription.get() != null)
      return this; 
    throw fail("Not subscribed!");
  }
  
  public final void cancel() {
    dispose();
  }
  
  public final void dispose() {
    DisposableHelper.dispose(this.subscription);
  }
  
  public final boolean hasSubscription() {
    boolean bool;
    if (this.subscription.get() != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public final boolean isCancelled() {
    return isDisposed();
  }
  
  public final boolean isDisposed() {
    return DisposableHelper.isDisposed(this.subscription.get());
  }
  
  public void onComplete() {
    if (!this.checkSubscriptionOnce) {
      this.checkSubscriptionOnce = true;
      if (this.subscription.get() == null)
        this.errors.add(new IllegalStateException("onSubscribe not called in proper order")); 
    } 
    try {
      this.lastThread = Thread.currentThread();
      this.completions++;
      this.actual.onComplete();
      return;
    } finally {
      this.done.countDown();
    } 
  }
  
  public void onError(Throwable paramThrowable) {
    if (!this.checkSubscriptionOnce) {
      this.checkSubscriptionOnce = true;
      if (this.subscription.get() == null)
        this.errors.add(new IllegalStateException("onSubscribe not called in proper order")); 
    } 
    try {
      this.lastThread = Thread.currentThread();
      if (paramThrowable == null) {
        List<Throwable> list = this.errors;
        NullPointerException nullPointerException = new NullPointerException();
        this("onError received a null Throwable");
        list.add(nullPointerException);
      } else {
        this.errors.add(paramThrowable);
      } 
      this.actual.onError(paramThrowable);
      return;
    } finally {
      this.done.countDown();
    } 
  }
  
  public void onNext(T paramT) {
    if (!this.checkSubscriptionOnce) {
      this.checkSubscriptionOnce = true;
      if (this.subscription.get() == null)
        this.errors.add(new IllegalStateException("onSubscribe not called in proper order")); 
    } 
    this.lastThread = Thread.currentThread();
    if (this.establishedFusionMode == 2) {
      try {
        while (true) {
          paramT = (T)this.qs.poll();
          if (paramT != null) {
            this.values.add(paramT);
            continue;
          } 
          break;
        } 
      } catch (Throwable throwable) {
        this.errors.add(throwable);
        this.qs.dispose();
      } 
      return;
    } 
    this.values.add((T)throwable);
    if (throwable == null)
      this.errors.add(new NullPointerException("onNext received a null value")); 
    this.actual.onNext(throwable);
  }
  
  public void onSubscribe(Disposable paramDisposable) {
    this.lastThread = Thread.currentThread();
    if (paramDisposable == null) {
      this.errors.add(new NullPointerException("onSubscribe received a null Subscription"));
      return;
    } 
    if (!this.subscription.compareAndSet(null, paramDisposable)) {
      paramDisposable.dispose();
      if (this.subscription.get() != DisposableHelper.DISPOSED) {
        List<Throwable> list = this.errors;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSubscribe received multiple subscriptions: ");
        stringBuilder.append(paramDisposable);
        list.add(new IllegalStateException(stringBuilder.toString()));
      } 
      return;
    } 
    if (this.initialFusionMode != 0 && paramDisposable instanceof QueueDisposable) {
      this.qs = (QueueDisposable<T>)paramDisposable;
      int i = this.qs.requestFusion(this.initialFusionMode);
      this.establishedFusionMode = i;
      if (i == 1) {
        this.checkSubscriptionOnce = true;
        this.lastThread = Thread.currentThread();
        try {
          while (true) {
            object = this.qs.poll();
            if (object != null) {
              this.values.add((T)object);
              continue;
            } 
            this.completions++;
            this.subscription.lazySet(DisposableHelper.DISPOSED);
            return;
          } 
        } catch (Throwable object) {
          this.errors.add((Throwable)object);
        } 
        return;
      } 
    } 
    this.actual.onSubscribe((Disposable)object);
  }
  
  public void onSuccess(T paramT) {
    onNext(paramT);
    onComplete();
  }
  
  final TestObserver<T> setInitialFusionMode(int paramInt) {
    this.initialFusionMode = paramInt;
    return this;
  }
  
  enum EmptyObserver implements Observer<Object> {
    INSTANCE;
    
    static {
    
    }
    
    public void onComplete() {}
    
    public void onError(Throwable param1Throwable) {}
    
    public void onNext(Object param1Object) {}
    
    public void onSubscribe(Disposable param1Disposable) {}
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\observers\TestObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */