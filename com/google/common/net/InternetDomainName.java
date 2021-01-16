package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;
import java.util.List;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public final class InternetDomainName {
  private static final CharMatcher DASH_MATCHER;
  
  private static final CharMatcher DOTS_MATCHER = CharMatcher.anyOf(".。．｡");
  
  private static final Joiner DOT_JOINER;
  
  private static final String DOT_REGEX = "\\.";
  
  private static final Splitter DOT_SPLITTER = Splitter.on('.');
  
  private static final int MAX_DOMAIN_PART_LENGTH = 63;
  
  private static final int MAX_LENGTH = 253;
  
  private static final int MAX_PARTS = 127;
  
  private static final int NO_PUBLIC_SUFFIX_FOUND = -1;
  
  private static final CharMatcher PART_CHAR_MATCHER;
  
  private final String name;
  
  private final ImmutableList<String> parts;
  
  private final int publicSuffixIndex;
  
  static {
    DOT_JOINER = Joiner.on('.');
    DASH_MATCHER = CharMatcher.anyOf("-_");
    PART_CHAR_MATCHER = CharMatcher.javaLetterOrDigit().or(DASH_MATCHER);
  }
  
  InternetDomainName(String paramString) {
    String str = Ascii.toLowerCase(DOTS_MATCHER.replaceFrom(paramString, '.'));
    boolean bool = str.endsWith(".");
    boolean bool1 = true;
    paramString = str;
    if (bool)
      paramString = str.substring(0, str.length() - 1); 
    if (paramString.length() <= 253) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Domain name too long: '%s':", paramString);
    this.name = paramString;
    this.parts = ImmutableList.copyOf(DOT_SPLITTER.split(paramString));
    if (this.parts.size() <= 127) {
      bool = bool1;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Domain has too many parts: '%s'", paramString);
    Preconditions.checkArgument(validateSyntax((List<String>)this.parts), "Not a valid domain name: '%s'", paramString);
    this.publicSuffixIndex = findPublicSuffix();
  }
  
  private InternetDomainName ancestor(int paramInt) {
    Joiner joiner = DOT_JOINER;
    ImmutableList<String> immutableList = this.parts;
    return from(joiner.join((Iterable)immutableList.subList(paramInt, immutableList.size())));
  }
  
  private int findPublicSuffix() {
    int i = this.parts.size();
    for (byte b = 0; b < i; b++) {
      String str = DOT_JOINER.join((Iterable)this.parts.subList(b, i));
      if (PublicSuffixPatterns.EXACT.containsKey(str))
        return b; 
      if (PublicSuffixPatterns.EXCLUDED.containsKey(str))
        return b + 1; 
      if (matchesWildcardPublicSuffix(str))
        return b; 
    } 
    return -1;
  }
  
  public static InternetDomainName from(String paramString) {
    return new InternetDomainName((String)Preconditions.checkNotNull(paramString));
  }
  
  public static boolean isValid(String paramString) {
    try {
      from(paramString);
      return true;
    } catch (IllegalArgumentException illegalArgumentException) {
      return false;
    } 
  }
  
  private static boolean matchesWildcardPublicSuffix(String paramString) {
    String[] arrayOfString = paramString.split("\\.", 2);
    int i = arrayOfString.length;
    boolean bool = true;
    if (i != 2 || !PublicSuffixPatterns.UNDER.containsKey(arrayOfString[1]))
      bool = false; 
    return bool;
  }
  
  private static boolean validatePart(String paramString, boolean paramBoolean) {
    if (paramString.length() < 1 || paramString.length() > 63)
      return false; 
    String str = CharMatcher.ascii().retainFrom(paramString);
    return !PART_CHAR_MATCHER.matchesAllOf(str) ? false : ((DASH_MATCHER.matches(paramString.charAt(0)) || DASH_MATCHER.matches(paramString.charAt(paramString.length() - 1))) ? false : (!(paramBoolean && CharMatcher.digit().matches(paramString.charAt(0)))));
  }
  
  private static boolean validateSyntax(List<String> paramList) {
    int i = paramList.size() - 1;
    if (!validatePart(paramList.get(i), true))
      return false; 
    for (byte b = 0; b < i; b++) {
      if (!validatePart(paramList.get(b), false))
        return false; 
    } 
    return true;
  }
  
  public InternetDomainName child(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append((String)Preconditions.checkNotNull(paramString));
    stringBuilder.append(".");
    stringBuilder.append(this.name);
    return from(stringBuilder.toString());
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof InternetDomainName) {
      paramObject = paramObject;
      return this.name.equals(((InternetDomainName)paramObject).name);
    } 
    return false;
  }
  
  public boolean hasParent() {
    int i = this.parts.size();
    boolean bool = true;
    if (i <= 1)
      bool = false; 
    return bool;
  }
  
  public boolean hasPublicSuffix() {
    boolean bool;
    if (this.publicSuffixIndex != -1) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public int hashCode() {
    return this.name.hashCode();
  }
  
  public boolean isPublicSuffix() {
    boolean bool;
    if (this.publicSuffixIndex == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isTopPrivateDomain() {
    int i = this.publicSuffixIndex;
    boolean bool = true;
    if (i != 1)
      bool = false; 
    return bool;
  }
  
  public boolean isUnderPublicSuffix() {
    boolean bool;
    if (this.publicSuffixIndex > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public InternetDomainName parent() {
    Preconditions.checkState(hasParent(), "Domain '%s' has no parent", this.name);
    return ancestor(1);
  }
  
  public ImmutableList<String> parts() {
    return this.parts;
  }
  
  public InternetDomainName publicSuffix() {
    InternetDomainName internetDomainName;
    if (hasPublicSuffix()) {
      internetDomainName = ancestor(this.publicSuffixIndex);
    } else {
      internetDomainName = null;
    } 
    return internetDomainName;
  }
  
  public String toString() {
    return this.name;
  }
  
  public InternetDomainName topPrivateDomain() {
    if (isTopPrivateDomain())
      return this; 
    Preconditions.checkState(isUnderPublicSuffix(), "Not under a public suffix: %s", this.name);
    return ancestor(this.publicSuffixIndex - 1);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\net\InternetDomainName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */