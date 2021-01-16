package io.opencensus.trace.config;

import io.opencensus.trace.Sampler;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_TraceParams extends TraceParams {
  private final int maxNumberOfAnnotations;
  
  private final int maxNumberOfAttributes;
  
  private final int maxNumberOfLinks;
  
  private final int maxNumberOfNetworkEvents;
  
  private final Sampler sampler;
  
  private AutoValue_TraceParams(Sampler paramSampler, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.sampler = paramSampler;
    this.maxNumberOfAttributes = paramInt1;
    this.maxNumberOfAnnotations = paramInt2;
    this.maxNumberOfNetworkEvents = paramInt3;
    this.maxNumberOfLinks = paramInt4;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof TraceParams) {
      paramObject = paramObject;
      if (!this.sampler.equals(paramObject.getSampler()) || this.maxNumberOfAttributes != paramObject.getMaxNumberOfAttributes() || this.maxNumberOfAnnotations != paramObject.getMaxNumberOfAnnotations() || this.maxNumberOfNetworkEvents != paramObject.getMaxNumberOfNetworkEvents() || this.maxNumberOfLinks != paramObject.getMaxNumberOfLinks())
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public int getMaxNumberOfAnnotations() {
    return this.maxNumberOfAnnotations;
  }
  
  public int getMaxNumberOfAttributes() {
    return this.maxNumberOfAttributes;
  }
  
  public int getMaxNumberOfLinks() {
    return this.maxNumberOfLinks;
  }
  
  public int getMaxNumberOfNetworkEvents() {
    return this.maxNumberOfNetworkEvents;
  }
  
  public Sampler getSampler() {
    return this.sampler;
  }
  
  public int hashCode() {
    return ((((this.sampler.hashCode() ^ 0xF4243) * 1000003 ^ this.maxNumberOfAttributes) * 1000003 ^ this.maxNumberOfAnnotations) * 1000003 ^ this.maxNumberOfNetworkEvents) * 1000003 ^ this.maxNumberOfLinks;
  }
  
  public TraceParams.Builder toBuilder() {
    return new Builder(this);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("TraceParams{sampler=");
    stringBuilder.append(this.sampler);
    stringBuilder.append(", maxNumberOfAttributes=");
    stringBuilder.append(this.maxNumberOfAttributes);
    stringBuilder.append(", maxNumberOfAnnotations=");
    stringBuilder.append(this.maxNumberOfAnnotations);
    stringBuilder.append(", maxNumberOfNetworkEvents=");
    stringBuilder.append(this.maxNumberOfNetworkEvents);
    stringBuilder.append(", maxNumberOfLinks=");
    stringBuilder.append(this.maxNumberOfLinks);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  static final class Builder extends TraceParams.Builder {
    private Integer maxNumberOfAnnotations;
    
    private Integer maxNumberOfAttributes;
    
    private Integer maxNumberOfLinks;
    
    private Integer maxNumberOfNetworkEvents;
    
    private Sampler sampler;
    
    Builder() {}
    
    private Builder(TraceParams param1TraceParams) {
      this.sampler = param1TraceParams.getSampler();
      this.maxNumberOfAttributes = Integer.valueOf(param1TraceParams.getMaxNumberOfAttributes());
      this.maxNumberOfAnnotations = Integer.valueOf(param1TraceParams.getMaxNumberOfAnnotations());
      this.maxNumberOfNetworkEvents = Integer.valueOf(param1TraceParams.getMaxNumberOfNetworkEvents());
      this.maxNumberOfLinks = Integer.valueOf(param1TraceParams.getMaxNumberOfLinks());
    }
    
    TraceParams autoBuild() {
      String str1 = "";
      if (this.sampler == null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("");
        stringBuilder1.append(" sampler");
        str1 = stringBuilder1.toString();
      } 
      String str2 = str1;
      if (this.maxNumberOfAttributes == null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append(" maxNumberOfAttributes");
        str2 = stringBuilder1.toString();
      } 
      str1 = str2;
      if (this.maxNumberOfAnnotations == null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str2);
        stringBuilder1.append(" maxNumberOfAnnotations");
        str1 = stringBuilder1.toString();
      } 
      str2 = str1;
      if (this.maxNumberOfNetworkEvents == null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append(" maxNumberOfNetworkEvents");
        str2 = stringBuilder1.toString();
      } 
      str1 = str2;
      if (this.maxNumberOfLinks == null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str2);
        stringBuilder1.append(" maxNumberOfLinks");
        str1 = stringBuilder1.toString();
      } 
      if (str1.isEmpty())
        return new AutoValue_TraceParams(this.sampler, this.maxNumberOfAttributes.intValue(), this.maxNumberOfAnnotations.intValue(), this.maxNumberOfNetworkEvents.intValue(), this.maxNumberOfLinks.intValue()); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Missing required properties:");
      stringBuilder.append(str1);
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public TraceParams.Builder setMaxNumberOfAnnotations(int param1Int) {
      this.maxNumberOfAnnotations = Integer.valueOf(param1Int);
      return this;
    }
    
    public TraceParams.Builder setMaxNumberOfAttributes(int param1Int) {
      this.maxNumberOfAttributes = Integer.valueOf(param1Int);
      return this;
    }
    
    public TraceParams.Builder setMaxNumberOfLinks(int param1Int) {
      this.maxNumberOfLinks = Integer.valueOf(param1Int);
      return this;
    }
    
    public TraceParams.Builder setMaxNumberOfNetworkEvents(int param1Int) {
      this.maxNumberOfNetworkEvents = Integer.valueOf(param1Int);
      return this;
    }
    
    public TraceParams.Builder setSampler(Sampler param1Sampler) {
      if (param1Sampler != null) {
        this.sampler = param1Sampler;
        return this;
      } 
      throw new NullPointerException("Null sampler");
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\config\AutoValue_TraceParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */