package io.opencensus.trace.export;

public abstract class ExportComponent {
  public static ExportComponent newNoopExportComponent() {
    return new NoopExportComponent();
  }
  
  public abstract RunningSpanStore getRunningSpanStore();
  
  public abstract SampledSpanStore getSampledSpanStore();
  
  public abstract SpanExporter getSpanExporter();
  
  private static final class NoopExportComponent extends ExportComponent {
    private final SampledSpanStore noopSampledSpanStore = SampledSpanStore.newNoopSampledSpanStore();
    
    private NoopExportComponent() {}
    
    public RunningSpanStore getRunningSpanStore() {
      return RunningSpanStore.getNoopRunningSpanStore();
    }
    
    public SampledSpanStore getSampledSpanStore() {
      return this.noopSampledSpanStore;
    }
    
    public SpanExporter getSpanExporter() {
      return SpanExporter.getNoopSpanExporter();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\ExportComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */