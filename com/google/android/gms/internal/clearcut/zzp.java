package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.phenotype.Phenotype;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class zzp implements ClearcutLogger.zza {
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  
  private static final zzao zzaq = (new zzao(Phenotype.getContentProviderUri("com.google.android.gms.clearcut.public"))).zzc("gms:playlog:service:samplingrules_").zzd("LogSamplingRules__");
  
  private static final zzao zzar = (new zzao(Phenotype.getContentProviderUri("com.google.android.gms.clearcut.public"))).zzc("gms:playlog:service:sampling_").zzd("LogSampling__");
  
  private static final ConcurrentHashMap<String, zzae<zzgw.zza>> zzas = new ConcurrentHashMap<String, zzae<zzgw.zza>>();
  
  private static final HashMap<String, zzae<String>> zzat = new HashMap<String, zzae<String>>();
  
  @VisibleForTesting
  private static Boolean zzau = null;
  
  @VisibleForTesting
  private static Long zzav = null;
  
  @VisibleForTesting
  private static final zzae<Boolean> zzaw = zzaq.zzc("enable_log_sampling_rules", false);
  
  private final Context zzh;
  
  public zzp(Context paramContext) {
    this.zzh = paramContext;
    paramContext = this.zzh;
    if (paramContext != null)
      zzae.maybeInit(paramContext); 
  }
  
  @VisibleForTesting
  private static long zza(String paramString, long paramLong) {
    byte[] arrayOfByte2;
    if (paramString == null || paramString.isEmpty()) {
      arrayOfByte2 = ByteBuffer.allocate(8).putLong(paramLong).array();
      return zzk.zza(arrayOfByte2);
    } 
    byte[] arrayOfByte3 = arrayOfByte2.getBytes(UTF_8);
    ByteBuffer byteBuffer = ByteBuffer.allocate(arrayOfByte3.length + 8);
    byteBuffer.put(arrayOfByte3);
    byteBuffer.putLong(paramLong);
    byte[] arrayOfByte1 = byteBuffer.array();
    return zzk.zza(arrayOfByte1);
  }
  
  @VisibleForTesting
  private static zzgw.zza.zzb zza(String paramString) {
    StringBuilder stringBuilder;
    if (paramString == null)
      return null; 
    String str = "";
    int i = paramString.indexOf(',');
    int j = 0;
    if (i >= 0) {
      str = paramString.substring(0, i);
      j = i + 1;
    } 
    i = paramString.indexOf('/', j);
    if (i <= 0) {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Failed to parse the rule: ".concat(paramString);
      } else {
        paramString = new String("Failed to parse the rule: ");
      } 
      Log.e("LogSamplerImpl", paramString);
      return null;
    } 
    try {
      long l1 = Long.parseLong(paramString.substring(j, i));
      long l2 = Long.parseLong(paramString.substring(i + 1));
      if (l1 < 0L || l2 < 0L) {
        stringBuilder = new StringBuilder(72);
        stringBuilder.append("negative values not supported: ");
        stringBuilder.append(l1);
        stringBuilder.append("/");
        stringBuilder.append(l2);
        Log.e("LogSamplerImpl", stringBuilder.toString());
        return null;
      } 
      return (zzgw.zza.zzb)zzgw.zza.zzb.zzfz().zzn(str).zzr(l1).zzs(l2).zzbh();
    } catch (NumberFormatException numberFormatException) {
      String str1 = String.valueOf(stringBuilder);
      if (str1.length() != 0) {
        str1 = "parseLong() failed while parsing: ".concat(str1);
      } else {
        str1 = new String("parseLong() failed while parsing: ");
      } 
      Log.e("LogSamplerImpl", str1, numberFormatException);
      return null;
    } 
  }
  
  @VisibleForTesting
  private static boolean zzb(long paramLong1, long paramLong2, long paramLong3) {
    if (paramLong2 >= 0L && paramLong3 > 0L) {
      if (paramLong1 >= 0L) {
        paramLong1 %= paramLong3;
      } else {
        paramLong1 = (Long.MAX_VALUE % paramLong3 + 1L + (paramLong1 & Long.MAX_VALUE) % paramLong3) % paramLong3;
      } 
      if (paramLong1 >= paramLong2)
        return false; 
    } 
    return true;
  }
  
  private static boolean zzc(Context paramContext) {
    if (zzau == null) {
      boolean bool;
      if (Wrappers.packageManager(paramContext).checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      zzau = Boolean.valueOf(bool);
    } 
    return zzau.booleanValue();
  }
  
  @VisibleForTesting
  private static long zzd(Context paramContext) {
    if (zzav == null) {
      long l = 0L;
      if (paramContext != null) {
        if (zzc(paramContext))
          l = zzy.getLong(paramContext.getContentResolver(), "android_id", 0L); 
        zzav = Long.valueOf(l);
      } else {
        return 0L;
      } 
    } 
    return zzav.longValue();
  }
  
  public final boolean zza(zze paramzze) {
    boolean bool;
    String str1 = paramzze.zzag.zzj;
    int i = paramzze.zzag.zzk;
    if (paramzze.zzaa != null) {
      bool = paramzze.zzaa.zzbji;
    } else {
      bool = false;
    } 
    boolean bool1 = ((Boolean)zzaw.get()).booleanValue();
    String str2 = null;
    if (!bool1) {
      if (str1 != null && !str1.isEmpty()) {
        String str = str1;
      } else if (i >= 0) {
        String str = String.valueOf(i);
      } else {
        paramzze = null;
      } 
      if (paramzze != null) {
        Context context = this.zzh;
        str1 = str2;
        if (context != null)
          if (!zzc(context)) {
            str1 = str2;
          } else {
            zzae<String> zzae2 = zzat.get(paramzze);
            zzae<String> zzae1 = zzae2;
            if (zzae2 == null) {
              zzae1 = zzar.zza((String)paramzze, null);
              zzat.put(paramzze, zzae1);
            } 
            str1 = zzae1.get();
          }  
        zzgw.zza.zzb zzb = zza(str1);
        if (zzb != null)
          return zzb(zza(zzb.zzfw(), zzd(this.zzh)), zzb.zzfx(), zzb.zzfy()); 
      } 
    } else {
      if (str1 == null || str1.isEmpty())
        if (i >= 0) {
          str1 = String.valueOf(i);
        } else {
          str1 = null;
        }  
      if (str1 != null) {
        List<zzgw.zza.zzb> list;
        if (this.zzh == null) {
          list = Collections.emptyList();
        } else {
          zzae<zzgw.zza> zzae2 = zzas.get(str1);
          zzae<zzgw.zza> zzae1 = zzae2;
          if (zzae2 == null) {
            zzae1 = zzaq.zza(str1, zzgw.zza.zzft(), zzq.zzax);
            zzae<zzgw.zza> zzae3 = zzas.putIfAbsent(str1, zzae1);
            if (zzae3 != null)
              zzae1 = zzae3; 
          } 
          list = ((zzgw.zza)zzae1.get()).zzfs();
        } 
        for (zzgw.zza.zzb zzb : list) {
          if ((!zzb.zzfv() || zzb.getEventCode() == 0 || zzb.getEventCode() == bool) && !zzb(zza(zzb.zzfw(), zzd(this.zzh)), zzb.zzfx(), zzb.zzfy()))
            return false; 
        } 
      } 
    } 
    return true;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */