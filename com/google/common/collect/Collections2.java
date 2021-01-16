package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
public final class Collections2 {
  static final Joiner STANDARD_JOINER = Joiner.on(", ").useForNull("null");
  
  static <T> Collection<T> cast(Iterable<T> paramIterable) {
    return (Collection<T>)paramIterable;
  }
  
  static boolean containsAllImpl(Collection<?> paramCollection1, Collection<?> paramCollection2) {
    return Iterables.all(paramCollection2, Predicates.in(paramCollection1));
  }
  
  public static <E> Collection<E> filter(Collection<E> paramCollection, Predicate<? super E> paramPredicate) {
    return (paramCollection instanceof FilteredCollection) ? ((FilteredCollection<E>)paramCollection).createCombined(paramPredicate) : new FilteredCollection<E>((Collection<E>)Preconditions.checkNotNull(paramCollection), (Predicate<? super E>)Preconditions.checkNotNull(paramPredicate));
  }
  
  private static boolean isPermutation(List<?> paramList1, List<?> paramList2) {
    return (paramList1.size() != paramList2.size()) ? false : HashMultiset.create(paramList1).equals(HashMultiset.create(paramList2));
  }
  
  private static boolean isPositiveInt(long paramLong) {
    boolean bool;
    if (paramLong >= 0L && paramLong <= 2147483647L) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  static StringBuilder newStringBuilderForCollection(int paramInt) {
    CollectPreconditions.checkNonnegative(paramInt, "size");
    return new StringBuilder((int)Math.min(paramInt * 8L, 1073741824L));
  }
  
  @Beta
  public static <E extends Comparable<? super E>> Collection<List<E>> orderedPermutations(Iterable<E> paramIterable) {
    return orderedPermutations(paramIterable, Ordering.natural());
  }
  
  @Beta
  public static <E> Collection<List<E>> orderedPermutations(Iterable<E> paramIterable, Comparator<? super E> paramComparator) {
    return new OrderedPermutationCollection<E>(paramIterable, paramComparator);
  }
  
  @Beta
  public static <E> Collection<List<E>> permutations(Collection<E> paramCollection) {
    return new PermutationCollection<E>(ImmutableList.copyOf(paramCollection));
  }
  
  static boolean safeContains(Collection<?> paramCollection, @Nullable Object paramObject) {
    Preconditions.checkNotNull(paramCollection);
    try {
      return paramCollection.contains(paramObject);
    } catch (ClassCastException classCastException) {
      return false;
    } catch (NullPointerException nullPointerException) {
      return false;
    } 
  }
  
  static boolean safeRemove(Collection<?> paramCollection, @Nullable Object paramObject) {
    Preconditions.checkNotNull(paramCollection);
    try {
      return paramCollection.remove(paramObject);
    } catch (ClassCastException classCastException) {
      return false;
    } catch (NullPointerException nullPointerException) {
      return false;
    } 
  }
  
  static String toStringImpl(final Collection<?> collection) {
    StringBuilder stringBuilder = newStringBuilderForCollection(collection.size());
    stringBuilder.append('[');
    STANDARD_JOINER.appendTo(stringBuilder, Iterables.transform(collection, new Function<Object, Object>() {
            public Object apply(Object param1Object) {
              Object object = param1Object;
              if (param1Object == collection)
                object = "(this Collection)"; 
              return object;
            }
          }));
    stringBuilder.append(']');
    return stringBuilder.toString();
  }
  
  public static <F, T> Collection<T> transform(Collection<F> paramCollection, Function<? super F, T> paramFunction) {
    return new TransformedCollection<F, T>(paramCollection, paramFunction);
  }
  
  static class FilteredCollection<E> extends AbstractCollection<E> {
    final Predicate<? super E> predicate;
    
    final Collection<E> unfiltered;
    
    FilteredCollection(Collection<E> param1Collection, Predicate<? super E> param1Predicate) {
      this.unfiltered = param1Collection;
      this.predicate = param1Predicate;
    }
    
    public boolean add(E param1E) {
      Preconditions.checkArgument(this.predicate.apply(param1E));
      return this.unfiltered.add(param1E);
    }
    
    public boolean addAll(Collection<? extends E> param1Collection) {
      // Byte code:
      //   0: aload_1
      //   1: invokeinterface iterator : ()Ljava/util/Iterator;
      //   6: astore_2
      //   7: aload_2
      //   8: invokeinterface hasNext : ()Z
      //   13: ifeq -> 39
      //   16: aload_2
      //   17: invokeinterface next : ()Ljava/lang/Object;
      //   22: astore_3
      //   23: aload_0
      //   24: getfield predicate : Lcom/google/common/base/Predicate;
      //   27: aload_3
      //   28: invokeinterface apply : (Ljava/lang/Object;)Z
      //   33: invokestatic checkArgument : (Z)V
      //   36: goto -> 7
      //   39: aload_0
      //   40: getfield unfiltered : Ljava/util/Collection;
      //   43: aload_1
      //   44: invokeinterface addAll : (Ljava/util/Collection;)Z
      //   49: ireturn
    }
    
    public void clear() {
      Iterables.removeIf(this.unfiltered, this.predicate);
    }
    
    public boolean contains(@Nullable Object param1Object) {
      return Collections2.safeContains(this.unfiltered, param1Object) ? this.predicate.apply(param1Object) : false;
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      return Collections2.containsAllImpl(this, param1Collection);
    }
    
    FilteredCollection<E> createCombined(Predicate<? super E> param1Predicate) {
      return new FilteredCollection(this.unfiltered, Predicates.and(this.predicate, param1Predicate));
    }
    
    public boolean isEmpty() {
      return Iterables.<E>any(this.unfiltered, this.predicate) ^ true;
    }
    
    public Iterator<E> iterator() {
      return Iterators.filter(this.unfiltered.iterator(), this.predicate);
    }
    
    public boolean remove(Object param1Object) {
      boolean bool;
      if (contains(param1Object) && this.unfiltered.remove(param1Object)) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return Iterables.removeIf(this.unfiltered, Predicates.and(this.predicate, Predicates.in(param1Collection)));
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return Iterables.removeIf(this.unfiltered, Predicates.and(this.predicate, Predicates.not(Predicates.in(param1Collection))));
    }
    
    public int size() {
      return Iterators.size(iterator());
    }
    
    public Object[] toArray() {
      return Lists.<E>newArrayList(iterator()).toArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])Lists.<E>newArrayList(iterator()).toArray((Object[])param1ArrayOfT);
    }
  }
  
  private static final class OrderedPermutationCollection<E> extends AbstractCollection<List<E>> {
    final Comparator<? super E> comparator;
    
    final ImmutableList<E> inputList;
    
    final int size;
    
    OrderedPermutationCollection(Iterable<E> param1Iterable, Comparator<? super E> param1Comparator) {
      this.inputList = Ordering.<E>from(param1Comparator).immutableSortedCopy(param1Iterable);
      this.comparator = param1Comparator;
      this.size = calculateSize(this.inputList, param1Comparator);
    }
    
    private static <E> int calculateSize(List<E> param1List, Comparator<? super E> param1Comparator) {
      long l1 = 1L;
      byte b = 1;
      int i = 1;
      while (b < param1List.size()) {
        long l = l1;
        int j = i;
        if (param1Comparator.compare(param1List.get(b - 1), param1List.get(b)) < 0) {
          l1 *= LongMath.binomial(b, i);
          j = 0;
          l = l1;
          if (!Collections2.isPositiveInt(l1))
            return Integer.MAX_VALUE; 
        } 
        b++;
        i = j + 1;
        l1 = l;
      } 
      long l2 = l1 * LongMath.binomial(b, i);
      return !Collections2.isPositiveInt(l2) ? Integer.MAX_VALUE : (int)l2;
    }
    
    public boolean contains(@Nullable Object param1Object) {
      if (param1Object instanceof List) {
        param1Object = param1Object;
        return Collections2.isPermutation(this.inputList, (List<?>)param1Object);
      } 
      return false;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public Iterator<List<E>> iterator() {
      return new Collections2.OrderedPermutationIterator<E>(this.inputList, this.comparator);
    }
    
    public int size() {
      return this.size;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("orderedPermutationCollection(");
      stringBuilder.append(this.inputList);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static final class OrderedPermutationIterator<E> extends AbstractIterator<List<E>> {
    final Comparator<? super E> comparator;
    
    List<E> nextPermutation;
    
    OrderedPermutationIterator(List<E> param1List, Comparator<? super E> param1Comparator) {
      this.nextPermutation = Lists.newArrayList(param1List);
      this.comparator = param1Comparator;
    }
    
    void calculateNextPermutation() {
      int i = findNextJ();
      if (i == -1) {
        this.nextPermutation = null;
        return;
      } 
      int j = findNextL(i);
      Collections.swap(this.nextPermutation, i, j);
      j = this.nextPermutation.size();
      Collections.reverse(this.nextPermutation.subList(i + 1, j));
    }
    
    protected List<E> computeNext() {
      List<E> list = this.nextPermutation;
      if (list == null)
        return endOfData(); 
      list = ImmutableList.copyOf(list);
      calculateNextPermutation();
      return list;
    }
    
    int findNextJ() {
      for (int i = this.nextPermutation.size() - 2; i >= 0; i--) {
        if (this.comparator.compare(this.nextPermutation.get(i), this.nextPermutation.get(i + 1)) < 0)
          return i; 
      } 
      return -1;
    }
    
    int findNextL(int param1Int) {
      E e = this.nextPermutation.get(param1Int);
      for (int i = this.nextPermutation.size() - 1; i > param1Int; i--) {
        if (this.comparator.compare(e, this.nextPermutation.get(i)) < 0)
          return i; 
      } 
      throw new AssertionError("this statement should be unreachable");
    }
  }
  
  private static final class PermutationCollection<E> extends AbstractCollection<List<E>> {
    final ImmutableList<E> inputList;
    
    PermutationCollection(ImmutableList<E> param1ImmutableList) {
      this.inputList = param1ImmutableList;
    }
    
    public boolean contains(@Nullable Object param1Object) {
      if (param1Object instanceof List) {
        param1Object = param1Object;
        return Collections2.isPermutation(this.inputList, (List<?>)param1Object);
      } 
      return false;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public Iterator<List<E>> iterator() {
      return new Collections2.PermutationIterator<E>(this.inputList);
    }
    
    public int size() {
      return IntMath.factorial(this.inputList.size());
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("permutations(");
      stringBuilder.append(this.inputList);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static class PermutationIterator<E> extends AbstractIterator<List<E>> {
    final int[] c;
    
    int j;
    
    final List<E> list;
    
    final int[] o;
    
    PermutationIterator(List<E> param1List) {
      this.list = new ArrayList<E>(param1List);
      int i = param1List.size();
      this.c = new int[i];
      this.o = new int[i];
      Arrays.fill(this.c, 0);
      Arrays.fill(this.o, 1);
      this.j = Integer.MAX_VALUE;
    }
    
    void calculateNextPermutation() {
      this.j = this.list.size() - 1;
      if (this.j == -1)
        return; 
      byte b = 0;
      while (true) {
        int[] arrayOfInt = this.c;
        int i = this.j;
        int j = arrayOfInt[i] + this.o[i];
        if (j < 0) {
          switchDirection();
          continue;
        } 
        if (j == i + 1) {
          if (i == 0)
            break; 
          b++;
          switchDirection();
          continue;
        } 
        Collections.swap(this.list, i - arrayOfInt[i] + b, i - j + b);
        this.c[this.j] = j;
        break;
      } 
    }
    
    protected List<E> computeNext() {
      if (this.j <= 0)
        return endOfData(); 
      ImmutableList<E> immutableList = ImmutableList.copyOf(this.list);
      calculateNextPermutation();
      return immutableList;
    }
    
    void switchDirection() {
      int[] arrayOfInt = this.o;
      int i = this.j;
      arrayOfInt[i] = -arrayOfInt[i];
      this.j = i - 1;
    }
  }
  
  static class TransformedCollection<F, T> extends AbstractCollection<T> {
    final Collection<F> fromCollection;
    
    final Function<? super F, ? extends T> function;
    
    TransformedCollection(Collection<F> param1Collection, Function<? super F, ? extends T> param1Function) {
      this.fromCollection = (Collection<F>)Preconditions.checkNotNull(param1Collection);
      this.function = (Function<? super F, ? extends T>)Preconditions.checkNotNull(param1Function);
    }
    
    public void clear() {
      this.fromCollection.clear();
    }
    
    public boolean isEmpty() {
      return this.fromCollection.isEmpty();
    }
    
    public Iterator<T> iterator() {
      return Iterators.transform(this.fromCollection.iterator(), this.function);
    }
    
    public int size() {
      return this.fromCollection.size();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Collections2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */