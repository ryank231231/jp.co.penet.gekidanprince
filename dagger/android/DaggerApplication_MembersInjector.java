package dagger.android;

import android.app.Activity;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class DaggerApplication_MembersInjector implements MembersInjector<DaggerApplication> {
  private final Provider<DispatchingAndroidInjector<Activity>> activityInjectorProvider;
  
  private final Provider<DispatchingAndroidInjector<BroadcastReceiver>> broadcastReceiverInjectorProvider;
  
  private final Provider<DispatchingAndroidInjector<ContentProvider>> contentProviderInjectorProvider;
  
  private final Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider;
  
  private final Provider<DispatchingAndroidInjector<Service>> serviceInjectorProvider;
  
  public DaggerApplication_MembersInjector(Provider<DispatchingAndroidInjector<Activity>> paramProvider, Provider<DispatchingAndroidInjector<BroadcastReceiver>> paramProvider1, Provider<DispatchingAndroidInjector<Fragment>> paramProvider2, Provider<DispatchingAndroidInjector<Service>> paramProvider3, Provider<DispatchingAndroidInjector<ContentProvider>> paramProvider4) {
    this.activityInjectorProvider = paramProvider;
    this.broadcastReceiverInjectorProvider = paramProvider1;
    this.fragmentInjectorProvider = paramProvider2;
    this.serviceInjectorProvider = paramProvider3;
    this.contentProviderInjectorProvider = paramProvider4;
  }
  
  public static MembersInjector<DaggerApplication> create(Provider<DispatchingAndroidInjector<Activity>> paramProvider, Provider<DispatchingAndroidInjector<BroadcastReceiver>> paramProvider1, Provider<DispatchingAndroidInjector<Fragment>> paramProvider2, Provider<DispatchingAndroidInjector<Service>> paramProvider3, Provider<DispatchingAndroidInjector<ContentProvider>> paramProvider4) {
    return new DaggerApplication_MembersInjector(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }
  
  public static void injectActivityInjector(DaggerApplication paramDaggerApplication, DispatchingAndroidInjector<Activity> paramDispatchingAndroidInjector) {
    paramDaggerApplication.activityInjector = paramDispatchingAndroidInjector;
  }
  
  public static void injectBroadcastReceiverInjector(DaggerApplication paramDaggerApplication, DispatchingAndroidInjector<BroadcastReceiver> paramDispatchingAndroidInjector) {
    paramDaggerApplication.broadcastReceiverInjector = paramDispatchingAndroidInjector;
  }
  
  public static void injectContentProviderInjector(DaggerApplication paramDaggerApplication, DispatchingAndroidInjector<ContentProvider> paramDispatchingAndroidInjector) {
    paramDaggerApplication.contentProviderInjector = paramDispatchingAndroidInjector;
  }
  
  public static void injectFragmentInjector(DaggerApplication paramDaggerApplication, DispatchingAndroidInjector<Fragment> paramDispatchingAndroidInjector) {
    paramDaggerApplication.fragmentInjector = paramDispatchingAndroidInjector;
  }
  
  public static void injectServiceInjector(DaggerApplication paramDaggerApplication, DispatchingAndroidInjector<Service> paramDispatchingAndroidInjector) {
    paramDaggerApplication.serviceInjector = paramDispatchingAndroidInjector;
  }
  
  public static void injectSetInjected(DaggerApplication paramDaggerApplication) {
    paramDaggerApplication.setInjected();
  }
  
  public void injectMembers(DaggerApplication paramDaggerApplication) {
    injectActivityInjector(paramDaggerApplication, (DispatchingAndroidInjector<Activity>)this.activityInjectorProvider.get());
    injectBroadcastReceiverInjector(paramDaggerApplication, (DispatchingAndroidInjector<BroadcastReceiver>)this.broadcastReceiverInjectorProvider.get());
    injectFragmentInjector(paramDaggerApplication, (DispatchingAndroidInjector<Fragment>)this.fragmentInjectorProvider.get());
    injectServiceInjector(paramDaggerApplication, (DispatchingAndroidInjector<Service>)this.serviceInjectorProvider.get());
    injectContentProviderInjector(paramDaggerApplication, (DispatchingAndroidInjector<ContentProvider>)this.contentProviderInjectorProvider.get());
    injectSetInjected(paramDaggerApplication);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\DaggerApplication_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */