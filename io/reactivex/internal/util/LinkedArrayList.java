package io.reactivex.internal.util;

import java.util.ArrayList;

public class LinkedArrayList {
  final int capacityHint;
  
  Object[] head;
  
  int indexInTail;
  
  volatile int size;
  
  Object[] tail;
  
  public LinkedArrayList(int paramInt) {
    this.capacityHint = paramInt;
  }
  
  public void add(Object paramObject) {
    if (this.size == 0) {
      this.head = new Object[this.capacityHint + 1];
      Object[] arrayOfObject = this.head;
      this.tail = arrayOfObject;
      arrayOfObject[0] = paramObject;
      this.indexInTail = 1;
      this.size = 1;
    } else {
      int i = this.indexInTail;
      int j = this.capacityHint;
      if (i == j) {
        Object[] arrayOfObject = new Object[j + 1];
        arrayOfObject[0] = paramObject;
        this.tail[j] = arrayOfObject;
        this.tail = arrayOfObject;
        this.indexInTail = 1;
        this.size++;
      } else {
        this.tail[i] = paramObject;
        this.indexInTail = i + 1;
        this.size++;
      } 
    } 
  }
  
  public Object[] head() {
    return this.head;
  }
  
  public int size() {
    return this.size;
  }
  
  public String toString() {
    int i = this.capacityHint;
    int j = this.size;
    ArrayList<Object> arrayList = new ArrayList(j + 1);
    Object[] arrayOfObject = head();
    int k = 0;
    int m = 0;
    while (k < j) {
      arrayList.add(arrayOfObject[m]);
      int n = k + 1;
      int i1 = m + 1;
      k = n;
      m = i1;
      if (i1 == i) {
        arrayOfObject = (Object[])arrayOfObject[i];
        m = 0;
        k = n;
      } 
    } 
    return arrayList.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\interna\\util\LinkedArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */