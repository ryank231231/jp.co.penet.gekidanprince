package io.reactivex.internal.util;

public final class OpenHashSet<T> {
  private static final int INT_PHI = -1640531527;
  
  T[] keys;
  
  final float loadFactor;
  
  int mask;
  
  int maxSize;
  
  int size;
  
  public OpenHashSet() {
    this(16, 0.75F);
  }
  
  public OpenHashSet(int paramInt) {
    this(paramInt, 0.75F);
  }
  
  public OpenHashSet(int paramInt, float paramFloat) {
    this.loadFactor = paramFloat;
    paramInt = Pow2.roundToPowerOfTwo(paramInt);
    this.mask = paramInt - 1;
    this.maxSize = (int)(paramFloat * paramInt);
    this.keys = (T[])new Object[paramInt];
  }
  
  static int mix(int paramInt) {
    paramInt *= -1640531527;
    return paramInt ^ paramInt >>> 16;
  }
  
  public boolean add(T paramT) {
    T[] arrayOfT = this.keys;
    int i = this.mask;
    int j = mix(paramT.hashCode()) & i;
    T t = arrayOfT[j];
    int k = j;
    if (t != null) {
      k = j;
      if (t.equals(paramT))
        return false; 
      while (true) {
        k = k + 1 & i;
        t = arrayOfT[k];
        if (t == null)
          break; 
        if (t.equals(paramT))
          return false; 
      } 
    } 
    arrayOfT[k] = paramT;
    k = this.size + 1;
    this.size = k;
    if (k >= this.maxSize)
      rehash(); 
    return true;
  }
  
  public Object[] keys() {
    return (Object[])this.keys;
  }
  
  void rehash() {
    T[] arrayOfT = this.keys;
    int i = arrayOfT.length;
    int j = i << 1;
    int k = j - 1;
    Object[] arrayOfObject = new Object[j];
    for (int m = this.size; m != 0; m--) {
      int n;
      while (true) {
        if (arrayOfT[--i] == null)
          continue; 
        int i1 = mix(arrayOfT[i].hashCode()) & k;
        n = i1;
        if (arrayOfObject[i1] != null) {
          n = i1;
          while (true) {
            i1 = n + 1 & k;
            n = i1;
            if (arrayOfObject[i1] == null) {
              n = i1;
              break;
            } 
          } 
        } 
        break;
      } 
      arrayOfObject[n] = arrayOfT[i];
    } 
    this.mask = k;
    this.maxSize = (int)(j * this.loadFactor);
    this.keys = (T[])arrayOfObject;
  }
  
  public boolean remove(T paramT) {
    T[] arrayOfT = this.keys;
    int i = this.mask;
    int j = mix(paramT.hashCode()) & i;
    T t = arrayOfT[j];
    if (t == null)
      return false; 
    int k = j;
    if (t.equals(paramT))
      return removeEntry(j, arrayOfT, i); 
    while (true) {
      j = k + 1 & i;
      t = arrayOfT[j];
      if (t == null)
        return false; 
      k = j;
      if (t.equals(paramT))
        return removeEntry(j, arrayOfT, i); 
    } 
  }
  
  boolean removeEntry(int paramInt1, T[] paramArrayOfT, int paramInt2) {
    this.size--;
    int i = paramInt1;
    label19: while (true) {
      for (paramInt1 = i + 1 & paramInt2;; paramInt1 = paramInt1 + 1 & paramInt2) {
        T t = paramArrayOfT[paramInt1];
        if (t == null) {
          paramArrayOfT[i] = null;
          return true;
        } 
        int j = mix(t.hashCode()) & paramInt2;
        if ((i <= paramInt1) ? (i >= j || j > paramInt1) : (i >= j && j > paramInt1)) {
          paramArrayOfT[i] = t;
          i = paramInt1;
          continue label19;
        } 
      } 
      break;
    } 
  }
  
  public int size() {
    return this.size;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\interna\\util\OpenHashSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */