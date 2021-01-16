package com.google.firebase.inappmessaging.model;

import android.support.annotation.Keep;

@Keep
public abstract class InAppMessage {
  @Deprecated
  Button actionButton;
  
  @Deprecated
  String backgroundHexColor;
  
  @Deprecated
  Text body;
  
  @Deprecated
  String campaignId;
  
  CampaignMetadata campaignMetadata;
  
  @Deprecated
  String campaignName;
  
  @Deprecated
  ImageData imageData;
  
  @Deprecated
  String imageUrl;
  
  @Deprecated
  Boolean isTestMessage;
  
  MessageType messageType;
  
  @Deprecated
  Text title;
  
  public InAppMessage(CampaignMetadata paramCampaignMetadata, MessageType paramMessageType) {
    this.campaignMetadata = paramCampaignMetadata;
    this.messageType = paramMessageType;
  }
  
  @Deprecated
  public InAppMessage(Text paramText1, Text paramText2, String paramString1, ImageData paramImageData, Button paramButton, Action paramAction, String paramString2, String paramString3, String paramString4, Boolean paramBoolean, MessageType paramMessageType) {
    this.title = paramText1;
    this.body = paramText2;
    this.imageUrl = paramString1;
    this.imageData = paramImageData;
    this.actionButton = paramButton;
    this.backgroundHexColor = paramString2;
    this.campaignId = paramString3;
    this.campaignName = paramString4;
    this.isTestMessage = paramBoolean;
    this.messageType = paramMessageType;
    this.campaignMetadata = new CampaignMetadata(paramString3, paramString4, paramBoolean.booleanValue());
  }
  
  public abstract Action getAction();
  
  @Deprecated
  public Button getActionButton() {
    return (getAction() != null) ? getAction().getButton() : this.actionButton;
  }
  
  @Deprecated
  public String getBackgroundHexColor() {
    return this.backgroundHexColor;
  }
  
  @Deprecated
  public Text getBody() {
    return this.body;
  }
  
  @Deprecated
  public String getCampaignId() {
    return this.campaignMetadata.getCampaignId();
  }
  
  public CampaignMetadata getCampaignMetadata() {
    return this.campaignMetadata;
  }
  
  @Deprecated
  public String getCampaignName() {
    return this.campaignMetadata.getCampaignName();
  }
  
  @Deprecated
  public ImageData getImageData() {
    return this.imageData;
  }
  
  @Deprecated
  public String getImageUrl() {
    return this.imageUrl;
  }
  
  @Deprecated
  public Boolean getIsTestMessage() {
    return Boolean.valueOf(this.campaignMetadata.getIsTestMessage());
  }
  
  public MessageType getMessageType() {
    return this.messageType;
  }
  
  @Deprecated
  public Text getTitle() {
    return this.title;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\model\InAppMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */