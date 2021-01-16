package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import javax.annotation.Nullable;

@GwtIncompatible
public final class Atomics {
  public static <V> AtomicReference<V> newReference() {
    return new AtomicReference<V>();
  }
  
  public static <V> AtomicReference<V> newReference(@Nullable V paramV) {
    return new AtomicReference<V>(paramV);
  }
  
  public static <E> AtomicReferenceArray<E> newReferenceArray(int paramInt) {
    return new AtomicReferenceArray<E>(paramInt);
  }
  
  public static <E> AtomicReferenceArray<E> newReferenceArray(E[] paramArrayOfE) {
    return new AtomicReferenceArray<E>(paramArrayOfE);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\Atomics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */