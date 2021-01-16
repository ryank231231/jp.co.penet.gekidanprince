package dagger.internal;

import dagger.releasablereferences.ReleasableReferenceManager;
import dagger.releasablereferences.TypedReleasableReferenceManager;
import java.lang.annotation.Annotation;

@GwtIncompatible
public final class TypedReleasableReferenceManagerDecorator<M extends Annotation> implements TypedReleasableReferenceManager<M> {
  private final ReleasableReferenceManager delegate;
  
  private final M metadata;
  
  public TypedReleasableReferenceManagerDecorator(ReleasableReferenceManager paramReleasableReferenceManager, M paramM) {
    this.delegate = Preconditions.<ReleasableReferenceManager>checkNotNull(paramReleasableReferenceManager);
    this.metadata = (M)Preconditions.<Annotation>checkNotNull((Annotation)paramM);
  }
  
  public M metadata() {
    return this.metadata;
  }
  
  public void releaseStrongReferences() {
    this.delegate.releaseStrongReferences();
  }
  
  public void restoreStrongReferences() {
    this.delegate.restoreStrongReferences();
  }
  
  public Class<? extends Annotation> scope() {
    return this.delegate.scope();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\internal\TypedReleasableReferenceManagerDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */