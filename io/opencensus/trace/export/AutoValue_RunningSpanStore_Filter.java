package io.opencensus.trace.export;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_RunningSpanStore_Filter extends RunningSpanStore.Filter {
  private final int maxSpansToReturn;
  
  private final String spanName;
  
  AutoValue_RunningSpanStore_Filter(String paramString, int paramInt) {
    if (paramString != null) {
      this.spanName = paramString;
      this.maxSpansToReturn = paramInt;
      return;
    } 
    throw new NullPointerException("Null spanName");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof RunningSpanStore.Filter) {
      paramObject = paramObject;
      if (!this.spanName.equals(paramObject.getSpanName()) || this.maxSpansToReturn != paramObject.getMaxSpansToReturn())
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public int getMaxSpansToReturn() {
    return this.maxSpansToReturn;
  }
  
  public String getSpanName() {
    return this.spanName;
  }
  
  public int hashCode() {
    return (this.spanName.hashCode() ^ 0xF4243) * 1000003 ^ this.maxSpansToReturn;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Filter{spanName=");
    stringBuilder.append(this.spanName);
    stringBuilder.append(", maxSpansToReturn=");
    stringBuilder.append(this.maxSpansToReturn);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\AutoValue_RunningSpanStore_Filter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */