package com.google.android.gms.common.api.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

final class zaaq extends zaau {
  private final ArrayList<Api.Client> zago;
  
  public zaaq(zaak paramzaak, ArrayList<Api.Client> paramArrayList) {
    super(paramzaak, null);
    this.zago = paramArrayList;
  }
  
  @WorkerThread
  public final void zaan() {
    (zaak.zad(this.zagi)).zaed.zagz = zaak.zag(this.zagi);
    ArrayList<Api.Client> arrayList = this.zago;
    int i = arrayList.size();
    byte b = 0;
    while (b < i) {
      Api.Client client = (Api.Client)arrayList.get(b);
      b++;
      ((Api.Client)client).getRemoteService(zaak.zah(this.zagi), (zaak.zad(this.zagi)).zaed.zagz);
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */