package com.google.android.gms.common.stats;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
  public abstract int getEventType();
  
  public abstract long getTimeMillis();
  
  public String toString() {
    long l1 = getTimeMillis();
    int i = getEventType();
    long l2 = zzu();
    String str = zzv();
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 53);
    stringBuilder.append(l1);
    stringBuilder.append("\t");
    stringBuilder.append(i);
    stringBuilder.append("\t");
    stringBuilder.append(l2);
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  public abstract long zzu();
  
  public abstract String zzv();
  
  @KeepForSdk
  public static interface Types {
    @KeepForSdk
    public static final int EVENT_TYPE_ACQUIRE_WAKE_LOCK = 7;
    
    @KeepForSdk
    public static final int EVENT_TYPE_RELEASE_WAKE_LOCK = 8;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\stats\StatsEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */