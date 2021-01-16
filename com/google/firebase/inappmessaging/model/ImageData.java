package com.google.firebase.inappmessaging.model;

import android.graphics.Bitmap;
import android.text.TextUtils;

public class ImageData {
  private final Bitmap bitmapData;
  
  private final String imageUrl;
  
  public ImageData(String paramString, Bitmap paramBitmap) {
    this.imageUrl = paramString;
    this.bitmapData = paramBitmap;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public Bitmap getBitmapData() {
    return this.bitmapData;
  }
  
  public String getImageUrl() {
    return this.imageUrl;
  }
  
  static class Builder {
    private Bitmap bitmapData;
    
    private String imageUrl;
    
    ImageData build() {
      return new ImageData(this.imageUrl, this.bitmapData);
    }
    
    Builder setBitmapData(Bitmap param1Bitmap) {
      this.bitmapData = param1Bitmap;
      return this;
    }
    
    Builder setImageUrl(String param1String) {
      if (!TextUtils.isEmpty(param1String))
        this.imageUrl = param1String; 
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\model\ImageData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */