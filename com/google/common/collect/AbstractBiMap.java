package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
abstract class AbstractBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
  @GwtIncompatible
  private static final long serialVersionUID = 0L;
  
  private transient Map<K, V> delegate;
  
  private transient Set<Map.Entry<K, V>> entrySet;
  
  @RetainedWith
  transient AbstractBiMap<V, K> inverse;
  
  private transient Set<K> keySet;
  
  private transient Set<V> valueSet;
  
  private AbstractBiMap(Map<K, V> paramMap, AbstractBiMap<V, K> paramAbstractBiMap) {
    this.delegate = paramMap;
    this.inverse = paramAbstractBiMap;
  }
  
  AbstractBiMap(Map<K, V> paramMap, Map<V, K> paramMap1) {
    setDelegates(paramMap, paramMap1);
  }
  
  private V putInBothMaps(@Nullable K paramK, @Nullable V paramV, boolean paramBoolean) {
    checkKey(paramK);
    checkValue(paramV);
    boolean bool = containsKey(paramK);
    if (bool && Objects.equal(paramV, get(paramK)))
      return paramV; 
    if (paramBoolean) {
      inverse().remove(paramV);
    } else {
      Preconditions.checkArgument(containsValue(paramV) ^ true, "value already present: %s", paramV);
    } 
    V v = this.delegate.put(paramK, paramV);
    updateInverseMap(paramK, bool, v, paramV);
    return v;
  }
  
  @CanIgnoreReturnValue
  private V removeFromBothMaps(Object paramObject) {
    paramObject = this.delegate.remove(paramObject);
    removeFromInverseMap((V)paramObject);
    return (V)paramObject;
  }
  
  private void removeFromInverseMap(V paramV) {
    this.inverse.delegate.remove(paramV);
  }
  
  private void updateInverseMap(K paramK, boolean paramBoolean, V paramV1, V paramV2) {
    if (paramBoolean)
      removeFromInverseMap(paramV1); 
    this.inverse.delegate.put((K)paramV2, (V)paramK);
  }
  
  @CanIgnoreReturnValue
  K checkKey(@Nullable K paramK) {
    return paramK;
  }
  
  @CanIgnoreReturnValue
  V checkValue(@Nullable V paramV) {
    return paramV;
  }
  
  public void clear() {
    this.delegate.clear();
    this.inverse.delegate.clear();
  }
  
  public boolean containsValue(@Nullable Object paramObject) {
    return this.inverse.containsKey(paramObject);
  }
  
  protected Map<K, V> delegate() {
    return this.delegate;
  }
  
  public Set<Map.Entry<K, V>> entrySet() {
    Set<Map.Entry<K, V>> set1 = this.entrySet;
    Set<Map.Entry<K, V>> set2 = set1;
    if (set1 == null) {
      set2 = new EntrySet();
      this.entrySet = set2;
    } 
    return set2;
  }
  
  Iterator<Map.Entry<K, V>> entrySetIterator() {
    return new Iterator<Map.Entry<K, V>>() {
        Map.Entry<K, V> entry;
        
        public boolean hasNext() {
          return iterator.hasNext();
        }
        
        public Map.Entry<K, V> next() {
          this.entry = iterator.next();
          return new AbstractBiMap.BiMapEntry(this.entry);
        }
        
        public void remove() {
          boolean bool;
          if (this.entry != null) {
            bool = true;
          } else {
            bool = false;
          } 
          CollectPreconditions.checkRemove(bool);
          V v = this.entry.getValue();
          iterator.remove();
          AbstractBiMap.this.removeFromInverseMap(v);
        }
      };
  }
  
  @CanIgnoreReturnValue
  public V forcePut(@Nullable K paramK, @Nullable V paramV) {
    return putInBothMaps(paramK, paramV, true);
  }
  
  public BiMap<V, K> inverse() {
    return this.inverse;
  }
  
  public Set<K> keySet() {
    Set<K> set1 = this.keySet;
    Set<K> set2 = set1;
    if (set1 == null) {
      set2 = new KeySet();
      this.keySet = set2;
    } 
    return set2;
  }
  
  AbstractBiMap<V, K> makeInverse(Map<V, K> paramMap) {
    return new Inverse<V, K>(paramMap, this);
  }
  
  @CanIgnoreReturnValue
  public V put(@Nullable K paramK, @Nullable V paramV) {
    return putInBothMaps(paramK, paramV, false);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap) {
    for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet())
      put((K)entry.getKey(), (V)entry.getValue()); 
  }
  
  @CanIgnoreReturnValue
  public V remove(@Nullable Object paramObject) {
    if (containsKey(paramObject)) {
      paramObject = removeFromBothMaps(paramObject);
    } else {
      paramObject = null;
    } 
    return (V)paramObject;
  }
  
  void setDelegates(Map<K, V> paramMap, Map<V, K> paramMap1) {
    boolean bool2;
    Map<K, V> map = this.delegate;
    boolean bool1 = true;
    if (map == null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2);
    if (this.inverse == null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2);
    Preconditions.checkArgument(paramMap.isEmpty());
    Preconditions.checkArgument(paramMap1.isEmpty());
    if (paramMap != paramMap1) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2);
    this.delegate = paramMap;
    this.inverse = makeInverse(paramMap1);
  }
  
  void setInverse(AbstractBiMap<V, K> paramAbstractBiMap) {
    this.inverse = paramAbstractBiMap;
  }
  
  public Set<V> values() {
    Set<V> set1 = this.valueSet;
    Set<V> set2 = set1;
    if (set1 == null) {
      set2 = new ValueSet();
      this.valueSet = set2;
    } 
    return set2;
  }
  
  class BiMapEntry extends ForwardingMapEntry<K, V> {
    private final Map.Entry<K, V> delegate;
    
    BiMapEntry(Map.Entry<K, V> param1Entry) {
      this.delegate = param1Entry;
    }
    
    protected Map.Entry<K, V> delegate() {
      return this.delegate;
    }
    
    public V setValue(V param1V) {
      Preconditions.checkState(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
      if (Objects.equal(param1V, getValue()))
        return param1V; 
      Preconditions.checkArgument(AbstractBiMap.this.containsValue(param1V) ^ true, "value already present: %s", param1V);
      V v = this.delegate.setValue(param1V);
      Preconditions.checkState(Objects.equal(param1V, AbstractBiMap.this.get(getKey())), "entry no longer in map");
      AbstractBiMap.this.updateInverseMap(getKey(), true, v, param1V);
      return v;
    }
  }
  
  private class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
    final Set<Map.Entry<K, V>> esDelegate = AbstractBiMap.this.delegate.entrySet();
    
    private EntrySet() {}
    
    public void clear() {
      AbstractBiMap.this.clear();
    }
    
    public boolean contains(Object param1Object) {
      return Maps.containsEntryImpl(delegate(), param1Object);
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      return standardContainsAll(param1Collection);
    }
    
    protected Set<Map.Entry<K, V>> delegate() {
      return this.esDelegate;
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return AbstractBiMap.this.entrySetIterator();
    }
    
    public boolean remove(Object param1Object) {
      if (!this.esDelegate.contains(param1Object))
        return false; 
      param1Object = param1Object;
      AbstractBiMap.this.inverse.delegate.remove(param1Object.getValue());
      this.esDelegate.remove(param1Object);
      return true;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return standardRemoveAll(param1Collection);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return standardRetainAll(param1Collection);
    }
    
    public Object[] toArray() {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])standardToArray((Object[])param1ArrayOfT);
    }
  }
  
  static class Inverse<K, V> extends AbstractBiMap<K, V> {
    @GwtIncompatible
    private static final long serialVersionUID = 0L;
    
    Inverse(Map<K, V> param1Map, AbstractBiMap<V, K> param1AbstractBiMap) {
      super(param1Map, param1AbstractBiMap);
    }
    
    @GwtIncompatible
    private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
      param1ObjectInputStream.defaultReadObject();
      setInverse((AbstractBiMap<V, K>)param1ObjectInputStream.readObject());
    }
    
    @GwtIncompatible
    private void writeObject(ObjectOutputStream param1ObjectOutputStream) throws IOException {
      param1ObjectOutputStream.defaultWriteObject();
      param1ObjectOutputStream.writeObject(inverse());
    }
    
    K checkKey(K param1K) {
      return this.inverse.checkValue(param1K);
    }
    
    V checkValue(V param1V) {
      return this.inverse.checkKey(param1V);
    }
    
    @GwtIncompatible
    Object readResolve() {
      return inverse().inverse();
    }
  }
  
  private class KeySet extends ForwardingSet<K> {
    private KeySet() {}
    
    public void clear() {
      AbstractBiMap.this.clear();
    }
    
    protected Set<K> delegate() {
      return AbstractBiMap.this.delegate.keySet();
    }
    
    public Iterator<K> iterator() {
      return Maps.keyIterator(AbstractBiMap.this.entrySet().iterator());
    }
    
    public boolean remove(Object param1Object) {
      if (!contains(param1Object))
        return false; 
      AbstractBiMap.this.removeFromBothMaps(param1Object);
      return true;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return standardRemoveAll(param1Collection);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return standardRetainAll(param1Collection);
    }
  }
  
  private class ValueSet extends ForwardingSet<V> {
    final Set<V> valuesDelegate = AbstractBiMap.this.inverse.keySet();
    
    private ValueSet() {}
    
    protected Set<V> delegate() {
      return this.valuesDelegate;
    }
    
    public Iterator<V> iterator() {
      return Maps.valueIterator(AbstractBiMap.this.entrySet().iterator());
    }
    
    public Object[] toArray() {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])standardToArray((Object[])param1ArrayOfT);
    }
    
    public String toString() {
      return standardToString();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\AbstractBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */