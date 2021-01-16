package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@TypeQualifier(applicableTo = Number.class)
public @interface Nonnegative {
  When when() default When.ALWAYS;
  
  class Nonnegative {}
}


/* Location:              Y:\classes-dex2jar.jar!\javax\annotation\Nonnegative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */