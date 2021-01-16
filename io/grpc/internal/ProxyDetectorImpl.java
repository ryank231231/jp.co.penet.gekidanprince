package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

class ProxyDetectorImpl implements ProxyDetector {
  private static final AuthenticationProvider DEFAULT_AUTHENTICATOR;
  
  private static final Supplier<ProxySelector> DEFAULT_PROXY_SELECTOR;
  
  @Deprecated
  private static final String GRPC_PROXY_ENV_VAR = "GRPC_PROXY_EXP";
  
  static final String PROXY_SCHEME = "https";
  
  private static final Logger log = Logger.getLogger(ProxyDetectorImpl.class.getName());
  
  private final AuthenticationProvider authenticationProvider;
  
  private final ProxyParameters override;
  
  private final Supplier<ProxySelector> proxySelector;
  
  static {
    DEFAULT_AUTHENTICATOR = new AuthenticationProvider() {
        public PasswordAuthentication requestPasswordAuthentication(String param1String1, InetAddress param1InetAddress, int param1Int, String param1String2, String param1String3, String param1String4) {
          try {
            URL uRL = new URL();
            this(param1String2, param1String1, param1Int, "");
          } catch (MalformedURLException malformedURLException) {
            ProxyDetectorImpl.log.log(Level.WARNING, String.format("failed to create URL for Authenticator: %s %s", new Object[] { param1String2, param1String1 }));
            malformedURLException = null;
          } 
          return Authenticator.requestPasswordAuthentication(param1String1, param1InetAddress, param1Int, param1String2, param1String3, param1String4, (URL)malformedURLException, Authenticator.RequestorType.PROXY);
        }
      };
    DEFAULT_PROXY_SELECTOR = new Supplier<ProxySelector>() {
        public ProxySelector get() {
          return ProxySelector.getDefault();
        }
      };
  }
  
  public ProxyDetectorImpl() {
    this(DEFAULT_PROXY_SELECTOR, DEFAULT_AUTHENTICATOR, System.getenv("GRPC_PROXY_EXP"));
  }
  
  @VisibleForTesting
  ProxyDetectorImpl(Supplier<ProxySelector> paramSupplier, AuthenticationProvider paramAuthenticationProvider, @Nullable String paramString) {
    this.proxySelector = (Supplier<ProxySelector>)Preconditions.checkNotNull(paramSupplier);
    this.authenticationProvider = (AuthenticationProvider)Preconditions.checkNotNull(paramAuthenticationProvider);
    if (paramString != null) {
      this.override = new ProxyParameters(overrideProxy(paramString), null, null);
    } else {
      this.override = null;
    } 
  }
  
  private ProxyParameters detectProxy(InetSocketAddress paramInetSocketAddress) throws IOException {
    try {
      String str = GrpcUtil.getHost(paramInetSocketAddress);
      try {
        URI uRI = new URI("https", null, str, paramInetSocketAddress.getPort(), null, null, null);
        List<Proxy> list = ((ProxySelector)this.proxySelector.get()).select(uRI);
        if (list.size() > 1)
          log.warning("More than 1 proxy detected, gRPC will select the first one"); 
        Proxy proxy = list.get(0);
        if (proxy.type() == Proxy.Type.DIRECT)
          return null; 
        InetSocketAddress inetSocketAddress2 = (InetSocketAddress)proxy.address();
        PasswordAuthentication passwordAuthentication = this.authenticationProvider.requestPasswordAuthentication(GrpcUtil.getHost(inetSocketAddress2), inetSocketAddress2.getAddress(), inetSocketAddress2.getPort(), "https", "", null);
        InetSocketAddress inetSocketAddress1 = inetSocketAddress2;
        if (inetSocketAddress2.isUnresolved())
          inetSocketAddress1 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress2.getHostName()), inetSocketAddress2.getPort()); 
        return (passwordAuthentication == null) ? new ProxyParameters(inetSocketAddress1, null, null) : new ProxyParameters(inetSocketAddress1, passwordAuthentication.getUserName(), new String(passwordAuthentication.getPassword()));
      } catch (URISyntaxException uRISyntaxException) {
        log.log(Level.WARNING, "Failed to construct URI for proxy lookup, proceeding without proxy", uRISyntaxException);
        return null;
      } 
    } catch (Throwable throwable) {
      log.log(Level.WARNING, "Failed to get host for proxy lookup, proceeding without proxy", throwable);
      return null;
    } 
  }
  
  private static InetSocketAddress overrideProxy(String paramString) {
    if (paramString == null)
      return null; 
    String[] arrayOfString = paramString.split(":", 2);
    int i = 80;
    if (arrayOfString.length > 1)
      i = Integer.parseInt(arrayOfString[1]); 
    log.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
    return new InetSocketAddress(arrayOfString[0], i);
  }
  
  @Nullable
  public ProxyParameters proxyFor(SocketAddress paramSocketAddress) throws IOException {
    ProxyParameters proxyParameters = this.override;
    return (proxyParameters != null) ? proxyParameters : (!(paramSocketAddress instanceof InetSocketAddress) ? null : detectProxy((InetSocketAddress)paramSocketAddress));
  }
  
  static interface AuthenticationProvider {
    PasswordAuthentication requestPasswordAuthentication(String param1String1, InetAddress param1InetAddress, int param1Int, String param1String2, String param1String3, String param1String4);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ProxyDetectorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */