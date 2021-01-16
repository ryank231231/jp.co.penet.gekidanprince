package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zal;

final class zabb extends zal {
  zabb(zaaw paramzaaw, Looper paramLooper) {
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
        Log.w("GoogleApiClientImpl", stringBuilder.toString());
        return;
      case 2:
        zaaw.zaa(this.zahg);
        return;
      case 1:
        break;
    } 
    zaaw.zab(this.zahg);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zabb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */