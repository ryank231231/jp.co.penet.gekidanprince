package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import java.net.SocketAddress;

final class PairSocketAddress extends SocketAddress {
  private static final long serialVersionUID = -6854992294603212793L;
  
  private final SocketAddress address;
  
  private final Attributes attributes;
  
  @VisibleForTesting
  PairSocketAddress(SocketAddress paramSocketAddress, Attributes paramAttributes) {
    this.address = (SocketAddress)Preconditions.checkNotNull(paramSocketAddress);
    this.attributes = (Attributes)Preconditions.checkNotNull(paramAttributes);
  }
  
  public SocketAddress getAddress() {
    return this.address;
  }
  
  public Attributes getAttributes() {
    return this.attributes;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\PairSocketAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */