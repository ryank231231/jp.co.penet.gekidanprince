package io.opencensus.trace.export;

import io.opencensus.common.Timestamp;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_SpanData_TimedEvent<T> extends SpanData.TimedEvent<T> {
  private final T event;
  
  private final Timestamp timestamp;
  
  AutoValue_SpanData_TimedEvent(Timestamp paramTimestamp, T paramT) {
    if (paramTimestamp != null) {
      this.timestamp = paramTimestamp;
      if (paramT != null) {
        this.event = paramT;
        return;
      } 
      throw new NullPointerException("Null event");
    } 
    throw new NullPointerException("Null timestamp");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof SpanData.TimedEvent) {
      paramObject = paramObject;
      if (!this.timestamp.equals(paramObject.getTimestamp()) || !this.event.equals(paramObject.getEvent()))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public T getEvent() {
    return this.event;
  }
  
  public Timestamp getTimestamp() {
    return this.timestamp;
  }
  
  public int hashCode() {
    return (this.timestamp.hashCode() ^ 0xF4243) * 1000003 ^ this.event.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("TimedEvent{timestamp=");
    stringBuilder.append(this.timestamp);
    stringBuilder.append(", event=");
    stringBuilder.append(this.event);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\AutoValue_SpanData_TimedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */