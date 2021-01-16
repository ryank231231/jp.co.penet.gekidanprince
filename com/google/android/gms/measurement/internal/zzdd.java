package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzdd extends zzf {
  @VisibleForTesting
  protected zzdx zzpf;
  
  private zzda zzpg;
  
  private final Set<zzdb> zzph = new CopyOnWriteArraySet<zzdb>();
  
  private boolean zzpi;
  
  private final AtomicReference<String> zzpj = new AtomicReference<String>();
  
  @VisibleForTesting
  protected boolean zzpk = true;
  
  protected zzdd(zzby paramzzby) {
    super(paramzzby);
  }
  
  private final void zza(Bundle paramBundle, long paramLong) {
    Preconditions.checkNotNull(paramBundle);
    zzcw.zza(paramBundle, "app_id", String.class, null);
    zzcw.zza(paramBundle, "origin", String.class, null);
    zzcw.zza(paramBundle, "name", String.class, null);
    zzcw.zza(paramBundle, "value", Object.class, null);
    zzcw.zza(paramBundle, "trigger_event_name", String.class, null);
    zzcw.zza(paramBundle, "trigger_timeout", Long.class, Long.valueOf(0L));
    zzcw.zza(paramBundle, "timed_out_event_name", String.class, null);
    zzcw.zza(paramBundle, "timed_out_event_params", Bundle.class, null);
    zzcw.zza(paramBundle, "triggered_event_name", String.class, null);
    zzcw.zza(paramBundle, "triggered_event_params", Bundle.class, null);
    zzcw.zza(paramBundle, "time_to_live", Long.class, Long.valueOf(0L));
    zzcw.zza(paramBundle, "expired_event_name", String.class, null);
    zzcw.zza(paramBundle, "expired_event_params", Bundle.class, null);
    Preconditions.checkNotEmpty(paramBundle.getString("name"));
    Preconditions.checkNotEmpty(paramBundle.getString("origin"));
    Preconditions.checkNotNull(paramBundle.get("value"));
    paramBundle.putLong("creation_timestamp", paramLong);
    String str = paramBundle.getString("name");
    Object object1 = paramBundle.get("value");
    if (super.zzab().zzbo(str) != 0) {
      super.zzad().zzda().zza("Invalid conditional user property name", super.zzaa().zzan(str));
      return;
    } 
    if (super.zzab().zzc(str, object1) != 0) {
      super.zzad().zzda().zza("Invalid conditional user property value", super.zzaa().zzan(str), object1);
      return;
    } 
    Object object2 = super.zzab().zzd(str, object1);
    if (object2 == null) {
      super.zzad().zzda().zza("Unable to normalize conditional user property value", super.zzaa().zzan(str), object1);
      return;
    } 
    zzcw.zza(paramBundle, object2);
    paramLong = paramBundle.getLong("trigger_timeout");
    if (!TextUtils.isEmpty(paramBundle.getString("trigger_event_name")) && (paramLong > 15552000000L || paramLong < 1L)) {
      super.zzad().zzda().zza("Invalid conditional user property timeout", super.zzaa().zzan(str), Long.valueOf(paramLong));
      return;
    } 
    paramLong = paramBundle.getLong("time_to_live");
    if (paramLong > 15552000000L || paramLong < 1L) {
      super.zzad().zzda().zza("Invalid conditional user property time to live", super.zzaa().zzan(str), Long.valueOf(paramLong));
      return;
    } 
    super.zzac().zza(new zzdl(this, paramBundle));
  }
  
  @WorkerThread
  private final void zza(String paramString1, String paramString2, long paramLong, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3) {
    Object<String> object;
    zzec zzec1;
    ArrayList<Bundle> arrayList3;
    Preconditions.checkNotEmpty(paramString1);
    if (!super.zzaf().zze(paramString3, zzal.zzis))
      Preconditions.checkNotEmpty(paramString2); 
    Preconditions.checkNotNull(paramBundle);
    super.zzq();
    zzah();
    if (!this.zzl.isEnabled()) {
      super.zzad().zzdh().zzaq("Event not sent since app measurement is disabled");
      return;
    } 
    boolean bool1 = this.zzpi;
    int i = 0;
    if (!bool1) {
      this.zzpi = true;
      try {
        Class<?> clazz;
        if (!this.zzl.zzep()) {
          clazz = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, super.getContext().getClassLoader());
        } else {
          clazz = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
        } 
        try {
          clazz.getDeclaredMethod("initialize", new Class[] { Context.class }).invoke(null, new Object[] { super.getContext() });
        } catch (Exception exception) {
          super.zzad().zzdd().zza("Failed to invoke Tag Manager's initialize() method", exception);
        } 
      } catch (ClassNotFoundException classNotFoundException) {
        super.zzad().zzdg().zzaq("Tag Manager is not found and thus will not be used");
      } 
    } 
    if (paramBoolean3) {
      super.zzag();
      if (!"_iap".equals(paramString2)) {
        boolean bool;
        zzgd zzgd = this.zzl.zzab();
        if (!zzgd.zzp("event", paramString2)) {
          bool = true;
        } else if (!zzgd.zza("event", zzcx.zzoy, paramString2)) {
          bool = true;
        } else if (!zzgd.zza("event", 40, paramString2)) {
          bool = true;
        } else {
          bool = false;
        } 
        if (bool) {
          super.zzad().zzdc().zza("Invalid public event name. Event will not be logged (FE)", super.zzaa().zzal(paramString2));
          this.zzl.zzab();
          paramString1 = zzgd.zza(paramString2, 40, true);
          if (paramString2 != null) {
            i = paramString2.length();
          } else {
            i = 0;
          } 
          this.zzl.zzab().zza(bool, "_ev", paramString1, i);
          return;
        } 
      } 
    } 
    super.zzag();
    zzec zzec2 = super.zzv().zzfc();
    if (zzec2 != null && !paramBundle.containsKey("_sc"))
      zzec2.zzpx = true; 
    if (paramBoolean1 && paramBoolean3) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    zzed.zza(zzec2, paramBundle, bool1);
    bool1 = "am".equals(paramString1);
    boolean bool2 = zzgd.zzbs(paramString2);
    if (paramBoolean1 && this.zzpg != null && !bool2 && !bool1) {
      super.zzad().zzdh().zza("Passing event to registered event handler (FE)", super.zzaa().zzal(paramString2), super.zzaa().zzc(paramBundle));
      this.zzpg.interceptEvent(paramString1, paramString2, paramBundle, paramLong);
      return;
    } 
    if (!this.zzl.zzet())
      return; 
    int k = super.zzab().zzbn(paramString2);
    if (k != 0) {
      super.zzad().zzdc().zza("Invalid event name. Event will not be logged (FE)", super.zzaa().zzal(paramString2));
      super.zzab();
      paramString1 = zzgd.zza(paramString2, 40, true);
      int m = i;
      if (paramString2 != null)
        m = paramString2.length(); 
      this.zzl.zzab().zza(paramString3, k, "_ev", paramString1, m);
      return;
    } 
    List<String> list2 = CollectionUtils.listOf((Object[])new String[] { "_o", "_sn", "_sc", "_si" });
    Bundle bundle = super.zzab().zza(paramString3, paramString2, paramBundle, list2, paramBoolean3, true);
    if (bundle == null || !bundle.containsKey("_sc") || !bundle.containsKey("_si")) {
      zzec1 = null;
    } else {
      zzec1 = new zzec(bundle.getString("_sn"), bundle.getString("_sc"), Long.valueOf(bundle.getLong("_si")).longValue());
    } 
    if (zzec1 != null)
      zzec2 = zzec1; 
    if (super.zzaf().zzac(paramString3)) {
      super.zzag();
      if (super.zzv().zzfc() != null && "_ae".equals(paramString2)) {
        long l1 = super.zzx().zzfq();
        if (l1 > 0L)
          super.zzab().zzb(bundle, l1); 
      } 
    } 
    ArrayList<Bundle> arrayList2 = new ArrayList();
    arrayList2.add(bundle);
    long l = super.zzab().zzgl().nextLong();
    if (super.zzaf().zze(super.zzt().zzan(), zzal.zzih) && (super.zzae()).zzls.get() > 0L && super.zzae().zzx(paramLong) && (super.zzae()).zzlv.get()) {
      super.zzad().zzdi().zzaq("Current session is expired, remove the session number and Id");
      if (super.zzaf().zze(super.zzt().zzan(), zzal.zzid))
        zza("auto", "_sid", (Object)null, super.zzz().currentTimeMillis()); 
      if (super.zzaf().zze(super.zzt().zzan(), zzal.zzie))
        zza("auto", "_sno", (Object)null, super.zzz().currentTimeMillis()); 
    } 
    if (super.zzaf().zzab(super.zzt().zzan()) && bundle.getLong("extend_session", 0L) == 1L) {
      super.zzad().zzdi().zzaq("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
      this.zzl.zzx().zza(paramLong, true);
    } 
    String[] arrayOfString = (String[])bundle.keySet().toArray((Object[])new String[paramBundle.size()]);
    Arrays.sort((Object[])arrayOfString);
    int j = arrayOfString.length;
    i = 0;
    k = 0;
    ArrayList<Bundle> arrayList1 = arrayList2;
    List<String> list1 = list2;
    while (i < j) {
      List<String> list;
      zzec zzec3;
      zzec zzec5;
      Bundle bundle1;
      Bundle bundle3;
      ArrayList<Bundle> arrayList4;
      ArrayList<Bundle> arrayList6;
      Object<String> object2;
      String str = arrayOfString[i];
      Object<String> object1 = (Object<String>)bundle.get(str);
      super.zzab();
      object1 = (Object<String>)zzgd.zzb(object1);
      if (object1 != null) {
        bundle.putInt(str, object1.length);
        for (byte b = 0; b < object1.length; b++) {
          Object object3 = object1[b];
          zzed.zza(zzec2, (Bundle)object3, true);
          object3 = super.zzab().zza(paramString3, "_ep", (Bundle)object3, list1, paramBoolean3, false);
          object3.putString("_en", paramString2);
          object3.putLong("_eid", l);
          object3.putString("_gn", str);
          object3.putInt("_ll", object1.length);
          object3.putInt("_i", b);
          arrayList1.add(object3);
        } 
        List<String> list3 = list1;
        zzec5 = zzec2;
        k += object1.length;
        bundle3 = bundle;
        arrayList6 = arrayList1;
        list = list3;
      } else {
        object1 = (Object<String>)list;
        Bundle bundle4 = bundle3;
        arrayList4 = arrayList6;
        zzec3 = zzec5;
        bundle1 = bundle4;
        object2 = object1;
      } 
      i++;
      ArrayList<Bundle> arrayList5 = arrayList4;
      Bundle bundle2 = bundle1;
      zzec zzec4 = zzec3;
      object = object2;
      arrayList3 = arrayList5;
    } 
    if (k != 0) {
      arrayList3.putLong("_eid", l);
      arrayList3.putInt("_epc", k);
    } 
    for (j = 0; j < object.size(); j++) {
      String str;
      Bundle bundle1 = (Bundle)object.get(j);
      if (j != 0) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i != 0) {
        str = "_ep";
      } else {
        str = paramString2;
      } 
      bundle1.putString("_o", paramString1);
      if (paramBoolean2)
        bundle1 = super.zzab().zzg(bundle1); 
      super.zzad().zzdh().zza("Logging event (FE)", super.zzaa().zzal(paramString2), super.zzaa().zzc(bundle1));
      zzaj zzaj = new zzaj(str, new zzag(bundle1), paramString1, paramLong);
      super.zzu().zzc(zzaj, paramString3);
      if (!bool1) {
        Iterator<zzdb> iterator = this.zzph.iterator();
        while (iterator.hasNext())
          ((zzdb)iterator.next()).onEvent(paramString1, paramString2, new Bundle(bundle1), paramLong); 
      } 
    } 
    super.zzag();
    if (super.zzv().zzfc() != null && "_ae".equals(paramString2))
      super.zzx().zza(true, true); 
  }
  
  private final void zza(String paramString1, String paramString2, long paramLong, Object paramObject) {
    super.zzac().zza(new zzdg(this, paramString1, paramString2, paramObject, paramLong));
  }
  
  private final void zza(String paramString1, String paramString2, String paramString3, Bundle paramBundle) {
    long l = super.zzz().currentTimeMillis();
    Preconditions.checkNotEmpty(paramString2);
    Bundle bundle = new Bundle();
    if (paramString1 != null)
      bundle.putString("app_id", paramString1); 
    bundle.putString("name", paramString2);
    bundle.putLong("creation_timestamp", l);
    if (paramString3 != null) {
      bundle.putString("expired_event_name", paramString3);
      bundle.putBundle("expired_event_params", paramBundle);
    } 
    super.zzac().zza(new zzdm(this, bundle));
  }
  
  @VisibleForTesting
  private final Map<String, Object> zzb(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    if (super.zzac().zzef()) {
      super.zzad().zzda().zzaq("Cannot get user properties from analytics worker thread");
      return Collections.emptyMap();
    } 
    if (zzq.isMainThread()) {
      super.zzad().zzda().zzaq("Cannot get user properties from main thread");
      return Collections.emptyMap();
    } 
    synchronized (new AtomicReference()) {
      zzbt zzbt = this.zzl.zzac();
      zzdp zzdp = new zzdp();
      this(this, null, paramString1, paramString2, paramString3, paramBoolean);
      zzbt.zza(zzdp);
      try {
        null.wait(5000L);
      } catch (InterruptedException interruptedException) {
        super.zzad().zzdd().zza("Interrupted waiting for get user properties", interruptedException);
      } 
      List list = null.get();
      if (list == null) {
        super.zzad().zzdd().zzaq("Timed out waiting for get user properties");
        return Collections.emptyMap();
      } 
      ArrayMap<String, Object> arrayMap = new ArrayMap(list.size());
      for (zzga zzga : list)
        arrayMap.put(zzga.name, zzga.getValue()); 
      return (Map<String, Object>)arrayMap;
    } 
  }
  
  private final void zzb(String paramString1, String paramString2, long paramLong, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3) {
    paramBundle = zzgd.zzh(paramBundle);
    super.zzac().zza(new zzdf(this, paramString1, paramString2, paramLong, paramBundle, paramBoolean1, paramBoolean2, paramBoolean3, paramString3));
  }
  
  @WorkerThread
  private final void zze(Bundle paramBundle) {
    super.zzq();
    zzah();
    Preconditions.checkNotNull(paramBundle);
    Preconditions.checkNotEmpty(paramBundle.getString("name"));
    Preconditions.checkNotEmpty(paramBundle.getString("origin"));
    Preconditions.checkNotNull(paramBundle.get("value"));
    if (!this.zzl.isEnabled()) {
      super.zzad().zzdh().zzaq("Conditional property not sent since collection is disabled");
      return;
    } 
    zzga zzga = new zzga(paramBundle.getString("name"), paramBundle.getLong("triggered_timestamp"), paramBundle.get("value"), paramBundle.getString("origin"));
    try {
      zzaj zzaj1 = super.zzab().zza(paramBundle.getString("app_id"), paramBundle.getString("triggered_event_name"), paramBundle.getBundle("triggered_event_params"), paramBundle.getString("origin"), 0L, true, false);
      zzaj zzaj2 = super.zzab().zza(paramBundle.getString("app_id"), paramBundle.getString("timed_out_event_name"), paramBundle.getBundle("timed_out_event_params"), paramBundle.getString("origin"), 0L, true, false);
      zzaj zzaj3 = super.zzab().zza(paramBundle.getString("app_id"), paramBundle.getString("expired_event_name"), paramBundle.getBundle("expired_event_params"), paramBundle.getString("origin"), 0L, true, false);
      zzr zzr = new zzr(paramBundle.getString("app_id"), paramBundle.getString("origin"), zzga, paramBundle.getLong("creation_timestamp"), false, paramBundle.getString("trigger_event_name"), zzaj2, paramBundle.getLong("trigger_timeout"), zzaj1, paramBundle.getLong("time_to_live"), zzaj3);
      super.zzu().zzd(zzr);
      return;
    } catch (IllegalArgumentException illegalArgumentException) {
      return;
    } 
  }
  
  @VisibleForTesting
  private final ArrayList<Bundle> zzf(String paramString1, String paramString2, String paramString3) {
    if (super.zzac().zzef()) {
      super.zzad().zzda().zzaq("Cannot get conditional user properties from analytics worker thread");
      return new ArrayList<Bundle>(0);
    } 
    if (zzq.isMainThread()) {
      super.zzad().zzda().zzaq("Cannot get conditional user properties from main thread");
      return new ArrayList<Bundle>(0);
    } 
    synchronized (new AtomicReference()) {
      zzbt zzbt = this.zzl.zzac();
      zzdn zzdn = new zzdn();
      this(this, null, paramString1, paramString2, paramString3);
      zzbt.zza(zzdn);
      try {
        null.wait(5000L);
      } catch (InterruptedException interruptedException) {
        super.zzad().zzdd().zza("Interrupted waiting for get conditional user properties", paramString1, interruptedException);
      } 
      List<zzr> list = null.get();
      if (list == null) {
        super.zzad().zzdd().zza("Timed out waiting for get conditional user properties", paramString1);
        return new ArrayList<Bundle>();
      } 
      return zzgd.zzc(list);
    } 
  }
  
  @WorkerThread
  private final void zzf(Bundle paramBundle) {
    super.zzq();
    zzah();
    Preconditions.checkNotNull(paramBundle);
    Preconditions.checkNotEmpty(paramBundle.getString("name"));
    if (!this.zzl.isEnabled()) {
      super.zzad().zzdh().zzaq("Conditional property not cleared since collection is disabled");
      return;
    } 
    zzga zzga = new zzga(paramBundle.getString("name"), 0L, null, null);
    try {
      zzaj zzaj = super.zzab().zza(paramBundle.getString("app_id"), paramBundle.getString("expired_event_name"), paramBundle.getBundle("expired_event_params"), paramBundle.getString("origin"), paramBundle.getLong("creation_timestamp"), true, false);
      zzr zzr = new zzr(paramBundle.getString("app_id"), paramBundle.getString("origin"), zzga, paramBundle.getLong("creation_timestamp"), paramBundle.getBoolean("active"), paramBundle.getString("trigger_event_name"), null, paramBundle.getLong("trigger_timeout"), null, paramBundle.getLong("time_to_live"), zzaj);
      super.zzu().zzd(zzr);
      return;
    } catch (IllegalArgumentException illegalArgumentException) {
      return;
    } 
  }
  
  @WorkerThread
  private final void zzfa() {
    if (super.zzaf().zze(super.zzt().zzan(), zzal.zzin)) {
      super.zzq();
      String str = (super.zzae()).zzlp.zzed();
      if (str != null)
        if ("unset".equals(str)) {
          zza("app", "_npa", (Object)null, super.zzz().currentTimeMillis());
        } else {
          long l;
          if ("true".equals(str)) {
            l = 1L;
          } else {
            l = 0L;
          } 
          zza("app", "_npa", Long.valueOf(l), super.zzz().currentTimeMillis());
        }  
    } 
    if (super.zzaf().zzs(super.zzt().zzan()) && this.zzl.isEnabled() && this.zzpk) {
      super.zzad().zzdh().zzaq("Recording app launch after enabling measurement for the first time (FE)");
      zzfb();
      return;
    } 
    super.zzad().zzdh().zzaq("Updating Scion state (FE)");
    super.zzu().zzfe();
  }
  
  @WorkerThread
  private final void zzg(boolean paramBoolean) {
    super.zzq();
    super.zzo();
    zzah();
    super.zzad().zzdh().zza("Setting app measurement enabled (FE)", Boolean.valueOf(paramBoolean));
    super.zzae().setMeasurementEnabled(paramBoolean);
    zzfa();
  }
  
  @Nullable
  private final String zzz(long paramLong) {
    synchronized (new AtomicReference()) {
      zzbt zzbt = super.zzac();
      zzdi zzdi = new zzdi();
      this(this, null);
      zzbt.zza(zzdi);
      try {
        null.wait(paramLong);
        return null.get();
      } catch (InterruptedException interruptedException) {
        super.zzad().zzdd().zzaq("Interrupted waiting for app instance id");
        return null;
      } 
    } 
  }
  
  public final void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle) {
    super.zzo();
    zza((String)null, paramString1, paramString2, paramBundle);
  }
  
  public final void clearConditionalUserPropertyAs(String paramString1, String paramString2, String paramString3, Bundle paramBundle) {
    Preconditions.checkNotEmpty(paramString1);
    super.zzn();
    zza(paramString1, paramString2, paramString3, paramBundle);
  }
  
  @Nullable
  public final String getCurrentScreenClass() {
    zzec zzec = this.zzl.zzv().zzfd();
    return (zzec != null) ? zzec.zzpv : null;
  }
  
  @Nullable
  public final String getCurrentScreenName() {
    zzec zzec = this.zzl.zzv().zzfd();
    return (zzec != null) ? zzec.zzpu : null;
  }
  
  @Nullable
  public final String getGmpAppId() {
    if (this.zzl.zzem() != null)
      return this.zzl.zzem(); 
    try {
      return GoogleServices.getGoogleAppId();
    } catch (IllegalStateException illegalStateException) {
      this.zzl.zzad().zzda().zza("getGoogleAppId failed with exception", illegalStateException);
      return null;
    } 
  }
  
  public final Map<String, Object> getUserProperties(String paramString1, String paramString2, boolean paramBoolean) {
    super.zzo();
    return zzb((String)null, paramString1, paramString2, paramBoolean);
  }
  
  public final Map<String, Object> getUserPropertiesAs(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    Preconditions.checkNotEmpty(paramString1);
    super.zzn();
    return zzb(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public final void logEvent(String paramString1, String paramString2, Bundle paramBundle) {
    logEvent(paramString1, paramString2, paramBundle, true, true, super.zzz().currentTimeMillis());
  }
  
  public final void logEvent(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong) {
    boolean bool;
    super.zzo();
    if (paramString1 == null)
      paramString1 = "app"; 
    if (paramBundle == null)
      paramBundle = new Bundle(); 
    if (!paramBoolean2 || this.zzpg == null || zzgd.zzbs(paramString2)) {
      bool = true;
    } else {
      bool = false;
    } 
    zzb(paramString1, paramString2, paramLong, paramBundle, paramBoolean2, bool, paramBoolean1 ^ true, null);
  }
  
  public final void resetAnalyticsData(long paramLong) {
    zzbi(null);
    super.zzac().zza(new zzdj(this, paramLong));
  }
  
  public final void setConditionalUserProperty(Bundle paramBundle) {
    setConditionalUserProperty(paramBundle, super.zzz().currentTimeMillis());
  }
  
  public final void setConditionalUserProperty(Bundle paramBundle, long paramLong) {
    Preconditions.checkNotNull(paramBundle);
    super.zzo();
    paramBundle = new Bundle(paramBundle);
    if (!TextUtils.isEmpty(paramBundle.getString("app_id")))
      super.zzad().zzdd().zzaq("Package name should be null when calling setConditionalUserProperty"); 
    paramBundle.remove("app_id");
    zza(paramBundle, paramLong);
  }
  
  public final void setMeasurementEnabled(boolean paramBoolean) {
    zzah();
    super.zzo();
    super.zzac().zza(new zzdt(this, paramBoolean));
  }
  
  public final void setMinimumSessionDuration(long paramLong) {
    super.zzo();
    super.zzac().zza(new zzdv(this, paramLong));
  }
  
  public final void setSessionTimeoutDuration(long paramLong) {
    super.zzo();
    super.zzac().zza(new zzdw(this, paramLong));
  }
  
  @WorkerThread
  public final void zza(zzda paramzzda) {
    super.zzq();
    super.zzo();
    zzah();
    if (paramzzda != null) {
      zzda zzda1 = this.zzpg;
      if (paramzzda != zzda1) {
        boolean bool;
        if (zzda1 == null) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.checkState(bool, "EventInterceptor already set.");
      } 
    } 
    this.zzpg = paramzzda;
  }
  
  public final void zza(zzdb paramzzdb) {
    super.zzo();
    zzah();
    Preconditions.checkNotNull(paramzzdb);
    if (!this.zzph.add(paramzzdb))
      super.zzad().zzdd().zzaq("OnEventListener already registered"); 
  }
  
  @WorkerThread
  final void zza(String paramString1, String paramString2, long paramLong, Bundle paramBundle) {
    boolean bool;
    super.zzo();
    super.zzq();
    if (this.zzpg == null || zzgd.zzbs(paramString2)) {
      bool = true;
    } else {
      bool = false;
    } 
    zza(paramString1, paramString2, paramLong, paramBundle, true, bool, false, null);
  }
  
  @WorkerThread
  final void zza(String paramString1, String paramString2, Bundle paramBundle) {
    super.zzo();
    super.zzq();
    zza(paramString1, paramString2, super.zzz().currentTimeMillis(), paramBundle);
  }
  
  public final void zza(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean) {
    logEvent(paramString1, paramString2, paramBundle, false, true, super.zzz().currentTimeMillis());
  }
  
  @WorkerThread
  final void zza(String paramString1, String paramString2, Object paramObject, long paramLong) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   9: pop
    //   10: aload_0
    //   11: invokevirtual zzq : ()V
    //   14: aload_0
    //   15: invokevirtual zzo : ()V
    //   18: aload_0
    //   19: invokevirtual zzah : ()V
    //   22: aload_0
    //   23: invokevirtual zzaf : ()Lcom/google/android/gms/measurement/internal/zzt;
    //   26: aload_0
    //   27: invokevirtual zzt : ()Lcom/google/android/gms/measurement/internal/zzap;
    //   30: invokevirtual zzan : ()Ljava/lang/String;
    //   33: getstatic com/google/android/gms/measurement/internal/zzal.zzin : Lcom/google/android/gms/measurement/internal/zzal$zza;
    //   36: invokevirtual zze : (Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzal$zza;)Z
    //   39: ifeq -> 174
    //   42: ldc_w 'allow_personalized_ads'
    //   45: aload_2
    //   46: invokevirtual equals : (Ljava/lang/Object;)Z
    //   49: ifeq -> 174
    //   52: aload_3
    //   53: instanceof java/lang/String
    //   56: ifeq -> 150
    //   59: aload_3
    //   60: checkcast java/lang/String
    //   63: astore #6
    //   65: aload #6
    //   67: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   70: ifne -> 150
    //   73: ldc_w 'false'
    //   76: aload #6
    //   78: getstatic java/util/Locale.ENGLISH : Ljava/util/Locale;
    //   81: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   84: invokevirtual equals : (Ljava/lang/Object;)Z
    //   87: ifeq -> 96
    //   90: lconst_1
    //   91: lstore #7
    //   93: goto -> 99
    //   96: lconst_0
    //   97: lstore #7
    //   99: lload #7
    //   101: invokestatic valueOf : (J)Ljava/lang/Long;
    //   104: astore_3
    //   105: aload_0
    //   106: invokevirtual zzae : ()Lcom/google/android/gms/measurement/internal/zzbf;
    //   109: getfield zzlp : Lcom/google/android/gms/measurement/internal/zzbk;
    //   112: astore #6
    //   114: aload_3
    //   115: checkcast java/lang/Long
    //   118: invokevirtual longValue : ()J
    //   121: lconst_1
    //   122: lcmp
    //   123: ifne -> 133
    //   126: ldc_w 'true'
    //   129: astore_2
    //   130: goto -> 137
    //   133: ldc_w 'false'
    //   136: astore_2
    //   137: aload #6
    //   139: aload_2
    //   140: invokevirtual zzav : (Ljava/lang/String;)V
    //   143: ldc_w '_npa'
    //   146: astore_2
    //   147: goto -> 174
    //   150: aload_3
    //   151: ifnonnull -> 174
    //   154: aload_0
    //   155: invokevirtual zzae : ()Lcom/google/android/gms/measurement/internal/zzbf;
    //   158: getfield zzlp : Lcom/google/android/gms/measurement/internal/zzbk;
    //   161: ldc_w 'unset'
    //   164: invokevirtual zzav : (Ljava/lang/String;)V
    //   167: ldc_w '_npa'
    //   170: astore_2
    //   171: goto -> 174
    //   174: aload_0
    //   175: getfield zzl : Lcom/google/android/gms/measurement/internal/zzby;
    //   178: invokevirtual isEnabled : ()Z
    //   181: ifne -> 198
    //   184: aload_0
    //   185: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   188: invokevirtual zzdh : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   191: ldc_w 'User property not set since app measurement is disabled'
    //   194: invokevirtual zzaq : (Ljava/lang/String;)V
    //   197: return
    //   198: aload_0
    //   199: getfield zzl : Lcom/google/android/gms/measurement/internal/zzby;
    //   202: invokevirtual zzet : ()Z
    //   205: ifne -> 209
    //   208: return
    //   209: aload_0
    //   210: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   213: invokevirtual zzdh : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   216: ldc_w 'Setting user property (FE)'
    //   219: aload_0
    //   220: invokevirtual zzaa : ()Lcom/google/android/gms/measurement/internal/zzas;
    //   223: aload_2
    //   224: invokevirtual zzal : (Ljava/lang/String;)Ljava/lang/String;
    //   227: aload_3
    //   228: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   231: new com/google/android/gms/measurement/internal/zzga
    //   234: dup
    //   235: aload_2
    //   236: lload #4
    //   238: aload_3
    //   239: aload_1
    //   240: invokespecial <init> : (Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V
    //   243: astore_1
    //   244: aload_0
    //   245: invokevirtual zzu : ()Lcom/google/android/gms/measurement/internal/zzeg;
    //   248: aload_1
    //   249: invokevirtual zzb : (Lcom/google/android/gms/measurement/internal/zzga;)V
    //   252: return
  }
  
  public final void zza(String paramString1, String paramString2, Object paramObject, boolean paramBoolean, long paramLong) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 11
    //   4: ldc_w 'app'
    //   7: astore_1
    //   8: goto -> 11
    //   11: bipush #6
    //   13: istore #7
    //   15: iconst_0
    //   16: istore #8
    //   18: iconst_0
    //   19: istore #9
    //   21: iload #4
    //   23: ifeq -> 39
    //   26: aload_0
    //   27: invokevirtual zzab : ()Lcom/google/android/gms/measurement/internal/zzgd;
    //   30: aload_2
    //   31: invokevirtual zzbo : (Ljava/lang/String;)I
    //   34: istore #7
    //   36: goto -> 102
    //   39: aload_0
    //   40: invokevirtual zzab : ()Lcom/google/android/gms/measurement/internal/zzgd;
    //   43: astore #10
    //   45: aload #10
    //   47: ldc_w 'user property'
    //   50: aload_2
    //   51: invokevirtual zzp : (Ljava/lang/String;Ljava/lang/String;)Z
    //   54: ifne -> 60
    //   57: goto -> 102
    //   60: aload #10
    //   62: ldc_w 'user property'
    //   65: getstatic com/google/android/gms/measurement/internal/zzcz.zzpc : [Ljava/lang/String;
    //   68: aload_2
    //   69: invokevirtual zza : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Z
    //   72: ifne -> 82
    //   75: bipush #15
    //   77: istore #7
    //   79: goto -> 102
    //   82: aload #10
    //   84: ldc_w 'user property'
    //   87: bipush #24
    //   89: aload_2
    //   90: invokevirtual zza : (Ljava/lang/String;ILjava/lang/String;)Z
    //   93: ifne -> 99
    //   96: goto -> 102
    //   99: iconst_0
    //   100: istore #7
    //   102: iload #7
    //   104: ifeq -> 153
    //   107: aload_0
    //   108: invokevirtual zzab : ()Lcom/google/android/gms/measurement/internal/zzgd;
    //   111: pop
    //   112: aload_2
    //   113: bipush #24
    //   115: iconst_1
    //   116: invokestatic zza : (Ljava/lang/String;IZ)Ljava/lang/String;
    //   119: astore_1
    //   120: iload #9
    //   122: istore #8
    //   124: aload_2
    //   125: ifnull -> 134
    //   128: aload_2
    //   129: invokevirtual length : ()I
    //   132: istore #8
    //   134: aload_0
    //   135: getfield zzl : Lcom/google/android/gms/measurement/internal/zzby;
    //   138: invokevirtual zzab : ()Lcom/google/android/gms/measurement/internal/zzgd;
    //   141: iload #7
    //   143: ldc_w '_ev'
    //   146: aload_1
    //   147: iload #8
    //   149: invokevirtual zza : (ILjava/lang/String;Ljava/lang/String;I)V
    //   152: return
    //   153: aload_3
    //   154: ifnull -> 256
    //   157: aload_0
    //   158: invokevirtual zzab : ()Lcom/google/android/gms/measurement/internal/zzgd;
    //   161: aload_2
    //   162: aload_3
    //   163: invokevirtual zzc : (Ljava/lang/String;Ljava/lang/Object;)I
    //   166: istore #9
    //   168: iload #9
    //   170: ifeq -> 232
    //   173: aload_0
    //   174: invokevirtual zzab : ()Lcom/google/android/gms/measurement/internal/zzgd;
    //   177: pop
    //   178: aload_2
    //   179: bipush #24
    //   181: iconst_1
    //   182: invokestatic zza : (Ljava/lang/String;IZ)Ljava/lang/String;
    //   185: astore_1
    //   186: aload_3
    //   187: instanceof java/lang/String
    //   190: ifne -> 204
    //   193: iload #8
    //   195: istore #7
    //   197: aload_3
    //   198: instanceof java/lang/CharSequence
    //   201: ifeq -> 213
    //   204: aload_3
    //   205: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   208: invokevirtual length : ()I
    //   211: istore #7
    //   213: aload_0
    //   214: getfield zzl : Lcom/google/android/gms/measurement/internal/zzby;
    //   217: invokevirtual zzab : ()Lcom/google/android/gms/measurement/internal/zzgd;
    //   220: iload #9
    //   222: ldc_w '_ev'
    //   225: aload_1
    //   226: iload #7
    //   228: invokevirtual zza : (ILjava/lang/String;Ljava/lang/String;I)V
    //   231: return
    //   232: aload_0
    //   233: invokevirtual zzab : ()Lcom/google/android/gms/measurement/internal/zzgd;
    //   236: aload_2
    //   237: aload_3
    //   238: invokevirtual zzd : (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   241: astore_3
    //   242: aload_3
    //   243: ifnull -> 255
    //   246: aload_0
    //   247: aload_1
    //   248: aload_2
    //   249: lload #5
    //   251: aload_3
    //   252: invokespecial zza : (Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   255: return
    //   256: aload_0
    //   257: aload_1
    //   258: aload_2
    //   259: lload #5
    //   261: aconst_null
    //   262: invokespecial zza : (Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   265: return
  }
  
  public final void zza(boolean paramBoolean) {
    zzah();
    super.zzo();
    super.zzac().zza(new zzdu(this, paramBoolean));
  }
  
  protected final boolean zzak() {
    return false;
  }
  
  public final void zzb(zzdb paramzzdb) {
    super.zzo();
    zzah();
    Preconditions.checkNotNull(paramzzdb);
    if (!this.zzph.remove(paramzzdb))
      super.zzad().zzdd().zzaq("OnEventListener had not been registered"); 
  }
  
  public final void zzb(String paramString1, String paramString2, Object paramObject, boolean paramBoolean) {
    zza(paramString1, paramString2, paramObject, paramBoolean, super.zzz().currentTimeMillis());
  }
  
  final void zzbi(@Nullable String paramString) {
    this.zzpj.set(paramString);
  }
  
  public final void zzd(Bundle paramBundle) {
    Preconditions.checkNotNull(paramBundle);
    Preconditions.checkNotEmpty(paramBundle.getString("app_id"));
    super.zzn();
    zza(new Bundle(paramBundle), super.zzz().currentTimeMillis());
  }
  
  public final ArrayList<Bundle> zze(String paramString1, String paramString2, String paramString3) {
    Preconditions.checkNotEmpty(paramString1);
    super.zzn();
    return zzf(paramString1, paramString2, paramString3);
  }
  
  public final void zzeu() {
    if (super.getContext().getApplicationContext() instanceof Application)
      ((Application)super.getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zzpf); 
  }
  
  public final Boolean zzev() {
    AtomicReference<Boolean> atomicReference = new AtomicReference();
    return super.zzac().<Boolean>zza(atomicReference, 15000L, "boolean test flag value", new zzde(this, atomicReference));
  }
  
  public final String zzew() {
    AtomicReference<String> atomicReference = new AtomicReference();
    return super.zzac().<String>zza(atomicReference, 15000L, "String test flag value", new zzdo(this, atomicReference));
  }
  
  public final Long zzex() {
    AtomicReference<Long> atomicReference = new AtomicReference();
    return super.zzac().<Long>zza(atomicReference, 15000L, "long test flag value", new zzdq(this, atomicReference));
  }
  
  public final Integer zzey() {
    AtomicReference<Integer> atomicReference = new AtomicReference();
    return super.zzac().<Integer>zza(atomicReference, 15000L, "int test flag value", new zzdr(this, atomicReference));
  }
  
  public final Double zzez() {
    AtomicReference<Double> atomicReference = new AtomicReference();
    return super.zzac().<Double>zza(atomicReference, 15000L, "double test flag value", new zzds(this, atomicReference));
  }
  
  @WorkerThread
  public final void zzfb() {
    super.zzq();
    super.zzo();
    zzah();
    if (!this.zzl.zzet())
      return; 
    super.zzu().zzfb();
    this.zzpk = false;
    String str = super.zzae().zzdx();
    if (!TextUtils.isEmpty(str)) {
      super.zzy().zzah();
      if (!str.equals(Build.VERSION.RELEASE)) {
        Bundle bundle = new Bundle();
        bundle.putString("_po", str);
        logEvent("auto", "_ou", bundle);
      } 
    } 
  }
  
  public final List<zzga> zzh(boolean paramBoolean) {
    AtomicReference<List> atomicReference;
    List<zzga> list;
    super.zzo();
    zzah();
    super.zzad().zzdh().zzaq("Fetching user attributes (FE)");
    if (super.zzac().zzef()) {
      super.zzad().zzda().zzaq("Cannot get all user properties from analytics worker thread");
      return Collections.emptyList();
    } 
    if (zzq.isMainThread()) {
      super.zzad().zzda().zzaq("Cannot get all user properties from main thread");
      return Collections.emptyList();
    } 
    synchronized (new AtomicReference()) {
      zzbt zzbt = this.zzl.zzac();
      zzdh zzdh = new zzdh();
      this(this, atomicReference, paramBoolean);
      zzbt.zza(zzdh);
      try {
        atomicReference.wait(5000L);
      } catch (InterruptedException interruptedException) {
        super.zzad().zzdd().zza("Interrupted waiting for get user properties", interruptedException);
      } 
      list = atomicReference.get();
      if (list == null) {
        super.zzad().zzdd().zzaq("Timed out waiting for get user properties");
        return Collections.emptyList();
      } 
      return list;
    } 
  }
  
  @Nullable
  public final String zzj() {
    super.zzo();
    return this.zzpj.get();
  }
  
  public final ArrayList<Bundle> zzn(String paramString1, String paramString2) {
    super.zzo();
    return zzf(null, paramString1, paramString2);
  }
  
  @Nullable
  public final String zzy(long paramLong) {
    if (super.zzac().zzef()) {
      super.zzad().zzda().zzaq("Cannot retrieve app instance id from analytics worker thread");
      return null;
    } 
    if (zzq.isMainThread()) {
      super.zzad().zzda().zzaq("Cannot retrieve app instance id from main thread");
      return null;
    } 
    paramLong = super.zzz().elapsedRealtime();
    String str1 = zzz(120000L);
    paramLong = super.zzz().elapsedRealtime() - paramLong;
    String str2 = str1;
    if (str1 == null) {
      str2 = str1;
      if (paramLong < 120000L)
        str2 = zzz(120000L - paramLong); 
    } 
    return str2;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */