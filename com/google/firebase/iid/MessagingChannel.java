package com.google.firebase.iid;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import javax.annotation.Nullable;

@KeepForSdk
public interface MessagingChannel {
  @KeepForSdk
  Task<Void> ackMessage(String paramString);
  
  @KeepForSdk
  Task<Void> buildChannel(String paramString1, @Nullable String paramString2);
  
  @KeepForSdk
  Task<Void> deleteInstanceId(String paramString);
  
  @KeepForSdk
  Task<Void> deleteToken(String paramString1, @Nullable String paramString2, String paramString3, String paramString4);
  
  @KeepForSdk
  Task<String> getToken(String paramString1, @Nullable String paramString2, String paramString3, String paramString4);
  
  @KeepForSdk
  boolean isAvailable();
  
  @KeepForSdk
  boolean isChannelBuilt();
  
  @KeepForSdk
  boolean needsRefresh();
  
  @KeepForSdk
  Task<Void> subscribeToTopic(String paramString1, String paramString2, String paramString3);
  
  @KeepForSdk
  Task<Void> unsubscribeFromTopic(String paramString1, String paramString2, String paramString3);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\MessagingChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */