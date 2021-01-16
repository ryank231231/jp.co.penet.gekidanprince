package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
  final Function<? super T, ? extends U> mapper;
  
  public FlowableMap(Flowable<T> paramFlowable, Function<? super T, ? extends U> paramFunction) {
    super(paramFlowable);
    this.mapper = paramFunction;
  }
  
  protected void subscribeActual(Subscriber<? super U> paramSubscriber) {
    if (paramSubscriber instanceof ConditionalSubscriber) {
      this.source.subscribe((FlowableSubscriber)new MapConditionalSubscriber<T, U>((ConditionalSubscriber<? super U>)paramSubscriber, this.mapper));
    } else {
      this.source.subscribe((FlowableSubscriber)new MapSubscriber<T, U>(paramSubscriber, this.mapper));
    } 
  }
  
  static final class MapConditionalSubscriber<T, U> extends BasicFuseableConditionalSubscriber<T, U> {
    final Function<? super T, ? extends U> mapper;
    
    MapConditionalSubscriber(ConditionalSubscriber<? super U> param1ConditionalSubscriber, Function<? super T, ? extends U> param1Function) {
      super(param1ConditionalSubscriber);
      this.mapper = param1Function;
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      if (this.sourceMode != 0) {
        this.actual.onNext(null);
        return;
      } 
      try {
        param1T = (T)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper function returned a null value.");
        this.actual.onNext(param1T);
        return;
      } catch (Throwable throwable) {
        fail(throwable);
        return;
      } 
    }
    
    @Nullable
    public U poll() throws Exception {
      Object object = this.qs.poll();
      if (object != null) {
        object = ObjectHelper.requireNonNull(this.mapper.apply(object), "The mapper function returned a null value.");
      } else {
        object = null;
      } 
      return (U)object;
    }
    
    public int requestFusion(int param1Int) {
      return transitiveBoundaryFusion(param1Int);
    }
    
    public boolean tryOnNext(T param1T) {
      if (this.done)
        return false; 
      try {
        param1T = (T)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper function returned a null value.");
        return this.actual.tryOnNext(param1T);
      } catch (Throwable throwable) {
        fail(throwable);
        return true;
      } 
    }
  }
  
  static final class MapSubscriber<T, U> extends BasicFuseableSubscriber<T, U> {
    final Function<? super T, ? extends U> mapper;
    
    MapSubscriber(Subscriber<? super U> param1Subscriber, Function<? super T, ? extends U> param1Function) {
      super(param1Subscriber);
      this.mapper = param1Function;
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      if (this.sourceMode != 0) {
        this.actual.onNext(null);
        return;
      } 
      try {
        param1T = (T)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper function returned a null value.");
        this.actual.onNext(param1T);
        return;
      } catch (Throwable throwable) {
        fail(throwable);
        return;
      } 
    }
    
    @Nullable
    public U poll() throws Exception {
      Object object = this.qs.poll();
      if (object != null) {
        object = ObjectHelper.requireNonNull(this.mapper.apply(object), "The mapper function returned a null value.");
      } else {
        object = null;
      } 
      return (U)object;
    }
    
    public int requestFusion(int param1Int) {
      return transitiveBoundaryFusion(param1Int);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */