package io.grpc.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.OkHostnameVerifier;
import io.grpc.okhttp.internal.Protocol;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

final class OkHttpTlsUpgrader {
  @VisibleForTesting
  static final List<Protocol> TLS_PROTOCOLS = Collections.unmodifiableList(Arrays.asList(new Protocol[] { Protocol.GRPC_EXP, Protocol.HTTP_2 }));
  
  @VisibleForTesting
  static String canonicalizeHost(String paramString) {
    return (paramString.startsWith("[") && paramString.endsWith("]")) ? paramString.substring(1, paramString.length() - 1) : paramString;
  }
  
  public static SSLSocket upgrade(SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, Socket paramSocket, String paramString, int paramInt, ConnectionSpec paramConnectionSpec) throws IOException {
    OkHostnameVerifier okHostnameVerifier;
    Preconditions.checkNotNull(paramSSLSocketFactory, "sslSocketFactory");
    Preconditions.checkNotNull(paramSocket, "socket");
    Preconditions.checkNotNull(paramConnectionSpec, "spec");
    paramSocket = paramSSLSocketFactory.createSocket(paramSocket, paramString, paramInt, true);
    paramConnectionSpec.apply((SSLSocket)paramSocket, false);
    OkHttpProtocolNegotiator okHttpProtocolNegotiator = OkHttpProtocolNegotiator.get();
    if (paramConnectionSpec.supportsTlsExtensions()) {
      List<Protocol> list = TLS_PROTOCOLS;
    } else {
      paramSSLSocketFactory = null;
    } 
    String str = okHttpProtocolNegotiator.negotiate((SSLSocket)paramSocket, paramString, (List<Protocol>)paramSSLSocketFactory);
    boolean bool = TLS_PROTOCOLS.contains(Protocol.get(str));
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("Only ");
    stringBuilder2.append(TLS_PROTOCOLS);
    stringBuilder2.append(" are supported, but negotiated protocol is %s");
    Preconditions.checkState(bool, stringBuilder2.toString(), str);
    HostnameVerifier hostnameVerifier = paramHostnameVerifier;
    if (paramHostnameVerifier == null)
      okHostnameVerifier = OkHostnameVerifier.INSTANCE; 
    if (okHostnameVerifier.verify(canonicalizeHost(paramString), paramSocket.getSession()))
      return (SSLSocket)paramSocket; 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Cannot verify hostname: ");
    stringBuilder1.append(paramString);
    throw new SSLPeerUnverifiedException(stringBuilder1.toString());
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\OkHttpTlsUpgrader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */