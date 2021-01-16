package io.grpc;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class ManagedChannelBuilder<T extends ManagedChannelBuilder<T>> {
  public static ManagedChannelBuilder<?> forAddress(String paramString, int paramInt) {
    return ManagedChannelProvider.provider().builderForAddress(paramString, paramInt);
  }
  
  public static ManagedChannelBuilder<?> forTarget(String paramString) {
    return ManagedChannelProvider.provider().builderForTarget(paramString);
  }
  
  private T thisT() {
    return (T)this;
  }
  
  public abstract ManagedChannel build();
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
  public abstract T compressorRegistry(CompressorRegistry paramCompressorRegistry);
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
  public abstract T decompressorRegistry(DecompressorRegistry paramDecompressorRegistry);
  
  public abstract T directExecutor();
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3982")
  public T disableRetry() {
    throw new UnsupportedOperationException();
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3399")
  public T enableFullStreamDecompression() {
    throw new UnsupportedOperationException();
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3982")
  public T enableRetry() {
    throw new UnsupportedOperationException();
  }
  
  public abstract T executor(Executor paramExecutor);
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2022")
  public abstract T idleTimeout(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract T intercept(List<ClientInterceptor> paramList);
  
  public abstract T intercept(ClientInterceptor... paramVarArgs);
  
  public T keepAliveTime(long paramLong, TimeUnit paramTimeUnit) {
    throw new UnsupportedOperationException();
  }
  
  public T keepAliveTimeout(long paramLong, TimeUnit paramTimeUnit) {
    throw new UnsupportedOperationException();
  }
  
  public T keepAliveWithoutCalls(boolean paramBoolean) {
    throw new UnsupportedOperationException();
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
  public abstract T loadBalancerFactory(LoadBalancer.Factory paramFactory);
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3982")
  public T maxHedgedAttempts(int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2307")
  public T maxInboundMessageSize(int paramInt) {
    return thisT();
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3982")
  public T maxRetryAttempts(int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
  public abstract T nameResolverFactory(NameResolver.Factory paramFactory);
  
  public abstract T overrideAuthority(String paramString);
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3982")
  public T perRpcBufferLimit(long paramLong) {
    throw new UnsupportedOperationException();
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3982")
  public T retryBufferSize(long paramLong) {
    throw new UnsupportedOperationException();
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1772")
  public T usePlaintext() {
    return usePlaintext(true);
  }
  
  @Deprecated
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1772")
  public T usePlaintext(boolean paramBoolean) {
    throw new UnsupportedOperationException();
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3713")
  public T useTransportSecurity() {
    throw new UnsupportedOperationException();
  }
  
  public abstract T userAgent(String paramString);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ManagedChannelBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */