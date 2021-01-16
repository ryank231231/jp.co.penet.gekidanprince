package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
public enum CaseFormat {
  LOWER_CAMEL,
  LOWER_HYPHEN(CharMatcher.is('-'), "-") {
    String convert(CaseFormat param1CaseFormat, String param1String) {
      return (param1CaseFormat == LOWER_UNDERSCORE) ? param1String.replace('-', '_') : ((param1CaseFormat == UPPER_UNDERSCORE) ? Ascii.toUpperCase(param1String.replace('-', '_')) : super.convert(param1CaseFormat, param1String));
    }
    
    String normalizeWord(String param1String) {
      return Ascii.toLowerCase(param1String);
    }
  },
  LOWER_UNDERSCORE(CharMatcher.is('_'), "_") {
    String convert(CaseFormat param1CaseFormat, String param1String) {
      return (param1CaseFormat == LOWER_HYPHEN) ? param1String.replace('_', '-') : ((param1CaseFormat == UPPER_UNDERSCORE) ? Ascii.toUpperCase(param1String) : super.convert(param1CaseFormat, param1String));
    }
    
    String normalizeWord(String param1String) {
      return Ascii.toLowerCase(param1String);
    }
  },
  UPPER_CAMEL(CharMatcher.is('_'), "_"),
  UPPER_UNDERSCORE(CharMatcher.is('_'), "_");
  
  private final CharMatcher wordBoundary;
  
  private final String wordSeparator;
  
  static {
    LOWER_CAMEL = new null("LOWER_CAMEL", 2, CharMatcher.inRange('A', 'Z'), "");
    UPPER_CAMEL = new null("UPPER_CAMEL", 3, CharMatcher.inRange('A', 'Z'), "");
    UPPER_UNDERSCORE = new null("UPPER_UNDERSCORE", 4, CharMatcher.is('_'), "_");
    $VALUES = new CaseFormat[] { LOWER_HYPHEN, LOWER_UNDERSCORE, LOWER_CAMEL, UPPER_CAMEL, UPPER_UNDERSCORE };
  }
  
  CaseFormat(CharMatcher paramCharMatcher, String paramString1) {
    this.wordBoundary = paramCharMatcher;
    this.wordSeparator = paramString1;
  }
  
  private static String firstCharOnlyToUpper(String paramString) {
    if (!paramString.isEmpty()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Ascii.toUpperCase(paramString.charAt(0)));
      stringBuilder.append(Ascii.toLowerCase(paramString.substring(1)));
      paramString = stringBuilder.toString();
    } 
    return paramString;
  }
  
  private String normalizeFirstWord(String paramString) {
    if (this == LOWER_CAMEL) {
      paramString = Ascii.toLowerCase(paramString);
    } else {
      paramString = normalizeWord(paramString);
    } 
    return paramString;
  }
  
  String convert(CaseFormat paramCaseFormat, String paramString) {
    int i = 0;
    StringBuilder stringBuilder = null;
    int j = -1;
    while (true) {
      String str;
      j = this.wordBoundary.indexIn(paramString, j + 1);
      if (j != -1) {
        if (!i) {
          stringBuilder = new StringBuilder(paramString.length() + this.wordSeparator.length() * 4);
          stringBuilder.append(paramCaseFormat.normalizeFirstWord(paramString.substring(i, j)));
        } else {
          stringBuilder.append(paramCaseFormat.normalizeWord(paramString.substring(i, j)));
        } 
        stringBuilder.append(paramCaseFormat.wordSeparator);
        i = this.wordSeparator.length() + j;
        continue;
      } 
      if (i == 0) {
        str = paramCaseFormat.normalizeFirstWord(paramString);
      } else {
        stringBuilder.append(str.normalizeWord(paramString.substring(i)));
        str = stringBuilder.toString();
      } 
      return str;
    } 
  }
  
  public Converter<String, String> converterTo(CaseFormat paramCaseFormat) {
    return new StringConverter(this, paramCaseFormat);
  }
  
  abstract String normalizeWord(String paramString);
  
  public final String to(CaseFormat paramCaseFormat, String paramString) {
    Preconditions.checkNotNull(paramCaseFormat);
    Preconditions.checkNotNull(paramString);
    if (paramCaseFormat != this)
      paramString = convert(paramCaseFormat, paramString); 
    return paramString;
  }
  
  private static final class StringConverter extends Converter<String, String> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private final CaseFormat sourceFormat;
    
    private final CaseFormat targetFormat;
    
    StringConverter(CaseFormat param1CaseFormat1, CaseFormat param1CaseFormat2) {
      this.sourceFormat = Preconditions.<CaseFormat>checkNotNull(param1CaseFormat1);
      this.targetFormat = Preconditions.<CaseFormat>checkNotNull(param1CaseFormat2);
    }
    
    protected String doBackward(String param1String) {
      return this.targetFormat.to(this.sourceFormat, param1String);
    }
    
    protected String doForward(String param1String) {
      return this.sourceFormat.to(this.targetFormat, param1String);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof StringConverter;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (this.sourceFormat.equals(((StringConverter)param1Object).sourceFormat)) {
          bool = bool1;
          if (this.targetFormat.equals(((StringConverter)param1Object).targetFormat))
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public int hashCode() {
      return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.sourceFormat);
      stringBuilder.append(".converterTo(");
      stringBuilder.append(this.targetFormat);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\CaseFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */