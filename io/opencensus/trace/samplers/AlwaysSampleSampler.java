package io.opencensus.trace.samplers;

import io.opencensus.trace.Sampler;
import io.opencensus.trace.Span;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.SpanId;
import io.opencensus.trace.TraceId;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AlwaysSampleSampler extends Sampler {
  public String getDescription() {
    return toString();
  }
  
  public boolean shouldSample(@Nullable SpanContext paramSpanContext, @Nullable Boolean paramBoolean, TraceId paramTraceId, SpanId paramSpanId, String paramString, List<Span> paramList) {
    return true;
  }
  
  public String toString() {
    return "AlwaysSampleSampler";
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\samplers\AlwaysSampleSampler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */