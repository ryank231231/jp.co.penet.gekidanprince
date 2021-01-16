package io.opencensus.trace.export;

import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_SpanData_TimedEvents<T> extends SpanData.TimedEvents<T> {
  private final int droppedEventsCount;
  
  private final List<SpanData.TimedEvent<T>> events;
  
  AutoValue_SpanData_TimedEvents(List<SpanData.TimedEvent<T>> paramList, int paramInt) {
    if (paramList != null) {
      this.events = paramList;
      this.droppedEventsCount = paramInt;
      return;
    } 
    throw new NullPointerException("Null events");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof SpanData.TimedEvents) {
      paramObject = paramObject;
      if (!this.events.equals(paramObject.getEvents()) || this.droppedEventsCount != paramObject.getDroppedEventsCount())
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public int getDroppedEventsCount() {
    return this.droppedEventsCount;
  }
  
  public List<SpanData.TimedEvent<T>> getEvents() {
    return this.events;
  }
  
  public int hashCode() {
    return (this.events.hashCode() ^ 0xF4243) * 1000003 ^ this.droppedEventsCount;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("TimedEvents{events=");
    stringBuilder.append(this.events);
    stringBuilder.append(", droppedEventsCount=");
    stringBuilder.append(this.droppedEventsCount);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\AutoValue_SpanData_TimedEvents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */