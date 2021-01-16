package dagger.android;

import android.app.Fragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class DaggerActivity_MembersInjector implements MembersInjector<DaggerActivity> {
  private final Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider;
  
  public DaggerActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> paramProvider) {
    this.fragmentInjectorProvider = paramProvider;
  }
  
  public static MembersInjector<DaggerActivity> create(Provider<DispatchingAndroidInjector<Fragment>> paramProvider) {
    return new DaggerActivity_MembersInjector(paramProvider);
  }
  
  public static void injectFragmentInjector(DaggerActivity paramDaggerActivity, DispatchingAndroidInjector<Fragment> paramDispatchingAndroidInjector) {
    paramDaggerActivity.fragmentInjector = paramDispatchingAndroidInjector;
  }
  
  public void injectMembers(DaggerActivity paramDaggerActivity) {
    injectFragmentInjector(paramDaggerActivity, (DispatchingAndroidInjector<Fragment>)this.fragmentInjectorProvider.get());
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\DaggerActivity_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */