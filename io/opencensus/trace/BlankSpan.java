package io.opencensus.trace;

import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class BlankSpan extends Span {
  public static final BlankSpan INSTANCE = new BlankSpan();
  
  private BlankSpan() {
    super(SpanContext.INVALID, null);
  }
  
  public void addAnnotation(Annotation paramAnnotation) {}
  
  public void addAnnotation(String paramString, Map<String, AttributeValue> paramMap) {}
  
  public void addLink(Link paramLink) {}
  
  public void addNetworkEvent(NetworkEvent paramNetworkEvent) {}
  
  public void end(EndSpanOptions paramEndSpanOptions) {}
  
  public void putAttribute(String paramString, AttributeValue paramAttributeValue) {}
  
  public void putAttributes(Map<String, AttributeValue> paramMap) {}
  
  public void setStatus(Status paramStatus) {}
  
  public String toString() {
    return "BlankSpan";
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\BlankSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */