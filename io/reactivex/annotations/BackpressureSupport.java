package io.reactivex.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface BackpressureSupport {
  BackpressureKind value();
}


/* Location:              Y:\classes-dex2jar.jar!\io\reactivex\annotations\BackpressureSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */