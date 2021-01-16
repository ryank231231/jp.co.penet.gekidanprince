package com.google.firebase.annotations;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@KeepForSdk
public @interface PublicApi {}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\annotations\PublicApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */