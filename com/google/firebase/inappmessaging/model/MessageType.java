package com.google.firebase.inappmessaging.model;

import android.support.annotation.Keep;

@Keep
public enum MessageType {
  BANNER, CARD, IMAGE_ONLY, MODAL, UNSUPPORTED;
  
  static {
    MODAL = new MessageType("MODAL", 1);
    IMAGE_ONLY = new MessageType("IMAGE_ONLY", 2);
    BANNER = new MessageType("BANNER", 3);
    CARD = new MessageType("CARD", 4);
    $VALUES = new MessageType[] { UNSUPPORTED, MODAL, IMAGE_ONLY, BANNER, CARD };
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\model\MessageType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */