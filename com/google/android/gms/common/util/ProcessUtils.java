package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

@KeepForSdk
public class ProcessUtils {
  private static String zzhf;
  
  private static int zzhg;
  
  @Nullable
  @KeepForSdk
  public static String getMyProcessName() {
    if (zzhf == null) {
      if (zzhg == 0)
        zzhg = Process.myPid(); 
      zzhf = zzd(zzhg);
    } 
    return zzhf;
  }
  
  @Nullable
  private static String zzd(int paramInt) {
    String str1;
    BufferedReader bufferedReader = null;
    String str2 = null;
    if (paramInt <= 0)
      return null; 
    try {
      String str;
      StringBuilder stringBuilder = new StringBuilder();
      this(25);
      stringBuilder.append("/proc/");
      stringBuilder.append(paramInt);
      stringBuilder.append("/cmdline");
      BufferedReader bufferedReader1 = zzk(stringBuilder.toString());
      try {
        return str2;
      } catch (IOException iOException) {
      
      } finally {
        str2 = null;
        bufferedReader = bufferedReader1;
      } 
      IOUtils.closeQuietly(bufferedReader);
      throw str;
    } catch (IOException iOException) {
    
    } finally {
      str1 = str2;
      IOUtils.closeQuietly((Closeable)str1);
    } 
    IOUtils.closeQuietly((Closeable)SYNTHETIC_LOCAL_VARIABLE_3);
    return str1;
  }
  
  private static BufferedReader zzk(String paramString) throws IOException {
    StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
    try {
      FileReader fileReader = new FileReader();
      this(paramString);
      return new BufferedReader(fileReader);
    } finally {
      StrictMode.setThreadPolicy(threadPolicy);
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\ProcessUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */