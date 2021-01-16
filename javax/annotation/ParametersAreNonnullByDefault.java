package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierDefault;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Nonnull
@TypeQualifierDefault({ElementType.PARAMETER})
public @interface ParametersAreNonnullByDefault {}


/* Location:              Y:\classes-dex2jar.jar!\javax\annotation\ParametersAreNonnullByDefault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */