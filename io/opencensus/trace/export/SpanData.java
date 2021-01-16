package io.opencensus.trace.export;

import com.google.common.base.Preconditions;
import io.opencensus.common.Timestamp;
import io.opencensus.trace.Annotation;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Link;
import io.opencensus.trace.NetworkEvent;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.SpanId;
import io.opencensus.trace.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class SpanData {
  public static SpanData create(SpanContext paramSpanContext, @Nullable SpanId paramSpanId, @Nullable Boolean paramBoolean, String paramString, Timestamp paramTimestamp1, Attributes paramAttributes, TimedEvents<Annotation> paramTimedEvents, TimedEvents<NetworkEvent> paramTimedEvents1, Links paramLinks, @Nullable Integer paramInteger, @Nullable Status paramStatus, @Nullable Timestamp paramTimestamp2) {
    return new AutoValue_SpanData(paramSpanContext, paramSpanId, paramBoolean, paramString, paramTimestamp1, paramAttributes, paramTimedEvents, paramTimedEvents1, paramLinks, paramInteger, paramStatus, paramTimestamp2);
  }
  
  public abstract TimedEvents<Annotation> getAnnotations();
  
  public abstract Attributes getAttributes();
  
  @Nullable
  public abstract Integer getChildSpanCount();
  
  public abstract SpanContext getContext();
  
  @Nullable
  public abstract Timestamp getEndTimestamp();
  
  @Nullable
  public abstract Boolean getHasRemoteParent();
  
  public abstract Links getLinks();
  
  public abstract String getName();
  
  public abstract TimedEvents<NetworkEvent> getNetworkEvents();
  
  @Nullable
  public abstract SpanId getParentSpanId();
  
  public abstract Timestamp getStartTimestamp();
  
  @Nullable
  public abstract Status getStatus();
  
  @Immutable
  public static abstract class Attributes {
    public static Attributes create(Map<String, AttributeValue> param1Map, int param1Int) {
      return new AutoValue_SpanData_Attributes(Collections.unmodifiableMap(new HashMap<String, AttributeValue>((Map<? extends String, ? extends AttributeValue>)Preconditions.checkNotNull(param1Map, "attributeMap"))), param1Int);
    }
    
    public abstract Map<String, AttributeValue> getAttributeMap();
    
    public abstract int getDroppedAttributesCount();
  }
  
  @Immutable
  public static abstract class Links {
    public static Links create(List<Link> param1List, int param1Int) {
      return new AutoValue_SpanData_Links(Collections.unmodifiableList(new ArrayList<Link>((Collection<? extends Link>)Preconditions.checkNotNull(param1List, "links"))), param1Int);
    }
    
    public abstract int getDroppedLinksCount();
    
    public abstract List<Link> getLinks();
  }
  
  @Immutable
  public static abstract class TimedEvent<T> {
    public static <T> TimedEvent<T> create(Timestamp param1Timestamp, T param1T) {
      return new AutoValue_SpanData_TimedEvent<T>(param1Timestamp, param1T);
    }
    
    public abstract T getEvent();
    
    public abstract Timestamp getTimestamp();
  }
  
  @Immutable
  public static abstract class TimedEvents<T> {
    public static <T> TimedEvents<T> create(List<SpanData.TimedEvent<T>> param1List, int param1Int) {
      return new AutoValue_SpanData_TimedEvents<T>(Collections.unmodifiableList(new ArrayList<SpanData.TimedEvent<T>>((Collection<? extends SpanData.TimedEvent<T>>)Preconditions.checkNotNull(param1List, "events"))), param1Int);
    }
    
    public abstract int getDroppedEventsCount();
    
    public abstract List<SpanData.TimedEvent<T>> getEvents();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\SpanData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */