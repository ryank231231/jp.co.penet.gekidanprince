package io.opencensus.trace.config;

public abstract class TraceConfig {
  private static final NoopTraceConfig NOOP_TRACE_CONFIG = new NoopTraceConfig();
  
  public static TraceConfig getNoopTraceConfig() {
    return NOOP_TRACE_CONFIG;
  }
  
  public abstract TraceParams getActiveTraceParams();
  
  public abstract void updateActiveTraceParams(TraceParams paramTraceParams);
  
  private static final class NoopTraceConfig extends TraceConfig {
    private NoopTraceConfig() {}
    
    public TraceParams getActiveTraceParams() {
      return TraceParams.DEFAULT;
    }
    
    public void updateActiveTraceParams(TraceParams param1TraceParams) {}
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\config\TraceConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */