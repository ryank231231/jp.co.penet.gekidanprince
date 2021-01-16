package dagger.android;

import dagger.internal.Factory;
import dagger.internal.GwtIncompatible;
import dagger.releasablereferences.TypedReleasableReferenceManager;
import java.util.Set;
import javax.inject.Provider;

@GwtIncompatible
public final class AndroidMemorySensitiveReferenceManager_Factory implements Factory<AndroidMemorySensitiveReferenceManager> {
  private final Provider<Set<TypedReleasableReferenceManager<ReleaseReferencesAt>>> managersProvider;
  
  public AndroidMemorySensitiveReferenceManager_Factory(Provider<Set<TypedReleasableReferenceManager<ReleaseReferencesAt>>> paramProvider) {
    this.managersProvider = paramProvider;
  }
  
  public static Factory<AndroidMemorySensitiveReferenceManager> create(Provider<Set<TypedReleasableReferenceManager<ReleaseReferencesAt>>> paramProvider) {
    return new AndroidMemorySensitiveReferenceManager_Factory(paramProvider);
  }
  
  public static AndroidMemorySensitiveReferenceManager newAndroidMemorySensitiveReferenceManager(Set<TypedReleasableReferenceManager<ReleaseReferencesAt>> paramSet) {
    return new AndroidMemorySensitiveReferenceManager(paramSet);
  }
  
  public AndroidMemorySensitiveReferenceManager get() {
    return new AndroidMemorySensitiveReferenceManager((Set<TypedReleasableReferenceManager<ReleaseReferencesAt>>)this.managersProvider.get());
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\AndroidMemorySensitiveReferenceManager_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */