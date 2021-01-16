package io.reactivex;

import io.reactivex.annotations.NonNull;
import org.reactivestreams.Subscriber;

public interface FlowableOperator<Downstream, Upstream> {
  @NonNull
  Subscriber<? super Upstream> apply(@NonNull Subscriber<? super Downstream> paramSubscriber) throws Exception;
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\FlowableOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */