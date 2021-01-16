package com.google.errorprone.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.lang.model.element.Modifier;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
@IncompatibleModifiers({Modifier.PUBLIC, Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL})
public @interface ForOverride {}


/* Location:              Y:\classes-dex2jar.jar!\com\google\errorprone\annotations\ForOverride.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */