package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.zzc;

@KeepForSdk
public final class Preconditions {
  private Preconditions() {
    throw new AssertionError("Uninstantiable");
  }
  
  @KeepForSdk
  public static void checkArgument(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException();
  }
  
  @KeepForSdk
  public static void checkArgument(boolean paramBoolean, Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  @KeepForSdk
  public static void checkArgument(boolean paramBoolean, String paramString, Object... paramVarArgs) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
  }
  
  @KeepForSdk
  public static void checkHandlerThread(Handler paramHandler) {
    checkHandlerThread(paramHandler, "Must be called on the handler thread");
  }
  
  @KeepForSdk
  public static void checkHandlerThread(Handler paramHandler, String paramString) {
    if (Looper.myLooper() == paramHandler.getLooper())
      return; 
    throw new IllegalStateException(paramString);
  }
  
  @KeepForSdk
  public static void checkMainThread(String paramString) {
    if (zzc.isMainThread())
      return; 
    throw new IllegalStateException(paramString);
  }
  
  @KeepForSdk
  public static String checkNotEmpty(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      return paramString; 
    throw new IllegalArgumentException("Given String is empty or null");
  }
  
  @KeepForSdk
  public static String checkNotEmpty(String paramString, Object paramObject) {
    if (!TextUtils.isEmpty(paramString))
      return paramString; 
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  @KeepForSdk
  public static void checkNotMainThread() {
    checkNotMainThread("Must not be called on the main application thread");
  }
  
  @KeepForSdk
  public static void checkNotMainThread(String paramString) {
    if (!zzc.isMainThread())
      return; 
    throw new IllegalStateException(paramString);
  }
  
  @NonNull
  @KeepForSdk
  public static <T> T checkNotNull(@Nullable T paramT) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException("null reference");
  }
  
  @NonNull
  @KeepForSdk
  public static <T> T checkNotNull(T paramT, Object paramObject) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  @KeepForSdk
  public static int checkNotZero(int paramInt) {
    if (paramInt != 0)
      return paramInt; 
    throw new IllegalArgumentException("Given Integer is zero");
  }
  
  @KeepForSdk
  public static int checkNotZero(int paramInt, Object paramObject) {
    if (paramInt != 0)
      return paramInt; 
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  @KeepForSdk
  public static long checkNotZero(long paramLong) {
    if (paramLong != 0L)
      return paramLong; 
    throw new IllegalArgumentException("Given Long is zero");
  }
  
  @KeepForSdk
  public static long checkNotZero(long paramLong, Object paramObject) {
    if (paramLong != 0L)
      return paramLong; 
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  @KeepForSdk
  public static void checkState(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException();
  }
  
  @KeepForSdk
  public static void checkState(boolean paramBoolean, Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(String.valueOf(paramObject));
  }
  
  @KeepForSdk
  public static void checkState(boolean paramBoolean, String paramString, Object... paramVarArgs) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(String.format(paramString, paramVarArgs));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */