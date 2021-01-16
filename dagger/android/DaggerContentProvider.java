package dagger.android;

import android.content.ContentProvider;
import android.support.annotation.CallSuper;

public abstract class DaggerContentProvider extends ContentProvider {
  @CallSuper
  public boolean onCreate() {
    AndroidInjection.inject(this);
    return true;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\DaggerContentProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */