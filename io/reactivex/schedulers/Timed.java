package io.reactivex.schedulers;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

public final class Timed<T> {
  final long time;
  
  final TimeUnit unit;
  
  final T value;
  
  public Timed(@NonNull T paramT, long paramLong, @NonNull TimeUnit paramTimeUnit) {
    this.value = paramT;
    this.time = paramLong;
    this.unit = (TimeUnit)ObjectHelper.requireNonNull(paramTimeUnit, "unit is null");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof Timed;
    boolean bool1 = false;
    if (bool) {
      paramObject = paramObject;
      bool = bool1;
      if (ObjectHelper.equals(this.value, ((Timed)paramObject).value)) {
        bool = bool1;
        if (this.time == ((Timed)paramObject).time) {
          bool = bool1;
          if (ObjectHelper.equals(this.unit, ((Timed)paramObject).unit))
            bool = true; 
        } 
      } 
      return bool;
    } 
    return false;
  }
  
  public int hashCode() {
    byte b;
    T t = this.value;
    if (t != null) {
      b = t.hashCode();
    } else {
      b = 0;
    } 
    long l = this.time;
    return (b * 31 + (int)(l ^ l >>> 31L)) * 31 + this.unit.hashCode();
  }
  
  public long time() {
    return this.time;
  }
  
  public long time(@NonNull TimeUnit paramTimeUnit) {
    return paramTimeUnit.convert(this.time, this.unit);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Timed[time=");
    stringBuilder.append(this.time);
    stringBuilder.append(", unit=");
    stringBuilder.append(this.unit);
    stringBuilder.append(", value=");
    stringBuilder.append(this.value);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  @NonNull
  public TimeUnit unit() {
    return this.unit;
  }
  
  @NonNull
  public T value() {
    return this.value;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\schedulers\Timed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */