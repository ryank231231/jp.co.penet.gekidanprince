package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;

@GwtIncompatible
interface PatternCompiler {
  CommonPattern compile(String paramString);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\PatternCompiler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */