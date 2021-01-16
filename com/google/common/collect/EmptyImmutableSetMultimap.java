package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(serializable = true)
class EmptyImmutableSetMultimap extends ImmutableSetMultimap<Object, Object> {
  static final EmptyImmutableSetMultimap INSTANCE = new EmptyImmutableSetMultimap();
  
  private static final long serialVersionUID = 0L;
  
  private EmptyImmutableSetMultimap() {
    super(ImmutableMap.of(), 0, null);
  }
  
  private Object readResolve() {
    return INSTANCE;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\EmptyImmutableSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */