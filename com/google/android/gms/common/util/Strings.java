package com.google.android.gms.common.util;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.regex.Pattern;

@KeepForSdk
@VisibleForTesting
public class Strings {
  private static final Pattern zzhh = Pattern.compile("\\$\\{(.*?)\\}");
  
  @Nullable
  @KeepForSdk
  public static String emptyToNull(@Nullable String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = null; 
    return str;
  }
  
  @KeepForSdk
  public static boolean isEmptyOrWhitespace(@Nullable String paramString) {
    return (paramString == null || paramString.trim().isEmpty());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\Strings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */