package com.google.firebase.inappmessaging.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.Iterator;
import javax.inject.Inject;

public class TestDeviceHelper {
  @VisibleForTesting
  static final String FRESH_INSTALL_PREFERENCES = "fresh_install";
  
  @VisibleForTesting
  static final int MAX_FETCH_COUNT = 5;
  
  @VisibleForTesting
  static final String TEST_DEVICE_PREFERENCES = "test_device";
  
  private int fetchCount = 0;
  
  private boolean isFreshInstall;
  
  private boolean isTestDevice;
  
  private final SharedPreferencesUtils sharedPreferencesUtils;
  
  @Inject
  public TestDeviceHelper(SharedPreferencesUtils paramSharedPreferencesUtils) {
    this.sharedPreferencesUtils = paramSharedPreferencesUtils;
    this.isFreshInstall = readFreshInstallStatusFromPreferences();
    this.isTestDevice = readTestDeviceStatusFromPreferences();
  }
  
  private boolean readFreshInstallStatusFromPreferences() {
    return this.sharedPreferencesUtils.getAndSetBooleanPreference("fresh_install", true);
  }
  
  private boolean readTestDeviceStatusFromPreferences() {
    return this.sharedPreferencesUtils.getAndSetBooleanPreference("test_device", false);
  }
  
  private void setFreshInstallStatus(boolean paramBoolean) {
    this.isFreshInstall = paramBoolean;
    this.sharedPreferencesUtils.setBooleanPreference("fresh_install", paramBoolean);
  }
  
  private void setTestDeviceStatus(boolean paramBoolean) {
    this.isTestDevice = paramBoolean;
    this.sharedPreferencesUtils.setBooleanPreference("test_device", paramBoolean);
  }
  
  private void updateFreshInstallStatus() {
    if (this.isFreshInstall) {
      this.fetchCount++;
      if (this.fetchCount >= 5)
        setFreshInstallStatus(false); 
    } 
  }
  
  public boolean isAppInstallFresh() {
    return this.isFreshInstall;
  }
  
  public boolean isDeviceInTestMode() {
    return this.isTestDevice;
  }
  
  public void processCampaignFetch(FetchEligibleCampaignsResponse paramFetchEligibleCampaignsResponse) {
    if (!this.isTestDevice) {
      updateFreshInstallStatus();
      Iterator<CampaignProto.ThickContent> iterator = paramFetchEligibleCampaignsResponse.getMessagesList().iterator();
      while (iterator.hasNext()) {
        if (((CampaignProto.ThickContent)iterator.next()).getIsTestCampaign()) {
          setTestDeviceStatus(true);
          Logging.logi("Setting this device as a test device");
          return;
        } 
      } 
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\TestDeviceHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */