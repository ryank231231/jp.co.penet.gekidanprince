package com.google.common.xml;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

@Beta
@GwtCompatible
public class XmlEscapers {
  private static final char MAX_ASCII_CONTROL_CHAR = '\037';
  
  private static final char MIN_ASCII_CONTROL_CHAR = '\000';
  
  private static final Escaper XML_ATTRIBUTE_ESCAPER;
  
  private static final Escaper XML_CONTENT_ESCAPER;
  
  private static final Escaper XML_ESCAPER;
  
  static {
    Escapers.Builder builder = Escapers.builder();
    char c1 = Character.MIN_VALUE;
    builder.setSafeRange(false, '�');
    builder.setUnsafeReplacement("�");
    for (char c2 = c1; c2 <= '\037'; c2 = c1) {
      if (c2 != '\t' && c2 != '\n' && c2 != '\r')
        builder.addEscape(c2, "�"); 
      c1 = (char)(c2 + 1);
    } 
    builder.addEscape('&', "&amp;");
    builder.addEscape('<', "&lt;");
    builder.addEscape('>', "&gt;");
    XML_CONTENT_ESCAPER = builder.build();
    builder.addEscape('\'', "&apos;");
    builder.addEscape('"', "&quot;");
    XML_ESCAPER = builder.build();
    builder.addEscape('\t', "&#x9;");
    builder.addEscape('\n', "&#xA;");
    builder.addEscape('\r', "&#xD;");
    XML_ATTRIBUTE_ESCAPER = builder.build();
  }
  
  public static Escaper xmlAttributeEscaper() {
    return XML_ATTRIBUTE_ESCAPER;
  }
  
  public static Escaper xmlContentEscaper() {
    return XML_CONTENT_ESCAPER;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\xml\XmlEscapers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */