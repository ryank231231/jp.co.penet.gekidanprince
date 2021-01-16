package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

public enum FetchErrorReason implements Internal.EnumLite {
  CLIENT_ERROR,
  NETWORK_ERROR,
  SERVER_ERROR,
  UNSPECIFIED_FETCH_ERROR(0);
  
  public static final int CLIENT_ERROR_VALUE = 2;
  
  public static final int NETWORK_ERROR_VALUE = 3;
  
  public static final int SERVER_ERROR_VALUE = 1;
  
  public static final int UNSPECIFIED_FETCH_ERROR_VALUE = 0;
  
  private static final Internal.EnumLiteMap<FetchErrorReason> internalValueMap;
  
  private final int value;
  
  static {
    SERVER_ERROR = new FetchErrorReason("SERVER_ERROR", 1, 1);
    CLIENT_ERROR = new FetchErrorReason("CLIENT_ERROR", 2, 2);
    NETWORK_ERROR = new FetchErrorReason("NETWORK_ERROR", 3, 3);
    $VALUES = new FetchErrorReason[] { UNSPECIFIED_FETCH_ERROR, SERVER_ERROR, CLIENT_ERROR, NETWORK_ERROR };
    internalValueMap = new Internal.EnumLiteMap<FetchErrorReason>() {
        public FetchErrorReason findValueByNumber(int param1Int) {
          return FetchErrorReason.forNumber(param1Int);
        }
      };
  }
  
  FetchErrorReason(int paramInt1) {
    this.value = paramInt1;
  }
  
  public static FetchErrorReason forNumber(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 3:
        return NETWORK_ERROR;
      case 2:
        return CLIENT_ERROR;
      case 1:
        return SERVER_ERROR;
      case 0:
        break;
    } 
    return UNSPECIFIED_FETCH_ERROR;
  }
  
  public static Internal.EnumLiteMap<FetchErrorReason> internalGetValueMap() {
    return internalValueMap;
  }
  
  public final int getNumber() {
    return this.value;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\FetchErrorReason.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */