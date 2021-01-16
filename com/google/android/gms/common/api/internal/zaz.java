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

final class zaz implements OnCompleteListener<Map<zai<?>, String>> {
  private zaz(zax paramzax) {}
  
  public final void onComplete(@NonNull Task<Map<zai<?>, String>> paramTask) {
    zax.zaa(this.zafh).lock();
    try {
      boolean bool = zax.zab(this.zafh);
      if (!bool)
        return; 
      if (paramTask.isSuccessful()) {
        zax zax1 = this.zafh;
        ArrayMap arrayMap = new ArrayMap();
        this(zax.zac(this.zafh).size());
        zax.zaa(zax1, (Map)arrayMap);
        for (zaw zaw : zax.zac(this.zafh).values())
          zax.zad(this.zafh).put(zaw.zak(), ConnectionResult.RESULT_SUCCESS); 
      } else {
        AvailabilityException availabilityException;
        if (paramTask.getException() instanceof AvailabilityException) {
          availabilityException = (AvailabilityException)paramTask.getException();
          if (zax.zae(this.zafh)) {
            zax zax1 = this.zafh;
            ArrayMap arrayMap = new ArrayMap();
            this(zax.zac(this.zafh).size());
            zax.zaa(zax1, (Map)arrayMap);
            for (zaw zaw : zax.zac(this.zafh).values()) {
              zai zai = zaw.zak();
              ConnectionResult connectionResult = availabilityException.getConnectionResult(zaw);
              if (zax.zaa(this.zafh, zaw, connectionResult)) {
                Map<zai, ConnectionResult> map = zax.zad(this.zafh);
                connectionResult = new ConnectionResult();
                this(16);
                map.put(zai, connectionResult);
                continue;
              } 
              zax.zad(this.zafh).put(zai, connectionResult);
            } 
          } else {
            zax.zaa(this.zafh, (Map)availabilityException.zaj());
          } 
          zax.zaa(this.zafh, zax.zaf(this.zafh));
        } else {
          Log.e("ConnectionlessGAC", "Unexpected availability exception", availabilityException.getException());
          zax.zaa(this.zafh, Collections.emptyMap());
          zax zax1 = this.zafh;
          ConnectionResult connectionResult = new ConnectionResult();
          this(8);
          zax.zaa(zax1, connectionResult);
        } 
      } 
      if (zax.zag(this.zafh) != null) {
        zax.zad(this.zafh).putAll(zax.zag(this.zafh));
        zax.zaa(this.zafh, zax.zaf(this.zafh));
      } 
      if (zax.zah(this.zafh) == null) {
        zax.zai(this.zafh);
        zax.zaj(this.zafh);
      } else {
        zax.zaa(this.zafh, false);
        zax.zak(this.zafh).zac(zax.zah(this.zafh));
      } 
      zax.zal(this.zafh).signalAll();
      return;
    } finally {
      zax.zaa(this.zafh).unlock();
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */