package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

@ShowFirstParty
public abstract class zac {
  private static final Object sLock;
  
  @GuardedBy("sLock")
  private static final Map<Object, zac> zacj = new WeakHashMap<Object, zac>();
  
  static {
    sLock = new Object();
  }
  
  public abstract void remove(int paramInt);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\zac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */