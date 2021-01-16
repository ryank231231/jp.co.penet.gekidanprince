package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public final class InetAddresses {
  private static final Inet4Address ANY4;
  
  private static final int IPV4_PART_COUNT = 4;
  
  private static final Splitter IPV4_SPLITTER = Splitter.on('.').limit(4);
  
  private static final int IPV6_PART_COUNT = 8;
  
  private static final Inet4Address LOOPBACK4 = (Inet4Address)forString("127.0.0.1");
  
  static {
    ANY4 = (Inet4Address)forString("0.0.0.0");
  }
  
  private static InetAddress bytesToInetAddress(byte[] paramArrayOfbyte) {
    try {
      return InetAddress.getByAddress(paramArrayOfbyte);
    } catch (UnknownHostException unknownHostException) {
      throw new AssertionError(unknownHostException);
    } 
  }
  
  public static int coerceToInteger(InetAddress paramInetAddress) {
    return ByteStreams.newDataInput(getCoercedIPv4Address(paramInetAddress).getAddress()).readInt();
  }
  
  private static void compressLongestRunOfZeroes(int[] paramArrayOfint) {
    byte b = 0;
    int i = -1;
    int j = -1;
    int k;
    for (k = -1; b < paramArrayOfint.length + 1; k = i1) {
      int m;
      int n;
      int i1;
      if (b < paramArrayOfint.length && paramArrayOfint[b] == 0) {
        m = i;
        n = j;
        i1 = k;
        if (k < 0) {
          i1 = b;
          m = i;
          n = j;
        } 
      } else {
        m = i;
        n = j;
        i1 = k;
        if (k >= 0) {
          i1 = b - k;
          m = i;
          if (i1 > i) {
            m = i1;
            j = k;
          } 
          i1 = -1;
          n = j;
        } 
      } 
      b++;
      i = m;
      j = n;
    } 
    if (i >= 2)
      Arrays.fill(paramArrayOfint, j, i + j, -1); 
  }
  
  @Nullable
  private static String convertDottedQuadToHex(String paramString) {
    int i = paramString.lastIndexOf(':') + 1;
    String str1 = paramString.substring(0, i);
    byte[] arrayOfByte = textToNumericFormatV4(paramString.substring(i));
    if (arrayOfByte == null)
      return null; 
    paramString = Integer.toHexString((arrayOfByte[0] & 0xFF) << 8 | arrayOfByte[1] & 0xFF);
    i = arrayOfByte[2];
    String str2 = Integer.toHexString(arrayOfByte[3] & 0xFF | (i & 0xFF) << 8);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append(paramString);
    stringBuilder.append(":");
    stringBuilder.append(str2);
    return stringBuilder.toString();
  }
  
  public static InetAddress decrement(InetAddress paramInetAddress) {
    boolean bool;
    byte[] arrayOfByte = paramInetAddress.getAddress();
    int i;
    for (i = arrayOfByte.length - 1; i >= 0 && arrayOfByte[i] == 0; i--)
      arrayOfByte[i] = (byte)-1; 
    if (i >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Decrementing %s would wrap.", paramInetAddress);
    arrayOfByte[i] = (byte)(byte)(arrayOfByte[i] - 1);
    return bytesToInetAddress(arrayOfByte);
  }
  
  public static InetAddress forString(String paramString) {
    byte[] arrayOfByte = ipStringToBytes(paramString);
    if (arrayOfByte != null)
      return bytesToInetAddress(arrayOfByte); 
    throw formatIllegalArgumentException("'%s' is not an IP string literal.", new Object[] { paramString });
  }
  
  public static InetAddress forUriString(String paramString) {
    InetAddress inetAddress = forUriStringNoThrow(paramString);
    if (inetAddress != null)
      return inetAddress; 
    throw formatIllegalArgumentException("Not a valid URI IP literal: '%s'", new Object[] { paramString });
  }
  
  @Nullable
  private static InetAddress forUriStringNoThrow(String paramString) {
    byte b;
    Preconditions.checkNotNull(paramString);
    if (paramString.startsWith("[") && paramString.endsWith("]")) {
      paramString = paramString.substring(1, paramString.length() - 1);
      b = 16;
    } else {
      b = 4;
    } 
    byte[] arrayOfByte = ipStringToBytes(paramString);
    return (arrayOfByte == null || arrayOfByte.length != b) ? null : bytesToInetAddress(arrayOfByte);
  }
  
  private static IllegalArgumentException formatIllegalArgumentException(String paramString, Object... paramVarArgs) {
    return new IllegalArgumentException(String.format(Locale.ROOT, paramString, paramVarArgs));
  }
  
  public static Inet4Address fromInteger(int paramInt) {
    return getInet4Address(Ints.toByteArray(paramInt));
  }
  
  public static InetAddress fromLittleEndianByteArray(byte[] paramArrayOfbyte) throws UnknownHostException {
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length];
    for (byte b = 0; b < paramArrayOfbyte.length; b++)
      arrayOfByte[b] = (byte)paramArrayOfbyte[paramArrayOfbyte.length - b - 1]; 
    return InetAddress.getByAddress(arrayOfByte);
  }
  
  public static Inet4Address get6to4IPv4Address(Inet6Address paramInet6Address) {
    Preconditions.checkArgument(is6to4Address(paramInet6Address), "Address '%s' is not a 6to4 address.", toAddrString(paramInet6Address));
    return getInet4Address(Arrays.copyOfRange(paramInet6Address.getAddress(), 2, 6));
  }
  
  public static Inet4Address getCoercedIPv4Address(InetAddress paramInetAddress) {
    long l;
    if (paramInetAddress instanceof Inet4Address)
      return (Inet4Address)paramInetAddress; 
    byte[] arrayOfByte = paramInetAddress.getAddress();
    int i = 0;
    while (true) {
      if (i < 15) {
        if (arrayOfByte[i] != 0) {
          i = 0;
          break;
        } 
        i++;
        continue;
      } 
      i = 1;
      break;
    } 
    if (i != 0 && arrayOfByte[15] == 1)
      return LOOPBACK4; 
    if (i != 0 && arrayOfByte[15] == 0)
      return ANY4; 
    paramInetAddress = paramInetAddress;
    if (hasEmbeddedIPv4ClientAddress((Inet6Address)paramInetAddress)) {
      l = getEmbeddedIPv4ClientAddress((Inet6Address)paramInetAddress).hashCode();
    } else {
      l = ByteBuffer.wrap(paramInetAddress.getAddress(), 0, 8).getLong();
    } 
    int j = Hashing.murmur3_32().hashLong(l).asInt() | 0xE0000000;
    i = j;
    if (j == -1)
      i = -2; 
    return getInet4Address(Ints.toByteArray(i));
  }
  
  public static Inet4Address getCompatIPv4Address(Inet6Address paramInet6Address) {
    Preconditions.checkArgument(isCompatIPv4Address(paramInet6Address), "Address '%s' is not IPv4-compatible.", toAddrString(paramInet6Address));
    return getInet4Address(Arrays.copyOfRange(paramInet6Address.getAddress(), 12, 16));
  }
  
  public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address paramInet6Address) {
    if (isCompatIPv4Address(paramInet6Address))
      return getCompatIPv4Address(paramInet6Address); 
    if (is6to4Address(paramInet6Address))
      return get6to4IPv4Address(paramInet6Address); 
    if (isTeredoAddress(paramInet6Address))
      return getTeredoInfo(paramInet6Address).getClient(); 
    throw formatIllegalArgumentException("'%s' has no embedded IPv4 address.", new Object[] { toAddrString(paramInet6Address) });
  }
  
  private static Inet4Address getInet4Address(byte[] paramArrayOfbyte) {
    boolean bool;
    if (paramArrayOfbyte.length == 4) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Byte array has invalid length for an IPv4 address: %s != 4.", paramArrayOfbyte.length);
    return (Inet4Address)bytesToInetAddress(paramArrayOfbyte);
  }
  
  public static Inet4Address getIsatapIPv4Address(Inet6Address paramInet6Address) {
    Preconditions.checkArgument(isIsatapAddress(paramInet6Address), "Address '%s' is not an ISATAP address.", toAddrString(paramInet6Address));
    return getInet4Address(Arrays.copyOfRange(paramInet6Address.getAddress(), 12, 16));
  }
  
  public static TeredoInfo getTeredoInfo(Inet6Address paramInet6Address) {
    Preconditions.checkArgument(isTeredoAddress(paramInet6Address), "Address '%s' is not a Teredo address.", toAddrString(paramInet6Address));
    byte[] arrayOfByte = paramInet6Address.getAddress();
    Inet4Address inet4Address = getInet4Address(Arrays.copyOfRange(arrayOfByte, 4, 8));
    short s1 = ByteStreams.newDataInput(arrayOfByte, 8).readShort();
    short s2 = ByteStreams.newDataInput(arrayOfByte, 10).readShort();
    arrayOfByte = Arrays.copyOfRange(arrayOfByte, 12, 16);
    for (byte b = 0; b < arrayOfByte.length; b++)
      arrayOfByte[b] = (byte)(byte)(arrayOfByte[b] ^ 0xFFFFFFFF); 
    return new TeredoInfo(inet4Address, getInet4Address(arrayOfByte), 0xFFFF & (s2 ^ 0xFFFFFFFF), s1 & 0xFFFF);
  }
  
  public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address paramInet6Address) {
    return (isCompatIPv4Address(paramInet6Address) || is6to4Address(paramInet6Address) || isTeredoAddress(paramInet6Address));
  }
  
  private static String hextetsToIPv6String(int[] paramArrayOfint) {
    StringBuilder stringBuilder = new StringBuilder(39);
    byte b = 0;
    for (boolean bool = false; b < paramArrayOfint.length; bool = bool1) {
      boolean bool1;
      if (paramArrayOfint[b] >= 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (bool1) {
        if (bool)
          stringBuilder.append(':'); 
        stringBuilder.append(Integer.toHexString(paramArrayOfint[b]));
      } else if (b == 0 || bool) {
        stringBuilder.append("::");
      } 
      b++;
    } 
    return stringBuilder.toString();
  }
  
  public static InetAddress increment(InetAddress paramInetAddress) {
    boolean bool;
    byte[] arrayOfByte = paramInetAddress.getAddress();
    int i = arrayOfByte.length - 1;
    while (true) {
      bool = false;
      if (i >= 0 && arrayOfByte[i] == -1) {
        arrayOfByte[i] = (byte)0;
        i--;
        continue;
      } 
      break;
    } 
    if (i >= 0)
      bool = true; 
    Preconditions.checkArgument(bool, "Incrementing %s would wrap.", paramInetAddress);
    arrayOfByte[i] = (byte)(byte)(arrayOfByte[i] + 1);
    return bytesToInetAddress(arrayOfByte);
  }
  
  @Nullable
  private static byte[] ipStringToBytes(String paramString) {
    byte b = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    while (b < paramString.length()) {
      char c = paramString.charAt(b);
      if (c == '.') {
        bool2 = true;
      } else if (c == ':') {
        if (bool2)
          return null; 
        bool1 = true;
      } else if (Character.digit(c, 16) == -1) {
        return null;
      } 
      b++;
    } 
    if (bool1) {
      String str = paramString;
      if (bool2) {
        paramString = convertDottedQuadToHex(paramString);
        str = paramString;
        if (paramString == null)
          return null; 
      } 
      return textToNumericFormatV6(str);
    } 
    return bool2 ? textToNumericFormatV4(paramString) : null;
  }
  
  public static boolean is6to4Address(Inet6Address paramInet6Address) {
    byte[] arrayOfByte = paramInet6Address.getAddress();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (arrayOfByte[0] == 32) {
      bool2 = bool1;
      if (arrayOfByte[1] == 2)
        bool2 = true; 
    } 
    return bool2;
  }
  
  public static boolean isCompatIPv4Address(Inet6Address paramInet6Address) {
    if (!paramInet6Address.isIPv4CompatibleAddress())
      return false; 
    byte[] arrayOfByte = paramInet6Address.getAddress();
    return !(arrayOfByte[12] == 0 && arrayOfByte[13] == 0 && arrayOfByte[14] == 0 && (arrayOfByte[15] == 0 || arrayOfByte[15] == 1));
  }
  
  public static boolean isInetAddress(String paramString) {
    boolean bool;
    if (ipStringToBytes(paramString) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static boolean isIsatapAddress(Inet6Address paramInet6Address) {
    boolean bool = isTeredoAddress(paramInet6Address);
    boolean bool1 = false;
    if (bool)
      return false; 
    byte[] arrayOfByte = paramInet6Address.getAddress();
    if ((arrayOfByte[8] | 0x3) != 3)
      return false; 
    bool = bool1;
    if (arrayOfByte[9] == 0) {
      bool = bool1;
      if (arrayOfByte[10] == 94) {
        bool = bool1;
        if (arrayOfByte[11] == -2)
          bool = true; 
      } 
    } 
    return bool;
  }
  
  public static boolean isMappedIPv4Address(String paramString) {
    byte[] arrayOfByte = ipStringToBytes(paramString);
    if (arrayOfByte != null && arrayOfByte.length == 16) {
      byte b2;
      byte b1 = 0;
      while (true) {
        b2 = 10;
        if (b1 < 10) {
          if (arrayOfByte[b1] != 0)
            return false; 
          b1++;
          continue;
        } 
        break;
      } 
      while (b2 < 12) {
        if (arrayOfByte[b2] != -1)
          return false; 
        b2++;
      } 
      return true;
    } 
    return false;
  }
  
  public static boolean isMaximum(InetAddress paramInetAddress) {
    byte[] arrayOfByte = paramInetAddress.getAddress();
    for (byte b = 0; b < arrayOfByte.length; b++) {
      if (arrayOfByte[b] != -1)
        return false; 
    } 
    return true;
  }
  
  public static boolean isTeredoAddress(Inet6Address paramInet6Address) {
    byte[] arrayOfByte = paramInet6Address.getAddress();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (arrayOfByte[0] == 32) {
      bool2 = bool1;
      if (arrayOfByte[1] == 1) {
        bool2 = bool1;
        if (arrayOfByte[2] == 0) {
          bool2 = bool1;
          if (arrayOfByte[3] == 0)
            bool2 = true; 
        } 
      } 
    } 
    return bool2;
  }
  
  public static boolean isUriInetAddress(String paramString) {
    boolean bool;
    if (forUriStringNoThrow(paramString) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private static short parseHextet(String paramString) {
    int i = Integer.parseInt(paramString, 16);
    if (i <= 65535)
      return (short)i; 
    throw new NumberFormatException();
  }
  
  private static byte parseOctet(String paramString) {
    int i = Integer.parseInt(paramString);
    if (i <= 255 && (!paramString.startsWith("0") || paramString.length() <= 1))
      return (byte)i; 
    throw new NumberFormatException();
  }
  
  @Nullable
  private static byte[] textToNumericFormatV4(String paramString) {
    byte[] arrayOfByte = new byte[4];
    try {
      Iterator iterator = IPV4_SPLITTER.split(paramString).iterator();
      byte b;
      for (b = 0; iterator.hasNext(); b++)
        arrayOfByte[b] = parseOctet((String)iterator.next()); 
      if (b == 4) {
        byte[] arrayOfByte1 = arrayOfByte;
      } else {
        iterator = null;
      } 
      return (byte[])iterator;
    } catch (NumberFormatException numberFormatException) {
      return null;
    } 
  }
  
  @Nullable
  private static byte[] textToNumericFormatV6(String paramString) {
    int m;
    String[] arrayOfString = paramString.split(":", 10);
    if (arrayOfString.length < 3 || arrayOfString.length > 9)
      return null; 
    int i = 1;
    int j;
    for (j = -1; i < arrayOfString.length - 1; j = n) {
      int n = j;
      if (arrayOfString[i].length() == 0) {
        if (j >= 0)
          return null; 
        n = i;
      } 
      i++;
    } 
    if (j >= 0) {
      int n;
      int i1 = arrayOfString.length - j - 1;
      if (arrayOfString[0].length() == 0) {
        i = j - 1;
        n = i;
        if (i != 0)
          return null; 
      } else {
        n = j;
      } 
      i = i1;
      m = n;
      if (arrayOfString[arrayOfString.length - 1].length() == 0) {
        i = --i1;
        m = n;
        if (i1 != 0)
          return null; 
      } 
    } else {
      m = arrayOfString.length;
      i = 0;
    } 
    int k = 8 - m + i;
    if ((j >= 0) ? (k >= 1) : (k == 0)) {
      ByteBuffer byteBuffer = ByteBuffer.allocate(16);
      j = 0;
      while (true) {
        int n;
        if (j < m) {
          try {
            byteBuffer.putShort(parseHextet(arrayOfString[j]));
            j++;
          } catch (NumberFormatException numberFormatException) {
            return null;
          } 
          continue;
        } 
        j = 0;
        while (true) {
          n = i;
          if (j < k) {
            byteBuffer.putShort((short)0);
            j++;
            continue;
          } 
          break;
        } 
        while (n > 0) {
          byteBuffer.putShort(parseHextet((String)numberFormatException[numberFormatException.length - n]));
          n--;
        } 
        return byteBuffer.array();
      } 
    } 
    return null;
  }
  
  public static String toAddrString(InetAddress paramInetAddress) {
    Preconditions.checkNotNull(paramInetAddress);
    if (paramInetAddress instanceof Inet4Address)
      return paramInetAddress.getHostAddress(); 
    Preconditions.checkArgument(paramInetAddress instanceof Inet6Address);
    byte[] arrayOfByte = paramInetAddress.getAddress();
    int[] arrayOfInt = new int[8];
    for (byte b = 0; b < arrayOfInt.length; b++) {
      int i = b * 2;
      arrayOfInt[b] = Ints.fromBytes((byte)0, (byte)0, arrayOfByte[i], arrayOfByte[i + 1]);
    } 
    compressLongestRunOfZeroes(arrayOfInt);
    return hextetsToIPv6String(arrayOfInt);
  }
  
  public static String toUriString(InetAddress paramInetAddress) {
    if (paramInetAddress instanceof Inet6Address) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[");
      stringBuilder.append(toAddrString(paramInetAddress));
      stringBuilder.append("]");
      return stringBuilder.toString();
    } 
    return toAddrString(paramInetAddress);
  }
  
  @Beta
  public static final class TeredoInfo {
    private final Inet4Address client;
    
    private final int flags;
    
    private final int port;
    
    private final Inet4Address server;
    
    public TeredoInfo(@Nullable Inet4Address param1Inet4Address1, @Nullable Inet4Address param1Inet4Address2, int param1Int1, int param1Int2) {
      boolean bool2;
      boolean bool1 = true;
      if (param1Int1 >= 0 && param1Int1 <= 65535) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "port '%s' is out of range (0 <= port <= 0xffff)", param1Int1);
      if (param1Int2 >= 0 && param1Int2 <= 65535) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "flags '%s' is out of range (0 <= flags <= 0xffff)", param1Int2);
      this.server = (Inet4Address)MoreObjects.firstNonNull(param1Inet4Address1, InetAddresses.ANY4);
      this.client = (Inet4Address)MoreObjects.firstNonNull(param1Inet4Address2, InetAddresses.ANY4);
      this.port = param1Int1;
      this.flags = param1Int2;
    }
    
    public Inet4Address getClient() {
      return this.client;
    }
    
    public int getFlags() {
      return this.flags;
    }
    
    public int getPort() {
      return this.port;
    }
    
    public Inet4Address getServer() {
      return this.server;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\net\InetAddresses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */