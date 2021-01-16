package com.google.android.gms.phenotype;

import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.phenotype.zzd;
import com.google.android.gms.internal.phenotype.zze;

@KeepForSdk
public final class Phenotype {
  @Deprecated
  private static final Api<Api.ApiOptions.NoOptions> API;
  
  private static final Api.AbstractClientBuilder<zze, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
  
  private static final Api.ClientKey<zze> CLIENT_KEY = new Api.ClientKey();
  
  @Deprecated
  private static final zzm zzaj;
  
  static {
    CLIENT_BUILDER = new zzl();
    API = new Api("Phenotype.API", CLIENT_BUILDER, CLIENT_KEY);
    zzaj = (zzm)new zzd();
  }
  
  @KeepForSdk
  public static Uri getContentProviderUri(String paramString) {
    paramString = String.valueOf(Uri.encode(paramString));
    if (paramString.length() != 0) {
      paramString = "content://com.google.android.gms.phenotype/".concat(paramString);
    } else {
      paramString = new String("content://com.google.android.gms.phenotype/");
    } 
    return Uri.parse(paramString);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\phenotype\Phenotype.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */