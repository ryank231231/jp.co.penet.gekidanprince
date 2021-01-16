package io.opencensus.trace.export;

import java.util.Collection;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class SpanExporter {
  private static final SpanExporter NOOP_SPAN_EXPORTER = new NoopSpanExporter();
  
  public static SpanExporter getNoopSpanExporter() {
    return NOOP_SPAN_EXPORTER;
  }
  
  public abstract void registerHandler(String paramString, Handler paramHandler);
  
  public abstract void unregisterHandler(String paramString);
  
  public static abstract class Handler {
    public abstract void export(Collection<SpanData> param1Collection);
  }
  
  private static final class NoopSpanExporter extends SpanExporter {
    private NoopSpanExporter() {}
    
    public void registerHandler(String param1String, SpanExporter.Handler param1Handler) {}
    
    public void unregisterHandler(String param1String) {}
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\SpanExporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */