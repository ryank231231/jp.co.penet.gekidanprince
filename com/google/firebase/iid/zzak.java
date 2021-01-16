package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzak<T> {
  final int what;
  
  final int zzcg;
  
  final TaskCompletionSource<T> zzch = new TaskCompletionSource();
  
  final Bundle zzci;
  
  zzak(int paramInt1, int paramInt2, Bundle paramBundle) {
    this.zzcg = paramInt1;
    this.what = paramInt2;
    this.zzci = paramBundle;
  }
  
  final void finish(T paramT) {
    if (Log.isLoggable("MessengerIpcClient", 3)) {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(paramT);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 16 + String.valueOf(str2).length());
      stringBuilder.append("Finishing ");
      stringBuilder.append(str1);
      stringBuilder.append(" with ");
      stringBuilder.append(str2);
      Log.d("MessengerIpcClient", stringBuilder.toString());
    } 
    this.zzch.setResult(paramT);
  }
  
  public String toString() {
    int i = this.what;
    int j = this.zzcg;
    boolean bool = zzab();
    StringBuilder stringBuilder = new StringBuilder(55);
    stringBuilder.append("Request { what=");
    stringBuilder.append(i);
    stringBuilder.append(" id=");
    stringBuilder.append(j);
    stringBuilder.append(" oneWay=");
    stringBuilder.append(bool);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  final void zza(zzal paramzzal) {
    if (Log.isLoggable("MessengerIpcClient", 3)) {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(paramzzal);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 14 + String.valueOf(str2).length());
      stringBuilder.append("Failing ");
      stringBuilder.append(str1);
      stringBuilder.append(" with ");
      stringBuilder.append(str2);
      Log.d("MessengerIpcClient", stringBuilder.toString());
    } 
    this.zzch.setException(paramzzal);
  }
  
  abstract boolean zzab();
  
  abstract void zzb(Bundle paramBundle);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */