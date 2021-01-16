package com.google.firebase.inappmessaging;

import com.google.android.gms.tasks.Task;
import com.google.firebase.inappmessaging.model.Action;

public interface FirebaseInAppMessagingDisplayCallbacks {
  Task<Void> displayErrorEncountered(InAppMessagingErrorReason paramInAppMessagingErrorReason);
  
  Task<Void> impressionDetected();
  
  @Deprecated
  Task<Void> messageClicked(Action paramAction);
  
  Task<Void> messageDismissed(InAppMessagingDismissType paramInAppMessagingDismissType);
  
  public enum InAppMessagingDismissType {
    AUTO, CLICK, SWIPE, UNKNOWN_DISMISS_TYPE;
    
    static {
      $VALUES = new InAppMessagingDismissType[] { UNKNOWN_DISMISS_TYPE, AUTO, CLICK, SWIPE };
    }
  }
  
  public enum InAppMessagingErrorReason {
    IMAGE_DISPLAY_ERROR, IMAGE_FETCH_ERROR, IMAGE_UNSUPPORTED_FORMAT, UNSPECIFIED_RENDER_ERROR;
    
    static {
      IMAGE_DISPLAY_ERROR = new InAppMessagingErrorReason("IMAGE_DISPLAY_ERROR", 2);
      IMAGE_UNSUPPORTED_FORMAT = new InAppMessagingErrorReason("IMAGE_UNSUPPORTED_FORMAT", 3);
      $VALUES = new InAppMessagingErrorReason[] { UNSPECIFIED_RENDER_ERROR, IMAGE_FETCH_ERROR, IMAGE_DISPLAY_ERROR, IMAGE_UNSUPPORTED_FORMAT };
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\FirebaseInAppMessagingDisplayCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */