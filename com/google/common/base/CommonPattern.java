package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
abstract class CommonPattern {
  public abstract boolean equals(Object paramObject);
  
  abstract int flags();
  
  public abstract int hashCode();
  
  abstract CommonMatcher matcher(CharSequence paramCharSequence);
  
  abstract String pattern();
  
  public abstract String toString();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\CommonPattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */