package io.opencensus.trace;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class Link {
  private static final Map<String, AttributeValue> EMPTY_ATTRIBUTES = Collections.emptyMap();
  
  public static Link fromSpanContext(SpanContext paramSpanContext, Type paramType) {
    return new AutoValue_Link(paramSpanContext.getTraceId(), paramSpanContext.getSpanId(), paramType, EMPTY_ATTRIBUTES);
  }
  
  public static Link fromSpanContext(SpanContext paramSpanContext, Type paramType, Map<String, AttributeValue> paramMap) {
    return new AutoValue_Link(paramSpanContext.getTraceId(), paramSpanContext.getSpanId(), paramType, Collections.unmodifiableMap(new HashMap<String, AttributeValue>(paramMap)));
  }
  
  public abstract Map<String, AttributeValue> getAttributes();
  
  public abstract SpanId getSpanId();
  
  public abstract TraceId getTraceId();
  
  public abstract Type getType();
  
  public enum Type {
    CHILD_LINKED_SPAN, PARENT_LINKED_SPAN;
    
    static {
    
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\Link.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */