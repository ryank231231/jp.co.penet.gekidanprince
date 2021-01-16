package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.net.InetAddress;
import java.text.ParseException;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public final class HostSpecifier {
  private final String canonicalForm;
  
  private HostSpecifier(String paramString) {
    this.canonicalForm = paramString;
  }
  
  public static HostSpecifier from(String paramString) throws ParseException {
    try {
      return fromValid(paramString);
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid host specifier: ");
      stringBuilder.append(paramString);
      ParseException parseException = new ParseException(stringBuilder.toString(), 0);
      parseException.initCause(illegalArgumentException);
      throw parseException;
    } 
  }
  
  public static HostSpecifier fromValid(String paramString) {
    InetAddress inetAddress;
    HostAndPort hostAndPort = HostAndPort.fromString(paramString);
    Preconditions.checkArgument(hostAndPort.hasPort() ^ true);
    String str = hostAndPort.getHost();
    hostAndPort = null;
    try {
      InetAddress inetAddress1 = InetAddresses.forString(str);
      inetAddress = inetAddress1;
    } catch (IllegalArgumentException illegalArgumentException) {}
    if (inetAddress != null)
      return new HostSpecifier(InetAddresses.toUriString(inetAddress)); 
    InternetDomainName internetDomainName = InternetDomainName.from(str);
    if (internetDomainName.hasPublicSuffix())
      return new HostSpecifier(internetDomainName.toString()); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Domain name does not have a recognized public suffix: ");
    stringBuilder.append(str);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static boolean isValid(String paramString) {
    try {
      fromValid(paramString);
      return true;
    } catch (IllegalArgumentException illegalArgumentException) {
      return false;
    } 
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject instanceof HostSpecifier) {
      paramObject = paramObject;
      return this.canonicalForm.equals(((HostSpecifier)paramObject).canonicalForm);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.canonicalForm.hashCode();
  }
  
  public String toString() {
    return this.canonicalForm;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\net\HostSpecifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */