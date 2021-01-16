package dagger.releasablereferences;

import dagger.internal.GwtIncompatible;

@GwtIncompatible
public interface TypedReleasableReferenceManager<M extends java.lang.annotation.Annotation> extends ReleasableReferenceManager {
  M metadata();
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\releasablereferences\TypedReleasableReferenceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */