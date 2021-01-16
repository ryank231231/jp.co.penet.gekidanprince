package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

@GwtIncompatible
class MapMakerInternalMap<K, V, E extends MapMakerInternalMap.InternalEntry<K, V, E>, S extends MapMakerInternalMap.Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
  static final long CLEANUP_EXECUTOR_DELAY_SECS = 60L;
  
  static final int CONTAINS_VALUE_RETRIES = 3;
  
  static final int DRAIN_MAX = 16;
  
  static final int DRAIN_THRESHOLD = 63;
  
  static final int MAXIMUM_CAPACITY = 1073741824;
  
  static final int MAX_SEGMENTS = 65536;
  
  static final WeakValueReference<Object, Object, DummyInternalEntry> UNSET_WEAK_VALUE_REFERENCE = new WeakValueReference<Object, Object, DummyInternalEntry>() {
      public void clear() {}
      
      public MapMakerInternalMap.WeakValueReference<Object, Object, MapMakerInternalMap.DummyInternalEntry> copyFor(ReferenceQueue<Object> param1ReferenceQueue, MapMakerInternalMap.DummyInternalEntry param1DummyInternalEntry) {
        return this;
      }
      
      public Object get() {
        return null;
      }
      
      public MapMakerInternalMap.DummyInternalEntry getEntry() {
        return null;
      }
    };
  
  private static final long serialVersionUID = 5L;
  
  final int concurrencyLevel;
  
  final transient InternalEntryHelper<K, V, E, S> entryHelper;
  
  transient Set<Map.Entry<K, V>> entrySet;
  
  final Equivalence<Object> keyEquivalence;
  
  transient Set<K> keySet;
  
  final transient int segmentMask;
  
  final transient int segmentShift;
  
  final transient Segment<K, V, E, S>[] segments;
  
  transient Collection<V> values;
  
  private MapMakerInternalMap(MapMaker paramMapMaker, InternalEntryHelper<K, V, E, S> paramInternalEntryHelper) {
    this.concurrencyLevel = Math.min(paramMapMaker.getConcurrencyLevel(), 65536);
    this.keyEquivalence = paramMapMaker.getKeyEquivalence();
    this.entryHelper = paramInternalEntryHelper;
    int i = Math.min(paramMapMaker.getInitialCapacity(), 1073741824);
    boolean bool = false;
    byte b = 1;
    int j = 1;
    int k = 0;
    while (j < this.concurrencyLevel) {
      k++;
      j <<= 1;
    } 
    this.segmentShift = 32 - k;
    this.segmentMask = j - 1;
    this.segments = newSegmentArray(j);
    int m = i / j;
    int n = b;
    k = m;
    if (j * m < i) {
      k = m + 1;
      n = b;
    } 
    while (true) {
      j = bool;
      if (n < k) {
        n <<= 1;
        continue;
      } 
      break;
    } 
    while (true) {
      Segment<K, V, E, S>[] arrayOfSegment = this.segments;
      if (j < arrayOfSegment.length) {
        arrayOfSegment[j] = createSegment(n, -1);
        j++;
        continue;
      } 
      break;
    } 
  }
  
  static <K, V> MapMakerInternalMap<K, V, ? extends InternalEntry<K, V, ?>, ?> create(MapMaker paramMapMaker) {
    if (paramMapMaker.getKeyStrength() == Strength.STRONG && paramMapMaker.getValueStrength() == Strength.STRONG)
      return new MapMakerInternalMap<K, V, InternalEntry<K, V, ?>, Object>(paramMapMaker, (InternalEntryHelper)StrongKeyStrongValueEntry.Helper.instance()); 
    if (paramMapMaker.getKeyStrength() == Strength.STRONG && paramMapMaker.getValueStrength() == Strength.WEAK)
      return new MapMakerInternalMap<K, V, InternalEntry<K, V, ?>, Object>(paramMapMaker, (InternalEntryHelper)StrongKeyWeakValueEntry.Helper.instance()); 
    if (paramMapMaker.getKeyStrength() == Strength.WEAK && paramMapMaker.getValueStrength() == Strength.STRONG)
      return new MapMakerInternalMap<K, V, InternalEntry<K, V, ?>, Object>(paramMapMaker, (InternalEntryHelper)WeakKeyStrongValueEntry.Helper.instance()); 
    if (paramMapMaker.getKeyStrength() == Strength.WEAK && paramMapMaker.getValueStrength() == Strength.WEAK)
      return new MapMakerInternalMap<K, V, InternalEntry<K, V, ?>, Object>(paramMapMaker, (InternalEntryHelper)WeakKeyWeakValueEntry.Helper.instance()); 
    throw new AssertionError();
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
    ArrayList<?> arrayList = new ArrayList(paramCollection.size());
    Iterators.addAll(arrayList, paramCollection.iterator());
    return (ArrayList)arrayList;
  }
  
  static <K, V, E extends InternalEntry<K, V, E>> WeakValueReference<K, V, E> unsetWeakValueReference() {
    return (WeakValueReference)UNSET_WEAK_VALUE_REFERENCE;
  }
  
  public void clear() {
    Segment<K, V, E, S>[] arrayOfSegment = this.segments;
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
    Segment<K, V, E, S>[] arrayOfSegment = this.segments;
    long l = -1L;
    byte b = 0;
    while (b < 3) {
      int i = arrayOfSegment.length;
      long l1 = 0L;
      for (byte b1 = 0; b1 < i; b1++) {
        Segment<K, V, E, S> segment = arrayOfSegment[b1];
        int j = segment.count;
        AtomicReferenceArray<E> atomicReferenceArray = segment.table;
        for (j = 0; j < atomicReferenceArray.length(); j++) {
          for (InternalEntry internalEntry = (InternalEntry)atomicReferenceArray.get(j); internalEntry != null; internalEntry = (InternalEntry)internalEntry.getNext()) {
            V v = segment.getLiveValue((E)internalEntry);
            if (v != null && valueEquivalence().equivalent(paramObject, v))
              return true; 
          } 
        } 
        l1 += segment.modCount;
      } 
      if (l1 == l)
        break; 
      b++;
      l = l1;
    } 
    return false;
  }
  
  @VisibleForTesting
  E copyEntry(E paramE1, E paramE2) {
    return segmentFor(paramE1.getHash()).copyEntry(paramE1, paramE2);
  }
  
  Segment<K, V, E, S> createSegment(int paramInt1, int paramInt2) {
    return (Segment<K, V, E, S>)this.entryHelper.newSegment(this, paramInt1, paramInt2);
  }
  
  public Set<Map.Entry<K, V>> entrySet() {
    Set<Map.Entry<K, V>> set = this.entrySet;
    if (set == null) {
      set = new EntrySet();
      this.entrySet = set;
    } 
    return set;
  }
  
  public V get(@Nullable Object paramObject) {
    if (paramObject == null)
      return null; 
    int i = hash(paramObject);
    return segmentFor(i).get(paramObject, i);
  }
  
  E getEntry(@Nullable Object paramObject) {
    if (paramObject == null)
      return null; 
    int i = hash(paramObject);
    return segmentFor(i).getEntry(paramObject, i);
  }
  
  V getLiveValue(E paramE) {
    if (paramE.getKey() == null)
      return null; 
    paramE = (E)paramE.getValue();
    return (V)((paramE == null) ? null : paramE);
  }
  
  int hash(Object paramObject) {
    return rehash(this.keyEquivalence.hash(paramObject));
  }
  
  public boolean isEmpty() {
    Segment<K, V, E, S>[] arrayOfSegment = this.segments;
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
  
  @VisibleForTesting
  boolean isLiveForTesting(InternalEntry<K, V, ?> paramInternalEntry) {
    boolean bool;
    if (segmentFor(paramInternalEntry.getHash()).getLiveValueForTesting(paramInternalEntry) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Set<K> keySet() {
    Set<K> set = this.keySet;
    if (set == null) {
      set = new KeySet();
      this.keySet = set;
    } 
    return set;
  }
  
  @VisibleForTesting
  Strength keyStrength() {
    return this.entryHelper.keyStrength();
  }
  
  final Segment<K, V, E, S>[] newSegmentArray(int paramInt) {
    return (Segment<K, V, E, S>[])new Segment[paramInt];
  }
  
  @CanIgnoreReturnValue
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
  
  @CanIgnoreReturnValue
  public V putIfAbsent(K paramK, V paramV) {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV);
    int i = hash(paramK);
    return segmentFor(i).put(paramK, i, paramV, true);
  }
  
  void reclaimKey(E paramE) {
    int i = paramE.getHash();
    segmentFor(i).reclaimKey(paramE, i);
  }
  
  void reclaimValue(WeakValueReference<K, V, E> paramWeakValueReference) {
    E e = paramWeakValueReference.getEntry();
    int i = e.getHash();
    segmentFor(i).reclaimValue((K)e.getKey(), i, paramWeakValueReference);
  }
  
  @CanIgnoreReturnValue
  public V remove(@Nullable Object paramObject) {
    if (paramObject == null)
      return null; 
    int i = hash(paramObject);
    return segmentFor(i).remove(paramObject, i);
  }
  
  @CanIgnoreReturnValue
  public boolean remove(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    if (paramObject1 == null || paramObject2 == null)
      return false; 
    int i = hash(paramObject1);
    return segmentFor(i).remove(paramObject1, i, paramObject2);
  }
  
  @CanIgnoreReturnValue
  public V replace(K paramK, V paramV) {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV);
    int i = hash(paramK);
    return segmentFor(i).replace(paramK, i, paramV);
  }
  
  @CanIgnoreReturnValue
  public boolean replace(K paramK, @Nullable V paramV1, V paramV2) {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV2);
    if (paramV1 == null)
      return false; 
    int i = hash(paramK);
    return segmentFor(i).replace(paramK, i, paramV1, paramV2);
  }
  
  Segment<K, V, E, S> segmentFor(int paramInt) {
    return this.segments[paramInt >>> this.segmentShift & this.segmentMask];
  }
  
  public int size() {
    Segment<K, V, E, S>[] arrayOfSegment = this.segments;
    long l = 0L;
    for (byte b = 0; b < arrayOfSegment.length; b++)
      l += (arrayOfSegment[b]).count; 
    return Ints.saturatedCast(l);
  }
  
  @VisibleForTesting
  Equivalence<Object> valueEquivalence() {
    return this.entryHelper.valueStrength().defaultEquivalence();
  }
  
  @VisibleForTesting
  Strength valueStrength() {
    return this.entryHelper.valueStrength();
  }
  
  public Collection<V> values() {
    Collection<V> collection = this.values;
    if (collection == null) {
      collection = new Values();
      this.values = collection;
    } 
    return collection;
  }
  
  Object writeReplace() {
    return new SerializationProxy<Object, Object>(this.entryHelper.keyStrength(), this.entryHelper.valueStrength(), this.keyEquivalence, this.entryHelper.valueStrength().defaultEquivalence(), this.concurrencyLevel, this);
  }
  
  static abstract class AbstractSerializationProxy<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
    private static final long serialVersionUID = 3L;
    
    final int concurrencyLevel;
    
    transient ConcurrentMap<K, V> delegate;
    
    final Equivalence<Object> keyEquivalence;
    
    final MapMakerInternalMap.Strength keyStrength;
    
    final Equivalence<Object> valueEquivalence;
    
    final MapMakerInternalMap.Strength valueStrength;
    
    AbstractSerializationProxy(MapMakerInternalMap.Strength param1Strength1, MapMakerInternalMap.Strength param1Strength2, Equivalence<Object> param1Equivalence1, Equivalence<Object> param1Equivalence2, int param1Int, ConcurrentMap<K, V> param1ConcurrentMap) {
      this.keyStrength = param1Strength1;
      this.valueStrength = param1Strength2;
      this.keyEquivalence = param1Equivalence1;
      this.valueEquivalence = param1Equivalence2;
      this.concurrencyLevel = param1Int;
      this.delegate = param1ConcurrentMap;
    }
    
    protected ConcurrentMap<K, V> delegate() {
      return this.delegate;
    }
    
    void readEntries(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
      while (true) {
        Object object1 = param1ObjectInputStream.readObject();
        if (object1 == null)
          return; 
        Object object2 = param1ObjectInputStream.readObject();
        this.delegate.put((K)object1, (V)object2);
      } 
    }
    
    MapMaker readMapMaker(ObjectInputStream param1ObjectInputStream) throws IOException {
      int i = param1ObjectInputStream.readInt();
      return (new MapMaker()).initialCapacity(i).setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).concurrencyLevel(this.concurrencyLevel);
    }
    
    void writeMapTo(ObjectOutputStream param1ObjectOutputStream) throws IOException {
      param1ObjectOutputStream.writeInt(this.delegate.size());
      for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
        param1ObjectOutputStream.writeObject(entry.getKey());
        param1ObjectOutputStream.writeObject(entry.getValue());
      } 
      param1ObjectOutputStream.writeObject(null);
    }
  }
  
  static abstract class AbstractStrongKeyEntry<K, V, E extends InternalEntry<K, V, E>> implements InternalEntry<K, V, E> {
    final int hash;
    
    final K key;
    
    final E next;
    
    AbstractStrongKeyEntry(K param1K, int param1Int, @Nullable E param1E) {
      this.key = param1K;
      this.hash = param1Int;
      this.next = param1E;
    }
    
    public int getHash() {
      return this.hash;
    }
    
    public K getKey() {
      return this.key;
    }
    
    public E getNext() {
      return this.next;
    }
  }
  
  static abstract class AbstractWeakKeyEntry<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<K> implements InternalEntry<K, V, E> {
    final int hash;
    
    final E next;
    
    AbstractWeakKeyEntry(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, @Nullable E param1E) {
      super(param1K, param1ReferenceQueue);
      this.hash = param1Int;
      this.next = param1E;
    }
    
    public int getHash() {
      return this.hash;
    }
    
    public K getKey() {
      return get();
    }
    
    public E getNext() {
      return this.next;
    }
  }
  
  static final class CleanupMapTask implements Runnable {
    final WeakReference<MapMakerInternalMap<?, ?, ?, ?>> mapReference;
    
    public CleanupMapTask(MapMakerInternalMap<?, ?, ?, ?> param1MapMakerInternalMap) {
      this.mapReference = new WeakReference<MapMakerInternalMap<?, ?, ?, ?>>(param1MapMakerInternalMap);
    }
    
    public void run() {
      MapMakerInternalMap mapMakerInternalMap = this.mapReference.get();
      if (mapMakerInternalMap != null) {
        MapMakerInternalMap.Segment[] arrayOfSegment = mapMakerInternalMap.segments;
        int i = arrayOfSegment.length;
        for (byte b = 0; b < i; b++)
          arrayOfSegment[b].runCleanup(); 
        return;
      } 
      throw new CancellationException();
    }
  }
  
  static final class DummyInternalEntry implements InternalEntry<Object, Object, DummyInternalEntry> {
    private DummyInternalEntry() {
      throw new AssertionError();
    }
    
    public int getHash() {
      throw new AssertionError();
    }
    
    public Object getKey() {
      throw new AssertionError();
    }
    
    public DummyInternalEntry getNext() {
      throw new AssertionError();
    }
    
    public Object getValue() {
      throw new AssertionError();
    }
  }
  
  final class EntryIterator extends HashIterator<Map.Entry<K, V>> {
    public Map.Entry<K, V> next() {
      return nextEntry();
    }
  }
  
  final class EntrySet extends SafeToArraySet<Map.Entry<K, V>> {
    public void clear() {
      MapMakerInternalMap.this.clear();
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
      object = MapMakerInternalMap.this.get(object);
      bool = bool1;
      if (object != null) {
        bool = bool1;
        if (MapMakerInternalMap.this.valueEquivalence().equivalent(param1Object.getValue(), object))
          bool = true; 
      } 
      return bool;
    }
    
    public boolean isEmpty() {
      return MapMakerInternalMap.this.isEmpty();
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return new MapMakerInternalMap.EntryIterator();
    }
    
    public boolean remove(Object param1Object) {
      boolean bool = param1Object instanceof Map.Entry;
      boolean bool1 = false;
      if (!bool)
        return false; 
      param1Object = param1Object;
      Object object = param1Object.getKey();
      bool = bool1;
      if (object != null) {
        bool = bool1;
        if (MapMakerInternalMap.this.remove(object, param1Object.getValue()))
          bool = true; 
      } 
      return bool;
    }
    
    public int size() {
      return MapMakerInternalMap.this.size();
    }
  }
  
  abstract class HashIterator<T> implements Iterator<T> {
    MapMakerInternalMap.Segment<K, V, E, S> currentSegment;
    
    AtomicReferenceArray<E> currentTable;
    
    MapMakerInternalMap<K, V, E, S>.WriteThroughEntry lastReturned;
    
    E nextEntry;
    
    MapMakerInternalMap<K, V, E, S>.WriteThroughEntry nextExternal;
    
    int nextSegmentIndex = MapMakerInternalMap.this.segments.length - 1;
    
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
        MapMakerInternalMap.Segment[] arrayOfSegment = MapMakerInternalMap.this.segments;
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
    
    boolean advanceTo(E param1E) {
      try {
        Object object = param1E.getKey();
        param1E = (E)MapMakerInternalMap.this.getLiveValue(param1E);
        if (param1E != null) {
          MapMakerInternalMap.WriteThroughEntry writeThroughEntry = new MapMakerInternalMap.WriteThroughEntry();
          this((K)object, (V)param1E);
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
    
    MapMakerInternalMap<K, V, E, S>.WriteThroughEntry nextEntry() {
      MapMakerInternalMap<K, V, E, S>.WriteThroughEntry writeThroughEntry = this.nextExternal;
      if (writeThroughEntry != null) {
        this.lastReturned = writeThroughEntry;
        advance();
        return this.lastReturned;
      } 
      throw new NoSuchElementException();
    }
    
    boolean nextInChain() {
      E e = this.nextEntry;
      if (e != null)
        while (true) {
          this.nextEntry = (E)e.getNext();
          e = this.nextEntry;
          if (e != null) {
            if (advanceTo(e))
              return true; 
            e = this.nextEntry;
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
          AtomicReferenceArray<E> atomicReferenceArray = this.currentTable;
          this.nextTableIndex = i - 1;
          MapMakerInternalMap.InternalEntry internalEntry = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(i);
          this.nextEntry = (E)internalEntry;
          if (internalEntry != null) {
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
      CollectPreconditions.checkRemove(bool);
      MapMakerInternalMap.this.remove(this.lastReturned.getKey());
      this.lastReturned = null;
    }
  }
  
  static interface InternalEntry<K, V, E extends InternalEntry<K, V, E>> {
    int getHash();
    
    K getKey();
    
    E getNext();
    
    V getValue();
  }
  
  static interface InternalEntryHelper<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> {
    E copy(S param1S, E param1E1, @Nullable E param1E2);
    
    MapMakerInternalMap.Strength keyStrength();
    
    E newEntry(S param1S, K param1K, int param1Int, @Nullable E param1E);
    
    S newSegment(MapMakerInternalMap<K, V, E, S> param1MapMakerInternalMap, int param1Int1, int param1Int2);
    
    void setValue(S param1S, E param1E, V param1V);
    
    MapMakerInternalMap.Strength valueStrength();
  }
  
  final class KeyIterator extends HashIterator<K> {
    public K next() {
      return nextEntry().getKey();
    }
  }
  
  final class KeySet extends SafeToArraySet<K> {
    public void clear() {
      MapMakerInternalMap.this.clear();
    }
    
    public boolean contains(Object param1Object) {
      return MapMakerInternalMap.this.containsKey(param1Object);
    }
    
    public boolean isEmpty() {
      return MapMakerInternalMap.this.isEmpty();
    }
    
    public Iterator<K> iterator() {
      return new MapMakerInternalMap.KeyIterator();
    }
    
    public boolean remove(Object param1Object) {
      boolean bool;
      if (MapMakerInternalMap.this.remove(param1Object) != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int size() {
      return MapMakerInternalMap.this.size();
    }
  }
  
  private static abstract class SafeToArraySet<E> extends AbstractSet<E> {
    private SafeToArraySet() {}
    
    public Object[] toArray() {
      return MapMakerInternalMap.toArrayList(this).toArray();
    }
    
    public <E> E[] toArray(E[] param1ArrayOfE) {
      return (E[])MapMakerInternalMap.toArrayList(this).toArray((Object[])param1ArrayOfE);
    }
  }
  
  static abstract class Segment<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
    volatile int count;
    
    @Weak
    final MapMakerInternalMap<K, V, E, S> map;
    
    final int maxSegmentSize;
    
    int modCount;
    
    final AtomicInteger readCount = new AtomicInteger();
    
    volatile AtomicReferenceArray<E> table;
    
    int threshold;
    
    Segment(MapMakerInternalMap<K, V, E, S> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      this.map = param1MapMakerInternalMap;
      this.maxSegmentSize = param1Int2;
      initTable(newEntryArray(param1Int1));
    }
    
    static <K, V, E extends MapMakerInternalMap.InternalEntry<K, V, E>> boolean isCollected(E param1E) {
      boolean bool;
      if (param1E.getValue() == null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    abstract E castForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry);
    
    void clear() {
      if (this.count != 0) {
        lock();
        try {
          AtomicReferenceArray<E> atomicReferenceArray = this.table;
          for (byte b = 0; b < atomicReferenceArray.length(); b++)
            atomicReferenceArray.set(b, null); 
          maybeClearReferenceQueues();
          this.readCount.set(0);
          this.modCount++;
          this.count = 0;
        } finally {
          unlock();
        } 
      } 
    }
    
    <T> void clearReferenceQueue(ReferenceQueue<T> param1ReferenceQueue) {
      while (param1ReferenceQueue.poll() != null);
    }
    
    @CanIgnoreReturnValue
    boolean clearValueForTesting(K param1K, int param1Int, MapMakerInternalMap.WeakValueReference<K, V, ? extends MapMakerInternalMap.InternalEntry<K, V, ?>> param1WeakValueReference) {
      lock();
      try {
        AtomicReferenceArray<E> atomicReferenceArray = this.table;
        int i = atomicReferenceArray.length() - 1 & param1Int;
        MapMakerInternalMap.InternalEntry internalEntry1 = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(i);
        for (MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry1; internalEntry2 != null; internalEntry2 = (MapMakerInternalMap.InternalEntry)internalEntry2.getNext()) {
          Object object = internalEntry2.getKey();
          if (internalEntry2.getHash() == param1Int && object != null && this.map.keyEquivalence.equivalent(param1K, object)) {
            if (((MapMakerInternalMap.WeakValueEntry<K, V, ? extends MapMakerInternalMap.InternalEntry<K, V, ?>>)internalEntry2).getValueReference() == param1WeakValueReference) {
              atomicReferenceArray.set(i, removeFromChain((E)internalEntry1, (E)internalEntry2));
              return true;
            } 
            return false;
          } 
        } 
        return false;
      } finally {
        unlock();
      } 
    }
    
    boolean containsKey(Object param1Object, int param1Int) {
      try {
        int i = this.count;
        boolean bool = false;
        if (i != 0) {
          param1Object = getLiveEntry(param1Object, param1Int);
          boolean bool1 = bool;
          if (param1Object != null) {
            param1Object = param1Object.getValue();
            bool1 = bool;
            if (param1Object != null)
              bool1 = true; 
          } 
          return bool1;
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
          AtomicReferenceArray<E> atomicReferenceArray = this.table;
          int i = atomicReferenceArray.length();
          for (byte b = 0; b < i; b++) {
            for (MapMakerInternalMap.InternalEntry internalEntry = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(b); internalEntry != null; internalEntry = (MapMakerInternalMap.InternalEntry)internalEntry.getNext()) {
              V v = getLiveValue((E)internalEntry);
              if (v != null) {
                boolean bool = this.map.valueEquivalence().equivalent(param1Object, v);
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
    
    E copyEntry(E param1E1, E param1E2) {
      return this.map.entryHelper.copy(self(), param1E1, param1E2);
    }
    
    E copyForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry1, @Nullable MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry2) {
      return this.map.entryHelper.copy(self(), castForTesting(param1InternalEntry1), castForTesting(param1InternalEntry2));
    }
    
    @GuardedBy("this")
    void drainKeyReferenceQueue(ReferenceQueue<K> param1ReferenceQueue) {
      int i = 0;
      while (true) {
        Reference<? extends K> reference = param1ReferenceQueue.poll();
        if (reference != null) {
          MapMakerInternalMap.InternalEntry internalEntry = (MapMakerInternalMap.InternalEntry)reference;
          this.map.reclaimKey((E)internalEntry);
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
    void drainValueReferenceQueue(ReferenceQueue<V> param1ReferenceQueue) {
      int i = 0;
      while (true) {
        Reference<? extends V> reference = param1ReferenceQueue.poll();
        if (reference != null) {
          MapMakerInternalMap.WeakValueReference<K, V, E> weakValueReference = (MapMakerInternalMap.WeakValueReference)reference;
          this.map.reclaimValue(weakValueReference);
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
    void expand() {
      AtomicReferenceArray<E> atomicReferenceArray1 = this.table;
      int i = atomicReferenceArray1.length();
      if (i >= 1073741824)
        return; 
      int j = this.count;
      AtomicReferenceArray<E> atomicReferenceArray2 = newEntryArray(i << 1);
      this.threshold = atomicReferenceArray2.length() * 3 / 4;
      int k = atomicReferenceArray2.length() - 1;
      byte b = 0;
      while (b < i) {
        MapMakerInternalMap.InternalEntry internalEntry = (MapMakerInternalMap.InternalEntry)atomicReferenceArray1.get(b);
        int m = j;
        if (internalEntry != null) {
          Object object = internalEntry.getNext();
          m = internalEntry.getHash() & k;
          if (object == null) {
            atomicReferenceArray2.set(m, (E)internalEntry);
            m = j;
          } else {
            Object object1 = internalEntry;
            while (object != null) {
              int n = object.getHash() & k;
              int i1 = m;
              if (n != m) {
                object1 = object;
                i1 = n;
              } 
              object = object.getNext();
              m = i1;
            } 
            atomicReferenceArray2.set(m, (E)object1);
            while (true) {
              m = j;
              if (internalEntry != object1) {
                m = internalEntry.getHash() & k;
                object = copyEntry((E)internalEntry, atomicReferenceArray2.get(m));
                if (object != null) {
                  atomicReferenceArray2.set(m, (E)object);
                } else {
                  j--;
                } 
                internalEntry = (MapMakerInternalMap.InternalEntry)internalEntry.getNext();
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
    
    V get(Object param1Object, int param1Int) {
      try {
        param1Object = getLiveEntry(param1Object, param1Int);
        if (param1Object == null)
          return null; 
        param1Object = param1Object.getValue();
        if (param1Object == null)
          tryDrainReferenceQueues(); 
        return (V)param1Object;
      } finally {
        postReadCleanup();
      } 
    }
    
    E getEntry(Object param1Object, int param1Int) {
      if (this.count != 0)
        for (E e = getFirst(param1Int); e != null; e = (E)e.getNext()) {
          if (e.getHash() == param1Int) {
            Object object = e.getKey();
            if (object == null) {
              tryDrainReferenceQueues();
            } else if (this.map.keyEquivalence.equivalent(param1Object, object)) {
              return e;
            } 
          } 
        }  
      return null;
    }
    
    E getFirst(int param1Int) {
      AtomicReferenceArray<E> atomicReferenceArray = this.table;
      return atomicReferenceArray.get(param1Int & atomicReferenceArray.length() - 1);
    }
    
    ReferenceQueue<K> getKeyReferenceQueueForTesting() {
      throw new AssertionError();
    }
    
    E getLiveEntry(Object param1Object, int param1Int) {
      return getEntry(param1Object, param1Int);
    }
    
    @Nullable
    V getLiveValue(E param1E) {
      if (param1E.getKey() == null) {
        tryDrainReferenceQueues();
        return null;
      } 
      param1E = (E)param1E.getValue();
      if (param1E == null) {
        tryDrainReferenceQueues();
        return null;
      } 
      return (V)param1E;
    }
    
    @Nullable
    V getLiveValueForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry) {
      return getLiveValue(castForTesting(param1InternalEntry));
    }
    
    ReferenceQueue<V> getValueReferenceQueueForTesting() {
      throw new AssertionError();
    }
    
    MapMakerInternalMap.WeakValueReference<K, V, E> getWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry) {
      throw new AssertionError();
    }
    
    void initTable(AtomicReferenceArray<E> param1AtomicReferenceArray) {
      this.threshold = param1AtomicReferenceArray.length() * 3 / 4;
      int i = this.threshold;
      if (i == this.maxSegmentSize)
        this.threshold = i + 1; 
      this.table = param1AtomicReferenceArray;
    }
    
    void maybeClearReferenceQueues() {}
    
    @GuardedBy("this")
    void maybeDrainReferenceQueues() {}
    
    AtomicReferenceArray<E> newEntryArray(int param1Int) {
      return new AtomicReferenceArray<E>(param1Int);
    }
    
    E newEntryForTesting(K param1K, int param1Int, @Nullable MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry) {
      return this.map.entryHelper.newEntry(self(), param1K, param1Int, castForTesting(param1InternalEntry));
    }
    
    MapMakerInternalMap.WeakValueReference<K, V, E> newWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry, V param1V) {
      throw new AssertionError();
    }
    
    void postReadCleanup() {
      if ((this.readCount.incrementAndGet() & 0x3F) == 0)
        runCleanup(); 
    }
    
    @GuardedBy("this")
    void preWriteCleanup() {
      runLockedCleanup();
    }
    
    V put(K param1K, int param1Int, V param1V, boolean param1Boolean) {
      lock();
      try {
        preWriteCleanup();
        int i = this.count + 1;
        int j = i;
        if (i > this.threshold) {
          expand();
          j = this.count + 1;
        } 
        AtomicReferenceArray<E> atomicReferenceArray = this.table;
        i = atomicReferenceArray.length() - 1 & param1Int;
        MapMakerInternalMap.InternalEntry internalEntry1 = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(i);
        for (MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry1; internalEntry2 != null; internalEntry2 = (MapMakerInternalMap.InternalEntry)internalEntry2.getNext()) {
          Object object = internalEntry2.getKey();
          if (internalEntry2.getHash() == param1Int && object != null && this.map.keyEquivalence.equivalent(param1K, object)) {
            param1K = (K)internalEntry2.getValue();
            if (param1K == null) {
              this.modCount++;
              setValue((E)internalEntry2, param1V);
              this.count = this.count;
              return null;
            } 
            if (param1Boolean)
              return (V)param1K; 
            this.modCount++;
            setValue((E)internalEntry2, param1V);
            return (V)param1K;
          } 
        } 
        this.modCount++;
        param1K = (K)this.map.entryHelper.newEntry(self(), param1K, param1Int, (E)internalEntry1);
        setValue((E)param1K, param1V);
        atomicReferenceArray.set(i, (E)param1K);
        this.count = j;
        return null;
      } finally {
        unlock();
      } 
    }
    
    @CanIgnoreReturnValue
    boolean reclaimKey(E param1E, int param1Int) {
      lock();
      try {
        int i = this.count;
        AtomicReferenceArray<E> atomicReferenceArray = this.table;
        param1Int &= atomicReferenceArray.length() - 1;
        MapMakerInternalMap.InternalEntry internalEntry1 = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(param1Int);
        for (MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry1; internalEntry2 != null; internalEntry2 = (MapMakerInternalMap.InternalEntry)internalEntry2.getNext()) {
          if (internalEntry2 == param1E) {
            this.modCount++;
            param1E = removeFromChain((E)internalEntry1, (E)internalEntry2);
            i = this.count;
            atomicReferenceArray.set(param1Int, param1E);
            this.count = i - 1;
            return true;
          } 
        } 
        return false;
      } finally {
        unlock();
      } 
    }
    
    @CanIgnoreReturnValue
    boolean reclaimValue(K param1K, int param1Int, MapMakerInternalMap.WeakValueReference<K, V, E> param1WeakValueReference) {
      lock();
      try {
        int i = this.count;
        AtomicReferenceArray<E> atomicReferenceArray = this.table;
        i = atomicReferenceArray.length() - 1 & param1Int;
        MapMakerInternalMap.InternalEntry internalEntry1 = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(i);
        for (MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry1; internalEntry2 != null; internalEntry2 = (MapMakerInternalMap.InternalEntry)internalEntry2.getNext()) {
          Object object = internalEntry2.getKey();
          if (internalEntry2.getHash() == param1Int && object != null && this.map.keyEquivalence.equivalent(param1K, object)) {
            if (((MapMakerInternalMap.WeakValueEntry<K, V, E>)internalEntry2).getValueReference() == param1WeakValueReference) {
              this.modCount++;
              param1K = (K)removeFromChain((E)internalEntry1, (E)internalEntry2);
              param1Int = this.count;
              atomicReferenceArray.set(i, (E)param1K);
              this.count = param1Int - 1;
              return true;
            } 
            return false;
          } 
        } 
        return false;
      } finally {
        unlock();
      } 
    }
    
    @CanIgnoreReturnValue
    V remove(Object param1Object, int param1Int) {
      lock();
      try {
        preWriteCleanup();
        int i = this.count;
        AtomicReferenceArray<E> atomicReferenceArray = this.table;
        i = atomicReferenceArray.length() - 1 & param1Int;
        MapMakerInternalMap.InternalEntry internalEntry1 = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(i);
        for (MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry1; internalEntry2 != null; internalEntry2 = (MapMakerInternalMap.InternalEntry)internalEntry2.getNext()) {
          Object object = internalEntry2.getKey();
          if (internalEntry2.getHash() == param1Int && object != null && this.map.keyEquivalence.equivalent(param1Object, object)) {
            param1Object = internalEntry2.getValue();
            if (param1Object != null || isCollected(internalEntry2)) {
              this.modCount++;
              internalEntry2 = (MapMakerInternalMap.InternalEntry)removeFromChain((E)internalEntry1, (E)internalEntry2);
              param1Int = this.count;
              atomicReferenceArray.set(i, (E)internalEntry2);
              this.count = param1Int - 1;
              return (V)param1Object;
            } 
            return null;
          } 
        } 
        return null;
      } finally {
        unlock();
      } 
    }
    
    boolean remove(Object param1Object1, int param1Int, Object param1Object2) {
      lock();
      try {
        preWriteCleanup();
        int i = this.count;
        AtomicReferenceArray<E> atomicReferenceArray = this.table;
        i = atomicReferenceArray.length() - 1 & param1Int;
        MapMakerInternalMap.InternalEntry internalEntry1 = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(i);
        MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry1;
        while (true) {
          boolean bool = false;
          if (internalEntry2 != null) {
            Object object = internalEntry2.getKey();
            if (internalEntry2.getHash() == param1Int && object != null && this.map.keyEquivalence.equivalent(param1Object1, object)) {
              param1Object1 = internalEntry2.getValue();
              if (this.map.valueEquivalence().equivalent(param1Object2, param1Object1)) {
                bool = true;
              } else if (!isCollected(internalEntry2)) {
                return false;
              } 
              this.modCount++;
              param1Object1 = removeFromChain((E)internalEntry1, (E)internalEntry2);
              param1Int = this.count;
              atomicReferenceArray.set(i, (E)param1Object1);
              this.count = param1Int - 1;
              return bool;
            } 
            internalEntry2 = (MapMakerInternalMap.InternalEntry)internalEntry2.getNext();
            continue;
          } 
          return false;
        } 
      } finally {
        unlock();
      } 
    }
    
    @GuardedBy("this")
    boolean removeEntryForTesting(E param1E) {
      int i = param1E.getHash();
      int j = this.count;
      AtomicReferenceArray<E> atomicReferenceArray = this.table;
      j = i & atomicReferenceArray.length() - 1;
      MapMakerInternalMap.InternalEntry internalEntry1 = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(j);
      for (MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry1; internalEntry2 != null; internalEntry2 = (MapMakerInternalMap.InternalEntry)internalEntry2.getNext()) {
        if (internalEntry2 == param1E) {
          this.modCount++;
          param1E = removeFromChain((E)internalEntry1, (E)internalEntry2);
          i = this.count;
          atomicReferenceArray.set(j, param1E);
          this.count = i - 1;
          return true;
        } 
      } 
      return false;
    }
    
    @GuardedBy("this")
    E removeFromChain(E param1E1, E param1E2) {
      int i = this.count;
      Object object = param1E2.getNext();
      while (param1E1 != param1E2) {
        E e = copyEntry(param1E1, (E)object);
        if (e != null) {
          object = e;
        } else {
          i--;
        } 
        param1E1 = (E)param1E1.getNext();
      } 
      this.count = i;
      return (E)object;
    }
    
    E removeFromChainForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry1, MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry2) {
      return removeFromChain(castForTesting(param1InternalEntry1), castForTesting(param1InternalEntry2));
    }
    
    @CanIgnoreReturnValue
    boolean removeTableEntryForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry) {
      return removeEntryForTesting(castForTesting(param1InternalEntry));
    }
    
    V replace(K param1K, int param1Int, V param1V) {
      lock();
      try {
        preWriteCleanup();
        AtomicReferenceArray<E> atomicReferenceArray = this.table;
        int i = atomicReferenceArray.length() - 1 & param1Int;
        MapMakerInternalMap.InternalEntry internalEntry1 = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(i);
        for (MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry1; internalEntry2 != null; internalEntry2 = (MapMakerInternalMap.InternalEntry)internalEntry2.getNext()) {
          Object object = internalEntry2.getKey();
          if (internalEntry2.getHash() == param1Int && object != null && this.map.keyEquivalence.equivalent(param1K, object)) {
            param1K = (K)internalEntry2.getValue();
            if (param1K == null) {
              if (isCollected(internalEntry2)) {
                param1Int = this.count;
                this.modCount++;
                param1K = (K)removeFromChain((E)internalEntry1, (E)internalEntry2);
                param1Int = this.count;
                atomicReferenceArray.set(i, (E)param1K);
                this.count = param1Int - 1;
              } 
              return null;
            } 
            this.modCount++;
            setValue((E)internalEntry2, param1V);
            return (V)param1K;
          } 
        } 
        return null;
      } finally {
        unlock();
      } 
    }
    
    boolean replace(K param1K, int param1Int, V param1V1, V param1V2) {
      lock();
      try {
        preWriteCleanup();
        AtomicReferenceArray<E> atomicReferenceArray = this.table;
        int i = atomicReferenceArray.length() - 1 & param1Int;
        MapMakerInternalMap.InternalEntry internalEntry1 = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(i);
        for (MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry1; internalEntry2 != null; internalEntry2 = (MapMakerInternalMap.InternalEntry)internalEntry2.getNext()) {
          Object object = internalEntry2.getKey();
          if (internalEntry2.getHash() == param1Int && object != null && this.map.keyEquivalence.equivalent(param1K, object)) {
            param1K = (K)internalEntry2.getValue();
            if (param1K == null) {
              if (isCollected(internalEntry2)) {
                param1Int = this.count;
                this.modCount++;
                param1K = (K)removeFromChain((E)internalEntry1, (E)internalEntry2);
                param1Int = this.count;
                atomicReferenceArray.set(i, (E)param1K);
                this.count = param1Int - 1;
              } 
              return false;
            } 
            if (this.map.valueEquivalence().equivalent(param1V1, param1K)) {
              this.modCount++;
              setValue((E)internalEntry2, param1V2);
              return true;
            } 
            return false;
          } 
        } 
        return false;
      } finally {
        unlock();
      } 
    }
    
    void runCleanup() {
      runLockedCleanup();
    }
    
    void runLockedCleanup() {
      if (tryLock())
        try {
          maybeDrainReferenceQueues();
          this.readCount.set(0);
        } finally {
          unlock();
        }  
    }
    
    abstract S self();
    
    void setTableEntryForTesting(int param1Int, MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry) {
      this.table.set(param1Int, castForTesting(param1InternalEntry));
    }
    
    void setValue(E param1E, V param1V) {
      this.map.entryHelper.setValue(self(), param1E, param1V);
    }
    
    void setValueForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry, V param1V) {
      this.map.entryHelper.setValue(self(), castForTesting(param1InternalEntry), param1V);
    }
    
    void setWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry, MapMakerInternalMap.WeakValueReference<K, V, ? extends MapMakerInternalMap.InternalEntry<K, V, ?>> param1WeakValueReference) {
      throw new AssertionError();
    }
    
    void tryDrainReferenceQueues() {
      if (tryLock())
        try {
          maybeDrainReferenceQueues();
        } finally {
          unlock();
        }  
    }
  }
  
  private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
    private static final long serialVersionUID = 3L;
    
    SerializationProxy(MapMakerInternalMap.Strength param1Strength1, MapMakerInternalMap.Strength param1Strength2, Equivalence<Object> param1Equivalence1, Equivalence<Object> param1Equivalence2, int param1Int, ConcurrentMap<K, V> param1ConcurrentMap) {
      super(param1Strength1, param1Strength2, param1Equivalence1, param1Equivalence2, param1Int, param1ConcurrentMap);
    }
    
    private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
      param1ObjectInputStream.defaultReadObject();
      this.delegate = readMapMaker(param1ObjectInputStream).makeMap();
      readEntries(param1ObjectInputStream);
    }
    
    private Object readResolve() {
      return this.delegate;
    }
    
    private void writeObject(ObjectOutputStream param1ObjectOutputStream) throws IOException {
      param1ObjectOutputStream.defaultWriteObject();
      writeMapTo(param1ObjectOutputStream);
    }
  }
  
  enum Strength {
    STRONG {
      Equivalence<Object> defaultEquivalence() {
        return Equivalence.equals();
      }
    },
    WEAK {
      Equivalence<Object> defaultEquivalence() {
        return Equivalence.identity();
      }
    };
    
    static {
    
    }
    
    abstract Equivalence<Object> defaultEquivalence();
  }
  
  enum null {
    Equivalence<Object> defaultEquivalence() {
      return Equivalence.equals();
    }
  }
  
  enum null {
    Equivalence<Object> defaultEquivalence() {
      return Equivalence.identity();
    }
  }
  
  static final class StrongKeyStrongValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, StrongKeyStrongValueEntry<K, V>> {
    @Nullable
    private volatile V value = null;
    
    StrongKeyStrongValueEntry(K param1K, int param1Int, @Nullable StrongKeyStrongValueEntry<K, V> param1StrongKeyStrongValueEntry) {
      super(param1K, param1Int, param1StrongKeyStrongValueEntry);
    }
    
    StrongKeyStrongValueEntry<K, V> copy(StrongKeyStrongValueEntry<K, V> param1StrongKeyStrongValueEntry) {
      param1StrongKeyStrongValueEntry = new StrongKeyStrongValueEntry(this.key, this.hash, param1StrongKeyStrongValueEntry);
      param1StrongKeyStrongValueEntry.value = this.value;
      return param1StrongKeyStrongValueEntry;
    }
    
    @Nullable
    public V getValue() {
      return this.value;
    }
    
    void setValue(V param1V) {
      this.value = param1V;
    }
    
    static final class Helper<K, V> implements MapMakerInternalMap.InternalEntryHelper<K, V, StrongKeyStrongValueEntry<K, V>, MapMakerInternalMap.StrongKeyStrongValueSegment<K, V>> {
      private static final Helper<?, ?> INSTANCE = new Helper();
      
      static <K, V> Helper<K, V> instance() {
        return (Helper)INSTANCE;
      }
      
      public MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> copy(MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> param2StrongKeyStrongValueSegment, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> param2StrongKeyStrongValueEntry1, @Nullable MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> param2StrongKeyStrongValueEntry2) {
        return param2StrongKeyStrongValueEntry1.copy(param2StrongKeyStrongValueEntry2);
      }
      
      public MapMakerInternalMap.Strength keyStrength() {
        return MapMakerInternalMap.Strength.STRONG;
      }
      
      public MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> newEntry(MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> param2StrongKeyStrongValueSegment, K param2K, int param2Int, @Nullable MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> param2StrongKeyStrongValueEntry) {
        return new MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>(param2K, param2Int, param2StrongKeyStrongValueEntry);
      }
      
      public MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>, MapMakerInternalMap.StrongKeyStrongValueSegment<K, V>> param2MapMakerInternalMap, int param2Int1, int param2Int2) {
        return new MapMakerInternalMap.StrongKeyStrongValueSegment<K, V>(param2MapMakerInternalMap, param2Int1, param2Int2);
      }
      
      public void setValue(MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> param2StrongKeyStrongValueSegment, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> param2StrongKeyStrongValueEntry, V param2V) {
        param2StrongKeyStrongValueEntry.setValue(param2V);
      }
      
      public MapMakerInternalMap.Strength valueStrength() {
        return MapMakerInternalMap.Strength.STRONG;
      }
    }
  }
  
  static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
    private static final Helper<?, ?> INSTANCE = new Helper();
    
    static <K, V> Helper<K, V> instance() {
      return (Helper)INSTANCE;
    }
    
    public MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> copy(MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> param1StrongKeyStrongValueSegment, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> param1StrongKeyStrongValueEntry1, @Nullable MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> param1StrongKeyStrongValueEntry2) {
      return param1StrongKeyStrongValueEntry1.copy(param1StrongKeyStrongValueEntry2);
    }
    
    public MapMakerInternalMap.Strength keyStrength() {
      return MapMakerInternalMap.Strength.STRONG;
    }
    
    public MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> newEntry(MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> param1StrongKeyStrongValueSegment, K param1K, int param1Int, @Nullable MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> param1StrongKeyStrongValueEntry) {
      return new MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>(param1K, param1Int, param1StrongKeyStrongValueEntry);
    }
    
    public MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>, MapMakerInternalMap.StrongKeyStrongValueSegment<K, V>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      return new MapMakerInternalMap.StrongKeyStrongValueSegment<K, V>(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
    
    public void setValue(MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> param1StrongKeyStrongValueSegment, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> param1StrongKeyStrongValueEntry, V param1V) {
      param1StrongKeyStrongValueEntry.setValue(param1V);
    }
    
    public MapMakerInternalMap.Strength valueStrength() {
      return MapMakerInternalMap.Strength.STRONG;
    }
  }
  
  static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
    StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      super(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
    
    public MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> castForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry) {
      return (MapMakerInternalMap.StrongKeyStrongValueEntry)param1InternalEntry;
    }
    
    StrongKeyStrongValueSegment<K, V> self() {
      return this;
    }
  }
  
  static final class StrongKeyWeakValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, StrongKeyWeakValueEntry<K, V>> {
    private volatile MapMakerInternalMap.WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> valueReference = MapMakerInternalMap.unsetWeakValueReference();
    
    StrongKeyWeakValueEntry(K param1K, int param1Int, @Nullable StrongKeyWeakValueEntry<K, V> param1StrongKeyWeakValueEntry) {
      super(param1K, param1Int, param1StrongKeyWeakValueEntry);
    }
    
    public void clearValue() {
      this.valueReference.clear();
    }
    
    StrongKeyWeakValueEntry<K, V> copy(ReferenceQueue<V> param1ReferenceQueue, StrongKeyWeakValueEntry<K, V> param1StrongKeyWeakValueEntry) {
      param1StrongKeyWeakValueEntry = new StrongKeyWeakValueEntry(this.key, this.hash, param1StrongKeyWeakValueEntry);
      param1StrongKeyWeakValueEntry.valueReference = this.valueReference.copyFor(param1ReferenceQueue, param1StrongKeyWeakValueEntry);
      return param1StrongKeyWeakValueEntry;
    }
    
    public V getValue() {
      return this.valueReference.get();
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> getValueReference() {
      return this.valueReference;
    }
    
    void setValue(V param1V, ReferenceQueue<V> param1ReferenceQueue) {
      MapMakerInternalMap.WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> weakValueReference = this.valueReference;
      this.valueReference = new MapMakerInternalMap.WeakValueReferenceImpl<K, V, StrongKeyWeakValueEntry<K, V>>(param1ReferenceQueue, param1V, this);
      weakValueReference.clear();
    }
    
    static final class Helper<K, V> implements MapMakerInternalMap.InternalEntryHelper<K, V, StrongKeyWeakValueEntry<K, V>, MapMakerInternalMap.StrongKeyWeakValueSegment<K, V>> {
      private static final Helper<?, ?> INSTANCE = new Helper();
      
      static <K, V> Helper<K, V> instance() {
        return (Helper)INSTANCE;
      }
      
      public MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> copy(MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> param2StrongKeyWeakValueSegment, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> param2StrongKeyWeakValueEntry1, @Nullable MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> param2StrongKeyWeakValueEntry2) {
        return MapMakerInternalMap.Segment.isCollected(param2StrongKeyWeakValueEntry1) ? null : param2StrongKeyWeakValueEntry1.copy(param2StrongKeyWeakValueSegment.queueForValues, param2StrongKeyWeakValueEntry2);
      }
      
      public MapMakerInternalMap.Strength keyStrength() {
        return MapMakerInternalMap.Strength.STRONG;
      }
      
      public MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> newEntry(MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> param2StrongKeyWeakValueSegment, K param2K, int param2Int, @Nullable MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> param2StrongKeyWeakValueEntry) {
        return new MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>(param2K, param2Int, param2StrongKeyWeakValueEntry);
      }
      
      public MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>, MapMakerInternalMap.StrongKeyWeakValueSegment<K, V>> param2MapMakerInternalMap, int param2Int1, int param2Int2) {
        return new MapMakerInternalMap.StrongKeyWeakValueSegment<K, V>(param2MapMakerInternalMap, param2Int1, param2Int2);
      }
      
      public void setValue(MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> param2StrongKeyWeakValueSegment, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> param2StrongKeyWeakValueEntry, V param2V) {
        param2StrongKeyWeakValueEntry.setValue(param2V, param2StrongKeyWeakValueSegment.queueForValues);
      }
      
      public MapMakerInternalMap.Strength valueStrength() {
        return MapMakerInternalMap.Strength.WEAK;
      }
    }
  }
  
  static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
    private static final Helper<?, ?> INSTANCE = new Helper();
    
    static <K, V> Helper<K, V> instance() {
      return (Helper)INSTANCE;
    }
    
    public MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> copy(MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> param1StrongKeyWeakValueSegment, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> param1StrongKeyWeakValueEntry1, @Nullable MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> param1StrongKeyWeakValueEntry2) {
      return MapMakerInternalMap.Segment.isCollected(param1StrongKeyWeakValueEntry1) ? null : param1StrongKeyWeakValueEntry1.copy(param1StrongKeyWeakValueSegment.queueForValues, param1StrongKeyWeakValueEntry2);
    }
    
    public MapMakerInternalMap.Strength keyStrength() {
      return MapMakerInternalMap.Strength.STRONG;
    }
    
    public MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> newEntry(MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> param1StrongKeyWeakValueSegment, K param1K, int param1Int, @Nullable MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> param1StrongKeyWeakValueEntry) {
      return new MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>(param1K, param1Int, param1StrongKeyWeakValueEntry);
    }
    
    public MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>, MapMakerInternalMap.StrongKeyWeakValueSegment<K, V>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      return new MapMakerInternalMap.StrongKeyWeakValueSegment<K, V>(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
    
    public void setValue(MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> param1StrongKeyWeakValueSegment, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> param1StrongKeyWeakValueEntry, V param1V) {
      param1StrongKeyWeakValueEntry.setValue(param1V, param1StrongKeyWeakValueSegment.queueForValues);
    }
    
    public MapMakerInternalMap.Strength valueStrength() {
      return MapMakerInternalMap.Strength.WEAK;
    }
  }
  
  static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
    private final ReferenceQueue<V> queueForValues = new ReferenceQueue<V>();
    
    StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      super(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
    
    public MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> castForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry) {
      return (MapMakerInternalMap.StrongKeyWeakValueEntry)param1InternalEntry;
    }
    
    ReferenceQueue<V> getValueReferenceQueueForTesting() {
      return this.queueForValues;
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>> getWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry) {
      return castForTesting(param1InternalEntry).getValueReference();
    }
    
    void maybeClearReferenceQueues() {
      clearReferenceQueue(this.queueForValues);
    }
    
    void maybeDrainReferenceQueues() {
      drainValueReferenceQueue(this.queueForValues);
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>> newWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry, V param1V) {
      return new MapMakerInternalMap.WeakValueReferenceImpl<K, V, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>>(this.queueForValues, param1V, castForTesting(param1InternalEntry));
    }
    
    StrongKeyWeakValueSegment<K, V> self() {
      return this;
    }
    
    public void setWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry, MapMakerInternalMap.WeakValueReference<K, V, ? extends MapMakerInternalMap.InternalEntry<K, V, ?>> param1WeakValueReference) {
      MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry = castForTesting(param1InternalEntry);
      MapMakerInternalMap.WeakValueReference weakValueReference = strongKeyWeakValueEntry.valueReference;
      MapMakerInternalMap.StrongKeyWeakValueEntry.access$502(strongKeyWeakValueEntry, param1WeakValueReference);
      weakValueReference.clear();
    }
  }
  
  static interface StrongValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {}
  
  final class ValueIterator extends HashIterator<V> {
    public V next() {
      return nextEntry().getValue();
    }
  }
  
  final class Values extends AbstractCollection<V> {
    public void clear() {
      MapMakerInternalMap.this.clear();
    }
    
    public boolean contains(Object param1Object) {
      return MapMakerInternalMap.this.containsValue(param1Object);
    }
    
    public boolean isEmpty() {
      return MapMakerInternalMap.this.isEmpty();
    }
    
    public Iterator<V> iterator() {
      return new MapMakerInternalMap.ValueIterator();
    }
    
    public int size() {
      return MapMakerInternalMap.this.size();
    }
    
    public Object[] toArray() {
      return MapMakerInternalMap.toArrayList(this).toArray();
    }
    
    public <E> E[] toArray(E[] param1ArrayOfE) {
      return (E[])MapMakerInternalMap.toArrayList(this).toArray((Object[])param1ArrayOfE);
    }
  }
  
  static final class WeakKeyStrongValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, WeakKeyStrongValueEntry<K, V>> {
    @Nullable
    private volatile V value = null;
    
    WeakKeyStrongValueEntry(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, @Nullable WeakKeyStrongValueEntry<K, V> param1WeakKeyStrongValueEntry) {
      super(param1ReferenceQueue, param1K, param1Int, param1WeakKeyStrongValueEntry);
    }
    
    WeakKeyStrongValueEntry<K, V> copy(ReferenceQueue<K> param1ReferenceQueue, WeakKeyStrongValueEntry<K, V> param1WeakKeyStrongValueEntry) {
      WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry = new WeakKeyStrongValueEntry(param1ReferenceQueue, getKey(), this.hash, param1WeakKeyStrongValueEntry);
      weakKeyStrongValueEntry.setValue(this.value);
      return weakKeyStrongValueEntry;
    }
    
    @Nullable
    public V getValue() {
      return this.value;
    }
    
    void setValue(V param1V) {
      this.value = param1V;
    }
    
    static final class Helper<K, V> implements MapMakerInternalMap.InternalEntryHelper<K, V, WeakKeyStrongValueEntry<K, V>, MapMakerInternalMap.WeakKeyStrongValueSegment<K, V>> {
      private static final Helper<?, ?> INSTANCE = new Helper();
      
      static <K, V> Helper<K, V> instance() {
        return (Helper)INSTANCE;
      }
      
      public MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> copy(MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> param2WeakKeyStrongValueSegment, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> param2WeakKeyStrongValueEntry1, @Nullable MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> param2WeakKeyStrongValueEntry2) {
        return (param2WeakKeyStrongValueEntry1.getKey() == null) ? null : param2WeakKeyStrongValueEntry1.copy(param2WeakKeyStrongValueSegment.queueForKeys, param2WeakKeyStrongValueEntry2);
      }
      
      public MapMakerInternalMap.Strength keyStrength() {
        return MapMakerInternalMap.Strength.WEAK;
      }
      
      public MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> newEntry(MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> param2WeakKeyStrongValueSegment, K param2K, int param2Int, @Nullable MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> param2WeakKeyStrongValueEntry) {
        return new MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>(param2WeakKeyStrongValueSegment.queueForKeys, param2K, param2Int, param2WeakKeyStrongValueEntry);
      }
      
      public MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>, MapMakerInternalMap.WeakKeyStrongValueSegment<K, V>> param2MapMakerInternalMap, int param2Int1, int param2Int2) {
        return new MapMakerInternalMap.WeakKeyStrongValueSegment<K, V>(param2MapMakerInternalMap, param2Int1, param2Int2);
      }
      
      public void setValue(MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> param2WeakKeyStrongValueSegment, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> param2WeakKeyStrongValueEntry, V param2V) {
        param2WeakKeyStrongValueEntry.setValue(param2V);
      }
      
      public MapMakerInternalMap.Strength valueStrength() {
        return MapMakerInternalMap.Strength.STRONG;
      }
    }
  }
  
  static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
    private static final Helper<?, ?> INSTANCE = new Helper();
    
    static <K, V> Helper<K, V> instance() {
      return (Helper)INSTANCE;
    }
    
    public MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> copy(MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> param1WeakKeyStrongValueSegment, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> param1WeakKeyStrongValueEntry1, @Nullable MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> param1WeakKeyStrongValueEntry2) {
      return (param1WeakKeyStrongValueEntry1.getKey() == null) ? null : param1WeakKeyStrongValueEntry1.copy(param1WeakKeyStrongValueSegment.queueForKeys, param1WeakKeyStrongValueEntry2);
    }
    
    public MapMakerInternalMap.Strength keyStrength() {
      return MapMakerInternalMap.Strength.WEAK;
    }
    
    public MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> newEntry(MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> param1WeakKeyStrongValueSegment, K param1K, int param1Int, @Nullable MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> param1WeakKeyStrongValueEntry) {
      return new MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>(param1WeakKeyStrongValueSegment.queueForKeys, param1K, param1Int, param1WeakKeyStrongValueEntry);
    }
    
    public MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>, MapMakerInternalMap.WeakKeyStrongValueSegment<K, V>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      return new MapMakerInternalMap.WeakKeyStrongValueSegment<K, V>(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
    
    public void setValue(MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> param1WeakKeyStrongValueSegment, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> param1WeakKeyStrongValueEntry, V param1V) {
      param1WeakKeyStrongValueEntry.setValue(param1V);
    }
    
    public MapMakerInternalMap.Strength valueStrength() {
      return MapMakerInternalMap.Strength.STRONG;
    }
  }
  
  static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
    private final ReferenceQueue<K> queueForKeys = new ReferenceQueue<K>();
    
    WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      super(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
    
    public MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> castForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry) {
      return (MapMakerInternalMap.WeakKeyStrongValueEntry)param1InternalEntry;
    }
    
    ReferenceQueue<K> getKeyReferenceQueueForTesting() {
      return this.queueForKeys;
    }
    
    void maybeClearReferenceQueues() {
      clearReferenceQueue(this.queueForKeys);
    }
    
    void maybeDrainReferenceQueues() {
      drainKeyReferenceQueue(this.queueForKeys);
    }
    
    WeakKeyStrongValueSegment<K, V> self() {
      return this;
    }
  }
  
  static final class WeakKeyWeakValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, WeakKeyWeakValueEntry<K, V>> {
    private volatile MapMakerInternalMap.WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> valueReference = MapMakerInternalMap.unsetWeakValueReference();
    
    WeakKeyWeakValueEntry(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, @Nullable WeakKeyWeakValueEntry<K, V> param1WeakKeyWeakValueEntry) {
      super(param1ReferenceQueue, param1K, param1Int, param1WeakKeyWeakValueEntry);
    }
    
    public void clearValue() {
      this.valueReference.clear();
    }
    
    WeakKeyWeakValueEntry<K, V> copy(ReferenceQueue<K> param1ReferenceQueue, ReferenceQueue<V> param1ReferenceQueue1, WeakKeyWeakValueEntry<K, V> param1WeakKeyWeakValueEntry) {
      WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry = new WeakKeyWeakValueEntry(param1ReferenceQueue, getKey(), this.hash, param1WeakKeyWeakValueEntry);
      weakKeyWeakValueEntry.valueReference = this.valueReference.copyFor(param1ReferenceQueue1, weakKeyWeakValueEntry);
      return weakKeyWeakValueEntry;
    }
    
    public V getValue() {
      return this.valueReference.get();
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> getValueReference() {
      return this.valueReference;
    }
    
    void setValue(V param1V, ReferenceQueue<V> param1ReferenceQueue) {
      MapMakerInternalMap.WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> weakValueReference = this.valueReference;
      this.valueReference = new MapMakerInternalMap.WeakValueReferenceImpl<K, V, WeakKeyWeakValueEntry<K, V>>(param1ReferenceQueue, param1V, this);
      weakValueReference.clear();
    }
    
    static final class Helper<K, V> implements MapMakerInternalMap.InternalEntryHelper<K, V, WeakKeyWeakValueEntry<K, V>, MapMakerInternalMap.WeakKeyWeakValueSegment<K, V>> {
      private static final Helper<?, ?> INSTANCE = new Helper();
      
      static <K, V> Helper<K, V> instance() {
        return (Helper)INSTANCE;
      }
      
      public MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> copy(MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> param2WeakKeyWeakValueSegment, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> param2WeakKeyWeakValueEntry1, @Nullable MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> param2WeakKeyWeakValueEntry2) {
        return (param2WeakKeyWeakValueEntry1.getKey() == null) ? null : (MapMakerInternalMap.Segment.isCollected(param2WeakKeyWeakValueEntry1) ? null : param2WeakKeyWeakValueEntry1.copy(param2WeakKeyWeakValueSegment.queueForKeys, param2WeakKeyWeakValueSegment.queueForValues, param2WeakKeyWeakValueEntry2));
      }
      
      public MapMakerInternalMap.Strength keyStrength() {
        return MapMakerInternalMap.Strength.WEAK;
      }
      
      public MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> newEntry(MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> param2WeakKeyWeakValueSegment, K param2K, int param2Int, @Nullable MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> param2WeakKeyWeakValueEntry) {
        return new MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>(param2WeakKeyWeakValueSegment.queueForKeys, param2K, param2Int, param2WeakKeyWeakValueEntry);
      }
      
      public MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>, MapMakerInternalMap.WeakKeyWeakValueSegment<K, V>> param2MapMakerInternalMap, int param2Int1, int param2Int2) {
        return new MapMakerInternalMap.WeakKeyWeakValueSegment<K, V>(param2MapMakerInternalMap, param2Int1, param2Int2);
      }
      
      public void setValue(MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> param2WeakKeyWeakValueSegment, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> param2WeakKeyWeakValueEntry, V param2V) {
        param2WeakKeyWeakValueEntry.setValue(param2V, param2WeakKeyWeakValueSegment.queueForValues);
      }
      
      public MapMakerInternalMap.Strength valueStrength() {
        return MapMakerInternalMap.Strength.WEAK;
      }
    }
  }
  
  static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
    private static final Helper<?, ?> INSTANCE = new Helper();
    
    static <K, V> Helper<K, V> instance() {
      return (Helper)INSTANCE;
    }
    
    public MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> copy(MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> param1WeakKeyWeakValueSegment, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> param1WeakKeyWeakValueEntry1, @Nullable MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> param1WeakKeyWeakValueEntry2) {
      return (param1WeakKeyWeakValueEntry1.getKey() == null) ? null : (MapMakerInternalMap.Segment.isCollected(param1WeakKeyWeakValueEntry1) ? null : param1WeakKeyWeakValueEntry1.copy(param1WeakKeyWeakValueSegment.queueForKeys, param1WeakKeyWeakValueSegment.queueForValues, param1WeakKeyWeakValueEntry2));
    }
    
    public MapMakerInternalMap.Strength keyStrength() {
      return MapMakerInternalMap.Strength.WEAK;
    }
    
    public MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> newEntry(MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> param1WeakKeyWeakValueSegment, K param1K, int param1Int, @Nullable MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> param1WeakKeyWeakValueEntry) {
      return new MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>(param1WeakKeyWeakValueSegment.queueForKeys, param1K, param1Int, param1WeakKeyWeakValueEntry);
    }
    
    public MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>, MapMakerInternalMap.WeakKeyWeakValueSegment<K, V>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      return new MapMakerInternalMap.WeakKeyWeakValueSegment<K, V>(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
    
    public void setValue(MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> param1WeakKeyWeakValueSegment, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> param1WeakKeyWeakValueEntry, V param1V) {
      param1WeakKeyWeakValueEntry.setValue(param1V, param1WeakKeyWeakValueSegment.queueForValues);
    }
    
    public MapMakerInternalMap.Strength valueStrength() {
      return MapMakerInternalMap.Strength.WEAK;
    }
  }
  
  static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
    private final ReferenceQueue<K> queueForKeys = new ReferenceQueue<K>();
    
    private final ReferenceQueue<V> queueForValues = new ReferenceQueue<V>();
    
    WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      super(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
    
    public MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> castForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry) {
      return (MapMakerInternalMap.WeakKeyWeakValueEntry)param1InternalEntry;
    }
    
    ReferenceQueue<K> getKeyReferenceQueueForTesting() {
      return this.queueForKeys;
    }
    
    ReferenceQueue<V> getValueReferenceQueueForTesting() {
      return this.queueForValues;
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>> getWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry) {
      return castForTesting(param1InternalEntry).getValueReference();
    }
    
    void maybeClearReferenceQueues() {
      clearReferenceQueue(this.queueForKeys);
    }
    
    void maybeDrainReferenceQueues() {
      drainKeyReferenceQueue(this.queueForKeys);
      drainValueReferenceQueue(this.queueForValues);
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>> newWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry, V param1V) {
      return new MapMakerInternalMap.WeakValueReferenceImpl<K, V, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>>(this.queueForValues, param1V, castForTesting(param1InternalEntry));
    }
    
    WeakKeyWeakValueSegment<K, V> self() {
      return this;
    }
    
    public void setWeakValueReferenceForTesting(MapMakerInternalMap.InternalEntry<K, V, ?> param1InternalEntry, MapMakerInternalMap.WeakValueReference<K, V, ? extends MapMakerInternalMap.InternalEntry<K, V, ?>> param1WeakValueReference) {
      MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry = castForTesting(param1InternalEntry);
      MapMakerInternalMap.WeakValueReference weakValueReference = weakKeyWeakValueEntry.valueReference;
      MapMakerInternalMap.WeakKeyWeakValueEntry.access$602(weakKeyWeakValueEntry, param1WeakValueReference);
      weakValueReference.clear();
    }
  }
  
  static interface WeakValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
    void clearValue();
    
    MapMakerInternalMap.WeakValueReference<K, V, E> getValueReference();
  }
  
  static interface WeakValueReference<K, V, E extends InternalEntry<K, V, E>> {
    void clear();
    
    WeakValueReference<K, V, E> copyFor(ReferenceQueue<V> param1ReferenceQueue, E param1E);
    
    @Nullable
    V get();
    
    E getEntry();
  }
  
  static final class WeakValueReferenceImpl<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<V> implements WeakValueReference<K, V, E> {
    final E entry;
    
    WeakValueReferenceImpl(ReferenceQueue<V> param1ReferenceQueue, V param1V, E param1E) {
      super(param1V, param1ReferenceQueue);
      this.entry = param1E;
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, E> copyFor(ReferenceQueue<V> param1ReferenceQueue, E param1E) {
      return new WeakValueReferenceImpl(param1ReferenceQueue, get(), param1E);
    }
    
    public E getEntry() {
      return this.entry;
    }
  }
  
  final class WriteThroughEntry extends AbstractMapEntry<K, V> {
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
      Object object = MapMakerInternalMap.this.put(this.key, param1V);
      this.value = param1V;
      return (V)object;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\MapMakerInternalMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */