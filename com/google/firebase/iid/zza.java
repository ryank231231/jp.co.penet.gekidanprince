package com.google.firebase.iid;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public final class zza {
  public static KeyPair zzc() {
    try {
      KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
      keyPairGenerator.initialize(2048);
      return keyPairGenerator.generateKeyPair();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError(noSuchAlgorithmException);
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */