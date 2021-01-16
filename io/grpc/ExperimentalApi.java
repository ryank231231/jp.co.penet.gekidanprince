package io.grpc;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PACKAGE, ElementType.TYPE})
public @interface ExperimentalApi {
  String value() default "";
}


/* Location:              Y:\classes-dex2jar.jar!\io\grpc\ExperimentalApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */