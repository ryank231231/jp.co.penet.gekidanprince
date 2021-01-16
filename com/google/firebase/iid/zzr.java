package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import java.io.IOException;
import java.util.concurrent.Executor;

final class zzr implements MessagingChannel {
  private final FirebaseApp zzao;
  
  private final zzan zzap;
  
  private final zzat zzbj;
  
  private final Executor zzbk;
  
  zzr(FirebaseApp paramFirebaseApp, zzan paramzzan, Executor paramExecutor) {
    this(paramFirebaseApp, paramzzan, paramExecutor, new zzat(paramFirebaseApp.getApplicationContext(), paramzzan));
  }
  
  @VisibleForTesting
  private zzr(FirebaseApp paramFirebaseApp, zzan paramzzan, Executor paramExecutor, zzat paramzzat) {
    this.zzao = paramFirebaseApp;
    this.zzap = paramzzan;
    this.zzbj = paramzzat;
    this.zzbk = paramExecutor;
  }
  
  private final Task<Bundle> zza(String paramString1, String paramString2, String paramString3, Bundle paramBundle) {
    paramBundle.putString("scope", paramString3);
    paramBundle.putString("sender", paramString2);
    paramBundle.putString("subtype", paramString2);
    paramBundle.putString("appid", paramString1);
    paramBundle.putString("gmp_app_id", this.zzao.getOptions().getApplicationId());
    paramBundle.putString("gmsv", Integer.toString(this.zzap.zzaf()));
    paramBundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
    paramBundle.putString("app_ver", this.zzap.zzad());
    paramBundle.putString("app_ver_name", this.zzap.zzae());
    paramBundle.putString("cliv", "fiid-12451000");
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    this.zzbk.execute(new zzs(this, paramBundle, taskCompletionSource));
    return taskCompletionSource.getTask();
  }
  
  private static String zza(Bundle paramBundle) throws IOException {
    if (paramBundle != null) {
      String str = paramBundle.getString("registration_id");
      if (str != null)
        return str; 
      str = paramBundle.getString("unregistered");
      if (str != null)
        return str; 
      str = paramBundle.getString("error");
      if (!"RST".equals(str)) {
        if (str != null)
          throw new IOException(str); 
        str = String.valueOf(paramBundle);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 21);
        stringBuilder.append("Unexpected response: ");
        stringBuilder.append(str);
        Log.w("FirebaseInstanceId", stringBuilder.toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
      } 
      throw new IOException("INSTANCE_ID_RESET");
    } 
    throw new IOException("SERVICE_NOT_AVAILABLE");
  }
  
  private final <T> Task<Void> zzb(Task<T> paramTask) {
    return paramTask.continueWith(zzi.zzf(), new zzt(this));
  }
  
  private final Task<String> zzc(Task<Bundle> paramTask) {
    return paramTask.continueWith(this.zzbk, new zzu(this));
  }
  
  public final Task<Void> ackMessage(String paramString) {
    return null;
  }
  
  public final Task<Void> buildChannel(String paramString1, String paramString2) {
    return Tasks.forResult(null);
  }
  
  public final Task<Void> deleteInstanceId(String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("iid-operation", "delete");
    bundle.putString("delete", "1");
    return zzb(zzc(zza(paramString, "*", "*", bundle)));
  }
  
  public final Task<Void> deleteToken(String paramString1, String paramString2, String paramString3, String paramString4) {
    Bundle bundle = new Bundle();
    bundle.putString("delete", "1");
    return zzb(zzc(zza(paramString1, paramString3, paramString4, bundle)));
  }
  
  public final Task<String> getToken(String paramString1, String paramString2, String paramString3, String paramString4) {
    return zzc(zza(paramString1, paramString3, paramString4, new Bundle()));
  }
  
  public final boolean isAvailable() {
    return (this.zzap.zzac() != 0);
  }
  
  public final boolean isChannelBuilt() {
    return true;
  }
  
  public final boolean needsRefresh() {
    return false;
  }
  
  public final Task<Void> subscribeToTopic(String paramString1, String paramString2, String paramString3) {
    Bundle bundle = new Bundle();
    String str1 = String.valueOf("/topics/");
    String str2 = String.valueOf(paramString3);
    if (str2.length() != 0) {
      str2 = str1.concat(str2);
    } else {
      str2 = new String(str1);
    } 
    bundle.putString("gcm.topic", str2);
    str2 = String.valueOf("/topics/");
    paramString3 = String.valueOf(paramString3);
    if (paramString3.length() != 0) {
      paramString3 = str2.concat(paramString3);
    } else {
      paramString3 = new String(str2);
    } 
    return zzb(zzc(zza(paramString1, paramString2, paramString3, bundle)));
  }
  
  public final Task<Void> unsubscribeFromTopic(String paramString1, String paramString2, String paramString3) {
    Bundle bundle = new Bundle();
    String str1 = String.valueOf("/topics/");
    String str2 = String.valueOf(paramString3);
    if (str2.length() != 0) {
      str1 = str1.concat(str2);
    } else {
      str1 = new String(str1);
    } 
    bundle.putString("gcm.topic", str1);
    bundle.putString("delete", "1");
    str1 = String.valueOf("/topics/");
    paramString3 = String.valueOf(paramString3);
    if (paramString3.length() != 0) {
      paramString3 = str1.concat(paramString3);
    } else {
      paramString3 = new String(str1);
    } 
    return zzb(zzc(zza(paramString1, paramString2, paramString3, bundle)));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */