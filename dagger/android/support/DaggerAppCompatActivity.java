package dagger.android.support;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import javax.inject.Inject;

public abstract class DaggerAppCompatActivity extends AppCompatActivity implements HasFragmentInjector, HasSupportFragmentInjector {
  @Inject
  DispatchingAndroidInjector<Fragment> frameworkFragmentInjector;
  
  @Inject
  DispatchingAndroidInjector<Fragment> supportFragmentInjector;
  
  public AndroidInjector<Fragment> fragmentInjector() {
    return (AndroidInjector<Fragment>)this.frameworkFragmentInjector;
  }
  
  protected void onCreate(@Nullable Bundle paramBundle) {
    AndroidInjection.inject((Activity)this);
    super.onCreate(paramBundle);
  }
  
  public AndroidInjector<Fragment> supportFragmentInjector() {
    return (AndroidInjector<Fragment>)this.supportFragmentInjector;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\support\DaggerAppCompatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */