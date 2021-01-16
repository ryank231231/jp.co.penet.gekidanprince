package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.Decompressor;
import io.grpc.Metadata;
import io.grpc.Status;
import javax.annotation.Nullable;

public interface ServerStream extends Stream {
  void cancel(Status paramStatus);
  
  void close(Status paramStatus, Metadata paramMetadata);
  
  Attributes getAttributes();
  
  @Nullable
  String getAuthority();
  
  void setDecompressor(Decompressor paramDecompressor);
  
  void setListener(ServerStreamListener paramServerStreamListener);
  
  StatsTraceContext statsTraceContext();
  
  void writeHeaders(Metadata paramMetadata);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ServerStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */