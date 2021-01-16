package dagger.android;

final class AutoAnnotation_ReleaseReferencesAtCreator_createReleaseReferencesAt implements ReleaseReferencesAt {
  private final int value;
  
  AutoAnnotation_ReleaseReferencesAtCreator_createReleaseReferencesAt(int paramInt) {
    this.value = paramInt;
  }
  
  public Class<? extends ReleaseReferencesAt> annotationType() {
    return ReleaseReferencesAt.class;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof ReleaseReferencesAt) {
      paramObject = paramObject;
      if (this.value != paramObject.value())
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public int hashCode() {
    return this.value ^ 0x4F9C270F;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("@dagger.android.ReleaseReferencesAt(");
    stringBuilder.append(this.value);
    stringBuilder.append(')');
    return stringBuilder.toString();
  }
  
  public int value() {
    return this.value;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\AutoAnnotation_ReleaseReferencesAtCreator_createReleaseReferencesAt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */