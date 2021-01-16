package io.opencensus.trace;

import com.google.common.base.Throwables;
import io.grpc.Context;
import io.opencensus.common.Scope;
import io.opencensus.trace.unsafe.ContextUtils;
import java.util.concurrent.Callable;

final class CurrentSpanUtils {
  static Span getCurrentSpan() {
    return (Span)ContextUtils.CONTEXT_SPAN_KEY.get();
  }
  
  private static void setErrorStatus(Span paramSpan, Throwable paramThrowable) {
    String str;
    Status status = Status.UNKNOWN;
    if (paramThrowable.getMessage() == null) {
      str = paramThrowable.getClass().getSimpleName();
    } else {
      str = str.getMessage();
    } 
    paramSpan.setStatus(status.withDescription(str));
  }
  
  static Scope withSpan(Span paramSpan, boolean paramBoolean) {
    return new ScopeInSpan(paramSpan, paramBoolean);
  }
  
  static Runnable withSpan(Span paramSpan, boolean paramBoolean, Runnable paramRunnable) {
    return new RunnableInSpan(paramSpan, paramRunnable, paramBoolean);
  }
  
  static <C> Callable<C> withSpan(Span paramSpan, boolean paramBoolean, Callable<C> paramCallable) {
    return new CallableInSpan<C>(paramSpan, paramCallable, paramBoolean);
  }
  
  private static final class CallableInSpan<V> implements Callable<V> {
    private final Callable<V> callable;
    
    private final boolean endSpan;
    
    private final Span span;
    
    private CallableInSpan(Span param1Span, Callable<V> param1Callable, boolean param1Boolean) {
      this.span = param1Span;
      this.callable = param1Callable;
      this.endSpan = param1Boolean;
    }
    
    public V call() throws Exception {
      Exception exception;
      Context context = Context.current().withValue(ContextUtils.CONTEXT_SPAN_KEY, this.span).attach();
      try {
        V v = this.callable.call();
        Context.current().detach(context);
        if (this.endSpan)
          this.span.end(); 
        return v;
      } catch (Exception null) {
        CurrentSpanUtils.setErrorStatus(this.span, exception);
        throw exception;
      } catch (Throwable throwable) {
        CurrentSpanUtils.setErrorStatus(this.span, throwable);
        Throwables.propagateIfPossible(throwable);
        exception = new RuntimeException();
        this("unexpected", throwable);
        throw exception;
      } finally {}
      Context.current().detach(context);
      if (this.endSpan)
        this.span.end(); 
      throw exception;
    }
  }
  
  private static final class RunnableInSpan implements Runnable {
    private final boolean endSpan;
    
    private final Runnable runnable;
    
    private final Span span;
    
    private RunnableInSpan(Span param1Span, Runnable param1Runnable, boolean param1Boolean) {
      this.span = param1Span;
      this.runnable = param1Runnable;
      this.endSpan = param1Boolean;
    }
    
    public void run() {
      Throwable throwable;
      Context context = Context.current().withValue(ContextUtils.CONTEXT_SPAN_KEY, this.span).attach();
      try {
        this.runnable.run();
        Context.current().detach(context);
        if (this.endSpan)
          this.span.end(); 
        return;
      } catch (Throwable null) {
        CurrentSpanUtils.setErrorStatus(this.span, throwable);
        Throwables.propagateIfPossible(throwable);
        RuntimeException runtimeException = new RuntimeException();
        this("unexpected", throwable);
        throw runtimeException;
      } finally {}
      Context.current().detach(context);
      if (this.endSpan)
        this.span.end(); 
      throw throwable;
    }
  }
  
  private static final class ScopeInSpan implements Scope {
    private boolean endSpan;
    
    private final Context origContext;
    
    private final Span span;
    
    private ScopeInSpan(Span param1Span, boolean param1Boolean) {
      this.span = param1Span;
      this.endSpan = param1Boolean;
      this.origContext = Context.current().withValue(ContextUtils.CONTEXT_SPAN_KEY, param1Span).attach();
    }
    
    public void close() {
      Context.current().detach(this.origContext);
      if (this.endSpan)
        this.span.end(); 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\CurrentSpanUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */