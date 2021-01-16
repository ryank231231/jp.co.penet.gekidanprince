package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.firebase.iid.zzav;
import com.google.firebase.iid.zzb;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class FirebaseMessagingService extends zzb {
  private static final Queue<String> zzdt = new ArrayDeque<String>(10);
  
  static void zzj(Bundle paramBundle) {
    Iterator<String> iterator = paramBundle.keySet().iterator();
    while (iterator.hasNext()) {
      String str = iterator.next();
      if (str != null && str.startsWith("google.c."))
        iterator.remove(); 
    } 
  }
  
  @WorkerThread
  public void onDeletedMessages() {}
  
  @WorkerThread
  public void onMessageReceived(RemoteMessage paramRemoteMessage) {}
  
  @WorkerThread
  public void onMessageSent(String paramString) {}
  
  @WorkerThread
  public void onNewToken(String paramString) {}
  
  @WorkerThread
  public void onSendError(String paramString, Exception paramException) {}
  
  protected final Intent zzb(Intent paramIntent) {
    return zzav.zzai().zzaj();
  }
  
  public final boolean zzc(Intent paramIntent) {
    if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(paramIntent.getAction())) {
      PendingIntent pendingIntent = (PendingIntent)paramIntent.getParcelableExtra("pending_intent");
      if (pendingIntent != null)
        try {
          pendingIntent.send();
        } catch (android.app.PendingIntent.CanceledException canceledException) {
          Log.e("FirebaseMessaging", "Notification pending intent canceled");
        }  
      if (MessagingAnalytics.shouldUploadMetrics(paramIntent))
        MessagingAnalytics.logNotificationOpen(paramIntent); 
      return true;
    } 
    return false;
  }
  
  public final void zzd(Intent paramIntent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getAction : ()Ljava/lang/String;
    //   4: astore_2
    //   5: ldc 'com.google.android.c2dm.intent.RECEIVE'
    //   7: aload_2
    //   8: invokevirtual equals : (Ljava/lang/Object;)Z
    //   11: ifne -> 110
    //   14: ldc 'com.google.firebase.messaging.RECEIVE_DIRECT_BOOT'
    //   16: aload_2
    //   17: invokevirtual equals : (Ljava/lang/Object;)Z
    //   20: ifeq -> 26
    //   23: goto -> 110
    //   26: ldc 'com.google.firebase.messaging.NOTIFICATION_DISMISS'
    //   28: aload_2
    //   29: invokevirtual equals : (Ljava/lang/Object;)Z
    //   32: ifeq -> 47
    //   35: aload_1
    //   36: invokestatic shouldUploadMetrics : (Landroid/content/Intent;)Z
    //   39: ifeq -> 109
    //   42: aload_1
    //   43: invokestatic logNotificationDismiss : (Landroid/content/Intent;)V
    //   46: return
    //   47: ldc 'com.google.firebase.messaging.NEW_TOKEN'
    //   49: aload_2
    //   50: invokevirtual equals : (Ljava/lang/Object;)Z
    //   53: ifeq -> 67
    //   56: aload_0
    //   57: aload_1
    //   58: ldc 'token'
    //   60: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   63: invokevirtual onNewToken : (Ljava/lang/String;)V
    //   66: return
    //   67: aload_1
    //   68: invokevirtual getAction : ()Ljava/lang/String;
    //   71: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   74: astore_1
    //   75: aload_1
    //   76: invokevirtual length : ()I
    //   79: ifeq -> 92
    //   82: ldc 'Unknown intent action: '
    //   84: aload_1
    //   85: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   88: astore_1
    //   89: goto -> 102
    //   92: new java/lang/String
    //   95: dup
    //   96: ldc 'Unknown intent action: '
    //   98: invokespecial <init> : (Ljava/lang/String;)V
    //   101: astore_1
    //   102: ldc 'FirebaseMessaging'
    //   104: aload_1
    //   105: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   108: pop
    //   109: return
    //   110: aload_1
    //   111: ldc 'google.message_id'
    //   113: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   116: astore_3
    //   117: aload_3
    //   118: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   121: istore #4
    //   123: iconst_2
    //   124: istore #5
    //   126: iload #4
    //   128: ifeq -> 139
    //   131: aconst_null
    //   132: invokestatic forResult : (Ljava/lang/Object;)Lcom/google/android/gms/tasks/Task;
    //   135: astore_2
    //   136: goto -> 164
    //   139: new android/os/Bundle
    //   142: dup
    //   143: invokespecial <init> : ()V
    //   146: astore_2
    //   147: aload_2
    //   148: ldc 'google.message_id'
    //   150: aload_3
    //   151: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload_0
    //   155: invokestatic zzc : (Landroid/content/Context;)Lcom/google/firebase/iid/zzab;
    //   158: iconst_2
    //   159: aload_2
    //   160: invokevirtual zza : (ILandroid/os/Bundle;)Lcom/google/android/gms/tasks/Task;
    //   163: astore_2
    //   164: aload_3
    //   165: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   168: ifeq -> 177
    //   171: iconst_0
    //   172: istore #6
    //   174: goto -> 278
    //   177: getstatic com/google/firebase/messaging/FirebaseMessagingService.zzdt : Ljava/util/Queue;
    //   180: aload_3
    //   181: invokeinterface contains : (Ljava/lang/Object;)Z
    //   186: ifeq -> 243
    //   189: ldc 'FirebaseMessaging'
    //   191: iconst_3
    //   192: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   195: ifeq -> 237
    //   198: aload_3
    //   199: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   202: astore_3
    //   203: aload_3
    //   204: invokevirtual length : ()I
    //   207: ifeq -> 220
    //   210: ldc 'Received duplicate message: '
    //   212: aload_3
    //   213: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   216: astore_3
    //   217: goto -> 230
    //   220: new java/lang/String
    //   223: dup
    //   224: ldc 'Received duplicate message: '
    //   226: invokespecial <init> : (Ljava/lang/String;)V
    //   229: astore_3
    //   230: ldc 'FirebaseMessaging'
    //   232: aload_3
    //   233: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   236: pop
    //   237: iconst_1
    //   238: istore #6
    //   240: goto -> 278
    //   243: getstatic com/google/firebase/messaging/FirebaseMessagingService.zzdt : Ljava/util/Queue;
    //   246: invokeinterface size : ()I
    //   251: bipush #10
    //   253: if_icmplt -> 265
    //   256: getstatic com/google/firebase/messaging/FirebaseMessagingService.zzdt : Ljava/util/Queue;
    //   259: invokeinterface remove : ()Ljava/lang/Object;
    //   264: pop
    //   265: getstatic com/google/firebase/messaging/FirebaseMessagingService.zzdt : Ljava/util/Queue;
    //   268: aload_3
    //   269: invokeinterface add : (Ljava/lang/Object;)Z
    //   274: pop
    //   275: iconst_0
    //   276: istore #6
    //   278: iload #6
    //   280: ifne -> 626
    //   283: aload_1
    //   284: ldc 'message_type'
    //   286: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   289: astore #7
    //   291: aload #7
    //   293: astore_3
    //   294: aload #7
    //   296: ifnonnull -> 302
    //   299: ldc 'gcm'
    //   301: astore_3
    //   302: aload_3
    //   303: invokevirtual hashCode : ()I
    //   306: istore #6
    //   308: iload #6
    //   310: ldc -2062414158
    //   312: if_icmpeq -> 385
    //   315: iload #6
    //   317: ldc 102161
    //   319: if_icmpeq -> 370
    //   322: iload #6
    //   324: ldc 814694033
    //   326: if_icmpeq -> 355
    //   329: iload #6
    //   331: ldc 814800675
    //   333: if_icmpeq -> 339
    //   336: goto -> 400
    //   339: aload_3
    //   340: ldc 'send_event'
    //   342: invokevirtual equals : (Ljava/lang/Object;)Z
    //   345: ifeq -> 400
    //   348: iload #5
    //   350: istore #6
    //   352: goto -> 403
    //   355: aload_3
    //   356: ldc 'send_error'
    //   358: invokevirtual equals : (Ljava/lang/Object;)Z
    //   361: ifeq -> 400
    //   364: iconst_3
    //   365: istore #6
    //   367: goto -> 403
    //   370: aload_3
    //   371: ldc 'gcm'
    //   373: invokevirtual equals : (Ljava/lang/Object;)Z
    //   376: ifeq -> 400
    //   379: iconst_0
    //   380: istore #6
    //   382: goto -> 403
    //   385: aload_3
    //   386: ldc 'deleted_messages'
    //   388: invokevirtual equals : (Ljava/lang/Object;)Z
    //   391: ifeq -> 400
    //   394: iconst_1
    //   395: istore #6
    //   397: goto -> 403
    //   400: iconst_m1
    //   401: istore #6
    //   403: iload #6
    //   405: tableswitch default -> 436, 0 -> 522, 1 -> 515, 2 -> 502, 3 -> 458
    //   436: aload_3
    //   437: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   440: astore_1
    //   441: aload_1
    //   442: invokevirtual length : ()I
    //   445: ifeq -> 609
    //   448: ldc 'Received message with unknown type: '
    //   450: aload_1
    //   451: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   454: astore_1
    //   455: goto -> 619
    //   458: aload_1
    //   459: ldc 'google.message_id'
    //   461: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   464: astore #7
    //   466: aload #7
    //   468: astore_3
    //   469: aload #7
    //   471: ifnonnull -> 481
    //   474: aload_1
    //   475: ldc 'message_id'
    //   477: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   480: astore_3
    //   481: aload_0
    //   482: aload_3
    //   483: new com/google/firebase/messaging/SendException
    //   486: dup
    //   487: aload_1
    //   488: ldc 'error'
    //   490: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   493: invokespecial <init> : (Ljava/lang/String;)V
    //   496: invokevirtual onSendError : (Ljava/lang/String;Ljava/lang/Exception;)V
    //   499: goto -> 626
    //   502: aload_0
    //   503: aload_1
    //   504: ldc 'google.message_id'
    //   506: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   509: invokevirtual onMessageSent : (Ljava/lang/String;)V
    //   512: goto -> 626
    //   515: aload_0
    //   516: invokevirtual onDeletedMessages : ()V
    //   519: goto -> 626
    //   522: aload_1
    //   523: invokestatic shouldUploadMetrics : (Landroid/content/Intent;)Z
    //   526: ifeq -> 533
    //   529: aload_1
    //   530: invokestatic logNotificationReceived : (Landroid/content/Intent;)V
    //   533: aload_1
    //   534: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   537: astore #7
    //   539: aload #7
    //   541: astore_3
    //   542: aload #7
    //   544: ifnonnull -> 555
    //   547: new android/os/Bundle
    //   550: dup
    //   551: invokespecial <init> : ()V
    //   554: astore_3
    //   555: aload_3
    //   556: ldc 'android.support.content.wakelockid'
    //   558: invokevirtual remove : (Ljava/lang/String;)V
    //   561: aload_3
    //   562: invokestatic zzf : (Landroid/os/Bundle;)Z
    //   565: ifeq -> 594
    //   568: new com/google/firebase/messaging/zza
    //   571: dup
    //   572: aload_0
    //   573: invokespecial <init> : (Landroid/content/Context;)V
    //   576: aload_3
    //   577: invokevirtual zzh : (Landroid/os/Bundle;)Z
    //   580: ifne -> 626
    //   583: aload_1
    //   584: invokestatic shouldUploadMetrics : (Landroid/content/Intent;)Z
    //   587: ifeq -> 594
    //   590: aload_1
    //   591: invokestatic logNotificationForeground : (Landroid/content/Intent;)V
    //   594: aload_0
    //   595: new com/google/firebase/messaging/RemoteMessage
    //   598: dup
    //   599: aload_3
    //   600: invokespecial <init> : (Landroid/os/Bundle;)V
    //   603: invokevirtual onMessageReceived : (Lcom/google/firebase/messaging/RemoteMessage;)V
    //   606: goto -> 626
    //   609: new java/lang/String
    //   612: dup
    //   613: ldc 'Received message with unknown type: '
    //   615: invokespecial <init> : (Ljava/lang/String;)V
    //   618: astore_1
    //   619: ldc 'FirebaseMessaging'
    //   621: aload_1
    //   622: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   625: pop
    //   626: aload_2
    //   627: lconst_1
    //   628: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   631: invokestatic await : (Lcom/google/android/gms/tasks/Task;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   634: pop
    //   635: return
    //   636: astore_1
    //   637: goto -> 645
    //   640: astore_1
    //   641: goto -> 645
    //   644: astore_1
    //   645: aload_1
    //   646: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   649: astore_2
    //   650: new java/lang/StringBuilder
    //   653: dup
    //   654: aload_2
    //   655: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   658: invokevirtual length : ()I
    //   661: bipush #20
    //   663: iadd
    //   664: invokespecial <init> : (I)V
    //   667: astore_1
    //   668: aload_1
    //   669: ldc_w 'Message ack failed: '
    //   672: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: aload_1
    //   677: aload_2
    //   678: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: ldc 'FirebaseMessaging'
    //   684: aload_1
    //   685: invokevirtual toString : ()Ljava/lang/String;
    //   688: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   691: pop
    //   692: return
    // Exception table:
    //   from	to	target	type
    //   626	635	644	java/util/concurrent/ExecutionException
    //   626	635	640	java/lang/InterruptedException
    //   626	635	636	java/util/concurrent/TimeoutException
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\messaging\FirebaseMessagingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */