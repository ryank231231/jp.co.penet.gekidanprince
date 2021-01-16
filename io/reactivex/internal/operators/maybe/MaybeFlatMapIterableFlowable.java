package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeFlatMapIterableFlowable<T, R> extends Flowable<R> {
  final Function<? super T, ? extends Iterable<? extends R>> mapper;
  
  final MaybeSource<T> source;
  
  public MaybeFlatMapIterableFlowable(MaybeSource<T> paramMaybeSource, Function<? super T, ? extends Iterable<? extends R>> paramFunction) {
    this.source = paramMaybeSource;
    this.mapper = paramFunction;
  }
  
  protected void subscribeActual(Subscriber<? super R> paramSubscriber) {
    this.source.subscribe(new FlatMapIterableObserver<T, R>(paramSubscriber, this.mapper));
  }
  
  static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements MaybeObserver<T> {
    private static final long serialVersionUID = -8938804753851907758L;
    
    final Subscriber<? super R> actual;
    
    volatile boolean cancelled;
    
    Disposable d;
    
    volatile Iterator<? extends R> it;
    
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    
    boolean outputFused;
    
    final AtomicLong requested;
    
    FlatMapIterableObserver(Subscriber<? super R> param1Subscriber, Function<? super T, ? extends Iterable<? extends R>> param1Function) {
      this.actual = param1Subscriber;
      this.mapper = param1Function;
      this.requested = new AtomicLong();
    }
    
    public void cancel() {
      this.cancelled = true;
      this.d.dispose();
      this.d = (Disposable)DisposableHelper.DISPOSED;
    }
    
    public void clear() {
      this.it = null;
    }
    
    void drain() {
      if (getAndIncrement() != 0)
        return; 
      Subscriber<? super R> subscriber = this.actual;
      Iterator<? extends R> iterator = this.it;
      if (this.outputFused && iterator != null) {
        subscriber.onNext(null);
        subscriber.onComplete();
        return;
      } 
      int i = 1;
      while (true) {
        if (iterator != null) {
          long l1 = this.requested.get();
          if (l1 == Long.MAX_VALUE) {
            fastPath(subscriber, iterator);
            return;
          } 
          long l2 = 0L;
          while (l2 != l1) {
            if (this.cancelled)
              return; 
            try {
              Object object = ObjectHelper.requireNonNull(iterator.next(), "The iterator returned a null value");
              subscriber.onNext(object);
              if (this.cancelled)
                return; 
              l2++;
              try {
                boolean bool = iterator.hasNext();
                if (!bool) {
                  subscriber.onComplete();
                  return;
                } 
              } catch (Throwable null) {
                Exceptions.throwIfFatal(throwable);
                subscriber.onError(throwable);
                return;
              } 
            } catch (Throwable throwable) {
              Exceptions.throwIfFatal(throwable);
              subscriber.onError(throwable);
              return;
            } 
          } 
          if (l2 != 0L)
            BackpressureHelper.produced(this.requested, l2); 
        } 
        int j = addAndGet(-i);
        if (j == 0)
          return; 
        i = j;
        if (throwable == null) {
          Iterator<? extends R> iterator1 = this.it;
          i = j;
        } 
      } 
    }
    
    void fastPath(Subscriber<? super R> param1Subscriber, Iterator<? extends R> param1Iterator) {
      while (true) {
        if (this.cancelled)
          return; 
        try {
          R r = param1Iterator.next();
          param1Subscriber.onNext(r);
          if (this.cancelled)
            return; 
          try {
            boolean bool = param1Iterator.hasNext();
            if (!bool) {
              param1Subscriber.onComplete();
              return;
            } 
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            param1Subscriber.onError(throwable);
            return;
          } 
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          param1Subscriber.onError(throwable);
          break;
        } 
      } 
    }
    
    public boolean isEmpty() {
      boolean bool;
      if (this.it == null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe((Subscription)this);
      } 
    }
    
    public void onSuccess(T param1T) {
      try {
        Iterator<? extends R> iterator = ((Iterable)this.mapper.apply(param1T)).iterator();
        boolean bool = iterator.hasNext();
        if (!bool) {
          this.actual.onComplete();
          return;
        } 
        this.it = iterator;
        drain();
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError(throwable);
        return;
      } 
    }
    
    @Nullable
    public R poll() throws Exception {
      Iterator<? extends R> iterator = this.it;
      if (iterator != null) {
        Object object = ObjectHelper.requireNonNull(iterator.next(), "The iterator returned a null value");
        if (!iterator.hasNext())
          this.it = null; 
        return (R)object;
      } 
      return null;
    }
    
    public void request(long param1Long) {
      if (SubscriptionHelper.validate(param1Long)) {
        BackpressureHelper.add(this.requested, param1Long);
        drain();
      } 
    }
    
    public int requestFusion(int param1Int) {
      if ((param1Int & 0x2) != 0) {
        this.outputFused = true;
        return 2;
      } 
      return 0;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFlatMapIterableFlowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */