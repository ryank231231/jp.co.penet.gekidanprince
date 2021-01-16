package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Beta
@GwtCompatible
@Immutable
public final class HostAndPort implements Serializable {
  private static final int NO_PORT = -1;
  
  private static final long serialVersionUID = 0L;
  
  private final boolean hasBracketlessColons;
  
  private final String host;
  
  private final int port;
  
  private HostAndPort(String paramString, int paramInt, boolean paramBoolean) {
    this.host = paramString;
    this.port = paramInt;
    this.hasBracketlessColons = paramBoolean;
  }
  
  public static HostAndPort fromHost(String paramString) {
    HostAndPort hostAndPort = fromString(paramString);
    Preconditions.checkArgument(hostAndPort.hasPort() ^ true, "Host has a port: %s", paramString);
    return hostAndPort;
  }
  
  public static HostAndPort fromParts(String paramString, int paramInt) {
    Preconditions.checkArgument(isValidPort(paramInt), "Port out of range: %s", paramInt);
    HostAndPort hostAndPort = fromString(paramString);
    Preconditions.checkArgument(hostAndPort.hasPort() ^ true, "Host has a port: %s", paramString);
    return new HostAndPort(hostAndPort.host, paramInt, hostAndPort.hasBracketlessColons);
  }
  
  public static HostAndPort fromString(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: ldc '['
    //   8: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   11: istore_1
    //   12: iconst_m1
    //   13: istore_2
    //   14: iconst_0
    //   15: istore_3
    //   16: iconst_0
    //   17: istore #4
    //   19: iload_1
    //   20: ifeq -> 47
    //   23: aload_0
    //   24: invokestatic getHostAndPortFromBracketedHost : (Ljava/lang/String;)[Ljava/lang/String;
    //   27: astore #5
    //   29: aload #5
    //   31: iconst_0
    //   32: aaload
    //   33: astore #6
    //   35: aload #5
    //   37: iconst_1
    //   38: aaload
    //   39: astore #5
    //   41: iload_3
    //   42: istore #4
    //   44: goto -> 115
    //   47: aload_0
    //   48: bipush #58
    //   50: invokevirtual indexOf : (I)I
    //   53: istore #7
    //   55: iload #7
    //   57: iflt -> 101
    //   60: iload #7
    //   62: iconst_1
    //   63: iadd
    //   64: istore #8
    //   66: aload_0
    //   67: bipush #58
    //   69: iload #8
    //   71: invokevirtual indexOf : (II)I
    //   74: iconst_m1
    //   75: if_icmpne -> 101
    //   78: aload_0
    //   79: iconst_0
    //   80: iload #7
    //   82: invokevirtual substring : (II)Ljava/lang/String;
    //   85: astore #6
    //   87: aload_0
    //   88: iload #8
    //   90: invokevirtual substring : (I)Ljava/lang/String;
    //   93: astore #5
    //   95: iload_3
    //   96: istore #4
    //   98: goto -> 115
    //   101: iload #7
    //   103: iflt -> 109
    //   106: iconst_1
    //   107: istore #4
    //   109: aconst_null
    //   110: astore #5
    //   112: aload_0
    //   113: astore #6
    //   115: aload #5
    //   117: invokestatic isNullOrEmpty : (Ljava/lang/String;)Z
    //   120: ifne -> 196
    //   123: aload #5
    //   125: ldc '+'
    //   127: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   130: iconst_1
    //   131: ixor
    //   132: ldc 'Unparseable port number: %s'
    //   134: aload_0
    //   135: invokestatic checkArgument : (ZLjava/lang/String;Ljava/lang/Object;)V
    //   138: aload #5
    //   140: invokestatic parseInt : (Ljava/lang/String;)I
    //   143: istore_2
    //   144: iload_2
    //   145: invokestatic isValidPort : (I)Z
    //   148: ldc 'Port number out of range: %s'
    //   150: aload_0
    //   151: invokestatic checkArgument : (ZLjava/lang/String;Ljava/lang/Object;)V
    //   154: goto -> 196
    //   157: astore #5
    //   159: new java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial <init> : ()V
    //   166: astore #5
    //   168: aload #5
    //   170: ldc 'Unparseable port number: '
    //   172: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload #5
    //   178: aload_0
    //   179: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: new java/lang/IllegalArgumentException
    //   186: dup
    //   187: aload #5
    //   189: invokevirtual toString : ()Ljava/lang/String;
    //   192: invokespecial <init> : (Ljava/lang/String;)V
    //   195: athrow
    //   196: new com/google/common/net/HostAndPort
    //   199: dup
    //   200: aload #6
    //   202: iload_2
    //   203: iload #4
    //   205: invokespecial <init> : (Ljava/lang/String;IZ)V
    //   208: areturn
    // Exception table:
    //   from	to	target	type
    //   138	144	157	java/lang/NumberFormatException
  }
  
  private static String[] getHostAndPortFromBracketedHost(String paramString) {
    boolean bool;
    if (paramString.charAt(0) == '[') {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Bracketed host-port string must start with a bracket: %s", paramString);
    int i = paramString.indexOf(':');
    int j = paramString.lastIndexOf(']');
    if (i > -1 && j > i) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Invalid bracketed host/port: %s", paramString);
    String str = paramString.substring(1, j);
    i = j + 1;
    if (i == paramString.length())
      return new String[] { str, "" }; 
    if (paramString.charAt(i) == ':') {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Only a colon may follow a close bracket: %s", paramString);
    i = j + 2;
    for (j = i; j < paramString.length(); j++)
      Preconditions.checkArgument(Character.isDigit(paramString.charAt(j)), "Port must be numeric: %s", paramString); 
    return new String[] { str, paramString.substring(i) };
  }
  
  private static boolean isValidPort(int paramInt) {
    boolean bool;
    if (paramInt >= 0 && paramInt <= 65535) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject instanceof HostAndPort) {
      paramObject = paramObject;
      if (!Objects.equal(this.host, ((HostAndPort)paramObject).host) || this.port != ((HostAndPort)paramObject).port || this.hasBracketlessColons != ((HostAndPort)paramObject).hasBracketlessColons)
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public String getHost() {
    return this.host;
  }
  
  @Deprecated
  public String getHostText() {
    return this.host;
  }
  
  public int getPort() {
    Preconditions.checkState(hasPort());
    return this.port;
  }
  
  public int getPortOrDefault(int paramInt) {
    if (hasPort())
      paramInt = this.port; 
    return paramInt;
  }
  
  public boolean hasPort() {
    boolean bool;
    if (this.port >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.host, Integer.valueOf(this.port), Boolean.valueOf(this.hasBracketlessColons) });
  }
  
  public HostAndPort requireBracketsForIPv6() {
    Preconditions.checkArgument(this.hasBracketlessColons ^ true, "Possible bracketless IPv6 literal: %s", this.host);
    return this;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(this.host.length() + 8);
    if (this.host.indexOf(':') >= 0) {
      stringBuilder.append('[');
      stringBuilder.append(this.host);
      stringBuilder.append(']');
    } else {
      stringBuilder.append(this.host);
    } 
    if (hasPort()) {
      stringBuilder.append(':');
      stringBuilder.append(this.port);
    } 
    return stringBuilder.toString();
  }
  
  public HostAndPort withDefaultPort(int paramInt) {
    Preconditions.checkArgument(isValidPort(paramInt));
    return (hasPort() || this.port == paramInt) ? this : new HostAndPort(this.host, paramInt, this.hasBracketlessColons);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\net\HostAndPort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */