package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@KeepForSdk
public @interface HideFirstParty {}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\HideFirstParty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */