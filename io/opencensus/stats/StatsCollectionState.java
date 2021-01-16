package io.opencensus.stats;

public enum StatsCollectionState {
  DISABLED, ENABLED;
  
  static {
    DISABLED = new StatsCollectionState("DISABLED", 1);
    $VALUES = new StatsCollectionState[] { ENABLED, DISABLED };
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\StatsCollectionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */