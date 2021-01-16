package io.opencensus.stats;

import com.google.common.annotations.VisibleForTesting;
import io.opencensus.internal.Provider;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class Stats {
  private static final Logger logger = Logger.getLogger(Stats.class.getName());
  
  private static final StatsComponent statsComponent = loadStatsComponent(StatsComponent.class.getClassLoader());
  
  public static StatsCollectionState getState() {
    return statsComponent.getState();
  }
  
  public static StatsRecorder getStatsRecorder() {
    return statsComponent.getStatsRecorder();
  }
  
  public static ViewManager getViewManager() {
    return statsComponent.getViewManager();
  }
  
  @VisibleForTesting
  static StatsComponent loadStatsComponent(@Nullable ClassLoader paramClassLoader) {
    try {
      return (StatsComponent)Provider.createInstance(Class.forName("io.opencensus.impl.stats.StatsComponentImpl", true, paramClassLoader), StatsComponent.class);
    } catch (ClassNotFoundException classNotFoundException) {
      logger.log(Level.FINE, "Couldn't load full implementation for StatsComponent, now trying to load lite implementation.", classNotFoundException);
      try {
        return (StatsComponent)Provider.createInstance(Class.forName("io.opencensus.impllite.stats.StatsComponentImplLite", true, paramClassLoader), StatsComponent.class);
      } catch (ClassNotFoundException classNotFoundException1) {
        logger.log(Level.FINE, "Couldn't load lite implementation for StatsComponent, now using default implementation for StatsComponent.", classNotFoundException1);
        return NoopStats.newNoopStatsComponent();
      } 
    } 
  }
  
  @Deprecated
  public static void setState(StatsCollectionState paramStatsCollectionState) {
    statsComponent.setState(paramStatsCollectionState);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\Stats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */