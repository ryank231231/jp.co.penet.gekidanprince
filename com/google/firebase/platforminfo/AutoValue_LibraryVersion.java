package com.google.firebase.platforminfo;

import javax.annotation.Nonnull;

final class AutoValue_LibraryVersion extends LibraryVersion {
  private final String libraryName;
  
  private final String version;
  
  AutoValue_LibraryVersion(String paramString1, String paramString2) {
    if (paramString1 != null) {
      this.libraryName = paramString1;
      if (paramString2 != null) {
        this.version = paramString2;
        return;
      } 
      throw new NullPointerException("Null version");
    } 
    throw new NullPointerException("Null libraryName");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof LibraryVersion) {
      paramObject = paramObject;
      if (!this.libraryName.equals(paramObject.getLibraryName()) || !this.version.equals(paramObject.getVersion()))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  @Nonnull
  public String getLibraryName() {
    return this.libraryName;
  }
  
  @Nonnull
  public String getVersion() {
    return this.version;
  }
  
  public int hashCode() {
    return (this.libraryName.hashCode() ^ 0xF4243) * 1000003 ^ this.version.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LibraryVersion{libraryName=");
    stringBuilder.append(this.libraryName);
    stringBuilder.append(", version=");
    stringBuilder.append(this.version);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\platforminfo\AutoValue_LibraryVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */