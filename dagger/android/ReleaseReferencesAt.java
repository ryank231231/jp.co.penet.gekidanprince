package dagger.android;

import dagger.internal.GwtIncompatible;
import dagger.releasablereferences.CanReleaseReferences;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.ANNOTATION_TYPE})
@GwtIncompatible
@CanReleaseReferences
public @interface ReleaseReferencesAt {
  int value();
}


/* Location:              Y:\classes-dex2jar.jar!\dagger\android\ReleaseReferencesAt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */