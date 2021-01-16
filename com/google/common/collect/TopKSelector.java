package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
final class TopKSelector<T> {
  private final T[] buffer;
  
  private int bufferSize;
  
  private final Comparator<? super T> comparator;
  
  private final int k;
  
  private T threshold;
  
  private TopKSelector(Comparator<? super T> paramComparator, int paramInt) {
    boolean bool;
    this.comparator = (Comparator<? super T>)Preconditions.checkNotNull(paramComparator, "comparator");
    this.k = paramInt;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "k must be nonnegative, was %s", paramInt);
    this.buffer = (T[])new Object[paramInt * 2];
    this.bufferSize = 0;
    this.threshold = null;
  }
  
  public static <T extends Comparable<? super T>> TopKSelector<T> greatest(int paramInt) {
    return greatest(paramInt, Ordering.natural());
  }
  
  public static <T> TopKSelector<T> greatest(int paramInt, Comparator<? super T> paramComparator) {
    return new TopKSelector<T>(Ordering.<T>from(paramComparator).reverse(), paramInt);
  }
  
  public static <T extends Comparable<? super T>> TopKSelector<T> least(int paramInt) {
    return least(paramInt, Ordering.natural());
  }
  
  public static <T> TopKSelector<T> least(int paramInt, Comparator<? super T> paramComparator) {
    return new TopKSelector<T>(paramComparator, paramInt);
  }
  
  private int partition(int paramInt1, int paramInt2, int paramInt3) {
    T[] arrayOfT = this.buffer;
    T t = arrayOfT[paramInt3];
    arrayOfT[paramInt3] = arrayOfT[paramInt2];
    for (paramInt3 = paramInt1; paramInt1 < paramInt2; paramInt3 = i) {
      int i = paramInt3;
      if (this.comparator.compare(this.buffer[paramInt1], t) < 0) {
        swap(paramInt3, paramInt1);
        i = paramInt3 + 1;
      } 
      paramInt1++;
    } 
    arrayOfT = this.buffer;
    arrayOfT[paramInt2] = arrayOfT[paramInt3];
    arrayOfT[paramInt3] = t;
    return paramInt3;
  }
  
  private void swap(int paramInt1, int paramInt2) {
    T[] arrayOfT = this.buffer;
    T t = arrayOfT[paramInt1];
    arrayOfT[paramInt1] = arrayOfT[paramInt2];
    arrayOfT[paramInt2] = t;
  }
  
  private void trim() {
    int i1;
    int i = this.k * 2 - 1;
    int j = IntMath.log2(i + 0, RoundingMode.CEILING);
    int k = 0;
    int m = 0;
    int n = 0;
    while (true) {
      i1 = n;
      if (k < i) {
        int i2 = partition(k, i, k + i + 1 >>> 1);
        int i3 = this.k;
        if (i2 > i3) {
          i2--;
          i3 = k;
          i1 = n;
        } else {
          i1 = n;
          if (i2 < i3) {
            i3 = Math.max(i2, k + 1);
            i1 = i2;
            i2 = i;
          } else {
            break;
          } 
        } 
        int i4 = m + 1;
        i = i2;
        k = i3;
        m = i4;
        n = i1;
        if (i4 >= j * 3) {
          Arrays.sort(this.buffer, i3, i2, this.comparator);
          break;
        } 
        continue;
      } 
      break;
    } 
    this.bufferSize = this.k;
    this.threshold = this.buffer[i1];
    while (++i1 < this.k) {
      if (this.comparator.compare(this.buffer[i1], this.threshold) > 0)
        this.threshold = this.buffer[i1]; 
    } 
  }
  
  public void offer(@Nullable T paramT) {
    int i = this.k;
    if (i == 0)
      return; 
    int j = this.bufferSize;
    if (j == 0) {
      this.buffer[0] = paramT;
      this.threshold = paramT;
      this.bufferSize = 1;
    } else if (j < i) {
      T[] arrayOfT = this.buffer;
      this.bufferSize = j + 1;
      arrayOfT[j] = paramT;
      if (this.comparator.compare(paramT, this.threshold) > 0)
        this.threshold = paramT; 
    } else if (this.comparator.compare(paramT, this.threshold) < 0) {
      T[] arrayOfT = this.buffer;
      i = this.bufferSize;
      this.bufferSize = i + 1;
      arrayOfT[i] = paramT;
      if (this.bufferSize == this.k * 2)
        trim(); 
    } 
  }
  
  public void offerAll(Iterable<? extends T> paramIterable) {
    offerAll(paramIterable.iterator());
  }
  
  public void offerAll(Iterator<? extends T> paramIterator) {
    while (paramIterator.hasNext())
      offer(paramIterator.next()); 
  }
  
  public List<T> topK() {
    Arrays.sort(this.buffer, 0, this.bufferSize, this.comparator);
    int i = this.bufferSize;
    int j = this.k;
    if (i > j) {
      T[] arrayOfT = this.buffer;
      Arrays.fill((Object[])arrayOfT, j, arrayOfT.length, (Object)null);
      i = this.k;
      this.bufferSize = i;
      this.threshold = this.buffer[i - 1];
    } 
    return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.buffer, this.bufferSize)));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\TopKSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */