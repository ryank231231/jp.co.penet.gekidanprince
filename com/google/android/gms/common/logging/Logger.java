package com.google.android.gms.common.logging;

import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

@KeepForSdk
public class Logger {
  private final String mTag;
  
  private final String zzei;
  
  private final GmsLogger zzew;
  
  private final int zzex;
  
  private Logger(String paramString1, String paramString2) {
    this.zzei = paramString2;
    this.mTag = paramString1;
    this.zzew = new GmsLogger(paramString1);
    byte b;
    for (b = 2; 7 >= b && !Log.isLoggable(this.mTag, b); b++);
    this.zzex = b;
  }
  
  @KeepForSdk
  public Logger(String paramString, String... paramVarArgs) {
    this(paramString, str);
  }
  
  private final String format(String paramString, @Nullable Object... paramVarArgs) {
    String str = paramString;
    if (paramVarArgs != null) {
      str = paramString;
      if (paramVarArgs.length > 0)
        str = String.format(Locale.US, paramString, paramVarArgs); 
    } 
    return this.zzei.concat(str);
  }
  
  @KeepForSdk
  public void d(String paramString, @Nullable Object... paramVarArgs) {
    if (isLoggable(3))
      Log.d(this.mTag, format(paramString, paramVarArgs)); 
  }
  
  @KeepForSdk
  public void e(String paramString, Throwable paramThrowable, @Nullable Object... paramVarArgs) {
    Log.e(this.mTag, format(paramString, paramVarArgs), paramThrowable);
  }
  
  @KeepForSdk
  public void e(String paramString, @Nullable Object... paramVarArgs) {
    Log.e(this.mTag, format(paramString, paramVarArgs));
  }
  
  @KeepForSdk
  public void i(String paramString, @Nullable Object... paramVarArgs) {
    Log.i(this.mTag, format(paramString, paramVarArgs));
  }
  
  @KeepForSdk
  public boolean isLoggable(int paramInt) {
    return (this.zzex <= paramInt);
  }
  
  @KeepForSdk
  public void v(String paramString, @Nullable Object... paramVarArgs) {
    if (isLoggable(2))
      Log.v(this.mTag, format(paramString, paramVarArgs)); 
  }
  
  @KeepForSdk
  public void w(String paramString, @Nullable Object... paramVarArgs) {
    Log.w(this.mTag, format(paramString, paramVarArgs));
  }
  
  @KeepForSdk
  public void wtf(String paramString, Throwable paramThrowable, @Nullable Object... paramVarArgs) {
    Log.wtf(this.mTag, format(paramString, paramVarArgs), paramThrowable);
  }
  
  @KeepForSdk
  public void wtf(Throwable paramThrowable) {
    Log.wtf(this.mTag, paramThrowable);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\logging\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */