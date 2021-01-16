package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
public abstract class Optional<T> implements Serializable {
  private static final long serialVersionUID = 0L;
  
  public static <T> Optional<T> absent() {
    return Absent.withType();
  }
  
  public static <T> Optional<T> fromNullable(@Nullable T paramT) {
    Optional<?> optional;
    if (paramT == null) {
      optional = absent();
    } else {
      optional = new Present(optional);
    } 
    return (Optional)optional;
  }
  
  public static <T> Optional<T> of(T paramT) {
    return new Present<T>(Preconditions.checkNotNull(paramT));
  }
  
  @Beta
  public static <T> Iterable<T> presentInstances(final Iterable<? extends Optional<? extends T>> optionals) {
    Preconditions.checkNotNull(optionals);
    return new Iterable<T>() {
        public Iterator<T> iterator() {
          return new AbstractIterator<T>() {
              private final Iterator<? extends Optional<? extends T>> iterator = Preconditions.<Iterator<? extends Optional<? extends T>>>checkNotNull(optionals.iterator());
              
              protected T computeNext() {
                while (this.iterator.hasNext()) {
                  Optional<T> optional = (Optional)this.iterator.next();
                  if (optional.isPresent())
                    return optional.get(); 
                } 
                return endOfData();
              }
            };
        }
      };
  }
  
  public abstract Set<T> asSet();
  
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract T get();
  
  public abstract int hashCode();
  
  public abstract boolean isPresent();
  
  public abstract Optional<T> or(Optional<? extends T> paramOptional);
  
  @Beta
  public abstract T or(Supplier<? extends T> paramSupplier);
  
  public abstract T or(T paramT);
  
  @Nullable
  public abstract T orNull();
  
  public abstract String toString();
  
  public abstract <V> Optional<V> transform(Function<? super T, V> paramFunction);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Optional.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */