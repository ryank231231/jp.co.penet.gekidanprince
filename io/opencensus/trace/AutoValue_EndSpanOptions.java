package io.opencensus.trace;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_EndSpanOptions extends EndSpanOptions {
  private final boolean sampleToLocalSpanStore;
  
  private final Status status;
  
  private AutoValue_EndSpanOptions(boolean paramBoolean, @Nullable Status paramStatus) {
    this.sampleToLocalSpanStore = paramBoolean;
    this.status = paramStatus;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof EndSpanOptions) {
      paramObject = paramObject;
      if (this.sampleToLocalSpanStore == paramObject.getSampleToLocalSpanStore()) {
        Status status = this.status;
        if ((status == null) ? (paramObject.getStatus() == null) : status.equals(paramObject.getStatus()))
          return bool; 
      } 
      return false;
    } 
    return false;
  }
  
  public boolean getSampleToLocalSpanStore() {
    return this.sampleToLocalSpanStore;
  }
  
  @Nullable
  public Status getStatus() {
    return this.status;
  }
  
  public int hashCode() {
    char c;
    int i;
    if (this.sampleToLocalSpanStore) {
      c = 'ӏ';
    } else {
      c = 'ӕ';
    } 
    Status status = this.status;
    if (status == null) {
      i = 0;
    } else {
      i = status.hashCode();
    } 
    return (c ^ 0xF4243) * 1000003 ^ i;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("EndSpanOptions{sampleToLocalSpanStore=");
    stringBuilder.append(this.sampleToLocalSpanStore);
    stringBuilder.append(", status=");
    stringBuilder.append(this.status);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  static final class Builder extends EndSpanOptions.Builder {
    private Boolean sampleToLocalSpanStore;
    
    private Status status;
    
    public EndSpanOptions build() {
      String str = "";
      if (this.sampleToLocalSpanStore == null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("");
        stringBuilder1.append(" sampleToLocalSpanStore");
        str = stringBuilder1.toString();
      } 
      if (str.isEmpty())
        return new AutoValue_EndSpanOptions(this.sampleToLocalSpanStore.booleanValue(), this.status); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Missing required properties:");
      stringBuilder.append(str);
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public EndSpanOptions.Builder setSampleToLocalSpanStore(boolean param1Boolean) {
      this.sampleToLocalSpanStore = Boolean.valueOf(param1Boolean);
      return this;
    }
    
    public EndSpanOptions.Builder setStatus(@Nullable Status param1Status) {
      this.status = param1Status;
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\AutoValue_EndSpanOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */