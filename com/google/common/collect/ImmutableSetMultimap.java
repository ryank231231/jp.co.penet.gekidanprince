package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {
  @GwtIncompatible
  private static final long serialVersionUID = 0L;
  
  private final transient ImmutableSet<V> emptySet;
  
  private transient ImmutableSet<Map.Entry<K, V>> entries;
  
  @LazyInit
  @RetainedWith
  private transient ImmutableSetMultimap<V, K> inverse;
  
  ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> paramImmutableMap, int paramInt, @Nullable Comparator<? super V> paramComparator) {
    super((ImmutableMap)paramImmutableMap, paramInt);
    this.emptySet = emptySet(paramComparator);
  }
  
  public static <K, V> Builder<K, V> builder() {
    return new Builder<K, V>();
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> paramMultimap) {
    return copyOf(paramMultimap, (Comparator<? super V>)null);
  }
  
  private static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> paramMultimap, Comparator<? super V> paramComparator) {
    Preconditions.checkNotNull(paramMultimap);
    if (paramMultimap.isEmpty() && paramComparator == null)
      return of(); 
    if (paramMultimap instanceof ImmutableSetMultimap) {
      ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap)paramMultimap;
      if (!immutableSetMultimap.isPartialView())
        return immutableSetMultimap; 
    } 
    ImmutableMap.Builder<Object, Object> builder = new ImmutableMap.Builder<Object, Object>(paramMultimap.asMap().size());
    int i = 0;
    for (Map.Entry entry : paramMultimap.asMap().entrySet()) {
      paramMultimap = (Multimap<? extends K, ? extends V>)entry.getKey();
      ImmutableSet<V> immutableSet = valueSet(paramComparator, (Collection<? extends V>)entry.getValue());
      if (!immutableSet.isEmpty()) {
        builder.put(paramMultimap, immutableSet);
        i += immutableSet.size();
      } 
    } 
    return new ImmutableSetMultimap<K, V>((ImmutableMap)builder.build(), i, paramComparator);
  }
  
  @Beta
  public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable) {
    return (new Builder<K, V>()).putAll(paramIterable).build();
  }
  
  private static <V> ImmutableSet<V> emptySet(@Nullable Comparator<? super V> paramComparator) {
    ImmutableSet<?> immutableSet;
    if (paramComparator == null) {
      immutableSet = ImmutableSet.of();
    } else {
      immutableSet = ImmutableSortedSet.emptySet((Comparator<?>)immutableSet);
    } 
    return (ImmutableSet)immutableSet;
  }
  
  private ImmutableSetMultimap<V, K> invert() {
    Builder<?, ?> builder = builder();
    for (Map.Entry<K, V> entry : entries())
      builder.put(entry.getValue(), entry.getKey()); 
    ImmutableSetMultimap<?, ?> immutableSetMultimap = builder.build();
    immutableSetMultimap.inverse = this;
    return (ImmutableSetMultimap)immutableSetMultimap;
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of() {
    return EmptyImmutableSetMultimap.INSTANCE;
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of(K paramK, V paramV) {
    Builder<?, ?> builder = builder();
    builder.put(paramK, paramV);
    return (ImmutableSetMultimap)builder.build();
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2) {
    Builder<?, ?> builder = builder();
    builder.put(paramK1, paramV1);
    builder.put(paramK2, paramV2);
    return (ImmutableSetMultimap)builder.build();
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3) {
    Builder<?, ?> builder = builder();
    builder.put(paramK1, paramV1);
    builder.put(paramK2, paramV2);
    builder.put(paramK3, paramV3);
    return (ImmutableSetMultimap)builder.build();
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4) {
    Builder<?, ?> builder = builder();
    builder.put(paramK1, paramV1);
    builder.put(paramK2, paramV2);
    builder.put(paramK3, paramV3);
    builder.put(paramK4, paramV4);
    return (ImmutableSetMultimap)builder.build();
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5) {
    Builder<?, ?> builder = builder();
    builder.put(paramK1, paramV1);
    builder.put(paramK2, paramV2);
    builder.put(paramK3, paramV3);
    builder.put(paramK4, paramV4);
    builder.put(paramK5, paramV5);
    return (ImmutableSetMultimap)builder.build();
  }
  
  @GwtIncompatible
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    Comparator<?> comparator = (Comparator)paramObjectInputStream.readObject();
    int i = paramObjectInputStream.readInt();
    if (i >= 0) {
      ImmutableMap.Builder<?, ?> builder = ImmutableMap.builder();
      byte b = 0;
      int j = 0;
      while (b < i) {
        Object object = paramObjectInputStream.readObject();
        int k = paramObjectInputStream.readInt();
        if (k > 0) {
          ImmutableSet.Builder<?> builder1 = valuesBuilder(comparator);
          for (byte b1 = 0; b1 < k; b1++)
            builder1.add(paramObjectInputStream.readObject()); 
          ImmutableSet<?> immutableSet = builder1.build();
          if (immutableSet.size() == k) {
            builder.put(object, immutableSet);
            j += k;
            b++;
            continue;
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Duplicate key-value pairs exist for key ");
          stringBuilder2.append(object);
          throw new InvalidObjectException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Invalid value count ");
        stringBuilder1.append(k);
        throw new InvalidObjectException(stringBuilder1.toString());
      } 
      try {
        ImmutableMap<?, ?> immutableMap = builder.build();
        ImmutableMultimap.FieldSettersHolder.MAP_FIELD_SETTER.set(this, immutableMap);
        ImmutableMultimap.FieldSettersHolder.SIZE_FIELD_SETTER.set(this, j);
        ImmutableMultimap.FieldSettersHolder.EMPTY_SET_FIELD_SETTER.set(this, emptySet(comparator));
        return;
      } catch (IllegalArgumentException illegalArgumentException) {
        throw (InvalidObjectException)(new InvalidObjectException(illegalArgumentException.getMessage())).initCause(illegalArgumentException);
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid key count ");
    stringBuilder.append(i);
    throw new InvalidObjectException(stringBuilder.toString());
  }
  
  private static <V> ImmutableSet<V> valueSet(@Nullable Comparator<? super V> paramComparator, Collection<? extends V> paramCollection) {
    ImmutableSet<V> immutableSet;
    if (paramComparator == null) {
      immutableSet = ImmutableSet.copyOf(paramCollection);
    } else {
      immutableSet = ImmutableSortedSet.copyOf((Comparator<? super V>)immutableSet, paramCollection);
    } 
    return immutableSet;
  }
  
  private static <V> ImmutableSet.Builder<V> valuesBuilder(@Nullable Comparator<? super V> paramComparator) {
    ImmutableSet.Builder<V> builder;
    if (paramComparator == null) {
      builder = new ImmutableSet.Builder();
    } else {
      builder = new ImmutableSortedSet.Builder((Comparator<?>)builder);
    } 
    return builder;
  }
  
  @GwtIncompatible
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(valueComparator());
    Serialization.writeMultimap(this, paramObjectOutputStream);
  }
  
  public ImmutableSet<Map.Entry<K, V>> entries() {
    ImmutableSet<Map.Entry<K, V>> immutableSet1 = this.entries;
    ImmutableSet<Map.Entry<K, V>> immutableSet2 = immutableSet1;
    if (immutableSet1 == null) {
      immutableSet2 = new EntrySet<K, V>(this);
      this.entries = immutableSet2;
    } 
    return immutableSet2;
  }
  
  public ImmutableSet<V> get(@Nullable K paramK) {
    return (ImmutableSet<V>)MoreObjects.firstNonNull(this.map.get(paramK), this.emptySet);
  }
  
  public ImmutableSetMultimap<V, K> inverse() {
    ImmutableSetMultimap<V, K> immutableSetMultimap1 = this.inverse;
    ImmutableSetMultimap<V, K> immutableSetMultimap2 = immutableSetMultimap1;
    if (immutableSetMultimap1 == null) {
      immutableSetMultimap2 = invert();
      this.inverse = immutableSetMultimap2;
    } 
    return immutableSetMultimap2;
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public ImmutableSet<V> removeAll(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public ImmutableSet<V> replaceValues(K paramK, Iterable<? extends V> paramIterable) {
    throw new UnsupportedOperationException();
  }
  
  @Nullable
  Comparator<? super V> valueComparator() {
    ImmutableSet<V> immutableSet = this.emptySet;
    if (immutableSet instanceof ImmutableSortedSet) {
      Comparator comparator = ((ImmutableSortedSet)immutableSet).comparator();
    } else {
      immutableSet = null;
    } 
    return (Comparator<? super V>)immutableSet;
  }
  
  public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
    public Builder() {
      super(MultimapBuilder.linkedHashKeys().linkedHashSetValues().build());
    }
    
    public ImmutableSetMultimap<K, V> build() {
      if (this.keyComparator != null) {
        SetMultimap<K, V> setMultimap = MultimapBuilder.linkedHashKeys().linkedHashSetValues().build();
        for (Map.Entry entry : Ordering.<K>from(this.keyComparator).onKeys().immutableSortedCopy(this.builderMultimap.asMap().entrySet()))
          setMultimap.putAll(entry.getKey(), (Iterable)entry.getValue()); 
        this.builderMultimap = setMultimap;
      } 
      return ImmutableSetMultimap.copyOf(this.builderMultimap, this.valueComparator);
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> orderKeysBy(Comparator<? super K> param1Comparator) {
      this.keyComparator = (Comparator<? super K>)Preconditions.checkNotNull(param1Comparator);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> orderValuesBy(Comparator<? super V> param1Comparator) {
      super.orderValuesBy(param1Comparator);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> put(K param1K, V param1V) {
      this.builderMultimap.put((K)Preconditions.checkNotNull(param1K), (V)Preconditions.checkNotNull(param1V));
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> put(Map.Entry<? extends K, ? extends V> param1Entry) {
      this.builderMultimap.put((K)Preconditions.checkNotNull(param1Entry.getKey()), (V)Preconditions.checkNotNull(param1Entry.getValue()));
      return this;
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
      super.putAll(param1Iterable);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(K param1K, Iterable<? extends V> param1Iterable) {
      Collection<V> collection = this.builderMultimap.get((K)Preconditions.checkNotNull(param1K));
      Iterator<? extends V> iterator = param1Iterable.iterator();
      while (iterator.hasNext())
        collection.add((V)Preconditions.checkNotNull(iterator.next())); 
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(K param1K, V... param1VarArgs) {
      return putAll(param1K, Arrays.asList(param1VarArgs));
    }
  }
  
  private static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
    @Weak
    private final transient ImmutableSetMultimap<K, V> multimap;
    
    EntrySet(ImmutableSetMultimap<K, V> param1ImmutableSetMultimap) {
      this.multimap = param1ImmutableSetMultimap;
    }
    
    public boolean contains(@Nullable Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        return this.multimap.containsEntry(param1Object.getKey(), param1Object.getValue());
      } 
      return false;
    }
    
    boolean isPartialView() {
      return false;
    }
    
    public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
      return this.multimap.entryIterator();
    }
    
    public int size() {
      return this.multimap.size();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */