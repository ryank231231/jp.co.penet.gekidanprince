package com.google.firebase.inappmessaging;

import android.support.annotation.Keep;
import com.google.firebase.inappmessaging.model.InAppMessage;

@Keep
public interface FirebaseInAppMessagingDisplay {
  @Keep
  void displayMessage(InAppMessage paramInAppMessage, FirebaseInAppMessagingDisplayCallbacks paramFirebaseInAppMessagingDisplayCallbacks);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\FirebaseInAppMessagingDisplay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */