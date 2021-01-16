package io.reactivex.internal.fuseable;

import io.reactivex.FlowableSubscriber;

public interface ConditionalSubscriber<T> extends FlowableSubscriber<T> {
  boolean tryOnNext(T paramT);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\fuseable\ConditionalSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */