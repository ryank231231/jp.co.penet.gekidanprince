package io.opencensus.trace;

import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_Link extends Link {
  private final Map<String, AttributeValue> attributes;
  
  private final SpanId spanId;
  
  private final TraceId traceId;
  
  private final Link.Type type;
  
  AutoValue_Link(TraceId paramTraceId, SpanId paramSpanId, Link.Type paramType, Map<String, AttributeValue> paramMap) {
    if (paramTraceId != null) {
      this.traceId = paramTraceId;
      if (paramSpanId != null) {
        this.spanId = paramSpanId;
        if (paramType != null) {
          this.type = paramType;
          if (paramMap != null) {
            this.attributes = paramMap;
            return;
          } 
          throw new NullPointerException("Null attributes");
        } 
        throw new NullPointerException("Null type");
      } 
      throw new NullPointerException("Null spanId");
    } 
    throw new NullPointerException("Null traceId");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof Link) {
      paramObject = paramObject;
      if (!this.traceId.equals(paramObject.getTraceId()) || !this.spanId.equals(paramObject.getSpanId()) || !this.type.equals(paramObject.getType()) || !this.attributes.equals(paramObject.getAttributes()))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public Map<String, AttributeValue> getAttributes() {
    return this.attributes;
  }
  
  public SpanId getSpanId() {
    return this.spanId;
  }
  
  public TraceId getTraceId() {
    return this.traceId;
  }
  
  public Link.Type getType() {
    return this.type;
  }
  
  public int hashCode() {
    return (((this.traceId.hashCode() ^ 0xF4243) * 1000003 ^ this.spanId.hashCode()) * 1000003 ^ this.type.hashCode()) * 1000003 ^ this.attributes.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Link{traceId=");
    stringBuilder.append(this.traceId);
    stringBuilder.append(", spanId=");
    stringBuilder.append(this.spanId);
    stringBuilder.append(", type=");
    stringBuilder.append(this.type);
    stringBuilder.append(", attributes=");
    stringBuilder.append(this.attributes);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\AutoValue_Link.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */