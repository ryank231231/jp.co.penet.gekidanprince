package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import javax.annotation.Nullable;

@KeepForSdk
public class StringResourceValueReader {
  private final Resources zzeu;
  
  private final String zzev;
  
  public StringResourceValueReader(Context paramContext) {
    Preconditions.checkNotNull(paramContext);
    this.zzeu = paramContext.getResources();
    this.zzev = this.zzeu.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
  }
  
  @Nullable
  @KeepForSdk
  public String getString(String paramString) {
    int i = this.zzeu.getIdentifier(paramString, "string", this.zzev);
    return (i == 0) ? null : this.zzeu.getString(i);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\StringResourceValueReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */