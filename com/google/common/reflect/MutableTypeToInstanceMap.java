package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public final class MutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
  private final Map<TypeToken<? extends B>, B> backingMap = Maps.newHashMap();
  
  @Nullable
  private <T extends B> T trustedGet(TypeToken<T> paramTypeToken) {
    return (T)this.backingMap.get(paramTypeToken);
  }
  
  @Nullable
  private <T extends B> T trustedPut(TypeToken<T> paramTypeToken, @Nullable T paramT) {
    return (T)this.backingMap.put(paramTypeToken, (B)paramT);
  }
  
  protected Map<TypeToken<? extends B>, B> delegate() {
    return this.backingMap;
  }
  
  public Set<Map.Entry<TypeToken<? extends B>, B>> entrySet() {
    return UnmodifiableEntry.transformEntries(super.entrySet());
  }
  
  @Nullable
  public <T extends B> T getInstance(TypeToken<T> paramTypeToken) {
    return trustedGet(paramTypeToken.rejectTypeVariables());
  }
  
  @Nullable
  public <T extends B> T getInstance(Class<T> paramClass) {
    return trustedGet(TypeToken.of(paramClass));
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public B put(TypeToken<? extends B> paramTypeToken, B paramB) {
    throw new UnsupportedOperationException("Please use putInstance() instead.");
  }
  
  @Deprecated
  public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> paramMap) {
    throw new UnsupportedOperationException("Please use putInstance() instead.");
  }
  
  @Nullable
  @CanIgnoreReturnValue
  public <T extends B> T putInstance(TypeToken<T> paramTypeToken, @Nullable T paramT) {
    return trustedPut(paramTypeToken.rejectTypeVariables(), paramT);
  }
  
  @Nullable
  @CanIgnoreReturnValue
  public <T extends B> T putInstance(Class<T> paramClass, @Nullable T paramT) {
    return trustedPut(TypeToken.of(paramClass), paramT);
  }
  
  private static final class UnmodifiableEntry<K, V> extends ForwardingMapEntry<K, V> {
    private final Map.Entry<K, V> delegate;
    
    private UnmodifiableEntry(Map.Entry<K, V> param1Entry) {
      this.delegate = (Map.Entry<K, V>)Preconditions.checkNotNull(param1Entry);
    }
    
    private static <K, V> Iterator<Map.Entry<K, V>> transformEntries(Iterator<Map.Entry<K, V>> param1Iterator) {
      return Iterators.transform(param1Iterator, new Function<Map.Entry<K, V>, Map.Entry<K, V>>() {
            public Map.Entry<K, V> apply(Map.Entry<K, V> param2Entry) {
              return (Map.Entry)new MutableTypeToInstanceMap.UnmodifiableEntry<Object, Object>(param2Entry);
            }
          });
    }
    
    static <K, V> Set<Map.Entry<K, V>> transformEntries(final Set<Map.Entry<K, V>> entries) {
      return (Set<Map.Entry<K, V>>)new ForwardingSet<Map.Entry<K, V>>() {
          protected Set<Map.Entry<K, V>> delegate() {
            return entries;
          }
          
          public Iterator<Map.Entry<K, V>> iterator() {
            return MutableTypeToInstanceMap.UnmodifiableEntry.transformEntries(super.iterator());
          }
          
          public Object[] toArray() {
            return standardToArray();
          }
          
          public <T> T[] toArray(T[] param2ArrayOfT) {
            return (T[])standardToArray((Object[])param2ArrayOfT);
          }
        };
    }
    
    protected Map.Entry<K, V> delegate() {
      return this.delegate;
    }
    
    public V setValue(V param1V) {
      throw new UnsupportedOperationException();
    }
  }
  
  static final class null extends ForwardingSet<Map.Entry<K, V>> {
    protected Set<Map.Entry<K, V>> delegate() {
      return entries;
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return MutableTypeToInstanceMap.UnmodifiableEntry.transformEntries(super.iterator());
    }
    
    public Object[] toArray() {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])standardToArray((Object[])param1ArrayOfT);
    }
  }
  
  static final class null implements Function<Map.Entry<K, V>, Map.Entry<K, V>> {
    public Map.Entry<K, V> apply(Map.Entry<K, V> param1Entry) {
      return (Map.Entry)new MutableTypeToInstanceMap.UnmodifiableEntry<Object, Object>(param1Entry);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\reflect\MutableTypeToInstanceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */