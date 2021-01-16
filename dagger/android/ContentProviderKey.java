package dagger.android;

import android.content.ContentProvider;
import dagger.MapKey;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@MapKey
@Target({ElementType.METHOD})
public @interface ContentProviderKey {
  Class<? extends ContentProvider> value();
}


/* Location:              Y:\classes-dex2jar.jar!\dagger\android\ContentProviderKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */