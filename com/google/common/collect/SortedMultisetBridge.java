package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.SortedSet;

@GwtIncompatible
interface SortedMultisetBridge<E> extends Multiset<E> {
  SortedSet<E> elementSet();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\SortedMultisetBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */