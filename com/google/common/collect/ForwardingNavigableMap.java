package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;

@GwtIncompatible
public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {
  public Map.Entry<K, V> ceilingEntry(K paramK) {
    return delegate().ceilingEntry(paramK);
  }
  
  public K ceilingKey(K paramK) {
    return delegate().ceilingKey(paramK);
  }
  
  protected abstract NavigableMap<K, V> delegate();
  
  public NavigableSet<K> descendingKeySet() {
    return delegate().descendingKeySet();
  }
  
  public NavigableMap<K, V> descendingMap() {
    return delegate().descendingMap();
  }
  
  public Map.Entry<K, V> firstEntry() {
    return delegate().firstEntry();
  }
  
  public Map.Entry<K, V> floorEntry(K paramK) {
    return delegate().floorEntry(paramK);
  }
  
  public K floorKey(K paramK) {
    return delegate().floorKey(paramK);
  }
  
  public NavigableMap<K, V> headMap(K paramK, boolean paramBoolean) {
    return delegate().headMap(paramK, paramBoolean);
  }
  
  public Map.Entry<K, V> higherEntry(K paramK) {
    return delegate().higherEntry(paramK);
  }
  
  public K higherKey(K paramK) {
    return delegate().higherKey(paramK);
  }
  
  public Map.Entry<K, V> lastEntry() {
    return delegate().lastEntry();
  }
  
  public Map.Entry<K, V> lowerEntry(K paramK) {
    return delegate().lowerEntry(paramK);
  }
  
  public K lowerKey(K paramK) {
    return delegate().lowerKey(paramK);
  }
  
  public NavigableSet<K> navigableKeySet() {
    return delegate().navigableKeySet();
  }
  
  public Map.Entry<K, V> pollFirstEntry() {
    return delegate().pollFirstEntry();
  }
  
  public Map.Entry<K, V> pollLastEntry() {
    return delegate().pollLastEntry();
  }
  
  protected Map.Entry<K, V> standardCeilingEntry(K paramK) {
    return tailMap(paramK, true).firstEntry();
  }
  
  protected K standardCeilingKey(K paramK) {
    return Maps.keyOrNull(ceilingEntry(paramK));
  }
  
  @Beta
  protected NavigableSet<K> standardDescendingKeySet() {
    return descendingMap().navigableKeySet();
  }
  
  protected Map.Entry<K, V> standardFirstEntry() {
    return Iterables.<Map.Entry<K, V>>getFirst(entrySet(), null);
  }
  
  protected K standardFirstKey() {
    Map.Entry<K, V> entry = firstEntry();
    if (entry != null)
      return entry.getKey(); 
    throw new NoSuchElementException();
  }
  
  protected Map.Entry<K, V> standardFloorEntry(K paramK) {
    return headMap(paramK, true).lastEntry();
  }
  
  protected K standardFloorKey(K paramK) {
    return Maps.keyOrNull(floorEntry(paramK));
  }
  
  protected SortedMap<K, V> standardHeadMap(K paramK) {
    return headMap(paramK, false);
  }
  
  protected Map.Entry<K, V> standardHigherEntry(K paramK) {
    return tailMap(paramK, false).firstEntry();
  }
  
  protected K standardHigherKey(K paramK) {
    return Maps.keyOrNull(higherEntry(paramK));
  }
  
  protected Map.Entry<K, V> standardLastEntry() {
    return Iterables.<Map.Entry<K, V>>getFirst(descendingMap().entrySet(), null);
  }
  
  protected K standardLastKey() {
    Map.Entry<K, V> entry = lastEntry();
    if (entry != null)
      return entry.getKey(); 
    throw new NoSuchElementException();
  }
  
  protected Map.Entry<K, V> standardLowerEntry(K paramK) {
    return headMap(paramK, false).lastEntry();
  }
  
  protected K standardLowerKey(K paramK) {
    return Maps.keyOrNull(lowerEntry(paramK));
  }
  
  protected Map.Entry<K, V> standardPollFirstEntry() {
    return Iterators.<Map.Entry<K, V>>pollNext(entrySet().iterator());
  }
  
  protected Map.Entry<K, V> standardPollLastEntry() {
    return Iterators.<Map.Entry<K, V>>pollNext(descendingMap().entrySet().iterator());
  }
  
  protected SortedMap<K, V> standardSubMap(K paramK1, K paramK2) {
    return subMap(paramK1, true, paramK2, false);
  }
  
  protected SortedMap<K, V> standardTailMap(K paramK) {
    return tailMap(paramK, true);
  }
  
  public NavigableMap<K, V> subMap(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2) {
    return delegate().subMap(paramK1, paramBoolean1, paramK2, paramBoolean2);
  }
  
  public NavigableMap<K, V> tailMap(K paramK, boolean paramBoolean) {
    return delegate().tailMap(paramK, paramBoolean);
  }
  
  @Beta
  protected class StandardDescendingMap extends Maps.DescendingMap<K, V> {
    protected Iterator<Map.Entry<K, V>> entryIterator() {
      return new Iterator<Map.Entry<K, V>>() {
          private Map.Entry<K, V> nextOrNull = ForwardingNavigableMap.StandardDescendingMap.this.forward().lastEntry();
          
          private Map.Entry<K, V> toRemove = null;
          
          public boolean hasNext() {
            boolean bool;
            if (this.nextOrNull != null) {
              bool = true;
            } else {
              bool = false;
            } 
            return bool;
          }
          
          public Map.Entry<K, V> next() {
            if (hasNext())
              try {
                return this.nextOrNull;
              } finally {
                this.toRemove = this.nextOrNull;
                this.nextOrNull = ForwardingNavigableMap.StandardDescendingMap.this.forward().lowerEntry(this.nextOrNull.getKey());
              }  
            throw new NoSuchElementException();
          }
          
          public void remove() {
            boolean bool;
            if (this.toRemove != null) {
              bool = true;
            } else {
              bool = false;
            } 
            CollectPreconditions.checkRemove(bool);
            ForwardingNavigableMap.StandardDescendingMap.this.forward().remove(this.toRemove.getKey());
            this.toRemove = null;
          }
        };
    }
    
    NavigableMap<K, V> forward() {
      return ForwardingNavigableMap.this;
    }
  }
  
  class null implements Iterator<Map.Entry<K, V>> {
    private Map.Entry<K, V> nextOrNull = this.this$1.forward().lastEntry();
    
    private Map.Entry<K, V> toRemove = null;
    
    public boolean hasNext() {
      boolean bool;
      if (this.nextOrNull != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public Map.Entry<K, V> next() {
      if (hasNext())
        try {
          return this.nextOrNull;
        } finally {
          this.toRemove = this.nextOrNull;
          this.nextOrNull = this.this$1.forward().lowerEntry(this.nextOrNull.getKey());
        }  
      throw new NoSuchElementException();
    }
    
    public void remove() {
      boolean bool;
      if (this.toRemove != null) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.checkRemove(bool);
      this.this$1.forward().remove(this.toRemove.getKey());
      this.toRemove = null;
    }
  }
  
  @Beta
  protected class StandardNavigableKeySet extends Maps.NavigableKeySet<K, V> {
    public StandardNavigableKeySet() {
      super(ForwardingNavigableMap.this);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ForwardingNavigableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */