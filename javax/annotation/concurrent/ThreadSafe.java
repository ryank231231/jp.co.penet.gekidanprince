package javax.annotation.concurrent;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE})
public @interface ThreadSafe {}


/* Location:              Y:\classes-dex2jar.jar!\javax\annotation\concurrent\ThreadSafe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */