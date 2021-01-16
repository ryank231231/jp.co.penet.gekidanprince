package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@GwtCompatible
public abstract class AbstractCache<K, V> implements Cache<K, V> {
  public ConcurrentMap<K, V> asMap() {
    throw new UnsupportedOperationException();
  }
  
  public void cleanUp() {}
  
  public V get(K paramK, Callable<? extends V> paramCallable) throws ExecutionException {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableMap<K, V> getAllPresent(Iterable<?> paramIterable) {
    LinkedHashMap<Iterable<?>, V> linkedHashMap = Maps.newLinkedHashMap();
    for (Iterable<?> paramIterable : paramIterable) {
      if (!linkedHashMap.containsKey(paramIterable)) {
        V v = getIfPresent(paramIterable);
        if (v != null)
          linkedHashMap.put(paramIterable, v); 
      } 
    } 
    return ImmutableMap.copyOf(linkedHashMap);
  }
  
  public void invalidate(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  public void invalidateAll() {
    throw new UnsupportedOperationException();
  }
  
  public void invalidateAll(Iterable<?> paramIterable) {
    Iterator<?> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      invalidate(iterator.next()); 
  }
  
  public void put(K paramK, V paramV) {
    throw new UnsupportedOperationException();
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap) {
    for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet())
      put((K)entry.getKey(), (V)entry.getValue()); 
  }
  
  public long size() {
    throw new UnsupportedOperationException();
  }
  
  public CacheStats stats() {
    throw new UnsupportedOperationException();
  }
  
  public static final class SimpleStatsCounter implements StatsCounter {
    private final LongAddable evictionCount = LongAddables.create();
    
    private final LongAddable hitCount = LongAddables.create();
    
    private final LongAddable loadExceptionCount = LongAddables.create();
    
    private final LongAddable loadSuccessCount = LongAddables.create();
    
    private final LongAddable missCount = LongAddables.create();
    
    private final LongAddable totalLoadTime = LongAddables.create();
    
    public void incrementBy(AbstractCache.StatsCounter param1StatsCounter) {
      CacheStats cacheStats = param1StatsCounter.snapshot();
      this.hitCount.add(cacheStats.hitCount());
      this.missCount.add(cacheStats.missCount());
      this.loadSuccessCount.add(cacheStats.loadSuccessCount());
      this.loadExceptionCount.add(cacheStats.loadExceptionCount());
      this.totalLoadTime.add(cacheStats.totalLoadTime());
      this.evictionCount.add(cacheStats.evictionCount());
    }
    
    public void recordEviction() {
      this.evictionCount.increment();
    }
    
    public void recordHits(int param1Int) {
      this.hitCount.add(param1Int);
    }
    
    public void recordLoadException(long param1Long) {
      this.loadExceptionCount.increment();
      this.totalLoadTime.add(param1Long);
    }
    
    public void recordLoadSuccess(long param1Long) {
      this.loadSuccessCount.increment();
      this.totalLoadTime.add(param1Long);
    }
    
    public void recordMisses(int param1Int) {
      this.missCount.add(param1Int);
    }
    
    public CacheStats snapshot() {
      return new CacheStats(this.hitCount.sum(), this.missCount.sum(), this.loadSuccessCount.sum(), this.loadExceptionCount.sum(), this.totalLoadTime.sum(), this.evictionCount.sum());
    }
  }
  
  public static interface StatsCounter {
    void recordEviction();
    
    void recordHits(int param1Int);
    
    void recordLoadException(long param1Long);
    
    void recordLoadSuccess(long param1Long);
    
    void recordMisses(int param1Int);
    
    CacheStats snapshot();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\cache\AbstractCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */