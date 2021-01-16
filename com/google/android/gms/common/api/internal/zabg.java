package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zal;

final class zabg extends zal {
  zabg(zabe paramzabe, Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    StringBuilder stringBuilder;
    int i;
    switch (paramMessage.what) {
      default:
        i = paramMessage.what;
        stringBuilder = new StringBuilder(31);
        stringBuilder.append("Unknown message id: ");
        stringBuilder.append(i);
        Log.w("GACStateManager", stringBuilder.toString());
        return;
      case 2:
        throw (RuntimeException)stringBuilder.obj;
      case 1:
        break;
    } 
    ((zabf)((Message)stringBuilder).obj).zac(this.zahu);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zabg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */