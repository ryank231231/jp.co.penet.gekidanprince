package io.opencensus.trace.export;

import io.opencensus.trace.Status;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_SampledSpanStore_ErrorFilter extends SampledSpanStore.ErrorFilter {
  private final Status.CanonicalCode canonicalCode;
  
  private final int maxSpansToReturn;
  
  private final String spanName;
  
  AutoValue_SampledSpanStore_ErrorFilter(String paramString, @Nullable Status.CanonicalCode paramCanonicalCode, int paramInt) {
    if (paramString != null) {
      this.spanName = paramString;
      this.canonicalCode = paramCanonicalCode;
      this.maxSpansToReturn = paramInt;
      return;
    } 
    throw new NullPointerException("Null spanName");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof SampledSpanStore.ErrorFilter) {
      paramObject = paramObject;
      if (this.spanName.equals(paramObject.getSpanName())) {
        Status.CanonicalCode canonicalCode = this.canonicalCode;
        if (((canonicalCode == null) ? (paramObject.getCanonicalCode() == null) : canonicalCode.equals(paramObject.getCanonicalCode())) && this.maxSpansToReturn == paramObject.getMaxSpansToReturn())
          return bool; 
      } 
      return false;
    } 
    return false;
  }
  
  @Nullable
  public Status.CanonicalCode getCanonicalCode() {
    return this.canonicalCode;
  }
  
  public int getMaxSpansToReturn() {
    return this.maxSpansToReturn;
  }
  
  public String getSpanName() {
    return this.spanName;
  }
  
  public int hashCode() {
    int j;
    int i = this.spanName.hashCode();
    Status.CanonicalCode canonicalCode = this.canonicalCode;
    if (canonicalCode == null) {
      j = 0;
    } else {
      j = canonicalCode.hashCode();
    } 
    return ((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ this.maxSpansToReturn;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ErrorFilter{spanName=");
    stringBuilder.append(this.spanName);
    stringBuilder.append(", canonicalCode=");
    stringBuilder.append(this.canonicalCode);
    stringBuilder.append(", maxSpansToReturn=");
    stringBuilder.append(this.maxSpansToReturn);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\AutoValue_SampledSpanStore_ErrorFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */