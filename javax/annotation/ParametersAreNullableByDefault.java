package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierDefault;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Nullable
@TypeQualifierDefault({ElementType.PARAMETER})
public @interface ParametersAreNullableByDefault {}


/* Location:              Y:\classes-dex2jar.jar!\javax\annotation\ParametersAreNullableByDefault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */