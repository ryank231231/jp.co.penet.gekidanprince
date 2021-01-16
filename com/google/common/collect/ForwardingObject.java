package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public abstract class ForwardingObject {
  protected abstract Object delegate();
  
  public String toString() {
    return delegate().toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ForwardingObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */