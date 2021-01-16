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
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class HashBiMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> implements BiMap<K, V>, Serializable {
  private static final double LOAD_FACTOR = 1.0D;
  
  @GwtIncompatible
  private static final long serialVersionUID = 0L;
  
  private transient BiEntry<K, V> firstInKeyInsertionOrder;
  
  private transient BiEntry<K, V>[] hashTableKToV;
  
  private transient BiEntry<K, V>[] hashTableVToK;
  
  @RetainedWith
  private transient BiMap<V, K> inverse;
  
  private transient BiEntry<K, V> lastInKeyInsertionOrder;
  
  private transient int mask;
  
  private transient int modCount;
  
  private transient int size;
  
  private HashBiMap(int paramInt) {
    init(paramInt);
  }
  
  public static <K, V> HashBiMap<K, V> create() {
    return create(16);
  }
  
  public static <K, V> HashBiMap<K, V> create(int paramInt) {
    return new HashBiMap<K, V>(paramInt);
  }
  
  public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> paramMap) {
    HashBiMap<?, ?> hashBiMap = create(paramMap.size());
    hashBiMap.putAll(paramMap);
    return (HashBiMap)hashBiMap;
  }
  
  private BiEntry<K, V>[] createTable(int paramInt) {
    return (BiEntry<K, V>[])new BiEntry[paramInt];
  }
  
  private void delete(BiEntry<K, V> paramBiEntry) {
    int i = paramBiEntry.keyHash & this.mask;
    BiEntry<K, V> biEntry1 = this.hashTableKToV[i];
    BiEntry<K, V> biEntry2 = null;
    while (true) {
      if (biEntry1 == paramBiEntry) {
        if (biEntry2 == null) {
          this.hashTableKToV[i] = paramBiEntry.nextInKToVBucket;
        } else {
          biEntry2.nextInKToVBucket = paramBiEntry.nextInKToVBucket;
        } 
        i = paramBiEntry.valueHash & this.mask;
        biEntry1 = this.hashTableVToK[i];
        biEntry2 = null;
        while (true) {
          if (biEntry1 == paramBiEntry) {
            if (biEntry2 == null) {
              this.hashTableVToK[i] = paramBiEntry.nextInVToKBucket;
            } else {
              biEntry2.nextInVToKBucket = paramBiEntry.nextInVToKBucket;
            } 
            if (paramBiEntry.prevInKeyInsertionOrder == null) {
              this.firstInKeyInsertionOrder = paramBiEntry.nextInKeyInsertionOrder;
            } else {
              paramBiEntry.prevInKeyInsertionOrder.nextInKeyInsertionOrder = paramBiEntry.nextInKeyInsertionOrder;
            } 
            if (paramBiEntry.nextInKeyInsertionOrder == null) {
              this.lastInKeyInsertionOrder = paramBiEntry.prevInKeyInsertionOrder;
            } else {
              paramBiEntry.nextInKeyInsertionOrder.prevInKeyInsertionOrder = paramBiEntry.prevInKeyInsertionOrder;
            } 
            this.size--;
            this.modCount++;
            return;
          } 
          BiEntry<K, V> biEntry3 = biEntry1.nextInVToKBucket;
          biEntry2 = biEntry1;
          biEntry1 = biEntry3;
        } 
        break;
      } 
      BiEntry<K, V> biEntry = biEntry1.nextInKToVBucket;
      biEntry2 = biEntry1;
      biEntry1 = biEntry;
    } 
  }
  
  private void init(int paramInt) {
    CollectPreconditions.checkNonnegative(paramInt, "expectedSize");
    paramInt = Hashing.closedTableSize(paramInt, 1.0D);
    this.hashTableKToV = createTable(paramInt);
    this.hashTableVToK = createTable(paramInt);
    this.firstInKeyInsertionOrder = null;
    this.lastInKeyInsertionOrder = null;
    this.size = 0;
    this.mask = paramInt - 1;
    this.modCount = 0;
  }
  
  private void insert(BiEntry<K, V> paramBiEntry1, @Nullable BiEntry<K, V> paramBiEntry2) {
    int i = paramBiEntry1.keyHash & this.mask;
    BiEntry<K, V>[] arrayOfBiEntry = this.hashTableKToV;
    paramBiEntry1.nextInKToVBucket = arrayOfBiEntry[i];
    arrayOfBiEntry[i] = paramBiEntry1;
    i = paramBiEntry1.valueHash & this.mask;
    arrayOfBiEntry = this.hashTableVToK;
    paramBiEntry1.nextInVToKBucket = arrayOfBiEntry[i];
    arrayOfBiEntry[i] = paramBiEntry1;
    if (paramBiEntry2 == null) {
      paramBiEntry2 = this.lastInKeyInsertionOrder;
      paramBiEntry1.prevInKeyInsertionOrder = paramBiEntry2;
      paramBiEntry1.nextInKeyInsertionOrder = null;
      if (paramBiEntry2 == null) {
        this.firstInKeyInsertionOrder = paramBiEntry1;
      } else {
        paramBiEntry2.nextInKeyInsertionOrder = paramBiEntry1;
      } 
      this.lastInKeyInsertionOrder = paramBiEntry1;
    } else {
      paramBiEntry1.prevInKeyInsertionOrder = paramBiEntry2.prevInKeyInsertionOrder;
      if (paramBiEntry1.prevInKeyInsertionOrder == null) {
        this.firstInKeyInsertionOrder = paramBiEntry1;
      } else {
        paramBiEntry1.prevInKeyInsertionOrder.nextInKeyInsertionOrder = paramBiEntry1;
      } 
      paramBiEntry1.nextInKeyInsertionOrder = paramBiEntry2.nextInKeyInsertionOrder;
      if (paramBiEntry1.nextInKeyInsertionOrder == null) {
        this.lastInKeyInsertionOrder = paramBiEntry1;
      } else {
        paramBiEntry1.nextInKeyInsertionOrder.prevInKeyInsertionOrder = paramBiEntry1;
      } 
    } 
    this.size++;
    this.modCount++;
  }
  
  private V put(@Nullable K paramK, @Nullable V paramV, boolean paramBoolean) {
    StringBuilder stringBuilder;
    int i = Hashing.smearedHash(paramK);
    int j = Hashing.smearedHash(paramV);
    BiEntry<K, V> biEntry1 = seekByKey(paramK, i);
    if (biEntry1 != null && j == biEntry1.valueHash && Objects.equal(paramV, biEntry1.value))
      return paramV; 
    BiEntry<K, V> biEntry2 = seekByValue(paramV, j);
    if (biEntry2 != null)
      if (paramBoolean) {
        delete(biEntry2);
      } else {
        stringBuilder = new StringBuilder();
        stringBuilder.append("value already present: ");
        stringBuilder.append(paramV);
        throw new IllegalArgumentException(stringBuilder.toString());
      }  
    BiEntry<StringBuilder, V> biEntry = new BiEntry<StringBuilder, V>(stringBuilder, i, paramV, j);
    if (biEntry1 != null) {
      delete(biEntry1);
      insert((BiEntry)biEntry, biEntry1);
      biEntry1.prevInKeyInsertionOrder = null;
      biEntry1.nextInKeyInsertionOrder = null;
      rehashIfNecessary();
      return biEntry1.value;
    } 
    insert((BiEntry)biEntry, (BiEntry<K, V>)null);
    rehashIfNecessary();
    return null;
  }
  
  @Nullable
  private K putInverse(@Nullable V paramV, @Nullable K paramK, boolean paramBoolean) {
    StringBuilder stringBuilder;
    int i = Hashing.smearedHash(paramV);
    int j = Hashing.smearedHash(paramK);
    BiEntry<K, V> biEntry1 = seekByValue(paramV, i);
    if (biEntry1 != null && j == biEntry1.keyHash && Objects.equal(paramK, biEntry1.key))
      return paramK; 
    BiEntry<K, V> biEntry2 = seekByKey(paramK, j);
    if (biEntry2 != null)
      if (paramBoolean) {
        delete(biEntry2);
      } else {
        stringBuilder = new StringBuilder();
        stringBuilder.append("value already present: ");
        stringBuilder.append(paramK);
        throw new IllegalArgumentException(stringBuilder.toString());
      }  
    if (biEntry1 != null)
      delete(biEntry1); 
    insert(new BiEntry<K, V>(paramK, j, (V)stringBuilder, i), biEntry2);
    if (biEntry2 != null) {
      biEntry2.prevInKeyInsertionOrder = null;
      biEntry2.nextInKeyInsertionOrder = null;
    } 
    rehashIfNecessary();
    return Maps.keyOrNull(biEntry1);
  }
  
  @GwtIncompatible
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    init(16);
    Serialization.populateMap(this, paramObjectInputStream, Serialization.readCount(paramObjectInputStream));
  }
  
  private void rehashIfNecessary() {
    BiEntry<K, V>[] arrayOfBiEntry = this.hashTableKToV;
    if (Hashing.needsResizing(this.size, arrayOfBiEntry.length, 1.0D)) {
      int i = arrayOfBiEntry.length * 2;
      this.hashTableKToV = createTable(i);
      this.hashTableVToK = createTable(i);
      this.mask = i - 1;
      this.size = 0;
      for (BiEntry<K, V> biEntry = this.firstInKeyInsertionOrder; biEntry != null; biEntry = biEntry.nextInKeyInsertionOrder)
        insert(biEntry, biEntry); 
      this.modCount++;
    } 
  }
  
  private BiEntry<K, V> seekByKey(@Nullable Object paramObject, int paramInt) {
    for (BiEntry<K, V> biEntry = this.hashTableKToV[this.mask & paramInt]; biEntry != null; biEntry = biEntry.nextInKToVBucket) {
      if (paramInt == biEntry.keyHash && Objects.equal(paramObject, biEntry.key))
        return biEntry; 
    } 
    return null;
  }
  
  private BiEntry<K, V> seekByValue(@Nullable Object paramObject, int paramInt) {
    for (BiEntry<K, V> biEntry = this.hashTableVToK[this.mask & paramInt]; biEntry != null; biEntry = biEntry.nextInVToKBucket) {
      if (paramInt == biEntry.valueHash && Objects.equal(paramObject, biEntry.value))
        return biEntry; 
    } 
    return null;
  }
  
  @GwtIncompatible
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.defaultWriteObject();
    Serialization.writeMap(this, paramObjectOutputStream);
  }
  
  public void clear() {
    this.size = 0;
    Arrays.fill((Object[])this.hashTableKToV, (Object)null);
    Arrays.fill((Object[])this.hashTableVToK, (Object)null);
    this.firstInKeyInsertionOrder = null;
    this.lastInKeyInsertionOrder = null;
    this.modCount++;
  }
  
  public boolean containsKey(@Nullable Object paramObject) {
    boolean bool;
    if (seekByKey(paramObject, Hashing.smearedHash(paramObject)) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean containsValue(@Nullable Object paramObject) {
    boolean bool;
    if (seekByValue(paramObject, Hashing.smearedHash(paramObject)) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  Iterator<Map.Entry<K, V>> entryIterator() {
    return new Itr<Map.Entry<K, V>>() {
        Map.Entry<K, V> output(HashBiMap.BiEntry<K, V> param1BiEntry) {
          return new MapEntry(param1BiEntry);
        }
        
        class MapEntry extends AbstractMapEntry<K, V> {
          HashBiMap.BiEntry<K, V> delegate;
          
          public K getKey() {
            return this.delegate.key;
          }
          
          public V getValue() {
            return this.delegate.value;
          }
          
          public V setValue(V param2V) {
            boolean bool;
            V v = this.delegate.value;
            int i = Hashing.smearedHash(param2V);
            if (i == this.delegate.valueHash && Objects.equal(param2V, v))
              return param2V; 
            if (HashBiMap.this.seekByValue(param2V, i) == null) {
              bool = true;
            } else {
              bool = false;
            } 
            Preconditions.checkArgument(bool, "value already present: %s", param2V);
            HashBiMap.this.delete(this.delegate);
            HashBiMap.BiEntry<K, V> biEntry1 = new HashBiMap.BiEntry<K, V>(this.delegate.key, this.delegate.keyHash, param2V, i);
            HashBiMap.this.insert(biEntry1, this.delegate);
            HashBiMap.BiEntry<K, V> biEntry2 = this.delegate;
            biEntry2.prevInKeyInsertionOrder = null;
            biEntry2.nextInKeyInsertionOrder = null;
            HashBiMap.null  = HashBiMap.null.this;
            .expectedModCount = HashBiMap.this.modCount;
            if (HashBiMap.null.this.toRemove == this.delegate)
              HashBiMap.null.this.toRemove = biEntry1; 
            this.delegate = biEntry1;
            return v;
          }
        }
      };
  }
  
  @CanIgnoreReturnValue
  public V forcePut(@Nullable K paramK, @Nullable V paramV) {
    return put(paramK, paramV, true);
  }
  
  @Nullable
  public V get(@Nullable Object paramObject) {
    return Maps.valueOrNull(seekByKey(paramObject, Hashing.smearedHash(paramObject)));
  }
  
  public BiMap<V, K> inverse() {
    BiMap<V, K> biMap1 = this.inverse;
    BiMap<V, K> biMap2 = biMap1;
    if (biMap1 == null) {
      biMap2 = new Inverse();
      this.inverse = biMap2;
    } 
    return biMap2;
  }
  
  public Set<K> keySet() {
    return new KeySet();
  }
  
  @CanIgnoreReturnValue
  public V put(@Nullable K paramK, @Nullable V paramV) {
    return put(paramK, paramV, false);
  }
  
  @CanIgnoreReturnValue
  public V remove(@Nullable Object<K, V> paramObject) {
    paramObject = (Object<K, V>)seekByKey(paramObject, Hashing.smearedHash(paramObject));
    if (paramObject == null)
      return null; 
    delete((BiEntry<K, V>)paramObject);
    ((BiEntry)paramObject).prevInKeyInsertionOrder = null;
    ((BiEntry)paramObject).nextInKeyInsertionOrder = null;
    return ((BiEntry)paramObject).value;
  }
  
  public int size() {
    return this.size;
  }
  
  public Set<V> values() {
    return inverse().keySet();
  }
  
  private static final class BiEntry<K, V> extends ImmutableEntry<K, V> {
    final int keyHash;
    
    @Nullable
    BiEntry<K, V> nextInKToVBucket;
    
    @Nullable
    BiEntry<K, V> nextInKeyInsertionOrder;
    
    @Nullable
    BiEntry<K, V> nextInVToKBucket;
    
    @Nullable
    BiEntry<K, V> prevInKeyInsertionOrder;
    
    final int valueHash;
    
    BiEntry(K param1K, int param1Int1, V param1V, int param1Int2) {
      super(param1K, param1V);
      this.keyHash = param1Int1;
      this.valueHash = param1Int2;
    }
  }
  
  private final class Inverse extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
    private Inverse() {}
    
    public void clear() {
      forward().clear();
    }
    
    public boolean containsKey(@Nullable Object param1Object) {
      return forward().containsValue(param1Object);
    }
    
    public Set<Map.Entry<V, K>> entrySet() {
      return new Maps.EntrySet<K, V>() {
          public Iterator<Map.Entry<V, K>> iterator() {
            return new HashBiMap<K, V>.Itr<Map.Entry<V, K>>() {
                Map.Entry<V, K> output(HashBiMap.BiEntry<K, V> param3BiEntry) {
                  return new InverseEntry(param3BiEntry);
                }
                
                class InverseEntry extends AbstractMapEntry<V, K> {
                  HashBiMap.BiEntry<K, V> delegate;
                  
                  public V getKey() {
                    return this.delegate.value;
                  }
                  
                  public K getValue() {
                    return this.delegate.key;
                  }
                  
                  public K setValue(K param4K) {
                    boolean bool;
                    K k = this.delegate.key;
                    int i = Hashing.smearedHash(param4K);
                    if (i == this.delegate.keyHash && Objects.equal(param4K, k))
                      return param4K; 
                    if (HashBiMap.this.seekByKey(param4K, i) == null) {
                      bool = true;
                    } else {
                      bool = false;
                    } 
                    Preconditions.checkArgument(bool, "value already present: %s", param4K);
                    HashBiMap.this.delete(this.delegate);
                    HashBiMap.BiEntry<K, V> biEntry = new HashBiMap.BiEntry<K, V>(param4K, i, this.delegate.value, this.delegate.valueHash);
                    this.delegate = biEntry;
                    HashBiMap.this.insert(biEntry, (HashBiMap.BiEntry<K, V>)null);
                    HashBiMap.Inverse.null.null  = HashBiMap.Inverse.null.null.this;
                    .expectedModCount = HashBiMap.this.modCount;
                    return k;
                  }
                }
              };
          }
          
          Map<V, K> map() {
            return HashBiMap.Inverse.this;
          }
        };
    }
    
    public K forcePut(@Nullable V param1V, @Nullable K param1K) {
      return HashBiMap.this.putInverse(param1V, param1K, true);
    }
    
    BiMap<K, V> forward() {
      return HashBiMap.this;
    }
    
    public K get(@Nullable Object param1Object) {
      return Maps.keyOrNull(HashBiMap.this.seekByValue(param1Object, Hashing.smearedHash(param1Object)));
    }
    
    public BiMap<K, V> inverse() {
      return forward();
    }
    
    public Set<V> keySet() {
      return new InverseKeySet();
    }
    
    public K put(@Nullable V param1V, @Nullable K param1K) {
      return HashBiMap.this.putInverse(param1V, param1K, false);
    }
    
    public K remove(@Nullable Object param1Object) {
      param1Object = HashBiMap.this.seekByValue(param1Object, Hashing.smearedHash(param1Object));
      if (param1Object == null)
        return null; 
      HashBiMap.this.delete((HashBiMap.BiEntry<K, V>)param1Object);
      ((HashBiMap.BiEntry)param1Object).prevInKeyInsertionOrder = null;
      ((HashBiMap.BiEntry)param1Object).nextInKeyInsertionOrder = null;
      return ((HashBiMap.BiEntry)param1Object).key;
    }
    
    public int size() {
      return HashBiMap.this.size;
    }
    
    public Set<K> values() {
      return forward().keySet();
    }
    
    Object writeReplace() {
      return new HashBiMap.InverseSerializedForm<Object, Object>(HashBiMap.this);
    }
    
    private final class InverseKeySet extends Maps.KeySet<V, K> {
      InverseKeySet() {
        super(HashBiMap.Inverse.this);
      }
      
      public Iterator<V> iterator() {
        return new HashBiMap<K, V>.Itr<V>() {
            V output(HashBiMap.BiEntry<K, V> param3BiEntry) {
              return param3BiEntry.value;
            }
          };
      }
      
      public boolean remove(@Nullable Object param2Object) {
        param2Object = HashBiMap.this.seekByValue(param2Object, Hashing.smearedHash(param2Object));
        if (param2Object == null)
          return false; 
        HashBiMap.this.delete((HashBiMap.BiEntry<K, V>)param2Object);
        return true;
      }
    }
    
    class null extends HashBiMap<K, V>.Itr<V> {
      V output(HashBiMap.BiEntry<K, V> param2BiEntry) {
        return param2BiEntry.value;
      }
    }
  }
  
  class null extends Maps.EntrySet<V, K> {
    public Iterator<Map.Entry<V, K>> iterator() {
      return new HashBiMap<K, V>.Itr<Map.Entry<V, K>>() {
          Map.Entry<V, K> output(HashBiMap.BiEntry<K, V> param3BiEntry) {
            return new InverseEntry(param3BiEntry);
          }
          
          class InverseEntry extends AbstractMapEntry<V, K> {
            HashBiMap.BiEntry<K, V> delegate;
            
            public V getKey() {
              return this.delegate.value;
            }
            
            public K getValue() {
              return this.delegate.key;
            }
            
            public K setValue(K param4K) {
              boolean bool;
              K k = this.delegate.key;
              int i = Hashing.smearedHash(param4K);
              if (i == this.delegate.keyHash && Objects.equal(param4K, k))
                return param4K; 
              if (HashBiMap.this.seekByKey(param4K, i) == null) {
                bool = true;
              } else {
                bool = false;
              } 
              Preconditions.checkArgument(bool, "value already present: %s", param4K);
              HashBiMap.this.delete(this.delegate);
              HashBiMap.BiEntry<K, V> biEntry = new HashBiMap.BiEntry<K, V>(param4K, i, this.delegate.value, this.delegate.valueHash);
              this.delegate = biEntry;
              HashBiMap.this.insert(biEntry, (HashBiMap.BiEntry<K, V>)null);
              HashBiMap.Inverse.null.null  = HashBiMap.Inverse.null.null.this;
              .expectedModCount = HashBiMap.this.modCount;
              return k;
            }
          }
        };
    }
    
    Map<V, K> map() {
      return this.this$1;
    }
  }
  
  class null extends Itr<Map.Entry<V, K>> {
    Map.Entry<V, K> output(HashBiMap.BiEntry<K, V> param1BiEntry) {
      return new InverseEntry(param1BiEntry);
    }
    
    class InverseEntry extends AbstractMapEntry<V, K> {
      HashBiMap.BiEntry<K, V> delegate;
      
      public V getKey() {
        return this.delegate.value;
      }
      
      public K getValue() {
        return this.delegate.key;
      }
      
      public K setValue(K param4K) {
        boolean bool;
        K k = this.delegate.key;
        int i = Hashing.smearedHash(param4K);
        if (i == this.delegate.keyHash && Objects.equal(param4K, k))
          return param4K; 
        if (HashBiMap.this.seekByKey(param4K, i) == null) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.checkArgument(bool, "value already present: %s", param4K);
        HashBiMap.this.delete(this.delegate);
        HashBiMap.BiEntry<K, V> biEntry = new HashBiMap.BiEntry<K, V>(param4K, i, this.delegate.value, this.delegate.valueHash);
        this.delegate = biEntry;
        HashBiMap.this.insert(biEntry, (HashBiMap.BiEntry<K, V>)null);
        HashBiMap.Inverse.null.null  = HashBiMap.Inverse.null.null.this;
        .expectedModCount = HashBiMap.this.modCount;
        return k;
      }
    }
  }
  
  class InverseEntry extends AbstractMapEntry<V, K> {
    HashBiMap.BiEntry<K, V> delegate;
    
    public V getKey() {
      return this.delegate.value;
    }
    
    public K getValue() {
      return this.delegate.key;
    }
    
    public K setValue(K param1K) {
      boolean bool;
      K k = this.delegate.key;
      int i = Hashing.smearedHash(param1K);
      if (i == this.delegate.keyHash && Objects.equal(param1K, k))
        return param1K; 
      if (HashBiMap.this.seekByKey(param1K, i) == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "value already present: %s", param1K);
      HashBiMap.this.delete(this.delegate);
      HashBiMap.BiEntry<K, V> biEntry = new HashBiMap.BiEntry<K, V>(param1K, i, this.delegate.value, this.delegate.valueHash);
      this.delegate = biEntry;
      HashBiMap.this.insert(biEntry, (HashBiMap.BiEntry<K, V>)null);
      HashBiMap.Inverse.null.null  = this.this$3;
      .expectedModCount = HashBiMap.this.modCount;
      return k;
    }
  }
  
  private final class InverseKeySet extends Maps.KeySet<V, K> {
    InverseKeySet() {
      super(HashBiMap.this);
    }
    
    public Iterator<V> iterator() {
      return new HashBiMap<K, V>.Itr<V>() {
          V output(HashBiMap.BiEntry<K, V> param3BiEntry) {
            return param3BiEntry.value;
          }
        };
    }
    
    public boolean remove(@Nullable Object param1Object) {
      param1Object = HashBiMap.this.seekByValue(param1Object, Hashing.smearedHash(param1Object));
      if (param1Object == null)
        return false; 
      HashBiMap.this.delete((HashBiMap.BiEntry<K, V>)param1Object);
      return true;
    }
  }
  
  class null extends Itr<V> {
    V output(HashBiMap.BiEntry<K, V> param1BiEntry) {
      return param1BiEntry.value;
    }
  }
  
  private static final class InverseSerializedForm<K, V> implements Serializable {
    private final HashBiMap<K, V> bimap;
    
    InverseSerializedForm(HashBiMap<K, V> param1HashBiMap) {
      this.bimap = param1HashBiMap;
    }
    
    Object readResolve() {
      return this.bimap.inverse();
    }
  }
  
  abstract class Itr<T> implements Iterator<T> {
    int expectedModCount = HashBiMap.this.modCount;
    
    HashBiMap.BiEntry<K, V> next = HashBiMap.this.firstInKeyInsertionOrder;
    
    HashBiMap.BiEntry<K, V> toRemove = null;
    
    public boolean hasNext() {
      if (HashBiMap.this.modCount == this.expectedModCount) {
        boolean bool;
        if (this.next != null) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      } 
      throw new ConcurrentModificationException();
    }
    
    public T next() {
      if (hasNext()) {
        HashBiMap.BiEntry<K, V> biEntry = this.next;
        this.next = biEntry.nextInKeyInsertionOrder;
        this.toRemove = biEntry;
        return output(biEntry);
      } 
      throw new NoSuchElementException();
    }
    
    abstract T output(HashBiMap.BiEntry<K, V> param1BiEntry);
    
    public void remove() {
      if (HashBiMap.this.modCount == this.expectedModCount) {
        boolean bool;
        if (this.toRemove != null) {
          bool = true;
        } else {
          bool = false;
        } 
        CollectPreconditions.checkRemove(bool);
        HashBiMap.this.delete(this.toRemove);
        this.expectedModCount = HashBiMap.this.modCount;
        this.toRemove = null;
        return;
      } 
      throw new ConcurrentModificationException();
    }
  }
  
  private final class KeySet extends Maps.KeySet<K, V> {
    KeySet() {
      super(HashBiMap.this);
    }
    
    public Iterator<K> iterator() {
      return new HashBiMap<K, V>.Itr<K>() {
          K output(HashBiMap.BiEntry<K, V> param2BiEntry) {
            return param2BiEntry.key;
          }
        };
    }
    
    public boolean remove(@Nullable Object param1Object) {
      param1Object = HashBiMap.this.seekByKey(param1Object, Hashing.smearedHash(param1Object));
      if (param1Object == null)
        return false; 
      HashBiMap.this.delete((HashBiMap.BiEntry<K, V>)param1Object);
      ((HashBiMap.BiEntry)param1Object).prevInKeyInsertionOrder = null;
      ((HashBiMap.BiEntry)param1Object).nextInKeyInsertionOrder = null;
      return true;
    }
  }
  
  class null extends Itr<K> {
    K output(HashBiMap.BiEntry<K, V> param1BiEntry) {
      return param1BiEntry.key;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\HashBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */