package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

final class zzdq extends zzds {
  private final int limit = this.zzacc.size();
  
  private int position = 0;
  
  zzdq(zzdp paramzzdp) {}
  
  public final boolean hasNext() {
    return (this.position < this.limit);
  }
  
  public final byte nextByte() {
    int i = this.position;
    if (i < this.limit) {
      this.position = i + 1;
      return this.zzacc.zzs(i);
    } 
    throw new NoSuchElementException();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */