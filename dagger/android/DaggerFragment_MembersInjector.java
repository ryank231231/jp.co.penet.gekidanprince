package dagger.android;

import android.app.Fragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class DaggerFragment_MembersInjector implements MembersInjector<DaggerFragment> {
  private final Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider;
  
  public DaggerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> paramProvider) {
    this.childFragmentInjectorProvider = paramProvider;
  }
  
  public static MembersInjector<DaggerFragment> create(Provider<DispatchingAndroidInjector<Fragment>> paramProvider) {
    return new DaggerFragment_MembersInjector(paramProvider);
  }
  
  public static void injectChildFragmentInjector(DaggerFragment paramDaggerFragment, DispatchingAndroidInjector<Fragment> paramDispatchingAndroidInjector) {
    paramDaggerFragment.childFragmentInjector = paramDispatchingAndroidInjector;
  }
  
  public void injectMembers(DaggerFragment paramDaggerFragment) {
    injectChildFragmentInjector(paramDaggerFragment, (DispatchingAndroidInjector<Fragment>)this.childFragmentInjectorProvider.get());
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\DaggerFragment_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */