package io.grpc;

import java.util.concurrent.Executor;

public interface CallCredentials {
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1914")
  public static final Attributes.Key<String> ATTR_AUTHORITY;
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1914")
  public static final Attributes.Key<SecurityLevel> ATTR_SECURITY_LEVEL = Attributes.Key.of("io.grpc.CallCredentials.securityLevel");
  
  static {
    ATTR_AUTHORITY = Attributes.Key.of("io.grpc.CallCredentials.authority");
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1914")
  void applyRequestMetadata(MethodDescriptor<?, ?> paramMethodDescriptor, Attributes paramAttributes, Executor paramExecutor, MetadataApplier paramMetadataApplier);
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1914")
  void thisUsesUnstableApi();
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1914")
  public static interface MetadataApplier {
    void apply(Metadata param1Metadata);
    
    void fail(Status param1Status);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\CallCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */