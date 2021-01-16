package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;

final class zaaa implements OnCompleteListener<Map<zai<?>, String>> {
  private SignInConnectionListener zafi;
  
  zaaa(zax paramzax, SignInConnectionListener paramSignInConnectionListener) {
    this.zafi = paramSignInConnectionListener;
  }
  
  final void cancel() {
    this.zafi.onComplete();
  }
  
  public final void onComplete(@NonNull Task<Map<zai<?>, String>> paramTask) {
    zax.zaa(this.zafh).lock();
    try {
      if (!zax.zab(this.zafh)) {
        this.zafi.onComplete();
        return;
      } 
      if (paramTask.isSuccessful()) {
        zax zax1 = this.zafh;
        ArrayMap arrayMap = new ArrayMap();
        this(zax.zam(this.zafh).size());
        zax.zab(zax1, (Map)arrayMap);
        for (zaw zaw : zax.zam(this.zafh).values())
          zax.zag(this.zafh).put(zaw.zak(), ConnectionResult.RESULT_SUCCESS); 
      } else {
        AvailabilityException availabilityException;
        if (paramTask.getException() instanceof AvailabilityException) {
          availabilityException = (AvailabilityException)paramTask.getException();
          if (zax.zae(this.zafh)) {
            zax zax1 = this.zafh;
            ArrayMap arrayMap = new ArrayMap();
            this(zax.zam(this.zafh).size());
            zax.zab(zax1, (Map)arrayMap);
            for (zaw zaw : zax.zam(this.zafh).values()) {
              zai zai = zaw.zak();
              ConnectionResult connectionResult = availabilityException.getConnectionResult(zaw);
              if (zax.zaa(this.zafh, zaw, connectionResult)) {
                Map<zai, ConnectionResult> map = zax.zag(this.zafh);
                connectionResult = new ConnectionResult();
                this(16);
                map.put(zai, connectionResult);
                continue;
              } 
              zax.zag(this.zafh).put(zai, connectionResult);
            } 
          } else {
            zax.zab(this.zafh, (Map)availabilityException.zaj());
          } 
        } else {
          Log.e("ConnectionlessGAC", "Unexpected availability exception", availabilityException.getException());
          zax.zab(this.zafh, Collections.emptyMap());
        } 
      } 
      if (this.zafh.isConnected()) {
        zax.zad(this.zafh).putAll(zax.zag(this.zafh));
        if (zax.zaf(this.zafh) == null) {
          zax.zai(this.zafh);
          zax.zaj(this.zafh);
          zax.zal(this.zafh).signalAll();
        } 
      } 
      this.zafi.onComplete();
      return;
    } finally {
      zax.zaa(this.zafh).unlock();
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */