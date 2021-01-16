package dagger.releasablereferences;

import dagger.internal.GwtIncompatible;
import java.lang.annotation.Annotation;

@GwtIncompatible
public interface ReleasableReferenceManager {
  void releaseStrongReferences();
  
  void restoreStrongReferences();
  
  Class<? extends Annotation> scope();
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\releasablereferences\ReleasableReferenceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */