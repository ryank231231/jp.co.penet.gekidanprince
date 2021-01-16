package io.grpc.stub;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.DoNotMock;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.Deadline;
import io.grpc.ExperimentalApi;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@DoNotMock
@ThreadSafe
public abstract class AbstractStub<S extends AbstractStub<S>> {
  private final CallOptions callOptions;
  
  private final Channel channel;
  
  protected AbstractStub(Channel paramChannel) {
    this(paramChannel, CallOptions.DEFAULT);
  }
  
  protected AbstractStub(Channel paramChannel, CallOptions paramCallOptions) {
    this.channel = (Channel)Preconditions.checkNotNull(paramChannel, "channel");
    this.callOptions = (CallOptions)Preconditions.checkNotNull(paramCallOptions, "callOptions");
  }
  
  protected abstract S build(Channel paramChannel, CallOptions paramCallOptions);
  
  public final CallOptions getCallOptions() {
    return this.callOptions;
  }
  
  public final Channel getChannel() {
    return this.channel;
  }
  
  public final S withCallCredentials(CallCredentials paramCallCredentials) {
    return build(this.channel, this.callOptions.withCallCredentials(paramCallCredentials));
  }
  
  @Deprecated
  public final S withChannel(Channel paramChannel) {
    return build(paramChannel, this.callOptions);
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
  public final S withCompression(String paramString) {
    return build(this.channel, this.callOptions.withCompression(paramString));
  }
  
  public final S withDeadline(@Nullable Deadline paramDeadline) {
    return build(this.channel, this.callOptions.withDeadline(paramDeadline));
  }
  
  public final S withDeadlineAfter(long paramLong, TimeUnit paramTimeUnit) {
    return build(this.channel, this.callOptions.withDeadlineAfter(paramLong, paramTimeUnit));
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3605")
  public final S withExecutor(Executor paramExecutor) {
    return build(this.channel, this.callOptions.withExecutor(paramExecutor));
  }
  
  public final S withInterceptors(ClientInterceptor... paramVarArgs) {
    return build(ClientInterceptors.intercept(this.channel, paramVarArgs), this.callOptions);
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2563")
  public final S withMaxInboundMessageSize(int paramInt) {
    return build(this.channel, this.callOptions.withMaxInboundMessageSize(paramInt));
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2563")
  public final S withMaxOutboundMessageSize(int paramInt) {
    return build(this.channel, this.callOptions.withMaxOutboundMessageSize(paramInt));
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1869")
  public final <T> S withOption(CallOptions.Key<T> paramKey, T paramT) {
    return build(this.channel, this.callOptions.withOption(paramKey, paramT));
  }
  
  public final S withWaitForReady() {
    return build(this.channel, this.callOptions.withWaitForReady());
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\stub\AbstractStub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */