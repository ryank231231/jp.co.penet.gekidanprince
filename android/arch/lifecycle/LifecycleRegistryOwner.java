package android.arch.lifecycle;

import android.support.annotation.NonNull;

@Deprecated
public interface LifecycleRegistryOwner extends LifecycleOwner {
  @NonNull
  LifecycleRegistry getLifecycle();
}


/* Location:              Y:\classes-dex2jar.jar!\android\arch\lifecycle\LifecycleRegistryOwner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */