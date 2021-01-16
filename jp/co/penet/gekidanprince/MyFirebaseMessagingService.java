package jp.co.penet.gekidanprince;

import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
  private static final String TAG = "MyFirebaseMsgService";
  
  private void handleNow() {
    Log.d("MyFirebaseMsgService", "Short lived task is done.");
  }
  
  private void scheduleJob() {
    Log.d("MyFirebaseMsgService", "scheduleJob.");
  }
  
  private void sendRegistrationToServer(String paramString) {}
  
  public void onMessageReceived(RemoteMessage paramRemoteMessage) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("From: ");
    stringBuilder.append(paramRemoteMessage.getFrom());
    Log.d("MyFirebaseMsgService", stringBuilder.toString());
    if (paramRemoteMessage.getData().size() > 0) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("Message data payload: ");
      stringBuilder.append(paramRemoteMessage.getData());
      Log.d("MyFirebaseMsgService", stringBuilder.toString());
      scheduleJob();
    } 
    if (paramRemoteMessage.getNotification() != null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("Message Notification Body: ");
      stringBuilder.append(paramRemoteMessage.getNotification().getBody());
      Log.d("MyFirebaseMsgService", stringBuilder.toString());
    } 
  }
  
  public void onNewToken(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Refreshed token: ");
    stringBuilder.append(paramString);
    Log.d("MyFirebaseMsgService", stringBuilder.toString());
    sendRegistrationToServer(paramString);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\jp\co\penet\gekidanprince\MyFirebaseMessagingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */