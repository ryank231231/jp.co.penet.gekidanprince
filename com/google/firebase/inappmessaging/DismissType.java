package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

public enum DismissType implements Internal.EnumLite {
  AUTO,
  CLICK,
  SWIPE,
  UNKNOWN_DISMISS_TYPE(0);
  
  public static final int AUTO_VALUE = 1;
  
  public static final int CLICK_VALUE = 2;
  
  public static final int SWIPE_VALUE = 3;
  
  public static final int UNKNOWN_DISMISS_TYPE_VALUE = 0;
  
  private static final Internal.EnumLiteMap<DismissType> internalValueMap;
  
  private final int value;
  
  static {
    AUTO = new DismissType("AUTO", 1, 1);
    CLICK = new DismissType("CLICK", 2, 2);
    SWIPE = new DismissType("SWIPE", 3, 3);
    $VALUES = new DismissType[] { UNKNOWN_DISMISS_TYPE, AUTO, CLICK, SWIPE };
    internalValueMap = new Internal.EnumLiteMap<DismissType>() {
        public DismissType findValueByNumber(int param1Int) {
          return DismissType.forNumber(param1Int);
        }
      };
  }
  
  DismissType(int paramInt1) {
    this.value = paramInt1;
  }
  
  public static DismissType forNumber(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 3:
        return SWIPE;
      case 2:
        return CLICK;
      case 1:
        return AUTO;
      case 0:
        break;
    } 
    return UNKNOWN_DISMISS_TYPE;
  }
  
  public static Internal.EnumLiteMap<DismissType> internalGetValueMap() {
    return internalValueMap;
  }
  
  public final int getNumber() {
    return this.value;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\DismissType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */