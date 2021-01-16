package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbt;
import com.google.android.gms.internal.measurement.zzby;
import com.google.android.gms.internal.measurement.zzbz;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzcc;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzcg;
import com.google.android.gms.internal.measurement.zzch;
import com.google.android.gms.internal.measurement.zzin;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class zzfz extends zzfs {
  zzfz(zzft paramzzft) {
    super(paramzzft);
  }
  
  static zzbt.zzd zza(zzcf paramzzcf, String paramString) {
    for (zzbt.zzd zzd : paramzzcf.zzxi) {
      if (zzd.getName().equals(paramString))
        return zzd; 
    } 
    return null;
  }
  
  static List<Long> zza(BitSet paramBitSet) {
    int i = (paramBitSet.length() + 63) / 64;
    ArrayList<Long> arrayList = new ArrayList(i);
    for (byte b = 0; b < i; b++) {
      long l = 0L;
      byte b1 = 0;
      while (b1 < 64) {
        int j = (b << 6) + b1;
        if (j < paramBitSet.length()) {
          long l1 = l;
          if (paramBitSet.get(j))
            l1 = l | 1L << b1; 
          b1++;
          l = l1;
        } 
      } 
      arrayList.add(Long.valueOf(l));
    } 
    return arrayList;
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt) {
    for (byte b = 0; b < paramInt; b++)
      paramStringBuilder.append("  "); 
  }
  
  private final void zza(StringBuilder paramStringBuilder, int paramInt, zzbz paramzzbz) {
    if (paramzzbz == null)
      return; 
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append("filter {\n");
    zza(paramStringBuilder, paramInt, "complement", paramzzbz.zzwi);
    zza(paramStringBuilder, paramInt, "param_name", super.zzaa().zzam(paramzzbz.zzwj));
    int i = paramInt + 1;
    zzcc zzcc = paramzzbz.zzwg;
    if (zzcc != null) {
      zza(paramStringBuilder, i);
      paramStringBuilder.append("string_filter");
      paramStringBuilder.append(" {\n");
      if (zzcc.zzws != null)
        zza(paramStringBuilder, i, "match_type", zzcc.zzws.name()); 
      zza(paramStringBuilder, i, "expression", zzcc.zzwt);
      zza(paramStringBuilder, i, "case_sensitive", zzcc.zzwu);
      if (zzcc.zzwv.length > 0) {
        zza(paramStringBuilder, i + 1);
        paramStringBuilder.append("expression_list {\n");
        for (String str : zzcc.zzwv) {
          zza(paramStringBuilder, i + 2);
          paramStringBuilder.append(str);
          paramStringBuilder.append("\n");
        } 
        paramStringBuilder.append("}\n");
      } 
      zza(paramStringBuilder, i);
      paramStringBuilder.append("}\n");
    } 
    zza(paramStringBuilder, i, "number_filter", paramzzbz.zzwh);
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append("}\n");
  }
  
  private final void zza(StringBuilder paramStringBuilder, int paramInt, String paramString1, zzbt.zzf paramzzf, String paramString2) {
    if (paramzzf == null)
      return; 
    zza(paramStringBuilder, 3);
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(" {\n");
    if (paramzzf.zzid() != 0) {
      zza(paramStringBuilder, 4);
      paramStringBuilder.append("results: ");
      Iterator<Long> iterator = paramzzf.zzic().iterator();
      for (paramInt = 0; iterator.hasNext(); paramInt++) {
        Long long_ = iterator.next();
        if (paramInt != 0)
          paramStringBuilder.append(", "); 
        paramStringBuilder.append(long_);
      } 
      paramStringBuilder.append('\n');
    } 
    if (paramzzf.zzib() != 0) {
      zza(paramStringBuilder, 4);
      paramStringBuilder.append("status: ");
      Iterator<Long> iterator = paramzzf.zzia().iterator();
      for (paramInt = 0; iterator.hasNext(); paramInt++) {
        Long long_ = iterator.next();
        if (paramInt != 0)
          paramStringBuilder.append(", "); 
        paramStringBuilder.append(long_);
      } 
      paramStringBuilder.append('\n');
    } 
    if (super.zzaf().zzt(paramString2)) {
      if (paramzzf.zzif() != 0) {
        zza(paramStringBuilder, 4);
        paramStringBuilder.append("dynamic_filter_timestamps: {");
        Iterator<zzbt.zzb> iterator = paramzzf.zzie().iterator();
        for (paramInt = 0; iterator.hasNext(); paramInt++) {
          zzbt.zzb zzb = iterator.next();
          if (paramInt != 0)
            paramStringBuilder.append(", "); 
          if (zzb.zzhd()) {
            Integer integer = Integer.valueOf(zzb.getIndex());
          } else {
            paramString1 = null;
          } 
          paramStringBuilder.append(paramString1);
          paramStringBuilder.append(":");
          if (zzb.zzhe()) {
            Long long_ = Long.valueOf(zzb.zzhf());
          } else {
            paramString1 = null;
          } 
          paramStringBuilder.append(paramString1);
        } 
        paramStringBuilder.append("}\n");
      } 
      if (paramzzf.zzih() != 0) {
        zza(paramStringBuilder, 4);
        paramStringBuilder.append("sequence_filter_timestamps: {");
        Iterator<zzbt.zzg> iterator = paramzzf.zzig().iterator();
        for (paramInt = 0; iterator.hasNext(); paramInt++) {
          zzbt.zzg zzg = iterator.next();
          if (paramInt != 0)
            paramStringBuilder.append(", "); 
          if (zzg.zzhd()) {
            Integer integer = Integer.valueOf(zzg.getIndex());
          } else {
            paramString1 = null;
          } 
          paramStringBuilder.append(paramString1);
          paramStringBuilder.append(": [");
          Iterator<Long> iterator1 = zzg.zzil().iterator();
          for (byte b = 0; iterator1.hasNext(); b++) {
            long l = ((Long)iterator1.next()).longValue();
            if (b)
              paramStringBuilder.append(", "); 
            paramStringBuilder.append(l);
          } 
          paramStringBuilder.append("]");
        } 
        paramStringBuilder.append("}\n");
      } 
    } 
    zza(paramStringBuilder, 3);
    paramStringBuilder.append("}\n");
  }
  
  private final void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, zzca paramzzca) {
    if (paramzzca == null)
      return; 
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" {\n");
    if (paramzzca.zzwk != null)
      zza(paramStringBuilder, paramInt, "comparison_type", paramzzca.zzwk.name()); 
    zza(paramStringBuilder, paramInt, "match_as_float", paramzzca.zzwl);
    zza(paramStringBuilder, paramInt, "comparison_value", paramzzca.zzwm);
    zza(paramStringBuilder, paramInt, "min_comparison_value", paramzzca.zzwn);
    zza(paramStringBuilder, paramInt, "max_comparison_value", paramzzca.zzwo);
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append("}\n");
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject) {
    if (paramObject == null)
      return; 
    zza(paramStringBuilder, paramInt + 1);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject);
    paramStringBuilder.append('\n');
  }
  
  static boolean zza(List<Long> paramList, int paramInt) {
    return (paramInt < paramList.size() << 6 && (1L << paramInt % 64 & ((Long)paramList.get(paramInt / 64)).longValue()) != 0L);
  }
  
  static zzbt.zzd[] zza(zzbt.zzd[] paramArrayOfzzd, String paramString, Object paramObject) {
    for (byte b = 0; b < paramArrayOfzzd.length; b++) {
      zzbt.zzd.zza zza1 = (zzbt.zzd.zza)paramArrayOfzzd[b].zzmh();
      if (paramString.equals(zza1.getName())) {
        zza1.zzhw().zzhv().zzhx();
        if (paramObject instanceof Long) {
          zza1.zzaj(((Long)paramObject).longValue());
        } else if (paramObject instanceof String) {
          zza1.zzbx((String)paramObject);
        } else if (paramObject instanceof Double) {
          zza1.zzb(((Double)paramObject).doubleValue());
        } 
        paramArrayOfzzd[b] = (zzbt.zzd)zza1.zzmr();
        return paramArrayOfzzd;
      } 
    } 
    zzbt.zzd[] arrayOfZzd = new zzbt.zzd[paramArrayOfzzd.length + 1];
    System.arraycopy(paramArrayOfzzd, 0, arrayOfZzd, 0, paramArrayOfzzd.length);
    zzbt.zzd.zza zza = zzbt.zzd.zzht().zzbw(paramString);
    if (paramObject instanceof Long) {
      zza.zzaj(((Long)paramObject).longValue());
    } else if (paramObject instanceof String) {
      zza.zzbx((String)paramObject);
    } else if (paramObject instanceof Double) {
      zza.zzb(((Double)paramObject).doubleValue());
    } 
    arrayOfZzd[paramArrayOfzzd.length] = (zzbt.zzd)zza.zzmr();
    return arrayOfZzd;
  }
  
  static Object zzb(zzcf paramzzcf, String paramString) {
    zzbt.zzd zzd = zza(paramzzcf, paramString);
    if (zzd != null) {
      if (zzd.zzhk())
        return zzd.zzhl(); 
      if (zzd.zzhn())
        return Long.valueOf(zzd.zzho()); 
      if (zzd.zzhq())
        return Double.valueOf(zzd.zzhr()); 
    } 
    return null;
  }
  
  static boolean zzbl(String paramString) {
    return (paramString != null && paramString.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && paramString.length() <= 310);
  }
  
  @WorkerThread
  final long zza(byte[] paramArrayOfbyte) {
    Preconditions.checkNotNull(paramArrayOfbyte);
    super.zzab().zzq();
    MessageDigest messageDigest = zzgd.getMessageDigest();
    if (messageDigest == null) {
      super.zzad().zzda().zzaq("Failed to get MD5");
      return 0L;
    } 
    return zzgd.zzd(messageDigest.digest(paramArrayOfbyte));
  }
  
  final <T extends Parcelable> T zza(byte[] paramArrayOfbyte, Parcelable.Creator<T> paramCreator) {
    if (paramArrayOfbyte == null)
      return null; 
    Parcel parcel = Parcel.obtain();
    try {
      parcel.unmarshall(paramArrayOfbyte, 0, paramArrayOfbyte.length);
      parcel.setDataPosition(0);
      Parcelable parcelable = (Parcelable)paramCreator.createFromParcel(parcel);
      parcel.recycle();
      return (T)parcelable;
    } catch (com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException parseException) {
      super.zzad().zzda().zzaq("Failed to load parcelable from buffer");
      parcel.recycle();
      return null;
    } finally {}
    parcel.recycle();
    throw paramArrayOfbyte;
  }
  
  final String zza(zzby paramzzby) {
    if (paramzzby == null)
      return "null"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\nevent_filter {\n");
    Integer integer = paramzzby.zzwa;
    byte b = 0;
    zza(stringBuilder, 0, "filter_id", integer);
    zza(stringBuilder, 0, "event_name", super.zzaa().zzal(paramzzby.zzwb));
    zza(stringBuilder, 1, "event_count_filter", paramzzby.zzwe);
    stringBuilder.append("  filters {\n");
    zzbz[] arrayOfZzbz = paramzzby.zzwc;
    int i = arrayOfZzbz.length;
    while (b < i) {
      zza(stringBuilder, 2, arrayOfZzbz[b]);
      b++;
    } 
    zza(stringBuilder, 1);
    stringBuilder.append("}\n}\n");
    return stringBuilder.toString();
  }
  
  final void zza(zzbt.zzd.zza paramzza, Object paramObject) {
    Preconditions.checkNotNull(paramObject);
    paramzza.zzhv().zzhw().zzhx();
    if (paramObject instanceof String) {
      paramzza.zzbx((String)paramObject);
      return;
    } 
    if (paramObject instanceof Long) {
      paramzza.zzaj(((Long)paramObject).longValue());
      return;
    } 
    if (paramObject instanceof Double) {
      paramzza.zzb(((Double)paramObject).doubleValue());
      return;
    } 
    super.zzad().zzda().zza("Ignoring invalid (type) event param value", paramObject);
  }
  
  final void zza(zzbt.zzh.zza paramzza, Object paramObject) {
    Preconditions.checkNotNull(paramObject);
    paramzza.zziw().zzix().zziy();
    if (paramObject instanceof String) {
      paramzza.zzbz((String)paramObject);
      return;
    } 
    if (paramObject instanceof Long) {
      paramzza.zzao(((Long)paramObject).longValue());
      return;
    } 
    if (paramObject instanceof Double) {
      paramzza.zzc(((Double)paramObject).doubleValue());
      return;
    } 
    super.zzad().zzda().zza("Ignoring invalid (type) user attribute value", paramObject);
  }
  
  final byte[] zza(zzcg paramzzcg) {
    try {
      byte[] arrayOfByte = new byte[paramzzcg.zzly()];
      zzin zzin = zzin.zzk(arrayOfByte, 0, arrayOfByte.length);
      paramzzcg.zza(zzin);
      zzin.zzlk();
      return arrayOfByte;
    } catch (IOException iOException) {
      super.zzad().zzda().zza("Data loss. Failed to serialize batch", iOException);
      return null;
    } 
  }
  
  protected final boolean zzak() {
    return false;
  }
  
  final String zzb(zzcb paramzzcb) {
    if (paramzzcb == null)
      return "null"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\nproperty_filter {\n");
    zza(stringBuilder, 0, "filter_id", paramzzcb.zzwa);
    zza(stringBuilder, 0, "property_name", super.zzaa().zzan(paramzzcb.zzwq));
    zza(stringBuilder, 1, paramzzcb.zzwr);
    stringBuilder.append("}\n");
    return stringBuilder.toString();
  }
  
  final String zzb(zzcg paramzzcg) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\nbatch {\n");
    if (paramzzcg.zzxl != null)
      for (zzch zzch : paramzzcg.zzxl) {
        if (zzch != null && zzch != null) {
          zza(stringBuilder, 1);
          stringBuilder.append("bundle {\n");
          zza(stringBuilder, 1, "protocol_version", zzch.zzxn);
          zza(stringBuilder, 1, "platform", zzch.zzxv);
          zza(stringBuilder, 1, "gmp_version", zzch.zzxz);
          zza(stringBuilder, 1, "uploading_gmp_version", zzch.zzya);
          zza(stringBuilder, 1, "dynamite_version", zzch.zzys);
          zza(stringBuilder, 1, "config_version", zzch.zzyl);
          zza(stringBuilder, 1, "gmp_app_id", zzch.zzch);
          zza(stringBuilder, 1, "admob_app_id", zzch.zzxf);
          zza(stringBuilder, 1, "app_id", zzch.zzcf);
          zza(stringBuilder, 1, "app_version", zzch.zzcn);
          zza(stringBuilder, 1, "app_version_major", zzch.zzyh);
          zza(stringBuilder, 1, "firebase_instance_id", zzch.zzcj);
          zza(stringBuilder, 1, "dev_cert_hash", zzch.zzyd);
          zza(stringBuilder, 1, "app_store", zzch.zzcp);
          zza(stringBuilder, 1, "upload_timestamp_millis", zzch.zzxq);
          zza(stringBuilder, 1, "start_timestamp_millis", zzch.zzxr);
          zza(stringBuilder, 1, "end_timestamp_millis", zzch.zzxs);
          zza(stringBuilder, 1, "previous_bundle_start_timestamp_millis", zzch.zzxt);
          zza(stringBuilder, 1, "previous_bundle_end_timestamp_millis", zzch.zzxu);
          zza(stringBuilder, 1, "app_instance_id", zzch.zzcg);
          zza(stringBuilder, 1, "resettable_device_id", zzch.zzyb);
          zza(stringBuilder, 1, "device_id", zzch.zzyk);
          zza(stringBuilder, 1, "ds_id", zzch.zzyn);
          zza(stringBuilder, 1, "limited_ad_tracking", zzch.zzyc);
          zza(stringBuilder, 1, "os_version", zzch.zzxw);
          zza(stringBuilder, 1, "device_model", zzch.zzxx);
          zza(stringBuilder, 1, "user_default_language", zzch.zzex);
          zza(stringBuilder, 1, "time_zone_offset_minutes", zzch.zzxy);
          zza(stringBuilder, 1, "bundle_sequential_index", zzch.zzye);
          zza(stringBuilder, 1, "service_upload", zzch.zzyf);
          zza(stringBuilder, 1, "health_monitor", zzch.zzdn);
          if (zzch.zzym != null && zzch.zzym.longValue() != 0L)
            zza(stringBuilder, 1, "android_id", zzch.zzym); 
          if (zzch.zzyp != null)
            zza(stringBuilder, 1, "retry_counter", zzch.zzyp); 
          zzbt.zzh[] arrayOfZzh = zzch.zzxp;
          if (arrayOfZzh != null) {
            int i = arrayOfZzh.length;
            for (byte b = 0; b < i; b++) {
              zzbt.zzh zzh = arrayOfZzh[b];
              if (zzh != null) {
                zza(stringBuilder, 2);
                stringBuilder.append("user_property {\n");
                if (zzh.zzis()) {
                  Long long_ = Long.valueOf(zzh.zzit());
                } else {
                  paramzzcg = null;
                } 
                zza(stringBuilder, 2, "set_timestamp_millis", paramzzcg);
                zza(stringBuilder, 2, "name", super.zzaa().zzan(zzh.getName()));
                zza(stringBuilder, 2, "string_value", zzh.zzhl());
                if (zzh.zzhn()) {
                  Long long_ = Long.valueOf(zzh.zzho());
                } else {
                  paramzzcg = null;
                } 
                zza(stringBuilder, 2, "int_value", paramzzcg);
                if (zzh.zzhq()) {
                  Double double_ = Double.valueOf(zzh.zzhr());
                } else {
                  paramzzcg = null;
                } 
                zza(stringBuilder, 2, "double_value", paramzzcg);
                zza(stringBuilder, 2);
                stringBuilder.append("}\n");
              } 
            } 
          } 
          zzbt.zza[] arrayOfZza = zzch.zzyg;
          String str = zzch.zzcf;
          if (arrayOfZza != null) {
            int i = arrayOfZza.length;
            for (byte b = 0; b < i; b++) {
              zzbt.zza zza = arrayOfZza[b];
              if (zza != null) {
                zza(stringBuilder, 2);
                stringBuilder.append("audience_membership {\n");
                if (zza.zzgu())
                  zza(stringBuilder, 2, "audience_id", Integer.valueOf(zza.zzgv())); 
                if (zza.zzgz())
                  zza(stringBuilder, 2, "new_audience", Boolean.valueOf(zza.zzha())); 
                zza(stringBuilder, 2, "current_data", zza.zzgw(), str);
                zza(stringBuilder, 2, "previous_data", zza.zzgy(), str);
                zza(stringBuilder, 2);
                stringBuilder.append("}\n");
              } 
            } 
          } 
          zzcf[] arrayOfZzcf = zzch.zzxo;
          if (arrayOfZzcf != null) {
            int i = arrayOfZzcf.length;
            for (byte b = 0; b < i; b++) {
              zzcf zzcf = arrayOfZzcf[b];
              if (zzcf != null) {
                zza(stringBuilder, 2);
                stringBuilder.append("event {\n");
                zza(stringBuilder, 2, "name", super.zzaa().zzal(zzcf.name));
                zza(stringBuilder, 2, "timestamp_millis", zzcf.zzxj);
                zza(stringBuilder, 2, "previous_timestamp_millis", zzcf.zzxk);
                zza(stringBuilder, 2, "count", zzcf.count);
                zzbt.zzd[] arrayOfZzd = zzcf.zzxi;
                if (arrayOfZzd != null) {
                  int j = arrayOfZzd.length;
                  for (byte b1 = 0; b1 < j; b1++) {
                    zzbt.zzd zzd = arrayOfZzd[b1];
                    if (zzd != null) {
                      zza(stringBuilder, 3);
                      stringBuilder.append("param {\n");
                      zza(stringBuilder, 3, "name", super.zzaa().zzam(zzd.getName()));
                      zza(stringBuilder, 3, "string_value", zzd.zzhl());
                      if (zzd.zzhn()) {
                        Long long_ = Long.valueOf(zzd.zzho());
                      } else {
                        zzcf = null;
                      } 
                      zza(stringBuilder, 3, "int_value", zzcf);
                      if (zzd.zzhq()) {
                        Double double_ = Double.valueOf(zzd.zzhr());
                      } else {
                        zzcf = null;
                      } 
                      zza(stringBuilder, 3, "double_value", zzcf);
                      zza(stringBuilder, 3);
                      stringBuilder.append("}\n");
                    } 
                  } 
                } 
                zza(stringBuilder, 2);
                stringBuilder.append("}\n");
              } 
            } 
          } 
          zza(stringBuilder, 1);
          stringBuilder.append("}\n");
        } 
      }  
    stringBuilder.append("}\n");
    return stringBuilder.toString();
  }
  
  final boolean zzb(long paramLong1, long paramLong2) {
    return (paramLong1 == 0L || paramLong2 <= 0L || Math.abs(super.zzz().currentTimeMillis() - paramLong1) > paramLong2);
  }
  
  final byte[] zzb(byte[] paramArrayOfbyte) throws IOException {
    try {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream();
      this(paramArrayOfbyte);
      GZIPInputStream gZIPInputStream = new GZIPInputStream();
      this(byteArrayInputStream);
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      this();
      byte[] arrayOfByte = new byte[1024];
      while (true) {
        int i = gZIPInputStream.read(arrayOfByte);
        if (i > 0) {
          byteArrayOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        gZIPInputStream.close();
        byteArrayInputStream.close();
        return byteArrayOutputStream.toByteArray();
      } 
    } catch (IOException iOException) {
      super.zzad().zzda().zza("Failed to ungzip content", iOException);
      throw iOException;
    } 
  }
  
  final byte[] zzc(byte[] paramArrayOfbyte) throws IOException {
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      this();
      GZIPOutputStream gZIPOutputStream = new GZIPOutputStream();
      this(byteArrayOutputStream);
      gZIPOutputStream.write(paramArrayOfbyte);
      gZIPOutputStream.close();
      byteArrayOutputStream.close();
      return byteArrayOutputStream.toByteArray();
    } catch (IOException iOException) {
      super.zzad().zzda().zza("Failed to gzip content", iOException);
      throw iOException;
    } 
  }
  
  @WorkerThread
  final boolean zze(zzaj paramzzaj, zzm paramzzm) {
    Preconditions.checkNotNull(paramzzaj);
    Preconditions.checkNotNull(paramzzm);
    if (TextUtils.isEmpty(paramzzm.zzch) && TextUtils.isEmpty(paramzzm.zzcv)) {
      super.zzag();
      return false;
    } 
    return true;
  }
  
  @Nullable
  final int[] zzgj() {
    Map<String, String> map = zzal.zzk(this.zzkt.getContext());
    if (map == null || map.size() == 0)
      return null; 
    ArrayList<Integer> arrayList1 = new ArrayList();
    int i = ((Integer)zzal.zzhp.get(null)).intValue();
    for (Map.Entry<String, String> entry : map.entrySet()) {
      if (((String)entry.getKey()).startsWith("measurement.id."))
        try {
          int k = Integer.parseInt((String)entry.getValue());
          if (k != 0) {
            arrayList1.add(Integer.valueOf(k));
            if (arrayList1.size() >= i) {
              super.zzad().zzdd().zza("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList1.size()));
              break;
            } 
          } 
        } catch (NumberFormatException numberFormatException) {
          super.zzad().zzdd().zza("Experiment ID NumberFormatException", numberFormatException);
        }  
    } 
    if (arrayList1.size() == 0)
      return null; 
    int[] arrayOfInt = new int[arrayList1.size()];
    ArrayList<Integer> arrayList2 = arrayList1;
    int j = arrayList2.size();
    i = 0;
    for (byte b = 0; i < j; b++) {
      arrayList1 = (ArrayList<Integer>)arrayList2.get(i);
      i++;
      arrayOfInt[b] = ((Integer)arrayList1).intValue();
    } 
    return arrayOfInt;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */