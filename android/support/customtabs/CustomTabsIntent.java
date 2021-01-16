package android.support.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.annotation.AnimRes;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.BundleCompat;
import android.support.v4.content.ContextCompat;
import android.widget.RemoteViews;
import java.util.ArrayList;

public final class CustomTabsIntent {
  public static final String EXTRA_ACTION_BUTTON_BUNDLE = "android.support.customtabs.extra.ACTION_BUTTON_BUNDLE";
  
  public static final String EXTRA_CLOSE_BUTTON_ICON = "android.support.customtabs.extra.CLOSE_BUTTON_ICON";
  
  public static final String EXTRA_DEFAULT_SHARE_MENU_ITEM = "android.support.customtabs.extra.SHARE_MENU_ITEM";
  
  public static final String EXTRA_ENABLE_INSTANT_APPS = "android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS";
  
  public static final String EXTRA_ENABLE_URLBAR_HIDING = "android.support.customtabs.extra.ENABLE_URLBAR_HIDING";
  
  public static final String EXTRA_EXIT_ANIMATION_BUNDLE = "android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE";
  
  public static final String EXTRA_MENU_ITEMS = "android.support.customtabs.extra.MENU_ITEMS";
  
  public static final String EXTRA_REMOTEVIEWS = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS";
  
  public static final String EXTRA_REMOTEVIEWS_CLICKED_ID = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_CLICKED_ID";
  
  public static final String EXTRA_REMOTEVIEWS_PENDINGINTENT = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_PENDINGINTENT";
  
  public static final String EXTRA_REMOTEVIEWS_VIEW_IDS = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_VIEW_IDS";
  
  public static final String EXTRA_SECONDARY_TOOLBAR_COLOR = "android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR";
  
  public static final String EXTRA_SESSION = "android.support.customtabs.extra.SESSION";
  
  public static final String EXTRA_TINT_ACTION_BUTTON = "android.support.customtabs.extra.TINT_ACTION_BUTTON";
  
  public static final String EXTRA_TITLE_VISIBILITY_STATE = "android.support.customtabs.extra.TITLE_VISIBILITY";
  
  public static final String EXTRA_TOOLBAR_COLOR = "android.support.customtabs.extra.TOOLBAR_COLOR";
  
  public static final String EXTRA_TOOLBAR_ITEMS = "android.support.customtabs.extra.TOOLBAR_ITEMS";
  
  private static final String EXTRA_USER_OPT_OUT_FROM_CUSTOM_TABS = "android.support.customtabs.extra.user_opt_out";
  
  public static final String KEY_DESCRIPTION = "android.support.customtabs.customaction.DESCRIPTION";
  
  public static final String KEY_ICON = "android.support.customtabs.customaction.ICON";
  
  public static final String KEY_ID = "android.support.customtabs.customaction.ID";
  
  public static final String KEY_MENU_ITEM_TITLE = "android.support.customtabs.customaction.MENU_ITEM_TITLE";
  
  public static final String KEY_PENDING_INTENT = "android.support.customtabs.customaction.PENDING_INTENT";
  
  private static final int MAX_TOOLBAR_ITEMS = 5;
  
  public static final int NO_TITLE = 0;
  
  public static final int SHOW_PAGE_TITLE = 1;
  
  public static final int TOOLBAR_ACTION_BUTTON_ID = 0;
  
  @NonNull
  public final Intent intent;
  
  @Nullable
  public final Bundle startAnimationBundle;
  
  private CustomTabsIntent(Intent paramIntent, Bundle paramBundle) {
    this.intent = paramIntent;
    this.startAnimationBundle = paramBundle;
  }
  
  public static int getMaxToolbarItems() {
    return 5;
  }
  
  public static Intent setAlwaysUseBrowserUI(Intent paramIntent) {
    Intent intent = paramIntent;
    if (paramIntent == null)
      intent = new Intent("android.intent.action.VIEW"); 
    intent.addFlags(268435456);
    intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
    return intent;
  }
  
  public static boolean shouldAlwaysUseBrowserUI(Intent paramIntent) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramIntent.getBooleanExtra("android.support.customtabs.extra.user_opt_out", false)) {
      bool2 = bool1;
      if ((paramIntent.getFlags() & 0x10000000) != 0)
        bool2 = true; 
    } 
    return bool2;
  }
  
  public void launchUrl(Context paramContext, Uri paramUri) {
    this.intent.setData(paramUri);
    ContextCompat.startActivity(paramContext, this.intent, this.startAnimationBundle);
  }
  
  public static final class Builder {
    private ArrayList<Bundle> mActionButtons;
    
    private boolean mInstantAppsEnabled;
    
    private final Intent mIntent;
    
    private ArrayList<Bundle> mMenuItems;
    
    private Bundle mStartAnimationBundle;
    
    public Builder() {
      this(null);
    }
    
    public Builder(@Nullable CustomTabsSession param1CustomTabsSession) {
      IBinder iBinder;
      this.mIntent = new Intent("android.intent.action.VIEW");
      CustomTabsSession customTabsSession = null;
      this.mMenuItems = null;
      this.mStartAnimationBundle = null;
      this.mActionButtons = null;
      this.mInstantAppsEnabled = true;
      if (param1CustomTabsSession != null)
        this.mIntent.setPackage(param1CustomTabsSession.getComponentName().getPackageName()); 
      Bundle bundle = new Bundle();
      if (param1CustomTabsSession == null) {
        param1CustomTabsSession = customTabsSession;
      } else {
        iBinder = param1CustomTabsSession.getBinder();
      } 
      BundleCompat.putBinder(bundle, "android.support.customtabs.extra.SESSION", iBinder);
      this.mIntent.putExtras(bundle);
    }
    
    public Builder addDefaultShareMenuItem() {
      this.mIntent.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", true);
      return this;
    }
    
    public Builder addMenuItem(@NonNull String param1String, @NonNull PendingIntent param1PendingIntent) {
      if (this.mMenuItems == null)
        this.mMenuItems = new ArrayList<Bundle>(); 
      Bundle bundle = new Bundle();
      bundle.putString("android.support.customtabs.customaction.MENU_ITEM_TITLE", param1String);
      bundle.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", (Parcelable)param1PendingIntent);
      this.mMenuItems.add(bundle);
      return this;
    }
    
    @Deprecated
    public Builder addToolbarItem(int param1Int, @NonNull Bitmap param1Bitmap, @NonNull String param1String, PendingIntent param1PendingIntent) throws IllegalStateException {
      if (this.mActionButtons == null)
        this.mActionButtons = new ArrayList<Bundle>(); 
      if (this.mActionButtons.size() < 5) {
        Bundle bundle = new Bundle();
        bundle.putInt("android.support.customtabs.customaction.ID", param1Int);
        bundle.putParcelable("android.support.customtabs.customaction.ICON", (Parcelable)param1Bitmap);
        bundle.putString("android.support.customtabs.customaction.DESCRIPTION", param1String);
        bundle.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", (Parcelable)param1PendingIntent);
        this.mActionButtons.add(bundle);
        return this;
      } 
      throw new IllegalStateException("Exceeded maximum toolbar item count of 5");
    }
    
    public CustomTabsIntent build() {
      ArrayList<Bundle> arrayList = this.mMenuItems;
      if (arrayList != null)
        this.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList); 
      arrayList = this.mActionButtons;
      if (arrayList != null)
        this.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList); 
      this.mIntent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.mInstantAppsEnabled);
      return new CustomTabsIntent(this.mIntent, this.mStartAnimationBundle);
    }
    
    public Builder enableUrlBarHiding() {
      this.mIntent.putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", true);
      return this;
    }
    
    public Builder setActionButton(@NonNull Bitmap param1Bitmap, @NonNull String param1String, @NonNull PendingIntent param1PendingIntent) {
      return setActionButton(param1Bitmap, param1String, param1PendingIntent, false);
    }
    
    public Builder setActionButton(@NonNull Bitmap param1Bitmap, @NonNull String param1String, @NonNull PendingIntent param1PendingIntent, boolean param1Boolean) {
      Bundle bundle = new Bundle();
      bundle.putInt("android.support.customtabs.customaction.ID", 0);
      bundle.putParcelable("android.support.customtabs.customaction.ICON", (Parcelable)param1Bitmap);
      bundle.putString("android.support.customtabs.customaction.DESCRIPTION", param1String);
      bundle.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", (Parcelable)param1PendingIntent);
      this.mIntent.putExtra("android.support.customtabs.extra.ACTION_BUTTON_BUNDLE", bundle);
      this.mIntent.putExtra("android.support.customtabs.extra.TINT_ACTION_BUTTON", param1Boolean);
      return this;
    }
    
    public Builder setCloseButtonIcon(@NonNull Bitmap param1Bitmap) {
      this.mIntent.putExtra("android.support.customtabs.extra.CLOSE_BUTTON_ICON", (Parcelable)param1Bitmap);
      return this;
    }
    
    public Builder setExitAnimations(@NonNull Context param1Context, @AnimRes int param1Int1, @AnimRes int param1Int2) {
      Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(param1Context, param1Int1, param1Int2).toBundle();
      this.mIntent.putExtra("android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE", bundle);
      return this;
    }
    
    public Builder setInstantAppsEnabled(boolean param1Boolean) {
      this.mInstantAppsEnabled = param1Boolean;
      return this;
    }
    
    public Builder setSecondaryToolbarColor(@ColorInt int param1Int) {
      this.mIntent.putExtra("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", param1Int);
      return this;
    }
    
    public Builder setSecondaryToolbarViews(@NonNull RemoteViews param1RemoteViews, @Nullable int[] param1ArrayOfint, @Nullable PendingIntent param1PendingIntent) {
      this.mIntent.putExtra("android.support.customtabs.extra.EXTRA_REMOTEVIEWS", (Parcelable)param1RemoteViews);
      this.mIntent.putExtra("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_VIEW_IDS", param1ArrayOfint);
      this.mIntent.putExtra("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_PENDINGINTENT", (Parcelable)param1PendingIntent);
      return this;
    }
    
    public Builder setShowTitle(boolean param1Boolean) {
      this.mIntent.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", param1Boolean);
      return this;
    }
    
    public Builder setStartAnimations(@NonNull Context param1Context, @AnimRes int param1Int1, @AnimRes int param1Int2) {
      this.mStartAnimationBundle = ActivityOptionsCompat.makeCustomAnimation(param1Context, param1Int1, param1Int2).toBundle();
      return this;
    }
    
    public Builder setToolbarColor(@ColorInt int param1Int) {
      this.mIntent.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", param1Int);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\customtabs\CustomTabsIntent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */