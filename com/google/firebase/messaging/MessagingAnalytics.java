package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;

@KeepForSdk
public class MessagingAnalytics {
  @KeepForSdk
  public static void logNotificationDismiss(Intent paramIntent) {
    zza("_nd", paramIntent);
  }
  
  @KeepForSdk
  public static void logNotificationForeground(Intent paramIntent) {
    zza("_nf", paramIntent);
  }
  
  @KeepForSdk
  public static void logNotificationOpen(Intent paramIntent) {
    if (paramIntent != null)
      if ("1".equals(paramIntent.getStringExtra("google.c.a.tc"))) {
        AnalyticsConnector analyticsConnector = (AnalyticsConnector)FirebaseApp.getInstance().get(AnalyticsConnector.class);
        if (Log.isLoggable("FirebaseMessaging", 3))
          Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event"); 
        if (analyticsConnector != null) {
          String str = paramIntent.getStringExtra("google.c.a.c_id");
          analyticsConnector.setUserProperty("fcm", "_ln", str);
          Bundle bundle = new Bundle();
          bundle.putString("source", "Firebase");
          bundle.putString("medium", "notification");
          bundle.putString("campaign", str);
          analyticsConnector.logEvent("fcm", "_cmp", bundle);
        } else {
          Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
        } 
      } else if (Log.isLoggable("FirebaseMessaging", 3)) {
        Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
      }  
    zza("_no", paramIntent);
  }
  
  @KeepForSdk
  public static void logNotificationReceived(Intent paramIntent) {
    zza("_nr", paramIntent);
  }
  
  @KeepForSdk
  public static boolean shouldUploadMetrics(Intent paramIntent) {
    return (paramIntent == null) ? false : ("com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(paramIntent.getAction()) ? false : "1".equals(paramIntent.getStringExtra("google.c.a.e")));
  }
  
  private static void zza(String paramString, Intent paramIntent) {
    Bundle bundle = new Bundle();
    String str = paramIntent.getStringExtra("google.c.a.c_id");
    if (str != null)
      bundle.putString("_nmid", str); 
    str = paramIntent.getStringExtra("google.c.a.c_l");
    if (str != null)
      bundle.putString("_nmn", str); 
    str = paramIntent.getStringExtra("google.c.a.m_l");
    if (!TextUtils.isEmpty(str))
      bundle.putString("label", str); 
    str = paramIntent.getStringExtra("google.c.a.m_c");
    if (!TextUtils.isEmpty(str))
      bundle.putString("message_channel", str); 
    str = paramIntent.getStringExtra("from");
    if (str == null || !str.startsWith("/topics/"))
      str = null; 
    if (str != null)
      bundle.putString("_nt", str); 
    if (paramIntent.hasExtra("google.c.a.ts"))
      try {
        bundle.putInt("_nmt", Integer.parseInt(paramIntent.getStringExtra("google.c.a.ts")));
      } catch (NumberFormatException numberFormatException) {
        Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", numberFormatException);
      }  
    if (paramIntent.hasExtra("google.c.a.udt"))
      try {
        bundle.putInt("_ndt", Integer.parseInt(paramIntent.getStringExtra("google.c.a.udt")));
      } catch (NumberFormatException numberFormatException) {
        Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", numberFormatException);
      }  
    if (Log.isLoggable("FirebaseMessaging", 3)) {
      String str1 = String.valueOf(bundle);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 22 + String.valueOf(str1).length());
      stringBuilder.append("Sending event=");
      stringBuilder.append(paramString);
      stringBuilder.append(" params=");
      stringBuilder.append(str1);
      Log.d("FirebaseMessaging", stringBuilder.toString());
    } 
    AnalyticsConnector analyticsConnector = (AnalyticsConnector)FirebaseApp.getInstance().get(AnalyticsConnector.class);
    if (analyticsConnector != null) {
      analyticsConnector.logEvent("fcm", paramString, bundle);
      return;
    } 
    Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\messaging\MessagingAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */