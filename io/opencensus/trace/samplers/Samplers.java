package io.opencensus.trace.samplers;

import io.opencensus.trace.Sampler;

public final class Samplers {
  private static final Sampler ALWAYS_SAMPLE = new AlwaysSampleSampler();
  
  private static final Sampler NEVER_SAMPLE = new NeverSampleSampler();
  
  public static Sampler alwaysSample() {
    return ALWAYS_SAMPLE;
  }
  
  public static Sampler neverSample() {
    return NEVER_SAMPLE;
  }
  
  public static Sampler probabilitySampler(double paramDouble) {
    return ProbabilitySampler.create(paramDouble);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\samplers\Samplers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */