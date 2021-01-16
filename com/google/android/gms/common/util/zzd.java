package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@VisibleForTesting
public final class zzd {
  private static final Pattern zzhi = Pattern.compile("\\\\u[0-9a-fA-F]{4}");
  
  public static String unescape(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      Matcher matcher = zzhi.matcher(paramString);
      StringBuffer stringBuffer;
      for (stringBuffer = null; matcher.find(); stringBuffer = stringBuffer1) {
        StringBuffer stringBuffer1 = stringBuffer;
        if (stringBuffer == null)
          stringBuffer1 = new StringBuffer(); 
        matcher.appendReplacement(stringBuffer1, new String(Character.toChars(Integer.parseInt(matcher.group().substring(2), 16))));
      } 
      if (stringBuffer == null)
        return paramString; 
      matcher.appendTail(stringBuffer);
      return stringBuffer.toString();
    } 
    return paramString;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */