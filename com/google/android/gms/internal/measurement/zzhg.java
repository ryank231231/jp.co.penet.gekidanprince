package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzhg implements Iterator<Object> {
  public final boolean hasNext() {
    return false;
  }
  
  public final Object next() {
    throw new NoSuchElementException();
  }
  
  public final void remove() {
    throw new UnsupportedOperationException();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */