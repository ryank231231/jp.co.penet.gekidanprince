package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Iterators {
  static final UnmodifiableListIterator<Object> EMPTY_LIST_ITERATOR = new UnmodifiableListIterator() {
      public boolean hasNext() {
        return false;
      }
      
      public boolean hasPrevious() {
        return false;
      }
      
      public Object next() {
        throw new NoSuchElementException();
      }
      
      public int nextIndex() {
        return 0;
      }
      
      public Object previous() {
        throw new NoSuchElementException();
      }
      
      public int previousIndex() {
        return -1;
      }
    };
  
  private static final Iterator<Object> EMPTY_MODIFIABLE_ITERATOR = new Iterator() {
      public boolean hasNext() {
        return false;
      }
      
      public Object next() {
        throw new NoSuchElementException();
      }
      
      public void remove() {
        CollectPreconditions.checkRemove(false);
      }
    };
  
  @CanIgnoreReturnValue
  public static <T> boolean addAll(Collection<T> paramCollection, Iterator<? extends T> paramIterator) {
    Preconditions.checkNotNull(paramCollection);
    Preconditions.checkNotNull(paramIterator);
    boolean bool;
    for (bool = false; paramIterator.hasNext(); bool |= paramCollection.add(paramIterator.next()));
    return bool;
  }
  
  @CanIgnoreReturnValue
  public static int advance(Iterator<?> paramIterator, int paramInt) {
    boolean bool;
    Preconditions.checkNotNull(paramIterator);
    byte b = 0;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "numberToAdvance must be nonnegative");
    while (b < paramInt && paramIterator.hasNext()) {
      paramIterator.next();
      b++;
    } 
    return b;
  }
  
  public static <T> boolean all(Iterator<T> paramIterator, Predicate<? super T> paramPredicate) {
    Preconditions.checkNotNull(paramPredicate);
    while (paramIterator.hasNext()) {
      if (!paramPredicate.apply(paramIterator.next()))
        return false; 
    } 
    return true;
  }
  
  public static <T> boolean any(Iterator<T> paramIterator, Predicate<? super T> paramPredicate) {
    boolean bool;
    if (indexOf(paramIterator, paramPredicate) != -1) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static <T> Enumeration<T> asEnumeration(final Iterator<T> iterator) {
    Preconditions.checkNotNull(iterator);
    return new Enumeration<T>() {
        public boolean hasMoreElements() {
          return iterator.hasNext();
        }
        
        public T nextElement() {
          return iterator.next();
        }
      };
  }
  
  static <T> ListIterator<T> cast(Iterator<T> paramIterator) {
    return (ListIterator<T>)paramIterator;
  }
  
  static void checkNonnegative(int paramInt) {
    if (paramInt >= 0)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("position (");
    stringBuilder.append(paramInt);
    stringBuilder.append(") must not be negative");
    throw new IndexOutOfBoundsException(stringBuilder.toString());
  }
  
  static void clear(Iterator<?> paramIterator) {
    Preconditions.checkNotNull(paramIterator);
    while (paramIterator.hasNext()) {
      paramIterator.next();
      paramIterator.remove();
    } 
  }
  
  public static <T> Iterator<T> concat(Iterator<? extends Iterator<? extends T>> paramIterator) {
    return new ConcatenatedIterator<T>(paramIterator);
  }
  
  public static <T> Iterator<T> concat(Iterator<? extends T> paramIterator1, Iterator<? extends T> paramIterator2) {
    Preconditions.checkNotNull(paramIterator1);
    Preconditions.checkNotNull(paramIterator2);
    return concat(new ConsumingQueueIterator<Iterator<? extends T>>((Iterator<? extends T>[])new Iterator[] { paramIterator1, paramIterator2 }));
  }
  
  public static <T> Iterator<T> concat(Iterator<? extends T> paramIterator1, Iterator<? extends T> paramIterator2, Iterator<? extends T> paramIterator3) {
    Preconditions.checkNotNull(paramIterator1);
    Preconditions.checkNotNull(paramIterator2);
    Preconditions.checkNotNull(paramIterator3);
    return concat(new ConsumingQueueIterator<Iterator<? extends T>>((Iterator<? extends T>[])new Iterator[] { paramIterator1, paramIterator2, paramIterator3 }));
  }
  
  public static <T> Iterator<T> concat(Iterator<? extends T> paramIterator1, Iterator<? extends T> paramIterator2, Iterator<? extends T> paramIterator3, Iterator<? extends T> paramIterator4) {
    Preconditions.checkNotNull(paramIterator1);
    Preconditions.checkNotNull(paramIterator2);
    Preconditions.checkNotNull(paramIterator3);
    Preconditions.checkNotNull(paramIterator4);
    return concat(new ConsumingQueueIterator<Iterator<? extends T>>((Iterator<? extends T>[])new Iterator[] { paramIterator1, paramIterator2, paramIterator3, paramIterator4 }));
  }
  
  public static <T> Iterator<T> concat(Iterator<? extends T>... paramVarArgs) {
    Iterator[] arrayOfIterator = (Iterator[])Preconditions.checkNotNull(paramVarArgs);
    int i = arrayOfIterator.length;
    for (byte b = 0; b < i; b++)
      Preconditions.checkNotNull(arrayOfIterator[b]); 
    return concat(new ConsumingQueueIterator<Iterator<? extends T>>(paramVarArgs));
  }
  
  public static <T> Iterator<T> consumingIterator(final Iterator<T> iterator) {
    Preconditions.checkNotNull(iterator);
    return new UnmodifiableIterator<T>() {
        public boolean hasNext() {
          return iterator.hasNext();
        }
        
        public T next() {
          T t = (T)iterator.next();
          iterator.remove();
          return t;
        }
        
        public String toString() {
          return "Iterators.consumingIterator(...)";
        }
      };
  }
  
  public static boolean contains(Iterator<?> paramIterator, @Nullable Object paramObject) {
    return any(paramIterator, Predicates.equalTo(paramObject));
  }
  
  public static <T> Iterator<T> cycle(final Iterable<T> iterable) {
    Preconditions.checkNotNull(iterable);
    return new Iterator<T>() {
        Iterator<T> iterator = Iterators.emptyModifiableIterator();
        
        public boolean hasNext() {
          return (this.iterator.hasNext() || iterable.iterator().hasNext());
        }
        
        public T next() {
          if (!this.iterator.hasNext()) {
            this.iterator = iterable.iterator();
            if (!this.iterator.hasNext())
              throw new NoSuchElementException(); 
          } 
          return this.iterator.next();
        }
        
        public void remove() {
          this.iterator.remove();
        }
      };
  }
  
  @SafeVarargs
  public static <T> Iterator<T> cycle(T... paramVarArgs) {
    return cycle(Lists.newArrayList(paramVarArgs));
  }
  
  public static boolean elementsEqual(Iterator<?> paramIterator1, Iterator<?> paramIterator2) {
    while (paramIterator1.hasNext()) {
      if (!paramIterator2.hasNext())
        return false; 
      if (!Objects.equal(paramIterator1.next(), paramIterator2.next()))
        return false; 
    } 
    return paramIterator2.hasNext() ^ true;
  }
  
  static <T> UnmodifiableIterator<T> emptyIterator() {
    return emptyListIterator();
  }
  
  static <T> UnmodifiableListIterator<T> emptyListIterator() {
    return (UnmodifiableListIterator)EMPTY_LIST_ITERATOR;
  }
  
  static <T> Iterator<T> emptyModifiableIterator() {
    return (Iterator)EMPTY_MODIFIABLE_ITERATOR;
  }
  
  public static <T> UnmodifiableIterator<T> filter(final Iterator<T> unfiltered, final Predicate<? super T> retainIfTrue) {
    Preconditions.checkNotNull(unfiltered);
    Preconditions.checkNotNull(retainIfTrue);
    return new AbstractIterator<T>() {
        protected T computeNext() {
          while (unfiltered.hasNext()) {
            T t = (T)unfiltered.next();
            if (retainIfTrue.apply(t))
              return t; 
          } 
          return endOfData();
        }
      };
  }
  
  @GwtIncompatible
  public static <T> UnmodifiableIterator<T> filter(Iterator<?> paramIterator, Class<T> paramClass) {
    return filter((Iterator)paramIterator, Predicates.instanceOf(paramClass));
  }
  
  public static <T> T find(Iterator<T> paramIterator, Predicate<? super T> paramPredicate) {
    return filter(paramIterator, paramPredicate).next();
  }
  
  @Nullable
  public static <T> T find(Iterator<? extends T> paramIterator, Predicate<? super T> paramPredicate, @Nullable T paramT) {
    return getNext(filter(paramIterator, paramPredicate), paramT);
  }
  
  @SafeVarargs
  public static <T> UnmodifiableIterator<T> forArray(T... paramVarArgs) {
    return forArray(paramVarArgs, 0, paramVarArgs.length, 0);
  }
  
  static <T> UnmodifiableListIterator<T> forArray(final T[] array, final int offset, int paramInt2, int paramInt3) {
    boolean bool;
    if (paramInt2 >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    Preconditions.checkPositionIndexes(offset, offset + paramInt2, array.length);
    Preconditions.checkPositionIndex(paramInt3, paramInt2);
    return (paramInt2 == 0) ? emptyListIterator() : new AbstractIndexedListIterator<T>(paramInt2, paramInt3) {
        protected T get(int param1Int) {
          return (T)array[offset + param1Int];
        }
      };
  }
  
  public static <T> UnmodifiableIterator<T> forEnumeration(final Enumeration<T> enumeration) {
    Preconditions.checkNotNull(enumeration);
    return new UnmodifiableIterator<T>() {
        public boolean hasNext() {
          return enumeration.hasMoreElements();
        }
        
        public T next() {
          return enumeration.nextElement();
        }
      };
  }
  
  public static int frequency(Iterator<?> paramIterator, @Nullable Object paramObject) {
    return size(filter(paramIterator, Predicates.equalTo(paramObject)));
  }
  
  public static <T> T get(Iterator<T> paramIterator, int paramInt) {
    checkNonnegative(paramInt);
    int i = advance(paramIterator, paramInt);
    if (paramIterator.hasNext())
      return paramIterator.next(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("position (");
    stringBuilder.append(paramInt);
    stringBuilder.append(") must be less than the number of elements that remained (");
    stringBuilder.append(i);
    stringBuilder.append(")");
    throw new IndexOutOfBoundsException(stringBuilder.toString());
  }
  
  @Nullable
  public static <T> T get(Iterator<? extends T> paramIterator, int paramInt, @Nullable T paramT) {
    checkNonnegative(paramInt);
    advance(paramIterator, paramInt);
    return getNext(paramIterator, paramT);
  }
  
  public static <T> T getLast(Iterator<T> paramIterator) {
    while (true) {
      T t = paramIterator.next();
      if (!paramIterator.hasNext())
        return t; 
    } 
  }
  
  @Nullable
  public static <T> T getLast(Iterator<? extends T> paramIterator, @Nullable T paramT) {
    if (paramIterator.hasNext())
      paramT = getLast((Iterator)paramIterator); 
    return paramT;
  }
  
  @Nullable
  public static <T> T getNext(Iterator<? extends T> paramIterator, @Nullable T paramT) {
    if (paramIterator.hasNext())
      paramT = paramIterator.next(); 
    return paramT;
  }
  
  @CanIgnoreReturnValue
  public static <T> T getOnlyElement(Iterator<T> paramIterator) {
    T t = paramIterator.next();
    if (!paramIterator.hasNext())
      return t; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("expected one element but was: <");
    stringBuilder.append(t);
    for (byte b = 0; b < 4 && paramIterator.hasNext(); b++) {
      stringBuilder.append(", ");
      stringBuilder.append(paramIterator.next());
    } 
    if (paramIterator.hasNext())
      stringBuilder.append(", ..."); 
    stringBuilder.append('>');
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  @Nullable
  @CanIgnoreReturnValue
  public static <T> T getOnlyElement(Iterator<? extends T> paramIterator, @Nullable T paramT) {
    if (paramIterator.hasNext())
      paramT = getOnlyElement((Iterator)paramIterator); 
    return paramT;
  }
  
  public static <T> int indexOf(Iterator<T> paramIterator, Predicate<? super T> paramPredicate) {
    Preconditions.checkNotNull(paramPredicate, "predicate");
    for (byte b = 0; paramIterator.hasNext(); b++) {
      if (paramPredicate.apply(paramIterator.next()))
        return b; 
    } 
    return -1;
  }
  
  public static <T> Iterator<T> limit(final Iterator<T> iterator, final int limitSize) {
    boolean bool;
    Preconditions.checkNotNull(iterator);
    if (limitSize >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "limit is negative");
    return new Iterator<T>() {
        private int count;
        
        public boolean hasNext() {
          boolean bool;
          if (this.count < limitSize && iterator.hasNext()) {
            bool = true;
          } else {
            bool = false;
          } 
          return bool;
        }
        
        public T next() {
          if (hasNext()) {
            this.count++;
            return iterator.next();
          } 
          throw new NoSuchElementException();
        }
        
        public void remove() {
          iterator.remove();
        }
      };
  }
  
  @Beta
  public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends Iterator<? extends T>> paramIterable, Comparator<? super T> paramComparator) {
    Preconditions.checkNotNull(paramIterable, "iterators");
    Preconditions.checkNotNull(paramComparator, "comparator");
    return new MergingIterator<T>(paramIterable, paramComparator);
  }
  
  public static <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> paramIterator, int paramInt) {
    return partitionImpl(paramIterator, paramInt, true);
  }
  
  public static <T> UnmodifiableIterator<List<T>> partition(Iterator<T> paramIterator, int paramInt) {
    return partitionImpl(paramIterator, paramInt, false);
  }
  
  private static <T> UnmodifiableIterator<List<T>> partitionImpl(final Iterator<T> iterator, final int size, final boolean pad) {
    boolean bool;
    Preconditions.checkNotNull(iterator);
    if (size > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    return new UnmodifiableIterator<List<T>>() {
        public boolean hasNext() {
          return iterator.hasNext();
        }
        
        public List<T> next() {
          if (hasNext()) {
            Object[] arrayOfObject = new Object[size];
            byte b1;
            for (b1 = 0; b1 < size && iterator.hasNext(); b1++)
              arrayOfObject[b1] = iterator.next(); 
            for (byte b2 = b1; b2 < size; b2++)
              arrayOfObject[b2] = null; 
            List<?> list2 = Collections.unmodifiableList(Arrays.asList(arrayOfObject));
            List<?> list1 = list2;
            if (!pad)
              if (b1 == size) {
                list1 = list2;
              } else {
                list1 = list2.subList(0, b1);
              }  
            return (List)list1;
          } 
          throw new NoSuchElementException();
        }
      };
  }
  
  @Deprecated
  public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> paramPeekingIterator) {
    return (PeekingIterator<T>)Preconditions.checkNotNull(paramPeekingIterator);
  }
  
  public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> paramIterator) {
    return (paramIterator instanceof PeekingImpl) ? (PeekingImpl)paramIterator : new PeekingImpl<T>(paramIterator);
  }
  
  @Nullable
  static <T> T pollNext(Iterator<T> paramIterator) {
    if (paramIterator.hasNext()) {
      T t = paramIterator.next();
      paramIterator.remove();
      return t;
    } 
    return null;
  }
  
  @CanIgnoreReturnValue
  public static boolean removeAll(Iterator<?> paramIterator, Collection<?> paramCollection) {
    return removeIf(paramIterator, Predicates.in(paramCollection));
  }
  
  @CanIgnoreReturnValue
  public static <T> boolean removeIf(Iterator<T> paramIterator, Predicate<? super T> paramPredicate) {
    Preconditions.checkNotNull(paramPredicate);
    boolean bool = false;
    while (paramIterator.hasNext()) {
      if (paramPredicate.apply(paramIterator.next())) {
        paramIterator.remove();
        bool = true;
      } 
    } 
    return bool;
  }
  
  @CanIgnoreReturnValue
  public static boolean retainAll(Iterator<?> paramIterator, Collection<?> paramCollection) {
    return removeIf(paramIterator, Predicates.not(Predicates.in(paramCollection)));
  }
  
  public static <T> UnmodifiableIterator<T> singletonIterator(@Nullable final T value) {
    return new UnmodifiableIterator<T>() {
        boolean done;
        
        public boolean hasNext() {
          return this.done ^ true;
        }
        
        public T next() {
          if (!this.done) {
            this.done = true;
            return (T)value;
          } 
          throw new NoSuchElementException();
        }
      };
  }
  
  public static int size(Iterator<?> paramIterator) {
    long l;
    for (l = 0L; paramIterator.hasNext(); l++)
      paramIterator.next(); 
    return Ints.saturatedCast(l);
  }
  
  @GwtIncompatible
  public static <T> T[] toArray(Iterator<? extends T> paramIterator, Class<T> paramClass) {
    return Iterables.toArray(Lists.newArrayList(paramIterator), paramClass);
  }
  
  public static String toString(Iterator<?> paramIterator) {
    Joiner joiner = Collections2.STANDARD_JOINER;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append('[');
    StringBuilder stringBuilder1 = joiner.appendTo(stringBuilder2, paramIterator);
    stringBuilder1.append(']');
    return stringBuilder1.toString();
  }
  
  public static <F, T> Iterator<T> transform(Iterator<F> paramIterator, final Function<? super F, ? extends T> function) {
    Preconditions.checkNotNull(function);
    return new TransformedIterator<F, T>(paramIterator) {
        T transform(F param1F) {
          return (T)function.apply(param1F);
        }
      };
  }
  
  public static <T> Optional<T> tryFind(Iterator<T> paramIterator, Predicate<? super T> paramPredicate) {
    Optional<T> optional;
    paramIterator = filter(paramIterator, paramPredicate);
    if (paramIterator.hasNext()) {
      optional = Optional.of(paramIterator.next());
    } else {
      optional = Optional.absent();
    } 
    return optional;
  }
  
  @Deprecated
  public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> paramUnmodifiableIterator) {
    return (UnmodifiableIterator<T>)Preconditions.checkNotNull(paramUnmodifiableIterator);
  }
  
  public static <T> UnmodifiableIterator<T> unmodifiableIterator(final Iterator<? extends T> iterator) {
    Preconditions.checkNotNull(iterator);
    return (iterator instanceof UnmodifiableIterator) ? (UnmodifiableIterator)iterator : new UnmodifiableIterator<T>() {
        public boolean hasNext() {
          return iterator.hasNext();
        }
        
        public T next() {
          return iterator.next();
        }
      };
  }
  
  private static class ConcatenatedIterator<T> extends MultitransformedIterator<Iterator<? extends T>, T> {
    public ConcatenatedIterator(Iterator<? extends Iterator<? extends T>> param1Iterator) {
      super(getComponentIterators(param1Iterator));
    }
    
    private static <T> Iterator<Iterator<? extends T>> getComponentIterators(Iterator<? extends Iterator<? extends T>> param1Iterator) {
      return (Iterator)new MultitransformedIterator<Iterator<? extends Iterator<? extends T>>, Iterator<? extends Iterator<? extends T>>>(param1Iterator) {
          Iterator<? extends Iterator<? extends T>> transform(Iterator<? extends T> param2Iterator) {
            return (param2Iterator instanceof Iterators.ConcatenatedIterator) ? Iterators.ConcatenatedIterator.getComponentIterators(((Iterators.ConcatenatedIterator)param2Iterator).backingIterator) : Iterators.singletonIterator(param2Iterator);
          }
        };
    }
    
    Iterator<? extends T> transform(Iterator<? extends T> param1Iterator) {
      return param1Iterator;
    }
  }
  
  static final class null extends MultitransformedIterator<Iterator<? extends T>, Iterator<? extends T>> {
    null(Iterator<? extends Iterator<? extends T>> param1Iterator) {
      super(param1Iterator);
    }
    
    Iterator<? extends Iterator<? extends T>> transform(Iterator<? extends T> param1Iterator) {
      return (param1Iterator instanceof Iterators.ConcatenatedIterator) ? Iterators.ConcatenatedIterator.getComponentIterators(((Iterators.ConcatenatedIterator)param1Iterator).backingIterator) : Iterators.singletonIterator(param1Iterator);
    }
  }
  
  private static class MergingIterator<T> extends UnmodifiableIterator<T> {
    final Queue<PeekingIterator<T>> queue = new PriorityQueue<PeekingIterator<T>>(2, (Comparator)new Comparator<PeekingIterator<PeekingIterator<T>>>() {
          public int compare(PeekingIterator<T> param2PeekingIterator1, PeekingIterator<T> param2PeekingIterator2) {
            return itemComparator.compare(param2PeekingIterator1.peek(), param2PeekingIterator2.peek());
          }
        });
    
    public MergingIterator(Iterable<? extends Iterator<? extends T>> param1Iterable, final Comparator<? super T> itemComparator) {
      for (Iterator<? extends T> iterator : param1Iterable) {
        if (iterator.hasNext())
          this.queue.add(Iterators.peekingIterator(iterator)); 
      } 
    }
    
    public boolean hasNext() {
      return this.queue.isEmpty() ^ true;
    }
    
    public T next() {
      PeekingIterator<Object> peekingIterator = (PeekingIterator)this.queue.remove();
      T t = (T)peekingIterator.next();
      if (peekingIterator.hasNext())
        this.queue.add(peekingIterator); 
      return t;
    }
  }
  
  class null implements Comparator<PeekingIterator<T>> {
    public int compare(PeekingIterator<T> param1PeekingIterator1, PeekingIterator<T> param1PeekingIterator2) {
      return itemComparator.compare(param1PeekingIterator1.peek(), param1PeekingIterator2.peek());
    }
  }
  
  private static class PeekingImpl<E> implements PeekingIterator<E> {
    private boolean hasPeeked;
    
    private final Iterator<? extends E> iterator;
    
    private E peekedElement;
    
    public PeekingImpl(Iterator<? extends E> param1Iterator) {
      this.iterator = (Iterator<? extends E>)Preconditions.checkNotNull(param1Iterator);
    }
    
    public boolean hasNext() {
      return (this.hasPeeked || this.iterator.hasNext());
    }
    
    public E next() {
      if (!this.hasPeeked)
        return this.iterator.next(); 
      E e = this.peekedElement;
      this.hasPeeked = false;
      this.peekedElement = null;
      return e;
    }
    
    public E peek() {
      if (!this.hasPeeked) {
        this.peekedElement = this.iterator.next();
        this.hasPeeked = true;
      } 
      return this.peekedElement;
    }
    
    public void remove() {
      Preconditions.checkState(this.hasPeeked ^ true, "Can't remove after you've peeked at next");
      this.iterator.remove();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Iterators.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */