package com.google.firebase.inappmessaging.display.internal;

import android.util.Log;

public class Logging {
  private static final String TAG = "FIAM.Display";
  
  public static void logd(String paramString) {
    if (Log.isLoggable("FIAM.Display", 3))
      Log.d("FIAM.Display", paramString); 
  }
  
  public static void logdHeader(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("============ ");
    stringBuilder.append(paramString);
    stringBuilder.append(" ============");
    logd(stringBuilder.toString());
  }
  
  public static void logdNumber(String paramString, float paramFloat) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(": ");
    stringBuilder.append(paramFloat);
    logd(stringBuilder.toString());
  }
  
  public static void logdPair(String paramString, float paramFloat1, float paramFloat2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(": (");
    stringBuilder.append(paramFloat1);
    stringBuilder.append(", ");
    stringBuilder.append(paramFloat2);
    stringBuilder.append(")");
    logd(stringBuilder.toString());
  }
  
  public static void loge(String paramString) {
    Log.e("FIAM.Display", paramString);
  }
  
  public static void logi(String paramString) {
    if (Log.isLoggable("FIAM.Display", 4))
      Log.i("FIAM.Display", paramString); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\Logging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */