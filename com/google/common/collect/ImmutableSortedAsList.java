package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class ImmutableSortedAsList<E> extends RegularImmutableAsList<E> implements SortedIterable<E> {
  ImmutableSortedAsList(ImmutableSortedSet<E> paramImmutableSortedSet, ImmutableList<E> paramImmutableList) {
    super(paramImmutableSortedSet, paramImmutableList);
  }
  
  public Comparator<? super E> comparator() {
    return delegateCollection().comparator();
  }
  
  public boolean contains(Object paramObject) {
    boolean bool;
    if (indexOf(paramObject) >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  ImmutableSortedSet<E> delegateCollection() {
    return (ImmutableSortedSet<E>)super.delegateCollection();
  }
  
  @GwtIncompatible
  public int indexOf(@Nullable Object paramObject) {
    int i = delegateCollection().indexOf(paramObject);
    if (i < 0 || !get(i).equals(paramObject))
      i = -1; 
    return i;
  }
  
  @GwtIncompatible
  public int lastIndexOf(@Nullable Object paramObject) {
    return indexOf(paramObject);
  }
  
  @GwtIncompatible
  ImmutableList<E> subListUnchecked(int paramInt1, int paramInt2) {
    return (new RegularImmutableSortedSet<E>(super.subListUnchecked(paramInt1, paramInt2), comparator())).asList();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableSortedAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */