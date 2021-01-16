package io.opencensus.trace.export;

import io.opencensus.trace.Link;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_SpanData_Links extends SpanData.Links {
  private final int droppedLinksCount;
  
  private final List<Link> links;
  
  AutoValue_SpanData_Links(List<Link> paramList, int paramInt) {
    if (paramList != null) {
      this.links = paramList;
      this.droppedLinksCount = paramInt;
      return;
    } 
    throw new NullPointerException("Null links");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof SpanData.Links) {
      paramObject = paramObject;
      if (!this.links.equals(paramObject.getLinks()) || this.droppedLinksCount != paramObject.getDroppedLinksCount())
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public int getDroppedLinksCount() {
    return this.droppedLinksCount;
  }
  
  public List<Link> getLinks() {
    return this.links;
  }
  
  public int hashCode() {
    return (this.links.hashCode() ^ 0xF4243) * 1000003 ^ this.droppedLinksCount;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Links{links=");
    stringBuilder.append(this.links);
    stringBuilder.append(", droppedLinksCount=");
    stringBuilder.append(this.droppedLinksCount);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\AutoValue_SpanData_Links.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */