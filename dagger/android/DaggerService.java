package dagger.android;

import android.app.Service;

public abstract class DaggerService extends Service {
  public void onCreate() {
    AndroidInjection.inject(this);
    super.onCreate();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\DaggerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */