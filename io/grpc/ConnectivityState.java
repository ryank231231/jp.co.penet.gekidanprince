package io.grpc;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4359")
public enum ConnectivityState {
  CONNECTING, IDLE, READY, SHUTDOWN, TRANSIENT_FAILURE;
  
  static {
    IDLE = new ConnectivityState("IDLE", 3);
    SHUTDOWN = new ConnectivityState("SHUTDOWN", 4);
    $VALUES = new ConnectivityState[] { CONNECTING, READY, TRANSIENT_FAILURE, IDLE, SHUTDOWN };
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ConnectivityState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */