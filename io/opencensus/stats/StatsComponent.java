package io.opencensus.stats;

public abstract class StatsComponent {
  public abstract StatsCollectionState getState();
  
  public abstract StatsRecorder getStatsRecorder();
  
  public abstract ViewManager getViewManager();
  
  @Deprecated
  public abstract void setState(StatsCollectionState paramStatsCollectionState);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\StatsComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */