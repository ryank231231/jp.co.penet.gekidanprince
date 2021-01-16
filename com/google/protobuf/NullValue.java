package com.google.protobuf;

public enum NullValue implements Internal.EnumLite {
  NULL_VALUE(0),
  UNRECOGNIZED(-1);
  
  public static final int NULL_VALUE_VALUE = 0;
  
  private static final Internal.EnumLiteMap<NullValue> internalValueMap;
  
  private final int value;
  
  static {
    $VALUES = new NullValue[] { NULL_VALUE, UNRECOGNIZED };
    internalValueMap = new Internal.EnumLiteMap<NullValue>() {
        public NullValue findValueByNumber(int param1Int) {
          return NullValue.forNumber(param1Int);
        }
      };
  }
  
  NullValue(int paramInt1) {
    this.value = paramInt1;
  }
  
  public static NullValue forNumber(int paramInt) {
    return (paramInt != 0) ? null : NULL_VALUE;
  }
  
  public static Internal.EnumLiteMap<NullValue> internalGetValueMap() {
    return internalValueMap;
  }
  
  public final int getNumber() {
    return this.value;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\NullValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */