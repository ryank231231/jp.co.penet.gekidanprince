package dagger.android;

import dagger.internal.GwtIncompatible;
import dagger.releasablereferences.TypedReleasableReferenceManager;
import java.util.Set;
import javax.inject.Inject;

@GwtIncompatible
public final class AndroidMemorySensitiveReferenceManager {
  private final Set<TypedReleasableReferenceManager<ReleaseReferencesAt>> managers;
  
  @Inject
  AndroidMemorySensitiveReferenceManager(Set<TypedReleasableReferenceManager<ReleaseReferencesAt>> paramSet) {
    this.managers = paramSet;
  }
  
  public void onTrimMemory(int paramInt) {
    for (TypedReleasableReferenceManager<ReleaseReferencesAt> typedReleasableReferenceManager : this.managers) {
      if (paramInt >= ((ReleaseReferencesAt)typedReleasableReferenceManager.metadata()).value()) {
        typedReleasableReferenceManager.releaseStrongReferences();
        continue;
      } 
      typedReleasableReferenceManager.restoreStrongReferences();
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\AndroidMemorySensitiveReferenceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */