package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@KeepForSdk
@VisibleForTesting
public final class JsonUtils {
  private static final Pattern zzhd = Pattern.compile("\\\\.");
  
  private static final Pattern zzhe = Pattern.compile("[\\\\\"/\b\f\n\r\t]");
  
  @KeepForSdk
  public static boolean areJsonValuesEquivalent(Object paramObject1, Object paramObject2) {
    if (paramObject1 == null && paramObject2 == null)
      return true; 
    if (paramObject1 == null || paramObject2 == null)
      return false; 
    if (paramObject1 instanceof JSONObject && paramObject2 instanceof JSONObject) {
      paramObject1 = paramObject1;
      JSONObject jSONObject = (JSONObject)paramObject2;
      if (paramObject1.length() != jSONObject.length())
        return false; 
      paramObject2 = paramObject1.keys();
      while (paramObject2.hasNext()) {
        String str = paramObject2.next();
        if (!jSONObject.has(str))
          return false; 
        try {
          boolean bool = areJsonValuesEquivalent(paramObject1.get(str), jSONObject.get(str));
          if (!bool)
            return false; 
        } catch (JSONException null) {
          return false;
        } 
      } 
      return true;
    } 
    if (jSONException instanceof JSONArray && paramObject2 instanceof JSONArray) {
      JSONArray jSONArray = (JSONArray)jSONException;
      paramObject2 = paramObject2;
      if (jSONArray.length() != paramObject2.length())
        return false; 
      byte b = 0;
      while (b < jSONArray.length()) {
        try {
          boolean bool = areJsonValuesEquivalent(jSONArray.get(b), paramObject2.get(b));
          if (!bool)
            return false; 
          b++;
        } catch (JSONException jSONException) {
          return false;
        } 
      } 
      return true;
    } 
    return jSONException.equals(paramObject2);
  }
  
  @KeepForSdk
  public static String escapeString(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      Matcher matcher = zzhe.matcher(paramString);
      StringBuffer stringBuffer;
      for (stringBuffer = null; matcher.find(); stringBuffer = stringBuffer1) {
        StringBuffer stringBuffer1 = stringBuffer;
        if (stringBuffer == null)
          stringBuffer1 = new StringBuffer(); 
        char c = matcher.group().charAt(0);
        if (c != '"') {
          if (c != '/') {
            if (c != '\\') {
              switch (c) {
                default:
                  switch (c) {
                    default:
                      stringBuffer = stringBuffer1;
                      continue;
                    case '\r':
                      matcher.appendReplacement(stringBuffer1, "\\\\r");
                      stringBuffer = stringBuffer1;
                      continue;
                    case '\f':
                      break;
                  } 
                  matcher.appendReplacement(stringBuffer1, "\\\\f");
                  stringBuffer = stringBuffer1;
                  continue;
                case '\n':
                  matcher.appendReplacement(stringBuffer1, "\\\\n");
                  stringBuffer = stringBuffer1;
                  continue;
                case '\t':
                  matcher.appendReplacement(stringBuffer1, "\\\\t");
                  stringBuffer = stringBuffer1;
                  continue;
                case '\b':
                  break;
              } 
              matcher.appendReplacement(stringBuffer1, "\\\\b");
              stringBuffer = stringBuffer1;
              continue;
            } 
            matcher.appendReplacement(stringBuffer1, "\\\\\\\\");
            stringBuffer = stringBuffer1;
            continue;
          } 
          matcher.appendReplacement(stringBuffer1, "\\\\/");
          stringBuffer = stringBuffer1;
          continue;
        } 
        matcher.appendReplacement(stringBuffer1, "\\\\\\\"");
      } 
      if (stringBuffer == null)
        return paramString; 
      matcher.appendTail(stringBuffer);
      return stringBuffer.toString();
    } 
    return paramString;
  }
  
  @KeepForSdk
  public static String unescapeString(String paramString) {
    StringBuffer stringBuffer;
    if (!TextUtils.isEmpty(paramString)) {
      String str = zzd.unescape(paramString);
      Matcher matcher = zzhd.matcher(str);
      paramString = null;
      while (matcher.find()) {
        StringBuffer stringBuffer1;
        String str1 = paramString;
        if (paramString == null)
          stringBuffer1 = new StringBuffer(); 
        char c = matcher.group().charAt(1);
        if (c != '"') {
          if (c != '/') {
            if (c != '\\') {
              if (c != 'b') {
                if (c != 'f') {
                  if (c != 'n') {
                    if (c != 'r') {
                      if (c == 't') {
                        matcher.appendReplacement(stringBuffer1, "\t");
                        StringBuffer stringBuffer8 = stringBuffer1;
                        continue;
                      } 
                      throw new IllegalStateException("Found an escaped character that should never be.");
                    } 
                    matcher.appendReplacement(stringBuffer1, "\r");
                    StringBuffer stringBuffer7 = stringBuffer1;
                    continue;
                  } 
                  matcher.appendReplacement(stringBuffer1, "\n");
                  StringBuffer stringBuffer6 = stringBuffer1;
                  continue;
                } 
                matcher.appendReplacement(stringBuffer1, "\f");
                StringBuffer stringBuffer5 = stringBuffer1;
                continue;
              } 
              matcher.appendReplacement(stringBuffer1, "\b");
              StringBuffer stringBuffer4 = stringBuffer1;
              continue;
            } 
            matcher.appendReplacement(stringBuffer1, "\\\\");
            StringBuffer stringBuffer3 = stringBuffer1;
            continue;
          } 
          matcher.appendReplacement(stringBuffer1, "/");
          StringBuffer stringBuffer2 = stringBuffer1;
          continue;
        } 
        matcher.appendReplacement(stringBuffer1, "\"");
        stringBuffer = stringBuffer1;
      } 
      if (stringBuffer == null)
        return str; 
      matcher.appendTail(stringBuffer);
      return stringBuffer.toString();
    } 
    return (String)stringBuffer;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\JsonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */