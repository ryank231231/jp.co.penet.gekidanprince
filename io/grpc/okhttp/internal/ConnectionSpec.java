package io.grpc.okhttp.internal;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpec {
  private static final CipherSuite[] APPROVED_CIPHER_SUITES = new CipherSuite[] { 
      CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_DSS_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, 
      CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA };
  
  public static final ConnectionSpec CLEARTEXT;
  
  public static final ConnectionSpec COMPATIBLE_TLS;
  
  public static final ConnectionSpec MODERN_TLS = (new Builder(true)).cipherSuites(APPROVED_CIPHER_SUITES).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0 }).supportsTlsExtensions(true).build();
  
  private final String[] cipherSuites;
  
  final boolean supportsTlsExtensions;
  
  final boolean tls;
  
  private final String[] tlsVersions;
  
  static {
    COMPATIBLE_TLS = (new Builder(MODERN_TLS)).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_0 }).supportsTlsExtensions(true).build();
    CLEARTEXT = (new Builder(false)).build();
  }
  
  private ConnectionSpec(Builder paramBuilder) {
    this.tls = paramBuilder.tls;
    this.cipherSuites = paramBuilder.cipherSuites;
    this.tlsVersions = paramBuilder.tlsVersions;
    this.supportsTlsExtensions = paramBuilder.supportsTlsExtensions;
  }
  
  private static <T> boolean contains(T[] paramArrayOfT, T paramT) {
    int i = paramArrayOfT.length;
    for (byte b = 0; b < i; b++) {
      if (Util.equal(paramT, paramArrayOfT[b]))
        return true; 
    } 
    return false;
  }
  
  private static boolean nonEmptyIntersection(String[] paramArrayOfString1, String[] paramArrayOfString2) {
    if (paramArrayOfString1 == null || paramArrayOfString2 == null || paramArrayOfString1.length == 0 || paramArrayOfString2.length == 0)
      return false; 
    int i = paramArrayOfString1.length;
    for (byte b = 0; b < i; b++) {
      if (contains(paramArrayOfString2, paramArrayOfString1[b]))
        return true; 
    } 
    return false;
  }
  
  private ConnectionSpec supportedSpec(SSLSocket paramSSLSocket, boolean paramBoolean) {
    String[] arrayOfString2;
    if (this.cipherSuites != null) {
      arrayOfString2 = paramSSLSocket.getEnabledCipherSuites();
      arrayOfString2 = Util.<String>intersect(String.class, this.cipherSuites, arrayOfString2);
    } else {
      arrayOfString2 = null;
    } 
    if (paramBoolean && Arrays.<String>asList(paramSSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")) {
      if (arrayOfString2 == null)
        arrayOfString2 = paramSSLSocket.getEnabledCipherSuites(); 
      String[] arrayOfString = new String[arrayOfString2.length + 1];
      System.arraycopy(arrayOfString2, 0, arrayOfString, 0, arrayOfString2.length);
      arrayOfString[arrayOfString.length - 1] = "TLS_FALLBACK_SCSV";
      arrayOfString2 = arrayOfString;
    } 
    String[] arrayOfString1 = paramSSLSocket.getEnabledProtocols();
    arrayOfString1 = Util.<String>intersect(String.class, this.tlsVersions, arrayOfString1);
    return (new Builder(this)).cipherSuites(arrayOfString2).tlsVersions(arrayOfString1).build();
  }
  
  public void apply(SSLSocket paramSSLSocket, boolean paramBoolean) {
    ConnectionSpec connectionSpec = supportedSpec(paramSSLSocket, paramBoolean);
    paramSSLSocket.setEnabledProtocols(connectionSpec.tlsVersions);
    String[] arrayOfString = connectionSpec.cipherSuites;
    if (arrayOfString != null)
      paramSSLSocket.setEnabledCipherSuites(arrayOfString); 
  }
  
  public List<CipherSuite> cipherSuites() {
    String[] arrayOfString = this.cipherSuites;
    if (arrayOfString == null)
      return null; 
    CipherSuite[] arrayOfCipherSuite = new CipherSuite[arrayOfString.length];
    byte b = 0;
    while (true) {
      arrayOfString = this.cipherSuites;
      if (b < arrayOfString.length) {
        arrayOfCipherSuite[b] = CipherSuite.forJavaName(arrayOfString[b]);
        b++;
        continue;
      } 
      return Util.immutableList(arrayOfCipherSuite);
    } 
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof ConnectionSpec))
      return false; 
    if (paramObject == this)
      return true; 
    paramObject = paramObject;
    boolean bool = this.tls;
    if (bool != ((ConnectionSpec)paramObject).tls)
      return false; 
    if (bool) {
      if (!Arrays.equals((Object[])this.cipherSuites, (Object[])((ConnectionSpec)paramObject).cipherSuites))
        return false; 
      if (!Arrays.equals((Object[])this.tlsVersions, (Object[])((ConnectionSpec)paramObject).tlsVersions))
        return false; 
      if (this.supportsTlsExtensions != ((ConnectionSpec)paramObject).supportsTlsExtensions)
        return false; 
    } 
    return true;
  }
  
  public int hashCode() {
    byte b;
    if (this.tls) {
      b = ((527 + Arrays.hashCode((Object[])this.cipherSuites)) * 31 + Arrays.hashCode((Object[])this.tlsVersions)) * 31 + (this.supportsTlsExtensions ^ true);
    } else {
      b = 17;
    } 
    return b;
  }
  
  public boolean isCompatible(SSLSocket paramSSLSocket) {
    boolean bool1 = this.tls;
    boolean bool2 = false;
    if (!bool1)
      return false; 
    String[] arrayOfString = paramSSLSocket.getEnabledProtocols();
    if (!nonEmptyIntersection(this.tlsVersions, arrayOfString))
      return false; 
    if (this.cipherSuites == null) {
      if ((paramSSLSocket.getEnabledCipherSuites()).length > 0)
        bool2 = true; 
    } else {
      String[] arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
      bool2 = nonEmptyIntersection(this.cipherSuites, arrayOfString1);
    } 
    return bool2;
  }
  
  public boolean isTls() {
    return this.tls;
  }
  
  public boolean supportsTlsExtensions() {
    return this.supportsTlsExtensions;
  }
  
  public List<TlsVersion> tlsVersions() {
    TlsVersion[] arrayOfTlsVersion = new TlsVersion[this.tlsVersions.length];
    byte b = 0;
    while (true) {
      String[] arrayOfString = this.tlsVersions;
      if (b < arrayOfString.length) {
        arrayOfTlsVersion[b] = TlsVersion.forJavaName(arrayOfString[b]);
        b++;
        continue;
      } 
      return Util.immutableList(arrayOfTlsVersion);
    } 
  }
  
  public String toString() {
    if (this.tls) {
      String str;
      List<CipherSuite> list = cipherSuites();
      if (list == null) {
        str = "[use default]";
      } else {
        str = str.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ConnectionSpec(cipherSuites=");
      stringBuilder.append(str);
      stringBuilder.append(", tlsVersions=");
      stringBuilder.append(tlsVersions());
      stringBuilder.append(", supportsTlsExtensions=");
      stringBuilder.append(this.supportsTlsExtensions);
      stringBuilder.append(")");
      return stringBuilder.toString();
    } 
    return "ConnectionSpec()";
  }
  
  public static final class Builder {
    private String[] cipherSuites;
    
    private boolean supportsTlsExtensions;
    
    private boolean tls;
    
    private String[] tlsVersions;
    
    public Builder(ConnectionSpec param1ConnectionSpec) {
      this.tls = param1ConnectionSpec.tls;
      this.cipherSuites = param1ConnectionSpec.cipherSuites;
      this.tlsVersions = param1ConnectionSpec.tlsVersions;
      this.supportsTlsExtensions = param1ConnectionSpec.supportsTlsExtensions;
    }
    
    public Builder(boolean param1Boolean) {
      this.tls = param1Boolean;
    }
    
    public ConnectionSpec build() {
      return new ConnectionSpec(this);
    }
    
    public Builder cipherSuites(CipherSuite... param1VarArgs) {
      if (this.tls) {
        String[] arrayOfString = new String[param1VarArgs.length];
        for (byte b = 0; b < param1VarArgs.length; b++)
          arrayOfString[b] = (param1VarArgs[b]).javaName; 
        this.cipherSuites = arrayOfString;
        return this;
      } 
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    
    public Builder cipherSuites(String... param1VarArgs) {
      if (this.tls) {
        if (param1VarArgs == null) {
          this.cipherSuites = null;
        } else {
          this.cipherSuites = (String[])param1VarArgs.clone();
        } 
        return this;
      } 
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    
    public Builder supportsTlsExtensions(boolean param1Boolean) {
      if (this.tls) {
        this.supportsTlsExtensions = param1Boolean;
        return this;
      } 
      throw new IllegalStateException("no TLS extensions for cleartext connections");
    }
    
    public Builder tlsVersions(TlsVersion... param1VarArgs) {
      if (this.tls) {
        if (param1VarArgs.length != 0) {
          String[] arrayOfString = new String[param1VarArgs.length];
          for (byte b = 0; b < param1VarArgs.length; b++)
            arrayOfString[b] = (param1VarArgs[b]).javaName; 
          this.tlsVersions = arrayOfString;
          return this;
        } 
        throw new IllegalArgumentException("At least one TlsVersion is required");
      } 
      throw new IllegalStateException("no TLS versions for cleartext connections");
    }
    
    public Builder tlsVersions(String... param1VarArgs) {
      if (this.tls) {
        if (param1VarArgs == null) {
          this.tlsVersions = null;
        } else {
          this.tlsVersions = (String[])param1VarArgs.clone();
        } 
        return this;
      } 
      throw new IllegalStateException("no TLS versions for cleartext connections");
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\internal\ConnectionSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */