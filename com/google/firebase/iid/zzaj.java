package com.google.firebase.iid;

import android.os.Bundle;

final class zzaj extends zzak<Void> {
  zzaj(int paramInt1, int paramInt2, Bundle paramBundle) {
    super(paramInt1, 2, paramBundle);
  }
  
  final boolean zzab() {
    return true;
  }
  
  final void zzb(Bundle paramBundle) {
    if (paramBundle.getBoolean("ack", false)) {
      finish(null);
      return;
    } 
    zza(new zzal(4, "Invalid response to one way request"));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */