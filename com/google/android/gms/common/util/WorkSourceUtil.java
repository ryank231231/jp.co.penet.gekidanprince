package com.google.android.gms.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@KeepForSdk
public class WorkSourceUtil {
  private static final int zzhj = Process.myUid();
  
  private static final Method zzhk = zzx();
  
  private static final Method zzhl = zzy();
  
  private static final Method zzhm = zzz();
  
  private static final Method zzhn = zzaa();
  
  private static final Method zzho = zzab();
  
  private static final Method zzhp = zzac();
  
  private static final Method zzhq = zzad();
  
  @Nullable
  @KeepForSdk
  public static WorkSource fromPackage(Context paramContext, @Nullable String paramString) {
    if (paramContext == null || paramContext.getPackageManager() == null || paramString == null)
      return null; 
    try {
      String str;
      ApplicationInfo applicationInfo = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0);
      if (applicationInfo == null) {
        str = String.valueOf(paramString);
        if (str.length() != 0) {
          str = "Could not get applicationInfo from package: ".concat(str);
        } else {
          str = new String("Could not get applicationInfo from package: ");
        } 
        Log.e("WorkSourceUtil", str);
        return null;
      } 
      return zza(((ApplicationInfo)str).uid, paramString);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      String str = String.valueOf(paramString);
      if (str.length() != 0) {
        str = "Could not find package: ".concat(str);
      } else {
        str = new String("Could not find package: ");
      } 
      Log.e("WorkSourceUtil", str);
      return null;
    } 
  }
  
  @KeepForSdk
  public static WorkSource fromPackageAndModuleExperimentalPi(Context paramContext, String paramString1, String paramString2) {
    if (paramContext == null || paramContext.getPackageManager() == null || paramString2 == null || paramString1 == null) {
      Log.w("WorkSourceUtil", "Unexpected null arguments");
      return null;
    } 
    int i = zzd(paramContext, paramString1);
    if (i < 0)
      return null; 
    WorkSource workSource = new WorkSource();
    Method method = zzhp;
    if (method == null || zzhq == null) {
      zza(workSource, i, paramString1);
      return workSource;
    } 
    try {
      Object object = method.invoke(workSource, new Object[0]);
      if (i != zzhj)
        zzhq.invoke(object, new Object[] { Integer.valueOf(i), paramString1 }); 
      zzhq.invoke(object, new Object[] { Integer.valueOf(zzhj), paramString2 });
    } catch (Exception exception) {
      Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", exception);
    } 
    return workSource;
  }
  
  @KeepForSdk
  public static List<String> getNames(@Nullable WorkSource paramWorkSource) {
    int i;
    byte b = 0;
    if (paramWorkSource == null) {
      i = 0;
    } else {
      i = zza(paramWorkSource);
    } 
    if (i == 0)
      return Collections.emptyList(); 
    ArrayList<String> arrayList = new ArrayList();
    while (b < i) {
      String str = zza(paramWorkSource, b);
      if (!Strings.isEmptyOrWhitespace(str))
        arrayList.add(str); 
      b++;
    } 
    return arrayList;
  }
  
  @KeepForSdk
  public static boolean hasWorkSourcePermission(Context paramContext) {
    return (paramContext == null) ? false : ((paramContext.getPackageManager() == null) ? false : ((Wrappers.packageManager(paramContext).checkPermission("android.permission.UPDATE_DEVICE_STATS", paramContext.getPackageName()) == 0)));
  }
  
  private static int zza(WorkSource paramWorkSource) {
    Method method = zzhm;
    if (method != null)
      try {
        return ((Integer)method.invoke(paramWorkSource, new Object[0])).intValue();
      } catch (Exception exception) {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", exception);
      }  
    return 0;
  }
  
  private static WorkSource zza(int paramInt, String paramString) {
    WorkSource workSource = new WorkSource();
    zza(workSource, paramInt, paramString);
    return workSource;
  }
  
  @Nullable
  private static String zza(WorkSource paramWorkSource, int paramInt) {
    Method method = zzho;
    if (method != null)
      try {
        return (String)method.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
      } catch (Exception exception) {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", exception);
      }  
    return null;
  }
  
  private static void zza(WorkSource paramWorkSource, int paramInt, @Nullable String paramString) {
    if (zzhl != null) {
      String str = paramString;
      if (paramString == null)
        str = ""; 
      try {
        zzhl.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt), str });
        return;
      } catch (Exception exception) {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", exception);
        return;
      } 
    } 
    Method method = zzhk;
    if (method != null)
      try {
        method.invoke(exception, new Object[] { Integer.valueOf(paramInt) });
        return;
      } catch (Exception exception1) {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", exception1);
      }  
  }
  
  private static Method zzaa() {
    try {
      Method method = WorkSource.class.getMethod("get", new Class[] { int.class });
    } catch (Exception exception) {
      exception = null;
    } 
    return (Method)exception;
  }
  
  private static Method zzab() {
    if (PlatformVersion.isAtLeastJellyBeanMR2())
      try {
        return WorkSource.class.getMethod("getName", new Class[] { int.class });
      } catch (Exception exception) {} 
    return null;
  }
  
  private static final Method zzac() {
    if (PlatformVersion.isAtLeastP()) {
      try {
        Method method = WorkSource.class.getMethod("createWorkChain", new Class[0]);
      } catch (Exception exception) {
        Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", exception);
        exception = null;
      } 
      return (Method)exception;
    } 
    Object object = null;
  }
  
  @SuppressLint({"PrivateApi"})
  private static final Method zzad() {
    if (PlatformVersion.isAtLeastP()) {
      try {
        Method method = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", new Class[] { int.class, String.class });
      } catch (Exception exception) {
        Log.w("WorkSourceUtil", "Missing WorkChain class", exception);
        exception = null;
      } 
      return (Method)exception;
    } 
    Object object = null;
  }
  
  private static int zzd(Context paramContext, String paramString) {
    try {
      String str;
      ApplicationInfo applicationInfo = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0);
      if (applicationInfo == null) {
        str = String.valueOf(paramString);
        if (str.length() != 0) {
          str = "Could not get applicationInfo from package: ".concat(str);
        } else {
          str = new String("Could not get applicationInfo from package: ");
        } 
        Log.e("WorkSourceUtil", str);
        return -1;
      } 
      return ((ApplicationInfo)str).uid;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      String str = String.valueOf(paramString);
      if (str.length() != 0) {
        str = "Could not find package: ".concat(str);
      } else {
        str = new String("Could not find package: ");
      } 
      Log.e("WorkSourceUtil", str);
      return -1;
    } 
  }
  
  private static Method zzx() {
    try {
      Method method = WorkSource.class.getMethod("add", new Class[] { int.class });
    } catch (Exception exception) {
      exception = null;
    } 
    return (Method)exception;
  }
  
  private static Method zzy() {
    if (PlatformVersion.isAtLeastJellyBeanMR2())
      try {
        return WorkSource.class.getMethod("add", new Class[] { int.class, String.class });
      } catch (Exception exception) {} 
    return null;
  }
  
  private static Method zzz() {
    try {
      Method method = WorkSource.class.getMethod("size", new Class[0]);
    } catch (Exception exception) {
      exception = null;
    } 
    return (Method)exception;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\WorkSourceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */