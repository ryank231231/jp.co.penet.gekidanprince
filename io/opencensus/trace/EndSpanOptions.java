package io.opencensus.trace;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class EndSpanOptions {
  public static final EndSpanOptions DEFAULT = builder().build();
  
  public static Builder builder() {
    return (new AutoValue_EndSpanOptions.Builder()).setSampleToLocalSpanStore(false);
  }
  
  public abstract boolean getSampleToLocalSpanStore();
  
  @Nullable
  public abstract Status getStatus();
  
  public static abstract class Builder {
    public abstract EndSpanOptions build();
    
    public abstract Builder setSampleToLocalSpanStore(boolean param1Boolean);
    
    public abstract Builder setStatus(Status param1Status);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\EndSpanOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */