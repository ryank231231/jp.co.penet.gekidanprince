package io.grpc;

import com.google.common.base.MoreObjects;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/3363")
public abstract class ForwardingChannelBuilder<T extends ForwardingChannelBuilder<T>> extends ManagedChannelBuilder<T> {
  public static ManagedChannelBuilder<?> forAddress(String paramString, int paramInt) {
    throw new UnsupportedOperationException("Subclass failed to hide static factory");
  }
  
  public static ManagedChannelBuilder<?> forTarget(String paramString) {
    throw new UnsupportedOperationException("Subclass failed to hide static factory");
  }
  
  public ManagedChannel build() {
    return delegate().build();
  }
  
  public T compressorRegistry(CompressorRegistry paramCompressorRegistry) {
    delegate().compressorRegistry(paramCompressorRegistry);
    return thisT();
  }
  
  public T decompressorRegistry(DecompressorRegistry paramDecompressorRegistry) {
    delegate().decompressorRegistry(paramDecompressorRegistry);
    return thisT();
  }
  
  protected abstract ManagedChannelBuilder<?> delegate();
  
  public T directExecutor() {
    delegate().directExecutor();
    return thisT();
  }
  
  public T disableRetry() {
    delegate().disableRetry();
    return thisT();
  }
  
  public T enableFullStreamDecompression() {
    delegate().enableFullStreamDecompression();
    return thisT();
  }
  
  public T enableRetry() {
    delegate().enableRetry();
    return thisT();
  }
  
  public T executor(Executor paramExecutor) {
    delegate().executor(paramExecutor);
    return thisT();
  }
  
  public T idleTimeout(long paramLong, TimeUnit paramTimeUnit) {
    delegate().idleTimeout(paramLong, paramTimeUnit);
    return thisT();
  }
  
  public T intercept(List<ClientInterceptor> paramList) {
    delegate().intercept(paramList);
    return thisT();
  }
  
  public T intercept(ClientInterceptor... paramVarArgs) {
    delegate().intercept(paramVarArgs);
    return thisT();
  }
  
  public T keepAliveTime(long paramLong, TimeUnit paramTimeUnit) {
    delegate().keepAliveTime(paramLong, paramTimeUnit);
    return thisT();
  }
  
  public T keepAliveTimeout(long paramLong, TimeUnit paramTimeUnit) {
    delegate().keepAliveTimeout(paramLong, paramTimeUnit);
    return thisT();
  }
  
  public T keepAliveWithoutCalls(boolean paramBoolean) {
    delegate().keepAliveWithoutCalls(paramBoolean);
    return thisT();
  }
  
  public T loadBalancerFactory(LoadBalancer.Factory paramFactory) {
    delegate().loadBalancerFactory(paramFactory);
    return thisT();
  }
  
  public T maxHedgedAttempts(int paramInt) {
    delegate().maxHedgedAttempts(paramInt);
    return thisT();
  }
  
  public T maxInboundMessageSize(int paramInt) {
    delegate().maxInboundMessageSize(paramInt);
    return thisT();
  }
  
  public T maxRetryAttempts(int paramInt) {
    delegate().maxRetryAttempts(paramInt);
    return thisT();
  }
  
  public T nameResolverFactory(NameResolver.Factory paramFactory) {
    delegate().nameResolverFactory(paramFactory);
    return thisT();
  }
  
  public T overrideAuthority(String paramString) {
    delegate().overrideAuthority(paramString);
    return thisT();
  }
  
  public T perRpcBufferLimit(long paramLong) {
    delegate().perRpcBufferLimit(paramLong);
    return thisT();
  }
  
  public T retryBufferSize(long paramLong) {
    delegate().retryBufferSize(paramLong);
    return thisT();
  }
  
  protected final T thisT() {
    return (T)this;
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
  }
  
  public T usePlaintext() {
    delegate().usePlaintext();
    return thisT();
  }
  
  @Deprecated
  public T usePlaintext(boolean paramBoolean) {
    delegate().usePlaintext(paramBoolean);
    return thisT();
  }
  
  public T useTransportSecurity() {
    delegate().useTransportSecurity();
    return thisT();
  }
  
  public T userAgent(String paramString) {
    delegate().userAgent(paramString);
    return thisT();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ForwardingChannelBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */