package com.google.android.gms.internal.clearcut;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzej extends zzei<FieldDescriptorType, Object> {
  zzej(int paramInt) {
    super(paramInt, null);
  }
  
  public final void zzv() {
    if (!isImmutable()) {
      for (byte b = 0; b < zzdr(); b++) {
        Map.Entry<K, V> entry = zzak(b);
        if (((zzca)entry.getKey()).zzaw())
          entry.setValue((V)Collections.unmodifiableList((List)entry.getValue())); 
      } 
      for (Map.Entry<K, V> entry : zzds()) {
        if (((zzca)entry.getKey()).zzaw())
          entry.setValue(Collections.unmodifiableList((List)entry.getValue())); 
      } 
    } 
    super.zzv();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */