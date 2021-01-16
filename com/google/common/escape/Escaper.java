package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;

@GwtCompatible
public abstract class Escaper {
  private final Function<String, String> asFunction = new Function<String, String>() {
      public String apply(String param1String) {
        return Escaper.this.escape(param1String);
      }
    };
  
  public final Function<String, String> asFunction() {
    return this.asFunction;
  }
  
  public abstract String escape(String paramString);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\escape\Escaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */