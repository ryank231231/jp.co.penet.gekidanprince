package io.opencensus.trace;

import com.google.common.annotations.VisibleForTesting;
import io.opencensus.common.Clock;
import io.opencensus.internal.Provider;
import io.opencensus.trace.config.TraceConfig;
import io.opencensus.trace.export.ExportComponent;
import io.opencensus.trace.propagation.PropagationComponent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class Tracing {
  private static final Logger logger = Logger.getLogger(Tracing.class.getName());
  
  private static final TraceComponent traceComponent = loadTraceComponent(TraceComponent.class.getClassLoader());
  
  public static Clock getClock() {
    return traceComponent.getClock();
  }
  
  public static ExportComponent getExportComponent() {
    return traceComponent.getExportComponent();
  }
  
  public static PropagationComponent getPropagationComponent() {
    return traceComponent.getPropagationComponent();
  }
  
  public static TraceConfig getTraceConfig() {
    return traceComponent.getTraceConfig();
  }
  
  public static Tracer getTracer() {
    return traceComponent.getTracer();
  }
  
  @VisibleForTesting
  static TraceComponent loadTraceComponent(@Nullable ClassLoader paramClassLoader) {
    try {
      return (TraceComponent)Provider.createInstance(Class.forName("io.opencensus.impl.trace.TraceComponentImpl", true, paramClassLoader), TraceComponent.class);
    } catch (ClassNotFoundException classNotFoundException) {
      logger.log(Level.FINE, "Couldn't load full implementation for TraceComponent, now trying to load lite implementation.", classNotFoundException);
      try {
        return (TraceComponent)Provider.createInstance(Class.forName("io.opencensus.impllite.trace.TraceComponentImplLite", true, paramClassLoader), TraceComponent.class);
      } catch (ClassNotFoundException classNotFoundException1) {
        logger.log(Level.FINE, "Couldn't load lite implementation for TraceComponent, now using default implementation for TraceComponent.", classNotFoundException1);
        return TraceComponent.newNoopTraceComponent();
      } 
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\Tracing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */