package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.MessagesProto;

public class Action {
  private final String actionUrl;
  
  private final Button button;
  
  public Action(String paramString, Button paramButton) {
    this.actionUrl = paramString;
    this.button = paramButton;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public String getActionUrl() {
    return this.actionUrl;
  }
  
  public Button getButton() {
    return this.button;
  }
  
  static class Builder {
    private String actionUrl;
    
    private Button button;
    
    Action build() {
      return new Action(this.actionUrl, this.button);
    }
    
    Builder setActionUrl(String param1String) {
      if (!TextUtils.isEmpty(param1String))
        this.actionUrl = param1String; 
      return this;
    }
    
    Builder setButton(MessagesProto.Button param1Button) {
      Button.Builder builder = new Button.Builder();
      builder.setButtonHexColor(param1Button.getButtonHexColor());
      builder.setText(param1Button.getText());
      return this;
    }
    
    Builder setButton(Button param1Button) {
      this.button = param1Button;
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\model\Action.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */