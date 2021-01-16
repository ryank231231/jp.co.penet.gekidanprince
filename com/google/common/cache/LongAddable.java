package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
interface LongAddable {
  void add(long paramLong);
  
  void increment();
  
  long sum();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\cache\LongAddable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */