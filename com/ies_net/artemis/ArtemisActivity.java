package com.ies_net.artemis;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NativeActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import com.android.vending.billing.util.IabHelper;
import com.android.vending.billing.util.IabResult;
import com.android.vending.billing.util.Inventory;
import com.android.vending.billing.util.Purchase;
import com.android.vending.billing.util.SkuDetails;
import com.google.android.vending.licensing.AESObfuscator;
import com.google.android.vending.licensing.APKExpansionPolicy;
import com.google.android.vending.licensing.LicenseChecker;
import com.google.android.vending.licensing.LicenseCheckerCallback;
import com.google.android.vending.licensing.Obfuscator;
import com.google.android.vending.licensing.Policy;
import java.util.ArrayList;

public class ArtemisActivity extends NativeActivity {
  private AlertDialog.Builder dialog;
  
  private boolean iabConsume;
  
  private String iabDescription;
  
  private boolean iabFinished;
  
  private IabHelper iabHelper;
  
  private String iabPrice;
  
  private boolean iabPurchase;
  
  private String iabSku;
  
  private String iabTitle;
  
  private String iabToken;
  
  private boolean libraryLoaded = false;
  
  private ArtemisActivity self;
  
  private void FinishPurchase(int paramInt, IabResult paramIabResult) {
    OnFinishPurchase(paramInt, this.iabTitle, this.iabDescription, this.iabPrice, this.iabToken, paramIabResult.getResponse(), paramIabResult.getMessage());
    this.iabFinished = true;
  }
  
  private native void OnFinishPurchase(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5);
  
  private native void OnFinishVideo();
  
  public void DownloadExpansionFiles(String paramString) {
    Context context = getApplicationContext();
    String str1 = getApplicationContext().getPackageName();
    String str2 = Settings.Secure.getString(getApplicationContext().getContentResolver(), "android_id");
    final APKExpansionPolicy aep = new APKExpansionPolicy(context, (Obfuscator)new AESObfuscator(new byte[] { 
            -6, -115, 21, -119, 67, 88, 28, -26, 84, 67, 
            -32, 111, 108, 102, -44, 46, 94, 49, -98, -47 }, str1, str2));
    aPKExpansionPolicy.resetPolicy();
    LicenseChecker licenseChecker = new LicenseChecker(getApplicationContext(), (Policy)aPKExpansionPolicy, paramString);
    this.self = this;
    licenseChecker.checkAccess(new LicenseCheckerCallback() {
          public void allow(int param1Int) {
            String str1 = "";
            String str2 = "";
            for (param1Int = 0; param1Int < aep.getExpansionURLCount(); param1Int++) {
              String str3 = str2;
              String str4 = str1;
              if (!str1.isEmpty()) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str1);
                stringBuilder3.append("|");
                str4 = stringBuilder3.toString();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append("|");
                str3 = stringBuilder2.toString();
              } 
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(str4);
              stringBuilder1.append(aep.getExpansionFileName(param1Int));
              str1 = stringBuilder1.toString();
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append(str3);
              stringBuilder1.append(aep.getExpansionURL(param1Int));
              str2 = stringBuilder1.toString();
            } 
            ArtemisActivity artemisActivity = ArtemisActivity.this;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
            stringBuilder.append("/Android/obb/");
            stringBuilder.append(ArtemisActivity.this.getPackageName());
            artemisActivity.DownloadResource(stringBuilder.toString(), str1, str2);
          }
          
          public void applicationError(int param1Int) {
            ArtemisActivity artemisActivity = ArtemisActivity.this;
            ArtemisActivity.access$002(artemisActivity, new AlertDialog.Builder((Context)artemisActivity.self));
            ArtemisActivity.this.dialog.setTitle("Download failed");
            ArtemisActivity.this.dialog.setMessage("License check - application error");
            ArtemisActivity.this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                  public void onCancel(DialogInterface param2DialogInterface) {
                    ArtemisActivity.this.finish();
                  }
                });
            ArtemisActivity.this.dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                    ArtemisActivity.this.finish();
                  }
                });
            ArtemisActivity.this.runOnUiThread(new Runnable() {
                  public void run() {
                    ArtemisActivity.this.dialog.show();
                  }
                });
          }
          
          public void dontAllow(int param1Int) {
            ArtemisActivity artemisActivity = ArtemisActivity.this;
            ArtemisActivity.access$002(artemisActivity, new AlertDialog.Builder((Context)artemisActivity.self));
            ArtemisActivity.this.dialog.setTitle("Download failed");
            if (param1Int != 291) {
              if (param1Int == 561)
                ArtemisActivity.this.dialog.setMessage("License check - Not licensed"); 
            } else {
              ArtemisActivity.this.dialog.setMessage("License check - Retry");
            } 
            ArtemisActivity.this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                  public void onCancel(DialogInterface param2DialogInterface) {
                    ArtemisActivity.this.finish();
                  }
                });
            ArtemisActivity.this.dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                    ArtemisActivity.this.finish();
                  }
                });
            ArtemisActivity.this.runOnUiThread(new Runnable() {
                  public void run() {
                    ArtemisActivity.this.dialog.show();
                  }
                });
          }
        });
  }
  
  public void DownloadResource(String paramString1, String paramString2, String paramString3) {
    Intent intent = new Intent(getApplicationContext(), DownloadActivity.class);
    intent.addFlags(65536);
    intent.putExtra("DIR", paramString1);
    intent.putExtra("NAME", paramString2);
    intent.putExtra("URL", paramString3);
    startActivityForResult(intent, 1);
    overridePendingTransition(0, 0);
  }
  
  protected native void EmulateKeyEvent(int paramInt1, int paramInt2);
  
  protected native void ExecuteTag(String paramString);
  
  public void InAppBilling(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) {
    this.iabHelper = new IabHelper((Context)this, paramString1);
    this.iabSku = paramString2;
    this.iabPurchase = paramBoolean1;
    this.iabConsume = paramBoolean2;
    this.iabFinished = false;
    this.iabTitle = "";
    this.iabDescription = "";
    this.iabPrice = "";
    this.iabToken = "";
    this.self = this;
    this.iabHelper.enableDebugLogging(true);
    this.iabHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
          public void onIabSetupFinished(IabResult param1IabResult) {
            if (!param1IabResult.isSuccess()) {
              ArtemisActivity.this.FinishPurchase(-1, param1IabResult);
              return;
            } 
            ArrayList<String> arrayList = new ArrayList();
            arrayList.add(ArtemisActivity.this.iabSku);
            ArtemisActivity.this.iabHelper.queryInventoryAsync(true, arrayList, new IabHelper.QueryInventoryFinishedListener() {
                  public void onQueryInventoryFinished(IabResult param2IabResult, Inventory param2Inventory) {
                    if (!param2IabResult.isSuccess()) {
                      ArtemisActivity.this.FinishPurchase(-2, param2IabResult);
                      return;
                    } 
                    SkuDetails skuDetails = param2Inventory.getSkuDetails(ArtemisActivity.this.iabSku);
                    if (skuDetails == null) {
                      ArtemisActivity.this.FinishPurchase(-3, param2IabResult);
                      return;
                    } 
                    ArtemisActivity.access$402(ArtemisActivity.this, skuDetails.getTitle());
                    ArtemisActivity.access$502(ArtemisActivity.this, skuDetails.getDescription());
                    ArtemisActivity.access$602(ArtemisActivity.this, skuDetails.getPrice());
                    Purchase purchase = param2Inventory.getPurchase(ArtemisActivity.this.iabSku);
                    if (purchase != null) {
                      ArtemisActivity.access$702(ArtemisActivity.this, purchase.getToken());
                      if (ArtemisActivity.this.iabConsume) {
                        ArtemisActivity.this.iabHelper.consumeAsync(purchase, new IabHelper.OnConsumeFinishedListener() {
                              public void onConsumeFinished(Purchase param3Purchase, IabResult param3IabResult) {
                                if (!param3IabResult.isSuccess()) {
                                  ArtemisActivity.this.FinishPurchase(-7, param3IabResult);
                                  return;
                                } 
                                ArtemisActivity.this.FinishPurchase(2, param3IabResult);
                              }
                            });
                        return;
                      } 
                      ArtemisActivity.this.FinishPurchase(2, param2IabResult);
                      return;
                    } 
                    if (!ArtemisActivity.this.iabPurchase) {
                      ArtemisActivity.this.FinishPurchase(3, param2IabResult);
                      return;
                    } 
                    ArtemisActivity.this.iabHelper.launchPurchaseFlow((Activity)ArtemisActivity.this.self, ArtemisActivity.this.iabSku, 3, new IabHelper.OnIabPurchaseFinishedListener() {
                          public void onIabPurchaseFinished(IabResult param3IabResult, Purchase param3Purchase) {
                            if (!param3IabResult.isSuccess()) {
                              if (param3IabResult.getResponse() == -1005) {
                                ArtemisActivity.this.FinishPurchase(-12, param3IabResult);
                              } else {
                                ArtemisActivity.this.FinishPurchase(-4, param3IabResult);
                              } 
                              return;
                            } 
                            if (!param3Purchase.getSku().equals(ArtemisActivity.this.iabSku)) {
                              ArtemisActivity.this.FinishPurchase(-5, param3IabResult);
                              return;
                            } 
                            ArtemisActivity.access$702(ArtemisActivity.this, param3Purchase.getToken());
                            if (!ArtemisActivity.this.iabConsume) {
                              ArtemisActivity.this.FinishPurchase(1, param3IabResult);
                              return;
                            } 
                            ArtemisActivity.this.iabHelper.consumeAsync(param3Purchase, new IabHelper.OnConsumeFinishedListener() {
                                  public void onConsumeFinished(Purchase param4Purchase, IabResult param4IabResult) {
                                    if (!param4IabResult.isSuccess()) {
                                      ArtemisActivity.this.FinishPurchase(-7, param4IabResult);
                                      return;
                                    } 
                                    ArtemisActivity.this.FinishPurchase(1, param4IabResult);
                                  }
                                });
                          }
                        });
                  }
                });
          }
        });
  }
  
  public void PlayVideo(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Intent intent = new Intent(getApplicationContext(), VideoViewActivity.class);
    intent.addFlags(65536);
    intent.putExtra("PATH", paramString);
    intent.putExtra("OFFSET", paramInt1);
    intent.putExtra("LENGTH", paramInt2);
    intent.putExtra("VOLUME", paramInt3);
    intent.putExtra("SKIP", paramInt4);
    startActivityForResult(intent, 2);
    overridePendingTransition(0, 0);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt1 == 1) {
      if (paramInt2 != -1 && paramInt2 == 0)
        finish(); 
    } else if (paramInt1 == 2) {
      OnFinishVideo();
    } else if (paramInt1 == 3) {
      IabHelper iabHelper = this.iabHelper;
      if (iabHelper == null)
        return; 
      iabHelper.handleActivityResult(paramInt1, paramInt2, paramIntent);
      if (!this.iabFinished && !this.iabConsume)
        FinishPurchase(-6, new IabResult(0, "")); 
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (!this.libraryLoaded) {
      ActivityInfo activityInfo;
      paramBundle = null;
      try {
        ActivityInfo activityInfo1 = getPackageManager().getActivityInfo(getComponentName(), 128);
        activityInfo = activityInfo1;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
      System.loadLibrary(activityInfo.metaData.getString("android.app.lib_name"));
      this.libraryLoaded = true;
    } 
  }
  
  protected void onResume() {
    super.onResume();
    if (Build.VERSION.SDK_INT >= 19)
      getWindow().getDecorView().setSystemUiVisibility(4102); 
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    if (Build.VERSION.SDK_INT >= 19)
      getWindow().getDecorView().setSystemUiVisibility(4102); 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\ies_net\artemis\ArtemisActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */