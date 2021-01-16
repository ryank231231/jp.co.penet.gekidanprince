package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@GwtIncompatible
final class JdkPattern extends CommonPattern implements Serializable {
  private static final long serialVersionUID = 0L;
  
  private final Pattern pattern;
  
  JdkPattern(Pattern paramPattern) {
    this.pattern = Preconditions.<Pattern>checkNotNull(paramPattern);
  }
  
  public boolean equals(Object paramObject) {
    return !(paramObject instanceof JdkPattern) ? false : this.pattern.equals(((JdkPattern)paramObject).pattern);
  }
  
  int flags() {
    return this.pattern.flags();
  }
  
  public int hashCode() {
    return this.pattern.hashCode();
  }
  
  CommonMatcher matcher(CharSequence paramCharSequence) {
    return new JdkMatcher(this.pattern.matcher(paramCharSequence));
  }
  
  String pattern() {
    return this.pattern.pattern();
  }
  
  public String toString() {
    return this.pattern.toString();
  }
  
  private static final class JdkMatcher extends CommonMatcher {
    final Matcher matcher;
    
    JdkMatcher(Matcher param1Matcher) {
      this.matcher = Preconditions.<Matcher>checkNotNull(param1Matcher);
    }
    
    int end() {
      return this.matcher.end();
    }
    
    boolean find() {
      return this.matcher.find();
    }
    
    boolean find(int param1Int) {
      return this.matcher.find(param1Int);
    }
    
    boolean matches() {
      return this.matcher.matches();
    }
    
    String replaceAll(String param1String) {
      return this.matcher.replaceAll(param1String);
    }
    
    int start() {
      return this.matcher.start();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\JdkPattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */