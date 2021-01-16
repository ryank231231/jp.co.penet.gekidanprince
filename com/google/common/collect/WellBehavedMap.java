package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@GwtCompatible
final class WellBehavedMap<K, V> extends ForwardingMap<K, V> {
  private final Map<K, V> delegate;
  
  private Set<Map.Entry<K, V>> entrySet;
  
  private WellBehavedMap(Map<K, V> paramMap) {
    this.delegate = paramMap;
  }
  
  static <K, V> WellBehavedMap<K, V> wrap(Map<K, V> paramMap) {
    return new WellBehavedMap<K, V>(paramMap);
  }
  
  protected Map<K, V> delegate() {
    return this.delegate;
  }
  
  public Set<Map.Entry<K, V>> entrySet() {
    Set<Map.Entry<K, V>> set = this.entrySet;
    if (set != null)
      return set; 
    set = new EntrySet();
    this.entrySet = set;
    return set;
  }
  
  private final class EntrySet extends Maps.EntrySet<K, V> {
    private EntrySet() {}
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return new TransformedIterator<K, Map.Entry<K, V>>(WellBehavedMap.this.keySet().iterator()) {
          Map.Entry<K, V> transform(final K key) {
            return new AbstractMapEntry<K, V>() {
                public K getKey() {
                  return (K)key;
                }
                
                public V getValue() {
                  return (V)WellBehavedMap.this.get(key);
                }
                
                public V setValue(V param3V) {
                  return WellBehavedMap.this.put(key, param3V);
                }
              };
          }
        };
    }
    
    Map<K, V> map() {
      return WellBehavedMap.this;
    }
  }
  
  class null extends TransformedIterator<K, Map.Entry<K, V>> {
    null(Iterator<? extends K> param1Iterator) {
      super(param1Iterator);
    }
    
    Map.Entry<K, V> transform(final K key) {
      return new AbstractMapEntry<K, V>() {
          public K getKey() {
            return (K)key;
          }
          
          public V getValue() {
            return (V)WellBehavedMap.this.get(key);
          }
          
          public V setValue(V param3V) {
            return WellBehavedMap.this.put(key, param3V);
          }
        };
    }
  }
  
  class null extends AbstractMapEntry<K, V> {
    public K getKey() {
      return (K)key;
    }
    
    public V getValue() {
      return (V)WellBehavedMap.this.get(key);
    }
    
    public V setValue(V param1V) {
      return WellBehavedMap.this.put(key, param1V);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\WellBehavedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */