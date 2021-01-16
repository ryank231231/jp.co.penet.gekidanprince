package com.google.firebase.platforminfo;

import com.google.auto.value.AutoValue;
import javax.annotation.Nonnull;

@AutoValue
abstract class LibraryVersion {
  static LibraryVersion create(String paramString1, String paramString2) {
    return new AutoValue_LibraryVersion(paramString1, paramString2);
  }
  
  @Nonnull
  public abstract String getLibraryName();
  
  @Nonnull
  public abstract String getVersion();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\platforminfo\LibraryVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */