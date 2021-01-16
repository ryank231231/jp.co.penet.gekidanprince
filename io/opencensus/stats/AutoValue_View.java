package io.opencensus.stats;

import io.opencensus.tags.TagKey;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_View extends View {
  private final Aggregation aggregation;
  
  private final List<TagKey> columns;
  
  private final String description;
  
  private final Measure measure;
  
  private final View.Name name;
  
  private final View.AggregationWindow window;
  
  AutoValue_View(View.Name paramName, String paramString, Measure paramMeasure, Aggregation paramAggregation, List<TagKey> paramList, View.AggregationWindow paramAggregationWindow) {
    if (paramName != null) {
      this.name = paramName;
      if (paramString != null) {
        this.description = paramString;
        if (paramMeasure != null) {
          this.measure = paramMeasure;
          if (paramAggregation != null) {
            this.aggregation = paramAggregation;
            if (paramList != null) {
              this.columns = paramList;
              if (paramAggregationWindow != null) {
                this.window = paramAggregationWindow;
                return;
              } 
              throw new NullPointerException("Null window");
            } 
            throw new NullPointerException("Null columns");
          } 
          throw new NullPointerException("Null aggregation");
        } 
        throw new NullPointerException("Null measure");
      } 
      throw new NullPointerException("Null description");
    } 
    throw new NullPointerException("Null name");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof View) {
      paramObject = paramObject;
      if (!this.name.equals(paramObject.getName()) || !this.description.equals(paramObject.getDescription()) || !this.measure.equals(paramObject.getMeasure()) || !this.aggregation.equals(paramObject.getAggregation()) || !this.columns.equals(paramObject.getColumns()) || !this.window.equals(paramObject.getWindow()))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public Aggregation getAggregation() {
    return this.aggregation;
  }
  
  public List<TagKey> getColumns() {
    return this.columns;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public Measure getMeasure() {
    return this.measure;
  }
  
  public View.Name getName() {
    return this.name;
  }
  
  public View.AggregationWindow getWindow() {
    return this.window;
  }
  
  public int hashCode() {
    return (((((this.name.hashCode() ^ 0xF4243) * 1000003 ^ this.description.hashCode()) * 1000003 ^ this.measure.hashCode()) * 1000003 ^ this.aggregation.hashCode()) * 1000003 ^ this.columns.hashCode()) * 1000003 ^ this.window.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("View{name=");
    stringBuilder.append(this.name);
    stringBuilder.append(", description=");
    stringBuilder.append(this.description);
    stringBuilder.append(", measure=");
    stringBuilder.append(this.measure);
    stringBuilder.append(", aggregation=");
    stringBuilder.append(this.aggregation);
    stringBuilder.append(", columns=");
    stringBuilder.append(this.columns);
    stringBuilder.append(", window=");
    stringBuilder.append(this.window);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_View.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */