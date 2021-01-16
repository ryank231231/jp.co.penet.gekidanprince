package io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicLong;

class QueueDrainSubscriberPad3 extends QueueDrainSubscriberPad2 {
  final AtomicLong requested = new AtomicLong();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\subscribers\QueueDrainSubscriberPad3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */