package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public abstract class FluentIterable<E> implements Iterable<E> {
  private final Optional<Iterable<E>> iterableDelegate;
  
  protected FluentIterable() {
    this.iterableDelegate = Optional.absent();
  }
  
  FluentIterable(Iterable<E> paramIterable) {
    Preconditions.checkNotNull(paramIterable);
    if (this == paramIterable)
      paramIterable = null; 
    this.iterableDelegate = Optional.fromNullable(paramIterable);
  }
  
  @Beta
  public static <T> FluentIterable<T> concat(final Iterable<? extends Iterable<? extends T>> inputs) {
    Preconditions.checkNotNull(inputs);
    return new FluentIterable<T>() {
        public Iterator<T> iterator() {
          return Iterators.concat(Iterables.transform(inputs, (Function)Iterables.toIterator()).iterator());
        }
      };
  }
  
  @Beta
  public static <T> FluentIterable<T> concat(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2) {
    return concat(ImmutableList.of(paramIterable1, paramIterable2));
  }
  
  @Beta
  public static <T> FluentIterable<T> concat(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2, Iterable<? extends T> paramIterable3) {
    return concat(ImmutableList.of(paramIterable1, paramIterable2, paramIterable3));
  }
  
  @Beta
  public static <T> FluentIterable<T> concat(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2, Iterable<? extends T> paramIterable3, Iterable<? extends T> paramIterable4) {
    return concat(ImmutableList.of(paramIterable1, paramIterable2, paramIterable3, paramIterable4));
  }
  
  @Beta
  public static <T> FluentIterable<T> concat(Iterable<? extends T>... paramVarArgs) {
    return concat(ImmutableList.copyOf(paramVarArgs));
  }
  
  @Deprecated
  public static <E> FluentIterable<E> from(FluentIterable<E> paramFluentIterable) {
    return (FluentIterable<E>)Preconditions.checkNotNull(paramFluentIterable);
  }
  
  public static <E> FluentIterable<E> from(final Iterable<E> iterable) {
    if (iterable instanceof FluentIterable) {
      iterable = iterable;
    } else {
      iterable = new FluentIterable<E>(iterable) {
          public Iterator<E> iterator() {
            return iterable.iterator();
          }
        };
    } 
    return (FluentIterable<E>)iterable;
  }
  
  @Beta
  public static <E> FluentIterable<E> from(E[] paramArrayOfE) {
    return from(Arrays.asList(paramArrayOfE));
  }
  
  private Iterable<E> getDelegate() {
    return (Iterable<E>)this.iterableDelegate.or(this);
  }
  
  @Beta
  public static <E> FluentIterable<E> of() {
    return from(ImmutableList.of());
  }
  
  @Beta
  public static <E> FluentIterable<E> of(@Nullable E paramE, E... paramVarArgs) {
    return from(Lists.asList(paramE, paramVarArgs));
  }
  
  @Deprecated
  @Beta
  public static <E> FluentIterable<E> of(E[] paramArrayOfE) {
    return from(Lists.newArrayList(paramArrayOfE));
  }
  
  public final boolean allMatch(Predicate<? super E> paramPredicate) {
    return Iterables.all(getDelegate(), paramPredicate);
  }
  
  public final boolean anyMatch(Predicate<? super E> paramPredicate) {
    return Iterables.any(getDelegate(), paramPredicate);
  }
  
  @Beta
  public final FluentIterable<E> append(Iterable<? extends E> paramIterable) {
    return from(concat(getDelegate(), paramIterable));
  }
  
  @Beta
  public final FluentIterable<E> append(E... paramVarArgs) {
    return from(concat(getDelegate(), Arrays.asList(paramVarArgs)));
  }
  
  public final boolean contains(@Nullable Object paramObject) {
    return Iterables.contains(getDelegate(), paramObject);
  }
  
  @CanIgnoreReturnValue
  public final <C extends java.util.Collection<? super E>> C copyInto(C paramC) {
    Preconditions.checkNotNull(paramC);
    Iterable<E> iterable = getDelegate();
    if (iterable instanceof java.util.Collection) {
      paramC.addAll(Collections2.cast(iterable));
    } else {
      Iterator<E> iterator = iterable.iterator();
      while (iterator.hasNext())
        paramC.add(iterator.next()); 
    } 
    return paramC;
  }
  
  public final FluentIterable<E> cycle() {
    return from(Iterables.cycle(getDelegate()));
  }
  
  public final FluentIterable<E> filter(Predicate<? super E> paramPredicate) {
    return from(Iterables.filter(getDelegate(), paramPredicate));
  }
  
  @GwtIncompatible
  public final <T> FluentIterable<T> filter(Class<T> paramClass) {
    return from(Iterables.filter(getDelegate(), paramClass));
  }
  
  public final Optional<E> first() {
    Optional<E> optional;
    Iterator<E> iterator = getDelegate().iterator();
    if (iterator.hasNext()) {
      optional = Optional.of(iterator.next());
    } else {
      optional = Optional.absent();
    } 
    return optional;
  }
  
  public final Optional<E> firstMatch(Predicate<? super E> paramPredicate) {
    return Iterables.tryFind(getDelegate(), paramPredicate);
  }
  
  public final E get(int paramInt) {
    return Iterables.get(getDelegate(), paramInt);
  }
  
  public final <K> ImmutableListMultimap<K, E> index(Function<? super E, K> paramFunction) {
    return Multimaps.index(getDelegate(), paramFunction);
  }
  
  public final boolean isEmpty() {
    return getDelegate().iterator().hasNext() ^ true;
  }
  
  @Beta
  public final String join(Joiner paramJoiner) {
    return paramJoiner.join(this);
  }
  
  public final Optional<E> last() {
    Iterable<E> iterable = getDelegate();
    if (iterable instanceof List) {
      List list = (List)iterable;
      return list.isEmpty() ? Optional.absent() : Optional.of(list.get(list.size() - 1));
    } 
    Iterator<E> iterator = iterable.iterator();
    if (!iterator.hasNext())
      return Optional.absent(); 
    if (iterable instanceof SortedSet)
      return Optional.of(((SortedSet)iterable).last()); 
    while (true) {
      iterable = (Iterable<E>)iterator.next();
      if (!iterator.hasNext())
        return Optional.of(iterable); 
    } 
  }
  
  public final FluentIterable<E> limit(int paramInt) {
    return from(Iterables.limit(getDelegate(), paramInt));
  }
  
  public final int size() {
    return Iterables.size(getDelegate());
  }
  
  public final FluentIterable<E> skip(int paramInt) {
    return from(Iterables.skip(getDelegate(), paramInt));
  }
  
  @GwtIncompatible
  public final E[] toArray(Class<E> paramClass) {
    return Iterables.toArray(getDelegate(), paramClass);
  }
  
  public final ImmutableList<E> toList() {
    return ImmutableList.copyOf(getDelegate());
  }
  
  public final <V> ImmutableMap<E, V> toMap(Function<? super E, V> paramFunction) {
    return Maps.toMap(getDelegate(), paramFunction);
  }
  
  public final ImmutableMultiset<E> toMultiset() {
    return ImmutableMultiset.copyOf(getDelegate());
  }
  
  public final ImmutableSet<E> toSet() {
    return ImmutableSet.copyOf(getDelegate());
  }
  
  public final ImmutableList<E> toSortedList(Comparator<? super E> paramComparator) {
    return Ordering.<E>from(paramComparator).immutableSortedCopy(getDelegate());
  }
  
  public final ImmutableSortedSet<E> toSortedSet(Comparator<? super E> paramComparator) {
    return ImmutableSortedSet.copyOf(paramComparator, getDelegate());
  }
  
  public String toString() {
    return Iterables.toString(getDelegate());
  }
  
  public final <T> FluentIterable<T> transform(Function<? super E, T> paramFunction) {
    return from(Iterables.transform(getDelegate(), paramFunction));
  }
  
  public <T> FluentIterable<T> transformAndConcat(Function<? super E, ? extends Iterable<? extends T>> paramFunction) {
    return from(concat(transform(paramFunction)));
  }
  
  public final <K> ImmutableMap<K, E> uniqueIndex(Function<? super E, K> paramFunction) {
    return Maps.uniqueIndex(getDelegate(), paramFunction);
  }
  
  private static class FromIterableFunction<E> implements Function<Iterable<E>, FluentIterable<E>> {
    public FluentIterable<E> apply(Iterable<E> param1Iterable) {
      return FluentIterable.from(param1Iterable);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\FluentIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */