package io.opencensus.trace;

import io.opencensus.common.Clock;
import io.opencensus.internal.ZeroTimeClock;
import io.opencensus.trace.config.TraceConfig;
import io.opencensus.trace.export.ExportComponent;
import io.opencensus.trace.propagation.PropagationComponent;

public abstract class TraceComponent {
  static TraceComponent newNoopTraceComponent() {
    return new NoopTraceComponent();
  }
  
  public abstract Clock getClock();
  
  public abstract ExportComponent getExportComponent();
  
  public abstract PropagationComponent getPropagationComponent();
  
  public abstract TraceConfig getTraceConfig();
  
  public abstract Tracer getTracer();
  
  private static final class NoopTraceComponent extends TraceComponent {
    private final ExportComponent noopExportComponent = ExportComponent.newNoopExportComponent();
    
    private NoopTraceComponent() {}
    
    public Clock getClock() {
      return (Clock)ZeroTimeClock.getInstance();
    }
    
    public ExportComponent getExportComponent() {
      return this.noopExportComponent;
    }
    
    public PropagationComponent getPropagationComponent() {
      return PropagationComponent.getNoopPropagationComponent();
    }
    
    public TraceConfig getTraceConfig() {
      return TraceConfig.getNoopTraceConfig();
    }
    
    public Tracer getTracer() {
      return Tracer.getNoopTracer();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\TraceComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */