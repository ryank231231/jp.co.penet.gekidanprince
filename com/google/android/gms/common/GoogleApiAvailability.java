package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.GuardedBy;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.base.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabr;
import com.google.android.gms.common.api.internal.zabu;
import com.google.android.gms.common.internal.ConnectionErrorMessages;
import com.google.android.gms.common.internal.DialogRedirect;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.base.zal;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;

public class GoogleApiAvailability extends GoogleApiAvailabilityLight {
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
  
  private static final Object mLock = new Object();
  
  private static final GoogleApiAvailability zaao = new GoogleApiAvailability();
  
  @GuardedBy("mLock")
  private String zaap;
  
  static {
    GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  }
  
  public static GoogleApiAvailability getInstance() {
    return zaao;
  }
  
  public static Dialog zaa(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener) {
    ProgressBar progressBar = new ProgressBar((Context)paramActivity, null, 16842874);
    progressBar.setIndeterminate(true);
    progressBar.setVisibility(0);
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)paramActivity);
    builder.setView((View)progressBar);
    builder.setMessage(ConnectionErrorMessages.getErrorMessage((Context)paramActivity, 18));
    builder.setPositiveButton("", null);
    AlertDialog alertDialog = builder.create();
    zaa(paramActivity, (Dialog)alertDialog, "GooglePlayServicesUpdatingDialog", paramOnCancelListener);
    return (Dialog)alertDialog;
  }
  
  static Dialog zaa(Context paramContext, int paramInt, DialogRedirect paramDialogRedirect, DialogInterface.OnCancelListener paramOnCancelListener) {
    AlertDialog.Builder builder1 = null;
    if (paramInt == 0)
      return null; 
    TypedValue typedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(16843529, typedValue, true);
    if ("Theme.Dialog.Alert".equals(paramContext.getResources().getResourceEntryName(typedValue.resourceId)))
      builder1 = new AlertDialog.Builder(paramContext, 5); 
    AlertDialog.Builder builder2 = builder1;
    if (builder1 == null)
      builder2 = new AlertDialog.Builder(paramContext); 
    builder2.setMessage(ConnectionErrorMessages.getErrorMessage(paramContext, paramInt));
    if (paramOnCancelListener != null)
      builder2.setOnCancelListener(paramOnCancelListener); 
    String str2 = ConnectionErrorMessages.getErrorDialogButtonMessage(paramContext, paramInt);
    if (str2 != null)
      builder2.setPositiveButton(str2, (DialogInterface.OnClickListener)paramDialogRedirect); 
    String str1 = ConnectionErrorMessages.getErrorTitle(paramContext, paramInt);
    if (str1 != null)
      builder2.setTitle(str1); 
    return (Dialog)builder2.create();
  }
  
  static void zaa(Activity paramActivity, Dialog paramDialog, String paramString, DialogInterface.OnCancelListener paramOnCancelListener) {
    FragmentManager fragmentManager1;
    if (paramActivity instanceof FragmentActivity) {
      fragmentManager1 = ((FragmentActivity)paramActivity).getSupportFragmentManager();
      SupportErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(fragmentManager1, paramString);
      return;
    } 
    FragmentManager fragmentManager = fragmentManager1.getFragmentManager();
    ErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(fragmentManager, paramString);
  }
  
  @TargetApi(20)
  private final void zaa(Context paramContext, int paramInt, String paramString, PendingIntent paramPendingIntent) {
    if (paramInt == 18) {
      zaa(paramContext);
      return;
    } 
    if (paramPendingIntent == null) {
      if (paramInt == 6)
        Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead."); 
      return;
    } 
    String str1 = ConnectionErrorMessages.getErrorNotificationTitle(paramContext, paramInt);
    String str2 = ConnectionErrorMessages.getErrorNotificationMessage(paramContext, paramInt);
    Resources resources = paramContext.getResources();
    NotificationManager notificationManager = (NotificationManager)paramContext.getSystemService("notification");
    NotificationCompat.Builder builder = (new NotificationCompat.Builder(paramContext)).setLocalOnly(true).setAutoCancel(true).setContentTitle(str1).setStyle((NotificationCompat.Style)(new NotificationCompat.BigTextStyle()).bigText(str2));
    if (DeviceProperties.isWearable(paramContext)) {
      Preconditions.checkState(PlatformVersion.isAtLeastKitKatWatch());
      builder.setSmallIcon((paramContext.getApplicationInfo()).icon).setPriority(2);
      if (DeviceProperties.isWearableWithoutPlayStore(paramContext)) {
        builder.addAction(R.drawable.common_full_open_on_phone, resources.getString(R.string.common_open_on_phone), paramPendingIntent);
      } else {
        builder.setContentIntent(paramPendingIntent);
      } 
    } else {
      builder.setSmallIcon(17301642).setTicker(resources.getString(R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(paramPendingIntent).setContentText(str2);
    } 
    if (PlatformVersion.isAtLeastO()) {
      Preconditions.checkState(PlatformVersion.isAtLeastO());
      String str4 = zag();
      String str3 = str4;
      if (str4 == null) {
        str4 = "com.google.android.gms.availability";
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
        String str = ConnectionErrorMessages.getDefaultNotificationChannelName(paramContext);
        if (notificationChannel == null) {
          notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", str, 4));
          str3 = str4;
        } else {
          str3 = str4;
          if (!str.equals(notificationChannel.getName())) {
            notificationChannel.setName(str);
            notificationManager.createNotificationChannel(notificationChannel);
            str3 = str4;
          } 
        } 
      } 
      builder.setChannelId(str3);
    } 
    Notification notification = builder.build();
    switch (paramInt) {
      default:
        paramInt = 39789;
        break;
      case 1:
      case 2:
      case 3:
        paramInt = 10436;
        GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.set(false);
        break;
    } 
    notificationManager.notify(paramInt, notification);
  }
  
  @VisibleForTesting(otherwise = 2)
  private final String zag() {
    synchronized (mLock) {
      return this.zaap;
    } 
  }
  
  public Task<Void> checkApiAvailability(GoogleApi<?> paramGoogleApi, GoogleApi<?>... paramVarArgs) {
    Preconditions.checkNotNull(paramGoogleApi, "Requested API must not be null.");
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      Preconditions.checkNotNull(paramVarArgs[b], "Requested API must not be null."); 
    ArrayList<GoogleApi<?>> arrayList = new ArrayList(paramVarArgs.length + 1);
    arrayList.add(paramGoogleApi);
    arrayList.addAll(Arrays.asList(paramVarArgs));
    return GoogleApiManager.zabc().zaa(arrayList).continueWith(new zaa(this));
  }
  
  @KeepForSdk
  @ShowFirstParty
  public int getClientVersion(Context paramContext) {
    return super.getClientVersion(paramContext);
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2) {
    return getErrorDialog(paramActivity, paramInt1, paramInt2, null);
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener) {
    return zaa((Context)paramActivity, paramInt1, DialogRedirect.getInstance(paramActivity, getErrorResolutionIntent((Context)paramActivity, paramInt1, "d"), paramInt2), paramOnCancelListener);
  }
  
  @Nullable
  @KeepForSdk
  @ShowFirstParty
  public Intent getErrorResolutionIntent(Context paramContext, int paramInt, @Nullable String paramString) {
    return super.getErrorResolutionIntent(paramContext, paramInt, paramString);
  }
  
  @Nullable
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2) {
    return super.getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  @Nullable
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, ConnectionResult paramConnectionResult) {
    return paramConnectionResult.hasResolution() ? paramConnectionResult.getResolution() : getErrorResolutionPendingIntent(paramContext, paramConnectionResult.getErrorCode(), 0);
  }
  
  public final String getErrorString(int paramInt) {
    return super.getErrorString(paramInt);
  }
  
  @HideFirstParty
  public int isGooglePlayServicesAvailable(Context paramContext) {
    return super.isGooglePlayServicesAvailable(paramContext);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public int isGooglePlayServicesAvailable(Context paramContext, int paramInt) {
    return super.isGooglePlayServicesAvailable(paramContext, paramInt);
  }
  
  public final boolean isUserResolvableError(int paramInt) {
    return super.isUserResolvableError(paramInt);
  }
  
  @MainThread
  public Task<Void> makeGooglePlayServicesAvailable(Activity paramActivity) {
    int i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
    Preconditions.checkMainThread("makeGooglePlayServicesAvailable must be called from the main thread");
    i = isGooglePlayServicesAvailable((Context)paramActivity, i);
    if (i == 0)
      return Tasks.forResult(null); 
    zabu zabu = zabu.zac(paramActivity);
    zabu.zab(new ConnectionResult(i, null), 0);
    return zabu.getTask();
  }
  
  @TargetApi(26)
  public void setDefaultNotificationChannelId(@NonNull Context paramContext, @NonNull String paramString) {
    if (PlatformVersion.isAtLeastO())
      Preconditions.checkNotNull(((NotificationManager)paramContext.getSystemService("notification")).getNotificationChannel(paramString)); 
    synchronized (mLock) {
      this.zaap = paramString;
      return;
    } 
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2) {
    return showErrorDialogFragment(paramActivity, paramInt1, paramInt2, null);
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener) {
    Dialog dialog = getErrorDialog(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
    if (dialog == null)
      return false; 
    zaa(paramActivity, dialog, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public void showErrorNotification(Context paramContext, int paramInt) {
    zaa(paramContext, paramInt, (String)null, getErrorResolutionPendingIntent(paramContext, paramInt, 0, "n"));
  }
  
  public void showErrorNotification(Context paramContext, ConnectionResult paramConnectionResult) {
    PendingIntent pendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    zaa(paramContext, paramConnectionResult.getErrorCode(), (String)null, pendingIntent);
  }
  
  @Nullable
  public final zabq zaa(Context paramContext, zabr paramzabr) {
    IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    intentFilter.addDataScheme("package");
    zabq zabq = new zabq(paramzabr);
    paramContext.registerReceiver((BroadcastReceiver)zabq, intentFilter);
    zabq.zac(paramContext);
    if (!isUninstalledAppPossiblyUpdating(paramContext, "com.google.android.gms")) {
      paramzabr.zas();
      zabq.unregister();
      return null;
    } 
    return zabq;
  }
  
  final void zaa(Context paramContext) {
    (new zaa(this, paramContext)).sendEmptyMessageDelayed(1, 120000L);
  }
  
  public final boolean zaa(Activity paramActivity, @NonNull LifecycleFragment paramLifecycleFragment, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener) {
    Dialog dialog = zaa((Context)paramActivity, paramInt1, DialogRedirect.getInstance(paramLifecycleFragment, getErrorResolutionIntent((Context)paramActivity, paramInt1, "d"), 2), paramOnCancelListener);
    if (dialog == null)
      return false; 
    zaa(paramActivity, dialog, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public final boolean zaa(Context paramContext, ConnectionResult paramConnectionResult, int paramInt) {
    PendingIntent pendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    if (pendingIntent != null) {
      zaa(paramContext, paramConnectionResult.getErrorCode(), (String)null, GoogleApiActivity.zaa(paramContext, pendingIntent, paramInt));
      return true;
    } 
    return false;
  }
  
  @SuppressLint({"HandlerLeak"})
  private final class zaa extends zal {
    private final Context zaaq;
    
    public zaa(GoogleApiAvailability this$0, Context param1Context) {
      super(looper);
      Looper looper;
      this.zaaq = param1Context.getApplicationContext();
    }
    
    public final void handleMessage(Message param1Message) {
      if (param1Message.what != 1) {
        int i = param1Message.what;
        StringBuilder stringBuilder = new StringBuilder(50);
        stringBuilder.append("Don't know how to handle this message: ");
        stringBuilder.append(i);
        Log.w("GoogleApiAvailability", stringBuilder.toString());
      } else {
        int i = this.zaar.isGooglePlayServicesAvailable(this.zaaq);
        if (this.zaar.isUserResolvableError(i)) {
          this.zaar.showErrorNotification(this.zaaq, i);
          return;
        } 
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\GoogleApiAvailability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */