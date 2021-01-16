package io.grpc.internal;

import io.grpc.Decompressor;

public interface Deframer {
  void close();
  
  void closeWhenComplete();
  
  void deframe(ReadableBuffer paramReadableBuffer);
  
  void request(int paramInt);
  
  void setDecompressor(Decompressor paramDecompressor);
  
  void setFullStreamDecompressor(GzipInflatingBuffer paramGzipInflatingBuffer);
  
  void setMaxInboundMessageSize(int paramInt);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\Deframer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */