package dagger.android;

import android.app.Fragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class DaggerDialogFragment_MembersInjector implements MembersInjector<DaggerDialogFragment> {
  private final Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider;
  
  public DaggerDialogFragment_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> paramProvider) {
    this.childFragmentInjectorProvider = paramProvider;
  }
  
  public static MembersInjector<DaggerDialogFragment> create(Provider<DispatchingAndroidInjector<Fragment>> paramProvider) {
    return new DaggerDialogFragment_MembersInjector(paramProvider);
  }
  
  public static void injectChildFragmentInjector(DaggerDialogFragment paramDaggerDialogFragment, DispatchingAndroidInjector<Fragment> paramDispatchingAndroidInjector) {
    paramDaggerDialogFragment.childFragmentInjector = paramDispatchingAndroidInjector;
  }
  
  public void injectMembers(DaggerDialogFragment paramDaggerDialogFragment) {
    injectChildFragmentInjector(paramDaggerDialogFragment, (DispatchingAndroidInjector<Fragment>)this.childFragmentInjectorProvider.get());
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\DaggerDialogFragment_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */