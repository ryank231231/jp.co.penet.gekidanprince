package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import java.security.KeyPair;

final class zzz {
  private final KeyPair zzbs;
  
  private final long zzbt;
  
  @VisibleForTesting
  zzz(KeyPair paramKeyPair, long paramLong) {
    this.zzbs = paramKeyPair;
    this.zzbt = paramLong;
  }
  
  private final String zzv() {
    return Base64.encodeToString(this.zzbs.getPublic().getEncoded(), 11);
  }
  
  private final String zzw() {
    return Base64.encodeToString(this.zzbs.getPrivate().getEncoded(), 11);
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof zzz))
      return false; 
    paramObject = paramObject;
    return (this.zzbt == ((zzz)paramObject).zzbt && this.zzbs.getPublic().equals(((zzz)paramObject).zzbs.getPublic()) && this.zzbs.getPrivate().equals(((zzz)paramObject).zzbs.getPrivate()));
  }
  
  final long getCreationTime() {
    return this.zzbt;
  }
  
  final KeyPair getKeyPair() {
    return this.zzbs;
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { this.zzbs.getPublic(), this.zzbs.getPrivate(), Long.valueOf(this.zzbt) });
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */