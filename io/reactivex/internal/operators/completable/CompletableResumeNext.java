package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class CompletableResumeNext extends Completable {
  final Function<? super Throwable, ? extends CompletableSource> errorMapper;
  
  final CompletableSource source;
  
  public CompletableResumeNext(CompletableSource paramCompletableSource, Function<? super Throwable, ? extends CompletableSource> paramFunction) {
    this.source = paramCompletableSource;
    this.errorMapper = paramFunction;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    SequentialDisposable sequentialDisposable = new SequentialDisposable();
    paramCompletableObserver.onSubscribe((Disposable)sequentialDisposable);
    this.source.subscribe(new ResumeNext(paramCompletableObserver, sequentialDisposable));
  }
  
  final class ResumeNext implements CompletableObserver {
    final CompletableObserver s;
    
    final SequentialDisposable sd;
    
    ResumeNext(CompletableObserver param1CompletableObserver, SequentialDisposable param1SequentialDisposable) {
      this.s = param1CompletableObserver;
      this.sd = param1SequentialDisposable;
    }
    
    public void onComplete() {
      this.s.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      try {
        NullPointerException nullPointerException;
        CompletableSource completableSource = (CompletableSource)CompletableResumeNext.this.errorMapper.apply(param1Throwable);
        if (completableSource == null) {
          nullPointerException = new NullPointerException("The CompletableConsumable returned is null");
          nullPointerException.initCause(param1Throwable);
          this.s.onError(nullPointerException);
          return;
        } 
        nullPointerException.subscribe(new OnErrorObserver());
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.s.onError((Throwable)new CompositeException(new Throwable[] { throwable, param1Throwable }));
        return;
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.sd.update(param1Disposable);
    }
    
    final class OnErrorObserver implements CompletableObserver {
      public void onComplete() {
        CompletableResumeNext.ResumeNext.this.s.onComplete();
      }
      
      public void onError(Throwable param2Throwable) {
        CompletableResumeNext.ResumeNext.this.s.onError(param2Throwable);
      }
      
      public void onSubscribe(Disposable param2Disposable) {
        CompletableResumeNext.ResumeNext.this.sd.update(param2Disposable);
      }
    }
  }
  
  final class OnErrorObserver implements CompletableObserver {
    public void onComplete() {
      this.this$1.s.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.this$1.s.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      this.this$1.sd.update(param1Disposable);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableResumeNext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */