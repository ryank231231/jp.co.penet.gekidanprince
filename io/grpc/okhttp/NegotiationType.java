package io.grpc.okhttp;

public enum NegotiationType {
  PLAINTEXT, TLS;
  
  static {
    PLAINTEXT = new NegotiationType("PLAINTEXT", 1);
    $VALUES = new NegotiationType[] { TLS, PLAINTEXT };
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\NegotiationType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */