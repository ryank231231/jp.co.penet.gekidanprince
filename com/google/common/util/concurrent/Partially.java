package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@GwtCompatible
final class Partially {
  @Documented
  @Retention(RetentionPolicy.CLASS)
  @Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
  static @interface GwtIncompatible {
    String value();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\Partially.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */