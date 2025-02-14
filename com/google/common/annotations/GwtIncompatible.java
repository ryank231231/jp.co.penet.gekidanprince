package com.google.common.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@GwtCompatible
public @interface GwtIncompatible {
  String value() default "";
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\annotations\GwtIncompatible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */