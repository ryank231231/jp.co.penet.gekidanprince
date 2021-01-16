package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Nonnegative(when = When.MAYBE)
@TypeQualifierNickname
public @interface CheckForSigned {}


/* Location:              Y:\classes-dex2jar.jar!\javax\annotation\CheckForSigned.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */