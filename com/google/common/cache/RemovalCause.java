package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public enum RemovalCause {
  COLLECTED,
  EXPIRED,
  EXPLICIT {
    boolean wasEvicted() {
      return false;
    }
  },
  REPLACED {
    boolean wasEvicted() {
      return false;
    }
  },
  SIZE;
  
  static {
    COLLECTED = new null("COLLECTED", 2);
    EXPIRED = new null("EXPIRED", 3);
    SIZE = new null("SIZE", 4);
    $VALUES = new RemovalCause[] { EXPLICIT, REPLACED, COLLECTED, EXPIRED, SIZE };
  }
  
  abstract boolean wasEvicted();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\cache\RemovalCause.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */