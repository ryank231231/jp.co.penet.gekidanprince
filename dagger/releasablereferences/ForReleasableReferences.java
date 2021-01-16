package dagger.releasablereferences;

import dagger.internal.GwtIncompatible;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Qualifier
@GwtIncompatible
public @interface ForReleasableReferences {
  Class<? extends Annotation> value();
}


/* Location:              Y:\classes-dex2jar.jar!\dagger\releasablereferences\ForReleasableReferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */