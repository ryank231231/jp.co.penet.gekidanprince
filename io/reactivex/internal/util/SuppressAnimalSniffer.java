package io.reactivex.internal.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE})
public @interface SuppressAnimalSniffer {}


/* Location:              Y:\classes-dex2jar.jar!\io\reactivex\interna\\util\SuppressAnimalSniffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */