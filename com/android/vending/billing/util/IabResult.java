package com.android.vending.billing.util;

public class IabResult {
  String mMessage;
  
  int mResponse;
  
  public IabResult(int paramInt, String paramString) {
    this.mResponse = paramInt;
    if (paramString == null || paramString.trim().length() == 0) {
      this.mMessage = IabHelper.getResponseDesc(paramInt);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" (response: ");
    stringBuilder.append(IabHelper.getResponseDesc(paramInt));
    stringBuilder.append(")");
    this.mMessage = stringBuilder.toString();
  }
  
  public String getMessage() {
    return this.mMessage;
  }
  
  public int getResponse() {
    return this.mResponse;
  }
  
  public boolean isFailure() {
    return isSuccess() ^ true;
  }
  
  public boolean isSuccess() {
    boolean bool;
    if (this.mResponse == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("IabResult: ");
    stringBuilder.append(getMessage());
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\android\vending\billin\\util\IabResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */