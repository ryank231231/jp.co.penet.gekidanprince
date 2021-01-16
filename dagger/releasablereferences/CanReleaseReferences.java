package dagger.releasablereferences;

import dagger.internal.GwtIncompatible;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.ANNOTATION_TYPE})
@GwtIncompatible
public @interface CanReleaseReferences {}


/* Location:              Y:\classes-dex2jar.jar!\dagger\releasablereferences\CanReleaseReferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */