package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@GwtCompatible
public interface LoadingCache<K, V> extends Cache<K, V>, Function<K, V> {
  @Deprecated
  V apply(K paramK);
  
  ConcurrentMap<K, V> asMap();
  
  V get(K paramK) throws ExecutionException;
  
  ImmutableMap<K, V> getAll(Iterable<? extends K> paramIterable) throws ExecutionException;
  
  V getUnchecked(K paramK);
  
  void refresh(K paramK);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\cache\LoadingCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */