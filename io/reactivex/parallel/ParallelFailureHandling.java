package io.reactivex.parallel;

import io.reactivex.annotations.Experimental;
import io.reactivex.functions.BiFunction;

@Experimental
public enum ParallelFailureHandling implements BiFunction<Long, Throwable, ParallelFailureHandling> {
  ERROR, RETRY, SKIP, STOP;
  
  static {
    ERROR = new ParallelFailureHandling("ERROR", 1);
    SKIP = new ParallelFailureHandling("SKIP", 2);
    RETRY = new ParallelFailureHandling("RETRY", 3);
    $VALUES = new ParallelFailureHandling[] { STOP, ERROR, SKIP, RETRY };
  }
  
  public ParallelFailureHandling apply(Long paramLong, Throwable paramThrowable) {
    return this;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\parallel\ParallelFailureHandling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */