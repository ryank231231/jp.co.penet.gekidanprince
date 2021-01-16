package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@TypeQualifier(applicableTo = String.class)
public @interface MatchesPattern {
  int flags() default 0;
  
  @RegEx
  String value();
  
  class MatchesPattern {}
}


/* Location:              Y:\classes-dex2jar.jar!\javax\annotation\MatchesPattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */