package com.android.vending.billing.util;

public class IabException extends Exception {
  IabResult mResult;
  
  public IabException(int paramInt, String paramString) {
    this(new IabResult(paramInt, paramString));
  }
  
  public IabException(int paramInt, String paramString, Exception paramException) {
    this(new IabResult(paramInt, paramString), paramException);
  }
  
  public IabException(IabResult paramIabResult) {
    this(paramIabResult, (Exception)null);
  }
  
  public IabException(IabResult paramIabResult, Exception paramException) {
    super(paramIabResult.getMessage(), paramException);
    this.mResult = paramIabResult;
  }
  
  public IabResult getResult() {
    return this.mResult;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\android\vending\billin\\util\IabException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */