package io.reactivex.internal.fuseable;

import org.reactivestreams.Publisher;

public interface HasUpstreamPublisher<T> {
  Publisher<T> source();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\fuseable\HasUpstreamPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */