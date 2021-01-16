package com.google.android.gms.internal.clearcut;

import java.util.ListIterator;

final class zzfb implements ListIterator<String> {
  private ListIterator<String> zzpc = (ListIterator)zzfa.zza(this.zzpe).listIterator(this.zzpd);
  
  zzfb(zzfa paramzzfa, int paramInt) {}
  
  public final boolean hasNext() {
    return this.zzpc.hasNext();
  }
  
  public final boolean hasPrevious() {
    return this.zzpc.hasPrevious();
  }
  
  public final int nextIndex() {
    return this.zzpc.nextIndex();
  }
  
  public final int previousIndex() {
    return this.zzpc.previousIndex();
  }
  
  public final void remove() {
    throw new UnsupportedOperationException();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */