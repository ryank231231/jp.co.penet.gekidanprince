package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
abstract class CommonMatcher {
  abstract int end();
  
  abstract boolean find();
  
  abstract boolean find(int paramInt);
  
  abstract boolean matches();
  
  abstract String replaceAll(String paramString);
  
  abstract int start();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\CommonMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */