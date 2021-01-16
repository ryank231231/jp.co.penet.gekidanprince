package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzbc implements Iterator {
  private final int limit = this.zzfl.size();
  
  private int position = 0;
  
  zzbc(zzbb paramzzbb) {}
  
  private final byte nextByte() {
    try {
      zzbb zzbb1 = this.zzfl;
      int i = this.position;
      this.position = i + 1;
      return zzbb1.zzj(i);
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      throw new NoSuchElementException(indexOutOfBoundsException.getMessage());
    } 
  }
  
  public final boolean hasNext() {
    return (this.position < this.limit);
  }
  
  public final void remove() {
    throw new UnsupportedOperationException();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */