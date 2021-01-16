package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.PACKAGE})
public @interface CheckReturnValue {
  When when() default When.ALWAYS;
}


/* Location:              Y:\classes-dex2jar.jar!\javax\annotation\CheckReturnValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */