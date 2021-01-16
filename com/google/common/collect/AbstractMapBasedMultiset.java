package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
  @GwtIncompatible
  private static final long serialVersionUID = -2250766705698539974L;
  
  private transient Map<E, Count> backingMap;
  
  private transient long size;
  
  protected AbstractMapBasedMultiset(Map<E, Count> paramMap) {
    this.backingMap = (Map<E, Count>)Preconditions.checkNotNull(paramMap);
    this.size = super.size();
  }
  
  private static int getAndSet(@Nullable Count paramCount, int paramInt) {
    return (paramCount == null) ? 0 : paramCount.getAndSet(paramInt);
  }
  
  @GwtIncompatible
  private void readObjectNoData() throws ObjectStreamException {
    throw new InvalidObjectException("Stream data required");
  }
  
  @CanIgnoreReturnValue
  public int add(@Nullable E paramE, int paramInt) {
    boolean bool2;
    int i;
    if (paramInt == 0)
      return count(paramE); 
    boolean bool1 = true;
    if (paramInt > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "occurrences cannot be negative: %s", paramInt);
    Count count = this.backingMap.get(paramE);
    if (count == null) {
      this.backingMap.put(paramE, new Count(paramInt));
      i = 0;
    } else {
      i = count.get();
      long l = i + paramInt;
      if (l <= 2147483647L) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "too many occurrences: %s", l);
      count.add(paramInt);
    } 
    this.size += paramInt;
    return i;
  }
  
  public void clear() {
    Iterator<Count> iterator = this.backingMap.values().iterator();
    while (iterator.hasNext())
      ((Count)iterator.next()).set(0); 
    this.backingMap.clear();
    this.size = 0L;
  }
  
  public int count(@Nullable Object paramObject) {
    int i;
    paramObject = Maps.<Count>safeGet(this.backingMap, paramObject);
    if (paramObject == null) {
      i = 0;
    } else {
      i = paramObject.get();
    } 
    return i;
  }
  
  int distinctElements() {
    return this.backingMap.size();
  }
  
  Iterator<Multiset.Entry<E>> entryIterator() {
    return (Iterator)new Iterator<Multiset.Entry<Multiset.Entry<E>>>() {
        Map.Entry<E, Count> toRemove;
        
        public boolean hasNext() {
          return backingEntries.hasNext();
        }
        
        public Multiset.Entry<E> next() {
          final Map.Entry<E, Count> mapEntry = backingEntries.next();
          this.toRemove = entry;
          return new Multisets.AbstractEntry<E>() {
              public int getCount() {
                int i;
                Count count = (Count)mapEntry.getValue();
                if (count == null || count.get() == 0) {
                  Count count1 = (Count)AbstractMapBasedMultiset.this.backingMap.get(getElement());
                  if (count1 != null)
                    return count1.get(); 
                } 
                if (count == null) {
                  i = 0;
                } else {
                  i = count.get();
                } 
                return i;
              }
              
              public E getElement() {
                return (E)mapEntry.getKey();
              }
            };
        }
        
        public void remove() {
          boolean bool;
          if (this.toRemove != null) {
            bool = true;
          } else {
            bool = false;
          } 
          CollectPreconditions.checkRemove(bool);
          AbstractMapBasedMultiset.access$122(AbstractMapBasedMultiset.this, ((Count)this.toRemove.getValue()).getAndSet(0));
          backingEntries.remove();
          this.toRemove = null;
        }
      };
  }
  
  public Set<Multiset.Entry<E>> entrySet() {
    return super.entrySet();
  }
  
  public Iterator<E> iterator() {
    return new MapBasedMultisetIterator();
  }
  
  @CanIgnoreReturnValue
  public int remove(@Nullable Object paramObject, int paramInt) {
    boolean bool;
    if (paramInt == 0)
      return count(paramObject); 
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "occurrences cannot be negative: %s", paramInt);
    Count count = this.backingMap.get(paramObject);
    if (count == null)
      return 0; 
    int i = count.get();
    if (i <= paramInt) {
      this.backingMap.remove(paramObject);
      paramInt = i;
    } 
    count.add(-paramInt);
    this.size -= paramInt;
    return i;
  }
  
  void setBackingMap(Map<E, Count> paramMap) {
    this.backingMap = paramMap;
  }
  
  @CanIgnoreReturnValue
  public int setCount(@Nullable E paramE, int paramInt) {
    int i;
    CollectPreconditions.checkNonnegative(paramInt, "count");
    if (paramInt == 0) {
      i = getAndSet(this.backingMap.remove(paramE), paramInt);
    } else {
      Count count = this.backingMap.get(paramE);
      i = getAndSet(count, paramInt);
      if (count == null)
        this.backingMap.put(paramE, new Count(paramInt)); 
    } 
    this.size += (paramInt - i);
    return i;
  }
  
  public int size() {
    return Ints.saturatedCast(this.size);
  }
  
  private class MapBasedMultisetIterator implements Iterator<E> {
    boolean canRemove;
    
    Map.Entry<E, Count> currentEntry;
    
    final Iterator<Map.Entry<E, Count>> entryIterator = AbstractMapBasedMultiset.this.backingMap.entrySet().iterator();
    
    int occurrencesLeft;
    
    public boolean hasNext() {
      return (this.occurrencesLeft > 0 || this.entryIterator.hasNext());
    }
    
    public E next() {
      if (this.occurrencesLeft == 0) {
        this.currentEntry = this.entryIterator.next();
        this.occurrencesLeft = ((Count)this.currentEntry.getValue()).get();
      } 
      this.occurrencesLeft--;
      this.canRemove = true;
      return this.currentEntry.getKey();
    }
    
    public void remove() {
      CollectPreconditions.checkRemove(this.canRemove);
      if (((Count)this.currentEntry.getValue()).get() > 0) {
        if (((Count)this.currentEntry.getValue()).addAndGet(-1) == 0)
          this.entryIterator.remove(); 
        AbstractMapBasedMultiset.access$110(AbstractMapBasedMultiset.this);
        this.canRemove = false;
        return;
      } 
      throw new ConcurrentModificationException();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\AbstractMapBasedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */