package io.opencensus.stats;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import io.opencensus.common.Functions;
import io.opencensus.common.Timestamp;
import io.opencensus.tags.TagContext;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

final class NoopStats {
  static MeasureMap getNoopMeasureMap() {
    return NoopMeasureMap.INSTANCE;
  }
  
  static StatsRecorder getNoopStatsRecorder() {
    return NoopStatsRecorder.INSTANCE;
  }
  
  static StatsComponent newNoopStatsComponent() {
    return new NoopStatsComponent();
  }
  
  static ViewManager newNoopViewManager() {
    return new NoopViewManager();
  }
  
  @Immutable
  private static final class NoopMeasureMap extends MeasureMap {
    static final MeasureMap INSTANCE = new NoopMeasureMap();
    
    public MeasureMap put(Measure.MeasureDouble param1MeasureDouble, double param1Double) {
      return this;
    }
    
    public MeasureMap put(Measure.MeasureLong param1MeasureLong, long param1Long) {
      return this;
    }
    
    public void record() {}
    
    public void record(TagContext param1TagContext) {
      Preconditions.checkNotNull(param1TagContext, "tags");
    }
  }
  
  @ThreadSafe
  private static final class NoopStatsComponent extends StatsComponent {
    private volatile boolean isRead;
    
    private final ViewManager viewManager = NoopStats.newNoopViewManager();
    
    private NoopStatsComponent() {}
    
    public StatsCollectionState getState() {
      this.isRead = true;
      return StatsCollectionState.DISABLED;
    }
    
    public StatsRecorder getStatsRecorder() {
      return NoopStats.getNoopStatsRecorder();
    }
    
    public ViewManager getViewManager() {
      return this.viewManager;
    }
    
    @Deprecated
    public void setState(StatsCollectionState param1StatsCollectionState) {
      Preconditions.checkNotNull(param1StatsCollectionState, "state");
      Preconditions.checkState(this.isRead ^ true, "State was already read, cannot set state.");
    }
  }
  
  @Immutable
  private static final class NoopStatsRecorder extends StatsRecorder {
    static final StatsRecorder INSTANCE = new NoopStatsRecorder();
    
    public MeasureMap newMeasureMap() {
      return NoopStats.getNoopMeasureMap();
    }
  }
  
  @ThreadSafe
  private static final class NoopViewManager extends ViewManager {
    private static final Timestamp ZERO_TIMESTAMP = Timestamp.create(0L, 0);
    
    @Nullable
    private volatile Set<View> exportedViews;
    
    @GuardedBy("registeredViews")
    private final Map<View.Name, View> registeredViews = Maps.newHashMap();
    
    private NoopViewManager() {}
    
    private static Set<View> filterExportedViews(Collection<View> param1Collection) {
      HashSet<View> hashSet = Sets.newHashSet();
      for (View view : param1Collection) {
        if (view.getWindow() instanceof View.AggregationWindow.Cumulative)
          hashSet.add(view); 
      } 
      return Collections.unmodifiableSet(hashSet);
    }
    
    public Set<View> getAllExportedViews() {
      Set<View> set1 = this.exportedViews;
      Set<View> set2 = set1;
      if (set1 == null)
        synchronized (this.registeredViews) {
          set2 = filterExportedViews(this.registeredViews.values());
          this.exportedViews = set2;
        }  
      return set2;
    }
    
    @Nullable
    public ViewData getView(View.Name param1Name) {
      Preconditions.checkNotNull(param1Name, "name");
      synchronized (this.registeredViews) {
        View view = this.registeredViews.get(param1Name);
        if (view == null)
          return null; 
        return ViewData.create(view, Collections.emptyMap(), view.getWindow().<ViewData.AggregationWindowData>match(Functions.returnConstant(ViewData.AggregationWindowData.CumulativeData.create(ZERO_TIMESTAMP, ZERO_TIMESTAMP)), Functions.returnConstant(ViewData.AggregationWindowData.IntervalData.create(ZERO_TIMESTAMP)), Functions.throwAssertionError()));
      } 
    }
    
    public void registerView(View param1View) {
      Preconditions.checkNotNull(param1View, "newView");
      synchronized (this.registeredViews) {
        boolean bool;
        this.exportedViews = null;
        View view = this.registeredViews.get(param1View.getName());
        if (view == null || param1View.equals(view)) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.checkArgument(bool, "A different view with the same name already exists.");
        if (view == null)
          this.registeredViews.put(param1View.getName(), param1View); 
        return;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\NoopStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */