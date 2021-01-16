package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.WeakReference;

@GwtIncompatible
public abstract class FinalizableWeakReference<T> extends WeakReference<T> implements FinalizableReference {
  protected FinalizableWeakReference(T paramT, FinalizableReferenceQueue paramFinalizableReferenceQueue) {
    super(paramT, paramFinalizableReferenceQueue.queue);
    paramFinalizableReferenceQueue.cleanUp();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\FinalizableWeakReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */