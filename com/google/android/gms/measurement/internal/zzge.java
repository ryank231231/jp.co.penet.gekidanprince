package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

final class zzge extends SSLSocketFactory {
  private final SSLSocketFactory zztf;
  
  zzge() {
    this(HttpsURLConnection.getDefaultSSLSocketFactory());
  }
  
  private zzge(SSLSocketFactory paramSSLSocketFactory) {
    this.zztf = paramSSLSocketFactory;
  }
  
  private final SSLSocket zza(SSLSocket paramSSLSocket) {
    return new zzgf(this, paramSSLSocket);
  }
  
  public final Socket createSocket() throws IOException {
    return zza((SSLSocket)this.zztf.createSocket());
  }
  
  public final Socket createSocket(String paramString, int paramInt) throws IOException {
    return zza((SSLSocket)this.zztf.createSocket(paramString, paramInt));
  }
  
  public final Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) throws IOException {
    return zza((SSLSocket)this.zztf.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
  }
  
  public final Socket createSocket(InetAddress paramInetAddress, int paramInt) throws IOException {
    return zza((SSLSocket)this.zztf.createSocket(paramInetAddress, paramInt));
  }
  
  public final Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) throws IOException {
    return zza((SSLSocket)this.zztf.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException {
    return zza((SSLSocket)this.zztf.createSocket(paramSocket, paramString, paramInt, paramBoolean));
  }
  
  public final String[] getDefaultCipherSuites() {
    return this.zztf.getDefaultCipherSuites();
  }
  
  public final String[] getSupportedCipherSuites() {
    return this.zztf.getSupportedCipherSuites();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */