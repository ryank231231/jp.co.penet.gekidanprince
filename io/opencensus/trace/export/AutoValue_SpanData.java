package io.opencensus.trace.export;

import io.opencensus.common.Timestamp;
import io.opencensus.trace.Annotation;
import io.opencensus.trace.NetworkEvent;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.SpanId;
import io.opencensus.trace.Status;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_SpanData extends SpanData {
  private final SpanData.TimedEvents<Annotation> annotations;
  
  private final SpanData.Attributes attributes;
  
  private final Integer childSpanCount;
  
  private final SpanContext context;
  
  private final Timestamp endTimestamp;
  
  private final Boolean hasRemoteParent;
  
  private final SpanData.Links links;
  
  private final String name;
  
  private final SpanData.TimedEvents<NetworkEvent> networkEvents;
  
  private final SpanId parentSpanId;
  
  private final Timestamp startTimestamp;
  
  private final Status status;
  
  AutoValue_SpanData(SpanContext paramSpanContext, @Nullable SpanId paramSpanId, @Nullable Boolean paramBoolean, String paramString, Timestamp paramTimestamp1, SpanData.Attributes paramAttributes, SpanData.TimedEvents<Annotation> paramTimedEvents, SpanData.TimedEvents<NetworkEvent> paramTimedEvents1, SpanData.Links paramLinks, @Nullable Integer paramInteger, @Nullable Status paramStatus, @Nullable Timestamp paramTimestamp2) {
    if (paramSpanContext != null) {
      this.context = paramSpanContext;
      this.parentSpanId = paramSpanId;
      this.hasRemoteParent = paramBoolean;
      if (paramString != null) {
        this.name = paramString;
        if (paramTimestamp1 != null) {
          this.startTimestamp = paramTimestamp1;
          if (paramAttributes != null) {
            this.attributes = paramAttributes;
            if (paramTimedEvents != null) {
              this.annotations = paramTimedEvents;
              if (paramTimedEvents1 != null) {
                this.networkEvents = paramTimedEvents1;
                if (paramLinks != null) {
                  this.links = paramLinks;
                  this.childSpanCount = paramInteger;
                  this.status = paramStatus;
                  this.endTimestamp = paramTimestamp2;
                  return;
                } 
                throw new NullPointerException("Null links");
              } 
              throw new NullPointerException("Null networkEvents");
            } 
            throw new NullPointerException("Null annotations");
          } 
          throw new NullPointerException("Null attributes");
        } 
        throw new NullPointerException("Null startTimestamp");
      } 
      throw new NullPointerException("Null name");
    } 
    throw new NullPointerException("Null context");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof SpanData) {
      paramObject = paramObject;
      if (this.context.equals(paramObject.getContext())) {
        SpanId spanId = this.parentSpanId;
        if ((spanId == null) ? (paramObject.getParentSpanId() == null) : spanId.equals(paramObject.getParentSpanId())) {
          Boolean bool1 = this.hasRemoteParent;
          if (((bool1 == null) ? (paramObject.getHasRemoteParent() == null) : bool1.equals(paramObject.getHasRemoteParent())) && this.name.equals(paramObject.getName()) && this.startTimestamp.equals(paramObject.getStartTimestamp()) && this.attributes.equals(paramObject.getAttributes()) && this.annotations.equals(paramObject.getAnnotations()) && this.networkEvents.equals(paramObject.getNetworkEvents()) && this.links.equals(paramObject.getLinks())) {
            Integer integer = this.childSpanCount;
            if ((integer == null) ? (paramObject.getChildSpanCount() == null) : integer.equals(paramObject.getChildSpanCount())) {
              Status status = this.status;
              if ((status == null) ? (paramObject.getStatus() == null) : status.equals(paramObject.getStatus())) {
                Timestamp timestamp = this.endTimestamp;
                if ((timestamp == null) ? (paramObject.getEndTimestamp() == null) : timestamp.equals(paramObject.getEndTimestamp()))
                  return bool; 
              } 
            } 
          } 
        } 
      } 
      return false;
    } 
    return false;
  }
  
  public SpanData.TimedEvents<Annotation> getAnnotations() {
    return this.annotations;
  }
  
  public SpanData.Attributes getAttributes() {
    return this.attributes;
  }
  
  @Nullable
  public Integer getChildSpanCount() {
    return this.childSpanCount;
  }
  
  public SpanContext getContext() {
    return this.context;
  }
  
  @Nullable
  public Timestamp getEndTimestamp() {
    return this.endTimestamp;
  }
  
  @Nullable
  public Boolean getHasRemoteParent() {
    return this.hasRemoteParent;
  }
  
  public SpanData.Links getLinks() {
    return this.links;
  }
  
  public String getName() {
    return this.name;
  }
  
  public SpanData.TimedEvents<NetworkEvent> getNetworkEvents() {
    return this.networkEvents;
  }
  
  @Nullable
  public SpanId getParentSpanId() {
    return this.parentSpanId;
  }
  
  public Timestamp getStartTimestamp() {
    return this.startTimestamp;
  }
  
  @Nullable
  public Status getStatus() {
    return this.status;
  }
  
  public int hashCode() {
    int k;
    int m;
    int i6;
    int i7;
    int i = this.context.hashCode();
    SpanId spanId = this.parentSpanId;
    int j = 0;
    if (spanId == null) {
      k = 0;
    } else {
      k = spanId.hashCode();
    } 
    Boolean bool = this.hasRemoteParent;
    if (bool == null) {
      m = 0;
    } else {
      m = bool.hashCode();
    } 
    int n = this.name.hashCode();
    int i1 = this.startTimestamp.hashCode();
    int i2 = this.attributes.hashCode();
    int i3 = this.annotations.hashCode();
    int i4 = this.networkEvents.hashCode();
    int i5 = this.links.hashCode();
    Integer integer = this.childSpanCount;
    if (integer == null) {
      i6 = 0;
    } else {
      i6 = integer.hashCode();
    } 
    Status status = this.status;
    if (status == null) {
      i7 = 0;
    } else {
      i7 = status.hashCode();
    } 
    Timestamp timestamp = this.endTimestamp;
    if (timestamp != null)
      j = timestamp.hashCode(); 
    return (((((((((((i ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ n) * 1000003 ^ i1) * 1000003 ^ i2) * 1000003 ^ i3) * 1000003 ^ i4) * 1000003 ^ i5) * 1000003 ^ i6) * 1000003 ^ i7) * 1000003 ^ j;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SpanData{context=");
    stringBuilder.append(this.context);
    stringBuilder.append(", parentSpanId=");
    stringBuilder.append(this.parentSpanId);
    stringBuilder.append(", hasRemoteParent=");
    stringBuilder.append(this.hasRemoteParent);
    stringBuilder.append(", name=");
    stringBuilder.append(this.name);
    stringBuilder.append(", startTimestamp=");
    stringBuilder.append(this.startTimestamp);
    stringBuilder.append(", attributes=");
    stringBuilder.append(this.attributes);
    stringBuilder.append(", annotations=");
    stringBuilder.append(this.annotations);
    stringBuilder.append(", networkEvents=");
    stringBuilder.append(this.networkEvents);
    stringBuilder.append(", links=");
    stringBuilder.append(this.links);
    stringBuilder.append(", childSpanCount=");
    stringBuilder.append(this.childSpanCount);
    stringBuilder.append(", status=");
    stringBuilder.append(this.status);
    stringBuilder.append(", endTimestamp=");
    stringBuilder.append(this.endTimestamp);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\AutoValue_SpanData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */