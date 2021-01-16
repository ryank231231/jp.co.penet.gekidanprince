package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.MessagesProto;

public class Text {
  private final String hexColor;
  
  private final String text;
  
  public Text(String paramString1, String paramString2) {
    this.text = paramString1;
    this.hexColor = paramString2;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public String getHexColor() {
    return this.hexColor;
  }
  
  public String getText() {
    return this.text;
  }
  
  static class Builder {
    private String hexColor;
    
    private String text;
    
    Text build() {
      return new Text(this.text, this.hexColor);
    }
    
    Builder setHexColor(String param1String) {
      if (!TextUtils.isEmpty(param1String))
        this.hexColor = param1String; 
      return this;
    }
    
    Builder setText(MessagesProto.Text param1Text) {
      setText(param1Text.getText());
      setHexColor(param1Text.getHexColor());
      return this;
    }
    
    Builder setText(String param1String) {
      if (!TextUtils.isEmpty(param1String))
        this.text = param1String; 
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\model\Text.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */