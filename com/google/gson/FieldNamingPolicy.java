package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

public enum FieldNamingPolicy implements FieldNamingStrategy {
  IDENTITY {
    public String translateName(Field param1Field) {
      return param1Field.getName();
    }
  },
  LOWER_CASE_WITH_DASHES,
  LOWER_CASE_WITH_UNDERSCORES,
  UPPER_CAMEL_CASE {
    public String translateName(Field param1Field) {
      return null.upperCaseFirstLetter(param1Field.getName());
    }
  },
  UPPER_CAMEL_CASE_WITH_SPACES {
    public String translateName(Field param1Field) {
      return null.upperCaseFirstLetter(null.separateCamelCase(param1Field.getName(), " "));
    }
  };
  
  static {
    LOWER_CASE_WITH_UNDERSCORES = new null("LOWER_CASE_WITH_UNDERSCORES", 3);
    LOWER_CASE_WITH_DASHES = new null("LOWER_CASE_WITH_DASHES", 4);
    $VALUES = new FieldNamingPolicy[] { IDENTITY, UPPER_CAMEL_CASE, UPPER_CAMEL_CASE_WITH_SPACES, LOWER_CASE_WITH_UNDERSCORES, LOWER_CASE_WITH_DASHES };
  }
  
  private static String modifyString(char paramChar, String paramString, int paramInt) {
    if (paramInt < paramString.length()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramChar);
      stringBuilder.append(paramString.substring(paramInt));
      paramString = stringBuilder.toString();
    } else {
      paramString = String.valueOf(paramChar);
    } 
    return paramString;
  }
  
  static String separateCamelCase(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < paramString1.length(); b++) {
      char c = paramString1.charAt(b);
      if (Character.isUpperCase(c) && stringBuilder.length() != 0)
        stringBuilder.append(paramString2); 
      stringBuilder.append(c);
    } 
    return stringBuilder.toString();
  }
  
  static String upperCaseFirstLetter(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    byte b = 0;
    char c = paramString.charAt(0);
    char c1;
    for (c1 = c; b < paramString.length() - 1 && !Character.isLetter(c1); c1 = c) {
      stringBuilder.append(c1);
      c = paramString.charAt(++b);
    } 
    if (b == paramString.length())
      return stringBuilder.toString(); 
    if (!Character.isUpperCase(c1)) {
      stringBuilder.append(modifyString(Character.toUpperCase(c1), paramString, b + 1));
      return stringBuilder.toString();
    } 
    return paramString;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\gson\FieldNamingPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */