package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class Ordering<T> implements Comparator<T> {
  static final int LEFT_IS_GREATER = 1;
  
  static final int RIGHT_IS_GREATER = -1;
  
  @GwtCompatible(serializable = true)
  public static Ordering<Object> allEqual() {
    return AllEqualOrdering.INSTANCE;
  }
  
  public static Ordering<Object> arbitrary() {
    return ArbitraryOrderingHolder.ARBITRARY_ORDERING;
  }
  
  @GwtCompatible(serializable = true)
  public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> paramIterable) {
    return new CompoundOrdering<T>(paramIterable);
  }
  
  @GwtCompatible(serializable = true)
  public static <T> Ordering<T> explicit(T paramT, T... paramVarArgs) {
    return explicit(Lists.asList(paramT, paramVarArgs));
  }
  
  @GwtCompatible(serializable = true)
  public static <T> Ordering<T> explicit(List<T> paramList) {
    return new ExplicitOrdering<T>(paramList);
  }
  
  @Deprecated
  @GwtCompatible(serializable = true)
  public static <T> Ordering<T> from(Ordering<T> paramOrdering) {
    return (Ordering<T>)Preconditions.checkNotNull(paramOrdering);
  }
  
  @GwtCompatible(serializable = true)
  public static <T> Ordering<T> from(Comparator<T> paramComparator) {
    if (paramComparator instanceof Ordering) {
      paramComparator = paramComparator;
    } else {
      paramComparator = new ComparatorOrdering<T>(paramComparator);
    } 
    return (Ordering<T>)paramComparator;
  }
  
  @GwtCompatible(serializable = true)
  public static <C extends Comparable> Ordering<C> natural() {
    return NaturalOrdering.INSTANCE;
  }
  
  @GwtCompatible(serializable = true)
  public static Ordering<Object> usingToString() {
    return UsingToStringOrdering.INSTANCE;
  }
  
  @Deprecated
  public int binarySearch(List<? extends T> paramList, @Nullable T paramT) {
    return Collections.binarySearch(paramList, paramT, this);
  }
  
  @CanIgnoreReturnValue
  public abstract int compare(@Nullable T paramT1, @Nullable T paramT2);
  
  @GwtCompatible(serializable = true)
  public <U extends T> Ordering<U> compound(Comparator<? super U> paramComparator) {
    return new CompoundOrdering<U>(this, (Comparator<? super U>)Preconditions.checkNotNull(paramComparator));
  }
  
  public <E extends T> List<E> greatestOf(Iterable<E> paramIterable, int paramInt) {
    return reverse().leastOf(paramIterable, paramInt);
  }
  
  public <E extends T> List<E> greatestOf(Iterator<E> paramIterator, int paramInt) {
    return reverse().leastOf(paramIterator, paramInt);
  }
  
  @CanIgnoreReturnValue
  public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> paramIterable) {
    Object[] arrayOfObject = Iterables.toArray(paramIterable);
    int i = arrayOfObject.length;
    for (byte b = 0; b < i; b++)
      Preconditions.checkNotNull(arrayOfObject[b]); 
    Arrays.sort(arrayOfObject, this);
    return ImmutableList.asImmutableList(arrayOfObject);
  }
  
  public boolean isOrdered(Iterable<? extends T> paramIterable) {
    Iterator<? extends T> iterator = paramIterable.iterator();
    if (iterator.hasNext()) {
      paramIterable = (Iterable<? extends T>)iterator.next();
      while (iterator.hasNext()) {
        T t2 = iterator.next();
        if (compare((T)paramIterable, t2) > 0)
          return false; 
        T t1 = t2;
      } 
    } 
    return true;
  }
  
  public boolean isStrictlyOrdered(Iterable<? extends T> paramIterable) {
    Iterator<? extends T> iterator = paramIterable.iterator();
    if (iterator.hasNext()) {
      paramIterable = (Iterable<? extends T>)iterator.next();
      while (iterator.hasNext()) {
        T t2 = iterator.next();
        if (compare((T)paramIterable, t2) >= 0)
          return false; 
        T t1 = t2;
      } 
    } 
    return true;
  }
  
  public <E extends T> List<E> leastOf(Iterable<E> paramIterable, int paramInt) {
    Object[] arrayOfObject;
    if (paramIterable instanceof Collection) {
      Collection collection = (Collection)paramIterable;
      if (collection.size() <= paramInt * 2L) {
        Object[] arrayOfObject1 = collection.toArray();
        Arrays.sort(arrayOfObject1, this);
        arrayOfObject = arrayOfObject1;
        if (arrayOfObject1.length > paramInt)
          arrayOfObject = ObjectArrays.arraysCopyOf(arrayOfObject1, paramInt); 
        return Collections.unmodifiableList(Arrays.asList((E[])arrayOfObject));
      } 
    } 
    return leastOf(arrayOfObject.iterator(), paramInt);
  }
  
  public <E extends T> List<E> leastOf(Iterator<E> paramIterator, int paramInt) {
    ArrayList<E> arrayList;
    Preconditions.checkNotNull(paramIterator);
    CollectPreconditions.checkNonnegative(paramInt, "k");
    if (paramInt == 0 || !paramIterator.hasNext())
      return ImmutableList.of(); 
    if (paramInt >= 1073741823) {
      arrayList = Lists.newArrayList(paramIterator);
      Collections.sort(arrayList, this);
      if (arrayList.size() > paramInt)
        arrayList.subList(paramInt, arrayList.size()).clear(); 
      arrayList.trimToSize();
      return Collections.unmodifiableList(arrayList);
    } 
    TopKSelector<?> topKSelector = TopKSelector.least(paramInt, this);
    topKSelector.offerAll((Iterator<?>)arrayList);
    return (List)topKSelector.topK();
  }
  
  @GwtCompatible(serializable = true)
  public <S extends T> Ordering<Iterable<S>> lexicographical() {
    return new LexicographicalOrdering<S>(this);
  }
  
  @CanIgnoreReturnValue
  public <E extends T> E max(Iterable<E> paramIterable) {
    return max(paramIterable.iterator());
  }
  
  @CanIgnoreReturnValue
  public <E extends T> E max(@Nullable E paramE1, @Nullable E paramE2) {
    if (compare((T)paramE1, (T)paramE2) < 0)
      paramE1 = paramE2; 
    return paramE1;
  }
  
  @CanIgnoreReturnValue
  public <E extends T> E max(@Nullable E paramE1, @Nullable E paramE2, @Nullable E paramE3, E... paramVarArgs) {
    paramE1 = max(max(paramE1, paramE2), paramE3);
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      paramE1 = max(paramE1, paramVarArgs[b]); 
    return paramE1;
  }
  
  @CanIgnoreReturnValue
  public <E extends T> E max(Iterator<E> paramIterator) {
    E e;
    for (e = paramIterator.next(); paramIterator.hasNext(); e = max(e, paramIterator.next()));
    return e;
  }
  
  @CanIgnoreReturnValue
  public <E extends T> E min(Iterable<E> paramIterable) {
    return min(paramIterable.iterator());
  }
  
  @CanIgnoreReturnValue
  public <E extends T> E min(@Nullable E paramE1, @Nullable E paramE2) {
    if (compare((T)paramE1, (T)paramE2) > 0)
      paramE1 = paramE2; 
    return paramE1;
  }
  
  @CanIgnoreReturnValue
  public <E extends T> E min(@Nullable E paramE1, @Nullable E paramE2, @Nullable E paramE3, E... paramVarArgs) {
    paramE1 = min(min(paramE1, paramE2), paramE3);
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      paramE1 = min(paramE1, paramVarArgs[b]); 
    return paramE1;
  }
  
  @CanIgnoreReturnValue
  public <E extends T> E min(Iterator<E> paramIterator) {
    E e;
    for (e = paramIterator.next(); paramIterator.hasNext(); e = min(e, paramIterator.next()));
    return e;
  }
  
  @GwtCompatible(serializable = true)
  public <S extends T> Ordering<S> nullsFirst() {
    return new NullsFirstOrdering<S>(this);
  }
  
  @GwtCompatible(serializable = true)
  public <S extends T> Ordering<S> nullsLast() {
    return new NullsLastOrdering<S>(this);
  }
  
  <T2 extends T> Ordering<Map.Entry<T2, ?>> onKeys() {
    return onResultOf(Maps.keyFunction());
  }
  
  @GwtCompatible(serializable = true)
  public <F> Ordering<F> onResultOf(Function<F, ? extends T> paramFunction) {
    return new ByFunctionOrdering<F, T>(paramFunction, this);
  }
  
  @GwtCompatible(serializable = true)
  public <S extends T> Ordering<S> reverse() {
    return new ReverseOrdering<S>(this);
  }
  
  @CanIgnoreReturnValue
  public <E extends T> List<E> sortedCopy(Iterable<E> paramIterable) {
    Object[] arrayOfObject = Iterables.toArray(paramIterable);
    Arrays.sort(arrayOfObject, this);
    return Lists.newArrayList(Arrays.asList((E[])arrayOfObject));
  }
  
  @VisibleForTesting
  static class ArbitraryOrdering extends Ordering<Object> {
    private final AtomicInteger counter = new AtomicInteger(0);
    
    private final ConcurrentMap<Object, Integer> uids = Platform.tryWeakKeys(new MapMaker()).makeMap();
    
    private Integer getUid(Object param1Object) {
      Integer integer = this.uids.get(param1Object);
      Object object = integer;
      if (integer == null) {
        object = Integer.valueOf(this.counter.getAndIncrement());
        param1Object = this.uids.putIfAbsent(param1Object, (Integer)object);
        if (param1Object != null)
          object = param1Object; 
      } 
      return (Integer)object;
    }
    
    public int compare(Object param1Object1, Object param1Object2) {
      if (param1Object1 == param1Object2)
        return 0; 
      int i = -1;
      if (param1Object1 == null)
        return -1; 
      if (param1Object2 == null)
        return 1; 
      int j = identityHashCode(param1Object1);
      int k = identityHashCode(param1Object2);
      if (j != k) {
        if (j >= k)
          i = 1; 
        return i;
      } 
      i = getUid(param1Object1).compareTo(getUid(param1Object2));
      if (i != 0)
        return i; 
      throw new AssertionError();
    }
    
    int identityHashCode(Object param1Object) {
      return System.identityHashCode(param1Object);
    }
    
    public String toString() {
      return "Ordering.arbitrary()";
    }
  }
  
  private static class ArbitraryOrderingHolder {
    static final Ordering<Object> ARBITRARY_ORDERING = new Ordering.ArbitraryOrdering();
  }
  
  @VisibleForTesting
  static class IncomparableValueException extends ClassCastException {
    private static final long serialVersionUID = 0L;
    
    final Object value;
    
    IncomparableValueException(Object param1Object) {
      super(stringBuilder.toString());
      this.value = param1Object;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Ordering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */