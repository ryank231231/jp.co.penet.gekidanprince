package com.google.android.vending.licensing;

public class StrictPolicy implements Policy {
  private int mLastResponse = 291;
  
  public boolean allowAccess() {
    boolean bool;
    if (this.mLastResponse == 256) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void processServerResponse(int paramInt, ResponseData paramResponseData) {
    this.mLastResponse = paramInt;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\vending\licensing\StrictPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */