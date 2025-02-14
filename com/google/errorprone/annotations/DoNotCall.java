package com.google.errorprone.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
public @interface DoNotCall {
  String value() default "";
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\errorprone\annotations\DoNotCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */