package io.reactivex.processors;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import org.reactivestreams.Processor;

public abstract class FlowableProcessor<T> extends Flowable<T> implements Processor<T, T>, FlowableSubscriber<T> {
  @Nullable
  public abstract Throwable getThrowable();
  
  public abstract boolean hasComplete();
  
  public abstract boolean hasSubscribers();
  
  public abstract boolean hasThrowable();
  
  @CheckReturnValue
  @NonNull
  public final FlowableProcessor<T> toSerialized() {
    return (FlowableProcessor<T>)((this instanceof SerializedProcessor) ? this : new SerializedProcessor(this));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\io\reactivex\processors\FlowableProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */