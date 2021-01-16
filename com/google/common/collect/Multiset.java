package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public interface Multiset<E> extends Collection<E> {
  @CanIgnoreReturnValue
  int add(@Nullable E paramE, int paramInt);
  
  @CanIgnoreReturnValue
  boolean add(E paramE);
  
  boolean contains(@Nullable Object paramObject);
  
  boolean containsAll(Collection<?> paramCollection);
  
  int count(@Nullable Object paramObject);
  
  Set<E> elementSet();
  
  Set<Entry<E>> entrySet();
  
  boolean equals(@Nullable Object paramObject);
  
  int hashCode();
  
  Iterator<E> iterator();
  
  @CanIgnoreReturnValue
  int remove(@Nullable Object paramObject, int paramInt);
  
  @CanIgnoreReturnValue
  boolean remove(@Nullable Object paramObject);
  
  @CanIgnoreReturnValue
  boolean removeAll(Collection<?> paramCollection);
  
  @CanIgnoreReturnValue
  boolean retainAll(Collection<?> paramCollection);
  
  @CanIgnoreReturnValue
  int setCount(E paramE, int paramInt);
  
  @CanIgnoreReturnValue
  boolean setCount(E paramE, int paramInt1, int paramInt2);
  
  String toString();
  
  public static interface Entry<E> {
    boolean equals(Object param1Object);
    
    int getCount();
    
    E getElement();
    
    int hashCode();
    
    String toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Multiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */