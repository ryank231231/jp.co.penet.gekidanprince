package io.reactivex;

public enum BackpressureStrategy {
  BUFFER, DROP, ERROR, LATEST, MISSING;
  
  static {
    ERROR = new BackpressureStrategy("ERROR", 1);
    BUFFER = new BackpressureStrategy("BUFFER", 2);
    DROP = new BackpressureStrategy("DROP", 3);
    LATEST = new BackpressureStrategy("LATEST", 4);
    $VALUES = new BackpressureStrategy[] { MISSING, ERROR, BUFFER, DROP, LATEST };
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\BackpressureStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */