package io.grpc.okhttp.internal;

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
    if ("TLSv1.2".equals(paramString))
      return TLS_1_2; 
    if ("TLSv1.1".equals(paramString))
      return TLS_1_1; 
    if ("TLSv1".equals(paramString))
      return TLS_1_0; 
    if ("SSLv3".equals(paramString))
      return SSL_3_0; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected TLS version: ");
    stringBuilder.append(paramString);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public String javaName() {
    return this.javaName;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\internal\TlsVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */