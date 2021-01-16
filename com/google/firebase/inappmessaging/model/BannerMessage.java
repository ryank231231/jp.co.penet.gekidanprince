package com.google.firebase.inappmessaging.model;

import javax.annotation.Nullable;

public class BannerMessage extends InAppMessage {
  @Nullable
  Action action;
  
  @Nullable
  String backgroundHexColor;
  
  @Nullable
  Text body;
  
  @Nullable
  ImageData imageData;
  
  @Nullable
  Text title;
  
  public BannerMessage(Text paramText1, Text paramText2, ImageData paramImageData, Action paramAction, String paramString, CampaignMetadata paramCampaignMetadata) {
    super(paramCampaignMetadata, MessageType.BANNER);
    this.title = paramText1;
    this.body = paramText2;
    this.imageData = paramImageData;
    this.action = paramAction;
    this.backgroundHexColor = paramString;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public Action getAction() {
    return this.action;
  }
  
  public String getBackgroundHexColor() {
    return this.backgroundHexColor;
  }
  
  public Text getBody() {
    return this.body;
  }
  
  public ImageData getImageData() {
    return this.imageData;
  }
  
  public Text getTitle() {
    return this.title;
  }
  
  public static class Builder {
    @Nullable
    Action action;
    
    @Nullable
    String backgroundHexColor;
    
    @Nullable
    Text body;
    
    @Nullable
    ImageData imageData;
    
    @Nullable
    Text title;
    
    public BannerMessage build(CampaignMetadata param1CampaignMetadata) {
      return new BannerMessage(this.title, this.body, this.imageData, this.action, this.backgroundHexColor, param1CampaignMetadata);
    }
    
    public Builder setAction(@Nullable Action param1Action) {
      this.action = param1Action;
      return this;
    }
    
    public Builder setBackgroundHexColor(@Nullable String param1String) {
      this.backgroundHexColor = param1String;
      return this;
    }
    
    public Builder setBody(@Nullable Text param1Text) {
      this.body = param1Text;
      return this;
    }
    
    public Builder setImageData(@Nullable ImageData param1ImageData) {
      this.imageData = param1ImageData;
      return this;
    }
    
    public Builder setTitle(@Nullable Text param1Text) {
      this.title = param1Text;
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\model\BannerMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */