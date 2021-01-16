package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.regex.Pattern;

public class FirebaseMessaging {
  public static final String INSTANCE_ID_SCOPE = "FCM";
  
  private static final Pattern zzdr = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
  
  private static FirebaseMessaging zzds;
  
  private final FirebaseInstanceId zzdl;
  
  private FirebaseMessaging(FirebaseInstanceId paramFirebaseInstanceId) {
    this.zzdl = paramFirebaseInstanceId;
  }
  
  public static FirebaseMessaging getInstance() {
    // Byte code:
    //   0: ldc com/google/firebase/messaging/FirebaseMessaging
    //   2: monitorenter
    //   3: getstatic com/google/firebase/messaging/FirebaseMessaging.zzds : Lcom/google/firebase/messaging/FirebaseMessaging;
    //   6: ifnonnull -> 24
    //   9: new com/google/firebase/messaging/FirebaseMessaging
    //   12: astore_0
    //   13: aload_0
    //   14: invokestatic getInstance : ()Lcom/google/firebase/iid/FirebaseInstanceId;
    //   17: invokespecial <init> : (Lcom/google/firebase/iid/FirebaseInstanceId;)V
    //   20: aload_0
    //   21: putstatic com/google/firebase/messaging/FirebaseMessaging.zzds : Lcom/google/firebase/messaging/FirebaseMessaging;
    //   24: getstatic com/google/firebase/messaging/FirebaseMessaging.zzds : Lcom/google/firebase/messaging/FirebaseMessaging;
    //   27: astore_0
    //   28: ldc com/google/firebase/messaging/FirebaseMessaging
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: astore_0
    //   34: ldc com/google/firebase/messaging/FirebaseMessaging
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   3	24	33	finally
    //   24	28	33	finally
  }
  
  public boolean isAutoInitEnabled() {
    return this.zzdl.zzq();
  }
  
  public void send(RemoteMessage paramRemoteMessage) {
    if (!TextUtils.isEmpty(paramRemoteMessage.getTo())) {
      Context context = FirebaseApp.getInstance().getApplicationContext();
      Intent intent1 = new Intent("com.google.android.gcm.intent.SEND");
      Intent intent2 = new Intent();
      intent2.setPackage("com.google.example.invalidpackage");
      intent1.putExtra("app", (Parcelable)PendingIntent.getBroadcast(context, 0, intent2, 0));
      intent1.setPackage("com.google.android.gms");
      intent1.putExtras(paramRemoteMessage.zzdu);
      context.sendOrderedBroadcast(intent1, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
      return;
    } 
    throw new IllegalArgumentException("Missing 'to'");
  }
  
  public void setAutoInitEnabled(boolean paramBoolean) {
    this.zzdl.zzb(paramBoolean);
  }
  
  public Task<Void> subscribeToTopic(String paramString) {
    String str = paramString;
    if (paramString != null) {
      str = paramString;
      if (paramString.startsWith("/topics/")) {
        Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in subscribeToTopic.");
        str = paramString.substring(8);
      } 
    } 
    if (str != null && zzdr.matcher(str).matches()) {
      FirebaseInstanceId firebaseInstanceId = this.zzdl;
      paramString = String.valueOf("S!");
      str = String.valueOf(str);
      if (str.length() != 0) {
        paramString = paramString.concat(str);
      } else {
        paramString = new String(paramString);
      } 
      return firebaseInstanceId.zza(paramString);
    } 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 78);
    stringBuilder.append("Invalid topic name: ");
    stringBuilder.append(str);
    stringBuilder.append(" does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public Task<Void> unsubscribeFromTopic(String paramString) {
    String str = paramString;
    if (paramString != null) {
      str = paramString;
      if (paramString.startsWith("/topics/")) {
        Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in unsubscribeFromTopic.");
        str = paramString.substring(8);
      } 
    } 
    if (str != null && zzdr.matcher(str).matches()) {
      FirebaseInstanceId firebaseInstanceId = this.zzdl;
      paramString = String.valueOf("U!");
      str = String.valueOf(str);
      if (str.length() != 0) {
        paramString = paramString.concat(str);
      } else {
        paramString = new String(paramString);
      } 
      return firebaseInstanceId.zza(paramString);
    } 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 78);
    stringBuilder.append("Invalid topic name: ");
    stringBuilder.append(str);
    stringBuilder.append(" does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\messaging\FirebaseMessaging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */