package io.opencensus.trace;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.MustBeClosed;
import io.opencensus.common.Scope;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

public abstract class Tracer {
  private static final NoopTracer noopTracer = new NoopTracer();
  
  static Tracer getNoopTracer() {
    return noopTracer;
  }
  
  public final Span getCurrentSpan() {
    Span span = CurrentSpanUtils.getCurrentSpan();
    if (span == null)
      span = BlankSpan.INSTANCE; 
    return span;
  }
  
  public final SpanBuilder spanBuilder(String paramString) {
    return spanBuilderWithExplicitParent(paramString, CurrentSpanUtils.getCurrentSpan());
  }
  
  public abstract SpanBuilder spanBuilderWithExplicitParent(String paramString, @Nullable Span paramSpan);
  
  public abstract SpanBuilder spanBuilderWithRemoteParent(String paramString, @Nullable SpanContext paramSpanContext);
  
  @MustBeClosed
  public final Scope withSpan(Span paramSpan) {
    return CurrentSpanUtils.withSpan((Span)Preconditions.checkNotNull(paramSpan, "span"), false);
  }
  
  public final Runnable withSpan(Span paramSpan, Runnable paramRunnable) {
    return CurrentSpanUtils.withSpan(paramSpan, false, paramRunnable);
  }
  
  public final <C> Callable<C> withSpan(Span paramSpan, Callable<C> paramCallable) {
    return CurrentSpanUtils.withSpan(paramSpan, false, paramCallable);
  }
  
  private static final class NoopTracer extends Tracer {
    private NoopTracer() {}
    
    public SpanBuilder spanBuilderWithExplicitParent(String param1String, @Nullable Span param1Span) {
      return SpanBuilder.NoopSpanBuilder.createWithParent(param1String, param1Span);
    }
    
    public SpanBuilder spanBuilderWithRemoteParent(String param1String, @Nullable SpanContext param1SpanContext) {
      return SpanBuilder.NoopSpanBuilder.createWithRemoteParent(param1String, param1SpanContext);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\Tracer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */