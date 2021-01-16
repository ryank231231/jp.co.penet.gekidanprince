package dagger.android.support;

import android.support.v4.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Inject;

public abstract class DaggerApplication extends DaggerApplication implements HasSupportFragmentInjector {
  @Inject
  DispatchingAndroidInjector<Fragment> supportFragmentInjector;
  
  protected abstract AndroidInjector<? extends DaggerApplication> applicationInjector();
  
  public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
    return this.supportFragmentInjector;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\dagger\android\support\DaggerApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */