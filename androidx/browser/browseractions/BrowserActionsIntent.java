package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrowserActionsIntent {
  public static final String ACTION_BROWSER_ACTIONS_OPEN = "androidx.browser.browseractions.browser_action_open";
  
  public static final String EXTRA_APP_ID = "androidx.browser.browseractions.APP_ID";
  
  public static final String EXTRA_MENU_ITEMS = "androidx.browser.browseractions.extra.MENU_ITEMS";
  
  public static final String EXTRA_SELECTED_ACTION_PENDING_INTENT = "androidx.browser.browseractions.extra.SELECTED_ACTION_PENDING_INTENT";
  
  public static final String EXTRA_TYPE = "androidx.browser.browseractions.extra.TYPE";
  
  public static final int ITEM_COPY = 3;
  
  public static final int ITEM_DOWNLOAD = 2;
  
  public static final int ITEM_INVALID_ITEM = -1;
  
  public static final int ITEM_OPEN_IN_INCOGNITO = 1;
  
  public static final int ITEM_OPEN_IN_NEW_TAB = 0;
  
  public static final int ITEM_SHARE = 4;
  
  public static final String KEY_ACTION = "androidx.browser.browseractions.ACTION";
  
  public static final String KEY_ICON_ID = "androidx.browser.browseractions.ICON_ID";
  
  public static final String KEY_TITLE = "androidx.browser.browseractions.TITLE";
  
  public static final int MAX_CUSTOM_ITEMS = 5;
  
  private static final String TAG = "BrowserActions";
  
  private static final String TEST_URL = "https://www.example.com";
  
  public static final int URL_TYPE_AUDIO = 3;
  
  public static final int URL_TYPE_FILE = 4;
  
  public static final int URL_TYPE_IMAGE = 1;
  
  public static final int URL_TYPE_NONE = 0;
  
  public static final int URL_TYPE_PLUGIN = 5;
  
  public static final int URL_TYPE_VIDEO = 2;
  
  private static BrowserActionsFallDialogListener sDialogListenter;
  
  @NonNull
  private final Intent mIntent;
  
  private BrowserActionsIntent(@NonNull Intent paramIntent) {
    this.mIntent = paramIntent;
  }
  
  private static List<ResolveInfo> getBrowserActionsIntentHandlers(Context paramContext) {
    Intent intent = new Intent("androidx.browser.browseractions.browser_action_open", Uri.parse("https://www.example.com"));
    return paramContext.getPackageManager().queryIntentActivities(intent, 131072);
  }
  
  public static String getCreatorPackageName(Intent paramIntent) {
    PendingIntent pendingIntent = (PendingIntent)paramIntent.getParcelableExtra("androidx.browser.browseractions.APP_ID");
    return (pendingIntent != null) ? ((Build.VERSION.SDK_INT >= 17) ? pendingIntent.getCreatorPackage() : pendingIntent.getTargetPackage()) : null;
  }
  
  public static void launchIntent(Context paramContext, Intent paramIntent) {
    launchIntent(paramContext, paramIntent, getBrowserActionsIntentHandlers(paramContext));
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  @VisibleForTesting
  static void launchIntent(Context paramContext, Intent paramIntent, List<ResolveInfo> paramList) {
    if (paramList == null || paramList.size() == 0) {
      openFallbackBrowserActionsMenu(paramContext, paramIntent);
      return;
    } 
    int i = paramList.size();
    byte b = 0;
    if (i == 1) {
      paramIntent.setPackage(((ResolveInfo)paramList.get(0)).activityInfo.packageName);
    } else {
      Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.example.com"));
      ResolveInfo resolveInfo = paramContext.getPackageManager().resolveActivity(intent, 65536);
      if (resolveInfo != null) {
        String str = resolveInfo.activityInfo.packageName;
        while (b < paramList.size()) {
          if (str.equals(((ResolveInfo)paramList.get(b)).activityInfo.packageName)) {
            paramIntent.setPackage(str);
            break;
          } 
          b++;
        } 
      } 
    } 
    ContextCompat.startActivity(paramContext, paramIntent, null);
  }
  
  public static void openBrowserAction(Context paramContext, Uri paramUri) {
    launchIntent(paramContext, (new Builder(paramContext, paramUri)).build().getIntent());
  }
  
  public static void openBrowserAction(Context paramContext, Uri paramUri, int paramInt, ArrayList<BrowserActionItem> paramArrayList, PendingIntent paramPendingIntent) {
    launchIntent(paramContext, (new Builder(paramContext, paramUri)).setUrlType(paramInt).setCustomItems(paramArrayList).setOnItemSelectedAction(paramPendingIntent).build().getIntent());
  }
  
  private static void openFallbackBrowserActionsMenu(Context paramContext, Intent paramIntent) {
    Uri uri = paramIntent.getData();
    int i = paramIntent.getIntExtra("androidx.browser.browseractions.extra.TYPE", 0);
    ArrayList<Bundle> arrayList = paramIntent.getParcelableArrayListExtra("androidx.browser.browseractions.extra.MENU_ITEMS");
    if (arrayList != null) {
      List<BrowserActionItem> list = parseBrowserActionItems(arrayList);
    } else {
      arrayList = null;
    } 
    openFallbackBrowserActionsMenu(paramContext, uri, i, (List)arrayList);
  }
  
  private static void openFallbackBrowserActionsMenu(Context paramContext, Uri paramUri, int paramInt, List<BrowserActionItem> paramList) {
    (new BrowserActionsFallbackMenuUi(paramContext, paramUri, paramList)).displayMenu();
    BrowserActionsFallDialogListener browserActionsFallDialogListener = sDialogListenter;
    if (browserActionsFallDialogListener != null)
      browserActionsFallDialogListener.onDialogShown(); 
  }
  
  public static List<BrowserActionItem> parseBrowserActionItems(ArrayList<Bundle> paramArrayList) {
    ArrayList<BrowserActionItem> arrayList = new ArrayList();
    byte b = 0;
    while (b < paramArrayList.size()) {
      Bundle bundle = paramArrayList.get(b);
      String str = bundle.getString("androidx.browser.browseractions.TITLE");
      PendingIntent pendingIntent = (PendingIntent)bundle.getParcelable("androidx.browser.browseractions.ACTION");
      int i = bundle.getInt("androidx.browser.browseractions.ICON_ID");
      if (!TextUtils.isEmpty(str) && pendingIntent != null) {
        arrayList.add(new BrowserActionItem(str, pendingIntent, i));
        b++;
        continue;
      } 
      throw new IllegalArgumentException("Custom item should contain a non-empty title and non-null intent.");
    } 
    return arrayList;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  @VisibleForTesting
  static void setDialogShownListenter(BrowserActionsFallDialogListener paramBrowserActionsFallDialogListener) {
    sDialogListenter = paramBrowserActionsFallDialogListener;
  }
  
  @NonNull
  public Intent getIntent() {
    return this.mIntent;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  @VisibleForTesting
  static interface BrowserActionsFallDialogListener {
    void onDialogShown();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface BrowserActionsItemId {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface BrowserActionsUrlType {}
  
  public static final class Builder {
    private Context mContext;
    
    private final Intent mIntent = new Intent("androidx.browser.browseractions.browser_action_open");
    
    private ArrayList<Bundle> mMenuItems = null;
    
    private PendingIntent mOnItemSelectedPendingIntent = null;
    
    private int mType;
    
    private Uri mUri;
    
    public Builder(Context param1Context, Uri param1Uri) {
      this.mContext = param1Context;
      this.mUri = param1Uri;
      this.mType = 0;
      this.mMenuItems = new ArrayList<Bundle>();
    }
    
    private Bundle getBundleFromItem(BrowserActionItem param1BrowserActionItem) {
      Bundle bundle = new Bundle();
      bundle.putString("androidx.browser.browseractions.TITLE", param1BrowserActionItem.getTitle());
      bundle.putParcelable("androidx.browser.browseractions.ACTION", (Parcelable)param1BrowserActionItem.getAction());
      if (param1BrowserActionItem.getIconId() != 0)
        bundle.putInt("androidx.browser.browseractions.ICON_ID", param1BrowserActionItem.getIconId()); 
      return bundle;
    }
    
    public BrowserActionsIntent build() {
      this.mIntent.setData(this.mUri);
      this.mIntent.putExtra("androidx.browser.browseractions.extra.TYPE", this.mType);
      this.mIntent.putParcelableArrayListExtra("androidx.browser.browseractions.extra.MENU_ITEMS", this.mMenuItems);
      PendingIntent pendingIntent = PendingIntent.getActivity(this.mContext, 0, new Intent(), 0);
      this.mIntent.putExtra("androidx.browser.browseractions.APP_ID", (Parcelable)pendingIntent);
      pendingIntent = this.mOnItemSelectedPendingIntent;
      if (pendingIntent != null)
        this.mIntent.putExtra("androidx.browser.browseractions.extra.SELECTED_ACTION_PENDING_INTENT", (Parcelable)pendingIntent); 
      return new BrowserActionsIntent(this.mIntent);
    }
    
    public Builder setCustomItems(ArrayList<BrowserActionItem> param1ArrayList) {
      if (param1ArrayList.size() <= 5) {
        byte b = 0;
        while (b < param1ArrayList.size()) {
          if (!TextUtils.isEmpty(((BrowserActionItem)param1ArrayList.get(b)).getTitle()) && ((BrowserActionItem)param1ArrayList.get(b)).getAction() != null) {
            this.mMenuItems.add(getBundleFromItem(param1ArrayList.get(b)));
            b++;
            continue;
          } 
          throw new IllegalArgumentException("Custom item should contain a non-empty title and non-null intent.");
        } 
        return this;
      } 
      throw new IllegalStateException("Exceeded maximum toolbar item count of 5");
    }
    
    public Builder setCustomItems(BrowserActionItem... param1VarArgs) {
      return setCustomItems(new ArrayList<BrowserActionItem>(Arrays.asList(param1VarArgs)));
    }
    
    public Builder setOnItemSelectedAction(PendingIntent param1PendingIntent) {
      this.mOnItemSelectedPendingIntent = param1PendingIntent;
      return this;
    }
    
    public Builder setUrlType(int param1Int) {
      this.mType = param1Int;
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\androidx\browser\browseractions\BrowserActionsIntent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */