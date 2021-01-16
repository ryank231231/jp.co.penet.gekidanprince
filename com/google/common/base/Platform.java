package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class Platform {
  private static final Logger logger = Logger.getLogger(Platform.class.getName());
  
  private static final PatternCompiler patternCompiler = loadPatternCompiler();
  
  static CommonPattern compilePattern(String paramString) {
    Preconditions.checkNotNull(paramString);
    return patternCompiler.compile(paramString);
  }
  
  static String formatCompact4Digits(double paramDouble) {
    return String.format(Locale.ROOT, "%.4g", new Object[] { Double.valueOf(paramDouble) });
  }
  
  static <T extends Enum<T>> Optional<T> getEnumIfPresent(Class<T> paramClass, String paramString) {
    Optional<?> optional;
    WeakReference weakReference = Enums.<T>getEnumConstants(paramClass).get(paramString);
    if (weakReference == null) {
      optional = Optional.absent();
    } else {
      optional = Optional.of(optional.cast(weakReference.get()));
    } 
    return (Optional)optional;
  }
  
  private static PatternCompiler loadPatternCompiler() {
    return new JdkPatternCompiler();
  }
  
  private static void logPatternCompilerError(ServiceConfigurationError paramServiceConfigurationError) {
    logger.log(Level.WARNING, "Error loading regex compiler, falling back to next option", paramServiceConfigurationError);
  }
  
  static CharMatcher precomputeCharMatcher(CharMatcher paramCharMatcher) {
    return paramCharMatcher.precomputedInternal();
  }
  
  static boolean stringIsNullOrEmpty(@Nullable String paramString) {
    return (paramString == null || paramString.isEmpty());
  }
  
  static long systemNanoTime() {
    return System.nanoTime();
  }
  
  static boolean usingJdkPatternCompiler() {
    return patternCompiler instanceof JdkPatternCompiler;
  }
  
  private static final class JdkPatternCompiler implements PatternCompiler {
    private JdkPatternCompiler() {}
    
    public CommonPattern compile(String param1String) {
      return new JdkPattern(Pattern.compile(param1String));
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */