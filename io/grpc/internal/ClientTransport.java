package io.grpc.internal;

import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface ClientTransport extends Instrumented<Channelz.SocketStats> {
  ClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, CallOptions paramCallOptions);
  
  void ping(PingCallback paramPingCallback, Executor paramExecutor);
  
  class ClientTransport {}
}


/* Location:              Y:\classes-dex2jar.jar!\io\grpc\internal\ClientTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */