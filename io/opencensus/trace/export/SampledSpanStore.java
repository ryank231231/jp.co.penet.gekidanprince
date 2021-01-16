package io.opencensus.trace.export;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import io.opencensus.trace.Status;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class SampledSpanStore {
  static SampledSpanStore newNoopSampledSpanStore() {
    return new NoopSampledSpanStore();
  }
  
  public abstract Collection<SpanData> getErrorSampledSpans(ErrorFilter paramErrorFilter);
  
  public abstract Collection<SpanData> getLatencySampledSpans(LatencyFilter paramLatencyFilter);
  
  @VisibleForTesting
  public abstract Set<String> getRegisteredSpanNamesForCollection();
  
  public abstract Summary getSummary();
  
  public abstract void registerSpanNamesForCollection(Collection<String> paramCollection);
  
  public abstract void unregisterSpanNamesForCollection(Collection<String> paramCollection);
  
  @Immutable
  public static abstract class ErrorFilter {
    public static ErrorFilter create(String param1String, @Nullable Status.CanonicalCode param1CanonicalCode, int param1Int) {
      boolean bool2;
      boolean bool1 = true;
      if (param1CanonicalCode != null) {
        if (param1CanonicalCode != Status.CanonicalCode.OK) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        Preconditions.checkArgument(bool2, "Invalid canonical code.");
      } 
      if (param1Int >= 0) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "Negative maxSpansToReturn.");
      return new AutoValue_SampledSpanStore_ErrorFilter(param1String, param1CanonicalCode, param1Int);
    }
    
    @Nullable
    public abstract Status.CanonicalCode getCanonicalCode();
    
    public abstract int getMaxSpansToReturn();
    
    public abstract String getSpanName();
  }
  
  public enum LatencyBucketBoundaries {
    MICROSx100_MILLIx1,
    MICROSx10_MICROSx100,
    MILLIx100_SECONDx1,
    MILLIx10_MILLIx100,
    MILLIx1_MILLIx10,
    SECONDx100_MAX,
    SECONDx10_SECONDx100,
    SECONDx1_SECONDx10,
    ZERO_MICROSx10(0L, TimeUnit.MICROSECONDS.toNanos(10L));
    
    private final long latencyLowerNs;
    
    private final long latencyUpperNs;
    
    static {
      MICROSx100_MILLIx1 = new LatencyBucketBoundaries("MICROSx100_MILLIx1", 2, TimeUnit.MICROSECONDS.toNanos(100L), TimeUnit.MILLISECONDS.toNanos(1L));
      MILLIx1_MILLIx10 = new LatencyBucketBoundaries("MILLIx1_MILLIx10", 3, TimeUnit.MILLISECONDS.toNanos(1L), TimeUnit.MILLISECONDS.toNanos(10L));
      MILLIx10_MILLIx100 = new LatencyBucketBoundaries("MILLIx10_MILLIx100", 4, TimeUnit.MILLISECONDS.toNanos(10L), TimeUnit.MILLISECONDS.toNanos(100L));
      MILLIx100_SECONDx1 = new LatencyBucketBoundaries("MILLIx100_SECONDx1", 5, TimeUnit.MILLISECONDS.toNanos(100L), TimeUnit.SECONDS.toNanos(1L));
      SECONDx1_SECONDx10 = new LatencyBucketBoundaries("SECONDx1_SECONDx10", 6, TimeUnit.SECONDS.toNanos(1L), TimeUnit.SECONDS.toNanos(10L));
      SECONDx10_SECONDx100 = new LatencyBucketBoundaries("SECONDx10_SECONDx100", 7, TimeUnit.SECONDS.toNanos(10L), TimeUnit.SECONDS.toNanos(100L));
      SECONDx100_MAX = new LatencyBucketBoundaries("SECONDx100_MAX", 8, TimeUnit.SECONDS.toNanos(100L), Long.MAX_VALUE);
      $VALUES = new LatencyBucketBoundaries[] { ZERO_MICROSx10, MICROSx10_MICROSx100, MICROSx100_MILLIx1, MILLIx1_MILLIx10, MILLIx10_MILLIx100, MILLIx100_SECONDx1, SECONDx1_SECONDx10, SECONDx10_SECONDx100, SECONDx100_MAX };
    }
    
    LatencyBucketBoundaries(long param1Long1, long param1Long2) {
      this.latencyLowerNs = param1Long1;
      this.latencyUpperNs = param1Long2;
    }
    
    public long getLatencyLowerNs() {
      return this.latencyLowerNs;
    }
    
    public long getLatencyUpperNs() {
      return this.latencyUpperNs;
    }
  }
  
  @Immutable
  public static abstract class LatencyFilter {
    public static LatencyFilter create(String param1String, long param1Long1, long param1Long2, int param1Int) {
      boolean bool2;
      boolean bool1 = true;
      if (param1Int >= 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "Negative maxSpansToReturn.");
      if (param1Long1 >= 0L) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "Negative latencyLowerNs");
      if (param1Long2 >= 0L) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "Negative latencyUpperNs");
      return new AutoValue_SampledSpanStore_LatencyFilter(param1String, param1Long1, param1Long2, param1Int);
    }
    
    public abstract long getLatencyLowerNs();
    
    public abstract long getLatencyUpperNs();
    
    public abstract int getMaxSpansToReturn();
    
    public abstract String getSpanName();
  }
  
  @ThreadSafe
  private static final class NoopSampledSpanStore extends SampledSpanStore {
    private static final SampledSpanStore.PerSpanNameSummary EMPTY_PER_SPAN_NAME_SUMMARY = SampledSpanStore.PerSpanNameSummary.create(Collections.emptyMap(), Collections.emptyMap());
    
    @GuardedBy("registeredSpanNames")
    private final Set<String> registeredSpanNames = Sets.newHashSet();
    
    private NoopSampledSpanStore() {}
    
    public Collection<SpanData> getErrorSampledSpans(SampledSpanStore.ErrorFilter param1ErrorFilter) {
      Preconditions.checkNotNull(param1ErrorFilter, "errorFilter");
      return Collections.emptyList();
    }
    
    public Collection<SpanData> getLatencySampledSpans(SampledSpanStore.LatencyFilter param1LatencyFilter) {
      Preconditions.checkNotNull(param1LatencyFilter, "latencyFilter");
      return Collections.emptyList();
    }
    
    public Set<String> getRegisteredSpanNamesForCollection() {
      synchronized (this.registeredSpanNames) {
        return (Set)Collections.unmodifiableSet(Sets.newHashSet(this.registeredSpanNames));
      } 
    }
    
    public SampledSpanStore.Summary getSummary() {
      HashMap<String, SampledSpanStore.PerSpanNameSummary> hashMap = Maps.newHashMap();
      synchronized (this.registeredSpanNames) {
        Iterator<String> iterator = this.registeredSpanNames.iterator();
        while (iterator.hasNext())
          hashMap.put(iterator.next(), EMPTY_PER_SPAN_NAME_SUMMARY); 
        return SampledSpanStore.Summary.create(hashMap);
      } 
    }
    
    public void registerSpanNamesForCollection(Collection<String> param1Collection) {
      Preconditions.checkNotNull(param1Collection, "spanNames");
      synchronized (this.registeredSpanNames) {
        this.registeredSpanNames.addAll(param1Collection);
        return;
      } 
    }
    
    public void unregisterSpanNamesForCollection(Collection<String> param1Collection) {
      Preconditions.checkNotNull(param1Collection);
      synchronized (this.registeredSpanNames) {
        this.registeredSpanNames.removeAll(param1Collection);
        return;
      } 
    }
  }
  
  @Immutable
  public static abstract class PerSpanNameSummary {
    public static PerSpanNameSummary create(Map<SampledSpanStore.LatencyBucketBoundaries, Integer> param1Map, Map<Status.CanonicalCode, Integer> param1Map1) {
      return new AutoValue_SampledSpanStore_PerSpanNameSummary(Collections.unmodifiableMap(new HashMap<SampledSpanStore.LatencyBucketBoundaries, Integer>((Map<? extends SampledSpanStore.LatencyBucketBoundaries, ? extends Integer>)Preconditions.checkNotNull(param1Map, "numbersOfLatencySampledSpans"))), Collections.unmodifiableMap(new HashMap<Status.CanonicalCode, Integer>((Map<? extends Status.CanonicalCode, ? extends Integer>)Preconditions.checkNotNull(param1Map1, "numbersOfErrorSampledSpans"))));
    }
    
    public abstract Map<Status.CanonicalCode, Integer> getNumbersOfErrorSampledSpans();
    
    public abstract Map<SampledSpanStore.LatencyBucketBoundaries, Integer> getNumbersOfLatencySampledSpans();
  }
  
  @Immutable
  public static abstract class Summary {
    public static Summary create(Map<String, SampledSpanStore.PerSpanNameSummary> param1Map) {
      return new AutoValue_SampledSpanStore_Summary(Collections.unmodifiableMap(new HashMap<String, SampledSpanStore.PerSpanNameSummary>((Map<? extends String, ? extends SampledSpanStore.PerSpanNameSummary>)Preconditions.checkNotNull(param1Map, "perSpanNameSummary"))));
    }
    
    public abstract Map<String, SampledSpanStore.PerSpanNameSummary> getPerSpanNameSummary();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\SampledSpanStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */