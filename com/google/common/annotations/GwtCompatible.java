package com.google.common.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.METHOD})
@GwtCompatible
public @interface GwtCompatible {
  boolean emulated() default false;
  
  boolean serializable() default false;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\annotations\GwtCompatible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */