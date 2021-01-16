package com.google.firebase.iid;

import android.support.annotation.NonNull;

public interface InstanceIdResult {
  @NonNull
  String getId();
  
  @NonNull
  String getToken();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\InstanceIdResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */