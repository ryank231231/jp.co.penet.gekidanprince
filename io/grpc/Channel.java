package io.grpc;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class Channel {
  public abstract String authority();
  
  public abstract <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> paramMethodDescriptor, CallOptions paramCallOptions);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\Channel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */