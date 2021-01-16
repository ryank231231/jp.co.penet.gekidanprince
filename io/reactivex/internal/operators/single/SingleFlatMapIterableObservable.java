package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;

public final class SingleFlatMapIterableObservable<T, R> extends Observable<R> {
  final Function<? super T, ? extends Iterable<? extends R>> mapper;
  
  final SingleSource<T> source;
  
  public SingleFlatMapIterableObservable(SingleSource<T> paramSingleSource, Function<? super T, ? extends Iterable<? extends R>> paramFunction) {
    this.source = paramSingleSource;
    this.mapper = paramFunction;
  }
  
  protected void subscribeActual(Observer<? super R> paramObserver) {
    this.source.subscribe(new FlatMapIterableObserver<T, R>(paramObserver, this.mapper));
  }
  
  static final class FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements SingleObserver<T> {
    private static final long serialVersionUID = -8938804753851907758L;
    
    final Observer<? super R> actual;
    
    volatile boolean cancelled;
    
    Disposable d;
    
    volatile Iterator<? extends R> it;
    
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    
    boolean outputFused;
    
    FlatMapIterableObserver(Observer<? super R> param1Observer, Function<? super T, ? extends Iterable<? extends R>> param1Function) {
      this.actual = param1Observer;
      this.mapper = param1Function;
    }
    
    public void clear() {
      this.it = null;
    }
    
    public void dispose() {
      this.cancelled = true;
      this.d.dispose();
      this.d = (Disposable)DisposableHelper.DISPOSED;
    }
    
    public boolean isDisposed() {
      return this.cancelled;
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
    
    public void onError(Throwable param1Throwable) {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe((Disposable)this);
      } 
    }
    
    public void onSuccess(T param1T) {
      Observer<? super R> observer = this.actual;
      try {
        Iterator<? extends R> iterator = ((Iterable)this.mapper.apply(param1T)).iterator();
        boolean bool = iterator.hasNext();
        if (!bool) {
          observer.onComplete();
          return;
        } 
        if (this.outputFused) {
          this.it = iterator;
          observer.onNext(null);
          observer.onComplete();
          return;
        } 
        while (true) {
          if (this.cancelled)
            return; 
          try {
            R r = iterator.next();
            observer.onNext(r);
            if (this.cancelled)
              return; 
            try {
              bool = iterator.hasNext();
              if (!bool) {
                observer.onComplete();
                return;
              } 
            } catch (Throwable throwable) {
              Exceptions.throwIfFatal(throwable);
              observer.onError(throwable);
              return;
            } 
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            observer.onError(throwable);
            break;
          } 
        } 
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
    
    public int requestFusion(int param1Int) {
      if ((param1Int & 0x2) != 0) {
        this.outputFused = true;
        return 2;
      } 
      return 0;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleFlatMapIterableObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */