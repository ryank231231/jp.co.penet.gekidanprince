package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@GwtCompatible
public final class AtomicLongMap<K> {
  private transient Map<K, Long> asMap;
  
  private final ConcurrentHashMap<K, AtomicLong> map;
  
  private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> paramConcurrentHashMap) {
    this.map = (ConcurrentHashMap<K, AtomicLong>)Preconditions.checkNotNull(paramConcurrentHashMap);
  }
  
  public static <K> AtomicLongMap<K> create() {
    return new AtomicLongMap<K>(new ConcurrentHashMap<K, AtomicLong>());
  }
  
  public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> paramMap) {
    AtomicLongMap<?> atomicLongMap = create();
    atomicLongMap.putAll(paramMap);
    return (AtomicLongMap)atomicLongMap;
  }
  
  private Map<K, Long> createAsMap() {
    return Collections.unmodifiableMap(Maps.transformValues(this.map, new Function<AtomicLong, Long>() {
            public Long apply(AtomicLong param1AtomicLong) {
              return Long.valueOf(param1AtomicLong.get());
            }
          }));
  }
  
  @CanIgnoreReturnValue
  public long addAndGet(K paramK, long paramLong) {
    label16: while (true) {
      AtomicLong atomicLong1 = this.map.get(paramK);
      AtomicLong atomicLong2 = atomicLong1;
      if (atomicLong1 == null) {
        atomicLong1 = this.map.putIfAbsent(paramK, new AtomicLong(paramLong));
        atomicLong2 = atomicLong1;
        if (atomicLong1 == null)
          return paramLong; 
      } 
      while (true) {
        long l1 = atomicLong2.get();
        if (l1 == 0L) {
          if (this.map.replace(paramK, atomicLong2, new AtomicLong(paramLong)))
            return paramLong; 
          continue label16;
        } 
        long l2 = l1 + paramLong;
        if (atomicLong2.compareAndSet(l1, l2))
          return l2; 
      } 
      break;
    } 
  }
  
  public Map<K, Long> asMap() {
    Map<K, Long> map1 = this.asMap;
    Map<K, Long> map2 = map1;
    if (map1 == null) {
      map2 = createAsMap();
      this.asMap = map2;
    } 
    return map2;
  }
  
  public void clear() {
    this.map.clear();
  }
  
  public boolean containsKey(Object paramObject) {
    return this.map.containsKey(paramObject);
  }
  
  @CanIgnoreReturnValue
  public long decrementAndGet(K paramK) {
    return addAndGet(paramK, -1L);
  }
  
  public long get(K paramK) {
    long l;
    AtomicLong atomicLong = this.map.get(paramK);
    if (atomicLong == null) {
      l = 0L;
    } else {
      l = atomicLong.get();
    } 
    return l;
  }
  
  @CanIgnoreReturnValue
  public long getAndAdd(K paramK, long paramLong) {
    label15: while (true) {
      AtomicLong atomicLong1 = this.map.get(paramK);
      AtomicLong atomicLong2 = atomicLong1;
      if (atomicLong1 == null) {
        atomicLong1 = this.map.putIfAbsent(paramK, new AtomicLong(paramLong));
        atomicLong2 = atomicLong1;
        if (atomicLong1 == null)
          return 0L; 
      } 
      while (true) {
        long l = atomicLong2.get();
        if (l == 0L) {
          if (this.map.replace(paramK, atomicLong2, new AtomicLong(paramLong)))
            return 0L; 
          continue label15;
        } 
        if (atomicLong2.compareAndSet(l, l + paramLong))
          return l; 
      } 
      break;
    } 
  }
  
  @CanIgnoreReturnValue
  public long getAndDecrement(K paramK) {
    return getAndAdd(paramK, -1L);
  }
  
  @CanIgnoreReturnValue
  public long getAndIncrement(K paramK) {
    return getAndAdd(paramK, 1L);
  }
  
  @CanIgnoreReturnValue
  public long incrementAndGet(K paramK) {
    return addAndGet(paramK, 1L);
  }
  
  public boolean isEmpty() {
    return this.map.isEmpty();
  }
  
  @CanIgnoreReturnValue
  public long put(K paramK, long paramLong) {
    label15: while (true) {
      AtomicLong atomicLong1 = this.map.get(paramK);
      AtomicLong atomicLong2 = atomicLong1;
      if (atomicLong1 == null) {
        atomicLong1 = this.map.putIfAbsent(paramK, new AtomicLong(paramLong));
        atomicLong2 = atomicLong1;
        if (atomicLong1 == null)
          return 0L; 
      } 
      while (true) {
        long l = atomicLong2.get();
        if (l == 0L) {
          if (this.map.replace(paramK, atomicLong2, new AtomicLong(paramLong)))
            return 0L; 
          continue label15;
        } 
        if (atomicLong2.compareAndSet(l, paramLong))
          return l; 
      } 
      break;
    } 
  }
  
  public void putAll(Map<? extends K, ? extends Long> paramMap) {
    for (Map.Entry<? extends K, ? extends Long> entry : paramMap.entrySet())
      put((K)entry.getKey(), ((Long)entry.getValue()).longValue()); 
  }
  
  long putIfAbsent(K paramK, long paramLong) {
    while (true) {
      AtomicLong atomicLong1 = this.map.get(paramK);
      AtomicLong atomicLong2 = atomicLong1;
      if (atomicLong1 == null) {
        atomicLong1 = this.map.putIfAbsent(paramK, new AtomicLong(paramLong));
        atomicLong2 = atomicLong1;
        if (atomicLong1 == null)
          return 0L; 
      } 
      long l = atomicLong2.get();
      if (l == 0L) {
        if (this.map.replace(paramK, atomicLong2, new AtomicLong(paramLong)))
          return 0L; 
        continue;
      } 
      return l;
    } 
  }
  
  @CanIgnoreReturnValue
  public long remove(K paramK) {
    long l;
    AtomicLong atomicLong = this.map.get(paramK);
    if (atomicLong == null)
      return 0L; 
    do {
      l = atomicLong.get();
    } while (l != 0L && !atomicLong.compareAndSet(l, 0L));
    this.map.remove(paramK, atomicLong);
    return l;
  }
  
  boolean remove(K paramK, long paramLong) {
    AtomicLong atomicLong = this.map.get(paramK);
    if (atomicLong == null)
      return false; 
    long l = atomicLong.get();
    if (l != paramLong)
      return false; 
    if (l == 0L || atomicLong.compareAndSet(l, 0L)) {
      this.map.remove(paramK, atomicLong);
      return true;
    } 
    return false;
  }
  
  public void removeAllZeros() {
    Iterator<Map.Entry> iterator = this.map.entrySet().iterator();
    while (iterator.hasNext()) {
      AtomicLong atomicLong = (AtomicLong)((Map.Entry)iterator.next()).getValue();
      if (atomicLong != null && atomicLong.get() == 0L)
        iterator.remove(); 
    } 
  }
  
  @Beta
  @CanIgnoreReturnValue
  public boolean removeIfZero(K paramK) {
    return remove(paramK, 0L);
  }
  
  boolean replace(K paramK, long paramLong1, long paramLong2) {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramLong1 == 0L) {
      if (putIfAbsent(paramK, paramLong2) == 0L)
        bool2 = true; 
      return bool2;
    } 
    AtomicLong atomicLong = this.map.get(paramK);
    if (atomicLong == null) {
      bool2 = bool1;
    } else {
      bool2 = atomicLong.compareAndSet(paramLong1, paramLong2);
    } 
    return bool2;
  }
  
  public int size() {
    return this.map.size();
  }
  
  public long sum() {
    Iterator<AtomicLong> iterator = this.map.values().iterator();
    long l;
    for (l = 0L; iterator.hasNext(); l += ((AtomicLong)iterator.next()).get());
    return l;
  }
  
  public String toString() {
    return this.map.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\AtomicLongMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */