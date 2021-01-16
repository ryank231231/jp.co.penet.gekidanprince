package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.SoftReference;

@GwtIncompatible
public abstract class FinalizableSoftReference<T> extends SoftReference<T> implements FinalizableReference {
  protected FinalizableSoftReference(T paramT, FinalizableReferenceQueue paramFinalizableReferenceQueue) {
    super(paramT, paramFinalizableReferenceQueue.queue);
    paramFinalizableReferenceQueue.cleanUp();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\FinalizableSoftReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */