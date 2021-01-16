package io.grpc.stub;

import com.google.common.base.Preconditions;
import io.grpc.ExperimentalApi;
import java.util.Iterator;

@ExperimentalApi
public final class StreamObservers {
  public static <V> void copyWithFlowControl(Iterable<V> paramIterable, CallStreamObserver<V> paramCallStreamObserver) {
    Preconditions.checkNotNull(paramIterable, "source");
    copyWithFlowControl(paramIterable.iterator(), paramCallStreamObserver);
  }
  
  public static <V> void copyWithFlowControl(final Iterator<V> source, final CallStreamObserver<V> target) {
    Preconditions.checkNotNull(source, "source");
    Preconditions.checkNotNull(target, "target");
    final class FlowControllingOnReadyHandler implements Runnable {
      public void run() {
        while (target.isReady() && source.hasNext())
          target.onNext(source.next()); 
        if (!source.hasNext())
          target.onCompleted(); 
      }
    };
    target.setOnReadyHandler(new FlowControllingOnReadyHandler());
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\stub\StreamObservers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */