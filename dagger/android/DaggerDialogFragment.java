package dagger.android;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import javax.inject.Inject;

public abstract class DaggerDialogFragment extends DialogFragment implements HasFragmentInjector {
  @Inject
  DispatchingAndroidInjector<Fragment> childFragmentInjector;
  
  public AndroidInjector<Fragment> fragmentInjector() {
    return (AndroidInjector<Fragment>)this.childFragmentInjector;
  }
  
  public void onAttach(Context paramContext) {
    AndroidInjection.inject((Fragment)this);
    super.onAttach(paramContext);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\DaggerDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */