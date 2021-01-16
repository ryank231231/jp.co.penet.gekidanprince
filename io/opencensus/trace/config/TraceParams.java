package io.opencensus.trace.config;

import com.google.common.base.Preconditions;
import io.opencensus.trace.Sampler;
import io.opencensus.trace.samplers.Samplers;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class TraceParams {
  public static final TraceParams DEFAULT;
  
  private static final double DEFAULT_PROBABILITY = 1.0E-4D;
  
  private static final Sampler DEFAULT_SAMPLER = Samplers.probabilitySampler(1.0E-4D);
  
  private static final int DEFAULT_SPAN_MAX_NUM_ANNOTATIONS = 32;
  
  private static final int DEFAULT_SPAN_MAX_NUM_ATTRIBUTES = 32;
  
  private static final int DEFAULT_SPAN_MAX_NUM_LINKS = 128;
  
  private static final int DEFAULT_SPAN_MAX_NUM_NETWORK_EVENTS = 128;
  
  static {
    DEFAULT = builder().setSampler(DEFAULT_SAMPLER).setMaxNumberOfAttributes(32).setMaxNumberOfAnnotations(32).setMaxNumberOfNetworkEvents(128).setMaxNumberOfLinks(128).build();
  }
  
  private static Builder builder() {
    return new AutoValue_TraceParams.Builder();
  }
  
  public abstract int getMaxNumberOfAnnotations();
  
  public abstract int getMaxNumberOfAttributes();
  
  public abstract int getMaxNumberOfLinks();
  
  public abstract int getMaxNumberOfNetworkEvents();
  
  public abstract Sampler getSampler();
  
  public abstract Builder toBuilder();
  
  public static abstract class Builder {
    abstract TraceParams autoBuild();
    
    public TraceParams build() {
      boolean bool2;
      TraceParams traceParams = autoBuild();
      int i = traceParams.getMaxNumberOfAttributes();
      boolean bool1 = true;
      if (i > 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "maxNumberOfAttributes");
      if (traceParams.getMaxNumberOfAnnotations() > 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "maxNumberOfAnnotations");
      if (traceParams.getMaxNumberOfNetworkEvents() > 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "maxNumberOfNetworkEvents");
      if (traceParams.getMaxNumberOfLinks() > 0) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "maxNumberOfLinks");
      return traceParams;
    }
    
    public abstract Builder setMaxNumberOfAnnotations(int param1Int);
    
    public abstract Builder setMaxNumberOfAttributes(int param1Int);
    
    public abstract Builder setMaxNumberOfLinks(int param1Int);
    
    public abstract Builder setMaxNumberOfNetworkEvents(int param1Int);
    
    public abstract Builder setSampler(Sampler param1Sampler);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\config\TraceParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */