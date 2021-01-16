package com.google.protobuf;

interface MutabilityOracle {
  public static final MutabilityOracle IMMUTABLE = new MutabilityOracle() {
      public void ensureMutable() {
        throw new UnsupportedOperationException();
      }
    };
  
  void ensureMutable();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\MutabilityOracle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */