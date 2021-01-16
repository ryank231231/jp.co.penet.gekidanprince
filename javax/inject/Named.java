package javax.inject;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Named {
  String value() default "";
}


/* Location:              Y:\classes-dex2jar.jar!\javax\inject\Named.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */