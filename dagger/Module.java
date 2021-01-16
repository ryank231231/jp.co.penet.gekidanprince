package dagger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Module {
  Class<?>[] includes() default {};
  
  Class<?>[] subcomponents() default {};
}


/* Location:              Y:\classes-dex2jar.jar!\dagger\Module.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */