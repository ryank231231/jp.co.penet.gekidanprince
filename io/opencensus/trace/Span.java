package io.opencensus.trace;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public abstract class Span {
  private static final Set<Options> DEFAULT_OPTIONS;
  
  private static final Map<String, AttributeValue> EMPTY_ATTRIBUTES = Collections.emptyMap();
  
  private final SpanContext context;
  
  private final Set<Options> options;
  
  static {
    DEFAULT_OPTIONS = Collections.unmodifiableSet(EnumSet.noneOf(Options.class));
  }
  
  protected Span(SpanContext paramSpanContext, @Nullable EnumSet<Options> paramEnumSet) {
    Set<Options> set;
    boolean bool;
    this.context = (SpanContext)Preconditions.checkNotNull(paramSpanContext, "context");
    if (paramEnumSet == null) {
      set = DEFAULT_OPTIONS;
    } else {
      set = Collections.unmodifiableSet(EnumSet.copyOf((EnumSet<? extends Options>)set));
    } 
    this.options = set;
    if (!paramSpanContext.getTraceOptions().isSampled() || this.options.contains(Options.RECORD_EVENTS)) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Span is sampled, but does not have RECORD_EVENTS set.");
  }
  
  public abstract void addAnnotation(Annotation paramAnnotation);
  
  public final void addAnnotation(String paramString) {
    addAnnotation(paramString, EMPTY_ATTRIBUTES);
  }
  
  public abstract void addAnnotation(String paramString, Map<String, AttributeValue> paramMap);
  
  @Deprecated
  public void addAttributes(Map<String, AttributeValue> paramMap) {
    putAttributes(paramMap);
  }
  
  public abstract void addLink(Link paramLink);
  
  public abstract void addNetworkEvent(NetworkEvent paramNetworkEvent);
  
  public final void end() {
    end(EndSpanOptions.DEFAULT);
  }
  
  public abstract void end(EndSpanOptions paramEndSpanOptions);
  
  public final SpanContext getContext() {
    return this.context;
  }
  
  public final Set<Options> getOptions() {
    return this.options;
  }
  
  public void putAttribute(String paramString, AttributeValue paramAttributeValue) {
    putAttributes(Collections.singletonMap(paramString, paramAttributeValue));
  }
  
  public void putAttributes(Map<String, AttributeValue> paramMap) {
    addAttributes(paramMap);
  }
  
  public void setStatus(Status paramStatus) {}
  
  public enum Options {
    RECORD_EVENTS;
    
    static {
    
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\Span.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */