package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
  final Callable<U> bufferSupplier;
  
  final int count;
  
  final int skip;
  
  public ObservableBuffer(ObservableSource<T> paramObservableSource, int paramInt1, int paramInt2, Callable<U> paramCallable) {
    super(paramObservableSource);
    this.count = paramInt1;
    this.skip = paramInt2;
    this.bufferSupplier = paramCallable;
  }
  
  protected void subscribeActual(Observer<? super U> paramObserver) {
    int i = this.skip;
    int j = this.count;
    if (i == j) {
      paramObserver = new BufferExactObserver<U, U>(paramObserver, j, this.bufferSupplier);
      if (paramObserver.createBuffer())
        this.source.subscribe(paramObserver); 
    } else {
      this.source.subscribe(new BufferSkipObserver<Object, U>(paramObserver, this.count, this.skip, this.bufferSupplier));
    } 
  }
  
  static final class BufferExactObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
    final Observer<? super U> actual;
    
    U buffer;
    
    final Callable<U> bufferSupplier;
    
    final int count;
    
    Disposable s;
    
    int size;
    
    BufferExactObserver(Observer<? super U> param1Observer, int param1Int, Callable<U> param1Callable) {
      this.actual = param1Observer;
      this.count = param1Int;
      this.bufferSupplier = param1Callable;
    }
    
    boolean createBuffer() {
      try {
        Collection collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), "Empty buffer supplied");
        this.buffer = (U)collection;
        return true;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.buffer = null;
        Disposable disposable = this.s;
        if (disposable == null) {
          EmptyDisposable.error(throwable, this.actual);
        } else {
          disposable.dispose();
          this.actual.onError(throwable);
        } 
        return false;
      } 
    }
    
    public void dispose() {
      this.s.dispose();
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      U u = this.buffer;
      if (u != null) {
        this.buffer = null;
        if (!u.isEmpty())
          this.actual.onNext(u); 
        this.actual.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      this.buffer = null;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      U u = this.buffer;
      if (u != null) {
        u.add(param1T);
        int i = this.size + 1;
        this.size = i;
        if (i >= this.count) {
          this.actual.onNext(u);
          this.size = 0;
          createBuffer();
        } 
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
  
  static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
    private static final long serialVersionUID = -8223395059921494546L;
    
    final Observer<? super U> actual;
    
    final Callable<U> bufferSupplier;
    
    final ArrayDeque<U> buffers;
    
    final int count;
    
    long index;
    
    Disposable s;
    
    final int skip;
    
    BufferSkipObserver(Observer<? super U> param1Observer, int param1Int1, int param1Int2, Callable<U> param1Callable) {
      this.actual = param1Observer;
      this.count = param1Int1;
      this.skip = param1Int2;
      this.bufferSupplier = param1Callable;
      this.buffers = new ArrayDeque<U>();
    }
    
    public void dispose() {
      this.s.dispose();
    }
    
    public boolean isDisposed() {
      return this.s.isDisposed();
    }
    
    public void onComplete() {
      while (!this.buffers.isEmpty())
        this.actual.onNext(this.buffers.poll()); 
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.buffers.clear();
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      long l = this.index;
      this.index = 1L + l;
      if (l % this.skip == 0L)
        try {
          Collection collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
          this.buffers.offer((U)collection);
        } catch (Throwable throwable) {
          this.buffers.clear();
          this.s.dispose();
          this.actual.onError(throwable);
          return;
        }  
      Iterator<U> iterator = this.buffers.iterator();
      while (iterator.hasNext()) {
        Collection<Throwable> collection = (Collection)iterator.next();
        collection.add(throwable);
        if (this.count <= collection.size()) {
          iterator.remove();
          this.actual.onNext(collection);
        } 
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */