package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

public final class zzae {
  final String name;
  
  private final String origin;
  
  final long timestamp;
  
  final String zzcf;
  
  final long zzfc;
  
  final zzag zzfd;
  
  zzae(zzby paramzzby, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, Bundle paramBundle) {
    zzag zzag1;
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotEmpty(paramString3);
    this.zzcf = paramString2;
    this.name = paramString3;
    paramString3 = paramString1;
    if (TextUtils.isEmpty(paramString1))
      paramString3 = null; 
    this.origin = paramString3;
    this.timestamp = paramLong1;
    this.zzfc = paramLong2;
    paramLong1 = this.zzfc;
    if (paramLong1 != 0L && paramLong1 > this.timestamp)
      paramzzby.zzad().zzdd().zza("Event created with reverse previous/current timestamps. appId", zzau.zzao(paramString2)); 
    if (paramBundle != null && !paramBundle.isEmpty()) {
      paramBundle = new Bundle(paramBundle);
      Iterator<String> iterator = paramBundle.keySet().iterator();
      while (iterator.hasNext()) {
        paramString3 = iterator.next();
        if (paramString3 == null) {
          paramzzby.zzad().zzda().zzaq("Param name can't be null");
          iterator.remove();
          continue;
        } 
        Object object = paramzzby.zzab().zzb(paramString3, paramBundle.get(paramString3));
        if (object == null) {
          paramzzby.zzad().zzdd().zza("Param value can't be null", paramzzby.zzaa().zzam(paramString3));
          iterator.remove();
          continue;
        } 
        paramzzby.zzab().zza(paramBundle, paramString3, object);
      } 
      zzag1 = new zzag(paramBundle);
    } else {
      zzag1 = new zzag(new Bundle());
    } 
    this.zzfd = zzag1;
  }
  
  private zzae(zzby paramzzby, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, zzag paramzzag) {
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotEmpty(paramString3);
    Preconditions.checkNotNull(paramzzag);
    this.zzcf = paramString2;
    this.name = paramString3;
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1))
      str = null; 
    this.origin = str;
    this.timestamp = paramLong1;
    this.zzfc = paramLong2;
    paramLong1 = this.zzfc;
    if (paramLong1 != 0L && paramLong1 > this.timestamp)
      paramzzby.zzad().zzdd().zza("Event created with reverse previous/current timestamps. appId, name", zzau.zzao(paramString2), zzau.zzao(paramString3)); 
    this.zzfd = paramzzag;
  }
  
  public final String toString() {
    String str1 = this.zzcf;
    String str2 = this.name;
    String str3 = String.valueOf(this.zzfd);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 33 + String.valueOf(str2).length() + String.valueOf(str3).length());
    stringBuilder.append("Event{appId='");
    stringBuilder.append(str1);
    stringBuilder.append("', name='");
    stringBuilder.append(str2);
    stringBuilder.append("', params=");
    stringBuilder.append(str3);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  final zzae zza(zzby paramzzby, long paramLong) {
    return new zzae(paramzzby, this.origin, this.zzcf, this.name, this.timestamp, paramLong, this.zzfd);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */