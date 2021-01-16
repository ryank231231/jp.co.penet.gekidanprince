package com.squareup.okhttp.internal;

import android.util.Log;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.tls.AndroidTrustRootIndex;
import com.squareup.okhttp.internal.tls.RealTrustRootIndex;
import com.squareup.okhttp.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;

public class Platform {
  private static final Platform PLATFORM = findPlatform();
  
  static byte[] concatLengthPrefixed(List<Protocol> paramList) {
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
    //   0: ldc 'com.android.org.conscrypt.SSLParametersImpl'
    //   2: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_0
    //   6: goto -> 16
    //   9: astore_1
    //   10: ldc 'org.apache.harmony.xnet.provider.jsse.SSLParametersImpl'
    //   12: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   15: astore_0
    //   16: new com/squareup/okhttp/internal/OptionalMethod
    //   19: astore_2
    //   20: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   23: astore_1
    //   24: aconst_null
    //   25: astore_3
    //   26: aload_2
    //   27: aconst_null
    //   28: ldc 'setUseSessionTickets'
    //   30: iconst_1
    //   31: anewarray java/lang/Class
    //   34: dup
    //   35: iconst_0
    //   36: aload_1
    //   37: aastore
    //   38: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   41: new com/squareup/okhttp/internal/OptionalMethod
    //   44: astore #4
    //   46: aload #4
    //   48: aconst_null
    //   49: ldc 'setHostname'
    //   51: iconst_1
    //   52: anewarray java/lang/Class
    //   55: dup
    //   56: iconst_0
    //   57: ldc java/lang/String
    //   59: aastore
    //   60: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   63: ldc 'android.net.TrafficStats'
    //   65: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   68: astore_1
    //   69: aload_1
    //   70: ldc 'tagSocket'
    //   72: iconst_1
    //   73: anewarray java/lang/Class
    //   76: dup
    //   77: iconst_0
    //   78: ldc java/net/Socket
    //   80: aastore
    //   81: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   84: astore #5
    //   86: aload_1
    //   87: ldc 'untagSocket'
    //   89: iconst_1
    //   90: anewarray java/lang/Class
    //   93: dup
    //   94: iconst_0
    //   95: ldc java/net/Socket
    //   97: aastore
    //   98: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   101: astore #6
    //   103: ldc 'android.net.Network'
    //   105: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   108: pop
    //   109: new com/squareup/okhttp/internal/OptionalMethod
    //   112: astore_1
    //   113: aload_1
    //   114: ldc [B
    //   116: ldc 'getAlpnSelectedProtocol'
    //   118: iconst_0
    //   119: anewarray java/lang/Class
    //   122: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   125: new com/squareup/okhttp/internal/OptionalMethod
    //   128: astore #7
    //   130: aload #7
    //   132: aconst_null
    //   133: ldc 'setAlpnProtocols'
    //   135: iconst_1
    //   136: anewarray java/lang/Class
    //   139: dup
    //   140: iconst_0
    //   141: ldc [B
    //   143: aastore
    //   144: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   147: aload #7
    //   149: astore_3
    //   150: goto -> 165
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_1
    //   156: aload #6
    //   158: astore_3
    //   159: goto -> 185
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_1
    //   165: goto -> 194
    //   168: astore_1
    //   169: aconst_null
    //   170: astore_3
    //   171: aload_3
    //   172: astore_1
    //   173: goto -> 185
    //   176: astore_1
    //   177: aconst_null
    //   178: astore_3
    //   179: aload_3
    //   180: astore #5
    //   182: aload #5
    //   184: astore_1
    //   185: aconst_null
    //   186: astore #7
    //   188: aload_3
    //   189: astore #6
    //   191: aload #7
    //   193: astore_3
    //   194: new com/squareup/okhttp/internal/Platform$Android
    //   197: dup
    //   198: aload_0
    //   199: aload_2
    //   200: aload #4
    //   202: aload #5
    //   204: aload #6
    //   206: aload_1
    //   207: aload_3
    //   208: invokespecial <init> : (Ljava/lang/Class;Lcom/squareup/okhttp/internal/OptionalMethod;Lcom/squareup/okhttp/internal/OptionalMethod;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/squareup/okhttp/internal/OptionalMethod;Lcom/squareup/okhttp/internal/OptionalMethod;)V
    //   211: astore_1
    //   212: aload_1
    //   213: areturn
    //   214: astore_1
    //   215: ldc 'sun.security.ssl.SSLContextImpl'
    //   217: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   220: astore_1
    //   221: ldc 'org.eclipse.jetty.alpn.ALPN'
    //   223: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   226: astore_3
    //   227: new java/lang/StringBuilder
    //   230: astore #5
    //   232: aload #5
    //   234: invokespecial <init> : ()V
    //   237: aload #5
    //   239: ldc 'org.eclipse.jetty.alpn.ALPN'
    //   241: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload #5
    //   247: ldc '$Provider'
    //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload #5
    //   255: invokevirtual toString : ()Ljava/lang/String;
    //   258: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   261: astore #5
    //   263: new java/lang/StringBuilder
    //   266: astore_0
    //   267: aload_0
    //   268: invokespecial <init> : ()V
    //   271: aload_0
    //   272: ldc 'org.eclipse.jetty.alpn.ALPN'
    //   274: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_0
    //   279: ldc '$ClientProvider'
    //   281: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_0
    //   286: invokevirtual toString : ()Ljava/lang/String;
    //   289: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   292: astore_0
    //   293: new java/lang/StringBuilder
    //   296: astore #6
    //   298: aload #6
    //   300: invokespecial <init> : ()V
    //   303: aload #6
    //   305: ldc 'org.eclipse.jetty.alpn.ALPN'
    //   307: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload #6
    //   313: ldc '$ServerProvider'
    //   315: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload #6
    //   321: invokevirtual toString : ()Ljava/lang/String;
    //   324: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   327: astore #6
    //   329: new com/squareup/okhttp/internal/Platform$JdkWithJettyBootPlatform
    //   332: dup
    //   333: aload_1
    //   334: aload_3
    //   335: ldc 'put'
    //   337: iconst_2
    //   338: anewarray java/lang/Class
    //   341: dup
    //   342: iconst_0
    //   343: ldc javax/net/ssl/SSLSocket
    //   345: aastore
    //   346: dup
    //   347: iconst_1
    //   348: aload #5
    //   350: aastore
    //   351: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   354: aload_3
    //   355: ldc 'get'
    //   357: iconst_1
    //   358: anewarray java/lang/Class
    //   361: dup
    //   362: iconst_0
    //   363: ldc javax/net/ssl/SSLSocket
    //   365: aastore
    //   366: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   369: aload_3
    //   370: ldc 'remove'
    //   372: iconst_1
    //   373: anewarray java/lang/Class
    //   376: dup
    //   377: iconst_0
    //   378: ldc javax/net/ssl/SSLSocket
    //   380: aastore
    //   381: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   384: aload_0
    //   385: aload #6
    //   387: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    //   390: astore_3
    //   391: aload_3
    //   392: areturn
    //   393: astore_3
    //   394: new com/squareup/okhttp/internal/Platform$JdkPlatform
    //   397: dup
    //   398: aload_1
    //   399: invokespecial <init> : (Ljava/lang/Class;)V
    //   402: astore_1
    //   403: aload_1
    //   404: areturn
    //   405: astore_1
    //   406: new com/squareup/okhttp/internal/Platform
    //   409: dup
    //   410: invokespecial <init> : ()V
    //   413: areturn
    //   414: astore #7
    //   416: goto -> 165
    //   419: astore_3
    //   420: aload #6
    //   422: astore_3
    //   423: goto -> 185
    // Exception table:
    //   from	to	target	type
    //   0	6	9	java/lang/ClassNotFoundException
    //   10	16	214	java/lang/ClassNotFoundException
    //   16	24	214	java/lang/ClassNotFoundException
    //   26	63	214	java/lang/ClassNotFoundException
    //   63	86	176	java/lang/ClassNotFoundException
    //   63	86	176	java/lang/NoSuchMethodException
    //   86	103	168	java/lang/ClassNotFoundException
    //   86	103	168	java/lang/NoSuchMethodException
    //   103	125	162	java/lang/ClassNotFoundException
    //   103	125	153	java/lang/NoSuchMethodException
    //   125	147	414	java/lang/ClassNotFoundException
    //   125	147	419	java/lang/NoSuchMethodException
    //   194	212	214	java/lang/ClassNotFoundException
    //   215	221	405	java/lang/ClassNotFoundException
    //   221	391	393	java/lang/ClassNotFoundException
    //   221	391	393	java/lang/NoSuchMethodException
    //   394	403	405	java/lang/ClassNotFoundException
  }
  
  public static Platform get() {
    return PLATFORM;
  }
  
  static <T> T readFieldOrNull(Object paramObject, Class<T> paramClass, String paramString) {
    Class<?> clazz = paramObject.getClass();
    while (clazz != Object.class) {
      try {
        Field field = clazz.getDeclaredField(paramString);
        field.setAccessible(true);
        null = field.get(paramObject);
        return (null == null || !paramClass.isInstance(null)) ? null : paramClass.cast(null);
      } catch (NoSuchFieldException noSuchFieldException) {
        clazz = clazz.getSuperclass();
      } catch (IllegalAccessException illegalAccessException) {
        throw new AssertionError();
      } 
    } 
    if (!paramString.equals("delegate")) {
      illegalAccessException = readFieldOrNull(illegalAccessException, Object.class, "delegate");
      if (illegalAccessException != null)
        return readFieldOrNull(illegalAccessException, paramClass, paramString); 
    } 
    return null;
  }
  
  public void afterHandshake(SSLSocket paramSSLSocket) {}
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList) {}
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt) throws IOException {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public String getPrefix() {
    return "OkHttp";
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket) {
    return null;
  }
  
  public void log(String paramString) {
    System.out.println(paramString);
  }
  
  public void logW(String paramString) {
    System.out.println(paramString);
  }
  
  public void tagSocket(Socket paramSocket) throws SocketException {}
  
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory) {
    return null;
  }
  
  public TrustRootIndex trustRootIndex(X509TrustManager paramX509TrustManager) {
    return (TrustRootIndex)new RealTrustRootIndex(paramX509TrustManager.getAcceptedIssuers());
  }
  
  public void untagSocket(Socket paramSocket) throws SocketException {}
  
  private static class Android extends Platform {
    private static final int MAX_LOG_LENGTH = 4000;
    
    private final OptionalMethod<Socket> getAlpnSelectedProtocol;
    
    private final OptionalMethod<Socket> setAlpnProtocols;
    
    private final OptionalMethod<Socket> setHostname;
    
    private final OptionalMethod<Socket> setUseSessionTickets;
    
    private final Class<?> sslParametersClass;
    
    private final Method trafficStatsTagSocket;
    
    private final Method trafficStatsUntagSocket;
    
    public Android(Class<?> param1Class, OptionalMethod<Socket> param1OptionalMethod1, OptionalMethod<Socket> param1OptionalMethod2, Method param1Method1, Method param1Method2, OptionalMethod<Socket> param1OptionalMethod3, OptionalMethod<Socket> param1OptionalMethod4) {
      this.sslParametersClass = param1Class;
      this.setUseSessionTickets = param1OptionalMethod1;
      this.setHostname = param1OptionalMethod2;
      this.trafficStatsTagSocket = param1Method1;
      this.trafficStatsUntagSocket = param1Method2;
      this.getAlpnSelectedProtocol = param1OptionalMethod3;
      this.setAlpnProtocols = param1OptionalMethod4;
    }
    
    public void configureTlsExtensions(SSLSocket param1SSLSocket, String param1String, List<Protocol> param1List) {
      if (param1String != null) {
        this.setUseSessionTickets.invokeOptionalWithoutCheckedException(param1SSLSocket, new Object[] { Boolean.valueOf(true) });
        this.setHostname.invokeOptionalWithoutCheckedException(param1SSLSocket, new Object[] { param1String });
      } 
      OptionalMethod<Socket> optionalMethod = this.setAlpnProtocols;
      if (optionalMethod != null && optionalMethod.isSupported(param1SSLSocket)) {
        byte[] arrayOfByte = concatLengthPrefixed(param1List);
        this.setAlpnProtocols.invokeWithoutCheckedException(param1SSLSocket, new Object[] { arrayOfByte });
      } 
    }
    
    public void connectSocket(Socket param1Socket, InetSocketAddress param1InetSocketAddress, int param1Int) throws IOException {
      try {
        param1Socket.connect(param1InetSocketAddress, param1Int);
        return;
      } catch (AssertionError assertionError) {
        if (Util.isAndroidGetsocknameError(assertionError))
          throw new IOException(assertionError); 
        throw assertionError;
      } catch (SecurityException securityException) {
        IOException iOException = new IOException("Exception in connect");
        iOException.initCause(securityException);
        throw iOException;
      } 
    }
    
    public String getSelectedProtocol(SSLSocket param1SSLSocket) {
      String str;
      OptionalMethod<Socket> optionalMethod = this.getAlpnSelectedProtocol;
      SSLSocket sSLSocket = null;
      if (optionalMethod == null)
        return null; 
      if (!optionalMethod.isSupported(param1SSLSocket))
        return null; 
      byte[] arrayOfByte = (byte[])this.getAlpnSelectedProtocol.invokeWithoutCheckedException(param1SSLSocket, new Object[0]);
      param1SSLSocket = sSLSocket;
      if (arrayOfByte != null)
        str = new String(arrayOfByte, Util.UTF_8); 
      return str;
    }
    
    public void log(String param1String) {
      int i = param1String.length();
      int j = 0;
      label16: while (j < i) {
        int k = param1String.indexOf('\n', j);
        if (k == -1)
          k = i; 
        while (true) {
          int m = Math.min(k, j + 4000);
          Log.d("OkHttp", param1String.substring(j, m));
          if (m >= k) {
            j = m + 1;
            continue label16;
          } 
          j = m;
        } 
      } 
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
    
    public X509TrustManager trustManager(SSLSocketFactory param1SSLSocketFactory) {
      Object object1 = readFieldOrNull(param1SSLSocketFactory, (Class)this.sslParametersClass, "sslParameters");
      Object object2 = object1;
      if (object1 == null)
        try {
          object2 = readFieldOrNull(param1SSLSocketFactory, (Class)Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, param1SSLSocketFactory.getClass().getClassLoader()), "sslParameters");
        } catch (ClassNotFoundException classNotFoundException) {
          return null;
        }  
      X509TrustManager x509TrustManager = readFieldOrNull(object2, X509TrustManager.class, "x509TrustManager");
      return (x509TrustManager != null) ? x509TrustManager : readFieldOrNull(object2, X509TrustManager.class, "trustManager");
    }
    
    public TrustRootIndex trustRootIndex(X509TrustManager param1X509TrustManager) {
      TrustRootIndex trustRootIndex = AndroidTrustRootIndex.get(param1X509TrustManager);
      return (trustRootIndex != null) ? trustRootIndex : super.trustRootIndex(param1X509TrustManager);
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
  
  private static class JdkPlatform extends Platform {
    private final Class<?> sslContextClass;
    
    public JdkPlatform(Class<?> param1Class) {
      this.sslContextClass = param1Class;
    }
    
    public X509TrustManager trustManager(SSLSocketFactory param1SSLSocketFactory) {
      param1SSLSocketFactory = readFieldOrNull(param1SSLSocketFactory, this.sslContextClass, "context");
      return (param1SSLSocketFactory == null) ? null : readFieldOrNull(param1SSLSocketFactory, X509TrustManager.class, "trustManager");
    }
  }
  
  private static class JdkWithJettyBootPlatform extends JdkPlatform {
    private final Class<?> clientProviderClass;
    
    private final Method getMethod;
    
    private final Method putMethod;
    
    private final Method removeMethod;
    
    private final Class<?> serverProviderClass;
    
    public JdkWithJettyBootPlatform(Class<?> param1Class1, Method param1Method1, Method param1Method2, Method param1Method3, Class<?> param1Class2, Class<?> param1Class3) {
      super(param1Class1);
      this.putMethod = param1Method1;
      this.getMethod = param1Method2;
      this.removeMethod = param1Method3;
      this.clientProviderClass = param1Class2;
      this.serverProviderClass = param1Class3;
    }
    
    public void afterHandshake(SSLSocket param1SSLSocket) {
      try {
        this.removeMethod.invoke(null, new Object[] { param1SSLSocket });
        return;
      } catch (IllegalAccessException|InvocationTargetException illegalAccessException) {
        throw new AssertionError();
      } 
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
      
      } catch (IllegalAccessException illegalAccessException) {}
      throw new AssertionError(illegalAccessException);
    }
    
    public String getSelectedProtocol(SSLSocket param1SSLSocket) {
      try {
        String str;
        Method method = this.getMethod;
        Platform.JettyNegoProvider jettyNegoProvider2 = null;
        Platform.JettyNegoProvider jettyNegoProvider1 = (Platform.JettyNegoProvider)Proxy.getInvocationHandler(method.invoke(null, new Object[] { param1SSLSocket }));
        if (!jettyNegoProvider1.unsupported && jettyNegoProvider1.selected == null) {
          Internal.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
          return null;
        } 
        if (jettyNegoProvider1.unsupported) {
          jettyNegoProvider1 = jettyNegoProvider2;
        } else {
          str = jettyNegoProvider1.selected;
        } 
        return str;
      } catch (InvocationTargetException|IllegalAccessException invocationTargetException) {
        throw new AssertionError();
      } 
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
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */