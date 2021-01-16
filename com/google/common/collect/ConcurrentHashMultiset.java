package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@GwtIncompatible
public final class ConcurrentHashMultiset<E> extends AbstractMultiset<E> implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private final transient ConcurrentMap<E, AtomicInteger> countMap;
  
  @VisibleForTesting
  ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> paramConcurrentMap) {
    Preconditions.checkArgument(paramConcurrentMap.isEmpty(), "the backing map (%s) must be empty", paramConcurrentMap);
    this.countMap = paramConcurrentMap;
  }
  
  public static <E> ConcurrentHashMultiset<E> create() {
    return new ConcurrentHashMultiset<E>(new ConcurrentHashMap<E, AtomicInteger>());
  }
  
  @Deprecated
  @Beta
  public static <E> ConcurrentHashMultiset<E> create(MapMaker paramMapMaker) {
    return create(paramMapMaker.makeMap());
  }
  
  public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> paramIterable) {
    ConcurrentHashMultiset<?> concurrentHashMultiset = create();
    Iterables.addAll(concurrentHashMultiset, paramIterable);
    return (ConcurrentHashMultiset)concurrentHashMultiset;
  }
  
  @Beta
  public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> paramConcurrentMap) {
    return new ConcurrentHashMultiset<E>(paramConcurrentMap);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    ConcurrentMap concurrentMap = (ConcurrentMap)paramObjectInputStream.readObject();
    FieldSettersHolder.COUNT_MAP_FIELD_SETTER.set(this, concurrentMap);
  }
  
  private List<E> snapshot() {
    ArrayList<?> arrayList = Lists.newArrayListWithExpectedSize(size());
    for (Multiset.Entry<Object> entry : (Iterable<Multiset.Entry<Object>>)entrySet()) {
      Object object = entry.getElement();
      for (int i = entry.getCount(); i > 0; i--)
        arrayList.add(object); 
    } 
    return (List)arrayList;
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.countMap);
  }
  
  @CanIgnoreReturnValue
  public int add(E paramE, int paramInt) {
    Preconditions.checkNotNull(paramE);
    if (paramInt == 0)
      return count(paramE); 
    CollectPreconditions.checkPositive(paramInt, "occurences");
    while (true) {
      AtomicInteger atomicInteger1 = Maps.<AtomicInteger>safeGet(this.countMap, paramE);
      AtomicInteger atomicInteger2 = atomicInteger1;
      if (atomicInteger1 == null) {
        atomicInteger1 = this.countMap.putIfAbsent(paramE, new AtomicInteger(paramInt));
        atomicInteger2 = atomicInteger1;
        if (atomicInteger1 == null)
          return 0; 
      } 
      while (true) {
        StringBuilder stringBuilder;
        int i = atomicInteger2.get();
        if (i != 0) {
          try {
            boolean bool = atomicInteger2.compareAndSet(i, IntMath.checkedAdd(i, paramInt));
            if (bool)
              return i; 
          } catch (ArithmeticException arithmeticException) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Overflow adding ");
            stringBuilder.append(paramInt);
            stringBuilder.append(" occurrences to a count of ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
          } 
          continue;
        } 
        atomicInteger1 = new AtomicInteger(paramInt);
        if (this.countMap.putIfAbsent((E)stringBuilder, atomicInteger1) == null || this.countMap.replace((E)stringBuilder, atomicInteger2, atomicInteger1))
          break; 
      } 
      break;
    } 
    return 0;
  }
  
  public void clear() {
    this.countMap.clear();
  }
  
  public int count(@Nullable Object paramObject) {
    int i;
    paramObject = Maps.<AtomicInteger>safeGet(this.countMap, paramObject);
    if (paramObject == null) {
      i = 0;
    } else {
      i = paramObject.get();
    } 
    return i;
  }
  
  Set<E> createElementSet() {
    return new ForwardingSet<E>() {
        public boolean contains(@Nullable Object param1Object) {
          boolean bool;
          if (param1Object != null && Collections2.safeContains(delegate, param1Object)) {
            bool = true;
          } else {
            bool = false;
          } 
          return bool;
        }
        
        public boolean containsAll(Collection<?> param1Collection) {
          return standardContainsAll(param1Collection);
        }
        
        protected Set<E> delegate() {
          return delegate;
        }
        
        public boolean remove(Object param1Object) {
          boolean bool;
          if (param1Object != null && Collections2.safeRemove(delegate, param1Object)) {
            bool = true;
          } else {
            bool = false;
          } 
          return bool;
        }
        
        public boolean removeAll(Collection<?> param1Collection) {
          return standardRemoveAll(param1Collection);
        }
      };
  }
  
  public Set<Multiset.Entry<E>> createEntrySet() {
    return new EntrySet();
  }
  
  int distinctElements() {
    return this.countMap.size();
  }
  
  Iterator<Multiset.Entry<E>> entryIterator() {
    return new ForwardingIterator<Multiset.Entry<E>>() {
        private Multiset.Entry<E> last;
        
        protected Iterator<Multiset.Entry<E>> delegate() {
          return readOnlyIterator;
        }
        
        public Multiset.Entry<E> next() {
          this.last = super.next();
          return this.last;
        }
        
        public void remove() {
          boolean bool;
          if (this.last != null) {
            bool = true;
          } else {
            bool = false;
          } 
          CollectPreconditions.checkRemove(bool);
          ConcurrentHashMultiset.this.setCount(this.last.getElement(), 0);
          this.last = null;
        }
      };
  }
  
  public boolean isEmpty() {
    return this.countMap.isEmpty();
  }
  
  @CanIgnoreReturnValue
  public int remove(@Nullable Object paramObject, int paramInt) {
    if (paramInt == 0)
      return count(paramObject); 
    CollectPreconditions.checkPositive(paramInt, "occurences");
    AtomicInteger atomicInteger = Maps.<AtomicInteger>safeGet(this.countMap, paramObject);
    if (atomicInteger == null)
      return 0; 
    while (true) {
      int i = atomicInteger.get();
      if (i != 0) {
        int j = Math.max(0, i - paramInt);
        if (atomicInteger.compareAndSet(i, j)) {
          if (j == 0)
            this.countMap.remove(paramObject, atomicInteger); 
          return i;
        } 
        continue;
      } 
      return 0;
    } 
  }
  
  @CanIgnoreReturnValue
  public boolean removeExactly(@Nullable Object paramObject, int paramInt) {
    if (paramInt == 0)
      return true; 
    CollectPreconditions.checkPositive(paramInt, "occurences");
    AtomicInteger atomicInteger = Maps.<AtomicInteger>safeGet(this.countMap, paramObject);
    if (atomicInteger == null)
      return false; 
    while (true) {
      int i = atomicInteger.get();
      if (i < paramInt)
        return false; 
      int j = i - paramInt;
      if (atomicInteger.compareAndSet(i, j)) {
        if (j == 0)
          this.countMap.remove(paramObject, atomicInteger); 
        return true;
      } 
    } 
  }
  
  @CanIgnoreReturnValue
  public int setCount(E paramE, int paramInt) {
    Preconditions.checkNotNull(paramE);
    CollectPreconditions.checkNonnegative(paramInt, "count");
    label23: while (true) {
      AtomicInteger atomicInteger1 = Maps.<AtomicInteger>safeGet(this.countMap, paramE);
      AtomicInteger atomicInteger2 = atomicInteger1;
      if (atomicInteger1 == null) {
        if (paramInt == 0)
          return 0; 
        atomicInteger1 = this.countMap.putIfAbsent(paramE, new AtomicInteger(paramInt));
        atomicInteger2 = atomicInteger1;
        if (atomicInteger1 == null)
          return 0; 
      } 
      while (true) {
        int i = atomicInteger2.get();
        if (i == 0) {
          if (paramInt == 0)
            return 0; 
          atomicInteger1 = new AtomicInteger(paramInt);
          if (this.countMap.putIfAbsent(paramE, atomicInteger1) == null || this.countMap.replace(paramE, atomicInteger2, atomicInteger1))
            return 0; 
          continue label23;
        } 
        if (atomicInteger2.compareAndSet(i, paramInt)) {
          if (paramInt == 0)
            this.countMap.remove(paramE, atomicInteger2); 
          return i;
        } 
      } 
      break;
    } 
  }
  
  @CanIgnoreReturnValue
  public boolean setCount(E paramE, int paramInt1, int paramInt2) {
    Preconditions.checkNotNull(paramE);
    CollectPreconditions.checkNonnegative(paramInt1, "oldCount");
    CollectPreconditions.checkNonnegative(paramInt2, "newCount");
    AtomicInteger atomicInteger = Maps.<AtomicInteger>safeGet(this.countMap, paramE);
    boolean bool = false;
    null = false;
    if (atomicInteger == null) {
      if (paramInt1 != 0)
        return false; 
      if (paramInt2 == 0)
        return true; 
      if (this.countMap.putIfAbsent(paramE, new AtomicInteger(paramInt2)) == null)
        null = true; 
      return null;
    } 
    int i = atomicInteger.get();
    if (i == paramInt1) {
      if (i == 0) {
        if (paramInt2 == 0) {
          this.countMap.remove(paramE, atomicInteger);
          return true;
        } 
        AtomicInteger atomicInteger1 = new AtomicInteger(paramInt2);
        if (this.countMap.putIfAbsent(paramE, atomicInteger1) != null) {
          null = bool;
          return this.countMap.replace(paramE, atomicInteger, atomicInteger1) ? true : null;
        } 
      } else {
        if (atomicInteger.compareAndSet(i, paramInt2)) {
          if (paramInt2 == 0)
            this.countMap.remove(paramE, atomicInteger); 
          return true;
        } 
        return false;
      } 
    } else {
      return false;
    } 
    return true;
  }
  
  public int size() {
    Iterator<AtomicInteger> iterator = this.countMap.values().iterator();
    long l;
    for (l = 0L; iterator.hasNext(); l += ((AtomicInteger)iterator.next()).get());
    return Ints.saturatedCast(l);
  }
  
  public Object[] toArray() {
    return snapshot().toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    return snapshot().toArray(paramArrayOfT);
  }
  
  private class EntrySet extends AbstractMultiset<E>.EntrySet {
    private EntrySet() {}
    
    private List<Multiset.Entry<E>> snapshot() {
      ArrayList<?> arrayList = Lists.newArrayListWithExpectedSize(size());
      Iterators.addAll(arrayList, iterator());
      return (List)arrayList;
    }
    
    ConcurrentHashMultiset<E> multiset() {
      return ConcurrentHashMultiset.this;
    }
    
    public Object[] toArray() {
      return snapshot().toArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return snapshot().toArray(param1ArrayOfT);
    }
  }
  
  private static class FieldSettersHolder {
    static final Serialization.FieldSetter<ConcurrentHashMultiset> COUNT_MAP_FIELD_SETTER = Serialization.getFieldSetter(ConcurrentHashMultiset.class, "countMap");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ConcurrentHashMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */