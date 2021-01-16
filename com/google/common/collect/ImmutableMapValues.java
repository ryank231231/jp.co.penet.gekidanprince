package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
  @Weak
  private final ImmutableMap<K, V> map;
  
  ImmutableMapValues(ImmutableMap<K, V> paramImmutableMap) {
    this.map = paramImmutableMap;
  }
  
  public ImmutableList<V> asList() {
    return new ImmutableAsList<V>() {
        ImmutableCollection<V> delegateCollection() {
          return ImmutableMapValues.this;
        }
        
        public V get(int param1Int) {
          return (V)((Map.Entry)entryList.get(param1Int)).getValue();
        }
      };
  }
  
  public boolean contains(@Nullable Object paramObject) {
    boolean bool;
    if (paramObject != null && Iterators.contains(iterator(), paramObject)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  boolean isPartialView() {
    return true;
  }
  
  public UnmodifiableIterator<V> iterator() {
    return new UnmodifiableIterator<V>() {
        final UnmodifiableIterator<Map.Entry<K, V>> entryItr = ImmutableMapValues.this.map.entrySet().iterator();
        
        public boolean hasNext() {
          return this.entryItr.hasNext();
        }
        
        public V next() {
          return (V)((Map.Entry)this.entryItr.next()).getValue();
        }
      };
  }
  
  public int size() {
    return this.map.size();
  }
  
  @GwtIncompatible
  Object writeReplace() {
    return new SerializedForm<V>(this.map);
  }
  
  @GwtIncompatible
  private static class SerializedForm<V> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final ImmutableMap<?, V> map;
    
    SerializedForm(ImmutableMap<?, V> param1ImmutableMap) {
      this.map = param1ImmutableMap;
    }
    
    Object readResolve() {
      return this.map.values();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableMapValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */