package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Sets {
  public static <B> Set<List<B>> cartesianProduct(List<? extends Set<? extends B>> paramList) {
    return CartesianSet.create(paramList);
  }
  
  public static <B> Set<List<B>> cartesianProduct(Set<? extends B>... paramVarArgs) {
    return cartesianProduct(Arrays.asList(paramVarArgs));
  }
  
  public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> paramCollection) {
    if (paramCollection instanceof EnumSet)
      return EnumSet.complementOf((EnumSet<E>)paramCollection); 
    Preconditions.checkArgument(paramCollection.isEmpty() ^ true, "collection is empty; use the other version of this method");
    return makeComplementByHand(paramCollection, ((Enum<E>)paramCollection.iterator().next()).getDeclaringClass());
  }
  
  public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> paramCollection, Class<E> paramClass) {
    Preconditions.checkNotNull(paramCollection);
    if (paramCollection instanceof EnumSet) {
      paramCollection = EnumSet.complementOf((EnumSet<E>)paramCollection);
    } else {
      paramCollection = makeComplementByHand(paramCollection, paramClass);
    } 
    return (EnumSet<E>)paramCollection;
  }
  
  public static <E> SetView<E> difference(final Set<E> set1, final Set<?> set2) {
    Preconditions.checkNotNull(set1, "set1");
    Preconditions.checkNotNull(set2, "set2");
    return new SetView<E>() {
        public boolean contains(Object param1Object) {
          boolean bool;
          if (set1.contains(param1Object) && !set2.contains(param1Object)) {
            bool = true;
          } else {
            bool = false;
          } 
          return bool;
        }
        
        public boolean isEmpty() {
          return set2.containsAll(set1);
        }
        
        public UnmodifiableIterator<E> iterator() {
          return Iterators.filter(set1.iterator(), notInSet2);
        }
        
        public int size() {
          return Iterators.size(iterator());
        }
      };
  }
  
  static boolean equalsImpl(Set<?> paramSet, @Nullable Object paramObject) {
    boolean bool = true;
    if (paramSet == paramObject)
      return true; 
    if (paramObject instanceof Set) {
      paramObject = paramObject;
      try {
        if (paramSet.size() == paramObject.size()) {
          boolean bool1 = paramSet.containsAll((Collection<?>)paramObject);
          if (bool1)
            return bool; 
        } 
        return false;
      } catch (NullPointerException nullPointerException) {
        return false;
      } catch (ClassCastException classCastException) {
        return false;
      } 
    } 
    return false;
  }
  
  @GwtIncompatible
  public static <E> NavigableSet<E> filter(NavigableSet<E> paramNavigableSet, Predicate<? super E> paramPredicate) {
    FilteredSet filteredSet;
    if (paramNavigableSet instanceof FilteredSet) {
      filteredSet = (FilteredSet)paramNavigableSet;
      paramPredicate = Predicates.and(filteredSet.predicate, paramPredicate);
      return new FilteredNavigableSet<E>((NavigableSet<E>)filteredSet.unfiltered, paramPredicate);
    } 
    return new FilteredNavigableSet<E>((NavigableSet<E>)Preconditions.checkNotNull(filteredSet), (Predicate<? super E>)Preconditions.checkNotNull(paramPredicate));
  }
  
  public static <E> Set<E> filter(Set<E> paramSet, Predicate<? super E> paramPredicate) {
    if (paramSet instanceof SortedSet)
      return filter((SortedSet<E>)paramSet, paramPredicate); 
    if (paramSet instanceof FilteredSet) {
      paramSet = paramSet;
      paramPredicate = Predicates.and(((FilteredSet)paramSet).predicate, paramPredicate);
      return new FilteredSet<E>((Set<E>)((FilteredSet)paramSet).unfiltered, paramPredicate);
    } 
    return new FilteredSet<E>((Set<E>)Preconditions.checkNotNull(paramSet), (Predicate<? super E>)Preconditions.checkNotNull(paramPredicate));
  }
  
  public static <E> SortedSet<E> filter(SortedSet<E> paramSortedSet, Predicate<? super E> paramPredicate) {
    FilteredSet filteredSet;
    if (paramSortedSet instanceof FilteredSet) {
      filteredSet = (FilteredSet)paramSortedSet;
      paramPredicate = Predicates.and(filteredSet.predicate, paramPredicate);
      return new FilteredSortedSet<E>((SortedSet<E>)filteredSet.unfiltered, paramPredicate);
    } 
    return new FilteredSortedSet<E>((SortedSet<E>)Preconditions.checkNotNull(filteredSet), (Predicate<? super E>)Preconditions.checkNotNull(paramPredicate));
  }
  
  static int hashCodeImpl(Set<?> paramSet) {
    Iterator<?> iterator = paramSet.iterator();
    int i;
    for (i = 0; iterator.hasNext(); i = i + b ^ 0xFFFFFFFF ^ 0xFFFFFFFF) {
      byte b;
      paramSet = (Set<?>)iterator.next();
      if (paramSet != null) {
        b = paramSet.hashCode();
      } else {
        b = 0;
      } 
    } 
    return i;
  }
  
  @GwtCompatible(serializable = true)
  public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(E paramE, E... paramVarArgs) {
    return ImmutableEnumSet.asImmutable(EnumSet.of(paramE, paramVarArgs));
  }
  
  @GwtCompatible(serializable = true)
  public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(Iterable<E> paramIterable) {
    if (paramIterable instanceof ImmutableEnumSet)
      return (ImmutableEnumSet)paramIterable; 
    if (paramIterable instanceof Collection) {
      paramIterable = paramIterable;
      return paramIterable.isEmpty() ? ImmutableSet.of() : ImmutableEnumSet.asImmutable(EnumSet.copyOf((Collection<E>)paramIterable));
    } 
    Iterator<E> iterator = paramIterable.iterator();
    if (iterator.hasNext()) {
      EnumSet<Enum> enumSet = EnumSet.of((Enum)iterator.next());
      Iterators.addAll(enumSet, iterator);
      return ImmutableEnumSet.asImmutable(enumSet);
    } 
    return ImmutableSet.of();
  }
  
  public static <E> SetView<E> intersection(final Set<E> set1, final Set<?> set2) {
    Preconditions.checkNotNull(set1, "set1");
    Preconditions.checkNotNull(set2, "set2");
    return new SetView<E>() {
        public boolean contains(Object param1Object) {
          boolean bool;
          if (set1.contains(param1Object) && set2.contains(param1Object)) {
            bool = true;
          } else {
            bool = false;
          } 
          return bool;
        }
        
        public boolean containsAll(Collection<?> param1Collection) {
          boolean bool;
          if (set1.containsAll(param1Collection) && set2.containsAll(param1Collection)) {
            bool = true;
          } else {
            bool = false;
          } 
          return bool;
        }
        
        public boolean isEmpty() {
          return iterator().hasNext() ^ true;
        }
        
        public UnmodifiableIterator<E> iterator() {
          return Iterators.filter(set1.iterator(), inSet2);
        }
        
        public int size() {
          return Iterators.size(iterator());
        }
      };
  }
  
  private static <E extends Enum<E>> EnumSet<E> makeComplementByHand(Collection<E> paramCollection, Class<E> paramClass) {
    EnumSet<E> enumSet = EnumSet.allOf(paramClass);
    enumSet.removeAll(paramCollection);
    return enumSet;
  }
  
  public static <E> Set<E> newConcurrentHashSet() {
    return Collections.newSetFromMap(new ConcurrentHashMap<E, Boolean>());
  }
  
  public static <E> Set<E> newConcurrentHashSet(Iterable<? extends E> paramIterable) {
    Set<?> set = newConcurrentHashSet();
    Iterables.addAll(set, paramIterable);
    return (Set)set;
  }
  
  @GwtIncompatible
  public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
    return new CopyOnWriteArraySet<E>();
  }
  
  @GwtIncompatible
  public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet(Iterable<? extends E> paramIterable) {
    if (paramIterable instanceof Collection) {
      paramIterable = Collections2.cast(paramIterable);
    } else {
      paramIterable = Lists.newArrayList(paramIterable);
    } 
    return new CopyOnWriteArraySet<E>((Collection<? extends E>)paramIterable);
  }
  
  public static <E extends Enum<E>> EnumSet<E> newEnumSet(Iterable<E> paramIterable, Class<E> paramClass) {
    EnumSet<E> enumSet = EnumSet.noneOf(paramClass);
    Iterables.addAll(enumSet, paramIterable);
    return enumSet;
  }
  
  public static <E> HashSet<E> newHashSet() {
    return new HashSet<E>();
  }
  
  public static <E> HashSet<E> newHashSet(Iterable<? extends E> paramIterable) {
    if (paramIterable instanceof Collection) {
      paramIterable = new HashSet<E>(Collections2.cast(paramIterable));
    } else {
      paramIterable = newHashSet(paramIterable.iterator());
    } 
    return (HashSet)paramIterable;
  }
  
  public static <E> HashSet<E> newHashSet(Iterator<? extends E> paramIterator) {
    HashSet<?> hashSet = newHashSet();
    Iterators.addAll(hashSet, paramIterator);
    return (HashSet)hashSet;
  }
  
  public static <E> HashSet<E> newHashSet(E... paramVarArgs) {
    HashSet<?> hashSet = newHashSetWithExpectedSize(paramVarArgs.length);
    Collections.addAll(hashSet, (Object[])paramVarArgs);
    return (HashSet)hashSet;
  }
  
  public static <E> HashSet<E> newHashSetWithExpectedSize(int paramInt) {
    return new HashSet<E>(Maps.capacity(paramInt));
  }
  
  public static <E> Set<E> newIdentityHashSet() {
    return Collections.newSetFromMap(Maps.newIdentityHashMap());
  }
  
  public static <E> LinkedHashSet<E> newLinkedHashSet() {
    return new LinkedHashSet<E>();
  }
  
  public static <E> LinkedHashSet<E> newLinkedHashSet(Iterable<? extends E> paramIterable) {
    if (paramIterable instanceof Collection)
      return new LinkedHashSet<E>(Collections2.cast(paramIterable)); 
    LinkedHashSet<?> linkedHashSet = newLinkedHashSet();
    Iterables.addAll(linkedHashSet, paramIterable);
    return (LinkedHashSet)linkedHashSet;
  }
  
  public static <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int paramInt) {
    return new LinkedHashSet<E>(Maps.capacity(paramInt));
  }
  
  @Deprecated
  public static <E> Set<E> newSetFromMap(Map<E, Boolean> paramMap) {
    return Collections.newSetFromMap(paramMap);
  }
  
  public static <E extends Comparable> TreeSet<E> newTreeSet() {
    return new TreeSet<E>();
  }
  
  public static <E extends Comparable> TreeSet<E> newTreeSet(Iterable<? extends E> paramIterable) {
    TreeSet<Comparable> treeSet = newTreeSet();
    Iterables.addAll(treeSet, paramIterable);
    return (TreeSet)treeSet;
  }
  
  public static <E> TreeSet<E> newTreeSet(Comparator<? super E> paramComparator) {
    return new TreeSet<E>((Comparator<? super E>)Preconditions.checkNotNull(paramComparator));
  }
  
  @GwtCompatible(serializable = false)
  public static <E> Set<Set<E>> powerSet(Set<E> paramSet) {
    return new PowerSet<E>(paramSet);
  }
  
  static boolean removeAllImpl(Set<?> paramSet, Collection<?> paramCollection) {
    Preconditions.checkNotNull(paramCollection);
    Collection<?> collection = paramCollection;
    if (paramCollection instanceof Multiset)
      collection = ((Multiset)paramCollection).elementSet(); 
    return (collection instanceof Set && collection.size() > paramSet.size()) ? Iterators.removeAll(paramSet.iterator(), collection) : removeAllImpl(paramSet, collection.iterator());
  }
  
  static boolean removeAllImpl(Set<?> paramSet, Iterator<?> paramIterator) {
    boolean bool;
    for (bool = false; paramIterator.hasNext(); bool |= paramSet.remove(paramIterator.next()));
    return bool;
  }
  
  @Beta
  @GwtIncompatible
  public static <K extends Comparable<? super K>> NavigableSet<K> subSet(NavigableSet<K> paramNavigableSet, Range<K> paramRange) {
    Comparator<? super K> comparator = paramNavigableSet.comparator();
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    if (comparator != null && paramNavigableSet.comparator() != Ordering.natural() && paramRange.hasLowerBound() && paramRange.hasUpperBound()) {
      boolean bool;
      if (paramNavigableSet.comparator().compare(paramRange.lowerEndpoint(), paramRange.upperEndpoint()) <= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "set is using a custom comparator which is inconsistent with the natural ordering.");
    } 
    if (paramRange.hasLowerBound() && paramRange.hasUpperBound()) {
      boolean bool;
      K k = paramRange.lowerEndpoint();
      if (paramRange.lowerBoundType() == BoundType.CLOSED) {
        bool = true;
      } else {
        bool = false;
      } 
      comparator = (Comparator<? super K>)paramRange.upperEndpoint();
      if (paramRange.upperBoundType() != BoundType.CLOSED)
        bool3 = false; 
      return paramNavigableSet.subSet(k, bool, (K)comparator, bool3);
    } 
    if (paramRange.hasLowerBound()) {
      boolean bool;
      comparator = (Comparator<? super K>)paramRange.lowerEndpoint();
      if (paramRange.lowerBoundType() == BoundType.CLOSED) {
        bool = bool1;
      } else {
        bool = false;
      } 
      return paramNavigableSet.tailSet((K)comparator, bool);
    } 
    if (paramRange.hasUpperBound()) {
      boolean bool;
      comparator = (Comparator<? super K>)paramRange.upperEndpoint();
      if (paramRange.upperBoundType() == BoundType.CLOSED) {
        bool = bool2;
      } else {
        bool = false;
      } 
      return paramNavigableSet.headSet((K)comparator, bool);
    } 
    return (NavigableSet<K>)Preconditions.checkNotNull(paramNavigableSet);
  }
  
  public static <E> SetView<E> symmetricDifference(final Set<? extends E> set1, final Set<? extends E> set2) {
    Preconditions.checkNotNull(set1, "set1");
    Preconditions.checkNotNull(set2, "set2");
    return new SetView<E>() {
        public boolean contains(Object param1Object) {
          boolean bool = set1.contains(param1Object);
          return set2.contains(param1Object) ^ bool;
        }
        
        public boolean isEmpty() {
          return set1.equals(set2);
        }
        
        public UnmodifiableIterator<E> iterator() {
          return new AbstractIterator() {
              public E computeNext() {
                while (itr1.hasNext()) {
                  E e = (E)itr1.next();
                  if (!set2.contains(e))
                    return e; 
                } 
                while (itr2.hasNext()) {
                  E e = (E)itr2.next();
                  if (!set1.contains(e))
                    return e; 
                } 
                return endOfData();
              }
            };
        }
        
        public int size() {
          return Iterators.size(iterator());
        }
      };
  }
  
  @GwtIncompatible
  public static <E> NavigableSet<E> synchronizedNavigableSet(NavigableSet<E> paramNavigableSet) {
    return Synchronized.navigableSet(paramNavigableSet);
  }
  
  public static <E> SetView<E> union(final Set<? extends E> set1, final Set<? extends E> set2) {
    Preconditions.checkNotNull(set1, "set1");
    Preconditions.checkNotNull(set2, "set2");
    return new SetView<E>() {
        public boolean contains(Object param1Object) {
          return (set1.contains(param1Object) || set2.contains(param1Object));
        }
        
        public <S extends Set<E>> S copyInto(S param1S) {
          param1S.addAll(set1);
          param1S.addAll(set2);
          return param1S;
        }
        
        public ImmutableSet<E> immutableCopy() {
          return (new ImmutableSet.Builder<E>()).addAll(set1).addAll(set2).build();
        }
        
        public boolean isEmpty() {
          boolean bool;
          if (set1.isEmpty() && set2.isEmpty()) {
            bool = true;
          } else {
            bool = false;
          } 
          return bool;
        }
        
        public UnmodifiableIterator<E> iterator() {
          return Iterators.unmodifiableIterator(Iterators.concat(set1.iterator(), set2minus1.iterator()));
        }
        
        public int size() {
          return IntMath.saturatedAdd(set1.size(), set2minus1.size());
        }
      };
  }
  
  @GwtIncompatible
  public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> paramNavigableSet) {
    return (paramNavigableSet instanceof ImmutableSortedSet || paramNavigableSet instanceof UnmodifiableNavigableSet) ? paramNavigableSet : new UnmodifiableNavigableSet<E>(paramNavigableSet);
  }
  
  private static final class CartesianSet<E> extends ForwardingCollection<List<E>> implements Set<List<E>> {
    private final transient ImmutableList<ImmutableSet<E>> axes;
    
    private final transient CartesianList<E> delegate;
    
    private CartesianSet(ImmutableList<ImmutableSet<E>> param1ImmutableList, CartesianList<E> param1CartesianList) {
      this.axes = param1ImmutableList;
      this.delegate = param1CartesianList;
    }
    
    static <E> Set<List<E>> create(List<? extends Set<? extends E>> param1List) {
      ImmutableList.Builder<ImmutableSet<?>> builder = new ImmutableList.Builder(param1List.size());
      Iterator<? extends Set<? extends E>> iterator = param1List.iterator();
      while (iterator.hasNext()) {
        ImmutableSet<?> immutableSet = ImmutableSet.copyOf(iterator.next());
        if (immutableSet.isEmpty())
          return ImmutableSet.of(); 
        builder.add(immutableSet);
      } 
      final ImmutableList<ImmutableSet<?>> axes = builder.build();
      return new CartesianSet<E>((ImmutableList)immutableList, new CartesianList<E>((ImmutableList)new ImmutableList<List<List<E>>>() {
              public List<E> get(int param2Int) {
                return ((ImmutableSet<E>)axes.get(param2Int)).asList();
              }
              
              boolean isPartialView() {
                return true;
              }
              
              public int size() {
                return axes.size();
              }
            }));
    }
    
    protected Collection<List<E>> delegate() {
      return this.delegate;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof CartesianSet) {
        param1Object = param1Object;
        return this.axes.equals(((CartesianSet)param1Object).axes);
      } 
      return super.equals(param1Object);
    }
    
    public int hashCode() {
      int i = size();
      byte b = 1;
      i--;
      int j;
      for (j = 0; j < this.axes.size(); j++)
        i = i * 31 ^ 0xFFFFFFFF ^ 0xFFFFFFFF; 
      Iterator<Set> iterator = this.axes.iterator();
      for (j = b; iterator.hasNext(); j = j * 31 + size() / set.size() * set.hashCode() ^ 0xFFFFFFFF ^ 0xFFFFFFFF)
        Set set = iterator.next(); 
      return j + i ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
    }
  }
  
  static final class null extends ImmutableList<List<E>> {
    public List<E> get(int param1Int) {
      return ((ImmutableSet<E>)axes.get(param1Int)).asList();
    }
    
    boolean isPartialView() {
      return true;
    }
    
    public int size() {
      return axes.size();
    }
  }
  
  @GwtIncompatible
  static class DescendingSet<E> extends ForwardingNavigableSet<E> {
    private final NavigableSet<E> forward;
    
    DescendingSet(NavigableSet<E> param1NavigableSet) {
      this.forward = param1NavigableSet;
    }
    
    private static <T> Ordering<T> reverse(Comparator<T> param1Comparator) {
      return Ordering.<T>from(param1Comparator).reverse();
    }
    
    public E ceiling(E param1E) {
      return this.forward.floor(param1E);
    }
    
    public Comparator<? super E> comparator() {
      Comparator<? super E> comparator = this.forward.comparator();
      return (comparator == null) ? Ordering.<Comparable>natural().reverse() : reverse(comparator);
    }
    
    protected NavigableSet<E> delegate() {
      return this.forward;
    }
    
    public Iterator<E> descendingIterator() {
      return this.forward.iterator();
    }
    
    public NavigableSet<E> descendingSet() {
      return this.forward;
    }
    
    public E first() {
      return this.forward.last();
    }
    
    public E floor(E param1E) {
      return this.forward.ceiling(param1E);
    }
    
    public NavigableSet<E> headSet(E param1E, boolean param1Boolean) {
      return this.forward.tailSet(param1E, param1Boolean).descendingSet();
    }
    
    public SortedSet<E> headSet(E param1E) {
      return standardHeadSet(param1E);
    }
    
    public E higher(E param1E) {
      return this.forward.lower(param1E);
    }
    
    public Iterator<E> iterator() {
      return this.forward.descendingIterator();
    }
    
    public E last() {
      return this.forward.first();
    }
    
    public E lower(E param1E) {
      return this.forward.higher(param1E);
    }
    
    public E pollFirst() {
      return this.forward.pollLast();
    }
    
    public E pollLast() {
      return this.forward.pollFirst();
    }
    
    public NavigableSet<E> subSet(E param1E1, boolean param1Boolean1, E param1E2, boolean param1Boolean2) {
      return this.forward.subSet(param1E2, param1Boolean2, param1E1, param1Boolean1).descendingSet();
    }
    
    public SortedSet<E> subSet(E param1E1, E param1E2) {
      return standardSubSet(param1E1, param1E2);
    }
    
    public NavigableSet<E> tailSet(E param1E, boolean param1Boolean) {
      return this.forward.headSet(param1E, param1Boolean).descendingSet();
    }
    
    public SortedSet<E> tailSet(E param1E) {
      return standardTailSet(param1E);
    }
    
    public Object[] toArray() {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])standardToArray((Object[])param1ArrayOfT);
    }
    
    public String toString() {
      return standardToString();
    }
  }
  
  @GwtIncompatible
  private static class FilteredNavigableSet<E> extends FilteredSortedSet<E> implements NavigableSet<E> {
    FilteredNavigableSet(NavigableSet<E> param1NavigableSet, Predicate<? super E> param1Predicate) {
      super(param1NavigableSet, param1Predicate);
    }
    
    public E ceiling(E param1E) {
      return Iterables.getFirst(tailSet(param1E, true), null);
    }
    
    public Iterator<E> descendingIterator() {
      return Iterators.filter(unfiltered().descendingIterator(), this.predicate);
    }
    
    public NavigableSet<E> descendingSet() {
      return Sets.filter(unfiltered().descendingSet(), this.predicate);
    }
    
    @Nullable
    public E floor(E param1E) {
      return Iterators.getNext(headSet(param1E, true).descendingIterator(), null);
    }
    
    public NavigableSet<E> headSet(E param1E, boolean param1Boolean) {
      return Sets.filter(unfiltered().headSet(param1E, param1Boolean), this.predicate);
    }
    
    public E higher(E param1E) {
      return Iterables.getFirst(tailSet(param1E, false), null);
    }
    
    public E last() {
      return descendingIterator().next();
    }
    
    @Nullable
    public E lower(E param1E) {
      return Iterators.getNext(headSet(param1E, false).descendingIterator(), null);
    }
    
    public E pollFirst() {
      return Iterables.removeFirstMatching(unfiltered(), this.predicate);
    }
    
    public E pollLast() {
      return Iterables.removeFirstMatching(unfiltered().descendingSet(), this.predicate);
    }
    
    public NavigableSet<E> subSet(E param1E1, boolean param1Boolean1, E param1E2, boolean param1Boolean2) {
      return Sets.filter(unfiltered().subSet(param1E1, param1Boolean1, param1E2, param1Boolean2), this.predicate);
    }
    
    public NavigableSet<E> tailSet(E param1E, boolean param1Boolean) {
      return Sets.filter(unfiltered().tailSet(param1E, param1Boolean), this.predicate);
    }
    
    NavigableSet<E> unfiltered() {
      return (NavigableSet<E>)this.unfiltered;
    }
  }
  
  private static class FilteredSet<E> extends Collections2.FilteredCollection<E> implements Set<E> {
    FilteredSet(Set<E> param1Set, Predicate<? super E> param1Predicate) {
      super(param1Set, param1Predicate);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      return Sets.equalsImpl(this, param1Object);
    }
    
    public int hashCode() {
      return Sets.hashCodeImpl(this);
    }
  }
  
  private static class FilteredSortedSet<E> extends FilteredSet<E> implements SortedSet<E> {
    FilteredSortedSet(SortedSet<E> param1SortedSet, Predicate<? super E> param1Predicate) {
      super(param1SortedSet, param1Predicate);
    }
    
    public Comparator<? super E> comparator() {
      return ((SortedSet<E>)this.unfiltered).comparator();
    }
    
    public E first() {
      return iterator().next();
    }
    
    public SortedSet<E> headSet(E param1E) {
      return new FilteredSortedSet(((SortedSet<E>)this.unfiltered).headSet(param1E), this.predicate);
    }
    
    public E last() {
      for (SortedSet<Object> sortedSet = (SortedSet)this.unfiltered;; sortedSet = sortedSet.headSet((Object)e)) {
        E e = (E)sortedSet.last();
        if (this.predicate.apply(e))
          return e; 
      } 
    }
    
    public SortedSet<E> subSet(E param1E1, E param1E2) {
      return new FilteredSortedSet(((SortedSet<E>)this.unfiltered).subSet(param1E1, param1E2), this.predicate);
    }
    
    public SortedSet<E> tailSet(E param1E) {
      return new FilteredSortedSet(((SortedSet<E>)this.unfiltered).tailSet(param1E), this.predicate);
    }
  }
  
  static abstract class ImprovedAbstractSet<E> extends AbstractSet<E> {
    public boolean removeAll(Collection<?> param1Collection) {
      return Sets.removeAllImpl(this, param1Collection);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return super.retainAll((Collection)Preconditions.checkNotNull(param1Collection));
    }
  }
  
  private static final class PowerSet<E> extends AbstractSet<Set<E>> {
    final ImmutableMap<E, Integer> inputSet;
    
    PowerSet(Set<E> param1Set) {
      boolean bool;
      this.inputSet = Maps.indexMap(param1Set);
      if (this.inputSet.size() <= 30) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "Too many elements to create power set: %s > 30", this.inputSet.size());
    }
    
    public boolean contains(@Nullable Object param1Object) {
      if (param1Object instanceof Set) {
        param1Object = param1Object;
        return this.inputSet.keySet().containsAll((Collection<?>)param1Object);
      } 
      return false;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof PowerSet) {
        param1Object = param1Object;
        return this.inputSet.equals(((PowerSet)param1Object).inputSet);
      } 
      return super.equals(param1Object);
    }
    
    public int hashCode() {
      return this.inputSet.keySet().hashCode() << this.inputSet.size() - 1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public Iterator<Set<E>> iterator() {
      return (Iterator)new AbstractIndexedListIterator<Set<Set<E>>>(size()) {
          protected Set<E> get(int param2Int) {
            return new Sets.SubSet<E>(Sets.PowerSet.this.inputSet, param2Int);
          }
        };
    }
    
    public int size() {
      return 1 << this.inputSet.size();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("powerSet(");
      stringBuilder.append(this.inputSet);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  class null extends AbstractIndexedListIterator<Set<E>> {
    null(int param1Int) {
      super(param1Int);
    }
    
    protected Set<E> get(int param1Int) {
      return new Sets.SubSet<E>(this.this$0.inputSet, param1Int);
    }
  }
  
  public static abstract class SetView<E> extends AbstractSet<E> {
    private SetView() {}
    
    @CanIgnoreReturnValue
    public <S extends Set<E>> S copyInto(S param1S) {
      param1S.addAll(this);
      return param1S;
    }
    
    public ImmutableSet<E> immutableCopy() {
      return ImmutableSet.copyOf(this);
    }
    
    public abstract UnmodifiableIterator<E> iterator();
  }
  
  private static final class SubSet<E> extends AbstractSet<E> {
    private final ImmutableMap<E, Integer> inputSet;
    
    private final int mask;
    
    SubSet(ImmutableMap<E, Integer> param1ImmutableMap, int param1Int) {
      this.inputSet = param1ImmutableMap;
      this.mask = param1Int;
    }
    
    public boolean contains(@Nullable Object param1Object) {
      param1Object = this.inputSet.get(param1Object);
      null = true;
      if (param1Object != null) {
        int i = this.mask;
        if ((1 << param1Object.intValue() & i) != 0)
          return null; 
      } 
      return false;
    }
    
    public Iterator<E> iterator() {
      return new UnmodifiableIterator<E>() {
          final ImmutableList<E> elements = Sets.SubSet.this.inputSet.keySet().asList();
          
          int remainingSetBits = Sets.SubSet.this.mask;
          
          public boolean hasNext() {
            boolean bool;
            if (this.remainingSetBits != 0) {
              bool = true;
            } else {
              bool = false;
            } 
            return bool;
          }
          
          public E next() {
            int i = Integer.numberOfTrailingZeros(this.remainingSetBits);
            if (i != 32) {
              this.remainingSetBits &= 1 << i ^ 0xFFFFFFFF;
              return this.elements.get(i);
            } 
            throw new NoSuchElementException();
          }
        };
    }
    
    public int size() {
      return Integer.bitCount(this.mask);
    }
  }
  
  class null extends UnmodifiableIterator<E> {
    final ImmutableList<E> elements = this.this$0.inputSet.keySet().asList();
    
    int remainingSetBits = this.this$0.mask;
    
    public boolean hasNext() {
      boolean bool;
      if (this.remainingSetBits != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public E next() {
      int i = Integer.numberOfTrailingZeros(this.remainingSetBits);
      if (i != 32) {
        this.remainingSetBits &= 1 << i ^ 0xFFFFFFFF;
        return this.elements.get(i);
      } 
      throw new NoSuchElementException();
    }
  }
  
  @GwtIncompatible
  static final class UnmodifiableNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E>, Serializable {
    private static final long serialVersionUID = 0L;
    
    private final NavigableSet<E> delegate;
    
    private transient UnmodifiableNavigableSet<E> descendingSet;
    
    UnmodifiableNavigableSet(NavigableSet<E> param1NavigableSet) {
      this.delegate = (NavigableSet<E>)Preconditions.checkNotNull(param1NavigableSet);
    }
    
    public E ceiling(E param1E) {
      return this.delegate.ceiling(param1E);
    }
    
    protected SortedSet<E> delegate() {
      return Collections.unmodifiableSortedSet(this.delegate);
    }
    
    public Iterator<E> descendingIterator() {
      return Iterators.unmodifiableIterator(this.delegate.descendingIterator());
    }
    
    public NavigableSet<E> descendingSet() {
      UnmodifiableNavigableSet<E> unmodifiableNavigableSet1 = this.descendingSet;
      UnmodifiableNavigableSet<E> unmodifiableNavigableSet2 = unmodifiableNavigableSet1;
      if (unmodifiableNavigableSet1 == null) {
        unmodifiableNavigableSet2 = new UnmodifiableNavigableSet(this.delegate.descendingSet());
        this.descendingSet = unmodifiableNavigableSet2;
        unmodifiableNavigableSet2.descendingSet = this;
      } 
      return unmodifiableNavigableSet2;
    }
    
    public E floor(E param1E) {
      return this.delegate.floor(param1E);
    }
    
    public NavigableSet<E> headSet(E param1E, boolean param1Boolean) {
      return Sets.unmodifiableNavigableSet(this.delegate.headSet(param1E, param1Boolean));
    }
    
    public E higher(E param1E) {
      return this.delegate.higher(param1E);
    }
    
    public E lower(E param1E) {
      return this.delegate.lower(param1E);
    }
    
    public E pollFirst() {
      throw new UnsupportedOperationException();
    }
    
    public E pollLast() {
      throw new UnsupportedOperationException();
    }
    
    public NavigableSet<E> subSet(E param1E1, boolean param1Boolean1, E param1E2, boolean param1Boolean2) {
      return Sets.unmodifiableNavigableSet(this.delegate.subSet(param1E1, param1Boolean1, param1E2, param1Boolean2));
    }
    
    public NavigableSet<E> tailSet(E param1E, boolean param1Boolean) {
      return Sets.unmodifiableNavigableSet(this.delegate.tailSet(param1E, param1Boolean));
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Sets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */