package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

@Beta
@GwtCompatible
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {
  private static final int DEFAULT_CAPACITY = 11;
  
  private static final int EVEN_POWERS_OF_TWO = 1431655765;
  
  private static final int ODD_POWERS_OF_TWO = -1431655766;
  
  private final Heap maxHeap;
  
  @VisibleForTesting
  final int maximumSize;
  
  private final Heap minHeap;
  
  private int modCount;
  
  private Object[] queue;
  
  private int size;
  
  private MinMaxPriorityQueue(Builder<? super E> paramBuilder, int paramInt) {
    Ordering<E> ordering = paramBuilder.ordering();
    this.minHeap = new Heap(ordering);
    this.maxHeap = new Heap(ordering.reverse());
    Heap heap2 = this.minHeap;
    Heap heap1 = this.maxHeap;
    heap2.otherHeap = heap1;
    heap1.otherHeap = heap2;
    this.maximumSize = paramBuilder.maximumSize;
    this.queue = new Object[paramInt];
  }
  
  private int calculateNewCapacity() {
    int i = this.queue.length;
    if (i < 64) {
      i = (i + 1) * 2;
    } else {
      i = IntMath.checkedMultiply(i / 2, 3);
    } 
    return capAtMaximumSize(i, this.maximumSize);
  }
  
  private static int capAtMaximumSize(int paramInt1, int paramInt2) {
    return Math.min(paramInt1 - 1, paramInt2) + 1;
  }
  
  public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create() {
    return (new Builder(Ordering.natural())).create();
  }
  
  public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> paramIterable) {
    return (new Builder(Ordering.natural())).create(paramIterable);
  }
  
  public static Builder<Comparable> expectedSize(int paramInt) {
    return (new Builder<Comparable>(Ordering.natural())).expectedSize(paramInt);
  }
  
  private MoveDesc<E> fillHole(int paramInt, E paramE) {
    Heap heap = heapForIndex(paramInt);
    int i = heap.fillHoleAt(paramInt);
    int j = heap.bubbleUpAlternatingLevels(i, paramE);
    if (j == i)
      return heap.tryCrossOverAndBubbleUp(paramInt, i, paramE); 
    if (j < paramInt) {
      MoveDesc<E> moveDesc = new MoveDesc<E>(paramE, elementData(paramInt));
    } else {
      paramE = null;
    } 
    return (MoveDesc<E>)paramE;
  }
  
  private int getMaxElementIndex() {
    int i = this.size;
    null = 1;
    switch (i) {
      default:
        if (this.maxHeap.compareElements(1, 2) <= 0)
          return null; 
        break;
      case 2:
        return 1;
      case 1:
        return 0;
    } 
    return 2;
  }
  
  private void growIfNeeded() {
    if (this.size > this.queue.length) {
      Object[] arrayOfObject1 = new Object[calculateNewCapacity()];
      Object[] arrayOfObject2 = this.queue;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, arrayOfObject2.length);
      this.queue = arrayOfObject1;
    } 
  }
  
  private Heap heapForIndex(int paramInt) {
    Heap heap;
    if (isEvenLevel(paramInt)) {
      heap = this.minHeap;
    } else {
      heap = this.maxHeap;
    } 
    return heap;
  }
  
  @VisibleForTesting
  static int initialQueueSize(int paramInt1, int paramInt2, Iterable<?> paramIterable) {
    int i = paramInt1;
    if (paramInt1 == -1)
      i = 11; 
    paramInt1 = i;
    if (paramIterable instanceof Collection)
      paramInt1 = Math.max(i, ((Collection)paramIterable).size()); 
    return capAtMaximumSize(paramInt1, paramInt2);
  }
  
  @VisibleForTesting
  static boolean isEvenLevel(int paramInt) {
    boolean bool2;
    boolean bool1 = true;
    paramInt = paramInt + 1 ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
    if (paramInt > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "negative index");
    if ((0x55555555 & paramInt) > (paramInt & 0xAAAAAAAA)) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    return bool2;
  }
  
  public static Builder<Comparable> maximumSize(int paramInt) {
    return (new Builder<Comparable>(Ordering.natural())).maximumSize(paramInt);
  }
  
  public static <B> Builder<B> orderedBy(Comparator<B> paramComparator) {
    return new Builder<B>(paramComparator);
  }
  
  private E removeAndGet(int paramInt) {
    E e = elementData(paramInt);
    removeAt(paramInt);
    return e;
  }
  
  @CanIgnoreReturnValue
  public boolean add(E paramE) {
    offer(paramE);
    return true;
  }
  
  @CanIgnoreReturnValue
  public boolean addAll(Collection<? extends E> paramCollection) {
    Iterator<? extends E> iterator = paramCollection.iterator();
    boolean bool;
    for (bool = false; iterator.hasNext(); bool = true)
      offer(iterator.next()); 
    return bool;
  }
  
  @VisibleForTesting
  int capacity() {
    return this.queue.length;
  }
  
  public void clear() {
    for (byte b = 0; b < this.size; b++)
      this.queue[b] = null; 
    this.size = 0;
  }
  
  public Comparator<? super E> comparator() {
    return this.minHeap.ordering;
  }
  
  E elementData(int paramInt) {
    return (E)this.queue[paramInt];
  }
  
  @VisibleForTesting
  boolean isIntact() {
    for (byte b = 1; b < this.size; b++) {
      if (!heapForIndex(b).verifyIndex(b))
        return false; 
    } 
    return true;
  }
  
  public Iterator<E> iterator() {
    return new QueueIterator();
  }
  
  @CanIgnoreReturnValue
  public boolean offer(E paramE) {
    Preconditions.checkNotNull(paramE);
    int i = this.modCount;
    boolean bool1 = true;
    this.modCount = i + 1;
    i = this.size;
    this.size = i + 1;
    growIfNeeded();
    heapForIndex(i).bubbleUp(i, paramE);
    boolean bool2 = bool1;
    if (this.size > this.maximumSize)
      if (pollLast() != paramE) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }  
    return bool2;
  }
  
  public E peek() {
    E e;
    if (isEmpty()) {
      Object object = null;
    } else {
      e = elementData(0);
    } 
    return e;
  }
  
  public E peekFirst() {
    return peek();
  }
  
  public E peekLast() {
    E e;
    if (isEmpty()) {
      Object object = null;
    } else {
      e = elementData(getMaxElementIndex());
    } 
    return e;
  }
  
  @CanIgnoreReturnValue
  public E poll() {
    E e;
    if (isEmpty()) {
      Object object = null;
    } else {
      e = removeAndGet(0);
    } 
    return e;
  }
  
  @CanIgnoreReturnValue
  public E pollFirst() {
    return poll();
  }
  
  @CanIgnoreReturnValue
  public E pollLast() {
    E e;
    if (isEmpty()) {
      Object object = null;
    } else {
      e = removeAndGet(getMaxElementIndex());
    } 
    return e;
  }
  
  @VisibleForTesting
  @CanIgnoreReturnValue
  MoveDesc<E> removeAt(int paramInt) {
    Preconditions.checkPositionIndex(paramInt, this.size);
    this.modCount++;
    int i = --this.size;
    if (i == paramInt) {
      this.queue[i] = null;
      return null;
    } 
    E e1 = elementData(i);
    i = heapForIndex(this.size).getCorrectLastElement(e1);
    E e2 = elementData(this.size);
    this.queue[this.size] = null;
    MoveDesc<E> moveDesc = fillHole(paramInt, e2);
    return (i < paramInt) ? ((moveDesc == null) ? new MoveDesc<E>(e1, e2) : new MoveDesc<E>(e1, moveDesc.replaced)) : moveDesc;
  }
  
  @CanIgnoreReturnValue
  public E removeFirst() {
    return remove();
  }
  
  @CanIgnoreReturnValue
  public E removeLast() {
    if (!isEmpty())
      return removeAndGet(getMaxElementIndex()); 
    throw new NoSuchElementException();
  }
  
  public int size() {
    return this.size;
  }
  
  public Object[] toArray() {
    int i = this.size;
    Object[] arrayOfObject = new Object[i];
    System.arraycopy(this.queue, 0, arrayOfObject, 0, i);
    return arrayOfObject;
  }
  
  @Beta
  public static final class Builder<B> {
    private static final int UNSET_EXPECTED_SIZE = -1;
    
    private final Comparator<B> comparator;
    
    private int expectedSize = -1;
    
    private int maximumSize = Integer.MAX_VALUE;
    
    private Builder(Comparator<B> param1Comparator) {
      this.comparator = (Comparator<B>)Preconditions.checkNotNull(param1Comparator);
    }
    
    private <T extends B> Ordering<T> ordering() {
      return Ordering.from(this.comparator);
    }
    
    public <T extends B> MinMaxPriorityQueue<T> create() {
      return create(Collections.emptySet());
    }
    
    public <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> param1Iterable) {
      MinMaxPriorityQueue<T> minMaxPriorityQueue = new MinMaxPriorityQueue(this, MinMaxPriorityQueue.initialQueueSize(this.expectedSize, this.maximumSize, param1Iterable));
      Iterator<? extends T> iterator = param1Iterable.iterator();
      while (iterator.hasNext())
        minMaxPriorityQueue.offer(iterator.next()); 
      return minMaxPriorityQueue;
    }
    
    @CanIgnoreReturnValue
    public Builder<B> expectedSize(int param1Int) {
      boolean bool;
      if (param1Int >= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool);
      this.expectedSize = param1Int;
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<B> maximumSize(int param1Int) {
      boolean bool;
      if (param1Int > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool);
      this.maximumSize = param1Int;
      return this;
    }
  }
  
  private class Heap {
    final Ordering<E> ordering;
    
    @Weak
    Heap otherHeap;
    
    Heap(Ordering<E> param1Ordering) {
      this.ordering = param1Ordering;
    }
    
    private int getGrandparentIndex(int param1Int) {
      return getParentIndex(getParentIndex(param1Int));
    }
    
    private int getLeftChildIndex(int param1Int) {
      return param1Int * 2 + 1;
    }
    
    private int getParentIndex(int param1Int) {
      return (param1Int - 1) / 2;
    }
    
    private int getRightChildIndex(int param1Int) {
      return param1Int * 2 + 2;
    }
    
    private boolean verifyIndex(int param1Int) {
      return (getLeftChildIndex(param1Int) < MinMaxPriorityQueue.this.size && compareElements(param1Int, getLeftChildIndex(param1Int)) > 0) ? false : ((getRightChildIndex(param1Int) < MinMaxPriorityQueue.this.size && compareElements(param1Int, getRightChildIndex(param1Int)) > 0) ? false : ((param1Int > 0 && compareElements(param1Int, getParentIndex(param1Int)) > 0) ? false : (!(param1Int > 2 && compareElements(getGrandparentIndex(param1Int), param1Int) > 0))));
    }
    
    void bubbleUp(int param1Int, E param1E) {
      Heap heap;
      int i = crossOverUp(param1Int, param1E);
      if (i == param1Int) {
        heap = this;
      } else {
        heap = this.otherHeap;
        param1Int = i;
      } 
      heap.bubbleUpAlternatingLevels(param1Int, param1E);
    }
    
    @CanIgnoreReturnValue
    int bubbleUpAlternatingLevels(int param1Int, E param1E) {
      while (param1Int > 2) {
        int i = getGrandparentIndex(param1Int);
        E e = (E)MinMaxPriorityQueue.this.elementData(i);
        if (this.ordering.compare(e, param1E) <= 0)
          break; 
        MinMaxPriorityQueue.this.queue[param1Int] = e;
        param1Int = i;
      } 
      MinMaxPriorityQueue.this.queue[param1Int] = param1E;
      return param1Int;
    }
    
    int compareElements(int param1Int1, int param1Int2) {
      return this.ordering.compare(MinMaxPriorityQueue.this.elementData(param1Int1), MinMaxPriorityQueue.this.elementData(param1Int2));
    }
    
    int crossOver(int param1Int, E param1E) {
      int i = findMinChild(param1Int);
      if (i > 0 && this.ordering.compare(MinMaxPriorityQueue.this.elementData(i), param1E) < 0) {
        MinMaxPriorityQueue.this.queue[param1Int] = MinMaxPriorityQueue.this.elementData(i);
        MinMaxPriorityQueue.this.queue[i] = param1E;
        return i;
      } 
      return crossOverUp(param1Int, param1E);
    }
    
    int crossOverUp(int param1Int, E param1E) {
      E e2;
      if (param1Int == 0) {
        MinMaxPriorityQueue.this.queue[0] = param1E;
        return 0;
      } 
      int i = getParentIndex(param1Int);
      E e1 = (E)MinMaxPriorityQueue.this.elementData(i);
      int j = i;
      E e3 = e1;
      if (i != 0) {
        int k = getRightChildIndex(getParentIndex(i));
        j = i;
        e3 = e1;
        if (k != i) {
          j = i;
          e3 = e1;
          if (getLeftChildIndex(k) >= MinMaxPriorityQueue.this.size) {
            E e = (E)MinMaxPriorityQueue.this.elementData(k);
            j = i;
            e3 = e1;
            if (this.ordering.compare(e, e1) < 0) {
              j = k;
              e2 = e;
            } 
          } 
        } 
      } 
      if (this.ordering.compare(e2, param1E) < 0) {
        MinMaxPriorityQueue.this.queue[param1Int] = e2;
        MinMaxPriorityQueue.this.queue[j] = param1E;
        return j;
      } 
      MinMaxPriorityQueue.this.queue[param1Int] = param1E;
      return param1Int;
    }
    
    int fillHoleAt(int param1Int) {
      while (true) {
        int i = findMinGrandChild(param1Int);
        if (i > 0) {
          MinMaxPriorityQueue.this.queue[param1Int] = MinMaxPriorityQueue.this.elementData(i);
          param1Int = i;
          continue;
        } 
        return param1Int;
      } 
    }
    
    int findMin(int param1Int1, int param1Int2) {
      boolean bool;
      if (param1Int1 >= MinMaxPriorityQueue.this.size)
        return -1; 
      if (param1Int1 > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool);
      int i = Math.min(param1Int1, MinMaxPriorityQueue.this.size - param1Int2);
      int j = param1Int1 + 1;
      while (j < i + param1Int2) {
        int k = param1Int1;
        if (compareElements(j, param1Int1) < 0)
          k = j; 
        j++;
        param1Int1 = k;
      } 
      return param1Int1;
    }
    
    int findMinChild(int param1Int) {
      return findMin(getLeftChildIndex(param1Int), 2);
    }
    
    int findMinGrandChild(int param1Int) {
      param1Int = getLeftChildIndex(param1Int);
      return (param1Int < 0) ? -1 : findMin(getLeftChildIndex(param1Int), 4);
    }
    
    int getCorrectLastElement(E param1E) {
      int i = getParentIndex(MinMaxPriorityQueue.this.size);
      if (i != 0) {
        int j = getRightChildIndex(getParentIndex(i));
        if (j != i && getLeftChildIndex(j) >= MinMaxPriorityQueue.this.size) {
          E e = (E)MinMaxPriorityQueue.this.elementData(j);
          if (this.ordering.compare(e, param1E) < 0) {
            MinMaxPriorityQueue.this.queue[j] = param1E;
            MinMaxPriorityQueue.this.queue[MinMaxPriorityQueue.this.size] = e;
            return j;
          } 
        } 
      } 
      return MinMaxPriorityQueue.this.size;
    }
    
    MinMaxPriorityQueue.MoveDesc<E> tryCrossOverAndBubbleUp(int param1Int1, int param1Int2, E param1E) {
      E e;
      int i = crossOver(param1Int2, param1E);
      if (i == param1Int2)
        return null; 
      if (i < param1Int1) {
        e = (E)MinMaxPriorityQueue.this.elementData(param1Int1);
      } else {
        e = (E)MinMaxPriorityQueue.this.elementData(getParentIndex(param1Int1));
      } 
      return (this.otherHeap.bubbleUpAlternatingLevels(i, param1E) < param1Int1) ? new MinMaxPriorityQueue.MoveDesc<E>(param1E, e) : null;
    }
  }
  
  static class MoveDesc<E> {
    final E replaced;
    
    final E toTrickle;
    
    MoveDesc(E param1E1, E param1E2) {
      this.toTrickle = param1E1;
      this.replaced = param1E2;
    }
  }
  
  private class QueueIterator implements Iterator<E> {
    private boolean canRemove;
    
    private int cursor = -1;
    
    private int expectedModCount = MinMaxPriorityQueue.this.modCount;
    
    private Queue<E> forgetMeNot;
    
    private E lastFromForgetMeNot;
    
    private List<E> skipMe;
    
    private QueueIterator() {}
    
    private boolean containsExact(Iterable<E> param1Iterable, E param1E) {
      Iterator<E> iterator = param1Iterable.iterator();
      while (iterator.hasNext()) {
        if (iterator.next() == param1E)
          return true; 
      } 
      return false;
    }
    
    private int nextNotInSkipMe(int param1Int) {
      int i = param1Int;
      if (this.skipMe != null)
        while (true) {
          i = param1Int;
          if (param1Int < MinMaxPriorityQueue.this.size()) {
            i = param1Int;
            if (containsExact(this.skipMe, MinMaxPriorityQueue.this.elementData(param1Int))) {
              param1Int++;
              continue;
            } 
          } 
          break;
        }  
      return i;
    }
    
    void checkModCount() {
      if (MinMaxPriorityQueue.this.modCount == this.expectedModCount)
        return; 
      throw new ConcurrentModificationException();
    }
    
    public boolean hasNext() {
      checkModCount();
      int i = this.cursor;
      boolean bool1 = true;
      boolean bool2 = bool1;
      if (nextNotInSkipMe(i + 1) >= MinMaxPriorityQueue.this.size()) {
        Queue<E> queue = this.forgetMeNot;
        if (queue != null && !queue.isEmpty()) {
          bool2 = bool1;
        } else {
          bool2 = false;
        } 
      } 
      return bool2;
    }
    
    public E next() {
      checkModCount();
      int i = nextNotInSkipMe(this.cursor + 1);
      if (i < MinMaxPriorityQueue.this.size()) {
        this.cursor = i;
        this.canRemove = true;
        return MinMaxPriorityQueue.this.elementData(this.cursor);
      } 
      if (this.forgetMeNot != null) {
        this.cursor = MinMaxPriorityQueue.this.size();
        this.lastFromForgetMeNot = this.forgetMeNot.poll();
        E e = this.lastFromForgetMeNot;
        if (e != null) {
          this.canRemove = true;
          return e;
        } 
      } 
      throw new NoSuchElementException("iterator moved past last element in queue.");
    }
    
    public void remove() {
      CollectPreconditions.checkRemove(this.canRemove);
      checkModCount();
      this.canRemove = false;
      this.expectedModCount++;
      if (this.cursor < MinMaxPriorityQueue.this.size()) {
        MinMaxPriorityQueue.MoveDesc moveDesc = MinMaxPriorityQueue.this.removeAt(this.cursor);
        if (moveDesc != null) {
          if (this.forgetMeNot == null) {
            this.forgetMeNot = new ArrayDeque<E>();
            this.skipMe = new ArrayList<E>(3);
          } 
          this.forgetMeNot.add(moveDesc.toTrickle);
          this.skipMe.add(moveDesc.replaced);
        } 
        this.cursor--;
      } else {
        Preconditions.checkState(removeExact(this.lastFromForgetMeNot));
        this.lastFromForgetMeNot = null;
      } 
    }
    
    boolean removeExact(Object param1Object) {
      for (byte b = 0; b < MinMaxPriorityQueue.this.size; b++) {
        if (MinMaxPriorityQueue.this.queue[b] == param1Object) {
          MinMaxPriorityQueue.this.removeAt(b);
          return true;
        } 
      } 
      return false;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\MinMaxPriorityQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */