package com.android.vending.billing.util;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public class IabHelper {
  public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
  
  public static final int BILLING_RESPONSE_RESULT_DEVELOPER_ERROR = 5;
  
  public static final int BILLING_RESPONSE_RESULT_ERROR = 6;
  
  public static final int BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED = 7;
  
  public static final int BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED = 8;
  
  public static final int BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE = 4;
  
  public static final int BILLING_RESPONSE_RESULT_OK = 0;
  
  public static final int BILLING_RESPONSE_RESULT_USER_CANCELED = 1;
  
  public static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
  
  public static final String GET_SKU_DETAILS_ITEM_TYPE_LIST = "ITEM_TYPE_LIST";
  
  public static final int IABHELPER_BAD_RESPONSE = -1002;
  
  public static final int IABHELPER_ERROR_BASE = -1000;
  
  public static final int IABHELPER_INVALID_CONSUMPTION = -1010;
  
  public static final int IABHELPER_MISSING_TOKEN = -1007;
  
  public static final int IABHELPER_REMOTE_EXCEPTION = -1001;
  
  public static final int IABHELPER_SEND_INTENT_FAILED = -1004;
  
  public static final int IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE = -1009;
  
  public static final int IABHELPER_UNKNOWN_ERROR = -1008;
  
  public static final int IABHELPER_UNKNOWN_PURCHASE_RESPONSE = -1006;
  
  public static final int IABHELPER_USER_CANCELLED = -1005;
  
  public static final int IABHELPER_VERIFICATION_FAILED = -1003;
  
  public static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
  
  public static final String ITEM_TYPE_INAPP = "inapp";
  
  public static final String ITEM_TYPE_SUBS = "subs";
  
  public static final String RESPONSE_BUY_INTENT = "BUY_INTENT";
  
  public static final String RESPONSE_CODE = "RESPONSE_CODE";
  
  public static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
  
  public static final String RESPONSE_INAPP_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
  
  public static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
  
  public static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
  
  public static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
  
  public static final String RESPONSE_INAPP_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
  
  boolean mAsyncInProgress = false;
  
  String mAsyncOperation = "";
  
  Context mContext;
  
  boolean mDebugLog = false;
  
  String mDebugTag = "IabHelper";
  
  boolean mDisposed = false;
  
  OnIabPurchaseFinishedListener mPurchaseListener;
  
  String mPurchasingItemType;
  
  int mRequestCode;
  
  IInAppBillingService mService;
  
  ServiceConnection mServiceConn;
  
  boolean mSetupDone = false;
  
  String mSignatureBase64 = null;
  
  boolean mSubscriptionsSupported = false;
  
  public IabHelper(Context paramContext, String paramString) {
    this.mContext = paramContext.getApplicationContext();
    this.mSignatureBase64 = paramString;
    logDebug("IAB helper created.");
  }
  
  private void checkNotDisposed() {
    if (!this.mDisposed)
      return; 
    throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
  }
  
  public static String getResponseDesc(int paramInt) {
    StringBuilder stringBuilder;
    String[] arrayOfString1 = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
    String[] arrayOfString2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
    if (paramInt <= -1000) {
      int i = -1000 - paramInt;
      if (i >= 0 && i < arrayOfString2.length)
        return arrayOfString2[i]; 
      stringBuilder = new StringBuilder();
      stringBuilder.append(String.valueOf(paramInt));
      stringBuilder.append(":Unknown IAB Helper Error");
      return stringBuilder.toString();
    } 
    if (paramInt < 0 || paramInt >= stringBuilder.length) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(String.valueOf(paramInt));
      stringBuilder.append(":Unknown");
      return stringBuilder.toString();
    } 
    return (String)stringBuilder[paramInt];
  }
  
  void checkSetupDone(String paramString) {
    if (this.mSetupDone)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Illegal state for operation (");
    stringBuilder.append(paramString);
    stringBuilder.append("): IAB helper is not set up.");
    logError(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("IAB helper is not set up. Can't perform operation: ");
    stringBuilder.append(paramString);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  void consume(Purchase paramPurchase) throws IabException {
    checkNotDisposed();
    checkSetupDone("consume");
    if (paramPurchase.mItemType.equals("inapp"))
      try {
        String str1 = paramPurchase.getToken();
        String str2 = paramPurchase.getSku();
        if (str1 != null && !str1.equals("")) {
          StringBuilder stringBuilder3 = new StringBuilder();
          this();
          stringBuilder3.append("Consuming sku: ");
          stringBuilder3.append(str2);
          stringBuilder3.append(", token: ");
          stringBuilder3.append(str1);
          logDebug(stringBuilder3.toString());
          int i = this.mService.consumePurchase(3, this.mContext.getPackageName(), str1);
          if (i == 0) {
            stringBuilder3 = new StringBuilder();
            this();
            stringBuilder3.append("Successfully consumed sku: ");
            stringBuilder3.append(str2);
            logDebug(stringBuilder3.toString());
            return;
          } 
          stringBuilder3 = new StringBuilder();
          this();
          stringBuilder3.append("Error consuming consuming sku ");
          stringBuilder3.append(str2);
          stringBuilder3.append(". ");
          stringBuilder3.append(getResponseDesc(i));
          logDebug(stringBuilder3.toString());
          IabException iabException1 = new IabException();
          stringBuilder3 = new StringBuilder();
          this();
          stringBuilder3.append("Error consuming sku ");
          stringBuilder3.append(str2);
          this(i, stringBuilder3.toString());
          throw iabException1;
        } 
        StringBuilder stringBuilder2 = new StringBuilder();
        this();
        stringBuilder2.append("Can't consume ");
        stringBuilder2.append(str2);
        stringBuilder2.append(". No token.");
        logError(stringBuilder2.toString());
        IabException iabException = new IabException();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        stringBuilder1.append("PurchaseInfo is missing token for sku: ");
        stringBuilder1.append(str2);
        stringBuilder1.append(" ");
        stringBuilder1.append(paramPurchase);
        this(-1007, stringBuilder1.toString());
        throw iabException;
      } catch (RemoteException remoteException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Remote exception while consuming. PurchaseInfo: ");
        stringBuilder1.append(paramPurchase);
        throw new IabException(-1001, stringBuilder1.toString(), remoteException);
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Items of type '");
    stringBuilder.append(paramPurchase.mItemType);
    stringBuilder.append("' can't be consumed.");
    throw new IabException(-1010, stringBuilder.toString());
  }
  
  public void consumeAsync(Purchase paramPurchase, OnConsumeFinishedListener paramOnConsumeFinishedListener) {
    checkNotDisposed();
    checkSetupDone("consume");
    ArrayList<Purchase> arrayList = new ArrayList();
    arrayList.add(paramPurchase);
    consumeAsyncInternal(arrayList, paramOnConsumeFinishedListener, null);
  }
  
  public void consumeAsync(List<Purchase> paramList, OnConsumeMultiFinishedListener paramOnConsumeMultiFinishedListener) {
    checkNotDisposed();
    checkSetupDone("consume");
    consumeAsyncInternal(paramList, null, paramOnConsumeMultiFinishedListener);
  }
  
  void consumeAsyncInternal(final List<Purchase> purchases, final OnConsumeFinishedListener singleListener, final OnConsumeMultiFinishedListener multiListener) {
    final Handler handler = new Handler();
    flagStartAsync("consume");
    (new Thread(new Runnable() {
          public void run() {
            final ArrayList<IabResult> results = new ArrayList();
            for (Purchase purchase : purchases) {
              try {
                IabHelper.this.consume(purchase);
                IabResult iabResult = new IabResult();
                StringBuilder stringBuilder = new StringBuilder();
                this();
                stringBuilder.append("Successful consume of sku ");
                stringBuilder.append(purchase.getSku());
                this(0, stringBuilder.toString());
                arrayList.add(iabResult);
              } catch (IabException iabException) {
                arrayList.add(iabException.getResult());
              } 
            } 
            IabHelper.this.flagEndAsync();
            if (!IabHelper.this.mDisposed && singleListener != null)
              handler.post(new Runnable() {
                    public void run() {
                      singleListener.onConsumeFinished(purchases.get(0), results.get(0));
                    }
                  }); 
            if (!IabHelper.this.mDisposed && multiListener != null)
              handler.post(new Runnable() {
                    public void run() {
                      multiListener.onConsumeMultiFinished(purchases, results);
                    }
                  }); 
          }
        })).start();
  }
  
  public void dispose() {
    logDebug("Disposing.");
    this.mSetupDone = false;
    if (this.mServiceConn != null) {
      logDebug("Unbinding from service.");
      Context context = this.mContext;
      if (context != null)
        context.unbindService(this.mServiceConn); 
    } 
    this.mDisposed = true;
    this.mContext = null;
    this.mServiceConn = null;
    this.mService = null;
    this.mPurchaseListener = null;
  }
  
  public void enableDebugLogging(boolean paramBoolean) {
    checkNotDisposed();
    this.mDebugLog = paramBoolean;
  }
  
  public void enableDebugLogging(boolean paramBoolean, String paramString) {
    checkNotDisposed();
    this.mDebugLog = paramBoolean;
    this.mDebugTag = paramString;
  }
  
  void flagEndAsync() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Ending async operation: ");
    stringBuilder.append(this.mAsyncOperation);
    logDebug(stringBuilder.toString());
    this.mAsyncOperation = "";
    this.mAsyncInProgress = false;
  }
  
  void flagStartAsync(String paramString) {
    if (!this.mAsyncInProgress) {
      this.mAsyncOperation = paramString;
      this.mAsyncInProgress = true;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Starting async operation: ");
      stringBuilder1.append(paramString);
      logDebug(stringBuilder1.toString());
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Can't start async operation (");
    stringBuilder.append(paramString);
    stringBuilder.append(") because another async operation(");
    stringBuilder.append(this.mAsyncOperation);
    stringBuilder.append(") is in progress.");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  int getResponseCodeFromBundle(Bundle paramBundle) {
    Object object = paramBundle.get("RESPONSE_CODE");
    if (object == null) {
      logDebug("Bundle with null response code, assuming OK (known issue)");
      return 0;
    } 
    if (object instanceof Integer)
      return ((Integer)object).intValue(); 
    if (object instanceof Long)
      return (int)((Long)object).longValue(); 
    logError("Unexpected type for bundle response code.");
    logError(object.getClass().getName());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected type for bundle response code: ");
    stringBuilder.append(object.getClass().getName());
    throw new RuntimeException(stringBuilder.toString());
  }
  
  int getResponseCodeFromIntent(Intent paramIntent) {
    Object object = paramIntent.getExtras().get("RESPONSE_CODE");
    if (object == null) {
      logError("Intent with no response code, assuming OK (known issue)");
      return 0;
    } 
    if (object instanceof Integer)
      return ((Integer)object).intValue(); 
    if (object instanceof Long)
      return (int)((Long)object).longValue(); 
    logError("Unexpected type for intent response code.");
    logError(object.getClass().getName());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected type for intent response code: ");
    stringBuilder.append(object.getClass().getName());
    throw new RuntimeException(stringBuilder.toString());
  }
  
  public boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    OnIabPurchaseFinishedListener onIabPurchaseFinishedListener;
    if (paramInt1 != this.mRequestCode)
      return false; 
    checkNotDisposed();
    checkSetupDone("handleActivityResult");
    flagEndAsync();
    if (paramIntent == null) {
      logError("Null data in IAB activity result.");
      IabResult iabResult = new IabResult(-1002, "Null data in IAB result");
      onIabPurchaseFinishedListener = this.mPurchaseListener;
      if (onIabPurchaseFinishedListener != null)
        onIabPurchaseFinishedListener.onIabPurchaseFinished(iabResult, null); 
      return true;
    } 
    paramInt1 = getResponseCodeFromIntent((Intent)onIabPurchaseFinishedListener);
    String str2 = onIabPurchaseFinishedListener.getStringExtra("INAPP_PURCHASE_DATA");
    String str1 = onIabPurchaseFinishedListener.getStringExtra("INAPP_DATA_SIGNATURE");
    if (paramInt2 == -1 && paramInt1 == 0) {
      IabResult iabResult;
      logDebug("Successful resultcode from purchase activity.");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Purchase data: ");
      stringBuilder.append(str2);
      logDebug(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("Data signature: ");
      stringBuilder.append(str1);
      logDebug(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("Extras: ");
      stringBuilder.append(onIabPurchaseFinishedListener.getExtras());
      logDebug(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("Expected item type: ");
      stringBuilder.append(this.mPurchasingItemType);
      logDebug(stringBuilder.toString());
      if (str2 == null || str1 == null) {
        logError("BUG: either purchaseData or dataSignature is null.");
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Extras: ");
        stringBuilder1.append(onIabPurchaseFinishedListener.getExtras().toString());
        logDebug(stringBuilder1.toString());
        iabResult = new IabResult(-1008, "IAB returned null purchaseData or dataSignature");
        onIabPurchaseFinishedListener = this.mPurchaseListener;
        if (onIabPurchaseFinishedListener != null)
          onIabPurchaseFinishedListener.onIabPurchaseFinished(iabResult, null); 
        return true;
      } 
      try {
        Purchase purchase = new Purchase();
        this(this.mPurchasingItemType, str2, (String)iabResult);
        String str = purchase.getSku();
        if (!Security.verifyPurchase(this.mSignatureBase64, str2, (String)iabResult)) {
          StringBuilder stringBuilder1 = new StringBuilder();
          this();
          stringBuilder1.append("Purchase signature verification FAILED for sku ");
          stringBuilder1.append(str);
          logError(stringBuilder1.toString());
          IabResult iabResult1 = new IabResult();
          stringBuilder1 = new StringBuilder();
          this();
          stringBuilder1.append("Signature verification failed for sku ");
          stringBuilder1.append(str);
          this(-1003, stringBuilder1.toString());
          if (this.mPurchaseListener != null)
            this.mPurchaseListener.onIabPurchaseFinished(iabResult1, purchase); 
          return true;
        } 
        logDebug("Purchase signature successfully verified.");
        OnIabPurchaseFinishedListener onIabPurchaseFinishedListener1 = this.mPurchaseListener;
        if (onIabPurchaseFinishedListener1 != null)
          onIabPurchaseFinishedListener1.onIabPurchaseFinished(new IabResult(0, "Success"), purchase); 
      } catch (JSONException jSONException) {
        logError("Failed to parse purchase data.");
        jSONException.printStackTrace();
        IabResult iabResult1 = new IabResult(-1002, "Failed to parse purchase data.");
        OnIabPurchaseFinishedListener onIabPurchaseFinishedListener1 = this.mPurchaseListener;
        if (onIabPurchaseFinishedListener1 != null)
          onIabPurchaseFinishedListener1.onIabPurchaseFinished(iabResult1, null); 
        return true;
      } 
    } else if (paramInt2 == -1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Result code was OK but in-app billing response was not OK: ");
      stringBuilder.append(getResponseDesc(paramInt1));
      logDebug(stringBuilder.toString());
      if (this.mPurchaseListener != null) {
        IabResult iabResult = new IabResult(paramInt1, "Problem purchashing item.");
        this.mPurchaseListener.onIabPurchaseFinished(iabResult, null);
      } 
    } else if (paramInt2 == 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Purchase canceled - Response: ");
      stringBuilder.append(getResponseDesc(paramInt1));
      logDebug(stringBuilder.toString());
      IabResult iabResult = new IabResult(-1005, "User canceled.");
      OnIabPurchaseFinishedListener onIabPurchaseFinishedListener1 = this.mPurchaseListener;
      if (onIabPurchaseFinishedListener1 != null)
        onIabPurchaseFinishedListener1.onIabPurchaseFinished(iabResult, null); 
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Purchase failed. Result code: ");
      stringBuilder.append(Integer.toString(paramInt2));
      stringBuilder.append(". Response: ");
      stringBuilder.append(getResponseDesc(paramInt1));
      logError(stringBuilder.toString());
      IabResult iabResult = new IabResult(-1006, "Unknown purchase response.");
      OnIabPurchaseFinishedListener onIabPurchaseFinishedListener1 = this.mPurchaseListener;
      if (onIabPurchaseFinishedListener1 != null)
        onIabPurchaseFinishedListener1.onIabPurchaseFinished(iabResult, null); 
    } 
    return true;
  }
  
  public void launchPurchaseFlow(Activity paramActivity, String paramString, int paramInt, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener) {
    launchPurchaseFlow(paramActivity, paramString, paramInt, paramOnIabPurchaseFinishedListener, "");
  }
  
  public void launchPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString2) {
    launchPurchaseFlow(paramActivity, paramString1, "inapp", paramInt, paramOnIabPurchaseFinishedListener, paramString2);
  }
  
  public void launchPurchaseFlow(Activity paramActivity, String paramString1, String paramString2, int paramInt, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString3) {
    checkNotDisposed();
    checkSetupDone("launchPurchaseFlow");
    flagStartAsync("launchPurchaseFlow");
    if (paramString2.equals("subs") && !this.mSubscriptionsSupported) {
      IabResult iabResult = new IabResult(-1009, "Subscriptions are not available.");
      flagEndAsync();
      if (paramOnIabPurchaseFinishedListener != null)
        paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(iabResult, null); 
      return;
    } 
    try {
      IabResult iabResult;
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      stringBuilder2.append("Constructing buy intent for ");
      stringBuilder2.append(paramString1);
      stringBuilder2.append(", item type: ");
      stringBuilder2.append(paramString2);
      logDebug(stringBuilder2.toString());
      Bundle bundle = this.mService.getBuyIntent(3, this.mContext.getPackageName(), paramString1, paramString2, paramString3);
      int i = getResponseCodeFromBundle(bundle);
      if (i != 0) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("Unable to buy item, Error response: ");
        stringBuilder.append(getResponseDesc(i));
        logError(stringBuilder.toString());
        flagEndAsync();
        iabResult = new IabResult();
        this(i, "Unable to buy item");
        if (paramOnIabPurchaseFinishedListener != null)
          paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(iabResult, null); 
        return;
      } 
      PendingIntent pendingIntent = (PendingIntent)bundle.getParcelable("BUY_INTENT");
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      stringBuilder1.append("Launching buy intent for ");
      stringBuilder1.append(paramString1);
      stringBuilder1.append(". Request code: ");
      stringBuilder1.append(paramInt);
      logDebug(stringBuilder1.toString());
      this.mRequestCode = paramInt;
      this.mPurchaseListener = paramOnIabPurchaseFinishedListener;
      this.mPurchasingItemType = paramString2;
      IntentSender intentSender = pendingIntent.getIntentSender();
      Intent intent = new Intent();
      this();
      iabResult.startIntentSenderForResult(intentSender, paramInt, intent, Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
    } catch (android.content.IntentSender.SendIntentException sendIntentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SendIntentException while launching purchase flow for sku ");
      stringBuilder.append(paramString1);
      logError(stringBuilder.toString());
      sendIntentException.printStackTrace();
      flagEndAsync();
      IabResult iabResult = new IabResult(-1004, "Failed to send intent.");
      if (paramOnIabPurchaseFinishedListener != null)
        paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(iabResult, null); 
    } catch (RemoteException remoteException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RemoteException while launching purchase flow for sku ");
      stringBuilder.append(paramString1);
      logError(stringBuilder.toString());
      remoteException.printStackTrace();
      flagEndAsync();
      IabResult iabResult = new IabResult(-1001, "Remote exception while starting purchase flow");
      if (paramOnIabPurchaseFinishedListener != null)
        paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(iabResult, null); 
    } 
  }
  
  public void launchSubscriptionPurchaseFlow(Activity paramActivity, String paramString, int paramInt, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener) {
    launchSubscriptionPurchaseFlow(paramActivity, paramString, paramInt, paramOnIabPurchaseFinishedListener, "");
  }
  
  public void launchSubscriptionPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString2) {
    launchPurchaseFlow(paramActivity, paramString1, "subs", paramInt, paramOnIabPurchaseFinishedListener, paramString2);
  }
  
  void logDebug(String paramString) {
    if (this.mDebugLog)
      Log.d(this.mDebugTag, paramString); 
  }
  
  void logError(String paramString) {
    String str = this.mDebugTag;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("In-app billing error: ");
    stringBuilder.append(paramString);
    Log.e(str, stringBuilder.toString());
  }
  
  void logWarn(String paramString) {
    String str = this.mDebugTag;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("In-app billing warning: ");
    stringBuilder.append(paramString);
    Log.w(str, stringBuilder.toString());
  }
  
  public Inventory queryInventory(boolean paramBoolean, List<String> paramList) throws IabException {
    return queryInventory(paramBoolean, paramList, null);
  }
  
  public Inventory queryInventory(boolean paramBoolean, List<String> paramList1, List<String> paramList2) throws IabException {
    checkNotDisposed();
    checkSetupDone("queryInventory");
    try {
      Inventory inventory = new Inventory();
      this();
      int i = queryPurchases(inventory, "inapp");
      if (i == 0) {
        IabException iabException1;
        if (paramBoolean) {
          i = querySkuDetails("inapp", inventory, paramList1);
          if (i != 0) {
            iabException1 = new IabException();
            this(i, "Error refreshing inventory (querying prices of items).");
            throw iabException1;
          } 
        } 
        if (this.mSubscriptionsSupported) {
          i = queryPurchases(inventory, "subs");
          if (i == 0) {
            if (paramBoolean) {
              i = querySkuDetails("subs", inventory, (List<String>)iabException1);
              if (i != 0) {
                iabException1 = new IabException();
                this(i, "Error refreshing inventory (querying prices of subscriptions).");
                throw iabException1;
              } 
            } 
          } else {
            iabException1 = new IabException();
            this(i, "Error refreshing inventory (querying owned subscriptions).");
            throw iabException1;
          } 
        } 
        return inventory;
      } 
      IabException iabException = new IabException();
      this(i, "Error refreshing inventory (querying owned items).");
      throw iabException;
    } catch (RemoteException remoteException) {
      throw new IabException(-1001, "Remote exception while refreshing inventory.", remoteException);
    } catch (JSONException jSONException) {
      throw new IabException(-1002, "Error parsing JSON response while refreshing inventory.", jSONException);
    } 
  }
  
  public void queryInventoryAsync(QueryInventoryFinishedListener paramQueryInventoryFinishedListener) {
    queryInventoryAsync(true, null, paramQueryInventoryFinishedListener);
  }
  
  public void queryInventoryAsync(boolean paramBoolean, QueryInventoryFinishedListener paramQueryInventoryFinishedListener) {
    queryInventoryAsync(paramBoolean, null, paramQueryInventoryFinishedListener);
  }
  
  public void queryInventoryAsync(final boolean querySkuDetails, final List<String> moreSkus, final QueryInventoryFinishedListener listener) {
    final Handler handler = new Handler();
    checkNotDisposed();
    checkSetupDone("queryInventory");
    flagStartAsync("refresh inventory");
    (new Thread(new Runnable() {
          public void run() {
            final Inventory inv_f;
            final IabResult result_f = new IabResult(0, "Inventory refresh successful.");
            try {
              inventory = IabHelper.this.queryInventory(querySkuDetails, moreSkus);
            } catch (IabException iabException) {
              iabResult = iabException.getResult();
              inventory = null;
            } 
            IabHelper.this.flagEndAsync();
            if (!IabHelper.this.mDisposed && listener != null)
              handler.post(new Runnable() {
                    public void run() {
                      listener.onQueryInventoryFinished(result_f, inv_f);
                    }
                  }); 
          }
        })).start();
  }
  
  int queryPurchases(Inventory paramInventory, String paramString) throws JSONException, RemoteException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Querying owned items, item type: ");
    stringBuilder.append(paramString);
    logDebug(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("Package name: ");
    stringBuilder.append(this.mContext.getPackageName());
    logDebug(stringBuilder.toString());
    boolean bool1 = false;
    stringBuilder = null;
    boolean bool2 = false;
    while (true) {
      StringBuilder stringBuilder1;
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("Calling getPurchases with continuation token: ");
      stringBuilder3.append((String)stringBuilder);
      logDebug(stringBuilder3.toString());
      Bundle bundle = this.mService.getPurchases(3, this.mContext.getPackageName(), paramString, (String)stringBuilder);
      int i = getResponseCodeFromBundle(bundle);
      stringBuilder3 = new StringBuilder();
      stringBuilder3.append("Owned items response: ");
      stringBuilder3.append(String.valueOf(i));
      logDebug(stringBuilder3.toString());
      if (i != 0) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("getPurchases() failed: ");
        stringBuilder1.append(getResponseDesc(i));
        logDebug(stringBuilder1.toString());
        return i;
      } 
      if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST"))
        break; 
      ArrayList<String> arrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
      ArrayList<String> arrayList3 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
      ArrayList<String> arrayList1 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
      for (i = 0; i < arrayList3.size(); i++) {
        StringBuilder stringBuilder4;
        String str1 = arrayList3.get(i);
        String str2 = arrayList1.get(i);
        String str3 = arrayList2.get(i);
        if (Security.verifyPurchase(this.mSignatureBase64, str1, str2)) {
          StringBuilder stringBuilder5 = new StringBuilder();
          stringBuilder5.append("Sku is owned: ");
          stringBuilder5.append(str3);
          logDebug(stringBuilder5.toString());
          Purchase purchase = new Purchase(paramString, str1, str2);
          if (TextUtils.isEmpty(purchase.getToken())) {
            logWarn("BUG: empty/null token!");
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Purchase data: ");
            stringBuilder4.append(str1);
            logDebug(stringBuilder4.toString());
          } 
          stringBuilder1.addPurchase(purchase);
        } else {
          logWarn("Purchase signature verification **FAILED**. Not adding item.");
          StringBuilder stringBuilder6 = new StringBuilder();
          stringBuilder6.append("   Purchase data: ");
          stringBuilder6.append(str1);
          logDebug(stringBuilder6.toString());
          StringBuilder stringBuilder5 = new StringBuilder();
          stringBuilder5.append("   Signature: ");
          stringBuilder5.append((String)stringBuilder4);
          logDebug(stringBuilder5.toString());
          bool2 = true;
        } 
      } 
      String str = bundle.getString("INAPP_CONTINUATION_TOKEN");
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Continuation token: ");
      stringBuilder2.append(str);
      logDebug(stringBuilder2.toString());
      if (TextUtils.isEmpty(str)) {
        i = bool1;
        if (bool2)
          i = -1003; 
        return i;
      } 
    } 
    logError("Bundle returned from getPurchases() doesn't contain required fields.");
    return -1002;
  }
  
  int querySkuDetails(String paramString, Inventory paramInventory, List<String> paramList) throws RemoteException, JSONException {
    logDebug("Querying SKU details.");
    ArrayList<String> arrayList = new ArrayList();
    arrayList.addAll(paramInventory.getAllOwnedSkus(paramString));
    if (paramList != null)
      for (String str : paramList) {
        if (!arrayList.contains(str))
          arrayList.add(str); 
      }  
    if (arrayList.size() == 0) {
      logDebug("queryPrices: nothing to do because there are no SKUs.");
      return 0;
    } 
    while (arrayList.size() > 0) {
      StringBuilder stringBuilder;
      paramList = new ArrayList<String>(arrayList.subList(0, Math.min(19, arrayList.size())));
      arrayList.removeAll(paramList);
      Bundle bundle2 = new Bundle();
      bundle2.putStringArrayList("ITEM_ID_LIST", (ArrayList)paramList);
      Bundle bundle1 = this.mService.getSkuDetails(3, this.mContext.getPackageName(), paramString, bundle2);
      if (!bundle1.containsKey("DETAILS_LIST")) {
        int i = getResponseCodeFromBundle(bundle1);
        if (i != 0) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("getSkuDetails() failed: ");
          stringBuilder.append(getResponseDesc(i));
          logDebug(stringBuilder.toString());
          return i;
        } 
        logError("getSkuDetails() returned a bundle with neither an error nor a detail list.");
        return -1002;
      } 
      Iterator<String> iterator = bundle1.getStringArrayList("DETAILS_LIST").iterator();
      while (iterator.hasNext()) {
        SkuDetails skuDetails = new SkuDetails((String)stringBuilder, iterator.next());
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Got sku details: ");
        stringBuilder1.append(skuDetails);
        logDebug(stringBuilder1.toString());
        paramInventory.addSkuDetails(skuDetails);
      } 
    } 
    return 0;
  }
  
  public void startSetup(final OnIabSetupFinishedListener listener) {
    checkNotDisposed();
    if (!this.mSetupDone) {
      logDebug("Starting in-app billing setup.");
      this.mServiceConn = new ServiceConnection() {
          public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
            if (IabHelper.this.mDisposed)
              return; 
            IabHelper.this.logDebug("Billing service connected.");
            IabHelper.this.mService = IInAppBillingService.Stub.asInterface(param1IBinder);
            String str = IabHelper.this.mContext.getPackageName();
            try {
              IabHelper.this.logDebug("Checking for in-app billing 3 support.");
              int i = IabHelper.this.mService.isBillingSupported(3, str, "inapp");
              if (i != 0) {
                if (listener != null) {
                  IabHelper.OnIabSetupFinishedListener onIabSetupFinishedListener1 = listener;
                  IabResult iabResult = new IabResult();
                  this(i, "Error checking for billing v3 support.");
                  onIabSetupFinishedListener1.onIabSetupFinished(iabResult);
                } 
                IabHelper.this.mSubscriptionsSupported = false;
                return;
              } 
              IabHelper iabHelper = IabHelper.this;
              StringBuilder stringBuilder = new StringBuilder();
              this();
              stringBuilder.append("In-app billing version 3 supported for ");
              stringBuilder.append(str);
              iabHelper.logDebug(stringBuilder.toString());
              i = IabHelper.this.mService.isBillingSupported(3, str, "subs");
              if (i == 0) {
                IabHelper.this.logDebug("Subscriptions AVAILABLE.");
                IabHelper.this.mSubscriptionsSupported = true;
              } else {
                IabHelper iabHelper1 = IabHelper.this;
                StringBuilder stringBuilder1 = new StringBuilder();
                this();
                stringBuilder1.append("Subscriptions NOT AVAILABLE. Response: ");
                stringBuilder1.append(i);
                iabHelper1.logDebug(stringBuilder1.toString());
              } 
              IabHelper.this.mSetupDone = true;
              IabHelper.OnIabSetupFinishedListener onIabSetupFinishedListener = listener;
              if (onIabSetupFinishedListener != null)
                onIabSetupFinishedListener.onIabSetupFinished(new IabResult(0, "Setup successful.")); 
              return;
            } catch (RemoteException remoteException) {
              IabHelper.OnIabSetupFinishedListener onIabSetupFinishedListener = listener;
              if (onIabSetupFinishedListener != null)
                onIabSetupFinishedListener.onIabSetupFinished(new IabResult(-1001, "RemoteException while setting up in-app billing.")); 
              remoteException.printStackTrace();
              return;
            } 
          }
          
          public void onServiceDisconnected(ComponentName param1ComponentName) {
            IabHelper.this.logDebug("Billing service disconnected.");
            IabHelper.this.mService = null;
          }
        };
      Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      intent.setPackage("com.android.vending");
      if (!this.mContext.getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
        this.mContext.bindService(intent, this.mServiceConn, 1);
      } else if (listener != null) {
        listener.onIabSetupFinished(new IabResult(3, "Billing service unavailable on device."));
      } 
      return;
    } 
    throw new IllegalStateException("IAB helper is already set up.");
  }
  
  public boolean subscriptionsSupported() {
    checkNotDisposed();
    return this.mSubscriptionsSupported;
  }
  
  public static interface OnConsumeFinishedListener {
    void onConsumeFinished(Purchase param1Purchase, IabResult param1IabResult);
  }
  
  public static interface OnConsumeMultiFinishedListener {
    void onConsumeMultiFinished(List<Purchase> param1List, List<IabResult> param1List1);
  }
  
  public static interface OnIabPurchaseFinishedListener {
    void onIabPurchaseFinished(IabResult param1IabResult, Purchase param1Purchase);
  }
  
  public static interface OnIabSetupFinishedListener {
    void onIabSetupFinished(IabResult param1IabResult);
  }
  
  public static interface QueryInventoryFinishedListener {
    void onQueryInventoryFinished(IabResult param1IabResult, Inventory param1Inventory);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\android\vending\billin\\util\IabHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */