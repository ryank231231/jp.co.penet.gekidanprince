package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.MapMaker;
import com.google.common.math.IntMath;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Beta
@GwtIncompatible
public abstract class Striped<L> {
  private static final int ALL_SET = -1;
  
  private static final int LARGE_LAZY_CUTOFF = 1024;
  
  private static final Supplier<ReadWriteLock> READ_WRITE_LOCK_SUPPLIER = new Supplier<ReadWriteLock>() {
      public ReadWriteLock get() {
        return new ReentrantReadWriteLock();
      }
    };
  
  private Striped() {}
  
  private static int ceilToPowerOfTwo(int paramInt) {
    return 1 << IntMath.log2(paramInt, RoundingMode.CEILING);
  }
  
  private static <L> Striped<L> lazy(int paramInt, Supplier<L> paramSupplier) {
    SmallLazyStriped<L> smallLazyStriped;
    LargeLazyStriped<L> largeLazyStriped;
    if (paramInt < 1024) {
      smallLazyStriped = new SmallLazyStriped<L>(paramInt, paramSupplier);
    } else {
      largeLazyStriped = new LargeLazyStriped<L>(paramInt, (Supplier<L>)smallLazyStriped);
    } 
    return largeLazyStriped;
  }
  
  public static Striped<Lock> lazyWeakLock(int paramInt) {
    return lazy(paramInt, new Supplier<Lock>() {
          public Lock get() {
            return new ReentrantLock(false);
          }
        });
  }
  
  public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int paramInt) {
    return lazy(paramInt, READ_WRITE_LOCK_SUPPLIER);
  }
  
  public static Striped<Semaphore> lazyWeakSemaphore(int paramInt1, final int permits) {
    return lazy(paramInt1, new Supplier<Semaphore>() {
          public Semaphore get() {
            return new Semaphore(permits, false);
          }
        });
  }
  
  public static Striped<Lock> lock(int paramInt) {
    return new CompactStriped<Lock>(paramInt, new Supplier<Lock>() {
          public Lock get() {
            return new Striped.PaddedLock();
          }
        });
  }
  
  public static Striped<ReadWriteLock> readWriteLock(int paramInt) {
    return new CompactStriped<ReadWriteLock>(paramInt, READ_WRITE_LOCK_SUPPLIER);
  }
  
  public static Striped<Semaphore> semaphore(int paramInt1, final int permits) {
    return new CompactStriped<Semaphore>(paramInt1, new Supplier<Semaphore>() {
          public Semaphore get() {
            return new Striped.PaddedSemaphore(permits);
          }
        });
  }
  
  private static int smear(int paramInt) {
    paramInt ^= paramInt >>> 20 ^ paramInt >>> 12;
    return paramInt >>> 4 ^ paramInt >>> 7 ^ paramInt;
  }
  
  public Iterable<L> bulkGet(Iterable<?> paramIterable) {
    Object[] arrayOfObject = Iterables.toArray(paramIterable, Object.class);
    if (arrayOfObject.length == 0)
      return (Iterable<L>)ImmutableList.of(); 
    int[] arrayOfInt = new int[arrayOfObject.length];
    byte b;
    for (b = 0; b < arrayOfObject.length; b++)
      arrayOfInt[b] = indexFor(arrayOfObject[b]); 
    Arrays.sort(arrayOfInt);
    int i = arrayOfInt[0];
    arrayOfObject[0] = getAt(i);
    for (b = 1; b < arrayOfObject.length; b++) {
      int j = arrayOfInt[b];
      if (j == i) {
        arrayOfObject[b] = arrayOfObject[b - 1];
      } else {
        arrayOfObject[b] = getAt(j);
        i = j;
      } 
    } 
    return Collections.unmodifiableList(Arrays.asList((L[])arrayOfObject));
  }
  
  public abstract L get(Object paramObject);
  
  public abstract L getAt(int paramInt);
  
  abstract int indexFor(Object paramObject);
  
  public abstract int size();
  
  private static class CompactStriped<L> extends PowerOfTwoStriped<L> {
    private final Object[] array;
    
    private CompactStriped(int param1Int, Supplier<L> param1Supplier) {
      super(param1Int);
      boolean bool2;
      boolean bool1 = false;
      if (param1Int <= 1073741824) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "Stripes must be <= 2^30)");
      this.array = new Object[this.mask + 1];
      param1Int = bool1;
      while (true) {
        Object[] arrayOfObject = this.array;
        if (param1Int < arrayOfObject.length) {
          arrayOfObject[param1Int] = param1Supplier.get();
          param1Int++;
          continue;
        } 
        break;
      } 
    }
    
    public L getAt(int param1Int) {
      return (L)this.array[param1Int];
    }
    
    public int size() {
      return this.array.length;
    }
  }
  
  @VisibleForTesting
  static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {
    final ConcurrentMap<Integer, L> locks;
    
    final int size;
    
    final Supplier<L> supplier;
    
    LargeLazyStriped(int param1Int, Supplier<L> param1Supplier) {
      super(param1Int);
      if (this.mask == -1) {
        param1Int = Integer.MAX_VALUE;
      } else {
        param1Int = this.mask + 1;
      } 
      this.size = param1Int;
      this.supplier = param1Supplier;
      this.locks = (new MapMaker()).weakValues().makeMap();
    }
    
    public L getAt(int param1Int) {
      if (this.size != Integer.MAX_VALUE)
        Preconditions.checkElementIndex(param1Int, size()); 
      L l = this.locks.get(Integer.valueOf(param1Int));
      if (l != null)
        return l; 
      l = (L)this.supplier.get();
      return (L)MoreObjects.firstNonNull(this.locks.putIfAbsent(Integer.valueOf(param1Int), l), l);
    }
    
    public int size() {
      return this.size;
    }
  }
  
  private static class PaddedLock extends ReentrantLock {
    long unused1;
    
    long unused2;
    
    long unused3;
    
    PaddedLock() {
      super(false);
    }
  }
  
  private static class PaddedSemaphore extends Semaphore {
    long unused1;
    
    long unused2;
    
    long unused3;
    
    PaddedSemaphore(int param1Int) {
      super(param1Int, false);
    }
  }
  
  private static abstract class PowerOfTwoStriped<L> extends Striped<L> {
    final int mask;
    
    PowerOfTwoStriped(int param1Int) {
      boolean bool;
      if (param1Int > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "Stripes must be positive");
      if (param1Int > 1073741824) {
        param1Int = -1;
      } else {
        param1Int = Striped.ceilToPowerOfTwo(param1Int) - 1;
      } 
      this.mask = param1Int;
    }
    
    public final L get(Object param1Object) {
      return getAt(indexFor(param1Object));
    }
    
    final int indexFor(Object param1Object) {
      return Striped.smear(param1Object.hashCode()) & this.mask;
    }
  }
  
  @VisibleForTesting
  static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {
    final AtomicReferenceArray<ArrayReference<? extends L>> locks;
    
    final ReferenceQueue<L> queue = new ReferenceQueue<L>();
    
    final int size;
    
    final Supplier<L> supplier;
    
    SmallLazyStriped(int param1Int, Supplier<L> param1Supplier) {
      super(param1Int);
      if (this.mask == -1) {
        param1Int = Integer.MAX_VALUE;
      } else {
        param1Int = this.mask + 1;
      } 
      this.size = param1Int;
      this.locks = new AtomicReferenceArray<ArrayReference<? extends L>>(this.size);
      this.supplier = param1Supplier;
    }
    
    private void drainQueue() {
      while (true) {
        Reference<? extends L> reference = this.queue.poll();
        if (reference != null) {
          reference = reference;
          this.locks.compareAndSet(((ArrayReference)reference).index, reference, null);
          continue;
        } 
        break;
      } 
    }
    
    public L getAt(int param1Int) {
      L l;
      if (this.size != Integer.MAX_VALUE)
        Preconditions.checkElementIndex(param1Int, size()); 
      ArrayReference<Object> arrayReference = (ArrayReference)this.locks.get(param1Int);
      if (arrayReference == null) {
        l = null;
      } else {
        l = (L)arrayReference.get();
      } 
      if (l != null)
        return l; 
      Object object = this.supplier.get();
      ArrayReference arrayReference1 = new ArrayReference(object, param1Int, this.queue);
      while (!this.locks.compareAndSet(param1Int, arrayReference, arrayReference1)) {
        arrayReference = (ArrayReference<Object>)this.locks.get(param1Int);
        if (arrayReference == null) {
          l = null;
        } else {
          l = (L)arrayReference.get();
        } 
        if (l != null)
          return l; 
      } 
      drainQueue();
      return (L)object;
    }
    
    public int size() {
      return this.size;
    }
    
    private static final class ArrayReference<L> extends WeakReference<L> {
      final int index;
      
      ArrayReference(L param2L, int param2Int, ReferenceQueue<L> param2ReferenceQueue) {
        super(param2L, param2ReferenceQueue);
        this.index = param2Int;
      }
    }
  }
  
  private static final class ArrayReference<L> extends WeakReference<L> {
    final int index;
    
    ArrayReference(L param1L, int param1Int, ReferenceQueue<L> param1ReferenceQueue) {
      super(param1L, param1ReferenceQueue);
      this.index = param1Int;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\Striped.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */