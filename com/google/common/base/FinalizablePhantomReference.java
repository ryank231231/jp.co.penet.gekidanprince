package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.PhantomReference;

@GwtIncompatible
public abstract class FinalizablePhantomReference<T> extends PhantomReference<T> implements FinalizableReference {
  protected FinalizablePhantomReference(T paramT, FinalizableReferenceQueue paramFinalizableReferenceQueue) {
    super(paramT, paramFinalizableReferenceQueue.queue);
    paramFinalizableReferenceQueue.cleanUp();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\FinalizablePhantomReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */