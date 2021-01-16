package dagger.multibindings;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ElementsIntoSet {}


/* Location:              Y:\classes-dex2jar.jar!\dagger\multibindings\ElementsIntoSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */