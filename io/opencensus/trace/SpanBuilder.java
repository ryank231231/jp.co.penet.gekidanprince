package io.opencensus.trace;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.MustBeClosed;
import io.opencensus.common.Scope;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

public abstract class SpanBuilder {
  public abstract SpanBuilder setParentLinks(List<Span> paramList);
  
  public abstract SpanBuilder setRecordEvents(boolean paramBoolean);
  
  public abstract SpanBuilder setSampler(Sampler paramSampler);
  
  @MustBeClosed
  public final Scope startScopedSpan() {
    return CurrentSpanUtils.withSpan(startSpan(), true);
  }
  
  public abstract Span startSpan();
  
  public final <V> V startSpanAndCall(Callable<V> paramCallable) throws Exception {
    return CurrentSpanUtils.<V>withSpan(startSpan(), true, paramCallable).call();
  }
  
  public final void startSpanAndRun(Runnable paramRunnable) {
    CurrentSpanUtils.withSpan(startSpan(), true, paramRunnable).run();
  }
  
  static final class NoopSpanBuilder extends SpanBuilder {
    private NoopSpanBuilder(String param1String) {
      Preconditions.checkNotNull(param1String, "name");
    }
    
    static NoopSpanBuilder createWithParent(String param1String, @Nullable Span param1Span) {
      return new NoopSpanBuilder(param1String);
    }
    
    static NoopSpanBuilder createWithRemoteParent(String param1String, @Nullable SpanContext param1SpanContext) {
      return new NoopSpanBuilder(param1String);
    }
    
    public SpanBuilder setParentLinks(List<Span> param1List) {
      return this;
    }
    
    public SpanBuilder setRecordEvents(boolean param1Boolean) {
      return this;
    }
    
    public SpanBuilder setSampler(@Nullable Sampler param1Sampler) {
      return this;
    }
    
    public Span startSpan() {
      return BlankSpan.INSTANCE;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\SpanBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */