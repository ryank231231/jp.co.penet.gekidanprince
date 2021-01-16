package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Untainted(when = When.ALWAYS)
@TypeQualifierNickname
public @interface Detainted {}


/* Location:              Y:\classes-dex2jar.jar!\javax\annotation\Detainted.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */