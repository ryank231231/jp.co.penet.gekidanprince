package dagger.android.support;

import android.support.v4.app.Fragment;
import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.multibindings.Multibinds;
import java.util.Map;

@Module(includes = {AndroidInjectionModule.class})
public abstract class AndroidSupportInjectionModule {
  @Multibinds
  abstract Map<Class<? extends Fragment>, AndroidInjector.Factory<? extends Fragment>> supportFragmentInjectorFactories();
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\support\AndroidSupportInjectionModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */