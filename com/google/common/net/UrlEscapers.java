package com.google.common.net;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;

@GwtCompatible
public final class UrlEscapers {
  private static final Escaper URL_FORM_PARAMETER_ESCAPER = (Escaper)new PercentEscaper("-_.*", true);
  
  static final String URL_FORM_PARAMETER_OTHER_SAFE_CHARS = "-_.*";
  
  private static final Escaper URL_FRAGMENT_ESCAPER;
  
  static final String URL_PATH_OTHER_SAFE_CHARS_LACKING_PLUS = "-._~!$'()*,;&=@:";
  
  private static final Escaper URL_PATH_SEGMENT_ESCAPER = (Escaper)new PercentEscaper("-._~!$'()*,;&=@:+", false);
  
  static {
    URL_FRAGMENT_ESCAPER = (Escaper)new PercentEscaper("-._~!$'()*,;&=@:+/?", false);
  }
  
  public static Escaper urlFormParameterEscaper() {
    return URL_FORM_PARAMETER_ESCAPER;
  }
  
  public static Escaper urlFragmentEscaper() {
    return URL_FRAGMENT_ESCAPER;
  }
  
  public static Escaper urlPathSegmentEscaper() {
    return URL_PATH_SEGMENT_ESCAPER;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\net\UrlEscapers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */