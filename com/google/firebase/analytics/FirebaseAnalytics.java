package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.annotation.Size;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.measurement.internal.zzby;
import com.google.android.gms.measurement.internal.zzdy;
import com.google.android.gms.measurement.internal.zzq;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.concurrent.ExecutorService;

public final class FirebaseAnalytics {
  private static volatile FirebaseAnalytics zzaam;
  
  private final zzaa zzaan;
  
  private String zzaao;
  
  private long zzaap;
  
  private final Object zzaaq;
  
  private ExecutorService zzab;
  
  private final zzby zzl;
  
  private final boolean zzn;
  
  private FirebaseAnalytics(zzaa paramzzaa) {
    Preconditions.checkNotNull(paramzzaa);
    this.zzl = null;
    this.zzaan = paramzzaa;
    this.zzn = true;
    this.zzaaq = new Object();
  }
  
  private FirebaseAnalytics(zzby paramzzby) {
    Preconditions.checkNotNull(paramzzby);
    this.zzl = paramzzby;
    this.zzaan = null;
    this.zzn = false;
    this.zzaaq = new Object();
  }
  
  @Keep
  @NonNull
  @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
  public static FirebaseAnalytics getInstance(@NonNull Context paramContext) {
    // Byte code:
    //   0: getstatic com/google/firebase/analytics/FirebaseAnalytics.zzaam : Lcom/google/firebase/analytics/FirebaseAnalytics;
    //   3: ifnonnull -> 74
    //   6: ldc com/google/firebase/analytics/FirebaseAnalytics
    //   8: monitorenter
    //   9: getstatic com/google/firebase/analytics/FirebaseAnalytics.zzaam : Lcom/google/firebase/analytics/FirebaseAnalytics;
    //   12: ifnonnull -> 62
    //   15: aload_0
    //   16: invokestatic zzf : (Landroid/content/Context;)Z
    //   19: ifeq -> 43
    //   22: aload_0
    //   23: invokestatic zza : (Landroid/content/Context;)Lcom/google/android/gms/internal/measurement/zzaa;
    //   26: astore_1
    //   27: new com/google/firebase/analytics/FirebaseAnalytics
    //   30: astore_0
    //   31: aload_0
    //   32: aload_1
    //   33: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzaa;)V
    //   36: aload_0
    //   37: putstatic com/google/firebase/analytics/FirebaseAnalytics.zzaam : Lcom/google/firebase/analytics/FirebaseAnalytics;
    //   40: goto -> 62
    //   43: aload_0
    //   44: aconst_null
    //   45: invokestatic zza : (Landroid/content/Context;Lcom/google/android/gms/internal/measurement/zzy;)Lcom/google/android/gms/measurement/internal/zzby;
    //   48: astore_0
    //   49: new com/google/firebase/analytics/FirebaseAnalytics
    //   52: astore_1
    //   53: aload_1
    //   54: aload_0
    //   55: invokespecial <init> : (Lcom/google/android/gms/measurement/internal/zzby;)V
    //   58: aload_1
    //   59: putstatic com/google/firebase/analytics/FirebaseAnalytics.zzaam : Lcom/google/firebase/analytics/FirebaseAnalytics;
    //   62: ldc com/google/firebase/analytics/FirebaseAnalytics
    //   64: monitorexit
    //   65: goto -> 74
    //   68: astore_0
    //   69: ldc com/google/firebase/analytics/FirebaseAnalytics
    //   71: monitorexit
    //   72: aload_0
    //   73: athrow
    //   74: getstatic com/google/firebase/analytics/FirebaseAnalytics.zzaam : Lcom/google/firebase/analytics/FirebaseAnalytics;
    //   77: areturn
    // Exception table:
    //   from	to	target	type
    //   9	40	68	finally
    //   43	62	68	finally
    //   62	65	68	finally
    //   69	72	68	finally
  }
  
  @Keep
  public static zzdy getScionFrontendApiImplementation(Context paramContext, Bundle paramBundle) {
    if (!zzaa.zzf(paramContext))
      return null; 
    zzaa zzaa1 = zzaa.zza(paramContext, null, null, null, paramBundle);
    return (zzaa1 == null) ? null : new zzb(zzaa1);
  }
  
  private final void zzbi(String paramString) {
    synchronized (this.zzaaq) {
      this.zzaao = paramString;
      if (this.zzn) {
        this.zzaap = DefaultClock.getInstance().elapsedRealtime();
      } else {
        this.zzaap = this.zzl.zzz().elapsedRealtime();
      } 
      return;
    } 
  }
  
  private final String zzj() {
    synchronized (this.zzaaq) {
      long l;
      if (this.zzn) {
        l = DefaultClock.getInstance().elapsedRealtime();
      } else {
        l = this.zzl.zzz().elapsedRealtime();
      } 
      if (Math.abs(l - this.zzaap) < 1000L)
        return this.zzaao; 
      return null;
    } 
  }
  
  private final ExecutorService zzjt() {
    // Byte code:
    //   0: ldc com/google/firebase/analytics/FirebaseAnalytics
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield zzab : Ljava/util/concurrent/ExecutorService;
    //   7: ifnonnull -> 44
    //   10: new java/util/concurrent/ThreadPoolExecutor
    //   13: astore_1
    //   14: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   17: astore_2
    //   18: new java/util/concurrent/ArrayBlockingQueue
    //   21: astore_3
    //   22: aload_3
    //   23: bipush #100
    //   25: invokespecial <init> : (I)V
    //   28: aload_1
    //   29: iconst_0
    //   30: iconst_1
    //   31: ldc2_w 30
    //   34: aload_2
    //   35: aload_3
    //   36: invokespecial <init> : (IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V
    //   39: aload_0
    //   40: aload_1
    //   41: putfield zzab : Ljava/util/concurrent/ExecutorService;
    //   44: aload_0
    //   45: getfield zzab : Ljava/util/concurrent/ExecutorService;
    //   48: astore_2
    //   49: ldc com/google/firebase/analytics/FirebaseAnalytics
    //   51: monitorexit
    //   52: aload_2
    //   53: areturn
    //   54: astore_2
    //   55: ldc com/google/firebase/analytics/FirebaseAnalytics
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   3	44	54	finally
    //   44	52	54	finally
    //   55	58	54	finally
  }
  
  @NonNull
  public final Task<String> getAppInstanceId() {
    try {
      String str = zzj();
      if (str != null)
        return Tasks.forResult(str); 
      ExecutorService executorService = zzjt();
      zza zza = new zza();
      this(this);
      return Tasks.call(executorService, zza);
    } catch (Exception exception) {
      if (this.zzn) {
        this.zzaan.zza(5, "Failed to schedule task for getAppInstanceId", null, null, null);
      } else {
        this.zzl.zzad().zzdd().zzaq("Failed to schedule task for getAppInstanceId");
      } 
      return Tasks.forException(exception);
    } 
  }
  
  @Keep
  public final String getFirebaseInstanceId() {
    return FirebaseInstanceId.getInstance().getId();
  }
  
  public final void logEvent(@NonNull @Size(max = 40L, min = 1L) String paramString, @Nullable Bundle paramBundle) {
    if (this.zzn) {
      this.zzaan.logEvent(paramString, paramBundle);
      return;
    } 
    this.zzl.zzs().zza("app", paramString, paramBundle, true);
  }
  
  public final void resetAnalyticsData() {
    zzbi(null);
    if (this.zzn) {
      this.zzaan.resetAnalyticsData();
      return;
    } 
    this.zzl.zzs().resetAnalyticsData(this.zzl.zzz().currentTimeMillis());
  }
  
  public final void setAnalyticsCollectionEnabled(boolean paramBoolean) {
    if (this.zzn) {
      this.zzaan.setMeasurementEnabled(paramBoolean);
      return;
    } 
    this.zzl.zzs().setMeasurementEnabled(paramBoolean);
  }
  
  @Keep
  @MainThread
  public final void setCurrentScreen(@NonNull Activity paramActivity, @Nullable @Size(max = 36L, min = 1L) String paramString1, @Nullable @Size(max = 36L, min = 1L) String paramString2) {
    if (this.zzn) {
      this.zzaan.setCurrentScreen(paramActivity, paramString1, paramString2);
      return;
    } 
    if (!zzq.isMainThread()) {
      this.zzl.zzad().zzdd().zzaq("setCurrentScreen must be called from the main thread");
      return;
    } 
    this.zzl.zzv().setCurrentScreen(paramActivity, paramString1, paramString2);
  }
  
  @Deprecated
  public final void setMinimumSessionDuration(long paramLong) {
    if (this.zzn) {
      this.zzaan.setMinimumSessionDuration(paramLong);
      return;
    } 
    this.zzl.zzs().setMinimumSessionDuration(paramLong);
  }
  
  public final void setSessionTimeoutDuration(long paramLong) {
    if (this.zzn) {
      this.zzaan.setSessionTimeoutDuration(paramLong);
      return;
    } 
    this.zzl.zzs().setSessionTimeoutDuration(paramLong);
  }
  
  public final void setUserId(@Nullable String paramString) {
    if (this.zzn) {
      this.zzaan.setUserId(paramString);
      return;
    } 
    this.zzl.zzs().zzb("app", "_id", paramString, true);
  }
  
  public final void setUserProperty(@NonNull @Size(max = 24L, min = 1L) String paramString1, @Nullable @Size(max = 36L) String paramString2) {
    if (this.zzn) {
      this.zzaan.setUserProperty(paramString1, paramString2);
      return;
    } 
    this.zzl.zzs().zzb("app", paramString1, paramString2, false);
  }
  
  public static class Event {
    public static final String ADD_PAYMENT_INFO = "add_payment_info";
    
    public static final String ADD_TO_CART = "add_to_cart";
    
    public static final String ADD_TO_WISHLIST = "add_to_wishlist";
    
    public static final String APP_OPEN = "app_open";
    
    public static final String BEGIN_CHECKOUT = "begin_checkout";
    
    public static final String CAMPAIGN_DETAILS = "campaign_details";
    
    public static final String CHECKOUT_PROGRESS = "checkout_progress";
    
    public static final String EARN_VIRTUAL_CURRENCY = "earn_virtual_currency";
    
    public static final String ECOMMERCE_PURCHASE = "ecommerce_purchase";
    
    public static final String GENERATE_LEAD = "generate_lead";
    
    public static final String JOIN_GROUP = "join_group";
    
    public static final String LEVEL_END = "level_end";
    
    public static final String LEVEL_START = "level_start";
    
    public static final String LEVEL_UP = "level_up";
    
    public static final String LOGIN = "login";
    
    public static final String POST_SCORE = "post_score";
    
    public static final String PRESENT_OFFER = "present_offer";
    
    public static final String PURCHASE_REFUND = "purchase_refund";
    
    public static final String REMOVE_FROM_CART = "remove_from_cart";
    
    public static final String SEARCH = "search";
    
    public static final String SELECT_CONTENT = "select_content";
    
    public static final String SET_CHECKOUT_OPTION = "set_checkout_option";
    
    public static final String SHARE = "share";
    
    public static final String SIGN_UP = "sign_up";
    
    public static final String SPEND_VIRTUAL_CURRENCY = "spend_virtual_currency";
    
    public static final String TUTORIAL_BEGIN = "tutorial_begin";
    
    public static final String TUTORIAL_COMPLETE = "tutorial_complete";
    
    public static final String UNLOCK_ACHIEVEMENT = "unlock_achievement";
    
    public static final String VIEW_ITEM = "view_item";
    
    public static final String VIEW_ITEM_LIST = "view_item_list";
    
    public static final String VIEW_SEARCH_RESULTS = "view_search_results";
  }
  
  public static class Param {
    public static final String ACHIEVEMENT_ID = "achievement_id";
    
    public static final String ACLID = "aclid";
    
    public static final String AFFILIATION = "affiliation";
    
    public static final String CAMPAIGN = "campaign";
    
    public static final String CHARACTER = "character";
    
    public static final String CHECKOUT_OPTION = "checkout_option";
    
    public static final String CHECKOUT_STEP = "checkout_step";
    
    public static final String CONTENT = "content";
    
    public static final String CONTENT_TYPE = "content_type";
    
    public static final String COUPON = "coupon";
    
    public static final String CP1 = "cp1";
    
    public static final String CREATIVE_NAME = "creative_name";
    
    public static final String CREATIVE_SLOT = "creative_slot";
    
    public static final String CURRENCY = "currency";
    
    public static final String DESTINATION = "destination";
    
    public static final String END_DATE = "end_date";
    
    public static final String EXTEND_SESSION = "extend_session";
    
    public static final String FLIGHT_NUMBER = "flight_number";
    
    public static final String GROUP_ID = "group_id";
    
    public static final String INDEX = "index";
    
    public static final String ITEM_BRAND = "item_brand";
    
    public static final String ITEM_CATEGORY = "item_category";
    
    public static final String ITEM_ID = "item_id";
    
    public static final String ITEM_LIST = "item_list";
    
    public static final String ITEM_LOCATION_ID = "item_location_id";
    
    public static final String ITEM_NAME = "item_name";
    
    public static final String ITEM_VARIANT = "item_variant";
    
    public static final String LEVEL = "level";
    
    public static final String LEVEL_NAME = "level_name";
    
    public static final String LOCATION = "location";
    
    public static final String MEDIUM = "medium";
    
    public static final String METHOD = "method";
    
    public static final String NUMBER_OF_NIGHTS = "number_of_nights";
    
    public static final String NUMBER_OF_PASSENGERS = "number_of_passengers";
    
    public static final String NUMBER_OF_ROOMS = "number_of_rooms";
    
    public static final String ORIGIN = "origin";
    
    public static final String PRICE = "price";
    
    public static final String QUANTITY = "quantity";
    
    public static final String SCORE = "score";
    
    public static final String SEARCH_TERM = "search_term";
    
    public static final String SHIPPING = "shipping";
    
    @Deprecated
    public static final String SIGN_UP_METHOD = "sign_up_method";
    
    public static final String SOURCE = "source";
    
    public static final String START_DATE = "start_date";
    
    public static final String SUCCESS = "success";
    
    public static final String TAX = "tax";
    
    public static final String TERM = "term";
    
    public static final String TRANSACTION_ID = "transaction_id";
    
    public static final String TRAVEL_CLASS = "travel_class";
    
    public static final String VALUE = "value";
    
    public static final String VIRTUAL_CURRENCY_NAME = "virtual_currency_name";
  }
  
  public static class UserProperty {
    public static final String SIGN_UP_METHOD = "sign_up_method";
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\analytics\FirebaseAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */