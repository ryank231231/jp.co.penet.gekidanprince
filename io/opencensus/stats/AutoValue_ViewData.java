package io.opencensus.stats;

import io.opencensus.tags.TagValue;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_ViewData extends ViewData {
  private final Map<List<TagValue>, AggregationData> aggregationMap;
  
  private final View view;
  
  private final ViewData.AggregationWindowData windowData;
  
  AutoValue_ViewData(View paramView, Map<List<TagValue>, AggregationData> paramMap, ViewData.AggregationWindowData paramAggregationWindowData) {
    if (paramView != null) {
      this.view = paramView;
      if (paramMap != null) {
        this.aggregationMap = paramMap;
        if (paramAggregationWindowData != null) {
          this.windowData = paramAggregationWindowData;
          return;
        } 
        throw new NullPointerException("Null windowData");
      } 
      throw new NullPointerException("Null aggregationMap");
    } 
    throw new NullPointerException("Null view");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof ViewData) {
      paramObject = paramObject;
      if (!this.view.equals(paramObject.getView()) || !this.aggregationMap.equals(paramObject.getAggregationMap()) || !this.windowData.equals(paramObject.getWindowData()))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public Map<List<TagValue>, AggregationData> getAggregationMap() {
    return this.aggregationMap;
  }
  
  public View getView() {
    return this.view;
  }
  
  public ViewData.AggregationWindowData getWindowData() {
    return this.windowData;
  }
  
  public int hashCode() {
    return ((this.view.hashCode() ^ 0xF4243) * 1000003 ^ this.aggregationMap.hashCode()) * 1000003 ^ this.windowData.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ViewData{view=");
    stringBuilder.append(this.view);
    stringBuilder.append(", aggregationMap=");
    stringBuilder.append(this.aggregationMap);
    stringBuilder.append(", windowData=");
    stringBuilder.append(this.windowData);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_ViewData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */