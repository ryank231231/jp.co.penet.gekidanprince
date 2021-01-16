package io.opencensus.trace.samplers;

import com.google.common.base.Preconditions;
import io.opencensus.trace.Sampler;
import io.opencensus.trace.Span;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.SpanId;
import io.opencensus.trace.TraceId;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
abstract class ProbabilitySampler extends Sampler {
  static ProbabilitySampler create(double paramDouble) {
    boolean bool;
    long l;
    if (paramDouble >= 0.0D && paramDouble <= 1.0D) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "probability must be in range [0.0, 1.0]");
    if (paramDouble == 0.0D) {
      l = Long.MIN_VALUE;
    } else if (paramDouble == 1.0D) {
      l = Long.MAX_VALUE;
    } else {
      l = (long)(9.223372036854776E18D * paramDouble);
    } 
    return new AutoValue_ProbabilitySampler(paramDouble, l);
  }
  
  public final String getDescription() {
    return String.format("ProbabilitySampler{%.6f}", new Object[] { Double.valueOf(getProbability()) });
  }
  
  abstract long getIdUpperBound();
  
  abstract double getProbability();
  
  public final boolean shouldSample(@Nullable SpanContext paramSpanContext, @Nullable Boolean paramBoolean, TraceId paramTraceId, SpanId paramSpanId, String paramString, @Nullable List<Span> paramList) {
    boolean bool = true;
    if (paramSpanContext != null && paramSpanContext.getTraceOptions().isSampled())
      return true; 
    if (paramList != null) {
      Iterator<Span> iterator = paramList.iterator();
      while (iterator.hasNext()) {
        if (((Span)iterator.next()).getContext().getTraceOptions().isSampled())
          return true; 
      } 
    } 
    if (Math.abs(paramTraceId.getLowerLong()) >= getIdUpperBound())
      bool = false; 
    return bool;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\samplers\ProbabilitySampler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */