package com.google.firebase.inappmessaging.display.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class InAppMessageLayoutConfig {
  private Boolean animate;
  
  private Boolean autoDismiss;
  
  private Boolean backgroundEnabled;
  
  private Float maxBodyHeightWeight;
  
  private Float maxBodyWidthWeight;
  
  private Integer maxDialogHeightPx;
  
  private Integer maxDialogWidthPx;
  
  private Float maxImageHeightWeight;
  
  private Float maxImageWidthWeight;
  
  private Integer viewWindowGravity;
  
  private Integer windowFlag;
  
  private Integer windowHeight;
  
  private Integer windowWidth;
  
  @NonNull
  public static Builder builder() {
    return new Builder();
  }
  
  public Boolean animate() {
    return this.animate;
  }
  
  public Boolean autoDismiss() {
    return this.autoDismiss;
  }
  
  public Boolean backgroundEnabled() {
    return this.backgroundEnabled;
  }
  
  public int getMaxBodyHeight() {
    return (int)(maxBodyHeightWeight().floatValue() * maxDialogHeightPx().intValue());
  }
  
  public int getMaxBodyWidth() {
    return (int)(maxBodyWidthWeight().floatValue() * maxDialogWidthPx().intValue());
  }
  
  public int getMaxImageHeight() {
    return (int)(maxImageHeightWeight().floatValue() * maxDialogHeightPx().intValue());
  }
  
  public int getMaxImageWidth() {
    return (int)(maxImageWidthWeight().floatValue() * maxDialogWidthPx().intValue());
  }
  
  @Nullable
  public Float maxBodyHeightWeight() {
    return this.maxBodyHeightWeight;
  }
  
  @Nullable
  public Float maxBodyWidthWeight() {
    return this.maxBodyWidthWeight;
  }
  
  public Integer maxDialogHeightPx() {
    return this.maxDialogHeightPx;
  }
  
  public Integer maxDialogWidthPx() {
    return this.maxDialogWidthPx;
  }
  
  public Float maxImageHeightWeight() {
    return this.maxImageHeightWeight;
  }
  
  public Float maxImageWidthWeight() {
    return this.maxImageWidthWeight;
  }
  
  public Integer viewWindowGravity() {
    return this.viewWindowGravity;
  }
  
  public Integer windowFlag() {
    return this.windowFlag;
  }
  
  public Integer windowHeight() {
    return this.windowHeight;
  }
  
  public Integer windowWidth() {
    return this.windowWidth;
  }
  
  public static class Builder {
    private final InAppMessageLayoutConfig config = new InAppMessageLayoutConfig();
    
    public InAppMessageLayoutConfig build() {
      return this.config;
    }
    
    public Builder setAnimate(Boolean param1Boolean) {
      InAppMessageLayoutConfig.access$1102(this.config, param1Boolean);
      return this;
    }
    
    public Builder setAutoDismiss(Boolean param1Boolean) {
      InAppMessageLayoutConfig.access$1202(this.config, param1Boolean);
      return this;
    }
    
    public Builder setBackgroundEnabled(Boolean param1Boolean) {
      InAppMessageLayoutConfig.access$1002(this.config, param1Boolean);
      return this;
    }
    
    public Builder setMaxBodyHeightWeight(Float param1Float) {
      InAppMessageLayoutConfig.access$202(this.config, param1Float);
      return this;
    }
    
    public Builder setMaxBodyWidthWeight(Float param1Float) {
      InAppMessageLayoutConfig.access$302(this.config, param1Float);
      return this;
    }
    
    public Builder setMaxDialogHeightPx(Integer param1Integer) {
      InAppMessageLayoutConfig.access$402(this.config, param1Integer);
      return this;
    }
    
    public Builder setMaxDialogWidthPx(Integer param1Integer) {
      InAppMessageLayoutConfig.access$502(this.config, param1Integer);
      return this;
    }
    
    public Builder setMaxImageHeightWeight(Float param1Float) {
      InAppMessageLayoutConfig.access$002(this.config, param1Float);
      return this;
    }
    
    public Builder setMaxImageWidthWeight(Float param1Float) {
      InAppMessageLayoutConfig.access$102(this.config, param1Float);
      return this;
    }
    
    public Builder setViewWindowGravity(Integer param1Integer) {
      InAppMessageLayoutConfig.access$602(this.config, param1Integer);
      return this;
    }
    
    public Builder setWindowFlag(Integer param1Integer) {
      InAppMessageLayoutConfig.access$702(this.config, param1Integer);
      return this;
    }
    
    public Builder setWindowHeight(Integer param1Integer) {
      InAppMessageLayoutConfig.access$902(this.config, param1Integer);
      return this;
    }
    
    public Builder setWindowWidth(Integer param1Integer) {
      InAppMessageLayoutConfig.access$802(this.config, param1Integer);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\InAppMessageLayoutConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */