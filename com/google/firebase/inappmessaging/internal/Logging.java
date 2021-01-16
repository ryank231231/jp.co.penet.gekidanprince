package com.google.firebase.inappmessaging.internal;

import android.util.Log;
import com.google.common.annotations.VisibleForTesting;

public class Logging {
  @VisibleForTesting
  public static final String TAG = "FIAM.Headless";
  
  public static void logd(String paramString) {
    if (Log.isLoggable("FIAM.Headless", 3))
      Log.d("FIAM.Headless", paramString); 
  }
  
  public static void loge(String paramString) {
    Log.e("FIAM.Headless", paramString);
  }
  
  public static void logi(String paramString) {
    if (Log.isLoggable("FIAM.Headless", 4))
      Log.i("FIAM.Headless", paramString); 
  }
  
  public static void logw(String paramString) {
    Log.w("FIAM.Headless", paramString);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\Logging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */