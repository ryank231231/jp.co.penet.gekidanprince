package com.google.android.gms.common.internal;

import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class ResourceUtils {
  private static final Uri zzet = (new Uri.Builder()).scheme("android.resource").authority("com.google.android.gms").appendPath("drawable").build();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\ResourceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */