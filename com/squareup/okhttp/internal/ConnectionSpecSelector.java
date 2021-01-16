package com.squareup.okhttp.internal;

import com.squareup.okhttp.ConnectionSpec;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpecSelector {
  private final List<ConnectionSpec> connectionSpecs;
  
  private boolean isFallback;
  
  private boolean isFallbackPossible;
  
  private int nextModeIndex = 0;
  
  public ConnectionSpecSelector(List<ConnectionSpec> paramList) {
    this.connectionSpecs = paramList;
  }
  
  private boolean isFallbackPossible(SSLSocket paramSSLSocket) {
    for (int i = this.nextModeIndex; i < this.connectionSpecs.size(); i++) {
      if (((ConnectionSpec)this.connectionSpecs.get(i)).isCompatible(paramSSLSocket))
        return true; 
    } 
    return false;
  }
  
  public ConnectionSpec configureSecureSocket(SSLSocket paramSSLSocket) throws IOException {
    ConnectionSpec connectionSpec;
    int i = this.nextModeIndex;
    int j = this.connectionSpecs.size();
    while (true) {
      if (i < j) {
        ConnectionSpec connectionSpec1 = this.connectionSpecs.get(i);
        if (connectionSpec1.isCompatible(paramSSLSocket)) {
          this.nextModeIndex = i + 1;
          break;
        } 
        i++;
        continue;
      } 
      connectionSpec = null;
      break;
    } 
    if (connectionSpec != null) {
      this.isFallbackPossible = isFallbackPossible(paramSSLSocket);
      Internal.instance.apply(connectionSpec, paramSSLSocket, this.isFallback);
      return connectionSpec;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unable to find acceptable protocols. isFallback=");
    stringBuilder.append(this.isFallback);
    stringBuilder.append(", modes=");
    stringBuilder.append(this.connectionSpecs);
    stringBuilder.append(", supported protocols=");
    stringBuilder.append(Arrays.toString((Object[])paramSSLSocket.getEnabledProtocols()));
    throw new UnknownServiceException(stringBuilder.toString());
  }
  
  public boolean connectionFailed(IOException paramIOException) {
    boolean bool1 = true;
    this.isFallback = true;
    if (!this.isFallbackPossible)
      return false; 
    if (paramIOException instanceof java.net.ProtocolException)
      return false; 
    if (paramIOException instanceof java.io.InterruptedIOException)
      return false; 
    boolean bool = paramIOException instanceof javax.net.ssl.SSLHandshakeException;
    if (bool && paramIOException.getCause() instanceof java.security.cert.CertificateException)
      return false; 
    if (paramIOException instanceof javax.net.ssl.SSLPeerUnverifiedException)
      return false; 
    boolean bool2 = bool1;
    if (!bool)
      if (paramIOException instanceof javax.net.ssl.SSLProtocolException) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }  
    return bool2;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\ConnectionSpecSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */