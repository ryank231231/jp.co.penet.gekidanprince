package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
  private static final double MAX_LOAD_FACTOR = 1.2D;
  
  private static final long serialVersionUID = 0L;
  
  private final transient Map.Entry<K, V>[] entries;
  
  private final transient int mask;
  
  private final transient ImmutableMapEntry<K, V>[] table;
  
  private RegularImmutableMap(Map.Entry<K, V>[] paramArrayOfEntry, ImmutableMapEntry<K, V>[] paramArrayOfImmutableMapEntry, int paramInt) {
    this.entries = paramArrayOfEntry;
    this.table = paramArrayOfImmutableMapEntry;
    this.mask = paramInt;
  }
  
  static void checkNoConflictInKeyBucket(Object paramObject, Map.Entry<?, ?> paramEntry, @Nullable ImmutableMapEntry<?, ?> paramImmutableMapEntry) {
    while (paramImmutableMapEntry != null) {
      checkNoConflict(paramObject.equals(paramImmutableMapEntry.getKey()) ^ true, "key", paramEntry, paramImmutableMapEntry);
      paramImmutableMapEntry = paramImmutableMapEntry.getNextInKeyBucket();
    } 
  }
  
  static <K, V> RegularImmutableMap<K, V> fromEntries(Map.Entry<K, V>... paramVarArgs) {
    return fromEntryArray(paramVarArgs.length, paramVarArgs);
  }
  
  static <K, V> RegularImmutableMap<K, V> fromEntryArray(int paramInt, Map.Entry<K, V>[] paramArrayOfEntry) {
    ImmutableMapEntry[] arrayOfImmutableMapEntry1;
    Preconditions.checkPositionIndex(paramInt, paramArrayOfEntry.length);
    if (paramInt == paramArrayOfEntry.length) {
      Map.Entry<K, V>[] arrayOfEntry = paramArrayOfEntry;
    } else {
      arrayOfImmutableMapEntry1 = ImmutableMapEntry.createEntryArray(paramInt);
    } 
    int i = Hashing.closedTableSize(paramInt, 1.2D);
    ImmutableMapEntry[] arrayOfImmutableMapEntry2 = (ImmutableMapEntry[])ImmutableMapEntry.createEntryArray(i);
    int j = i - 1;
    for (i = 0; i < paramInt; i++) {
      Map.Entry<K, V> entry = paramArrayOfEntry[i];
      K k = entry.getKey();
      V v = entry.getValue();
      CollectPreconditions.checkEntryNotNull(k, v);
      int m = Hashing.smear(k.hashCode()) & j;
      ImmutableMapEntry<K, V> immutableMapEntry = arrayOfImmutableMapEntry2[m];
      if (immutableMapEntry == null) {
        boolean bool;
        if (entry instanceof ImmutableMapEntry && ((ImmutableMapEntry)entry).isReusable()) {
          bool = true;
        } else {
          bool = false;
        } 
        if (bool) {
          entry = entry;
        } else {
          entry = new ImmutableMapEntry<K, V>(k, v);
        } 
      } else {
        entry = new ImmutableMapEntry.NonTerminalImmutableMapEntry<K, V>(k, v, immutableMapEntry);
      } 
      arrayOfImmutableMapEntry2[m] = (ImmutableMapEntry)entry;
      arrayOfImmutableMapEntry1[i] = (ImmutableMapEntry)entry;
      checkNoConflictInKeyBucket(k, entry, immutableMapEntry);
    } 
    return new RegularImmutableMap<K, V>((Map.Entry<K, V>[])arrayOfImmutableMapEntry1, (ImmutableMapEntry<K, V>[])arrayOfImmutableMapEntry2, j);
  }
  
  @Nullable
  static <V> V get(@Nullable Object paramObject, ImmutableMapEntry<?, V>[] paramArrayOfImmutableMapEntry, int paramInt) {
    if (paramObject == null)
      return null; 
    for (ImmutableMapEntry<?, V> immutableMapEntry = paramArrayOfImmutableMapEntry[paramInt & Hashing.smear(paramObject.hashCode())]; immutableMapEntry != null; immutableMapEntry = immutableMapEntry.getNextInKeyBucket()) {
      if (paramObject.equals(immutableMapEntry.getKey()))
        return immutableMapEntry.getValue(); 
    } 
    return null;
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet() {
    return new ImmutableMapEntrySet.RegularEntrySet<K, V>(this, this.entries);
  }
  
  ImmutableSet<K> createKeySet() {
    return new KeySet<K, Object>(this);
  }
  
  ImmutableCollection<V> createValues() {
    return new Values<Object, V>(this);
  }
  
  public V get(@Nullable Object paramObject) {
    return get(paramObject, (ImmutableMapEntry<?, V>[])this.table, this.mask);
  }
  
  boolean isPartialView() {
    return false;
  }
  
  public int size() {
    return this.entries.length;
  }
  
  @GwtCompatible(emulated = true)
  private static final class KeySet<K, V> extends ImmutableSet.Indexed<K> {
    @Weak
    private final RegularImmutableMap<K, V> map;
    
    KeySet(RegularImmutableMap<K, V> param1RegularImmutableMap) {
      this.map = param1RegularImmutableMap;
    }
    
    public boolean contains(Object param1Object) {
      return this.map.containsKey(param1Object);
    }
    
    K get(int param1Int) {
      return this.map.entries[param1Int].getKey();
    }
    
    boolean isPartialView() {
      return true;
    }
    
    public int size() {
      return this.map.size();
    }
    
    @GwtIncompatible
    Object writeReplace() {
      return new SerializedForm<K>(this.map);
    }
    
    @GwtIncompatible
    private static class SerializedForm<K> implements Serializable {
      private static final long serialVersionUID = 0L;
      
      final ImmutableMap<K, ?> map;
      
      SerializedForm(ImmutableMap<K, ?> param2ImmutableMap) {
        this.map = param2ImmutableMap;
      }
      
      Object readResolve() {
        return this.map.keySet();
      }
    }
  }
  
  @GwtIncompatible
  private static class SerializedForm<K> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final ImmutableMap<K, ?> map;
    
    SerializedForm(ImmutableMap<K, ?> param1ImmutableMap) {
      this.map = param1ImmutableMap;
    }
    
    Object readResolve() {
      return this.map.keySet();
    }
  }
  
  @GwtCompatible(emulated = true)
  private static final class Values<K, V> extends ImmutableList<V> {
    @Weak
    final RegularImmutableMap<K, V> map;
    
    Values(RegularImmutableMap<K, V> param1RegularImmutableMap) {
      this.map = param1RegularImmutableMap;
    }
    
    public V get(int param1Int) {
      return this.map.entries[param1Int].getValue();
    }
    
    boolean isPartialView() {
      return true;
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
      
      SerializedForm(ImmutableMap<?, V> param2ImmutableMap) {
        this.map = param2ImmutableMap;
      }
      
      Object readResolve() {
        return this.map.values();
      }
    }
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


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\RegularImmutableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */