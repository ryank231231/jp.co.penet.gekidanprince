package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcelable;

public interface SafeParcelable extends Parcelable {
  public static final String NULL = "SAFE_PARCELABLE_NULL_STRING";
  
  public static @interface Class {
    String creator();
    
    boolean validate() default false;
  }
  
  public static @interface Constructor {}
  
  public static @interface Field {
    String defaultValue() default "SAFE_PARCELABLE_NULL_STRING";
    
    String defaultValueUnchecked() default "SAFE_PARCELABLE_NULL_STRING";
    
    String getter() default "SAFE_PARCELABLE_NULL_STRING";
    
    int id();
    
    String type() default "SAFE_PARCELABLE_NULL_STRING";
  }
  
  public static @interface Indicator {
    String getter() default "SAFE_PARCELABLE_NULL_STRING";
  }
  
  public static @interface Param {
    int id();
  }
  
  public static @interface Reserved {
    int[] value();
  }
  
  public static @interface VersionField {
    String getter() default "SAFE_PARCELABLE_NULL_STRING";
    
    int id();
    
    String type() default "SAFE_PARCELABLE_NULL_STRING";
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\safeparcel\SafeParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */