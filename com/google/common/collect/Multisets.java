package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public final class Multisets {
  private static final Ordering<Multiset.Entry<?>> DECREASING_COUNT_ORDERING = new Ordering<Multiset.Entry<?>>() {
      public int compare(Multiset.Entry<?> param1Entry1, Multiset.Entry<?> param1Entry2) {
        return Ints.compare(param1Entry2.getCount(), param1Entry1.getCount());
      }
    };
  
  static <E> boolean addAllImpl(Multiset<E> paramMultiset, Collection<? extends E> paramCollection) {
    if (paramCollection.isEmpty())
      return false; 
    if (paramCollection instanceof Multiset) {
      for (Multiset.Entry<E> entry : (Iterable<Multiset.Entry<E>>)cast(paramCollection).entrySet())
        paramMultiset.add(entry.getElement(), entry.getCount()); 
    } else {
      Iterators.addAll(paramMultiset, entry.iterator());
    } 
    return true;
  }
  
  static <T> Multiset<T> cast(Iterable<T> paramIterable) {
    return (Multiset<T>)paramIterable;
  }
  
  @CanIgnoreReturnValue
  public static boolean containsOccurrences(Multiset<?> paramMultiset1, Multiset<?> paramMultiset2) {
    Preconditions.checkNotNull(paramMultiset1);
    Preconditions.checkNotNull(paramMultiset2);
    for (Multiset.Entry<?> entry : paramMultiset2.entrySet()) {
      if (paramMultiset1.count(entry.getElement()) < entry.getCount())
        return false; 
    } 
    return true;
  }
  
  @Beta
  public static <E> ImmutableMultiset<E> copyHighestCountFirst(Multiset<E> paramMultiset) {
    return ImmutableMultiset.copyFromEntries(DECREASING_COUNT_ORDERING.immutableSortedCopy(paramMultiset.entrySet()));
  }
  
  @Beta
  public static <E> Multiset<E> difference(final Multiset<E> multiset1, final Multiset<?> multiset2) {
    Preconditions.checkNotNull(multiset1);
    Preconditions.checkNotNull(multiset2);
    return new AbstractMultiset<E>() {
        public int count(@Nullable Object param1Object) {
          int i = multiset1.count(param1Object);
          int j = 0;
          if (i != 0)
            j = Math.max(0, i - multiset2.count(param1Object)); 
          return j;
        }
        
        int distinctElements() {
          return Iterators.size(entryIterator());
        }
        
        Iterator<Multiset.Entry<E>> entryIterator() {
          return new AbstractIterator() {
              protected Multiset.Entry<E> computeNext() {
                while (iterator1.hasNext()) {
                  Multiset.Entry<Object> entry = iterator1.next();
                  E e = (E)entry.getElement();
                  int i = entry.getCount() - multiset2.count(e);
                  if (i > 0)
                    return Multisets.immutableEntry(e, i); 
                } 
                return endOfData();
              }
            };
        }
      };
  }
  
  static boolean equalsImpl(Multiset<?> paramMultiset, @Nullable Object paramObject) {
    if (paramObject == paramMultiset)
      return true; 
    if (paramObject instanceof Multiset) {
      paramObject = paramObject;
      if (paramMultiset.size() != paramObject.size() || paramMultiset.entrySet().size() != paramObject.entrySet().size())
        return false; 
      paramObject = paramObject.entrySet().iterator();
      while (paramObject.hasNext()) {
        Multiset.Entry entry = paramObject.next();
        if (paramMultiset.count(entry.getElement()) != entry.getCount())
          return false; 
      } 
      return true;
    } 
    return false;
  }
  
  @Beta
  public static <E> Multiset<E> filter(Multiset<E> paramMultiset, Predicate<? super E> paramPredicate) {
    if (paramMultiset instanceof FilteredMultiset) {
      paramMultiset = paramMultiset;
      paramPredicate = Predicates.and(((FilteredMultiset)paramMultiset).predicate, paramPredicate);
      return new FilteredMultiset<E>(((FilteredMultiset)paramMultiset).unfiltered, paramPredicate);
    } 
    return new FilteredMultiset<E>(paramMultiset, paramPredicate);
  }
  
  public static <E> Multiset.Entry<E> immutableEntry(@Nullable E paramE, int paramInt) {
    return new ImmutableEntry<E>(paramE, paramInt);
  }
  
  static int inferDistinctElements(Iterable<?> paramIterable) {
    return (paramIterable instanceof Multiset) ? ((Multiset)paramIterable).elementSet().size() : 11;
  }
  
  public static <E> Multiset<E> intersection(final Multiset<E> multiset1, final Multiset<?> multiset2) {
    Preconditions.checkNotNull(multiset1);
    Preconditions.checkNotNull(multiset2);
    return new AbstractMultiset<E>() {
        public int count(Object param1Object) {
          int i = multiset1.count(param1Object);
          if (i == 0) {
            i = 0;
          } else {
            i = Math.min(i, multiset2.count(param1Object));
          } 
          return i;
        }
        
        Set<E> createElementSet() {
          return Sets.intersection(multiset1.elementSet(), multiset2.elementSet());
        }
        
        int distinctElements() {
          return elementSet().size();
        }
        
        Iterator<Multiset.Entry<E>> entryIterator() {
          return new AbstractIterator() {
              protected Multiset.Entry<E> computeNext() {
                while (iterator1.hasNext()) {
                  Multiset.Entry<Object> entry = iterator1.next();
                  E e = (E)entry.getElement();
                  int i = Math.min(entry.getCount(), multiset2.count(e));
                  if (i > 0)
                    return Multisets.immutableEntry(e, i); 
                } 
                return endOfData();
              }
            };
        }
      };
  }
  
  static <E> Iterator<E> iteratorImpl(Multiset<E> paramMultiset) {
    return new MultisetIteratorImpl<E>(paramMultiset, paramMultiset.entrySet().iterator());
  }
  
  static boolean removeAllImpl(Multiset<?> paramMultiset, Collection<?> paramCollection) {
    Collection<?> collection = paramCollection;
    if (paramCollection instanceof Multiset)
      collection = ((Multiset)paramCollection).elementSet(); 
    return paramMultiset.elementSet().removeAll(collection);
  }
  
  @CanIgnoreReturnValue
  public static boolean removeOccurrences(Multiset<?> paramMultiset1, Multiset<?> paramMultiset2) {
    Preconditions.checkNotNull(paramMultiset1);
    Preconditions.checkNotNull(paramMultiset2);
    Iterator<Multiset.Entry> iterator = paramMultiset1.entrySet().iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      Multiset.Entry entry = iterator.next();
      int i = paramMultiset2.count(entry.getElement());
      if (i >= entry.getCount()) {
        iterator.remove();
        bool = true;
        continue;
      } 
      if (i > 0) {
        paramMultiset1.remove(entry.getElement(), i);
        bool = true;
      } 
    } 
    return bool;
  }
  
  @CanIgnoreReturnValue
  public static boolean removeOccurrences(Multiset<?> paramMultiset, Iterable<?> paramIterable) {
    if (paramIterable instanceof Multiset)
      return removeOccurrences(paramMultiset, (Multiset)paramIterable); 
    Preconditions.checkNotNull(paramMultiset);
    Preconditions.checkNotNull(paramIterable);
    boolean bool = false;
    Iterator<?> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      bool |= paramMultiset.remove(iterator.next()); 
    return bool;
  }
  
  static boolean retainAllImpl(Multiset<?> paramMultiset, Collection<?> paramCollection) {
    Preconditions.checkNotNull(paramCollection);
    Collection<?> collection = paramCollection;
    if (paramCollection instanceof Multiset)
      collection = ((Multiset)paramCollection).elementSet(); 
    return paramMultiset.elementSet().retainAll(collection);
  }
  
  @CanIgnoreReturnValue
  public static boolean retainOccurrences(Multiset<?> paramMultiset1, Multiset<?> paramMultiset2) {
    return retainOccurrencesImpl(paramMultiset1, paramMultiset2);
  }
  
  private static <E> boolean retainOccurrencesImpl(Multiset<E> paramMultiset, Multiset<?> paramMultiset1) {
    Preconditions.checkNotNull(paramMultiset);
    Preconditions.checkNotNull(paramMultiset1);
    Iterator<Multiset.Entry> iterator = paramMultiset.entrySet().iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      Multiset.Entry<E> entry = iterator.next();
      int i = paramMultiset1.count(entry.getElement());
      if (i == 0) {
        iterator.remove();
        bool = true;
        continue;
      } 
      if (i < entry.getCount()) {
        paramMultiset.setCount(entry.getElement(), i);
        bool = true;
      } 
    } 
    return bool;
  }
  
  static <E> int setCountImpl(Multiset<E> paramMultiset, E paramE, int paramInt) {
    CollectPreconditions.checkNonnegative(paramInt, "count");
    int i = paramMultiset.count(paramE);
    paramInt -= i;
    if (paramInt > 0) {
      paramMultiset.add(paramE, paramInt);
    } else if (paramInt < 0) {
      paramMultiset.remove(paramE, -paramInt);
    } 
    return i;
  }
  
  static <E> boolean setCountImpl(Multiset<E> paramMultiset, E paramE, int paramInt1, int paramInt2) {
    CollectPreconditions.checkNonnegative(paramInt1, "oldCount");
    CollectPreconditions.checkNonnegative(paramInt2, "newCount");
    if (paramMultiset.count(paramE) == paramInt1) {
      paramMultiset.setCount(paramE, paramInt2);
      return true;
    } 
    return false;
  }
  
  static int sizeImpl(Multiset<?> paramMultiset) {
    Iterator<Multiset.Entry> iterator = paramMultiset.entrySet().iterator();
    long l;
    for (l = 0L; iterator.hasNext(); l += ((Multiset.Entry)iterator.next()).getCount());
    return Ints.saturatedCast(l);
  }
  
  @Beta
  public static <E> Multiset<E> sum(final Multiset<? extends E> multiset1, final Multiset<? extends E> multiset2) {
    Preconditions.checkNotNull(multiset1);
    Preconditions.checkNotNull(multiset2);
    return new AbstractMultiset<E>() {
        public boolean contains(@Nullable Object param1Object) {
          return (multiset1.contains(param1Object) || multiset2.contains(param1Object));
        }
        
        public int count(Object param1Object) {
          return multiset1.count(param1Object) + multiset2.count(param1Object);
        }
        
        Set<E> createElementSet() {
          return Sets.union(multiset1.elementSet(), multiset2.elementSet());
        }
        
        int distinctElements() {
          return elementSet().size();
        }
        
        Iterator<Multiset.Entry<E>> entryIterator() {
          return new AbstractIterator() {
              protected Multiset.Entry<E> computeNext() {
                if (iterator1.hasNext()) {
                  Multiset.Entry<Object> entry = iterator1.next();
                  E e = (E)entry.getElement();
                  return Multisets.immutableEntry(e, entry.getCount() + multiset2.count(e));
                } 
                while (iterator2.hasNext()) {
                  Multiset.Entry<Object> entry = iterator2.next();
                  E e = (E)entry.getElement();
                  if (!multiset1.contains(e))
                    return Multisets.immutableEntry(e, entry.getCount()); 
                } 
                return endOfData();
              }
            };
        }
        
        public boolean isEmpty() {
          boolean bool;
          if (multiset1.isEmpty() && multiset2.isEmpty()) {
            bool = true;
          } else {
            bool = false;
          } 
          return bool;
        }
        
        public int size() {
          return IntMath.saturatedAdd(multiset1.size(), multiset2.size());
        }
      };
  }
  
  @Beta
  public static <E> Multiset<E> union(final Multiset<? extends E> multiset1, final Multiset<? extends E> multiset2) {
    Preconditions.checkNotNull(multiset1);
    Preconditions.checkNotNull(multiset2);
    return new AbstractMultiset<E>() {
        public boolean contains(@Nullable Object param1Object) {
          return (multiset1.contains(param1Object) || multiset2.contains(param1Object));
        }
        
        public int count(Object param1Object) {
          return Math.max(multiset1.count(param1Object), multiset2.count(param1Object));
        }
        
        Set<E> createElementSet() {
          return Sets.union(multiset1.elementSet(), multiset2.elementSet());
        }
        
        int distinctElements() {
          return elementSet().size();
        }
        
        Iterator<Multiset.Entry<E>> entryIterator() {
          return new AbstractIterator() {
              protected Multiset.Entry<E> computeNext() {
                if (iterator1.hasNext()) {
                  Multiset.Entry<Object> entry = iterator1.next();
                  E e = (E)entry.getElement();
                  return Multisets.immutableEntry(e, Math.max(entry.getCount(), multiset2.count(e)));
                } 
                while (iterator2.hasNext()) {
                  Multiset.Entry<Object> entry = iterator2.next();
                  E e = (E)entry.getElement();
                  if (!multiset1.contains(e))
                    return Multisets.immutableEntry(e, entry.getCount()); 
                } 
                return endOfData();
              }
            };
        }
        
        public boolean isEmpty() {
          boolean bool;
          if (multiset1.isEmpty() && multiset2.isEmpty()) {
            bool = true;
          } else {
            bool = false;
          } 
          return bool;
        }
      };
  }
  
  @Deprecated
  public static <E> Multiset<E> unmodifiableMultiset(ImmutableMultiset<E> paramImmutableMultiset) {
    return (Multiset<E>)Preconditions.checkNotNull(paramImmutableMultiset);
  }
  
  public static <E> Multiset<E> unmodifiableMultiset(Multiset<? extends E> paramMultiset) {
    return (paramMultiset instanceof UnmodifiableMultiset || paramMultiset instanceof ImmutableMultiset) ? paramMultiset : new UnmodifiableMultiset<E>((Multiset<? extends E>)Preconditions.checkNotNull(paramMultiset));
  }
  
  @Beta
  public static <E> SortedMultiset<E> unmodifiableSortedMultiset(SortedMultiset<E> paramSortedMultiset) {
    return new UnmodifiableSortedMultiset<E>((SortedMultiset<E>)Preconditions.checkNotNull(paramSortedMultiset));
  }
  
  static abstract class AbstractEntry<E> implements Multiset.Entry<E> {
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof Multiset.Entry;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (getCount() == param1Object.getCount()) {
          bool = bool1;
          if (Objects.equal(getElement(), param1Object.getElement()))
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public int hashCode() {
      int i;
      E e = getElement();
      if (e == null) {
        i = 0;
      } else {
        i = e.hashCode();
      } 
      return i ^ getCount();
    }
    
    public String toString() {
      String str = String.valueOf(getElement());
      int i = getCount();
      if (i != 1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" x ");
        stringBuilder.append(i);
        str = stringBuilder.toString();
      } 
      return str;
    }
  }
  
  static abstract class ElementSet<E> extends Sets.ImprovedAbstractSet<E> {
    public void clear() {
      multiset().clear();
    }
    
    public boolean contains(Object param1Object) {
      return multiset().contains(param1Object);
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      return multiset().containsAll(param1Collection);
    }
    
    public boolean isEmpty() {
      return multiset().isEmpty();
    }
    
    public Iterator<E> iterator() {
      return new TransformedIterator<Multiset.Entry<E>, E>(multiset().entrySet().iterator()) {
          E transform(Multiset.Entry<E> param2Entry) {
            return param2Entry.getElement();
          }
        };
    }
    
    abstract Multiset<E> multiset();
    
    public boolean remove(Object param1Object) {
      boolean bool;
      if (multiset().remove(param1Object, 2147483647) > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int size() {
      return multiset().entrySet().size();
    }
  }
  
  class null extends TransformedIterator<Multiset.Entry<E>, E> {
    null(Iterator<? extends Multiset.Entry<E>> param1Iterator) {
      super(param1Iterator);
    }
    
    E transform(Multiset.Entry<E> param1Entry) {
      return param1Entry.getElement();
    }
  }
  
  static abstract class EntrySet<E> extends Sets.ImprovedAbstractSet<Multiset.Entry<E>> {
    public void clear() {
      multiset().clear();
    }
    
    public boolean contains(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof Multiset.Entry;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        if (param1Object.getCount() <= 0)
          return false; 
        if (multiset().count(param1Object.getElement()) == param1Object.getCount())
          bool1 = true; 
        return bool1;
      } 
      return false;
    }
    
    abstract Multiset<E> multiset();
    
    public boolean remove(Object param1Object) {
      if (param1Object instanceof Multiset.Entry) {
        param1Object = param1Object;
        E e = (E)param1Object.getElement();
        int i = param1Object.getCount();
        if (i != 0)
          return multiset().setCount(e, i, 0); 
      } 
      return false;
    }
  }
  
  private static final class FilteredMultiset<E> extends AbstractMultiset<E> {
    final Predicate<? super E> predicate;
    
    final Multiset<E> unfiltered;
    
    FilteredMultiset(Multiset<E> param1Multiset, Predicate<? super E> param1Predicate) {
      this.unfiltered = (Multiset<E>)Preconditions.checkNotNull(param1Multiset);
      this.predicate = (Predicate<? super E>)Preconditions.checkNotNull(param1Predicate);
    }
    
    public int add(@Nullable E param1E, int param1Int) {
      Preconditions.checkArgument(this.predicate.apply(param1E), "Element %s does not match predicate %s", param1E, this.predicate);
      return this.unfiltered.add(param1E, param1Int);
    }
    
    public void clear() {
      elementSet().clear();
    }
    
    public int count(@Nullable Object param1Object) {
      int i = this.unfiltered.count(param1Object);
      if (i > 0) {
        if (!this.predicate.apply(param1Object))
          i = 0; 
        return i;
      } 
      return 0;
    }
    
    Set<E> createElementSet() {
      return Sets.filter(this.unfiltered.elementSet(), this.predicate);
    }
    
    Set<Multiset.Entry<E>> createEntrySet() {
      return Sets.filter(this.unfiltered.entrySet(), new Predicate<Multiset.Entry<E>>() {
            public boolean apply(Multiset.Entry<E> param2Entry) {
              return Multisets.FilteredMultiset.this.predicate.apply(param2Entry.getElement());
            }
          });
    }
    
    int distinctElements() {
      return elementSet().size();
    }
    
    Iterator<Multiset.Entry<E>> entryIterator() {
      throw new AssertionError("should never be called");
    }
    
    public UnmodifiableIterator<E> iterator() {
      return Iterators.filter(this.unfiltered.iterator(), this.predicate);
    }
    
    public int remove(@Nullable Object param1Object, int param1Int) {
      CollectPreconditions.checkNonnegative(param1Int, "occurrences");
      if (param1Int == 0)
        return count(param1Object); 
      if (contains(param1Object)) {
        param1Int = this.unfiltered.remove(param1Object, param1Int);
      } else {
        param1Int = 0;
      } 
      return param1Int;
    }
  }
  
  class null implements Predicate<Multiset.Entry<E>> {
    public boolean apply(Multiset.Entry<E> param1Entry) {
      return this.this$0.predicate.apply(param1Entry.getElement());
    }
  }
  
  static class ImmutableEntry<E> extends AbstractEntry<E> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private final int count;
    
    @Nullable
    private final E element;
    
    ImmutableEntry(@Nullable E param1E, int param1Int) {
      this.element = param1E;
      this.count = param1Int;
      CollectPreconditions.checkNonnegative(param1Int, "count");
    }
    
    public final int getCount() {
      return this.count;
    }
    
    @Nullable
    public final E getElement() {
      return this.element;
    }
    
    public ImmutableEntry<E> nextInBucket() {
      return null;
    }
  }
  
  static final class MultisetIteratorImpl<E> implements Iterator<E> {
    private boolean canRemove;
    
    private Multiset.Entry<E> currentEntry;
    
    private final Iterator<Multiset.Entry<E>> entryIterator;
    
    private int laterCount;
    
    private final Multiset<E> multiset;
    
    private int totalCount;
    
    MultisetIteratorImpl(Multiset<E> param1Multiset, Iterator<Multiset.Entry<E>> param1Iterator) {
      this.multiset = param1Multiset;
      this.entryIterator = param1Iterator;
    }
    
    public boolean hasNext() {
      return (this.laterCount > 0 || this.entryIterator.hasNext());
    }
    
    public E next() {
      if (hasNext()) {
        if (this.laterCount == 0) {
          this.currentEntry = this.entryIterator.next();
          int i = this.currentEntry.getCount();
          this.laterCount = i;
          this.totalCount = i;
        } 
        this.laterCount--;
        this.canRemove = true;
        return this.currentEntry.getElement();
      } 
      throw new NoSuchElementException();
    }
    
    public void remove() {
      CollectPreconditions.checkRemove(this.canRemove);
      if (this.totalCount == 1) {
        this.entryIterator.remove();
      } else {
        this.multiset.remove(this.currentEntry.getElement());
      } 
      this.totalCount--;
      this.canRemove = false;
    }
  }
  
  static class UnmodifiableMultiset<E> extends ForwardingMultiset<E> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final Multiset<? extends E> delegate;
    
    transient Set<E> elementSet;
    
    transient Set<Multiset.Entry<E>> entrySet;
    
    UnmodifiableMultiset(Multiset<? extends E> param1Multiset) {
      this.delegate = param1Multiset;
    }
    
    public int add(E param1E, int param1Int) {
      throw new UnsupportedOperationException();
    }
    
    public boolean add(E param1E) {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends E> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    public void clear() {
      throw new UnsupportedOperationException();
    }
    
    Set<E> createElementSet() {
      return Collections.unmodifiableSet(this.delegate.elementSet());
    }
    
    protected Multiset<E> delegate() {
      return (Multiset)this.delegate;
    }
    
    public Set<E> elementSet() {
      Set<E> set1 = this.elementSet;
      Set<E> set2 = set1;
      if (set1 == null) {
        set2 = createElementSet();
        this.elementSet = set2;
      } 
      return set2;
    }
    
    public Set<Multiset.Entry<E>> entrySet() {
      Set<Multiset.Entry<E>> set1 = this.entrySet;
      Set<Multiset.Entry<E>> set2 = set1;
      if (set1 == null) {
        set2 = Collections.unmodifiableSet((Set)this.delegate.entrySet());
        this.entrySet = set2;
      } 
      return set2;
    }
    
    public Iterator<E> iterator() {
      return Iterators.unmodifiableIterator(this.delegate.iterator());
    }
    
    public int remove(Object param1Object, int param1Int) {
      throw new UnsupportedOperationException();
    }
    
    public boolean remove(Object param1Object) {
      throw new UnsupportedOperationException();
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    public int setCount(E param1E, int param1Int) {
      throw new UnsupportedOperationException();
    }
    
    public boolean setCount(E param1E, int param1Int1, int param1Int2) {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Multisets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */