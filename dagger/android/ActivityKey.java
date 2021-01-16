package dagger.android;

import android.app.Activity;
import dagger.MapKey;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@MapKey
@Target({ElementType.METHOD})
public @interface ActivityKey {
  Class<? extends Activity> value();
}


/* Location:              Y:\classes-dex2jar.jar!\dagger\android\ActivityKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */