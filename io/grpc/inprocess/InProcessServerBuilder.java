package io.grpc.inprocess;

import com.google.common.base.Preconditions;
import io.grpc.ExperimentalApi;
import io.grpc.ServerBuilder;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.AbstractServerImplBuilder;
import io.grpc.internal.FixedObjectPool;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InternalServer;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.SharedResourcePool;
import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1783")
public final class InProcessServerBuilder extends AbstractServerImplBuilder<InProcessServerBuilder> {
  private final String name;
  
  private ObjectPool<ScheduledExecutorService> schedulerPool = (ObjectPool<ScheduledExecutorService>)SharedResourcePool.forResource(GrpcUtil.TIMER_SERVICE);
  
  private InProcessServerBuilder(String paramString) {
    this.name = (String)Preconditions.checkNotNull(paramString, "name");
    setStatsRecordStartedRpcs(false);
    setStatsRecordFinishedRpcs(false);
    handshakeTimeout(Long.MAX_VALUE, TimeUnit.SECONDS);
  }
  
  public static InProcessServerBuilder forName(String paramString) {
    return new InProcessServerBuilder(paramString);
  }
  
  public static InProcessServerBuilder forPort(int paramInt) {
    throw new UnsupportedOperationException("call forName() instead");
  }
  
  public static String generateName() {
    return UUID.randomUUID().toString();
  }
  
  protected InProcessServer buildTransportServer(List<ServerStreamTracer.Factory> paramList) {
    return new InProcessServer(this.name, this.schedulerPool, paramList);
  }
  
  public InProcessServerBuilder scheduledExecutorService(ScheduledExecutorService paramScheduledExecutorService) {
    this.schedulerPool = (ObjectPool<ScheduledExecutorService>)new FixedObjectPool(Preconditions.checkNotNull(paramScheduledExecutorService, "scheduledExecutorService"));
    return this;
  }
  
  public InProcessServerBuilder useTransportSecurity(File paramFile1, File paramFile2) {
    throw new UnsupportedOperationException("TLS not supported in InProcessServer");
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\inprocess\InProcessServerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */