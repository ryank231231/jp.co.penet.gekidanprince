package com.google.firebase.inappmessaging.display.internal;

import android.net.Uri;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.squareup.picasso.Picasso;

@FirebaseAppScope
public class PicassoErrorListener implements Picasso.Listener {
  private FirebaseInAppMessagingDisplayCallbacks displayCallbacks;
  
  private InAppMessage inAppMessage;
  
  public void onImageLoadFailed(Picasso paramPicasso, Uri paramUri, Exception paramException) {
    if (this.inAppMessage != null) {
      FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks = this.displayCallbacks;
      if (firebaseInAppMessagingDisplayCallbacks != null)
        if (paramException instanceof com.squareup.picasso.Downloader.ResponseException) {
          firebaseInAppMessagingDisplayCallbacks.displayErrorEncountered(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_FETCH_ERROR);
        } else if (paramException instanceof java.io.IOException && paramException.getLocalizedMessage().contains("Failed to decode")) {
          this.displayCallbacks.displayErrorEncountered(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_UNSUPPORTED_FORMAT);
        } else {
          this.displayCallbacks.displayErrorEncountered(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.UNSPECIFIED_RENDER_ERROR);
        }  
    } 
  }
  
  public void setInAppMessage(InAppMessage paramInAppMessage, FirebaseInAppMessagingDisplayCallbacks paramFirebaseInAppMessagingDisplayCallbacks) {
    this.inAppMessage = paramInAppMessage;
    this.displayCallbacks = paramFirebaseInAppMessagingDisplayCallbacks;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\PicassoErrorListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */