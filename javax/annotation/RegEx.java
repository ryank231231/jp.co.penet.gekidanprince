package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Syntax("RegEx")
@TypeQualifierNickname
public @interface RegEx {
  When when() default When.ALWAYS;
  
  class RegEx {}
}


/* Location:              Y:\classes-dex2jar.jar!\javax\annotation\RegEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */