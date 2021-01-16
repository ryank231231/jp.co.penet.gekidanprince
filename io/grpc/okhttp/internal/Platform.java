package io.grpc.okhttp.internal;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.security.PrivilegedExceptionAction;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okio.Buffer;

public class Platform {
  private static final String[] ANDROID_SECURITY_PROVIDERS;
  
  private static final Platform PLATFORM;
  
  public static final Logger logger = Logger.getLogger(Platform.class.getName());
  
  private final Provider sslProvider;
  
  static {
    ANDROID_SECURITY_PROVIDERS = new String[] { "com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider" };
    PLATFORM = findPlatform();
  }
  
  public Platform(Provider paramProvider) {
    this.sslProvider = paramProvider;
  }
  
  public static byte[] concatLengthPrefixed(List<Protocol> paramList) {
    Buffer buffer = new Buffer();
    int i = paramList.size();
    for (byte b = 0; b < i; b++) {
      Protocol protocol = paramList.get(b);
      if (protocol != Protocol.HTTP_1_0) {
        buffer.writeByte(protocol.toString().length());
        buffer.writeUtf8(protocol.toString());
      } 
    } 
    return buffer.readByteArray();
  }
  
  private static Platform findPlatform() {
    // Byte code:
    //   0: getstatic io/grpc/internal/GrpcUtil.IS_RESTRICTED_APPENGINE : Z
    //   3: ifeq -> 13
    //   6: invokestatic getAppEngineProvider : ()Ljava/security/Provider;
    //   9: astore_0
    //   10: goto -> 17
    //   13: invokestatic getAndroidSecurityProvider : ()Ljava/security/Provider;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull -> 266
    //   21: new io/grpc/okhttp/internal/OptionalMethod
    //   24: dup
    //   25: aconst_null
    //   26: ldc 'setUseSessionTickets'
    //   28: iconst_1
    //   29: anewarray java/lang/Class
    //   32: dup
    //   33: iconst_0
    //   34: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   37: aastore
    //   38: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   41: astore_1
    //   42: new io/grpc/okhttp/internal/OptionalMethod
    //   45: dup
    //   46: aconst_null
    //   47: ldc 'setHostname'
    //   49: iconst_1
    //   50: anewarray java/lang/Class
    //   53: dup
    //   54: iconst_0
    //   55: ldc java/lang/String
    //   57: aastore
    //   58: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   61: astore_2
    //   62: new io/grpc/okhttp/internal/OptionalMethod
    //   65: dup
    //   66: ldc [B
    //   68: ldc 'getAlpnSelectedProtocol'
    //   70: iconst_0
    //   71: anewarray java/lang/Class
    //   74: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   77: astore_3
    //   78: new io/grpc/okhttp/internal/OptionalMethod
    //   81: dup
    //   82: aconst_null
    //   83: ldc 'setAlpnProtocols'
    //   85: iconst_1
    //   86: anewarray java/lang/Class
    //   89: dup
    //   90: iconst_0
    //   91: ldc [B
    //   93: aastore
    //   94: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   97: astore #4
    //   99: ldc 'android.net.TrafficStats'
    //   101: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   104: astore #5
    //   106: aload #5
    //   108: ldc 'tagSocket'
    //   110: iconst_1
    //   111: anewarray java/lang/Class
    //   114: dup
    //   115: iconst_0
    //   116: ldc java/net/Socket
    //   118: aastore
    //   119: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   122: astore #6
    //   124: aload #5
    //   126: ldc 'untagSocket'
    //   128: iconst_1
    //   129: anewarray java/lang/Class
    //   132: dup
    //   133: iconst_0
    //   134: ldc java/net/Socket
    //   136: aastore
    //   137: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   140: astore #7
    //   142: goto -> 164
    //   145: astore #5
    //   147: aconst_null
    //   148: astore #6
    //   150: aconst_null
    //   151: astore #7
    //   153: goto -> 164
    //   156: astore #5
    //   158: aconst_null
    //   159: astore #6
    //   161: aconst_null
    //   162: astore #7
    //   164: getstatic io/grpc/internal/GrpcUtil.IS_RESTRICTED_APPENGINE : Z
    //   167: ifeq -> 178
    //   170: getstatic io/grpc/okhttp/internal/Platform$TlsExtensionType.ALPN_AND_NPN : Lio/grpc/okhttp/internal/Platform$TlsExtensionType;
    //   173: astore #5
    //   175: goto -> 246
    //   178: aload_0
    //   179: invokevirtual getName : ()Ljava/lang/String;
    //   182: ldc 'GmsCore_OpenSSL'
    //   184: invokevirtual equals : (Ljava/lang/Object;)Z
    //   187: ifne -> 241
    //   190: aload_0
    //   191: invokevirtual getName : ()Ljava/lang/String;
    //   194: ldc 'Conscrypt'
    //   196: invokevirtual equals : (Ljava/lang/Object;)Z
    //   199: ifeq -> 205
    //   202: goto -> 241
    //   205: invokestatic isAtLeastAndroid5 : ()Z
    //   208: ifeq -> 219
    //   211: getstatic io/grpc/okhttp/internal/Platform$TlsExtensionType.ALPN_AND_NPN : Lio/grpc/okhttp/internal/Platform$TlsExtensionType;
    //   214: astore #5
    //   216: goto -> 246
    //   219: invokestatic isAtLeastAndroid41 : ()Z
    //   222: ifeq -> 233
    //   225: getstatic io/grpc/okhttp/internal/Platform$TlsExtensionType.NPN : Lio/grpc/okhttp/internal/Platform$TlsExtensionType;
    //   228: astore #5
    //   230: goto -> 246
    //   233: getstatic io/grpc/okhttp/internal/Platform$TlsExtensionType.NONE : Lio/grpc/okhttp/internal/Platform$TlsExtensionType;
    //   236: astore #5
    //   238: goto -> 246
    //   241: getstatic io/grpc/okhttp/internal/Platform$TlsExtensionType.ALPN_AND_NPN : Lio/grpc/okhttp/internal/Platform$TlsExtensionType;
    //   244: astore #5
    //   246: new io/grpc/okhttp/internal/Platform$Android
    //   249: dup
    //   250: aload_1
    //   251: aload_2
    //   252: aload #6
    //   254: aload #7
    //   256: aload_3
    //   257: aload #4
    //   259: aload_0
    //   260: aload #5
    //   262: invokespecial <init> : (Lio/grpc/okhttp/internal/OptionalMethod;Lio/grpc/okhttp/internal/OptionalMethod;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lio/grpc/okhttp/internal/OptionalMethod;Lio/grpc/okhttp/internal/OptionalMethod;Ljava/security/Provider;Lio/grpc/okhttp/internal/Platform$TlsExtensionType;)V
    //   265: areturn
    //   266: invokestatic getDefault : ()Ljavax/net/ssl/SSLContext;
    //   269: invokevirtual getProvider : ()Ljava/security/Provider;
    //   272: astore #5
    //   274: ldc 'TLS'
    //   276: aload #5
    //   278: invokestatic getInstance : (Ljava/lang/String;Ljava/security/Provider;)Ljavax/net/ssl/SSLContext;
    //   281: astore #7
    //   283: aload #7
    //   285: aconst_null
    //   286: aconst_null
    //   287: aconst_null
    //   288: invokevirtual init : ([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   291: aload #7
    //   293: invokevirtual createSSLEngine : ()Ljavax/net/ssl/SSLEngine;
    //   296: astore #7
    //   298: new io/grpc/okhttp/internal/Platform$1
    //   301: astore #6
    //   303: aload #6
    //   305: invokespecial <init> : ()V
    //   308: aload #6
    //   310: invokestatic doPrivileged : (Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
    //   313: checkcast java/lang/reflect/Method
    //   316: aload #7
    //   318: iconst_0
    //   319: anewarray java/lang/Object
    //   322: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   325: pop
    //   326: new io/grpc/okhttp/internal/Platform$2
    //   329: astore #7
    //   331: aload #7
    //   333: invokespecial <init> : ()V
    //   336: aload #7
    //   338: invokestatic doPrivileged : (Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
    //   341: checkcast java/lang/reflect/Method
    //   344: astore #7
    //   346: new io/grpc/okhttp/internal/Platform$3
    //   349: astore #6
    //   351: aload #6
    //   353: invokespecial <init> : ()V
    //   356: new io/grpc/okhttp/internal/Platform$JdkAlpnPlatform
    //   359: dup
    //   360: aload #5
    //   362: aload #7
    //   364: aload #6
    //   366: invokestatic doPrivileged : (Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
    //   369: checkcast java/lang/reflect/Method
    //   372: aconst_null
    //   373: invokespecial <init> : (Ljava/security/Provider;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lio/grpc/okhttp/internal/Platform$1;)V
    //   376: astore #7
    //   378: aload #7
    //   380: areturn
    //   381: astore #7
    //   383: ldc 'org.eclipse.jetty.alpn.ALPN'
    //   385: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   388: astore #7
    //   390: new java/lang/StringBuilder
    //   393: astore #6
    //   395: aload #6
    //   397: invokespecial <init> : ()V
    //   400: aload #6
    //   402: ldc 'org.eclipse.jetty.alpn.ALPN'
    //   404: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload #6
    //   410: ldc_w '$Provider'
    //   413: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload #6
    //   419: invokevirtual toString : ()Ljava/lang/String;
    //   422: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   425: astore #6
    //   427: new java/lang/StringBuilder
    //   430: astore_0
    //   431: aload_0
    //   432: invokespecial <init> : ()V
    //   435: aload_0
    //   436: ldc 'org.eclipse.jetty.alpn.ALPN'
    //   438: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload_0
    //   443: ldc_w '$ClientProvider'
    //   446: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload_0
    //   451: invokevirtual toString : ()Ljava/lang/String;
    //   454: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   457: astore_0
    //   458: new java/lang/StringBuilder
    //   461: astore_1
    //   462: aload_1
    //   463: invokespecial <init> : ()V
    //   466: aload_1
    //   467: ldc 'org.eclipse.jetty.alpn.ALPN'
    //   469: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload_1
    //   474: ldc_w '$ServerProvider'
    //   477: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload_1
    //   482: invokevirtual toString : ()Ljava/lang/String;
    //   485: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   488: astore_1
    //   489: new io/grpc/okhttp/internal/Platform$JdkWithJettyBootPlatform
    //   492: dup
    //   493: aload #7
    //   495: ldc_w 'put'
    //   498: iconst_2
    //   499: anewarray java/lang/Class
    //   502: dup
    //   503: iconst_0
    //   504: ldc_w javax/net/ssl/SSLSocket
    //   507: aastore
    //   508: dup
    //   509: iconst_1
    //   510: aload #6
    //   512: aastore
    //   513: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   516: aload #7
    //   518: ldc_w 'get'
    //   521: iconst_1
    //   522: anewarray java/lang/Class
    //   525: dup
    //   526: iconst_0
    //   527: ldc_w javax/net/ssl/SSLSocket
    //   530: aastore
    //   531: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   534: aload #7
    //   536: ldc_w 'remove'
    //   539: iconst_1
    //   540: anewarray java/lang/Class
    //   543: dup
    //   544: iconst_0
    //   545: ldc_w javax/net/ssl/SSLSocket
    //   548: aastore
    //   549: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   552: aload_0
    //   553: aload_1
    //   554: aload #5
    //   556: invokespecial <init> : (Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;Ljava/security/Provider;)V
    //   559: astore #7
    //   561: aload #7
    //   563: areturn
    //   564: astore #7
    //   566: new io/grpc/okhttp/internal/Platform
    //   569: dup
    //   570: aload #5
    //   572: invokespecial <init> : (Ljava/security/Provider;)V
    //   575: areturn
    //   576: astore #5
    //   578: new java/lang/RuntimeException
    //   581: dup
    //   582: aload #5
    //   584: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   587: athrow
    //   588: astore #5
    //   590: goto -> 161
    //   593: astore #5
    //   595: goto -> 150
    // Exception table:
    //   from	to	target	type
    //   99	124	156	java/lang/ClassNotFoundException
    //   99	124	145	java/lang/NoSuchMethodException
    //   124	142	588	java/lang/ClassNotFoundException
    //   124	142	593	java/lang/NoSuchMethodException
    //   266	274	576	java/security/NoSuchAlgorithmException
    //   274	378	381	java/security/NoSuchAlgorithmException
    //   274	378	381	java/security/KeyManagementException
    //   274	378	381	java/security/PrivilegedActionException
    //   274	378	381	java/lang/IllegalAccessException
    //   274	378	381	java/lang/reflect/InvocationTargetException
    //   383	561	564	java/lang/ClassNotFoundException
    //   383	561	564	java/lang/NoSuchMethodException
  }
  
  public static Platform get() {
    return PLATFORM;
  }
  
  private static Provider getAndroidSecurityProvider() {
    for (Provider provider : Security.getProviders()) {
      for (String str : ANDROID_SECURITY_PROVIDERS) {
        if (str.equals(provider.getClass().getName())) {
          logger.log(Level.FINE, "Found registered provider {0}", str);
          return provider;
        } 
      } 
    } 
    logger.log(Level.WARNING, "Unable to find Conscrypt");
    return null;
  }
  
  private static Provider getAppEngineProvider() {
    try {
      return Class.forName("org.conscrypt.OpenSSLProvider").getConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (Throwable throwable) {
      throw new RuntimeException("Unable to load conscrypt security provider", throwable);
    } 
  }
  
  private static boolean isAtLeastAndroid41() {
    try {
      Platform.class.getClassLoader().loadClass("android.app.ActivityOptions");
      return true;
    } catch (ClassNotFoundException classNotFoundException) {
      logger.log(Level.FINE, "Can't find class", classNotFoundException);
      return false;
    } 
  }
  
  private static boolean isAtLeastAndroid5() {
    try {
      Platform.class.getClassLoader().loadClass("android.net.Network");
      return true;
    } catch (ClassNotFoundException classNotFoundException) {
      logger.log(Level.FINE, "Can't find class", classNotFoundException);
      return false;
    } 
  }
  
  public void afterHandshake(SSLSocket paramSSLSocket) {}
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList) {}
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt) throws IOException {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public String getPrefix() {
    return "OkHttp";
  }
  
  public Provider getProvider() {
    return this.sslProvider;
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket) {
    return null;
  }
  
  public TlsExtensionType getTlsExtensionType() {
    return TlsExtensionType.NONE;
  }
  
  public void logW(String paramString) {
    System.out.println(paramString);
  }
  
  public void tagSocket(Socket paramSocket) throws SocketException {}
  
  public void untagSocket(Socket paramSocket) throws SocketException {}
  
  private static class Android extends Platform {
    private final OptionalMethod<Socket> getAlpnSelectedProtocol;
    
    private final OptionalMethod<Socket> setAlpnProtocols;
    
    private final OptionalMethod<Socket> setHostname;
    
    private final OptionalMethod<Socket> setUseSessionTickets;
    
    private final Platform.TlsExtensionType tlsExtensionType;
    
    private final Method trafficStatsTagSocket;
    
    private final Method trafficStatsUntagSocket;
    
    public Android(OptionalMethod<Socket> param1OptionalMethod1, OptionalMethod<Socket> param1OptionalMethod2, Method param1Method1, Method param1Method2, OptionalMethod<Socket> param1OptionalMethod3, OptionalMethod<Socket> param1OptionalMethod4, Provider param1Provider, Platform.TlsExtensionType param1TlsExtensionType) {
      super(param1Provider);
      this.setUseSessionTickets = param1OptionalMethod1;
      this.setHostname = param1OptionalMethod2;
      this.trafficStatsTagSocket = param1Method1;
      this.trafficStatsUntagSocket = param1Method2;
      this.getAlpnSelectedProtocol = param1OptionalMethod3;
      this.setAlpnProtocols = param1OptionalMethod4;
      this.tlsExtensionType = param1TlsExtensionType;
    }
    
    public void configureTlsExtensions(SSLSocket param1SSLSocket, String param1String, List<Protocol> param1List) {
      if (param1String != null) {
        this.setUseSessionTickets.invokeOptionalWithoutCheckedException(param1SSLSocket, new Object[] { Boolean.valueOf(true) });
        this.setHostname.invokeOptionalWithoutCheckedException(param1SSLSocket, new Object[] { param1String });
      } 
      if (this.setAlpnProtocols.isSupported(param1SSLSocket)) {
        byte[] arrayOfByte = concatLengthPrefixed(param1List);
        this.setAlpnProtocols.invokeWithoutCheckedException(param1SSLSocket, new Object[] { arrayOfByte });
      } 
    }
    
    public void connectSocket(Socket param1Socket, InetSocketAddress param1InetSocketAddress, int param1Int) throws IOException {
      try {
        param1Socket.connect(param1InetSocketAddress, param1Int);
        return;
      } catch (SecurityException securityException) {
        IOException iOException = new IOException("Exception in connect");
        iOException.initCause(securityException);
        throw iOException;
      } 
    }
    
    public String getSelectedProtocol(SSLSocket param1SSLSocket) {
      String str;
      boolean bool = this.getAlpnSelectedProtocol.isSupported(param1SSLSocket);
      SSLSocket sSLSocket = null;
      if (!bool)
        return null; 
      byte[] arrayOfByte = (byte[])this.getAlpnSelectedProtocol.invokeWithoutCheckedException(param1SSLSocket, new Object[0]);
      param1SSLSocket = sSLSocket;
      if (arrayOfByte != null)
        str = new String(arrayOfByte, Util.UTF_8); 
      return str;
    }
    
    public Platform.TlsExtensionType getTlsExtensionType() {
      return this.tlsExtensionType;
    }
    
    public void tagSocket(Socket param1Socket) throws SocketException {
      Method method = this.trafficStatsTagSocket;
      if (method == null)
        return; 
      try {
        method.invoke(null, new Object[] { param1Socket });
        return;
      } catch (IllegalAccessException illegalAccessException) {
        throw new RuntimeException(illegalAccessException);
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException(invocationTargetException.getCause());
      } 
    }
    
    public void untagSocket(Socket param1Socket) throws SocketException {
      Method method = this.trafficStatsUntagSocket;
      if (method == null)
        return; 
      try {
        method.invoke(null, new Object[] { param1Socket });
        return;
      } catch (IllegalAccessException illegalAccessException) {
        throw new RuntimeException(illegalAccessException);
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException(invocationTargetException.getCause());
      } 
    }
  }
  
  private static class JdkAlpnPlatform extends Platform {
    private final Method getApplicationProtocol;
    
    private final Method setApplicationProtocols;
    
    private JdkAlpnPlatform(Provider param1Provider, Method param1Method1, Method param1Method2) {
      super(param1Provider);
      this.setApplicationProtocols = param1Method1;
      this.getApplicationProtocol = param1Method2;
    }
    
    public void configureTlsExtensions(SSLSocket param1SSLSocket, String param1String, List<Protocol> param1List) {
      SSLParameters sSLParameters = param1SSLSocket.getSSLParameters();
      ArrayList<String> arrayList = new ArrayList(param1List.size());
      for (Protocol protocol : param1List) {
        if (protocol == Protocol.HTTP_1_0)
          continue; 
        arrayList.add(protocol.toString());
      } 
      try {
        this.setApplicationProtocols.invoke(sSLParameters, new Object[] { arrayList.toArray(new String[arrayList.size()]) });
        param1SSLSocket.setSSLParameters(sSLParameters);
        return;
      } catch (IllegalAccessException illegalAccessException) {
        throw new RuntimeException(illegalAccessException);
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException(invocationTargetException);
      } 
    }
    
    public String getSelectedProtocol(SSLSocket param1SSLSocket) {
      try {
        return (String)this.getApplicationProtocol.invoke(param1SSLSocket, new Object[0]);
      } catch (IllegalAccessException illegalAccessException) {
        throw new RuntimeException(illegalAccessException);
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException(invocationTargetException);
      } 
    }
    
    public Platform.TlsExtensionType getTlsExtensionType() {
      return Platform.TlsExtensionType.ALPN_AND_NPN;
    }
  }
  
  private static class JdkWithJettyBootPlatform extends Platform {
    private final Class<?> clientProviderClass;
    
    private final Method getMethod;
    
    private final Method putMethod;
    
    private final Method removeMethod;
    
    private final Class<?> serverProviderClass;
    
    public JdkWithJettyBootPlatform(Method param1Method1, Method param1Method2, Method param1Method3, Class<?> param1Class1, Class<?> param1Class2, Provider param1Provider) {
      super(param1Provider);
      this.putMethod = param1Method1;
      this.getMethod = param1Method2;
      this.removeMethod = param1Method3;
      this.clientProviderClass = param1Class1;
      this.serverProviderClass = param1Class2;
    }
    
    public void afterHandshake(SSLSocket param1SSLSocket) {
      try {
        this.removeMethod.invoke(null, new Object[] { param1SSLSocket });
      } catch (IllegalAccessException illegalAccessException) {
        throw new AssertionError();
      } catch (InvocationTargetException invocationTargetException) {}
    }
    
    public void configureTlsExtensions(SSLSocket param1SSLSocket, String param1String, List<Protocol> param1List) {
      ArrayList<String> arrayList = new ArrayList(param1List.size());
      int i = param1List.size();
      for (byte b = 0; b < i; b++) {
        Protocol protocol = param1List.get(b);
        if (protocol != Protocol.HTTP_1_0)
          arrayList.add(protocol.toString()); 
      } 
      try {
        ClassLoader classLoader = Platform.class.getClassLoader();
        Class<?> clazz1 = this.clientProviderClass;
        Class<?> clazz2 = this.serverProviderClass;
        Platform.JettyNegoProvider jettyNegoProvider = new Platform.JettyNegoProvider();
        this(arrayList);
        Object object = Proxy.newProxyInstance(classLoader, new Class[] { clazz1, clazz2 }, jettyNegoProvider);
        this.putMethod.invoke(null, new Object[] { param1SSLSocket, object });
        return;
      } catch (InvocationTargetException invocationTargetException) {
        throw new AssertionError(invocationTargetException);
      } catch (IllegalAccessException illegalAccessException) {
        throw new AssertionError(illegalAccessException);
      } 
    }
    
    public String getSelectedProtocol(SSLSocket param1SSLSocket) {
      try {
        String str;
        Method method = this.getMethod;
        Platform.JettyNegoProvider jettyNegoProvider2 = null;
        Platform.JettyNegoProvider jettyNegoProvider1 = (Platform.JettyNegoProvider)Proxy.getInvocationHandler(method.invoke(null, new Object[] { param1SSLSocket }));
        if (!jettyNegoProvider1.unsupported && jettyNegoProvider1.selected == null) {
          logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
          return null;
        } 
        if (jettyNegoProvider1.unsupported) {
          jettyNegoProvider1 = jettyNegoProvider2;
        } else {
          str = jettyNegoProvider1.selected;
        } 
        return str;
      } catch (InvocationTargetException invocationTargetException) {
        throw new AssertionError();
      } catch (IllegalAccessException illegalAccessException) {
        throw new AssertionError();
      } 
    }
    
    public Platform.TlsExtensionType getTlsExtensionType() {
      return Platform.TlsExtensionType.ALPN_AND_NPN;
    }
  }
  
  private static class JettyNegoProvider implements InvocationHandler {
    private final List<String> protocols;
    
    private String selected;
    
    private boolean unsupported;
    
    public JettyNegoProvider(List<String> param1List) {
      this.protocols = param1List;
    }
    
    public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
      String str = param1Method.getName();
      Class<?> clazz = param1Method.getReturnType();
      param1Object = param1ArrayOfObject;
      if (param1ArrayOfObject == null)
        param1Object = Util.EMPTY_STRING_ARRAY; 
      if (str.equals("supports") && boolean.class == clazz)
        return Boolean.valueOf(true); 
      if (str.equals("unsupported") && void.class == clazz) {
        this.unsupported = true;
        return null;
      } 
      if (str.equals("protocols") && param1Object.length == 0)
        return this.protocols; 
      if ((str.equals("selectProtocol") || str.equals("select")) && String.class == clazz && param1Object.length == 1 && param1Object[0] instanceof List) {
        param1Object = param1Object[0];
        int i = param1Object.size();
        for (byte b = 0; b < i; b++) {
          if (this.protocols.contains(param1Object.get(b))) {
            param1Object = param1Object.get(b);
            this.selected = (String)param1Object;
            return param1Object;
          } 
        } 
        param1Object = this.protocols.get(0);
        this.selected = (String)param1Object;
        return param1Object;
      } 
      if ((str.equals("protocolSelected") || str.equals("selected")) && param1Object.length == 1) {
        this.selected = (String)param1Object[0];
        return null;
      } 
      return param1Method.invoke(this, (Object[])param1Object);
    }
  }
  
  public enum TlsExtensionType {
    ALPN_AND_NPN, NONE, NPN;
    
    static {
      $VALUES = new TlsExtensionType[] { ALPN_AND_NPN, NPN, NONE };
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\internal\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */