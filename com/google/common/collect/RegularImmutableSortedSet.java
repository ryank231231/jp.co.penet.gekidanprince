package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
  static final RegularImmutableSortedSet<Comparable> NATURAL_EMPTY_SET = new RegularImmutableSortedSet(ImmutableList.of(), Ordering.natural());
  
  private final transient ImmutableList<E> elements;
  
  RegularImmutableSortedSet(ImmutableList<E> paramImmutableList, Comparator<? super E> paramComparator) {
    super(paramComparator);
    this.elements = paramImmutableList;
  }
  
  private int unsafeBinarySearch(Object paramObject) throws ClassCastException {
    return Collections.binarySearch(this.elements, (E)paramObject, (Comparator)unsafeComparator());
  }
  
  public E ceiling(E paramE) {
    int i = tailIndex(paramE, true);
    if (i == size()) {
      paramE = null;
    } else {
      paramE = this.elements.get(i);
    } 
    return paramE;
  }
  
  public boolean contains(@Nullable Object paramObject) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramObject != null)
      try {
        int i = unsafeBinarySearch(paramObject);
        bool2 = bool1;
        if (i >= 0)
          bool2 = true; 
      } catch (ClassCastException classCastException) {
        return false;
      }  
    return bool2;
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    Collection<?> collection = paramCollection;
    if (paramCollection instanceof Multiset)
      collection = ((Multiset)paramCollection).elementSet(); 
    if (!SortedIterables.hasSameComparator(comparator(), collection) || collection.size() <= 1)
      return super.containsAll(collection); 
    PeekingIterator<E> peekingIterator = Iterators.peekingIterator(iterator());
    Iterator<?> iterator = collection.iterator();
    paramCollection = (Collection<?>)iterator.next();
    try {
      while (peekingIterator.hasNext()) {
        int i = unsafeCompare(peekingIterator.peek(), paramCollection);
        if (i < 0) {
          peekingIterator.next();
          continue;
        } 
        if (i == 0) {
          if (!iterator.hasNext())
            return true; 
          paramCollection = (Collection<?>)iterator.next();
          continue;
        } 
        if (i > 0)
          return false; 
      } 
      return false;
    } catch (NullPointerException nullPointerException) {
      return false;
    } catch (ClassCastException classCastException) {
      return false;
    } 
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt) {
    return this.elements.copyIntoArray(paramArrayOfObject, paramInt);
  }
  
  ImmutableList<E> createAsList() {
    ImmutableList<E> immutableList;
    if (size() <= 1) {
      immutableList = this.elements;
    } else {
      immutableList = new ImmutableSortedAsList<E>(this, this.elements);
    } 
    return immutableList;
  }
  
  ImmutableSortedSet<E> createDescendingSet() {
    RegularImmutableSortedSet<E> regularImmutableSortedSet;
    Ordering<? super E> ordering = Ordering.<E>from(this.comparator).reverse();
    if (isEmpty()) {
      regularImmutableSortedSet = emptySet(ordering);
    } else {
      regularImmutableSortedSet = new RegularImmutableSortedSet(this.elements.reverse(), (Comparator<? super E>)regularImmutableSortedSet);
    } 
    return regularImmutableSortedSet;
  }
  
  @GwtIncompatible
  public UnmodifiableIterator<E> descendingIterator() {
    return this.elements.reverse().iterator();
  }
  
  public boolean equals(@Nullable Object<E> paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof java.util.Set))
      return false; 
    paramObject = paramObject;
    if (size() != paramObject.size())
      return false; 
    if (isEmpty())
      return true; 
    if (SortedIterables.hasSameComparator(this.comparator, (Iterable<?>)paramObject)) {
      Iterator<Object> iterator = paramObject.iterator();
      try {
        paramObject = (Object<E>)iterator();
        while (paramObject.hasNext()) {
          E e = paramObject.next();
          Object object = iterator.next();
          if (object != null) {
            int i = unsafeCompare(e, object);
            if (i != 0)
              return false; 
            continue;
          } 
          return false;
        } 
        return true;
      } catch (ClassCastException classCastException) {
        return false;
      } catch (NoSuchElementException noSuchElementException) {
        return false;
      } 
    } 
    return containsAll((Collection<?>)noSuchElementException);
  }
  
  public E first() {
    if (!isEmpty())
      return this.elements.get(0); 
    throw new NoSuchElementException();
  }
  
  public E floor(E paramE) {
    int i = headIndex(paramE, true) - 1;
    if (i == -1) {
      paramE = null;
    } else {
      paramE = this.elements.get(i);
    } 
    return paramE;
  }
  
  RegularImmutableSortedSet<E> getSubSet(int paramInt1, int paramInt2) {
    return (paramInt1 == 0 && paramInt2 == size()) ? this : ((paramInt1 < paramInt2) ? new RegularImmutableSortedSet(this.elements.subList(paramInt1, paramInt2), this.comparator) : emptySet(this.comparator));
  }
  
  int headIndex(E paramE, boolean paramBoolean) {
    SortedLists.KeyPresentBehavior keyPresentBehavior;
    ImmutableList<E> immutableList = this.elements;
    Object object = Preconditions.checkNotNull(paramE);
    Comparator<? super E> comparator = comparator();
    if (paramBoolean) {
      keyPresentBehavior = SortedLists.KeyPresentBehavior.FIRST_AFTER;
    } else {
      keyPresentBehavior = SortedLists.KeyPresentBehavior.FIRST_PRESENT;
    } 
    return SortedLists.binarySearch(immutableList, (E)object, comparator, keyPresentBehavior, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
  }
  
  ImmutableSortedSet<E> headSetImpl(E paramE, boolean paramBoolean) {
    return getSubSet(0, headIndex(paramE, paramBoolean));
  }
  
  public E higher(E paramE) {
    int i = tailIndex(paramE, false);
    if (i == size()) {
      paramE = null;
    } else {
      paramE = this.elements.get(i);
    } 
    return paramE;
  }
  
  int indexOf(@Nullable Object paramObject) {
    if (paramObject == null)
      return -1; 
    try {
      int i = SortedLists.binarySearch(this.elements, (E)paramObject, (Comparator)unsafeComparator(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
      if (i < 0)
        i = -1; 
      return i;
    } catch (ClassCastException classCastException) {
      return -1;
    } 
  }
  
  boolean isPartialView() {
    return this.elements.isPartialView();
  }
  
  public UnmodifiableIterator<E> iterator() {
    return this.elements.iterator();
  }
  
  public E last() {
    if (!isEmpty())
      return this.elements.get(size() - 1); 
    throw new NoSuchElementException();
  }
  
  public E lower(E paramE) {
    int i = headIndex(paramE, false) - 1;
    if (i == -1) {
      paramE = null;
    } else {
      paramE = this.elements.get(i);
    } 
    return paramE;
  }
  
  public int size() {
    return this.elements.size();
  }
  
  ImmutableSortedSet<E> subSetImpl(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2) {
    return tailSetImpl(paramE1, paramBoolean1).headSetImpl(paramE2, paramBoolean2);
  }
  
  int tailIndex(E paramE, boolean paramBoolean) {
    SortedLists.KeyPresentBehavior keyPresentBehavior;
    ImmutableList<E> immutableList = this.elements;
    Object object = Preconditions.checkNotNull(paramE);
    Comparator<? super E> comparator = comparator();
    if (paramBoolean) {
      keyPresentBehavior = SortedLists.KeyPresentBehavior.FIRST_PRESENT;
    } else {
      keyPresentBehavior = SortedLists.KeyPresentBehavior.FIRST_AFTER;
    } 
    return SortedLists.binarySearch(immutableList, (E)object, comparator, keyPresentBehavior, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
  }
  
  ImmutableSortedSet<E> tailSetImpl(E paramE, boolean paramBoolean) {
    return getSubSet(tailIndex(paramE, paramBoolean), size());
  }
  
  Comparator<Object> unsafeComparator() {
    return (Comparator)this.comparator;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\RegularImmutableSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */