package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(serializable = true)
class EmptyImmutableListMultimap extends ImmutableListMultimap<Object, Object> {
  static final EmptyImmutableListMultimap INSTANCE = new EmptyImmutableListMultimap();
  
  private static final long serialVersionUID = 0L;
  
  private EmptyImmutableListMultimap() {
    super(ImmutableMap.of(), 0);
  }
  
  private Object readResolve() {
    return INSTANCE;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\EmptyImmutableListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */