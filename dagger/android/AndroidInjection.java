package dagger.android;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.util.Log;
import dagger.internal.Preconditions;

public final class AndroidInjection {
  private static final String TAG = "dagger.android";
  
  private static HasFragmentInjector findHasFragmentInjector(Fragment paramFragment) {
    Fragment fragment = paramFragment;
    while (true) {
      Fragment fragment1 = fragment.getParentFragment();
      if (fragment1 != null) {
        fragment = fragment1;
        if (fragment1 instanceof HasFragmentInjector)
          return (HasFragmentInjector)fragment1; 
        continue;
      } 
      Activity activity = paramFragment.getActivity();
      if (activity instanceof HasFragmentInjector)
        return (HasFragmentInjector)activity; 
      if (activity.getApplication() instanceof HasFragmentInjector)
        return (HasFragmentInjector)activity.getApplication(); 
      throw new IllegalArgumentException(String.format("No injector was found for %s", new Object[] { paramFragment.getClass().getCanonicalName() }));
    } 
  }
  
  public static void inject(Activity paramActivity) {
    Preconditions.checkNotNull(paramActivity, "activity");
    Application application = paramActivity.getApplication();
    if (application instanceof HasActivityInjector) {
      AndroidInjector androidInjector = ((HasActivityInjector)application).activityInjector();
      Preconditions.checkNotNull(androidInjector, "%s.activityInjector() returned null", application.getClass());
      androidInjector.inject(paramActivity);
      return;
    } 
    throw new RuntimeException(String.format("%s does not implement %s", new Object[] { application.getClass().getCanonicalName(), HasActivityInjector.class.getCanonicalName() }));
  }
  
  public static void inject(Fragment paramFragment) {
    Preconditions.checkNotNull(paramFragment, "fragment");
    HasFragmentInjector hasFragmentInjector = findHasFragmentInjector(paramFragment);
    if (Log.isLoggable("dagger.android", 3))
      Log.d("dagger.android", String.format("An injector for %s was found in %s", new Object[] { paramFragment.getClass().getCanonicalName(), hasFragmentInjector.getClass().getCanonicalName() })); 
    AndroidInjector androidInjector = hasFragmentInjector.fragmentInjector();
    Preconditions.checkNotNull(androidInjector, "%s.fragmentInjector() returned null", hasFragmentInjector.getClass());
    androidInjector.inject(paramFragment);
  }
  
  public static void inject(Service paramService) {
    Preconditions.checkNotNull(paramService, "service");
    Application application = paramService.getApplication();
    if (application instanceof HasServiceInjector) {
      AndroidInjector androidInjector = ((HasServiceInjector)application).serviceInjector();
      Preconditions.checkNotNull(androidInjector, "%s.serviceInjector() returned null", application.getClass());
      androidInjector.inject(paramService);
      return;
    } 
    throw new RuntimeException(String.format("%s does not implement %s", new Object[] { application.getClass().getCanonicalName(), HasServiceInjector.class.getCanonicalName() }));
  }
  
  public static void inject(BroadcastReceiver paramBroadcastReceiver, Context paramContext) {
    Preconditions.checkNotNull(paramBroadcastReceiver, "broadcastReceiver");
    Preconditions.checkNotNull(paramContext, "context");
    Application application = (Application)paramContext.getApplicationContext();
    if (application instanceof HasBroadcastReceiverInjector) {
      AndroidInjector androidInjector = ((HasBroadcastReceiverInjector)application).broadcastReceiverInjector();
      Preconditions.checkNotNull(androidInjector, "%s.broadcastReceiverInjector() returned null", application.getClass());
      androidInjector.inject(paramBroadcastReceiver);
      return;
    } 
    throw new RuntimeException(String.format("%s does not implement %s", new Object[] { application.getClass().getCanonicalName(), HasBroadcastReceiverInjector.class.getCanonicalName() }));
  }
  
  public static void inject(ContentProvider paramContentProvider) {
    Preconditions.checkNotNull(paramContentProvider, "contentProvider");
    Application application = (Application)paramContentProvider.getContext().getApplicationContext();
    if (application instanceof HasContentProviderInjector) {
      AndroidInjector androidInjector = ((HasContentProviderInjector)application).contentProviderInjector();
      Preconditions.checkNotNull(androidInjector, "%s.contentProviderInjector() returned null", application.getClass());
      androidInjector.inject(paramContentProvider);
      return;
    } 
    throw new RuntimeException(String.format("%s does not implement %s", new Object[] { application.getClass().getCanonicalName(), HasContentProviderInjector.class.getCanonicalName() }));
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\AndroidInjection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */