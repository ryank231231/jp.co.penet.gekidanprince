package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
@ThreadSafe
public final class CompressorRegistry {
  private static final CompressorRegistry DEFAULT_INSTANCE = new CompressorRegistry(new Compressor[] { new Codec.Gzip(), Codec.Identity.NONE });
  
  private final ConcurrentMap<String, Compressor> compressors = new ConcurrentHashMap<String, Compressor>();
  
  @VisibleForTesting
  CompressorRegistry(Compressor... paramVarArgs) {
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      Compressor compressor = paramVarArgs[b];
      this.compressors.put(compressor.getMessageEncoding(), compressor);
    } 
  }
  
  public static CompressorRegistry getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static CompressorRegistry newEmptyInstance() {
    return new CompressorRegistry(new Compressor[0]);
  }
  
  @Nullable
  public Compressor lookupCompressor(String paramString) {
    return this.compressors.get(paramString);
  }
  
  public void register(Compressor paramCompressor) {
    String str = paramCompressor.getMessageEncoding();
    Preconditions.checkArgument(str.contains(",") ^ true, "Comma is currently not allowed in message encoding");
    this.compressors.put(str, paramCompressor);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\CompressorRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */