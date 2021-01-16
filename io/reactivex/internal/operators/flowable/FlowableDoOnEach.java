package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableDoOnEach<T> extends AbstractFlowableWithUpstream<T, T> {
  final Action onAfterTerminate;
  
  final Action onComplete;
  
  final Consumer<? super Throwable> onError;
  
  final Consumer<? super T> onNext;
  
  public FlowableDoOnEach(Flowable<T> paramFlowable, Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction1, Action paramAction2) {
    super(paramFlowable);
    this.onNext = paramConsumer;
    this.onError = paramConsumer1;
    this.onComplete = paramAction1;
    this.onAfterTerminate = paramAction2;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    if (paramSubscriber instanceof ConditionalSubscriber) {
      this.source.subscribe((FlowableSubscriber)new DoOnEachConditionalSubscriber<T>((ConditionalSubscriber<? super T>)paramSubscriber, this.onNext, this.onError, this.onComplete, this.onAfterTerminate));
    } else {
      this.source.subscribe((FlowableSubscriber)new DoOnEachSubscriber<T>(paramSubscriber, this.onNext, this.onError, this.onComplete, this.onAfterTerminate));
    } 
  }
  
  static final class DoOnEachConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
    final Action onAfterTerminate;
    
    final Action onComplete;
    
    final Consumer<? super Throwable> onError;
    
    final Consumer<? super T> onNext;
    
    DoOnEachConditionalSubscriber(ConditionalSubscriber<? super T> param1ConditionalSubscriber, Consumer<? super T> param1Consumer, Consumer<? super Throwable> param1Consumer1, Action param1Action1, Action param1Action2) {
      super(param1ConditionalSubscriber);
      this.onNext = param1Consumer;
      this.onError = param1Consumer1;
      this.onComplete = param1Action1;
      this.onAfterTerminate = param1Action2;
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      try {
        this.onComplete.run();
        this.done = true;
        this.actual.onComplete();
        try {
          this.onAfterTerminate.run();
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          RxJavaPlugins.onError(throwable);
        } 
        return;
      } catch (Throwable throwable) {
        fail(throwable);
        return;
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      boolean bool = true;
      this.done = true;
      try {
        this.onError.accept(param1Throwable);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError((Throwable)new CompositeException(new Throwable[] { param1Throwable, throwable }));
        bool = false;
      } 
      if (bool)
        this.actual.onError(param1Throwable); 
      try {
        this.onAfterTerminate.run();
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError(throwable);
      } 
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      if (this.sourceMode != 0) {
        this.actual.onNext(null);
        return;
      } 
      try {
        this.onNext.accept(param1T);
        this.actual.onNext(param1T);
        return;
      } catch (Throwable throwable) {
        fail(throwable);
        return;
      } 
    }
    
    @Nullable
    public T poll() throws Exception {
      try {
        Object object = this.qs.poll();
        if (object != null) {
          try {
            this.onNext.accept(object);
            this.onAfterTerminate.run();
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            try {
              this.onError.accept(throwable);
              throw ExceptionHelper.throwIfThrowable(throwable);
            } catch (Throwable throwable1) {
              CompositeException compositeException = new CompositeException();
              this(new Throwable[] { throwable, throwable1 });
              throw compositeException;
            } 
          } finally {}
        } else if (this.sourceMode == 1) {
          this.onComplete.run();
          this.onAfterTerminate.run();
        } 
        return (T)object;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        try {
          this.onError.accept(throwable);
          throw ExceptionHelper.throwIfThrowable(throwable);
        } catch (Throwable throwable1) {
          throw new CompositeException(new Throwable[] { throwable, throwable1 });
        } 
      } 
    }
    
    public int requestFusion(int param1Int) {
      return transitiveBoundaryFusion(param1Int);
    }
    
    public boolean tryOnNext(T param1T) {
      if (this.done)
        return false; 
      try {
        this.onNext.accept(param1T);
        return this.actual.tryOnNext(param1T);
      } catch (Throwable throwable) {
        fail(throwable);
        return false;
      } 
    }
  }
  
  static final class DoOnEachSubscriber<T> extends BasicFuseableSubscriber<T, T> {
    final Action onAfterTerminate;
    
    final Action onComplete;
    
    final Consumer<? super Throwable> onError;
    
    final Consumer<? super T> onNext;
    
    DoOnEachSubscriber(Subscriber<? super T> param1Subscriber, Consumer<? super T> param1Consumer, Consumer<? super Throwable> param1Consumer1, Action param1Action1, Action param1Action2) {
      super(param1Subscriber);
      this.onNext = param1Consumer;
      this.onError = param1Consumer1;
      this.onComplete = param1Action1;
      this.onAfterTerminate = param1Action2;
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      try {
        this.onComplete.run();
        this.done = true;
        this.actual.onComplete();
        try {
          this.onAfterTerminate.run();
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          RxJavaPlugins.onError(throwable);
        } 
        return;
      } catch (Throwable throwable) {
        fail(throwable);
        return;
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      boolean bool = true;
      this.done = true;
      try {
        this.onError.accept(param1Throwable);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError((Throwable)new CompositeException(new Throwable[] { param1Throwable, throwable }));
        bool = false;
      } 
      if (bool)
        this.actual.onError(param1Throwable); 
      try {
        this.onAfterTerminate.run();
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError(throwable);
      } 
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      if (this.sourceMode != 0) {
        this.actual.onNext(null);
        return;
      } 
      try {
        this.onNext.accept(param1T);
        this.actual.onNext(param1T);
        return;
      } catch (Throwable throwable) {
        fail(throwable);
        return;
      } 
    }
    
    @Nullable
    public T poll() throws Exception {
      try {
        Object object = this.qs.poll();
        if (object != null) {
          try {
            this.onNext.accept(object);
            this.onAfterTerminate.run();
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            try {
              this.onError.accept(throwable);
              throw ExceptionHelper.throwIfThrowable(throwable);
            } catch (Throwable throwable1) {
              CompositeException compositeException = new CompositeException();
              this(new Throwable[] { throwable, throwable1 });
              throw compositeException;
            } 
          } finally {}
        } else if (this.sourceMode == 1) {
          this.onComplete.run();
          this.onAfterTerminate.run();
        } 
        return (T)object;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        try {
          this.onError.accept(throwable);
          throw ExceptionHelper.throwIfThrowable(throwable);
        } catch (Throwable throwable1) {
          throw new CompositeException(new Throwable[] { throwable, throwable1 });
        } 
      } 
    }
    
    public int requestFusion(int param1Int) {
      return transitiveBoundaryFusion(param1Int);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDoOnEach.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */