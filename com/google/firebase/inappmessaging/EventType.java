package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

public enum EventType implements Internal.EnumLite {
  CLICK_EVENT_TYPE,
  IMPRESSION_EVENT_TYPE,
  UNKNOWN_EVENT_TYPE(0);
  
  public static final int CLICK_EVENT_TYPE_VALUE = 2;
  
  public static final int IMPRESSION_EVENT_TYPE_VALUE = 1;
  
  public static final int UNKNOWN_EVENT_TYPE_VALUE = 0;
  
  private static final Internal.EnumLiteMap<EventType> internalValueMap;
  
  private final int value;
  
  static {
    IMPRESSION_EVENT_TYPE = new EventType("IMPRESSION_EVENT_TYPE", 1, 1);
    CLICK_EVENT_TYPE = new EventType("CLICK_EVENT_TYPE", 2, 2);
    $VALUES = new EventType[] { UNKNOWN_EVENT_TYPE, IMPRESSION_EVENT_TYPE, CLICK_EVENT_TYPE };
    internalValueMap = new Internal.EnumLiteMap<EventType>() {
        public EventType findValueByNumber(int param1Int) {
          return EventType.forNumber(param1Int);
        }
      };
  }
  
  EventType(int paramInt1) {
    this.value = paramInt1;
  }
  
  public static EventType forNumber(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 2:
        return CLICK_EVENT_TYPE;
      case 1:
        return IMPRESSION_EVENT_TYPE;
      case 0:
        break;
    } 
    return UNKNOWN_EVENT_TYPE;
  }
  
  public static Internal.EnumLiteMap<EventType> internalGetValueMap() {
    return internalValueMap;
  }
  
  public final int getNumber() {
    return this.value;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\EventType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */