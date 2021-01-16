package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface OverridingMethodsMustInvokeSuper {}


/* Location:              Y:\classes-dex2jar.jar!\javax\annotation\OverridingMethodsMustInvokeSuper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */