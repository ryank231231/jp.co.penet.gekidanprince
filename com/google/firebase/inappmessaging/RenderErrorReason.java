package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

public enum RenderErrorReason implements Internal.EnumLite {
  IMAGE_DISPLAY_ERROR,
  IMAGE_FETCH_ERROR,
  IMAGE_UNSUPPORTED_FORMAT,
  UNSPECIFIED_RENDER_ERROR(0);
  
  public static final int IMAGE_DISPLAY_ERROR_VALUE = 2;
  
  public static final int IMAGE_FETCH_ERROR_VALUE = 1;
  
  public static final int IMAGE_UNSUPPORTED_FORMAT_VALUE = 3;
  
  public static final int UNSPECIFIED_RENDER_ERROR_VALUE = 0;
  
  private static final Internal.EnumLiteMap<RenderErrorReason> internalValueMap;
  
  private final int value;
  
  static {
    IMAGE_FETCH_ERROR = new RenderErrorReason("IMAGE_FETCH_ERROR", 1, 1);
    IMAGE_DISPLAY_ERROR = new RenderErrorReason("IMAGE_DISPLAY_ERROR", 2, 2);
    IMAGE_UNSUPPORTED_FORMAT = new RenderErrorReason("IMAGE_UNSUPPORTED_FORMAT", 3, 3);
    $VALUES = new RenderErrorReason[] { UNSPECIFIED_RENDER_ERROR, IMAGE_FETCH_ERROR, IMAGE_DISPLAY_ERROR, IMAGE_UNSUPPORTED_FORMAT };
    internalValueMap = new Internal.EnumLiteMap<RenderErrorReason>() {
        public RenderErrorReason findValueByNumber(int param1Int) {
          return RenderErrorReason.forNumber(param1Int);
        }
      };
  }
  
  RenderErrorReason(int paramInt1) {
    this.value = paramInt1;
  }
  
  public static RenderErrorReason forNumber(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 3:
        return IMAGE_UNSUPPORTED_FORMAT;
      case 2:
        return IMAGE_DISPLAY_ERROR;
      case 1:
        return IMAGE_FETCH_ERROR;
      case 0:
        break;
    } 
    return UNSPECIFIED_RENDER_ERROR;
  }
  
  public static Internal.EnumLiteMap<RenderErrorReason> internalGetValueMap() {
    return internalValueMap;
  }
  
  public final int getNumber() {
    return this.value;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\RenderErrorReason.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */