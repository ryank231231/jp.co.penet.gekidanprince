package io.grpc;

@ExperimentalApi
public enum SecurityLevel {
  INTEGRITY, NONE, PRIVACY_AND_INTEGRITY;
  
  static {
    INTEGRITY = new SecurityLevel("INTEGRITY", 1);
    PRIVACY_AND_INTEGRITY = new SecurityLevel("PRIVACY_AND_INTEGRITY", 2);
    $VALUES = new SecurityLevel[] { NONE, INTEGRITY, PRIVACY_AND_INTEGRITY };
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\SecurityLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */