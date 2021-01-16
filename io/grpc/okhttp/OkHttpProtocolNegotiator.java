package io.grpc.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.okhttp.internal.OptionalMethod;
import io.grpc.okhttp.internal.Platform;
import io.grpc.okhttp.internal.Protocol;
import io.grpc.okhttp.internal.Util;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

class OkHttpProtocolNegotiator {
  private static final Platform DEFAULT_PLATFORM;
  
  private static OkHttpProtocolNegotiator NEGOTIATOR;
  
  private static final Logger logger = Logger.getLogger(OkHttpProtocolNegotiator.class.getName());
  
  protected final Platform platform;
  
  static {
    DEFAULT_PLATFORM = Platform.get();
    NEGOTIATOR = createNegotiator(OkHttpProtocolNegotiator.class.getClassLoader());
  }
  
  @VisibleForTesting
  OkHttpProtocolNegotiator(Platform paramPlatform) {
    this.platform = (Platform)Preconditions.checkNotNull(paramPlatform, "platform");
  }
  
  @VisibleForTesting
  static OkHttpProtocolNegotiator createNegotiator(ClassLoader paramClassLoader) {
    try {
      paramClassLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
    } catch (ClassNotFoundException classNotFoundException) {
      logger.log(Level.FINE, "Unable to find Conscrypt. Skipping", classNotFoundException);
      try {
        paramClassLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
        boolean bool1 = true;
      } catch (ClassNotFoundException classNotFoundException1) {
        logger.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", classNotFoundException1);
        boolean bool1 = false;
      } 
    } 
    boolean bool = true;
  }
  
  public static OkHttpProtocolNegotiator get() {
    return NEGOTIATOR;
  }
  
  protected void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList) {
    this.platform.configureTlsExtensions(paramSSLSocket, paramString, paramList);
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket) {
    return this.platform.getSelectedProtocol(paramSSLSocket);
  }
  
  public String negotiate(SSLSocket paramSSLSocket, String paramString, @Nullable List<Protocol> paramList) throws IOException {
    if (paramList != null)
      configureTlsExtensions(paramSSLSocket, paramString, paramList); 
    try {
      paramSSLSocket.startHandshake();
      paramString = getSelectedProtocol(paramSSLSocket);
      if (paramString != null)
        return paramString; 
      RuntimeException runtimeException = new RuntimeException();
      this("protocol negotiation failed");
      throw runtimeException;
    } finally {
      this.platform.afterHandshake(paramSSLSocket);
    } 
  }
  
  @VisibleForTesting
  static final class AndroidNegotiator extends OkHttpProtocolNegotiator {
    private static final OptionalMethod<Socket> GET_ALPN_SELECTED_PROTOCOL;
    
    private static final OptionalMethod<Socket> GET_NPN_SELECTED_PROTOCOL;
    
    private static final OptionalMethod<Socket> SET_ALPN_PROTOCOLS;
    
    private static final OptionalMethod<Socket> SET_HOSTNAME = new OptionalMethod(null, "setHostname", new Class[] { String.class });
    
    private static final OptionalMethod<Socket> SET_NPN_PROTOCOLS;
    
    private static final OptionalMethod<Socket> SET_USE_SESSION_TICKETS = new OptionalMethod(null, "setUseSessionTickets", new Class[] { boolean.class });
    
    static {
      GET_ALPN_SELECTED_PROTOCOL = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
      SET_ALPN_PROTOCOLS = new OptionalMethod(null, "setAlpnProtocols", new Class[] { byte[].class });
      GET_NPN_SELECTED_PROTOCOL = new OptionalMethod(byte[].class, "getNpnSelectedProtocol", new Class[0]);
      SET_NPN_PROTOCOLS = new OptionalMethod(null, "setNpnProtocols", new Class[] { byte[].class });
    }
    
    AndroidNegotiator(Platform param1Platform) {
      super(param1Platform);
    }
    
    protected void configureTlsExtensions(SSLSocket param1SSLSocket, String param1String, List<Protocol> param1List) {
      if (param1String != null) {
        SET_USE_SESSION_TICKETS.invokeOptionalWithoutCheckedException(param1SSLSocket, new Object[] { Boolean.valueOf(true) });
        SET_HOSTNAME.invokeOptionalWithoutCheckedException(param1SSLSocket, new Object[] { param1String });
      } 
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Platform.concatLengthPrefixed(param1List);
      if (this.platform.getTlsExtensionType() == Platform.TlsExtensionType.ALPN_AND_NPN)
        SET_ALPN_PROTOCOLS.invokeWithoutCheckedException(param1SSLSocket, arrayOfObject); 
      if (this.platform.getTlsExtensionType() != Platform.TlsExtensionType.NONE) {
        SET_NPN_PROTOCOLS.invokeWithoutCheckedException(param1SSLSocket, arrayOfObject);
        return;
      } 
      throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
    }
    
    public String getSelectedProtocol(SSLSocket param1SSLSocket) {
      if (this.platform.getTlsExtensionType() == Platform.TlsExtensionType.ALPN_AND_NPN)
        try {
          byte[] arrayOfByte = (byte[])GET_ALPN_SELECTED_PROTOCOL.invokeWithoutCheckedException(param1SSLSocket, new Object[0]);
          if (arrayOfByte != null)
            return new String(arrayOfByte, Util.UTF_8); 
        } catch (Exception exception) {} 
      if (this.platform.getTlsExtensionType() != Platform.TlsExtensionType.NONE)
        try {
          byte[] arrayOfByte = (byte[])GET_NPN_SELECTED_PROTOCOL.invokeWithoutCheckedException(param1SSLSocket, new Object[0]);
          if (arrayOfByte != null)
            return new String(arrayOfByte, Util.UTF_8); 
        } catch (Exception exception) {} 
      return null;
    }
    
    public String negotiate(SSLSocket param1SSLSocket, String param1String, List<Protocol> param1List) throws IOException {
      String str1 = getSelectedProtocol(param1SSLSocket);
      String str2 = str1;
      if (str1 == null)
        str2 = super.negotiate(param1SSLSocket, param1String, param1List); 
      return str2;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\OkHttpProtocolNegotiator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */