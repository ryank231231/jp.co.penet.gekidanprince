package com.squareup.picasso;

public enum NetworkPolicy {
  NO_CACHE(1),
  NO_STORE(2),
  OFFLINE(4);
  
  final int index;
  
  static {
    $VALUES = new NetworkPolicy[] { NO_CACHE, NO_STORE, OFFLINE };
  }
  
  NetworkPolicy(int paramInt1) {
    this.index = paramInt1;
  }
  
  public static boolean isOfflineOnly(int paramInt) {
    boolean bool;
    if ((paramInt & OFFLINE.index) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static boolean shouldReadFromDiskCache(int paramInt) {
    boolean bool;
    if ((paramInt & NO_CACHE.index) == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static boolean shouldWriteToDiskCache(int paramInt) {
    boolean bool;
    if ((paramInt & NO_STORE.index) == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\picasso\NetworkPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */