package com.google.errorprone.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Immutable {
  String[] containerOf() default {};
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\errorprone\annotations\Immutable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */