package dagger.android.support;

import android.content.Context;
import android.support.v4.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Inject;

public abstract class DaggerFragment extends Fragment implements HasSupportFragmentInjector {
  @Inject
  DispatchingAndroidInjector<Fragment> childFragmentInjector;
  
  public void onAttach(Context paramContext) {
    AndroidSupportInjection.inject(this);
    super.onAttach(paramContext);
  }
  
  public AndroidInjector<Fragment> supportFragmentInjector() {
    return (AndroidInjector<Fragment>)this.childFragmentInjector;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\support\DaggerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */