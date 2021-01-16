package com.google.gson.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface SerializedName {
  String[] alternate() default {};
  
  String value();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\gson\annotations\SerializedName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */