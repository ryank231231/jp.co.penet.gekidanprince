package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

@KeepForSdk
public interface ComponentRegistrar {
  @KeepForSdk
  List<Component<?>> getComponents();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\components\ComponentRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */