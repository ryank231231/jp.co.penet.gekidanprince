package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;

final class DnsNameResolver extends NameResolver {
  private static final String GRPCLB_NAME_PREFIX = "_grpclb._tcp.";
  
  private static final boolean JNDI_AVAILABLE;
  
  private static final String JNDI_PROPERTY;
  
  private static final String SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY = "clientHostname";
  
  private static final String SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY = "clientLanguage";
  
  private static final Set<String> SERVICE_CONFIG_CHOICE_KEYS;
  
  private static final String SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY = "percentage";
  
  private static final String SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY = "serviceConfig";
  
  private static final String SERVICE_CONFIG_NAME_PREFIX = "_grpc_config.";
  
  static final String SERVICE_CONFIG_PREFIX = "_grpc_config=";
  
  @VisibleForTesting
  static boolean enableJndi;
  
  private static String localHostname;
  
  private static final Logger logger = Logger.getLogger(DnsNameResolver.class.getName());
  
  private final String authority;
  
  private DelegateResolver delegateResolver;
  
  @GuardedBy("this")
  private ExecutorService executor;
  
  private final SharedResourceHolder.Resource<ExecutorService> executorResource;
  
  private final String host;
  
  @GuardedBy("this")
  private NameResolver.Listener listener;
  
  private final int port;
  
  @VisibleForTesting
  final ProxyDetector proxyDetector;
  
  private final Random random;
  
  private final Runnable resolutionRunnable;
  
  @GuardedBy("this")
  private boolean resolving;
  
  @GuardedBy("this")
  private boolean shutdown;
  
  static {
    JNDI_AVAILABLE = jndiAvailable();
    SERVICE_CONFIG_CHOICE_KEYS = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(new String[] { "clientLanguage", "percentage", "clientHostname", "serviceConfig" })));
    JNDI_PROPERTY = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "false");
    enableJndi = Boolean.parseBoolean(JNDI_PROPERTY);
  }
  
  DnsNameResolver(@Nullable String paramString1, String paramString2, Attributes paramAttributes, SharedResourceHolder.Resource<ExecutorService> paramResource, ProxyDetector paramProxyDetector) {
    StringBuilder stringBuilder1;
    this.random = new Random();
    this.delegateResolver = pickDelegateResolver();
    this.resolutionRunnable = new Runnable() {
        public void run() {
          synchronized (DnsNameResolver.this) {
            if (DnsNameResolver.this.shutdown)
              return; 
            NameResolver.Listener listener = DnsNameResolver.this.listener;
            DnsNameResolver.access$202(DnsNameResolver.this, true);
            try {
              InetSocketAddress inetSocketAddress = InetSocketAddress.createUnresolved(DnsNameResolver.this.host, DnsNameResolver.this.port);
            } finally {
              null = null;
            } 
          } 
        }
      };
    this.executorResource = paramResource;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("//");
    stringBuilder2.append(paramString2);
    URI uRI = URI.create(stringBuilder2.toString());
    this.authority = (String)Preconditions.checkNotNull(uRI.getAuthority(), "nameUri (%s) doesn't have an authority", uRI);
    this.host = (String)Preconditions.checkNotNull(uRI.getHost(), "host");
    if (uRI.getPort() == -1) {
      Integer integer = (Integer)paramAttributes.get(NameResolver.Factory.PARAMS_DEFAULT_PORT);
      if (integer != null) {
        this.port = integer.intValue();
      } else {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("name '");
        stringBuilder1.append(paramString2);
        stringBuilder1.append("' doesn't contain a port, and default port is not set in params");
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
    } else {
      this.port = stringBuilder1.getPort();
    } 
    this.proxyDetector = paramProxyDetector;
  }
  
  @Nullable
  private static final List<String> getClientLanguagesFromChoice(Map<String, Object> paramMap) {
    return !paramMap.containsKey("clientLanguage") ? null : ServiceConfigUtil.checkStringList(ServiceConfigUtil.getList(paramMap, "clientLanguage"));
  }
  
  @Nullable
  private static final List<String> getHostnamesFromChoice(Map<String, Object> paramMap) {
    return !paramMap.containsKey("clientHostname") ? null : ServiceConfigUtil.checkStringList(ServiceConfigUtil.getList(paramMap, "clientHostname"));
  }
  
  private static String getLocalHostname() {
    if (localHostname == null)
      try {
        localHostname = InetAddress.getLocalHost().getHostName();
      } catch (UnknownHostException unknownHostException) {
        throw new RuntimeException(unknownHostException);
      }  
    return localHostname;
  }
  
  @Nullable
  private static final Double getPercentageFromChoice(Map<String, Object> paramMap) {
    return !paramMap.containsKey("percentage") ? null : ServiceConfigUtil.getDouble(paramMap, "percentage");
  }
  
  @VisibleForTesting
  static boolean jndiAvailable() {
    if (GrpcUtil.IS_RESTRICTED_APPENGINE)
      return false; 
    try {
      Class.forName("javax.naming.directory.InitialDirContext");
      Class.forName("com.sun.jndi.dns.DnsContextFactory");
      return true;
    } catch (ClassNotFoundException classNotFoundException) {
      logger.log(Level.FINE, "Unable to find JNDI DNS resolver, skipping", classNotFoundException);
      return false;
    } 
  }
  
  @Nullable
  @VisibleForTesting
  static Map<String, Object> maybeChooseServiceConfig(Map<String, Object> paramMap, Random paramRandom, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface entrySet : ()Ljava/util/Set;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore_3
    //   12: aload_3
    //   13: invokeinterface hasNext : ()Z
    //   18: istore #4
    //   20: iconst_0
    //   21: istore #5
    //   23: iload #4
    //   25: ifeq -> 72
    //   28: aload_3
    //   29: invokeinterface next : ()Ljava/lang/Object;
    //   34: checkcast java/util/Map$Entry
    //   37: astore #6
    //   39: getstatic io/grpc/internal/DnsNameResolver.SERVICE_CONFIG_CHOICE_KEYS : Ljava/util/Set;
    //   42: aload #6
    //   44: invokeinterface getKey : ()Ljava/lang/Object;
    //   49: invokeinterface contains : (Ljava/lang/Object;)Z
    //   54: ldc_w 'Bad key: %s'
    //   57: iconst_1
    //   58: anewarray java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload #6
    //   65: aastore
    //   66: invokestatic verify : (ZLjava/lang/String;[Ljava/lang/Object;)V
    //   69: goto -> 12
    //   72: aload_0
    //   73: invokestatic getClientLanguagesFromChoice : (Ljava/util/Map;)Ljava/util/List;
    //   76: astore #6
    //   78: aload #6
    //   80: ifnull -> 147
    //   83: aload #6
    //   85: invokeinterface isEmpty : ()Z
    //   90: ifne -> 147
    //   93: aload #6
    //   95: invokeinterface iterator : ()Ljava/util/Iterator;
    //   100: astore #6
    //   102: aload #6
    //   104: invokeinterface hasNext : ()Z
    //   109: ifeq -> 137
    //   112: ldc_w 'java'
    //   115: aload #6
    //   117: invokeinterface next : ()Ljava/lang/Object;
    //   122: checkcast java/lang/String
    //   125: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   128: ifeq -> 102
    //   131: iconst_1
    //   132: istore #7
    //   134: goto -> 140
    //   137: iconst_0
    //   138: istore #7
    //   140: iload #7
    //   142: ifne -> 147
    //   145: aconst_null
    //   146: areturn
    //   147: aload_0
    //   148: invokestatic getPercentageFromChoice : (Ljava/util/Map;)Ljava/lang/Double;
    //   151: astore #6
    //   153: aload #6
    //   155: ifnull -> 216
    //   158: aload #6
    //   160: invokevirtual intValue : ()I
    //   163: istore #7
    //   165: iload #7
    //   167: iflt -> 183
    //   170: iload #7
    //   172: bipush #100
    //   174: if_icmpgt -> 183
    //   177: iconst_1
    //   178: istore #4
    //   180: goto -> 186
    //   183: iconst_0
    //   184: istore #4
    //   186: iload #4
    //   188: ldc_w 'Bad percentage: %s'
    //   191: iconst_1
    //   192: anewarray java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload #6
    //   199: aastore
    //   200: invokestatic verify : (ZLjava/lang/String;[Ljava/lang/Object;)V
    //   203: aload_1
    //   204: bipush #100
    //   206: invokevirtual nextInt : (I)I
    //   209: iload #7
    //   211: if_icmplt -> 216
    //   214: aconst_null
    //   215: areturn
    //   216: aload_0
    //   217: invokestatic getHostnamesFromChoice : (Ljava/util/Map;)Ljava/util/List;
    //   220: astore_1
    //   221: aload_1
    //   222: ifnull -> 280
    //   225: aload_1
    //   226: invokeinterface isEmpty : ()Z
    //   231: ifne -> 280
    //   234: aload_1
    //   235: invokeinterface iterator : ()Ljava/util/Iterator;
    //   240: astore_1
    //   241: iload #5
    //   243: istore #7
    //   245: aload_1
    //   246: invokeinterface hasNext : ()Z
    //   251: ifeq -> 273
    //   254: aload_1
    //   255: invokeinterface next : ()Ljava/lang/Object;
    //   260: checkcast java/lang/String
    //   263: aload_2
    //   264: invokevirtual equals : (Ljava/lang/Object;)Z
    //   267: ifeq -> 241
    //   270: iconst_1
    //   271: istore #7
    //   273: iload #7
    //   275: ifne -> 280
    //   278: aconst_null
    //   279: areturn
    //   280: aload_0
    //   281: ldc 'serviceConfig'
    //   283: invokestatic getObject : (Ljava/util/Map;Ljava/lang/String;)Ljava/util/Map;
    //   286: areturn
  }
  
  @VisibleForTesting
  static List<Map<String, Object>> parseTxtResults(List<String> paramList) {
    ArrayList<Map<String, Object>> arrayList = new ArrayList();
    for (String str : paramList) {
      if (str.startsWith("_grpc_config="))
        try {
          Object object = JsonParser.parse(str.substring(13));
          if (object instanceof List) {
            StringBuilder stringBuilder1;
            List list = (List)object;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
              if (iterator.next() instanceof Map)
                continue; 
              IOException iOException1 = new IOException();
              stringBuilder1 = new StringBuilder();
              this();
              stringBuilder1.append("wrong element type ");
              stringBuilder1.append(object);
              this(stringBuilder1.toString());
              throw iOException1;
            } 
            arrayList.addAll((Collection)stringBuilder1);
            continue;
          } 
          IOException iOException = new IOException();
          StringBuilder stringBuilder = new StringBuilder();
          this();
          stringBuilder.append("wrong type ");
          stringBuilder.append(object);
          this(stringBuilder.toString());
          throw iOException;
        } catch (IOException iOException) {
          Logger logger = logger;
          Level level = Level.WARNING;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Bad service config: ");
          stringBuilder.append(str);
          logger.log(level, stringBuilder.toString(), iOException);
          continue;
        }  
      logger.log(Level.FINE, "Ignoring non service config {0}", new Object[] { str });
    } 
    return arrayList;
  }
  
  private DelegateResolver pickDelegateResolver() {
    JdkResolver jdkResolver = new JdkResolver();
    return (DelegateResolver)((JNDI_AVAILABLE && enableJndi) ? new CompositeResolver(jdkResolver, new JndiResolver()) : jdkResolver);
  }
  
  @GuardedBy("this")
  private void resolve() {
    if (this.resolving || this.shutdown)
      return; 
    this.executor.execute(this.resolutionRunnable);
  }
  
  @VisibleForTesting
  static String unquote(String paramString) {
    StringBuilder stringBuilder = new StringBuilder(paramString.length());
    int i = 0;
    boolean bool = false;
    while (true) {
      int j;
      int k;
      if (i < paramString.length()) {
        char c = paramString.charAt(i);
        if (!bool) {
          if (c == ' ')
            continue; 
          j = i;
          k = c;
          if (c == '"') {
            bool = true;
            continue;
          } 
        } else {
          if (c == '"') {
            bool = false;
          } else {
            j = i;
            k = c;
            if (c == '\\') {
              j = i + 1;
              i = paramString.charAt(j);
              k = i;
            } 
            stringBuilder.append(k);
            i = j;
          } 
          continue;
        } 
      } else {
        break;
      } 
      stringBuilder.append(k);
      i = j;
      i++;
    } 
    return stringBuilder.toString();
  }
  
  final int getPort() {
    return this.port;
  }
  
  public final String getServiceAuthority() {
    return this.authority;
  }
  
  public final void refresh() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield listener : Lio/grpc/NameResolver$Listener;
    //   6: ifnull -> 14
    //   9: iconst_1
    //   10: istore_1
    //   11: goto -> 16
    //   14: iconst_0
    //   15: istore_1
    //   16: iload_1
    //   17: ldc_w 'not started'
    //   20: invokestatic checkState : (ZLjava/lang/Object;)V
    //   23: aload_0
    //   24: invokespecial resolve : ()V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	30	finally
    //   16	27	30	finally
  }
  
  @VisibleForTesting
  void setDelegateResolver(DelegateResolver paramDelegateResolver) {
    this.delegateResolver = paramDelegateResolver;
  }
  
  public final void shutdown() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield shutdown : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield shutdown : Z
    //   19: aload_0
    //   20: getfield executor : Ljava/util/concurrent/ExecutorService;
    //   23: ifnull -> 44
    //   26: aload_0
    //   27: aload_0
    //   28: getfield executorResource : Lio/grpc/internal/SharedResourceHolder$Resource;
    //   31: aload_0
    //   32: getfield executor : Ljava/util/concurrent/ExecutorService;
    //   35: invokestatic release : (Lio/grpc/internal/SharedResourceHolder$Resource;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast java/util/concurrent/ExecutorService
    //   41: putfield executor : Ljava/util/concurrent/ExecutorService;
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   14	44	47	finally
  }
  
  public final void start(NameResolver.Listener paramListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield listener : Lio/grpc/NameResolver$Listener;
    //   6: ifnonnull -> 14
    //   9: iconst_1
    //   10: istore_2
    //   11: goto -> 16
    //   14: iconst_0
    //   15: istore_2
    //   16: iload_2
    //   17: ldc_w 'already started'
    //   20: invokestatic checkState : (ZLjava/lang/Object;)V
    //   23: aload_0
    //   24: aload_0
    //   25: getfield executorResource : Lio/grpc/internal/SharedResourceHolder$Resource;
    //   28: invokestatic get : (Lio/grpc/internal/SharedResourceHolder$Resource;)Ljava/lang/Object;
    //   31: checkcast java/util/concurrent/ExecutorService
    //   34: putfield executor : Ljava/util/concurrent/ExecutorService;
    //   37: aload_0
    //   38: aload_1
    //   39: ldc_w 'listener'
    //   42: invokestatic checkNotNull : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast io/grpc/NameResolver$Listener
    //   48: putfield listener : Lio/grpc/NameResolver$Listener;
    //   51: aload_0
    //   52: invokespecial resolve : ()V
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	58	finally
    //   16	55	58	finally
  }
  
  @VisibleForTesting
  static final class CompositeResolver extends DelegateResolver {
    private final DnsNameResolver.DelegateResolver jdkResovler;
    
    private final DnsNameResolver.DelegateResolver jndiResovler;
    
    CompositeResolver(DnsNameResolver.DelegateResolver param1DelegateResolver1, DnsNameResolver.DelegateResolver param1DelegateResolver2) {
      this.jdkResovler = param1DelegateResolver1;
      this.jndiResovler = param1DelegateResolver2;
    }
    
    DnsNameResolver.ResolutionResults resolve(String param1String) throws Exception {
      List<?> list1;
      List<InetAddress> list = (this.jdkResovler.resolve(param1String)).addresses;
      List<?> list2 = Collections.emptyList();
      List<?> list3 = Collections.emptyList();
      List<?> list4 = list2;
      try {
        DnsNameResolver.ResolutionResults resolutionResults = this.jndiResovler.resolve(param1String);
        list4 = list2;
        list1 = resolutionResults.txtRecords;
        list4 = list1;
        list2 = resolutionResults.balancerAddresses;
        list3 = list2;
      } catch (Throwable throwable) {
        DnsNameResolver.logger.log(Level.SEVERE, "Failed to resolve TXT results", throwable);
        list1 = list4;
      } 
      return new DnsNameResolver.ResolutionResults(list, (List)list1, (List)list3);
    }
  }
  
  @VisibleForTesting
  static abstract class DelegateResolver {
    abstract DnsNameResolver.ResolutionResults resolve(String param1String) throws Exception;
  }
  
  @VisibleForTesting
  static final class JdkResolver extends DelegateResolver {
    DnsNameResolver.ResolutionResults resolve(String param1String) throws Exception {
      return new DnsNameResolver.ResolutionResults(Arrays.asList(InetAddress.getAllByName(param1String)), Collections.emptyList(), Collections.emptyList());
    }
  }
  
  @VisibleForTesting
  static final class JndiResolver extends DelegateResolver {
    private static final Pattern whitespace = Pattern.compile("\\s+");
    
    private List<String> getAllRecords(String param1String1, String param1String2) throws NamingException {
      Attributes attributes = (new InitialDirContext()).getAttributes(param1String2, new String[] { param1String1 });
      null = new ArrayList();
      NamingEnumeration<? extends Attribute> namingEnumeration = attributes.getAll();
      try {
        while (namingEnumeration.hasMore()) {
          NamingEnumeration<?> namingEnumeration1 = ((Attribute)namingEnumeration.next()).getAll();
          try {
            while (namingEnumeration1.hasMore())
              null.add(DnsNameResolver.unquote(String.valueOf(namingEnumeration1.next()))); 
          } finally {
            namingEnumeration1.close();
          } 
        } 
        return null;
      } finally {
        namingEnumeration.close();
      } 
    }
    
    DnsNameResolver.ResolutionResults resolve(String param1String) throws NamingException {
      List<?> list1 = Collections.emptyList();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("_grpc_config.");
      stringBuilder2.append(param1String);
      String str2 = stringBuilder2.toString();
      if (DnsNameResolver.logger.isLoggable(Level.FINER))
        DnsNameResolver.logger.log(Level.FINER, "About to query TXT records for {0}", new Object[] { str2 }); 
      try {
        stringBuilder2 = new StringBuilder();
        this();
        stringBuilder2.append("dns:///");
        stringBuilder2.append(str2);
        List<String> list = getAllRecords("TXT", stringBuilder2.toString());
      } catch (NamingException namingException1) {
        List<?> list = list1;
        if (DnsNameResolver.logger.isLoggable(Level.FINE)) {
          Logger logger = DnsNameResolver.logger;
          Level level = Level.FINE;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Unable to look up ");
          stringBuilder.append(str2);
          logger.log(level, stringBuilder.toString(), namingException1);
          List<?> list3 = list1;
        } 
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("_grpclb._tcp.");
      stringBuilder1.append(param1String);
      String str1 = stringBuilder1.toString();
      if (DnsNameResolver.logger.isLoggable(Level.FINER))
        DnsNameResolver.logger.log(Level.FINER, "About to query SRV records for {0}", new Object[] { str1 }); 
      List<?> list2 = Collections.emptyList();
      try {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("dns:///");
        stringBuilder.append(str1);
        List<String> list = getAllRecords("SRV", stringBuilder.toString());
        ArrayList<?> arrayList = new ArrayList();
        this(list.size());
        try {
          Iterator<String> iterator = list.iterator();
          while (true) {
            list2 = arrayList;
            if (iterator.hasNext()) {
              str3 = iterator.next();
              try {
                boolean bool;
                String[] arrayOfString = whitespace.split(str3);
                if (arrayOfString.length == 4) {
                  bool = true;
                } else {
                  bool = false;
                } 
                Verify.verify(bool, "Bad SRV Record: %s, ", new Object[] { str3 });
                String str = arrayOfString[3];
                int i = Integer.parseInt(arrayOfString[2]);
                InetAddress[] arrayOfInetAddress = InetAddress.getAllByName(str);
                ArrayList<InetSocketAddress> arrayList1 = new ArrayList();
                this(arrayOfInetAddress.length);
                int j = arrayOfInetAddress.length;
                for (byte b = 0; b < j; b++) {
                  InetAddress inetAddress = arrayOfInetAddress[b];
                  InetSocketAddress inetSocketAddress = new InetSocketAddress();
                  this(inetAddress, i);
                  arrayList1.add(inetSocketAddress);
                } 
                Attributes attributes = Attributes.newBuilder().set(GrpcAttributes.ATTR_LB_ADDR_AUTHORITY, str).build();
                EquivalentAddressGroup equivalentAddressGroup = new EquivalentAddressGroup();
                this(Collections.unmodifiableList(arrayList1), attributes);
                arrayList.add(equivalentAddressGroup);
              } catch (UnknownHostException unknownHostException) {
                Logger logger = DnsNameResolver.logger;
                Level level = Level.WARNING;
                StringBuilder stringBuilder3 = new StringBuilder();
                this();
                stringBuilder3.append("Can't find address for SRV record");
                stringBuilder3.append(str3);
                logger.log(level, stringBuilder3.toString(), unknownHostException);
              } catch (RuntimeException runtimeException) {
                Logger logger = DnsNameResolver.logger;
                Level level = Level.WARNING;
                StringBuilder stringBuilder3 = new StringBuilder();
                this();
                stringBuilder3.append("Failed to construct SRV record");
                stringBuilder3.append(str3);
                logger.log(level, stringBuilder3.toString(), runtimeException);
              } 
              continue;
            } 
            break;
          } 
        } catch (NamingException null) {}
      } catch (NamingException namingException) {
        param1String = str3;
      } 
      String str3 = param1String;
      if (DnsNameResolver.logger.isLoggable(Level.FINE)) {
        Logger logger = DnsNameResolver.logger;
        Level level = Level.FINE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to look up ");
        stringBuilder.append(str2);
        logger.log(level, stringBuilder.toString(), namingException);
        String str = param1String;
      } 
    }
  }
  
  @VisibleForTesting
  static final class ResolutionResults {
    final List<InetAddress> addresses;
    
    final List<EquivalentAddressGroup> balancerAddresses;
    
    final List<String> txtRecords;
    
    ResolutionResults(List<InetAddress> param1List, List<String> param1List1, List<EquivalentAddressGroup> param1List2) {
      this.addresses = Collections.unmodifiableList((List<? extends InetAddress>)Preconditions.checkNotNull(param1List, "addresses"));
      this.txtRecords = Collections.unmodifiableList((List<? extends String>)Preconditions.checkNotNull(param1List1, "txtRecords"));
      this.balancerAddresses = Collections.unmodifiableList((List<? extends EquivalentAddressGroup>)Preconditions.checkNotNull(param1List2, "balancerAddresses"));
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\DnsNameResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */