package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
  static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap(null, null, (Map.Entry<K, V>[])ImmutableMap.EMPTY_ENTRY_ARRAY, 0, 0);
  
  static final double MAX_LOAD_FACTOR = 1.2D;
  
  private final transient Map.Entry<K, V>[] entries;
  
  private final transient int hashCode;
  
  @LazyInit
  @RetainedWith
  private transient ImmutableBiMap<V, K> inverse;
  
  private final transient ImmutableMapEntry<K, V>[] keyTable;
  
  private final transient int mask;
  
  private final transient ImmutableMapEntry<K, V>[] valueTable;
  
  private RegularImmutableBiMap(ImmutableMapEntry<K, V>[] paramArrayOfImmutableMapEntry1, ImmutableMapEntry<K, V>[] paramArrayOfImmutableMapEntry2, Map.Entry<K, V>[] paramArrayOfEntry, int paramInt1, int paramInt2) {
    this.keyTable = paramArrayOfImmutableMapEntry1;
    this.valueTable = paramArrayOfImmutableMapEntry2;
    this.entries = paramArrayOfEntry;
    this.mask = paramInt1;
    this.hashCode = paramInt2;
  }
  
  private static void checkNoConflictInValueBucket(Object paramObject, Map.Entry<?, ?> paramEntry, @Nullable ImmutableMapEntry<?, ?> paramImmutableMapEntry) {
    while (paramImmutableMapEntry != null) {
      checkNoConflict(paramObject.equals(paramImmutableMapEntry.getValue()) ^ true, "value", paramEntry, paramImmutableMapEntry);
      paramImmutableMapEntry = paramImmutableMapEntry.getNextInValueBucket();
    } 
  }
  
  static <K, V> RegularImmutableBiMap<K, V> fromEntries(Map.Entry<K, V>... paramVarArgs) {
    return fromEntryArray(paramVarArgs.length, paramVarArgs);
  }
  
  static <K, V> RegularImmutableBiMap<K, V> fromEntryArray(int paramInt, Map.Entry<K, V>[] paramArrayOfEntry) {
    ImmutableMapEntry[] arrayOfImmutableMapEntry3;
    int i = paramInt;
    Preconditions.checkPositionIndex(i, paramArrayOfEntry.length);
    int j = Hashing.closedTableSize(i, 1.2D);
    int k = j - 1;
    ImmutableMapEntry[] arrayOfImmutableMapEntry1 = (ImmutableMapEntry[])ImmutableMapEntry.createEntryArray(j);
    ImmutableMapEntry[] arrayOfImmutableMapEntry2 = (ImmutableMapEntry[])ImmutableMapEntry.createEntryArray(j);
    if (i == paramArrayOfEntry.length) {
      Map.Entry<K, V>[] arrayOfEntry = paramArrayOfEntry;
    } else {
      arrayOfImmutableMapEntry3 = ImmutableMapEntry.createEntryArray(paramInt);
    } 
    i = 0;
    j = 0;
    while (i < paramInt) {
      Map.Entry<K, V> entry = paramArrayOfEntry[i];
      K k1 = entry.getKey();
      V v = entry.getValue();
      CollectPreconditions.checkEntryNotNull(k1, v);
      int m = k1.hashCode();
      int n = v.hashCode();
      int i1 = Hashing.smear(m) & k;
      int i2 = Hashing.smear(n) & k;
      ImmutableMapEntry<?, ?> immutableMapEntry1 = arrayOfImmutableMapEntry1[i1];
      RegularImmutableMap.checkNoConflictInKeyBucket(k1, entry, immutableMapEntry1);
      ImmutableMapEntry<?, ?> immutableMapEntry2 = arrayOfImmutableMapEntry2[i2];
      checkNoConflictInValueBucket(v, entry, immutableMapEntry2);
      if (immutableMapEntry2 == null && immutableMapEntry1 == null) {
        boolean bool;
        if (entry instanceof ImmutableMapEntry && ((ImmutableMapEntry)entry).isReusable()) {
          bool = true;
        } else {
          bool = false;
        } 
        if (bool) {
          immutableMapEntry1 = (ImmutableMapEntry<?, ?>)entry;
        } else {
          immutableMapEntry1 = new ImmutableMapEntry<Object, Object>(k1, v);
        } 
      } else {
        immutableMapEntry1 = new ImmutableMapEntry.NonTerminalImmutableBiMapEntry<Object, Object>(k1, v, immutableMapEntry1, immutableMapEntry2);
      } 
      arrayOfImmutableMapEntry1[i1] = immutableMapEntry1;
      arrayOfImmutableMapEntry2[i2] = immutableMapEntry1;
      arrayOfImmutableMapEntry3[i] = immutableMapEntry1;
      j += m ^ n;
      i++;
    } 
    return new RegularImmutableBiMap<K, V>((ImmutableMapEntry<K, V>[])arrayOfImmutableMapEntry1, (ImmutableMapEntry<K, V>[])arrayOfImmutableMapEntry2, (Map.Entry<K, V>[])arrayOfImmutableMapEntry3, k, j);
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet() {
    ImmutableSet<?> immutableSet;
    if (isEmpty()) {
      immutableSet = ImmutableSet.of();
    } else {
      immutableSet = new ImmutableMapEntrySet.RegularEntrySet<K, V>(this, this.entries);
    } 
    return (ImmutableSet)immutableSet;
  }
  
  @Nullable
  public V get(@Nullable Object paramObject) {
    ImmutableMapEntry<K, V>[] arrayOfImmutableMapEntry = this.keyTable;
    if (arrayOfImmutableMapEntry == null) {
      paramObject = null;
    } else {
      paramObject = RegularImmutableMap.get(paramObject, (ImmutableMapEntry<?, V>[])arrayOfImmutableMapEntry, this.mask);
    } 
    return (V)paramObject;
  }
  
  public int hashCode() {
    return this.hashCode;
  }
  
  public ImmutableBiMap<V, K> inverse() {
    if (isEmpty())
      return ImmutableBiMap.of(); 
    ImmutableBiMap<V, K> immutableBiMap1 = this.inverse;
    ImmutableBiMap<V, K> immutableBiMap2 = immutableBiMap1;
    if (immutableBiMap1 == null) {
      immutableBiMap2 = new Inverse();
      this.inverse = immutableBiMap2;
    } 
    return immutableBiMap2;
  }
  
  boolean isHashCodeFast() {
    return true;
  }
  
  boolean isPartialView() {
    return false;
  }
  
  public int size() {
    return this.entries.length;
  }
  
  private final class Inverse extends ImmutableBiMap<V, K> {
    private Inverse() {}
    
    ImmutableSet<Map.Entry<V, K>> createEntrySet() {
      return new InverseEntrySet();
    }
    
    public K get(@Nullable Object param1Object) {
      if (param1Object == null || RegularImmutableBiMap.this.valueTable == null)
        return null; 
      int i = Hashing.smear(param1Object.hashCode());
      int j = RegularImmutableBiMap.this.mask;
      for (ImmutableMapEntry immutableMapEntry = RegularImmutableBiMap.this.valueTable[i & j]; immutableMapEntry != null; immutableMapEntry = immutableMapEntry.getNextInValueBucket()) {
        if (param1Object.equals(immutableMapEntry.getValue()))
          return (K)immutableMapEntry.getKey(); 
      } 
      return null;
    }
    
    public ImmutableBiMap<K, V> inverse() {
      return RegularImmutableBiMap.this;
    }
    
    boolean isPartialView() {
      return false;
    }
    
    public int size() {
      return inverse().size();
    }
    
    Object writeReplace() {
      return new RegularImmutableBiMap.InverseSerializedForm<Object, Object>(RegularImmutableBiMap.this);
    }
    
    final class InverseEntrySet extends ImmutableMapEntrySet<V, K> {
      ImmutableList<Map.Entry<V, K>> createAsList() {
        return new ImmutableAsList<Map.Entry<V, K>>() {
            ImmutableCollection<Map.Entry<V, K>> delegateCollection() {
              return RegularImmutableBiMap.Inverse.InverseEntrySet.this;
            }
            
            public Map.Entry<V, K> get(int param3Int) {
              Map.Entry entry = RegularImmutableBiMap.this.entries[param3Int];
              return Maps.immutableEntry((V)entry.getValue(), (K)entry.getKey());
            }
          };
      }
      
      public int hashCode() {
        return RegularImmutableBiMap.this.hashCode;
      }
      
      boolean isHashCodeFast() {
        return true;
      }
      
      public UnmodifiableIterator<Map.Entry<V, K>> iterator() {
        return asList().iterator();
      }
      
      ImmutableMap<V, K> map() {
        return RegularImmutableBiMap.Inverse.this;
      }
    }
    
    class null extends ImmutableAsList<Map.Entry<V, K>> {
      ImmutableCollection<Map.Entry<V, K>> delegateCollection() {
        return this.this$2;
      }
      
      public Map.Entry<V, K> get(int param2Int) {
        Map.Entry entry = RegularImmutableBiMap.this.entries[param2Int];
        return Maps.immutableEntry((V)entry.getValue(), (K)entry.getKey());
      }
    }
  }
  
  final class InverseEntrySet extends ImmutableMapEntrySet<V, K> {
    ImmutableList<Map.Entry<V, K>> createAsList() {
      return new ImmutableAsList<Map.Entry<V, K>>() {
          ImmutableCollection<Map.Entry<V, K>> delegateCollection() {
            return RegularImmutableBiMap.Inverse.InverseEntrySet.this;
          }
          
          public Map.Entry<V, K> get(int param3Int) {
            Map.Entry entry = RegularImmutableBiMap.this.entries[param3Int];
            return Maps.immutableEntry((V)entry.getValue(), (K)entry.getKey());
          }
        };
    }
    
    public int hashCode() {
      return RegularImmutableBiMap.this.hashCode;
    }
    
    boolean isHashCodeFast() {
      return true;
    }
    
    public UnmodifiableIterator<Map.Entry<V, K>> iterator() {
      return asList().iterator();
    }
    
    ImmutableMap<V, K> map() {
      return this.this$1;
    }
  }
  
  class null extends ImmutableAsList<Map.Entry<V, K>> {
    ImmutableCollection<Map.Entry<V, K>> delegateCollection() {
      return this.this$2;
    }
    
    public Map.Entry<V, K> get(int param1Int) {
      Map.Entry entry = RegularImmutableBiMap.this.entries[param1Int];
      return Maps.immutableEntry((V)entry.getValue(), (K)entry.getKey());
    }
  }
  
  private static class InverseSerializedForm<K, V> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private final ImmutableBiMap<K, V> forward;
    
    InverseSerializedForm(ImmutableBiMap<K, V> param1ImmutableBiMap) {
      this.forward = param1ImmutableBiMap;
    }
    
    Object readResolve() {
      return this.forward.inverse();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\RegularImmutableBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */