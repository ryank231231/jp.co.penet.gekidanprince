package com.google.errorprone.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.PARAMETER})
public @interface CompatibleWith {
  String value();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\errorprone\annotations\CompatibleWith.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */