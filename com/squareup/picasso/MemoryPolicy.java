package com.squareup.picasso;

public enum MemoryPolicy {
  NO_CACHE(1),
  NO_STORE(2);
  
  final int index;
  
  static {
    $VALUES = new MemoryPolicy[] { NO_CACHE, NO_STORE };
  }
  
  MemoryPolicy(int paramInt1) {
    this.index = paramInt1;
  }
  
  static boolean shouldReadFromMemoryCache(int paramInt) {
    boolean bool;
    if ((paramInt & NO_CACHE.index) == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  static boolean shouldWriteToMemoryCache(int paramInt) {
    boolean bool;
    if ((paramInt & NO_STORE.index) == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\picasso\MemoryPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */