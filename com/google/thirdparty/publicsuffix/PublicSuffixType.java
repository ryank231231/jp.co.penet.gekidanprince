package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
enum PublicSuffixType {
  ICANN,
  PRIVATE(':', ',');
  
  private final char innerNodeCode;
  
  private final char leafNodeCode;
  
  static {
    ICANN = new PublicSuffixType("ICANN", 1, '!', '?');
    $VALUES = new PublicSuffixType[] { PRIVATE, ICANN };
  }
  
  PublicSuffixType(char paramChar1, char paramChar2) {
    this.innerNodeCode = (char)paramChar1;
    this.leafNodeCode = (char)paramChar2;
  }
  
  static PublicSuffixType fromCode(char paramChar) {
    for (PublicSuffixType publicSuffixType : values()) {
      if (publicSuffixType.getInnerNodeCode() == paramChar || publicSuffixType.getLeafNodeCode() == paramChar)
        return publicSuffixType; 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No enum corresponding to given code: ");
    stringBuilder.append(paramChar);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static PublicSuffixType fromIsPrivate(boolean paramBoolean) {
    PublicSuffixType publicSuffixType;
    if (paramBoolean) {
      publicSuffixType = PRIVATE;
    } else {
      publicSuffixType = ICANN;
    } 
    return publicSuffixType;
  }
  
  char getInnerNodeCode() {
    return this.innerNodeCode;
  }
  
  char getLeafNodeCode() {
    return this.leafNodeCode;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\thirdparty\publicsuffix\PublicSuffixType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */