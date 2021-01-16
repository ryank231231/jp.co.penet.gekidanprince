package io.grpc;

@Internal
public final class InternalStatus {
  @Internal
  public static final Metadata.Key<Status> CODE_KEY;
  
  @Internal
  public static final Metadata.Key<String> MESSAGE_KEY = Status.MESSAGE_KEY;
  
  static {
    CODE_KEY = Status.CODE_KEY;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\InternalStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */