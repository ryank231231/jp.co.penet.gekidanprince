package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public abstract class ImmutableMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {
  private static final long serialVersionUID = 0L;
  
  final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
  
  final transient int size;
  
  ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> paramImmutableMap, int paramInt) {
    this.map = paramImmutableMap;
    this.size = paramInt;
  }
  
  public static <K, V> Builder<K, V> builder() {
    return new Builder<K, V>();
  }
  
  public static <K, V> ImmutableMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> paramMultimap) {
    if (paramMultimap instanceof ImmutableMultimap) {
      ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap)paramMultimap;
      if (!immutableMultimap.isPartialView())
        return immutableMultimap; 
    } 
    return ImmutableListMultimap.copyOf(paramMultimap);
  }
  
  @Beta
  public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable) {
    return ImmutableListMultimap.copyOf(paramIterable);
  }
  
  public static <K, V> ImmutableMultimap<K, V> of() {
    return ImmutableListMultimap.of();
  }
  
  public static <K, V> ImmutableMultimap<K, V> of(K paramK, V paramV) {
    return ImmutableListMultimap.of(paramK, paramV);
  }
  
  public static <K, V> ImmutableMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2) {
    return ImmutableListMultimap.of(paramK1, paramV1, paramK2, paramV2);
  }
  
  public static <K, V> ImmutableMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3) {
    return ImmutableListMultimap.of(paramK1, paramV1, paramK2, paramV2, paramK3, paramV3);
  }
  
  public static <K, V> ImmutableMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4) {
    return ImmutableListMultimap.of(paramK1, paramV1, paramK2, paramV2, paramK3, paramV3, paramK4, paramV4);
  }
  
  public static <K, V> ImmutableMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5) {
    return ImmutableListMultimap.of(paramK1, paramV1, paramK2, paramV2, paramK3, paramV3, paramK4, paramV4, paramK5, paramV5);
  }
  
  public ImmutableMap<K, Collection<V>> asMap() {
    return (ImmutableMap)this.map;
  }
  
  @Deprecated
  public void clear() {
    throw new UnsupportedOperationException();
  }
  
  public boolean containsKey(@Nullable Object paramObject) {
    return this.map.containsKey(paramObject);
  }
  
  public boolean containsValue(@Nullable Object paramObject) {
    boolean bool;
    if (paramObject != null && super.containsValue(paramObject)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  Map<K, Collection<V>> createAsMap() {
    throw new AssertionError("should never be called");
  }
  
  ImmutableCollection<Map.Entry<K, V>> createEntries() {
    return new EntryCollection<K, V>(this);
  }
  
  ImmutableMultiset<K> createKeys() {
    return new Keys();
  }
  
  ImmutableCollection<V> createValues() {
    return new Values<Object, V>(this);
  }
  
  public ImmutableCollection<Map.Entry<K, V>> entries() {
    return (ImmutableCollection<Map.Entry<K, V>>)super.entries();
  }
  
  UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
    return new Itr<Map.Entry<K, V>>() {
        Map.Entry<K, V> output(K param1K, V param1V) {
          return Maps.immutableEntry(param1K, param1V);
        }
      };
  }
  
  public abstract ImmutableCollection<V> get(K paramK);
  
  public abstract ImmutableMultimap<V, K> inverse();
  
  boolean isPartialView() {
    return this.map.isPartialView();
  }
  
  public ImmutableSet<K> keySet() {
    return this.map.keySet();
  }
  
  public ImmutableMultiset<K> keys() {
    return (ImmutableMultiset<K>)super.keys();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public boolean put(K paramK, V paramV) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public boolean putAll(Multimap<? extends K, ? extends V> paramMultimap) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public boolean putAll(K paramK, Iterable<? extends V> paramIterable) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public boolean remove(Object paramObject1, Object paramObject2) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public ImmutableCollection<V> removeAll(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public ImmutableCollection<V> replaceValues(K paramK, Iterable<? extends V> paramIterable) {
    throw new UnsupportedOperationException();
  }
  
  public int size() {
    return this.size;
  }
  
  UnmodifiableIterator<V> valueIterator() {
    return new Itr<V>() {
        V output(K param1K, V param1V) {
          return param1V;
        }
      };
  }
  
  public ImmutableCollection<V> values() {
    return (ImmutableCollection<V>)super.values();
  }
  
  public static class Builder<K, V> {
    Multimap<K, V> builderMultimap;
    
    Comparator<? super K> keyComparator;
    
    Comparator<? super V> valueComparator;
    
    public Builder() {
      this(MultimapBuilder.linkedHashKeys().arrayListValues().build());
    }
    
    Builder(Multimap<K, V> param1Multimap) {
      this.builderMultimap = param1Multimap;
    }
    
    public ImmutableMultimap<K, V> build() {
      if (this.valueComparator != null) {
        Iterator<List<V>> iterator = this.builderMultimap.asMap().values().iterator();
        while (iterator.hasNext())
          Collections.sort(iterator.next(), this.valueComparator); 
      } 
      if (this.keyComparator != null) {
        ListMultimap<K, V> listMultimap = MultimapBuilder.linkedHashKeys().arrayListValues().build();
        for (Map.Entry entry : Ordering.<K>from(this.keyComparator).onKeys().immutableSortedCopy(this.builderMultimap.asMap().entrySet()))
          listMultimap.putAll(entry.getKey(), (Iterable)entry.getValue()); 
        this.builderMultimap = listMultimap;
      } 
      return ImmutableMultimap.copyOf(this.builderMultimap);
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> orderKeysBy(Comparator<? super K> param1Comparator) {
      this.keyComparator = (Comparator<? super K>)Preconditions.checkNotNull(param1Comparator);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> orderValuesBy(Comparator<? super V> param1Comparator) {
      this.valueComparator = (Comparator<? super V>)Preconditions.checkNotNull(param1Comparator);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> put(K param1K, V param1V) {
      CollectPreconditions.checkEntryNotNull(param1K, param1V);
      this.builderMultimap.put(param1K, param1V);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> put(Map.Entry<? extends K, ? extends V> param1Entry) {
      return put(param1Entry.getKey(), param1Entry.getValue());
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(Multimap<? extends K, ? extends V> param1Multimap) {
      for (Map.Entry entry : param1Multimap.asMap().entrySet())
        putAll((K)entry.getKey(), (Iterable<? extends V>)entry.getValue()); 
      return this;
    }
    
    @Beta
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> param1Iterable) {
      Iterator<? extends Map.Entry<? extends K, ? extends V>> iterator = param1Iterable.iterator();
      while (iterator.hasNext())
        put(iterator.next()); 
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(K param1K, Iterable<? extends V> param1Iterable) {
      if (param1K != null) {
        Collection<V> collection = this.builderMultimap.get(param1K);
        for (Iterable<? extends V> param1Iterable : param1Iterable) {
          CollectPreconditions.checkEntryNotNull(param1K, param1Iterable);
          collection.add((V)param1Iterable);
        } 
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("null key in entry: null=");
      stringBuilder.append(Iterables.toString(param1Iterable));
      throw new NullPointerException(stringBuilder.toString());
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(K param1K, V... param1VarArgs) {
      return putAll(param1K, Arrays.asList(param1VarArgs));
    }
  }
  
  private static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
    private static final long serialVersionUID = 0L;
    
    @Weak
    final ImmutableMultimap<K, V> multimap;
    
    EntryCollection(ImmutableMultimap<K, V> param1ImmutableMultimap) {
      this.multimap = param1ImmutableMultimap;
    }
    
    public boolean contains(Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        return this.multimap.containsEntry(param1Object.getKey(), param1Object.getValue());
      } 
      return false;
    }
    
    boolean isPartialView() {
      return this.multimap.isPartialView();
    }
    
    public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
      return this.multimap.entryIterator();
    }
    
    public int size() {
      return this.multimap.size();
    }
  }
  
  @GwtIncompatible
  static class FieldSettersHolder {
    static final Serialization.FieldSetter<ImmutableSetMultimap> EMPTY_SET_FIELD_SETTER = Serialization.getFieldSetter(ImmutableSetMultimap.class, "emptySet");
    
    static final Serialization.FieldSetter<ImmutableMultimap> MAP_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "map");
    
    static final Serialization.FieldSetter<ImmutableMultimap> SIZE_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "size");
    
    static {
    
    }
  }
  
  private abstract class Itr<T> extends UnmodifiableIterator<T> {
    K key = null;
    
    final Iterator<Map.Entry<K, Collection<V>>> mapIterator = ImmutableMultimap.this.asMap().entrySet().iterator();
    
    Iterator<V> valueIterator = Iterators.emptyIterator();
    
    private Itr() {}
    
    public boolean hasNext() {
      return (this.mapIterator.hasNext() || this.valueIterator.hasNext());
    }
    
    public T next() {
      if (!this.valueIterator.hasNext()) {
        Map.Entry entry = this.mapIterator.next();
        this.key = (K)entry.getKey();
        this.valueIterator = ((Collection<V>)entry.getValue()).iterator();
      } 
      return output(this.key, this.valueIterator.next());
    }
    
    abstract T output(K param1K, V param1V);
  }
  
  class Keys extends ImmutableMultiset<K> {
    public boolean contains(@Nullable Object param1Object) {
      return ImmutableMultimap.this.containsKey(param1Object);
    }
    
    public int count(@Nullable Object param1Object) {
      int i;
      param1Object = ImmutableMultimap.this.map.get(param1Object);
      if (param1Object == null) {
        i = 0;
      } else {
        i = param1Object.size();
      } 
      return i;
    }
    
    public Set<K> elementSet() {
      return ImmutableMultimap.this.keySet();
    }
    
    Multiset.Entry<K> getEntry(int param1Int) {
      Map.Entry entry = ImmutableMultimap.this.map.entrySet().asList().get(param1Int);
      return Multisets.immutableEntry((K)entry.getKey(), ((Collection)entry.getValue()).size());
    }
    
    boolean isPartialView() {
      return true;
    }
    
    public int size() {
      return ImmutableMultimap.this.size();
    }
  }
  
  private static final class Values<K, V> extends ImmutableCollection<V> {
    private static final long serialVersionUID = 0L;
    
    @Weak
    private final transient ImmutableMultimap<K, V> multimap;
    
    Values(ImmutableMultimap<K, V> param1ImmutableMultimap) {
      this.multimap = param1ImmutableMultimap;
    }
    
    public boolean contains(@Nullable Object param1Object) {
      return this.multimap.containsValue(param1Object);
    }
    
    @GwtIncompatible
    int copyIntoArray(Object[] param1ArrayOfObject, int param1Int) {
      Iterator<ImmutableCollection> iterator = this.multimap.map.values().iterator();
      while (iterator.hasNext())
        param1Int = ((ImmutableCollection)iterator.next()).copyIntoArray(param1ArrayOfObject, param1Int); 
      return param1Int;
    }
    
    boolean isPartialView() {
      return true;
    }
    
    public UnmodifiableIterator<V> iterator() {
      return this.multimap.valueIterator();
    }
    
    public int size() {
      return this.multimap.size();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */