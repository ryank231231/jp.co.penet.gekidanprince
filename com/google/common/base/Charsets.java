package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.nio.charset.Charset;

@GwtCompatible(emulated = true)
public final class Charsets {
  @GwtIncompatible
  public static final Charset ISO_8859_1;
  
  @GwtIncompatible
  public static final Charset US_ASCII = Charset.forName("US-ASCII");
  
  @GwtIncompatible
  public static final Charset UTF_16;
  
  @GwtIncompatible
  public static final Charset UTF_16BE;
  
  @GwtIncompatible
  public static final Charset UTF_16LE;
  
  public static final Charset UTF_8;
  
  static {
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    UTF_8 = Charset.forName("UTF-8");
    UTF_16BE = Charset.forName("UTF-16BE");
    UTF_16LE = Charset.forName("UTF-16LE");
    UTF_16 = Charset.forName("UTF-16");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Charsets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */