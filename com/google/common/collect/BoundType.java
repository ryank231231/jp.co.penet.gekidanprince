package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public enum BoundType {
  CLOSED,
  OPEN {
    BoundType flip() {
      return CLOSED;
    }
  };
  
  static {
    CLOSED = new null("CLOSED", 1);
    $VALUES = new BoundType[] { OPEN, CLOSED };
  }
  
  static BoundType forBoolean(boolean paramBoolean) {
    BoundType boundType;
    if (paramBoolean) {
      boundType = CLOSED;
    } else {
      boundType = OPEN;
    } 
    return boundType;
  }
  
  abstract BoundType flip();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\BoundType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */