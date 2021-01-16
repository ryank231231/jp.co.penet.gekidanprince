package com.google.auto.value;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE})
public @interface AutoValue {
  @Retention(RetentionPolicy.CLASS)
  @Target({ElementType.TYPE})
  public static @interface Builder {}
  
  @Retention(RetentionPolicy.CLASS)
  @Target({ElementType.TYPE, ElementType.METHOD})
  public static @interface CopyAnnotations {
    Class<? extends Annotation>[] exclude() default {};
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\auto\value\AutoValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */