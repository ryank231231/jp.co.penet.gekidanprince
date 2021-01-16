package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
final class Count implements Serializable {
  private int value;
  
  Count(int paramInt) {
    this.value = paramInt;
  }
  
  public void add(int paramInt) {
    this.value += paramInt;
  }
  
  public int addAndGet(int paramInt) {
    paramInt = this.value + paramInt;
    this.value = paramInt;
    return paramInt;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool;
    if (paramObject instanceof Count && ((Count)paramObject).value == this.value) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public int get() {
    return this.value;
  }
  
  public int getAndSet(int paramInt) {
    int i = this.value;
    this.value = paramInt;
    return i;
  }
  
  public int hashCode() {
    return this.value;
  }
  
  public void set(int paramInt) {
    this.value = paramInt;
  }
  
  public String toString() {
    return Integer.toString(this.value);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Count.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */