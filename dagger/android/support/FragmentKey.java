package dagger.android.support;

import android.support.v4.app.Fragment;
import dagger.MapKey;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@MapKey
@Target({ElementType.METHOD})
public @interface FragmentKey {
  Class<? extends Fragment> value();
}


/* Location:              Y:\classes-dex2jar.jar!\dagger\android\support\FragmentKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */