package io.grpc.okhttp.internal.framed;

import io.grpc.okhttp.internal.Protocol;
import okio.BufferedSink;
import okio.BufferedSource;

public interface Variant {
  Protocol getProtocol();
  
  FrameReader newReader(BufferedSource paramBufferedSource, boolean paramBoolean);
  
  FrameWriter newWriter(BufferedSink paramBufferedSink, boolean paramBoolean);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\internal\framed\Variant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */