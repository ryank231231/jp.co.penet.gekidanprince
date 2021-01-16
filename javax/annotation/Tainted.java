package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Untainted(when = When.MAYBE)
@TypeQualifierNickname
public @interface Tainted {}


/* Location:              Y:\classes-dex2jar.jar!\javax\annotation\Tainted.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */