package io.grpc.internal;

import io.grpc.Attributes;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface ConnectionClientTransport extends ManagedClientTransport {
  Attributes getAttributes();
}


/* Location:              Y:\classes-dex2jar.jar!\io\grpc\internal\ConnectionClientTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */