package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

@GwtCompatible(emulated = true)
class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
  static final int CONTAINS_VALUE_RETRIES = 3;
  
  static final Queue<? extends Object> DISCARDING_QUEUE;
  
  static final int DRAIN_MAX = 16;
  
  static final int DRAIN_THRESHOLD = 63;
  
  static final int MAXIMUM_CAPACITY = 1073741824;
  
  static final int MAX_SEGMENTS = 65536;
  
  static final ValueReference<Object, Object> UNSET;
  
  static final Logger logger = Logger.getLogger(LocalCache.class.getName());
  
  final int concurrencyLevel;
  
  @Nullable
  final CacheLoader<? super K, V> defaultLoader;
  
  final EntryFactory entryFactory;
  
  Set<Map.Entry<K, V>> entrySet;
  
  final long expireAfterAccessNanos;
  
  final long expireAfterWriteNanos;
  
  final AbstractCache.StatsCounter globalStatsCounter;
  
  final Equivalence<Object> keyEquivalence;
  
  Set<K> keySet;
  
  final Strength keyStrength;
  
  final long maxWeight;
  
  final long refreshNanos;
  
  final RemovalListener<K, V> removalListener;
  
  final Queue<RemovalNotification<K, V>> removalNotificationQueue;
  
  final int segmentMask;
  
  final int segmentShift;
  
  final Segment<K, V>[] segments;
  
  final Ticker ticker;
  
  final Equivalence<Object> valueEquivalence;
  
  final Strength valueStrength;
  
  Collection<V> values;
  
  final Weigher<K, V> weigher;
  
  static {
    UNSET = new ValueReference<Object, Object>() {
        public LocalCache.ValueReference<Object, Object> copyFor(ReferenceQueue<Object> param1ReferenceQueue, @Nullable Object param1Object, LocalCache.ReferenceEntry<Object, Object> param1ReferenceEntry) {
          return this;
        }
        
        public Object get() {
          return null;
        }
        
        public LocalCache.ReferenceEntry<Object, Object> getEntry() {
          return null;
        }
        
        public int getWeight() {
          return 0;
        }
        
        public boolean isActive() {
          return false;
        }
        
        public boolean isLoading() {
          return false;
        }
        
        public void notifyNewValue(Object param1Object) {}
        
        public Object waitForValue() {
          return null;
        }
      };
    DISCARDING_QUEUE = new AbstractQueue() {
        public Iterator<Object> iterator() {
          return (Iterator<Object>)ImmutableSet.of().iterator();
        }
        
        public boolean offer(Object param1Object) {
          return true;
        }
        
        public Object peek() {
          return null;
        }
        
        public Object poll() {
          return null;
        }
        
        public int size() {
          return 0;
        }
      };
  }
  
  LocalCache(CacheBuilder<? super K, ? super V> paramCacheBuilder, @Nullable CacheLoader<? super K, V> paramCacheLoader) {
    Queue<?> queue;
    this.concurrencyLevel = Math.min(paramCacheBuilder.getConcurrencyLevel(), 65536);
    this.keyStrength = paramCacheBuilder.getKeyStrength();
    this.valueStrength = paramCacheBuilder.getValueStrength();
    this.keyEquivalence = paramCacheBuilder.getKeyEquivalence();
    this.valueEquivalence = paramCacheBuilder.getValueEquivalence();
    this.maxWeight = paramCacheBuilder.getMaximumWeight();
    this.weigher = paramCacheBuilder.getWeigher();
    this.expireAfterAccessNanos = paramCacheBuilder.getExpireAfterAccessNanos();
    this.expireAfterWriteNanos = paramCacheBuilder.getExpireAfterWriteNanos();
    this.refreshNanos = paramCacheBuilder.getRefreshNanos();
    this.removalListener = paramCacheBuilder.getRemovalListener();
    if (this.removalListener == CacheBuilder.NullListener.INSTANCE) {
      queue = discardingQueue();
    } else {
      queue = new ConcurrentLinkedQueue();
    } 
    this.removalNotificationQueue = (Queue)queue;
    this.ticker = paramCacheBuilder.getTicker(recordsTime());
    this.entryFactory = EntryFactory.getFactory(this.keyStrength, usesAccessEntries(), usesWriteEntries());
    this.globalStatsCounter = (AbstractCache.StatsCounter)paramCacheBuilder.getStatsCounterSupplier().get();
    this.defaultLoader = paramCacheLoader;
    int i = Math.min(paramCacheBuilder.getInitialCapacity(), 1073741824);
    int j = i;
    if (evictsBySize()) {
      j = i;
      if (!customWeigher())
        j = Math.min(i, (int)this.maxWeight); 
    } 
    boolean bool1 = false;
    boolean bool2 = false;
    byte b = 1;
    i = 1;
    int k = 0;
    while (i < this.concurrencyLevel && (!evictsBySize() || (i * 20) <= this.maxWeight)) {
      k++;
      i <<= 1;
    } 
    this.segmentShift = 32 - k;
    this.segmentMask = i - 1;
    this.segments = newSegmentArray(i);
    int m = j / i;
    k = b;
    int n = m;
    if (m * i < j) {
      n = m + 1;
      k = b;
    } 
    while (k < n)
      k <<= 1; 
    j = bool1;
    if (evictsBySize()) {
      long l1 = this.maxWeight;
      long l2 = i;
      long l3 = l1 / l2 + 1L;
      j = bool2;
      while (j < this.segments.length) {
        long l = l3;
        if (j == l1 % l2)
          l = l3 - 1L; 
        this.segments[j] = createSegment(k, l, (AbstractCache.StatsCounter)paramCacheBuilder.getStatsCounterSupplier().get());
        j++;
        l3 = l;
      } 
    } else {
      while (true) {
        Segment<K, V>[] arrayOfSegment = this.segments;
        if (j < arrayOfSegment.length) {
          arrayOfSegment[j] = createSegment(k, -1L, (AbstractCache.StatsCounter)paramCacheBuilder.getStatsCounterSupplier().get());
          j++;
          continue;
        } 
        break;
      } 
    } 
  }
  
  static <K, V> void connectAccessOrder(ReferenceEntry<K, V> paramReferenceEntry1, ReferenceEntry<K, V> paramReferenceEntry2) {
    paramReferenceEntry1.setNextInAccessQueue(paramReferenceEntry2);
    paramReferenceEntry2.setPreviousInAccessQueue(paramReferenceEntry1);
  }
  
  static <K, V> void connectWriteOrder(ReferenceEntry<K, V> paramReferenceEntry1, ReferenceEntry<K, V> paramReferenceEntry2) {
    paramReferenceEntry1.setNextInWriteQueue(paramReferenceEntry2);
    paramReferenceEntry2.setPreviousInWriteQueue(paramReferenceEntry1);
  }
  
  static <E> Queue<E> discardingQueue() {
    return (Queue)DISCARDING_QUEUE;
  }
  
  static <K, V> ReferenceEntry<K, V> nullEntry() {
    return NullEntry.INSTANCE;
  }
  
  static <K, V> void nullifyAccessOrder(ReferenceEntry<K, V> paramReferenceEntry) {
    ReferenceEntry<?, ?> referenceEntry = nullEntry();
    paramReferenceEntry.setNextInAccessQueue((ReferenceEntry)referenceEntry);
    paramReferenceEntry.setPreviousInAccessQueue((ReferenceEntry)referenceEntry);
  }
  
  static <K, V> void nullifyWriteOrder(ReferenceEntry<K, V> paramReferenceEntry) {
    ReferenceEntry<?, ?> referenceEntry = nullEntry();
    paramReferenceEntry.setNextInWriteQueue((ReferenceEntry)referenceEntry);
    paramReferenceEntry.setPreviousInWriteQueue((ReferenceEntry)referenceEntry);
  }
  
  static int rehash(int paramInt) {
    paramInt += paramInt << 15 ^ 0xFFFFCD7D;
    paramInt ^= paramInt >>> 10;
    paramInt += paramInt << 3;
    paramInt ^= paramInt >>> 6;
    paramInt += (paramInt << 2) + (paramInt << 14);
    return paramInt ^ paramInt >>> 16;
  }
  
  private static <E> ArrayList<E> toArrayList(Collection<E> paramCollection) {
    ArrayList<E> arrayList = new ArrayList(paramCollection.size());
    Iterators.addAll(arrayList, paramCollection.iterator());
    return arrayList;
  }
  
  static <K, V> ValueReference<K, V> unset() {
    return (ValueReference)UNSET;
  }
  
  public void cleanUp() {
    Segment<K, V>[] arrayOfSegment = this.segments;
    int i = arrayOfSegment.length;
    for (byte b = 0; b < i; b++)
      arrayOfSegment[b].cleanUp(); 
  }
  
  public void clear() {
    Segment<K, V>[] arrayOfSegment = this.segments;
    int i = arrayOfSegment.length;
    for (byte b = 0; b < i; b++)
      arrayOfSegment[b].clear(); 
  }
  
  public boolean containsKey(@Nullable Object paramObject) {
    if (paramObject == null)
      return false; 
    int i = hash(paramObject);
    return segmentFor(i).containsKey(paramObject, i);
  }
  
  public boolean containsValue(@Nullable Object paramObject) {
    if (paramObject == null)
      return false; 
    long l1 = this.ticker.read();
    Segment<K, V>[] arrayOfSegment = this.segments;
    long l2 = -1L;
    byte b = 0;
    while (b < 3) {
      int i = arrayOfSegment.length;
      long l = 0L;
      for (byte b1 = 0; b1 < i; b1++) {
        Segment<K, V> segment = arrayOfSegment[b1];
        int j = segment.count;
        AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = segment.table;
        for (j = 0; j < atomicReferenceArray.length(); j++) {
          for (ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(j); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
            V v = segment.getLiveValue(referenceEntry, l1);
            if (v != null && this.valueEquivalence.equivalent(paramObject, v))
              return true; 
          } 
        } 
        l += segment.modCount;
      } 
      if (l == l2)
        break; 
      b++;
      l2 = l;
    } 
    return false;
  }
  
  @VisibleForTesting
  ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> paramReferenceEntry1, ReferenceEntry<K, V> paramReferenceEntry2) {
    return segmentFor(paramReferenceEntry1.getHash()).copyEntry(paramReferenceEntry1, paramReferenceEntry2);
  }
  
  Segment<K, V> createSegment(int paramInt, long paramLong, AbstractCache.StatsCounter paramStatsCounter) {
    return new Segment<K, V>(this, paramInt, paramLong, paramStatsCounter);
  }
  
  boolean customWeigher() {
    boolean bool;
    if (this.weigher != CacheBuilder.OneWeigher.INSTANCE) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @GwtIncompatible
  public Set<Map.Entry<K, V>> entrySet() {
    Set<Map.Entry<K, V>> set = this.entrySet;
    if (set == null) {
      set = new EntrySet(this);
      this.entrySet = set;
    } 
    return set;
  }
  
  boolean evictsBySize() {
    boolean bool;
    if (this.maxWeight >= 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  boolean expires() {
    return (expiresAfterWrite() || expiresAfterAccess());
  }
  
  boolean expiresAfterAccess() {
    boolean bool;
    if (this.expireAfterAccessNanos > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  boolean expiresAfterWrite() {
    boolean bool;
    if (this.expireAfterWriteNanos > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @Nullable
  public V get(@Nullable Object paramObject) {
    if (paramObject == null)
      return null; 
    int i = hash(paramObject);
    return segmentFor(i).get(paramObject, i);
  }
  
  V get(K paramK, CacheLoader<? super K, V> paramCacheLoader) throws ExecutionException {
    int i = hash(Preconditions.checkNotNull(paramK));
    return segmentFor(i).get(paramK, i, paramCacheLoader);
  }
  
  ImmutableMap<K, V> getAll(Iterable<? extends K> paramIterable) throws ExecutionException {
    LinkedHashMap<K, V> linkedHashMap = Maps.newLinkedHashMap();
    LinkedHashSet<K> linkedHashSet = Sets.newLinkedHashSet();
    null = paramIterable.iterator();
    byte b1 = 0;
    byte b2 = 0;
    while (null.hasNext()) {
      K k = null.next();
      V v = get(k);
      if (!linkedHashMap.containsKey(k)) {
        linkedHashMap.put(k, v);
        if (v == null) {
          b2++;
          linkedHashSet.add(k);
          continue;
        } 
        b1++;
      } 
    } 
    byte b3 = b2;
    try {
      boolean bool = linkedHashSet.isEmpty();
      byte b = b2;
      if (!bool) {
        b3 = b2;
        try {
          Map<K, V> map = loadAll(linkedHashSet, this.defaultLoader);
          b3 = b2;
          Iterator<K> iterator = linkedHashSet.iterator();
          while (true) {
            b = b2;
            b3 = b2;
            if (iterator.hasNext()) {
              b3 = b2;
              null = (Iterator<? extends K>)iterator.next();
              b3 = b2;
              V v = map.get(null);
              if (v != null) {
                b3 = b2;
                linkedHashMap.put((K)null, v);
                continue;
              } 
              b3 = b2;
              CacheLoader.InvalidCacheLoadException invalidCacheLoadException = new CacheLoader.InvalidCacheLoadException();
              b3 = b2;
              StringBuilder stringBuilder = new StringBuilder();
              b3 = b2;
              this();
              b3 = b2;
              stringBuilder.append("loadAll failed to return a value for ");
              b3 = b2;
              stringBuilder.append(null);
              b3 = b2;
              this(stringBuilder.toString());
              b3 = b2;
              throw invalidCacheLoadException;
            } 
            break;
          } 
        } catch (UnsupportedLoadingOperationException unsupportedLoadingOperationException) {
          b3 = b2;
          Iterator<K> iterator = linkedHashSet.iterator();
          while (true) {
            b = b2;
            b3 = b2;
            if (iterator.hasNext()) {
              b3 = b2;
              unsupportedLoadingOperationException = (CacheLoader.UnsupportedLoadingOperationException)iterator.next();
              b3 = --b2;
              linkedHashMap.put((K)unsupportedLoadingOperationException, get((K)unsupportedLoadingOperationException, this.defaultLoader));
              continue;
            } 
            break;
          } 
        } 
      } 
      b3 = b;
      return ImmutableMap.copyOf(linkedHashMap);
    } finally {
      this.globalStatsCounter.recordHits(b1);
      this.globalStatsCounter.recordMisses(b3);
    } 
  }
  
  ImmutableMap<K, V> getAllPresent(Iterable<?> paramIterable) {
    LinkedHashMap<Iterable<?>, V> linkedHashMap = Maps.newLinkedHashMap();
    Iterator<?> iterator = paramIterable.iterator();
    byte b1 = 0;
    byte b2 = 0;
    while (iterator.hasNext()) {
      paramIterable = (Iterable<?>)iterator.next();
      V v = get(paramIterable);
      if (v == null) {
        b2++;
        continue;
      } 
      linkedHashMap.put(paramIterable, v);
      b1++;
    } 
    this.globalStatsCounter.recordHits(b1);
    this.globalStatsCounter.recordMisses(b2);
    return ImmutableMap.copyOf(linkedHashMap);
  }
  
  ReferenceEntry<K, V> getEntry(@Nullable Object paramObject) {
    if (paramObject == null)
      return null; 
    int i = hash(paramObject);
    return segmentFor(i).getEntry(paramObject, i);
  }
  
  @Nullable
  public V getIfPresent(Object paramObject) {
    int i = hash(Preconditions.checkNotNull(paramObject));
    paramObject = segmentFor(i).get(paramObject, i);
    if (paramObject == null) {
      this.globalStatsCounter.recordMisses(1);
    } else {
      this.globalStatsCounter.recordHits(1);
    } 
    return (V)paramObject;
  }
  
  @Nullable
  V getLiveValue(ReferenceEntry<K, V> paramReferenceEntry, long paramLong) {
    if (paramReferenceEntry.getKey() == null)
      return null; 
    Object object = paramReferenceEntry.getValueReference().get();
    return (V)((object == null) ? null : (isExpired(paramReferenceEntry, paramLong) ? null : object));
  }
  
  @Nullable
  public V getOrDefault(@Nullable Object paramObject, @Nullable V paramV) {
    paramObject = get(paramObject);
    if (paramObject != null)
      paramV = (V)paramObject; 
    return paramV;
  }
  
  V getOrLoad(K paramK) throws ExecutionException {
    return get(paramK, this.defaultLoader);
  }
  
  int hash(@Nullable Object paramObject) {
    return rehash(this.keyEquivalence.hash(paramObject));
  }
  
  void invalidateAll(Iterable<?> paramIterable) {
    Iterator<?> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      remove(iterator.next()); 
  }
  
  public boolean isEmpty() {
    Segment<K, V>[] arrayOfSegment = this.segments;
    long l = 0L;
    byte b;
    for (b = 0; b < arrayOfSegment.length; b++) {
      if ((arrayOfSegment[b]).count != 0)
        return false; 
      l += (arrayOfSegment[b]).modCount;
    } 
    if (l != 0L) {
      for (b = 0; b < arrayOfSegment.length; b++) {
        if ((arrayOfSegment[b]).count != 0)
          return false; 
        l -= (arrayOfSegment[b]).modCount;
      } 
      if (l != 0L)
        return false; 
    } 
    return true;
  }
  
  boolean isExpired(ReferenceEntry<K, V> paramReferenceEntry, long paramLong) {
    Preconditions.checkNotNull(paramReferenceEntry);
    return (expiresAfterAccess() && paramLong - paramReferenceEntry.getAccessTime() >= this.expireAfterAccessNanos) ? true : ((expiresAfterWrite() && paramLong - paramReferenceEntry.getWriteTime() >= this.expireAfterWriteNanos));
  }
  
  @VisibleForTesting
  boolean isLive(ReferenceEntry<K, V> paramReferenceEntry, long paramLong) {
    boolean bool;
    if (segmentFor(paramReferenceEntry.getHash()).getLiveValue(paramReferenceEntry, paramLong) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Set<K> keySet() {
    Set<K> set = this.keySet;
    if (set == null) {
      set = new KeySet(this);
      this.keySet = set;
    } 
    return set;
  }
  
  @Nullable
  Map<K, V> loadAll(Set<? extends K> paramSet, CacheLoader<? super K, V> paramCacheLoader) throws ExecutionException {
    Preconditions.checkNotNull(paramCacheLoader);
    Preconditions.checkNotNull(paramSet);
    Stopwatch stopwatch = Stopwatch.createStarted();
    boolean bool1 = false;
    boolean bool2 = false;
    try {
      Map<? super K, V> map = paramCacheLoader.loadAll(paramSet);
      if (map != null) {
        stopwatch.stop();
        for (Map.Entry<? super K, V> entry : map.entrySet()) {
          Object object = entry.getKey();
          entry = (Map.Entry<? super K, V>)entry.getValue();
          if (object == null || entry == null) {
            bool2 = true;
            continue;
          } 
          put((K)object, (V)entry);
        } 
        if (!bool2)
          return (Map)map; 
        this.globalStatsCounter.recordLoadException(stopwatch.elapsed(TimeUnit.NANOSECONDS));
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramCacheLoader);
        stringBuilder1.append(" returned null keys or values from loadAll");
        throw new CacheLoader.InvalidCacheLoadException(stringBuilder1.toString());
      } 
      this.globalStatsCounter.recordLoadException(stopwatch.elapsed(TimeUnit.NANOSECONDS));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramCacheLoader);
      stringBuilder.append(" returned null map from loadAll");
      throw new CacheLoader.InvalidCacheLoadException(stringBuilder.toString());
    } catch (UnsupportedLoadingOperationException unsupportedLoadingOperationException) {
      try {
        throw unsupportedLoadingOperationException;
      } finally {
        unsupportedLoadingOperationException = null;
      } 
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      ExecutionException executionException = new ExecutionException();
      this(interruptedException);
      throw executionException;
    } catch (RuntimeException runtimeException) {
      UncheckedExecutionException uncheckedExecutionException = new UncheckedExecutionException();
      this(runtimeException);
      throw uncheckedExecutionException;
    } catch (Exception exception) {
      ExecutionException executionException = new ExecutionException();
      this(exception);
      throw executionException;
    } catch (Error error) {
      ExecutionError executionError = new ExecutionError();
      this(error);
      throw executionError;
    } finally {
      paramSet = null;
    } 
    if (!bool2)
      this.globalStatsCounter.recordLoadException(stopwatch.elapsed(TimeUnit.NANOSECONDS)); 
    throw paramSet;
  }
  
  long longSize() {
    Segment<K, V>[] arrayOfSegment = this.segments;
    long l = 0L;
    for (byte b = 0; b < arrayOfSegment.length; b++)
      l += Math.max(0, (arrayOfSegment[b]).count); 
    return l;
  }
  
  @VisibleForTesting
  ReferenceEntry<K, V> newEntry(K paramK, int paramInt, @Nullable ReferenceEntry<K, V> paramReferenceEntry) {
    Segment<K, V> segment = segmentFor(paramInt);
    segment.lock();
    try {
      return segment.newEntry(paramK, paramInt, paramReferenceEntry);
    } finally {
      segment.unlock();
    } 
  }
  
  final Segment<K, V>[] newSegmentArray(int paramInt) {
    return (Segment<K, V>[])new Segment[paramInt];
  }
  
  @VisibleForTesting
  ValueReference<K, V> newValueReference(ReferenceEntry<K, V> paramReferenceEntry, V paramV, int paramInt) {
    int i = paramReferenceEntry.getHash();
    return this.valueStrength.referenceValue(segmentFor(i), paramReferenceEntry, (V)Preconditions.checkNotNull(paramV), paramInt);
  }
  
  void processPendingNotifications() {
    while (true) {
      RemovalNotification<K, V> removalNotification = this.removalNotificationQueue.poll();
      if (removalNotification != null) {
        try {
          this.removalListener.onRemoval(removalNotification);
        } catch (Throwable throwable) {
          logger.log(Level.WARNING, "Exception thrown by removal listener", throwable);
        } 
        continue;
      } 
      break;
    } 
  }
  
  public V put(K paramK, V paramV) {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV);
    int i = hash(paramK);
    return segmentFor(i).put(paramK, i, paramV, false);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap) {
    for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet())
      put((K)entry.getKey(), (V)entry.getValue()); 
  }
  
  public V putIfAbsent(K paramK, V paramV) {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV);
    int i = hash(paramK);
    return segmentFor(i).put(paramK, i, paramV, true);
  }
  
  void reclaimKey(ReferenceEntry<K, V> paramReferenceEntry) {
    int i = paramReferenceEntry.getHash();
    segmentFor(i).reclaimKey(paramReferenceEntry, i);
  }
  
  void reclaimValue(ValueReference<K, V> paramValueReference) {
    ReferenceEntry<K, V> referenceEntry = paramValueReference.getEntry();
    int i = referenceEntry.getHash();
    segmentFor(i).reclaimValue(referenceEntry.getKey(), i, paramValueReference);
  }
  
  boolean recordsAccess() {
    return expiresAfterAccess();
  }
  
  boolean recordsTime() {
    return (recordsWrite() || recordsAccess());
  }
  
  boolean recordsWrite() {
    return (expiresAfterWrite() || refreshes());
  }
  
  void refresh(K paramK) {
    int i = hash(Preconditions.checkNotNull(paramK));
    segmentFor(i).refresh(paramK, i, this.defaultLoader, false);
  }
  
  boolean refreshes() {
    boolean bool;
    if (this.refreshNanos > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public V remove(@Nullable Object paramObject) {
    if (paramObject == null)
      return null; 
    int i = hash(paramObject);
    return segmentFor(i).remove(paramObject, i);
  }
  
  public boolean remove(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    if (paramObject1 == null || paramObject2 == null)
      return false; 
    int i = hash(paramObject1);
    return segmentFor(i).remove(paramObject1, i, paramObject2);
  }
  
  public V replace(K paramK, V paramV) {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV);
    int i = hash(paramK);
    return segmentFor(i).replace(paramK, i, paramV);
  }
  
  public boolean replace(K paramK, @Nullable V paramV1, V paramV2) {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV2);
    if (paramV1 == null)
      return false; 
    int i = hash(paramK);
    return segmentFor(i).replace(paramK, i, paramV1, paramV2);
  }
  
  Segment<K, V> segmentFor(int paramInt) {
    return this.segments[paramInt >>> this.segmentShift & this.segmentMask];
  }
  
  public int size() {
    return Ints.saturatedCast(longSize());
  }
  
  boolean usesAccessEntries() {
    return (usesAccessQueue() || recordsAccess());
  }
  
  boolean usesAccessQueue() {
    return (expiresAfterAccess() || evictsBySize());
  }
  
  boolean usesKeyReferences() {
    boolean bool;
    if (this.keyStrength != Strength.STRONG) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  boolean usesValueReferences() {
    boolean bool;
    if (this.valueStrength != Strength.STRONG) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  boolean usesWriteEntries() {
    return (usesWriteQueue() || recordsWrite());
  }
  
  boolean usesWriteQueue() {
    return expiresAfterWrite();
  }
  
  public Collection<V> values() {
    Collection<V> collection = this.values;
    if (collection == null) {
      collection = new Values(this);
      this.values = collection;
    } 
    return collection;
  }
  
  abstract class AbstractCacheSet<T> extends AbstractSet<T> {
    @Weak
    final ConcurrentMap<?, ?> map;
    
    AbstractCacheSet(ConcurrentMap<?, ?> param1ConcurrentMap) {
      this.map = param1ConcurrentMap;
    }
    
    public void clear() {
      this.map.clear();
    }
    
    public boolean isEmpty() {
      return this.map.isEmpty();
    }
    
    public int size() {
      return this.map.size();
    }
    
    public Object[] toArray() {
      return LocalCache.toArrayList(this).toArray();
    }
    
    public <E> E[] toArray(E[] param1ArrayOfE) {
      return (E[])LocalCache.toArrayList(this).toArray((Object[])param1ArrayOfE);
    }
  }
  
  static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
    public long getAccessTime() {
      throw new UnsupportedOperationException();
    }
    
    public int getHash() {
      throw new UnsupportedOperationException();
    }
    
    public K getKey() {
      throw new UnsupportedOperationException();
    }
    
    public LocalCache.ReferenceEntry<K, V> getNext() {
      throw new UnsupportedOperationException();
    }
    
    public LocalCache.ReferenceEntry<K, V> getNextInAccessQueue() {
      throw new UnsupportedOperationException();
    }
    
    public LocalCache.ReferenceEntry<K, V> getNextInWriteQueue() {
      throw new UnsupportedOperationException();
    }
    
    public LocalCache.ReferenceEntry<K, V> getPreviousInAccessQueue() {
      throw new UnsupportedOperationException();
    }
    
    public LocalCache.ReferenceEntry<K, V> getPreviousInWriteQueue() {
      throw new UnsupportedOperationException();
    }
    
    public LocalCache.ValueReference<K, V> getValueReference() {
      throw new UnsupportedOperationException();
    }
    
    public long getWriteTime() {
      throw new UnsupportedOperationException();
    }
    
    public void setAccessTime(long param1Long) {
      throw new UnsupportedOperationException();
    }
    
    public void setNextInAccessQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      throw new UnsupportedOperationException();
    }
    
    public void setNextInWriteQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      throw new UnsupportedOperationException();
    }
    
    public void setPreviousInAccessQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      throw new UnsupportedOperationException();
    }
    
    public void setPreviousInWriteQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      throw new UnsupportedOperationException();
    }
    
    public void setValueReference(LocalCache.ValueReference<K, V> param1ValueReference) {
      throw new UnsupportedOperationException();
    }
    
    public void setWriteTime(long param1Long) {
      throw new UnsupportedOperationException();
    }
  }
  
  static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
    final LocalCache.ReferenceEntry<K, V> head = new LocalCache.AbstractReferenceEntry<K, V>() {
        LocalCache.ReferenceEntry<K, V> nextAccess = this;
        
        LocalCache.ReferenceEntry<K, V> previousAccess = this;
        
        public long getAccessTime() {
          return Long.MAX_VALUE;
        }
        
        public LocalCache.ReferenceEntry<K, V> getNextInAccessQueue() {
          return this.nextAccess;
        }
        
        public LocalCache.ReferenceEntry<K, V> getPreviousInAccessQueue() {
          return this.previousAccess;
        }
        
        public void setAccessTime(long param2Long) {}
        
        public void setNextInAccessQueue(LocalCache.ReferenceEntry<K, V> param2ReferenceEntry) {
          this.nextAccess = param2ReferenceEntry;
        }
        
        public void setPreviousInAccessQueue(LocalCache.ReferenceEntry<K, V> param2ReferenceEntry) {
          this.previousAccess = param2ReferenceEntry;
        }
      };
    
    public void clear() {
      LocalCache.ReferenceEntry<K, V> referenceEntry = this.head.getNextInAccessQueue();
      while (true) {
        LocalCache.ReferenceEntry<K, V> referenceEntry1 = this.head;
        if (referenceEntry != referenceEntry1) {
          referenceEntry1 = referenceEntry.getNextInAccessQueue();
          LocalCache.nullifyAccessOrder(referenceEntry);
          referenceEntry = referenceEntry1;
          continue;
        } 
        referenceEntry1.setNextInAccessQueue(referenceEntry1);
        referenceEntry = this.head;
        referenceEntry.setPreviousInAccessQueue(referenceEntry);
        return;
      } 
    }
    
    public boolean contains(Object param1Object) {
      boolean bool;
      if (((LocalCache.ReferenceEntry)param1Object).getNextInAccessQueue() != LocalCache.NullEntry.INSTANCE) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean isEmpty() {
      boolean bool;
      if (this.head.getNextInAccessQueue() == this.head) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public Iterator<LocalCache.ReferenceEntry<K, V>> iterator() {
      return (Iterator<LocalCache.ReferenceEntry<K, V>>)new AbstractSequentialIterator<LocalCache.ReferenceEntry<K, V>>(peek()) {
          protected LocalCache.ReferenceEntry<K, V> computeNext(LocalCache.ReferenceEntry<K, V> param2ReferenceEntry) {
            LocalCache.ReferenceEntry<K, V> referenceEntry = param2ReferenceEntry.getNextInAccessQueue();
            param2ReferenceEntry = referenceEntry;
            if (referenceEntry == LocalCache.AccessQueue.this.head)
              param2ReferenceEntry = null; 
            return param2ReferenceEntry;
          }
        };
    }
    
    public boolean offer(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      LocalCache.connectAccessOrder(param1ReferenceEntry.getPreviousInAccessQueue(), param1ReferenceEntry.getNextInAccessQueue());
      LocalCache.connectAccessOrder(this.head.getPreviousInAccessQueue(), param1ReferenceEntry);
      LocalCache.connectAccessOrder(param1ReferenceEntry, this.head);
      return true;
    }
    
    public LocalCache.ReferenceEntry<K, V> peek() {
      LocalCache.ReferenceEntry<K, V> referenceEntry1 = this.head.getNextInAccessQueue();
      LocalCache.ReferenceEntry<K, V> referenceEntry2 = referenceEntry1;
      if (referenceEntry1 == this.head)
        referenceEntry2 = null; 
      return referenceEntry2;
    }
    
    public LocalCache.ReferenceEntry<K, V> poll() {
      LocalCache.ReferenceEntry<K, V> referenceEntry = this.head.getNextInAccessQueue();
      if (referenceEntry == this.head)
        return null; 
      remove(referenceEntry);
      return referenceEntry;
    }
    
    public boolean remove(Object param1Object) {
      boolean bool;
      LocalCache.ReferenceEntry<?, ?> referenceEntry1 = (LocalCache.ReferenceEntry)param1Object;
      LocalCache.ReferenceEntry<?, ?> referenceEntry2 = referenceEntry1.getPreviousInAccessQueue();
      param1Object = referenceEntry1.getNextInAccessQueue();
      LocalCache.connectAccessOrder(referenceEntry2, (LocalCache.ReferenceEntry<?, ?>)param1Object);
      LocalCache.nullifyAccessOrder(referenceEntry1);
      if (param1Object != LocalCache.NullEntry.INSTANCE) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int size() {
      LocalCache.ReferenceEntry<K, V> referenceEntry = this.head.getNextInAccessQueue();
      byte b = 0;
      while (referenceEntry != this.head) {
        b++;
        referenceEntry = referenceEntry.getNextInAccessQueue();
      } 
      return b;
    }
  }
  
  class null extends AbstractReferenceEntry<K, V> {
    LocalCache.ReferenceEntry<K, V> nextAccess = this;
    
    LocalCache.ReferenceEntry<K, V> previousAccess = this;
    
    public long getAccessTime() {
      return Long.MAX_VALUE;
    }
    
    public LocalCache.ReferenceEntry<K, V> getNextInAccessQueue() {
      return this.nextAccess;
    }
    
    public LocalCache.ReferenceEntry<K, V> getPreviousInAccessQueue() {
      return this.previousAccess;
    }
    
    public void setAccessTime(long param1Long) {}
    
    public void setNextInAccessQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.nextAccess = param1ReferenceEntry;
    }
    
    public void setPreviousInAccessQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.previousAccess = param1ReferenceEntry;
    }
  }
  
  class null extends AbstractSequentialIterator<ReferenceEntry<K, V>> {
    null(LocalCache.ReferenceEntry param1ReferenceEntry) {
      super(param1ReferenceEntry);
    }
    
    protected LocalCache.ReferenceEntry<K, V> computeNext(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      LocalCache.ReferenceEntry<K, V> referenceEntry = param1ReferenceEntry.getNextInAccessQueue();
      param1ReferenceEntry = referenceEntry;
      if (referenceEntry == this.this$0.head)
        param1ReferenceEntry = null; 
      return param1ReferenceEntry;
    }
  }
  
  enum EntryFactory {
    STRONG {
      <K, V> LocalCache.ReferenceEntry<K, V> newEntry(LocalCache.Segment<K, V> param2Segment, K param2K, int param2Int, @Nullable LocalCache.ReferenceEntry<K, V> param2ReferenceEntry) {
        return new LocalCache.StrongEntry<K, V>(param2K, param2Int, param2ReferenceEntry);
      }
    },
    STRONG_ACCESS {
      <K, V> LocalCache.ReferenceEntry<K, V> copyEntry(LocalCache.Segment<K, V> param2Segment, LocalCache.ReferenceEntry<K, V> param2ReferenceEntry1, LocalCache.ReferenceEntry<K, V> param2ReferenceEntry2) {
        LocalCache.ReferenceEntry<K, V> referenceEntry = super.copyEntry(param2Segment, param2ReferenceEntry1, param2ReferenceEntry2);
        copyAccessEntry(param2ReferenceEntry1, referenceEntry);
        return referenceEntry;
      }
      
      <K, V> LocalCache.ReferenceEntry<K, V> newEntry(LocalCache.Segment<K, V> param2Segment, K param2K, int param2Int, @Nullable LocalCache.ReferenceEntry<K, V> param2ReferenceEntry) {
        return new LocalCache.StrongAccessEntry<K, V>(param2K, param2Int, param2ReferenceEntry);
      }
    },
    STRONG_ACCESS_WRITE,
    STRONG_WRITE {
      <K, V> LocalCache.ReferenceEntry<K, V> copyEntry(LocalCache.Segment<K, V> param2Segment, LocalCache.ReferenceEntry<K, V> param2ReferenceEntry1, LocalCache.ReferenceEntry<K, V> param2ReferenceEntry2) {
        LocalCache.ReferenceEntry<K, V> referenceEntry = super.copyEntry(param2Segment, param2ReferenceEntry1, param2ReferenceEntry2);
        copyWriteEntry(param2ReferenceEntry1, referenceEntry);
        return referenceEntry;
      }
      
      <K, V> LocalCache.ReferenceEntry<K, V> newEntry(LocalCache.Segment<K, V> param2Segment, K param2K, int param2Int, @Nullable LocalCache.ReferenceEntry<K, V> param2ReferenceEntry) {
        return new LocalCache.StrongWriteEntry<K, V>(param2K, param2Int, param2ReferenceEntry);
      }
    },
    WEAK,
    WEAK_ACCESS,
    WEAK_ACCESS_WRITE,
    WEAK_WRITE;
    
    static final int ACCESS_MASK = 1;
    
    static final int WEAK_MASK = 4;
    
    static final int WRITE_MASK = 2;
    
    static final EntryFactory[] factories;
    
    static {
      WEAK_ACCESS_WRITE = new null("WEAK_ACCESS_WRITE", 7);
      EntryFactory entryFactory1 = STRONG;
      EntryFactory entryFactory2 = STRONG_ACCESS;
      EntryFactory entryFactory3 = STRONG_WRITE;
      EntryFactory entryFactory4 = STRONG_ACCESS_WRITE;
      EntryFactory entryFactory5 = WEAK;
      EntryFactory entryFactory6 = WEAK_ACCESS;
      EntryFactory entryFactory7 = WEAK_WRITE;
      EntryFactory entryFactory8 = WEAK_ACCESS_WRITE;
      $VALUES = new EntryFactory[] { entryFactory1, entryFactory2, entryFactory3, entryFactory4, entryFactory5, entryFactory6, entryFactory7, entryFactory8 };
      factories = new EntryFactory[] { entryFactory1, entryFactory2, entryFactory3, entryFactory4, entryFactory5, entryFactory6, entryFactory7, entryFactory8 };
    }
    
    static EntryFactory getFactory(LocalCache.Strength param1Strength, boolean param1Boolean1, boolean param1Boolean2) {
      boolean bool;
      LocalCache.Strength strength = LocalCache.Strength.WEAK;
      byte b = 0;
      if (param1Strength == strength) {
        bool = true;
      } else {
        bool = false;
      } 
      if (param1Boolean2)
        b = 2; 
      return factories[bool | param1Boolean1 | b];
    }
    
    <K, V> void copyAccessEntry(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry1, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry2) {
      param1ReferenceEntry2.setAccessTime(param1ReferenceEntry1.getAccessTime());
      LocalCache.connectAccessOrder(param1ReferenceEntry1.getPreviousInAccessQueue(), param1ReferenceEntry2);
      LocalCache.connectAccessOrder(param1ReferenceEntry2, param1ReferenceEntry1.getNextInAccessQueue());
      LocalCache.nullifyAccessOrder(param1ReferenceEntry1);
    }
    
    <K, V> LocalCache.ReferenceEntry<K, V> copyEntry(LocalCache.Segment<K, V> param1Segment, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry1, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry2) {
      return newEntry(param1Segment, param1ReferenceEntry1.getKey(), param1ReferenceEntry1.getHash(), param1ReferenceEntry2);
    }
    
    <K, V> void copyWriteEntry(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry1, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry2) {
      param1ReferenceEntry2.setWriteTime(param1ReferenceEntry1.getWriteTime());
      LocalCache.connectWriteOrder(param1ReferenceEntry1.getPreviousInWriteQueue(), param1ReferenceEntry2);
      LocalCache.connectWriteOrder(param1ReferenceEntry2, param1ReferenceEntry1.getNextInWriteQueue());
      LocalCache.nullifyWriteOrder(param1ReferenceEntry1);
    }
    
    abstract <K, V> LocalCache.ReferenceEntry<K, V> newEntry(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry);
  }
  
  enum null {
    <K, V> LocalCache.ReferenceEntry<K, V> newEntry(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      return new LocalCache.StrongEntry<K, V>(param1K, param1Int, param1ReferenceEntry);
    }
  }
  
  enum null {
    <K, V> LocalCache.ReferenceEntry<K, V> copyEntry(LocalCache.Segment<K, V> param1Segment, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry1, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry2) {
      LocalCache.ReferenceEntry<K, V> referenceEntry = super.copyEntry(param1Segment, param1ReferenceEntry1, param1ReferenceEntry2);
      copyAccessEntry(param1ReferenceEntry1, referenceEntry);
      return referenceEntry;
    }
    
    <K, V> LocalCache.ReferenceEntry<K, V> newEntry(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      return new LocalCache.StrongAccessEntry<K, V>(param1K, param1Int, param1ReferenceEntry);
    }
  }
  
  enum null {
    <K, V> LocalCache.ReferenceEntry<K, V> copyEntry(LocalCache.Segment<K, V> param1Segment, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry1, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry2) {
      LocalCache.ReferenceEntry<K, V> referenceEntry = super.copyEntry(param1Segment, param1ReferenceEntry1, param1ReferenceEntry2);
      copyWriteEntry(param1ReferenceEntry1, referenceEntry);
      return referenceEntry;
    }
    
    <K, V> LocalCache.ReferenceEntry<K, V> newEntry(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      return new LocalCache.StrongWriteEntry<K, V>(param1K, param1Int, param1ReferenceEntry);
    }
  }
  
  enum null {
    <K, V> LocalCache.ReferenceEntry<K, V> copyEntry(LocalCache.Segment<K, V> param1Segment, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry1, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry2) {
      LocalCache.ReferenceEntry<K, V> referenceEntry = super.copyEntry(param1Segment, param1ReferenceEntry1, param1ReferenceEntry2);
      copyAccessEntry(param1ReferenceEntry1, referenceEntry);
      copyWriteEntry(param1ReferenceEntry1, referenceEntry);
      return referenceEntry;
    }
    
    <K, V> LocalCache.ReferenceEntry<K, V> newEntry(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      return new LocalCache.StrongAccessWriteEntry<K, V>(param1K, param1Int, param1ReferenceEntry);
    }
  }
  
  enum null {
    <K, V> LocalCache.ReferenceEntry<K, V> newEntry(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      return new LocalCache.WeakEntry<K, V>(param1Segment.keyReferenceQueue, param1K, param1Int, param1ReferenceEntry);
    }
  }
  
  enum null {
    <K, V> LocalCache.ReferenceEntry<K, V> copyEntry(LocalCache.Segment<K, V> param1Segment, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry1, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry2) {
      LocalCache.ReferenceEntry<K, V> referenceEntry = super.copyEntry(param1Segment, param1ReferenceEntry1, param1ReferenceEntry2);
      copyAccessEntry(param1ReferenceEntry1, referenceEntry);
      return referenceEntry;
    }
    
    <K, V> LocalCache.ReferenceEntry<K, V> newEntry(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      return new LocalCache.WeakAccessEntry<K, V>(param1Segment.keyReferenceQueue, param1K, param1Int, param1ReferenceEntry);
    }
  }
  
  enum null {
    <K, V> LocalCache.ReferenceEntry<K, V> copyEntry(LocalCache.Segment<K, V> param1Segment, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry1, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry2) {
      LocalCache.ReferenceEntry<K, V> referenceEntry = super.copyEntry(param1Segment, param1ReferenceEntry1, param1ReferenceEntry2);
      copyWriteEntry(param1ReferenceEntry1, referenceEntry);
      return referenceEntry;
    }
    
    <K, V> LocalCache.ReferenceEntry<K, V> newEntry(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      return new LocalCache.WeakWriteEntry<K, V>(param1Segment.keyReferenceQueue, param1K, param1Int, param1ReferenceEntry);
    }
  }
  
  enum null {
    <K, V> LocalCache.ReferenceEntry<K, V> copyEntry(LocalCache.Segment<K, V> param1Segment, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry1, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry2) {
      LocalCache.ReferenceEntry<K, V> referenceEntry = super.copyEntry(param1Segment, param1ReferenceEntry1, param1ReferenceEntry2);
      copyAccessEntry(param1ReferenceEntry1, referenceEntry);
      copyWriteEntry(param1ReferenceEntry1, referenceEntry);
      return referenceEntry;
    }
    
    <K, V> LocalCache.ReferenceEntry<K, V> newEntry(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      return new LocalCache.WeakAccessWriteEntry<K, V>(param1Segment.keyReferenceQueue, param1K, param1Int, param1ReferenceEntry);
    }
  }
  
  final class EntryIterator extends HashIterator<Map.Entry<K, V>> {
    public Map.Entry<K, V> next() {
      return nextEntry();
    }
  }
  
  final class EntrySet extends AbstractCacheSet<Map.Entry<K, V>> {
    EntrySet(ConcurrentMap<?, ?> param1ConcurrentMap) {
      super(param1ConcurrentMap);
    }
    
    public boolean contains(Object param1Object) {
      boolean bool = param1Object instanceof Map.Entry;
      boolean bool1 = false;
      if (!bool)
        return false; 
      param1Object = param1Object;
      Object object = param1Object.getKey();
      if (object == null)
        return false; 
      object = LocalCache.this.get(object);
      bool = bool1;
      if (object != null) {
        bool = bool1;
        if (LocalCache.this.valueEquivalence.equivalent(param1Object.getValue(), object))
          bool = true; 
      } 
      return bool;
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return new LocalCache.EntryIterator();
    }
    
    public boolean remove(Object param1Object) {
      boolean bool = param1Object instanceof Map.Entry;
      boolean bool1 = false;
      if (!bool)
        return false; 
      Map.Entry entry = (Map.Entry)param1Object;
      param1Object = entry.getKey();
      bool = bool1;
      if (param1Object != null) {
        bool = bool1;
        if (LocalCache.this.remove(param1Object, entry.getValue()))
          bool = true; 
      } 
      return bool;
    }
  }
  
  abstract class HashIterator<T> implements Iterator<T> {
    LocalCache.Segment<K, V> currentSegment;
    
    AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> currentTable;
    
    LocalCache<K, V>.WriteThroughEntry lastReturned;
    
    LocalCache.ReferenceEntry<K, V> nextEntry;
    
    LocalCache<K, V>.WriteThroughEntry nextExternal;
    
    int nextSegmentIndex = LocalCache.this.segments.length - 1;
    
    int nextTableIndex = -1;
    
    HashIterator() {
      advance();
    }
    
    final void advance() {
      this.nextExternal = null;
      if (nextInChain())
        return; 
      if (nextInTable())
        return; 
      while (this.nextSegmentIndex >= 0) {
        LocalCache.Segment[] arrayOfSegment = LocalCache.this.segments;
        int i = this.nextSegmentIndex;
        this.nextSegmentIndex = i - 1;
        this.currentSegment = arrayOfSegment[i];
        if (this.currentSegment.count != 0) {
          this.currentTable = this.currentSegment.table;
          this.nextTableIndex = this.currentTable.length() - 1;
          if (nextInTable())
            return; 
        } 
      } 
    }
    
    boolean advanceTo(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      try {
        long l = LocalCache.this.ticker.read();
        K k = param1ReferenceEntry.getKey();
        V v = (V)LocalCache.this.getLiveValue((LocalCache.ReferenceEntry)param1ReferenceEntry, l);
        if (v != null) {
          LocalCache.WriteThroughEntry writeThroughEntry = new LocalCache.WriteThroughEntry();
          this(k, v);
          this.nextExternal = writeThroughEntry;
          return true;
        } 
        return false;
      } finally {
        this.currentSegment.postReadCleanup();
      } 
    }
    
    public boolean hasNext() {
      boolean bool;
      if (this.nextExternal != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public abstract T next();
    
    LocalCache<K, V>.WriteThroughEntry nextEntry() {
      LocalCache<K, V>.WriteThroughEntry writeThroughEntry = this.nextExternal;
      if (writeThroughEntry != null) {
        this.lastReturned = writeThroughEntry;
        advance();
        return this.lastReturned;
      } 
      throw new NoSuchElementException();
    }
    
    boolean nextInChain() {
      LocalCache.ReferenceEntry<K, V> referenceEntry = this.nextEntry;
      if (referenceEntry != null)
        while (true) {
          this.nextEntry = referenceEntry.getNext();
          referenceEntry = this.nextEntry;
          if (referenceEntry != null) {
            if (advanceTo(referenceEntry))
              return true; 
            referenceEntry = this.nextEntry;
            continue;
          } 
          break;
        }  
      return false;
    }
    
    boolean nextInTable() {
      while (true) {
        int i = this.nextTableIndex;
        if (i >= 0) {
          AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> atomicReferenceArray = this.currentTable;
          this.nextTableIndex = i - 1;
          LocalCache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i);
          this.nextEntry = referenceEntry;
          if (referenceEntry != null) {
            if (!advanceTo(this.nextEntry)) {
              if (nextInChain())
                continue; 
              continue;
            } 
            return true;
          } 
          continue;
        } 
        return false;
      } 
    }
    
    public void remove() {
      boolean bool;
      if (this.lastReturned != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool);
      LocalCache.this.remove(this.lastReturned.getKey());
      this.lastReturned = null;
    }
  }
  
  final class KeyIterator extends HashIterator<K> {
    public K next() {
      return nextEntry().getKey();
    }
  }
  
  final class KeySet extends AbstractCacheSet<K> {
    KeySet(ConcurrentMap<?, ?> param1ConcurrentMap) {
      super(param1ConcurrentMap);
    }
    
    public boolean contains(Object param1Object) {
      return this.map.containsKey(param1Object);
    }
    
    public Iterator<K> iterator() {
      return new LocalCache.KeyIterator();
    }
    
    public boolean remove(Object param1Object) {
      boolean bool;
      if (this.map.remove(param1Object) != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
  }
  
  static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements LoadingCache<K, V>, Serializable {
    private static final long serialVersionUID = 1L;
    
    transient LoadingCache<K, V> autoDelegate;
    
    LoadingSerializationProxy(LocalCache<K, V> param1LocalCache) {
      super(param1LocalCache);
    }
    
    private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
      param1ObjectInputStream.defaultReadObject();
      this.autoDelegate = recreateCacheBuilder().build(this.loader);
    }
    
    private Object readResolve() {
      return this.autoDelegate;
    }
    
    public final V apply(K param1K) {
      return this.autoDelegate.apply(param1K);
    }
    
    public V get(K param1K) throws ExecutionException {
      return this.autoDelegate.get(param1K);
    }
    
    public ImmutableMap<K, V> getAll(Iterable<? extends K> param1Iterable) throws ExecutionException {
      return this.autoDelegate.getAll(param1Iterable);
    }
    
    public V getUnchecked(K param1K) {
      return this.autoDelegate.getUnchecked(param1K);
    }
    
    public void refresh(K param1K) {
      this.autoDelegate.refresh(param1K);
    }
  }
  
  static class LoadingValueReference<K, V> implements ValueReference<K, V> {
    final SettableFuture<V> futureValue = SettableFuture.create();
    
    volatile LocalCache.ValueReference<K, V> oldValue;
    
    final Stopwatch stopwatch = Stopwatch.createUnstarted();
    
    public LoadingValueReference() {
      this(LocalCache.unset());
    }
    
    public LoadingValueReference(LocalCache.ValueReference<K, V> param1ValueReference) {
      this.oldValue = param1ValueReference;
    }
    
    private ListenableFuture<V> fullyFailedFuture(Throwable param1Throwable) {
      return Futures.immediateFailedFuture(param1Throwable);
    }
    
    public LocalCache.ValueReference<K, V> copyFor(ReferenceQueue<V> param1ReferenceQueue, @Nullable V param1V, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      return this;
    }
    
    public long elapsedNanos() {
      return this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
    }
    
    public V get() {
      return this.oldValue.get();
    }
    
    public LocalCache.ReferenceEntry<K, V> getEntry() {
      return null;
    }
    
    public LocalCache.ValueReference<K, V> getOldValue() {
      return this.oldValue;
    }
    
    public int getWeight() {
      return this.oldValue.getWeight();
    }
    
    public boolean isActive() {
      return this.oldValue.isActive();
    }
    
    public boolean isLoading() {
      return true;
    }
    
    public ListenableFuture<V> loadFuture(K param1K, CacheLoader<? super K, V> param1CacheLoader) {
      try {
        this.stopwatch.start();
        V v = this.oldValue.get();
        if (v == null) {
          SettableFuture<V> settableFuture;
          param1K = (K)param1CacheLoader.load(param1K);
          if (set((V)param1K)) {
            settableFuture = this.futureValue;
          } else {
            null = Futures.immediateFuture(settableFuture);
          } 
          return null;
        } 
        null = param1CacheLoader.reload((K)null, v);
        if (null == null)
          return Futures.immediateFuture(null); 
        Function<V, V> function = new Function<V, V>() {
            public V apply(V param2V) {
              LocalCache.LoadingValueReference.this.set(param2V);
              return param2V;
            }
          };
        super(this);
        return Futures.transform(null, function);
      } catch (Throwable throwable) {
        ListenableFuture<V> listenableFuture;
        if (setException(throwable)) {
          SettableFuture<V> settableFuture = this.futureValue;
        } else {
          listenableFuture = fullyFailedFuture(throwable);
        } 
        if (throwable instanceof InterruptedException)
          Thread.currentThread().interrupt(); 
        return listenableFuture;
      } 
    }
    
    public void notifyNewValue(@Nullable V param1V) {
      if (param1V != null) {
        set(param1V);
      } else {
        this.oldValue = LocalCache.unset();
      } 
    }
    
    public boolean set(@Nullable V param1V) {
      return this.futureValue.set(param1V);
    }
    
    public boolean setException(Throwable param1Throwable) {
      return this.futureValue.setException(param1Throwable);
    }
    
    public V waitForValue() throws ExecutionException {
      return (V)Uninterruptibles.getUninterruptibly((Future)this.futureValue);
    }
  }
  
  class null implements Function<V, V> {
    public V apply(V param1V) {
      this.this$0.set(param1V);
      return param1V;
    }
  }
  
  static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
    private static final long serialVersionUID = 1L;
    
    LocalLoadingCache(CacheBuilder<? super K, ? super V> param1CacheBuilder, CacheLoader<? super K, V> param1CacheLoader) {
      super(new LocalCache<K, V>(param1CacheBuilder, (CacheLoader<? super K, V>)Preconditions.checkNotNull(param1CacheLoader)));
    }
    
    public final V apply(K param1K) {
      return getUnchecked(param1K);
    }
    
    public V get(K param1K) throws ExecutionException {
      return this.localCache.getOrLoad(param1K);
    }
    
    public ImmutableMap<K, V> getAll(Iterable<? extends K> param1Iterable) throws ExecutionException {
      return this.localCache.getAll(param1Iterable);
    }
    
    public V getUnchecked(K param1K) {
      try {
        return get(param1K);
      } catch (ExecutionException executionException) {
        throw new UncheckedExecutionException(executionException.getCause());
      } 
    }
    
    public void refresh(K param1K) {
      this.localCache.refresh(param1K);
    }
    
    Object writeReplace() {
      return new LocalCache.LoadingSerializationProxy<K, V>(this.localCache);
    }
  }
  
  static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
    private static final long serialVersionUID = 1L;
    
    final LocalCache<K, V> localCache;
    
    LocalManualCache(CacheBuilder<? super K, ? super V> param1CacheBuilder) {
      this(new LocalCache<K, V>(param1CacheBuilder, null));
    }
    
    private LocalManualCache(LocalCache<K, V> param1LocalCache) {
      this.localCache = param1LocalCache;
    }
    
    public ConcurrentMap<K, V> asMap() {
      return this.localCache;
    }
    
    public void cleanUp() {
      this.localCache.cleanUp();
    }
    
    public V get(K param1K, final Callable<? extends V> valueLoader) throws ExecutionException {
      Preconditions.checkNotNull(valueLoader);
      return this.localCache.get(param1K, (CacheLoader)new CacheLoader<Object, V>() {
            public V load(Object param2Object) throws Exception {
              return valueLoader.call();
            }
          });
    }
    
    public ImmutableMap<K, V> getAllPresent(Iterable<?> param1Iterable) {
      return this.localCache.getAllPresent(param1Iterable);
    }
    
    @Nullable
    public V getIfPresent(Object param1Object) {
      return this.localCache.getIfPresent(param1Object);
    }
    
    public void invalidate(Object param1Object) {
      Preconditions.checkNotNull(param1Object);
      this.localCache.remove(param1Object);
    }
    
    public void invalidateAll() {
      this.localCache.clear();
    }
    
    public void invalidateAll(Iterable<?> param1Iterable) {
      this.localCache.invalidateAll(param1Iterable);
    }
    
    public void put(K param1K, V param1V) {
      this.localCache.put(param1K, param1V);
    }
    
    public void putAll(Map<? extends K, ? extends V> param1Map) {
      this.localCache.putAll(param1Map);
    }
    
    public long size() {
      return this.localCache.longSize();
    }
    
    public CacheStats stats() {
      AbstractCache.SimpleStatsCounter simpleStatsCounter = new AbstractCache.SimpleStatsCounter();
      simpleStatsCounter.incrementBy(this.localCache.globalStatsCounter);
      LocalCache.Segment<K, V>[] arrayOfSegment = this.localCache.segments;
      int i = arrayOfSegment.length;
      for (byte b = 0; b < i; b++)
        simpleStatsCounter.incrementBy((arrayOfSegment[b]).statsCounter); 
      return simpleStatsCounter.snapshot();
    }
    
    Object writeReplace() {
      return new LocalCache.ManualSerializationProxy<K, V>(this.localCache);
    }
  }
  
  class null extends CacheLoader<Object, V> {
    public V load(Object param1Object) throws Exception {
      return valueLoader.call();
    }
  }
  
  static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    final int concurrencyLevel;
    
    transient Cache<K, V> delegate;
    
    final long expireAfterAccessNanos;
    
    final long expireAfterWriteNanos;
    
    final Equivalence<Object> keyEquivalence;
    
    final LocalCache.Strength keyStrength;
    
    final CacheLoader<? super K, V> loader;
    
    final long maxWeight;
    
    final RemovalListener<? super K, ? super V> removalListener;
    
    final Ticker ticker;
    
    final Equivalence<Object> valueEquivalence;
    
    final LocalCache.Strength valueStrength;
    
    final Weigher<K, V> weigher;
    
    private ManualSerializationProxy(LocalCache.Strength param1Strength1, LocalCache.Strength param1Strength2, Equivalence<Object> param1Equivalence1, Equivalence<Object> param1Equivalence2, long param1Long1, long param1Long2, long param1Long3, Weigher<K, V> param1Weigher, int param1Int, RemovalListener<? super K, ? super V> param1RemovalListener, Ticker param1Ticker, CacheLoader<? super K, V> param1CacheLoader) {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial <init> : ()V
      //   4: aload_0
      //   5: aload_1
      //   6: putfield keyStrength : Lcom/google/common/cache/LocalCache$Strength;
      //   9: aload_0
      //   10: aload_2
      //   11: putfield valueStrength : Lcom/google/common/cache/LocalCache$Strength;
      //   14: aload_0
      //   15: aload_3
      //   16: putfield keyEquivalence : Lcom/google/common/base/Equivalence;
      //   19: aload_0
      //   20: aload #4
      //   22: putfield valueEquivalence : Lcom/google/common/base/Equivalence;
      //   25: aload_0
      //   26: lload #5
      //   28: putfield expireAfterWriteNanos : J
      //   31: aload_0
      //   32: lload #7
      //   34: putfield expireAfterAccessNanos : J
      //   37: aload_0
      //   38: lload #9
      //   40: putfield maxWeight : J
      //   43: aload_0
      //   44: aload #11
      //   46: putfield weigher : Lcom/google/common/cache/Weigher;
      //   49: aload_0
      //   50: iload #12
      //   52: putfield concurrencyLevel : I
      //   55: aload_0
      //   56: aload #13
      //   58: putfield removalListener : Lcom/google/common/cache/RemovalListener;
      //   61: aload #14
      //   63: invokestatic systemTicker : ()Lcom/google/common/base/Ticker;
      //   66: if_acmpeq -> 80
      //   69: aload #14
      //   71: astore_1
      //   72: aload #14
      //   74: getstatic com/google/common/cache/CacheBuilder.NULL_TICKER : Lcom/google/common/base/Ticker;
      //   77: if_acmpne -> 82
      //   80: aconst_null
      //   81: astore_1
      //   82: aload_0
      //   83: aload_1
      //   84: putfield ticker : Lcom/google/common/base/Ticker;
      //   87: aload_0
      //   88: aload #15
      //   90: putfield loader : Lcom/google/common/cache/CacheLoader;
      //   93: return
    }
    
    ManualSerializationProxy(LocalCache<K, V> param1LocalCache) {
      this(param1LocalCache.keyStrength, param1LocalCache.valueStrength, param1LocalCache.keyEquivalence, param1LocalCache.valueEquivalence, param1LocalCache.expireAfterWriteNanos, param1LocalCache.expireAfterAccessNanos, param1LocalCache.maxWeight, param1LocalCache.weigher, param1LocalCache.concurrencyLevel, param1LocalCache.removalListener, param1LocalCache.ticker, param1LocalCache.defaultLoader);
    }
    
    private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
      param1ObjectInputStream.defaultReadObject();
      this.delegate = recreateCacheBuilder().build();
    }
    
    private Object readResolve() {
      return this.delegate;
    }
    
    protected Cache<K, V> delegate() {
      return this.delegate;
    }
    
    CacheBuilder<K, V> recreateCacheBuilder() {
      CacheBuilder<K, V> cacheBuilder = CacheBuilder.newBuilder().setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).valueEquivalence(this.valueEquivalence).concurrencyLevel(this.concurrencyLevel).removalListener(this.removalListener);
      cacheBuilder.strictParsing = false;
      long l = this.expireAfterWriteNanos;
      if (l > 0L)
        cacheBuilder.expireAfterWrite(l, TimeUnit.NANOSECONDS); 
      l = this.expireAfterAccessNanos;
      if (l > 0L)
        cacheBuilder.expireAfterAccess(l, TimeUnit.NANOSECONDS); 
      if (this.weigher != CacheBuilder.OneWeigher.INSTANCE) {
        cacheBuilder.weigher(this.weigher);
        l = this.maxWeight;
        if (l != -1L)
          cacheBuilder.maximumWeight(l); 
      } else {
        l = this.maxWeight;
        if (l != -1L)
          cacheBuilder.maximumSize(l); 
      } 
      Ticker ticker = this.ticker;
      if (ticker != null)
        cacheBuilder.ticker(ticker); 
      return cacheBuilder;
    }
  }
  
  private enum NullEntry implements ReferenceEntry<Object, Object> {
    INSTANCE;
    
    static {
    
    }
    
    public long getAccessTime() {
      return 0L;
    }
    
    public int getHash() {
      return 0;
    }
    
    public Object getKey() {
      return null;
    }
    
    public LocalCache.ReferenceEntry<Object, Object> getNext() {
      return null;
    }
    
    public LocalCache.ReferenceEntry<Object, Object> getNextInAccessQueue() {
      return this;
    }
    
    public LocalCache.ReferenceEntry<Object, Object> getNextInWriteQueue() {
      return this;
    }
    
    public LocalCache.ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
      return this;
    }
    
    public LocalCache.ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
      return this;
    }
    
    public LocalCache.ValueReference<Object, Object> getValueReference() {
      return null;
    }
    
    public long getWriteTime() {
      return 0L;
    }
    
    public void setAccessTime(long param1Long) {}
    
    public void setNextInAccessQueue(LocalCache.ReferenceEntry<Object, Object> param1ReferenceEntry) {}
    
    public void setNextInWriteQueue(LocalCache.ReferenceEntry<Object, Object> param1ReferenceEntry) {}
    
    public void setPreviousInAccessQueue(LocalCache.ReferenceEntry<Object, Object> param1ReferenceEntry) {}
    
    public void setPreviousInWriteQueue(LocalCache.ReferenceEntry<Object, Object> param1ReferenceEntry) {}
    
    public void setValueReference(LocalCache.ValueReference<Object, Object> param1ValueReference) {}
    
    public void setWriteTime(long param1Long) {}
  }
  
  static interface ReferenceEntry<K, V> {
    long getAccessTime();
    
    int getHash();
    
    @Nullable
    K getKey();
    
    @Nullable
    ReferenceEntry<K, V> getNext();
    
    ReferenceEntry<K, V> getNextInAccessQueue();
    
    ReferenceEntry<K, V> getNextInWriteQueue();
    
    ReferenceEntry<K, V> getPreviousInAccessQueue();
    
    ReferenceEntry<K, V> getPreviousInWriteQueue();
    
    LocalCache.ValueReference<K, V> getValueReference();
    
    long getWriteTime();
    
    void setAccessTime(long param1Long);
    
    void setNextInAccessQueue(ReferenceEntry<K, V> param1ReferenceEntry);
    
    void setNextInWriteQueue(ReferenceEntry<K, V> param1ReferenceEntry);
    
    void setPreviousInAccessQueue(ReferenceEntry<K, V> param1ReferenceEntry);
    
    void setPreviousInWriteQueue(ReferenceEntry<K, V> param1ReferenceEntry);
    
    void setValueReference(LocalCache.ValueReference<K, V> param1ValueReference);
    
    void setWriteTime(long param1Long);
  }
  
  static class Segment<K, V> extends ReentrantLock {
    @GuardedBy("this")
    final Queue<LocalCache.ReferenceEntry<K, V>> accessQueue;
    
    volatile int count;
    
    final ReferenceQueue<K> keyReferenceQueue;
    
    @Weak
    final LocalCache<K, V> map;
    
    final long maxSegmentWeight;
    
    int modCount;
    
    final AtomicInteger readCount;
    
    final Queue<LocalCache.ReferenceEntry<K, V>> recencyQueue;
    
    final AbstractCache.StatsCounter statsCounter;
    
    volatile AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table;
    
    int threshold;
    
    @GuardedBy("this")
    long totalWeight;
    
    final ReferenceQueue<V> valueReferenceQueue;
    
    @GuardedBy("this")
    final Queue<LocalCache.ReferenceEntry<K, V>> writeQueue;
    
    Segment(LocalCache<K, V> param1LocalCache, int param1Int, long param1Long, AbstractCache.StatsCounter param1StatsCounter) {
      Queue<?> queue1;
      ReferenceQueue<V> referenceQueue;
      Queue<?> queue2;
      this.readCount = new AtomicInteger();
      this.map = param1LocalCache;
      this.maxSegmentWeight = param1Long;
      this.statsCounter = (AbstractCache.StatsCounter)Preconditions.checkNotNull(param1StatsCounter);
      initTable(newEntryArray(param1Int));
      boolean bool = param1LocalCache.usesKeyReferences();
      AbstractCache.StatsCounter statsCounter = null;
      if (bool) {
        referenceQueue = new ReferenceQueue();
      } else {
        param1StatsCounter = null;
      } 
      this.keyReferenceQueue = (ReferenceQueue<K>)param1StatsCounter;
      param1StatsCounter = statsCounter;
      if (param1LocalCache.usesValueReferences())
        referenceQueue = new ReferenceQueue(); 
      this.valueReferenceQueue = referenceQueue;
      if (param1LocalCache.usesAccessQueue()) {
        queue2 = new ConcurrentLinkedQueue();
      } else {
        queue2 = LocalCache.discardingQueue();
      } 
      this.recencyQueue = (Queue)queue2;
      if (param1LocalCache.usesWriteQueue()) {
        queue2 = new LocalCache.WriteQueue<Object, Object>();
      } else {
        queue2 = LocalCache.discardingQueue();
      } 
      this.writeQueue = (Queue)queue2;
      if (param1LocalCache.usesAccessQueue()) {
        queue1 = new LocalCache.AccessQueue<Object, Object>();
      } else {
        queue1 = LocalCache.discardingQueue();
      } 
      this.accessQueue = (Queue)queue1;
    }
    
    void cleanUp() {
      runLockedCleanup(this.map.ticker.read());
      runUnlockedCleanup();
    }
    
    void clear() {
      if (this.count != 0) {
        lock();
        try {
          preWriteCleanup(this.map.ticker.read());
          AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
          byte b;
          for (b = 0; b < atomicReferenceArray.length(); b++) {
            for (LocalCache.ReferenceEntry referenceEntry = atomicReferenceArray.get(b); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
              if (referenceEntry.getValueReference().isActive()) {
                RemovalCause removalCause;
                Object object1 = referenceEntry.getKey();
                Object object2 = referenceEntry.getValueReference().get();
                if (object1 == null || object2 == null) {
                  removalCause = RemovalCause.COLLECTED;
                } else {
                  removalCause = RemovalCause.EXPLICIT;
                } 
                enqueueNotification((K)object1, referenceEntry.getHash(), (V)object2, referenceEntry.getValueReference().getWeight(), removalCause);
              } 
            } 
          } 
          for (b = 0; b < atomicReferenceArray.length(); b++)
            atomicReferenceArray.set(b, null); 
          clearReferenceQueues();
          this.writeQueue.clear();
          this.accessQueue.clear();
          this.readCount.set(0);
          this.modCount++;
          this.count = 0;
        } finally {
          unlock();
          postWriteCleanup();
        } 
      } 
    }
    
    void clearKeyReferenceQueue() {
      while (this.keyReferenceQueue.poll() != null);
    }
    
    void clearReferenceQueues() {
      if (this.map.usesKeyReferences())
        clearKeyReferenceQueue(); 
      if (this.map.usesValueReferences())
        clearValueReferenceQueue(); 
    }
    
    void clearValueReferenceQueue() {
      while (this.valueReferenceQueue.poll() != null);
    }
    
    boolean containsKey(Object<K, V> param1Object, int param1Int) {
      try {
        int i = this.count;
        boolean bool = false;
        if (i != 0) {
          param1Object = (Object<K, V>)getLiveEntry(param1Object, param1Int, this.map.ticker.read());
          if (param1Object == null)
            return false; 
          param1Object = (Object<K, V>)param1Object.getValueReference().get();
          if (param1Object != null)
            bool = true; 
          return bool;
        } 
        return false;
      } finally {
        postReadCleanup();
      } 
    }
    
    @VisibleForTesting
    boolean containsValue(Object param1Object) {
      try {
        if (this.count != 0) {
          long l = this.map.ticker.read();
          AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
          int i = atomicReferenceArray.length();
          for (byte b = 0; b < i; b++) {
            for (LocalCache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(b); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
              V v = getLiveValue(referenceEntry, l);
              if (v != null) {
                boolean bool = this.map.valueEquivalence.equivalent(param1Object, v);
                if (bool)
                  return true; 
              } 
            } 
          } 
        } 
        return false;
      } finally {
        postReadCleanup();
      } 
    }
    
    @GuardedBy("this")
    LocalCache.ReferenceEntry<K, V> copyEntry(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry1, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry2) {
      if (param1ReferenceEntry1.getKey() == null)
        return null; 
      LocalCache.ValueReference<K, V> valueReference = param1ReferenceEntry1.getValueReference();
      V v = valueReference.get();
      if (v == null && valueReference.isActive())
        return null; 
      param1ReferenceEntry1 = this.map.entryFactory.copyEntry(this, param1ReferenceEntry1, param1ReferenceEntry2);
      param1ReferenceEntry1.setValueReference(valueReference.copyFor(this.valueReferenceQueue, v, param1ReferenceEntry1));
      return param1ReferenceEntry1;
    }
    
    @GuardedBy("this")
    void drainKeyReferenceQueue() {
      int i = 0;
      while (true) {
        Reference<? extends K> reference = this.keyReferenceQueue.poll();
        if (reference != null) {
          LocalCache.ReferenceEntry<K, V> referenceEntry = (LocalCache.ReferenceEntry)reference;
          this.map.reclaimKey(referenceEntry);
          int j = i + 1;
          i = j;
          if (j == 16)
            break; 
          continue;
        } 
        break;
      } 
    }
    
    @GuardedBy("this")
    void drainRecencyQueue() {
      while (true) {
        LocalCache.ReferenceEntry<K, V> referenceEntry = this.recencyQueue.poll();
        if (referenceEntry != null) {
          if (this.accessQueue.contains(referenceEntry))
            this.accessQueue.add(referenceEntry); 
          continue;
        } 
        break;
      } 
    }
    
    @GuardedBy("this")
    void drainReferenceQueues() {
      if (this.map.usesKeyReferences())
        drainKeyReferenceQueue(); 
      if (this.map.usesValueReferences())
        drainValueReferenceQueue(); 
    }
    
    @GuardedBy("this")
    void drainValueReferenceQueue() {
      int i = 0;
      while (true) {
        Reference<? extends V> reference = this.valueReferenceQueue.poll();
        if (reference != null) {
          LocalCache.ValueReference<K, V> valueReference = (LocalCache.ValueReference)reference;
          this.map.reclaimValue(valueReference);
          int j = i + 1;
          i = j;
          if (j == 16)
            break; 
          continue;
        } 
        break;
      } 
    }
    
    @GuardedBy("this")
    void enqueueNotification(@Nullable K param1K, int param1Int1, @Nullable V param1V, int param1Int2, RemovalCause param1RemovalCause) {
      this.totalWeight -= param1Int2;
      if (param1RemovalCause.wasEvicted())
        this.statsCounter.recordEviction(); 
      if (this.map.removalNotificationQueue != LocalCache.DISCARDING_QUEUE) {
        RemovalNotification<K, V> removalNotification = RemovalNotification.create(param1K, param1V, param1RemovalCause);
        this.map.removalNotificationQueue.offer(removalNotification);
      } 
    }
    
    @GuardedBy("this")
    void evictEntries(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      if (!this.map.evictsBySize())
        return; 
      drainRecencyQueue();
      if (param1ReferenceEntry.getValueReference().getWeight() <= this.maxSegmentWeight || removeEntry(param1ReferenceEntry, param1ReferenceEntry.getHash(), RemovalCause.SIZE)) {
        while (this.totalWeight > this.maxSegmentWeight) {
          param1ReferenceEntry = getNextEvictable();
          if (removeEntry(param1ReferenceEntry, param1ReferenceEntry.getHash(), RemovalCause.SIZE))
            continue; 
          throw new AssertionError();
        } 
        return;
      } 
      throw new AssertionError();
    }
    
    @GuardedBy("this")
    void expand() {
      AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> atomicReferenceArray1 = this.table;
      int i = atomicReferenceArray1.length();
      if (i >= 1073741824)
        return; 
      int j = this.count;
      AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> atomicReferenceArray2 = newEntryArray(i << 1);
      this.threshold = atomicReferenceArray2.length() * 3 / 4;
      int k = atomicReferenceArray2.length() - 1;
      byte b = 0;
      while (b < i) {
        LocalCache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray1.get(b);
        int m = j;
        if (referenceEntry != null) {
          LocalCache.ReferenceEntry<K, V> referenceEntry1 = referenceEntry.getNext();
          int n = referenceEntry.getHash() & k;
          if (referenceEntry1 == null) {
            atomicReferenceArray2.set(n, referenceEntry);
            m = j;
          } else {
            LocalCache.ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
            while (referenceEntry1 != null) {
              int i1 = referenceEntry1.getHash() & k;
              m = n;
              if (i1 != n) {
                referenceEntry2 = referenceEntry1;
                m = i1;
              } 
              referenceEntry1 = referenceEntry1.getNext();
              n = m;
            } 
            atomicReferenceArray2.set(n, referenceEntry2);
            while (true) {
              m = j;
              if (referenceEntry != referenceEntry2) {
                m = referenceEntry.getHash() & k;
                referenceEntry1 = copyEntry(referenceEntry, atomicReferenceArray2.get(m));
                if (referenceEntry1 != null) {
                  atomicReferenceArray2.set(m, referenceEntry1);
                } else {
                  removeCollectedEntry(referenceEntry);
                  j--;
                } 
                referenceEntry = referenceEntry.getNext();
                continue;
              } 
              break;
            } 
          } 
        } 
        b++;
        j = m;
      } 
      this.table = atomicReferenceArray2;
      this.count = j;
    }
    
    @GuardedBy("this")
    void expireEntries(long param1Long) {
      drainRecencyQueue();
      while (true) {
        LocalCache.ReferenceEntry<K, V> referenceEntry = this.writeQueue.peek();
        if (referenceEntry != null && this.map.isExpired(referenceEntry, param1Long)) {
          if (removeEntry(referenceEntry, referenceEntry.getHash(), RemovalCause.EXPIRED))
            continue; 
          throw new AssertionError();
        } 
        break;
      } 
      while (true) {
        LocalCache.ReferenceEntry<K, V> referenceEntry = this.accessQueue.peek();
        if (referenceEntry != null && this.map.isExpired(referenceEntry, param1Long)) {
          if (removeEntry(referenceEntry, referenceEntry.getHash(), RemovalCause.EXPIRED))
            continue; 
          throw new AssertionError();
        } 
        break;
      } 
    }
    
    @Nullable
    V get(Object<K, V> param1Object, int param1Int) {
      try {
        if (this.count != 0) {
          long l = this.map.ticker.read();
          param1Object = (Object<K, V>)getLiveEntry(param1Object, param1Int, l);
          if (param1Object == null)
            return null; 
          Object object = param1Object.getValueReference().get();
          if (object != null) {
            recordRead((LocalCache.ReferenceEntry<K, V>)param1Object, l);
            param1Object = (Object<K, V>)scheduleRefresh((LocalCache.ReferenceEntry<K, V>)param1Object, param1Object.getKey(), param1Int, (V)object, l, this.map.defaultLoader);
            return (V)param1Object;
          } 
          tryDrainReferenceQueues();
        } 
        return null;
      } finally {
        postReadCleanup();
      } 
    }
    
    V get(K param1K, int param1Int, CacheLoader<? super K, V> param1CacheLoader) throws ExecutionException {
      Preconditions.checkNotNull(param1K);
      Preconditions.checkNotNull(param1CacheLoader);
      try {
        if (this.count != 0) {
          LocalCache.ReferenceEntry<K, V> referenceEntry = getEntry(param1K, param1Int);
          if (referenceEntry != null) {
            long l = this.map.ticker.read();
            V v = getLiveValue(referenceEntry, l);
            if (v != null) {
              recordRead(referenceEntry, l);
              this.statsCounter.recordHits(1);
              param1K = (K)scheduleRefresh(referenceEntry, param1K, param1Int, v, l, param1CacheLoader);
              postReadCleanup();
              return (V)param1K;
            } 
            LocalCache.ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            if (valueReference.isLoading()) {
              param1K = (K)waitForLoadingValue(referenceEntry, param1K, valueReference);
              postReadCleanup();
              return (V)param1K;
            } 
          } 
        } 
        param1K = (K)lockedGetOrLoad(param1K, param1Int, param1CacheLoader);
        postReadCleanup();
        return (V)param1K;
      } catch (ExecutionException executionException) {
        Throwable throwable = executionException.getCause();
        if (!(throwable instanceof Error)) {
          UncheckedExecutionException uncheckedExecutionException;
          if (throwable instanceof RuntimeException) {
            uncheckedExecutionException = new UncheckedExecutionException();
            this(throwable);
            throw uncheckedExecutionException;
          } 
          throw uncheckedExecutionException;
        } 
        ExecutionError executionError = new ExecutionError();
        this((Error)throwable);
        throw executionError;
      } finally {}
      postReadCleanup();
      throw param1K;
    }
    
    V getAndRecordStats(K param1K, int param1Int, LocalCache.LoadingValueReference<K, V> param1LoadingValueReference, ListenableFuture<V> param1ListenableFuture) throws ExecutionException {
      Exception exception;
      try {
        Object object = Uninterruptibles.getUninterruptibly((Future)param1ListenableFuture);
      } finally {
        exception = null;
      } 
      if (param1ListenableFuture == null) {
        this.statsCounter.recordLoadException(param1LoadingValueReference.elapsedNanos());
        removeLoadingValue(param1K, param1Int, param1LoadingValueReference);
      } 
      throw exception;
    }
    
    @Nullable
    LocalCache.ReferenceEntry<K, V> getEntry(Object param1Object, int param1Int) {
      for (LocalCache.ReferenceEntry<K, V> referenceEntry = getFirst(param1Int); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
        if (referenceEntry.getHash() == param1Int) {
          K k = referenceEntry.getKey();
          if (k == null) {
            tryDrainReferenceQueues();
          } else if (this.map.keyEquivalence.equivalent(param1Object, k)) {
            return referenceEntry;
          } 
        } 
      } 
      return null;
    }
    
    LocalCache.ReferenceEntry<K, V> getFirst(int param1Int) {
      AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
      return atomicReferenceArray.get(param1Int & atomicReferenceArray.length() - 1);
    }
    
    @Nullable
    LocalCache.ReferenceEntry<K, V> getLiveEntry(Object<K, V> param1Object, int param1Int, long param1Long) {
      param1Object = (Object<K, V>)getEntry(param1Object, param1Int);
      if (param1Object == null)
        return null; 
      if (this.map.isExpired((LocalCache.ReferenceEntry<K, V>)param1Object, param1Long)) {
        tryExpireEntries(param1Long);
        return null;
      } 
      return (LocalCache.ReferenceEntry<K, V>)param1Object;
    }
    
    V getLiveValue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry, long param1Long) {
      if (param1ReferenceEntry.getKey() == null) {
        tryDrainReferenceQueues();
        return null;
      } 
      Object object = param1ReferenceEntry.getValueReference().get();
      if (object == null) {
        tryDrainReferenceQueues();
        return null;
      } 
      if (this.map.isExpired(param1ReferenceEntry, param1Long)) {
        tryExpireEntries(param1Long);
        return null;
      } 
      return (V)object;
    }
    
    @GuardedBy("this")
    LocalCache.ReferenceEntry<K, V> getNextEvictable() {
      for (LocalCache.ReferenceEntry<K, V> referenceEntry : this.accessQueue) {
        if (referenceEntry.getValueReference().getWeight() > 0)
          return referenceEntry; 
      } 
      throw new AssertionError();
    }
    
    void initTable(AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> param1AtomicReferenceArray) {
      this.threshold = param1AtomicReferenceArray.length() * 3 / 4;
      if (!this.map.customWeigher()) {
        int i = this.threshold;
        if (i == this.maxSegmentWeight)
          this.threshold = i + 1; 
      } 
      this.table = param1AtomicReferenceArray;
    }
    
    @Nullable
    LocalCache.LoadingValueReference<K, V> insertLoadingValueReference(K param1K, int param1Int, boolean param1Boolean) {
      lock();
      try {
        LocalCache.ValueReference<K, V> valueReference;
        LocalCache.LoadingValueReference<Object, Object> loadingValueReference1;
        long l = this.map.ticker.read();
        preWriteCleanup(l);
        AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
        int i = atomicReferenceArray.length() - 1 & param1Int;
        LocalCache.ReferenceEntry<Object, Object> referenceEntry1 = (LocalCache.ReferenceEntry)atomicReferenceArray.get(i);
        for (LocalCache.ReferenceEntry<Object, Object> referenceEntry2 = referenceEntry1; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
          Object object = referenceEntry2.getKey();
          if (referenceEntry2.getHash() == param1Int && object != null && this.map.keyEquivalence.equivalent(param1K, object)) {
            valueReference = referenceEntry2.getValueReference();
            if (valueReference.isLoading() || (param1Boolean && l - referenceEntry2.getWriteTime() < this.map.refreshNanos))
              return null; 
            this.modCount++;
            loadingValueReference1 = new LocalCache.LoadingValueReference<Object, Object>();
            this(valueReference);
            referenceEntry2.setValueReference(loadingValueReference1);
            return (LocalCache.LoadingValueReference)loadingValueReference1;
          } 
        } 
        this.modCount++;
        LocalCache.LoadingValueReference<Object, Object> loadingValueReference2 = new LocalCache.LoadingValueReference<Object, Object>();
        this();
        LocalCache.ReferenceEntry<K, V> referenceEntry = newEntry((K)valueReference, param1Int, (LocalCache.ReferenceEntry)loadingValueReference1);
        referenceEntry.setValueReference((LocalCache.ValueReference)loadingValueReference2);
        atomicReferenceArray.set(i, referenceEntry);
        return (LocalCache.LoadingValueReference)loadingValueReference2;
      } finally {
        unlock();
        postWriteCleanup();
      } 
    }
    
    ListenableFuture<V> loadAsync(final K key, final int hash, final LocalCache.LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> param1CacheLoader) {
      final ListenableFuture<V> loadingFuture = loadingValueReference.loadFuture(key, param1CacheLoader);
      listenableFuture.addListener(new Runnable() {
            public void run() {
              try {
                LocalCache.Segment.this.getAndRecordStats(key, hash, loadingValueReference, loadingFuture);
              } catch (Throwable throwable) {
                LocalCache.logger.log(Level.WARNING, "Exception thrown during refresh", throwable);
                loadingValueReference.setException(throwable);
              } 
            }
          }MoreExecutors.directExecutor());
      return listenableFuture;
    }
    
    V loadSync(K param1K, int param1Int, LocalCache.LoadingValueReference<K, V> param1LoadingValueReference, CacheLoader<? super K, V> param1CacheLoader) throws ExecutionException {
      return getAndRecordStats(param1K, param1Int, param1LoadingValueReference, param1LoadingValueReference.loadFuture(param1K, param1CacheLoader));
    }
    
    V lockedGetOrLoad(K param1K, int param1Int, CacheLoader<? super K, V> param1CacheLoader) throws ExecutionException {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual lock : ()V
      //   4: aload_0
      //   5: getfield map : Lcom/google/common/cache/LocalCache;
      //   8: getfield ticker : Lcom/google/common/base/Ticker;
      //   11: invokevirtual read : ()J
      //   14: lstore #4
      //   16: aload_0
      //   17: lload #4
      //   19: invokevirtual preWriteCleanup : (J)V
      //   22: aload_0
      //   23: getfield count : I
      //   26: istore #6
      //   28: aload_0
      //   29: getfield table : Ljava/util/concurrent/atomic/AtomicReferenceArray;
      //   32: astore #7
      //   34: iload_2
      //   35: aload #7
      //   37: invokevirtual length : ()I
      //   40: iconst_1
      //   41: isub
      //   42: iand
      //   43: istore #8
      //   45: aload #7
      //   47: iload #8
      //   49: invokevirtual get : (I)Ljava/lang/Object;
      //   52: checkcast com/google/common/cache/LocalCache$ReferenceEntry
      //   55: astore #9
      //   57: aload #9
      //   59: astore #10
      //   61: aconst_null
      //   62: astore #11
      //   64: aload #10
      //   66: ifnull -> 283
      //   69: aload #10
      //   71: invokeinterface getKey : ()Ljava/lang/Object;
      //   76: astore #12
      //   78: aload #10
      //   80: invokeinterface getHash : ()I
      //   85: iload_2
      //   86: if_icmpne -> 271
      //   89: aload #12
      //   91: ifnull -> 271
      //   94: aload_0
      //   95: getfield map : Lcom/google/common/cache/LocalCache;
      //   98: getfield keyEquivalence : Lcom/google/common/base/Equivalence;
      //   101: aload_1
      //   102: aload #12
      //   104: invokevirtual equivalent : (Ljava/lang/Object;Ljava/lang/Object;)Z
      //   107: ifeq -> 271
      //   110: aload #10
      //   112: invokeinterface getValueReference : ()Lcom/google/common/cache/LocalCache$ValueReference;
      //   117: astore #13
      //   119: aload #13
      //   121: invokeinterface isLoading : ()Z
      //   126: ifeq -> 135
      //   129: iconst_0
      //   130: istore #6
      //   132: goto -> 289
      //   135: aload #13
      //   137: invokeinterface get : ()Ljava/lang/Object;
      //   142: astore #14
      //   144: aload #14
      //   146: ifnonnull -> 171
      //   149: aload_0
      //   150: aload #12
      //   152: iload_2
      //   153: aload #14
      //   155: aload #13
      //   157: invokeinterface getWeight : ()I
      //   162: getstatic com/google/common/cache/RemovalCause.COLLECTED : Lcom/google/common/cache/RemovalCause;
      //   165: invokevirtual enqueueNotification : (Ljava/lang/Object;ILjava/lang/Object;ILcom/google/common/cache/RemovalCause;)V
      //   168: goto -> 204
      //   171: aload_0
      //   172: getfield map : Lcom/google/common/cache/LocalCache;
      //   175: aload #10
      //   177: lload #4
      //   179: invokevirtual isExpired : (Lcom/google/common/cache/LocalCache$ReferenceEntry;J)Z
      //   182: ifeq -> 242
      //   185: aload_0
      //   186: aload #12
      //   188: iload_2
      //   189: aload #14
      //   191: aload #13
      //   193: invokeinterface getWeight : ()I
      //   198: getstatic com/google/common/cache/RemovalCause.EXPIRED : Lcom/google/common/cache/RemovalCause;
      //   201: invokevirtual enqueueNotification : (Ljava/lang/Object;ILjava/lang/Object;ILcom/google/common/cache/RemovalCause;)V
      //   204: aload_0
      //   205: getfield writeQueue : Ljava/util/Queue;
      //   208: aload #10
      //   210: invokeinterface remove : (Ljava/lang/Object;)Z
      //   215: pop
      //   216: aload_0
      //   217: getfield accessQueue : Ljava/util/Queue;
      //   220: aload #10
      //   222: invokeinterface remove : (Ljava/lang/Object;)Z
      //   227: pop
      //   228: aload_0
      //   229: iload #6
      //   231: iconst_1
      //   232: isub
      //   233: putfield count : I
      //   236: iconst_1
      //   237: istore #6
      //   239: goto -> 289
      //   242: aload_0
      //   243: aload #10
      //   245: lload #4
      //   247: invokevirtual recordLockedRead : (Lcom/google/common/cache/LocalCache$ReferenceEntry;J)V
      //   250: aload_0
      //   251: getfield statsCounter : Lcom/google/common/cache/AbstractCache$StatsCounter;
      //   254: iconst_1
      //   255: invokeinterface recordHits : (I)V
      //   260: aload_0
      //   261: invokevirtual unlock : ()V
      //   264: aload_0
      //   265: invokevirtual postWriteCleanup : ()V
      //   268: aload #14
      //   270: areturn
      //   271: aload #10
      //   273: invokeinterface getNext : ()Lcom/google/common/cache/LocalCache$ReferenceEntry;
      //   278: astore #10
      //   280: goto -> 61
      //   283: aconst_null
      //   284: astore #13
      //   286: iconst_1
      //   287: istore #6
      //   289: aload #10
      //   291: astore #14
      //   293: iload #6
      //   295: ifeq -> 357
      //   298: new com/google/common/cache/LocalCache$LoadingValueReference
      //   301: astore #11
      //   303: aload #11
      //   305: invokespecial <init> : ()V
      //   308: aload #10
      //   310: ifnonnull -> 344
      //   313: aload_0
      //   314: aload_1
      //   315: iload_2
      //   316: aload #9
      //   318: invokevirtual newEntry : (Ljava/lang/Object;ILcom/google/common/cache/LocalCache$ReferenceEntry;)Lcom/google/common/cache/LocalCache$ReferenceEntry;
      //   321: astore #14
      //   323: aload #14
      //   325: aload #11
      //   327: invokeinterface setValueReference : (Lcom/google/common/cache/LocalCache$ValueReference;)V
      //   332: aload #7
      //   334: iload #8
      //   336: aload #14
      //   338: invokevirtual set : (ILjava/lang/Object;)V
      //   341: goto -> 357
      //   344: aload #10
      //   346: aload #11
      //   348: invokeinterface setValueReference : (Lcom/google/common/cache/LocalCache$ValueReference;)V
      //   353: aload #10
      //   355: astore #14
      //   357: aload_0
      //   358: invokevirtual unlock : ()V
      //   361: aload_0
      //   362: invokevirtual postWriteCleanup : ()V
      //   365: iload #6
      //   367: ifeq -> 417
      //   370: aload #14
      //   372: monitorenter
      //   373: aload_0
      //   374: aload_1
      //   375: iload_2
      //   376: aload #11
      //   378: aload_3
      //   379: invokevirtual loadSync : (Ljava/lang/Object;ILcom/google/common/cache/LocalCache$LoadingValueReference;Lcom/google/common/cache/CacheLoader;)Ljava/lang/Object;
      //   382: astore_1
      //   383: aload #14
      //   385: monitorexit
      //   386: aload_0
      //   387: getfield statsCounter : Lcom/google/common/cache/AbstractCache$StatsCounter;
      //   390: iconst_1
      //   391: invokeinterface recordMisses : (I)V
      //   396: aload_1
      //   397: areturn
      //   398: astore_1
      //   399: aload #14
      //   401: monitorexit
      //   402: aload_1
      //   403: athrow
      //   404: astore_1
      //   405: aload_0
      //   406: getfield statsCounter : Lcom/google/common/cache/AbstractCache$StatsCounter;
      //   409: iconst_1
      //   410: invokeinterface recordMisses : (I)V
      //   415: aload_1
      //   416: athrow
      //   417: aload_0
      //   418: aload #14
      //   420: aload_1
      //   421: aload #13
      //   423: invokevirtual waitForLoadingValue : (Lcom/google/common/cache/LocalCache$ReferenceEntry;Ljava/lang/Object;Lcom/google/common/cache/LocalCache$ValueReference;)Ljava/lang/Object;
      //   426: areturn
      //   427: astore_1
      //   428: aload_0
      //   429: invokevirtual unlock : ()V
      //   432: aload_0
      //   433: invokevirtual postWriteCleanup : ()V
      //   436: aload_1
      //   437: athrow
      // Exception table:
      //   from	to	target	type
      //   4	57	427	finally
      //   69	89	427	finally
      //   94	129	427	finally
      //   135	144	427	finally
      //   149	168	427	finally
      //   171	204	427	finally
      //   204	236	427	finally
      //   242	260	427	finally
      //   271	280	427	finally
      //   298	308	427	finally
      //   313	341	427	finally
      //   344	353	427	finally
      //   370	373	404	finally
      //   373	386	398	finally
      //   399	402	398	finally
      //   402	404	404	finally
    }
    
    @GuardedBy("this")
    LocalCache.ReferenceEntry<K, V> newEntry(K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      return this.map.entryFactory.newEntry(this, (K)Preconditions.checkNotNull(param1K), param1Int, param1ReferenceEntry);
    }
    
    AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> newEntryArray(int param1Int) {
      return new AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>>(param1Int);
    }
    
    void postReadCleanup() {
      if ((this.readCount.incrementAndGet() & 0x3F) == 0)
        cleanUp(); 
    }
    
    void postWriteCleanup() {
      runUnlockedCleanup();
    }
    
    @GuardedBy("this")
    void preWriteCleanup(long param1Long) {
      runLockedCleanup(param1Long);
    }
    
    @Nullable
    V put(K param1K, int param1Int, V param1V, boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual lock : ()V
      //   4: aload_0
      //   5: getfield map : Lcom/google/common/cache/LocalCache;
      //   8: getfield ticker : Lcom/google/common/base/Ticker;
      //   11: invokevirtual read : ()J
      //   14: lstore #5
      //   16: aload_0
      //   17: lload #5
      //   19: invokevirtual preWriteCleanup : (J)V
      //   22: aload_0
      //   23: getfield count : I
      //   26: iconst_1
      //   27: iadd
      //   28: aload_0
      //   29: getfield threshold : I
      //   32: if_icmple -> 45
      //   35: aload_0
      //   36: invokevirtual expand : ()V
      //   39: aload_0
      //   40: getfield count : I
      //   43: istore #7
      //   45: aload_0
      //   46: getfield table : Ljava/util/concurrent/atomic/AtomicReferenceArray;
      //   49: astore #8
      //   51: iload_2
      //   52: aload #8
      //   54: invokevirtual length : ()I
      //   57: iconst_1
      //   58: isub
      //   59: iand
      //   60: istore #7
      //   62: aload #8
      //   64: iload #7
      //   66: invokevirtual get : (I)Ljava/lang/Object;
      //   69: checkcast com/google/common/cache/LocalCache$ReferenceEntry
      //   72: astore #9
      //   74: aload #9
      //   76: astore #10
      //   78: aload #10
      //   80: ifnull -> 324
      //   83: aload #10
      //   85: invokeinterface getKey : ()Ljava/lang/Object;
      //   90: astore #11
      //   92: aload #10
      //   94: invokeinterface getHash : ()I
      //   99: iload_2
      //   100: if_icmpne -> 312
      //   103: aload #11
      //   105: ifnull -> 312
      //   108: aload_0
      //   109: getfield map : Lcom/google/common/cache/LocalCache;
      //   112: getfield keyEquivalence : Lcom/google/common/base/Equivalence;
      //   115: aload_1
      //   116: aload #11
      //   118: invokevirtual equivalent : (Ljava/lang/Object;Ljava/lang/Object;)Z
      //   121: ifeq -> 312
      //   124: aload #10
      //   126: invokeinterface getValueReference : ()Lcom/google/common/cache/LocalCache$ValueReference;
      //   131: astore #9
      //   133: aload #9
      //   135: invokeinterface get : ()Ljava/lang/Object;
      //   140: astore #8
      //   142: aload #8
      //   144: ifnonnull -> 241
      //   147: aload_0
      //   148: aload_0
      //   149: getfield modCount : I
      //   152: iconst_1
      //   153: iadd
      //   154: putfield modCount : I
      //   157: aload #9
      //   159: invokeinterface isActive : ()Z
      //   164: ifeq -> 203
      //   167: aload_0
      //   168: aload_1
      //   169: iload_2
      //   170: aload #8
      //   172: aload #9
      //   174: invokeinterface getWeight : ()I
      //   179: getstatic com/google/common/cache/RemovalCause.COLLECTED : Lcom/google/common/cache/RemovalCause;
      //   182: invokevirtual enqueueNotification : (Ljava/lang/Object;ILjava/lang/Object;ILcom/google/common/cache/RemovalCause;)V
      //   185: aload_0
      //   186: aload #10
      //   188: aload_1
      //   189: aload_3
      //   190: lload #5
      //   192: invokevirtual setValue : (Lcom/google/common/cache/LocalCache$ReferenceEntry;Ljava/lang/Object;Ljava/lang/Object;J)V
      //   195: aload_0
      //   196: getfield count : I
      //   199: istore_2
      //   200: goto -> 220
      //   203: aload_0
      //   204: aload #10
      //   206: aload_1
      //   207: aload_3
      //   208: lload #5
      //   210: invokevirtual setValue : (Lcom/google/common/cache/LocalCache$ReferenceEntry;Ljava/lang/Object;Ljava/lang/Object;J)V
      //   213: aload_0
      //   214: getfield count : I
      //   217: iconst_1
      //   218: iadd
      //   219: istore_2
      //   220: aload_0
      //   221: iload_2
      //   222: putfield count : I
      //   225: aload_0
      //   226: aload #10
      //   228: invokevirtual evictEntries : (Lcom/google/common/cache/LocalCache$ReferenceEntry;)V
      //   231: aload_0
      //   232: invokevirtual unlock : ()V
      //   235: aload_0
      //   236: invokevirtual postWriteCleanup : ()V
      //   239: aconst_null
      //   240: areturn
      //   241: iload #4
      //   243: ifeq -> 265
      //   246: aload_0
      //   247: aload #10
      //   249: lload #5
      //   251: invokevirtual recordLockedRead : (Lcom/google/common/cache/LocalCache$ReferenceEntry;J)V
      //   254: aload_0
      //   255: invokevirtual unlock : ()V
      //   258: aload_0
      //   259: invokevirtual postWriteCleanup : ()V
      //   262: aload #8
      //   264: areturn
      //   265: aload_0
      //   266: aload_0
      //   267: getfield modCount : I
      //   270: iconst_1
      //   271: iadd
      //   272: putfield modCount : I
      //   275: aload_0
      //   276: aload_1
      //   277: iload_2
      //   278: aload #8
      //   280: aload #9
      //   282: invokeinterface getWeight : ()I
      //   287: getstatic com/google/common/cache/RemovalCause.REPLACED : Lcom/google/common/cache/RemovalCause;
      //   290: invokevirtual enqueueNotification : (Ljava/lang/Object;ILjava/lang/Object;ILcom/google/common/cache/RemovalCause;)V
      //   293: aload_0
      //   294: aload #10
      //   296: aload_1
      //   297: aload_3
      //   298: lload #5
      //   300: invokevirtual setValue : (Lcom/google/common/cache/LocalCache$ReferenceEntry;Ljava/lang/Object;Ljava/lang/Object;J)V
      //   303: aload_0
      //   304: aload #10
      //   306: invokevirtual evictEntries : (Lcom/google/common/cache/LocalCache$ReferenceEntry;)V
      //   309: goto -> 254
      //   312: aload #10
      //   314: invokeinterface getNext : ()Lcom/google/common/cache/LocalCache$ReferenceEntry;
      //   319: astore #10
      //   321: goto -> 78
      //   324: aload_0
      //   325: aload_0
      //   326: getfield modCount : I
      //   329: iconst_1
      //   330: iadd
      //   331: putfield modCount : I
      //   334: aload_0
      //   335: aload_1
      //   336: iload_2
      //   337: aload #9
      //   339: invokevirtual newEntry : (Ljava/lang/Object;ILcom/google/common/cache/LocalCache$ReferenceEntry;)Lcom/google/common/cache/LocalCache$ReferenceEntry;
      //   342: astore #10
      //   344: aload_0
      //   345: aload #10
      //   347: aload_1
      //   348: aload_3
      //   349: lload #5
      //   351: invokevirtual setValue : (Lcom/google/common/cache/LocalCache$ReferenceEntry;Ljava/lang/Object;Ljava/lang/Object;J)V
      //   354: aload #8
      //   356: iload #7
      //   358: aload #10
      //   360: invokevirtual set : (ILjava/lang/Object;)V
      //   363: aload_0
      //   364: aload_0
      //   365: getfield count : I
      //   368: iconst_1
      //   369: iadd
      //   370: putfield count : I
      //   373: aload_0
      //   374: aload #10
      //   376: invokevirtual evictEntries : (Lcom/google/common/cache/LocalCache$ReferenceEntry;)V
      //   379: goto -> 231
      //   382: astore_1
      //   383: aload_0
      //   384: invokevirtual unlock : ()V
      //   387: aload_0
      //   388: invokevirtual postWriteCleanup : ()V
      //   391: aload_1
      //   392: athrow
      // Exception table:
      //   from	to	target	type
      //   4	45	382	finally
      //   45	74	382	finally
      //   83	103	382	finally
      //   108	142	382	finally
      //   147	200	382	finally
      //   203	220	382	finally
      //   220	231	382	finally
      //   246	254	382	finally
      //   265	309	382	finally
      //   312	321	382	finally
      //   324	379	382	finally
    }
    
    boolean reclaimKey(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry, int param1Int) {
      lock();
      try {
        int i = this.count;
        AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
        i = atomicReferenceArray.length() - 1 & param1Int;
        LocalCache.ReferenceEntry<K, V> referenceEntry1 = atomicReferenceArray.get(i);
        for (LocalCache.ReferenceEntry<K, V> referenceEntry2 = referenceEntry1; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
          if (referenceEntry2 == param1ReferenceEntry) {
            this.modCount++;
            param1ReferenceEntry = removeValueFromChain(referenceEntry1, referenceEntry2, referenceEntry2.getKey(), param1Int, (V)referenceEntry2.getValueReference().get(), referenceEntry2.getValueReference(), RemovalCause.COLLECTED);
            param1Int = this.count;
            atomicReferenceArray.set(i, param1ReferenceEntry);
            this.count = param1Int - 1;
            return true;
          } 
        } 
        return false;
      } finally {
        unlock();
        postWriteCleanup();
      } 
    }
    
    boolean reclaimValue(K param1K, int param1Int, LocalCache.ValueReference<K, V> param1ValueReference) {
      lock();
      try {
        int i = this.count;
        AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
        i = atomicReferenceArray.length() - 1 & param1Int;
        LocalCache.ReferenceEntry<K, V> referenceEntry1 = atomicReferenceArray.get(i);
        for (LocalCache.ReferenceEntry<K, V> referenceEntry2 = referenceEntry1; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
          Object object = referenceEntry2.getKey();
          if (referenceEntry2.getHash() == param1Int && object != null && this.map.keyEquivalence.equivalent(param1K, object)) {
            if (referenceEntry2.getValueReference() == param1ValueReference) {
              this.modCount++;
              LocalCache.ReferenceEntry<K, V> referenceEntry = removeValueFromChain(referenceEntry1, referenceEntry2, (K)object, param1Int, param1ValueReference.get(), param1ValueReference, RemovalCause.COLLECTED);
              param1Int = this.count;
              atomicReferenceArray.set(i, referenceEntry);
              this.count = param1Int - 1;
              return true;
            } 
            return false;
          } 
        } 
        return false;
      } finally {
        unlock();
        if (!isHeldByCurrentThread())
          postWriteCleanup(); 
      } 
    }
    
    @GuardedBy("this")
    void recordLockedRead(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry, long param1Long) {
      if (this.map.recordsAccess())
        param1ReferenceEntry.setAccessTime(param1Long); 
      this.accessQueue.add(param1ReferenceEntry);
    }
    
    void recordRead(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry, long param1Long) {
      if (this.map.recordsAccess())
        param1ReferenceEntry.setAccessTime(param1Long); 
      this.recencyQueue.add(param1ReferenceEntry);
    }
    
    @GuardedBy("this")
    void recordWrite(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry, int param1Int, long param1Long) {
      drainRecencyQueue();
      this.totalWeight += param1Int;
      if (this.map.recordsAccess())
        param1ReferenceEntry.setAccessTime(param1Long); 
      if (this.map.recordsWrite())
        param1ReferenceEntry.setWriteTime(param1Long); 
      this.accessQueue.add(param1ReferenceEntry);
      this.writeQueue.add(param1ReferenceEntry);
    }
    
    @Nullable
    V refresh(K param1K, int param1Int, CacheLoader<? super K, V> param1CacheLoader, boolean param1Boolean) {
      LocalCache.LoadingValueReference<K, V> loadingValueReference = insertLoadingValueReference(param1K, param1Int, param1Boolean);
      if (loadingValueReference == null)
        return null; 
      ListenableFuture<V> listenableFuture = loadAsync(param1K, param1Int, loadingValueReference, param1CacheLoader);
      if (listenableFuture.isDone())
        try {
          return (V)Uninterruptibles.getUninterruptibly((Future)listenableFuture);
        } catch (Throwable throwable) {} 
      return null;
    }
    
    @Nullable
    V remove(Object<K, V> param1Object, int param1Int) {
      lock();
      try {
        preWriteCleanup(this.map.ticker.read());
        int i = this.count;
        AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
        i = atomicReferenceArray.length() - 1 & param1Int;
      } finally {
        unlock();
        postWriteCleanup();
      } 
    }
    
    boolean remove(Object param1Object1, int param1Int, Object<K, V> param1Object2) {
      lock();
      try {
        preWriteCleanup(this.map.ticker.read());
        int i = this.count;
        AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
        i = atomicReferenceArray.length();
        boolean bool = true;
        i = i - 1 & param1Int;
      } finally {
        unlock();
        postWriteCleanup();
      } 
    }
    
    @GuardedBy("this")
    void removeCollectedEntry(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      enqueueNotification(param1ReferenceEntry.getKey(), param1ReferenceEntry.getHash(), (V)param1ReferenceEntry.getValueReference().get(), param1ReferenceEntry.getValueReference().getWeight(), RemovalCause.COLLECTED);
      this.writeQueue.remove(param1ReferenceEntry);
      this.accessQueue.remove(param1ReferenceEntry);
    }
    
    @VisibleForTesting
    @GuardedBy("this")
    boolean removeEntry(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry, int param1Int, RemovalCause param1RemovalCause) {
      int i = this.count;
      AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
      i = atomicReferenceArray.length() - 1 & param1Int;
      LocalCache.ReferenceEntry<K, V> referenceEntry1 = atomicReferenceArray.get(i);
      for (LocalCache.ReferenceEntry<K, V> referenceEntry2 = referenceEntry1; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
        if (referenceEntry2 == param1ReferenceEntry) {
          this.modCount++;
          param1ReferenceEntry = removeValueFromChain(referenceEntry1, referenceEntry2, referenceEntry2.getKey(), param1Int, (V)referenceEntry2.getValueReference().get(), referenceEntry2.getValueReference(), param1RemovalCause);
          param1Int = this.count;
          atomicReferenceArray.set(i, param1ReferenceEntry);
          this.count = param1Int - 1;
          return true;
        } 
      } 
      return false;
    }
    
    @Nullable
    @GuardedBy("this")
    LocalCache.ReferenceEntry<K, V> removeEntryFromChain(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry1, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry2) {
      int i = this.count;
      LocalCache.ReferenceEntry<K, V> referenceEntry = param1ReferenceEntry2.getNext();
      while (param1ReferenceEntry1 != param1ReferenceEntry2) {
        LocalCache.ReferenceEntry<K, V> referenceEntry1 = copyEntry(param1ReferenceEntry1, referenceEntry);
        if (referenceEntry1 != null) {
          referenceEntry = referenceEntry1;
        } else {
          removeCollectedEntry(param1ReferenceEntry1);
          i--;
        } 
        param1ReferenceEntry1 = param1ReferenceEntry1.getNext();
      } 
      this.count = i;
      return referenceEntry;
    }
    
    boolean removeLoadingValue(K param1K, int param1Int, LocalCache.LoadingValueReference<K, V> param1LoadingValueReference) {
      lock();
      try {
        AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
        int i = atomicReferenceArray.length() - 1 & param1Int;
      } finally {
        unlock();
        postWriteCleanup();
      } 
    }
    
    @Nullable
    @GuardedBy("this")
    LocalCache.ReferenceEntry<K, V> removeValueFromChain(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry1, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry2, @Nullable K param1K, int param1Int, V param1V, LocalCache.ValueReference<K, V> param1ValueReference, RemovalCause param1RemovalCause) {
      enqueueNotification(param1K, param1Int, param1V, param1ValueReference.getWeight(), param1RemovalCause);
      this.writeQueue.remove(param1ReferenceEntry2);
      this.accessQueue.remove(param1ReferenceEntry2);
      if (param1ValueReference.isLoading()) {
        param1ValueReference.notifyNewValue(null);
        return param1ReferenceEntry1;
      } 
      return removeEntryFromChain(param1ReferenceEntry1, param1ReferenceEntry2);
    }
    
    @Nullable
    V replace(K param1K, int param1Int, V param1V) {
      lock();
      try {
        long l = this.map.ticker.read();
        preWriteCleanup(l);
        AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
        int i = param1Int & atomicReferenceArray.length() - 1;
      } finally {
        unlock();
        postWriteCleanup();
      } 
    }
    
    boolean replace(K param1K, int param1Int, V param1V1, V param1V2) {
      lock();
      try {
        long l = this.map.ticker.read();
        preWriteCleanup(l);
        AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
        int i = param1Int & atomicReferenceArray.length() - 1;
      } finally {
        unlock();
        postWriteCleanup();
      } 
    }
    
    void runLockedCleanup(long param1Long) {
      if (tryLock())
        try {
          drainReferenceQueues();
          expireEntries(param1Long);
          this.readCount.set(0);
        } finally {
          unlock();
        }  
    }
    
    void runUnlockedCleanup() {
      if (!isHeldByCurrentThread())
        this.map.processPendingNotifications(); 
    }
    
    V scheduleRefresh(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry, K param1K, int param1Int, V param1V, long param1Long, CacheLoader<? super K, V> param1CacheLoader) {
      if (this.map.refreshes() && param1Long - param1ReferenceEntry.getWriteTime() > this.map.refreshNanos && !param1ReferenceEntry.getValueReference().isLoading()) {
        param1ReferenceEntry = (LocalCache.ReferenceEntry<K, V>)refresh(param1K, param1Int, param1CacheLoader, true);
        if (param1ReferenceEntry != null)
          return (V)param1ReferenceEntry; 
      } 
      return param1V;
    }
    
    @GuardedBy("this")
    void setValue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry, K param1K, V param1V, long param1Long) {
      boolean bool;
      LocalCache.ValueReference<K, V> valueReference = param1ReferenceEntry.getValueReference();
      int i = this.map.weigher.weigh(param1K, param1V);
      if (i >= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Weights must be non-negative");
      param1ReferenceEntry.setValueReference(this.map.valueStrength.referenceValue(this, param1ReferenceEntry, param1V, i));
      recordWrite(param1ReferenceEntry, i, param1Long);
      valueReference.notifyNewValue(param1V);
    }
    
    boolean storeLoadedValue(K param1K, int param1Int, LocalCache.LoadingValueReference<K, V> param1LoadingValueReference, V param1V) {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual lock : ()V
      //   4: aload_0
      //   5: getfield map : Lcom/google/common/cache/LocalCache;
      //   8: getfield ticker : Lcom/google/common/base/Ticker;
      //   11: invokevirtual read : ()J
      //   14: lstore #5
      //   16: aload_0
      //   17: lload #5
      //   19: invokevirtual preWriteCleanup : (J)V
      //   22: aload_0
      //   23: getfield count : I
      //   26: iconst_1
      //   27: iadd
      //   28: istore #7
      //   30: iload #7
      //   32: aload_0
      //   33: getfield threshold : I
      //   36: if_icmple -> 54
      //   39: aload_0
      //   40: invokevirtual expand : ()V
      //   43: aload_0
      //   44: getfield count : I
      //   47: iconst_1
      //   48: iadd
      //   49: istore #7
      //   51: goto -> 54
      //   54: aload_0
      //   55: getfield table : Ljava/util/concurrent/atomic/AtomicReferenceArray;
      //   58: astore #8
      //   60: iload_2
      //   61: aload #8
      //   63: invokevirtual length : ()I
      //   66: iconst_1
      //   67: isub
      //   68: iand
      //   69: istore #9
      //   71: aload #8
      //   73: iload #9
      //   75: invokevirtual get : (I)Ljava/lang/Object;
      //   78: checkcast com/google/common/cache/LocalCache$ReferenceEntry
      //   81: astore #10
      //   83: aload #10
      //   85: astore #11
      //   87: aload #11
      //   89: ifnull -> 299
      //   92: aload #11
      //   94: invokeinterface getKey : ()Ljava/lang/Object;
      //   99: astore #12
      //   101: aload #11
      //   103: invokeinterface getHash : ()I
      //   108: iload_2
      //   109: if_icmpne -> 287
      //   112: aload #12
      //   114: ifnull -> 287
      //   117: aload_0
      //   118: getfield map : Lcom/google/common/cache/LocalCache;
      //   121: getfield keyEquivalence : Lcom/google/common/base/Equivalence;
      //   124: aload_1
      //   125: aload #12
      //   127: invokevirtual equivalent : (Ljava/lang/Object;Ljava/lang/Object;)Z
      //   130: ifeq -> 287
      //   133: aload #11
      //   135: invokeinterface getValueReference : ()Lcom/google/common/cache/LocalCache$ValueReference;
      //   140: astore #10
      //   142: aload #10
      //   144: invokeinterface get : ()Ljava/lang/Object;
      //   149: astore #8
      //   151: aload_3
      //   152: aload #10
      //   154: if_acmpeq -> 195
      //   157: aload #8
      //   159: ifnonnull -> 173
      //   162: aload #10
      //   164: getstatic com/google/common/cache/LocalCache.UNSET : Lcom/google/common/cache/LocalCache$ValueReference;
      //   167: if_acmpeq -> 173
      //   170: goto -> 195
      //   173: aload_0
      //   174: aload_1
      //   175: iload_2
      //   176: aload #4
      //   178: iconst_0
      //   179: getstatic com/google/common/cache/RemovalCause.REPLACED : Lcom/google/common/cache/RemovalCause;
      //   182: invokevirtual enqueueNotification : (Ljava/lang/Object;ILjava/lang/Object;ILcom/google/common/cache/RemovalCause;)V
      //   185: aload_0
      //   186: invokevirtual unlock : ()V
      //   189: aload_0
      //   190: invokevirtual postWriteCleanup : ()V
      //   193: iconst_0
      //   194: ireturn
      //   195: aload_0
      //   196: aload_0
      //   197: getfield modCount : I
      //   200: iconst_1
      //   201: iadd
      //   202: putfield modCount : I
      //   205: iload #7
      //   207: istore #9
      //   209: aload_3
      //   210: invokevirtual isActive : ()Z
      //   213: ifeq -> 254
      //   216: aload #8
      //   218: ifnonnull -> 229
      //   221: getstatic com/google/common/cache/RemovalCause.COLLECTED : Lcom/google/common/cache/RemovalCause;
      //   224: astore #10
      //   226: goto -> 234
      //   229: getstatic com/google/common/cache/RemovalCause.REPLACED : Lcom/google/common/cache/RemovalCause;
      //   232: astore #10
      //   234: aload_0
      //   235: aload_1
      //   236: iload_2
      //   237: aload #8
      //   239: aload_3
      //   240: invokevirtual getWeight : ()I
      //   243: aload #10
      //   245: invokevirtual enqueueNotification : (Ljava/lang/Object;ILjava/lang/Object;ILcom/google/common/cache/RemovalCause;)V
      //   248: iload #7
      //   250: iconst_1
      //   251: isub
      //   252: istore #9
      //   254: aload_0
      //   255: aload #11
      //   257: aload_1
      //   258: aload #4
      //   260: lload #5
      //   262: invokevirtual setValue : (Lcom/google/common/cache/LocalCache$ReferenceEntry;Ljava/lang/Object;Ljava/lang/Object;J)V
      //   265: aload_0
      //   266: iload #9
      //   268: putfield count : I
      //   271: aload_0
      //   272: aload #11
      //   274: invokevirtual evictEntries : (Lcom/google/common/cache/LocalCache$ReferenceEntry;)V
      //   277: aload_0
      //   278: invokevirtual unlock : ()V
      //   281: aload_0
      //   282: invokevirtual postWriteCleanup : ()V
      //   285: iconst_1
      //   286: ireturn
      //   287: aload #11
      //   289: invokeinterface getNext : ()Lcom/google/common/cache/LocalCache$ReferenceEntry;
      //   294: astore #11
      //   296: goto -> 87
      //   299: aload_0
      //   300: aload_0
      //   301: getfield modCount : I
      //   304: iconst_1
      //   305: iadd
      //   306: putfield modCount : I
      //   309: aload_0
      //   310: aload_1
      //   311: iload_2
      //   312: aload #10
      //   314: invokevirtual newEntry : (Ljava/lang/Object;ILcom/google/common/cache/LocalCache$ReferenceEntry;)Lcom/google/common/cache/LocalCache$ReferenceEntry;
      //   317: astore_3
      //   318: aload_0
      //   319: aload_3
      //   320: aload_1
      //   321: aload #4
      //   323: lload #5
      //   325: invokevirtual setValue : (Lcom/google/common/cache/LocalCache$ReferenceEntry;Ljava/lang/Object;Ljava/lang/Object;J)V
      //   328: aload #8
      //   330: iload #9
      //   332: aload_3
      //   333: invokevirtual set : (ILjava/lang/Object;)V
      //   336: aload_0
      //   337: iload #7
      //   339: putfield count : I
      //   342: aload_0
      //   343: aload_3
      //   344: invokevirtual evictEntries : (Lcom/google/common/cache/LocalCache$ReferenceEntry;)V
      //   347: goto -> 277
      //   350: astore_1
      //   351: aload_0
      //   352: invokevirtual unlock : ()V
      //   355: aload_0
      //   356: invokevirtual postWriteCleanup : ()V
      //   359: aload_1
      //   360: athrow
      // Exception table:
      //   from	to	target	type
      //   4	51	350	finally
      //   54	83	350	finally
      //   92	112	350	finally
      //   117	151	350	finally
      //   162	170	350	finally
      //   173	185	350	finally
      //   195	205	350	finally
      //   209	216	350	finally
      //   221	226	350	finally
      //   229	234	350	finally
      //   234	248	350	finally
      //   254	277	350	finally
      //   287	296	350	finally
      //   299	347	350	finally
    }
    
    void tryDrainReferenceQueues() {
      if (tryLock())
        try {
          drainReferenceQueues();
        } finally {
          unlock();
        }  
    }
    
    void tryExpireEntries(long param1Long) {
      if (tryLock())
        try {
          expireEntries(param1Long);
        } finally {
          unlock();
        }  
    }
    
    V waitForLoadingValue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry, K param1K, LocalCache.ValueReference<K, V> param1ValueReference) throws ExecutionException {
      if (param1ValueReference.isLoading()) {
        Preconditions.checkState(Thread.holdsLock(param1ReferenceEntry) ^ true, "Recursive load of: %s", param1K);
        try {
          param1ValueReference = (LocalCache.ValueReference<K, V>)param1ValueReference.waitForValue();
          if (param1ValueReference != null) {
            recordRead(param1ReferenceEntry, this.map.ticker.read());
            return (V)param1ValueReference;
          } 
          CacheLoader.InvalidCacheLoadException invalidCacheLoadException = new CacheLoader.InvalidCacheLoadException();
          StringBuilder stringBuilder = new StringBuilder();
          this();
          stringBuilder.append("CacheLoader returned null for key ");
          stringBuilder.append(param1K);
          stringBuilder.append(".");
          this(stringBuilder.toString());
          throw invalidCacheLoadException;
        } finally {
          this.statsCounter.recordMisses(1);
        } 
      } 
      throw new AssertionError();
    }
  }
  
  class null implements Runnable {
    public void run() {
      try {
        this.this$0.getAndRecordStats(key, hash, loadingValueReference, loadingFuture);
      } catch (Throwable throwable) {
        LocalCache.logger.log(Level.WARNING, "Exception thrown during refresh", throwable);
        loadingValueReference.setException(throwable);
      } 
    }
  }
  
  static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {
    final LocalCache.ReferenceEntry<K, V> entry;
    
    SoftValueReference(ReferenceQueue<V> param1ReferenceQueue, V param1V, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1V, param1ReferenceQueue);
      this.entry = param1ReferenceEntry;
    }
    
    public LocalCache.ValueReference<K, V> copyFor(ReferenceQueue<V> param1ReferenceQueue, V param1V, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      return new SoftValueReference(param1ReferenceQueue, param1V, param1ReferenceEntry);
    }
    
    public LocalCache.ReferenceEntry<K, V> getEntry() {
      return this.entry;
    }
    
    public int getWeight() {
      return 1;
    }
    
    public boolean isActive() {
      return true;
    }
    
    public boolean isLoading() {
      return false;
    }
    
    public void notifyNewValue(V param1V) {}
    
    public V waitForValue() {
      return get();
    }
  }
  
  enum Strength {
    SOFT,
    STRONG {
      Equivalence<Object> defaultEquivalence() {
        return Equivalence.equals();
      }
      
      <K, V> LocalCache.ValueReference<K, V> referenceValue(LocalCache.Segment<K, V> param2Segment, LocalCache.ReferenceEntry<K, V> param2ReferenceEntry, V param2V, int param2Int) {
        LocalCache.StrongValueReference<Object, V> strongValueReference;
        if (param2Int == 1) {
          strongValueReference = new LocalCache.StrongValueReference<Object, V>(param2V);
        } else {
          strongValueReference = new LocalCache.WeightedStrongValueReference<Object, V>(param2V, param2Int);
        } 
        return (LocalCache.ValueReference)strongValueReference;
      }
    },
    WEAK;
    
    static {
      $VALUES = new Strength[] { STRONG, SOFT, WEAK };
    }
    
    abstract Equivalence<Object> defaultEquivalence();
    
    abstract <K, V> LocalCache.ValueReference<K, V> referenceValue(LocalCache.Segment<K, V> param1Segment, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry, V param1V, int param1Int);
  }
  
  enum null {
    Equivalence<Object> defaultEquivalence() {
      return Equivalence.equals();
    }
    
    <K, V> LocalCache.ValueReference<K, V> referenceValue(LocalCache.Segment<K, V> param1Segment, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry, V param1V, int param1Int) {
      LocalCache.StrongValueReference<Object, V> strongValueReference;
      if (param1Int == 1) {
        strongValueReference = new LocalCache.StrongValueReference<Object, V>(param1V);
      } else {
        strongValueReference = new LocalCache.WeightedStrongValueReference<Object, V>(param1V, param1Int);
      } 
      return (LocalCache.ValueReference)strongValueReference;
    }
  }
  
  enum null {
    Equivalence<Object> defaultEquivalence() {
      return Equivalence.identity();
    }
    
    <K, V> LocalCache.ValueReference<K, V> referenceValue(LocalCache.Segment<K, V> param1Segment, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry, V param1V, int param1Int) {
      LocalCache.SoftValueReference<K, V> softValueReference;
      if (param1Int == 1) {
        softValueReference = new LocalCache.SoftValueReference<K, V>(param1Segment.valueReferenceQueue, param1V, param1ReferenceEntry);
      } else {
        softValueReference = new LocalCache.WeightedSoftValueReference<K, V>(((LocalCache.Segment)softValueReference).valueReferenceQueue, param1V, param1ReferenceEntry, param1Int);
      } 
      return softValueReference;
    }
  }
  
  enum null {
    Equivalence<Object> defaultEquivalence() {
      return Equivalence.identity();
    }
    
    <K, V> LocalCache.ValueReference<K, V> referenceValue(LocalCache.Segment<K, V> param1Segment, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry, V param1V, int param1Int) {
      LocalCache.WeakValueReference<K, V> weakValueReference;
      if (param1Int == 1) {
        weakValueReference = new LocalCache.WeakValueReference<K, V>(param1Segment.valueReferenceQueue, param1V, param1ReferenceEntry);
      } else {
        weakValueReference = new LocalCache.WeightedWeakValueReference<K, V>(((LocalCache.Segment)weakValueReference).valueReferenceQueue, param1V, param1ReferenceEntry, param1Int);
      } 
      return weakValueReference;
    }
  }
  
  static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {
    volatile long accessTime = Long.MAX_VALUE;
    
    LocalCache.ReferenceEntry<K, V> nextAccess = LocalCache.nullEntry();
    
    LocalCache.ReferenceEntry<K, V> previousAccess = LocalCache.nullEntry();
    
    StrongAccessEntry(K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1K, param1Int, param1ReferenceEntry);
    }
    
    public long getAccessTime() {
      return this.accessTime;
    }
    
    public LocalCache.ReferenceEntry<K, V> getNextInAccessQueue() {
      return this.nextAccess;
    }
    
    public LocalCache.ReferenceEntry<K, V> getPreviousInAccessQueue() {
      return this.previousAccess;
    }
    
    public void setAccessTime(long param1Long) {
      this.accessTime = param1Long;
    }
    
    public void setNextInAccessQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.nextAccess = param1ReferenceEntry;
    }
    
    public void setPreviousInAccessQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.previousAccess = param1ReferenceEntry;
    }
  }
  
  static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {
    volatile long accessTime = Long.MAX_VALUE;
    
    LocalCache.ReferenceEntry<K, V> nextAccess = LocalCache.nullEntry();
    
    LocalCache.ReferenceEntry<K, V> nextWrite = LocalCache.nullEntry();
    
    LocalCache.ReferenceEntry<K, V> previousAccess = LocalCache.nullEntry();
    
    LocalCache.ReferenceEntry<K, V> previousWrite = LocalCache.nullEntry();
    
    volatile long writeTime = Long.MAX_VALUE;
    
    StrongAccessWriteEntry(K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1K, param1Int, param1ReferenceEntry);
    }
    
    public long getAccessTime() {
      return this.accessTime;
    }
    
    public LocalCache.ReferenceEntry<K, V> getNextInAccessQueue() {
      return this.nextAccess;
    }
    
    public LocalCache.ReferenceEntry<K, V> getNextInWriteQueue() {
      return this.nextWrite;
    }
    
    public LocalCache.ReferenceEntry<K, V> getPreviousInAccessQueue() {
      return this.previousAccess;
    }
    
    public LocalCache.ReferenceEntry<K, V> getPreviousInWriteQueue() {
      return this.previousWrite;
    }
    
    public long getWriteTime() {
      return this.writeTime;
    }
    
    public void setAccessTime(long param1Long) {
      this.accessTime = param1Long;
    }
    
    public void setNextInAccessQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.nextAccess = param1ReferenceEntry;
    }
    
    public void setNextInWriteQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.nextWrite = param1ReferenceEntry;
    }
    
    public void setPreviousInAccessQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.previousAccess = param1ReferenceEntry;
    }
    
    public void setPreviousInWriteQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.previousWrite = param1ReferenceEntry;
    }
    
    public void setWriteTime(long param1Long) {
      this.writeTime = param1Long;
    }
  }
  
  static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {
    final int hash;
    
    final K key;
    
    final LocalCache.ReferenceEntry<K, V> next;
    
    volatile LocalCache.ValueReference<K, V> valueReference = LocalCache.unset();
    
    StrongEntry(K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.key = param1K;
      this.hash = param1Int;
      this.next = param1ReferenceEntry;
    }
    
    public int getHash() {
      return this.hash;
    }
    
    public K getKey() {
      return this.key;
    }
    
    public LocalCache.ReferenceEntry<K, V> getNext() {
      return this.next;
    }
    
    public LocalCache.ValueReference<K, V> getValueReference() {
      return this.valueReference;
    }
    
    public void setValueReference(LocalCache.ValueReference<K, V> param1ValueReference) {
      this.valueReference = param1ValueReference;
    }
  }
  
  static class StrongValueReference<K, V> implements ValueReference<K, V> {
    final V referent;
    
    StrongValueReference(V param1V) {
      this.referent = param1V;
    }
    
    public LocalCache.ValueReference<K, V> copyFor(ReferenceQueue<V> param1ReferenceQueue, V param1V, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      return this;
    }
    
    public V get() {
      return this.referent;
    }
    
    public LocalCache.ReferenceEntry<K, V> getEntry() {
      return null;
    }
    
    public int getWeight() {
      return 1;
    }
    
    public boolean isActive() {
      return true;
    }
    
    public boolean isLoading() {
      return false;
    }
    
    public void notifyNewValue(V param1V) {}
    
    public V waitForValue() {
      return get();
    }
  }
  
  static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {
    LocalCache.ReferenceEntry<K, V> nextWrite = LocalCache.nullEntry();
    
    LocalCache.ReferenceEntry<K, V> previousWrite = LocalCache.nullEntry();
    
    volatile long writeTime = Long.MAX_VALUE;
    
    StrongWriteEntry(K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1K, param1Int, param1ReferenceEntry);
    }
    
    public LocalCache.ReferenceEntry<K, V> getNextInWriteQueue() {
      return this.nextWrite;
    }
    
    public LocalCache.ReferenceEntry<K, V> getPreviousInWriteQueue() {
      return this.previousWrite;
    }
    
    public long getWriteTime() {
      return this.writeTime;
    }
    
    public void setNextInWriteQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.nextWrite = param1ReferenceEntry;
    }
    
    public void setPreviousInWriteQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.previousWrite = param1ReferenceEntry;
    }
    
    public void setWriteTime(long param1Long) {
      this.writeTime = param1Long;
    }
  }
  
  final class ValueIterator extends HashIterator<V> {
    public V next() {
      return nextEntry().getValue();
    }
  }
  
  static interface ValueReference<K, V> {
    ValueReference<K, V> copyFor(ReferenceQueue<V> param1ReferenceQueue, @Nullable V param1V, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry);
    
    @Nullable
    V get();
    
    @Nullable
    LocalCache.ReferenceEntry<K, V> getEntry();
    
    int getWeight();
    
    boolean isActive();
    
    boolean isLoading();
    
    void notifyNewValue(@Nullable V param1V);
    
    V waitForValue() throws ExecutionException;
  }
  
  final class Values extends AbstractCollection<V> {
    private final ConcurrentMap<?, ?> map;
    
    Values(ConcurrentMap<?, ?> param1ConcurrentMap) {
      this.map = param1ConcurrentMap;
    }
    
    public void clear() {
      this.map.clear();
    }
    
    public boolean contains(Object param1Object) {
      return this.map.containsValue(param1Object);
    }
    
    public boolean isEmpty() {
      return this.map.isEmpty();
    }
    
    public Iterator<V> iterator() {
      return new LocalCache.ValueIterator();
    }
    
    public int size() {
      return this.map.size();
    }
    
    public Object[] toArray() {
      return LocalCache.toArrayList(this).toArray();
    }
    
    public <E> E[] toArray(E[] param1ArrayOfE) {
      return (E[])LocalCache.toArrayList(this).toArray((Object[])param1ArrayOfE);
    }
  }
  
  static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {
    volatile long accessTime = Long.MAX_VALUE;
    
    LocalCache.ReferenceEntry<K, V> nextAccess = LocalCache.nullEntry();
    
    LocalCache.ReferenceEntry<K, V> previousAccess = LocalCache.nullEntry();
    
    WeakAccessEntry(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1ReferenceQueue, param1K, param1Int, param1ReferenceEntry);
    }
    
    public long getAccessTime() {
      return this.accessTime;
    }
    
    public LocalCache.ReferenceEntry<K, V> getNextInAccessQueue() {
      return this.nextAccess;
    }
    
    public LocalCache.ReferenceEntry<K, V> getPreviousInAccessQueue() {
      return this.previousAccess;
    }
    
    public void setAccessTime(long param1Long) {
      this.accessTime = param1Long;
    }
    
    public void setNextInAccessQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.nextAccess = param1ReferenceEntry;
    }
    
    public void setPreviousInAccessQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.previousAccess = param1ReferenceEntry;
    }
  }
  
  static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {
    volatile long accessTime = Long.MAX_VALUE;
    
    LocalCache.ReferenceEntry<K, V> nextAccess = LocalCache.nullEntry();
    
    LocalCache.ReferenceEntry<K, V> nextWrite = LocalCache.nullEntry();
    
    LocalCache.ReferenceEntry<K, V> previousAccess = LocalCache.nullEntry();
    
    LocalCache.ReferenceEntry<K, V> previousWrite = LocalCache.nullEntry();
    
    volatile long writeTime = Long.MAX_VALUE;
    
    WeakAccessWriteEntry(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1ReferenceQueue, param1K, param1Int, param1ReferenceEntry);
    }
    
    public long getAccessTime() {
      return this.accessTime;
    }
    
    public LocalCache.ReferenceEntry<K, V> getNextInAccessQueue() {
      return this.nextAccess;
    }
    
    public LocalCache.ReferenceEntry<K, V> getNextInWriteQueue() {
      return this.nextWrite;
    }
    
    public LocalCache.ReferenceEntry<K, V> getPreviousInAccessQueue() {
      return this.previousAccess;
    }
    
    public LocalCache.ReferenceEntry<K, V> getPreviousInWriteQueue() {
      return this.previousWrite;
    }
    
    public long getWriteTime() {
      return this.writeTime;
    }
    
    public void setAccessTime(long param1Long) {
      this.accessTime = param1Long;
    }
    
    public void setNextInAccessQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.nextAccess = param1ReferenceEntry;
    }
    
    public void setNextInWriteQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.nextWrite = param1ReferenceEntry;
    }
    
    public void setPreviousInAccessQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.previousAccess = param1ReferenceEntry;
    }
    
    public void setPreviousInWriteQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.previousWrite = param1ReferenceEntry;
    }
    
    public void setWriteTime(long param1Long) {
      this.writeTime = param1Long;
    }
  }
  
  static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
    final int hash;
    
    final LocalCache.ReferenceEntry<K, V> next;
    
    volatile LocalCache.ValueReference<K, V> valueReference = LocalCache.unset();
    
    WeakEntry(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1K, param1ReferenceQueue);
      this.hash = param1Int;
      this.next = param1ReferenceEntry;
    }
    
    public long getAccessTime() {
      throw new UnsupportedOperationException();
    }
    
    public int getHash() {
      return this.hash;
    }
    
    public K getKey() {
      return get();
    }
    
    public LocalCache.ReferenceEntry<K, V> getNext() {
      return this.next;
    }
    
    public LocalCache.ReferenceEntry<K, V> getNextInAccessQueue() {
      throw new UnsupportedOperationException();
    }
    
    public LocalCache.ReferenceEntry<K, V> getNextInWriteQueue() {
      throw new UnsupportedOperationException();
    }
    
    public LocalCache.ReferenceEntry<K, V> getPreviousInAccessQueue() {
      throw new UnsupportedOperationException();
    }
    
    public LocalCache.ReferenceEntry<K, V> getPreviousInWriteQueue() {
      throw new UnsupportedOperationException();
    }
    
    public LocalCache.ValueReference<K, V> getValueReference() {
      return this.valueReference;
    }
    
    public long getWriteTime() {
      throw new UnsupportedOperationException();
    }
    
    public void setAccessTime(long param1Long) {
      throw new UnsupportedOperationException();
    }
    
    public void setNextInAccessQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      throw new UnsupportedOperationException();
    }
    
    public void setNextInWriteQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      throw new UnsupportedOperationException();
    }
    
    public void setPreviousInAccessQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      throw new UnsupportedOperationException();
    }
    
    public void setPreviousInWriteQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      throw new UnsupportedOperationException();
    }
    
    public void setValueReference(LocalCache.ValueReference<K, V> param1ValueReference) {
      this.valueReference = param1ValueReference;
    }
    
    public void setWriteTime(long param1Long) {
      throw new UnsupportedOperationException();
    }
  }
  
  static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {
    final LocalCache.ReferenceEntry<K, V> entry;
    
    WeakValueReference(ReferenceQueue<V> param1ReferenceQueue, V param1V, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1V, param1ReferenceQueue);
      this.entry = param1ReferenceEntry;
    }
    
    public LocalCache.ValueReference<K, V> copyFor(ReferenceQueue<V> param1ReferenceQueue, V param1V, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      return new WeakValueReference(param1ReferenceQueue, param1V, param1ReferenceEntry);
    }
    
    public LocalCache.ReferenceEntry<K, V> getEntry() {
      return this.entry;
    }
    
    public int getWeight() {
      return 1;
    }
    
    public boolean isActive() {
      return true;
    }
    
    public boolean isLoading() {
      return false;
    }
    
    public void notifyNewValue(V param1V) {}
    
    public V waitForValue() {
      return get();
    }
  }
  
  static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {
    LocalCache.ReferenceEntry<K, V> nextWrite = LocalCache.nullEntry();
    
    LocalCache.ReferenceEntry<K, V> previousWrite = LocalCache.nullEntry();
    
    volatile long writeTime = Long.MAX_VALUE;
    
    WeakWriteEntry(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, @Nullable LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1ReferenceQueue, param1K, param1Int, param1ReferenceEntry);
    }
    
    public LocalCache.ReferenceEntry<K, V> getNextInWriteQueue() {
      return this.nextWrite;
    }
    
    public LocalCache.ReferenceEntry<K, V> getPreviousInWriteQueue() {
      return this.previousWrite;
    }
    
    public long getWriteTime() {
      return this.writeTime;
    }
    
    public void setNextInWriteQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.nextWrite = param1ReferenceEntry;
    }
    
    public void setPreviousInWriteQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.previousWrite = param1ReferenceEntry;
    }
    
    public void setWriteTime(long param1Long) {
      this.writeTime = param1Long;
    }
  }
  
  static final class WeightedSoftValueReference<K, V> extends SoftValueReference<K, V> {
    final int weight;
    
    WeightedSoftValueReference(ReferenceQueue<V> param1ReferenceQueue, V param1V, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry, int param1Int) {
      super(param1ReferenceQueue, param1V, param1ReferenceEntry);
      this.weight = param1Int;
    }
    
    public LocalCache.ValueReference<K, V> copyFor(ReferenceQueue<V> param1ReferenceQueue, V param1V, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      return new WeightedSoftValueReference(param1ReferenceQueue, param1V, param1ReferenceEntry, this.weight);
    }
    
    public int getWeight() {
      return this.weight;
    }
  }
  
  static final class WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {
    final int weight;
    
    WeightedStrongValueReference(V param1V, int param1Int) {
      super(param1V);
      this.weight = param1Int;
    }
    
    public int getWeight() {
      return this.weight;
    }
  }
  
  static final class WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {
    final int weight;
    
    WeightedWeakValueReference(ReferenceQueue<V> param1ReferenceQueue, V param1V, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry, int param1Int) {
      super(param1ReferenceQueue, param1V, param1ReferenceEntry);
      this.weight = param1Int;
    }
    
    public LocalCache.ValueReference<K, V> copyFor(ReferenceQueue<V> param1ReferenceQueue, V param1V, LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      return new WeightedWeakValueReference(param1ReferenceQueue, param1V, param1ReferenceEntry, this.weight);
    }
    
    public int getWeight() {
      return this.weight;
    }
  }
  
  static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
    final LocalCache.ReferenceEntry<K, V> head = new LocalCache.AbstractReferenceEntry<K, V>() {
        LocalCache.ReferenceEntry<K, V> nextWrite = this;
        
        LocalCache.ReferenceEntry<K, V> previousWrite = this;
        
        public LocalCache.ReferenceEntry<K, V> getNextInWriteQueue() {
          return this.nextWrite;
        }
        
        public LocalCache.ReferenceEntry<K, V> getPreviousInWriteQueue() {
          return this.previousWrite;
        }
        
        public long getWriteTime() {
          return Long.MAX_VALUE;
        }
        
        public void setNextInWriteQueue(LocalCache.ReferenceEntry<K, V> param2ReferenceEntry) {
          this.nextWrite = param2ReferenceEntry;
        }
        
        public void setPreviousInWriteQueue(LocalCache.ReferenceEntry<K, V> param2ReferenceEntry) {
          this.previousWrite = param2ReferenceEntry;
        }
        
        public void setWriteTime(long param2Long) {}
      };
    
    public void clear() {
      LocalCache.ReferenceEntry<K, V> referenceEntry = this.head.getNextInWriteQueue();
      while (true) {
        LocalCache.ReferenceEntry<K, V> referenceEntry1 = this.head;
        if (referenceEntry != referenceEntry1) {
          referenceEntry1 = referenceEntry.getNextInWriteQueue();
          LocalCache.nullifyWriteOrder(referenceEntry);
          referenceEntry = referenceEntry1;
          continue;
        } 
        referenceEntry1.setNextInWriteQueue(referenceEntry1);
        referenceEntry = this.head;
        referenceEntry.setPreviousInWriteQueue(referenceEntry);
        return;
      } 
    }
    
    public boolean contains(Object param1Object) {
      boolean bool;
      if (((LocalCache.ReferenceEntry)param1Object).getNextInWriteQueue() != LocalCache.NullEntry.INSTANCE) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean isEmpty() {
      boolean bool;
      if (this.head.getNextInWriteQueue() == this.head) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public Iterator<LocalCache.ReferenceEntry<K, V>> iterator() {
      return (Iterator<LocalCache.ReferenceEntry<K, V>>)new AbstractSequentialIterator<LocalCache.ReferenceEntry<K, V>>(peek()) {
          protected LocalCache.ReferenceEntry<K, V> computeNext(LocalCache.ReferenceEntry<K, V> param2ReferenceEntry) {
            LocalCache.ReferenceEntry<K, V> referenceEntry = param2ReferenceEntry.getNextInWriteQueue();
            param2ReferenceEntry = referenceEntry;
            if (referenceEntry == LocalCache.WriteQueue.this.head)
              param2ReferenceEntry = null; 
            return param2ReferenceEntry;
          }
        };
    }
    
    public boolean offer(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      LocalCache.connectWriteOrder(param1ReferenceEntry.getPreviousInWriteQueue(), param1ReferenceEntry.getNextInWriteQueue());
      LocalCache.connectWriteOrder(this.head.getPreviousInWriteQueue(), param1ReferenceEntry);
      LocalCache.connectWriteOrder(param1ReferenceEntry, this.head);
      return true;
    }
    
    public LocalCache.ReferenceEntry<K, V> peek() {
      LocalCache.ReferenceEntry<K, V> referenceEntry1 = this.head.getNextInWriteQueue();
      LocalCache.ReferenceEntry<K, V> referenceEntry2 = referenceEntry1;
      if (referenceEntry1 == this.head)
        referenceEntry2 = null; 
      return referenceEntry2;
    }
    
    public LocalCache.ReferenceEntry<K, V> poll() {
      LocalCache.ReferenceEntry<K, V> referenceEntry = this.head.getNextInWriteQueue();
      if (referenceEntry == this.head)
        return null; 
      remove(referenceEntry);
      return referenceEntry;
    }
    
    public boolean remove(Object param1Object) {
      boolean bool;
      param1Object = param1Object;
      LocalCache.ReferenceEntry<?, ?> referenceEntry1 = param1Object.getPreviousInWriteQueue();
      LocalCache.ReferenceEntry<?, ?> referenceEntry2 = param1Object.getNextInWriteQueue();
      LocalCache.connectWriteOrder(referenceEntry1, referenceEntry2);
      LocalCache.nullifyWriteOrder((LocalCache.ReferenceEntry<?, ?>)param1Object);
      if (referenceEntry2 != LocalCache.NullEntry.INSTANCE) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int size() {
      LocalCache.ReferenceEntry<K, V> referenceEntry = this.head.getNextInWriteQueue();
      byte b = 0;
      while (referenceEntry != this.head) {
        b++;
        referenceEntry = referenceEntry.getNextInWriteQueue();
      } 
      return b;
    }
  }
  
  class null extends AbstractReferenceEntry<K, V> {
    LocalCache.ReferenceEntry<K, V> nextWrite = this;
    
    LocalCache.ReferenceEntry<K, V> previousWrite = this;
    
    public LocalCache.ReferenceEntry<K, V> getNextInWriteQueue() {
      return this.nextWrite;
    }
    
    public LocalCache.ReferenceEntry<K, V> getPreviousInWriteQueue() {
      return this.previousWrite;
    }
    
    public long getWriteTime() {
      return Long.MAX_VALUE;
    }
    
    public void setNextInWriteQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.nextWrite = param1ReferenceEntry;
    }
    
    public void setPreviousInWriteQueue(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      this.previousWrite = param1ReferenceEntry;
    }
    
    public void setWriteTime(long param1Long) {}
  }
  
  class null extends AbstractSequentialIterator<ReferenceEntry<K, V>> {
    null(LocalCache.ReferenceEntry param1ReferenceEntry) {
      super(param1ReferenceEntry);
    }
    
    protected LocalCache.ReferenceEntry<K, V> computeNext(LocalCache.ReferenceEntry<K, V> param1ReferenceEntry) {
      LocalCache.ReferenceEntry<K, V> referenceEntry = param1ReferenceEntry.getNextInWriteQueue();
      param1ReferenceEntry = referenceEntry;
      if (referenceEntry == this.this$0.head)
        param1ReferenceEntry = null; 
      return param1ReferenceEntry;
    }
  }
  
  final class WriteThroughEntry implements Map.Entry<K, V> {
    final K key;
    
    V value;
    
    WriteThroughEntry(K param1K, V param1V) {
      this.key = param1K;
      this.value = param1V;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof Map.Entry;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (this.key.equals(param1Object.getKey())) {
          bool = bool1;
          if (this.value.equals(param1Object.getValue()))
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public K getKey() {
      return this.key;
    }
    
    public V getValue() {
      return this.value;
    }
    
    public int hashCode() {
      return this.key.hashCode() ^ this.value.hashCode();
    }
    
    public V setValue(V param1V) {
      V v = (V)LocalCache.this.put(this.key, (Object)param1V);
      this.value = param1V;
      return v;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getKey());
      stringBuilder.append("=");
      stringBuilder.append(getValue());
      return stringBuilder.toString();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\cache\LocalCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */