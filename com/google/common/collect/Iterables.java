package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Iterables {
  @CanIgnoreReturnValue
  public static <T> boolean addAll(Collection<T> paramCollection, Iterable<? extends T> paramIterable) {
    return (paramIterable instanceof Collection) ? paramCollection.addAll(Collections2.cast(paramIterable)) : Iterators.addAll(paramCollection, ((Iterable<? extends T>)Preconditions.checkNotNull(paramIterable)).iterator());
  }
  
  public static <T> boolean all(Iterable<T> paramIterable, Predicate<? super T> paramPredicate) {
    return Iterators.all(paramIterable.iterator(), paramPredicate);
  }
  
  public static <T> boolean any(Iterable<T> paramIterable, Predicate<? super T> paramPredicate) {
    return Iterators.any(paramIterable.iterator(), paramPredicate);
  }
  
  private static <E> Collection<E> castOrCopyToCollection(Iterable<E> paramIterable) {
    if (paramIterable instanceof Collection) {
      paramIterable = paramIterable;
    } else {
      paramIterable = Lists.newArrayList(paramIterable.iterator());
    } 
    return (Collection<E>)paramIterable;
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends Iterable<? extends T>> paramIterable) {
    return FluentIterable.concat(paramIterable);
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2) {
    return FluentIterable.concat(paramIterable1, paramIterable2);
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2, Iterable<? extends T> paramIterable3) {
    return FluentIterable.concat(paramIterable1, paramIterable2, paramIterable3);
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2, Iterable<? extends T> paramIterable3, Iterable<? extends T> paramIterable4) {
    return FluentIterable.concat(paramIterable1, paramIterable2, paramIterable3, paramIterable4);
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T>... paramVarArgs) {
    return concat(ImmutableList.copyOf(paramVarArgs));
  }
  
  public static <T> Iterable<T> consumingIterable(final Iterable<T> iterable) {
    if (iterable instanceof Queue)
      return new FluentIterable<T>() {
          public Iterator<T> iterator() {
            return new ConsumingQueueIterator<T>((Queue<T>)iterable);
          }
          
          public String toString() {
            return "Iterables.consumingIterable(...)";
          }
        }; 
    Preconditions.checkNotNull(iterable);
    return new FluentIterable<T>() {
        public Iterator<T> iterator() {
          return Iterators.consumingIterator(iterable.iterator());
        }
        
        public String toString() {
          return "Iterables.consumingIterable(...)";
        }
      };
  }
  
  public static boolean contains(Iterable<?> paramIterable, @Nullable Object paramObject) {
    return (paramIterable instanceof Collection) ? Collections2.safeContains((Collection)paramIterable, paramObject) : Iterators.contains(paramIterable.iterator(), paramObject);
  }
  
  public static <T> Iterable<T> cycle(final Iterable<T> iterable) {
    Preconditions.checkNotNull(iterable);
    return new FluentIterable<T>() {
        public Iterator<T> iterator() {
          return Iterators.cycle(iterable);
        }
        
        public String toString() {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(iterable.toString());
          stringBuilder.append(" (cycled)");
          return stringBuilder.toString();
        }
      };
  }
  
  public static <T> Iterable<T> cycle(T... paramVarArgs) {
    return cycle(Lists.newArrayList(paramVarArgs));
  }
  
  public static boolean elementsEqual(Iterable<?> paramIterable1, Iterable<?> paramIterable2) {
    if (paramIterable1 instanceof Collection && paramIterable2 instanceof Collection) {
      Collection collection1 = (Collection)paramIterable1;
      Collection collection2 = (Collection)paramIterable2;
      if (collection1.size() != collection2.size())
        return false; 
    } 
    return Iterators.elementsEqual(paramIterable1.iterator(), paramIterable2.iterator());
  }
  
  public static <T> Iterable<T> filter(final Iterable<T> unfiltered, final Predicate<? super T> retainIfTrue) {
    Preconditions.checkNotNull(unfiltered);
    Preconditions.checkNotNull(retainIfTrue);
    return new FluentIterable<T>() {
        public Iterator<T> iterator() {
          return Iterators.filter(unfiltered.iterator(), retainIfTrue);
        }
      };
  }
  
  @GwtIncompatible
  public static <T> Iterable<T> filter(final Iterable<?> unfiltered, final Class<T> desiredType) {
    Preconditions.checkNotNull(unfiltered);
    Preconditions.checkNotNull(desiredType);
    return new FluentIterable<T>() {
        public Iterator<T> iterator() {
          return Iterators.filter(unfiltered.iterator(), desiredType);
        }
      };
  }
  
  public static <T> T find(Iterable<T> paramIterable, Predicate<? super T> paramPredicate) {
    return Iterators.find(paramIterable.iterator(), paramPredicate);
  }
  
  @Nullable
  public static <T> T find(Iterable<? extends T> paramIterable, Predicate<? super T> paramPredicate, @Nullable T paramT) {
    return Iterators.find(paramIterable.iterator(), paramPredicate, paramT);
  }
  
  public static int frequency(Iterable<?> paramIterable, @Nullable Object paramObject) {
    return (paramIterable instanceof Multiset) ? ((Multiset)paramIterable).count(paramObject) : ((paramIterable instanceof Set) ? ((Set)paramIterable).contains(paramObject) : Iterators.frequency(paramIterable.iterator(), paramObject));
  }
  
  public static <T> T get(Iterable<T> paramIterable, int paramInt) {
    Preconditions.checkNotNull(paramIterable);
    if (paramIterable instanceof List) {
      paramIterable = ((List)paramIterable).get(paramInt);
    } else {
      paramIterable = Iterators.get((Iterator)paramIterable.iterator(), paramInt);
    } 
    return (T)paramIterable;
  }
  
  @Nullable
  public static <T> T get(Iterable<? extends T> paramIterable, int paramInt, @Nullable T paramT) {
    Preconditions.checkNotNull(paramIterable);
    Iterators.checkNonnegative(paramInt);
    if (paramIterable instanceof List) {
      paramIterable = Lists.cast(paramIterable);
      if (paramInt < paramIterable.size())
        paramT = paramIterable.get(paramInt); 
      return paramT;
    } 
    Iterator<? extends T> iterator = paramIterable.iterator();
    Iterators.advance(iterator, paramInt);
    return Iterators.getNext(iterator, paramT);
  }
  
  @Nullable
  public static <T> T getFirst(Iterable<? extends T> paramIterable, @Nullable T paramT) {
    return Iterators.getNext(paramIterable.iterator(), paramT);
  }
  
  public static <T> T getLast(Iterable<T> paramIterable) {
    if (paramIterable instanceof List) {
      paramIterable = paramIterable;
      if (!paramIterable.isEmpty())
        return getLastInNonemptyList((List<T>)paramIterable); 
      throw new NoSuchElementException();
    } 
    return Iterators.getLast(paramIterable.iterator());
  }
  
  @Nullable
  public static <T> T getLast(Iterable<? extends T> paramIterable, @Nullable T paramT) {
    if (paramIterable instanceof Collection) {
      if (Collections2.<T>cast(paramIterable).isEmpty())
        return paramT; 
      if (paramIterable instanceof List)
        return getLastInNonemptyList(Lists.cast((Iterable)paramIterable)); 
    } 
    return Iterators.getLast(paramIterable.iterator(), paramT);
  }
  
  private static <T> T getLastInNonemptyList(List<T> paramList) {
    return paramList.get(paramList.size() - 1);
  }
  
  public static <T> T getOnlyElement(Iterable<T> paramIterable) {
    return Iterators.getOnlyElement(paramIterable.iterator());
  }
  
  @Nullable
  public static <T> T getOnlyElement(Iterable<? extends T> paramIterable, @Nullable T paramT) {
    return Iterators.getOnlyElement(paramIterable.iterator(), paramT);
  }
  
  public static <T> int indexOf(Iterable<T> paramIterable, Predicate<? super T> paramPredicate) {
    return Iterators.indexOf(paramIterable.iterator(), paramPredicate);
  }
  
  public static boolean isEmpty(Iterable<?> paramIterable) {
    return (paramIterable instanceof Collection) ? ((Collection)paramIterable).isEmpty() : (paramIterable.iterator().hasNext() ^ true);
  }
  
  public static <T> Iterable<T> limit(final Iterable<T> iterable, final int limitSize) {
    boolean bool;
    Preconditions.checkNotNull(iterable);
    if (limitSize >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "limit is negative");
    return new FluentIterable<T>() {
        public Iterator<T> iterator() {
          return Iterators.limit(iterable.iterator(), limitSize);
        }
      };
  }
  
  @Beta
  public static <T> Iterable<T> mergeSorted(final Iterable<? extends Iterable<? extends T>> iterables, final Comparator<? super T> comparator) {
    Preconditions.checkNotNull(iterables, "iterables");
    Preconditions.checkNotNull(comparator, "comparator");
    return new UnmodifiableIterable<T>(new FluentIterable<T>() {
          public Iterator<T> iterator() {
            return Iterators.mergeSorted(Iterables.transform(iterables, (Function)Iterables.toIterator()), comparator);
          }
        });
  }
  
  public static <T> Iterable<List<T>> paddedPartition(final Iterable<T> iterable, final int size) {
    boolean bool;
    Preconditions.checkNotNull(iterable);
    if (size > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    return new FluentIterable<List<T>>() {
        public Iterator<List<T>> iterator() {
          return Iterators.paddedPartition(iterable.iterator(), size);
        }
      };
  }
  
  public static <T> Iterable<List<T>> partition(final Iterable<T> iterable, final int size) {
    boolean bool;
    Preconditions.checkNotNull(iterable);
    if (size > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    return new FluentIterable<List<T>>() {
        public Iterator<List<T>> iterator() {
          return Iterators.partition(iterable.iterator(), size);
        }
      };
  }
  
  @CanIgnoreReturnValue
  public static boolean removeAll(Iterable<?> paramIterable, Collection<?> paramCollection) {
    boolean bool;
    if (paramIterable instanceof Collection) {
      bool = ((Collection)paramIterable).removeAll((Collection)Preconditions.checkNotNull(paramCollection));
    } else {
      bool = Iterators.removeAll(paramIterable.iterator(), paramCollection);
    } 
    return bool;
  }
  
  @Nullable
  static <T> T removeFirstMatching(Iterable<T> paramIterable, Predicate<? super T> paramPredicate) {
    Preconditions.checkNotNull(paramPredicate);
    Iterator<T> iterator = paramIterable.iterator();
    while (iterator.hasNext()) {
      T t = iterator.next();
      if (paramPredicate.apply(t)) {
        iterator.remove();
        return t;
      } 
    } 
    return null;
  }
  
  @CanIgnoreReturnValue
  public static <T> boolean removeIf(Iterable<T> paramIterable, Predicate<? super T> paramPredicate) {
    return (paramIterable instanceof java.util.RandomAccess && paramIterable instanceof List) ? removeIfFromRandomAccessList((List)paramIterable, (Predicate)Preconditions.checkNotNull(paramPredicate)) : Iterators.removeIf(paramIterable.iterator(), paramPredicate);
  }
  
  private static <T> boolean removeIfFromRandomAccessList(List<T> paramList, Predicate<? super T> paramPredicate) {
    boolean bool = false;
    byte b = 0;
    int i;
    for (i = 0; b < paramList.size(); i = j) {
      T t = paramList.get(b);
      int j = i;
      if (!paramPredicate.apply(t)) {
        if (b > i)
          try {
            paramList.set(i, t);
          } catch (UnsupportedOperationException unsupportedOperationException) {
            slowRemoveIfForRemainingElements(paramList, paramPredicate, i, b);
            return true;
          } catch (IllegalArgumentException illegalArgumentException) {
            slowRemoveIfForRemainingElements(paramList, paramPredicate, i, b);
            return true;
          }  
        j = i + 1;
      } 
      b++;
    } 
    paramList.subList(i, paramList.size()).clear();
    if (b != i)
      bool = true; 
    return bool;
  }
  
  @CanIgnoreReturnValue
  public static boolean retainAll(Iterable<?> paramIterable, Collection<?> paramCollection) {
    boolean bool;
    if (paramIterable instanceof Collection) {
      bool = ((Collection)paramIterable).retainAll((Collection)Preconditions.checkNotNull(paramCollection));
    } else {
      bool = Iterators.retainAll(paramIterable.iterator(), paramCollection);
    } 
    return bool;
  }
  
  public static int size(Iterable<?> paramIterable) {
    int i;
    if (paramIterable instanceof Collection) {
      i = ((Collection)paramIterable).size();
    } else {
      i = Iterators.size(paramIterable.iterator());
    } 
    return i;
  }
  
  public static <T> Iterable<T> skip(final Iterable<T> iterable, final int numberToSkip) {
    boolean bool;
    Preconditions.checkNotNull(iterable);
    if (numberToSkip >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "number to skip cannot be negative");
    return (iterable instanceof List) ? new FluentIterable<T>() {
        public Iterator<T> iterator() {
          int i = Math.min(list.size(), numberToSkip);
          List<T> list = list;
          return list.subList(i, list.size()).iterator();
        }
      } : new FluentIterable<T>() {
        public Iterator<T> iterator() {
          final Iterator<?> iterator = iterable.iterator();
          Iterators.advance(iterator, numberToSkip);
          return new Iterator() {
              boolean atStart = true;
              
              public boolean hasNext() {
                return iterator.hasNext();
              }
              
              public T next() {
                T t = (T)iterator.next();
                this.atStart = false;
                return t;
              }
              
              public void remove() {
                CollectPreconditions.checkRemove(this.atStart ^ true);
                iterator.remove();
              }
            };
        }
      };
  }
  
  private static <T> void slowRemoveIfForRemainingElements(List<T> paramList, Predicate<? super T> paramPredicate, int paramInt1, int paramInt2) {
    for (int i = paramList.size() - 1; i > paramInt2; i--) {
      if (paramPredicate.apply(paramList.get(i)))
        paramList.remove(i); 
    } 
    while (--paramInt2 >= paramInt1) {
      paramList.remove(paramInt2);
      paramInt2--;
    } 
  }
  
  static Object[] toArray(Iterable<?> paramIterable) {
    return castOrCopyToCollection(paramIterable).toArray();
  }
  
  @GwtIncompatible
  public static <T> T[] toArray(Iterable<? extends T> paramIterable, Class<T> paramClass) {
    return toArray(paramIterable, ObjectArrays.newArray(paramClass, 0));
  }
  
  static <T> T[] toArray(Iterable<? extends T> paramIterable, T[] paramArrayOfT) {
    return (T[])castOrCopyToCollection(paramIterable).toArray((Object[])paramArrayOfT);
  }
  
  static <T> Function<Iterable<? extends T>, Iterator<? extends T>> toIterator() {
    return new Function<Iterable<? extends T>, Iterator<? extends T>>() {
        public Iterator<? extends T> apply(Iterable<? extends T> param1Iterable) {
          return param1Iterable.iterator();
        }
      };
  }
  
  public static String toString(Iterable<?> paramIterable) {
    return Iterators.toString(paramIterable.iterator());
  }
  
  public static <F, T> Iterable<T> transform(final Iterable<F> fromIterable, final Function<? super F, ? extends T> function) {
    Preconditions.checkNotNull(fromIterable);
    Preconditions.checkNotNull(function);
    return new FluentIterable<T>() {
        public Iterator<T> iterator() {
          return Iterators.transform(fromIterable.iterator(), function);
        }
      };
  }
  
  public static <T> Optional<T> tryFind(Iterable<T> paramIterable, Predicate<? super T> paramPredicate) {
    return Iterators.tryFind(paramIterable.iterator(), paramPredicate);
  }
  
  @Deprecated
  public static <E> Iterable<E> unmodifiableIterable(ImmutableCollection<E> paramImmutableCollection) {
    return (Iterable<E>)Preconditions.checkNotNull(paramImmutableCollection);
  }
  
  public static <T> Iterable<T> unmodifiableIterable(Iterable<? extends T> paramIterable) {
    Preconditions.checkNotNull(paramIterable);
    return (paramIterable instanceof UnmodifiableIterable || paramIterable instanceof ImmutableCollection) ? paramIterable : new UnmodifiableIterable<T>(paramIterable);
  }
  
  private static final class UnmodifiableIterable<T> extends FluentIterable<T> {
    private final Iterable<? extends T> iterable;
    
    private UnmodifiableIterable(Iterable<? extends T> param1Iterable) {
      this.iterable = param1Iterable;
    }
    
    public Iterator<T> iterator() {
      return Iterators.unmodifiableIterator(this.iterable.iterator());
    }
    
    public String toString() {
      return this.iterable.toString();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Iterables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */