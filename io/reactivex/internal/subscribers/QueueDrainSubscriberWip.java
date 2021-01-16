package io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicInteger;

class QueueDrainSubscriberWip extends QueueDrainSubscriberPad0 {
  final AtomicInteger wip = new AtomicInteger();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\subscribers\QueueDrainSubscriberWip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */