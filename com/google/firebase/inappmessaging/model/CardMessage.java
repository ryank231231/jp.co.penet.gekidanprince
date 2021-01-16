package com.google.firebase.inappmessaging.model;

import android.support.annotation.Keep;
import android.support.annotation.Nullable;

@Keep
public class CardMessage extends InAppMessage {
  private final String backgroundHexColor;
  
  private final Text body;
  
  private final ImageData landscapeImageData;
  
  private final ImageData portraitImageData;
  
  private final Action primaryAction;
  
  private final Action secondaryAction;
  
  private final Text title;
  
  public CardMessage(CampaignMetadata paramCampaignMetadata, Text paramText1, Text paramText2, ImageData paramImageData1, ImageData paramImageData2, String paramString, Action paramAction1, Action paramAction2) {
    super(paramCampaignMetadata, MessageType.CARD);
    this.title = paramText1;
    this.body = paramText2;
    this.portraitImageData = paramImageData1;
    this.landscapeImageData = paramImageData2;
    this.backgroundHexColor = paramString;
    this.primaryAction = paramAction1;
    this.secondaryAction = paramAction2;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  @Deprecated
  public Action getAction() {
    return this.primaryAction;
  }
  
  @Nullable
  public String getBackgroundHexColor() {
    return this.backgroundHexColor;
  }
  
  public Text getBody() {
    return this.body;
  }
  
  public ImageData getImageData() {
    return this.portraitImageData;
  }
  
  @Nullable
  public ImageData getLandscapeImageData() {
    return this.landscapeImageData;
  }
  
  public ImageData getPortraitImageData() {
    return this.portraitImageData;
  }
  
  @Nullable
  public Action getPrimaryAction() {
    return this.primaryAction;
  }
  
  @Nullable
  public Action getSecondaryAction() {
    return this.secondaryAction;
  }
  
  public Text getTitle() {
    return this.title;
  }
  
  public static class Builder {
    private String backgroundHexColor;
    
    private Text body;
    
    private ImageData landscapeImageData;
    
    private ImageData portraitImageData;
    
    private Action primaryAction;
    
    private Action secondaryAction;
    
    private Text title;
    
    public CardMessage build(CampaignMetadata param1CampaignMetadata) {
      return new CardMessage(param1CampaignMetadata, this.title, this.body, this.portraitImageData, this.landscapeImageData, this.backgroundHexColor, this.primaryAction, this.secondaryAction);
    }
    
    public Builder setBackgroundHexColor(String param1String) {
      this.backgroundHexColor = param1String;
      return this;
    }
    
    public Builder setBody(Text param1Text) {
      this.body = param1Text;
      return this;
    }
    
    public Builder setLandscapeImageData(ImageData param1ImageData) {
      this.landscapeImageData = param1ImageData;
      return this;
    }
    
    public Builder setPortraitImageData(ImageData param1ImageData) {
      this.portraitImageData = param1ImageData;
      return this;
    }
    
    public Builder setPrimaryAction(Action param1Action) {
      this.primaryAction = param1Action;
      return this;
    }
    
    public Builder setSecondaryAction(Action param1Action) {
      this.secondaryAction = param1Action;
      return this;
    }
    
    public Builder setTitle(Text param1Text) {
      this.title = param1Text;
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\model\CardMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */