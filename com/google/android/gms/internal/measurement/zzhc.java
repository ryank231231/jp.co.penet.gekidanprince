package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzhc extends zzhb<FieldDescriptorType, Object> {
  zzhc(int paramInt) {
    super(paramInt, null);
  }
  
  public final void zzjz() {
    if (!isImmutable()) {
      for (byte b = 0; b < zzoi(); b++) {
        Map.Entry<K, V> entry = zzbf(b);
        if (((zzes)entry.getKey()).zzmc())
          entry.setValue((V)Collections.unmodifiableList((List)entry.getValue())); 
      } 
      for (Map.Entry<K, V> entry : zzoj()) {
        if (((zzes)entry.getKey()).zzmc())
          entry.setValue(Collections.unmodifiableList((List)entry.getValue())); 
      } 
    } 
    super.zzjz();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */