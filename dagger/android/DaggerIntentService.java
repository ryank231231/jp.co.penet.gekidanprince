package dagger.android;

import android.app.IntentService;
import android.app.Service;

public abstract class DaggerIntentService extends IntentService {
  public DaggerIntentService(String paramString) {
    super(paramString);
  }
  
  public void onCreate() {
    AndroidInjection.inject((Service)this);
    super.onCreate();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\DaggerIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */