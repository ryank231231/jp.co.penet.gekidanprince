package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

public enum MaybeToPublisher implements Function<MaybeSource<Object>, Publisher<Object>> {
  INSTANCE;
  
  static {
    $VALUES = new MaybeToPublisher[] { INSTANCE };
  }
  
  public static <T> Function<MaybeSource<T>, Publisher<T>> instance() {
    return INSTANCE;
  }
  
  public Publisher<Object> apply(MaybeSource<Object> paramMaybeSource) throws Exception {
    return (Publisher<Object>)new MaybeToFlowable(paramMaybeSource);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeToPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */