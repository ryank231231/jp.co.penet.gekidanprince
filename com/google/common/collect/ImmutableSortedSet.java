package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, SortedIterable<E> {
  final transient Comparator<? super E> comparator;
  
  @LazyInit
  @GwtIncompatible
  transient ImmutableSortedSet<E> descendingSet;
  
  ImmutableSortedSet(Comparator<? super E> paramComparator) {
    this.comparator = paramComparator;
  }
  
  static <E> ImmutableSortedSet<E> construct(Comparator<? super E> paramComparator, int paramInt, E... paramVarArgs) {
    if (paramInt == 0)
      return emptySet(paramComparator); 
    ObjectArrays.checkElementsNotNull((Object[])paramVarArgs, paramInt);
    Arrays.sort(paramVarArgs, 0, paramInt, paramComparator);
    byte b = 1;
    int i;
    for (i = 1; b < paramInt; i = j) {
      E e = paramVarArgs[b];
      int j = i;
      if (paramComparator.compare(e, paramVarArgs[i - 1]) != 0) {
        paramVarArgs[i] = e;
        j = i + 1;
      } 
      b++;
    } 
    Arrays.fill((Object[])paramVarArgs, i, paramInt, (Object)null);
    return new RegularImmutableSortedSet<E>(ImmutableList.asImmutableList((Object[])paramVarArgs, i), paramComparator);
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> paramIterable) {
    return copyOf(Ordering.natural(), paramIterable);
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> paramCollection) {
    return copyOf(Ordering.natural(), paramCollection);
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> paramComparator, Iterable<? extends E> paramIterable) {
    Preconditions.checkNotNull(paramComparator);
    if (SortedIterables.hasSameComparator(paramComparator, paramIterable) && paramIterable instanceof ImmutableSortedSet) {
      ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet)paramIterable;
      if (!immutableSortedSet.isPartialView())
        return immutableSortedSet; 
    } 
    Object[] arrayOfObject = Iterables.toArray(paramIterable);
    return construct(paramComparator, arrayOfObject.length, (E[])arrayOfObject);
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> paramComparator, Collection<? extends E> paramCollection) {
    return copyOf(paramComparator, paramCollection);
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> paramComparator, Iterator<? extends E> paramIterator) {
    return (new Builder<E>(paramComparator)).addAll(paramIterator).build();
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> paramIterator) {
    return copyOf(Ordering.natural(), paramIterator);
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> copyOf(E[] paramArrayOfE) {
    return construct(Ordering.natural(), paramArrayOfE.length, (E[])paramArrayOfE.clone());
  }
  
  public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> paramSortedSet) {
    Comparator<? super E> comparator = SortedIterables.comparator(paramSortedSet);
    ImmutableList<E> immutableList = ImmutableList.copyOf(paramSortedSet);
    return immutableList.isEmpty() ? emptySet(comparator) : new RegularImmutableSortedSet<E>(immutableList, comparator);
  }
  
  static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> paramComparator) {
    return (RegularImmutableSortedSet<E>)(Ordering.<Comparable>natural().equals(paramComparator) ? RegularImmutableSortedSet.NATURAL_EMPTY_SET : new RegularImmutableSortedSet<E>(ImmutableList.of(), paramComparator));
  }
  
  public static <E extends Comparable<?>> Builder<E> naturalOrder() {
    return new Builder<E>(Ordering.natural());
  }
  
  public static <E> ImmutableSortedSet<E> of() {
    return (ImmutableSortedSet)RegularImmutableSortedSet.NATURAL_EMPTY_SET;
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE) {
    return new RegularImmutableSortedSet<E>(ImmutableList.of(paramE), Ordering.natural());
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE1, E paramE2) {
    return construct(Ordering.natural(), 2, (E[])new Comparable[] { (Comparable)paramE1, (Comparable)paramE2 });
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE1, E paramE2, E paramE3) {
    return construct(Ordering.natural(), 3, (E[])new Comparable[] { (Comparable)paramE1, (Comparable)paramE2, (Comparable)paramE3 });
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4) {
    return construct(Ordering.natural(), 4, (E[])new Comparable[] { (Comparable)paramE1, (Comparable)paramE2, (Comparable)paramE3, (Comparable)paramE4 });
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5) {
    return construct(Ordering.natural(), 5, (E[])new Comparable[] { (Comparable)paramE1, (Comparable)paramE2, (Comparable)paramE3, (Comparable)paramE4, (Comparable)paramE5 });
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs) {
    Comparable[] arrayOfComparable = new Comparable[paramVarArgs.length + 6];
    arrayOfComparable[0] = (Comparable)paramE1;
    arrayOfComparable[1] = (Comparable)paramE2;
    arrayOfComparable[2] = (Comparable)paramE3;
    arrayOfComparable[3] = (Comparable)paramE4;
    arrayOfComparable[4] = (Comparable)paramE5;
    arrayOfComparable[5] = (Comparable)paramE6;
    System.arraycopy(paramVarArgs, 0, arrayOfComparable, 6, paramVarArgs.length);
    return construct(Ordering.natural(), arrayOfComparable.length, (E[])arrayOfComparable);
  }
  
  public static <E> Builder<E> orderedBy(Comparator<E> paramComparator) {
    return new Builder<E>(paramComparator);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream) throws InvalidObjectException {
    throw new InvalidObjectException("Use SerializedForm");
  }
  
  public static <E extends Comparable<?>> Builder<E> reverseOrder() {
    return new Builder<E>(Ordering.<Comparable>natural().reverse());
  }
  
  static int unsafeCompare(Comparator<?> paramComparator, Object paramObject1, Object paramObject2) {
    return paramComparator.compare(paramObject1, paramObject2);
  }
  
  @GwtIncompatible
  public E ceiling(E paramE) {
    return Iterables.getFirst(tailSet(paramE, true), null);
  }
  
  public Comparator<? super E> comparator() {
    return this.comparator;
  }
  
  @GwtIncompatible
  ImmutableSortedSet<E> createDescendingSet() {
    return new DescendingImmutableSortedSet<E>(this);
  }
  
  @GwtIncompatible
  public abstract UnmodifiableIterator<E> descendingIterator();
  
  @GwtIncompatible
  public ImmutableSortedSet<E> descendingSet() {
    ImmutableSortedSet<E> immutableSortedSet1 = this.descendingSet;
    ImmutableSortedSet<E> immutableSortedSet2 = immutableSortedSet1;
    if (immutableSortedSet1 == null) {
      immutableSortedSet2 = createDescendingSet();
      this.descendingSet = immutableSortedSet2;
      immutableSortedSet2.descendingSet = this;
    } 
    return immutableSortedSet2;
  }
  
  public E first() {
    return iterator().next();
  }
  
  @GwtIncompatible
  public E floor(E paramE) {
    return Iterators.getNext(headSet(paramE, true).descendingIterator(), null);
  }
  
  public ImmutableSortedSet<E> headSet(E paramE) {
    return headSet(paramE, false);
  }
  
  @GwtIncompatible
  public ImmutableSortedSet<E> headSet(E paramE, boolean paramBoolean) {
    return headSetImpl((E)Preconditions.checkNotNull(paramE), paramBoolean);
  }
  
  abstract ImmutableSortedSet<E> headSetImpl(E paramE, boolean paramBoolean);
  
  @GwtIncompatible
  public E higher(E paramE) {
    return Iterables.getFirst(tailSet(paramE, false), null);
  }
  
  abstract int indexOf(@Nullable Object paramObject);
  
  public abstract UnmodifiableIterator<E> iterator();
  
  public E last() {
    return descendingIterator().next();
  }
  
  @GwtIncompatible
  public E lower(E paramE) {
    return Iterators.getNext(headSet(paramE, false).descendingIterator(), null);
  }
  
  @Deprecated
  @GwtIncompatible
  @CanIgnoreReturnValue
  public final E pollFirst() {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @GwtIncompatible
  @CanIgnoreReturnValue
  public final E pollLast() {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableSortedSet<E> subSet(E paramE1, E paramE2) {
    return subSet(paramE1, true, paramE2, false);
  }
  
  @GwtIncompatible
  public ImmutableSortedSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2) {
    boolean bool;
    Preconditions.checkNotNull(paramE1);
    Preconditions.checkNotNull(paramE2);
    if (this.comparator.compare(paramE1, paramE2) <= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    return subSetImpl(paramE1, paramBoolean1, paramE2, paramBoolean2);
  }
  
  abstract ImmutableSortedSet<E> subSetImpl(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2);
  
  public ImmutableSortedSet<E> tailSet(E paramE) {
    return tailSet(paramE, true);
  }
  
  @GwtIncompatible
  public ImmutableSortedSet<E> tailSet(E paramE, boolean paramBoolean) {
    return tailSetImpl((E)Preconditions.checkNotNull(paramE), paramBoolean);
  }
  
  abstract ImmutableSortedSet<E> tailSetImpl(E paramE, boolean paramBoolean);
  
  int unsafeCompare(Object paramObject1, Object paramObject2) {
    return unsafeCompare(this.comparator, paramObject1, paramObject2);
  }
  
  Object writeReplace() {
    return new SerializedForm<E>(this.comparator, toArray());
  }
  
  public static final class Builder<E> extends ImmutableSet.Builder<E> {
    private final Comparator<? super E> comparator;
    
    public Builder(Comparator<? super E> param1Comparator) {
      this.comparator = (Comparator<? super E>)Preconditions.checkNotNull(param1Comparator);
    }
    
    @CanIgnoreReturnValue
    public Builder<E> add(E param1E) {
      super.add(param1E);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> add(E... param1VarArgs) {
      super.add(param1VarArgs);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> addAll(Iterable<? extends E> param1Iterable) {
      super.addAll(param1Iterable);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> addAll(Iterator<? extends E> param1Iterator) {
      super.addAll(param1Iterator);
      return this;
    }
    
    public ImmutableSortedSet<E> build() {
      Object[] arrayOfObject = this.contents;
      ImmutableSortedSet<E> immutableSortedSet = ImmutableSortedSet.construct(this.comparator, this.size, (E[])arrayOfObject);
      this.size = immutableSortedSet.size();
      return immutableSortedSet;
    }
  }
  
  private static class SerializedForm<E> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final Comparator<? super E> comparator;
    
    final Object[] elements;
    
    public SerializedForm(Comparator<? super E> param1Comparator, Object[] param1ArrayOfObject) {
      this.comparator = param1Comparator;
      this.elements = param1ArrayOfObject;
    }
    
    Object readResolve() {
      return (new ImmutableSortedSet.Builder((Comparator)this.comparator)).add(this.elements).build();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */