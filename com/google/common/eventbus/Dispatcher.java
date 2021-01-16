package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

abstract class Dispatcher {
  static Dispatcher immediate() {
    return ImmediateDispatcher.INSTANCE;
  }
  
  static Dispatcher legacyAsync() {
    return new LegacyAsyncDispatcher();
  }
  
  static Dispatcher perThreadDispatchQueue() {
    return new PerThreadQueuedDispatcher();
  }
  
  abstract void dispatch(Object paramObject, Iterator<Subscriber> paramIterator);
  
  private static final class ImmediateDispatcher extends Dispatcher {
    private static final ImmediateDispatcher INSTANCE = new ImmediateDispatcher();
    
    void dispatch(Object param1Object, Iterator<Subscriber> param1Iterator) {
      Preconditions.checkNotNull(param1Object);
      while (param1Iterator.hasNext())
        ((Subscriber)param1Iterator.next()).dispatchEvent(param1Object); 
    }
  }
  
  private static final class LegacyAsyncDispatcher extends Dispatcher {
    private final ConcurrentLinkedQueue<EventWithSubscriber> queue = Queues.newConcurrentLinkedQueue();
    
    private LegacyAsyncDispatcher() {}
    
    void dispatch(Object param1Object, Iterator<Subscriber> param1Iterator) {
      Preconditions.checkNotNull(param1Object);
      while (param1Iterator.hasNext())
        this.queue.add(new EventWithSubscriber(param1Object, param1Iterator.next())); 
      while (true) {
        param1Object = this.queue.poll();
        if (param1Object != null) {
          ((EventWithSubscriber)param1Object).subscriber.dispatchEvent(((EventWithSubscriber)param1Object).event);
          continue;
        } 
        break;
      } 
    }
    
    private static final class EventWithSubscriber {
      private final Object event;
      
      private final Subscriber subscriber;
      
      private EventWithSubscriber(Object param2Object, Subscriber param2Subscriber) {
        this.event = param2Object;
        this.subscriber = param2Subscriber;
      }
    }
  }
  
  private static final class EventWithSubscriber {
    private final Object event;
    
    private final Subscriber subscriber;
    
    private EventWithSubscriber(Object param1Object, Subscriber param1Subscriber) {
      this.event = param1Object;
      this.subscriber = param1Subscriber;
    }
  }
  
  private static final class PerThreadQueuedDispatcher extends Dispatcher {
    private final ThreadLocal<Boolean> dispatching = new ThreadLocal<Boolean>() {
        protected Boolean initialValue() {
          return Boolean.valueOf(false);
        }
      };
    
    private final ThreadLocal<Queue<Event>> queue = new ThreadLocal<Queue<Event>>() {
        protected Queue<Dispatcher.PerThreadQueuedDispatcher.Event> initialValue() {
          return Queues.newArrayDeque();
        }
      };
    
    private PerThreadQueuedDispatcher() {}
    
    void dispatch(Object param1Object, Iterator<Subscriber> param1Iterator) {
      Preconditions.checkNotNull(param1Object);
      Preconditions.checkNotNull(param1Iterator);
      Queue<Event> queue = this.queue.get();
      queue.offer(new Event(param1Object, param1Iterator));
      if (!((Boolean)this.dispatching.get()).booleanValue()) {
        this.dispatching.set(Boolean.valueOf(true));
        try {
          while (true) {
            param1Object = queue.poll();
            if (param1Object != null) {
              while (((Event)param1Object).subscribers.hasNext())
                ((Subscriber)((Event)param1Object).subscribers.next()).dispatchEvent(((Event)param1Object).event); 
              continue;
            } 
            this.dispatching.remove();
            this.queue.remove();
            break;
          } 
        } finally {
          this.dispatching.remove();
          this.queue.remove();
        } 
      } 
    }
    
    private static final class Event {
      private final Object event;
      
      private final Iterator<Subscriber> subscribers;
      
      private Event(Object param2Object, Iterator<Subscriber> param2Iterator) {
        this.event = param2Object;
        this.subscribers = param2Iterator;
      }
    }
  }
  
  class null extends ThreadLocal<Queue<PerThreadQueuedDispatcher.Event>> {
    protected Queue<Dispatcher.PerThreadQueuedDispatcher.Event> initialValue() {
      return Queues.newArrayDeque();
    }
  }
  
  class null extends ThreadLocal<Boolean> {
    protected Boolean initialValue() {
      return Boolean.valueOf(false);
    }
  }
  
  private static final class Event {
    private final Object event;
    
    private final Iterator<Subscriber> subscribers;
    
    private Event(Object param1Object, Iterator<Subscriber> param1Iterator) {
      this.event = param1Object;
      this.subscribers = param1Iterator;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\eventbus\Dispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */