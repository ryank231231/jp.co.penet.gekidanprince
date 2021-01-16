package com.google.android.gms.common.api.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import java.util.ArrayList;
import java.util.Map;

final class zaan extends zaau {
  private final Map<Api.Client, zaam> zagk;
  
  public zaan(zaak paramzaak, Map<Api.Client, zaam> paramMap) {
    super(paramzaak, null);
    this.zagk = paramMap;
  }
  
  @WorkerThread
  public final void zaan() {
    ConnectionResult connectionResult;
    GoogleApiAvailabilityCache googleApiAvailabilityCache = new GoogleApiAvailabilityCache(zaak.zab(this.zagi));
    ArrayList<Api.Client> arrayList1 = new ArrayList();
    ArrayList<Api.Client> arrayList2 = new ArrayList();
    for (Api.Client client : this.zagk.keySet()) {
      if (client.requiresGooglePlayServices() && !zaam.zaa(this.zagk.get(client))) {
        arrayList1.add(client);
        continue;
      } 
      arrayList2.add(client);
    } 
    int i = -1;
    boolean bool = arrayList1.isEmpty();
    int j = 0;
    int k = 0;
    if (bool) {
      arrayList1 = arrayList2;
      int m = arrayList1.size();
      while (k < m) {
        arrayList2 = (ArrayList<Api.Client>)arrayList1.get(k);
        k++;
        Api.Client client = (Api.Client)arrayList2;
        j = googleApiAvailabilityCache.getClientAvailability(zaak.zaa(this.zagi), client);
        i = j;
        if (j == 0) {
          i = j;
          break;
        } 
      } 
    } else {
      arrayList1 = arrayList1;
      int m = arrayList1.size();
      k = j;
      while (k < m) {
        arrayList2 = (ArrayList<Api.Client>)arrayList1.get(k);
        k++;
        Api.Client client = (Api.Client)arrayList2;
        j = googleApiAvailabilityCache.getClientAvailability(zaak.zaa(this.zagi), client);
        i = j;
        if (j != 0) {
          i = j;
          break;
        } 
      } 
    } 
    if (i != 0) {
      connectionResult = new ConnectionResult(i, null);
      zaak.zad(this.zagi).zaa(new zaao(this, this.zagi, connectionResult));
      return;
    } 
    if (zaak.zae(this.zagi))
      zaak.zaf(this.zagi).connect(); 
    for (Api.Client client : this.zagk.keySet()) {
      BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = this.zagk.get(client);
      if (client.requiresGooglePlayServices() && connectionResult.getClientAvailability(zaak.zaa(this.zagi), client) != 0) {
        zaak.zad(this.zagi).zaa(new zaap(this, this.zagi, connectionProgressReportCallbacks));
        continue;
      } 
      client.connect(connectionProgressReportCallbacks);
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */