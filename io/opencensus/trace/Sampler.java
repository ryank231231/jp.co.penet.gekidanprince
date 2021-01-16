package io.opencensus.trace;

import java.util.List;
import javax.annotation.Nullable;

public abstract class Sampler {
  public abstract String getDescription();
  
  public abstract boolean shouldSample(@Nullable SpanContext paramSpanContext, @Nullable Boolean paramBoolean, TraceId paramTraceId, SpanId paramSpanId, String paramString, List<Span> paramList);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\Sampler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */