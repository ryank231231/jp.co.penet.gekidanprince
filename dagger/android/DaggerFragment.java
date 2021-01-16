package dagger.android;

import android.app.Fragment;
import android.content.Context;
import javax.inject.Inject;

public abstract class DaggerFragment extends Fragment implements HasFragmentInjector {
  @Inject
  DispatchingAndroidInjector<Fragment> childFragmentInjector;
  
  public AndroidInjector<Fragment> fragmentInjector() {
    return (AndroidInjector<Fragment>)this.childFragmentInjector;
  }
  
  public void onAttach(Context paramContext) {
    AndroidInjection.inject(this);
    super.onAttach(paramContext);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\DaggerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */