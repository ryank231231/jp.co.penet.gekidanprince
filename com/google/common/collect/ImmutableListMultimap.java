package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ListMultimap<K, V> {
  @GwtIncompatible
  private static final long serialVersionUID = 0L;
  
  @LazyInit
  @RetainedWith
  private transient ImmutableListMultimap<V, K> inverse;
  
  ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> paramImmutableMap, int paramInt) {
    super((ImmutableMap)paramImmutableMap, paramInt);
  }
  
  public static <K, V> Builder<K, V> builder() {
    return new Builder<K, V>();
  }
  
  public static <K, V> ImmutableListMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> paramMultimap) {
    if (paramMultimap.isEmpty())
      return of(); 
    if (paramMultimap instanceof ImmutableListMultimap) {
      ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap)paramMultimap;
      if (!immutableListMultimap.isPartialView())
        return immutableListMultimap; 
    } 
    ImmutableMap.Builder<Object, Object> builder = new ImmutableMap.Builder<Object, Object>(paramMultimap.asMap().size());
    int i = 0;
    for (Map.Entry entry : paramMultimap.asMap().entrySet()) {
      ImmutableList<?> immutableList = ImmutableList.copyOf((Collection)entry.getValue());
      if (!immutableList.isEmpty()) {
        builder.put(entry.getKey(), immutableList);
        i += immutableList.size();
      } 
    } 
    return new ImmutableListMultimap<K, V>((ImmutableMap)builder.build(), i);
  }
  
  @Beta
  public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable) {
    return (new Builder<K, V>()).putAll(paramIterable).build();
  }
  
  private ImmutableListMultimap<V, K> invert() {
    Builder<?, ?> builder = builder();
    for (Map.Entry<K, V> entry : entries())
      builder.put(entry.getValue(), entry.getKey()); 
    ImmutableListMultimap<?, ?> immutableListMultimap = builder.build();
    immutableListMultimap.inverse = this;
    return (ImmutableListMultimap)immutableListMultimap;
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of() {
    return EmptyImmutableListMultimap.INSTANCE;
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of(K paramK, V paramV) {
    Builder<?, ?> builder = builder();
    builder.put(paramK, paramV);
    return (ImmutableListMultimap)builder.build();
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2) {
    Builder<?, ?> builder = builder();
    builder.put(paramK1, paramV1);
    builder.put(paramK2, paramV2);
    return (ImmutableListMultimap)builder.build();
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3) {
    Builder<?, ?> builder = builder();
    builder.put(paramK1, paramV1);
    builder.put(paramK2, paramV2);
    builder.put(paramK3, paramV3);
    return (ImmutableListMultimap)builder.build();
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4) {
    Builder<?, ?> builder = builder();
    builder.put(paramK1, paramV1);
    builder.put(paramK2, paramV2);
    builder.put(paramK3, paramV3);
    builder.put(paramK4, paramV4);
    return (ImmutableListMultimap)builder.build();
  }
  
  public static <K, V> ImmutableListMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5) {
    Builder<?, ?> builder = builder();
    builder.put(paramK1, paramV1);
    builder.put(paramK2, paramV2);
    builder.put(paramK3, paramV3);
    builder.put(paramK4, paramV4);
    builder.put(paramK5, paramV5);
    return (ImmutableListMultimap)builder.build();
  }
  
  @GwtIncompatible
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    int i = paramObjectInputStream.readInt();
    if (i >= 0) {
      ImmutableMap.Builder<?, ?> builder = ImmutableMap.builder();
      byte b = 0;
      int j = 0;
      while (b < i) {
        Object object = paramObjectInputStream.readObject();
        int k = paramObjectInputStream.readInt();
        if (k > 0) {
          ImmutableList.Builder<?> builder1 = ImmutableList.builder();
          for (byte b1 = 0; b1 < k; b1++)
            builder1.add(paramObjectInputStream.readObject()); 
          builder.put(object, builder1.build());
          j += k;
          b++;
          continue;
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
  
  @GwtIncompatible
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.defaultWriteObject();
    Serialization.writeMultimap(this, paramObjectOutputStream);
  }
  
  public ImmutableList<V> get(@Nullable K paramK) {
    ImmutableList<?> immutableList2 = (ImmutableList)this.map.get(paramK);
    ImmutableList<?> immutableList1 = immutableList2;
    if (immutableList2 == null)
      immutableList1 = ImmutableList.of(); 
    return (ImmutableList)immutableList1;
  }
  
  public ImmutableListMultimap<V, K> inverse() {
    ImmutableListMultimap<V, K> immutableListMultimap1 = this.inverse;
    ImmutableListMultimap<V, K> immutableListMultimap2 = immutableListMultimap1;
    if (immutableListMultimap1 == null) {
      immutableListMultimap2 = invert();
      this.inverse = immutableListMultimap2;
    } 
    return immutableListMultimap2;
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public ImmutableList<V> removeAll(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public ImmutableList<V> replaceValues(K paramK, Iterable<? extends V> paramIterable) {
    throw new UnsupportedOperationException();
  }
  
  public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
    public ImmutableListMultimap<K, V> build() {
      return (ImmutableListMultimap<K, V>)super.build();
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> orderKeysBy(Comparator<? super K> param1Comparator) {
      super.orderKeysBy(param1Comparator);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> orderValuesBy(Comparator<? super V> param1Comparator) {
      super.orderValuesBy(param1Comparator);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> put(K param1K, V param1V) {
      super.put(param1K, param1V);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> put(Map.Entry<? extends K, ? extends V> param1Entry) {
      super.put(param1Entry);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(Multimap<? extends K, ? extends V> param1Multimap) {
      super.putAll(param1Multimap);
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
      super.putAll(param1K, param1Iterable);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<K, V> putAll(K param1K, V... param1VarArgs) {
      super.putAll(param1K, param1VarArgs);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */