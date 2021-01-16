package com.google.api;

import com.google.protobuf.Internal;

public enum ChangeType implements Internal.EnumLite {
  ADDED,
  CHANGE_TYPE_UNSPECIFIED(0),
  MODIFIED(0),
  REMOVED(0),
  UNRECOGNIZED(0);
  
  public static final int ADDED_VALUE = 1;
  
  public static final int CHANGE_TYPE_UNSPECIFIED_VALUE = 0;
  
  public static final int MODIFIED_VALUE = 3;
  
  public static final int REMOVED_VALUE = 2;
  
  private static final Internal.EnumLiteMap<ChangeType> internalValueMap;
  
  private final int value;
  
  static {
    ADDED = new ChangeType("ADDED", 1, 1);
    REMOVED = new ChangeType("REMOVED", 2, 2);
    MODIFIED = new ChangeType("MODIFIED", 3, 3);
    UNRECOGNIZED = new ChangeType("UNRECOGNIZED", 4, -1);
    $VALUES = new ChangeType[] { CHANGE_TYPE_UNSPECIFIED, ADDED, REMOVED, MODIFIED, UNRECOGNIZED };
    internalValueMap = new Internal.EnumLiteMap<ChangeType>() {
        public ChangeType findValueByNumber(int param1Int) {
          return ChangeType.forNumber(param1Int);
        }
      };
  }
  
  ChangeType(int paramInt1) {
    this.value = paramInt1;
  }
  
  public static ChangeType forNumber(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 3:
        return MODIFIED;
      case 2:
        return REMOVED;
      case 1:
        return ADDED;
      case 0:
        break;
    } 
    return CHANGE_TYPE_UNSPECIFIED;
  }
  
  public static Internal.EnumLiteMap<ChangeType> internalGetValueMap() {
    return internalValueMap;
  }
  
  public final int getNumber() {
    return this.value;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\ChangeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */