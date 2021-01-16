package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class MapIteratorCache<K, V> {
  private final Map<K, V> backingMap;
  
  @Nullable
  private transient Map.Entry<K, V> entrySetCache;
  
  MapIteratorCache(Map<K, V> paramMap) {
    this.backingMap = (Map<K, V>)Preconditions.checkNotNull(paramMap);
  }
  
  public void clear() {
    clearCache();
    this.backingMap.clear();
  }
  
  protected void clearCache() {
    this.entrySetCache = null;
  }
  
  public final boolean containsKey(@Nullable Object paramObject) {
    return (getIfCached(paramObject) != null || this.backingMap.containsKey(paramObject));
  }
  
  public V get(@Nullable Object paramObject) {
    V v = getIfCached(paramObject);
    if (v != null) {
      paramObject = v;
    } else {
      paramObject = getWithoutCaching(paramObject);
    } 
    return (V)paramObject;
  }
  
  protected V getIfCached(@Nullable Object paramObject) {
    Map.Entry<K, V> entry = this.entrySetCache;
    return (entry != null && entry.getKey() == paramObject) ? entry.getValue() : null;
  }
  
  public final V getWithoutCaching(@Nullable Object paramObject) {
    return this.backingMap.get(paramObject);
  }
  
  @CanIgnoreReturnValue
  public V put(@Nullable K paramK, @Nullable V paramV) {
    clearCache();
    return this.backingMap.put(paramK, paramV);
  }
  
  @CanIgnoreReturnValue
  public V remove(@Nullable Object paramObject) {
    clearCache();
    return this.backingMap.remove(paramObject);
  }
  
  public final Set<K> unmodifiableKeySet() {
    return new AbstractSet<K>() {
        public boolean contains(@Nullable Object param1Object) {
          return MapIteratorCache.this.containsKey(param1Object);
        }
        
        public UnmodifiableIterator<K> iterator() {
          return new UnmodifiableIterator<K>() {
              public boolean hasNext() {
                return entryIterator.hasNext();
              }
              
              public K next() {
                Map.Entry entry = entryIterator.next();
                MapIteratorCache.access$102(MapIteratorCache.this, entry);
                return (K)entry.getKey();
              }
            };
        }
        
        public int size() {
          return MapIteratorCache.this.backingMap.size();
        }
      };
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\MapIteratorCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */