package com.squareup.okhttp.internal.framed;

import okio.ByteString;

public final class Header {
  public static final ByteString RESPONSE_STATUS = ByteString.encodeUtf8(":status");
  
  public static final ByteString TARGET_AUTHORITY;
  
  public static final ByteString TARGET_HOST;
  
  public static final ByteString TARGET_METHOD = ByteString.encodeUtf8(":method");
  
  public static final ByteString TARGET_PATH = ByteString.encodeUtf8(":path");
  
  public static final ByteString TARGET_SCHEME = ByteString.encodeUtf8(":scheme");
  
  public static final ByteString VERSION;
  
  final int hpackSize;
  
  public final ByteString name;
  
  public final ByteString value;
  
  static {
    TARGET_AUTHORITY = ByteString.encodeUtf8(":authority");
    TARGET_HOST = ByteString.encodeUtf8(":host");
    VERSION = ByteString.encodeUtf8(":version");
  }
  
  public Header(String paramString1, String paramString2) {
    this(ByteString.encodeUtf8(paramString1), ByteString.encodeUtf8(paramString2));
  }
  
  public Header(ByteString paramByteString, String paramString) {
    this(paramByteString, ByteString.encodeUtf8(paramString));
  }
  
  public Header(ByteString paramByteString1, ByteString paramByteString2) {
    this.name = paramByteString1;
    this.value = paramByteString2;
    this.hpackSize = paramByteString1.size() + 32 + paramByteString2.size();
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof Header;
    boolean bool1 = false;
    if (bool) {
      paramObject = paramObject;
      bool = bool1;
      if (this.name.equals(((Header)paramObject).name)) {
        bool = bool1;
        if (this.value.equals(((Header)paramObject).value))
          bool = true; 
      } 
      return bool;
    } 
    return false;
  }
  
  public int hashCode() {
    return (527 + this.name.hashCode()) * 31 + this.value.hashCode();
  }
  
  public String toString() {
    return String.format("%s: %s", new Object[] { this.name.utf8(), this.value.utf8() });
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\framed\Header.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */