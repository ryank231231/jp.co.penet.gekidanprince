package dagger.multibindings;

import dagger.MapKey;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MapKey
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface LongKey {
  long value();
}


/* Location:              Y:\classes-dex2jar.jar!\dagger\multibindings\LongKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */