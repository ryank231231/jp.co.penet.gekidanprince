package com.google.common.html;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

@Beta
@GwtCompatible
public final class HtmlEscapers {
  private static final Escaper HTML_ESCAPER = Escapers.builder().addEscape('"', "&quot;").addEscape('\'', "&#39;").addEscape('&', "&amp;").addEscape('<', "&lt;").addEscape('>', "&gt;").build();
  
  public static Escaper htmlEscaper() {
    return HTML_ESCAPER;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\html\HtmlEscapers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */