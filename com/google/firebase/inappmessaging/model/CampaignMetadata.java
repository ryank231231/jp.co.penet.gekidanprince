package com.google.firebase.inappmessaging.model;

public class CampaignMetadata {
  private final String campaignId;
  
  private final String campaignName;
  
  private final boolean isTestMessage;
  
  public CampaignMetadata(String paramString1, String paramString2, boolean paramBoolean) {
    this.campaignId = paramString1;
    this.campaignName = paramString2;
    this.isTestMessage = paramBoolean;
  }
  
  public String getCampaignId() {
    return this.campaignId;
  }
  
  public String getCampaignName() {
    return this.campaignName;
  }
  
  public boolean getIsTestMessage() {
    return this.isTestMessage;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\model\CampaignMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */