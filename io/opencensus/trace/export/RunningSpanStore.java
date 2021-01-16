package io.opencensus.trace.export;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class RunningSpanStore {
  private static final RunningSpanStore NOOP_RUNNING_SPAN_STORE = new NoopRunningSpanStore();
  
  static RunningSpanStore getNoopRunningSpanStore() {
    return NOOP_RUNNING_SPAN_STORE;
  }
  
  public abstract Collection<SpanData> getRunningSpans(Filter paramFilter);
  
  public abstract Summary getSummary();
  
  @Immutable
  public static abstract class Filter {
    public static Filter create(String param1String, int param1Int) {
      boolean bool;
      if (param1Int >= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "Negative maxSpansToReturn.");
      return new AutoValue_RunningSpanStore_Filter(param1String, param1Int);
    }
    
    public abstract int getMaxSpansToReturn();
    
    public abstract String getSpanName();
  }
  
  private static final class NoopRunningSpanStore extends RunningSpanStore {
    private static final RunningSpanStore.Summary EMPTY_SUMMARY = RunningSpanStore.Summary.create(Collections.emptyMap());
    
    private NoopRunningSpanStore() {}
    
    public Collection<SpanData> getRunningSpans(RunningSpanStore.Filter param1Filter) {
      Preconditions.checkNotNull(param1Filter, "filter");
      return Collections.emptyList();
    }
    
    public RunningSpanStore.Summary getSummary() {
      return EMPTY_SUMMARY;
    }
  }
  
  @Immutable
  public static abstract class PerSpanNameSummary {
    public static PerSpanNameSummary create(int param1Int) {
      boolean bool;
      if (param1Int >= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "Negative numRunningSpans.");
      return new AutoValue_RunningSpanStore_PerSpanNameSummary(param1Int);
    }
    
    public abstract int getNumRunningSpans();
  }
  
  @Immutable
  public static abstract class Summary {
    public static Summary create(Map<String, RunningSpanStore.PerSpanNameSummary> param1Map) {
      return new AutoValue_RunningSpanStore_Summary(Collections.unmodifiableMap(new HashMap<String, RunningSpanStore.PerSpanNameSummary>((Map<? extends String, ? extends RunningSpanStore.PerSpanNameSummary>)Preconditions.checkNotNull(param1Map, "perSpanNameSummary"))));
    }
    
    public abstract Map<String, RunningSpanStore.PerSpanNameSummary> getPerSpanNameSummary();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\RunningSpanStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */