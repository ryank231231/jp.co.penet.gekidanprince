package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public final class LinkedHashMultimap<K, V> extends AbstractSetMultimap<K, V> {
  private static final int DEFAULT_KEY_CAPACITY = 16;
  
  private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
  
  @VisibleForTesting
  static final double VALUE_SET_LOAD_FACTOR = 1.0D;
  
  @GwtIncompatible
  private static final long serialVersionUID = 1L;
  
  private transient ValueEntry<K, V> multimapHeaderEntry;
  
  @VisibleForTesting
  transient int valueSetCapacity = 2;
  
  private LinkedHashMultimap(int paramInt1, int paramInt2) {
    super(new LinkedHashMap<K, Collection<V>>(paramInt1));
    CollectPreconditions.checkNonnegative(paramInt2, "expectedValuesPerKey");
    this.valueSetCapacity = paramInt2;
    this.multimapHeaderEntry = new ValueEntry<K, V>(null, null, 0, null);
    ValueEntry<K, V> valueEntry = this.multimapHeaderEntry;
    succeedsInMultimap(valueEntry, valueEntry);
  }
  
  public static <K, V> LinkedHashMultimap<K, V> create() {
    return new LinkedHashMultimap<K, V>(16, 2);
  }
  
  public static <K, V> LinkedHashMultimap<K, V> create(int paramInt1, int paramInt2) {
    return new LinkedHashMultimap<K, V>(Maps.capacity(paramInt1), Maps.capacity(paramInt2));
  }
  
  public static <K, V> LinkedHashMultimap<K, V> create(Multimap<? extends K, ? extends V> paramMultimap) {
    LinkedHashMultimap<?, ?> linkedHashMultimap = create(paramMultimap.keySet().size(), 2);
    linkedHashMultimap.putAll(paramMultimap);
    return (LinkedHashMultimap)linkedHashMultimap;
  }
  
  private static <K, V> void deleteFromMultimap(ValueEntry<K, V> paramValueEntry) {
    succeedsInMultimap(paramValueEntry.getPredecessorInMultimap(), paramValueEntry.getSuccessorInMultimap());
  }
  
  private static <K, V> void deleteFromValueSet(ValueSetLink<K, V> paramValueSetLink) {
    succeedsInValueSet(paramValueSetLink.getPredecessorInValueSet(), paramValueSetLink.getSuccessorInValueSet());
  }
  
  @GwtIncompatible
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    boolean bool = false;
    this.multimapHeaderEntry = new ValueEntry<K, V>(null, null, 0, null);
    ValueEntry<K, V> valueEntry = this.multimapHeaderEntry;
    succeedsInMultimap(valueEntry, valueEntry);
    this.valueSetCapacity = 2;
    int i = paramObjectInputStream.readInt();
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    byte b;
    for (b = 0; b < i; b++) {
      Object object = paramObjectInputStream.readObject();
      linkedHashMap.put(object, createCollection((K)object));
    } 
    i = paramObjectInputStream.readInt();
    for (b = bool; b < i; b++) {
      Object object1 = paramObjectInputStream.readObject();
      Object object2 = paramObjectInputStream.readObject();
      ((Collection<Object>)linkedHashMap.get(object1)).add(object2);
    } 
    setMap((Map)linkedHashMap);
  }
  
  private static <K, V> void succeedsInMultimap(ValueEntry<K, V> paramValueEntry1, ValueEntry<K, V> paramValueEntry2) {
    paramValueEntry1.setSuccessorInMultimap(paramValueEntry2);
    paramValueEntry2.setPredecessorInMultimap(paramValueEntry1);
  }
  
  private static <K, V> void succeedsInValueSet(ValueSetLink<K, V> paramValueSetLink1, ValueSetLink<K, V> paramValueSetLink2) {
    paramValueSetLink1.setSuccessorInValueSet(paramValueSetLink2);
    paramValueSetLink2.setPredecessorInValueSet(paramValueSetLink1);
  }
  
  @GwtIncompatible
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(keySet().size());
    Iterator<K> iterator = keySet().iterator();
    while (iterator.hasNext())
      paramObjectOutputStream.writeObject(iterator.next()); 
    paramObjectOutputStream.writeInt(size());
    for (Map.Entry<K, V> entry : entries()) {
      paramObjectOutputStream.writeObject(entry.getKey());
      paramObjectOutputStream.writeObject(entry.getValue());
    } 
  }
  
  public void clear() {
    super.clear();
    ValueEntry<K, V> valueEntry = this.multimapHeaderEntry;
    succeedsInMultimap(valueEntry, valueEntry);
  }
  
  Collection<V> createCollection(K paramK) {
    return new ValueSet(paramK, this.valueSetCapacity);
  }
  
  Set<V> createCollection() {
    return new LinkedHashSet<V>(this.valueSetCapacity);
  }
  
  public Set<Map.Entry<K, V>> entries() {
    return super.entries();
  }
  
  Iterator<Map.Entry<K, V>> entryIterator() {
    return new Iterator<Map.Entry<K, V>>() {
        LinkedHashMultimap.ValueEntry<K, V> nextEntry = LinkedHashMultimap.this.multimapHeaderEntry.successorInMultimap;
        
        LinkedHashMultimap.ValueEntry<K, V> toRemove;
        
        public boolean hasNext() {
          boolean bool;
          if (this.nextEntry != LinkedHashMultimap.this.multimapHeaderEntry) {
            bool = true;
          } else {
            bool = false;
          } 
          return bool;
        }
        
        public Map.Entry<K, V> next() {
          if (hasNext()) {
            LinkedHashMultimap.ValueEntry<K, V> valueEntry = this.nextEntry;
            this.toRemove = valueEntry;
            this.nextEntry = valueEntry.successorInMultimap;
            return valueEntry;
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
          LinkedHashMultimap.this.remove(this.toRemove.getKey(), this.toRemove.getValue());
          this.toRemove = null;
        }
      };
  }
  
  public Set<K> keySet() {
    return super.keySet();
  }
  
  @CanIgnoreReturnValue
  public Set<V> replaceValues(@Nullable K paramK, Iterable<? extends V> paramIterable) {
    return super.replaceValues(paramK, paramIterable);
  }
  
  Iterator<V> valueIterator() {
    return Maps.valueIterator(entryIterator());
  }
  
  public Collection<V> values() {
    return super.values();
  }
  
  @VisibleForTesting
  static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements ValueSetLink<K, V> {
    @Nullable
    ValueEntry<K, V> nextInValueBucket;
    
    ValueEntry<K, V> predecessorInMultimap;
    
    LinkedHashMultimap.ValueSetLink<K, V> predecessorInValueSet;
    
    final int smearedValueHash;
    
    ValueEntry<K, V> successorInMultimap;
    
    LinkedHashMultimap.ValueSetLink<K, V> successorInValueSet;
    
    ValueEntry(@Nullable K param1K, @Nullable V param1V, int param1Int, @Nullable ValueEntry<K, V> param1ValueEntry) {
      super(param1K, param1V);
      this.smearedValueHash = param1Int;
      this.nextInValueBucket = param1ValueEntry;
    }
    
    public ValueEntry<K, V> getPredecessorInMultimap() {
      return this.predecessorInMultimap;
    }
    
    public LinkedHashMultimap.ValueSetLink<K, V> getPredecessorInValueSet() {
      return this.predecessorInValueSet;
    }
    
    public ValueEntry<K, V> getSuccessorInMultimap() {
      return this.successorInMultimap;
    }
    
    public LinkedHashMultimap.ValueSetLink<K, V> getSuccessorInValueSet() {
      return this.successorInValueSet;
    }
    
    boolean matchesValue(@Nullable Object param1Object, int param1Int) {
      boolean bool;
      if (this.smearedValueHash == param1Int && Objects.equal(getValue(), param1Object)) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void setPredecessorInMultimap(ValueEntry<K, V> param1ValueEntry) {
      this.predecessorInMultimap = param1ValueEntry;
    }
    
    public void setPredecessorInValueSet(LinkedHashMultimap.ValueSetLink<K, V> param1ValueSetLink) {
      this.predecessorInValueSet = param1ValueSetLink;
    }
    
    public void setSuccessorInMultimap(ValueEntry<K, V> param1ValueEntry) {
      this.successorInMultimap = param1ValueEntry;
    }
    
    public void setSuccessorInValueSet(LinkedHashMultimap.ValueSetLink<K, V> param1ValueSetLink) {
      this.successorInValueSet = param1ValueSetLink;
    }
  }
  
  @VisibleForTesting
  final class ValueSet extends Sets.ImprovedAbstractSet<V> implements ValueSetLink<K, V> {
    private LinkedHashMultimap.ValueSetLink<K, V> firstEntry;
    
    @VisibleForTesting
    LinkedHashMultimap.ValueEntry<K, V>[] hashTable;
    
    private final K key;
    
    private LinkedHashMultimap.ValueSetLink<K, V> lastEntry;
    
    private int modCount = 0;
    
    private int size = 0;
    
    ValueSet(K param1K, int param1Int) {
      this.key = param1K;
      this.firstEntry = this;
      this.lastEntry = this;
      this.hashTable = (LinkedHashMultimap.ValueEntry<K, V>[])new LinkedHashMultimap.ValueEntry[Hashing.closedTableSize(param1Int, 1.0D)];
    }
    
    private int mask() {
      return this.hashTable.length - 1;
    }
    
    private void rehashIfNecessary() {
      if (Hashing.needsResizing(this.size, this.hashTable.length, 1.0D)) {
        LinkedHashMultimap.ValueEntry[] arrayOfValueEntry = new LinkedHashMultimap.ValueEntry[this.hashTable.length * 2];
        this.hashTable = (LinkedHashMultimap.ValueEntry<K, V>[])arrayOfValueEntry;
        int i = arrayOfValueEntry.length;
        for (LinkedHashMultimap.ValueSetLink<K, V> valueSetLink = this.firstEntry; valueSetLink != this; valueSetLink = valueSetLink.getSuccessorInValueSet()) {
          LinkedHashMultimap.ValueEntry valueEntry = (LinkedHashMultimap.ValueEntry)valueSetLink;
          int j = valueEntry.smearedValueHash & i - 1;
          valueEntry.nextInValueBucket = arrayOfValueEntry[j];
          arrayOfValueEntry[j] = valueEntry;
        } 
      } 
    }
    
    public boolean add(@Nullable V param1V) {
      int i = Hashing.smearedHash(param1V);
      int j = mask() & i;
      LinkedHashMultimap.ValueEntry<K, V> valueEntry2 = this.hashTable[j];
      for (LinkedHashMultimap.ValueEntry<K, V> valueEntry3 = valueEntry2; valueEntry3 != null; valueEntry3 = valueEntry3.nextInValueBucket) {
        if (valueEntry3.matchesValue(param1V, i))
          return false; 
      } 
      LinkedHashMultimap.ValueEntry<K, V> valueEntry1 = new LinkedHashMultimap.ValueEntry<K, V>(this.key, param1V, i, valueEntry2);
      LinkedHashMultimap.succeedsInValueSet(this.lastEntry, valueEntry1);
      LinkedHashMultimap.succeedsInValueSet(valueEntry1, this);
      LinkedHashMultimap.succeedsInMultimap(LinkedHashMultimap.this.multimapHeaderEntry.getPredecessorInMultimap(), valueEntry1);
      LinkedHashMultimap.succeedsInMultimap(valueEntry1, LinkedHashMultimap.this.multimapHeaderEntry);
      this.hashTable[j] = valueEntry1;
      this.size++;
      this.modCount++;
      rehashIfNecessary();
      return true;
    }
    
    public void clear() {
      Arrays.fill((Object[])this.hashTable, (Object)null);
      this.size = 0;
      for (LinkedHashMultimap.ValueSetLink<K, V> valueSetLink = this.firstEntry; valueSetLink != this; valueSetLink = valueSetLink.getSuccessorInValueSet())
        LinkedHashMultimap.deleteFromMultimap((LinkedHashMultimap.ValueEntry)valueSetLink); 
      LinkedHashMultimap.succeedsInValueSet(this, this);
      this.modCount++;
    }
    
    public boolean contains(@Nullable Object param1Object) {
      int i = Hashing.smearedHash(param1Object);
      for (LinkedHashMultimap.ValueEntry<K, V> valueEntry = this.hashTable[mask() & i]; valueEntry != null; valueEntry = valueEntry.nextInValueBucket) {
        if (valueEntry.matchesValue(param1Object, i))
          return true; 
      } 
      return false;
    }
    
    public LinkedHashMultimap.ValueSetLink<K, V> getPredecessorInValueSet() {
      return this.lastEntry;
    }
    
    public LinkedHashMultimap.ValueSetLink<K, V> getSuccessorInValueSet() {
      return this.firstEntry;
    }
    
    public Iterator<V> iterator() {
      return new Iterator<V>() {
          int expectedModCount = LinkedHashMultimap.ValueSet.this.modCount;
          
          LinkedHashMultimap.ValueSetLink<K, V> nextEntry = LinkedHashMultimap.ValueSet.this.firstEntry;
          
          LinkedHashMultimap.ValueEntry<K, V> toRemove;
          
          private void checkForComodification() {
            if (LinkedHashMultimap.ValueSet.this.modCount == this.expectedModCount)
              return; 
            throw new ConcurrentModificationException();
          }
          
          public boolean hasNext() {
            boolean bool;
            checkForComodification();
            if (this.nextEntry != LinkedHashMultimap.ValueSet.this) {
              bool = true;
            } else {
              bool = false;
            } 
            return bool;
          }
          
          public V next() {
            if (hasNext()) {
              LinkedHashMultimap.ValueEntry<K, V> valueEntry = (LinkedHashMultimap.ValueEntry)this.nextEntry;
              Object object = valueEntry.getValue();
              this.toRemove = valueEntry;
              this.nextEntry = valueEntry.getSuccessorInValueSet();
              return (V)object;
            } 
            throw new NoSuchElementException();
          }
          
          public void remove() {
            boolean bool;
            checkForComodification();
            if (this.toRemove != null) {
              bool = true;
            } else {
              bool = false;
            } 
            CollectPreconditions.checkRemove(bool);
            LinkedHashMultimap.ValueSet.this.remove(this.toRemove.getValue());
            this.expectedModCount = LinkedHashMultimap.ValueSet.this.modCount;
            this.toRemove = null;
          }
        };
    }
    
    @CanIgnoreReturnValue
    public boolean remove(@Nullable Object param1Object) {
      int i = Hashing.smearedHash(param1Object);
      int j = mask() & i;
      LinkedHashMultimap.ValueEntry<K, V> valueEntry1 = this.hashTable[j];
      LinkedHashMultimap.ValueEntry<K, V> valueEntry2 = null;
      while (valueEntry1 != null) {
        if (valueEntry1.matchesValue(param1Object, i)) {
          if (valueEntry2 == null) {
            this.hashTable[j] = valueEntry1.nextInValueBucket;
          } else {
            valueEntry2.nextInValueBucket = valueEntry1.nextInValueBucket;
          } 
          LinkedHashMultimap.deleteFromValueSet(valueEntry1);
          LinkedHashMultimap.deleteFromMultimap(valueEntry1);
          this.size--;
          this.modCount++;
          return true;
        } 
        LinkedHashMultimap.ValueEntry<K, V> valueEntry = valueEntry1.nextInValueBucket;
        valueEntry2 = valueEntry1;
        valueEntry1 = valueEntry;
      } 
      return false;
    }
    
    public void setPredecessorInValueSet(LinkedHashMultimap.ValueSetLink<K, V> param1ValueSetLink) {
      this.lastEntry = param1ValueSetLink;
    }
    
    public void setSuccessorInValueSet(LinkedHashMultimap.ValueSetLink<K, V> param1ValueSetLink) {
      this.firstEntry = param1ValueSetLink;
    }
    
    public int size() {
      return this.size;
    }
  }
  
  class null implements Iterator<V> {
    int expectedModCount = this.this$1.modCount;
    
    LinkedHashMultimap.ValueSetLink<K, V> nextEntry = this.this$1.firstEntry;
    
    LinkedHashMultimap.ValueEntry<K, V> toRemove;
    
    private void checkForComodification() {
      if (this.this$1.modCount == this.expectedModCount)
        return; 
      throw new ConcurrentModificationException();
    }
    
    public boolean hasNext() {
      boolean bool;
      checkForComodification();
      if (this.nextEntry != this.this$1) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public V next() {
      if (hasNext()) {
        LinkedHashMultimap.ValueEntry<K, V> valueEntry = (LinkedHashMultimap.ValueEntry)this.nextEntry;
        Object object = valueEntry.getValue();
        this.toRemove = valueEntry;
        this.nextEntry = valueEntry.getSuccessorInValueSet();
        return (V)object;
      } 
      throw new NoSuchElementException();
    }
    
    public void remove() {
      boolean bool;
      checkForComodification();
      if (this.toRemove != null) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.checkRemove(bool);
      this.this$1.remove(this.toRemove.getValue());
      this.expectedModCount = this.this$1.modCount;
      this.toRemove = null;
    }
  }
  
  private static interface ValueSetLink<K, V> {
    ValueSetLink<K, V> getPredecessorInValueSet();
    
    ValueSetLink<K, V> getSuccessorInValueSet();
    
    void setPredecessorInValueSet(ValueSetLink<K, V> param1ValueSetLink);
    
    void setSuccessorInValueSet(ValueSetLink<K, V> param1ValueSetLink);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\LinkedHashMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */