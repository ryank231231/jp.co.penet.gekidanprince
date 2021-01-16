package dagger.android;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
public @interface ContributesAndroidInjector {
  Class<?>[] modules() default {};
}


/* Location:              Y:\classes-dex2jar.jar!\dagger\android\ContributesAndroidInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */