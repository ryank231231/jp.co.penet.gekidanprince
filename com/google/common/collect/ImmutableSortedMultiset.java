package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

@GwtIncompatible
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements SortedMultiset<E> {
  @LazyInit
  transient ImmutableSortedMultiset<E> descendingMultiset;
  
  public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> paramIterable) {
    return copyOf(Ordering.natural(), paramIterable);
  }
  
  public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> paramComparator, Iterable<? extends E> paramIterable) {
    if (paramIterable instanceof ImmutableSortedMultiset) {
      ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset)paramIterable;
      if (paramComparator.equals(immutableSortedMultiset.comparator()))
        return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(paramComparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset; 
    } 
    paramIterable = Lists.newArrayList(paramIterable);
    TreeMultiset<?> treeMultiset = TreeMultiset.create((Comparator)Preconditions.checkNotNull(paramComparator));
    Iterables.addAll(treeMultiset, paramIterable);
    return copyOfSortedEntries(paramComparator, treeMultiset.entrySet());
  }
  
  public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> paramComparator, Iterator<? extends E> paramIterator) {
    Preconditions.checkNotNull(paramComparator);
    return (new Builder<E>(paramComparator)).addAll(paramIterator).build();
  }
  
  public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> paramIterator) {
    return copyOf(Ordering.natural(), paramIterator);
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> copyOf(E[] paramArrayOfE) {
    return copyOf(Ordering.natural(), Arrays.asList(paramArrayOfE));
  }
  
  public static <E> ImmutableSortedMultiset<E> copyOfSorted(SortedMultiset<E> paramSortedMultiset) {
    return copyOfSortedEntries(paramSortedMultiset.comparator(), Lists.newArrayList(paramSortedMultiset.entrySet()));
  }
  
  private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> paramComparator, Collection<Multiset.Entry<E>> paramCollection) {
    if (paramCollection.isEmpty())
      return emptyMultiset(paramComparator); 
    ImmutableList.Builder<E> builder = new ImmutableList.Builder(paramCollection.size());
    long[] arrayOfLong = new long[paramCollection.size() + 1];
    Iterator<Multiset.Entry<E>> iterator = paramCollection.iterator();
    int i;
    for (i = 0; iterator.hasNext(); i = j) {
      Multiset.Entry entry = iterator.next();
      builder.add(entry.getElement());
      int j = i + 1;
      arrayOfLong[j] = arrayOfLong[i] + entry.getCount();
    } 
    return new RegularImmutableSortedMultiset<E>(new RegularImmutableSortedSet<E>(builder.build(), paramComparator), arrayOfLong, 0, paramCollection.size());
  }
  
  static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> paramComparator) {
    return (ImmutableSortedMultiset<E>)(Ordering.<Comparable>natural().equals(paramComparator) ? RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET : new RegularImmutableSortedMultiset<E>(paramComparator));
  }
  
  public static <E extends Comparable<?>> Builder<E> naturalOrder() {
    return new Builder<E>(Ordering.natural());
  }
  
  public static <E> ImmutableSortedMultiset<E> of() {
    return (ImmutableSortedMultiset)RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE) {
    return new RegularImmutableSortedMultiset<E>((RegularImmutableSortedSet<E>)ImmutableSortedSet.<E>of(paramE), new long[] { 0L, 1L }, 0, 1);
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE1, E paramE2) {
    return copyOf(Ordering.natural(), Arrays.asList((E[])new Comparable[] { (Comparable)paramE1, (Comparable)paramE2 }));
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE1, E paramE2, E paramE3) {
    return copyOf(Ordering.natural(), Arrays.asList((E[])new Comparable[] { (Comparable)paramE1, (Comparable)paramE2, (Comparable)paramE3 }));
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4) {
    return copyOf(Ordering.natural(), Arrays.asList((E[])new Comparable[] { (Comparable)paramE1, (Comparable)paramE2, (Comparable)paramE3, (Comparable)paramE4 }));
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5) {
    return copyOf(Ordering.natural(), Arrays.asList((E[])new Comparable[] { (Comparable)paramE1, (Comparable)paramE2, (Comparable)paramE3, (Comparable)paramE4, (Comparable)paramE5 }));
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs) {
    ArrayList<?> arrayList = Lists.newArrayListWithCapacity(paramVarArgs.length + 6);
    Collections.addAll(arrayList, (Object[])new Comparable[] { (Comparable)paramE1, (Comparable)paramE2, (Comparable)paramE3, (Comparable)paramE4, (Comparable)paramE5, (Comparable)paramE6 });
    Collections.addAll(arrayList, (Object[])paramVarArgs);
    return copyOf(Ordering.natural(), (Iterable)arrayList);
  }
  
  public static <E> Builder<E> orderedBy(Comparator<E> paramComparator) {
    return new Builder<E>(paramComparator);
  }
  
  public static <E extends Comparable<?>> Builder<E> reverseOrder() {
    return new Builder<E>(Ordering.<Comparable>natural().reverse());
  }
  
  public final Comparator<? super E> comparator() {
    return elementSet().comparator();
  }
  
  public ImmutableSortedMultiset<E> descendingMultiset() {
    ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
    if (immutableSortedMultiset == null) {
      if (isEmpty()) {
        immutableSortedMultiset = emptyMultiset(Ordering.<E>from(comparator()).reverse());
      } else {
        immutableSortedMultiset = new DescendingImmutableSortedMultiset<E>(this);
      } 
      this.descendingMultiset = immutableSortedMultiset;
      return immutableSortedMultiset;
    } 
    return immutableSortedMultiset;
  }
  
  public abstract ImmutableSortedSet<E> elementSet();
  
  public abstract ImmutableSortedMultiset<E> headMultiset(E paramE, BoundType paramBoundType);
  
  @Deprecated
  @CanIgnoreReturnValue
  public final Multiset.Entry<E> pollFirstEntry() {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final Multiset.Entry<E> pollLastEntry() {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableSortedMultiset<E> subMultiset(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2) {
    boolean bool;
    if (comparator().compare(paramE1, paramE2) <= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Expected lowerBound <= upperBound but %s > %s", paramE1, paramE2);
    return tailMultiset(paramE1, paramBoundType1).headMultiset(paramE2, paramBoundType2);
  }
  
  public abstract ImmutableSortedMultiset<E> tailMultiset(E paramE, BoundType paramBoundType);
  
  Object writeReplace() {
    return new SerializedForm(this);
  }
  
  public static class Builder<E> extends ImmutableMultiset.Builder<E> {
    public Builder(Comparator<? super E> param1Comparator) {
      super(TreeMultiset.create((Comparator<? super E>)Preconditions.checkNotNull(param1Comparator)));
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
    
    @CanIgnoreReturnValue
    public Builder<E> addCopies(E param1E, int param1Int) {
      super.addCopies(param1E, param1Int);
      return this;
    }
    
    public ImmutableSortedMultiset<E> build() {
      return ImmutableSortedMultiset.copyOfSorted((SortedMultiset<E>)this.contents);
    }
    
    @CanIgnoreReturnValue
    public Builder<E> setCount(E param1E, int param1Int) {
      super.setCount(param1E, param1Int);
      return this;
    }
  }
  
  private static final class SerializedForm<E> implements Serializable {
    final Comparator<? super E> comparator;
    
    final int[] counts;
    
    final E[] elements;
    
    SerializedForm(SortedMultiset<E> param1SortedMultiset) {
      this.comparator = param1SortedMultiset.comparator();
      int i = param1SortedMultiset.entrySet().size();
      this.elements = (E[])new Object[i];
      this.counts = new int[i];
      Iterator<Multiset.Entry> iterator = param1SortedMultiset.entrySet().iterator();
      for (i = 0; iterator.hasNext(); i++) {
        Multiset.Entry<E> entry = iterator.next();
        this.elements[i] = entry.getElement();
        this.counts[i] = entry.getCount();
      } 
    }
    
    Object readResolve() {
      int i = this.elements.length;
      ImmutableSortedMultiset.Builder<E> builder = new ImmutableSortedMultiset.Builder<E>(this.comparator);
      for (byte b = 0; b < i; b++)
        builder.addCopies(this.elements[b], this.counts[b]); 
      return builder.build();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableSortedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */