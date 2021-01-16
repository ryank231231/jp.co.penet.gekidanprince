package com.google.firebase.inappmessaging.model;

import android.support.annotation.Keep;
import javax.annotation.Nullable;

@Keep
public class ModalMessage extends InAppMessage {
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
  
  public ModalMessage(Text paramText1, Text paramText2, ImageData paramImageData, Action paramAction, String paramString, CampaignMetadata paramCampaignMetadata) {
    super(paramCampaignMetadata, MessageType.MODAL);
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
    
    public ModalMessage build(CampaignMetadata param1CampaignMetadata) {
      return new ModalMessage(this.title, this.body, this.imageData, this.action, this.backgroundHexColor, param1CampaignMetadata);
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


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\model\ModalMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */