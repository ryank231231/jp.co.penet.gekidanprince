package com.google.android.gms.internal.clearcut;

import android.net.Uri;

public final class zzao {
  private final String zzef;
  
  private final Uri zzeg;
  
  private final String zzeh;
  
  private final String zzei;
  
  private final boolean zzej;
  
  private final boolean zzek;
  
  public zzao(Uri paramUri) {
    this(null, paramUri, "", "", false, false);
  }
  
  private zzao(String paramString1, Uri paramUri, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2) {
    this.zzef = paramString1;
    this.zzeg = paramUri;
    this.zzeh = paramString2;
    this.zzei = paramString3;
    this.zzej = paramBoolean1;
    this.zzek = paramBoolean2;
  }
  
  public final <T> zzae<T> zza(String paramString, T paramT, zzan<T> paramzzan) {
    return zzae.zzb(this, paramString, paramT, paramzzan);
  }
  
  public final zzae<String> zza(String paramString1, String paramString2) {
    return zzae.zzb(this, paramString1, (String)null);
  }
  
  public final zzae<Boolean> zzc(String paramString, boolean paramBoolean) {
    return zzae.zzb(this, paramString, false);
  }
  
  public final zzao zzc(String paramString) {
    boolean bool = this.zzej;
    if (!bool)
      return new zzao(this.zzef, this.zzeg, paramString, this.zzei, bool, this.zzek); 
    throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
  }
  
  public final zzao zzd(String paramString) {
    return new zzao(this.zzef, this.zzeg, this.zzeh, paramString, this.zzej, this.zzek);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */