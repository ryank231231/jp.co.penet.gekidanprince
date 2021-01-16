package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public final class PatternFilenameFilter implements FilenameFilter {
  private final Pattern pattern;
  
  public PatternFilenameFilter(String paramString) {
    this(Pattern.compile(paramString));
  }
  
  public PatternFilenameFilter(Pattern paramPattern) {
    this.pattern = (Pattern)Preconditions.checkNotNull(paramPattern);
  }
  
  public boolean accept(@Nullable File paramFile, String paramString) {
    return this.pattern.matcher(paramString).matches();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\PatternFilenameFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */