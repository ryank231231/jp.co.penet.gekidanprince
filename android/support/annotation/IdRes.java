package android.support.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE})
public @interface IdRes {}


/* Location:              Y:\classes-dex2jar.jar!\android\support\annotation\IdRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */