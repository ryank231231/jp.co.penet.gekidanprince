package com.google.firebase.inappmessaging.model;

import javax.annotation.Nullable;

public class ImageOnlyMessage extends InAppMessage {
  @Nullable
  Action action;
  
  @Nullable
  ImageData imageData;
  
  public ImageOnlyMessage(ImageData paramImageData, Action paramAction, CampaignMetadata paramCampaignMetadata) {
    super(paramCampaignMetadata, MessageType.IMAGE_ONLY);
    this.imageData = paramImageData;
    this.action = paramAction;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public Action getAction() {
    return this.action;
  }
  
  public ImageData getImageData() {
    return this.imageData;
  }
  
  public static class Builder {
    @Nullable
    Action action;
    
    @Nullable
    ImageData imageData;
    
    public ImageOnlyMessage build(CampaignMetadata param1CampaignMetadata) {
      return new ImageOnlyMessage(this.imageData, this.action, param1CampaignMetadata);
    }
    
    public Builder setAction(@Nullable Action param1Action) {
      this.action = param1Action;
      return this;
    }
    
    public Builder setImageData(@Nullable ImageData param1ImageData) {
      this.imageData = param1ImageData;
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\model\ImageOnlyMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */