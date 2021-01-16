package io.grpc.inprocess;

import java.net.SocketAddress;

public final class InProcessSocketAddress extends SocketAddress {
  private static final long serialVersionUID = -2803441206326023474L;
  
  private final String name;
  
  public InProcessSocketAddress(String paramString) {
    this.name = paramString;
  }
  
  public String getName() {
    return this.name;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\inprocess\InProcessSocketAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */