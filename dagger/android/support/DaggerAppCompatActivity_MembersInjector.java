package dagger.android.support;

import android.app.Fragment;
import android.support.v4.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class DaggerAppCompatActivity_MembersInjector implements MembersInjector<DaggerAppCompatActivity> {
  private final Provider<DispatchingAndroidInjector<Fragment>> frameworkFragmentInjectorProvider;
  
  private final Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider;
  
  public DaggerAppCompatActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> paramProvider, Provider<DispatchingAndroidInjector<Fragment>> paramProvider1) {
    this.supportFragmentInjectorProvider = paramProvider;
    this.frameworkFragmentInjectorProvider = paramProvider1;
  }
  
  public static MembersInjector<DaggerAppCompatActivity> create(Provider<DispatchingAndroidInjector<Fragment>> paramProvider, Provider<DispatchingAndroidInjector<Fragment>> paramProvider1) {
    return new DaggerAppCompatActivity_MembersInjector(paramProvider, paramProvider1);
  }
  
  public static void injectFrameworkFragmentInjector(DaggerAppCompatActivity paramDaggerAppCompatActivity, DispatchingAndroidInjector<Fragment> paramDispatchingAndroidInjector) {
    paramDaggerAppCompatActivity.frameworkFragmentInjector = paramDispatchingAndroidInjector;
  }
  
  public static void injectSupportFragmentInjector(DaggerAppCompatActivity paramDaggerAppCompatActivity, DispatchingAndroidInjector<Fragment> paramDispatchingAndroidInjector) {
    paramDaggerAppCompatActivity.supportFragmentInjector = paramDispatchingAndroidInjector;
  }
  
  public void injectMembers(DaggerAppCompatActivity paramDaggerAppCompatActivity) {
    injectSupportFragmentInjector(paramDaggerAppCompatActivity, (DispatchingAndroidInjector<Fragment>)this.supportFragmentInjectorProvider.get());
    injectFrameworkFragmentInjector(paramDaggerAppCompatActivity, (DispatchingAndroidInjector<Fragment>)this.frameworkFragmentInjectorProvider.get());
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\support\DaggerAppCompatActivity_MembersInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */