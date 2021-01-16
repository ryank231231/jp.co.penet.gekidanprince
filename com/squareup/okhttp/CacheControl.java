package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HeaderParser;
import java.util.concurrent.TimeUnit;

public final class CacheControl {
  public static final CacheControl FORCE_CACHE;
  
  public static final CacheControl FORCE_NETWORK = (new Builder()).noCache().build();
  
  String headerValue;
  
  private final boolean isPrivate;
  
  private final boolean isPublic;
  
  private final int maxAgeSeconds;
  
  private final int maxStaleSeconds;
  
  private final int minFreshSeconds;
  
  private final boolean mustRevalidate;
  
  private final boolean noCache;
  
  private final boolean noStore;
  
  private final boolean noTransform;
  
  private final boolean onlyIfCached;
  
  private final int sMaxAgeSeconds;
  
  static {
    FORCE_CACHE = (new Builder()).onlyIfCached().maxStale(2147483647, TimeUnit.SECONDS).build();
  }
  
  private CacheControl(Builder paramBuilder) {
    this.noCache = paramBuilder.noCache;
    this.noStore = paramBuilder.noStore;
    this.maxAgeSeconds = paramBuilder.maxAgeSeconds;
    this.sMaxAgeSeconds = -1;
    this.isPrivate = false;
    this.isPublic = false;
    this.mustRevalidate = false;
    this.maxStaleSeconds = paramBuilder.maxStaleSeconds;
    this.minFreshSeconds = paramBuilder.minFreshSeconds;
    this.onlyIfCached = paramBuilder.onlyIfCached;
    this.noTransform = paramBuilder.noTransform;
  }
  
  private CacheControl(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, String paramString) {
    this.noCache = paramBoolean1;
    this.noStore = paramBoolean2;
    this.maxAgeSeconds = paramInt1;
    this.sMaxAgeSeconds = paramInt2;
    this.isPrivate = paramBoolean3;
    this.isPublic = paramBoolean4;
    this.mustRevalidate = paramBoolean5;
    this.maxStaleSeconds = paramInt3;
    this.minFreshSeconds = paramInt4;
    this.onlyIfCached = paramBoolean6;
    this.noTransform = paramBoolean7;
    this.headerValue = paramString;
  }
  
  private String headerValue() {
    StringBuilder stringBuilder = new StringBuilder();
    if (this.noCache)
      stringBuilder.append("no-cache, "); 
    if (this.noStore)
      stringBuilder.append("no-store, "); 
    if (this.maxAgeSeconds != -1) {
      stringBuilder.append("max-age=");
      stringBuilder.append(this.maxAgeSeconds);
      stringBuilder.append(", ");
    } 
    if (this.sMaxAgeSeconds != -1) {
      stringBuilder.append("s-maxage=");
      stringBuilder.append(this.sMaxAgeSeconds);
      stringBuilder.append(", ");
    } 
    if (this.isPrivate)
      stringBuilder.append("private, "); 
    if (this.isPublic)
      stringBuilder.append("public, "); 
    if (this.mustRevalidate)
      stringBuilder.append("must-revalidate, "); 
    if (this.maxStaleSeconds != -1) {
      stringBuilder.append("max-stale=");
      stringBuilder.append(this.maxStaleSeconds);
      stringBuilder.append(", ");
    } 
    if (this.minFreshSeconds != -1) {
      stringBuilder.append("min-fresh=");
      stringBuilder.append(this.minFreshSeconds);
      stringBuilder.append(", ");
    } 
    if (this.onlyIfCached)
      stringBuilder.append("only-if-cached, "); 
    if (this.noTransform)
      stringBuilder.append("no-transform, "); 
    if (stringBuilder.length() == 0)
      return ""; 
    stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
    return stringBuilder.toString();
  }
  
  public static CacheControl parse(Headers paramHeaders) {
    int i = paramHeaders.size();
    byte b = 0;
    boolean bool1 = true;
    String str = null;
    boolean bool2 = false;
    boolean bool3 = false;
    int j = -1;
    byte b1 = -1;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    byte b2 = -1;
    byte b3 = -1;
    boolean bool7 = false;
    boolean bool8 = false;
    while (true) {
      String str1;
      Headers headers = paramHeaders;
      if (b < i) {
        String str2 = headers.name(b);
        String str3 = headers.value(b);
        if (str2.equalsIgnoreCase("Cache-Control")) {
          if (str != null) {
            bool1 = false;
          } else {
            str = str3;
          } 
        } else if (str2.equalsIgnoreCase("Pragma")) {
          bool1 = false;
        } else {
          continue;
        } 
        int k = 0;
        while (k < str3.length()) {
          String str4;
          boolean bool9;
          boolean bool10;
          byte b4;
          boolean bool11;
          boolean bool12;
          boolean bool13;
          byte b5;
          byte b6;
          boolean bool14;
          int m = HeaderParser.skipUntil(str3, k, "=,;");
          str2 = str3.substring(k, m).trim();
          if (m == str3.length() || str3.charAt(m) == ',' || str3.charAt(m) == ';') {
            k = m + 1;
            headers = null;
          } else {
            m = HeaderParser.skipWhitespace(str3, m + 1);
            if (m < str3.length() && str3.charAt(m) == '"') {
              k = HeaderParser.skipUntil(str3, ++m, "\"");
              str4 = str3.substring(m, k);
              k++;
            } else {
              k = HeaderParser.skipUntil(str3, m, ",;");
              str4 = str3.substring(m, k).trim();
            } 
          } 
          if ("no-cache".equalsIgnoreCase(str2)) {
            bool9 = true;
            bool10 = bool3;
            m = j;
            b4 = b1;
            bool11 = bool4;
            bool12 = bool5;
            bool13 = bool6;
            b5 = b2;
            b6 = b3;
            bool14 = bool7;
          } else if ("no-store".equalsIgnoreCase(str2)) {
            bool10 = true;
            bool9 = bool2;
            m = j;
            b4 = b1;
            bool11 = bool4;
            bool12 = bool5;
            bool13 = bool6;
            b5 = b2;
            b6 = b3;
            bool14 = bool7;
          } else if ("max-age".equalsIgnoreCase(str2)) {
            m = HeaderParser.parseSeconds(str4, -1);
            bool9 = bool2;
            bool10 = bool3;
            b4 = b1;
            bool11 = bool4;
            bool12 = bool5;
            bool13 = bool6;
            b5 = b2;
            b6 = b3;
            bool14 = bool7;
          } else if ("s-maxage".equalsIgnoreCase(str2)) {
            b4 = HeaderParser.parseSeconds(str4, -1);
            bool9 = bool2;
            bool10 = bool3;
            m = j;
            bool11 = bool4;
            bool12 = bool5;
            bool13 = bool6;
            b5 = b2;
            b6 = b3;
            bool14 = bool7;
          } else if ("private".equalsIgnoreCase(str2)) {
            bool11 = true;
            bool9 = bool2;
            bool10 = bool3;
            m = j;
            b4 = b1;
            bool12 = bool5;
            bool13 = bool6;
            b5 = b2;
            b6 = b3;
            bool14 = bool7;
          } else if ("public".equalsIgnoreCase(str2)) {
            bool12 = true;
            bool9 = bool2;
            bool10 = bool3;
            m = j;
            b4 = b1;
            bool11 = bool4;
            bool13 = bool6;
            b5 = b2;
            b6 = b3;
            bool14 = bool7;
          } else if ("must-revalidate".equalsIgnoreCase(str2)) {
            bool13 = true;
            bool9 = bool2;
            bool10 = bool3;
            m = j;
            b4 = b1;
            bool11 = bool4;
            bool12 = bool5;
            b5 = b2;
            b6 = b3;
            bool14 = bool7;
          } else if ("max-stale".equalsIgnoreCase(str2)) {
            b5 = HeaderParser.parseSeconds(str4, 2147483647);
            bool9 = bool2;
            bool10 = bool3;
            m = j;
            b4 = b1;
            bool11 = bool4;
            bool12 = bool5;
            bool13 = bool6;
            b6 = b3;
            bool14 = bool7;
          } else if ("min-fresh".equalsIgnoreCase(str2)) {
            b6 = HeaderParser.parseSeconds(str4, -1);
            bool9 = bool2;
            bool10 = bool3;
            m = j;
            b4 = b1;
            bool11 = bool4;
            bool12 = bool5;
            bool13 = bool6;
            b5 = b2;
            bool14 = bool7;
          } else if ("only-if-cached".equalsIgnoreCase(str2)) {
            bool14 = true;
            bool9 = bool2;
            bool10 = bool3;
            m = j;
            b4 = b1;
            bool11 = bool4;
            bool12 = bool5;
            bool13 = bool6;
            b5 = b2;
            b6 = b3;
          } else {
            bool9 = bool2;
            bool10 = bool3;
            m = j;
            b4 = b1;
            bool11 = bool4;
            bool12 = bool5;
            bool13 = bool6;
            b5 = b2;
            b6 = b3;
            bool14 = bool7;
            if ("no-transform".equalsIgnoreCase(str2)) {
              bool8 = true;
              bool14 = bool7;
              b6 = b3;
              b5 = b2;
              bool13 = bool6;
              bool12 = bool5;
              bool11 = bool4;
              b4 = b1;
              m = j;
              bool10 = bool3;
              bool9 = bool2;
            } 
          } 
          bool2 = bool9;
          bool3 = bool10;
          j = m;
          b1 = b4;
          bool4 = bool11;
          bool5 = bool12;
          bool6 = bool13;
          b2 = b5;
          b3 = b6;
          bool7 = bool14;
        } 
        continue;
      } 
      if (!bool1) {
        paramHeaders = null;
      } else {
        str1 = str;
      } 
      return new CacheControl(bool2, bool3, j, b1, bool4, bool5, bool6, b2, b3, bool7, bool8, str1);
      b++;
    } 
  }
  
  public boolean isPrivate() {
    return this.isPrivate;
  }
  
  public boolean isPublic() {
    return this.isPublic;
  }
  
  public int maxAgeSeconds() {
    return this.maxAgeSeconds;
  }
  
  public int maxStaleSeconds() {
    return this.maxStaleSeconds;
  }
  
  public int minFreshSeconds() {
    return this.minFreshSeconds;
  }
  
  public boolean mustRevalidate() {
    return this.mustRevalidate;
  }
  
  public boolean noCache() {
    return this.noCache;
  }
  
  public boolean noStore() {
    return this.noStore;
  }
  
  public boolean noTransform() {
    return this.noTransform;
  }
  
  public boolean onlyIfCached() {
    return this.onlyIfCached;
  }
  
  public int sMaxAgeSeconds() {
    return this.sMaxAgeSeconds;
  }
  
  public String toString() {
    String str = this.headerValue;
    if (str == null) {
      str = headerValue();
      this.headerValue = str;
    } 
    return str;
  }
  
  public static final class Builder {
    int maxAgeSeconds = -1;
    
    int maxStaleSeconds = -1;
    
    int minFreshSeconds = -1;
    
    boolean noCache;
    
    boolean noStore;
    
    boolean noTransform;
    
    boolean onlyIfCached;
    
    public CacheControl build() {
      return new CacheControl(this);
    }
    
    public Builder maxAge(int param1Int, TimeUnit param1TimeUnit) {
      if (param1Int >= 0) {
        long l = param1TimeUnit.toSeconds(param1Int);
        if (l > 2147483647L) {
          param1Int = Integer.MAX_VALUE;
        } else {
          param1Int = (int)l;
        } 
        this.maxAgeSeconds = param1Int;
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("maxAge < 0: ");
      stringBuilder.append(param1Int);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder maxStale(int param1Int, TimeUnit param1TimeUnit) {
      if (param1Int >= 0) {
        long l = param1TimeUnit.toSeconds(param1Int);
        if (l > 2147483647L) {
          param1Int = Integer.MAX_VALUE;
        } else {
          param1Int = (int)l;
        } 
        this.maxStaleSeconds = param1Int;
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("maxStale < 0: ");
      stringBuilder.append(param1Int);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder minFresh(int param1Int, TimeUnit param1TimeUnit) {
      if (param1Int >= 0) {
        long l = param1TimeUnit.toSeconds(param1Int);
        if (l > 2147483647L) {
          param1Int = Integer.MAX_VALUE;
        } else {
          param1Int = (int)l;
        } 
        this.minFreshSeconds = param1Int;
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("minFresh < 0: ");
      stringBuilder.append(param1Int);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder noCache() {
      this.noCache = true;
      return this;
    }
    
    public Builder noStore() {
      this.noStore = true;
      return this;
    }
    
    public Builder noTransform() {
      this.noTransform = true;
      return this;
    }
    
    public Builder onlyIfCached() {
      this.onlyIfCached = true;
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\CacheControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */