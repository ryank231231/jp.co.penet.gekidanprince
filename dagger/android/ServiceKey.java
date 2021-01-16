package dagger.android;

import android.app.Service;
import dagger.MapKey;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@MapKey
@Target({ElementType.METHOD})
public @interface ServiceKey {
  Class<? extends Service> value();
}


/* Location:              Y:\classes-dex2jar.jar!\dagger\android\ServiceKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */