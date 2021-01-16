package dagger.android.support;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDialogFragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Inject;

public abstract class DaggerAppCompatDialogFragment extends AppCompatDialogFragment implements HasSupportFragmentInjector {
  @Inject
  DispatchingAndroidInjector<Fragment> childFragmentInjector;
  
  public void onAttach(Context paramContext) {
    AndroidSupportInjection.inject((Fragment)this);
    super.onAttach(paramContext);
  }
  
  public AndroidInjector<Fragment> supportFragmentInjector() {
    return (AndroidInjector<Fragment>)this.childFragmentInjector;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\support\DaggerAppCompatDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */