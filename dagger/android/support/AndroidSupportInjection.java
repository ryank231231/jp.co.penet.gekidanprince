package dagger.android.support;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import dagger.android.AndroidInjector;
import dagger.internal.Preconditions;

public final class AndroidSupportInjection {
  private static final String TAG = "dagger.android.support";
  
  private static HasSupportFragmentInjector findHasFragmentInjector(Fragment paramFragment) {
    Fragment fragment = paramFragment;
    while (true) {
      Fragment fragment1 = fragment.getParentFragment();
      if (fragment1 != null) {
        fragment = fragment1;
        if (fragment1 instanceof HasSupportFragmentInjector)
          return (HasSupportFragmentInjector)fragment1; 
        continue;
      } 
      FragmentActivity fragmentActivity = paramFragment.getActivity();
      if (fragmentActivity instanceof HasSupportFragmentInjector)
        return (HasSupportFragmentInjector)fragmentActivity; 
      if (fragmentActivity.getApplication() instanceof HasSupportFragmentInjector)
        return (HasSupportFragmentInjector)fragmentActivity.getApplication(); 
      throw new IllegalArgumentException(String.format("No injector was found for %s", new Object[] { paramFragment.getClass().getCanonicalName() }));
    } 
  }
  
  public static void inject(Fragment paramFragment) {
    Preconditions.checkNotNull(paramFragment, "fragment");
    HasSupportFragmentInjector hasSupportFragmentInjector = findHasFragmentInjector(paramFragment);
    if (Log.isLoggable("dagger.android.support", 3))
      Log.d("dagger.android.support", String.format("An injector for %s was found in %s", new Object[] { paramFragment.getClass().getCanonicalName(), hasSupportFragmentInjector.getClass().getCanonicalName() })); 
    AndroidInjector androidInjector = hasSupportFragmentInjector.supportFragmentInjector();
    Preconditions.checkNotNull(androidInjector, "%s.supportFragmentInjector() returned null", hasSupportFragmentInjector.getClass());
    androidInjector.inject(paramFragment);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\support\AndroidSupportInjection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */