package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Lists {
  static <E> boolean addAllImpl(List<E> paramList, int paramInt, Iterable<? extends E> paramIterable) {
    ListIterator<E> listIterator = paramList.listIterator(paramInt);
    Iterator<? extends E> iterator = paramIterable.iterator();
    boolean bool;
    for (bool = false; iterator.hasNext(); bool = true)
      listIterator.add(iterator.next()); 
    return bool;
  }
  
  public static <E> List<E> asList(@Nullable E paramE1, @Nullable E paramE2, E[] paramArrayOfE) {
    return new TwoPlusArrayList<E>(paramE1, paramE2, paramArrayOfE);
  }
  
  public static <E> List<E> asList(@Nullable E paramE, E[] paramArrayOfE) {
    return new OnePlusArrayList<E>(paramE, paramArrayOfE);
  }
  
  public static <B> List<List<B>> cartesianProduct(List<? extends List<? extends B>> paramList) {
    return CartesianList.create(paramList);
  }
  
  public static <B> List<List<B>> cartesianProduct(List<? extends B>... paramVarArgs) {
    return cartesianProduct(Arrays.asList(paramVarArgs));
  }
  
  static <T> List<T> cast(Iterable<T> paramIterable) {
    return (List<T>)paramIterable;
  }
  
  public static ImmutableList<Character> charactersOf(String paramString) {
    return new StringAsImmutableList((String)Preconditions.checkNotNull(paramString));
  }
  
  @Beta
  public static List<Character> charactersOf(CharSequence paramCharSequence) {
    return new CharSequenceAsList((CharSequence)Preconditions.checkNotNull(paramCharSequence));
  }
  
  @VisibleForTesting
  static int computeArrayListCapacity(int paramInt) {
    CollectPreconditions.checkNonnegative(paramInt, "arraySize");
    return Ints.saturatedCast(paramInt + 5L + (paramInt / 10));
  }
  
  static boolean equalsImpl(List<?> paramList, @Nullable Object paramObject) {
    if (paramObject == Preconditions.checkNotNull(paramList))
      return true; 
    if (!(paramObject instanceof List))
      return false; 
    paramObject = paramObject;
    int i = paramList.size();
    if (i != paramObject.size())
      return false; 
    if (paramList instanceof RandomAccess && paramObject instanceof RandomAccess) {
      for (byte b = 0; b < i; b++) {
        if (!Objects.equal(paramList.get(b), paramObject.get(b)))
          return false; 
      } 
      return true;
    } 
    return Iterators.elementsEqual(paramList.iterator(), paramObject.iterator());
  }
  
  static int hashCodeImpl(List<?> paramList) {
    Iterator<?> iterator = paramList.iterator();
    int i;
    for (i = 1; iterator.hasNext(); i = i * 31 + j ^ 0xFFFFFFFF ^ 0xFFFFFFFF) {
      int j;
      paramList = (List<?>)iterator.next();
      if (paramList == null) {
        j = 0;
      } else {
        j = paramList.hashCode();
      } 
    } 
    return i;
  }
  
  static int indexOfImpl(List<?> paramList, @Nullable Object paramObject) {
    if (paramList instanceof RandomAccess)
      return indexOfRandomAccess(paramList, paramObject); 
    ListIterator<?> listIterator = paramList.listIterator();
    while (listIterator.hasNext()) {
      if (Objects.equal(paramObject, listIterator.next()))
        return listIterator.previousIndex(); 
    } 
    return -1;
  }
  
  private static int indexOfRandomAccess(List<?> paramList, @Nullable Object paramObject) {
    int i = paramList.size();
    byte b1 = 0;
    byte b2 = 0;
    if (paramObject == null) {
      for (b1 = b2; b1 < i; b1++) {
        if (paramList.get(b1) == null)
          return b1; 
      } 
    } else {
      while (b1 < i) {
        if (paramObject.equals(paramList.get(b1)))
          return b1; 
        b1++;
      } 
    } 
    return -1;
  }
  
  static int lastIndexOfImpl(List<?> paramList, @Nullable Object paramObject) {
    if (paramList instanceof RandomAccess)
      return lastIndexOfRandomAccess(paramList, paramObject); 
    ListIterator<?> listIterator = paramList.listIterator(paramList.size());
    while (listIterator.hasPrevious()) {
      if (Objects.equal(paramObject, listIterator.previous()))
        return listIterator.nextIndex(); 
    } 
    return -1;
  }
  
  private static int lastIndexOfRandomAccess(List<?> paramList, @Nullable Object paramObject) {
    if (paramObject == null) {
      for (int i = paramList.size() - 1; i >= 0; i--) {
        if (paramList.get(i) == null)
          return i; 
      } 
    } else {
      for (int i = paramList.size() - 1; i >= 0; i--) {
        if (paramObject.equals(paramList.get(i)))
          return i; 
      } 
    } 
    return -1;
  }
  
  static <E> ListIterator<E> listIteratorImpl(List<E> paramList, int paramInt) {
    return (new AbstractListWrapper<E>(paramList)).listIterator(paramInt);
  }
  
  @GwtCompatible(serializable = true)
  public static <E> ArrayList<E> newArrayList() {
    return new ArrayList<E>();
  }
  
  @GwtCompatible(serializable = true)
  @CanIgnoreReturnValue
  public static <E> ArrayList<E> newArrayList(Iterable<? extends E> paramIterable) {
    Preconditions.checkNotNull(paramIterable);
    if (paramIterable instanceof Collection) {
      paramIterable = new ArrayList<E>(Collections2.cast(paramIterable));
    } else {
      paramIterable = newArrayList(paramIterable.iterator());
    } 
    return (ArrayList)paramIterable;
  }
  
  @GwtCompatible(serializable = true)
  @CanIgnoreReturnValue
  public static <E> ArrayList<E> newArrayList(Iterator<? extends E> paramIterator) {
    ArrayList<?> arrayList = newArrayList();
    Iterators.addAll(arrayList, paramIterator);
    return (ArrayList)arrayList;
  }
  
  @GwtCompatible(serializable = true)
  @CanIgnoreReturnValue
  public static <E> ArrayList<E> newArrayList(E... paramVarArgs) {
    Preconditions.checkNotNull(paramVarArgs);
    ArrayList<? super E> arrayList = new ArrayList(computeArrayListCapacity(paramVarArgs.length));
    Collections.addAll(arrayList, paramVarArgs);
    return (ArrayList)arrayList;
  }
  
  @GwtCompatible(serializable = true)
  public static <E> ArrayList<E> newArrayListWithCapacity(int paramInt) {
    CollectPreconditions.checkNonnegative(paramInt, "initialArraySize");
    return new ArrayList<E>(paramInt);
  }
  
  @GwtCompatible(serializable = true)
  public static <E> ArrayList<E> newArrayListWithExpectedSize(int paramInt) {
    return new ArrayList<E>(computeArrayListCapacity(paramInt));
  }
  
  @GwtIncompatible
  public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList() {
    return new CopyOnWriteArrayList<E>();
  }
  
  @GwtIncompatible
  public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(Iterable<? extends E> paramIterable) {
    if (paramIterable instanceof Collection) {
      paramIterable = Collections2.cast(paramIterable);
    } else {
      paramIterable = newArrayList(paramIterable);
    } 
    return new CopyOnWriteArrayList<E>((Collection<? extends E>)paramIterable);
  }
  
  @GwtCompatible(serializable = true)
  public static <E> LinkedList<E> newLinkedList() {
    return new LinkedList<E>();
  }
  
  @GwtCompatible(serializable = true)
  public static <E> LinkedList<E> newLinkedList(Iterable<? extends E> paramIterable) {
    LinkedList<?> linkedList = newLinkedList();
    Iterables.addAll(linkedList, paramIterable);
    return (LinkedList)linkedList;
  }
  
  public static <T> List<List<T>> partition(List<T> paramList, int paramInt) {
    boolean bool;
    Preconditions.checkNotNull(paramList);
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    if (paramList instanceof RandomAccess) {
      paramList = (List<T>)new RandomAccessPartition<T>(paramList, paramInt);
    } else {
      paramList = (List<T>)new Partition<T>(paramList, paramInt);
    } 
    return (List)paramList;
  }
  
  public static <T> List<T> reverse(List<T> paramList) {
    return (paramList instanceof ImmutableList) ? ((ImmutableList<T>)paramList).reverse() : ((paramList instanceof ReverseList) ? ((ReverseList<T>)paramList).getForwardList() : ((paramList instanceof RandomAccess) ? new RandomAccessReverseList<T>(paramList) : new ReverseList<T>(paramList)));
  }
  
  static <E> List<E> subListImpl(List<E> paramList, int paramInt1, int paramInt2) {
    if (paramList instanceof RandomAccess) {
      paramList = new RandomAccessListWrapper<E>(paramList) {
          private static final long serialVersionUID = 0L;
          
          public ListIterator<E> listIterator(int param1Int) {
            return this.backingList.listIterator(param1Int);
          }
        };
    } else {
      paramList = new AbstractListWrapper<E>(paramList) {
          private static final long serialVersionUID = 0L;
          
          public ListIterator<E> listIterator(int param1Int) {
            return this.backingList.listIterator(param1Int);
          }
        };
    } 
    return paramList.subList(paramInt1, paramInt2);
  }
  
  public static <F, T> List<T> transform(List<F> paramList, Function<? super F, ? extends T> paramFunction) {
    if (paramList instanceof RandomAccess) {
      paramList = new TransformingRandomAccessList<F, F>(paramList, paramFunction);
    } else {
      paramList = new TransformingSequentialList<F, F>(paramList, paramFunction);
    } 
    return paramList;
  }
  
  private static class AbstractListWrapper<E> extends AbstractList<E> {
    final List<E> backingList;
    
    AbstractListWrapper(List<E> param1List) {
      this.backingList = (List<E>)Preconditions.checkNotNull(param1List);
    }
    
    public void add(int param1Int, E param1E) {
      this.backingList.add(param1Int, param1E);
    }
    
    public boolean addAll(int param1Int, Collection<? extends E> param1Collection) {
      return this.backingList.addAll(param1Int, param1Collection);
    }
    
    public boolean contains(Object param1Object) {
      return this.backingList.contains(param1Object);
    }
    
    public E get(int param1Int) {
      return this.backingList.get(param1Int);
    }
    
    public E remove(int param1Int) {
      return this.backingList.remove(param1Int);
    }
    
    public E set(int param1Int, E param1E) {
      return this.backingList.set(param1Int, param1E);
    }
    
    public int size() {
      return this.backingList.size();
    }
  }
  
  private static final class CharSequenceAsList extends AbstractList<Character> {
    private final CharSequence sequence;
    
    CharSequenceAsList(CharSequence param1CharSequence) {
      this.sequence = param1CharSequence;
    }
    
    public Character get(int param1Int) {
      Preconditions.checkElementIndex(param1Int, size());
      return Character.valueOf(this.sequence.charAt(param1Int));
    }
    
    public int size() {
      return this.sequence.length();
    }
  }
  
  private static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
    private static final long serialVersionUID = 0L;
    
    final E first;
    
    final E[] rest;
    
    OnePlusArrayList(@Nullable E param1E, E[] param1ArrayOfE) {
      this.first = param1E;
      this.rest = (E[])Preconditions.checkNotNull(param1ArrayOfE);
    }
    
    public E get(int param1Int) {
      E e;
      Preconditions.checkElementIndex(param1Int, size());
      if (param1Int == 0) {
        e = this.first;
      } else {
        e = this.rest[param1Int - 1];
      } 
      return e;
    }
    
    public int size() {
      return IntMath.saturatedAdd(this.rest.length, 1);
    }
  }
  
  private static class Partition<T> extends AbstractList<List<T>> {
    final List<T> list;
    
    final int size;
    
    Partition(List<T> param1List, int param1Int) {
      this.list = param1List;
      this.size = param1Int;
    }
    
    public List<T> get(int param1Int) {
      Preconditions.checkElementIndex(param1Int, size());
      int i = this.size;
      param1Int *= i;
      i = Math.min(i + param1Int, this.list.size());
      return this.list.subList(param1Int, i);
    }
    
    public boolean isEmpty() {
      return this.list.isEmpty();
    }
    
    public int size() {
      return IntMath.divide(this.list.size(), this.size, RoundingMode.CEILING);
    }
  }
  
  private static class RandomAccessListWrapper<E> extends AbstractListWrapper<E> implements RandomAccess {
    RandomAccessListWrapper(List<E> param1List) {
      super(param1List);
    }
  }
  
  private static class RandomAccessPartition<T> extends Partition<T> implements RandomAccess {
    RandomAccessPartition(List<T> param1List, int param1Int) {
      super(param1List, param1Int);
    }
  }
  
  private static class RandomAccessReverseList<T> extends ReverseList<T> implements RandomAccess {
    RandomAccessReverseList(List<T> param1List) {
      super(param1List);
    }
  }
  
  private static class ReverseList<T> extends AbstractList<T> {
    private final List<T> forwardList;
    
    ReverseList(List<T> param1List) {
      this.forwardList = (List<T>)Preconditions.checkNotNull(param1List);
    }
    
    private int reverseIndex(int param1Int) {
      int i = size();
      Preconditions.checkElementIndex(param1Int, i);
      return i - 1 - param1Int;
    }
    
    private int reversePosition(int param1Int) {
      int i = size();
      Preconditions.checkPositionIndex(param1Int, i);
      return i - param1Int;
    }
    
    public void add(int param1Int, @Nullable T param1T) {
      this.forwardList.add(reversePosition(param1Int), param1T);
    }
    
    public void clear() {
      this.forwardList.clear();
    }
    
    public T get(int param1Int) {
      return this.forwardList.get(reverseIndex(param1Int));
    }
    
    List<T> getForwardList() {
      return this.forwardList;
    }
    
    public Iterator<T> iterator() {
      return listIterator();
    }
    
    public ListIterator<T> listIterator(int param1Int) {
      param1Int = reversePosition(param1Int);
      return new ListIterator<T>() {
          boolean canRemoveOrSet;
          
          public void add(T param2T) {
            forwardIterator.add(param2T);
            forwardIterator.previous();
            this.canRemoveOrSet = false;
          }
          
          public boolean hasNext() {
            return forwardIterator.hasPrevious();
          }
          
          public boolean hasPrevious() {
            return forwardIterator.hasNext();
          }
          
          public T next() {
            if (hasNext()) {
              this.canRemoveOrSet = true;
              return forwardIterator.previous();
            } 
            throw new NoSuchElementException();
          }
          
          public int nextIndex() {
            return Lists.ReverseList.this.reversePosition(forwardIterator.nextIndex());
          }
          
          public T previous() {
            if (hasPrevious()) {
              this.canRemoveOrSet = true;
              return forwardIterator.next();
            } 
            throw new NoSuchElementException();
          }
          
          public int previousIndex() {
            return nextIndex() - 1;
          }
          
          public void remove() {
            CollectPreconditions.checkRemove(this.canRemoveOrSet);
            forwardIterator.remove();
            this.canRemoveOrSet = false;
          }
          
          public void set(T param2T) {
            Preconditions.checkState(this.canRemoveOrSet);
            forwardIterator.set(param2T);
          }
        };
    }
    
    public T remove(int param1Int) {
      return this.forwardList.remove(reverseIndex(param1Int));
    }
    
    protected void removeRange(int param1Int1, int param1Int2) {
      subList(param1Int1, param1Int2).clear();
    }
    
    public T set(int param1Int, @Nullable T param1T) {
      return this.forwardList.set(reverseIndex(param1Int), param1T);
    }
    
    public int size() {
      return this.forwardList.size();
    }
    
    public List<T> subList(int param1Int1, int param1Int2) {
      Preconditions.checkPositionIndexes(param1Int1, param1Int2, size());
      return Lists.reverse(this.forwardList.subList(reversePosition(param1Int2), reversePosition(param1Int1)));
    }
  }
  
  class null implements ListIterator<T> {
    boolean canRemoveOrSet;
    
    public void add(T param1T) {
      forwardIterator.add(param1T);
      forwardIterator.previous();
      this.canRemoveOrSet = false;
    }
    
    public boolean hasNext() {
      return forwardIterator.hasPrevious();
    }
    
    public boolean hasPrevious() {
      return forwardIterator.hasNext();
    }
    
    public T next() {
      if (hasNext()) {
        this.canRemoveOrSet = true;
        return forwardIterator.previous();
      } 
      throw new NoSuchElementException();
    }
    
    public int nextIndex() {
      return this.this$0.reversePosition(forwardIterator.nextIndex());
    }
    
    public T previous() {
      if (hasPrevious()) {
        this.canRemoveOrSet = true;
        return forwardIterator.next();
      } 
      throw new NoSuchElementException();
    }
    
    public int previousIndex() {
      return nextIndex() - 1;
    }
    
    public void remove() {
      CollectPreconditions.checkRemove(this.canRemoveOrSet);
      forwardIterator.remove();
      this.canRemoveOrSet = false;
    }
    
    public void set(T param1T) {
      Preconditions.checkState(this.canRemoveOrSet);
      forwardIterator.set(param1T);
    }
  }
  
  private static final class StringAsImmutableList extends ImmutableList<Character> {
    private final String string;
    
    StringAsImmutableList(String param1String) {
      this.string = param1String;
    }
    
    public Character get(int param1Int) {
      Preconditions.checkElementIndex(param1Int, size());
      return Character.valueOf(this.string.charAt(param1Int));
    }
    
    public int indexOf(@Nullable Object param1Object) {
      byte b;
      if (param1Object instanceof Character) {
        b = this.string.indexOf(((Character)param1Object).charValue());
      } else {
        b = -1;
      } 
      return b;
    }
    
    boolean isPartialView() {
      return false;
    }
    
    public int lastIndexOf(@Nullable Object param1Object) {
      byte b;
      if (param1Object instanceof Character) {
        b = this.string.lastIndexOf(((Character)param1Object).charValue());
      } else {
        b = -1;
      } 
      return b;
    }
    
    public int size() {
      return this.string.length();
    }
    
    public ImmutableList<Character> subList(int param1Int1, int param1Int2) {
      Preconditions.checkPositionIndexes(param1Int1, param1Int2, size());
      return Lists.charactersOf(this.string.substring(param1Int1, param1Int2));
    }
  }
  
  private static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0L;
    
    final List<F> fromList;
    
    final Function<? super F, ? extends T> function;
    
    TransformingRandomAccessList(List<F> param1List, Function<? super F, ? extends T> param1Function) {
      this.fromList = (List<F>)Preconditions.checkNotNull(param1List);
      this.function = (Function<? super F, ? extends T>)Preconditions.checkNotNull(param1Function);
    }
    
    public void clear() {
      this.fromList.clear();
    }
    
    public T get(int param1Int) {
      return (T)this.function.apply(this.fromList.get(param1Int));
    }
    
    public boolean isEmpty() {
      return this.fromList.isEmpty();
    }
    
    public Iterator<T> iterator() {
      return listIterator();
    }
    
    public ListIterator<T> listIterator(int param1Int) {
      return new TransformedListIterator<F, T>(this.fromList.listIterator(param1Int)) {
          T transform(F param2F) {
            return (T)Lists.TransformingRandomAccessList.this.function.apply(param2F);
          }
        };
    }
    
    public T remove(int param1Int) {
      return (T)this.function.apply(this.fromList.remove(param1Int));
    }
    
    public int size() {
      return this.fromList.size();
    }
  }
  
  class null extends TransformedListIterator<F, T> {
    null(ListIterator<? extends F> param1ListIterator) {
      super(param1ListIterator);
    }
    
    T transform(F param1F) {
      return (T)this.this$0.function.apply(param1F);
    }
  }
  
  private static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final List<F> fromList;
    
    final Function<? super F, ? extends T> function;
    
    TransformingSequentialList(List<F> param1List, Function<? super F, ? extends T> param1Function) {
      this.fromList = (List<F>)Preconditions.checkNotNull(param1List);
      this.function = (Function<? super F, ? extends T>)Preconditions.checkNotNull(param1Function);
    }
    
    public void clear() {
      this.fromList.clear();
    }
    
    public ListIterator<T> listIterator(int param1Int) {
      return new TransformedListIterator<F, T>(this.fromList.listIterator(param1Int)) {
          T transform(F param2F) {
            return (T)Lists.TransformingSequentialList.this.function.apply(param2F);
          }
        };
    }
    
    public int size() {
      return this.fromList.size();
    }
  }
  
  class null extends TransformedListIterator<F, T> {
    null(ListIterator<? extends F> param1ListIterator) {
      super(param1ListIterator);
    }
    
    T transform(F param1F) {
      return (T)this.this$0.function.apply(param1F);
    }
  }
  
  private static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
    private static final long serialVersionUID = 0L;
    
    final E first;
    
    final E[] rest;
    
    final E second;
    
    TwoPlusArrayList(@Nullable E param1E1, @Nullable E param1E2, E[] param1ArrayOfE) {
      this.first = param1E1;
      this.second = param1E2;
      this.rest = (E[])Preconditions.checkNotNull(param1ArrayOfE);
    }
    
    public E get(int param1Int) {
      switch (param1Int) {
        default:
          Preconditions.checkElementIndex(param1Int, size());
          return this.rest[param1Int - 2];
        case 1:
          return this.second;
        case 0:
          break;
      } 
      return this.first;
    }
    
    public int size() {
      return IntMath.saturatedAdd(this.rest.length, 2);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Lists.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */