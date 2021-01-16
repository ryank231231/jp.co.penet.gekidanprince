package io.grpc.inprocess;

import com.google.common.base.Preconditions;
import io.grpc.ExperimentalApi;
import io.grpc.Internal;
import io.grpc.ManagedChannelBuilder;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.ProxyParameters;
import io.grpc.internal.SharedResourceHolder;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1783")
public final class InProcessChannelBuilder extends AbstractManagedChannelImplBuilder<InProcessChannelBuilder> {
  private final String name;
  
  private ScheduledExecutorService scheduledExecutorService;
  
  private InProcessChannelBuilder(String paramString) {
    super(new InProcessSocketAddress(paramString), "localhost");
    this.name = (String)Preconditions.checkNotNull(paramString, "name");
    setStatsRecordStartedRpcs(false);
    setStatsRecordFinishedRpcs(false);
  }
  
  public static InProcessChannelBuilder forAddress(String paramString, int paramInt) {
    throw new UnsupportedOperationException("call forName() instead");
  }
  
  public static InProcessChannelBuilder forName(String paramString) {
    return new InProcessChannelBuilder(paramString);
  }
  
  public static InProcessChannelBuilder forTarget(String paramString) {
    throw new UnsupportedOperationException("call forName() instead");
  }
  
  @Internal
  protected ClientTransportFactory buildTransportFactory() {
    return new InProcessClientTransportFactory(this.name, this.scheduledExecutorService);
  }
  
  public InProcessChannelBuilder keepAliveTime(long paramLong, TimeUnit paramTimeUnit) {
    return this;
  }
  
  public InProcessChannelBuilder keepAliveTimeout(long paramLong, TimeUnit paramTimeUnit) {
    return this;
  }
  
  public InProcessChannelBuilder keepAliveWithoutCalls(boolean paramBoolean) {
    return this;
  }
  
  public final InProcessChannelBuilder maxInboundMessageSize(int paramInt) {
    return (InProcessChannelBuilder)super.maxInboundMessageSize(paramInt);
  }
  
  public InProcessChannelBuilder scheduledExecutorService(ScheduledExecutorService paramScheduledExecutorService) {
    this.scheduledExecutorService = (ScheduledExecutorService)Preconditions.checkNotNull(paramScheduledExecutorService, "scheduledExecutorService");
    return this;
  }
  
  public InProcessChannelBuilder usePlaintext() {
    return this;
  }
  
  @Deprecated
  public InProcessChannelBuilder usePlaintext(boolean paramBoolean) {
    return this;
  }
  
  public InProcessChannelBuilder useTransportSecurity() {
    return this;
  }
  
  static final class InProcessClientTransportFactory implements ClientTransportFactory {
    private boolean closed;
    
    private final String name;
    
    private final ScheduledExecutorService timerService;
    
    private final boolean useSharedTimer;
    
    private InProcessClientTransportFactory(String param1String, @Nullable ScheduledExecutorService param1ScheduledExecutorService) {
      boolean bool;
      this.name = param1String;
      if (param1ScheduledExecutorService == null) {
        bool = true;
      } else {
        bool = false;
      } 
      this.useSharedTimer = bool;
      if (this.useSharedTimer)
        param1ScheduledExecutorService = (ScheduledExecutorService)SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE); 
      this.timerService = param1ScheduledExecutorService;
    }
    
    public void close() {
      if (this.closed)
        return; 
      this.closed = true;
      if (this.useSharedTimer)
        SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.timerService); 
    }
    
    public ScheduledExecutorService getScheduledExecutorService() {
      return this.timerService;
    }
    
    public ConnectionClientTransport newClientTransport(SocketAddress param1SocketAddress, String param1String1, String param1String2, ProxyParameters param1ProxyParameters) {
      if (!this.closed)
        return (ConnectionClientTransport)new InProcessTransport(this.name, param1String1, param1String2); 
      throw new IllegalStateException("The transport factory is closed.");
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\inprocess\InProcessChannelBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */