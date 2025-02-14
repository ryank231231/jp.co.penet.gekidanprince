package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class Asserts {
  private Asserts() {
    throw new AssertionError("Uninstantiable");
  }
  
  @KeepForSdk
  public static void checkMainThread(String paramString) {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
      return; 
    String str1 = String.valueOf(Thread.currentThread());
    String str2 = String.valueOf(Looper.getMainLooper().getThread());
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 57 + String.valueOf(str2).length());
    stringBuilder.append("checkMainThread: current thread ");
    stringBuilder.append(str1);
    stringBuilder.append(" IS NOT the main thread ");
    stringBuilder.append(str2);
    stringBuilder.append("!");
    Log.e("Asserts", stringBuilder.toString());
    throw new IllegalStateException(paramString);
  }
  
  @KeepForSdk
  public static void checkNotMainThread(String paramString) {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
      return; 
    String str1 = String.valueOf(Thread.currentThread());
    String str2 = String.valueOf(Looper.getMainLooper().getThread());
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 56 + String.valueOf(str2).length());
    stringBuilder.append("checkNotMainThread: current thread ");
    stringBuilder.append(str1);
    stringBuilder.append(" IS the main thread ");
    stringBuilder.append(str2);
    stringBuilder.append("!");
    Log.e("Asserts", stringBuilder.toString());
    throw new IllegalStateException(paramString);
  }
  
  @KeepForSdk
  public static void checkNotNull(Object paramObject) {
    if (paramObject != null)
      return; 
    throw new IllegalArgumentException("null reference");
  }
  
  @KeepForSdk
  public static void checkNotNull(Object paramObject1, Object paramObject2) {
    if (paramObject1 != null)
      return; 
    throw new IllegalArgumentException(String.valueOf(paramObject2));
  }
  
  @KeepForSdk
  public static void checkNull(Object paramObject) {
    if (paramObject == null)
      return; 
    throw new IllegalArgumentException("non-null reference");
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
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\Asserts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */