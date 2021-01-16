package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.MessagesProto;

public class Button {
  private final String buttonHexColor;
  
  private final Text text;
  
  public Button(Text paramText, String paramString) {
    this.text = paramText;
    this.buttonHexColor = paramString;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public String getButtonHexColor() {
    return this.buttonHexColor;
  }
  
  public Text getText() {
    return this.text;
  }
  
  static class Builder {
    private String buttonHexColor;
    
    private Text text;
    
    Button build() {
      return new Button(this.text, this.buttonHexColor);
    }
    
    Builder setButtonHexColor(String param1String) {
      if (!TextUtils.isEmpty(param1String))
        this.buttonHexColor = param1String; 
      return this;
    }
    
    Builder setText(MessagesProto.Text param1Text) {
      Text.Builder builder = new Text.Builder();
      builder.setText(param1Text);
      this.text = builder.build();
      return this;
    }
    
    Builder setText(Text param1Text) {
      this.text = param1Text;
      return this;
    }
    
    Builder setText(String param1String) {
      this.text = (new Text.Builder()).setText(param1String).build();
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\model\Button.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */