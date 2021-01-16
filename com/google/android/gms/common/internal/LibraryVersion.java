package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@KeepForSdk
public class LibraryVersion {
  private static final GmsLogger zzel = new GmsLogger("LibraryVersion", "");
  
  private static LibraryVersion zzem = new LibraryVersion();
  
  private ConcurrentHashMap<String, String> zzen = new ConcurrentHashMap<String, String>();
  
  @KeepForSdk
  public static LibraryVersion getInstance() {
    return zzem;
  }
  
  @KeepForSdk
  public String getVersion(@NonNull String paramString) {
    String str1;
    GmsLogger gmsLogger3;
    Preconditions.checkNotEmpty(paramString, "Please provide a valid libraryName");
    if (this.zzen.containsKey(paramString))
      return this.zzen.get(paramString); 
    Properties properties = new Properties();
    GmsLogger gmsLogger2 = null;
    String str2 = null;
    String str3 = str2;
    try {
      StringBuilder stringBuilder;
      InputStream inputStream = LibraryVersion.class.getResourceAsStream(String.format("/%s.properties", new Object[] { paramString }));
      if (inputStream != null) {
        str3 = str2;
        properties.load(inputStream);
        str3 = str2;
        str1 = properties.getProperty("version", null);
        str3 = str1;
        gmsLogger2 = zzel;
        str3 = str1;
        int i = String.valueOf(paramString).length();
        str3 = str1;
        int j = String.valueOf(str1).length();
        str3 = str1;
        stringBuilder = new StringBuilder();
        str3 = str1;
        this(i + 12 + j);
        str3 = str1;
        stringBuilder.append(paramString);
        str3 = str1;
        stringBuilder.append(" version is ");
        str3 = str1;
        stringBuilder.append(str1);
        str3 = str1;
        gmsLogger2.v("LibraryVersion", stringBuilder.toString());
        str3 = str1;
      } else {
        StringBuilder stringBuilder1 = stringBuilder;
        GmsLogger gmsLogger = zzel;
        stringBuilder1 = stringBuilder;
        str1 = String.valueOf(paramString);
        stringBuilder1 = stringBuilder;
        if (str1.length() != 0) {
          stringBuilder1 = stringBuilder;
          str1 = "Failed to get app version for libraryName: ".concat(str1);
        } else {
          stringBuilder1 = stringBuilder;
          str1 = new String("Failed to get app version for libraryName: ");
        } 
        stringBuilder1 = stringBuilder;
        gmsLogger.e("LibraryVersion", str1);
        gmsLogger3 = gmsLogger2;
      } 
    } catch (IOException iOException) {
      gmsLogger2 = zzel;
      str1 = String.valueOf(paramString);
      if (str1.length() != 0) {
        str1 = "Failed to get app version for libraryName: ".concat(str1);
      } else {
        str1 = new String("Failed to get app version for libraryName: ");
      } 
      gmsLogger2.e("LibraryVersion", str1, iOException);
    } 
    GmsLogger gmsLogger1 = gmsLogger3;
    if (gmsLogger3 == null) {
      str1 = "UNKNOWN";
      zzel.d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version isexpected druing Google internal testing where locally-built libraries are used");
    } 
    this.zzen.put(paramString, str1);
    return str1;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\LibraryVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */