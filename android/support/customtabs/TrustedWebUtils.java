package android.support.customtabs;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.BundleCompat;

public class TrustedWebUtils {
  public static final String EXTRA_LAUNCH_AS_TRUSTED_WEB_ACTIVITY = "android.support.customtabs.extra.LAUNCH_AS_TRUSTED_WEB_ACTIVITY";
  
  public static void launchAsTrustedWebActivity(@NonNull Context paramContext, @NonNull CustomTabsIntent paramCustomTabsIntent, @NonNull Uri paramUri) {
    if (BundleCompat.getBinder(paramCustomTabsIntent.intent.getExtras(), "android.support.customtabs.extra.SESSION") != null) {
      paramCustomTabsIntent.intent.putExtra("android.support.customtabs.extra.LAUNCH_AS_TRUSTED_WEB_ACTIVITY", true);
      paramCustomTabsIntent.launchUrl(paramContext, paramUri);
      return;
    } 
    throw new IllegalArgumentException("Given CustomTabsIntent should be associated with a valid CustomTabsSession");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\customtabs\TrustedWebUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */