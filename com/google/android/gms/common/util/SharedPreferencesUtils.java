package com.google.android.gms.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.File;

@KeepForSdk
public class SharedPreferencesUtils {
  @Deprecated
  @KeepForSdk
  public static void publishWorldReadableSharedPreferences(Context paramContext, SharedPreferences.Editor paramEditor, String paramString) {
    File file1 = new File((paramContext.getApplicationInfo()).dataDir, "shared_prefs");
    File file2 = file1.getParentFile();
    if (file2 != null)
      file2.setExecutable(true, false); 
    file1.setExecutable(true, false);
    paramEditor.commit();
    (new File(file1, String.valueOf(paramString).concat(".xml"))).setReadable(true, false);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\SharedPreferencesUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */