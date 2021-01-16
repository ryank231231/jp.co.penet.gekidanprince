package com.google.firebase.inappmessaging.model;

public class TriggeredInAppMessage {
  private InAppMessage inAppMessage;
  
  private String triggeringEvent;
  
  public TriggeredInAppMessage(InAppMessage paramInAppMessage, String paramString) {
    this.inAppMessage = paramInAppMessage;
    this.triggeringEvent = paramString;
  }
  
  public InAppMessage getInAppMessage() {
    return this.inAppMessage;
  }
  
  public String getTriggeringEvent() {
    return this.triggeringEvent;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\model\TriggeredInAppMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */