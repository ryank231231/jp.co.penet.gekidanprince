package com.google.errorprone.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.lang.model.element.Modifier;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
@IncompatibleModifiers({Modifier.FINAL})
public @interface Var {}


/* Location:              Y:\classes-dex2jar.jar!\com\google\errorprone\annotations\Var.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */