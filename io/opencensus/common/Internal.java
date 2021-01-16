package io.opencensus.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PACKAGE, ElementType.TYPE})
public @interface Internal {}


/* Location:              Y:\classes-dex2jar.jar!\io\opencensus\common\Internal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */