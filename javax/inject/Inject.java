package javax.inject;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
public @interface Inject {}


/* Location:              Y:\classes-dex2jar.jar!\javax\inject\Inject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */