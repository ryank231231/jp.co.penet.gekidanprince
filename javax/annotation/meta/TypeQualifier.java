package javax.annotation.meta;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE})
public @interface TypeQualifier {
  Class<?> applicableTo() default Object.class;
}


/* Location:              Y:\classes-dex2jar.jar!\javax\annotation\meta\TypeQualifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */