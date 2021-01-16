package io.opencensus.trace;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class SpanContext {
  public static final SpanContext INVALID = new SpanContext(TraceId.INVALID, SpanId.INVALID, TraceOptions.DEFAULT);
  
  private final SpanId spanId;
  
  private final TraceId traceId;
  
  private final TraceOptions traceOptions;
  
  private SpanContext(TraceId paramTraceId, SpanId paramSpanId, TraceOptions paramTraceOptions) {
    this.traceId = paramTraceId;
    this.spanId = paramSpanId;
    this.traceOptions = paramTraceOptions;
  }
  
  public static SpanContext create(TraceId paramTraceId, SpanId paramSpanId, TraceOptions paramTraceOptions) {
    return new SpanContext(paramTraceId, paramSpanId, paramTraceOptions);
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof SpanContext))
      return false; 
    paramObject = paramObject;
    if (!this.traceId.equals(((SpanContext)paramObject).traceId) || !this.spanId.equals(((SpanContext)paramObject).spanId) || !this.traceOptions.equals(((SpanContext)paramObject).traceOptions))
      bool = false; 
    return bool;
  }
  
  public SpanId getSpanId() {
    return this.spanId;
  }
  
  public TraceId getTraceId() {
    return this.traceId;
  }
  
  public TraceOptions getTraceOptions() {
    return this.traceOptions;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.traceId, this.spanId, this.traceOptions });
  }
  
  public boolean isValid() {
    boolean bool;
    if (this.traceId.isValid() && this.spanId.isValid()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("traceId", this.traceId).add("spanId", this.spanId).add("traceOptions", this.traceOptions).toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\SpanContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */