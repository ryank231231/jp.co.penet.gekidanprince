package io.reactivex;

import io.reactivex.annotations.NonNull;

public interface FlowableOnSubscribe<T> {
  void subscribe(@NonNull FlowableEmitter<T> paramFlowableEmitter) throws Exception;
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\FlowableOnSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */