package com.squareup.okhttp;

public enum TlsVersion {
  SSL_3_0,
  TLS_1_0,
  TLS_1_1,
  TLS_1_2("TLSv1.2");
  
  final String javaName;
  
  static {
    TLS_1_1 = new TlsVersion("TLS_1_1", 1, "TLSv1.1");
    TLS_1_0 = new TlsVersion("TLS_1_0", 2, "TLSv1");
    SSL_3_0 = new TlsVersion("SSL_3_0", 3, "SSLv3");
    $VALUES = new TlsVersion[] { TLS_1_2, TLS_1_1, TLS_1_0, SSL_3_0 };
  }
  
  TlsVersion(String paramString1) {
    this.javaName = paramString1;
  }
  
  public static TlsVersion forJavaName(String paramString) {
    byte b;
    StringBuilder stringBuilder;
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case 79923350:
        if (paramString.equals("TLSv1")) {
          b = 2;
          break;
        } 
      case 79201641:
        if (paramString.equals("SSLv3")) {
          b = 3;
          break;
        } 
      case -503070502:
        if (paramString.equals("TLSv1.2")) {
          b = 0;
          break;
        } 
      case -503070503:
        if (paramString.equals("TLSv1.1")) {
          b = 1;
          break;
        } 
    } 
    switch (b) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected TLS version: ");
        stringBuilder.append(paramString);
        throw new IllegalArgumentException(stringBuilder.toString());
      case 3:
        return SSL_3_0;
      case 2:
        return TLS_1_0;
      case 1:
        return TLS_1_1;
      case 0:
        break;
    } 
    return TLS_1_2;
  }
  
  public String javaName() {
    return this.javaName;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\TlsVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */