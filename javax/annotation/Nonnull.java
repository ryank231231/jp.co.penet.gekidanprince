package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@TypeQualifier
public @interface Nonnull {
  When when() default When.ALWAYS;
  
  class Nonnull {}
}


/* Location:              Y:\classes-dex2jar.jar!\javax\annotation\Nonnull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */