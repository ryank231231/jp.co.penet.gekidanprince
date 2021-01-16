package dagger.internal;

import dagger.releasablereferences.ReleasableReferenceManager;
import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@GwtIncompatible
public final class ReferenceReleasingProviderManager implements ReleasableReferenceManager {
  private final Queue<WeakReference<ReferenceReleasingProvider<?>>> providers = new ConcurrentLinkedQueue<WeakReference<ReferenceReleasingProvider<?>>>();
  
  private final Class<? extends Annotation> scope;
  
  public ReferenceReleasingProviderManager(Class<? extends Annotation> paramClass) {
    this.scope = Preconditions.<Class<? extends Annotation>>checkNotNull(paramClass);
  }
  
  private void execute(Operation paramOperation) {
    Iterator<WeakReference<ReferenceReleasingProvider<?>>> iterator = this.providers.iterator();
    while (iterator.hasNext()) {
      ReferenceReleasingProvider<?> referenceReleasingProvider = ((WeakReference<ReferenceReleasingProvider>)iterator.next()).get();
      if (referenceReleasingProvider == null) {
        iterator.remove();
        continue;
      } 
      paramOperation.execute(referenceReleasingProvider);
    } 
  }
  
  public void addProvider(ReferenceReleasingProvider<?> paramReferenceReleasingProvider) {
    this.providers.add(new WeakReference<ReferenceReleasingProvider<?>>(paramReferenceReleasingProvider));
  }
  
  public void releaseStrongReferences() {
    execute(Operation.RELEASE);
  }
  
  public void restoreStrongReferences() {
    execute(Operation.RESTORE);
  }
  
  public Class<? extends Annotation> scope() {
    return this.scope;
  }
  
  private enum Operation {
    RELEASE {
      void execute(ReferenceReleasingProvider<?> param2ReferenceReleasingProvider) {
        param2ReferenceReleasingProvider.releaseStrongReference();
      }
    },
    RESTORE {
      void execute(ReferenceReleasingProvider<?> param2ReferenceReleasingProvider) {
        param2ReferenceReleasingProvider.restoreStrongReference();
      }
    };
    
    static {
    
    }
    
    abstract void execute(ReferenceReleasingProvider<?> param1ReferenceReleasingProvider);
  }
  
  enum null {
    void execute(ReferenceReleasingProvider<?> param1ReferenceReleasingProvider) {
      param1ReferenceReleasingProvider.releaseStrongReference();
    }
  }
  
  enum null {
    void execute(ReferenceReleasingProvider<?> param1ReferenceReleasingProvider) {
      param1ReferenceReleasingProvider.restoreStrongReference();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\internal\ReferenceReleasingProviderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */