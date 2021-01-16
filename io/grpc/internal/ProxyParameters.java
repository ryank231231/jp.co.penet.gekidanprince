package io.grpc.internal;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.net.InetSocketAddress;
import javax.annotation.Nullable;

public final class ProxyParameters {
  @Nullable
  public final String password;
  
  public final InetSocketAddress proxyAddress;
  
  @Nullable
  public final String username;
  
  public ProxyParameters(InetSocketAddress paramInetSocketAddress, @Nullable String paramString1, @Nullable String paramString2) {
    Preconditions.checkNotNull(paramInetSocketAddress);
    Preconditions.checkState(paramInetSocketAddress.isUnresolved() ^ true);
    this.proxyAddress = paramInetSocketAddress;
    this.username = paramString1;
    this.password = paramString2;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof ProxyParameters;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (Objects.equal(this.proxyAddress, ((ProxyParameters)paramObject).proxyAddress)) {
      bool = bool1;
      if (Objects.equal(this.username, ((ProxyParameters)paramObject).username)) {
        bool = bool1;
        if (Objects.equal(this.password, ((ProxyParameters)paramObject).password))
          bool = true; 
      } 
    } 
    return bool;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.proxyAddress, this.username, this.password });
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ProxyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */