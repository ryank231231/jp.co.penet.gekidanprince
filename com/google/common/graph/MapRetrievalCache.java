package com.google.common.graph;

import java.util.Map;
import javax.annotation.Nullable;

class MapRetrievalCache<K, V> extends MapIteratorCache<K, V> {
  @Nullable
  private transient CacheEntry<K, V> cacheEntry1;
  
  @Nullable
  private transient CacheEntry<K, V> cacheEntry2;
  
  MapRetrievalCache(Map<K, V> paramMap) {
    super(paramMap);
  }
  
  private void addToCache(CacheEntry<K, V> paramCacheEntry) {
    this.cacheEntry2 = this.cacheEntry1;
    this.cacheEntry1 = paramCacheEntry;
  }
  
  private void addToCache(K paramK, V paramV) {
    addToCache(new CacheEntry<K, V>(paramK, paramV));
  }
  
  protected void clearCache() {
    super.clearCache();
    this.cacheEntry1 = null;
    this.cacheEntry2 = null;
  }
  
  public V get(@Nullable Object paramObject) {
    V v = getIfCached(paramObject);
    if (v != null)
      return v; 
    v = getWithoutCaching(paramObject);
    if (v != null)
      addToCache((K)paramObject, v); 
    return v;
  }
  
  protected V getIfCached(@Nullable Object paramObject) {
    V v = super.getIfCached(paramObject);
    if (v != null)
      return v; 
    CacheEntry<K, V> cacheEntry = this.cacheEntry1;
    if (cacheEntry != null && cacheEntry.key == paramObject)
      return cacheEntry.value; 
    cacheEntry = this.cacheEntry2;
    if (cacheEntry != null && cacheEntry.key == paramObject) {
      addToCache(cacheEntry);
      return cacheEntry.value;
    } 
    return null;
  }
  
  private static final class CacheEntry<K, V> {
    final K key;
    
    final V value;
    
    CacheEntry(K param1K, V param1V) {
      this.key = param1K;
      this.value = param1V;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\MapRetrievalCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */