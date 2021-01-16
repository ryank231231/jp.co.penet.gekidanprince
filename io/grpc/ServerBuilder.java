package io.grpc;

import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public abstract class ServerBuilder<T extends ServerBuilder<T>> {
  public static ServerBuilder<?> forPort(int paramInt) {
    return ServerProvider.provider().builderForPort(paramInt);
  }
  
  public abstract T addService(BindableService paramBindableService);
  
  public abstract T addService(ServerServiceDefinition paramServerServiceDefinition);
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
  public T addStreamTracerFactory(ServerStreamTracer.Factory paramFactory) {
    throw new UnsupportedOperationException();
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2132")
  public T addTransportFilter(ServerTransportFilter paramServerTransportFilter) {
    throw new UnsupportedOperationException();
  }
  
  public abstract Server build();
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
  public abstract T compressorRegistry(@Nullable CompressorRegistry paramCompressorRegistry);
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
  public abstract T decompressorRegistry(@Nullable DecompressorRegistry paramDecompressorRegistry);
  
  public abstract T directExecutor();
  
  public abstract T executor(@Nullable Executor paramExecutor);
  
  public abstract T fallbackHandlerRegistry(@Nullable HandlerRegistry paramHandlerRegistry);
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3706")
  public T handshakeTimeout(long paramLong, TimeUnit paramTimeUnit) {
    throw new UnsupportedOperationException();
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3117")
  public T intercept(ServerInterceptor paramServerInterceptor) {
    throw new UnsupportedOperationException();
  }
  
  public abstract T useTransportSecurity(File paramFile1, File paramFile2);
  
  public T useTransportSecurity(InputStream paramInputStream1, InputStream paramInputStream2) {
    throw new UnsupportedOperationException();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ServerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */