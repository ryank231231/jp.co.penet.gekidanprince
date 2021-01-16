package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public class EventBus {
  private static final Logger logger = Logger.getLogger(EventBus.class.getName());
  
  private final Dispatcher dispatcher;
  
  private final SubscriberExceptionHandler exceptionHandler;
  
  private final Executor executor;
  
  private final String identifier;
  
  private final SubscriberRegistry subscribers = new SubscriberRegistry(this);
  
  public EventBus() {
    this("default");
  }
  
  public EventBus(SubscriberExceptionHandler paramSubscriberExceptionHandler) {
    this("default", MoreExecutors.directExecutor(), Dispatcher.perThreadDispatchQueue(), paramSubscriberExceptionHandler);
  }
  
  public EventBus(String paramString) {
    this(paramString, MoreExecutors.directExecutor(), Dispatcher.perThreadDispatchQueue(), LoggingHandler.INSTANCE);
  }
  
  EventBus(String paramString, Executor paramExecutor, Dispatcher paramDispatcher, SubscriberExceptionHandler paramSubscriberExceptionHandler) {
    this.identifier = (String)Preconditions.checkNotNull(paramString);
    this.executor = (Executor)Preconditions.checkNotNull(paramExecutor);
    this.dispatcher = (Dispatcher)Preconditions.checkNotNull(paramDispatcher);
    this.exceptionHandler = (SubscriberExceptionHandler)Preconditions.checkNotNull(paramSubscriberExceptionHandler);
  }
  
  final Executor executor() {
    return this.executor;
  }
  
  void handleSubscriberException(Throwable paramThrowable, SubscriberExceptionContext paramSubscriberExceptionContext) {
    Preconditions.checkNotNull(paramThrowable);
    Preconditions.checkNotNull(paramSubscriberExceptionContext);
    try {
      this.exceptionHandler.handleException(paramThrowable, paramSubscriberExceptionContext);
    } catch (Throwable throwable) {
      logger.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", new Object[] { throwable, paramThrowable }), throwable);
    } 
  }
  
  public final String identifier() {
    return this.identifier;
  }
  
  public void post(Object paramObject) {
    Iterator<Subscriber> iterator = this.subscribers.getSubscribers(paramObject);
    if (iterator.hasNext()) {
      this.dispatcher.dispatch(paramObject, iterator);
    } else if (!(paramObject instanceof DeadEvent)) {
      post(new DeadEvent(this, paramObject));
    } 
  }
  
  public void register(Object paramObject) {
    this.subscribers.register(paramObject);
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).addValue(this.identifier).toString();
  }
  
  public void unregister(Object paramObject) {
    this.subscribers.unregister(paramObject);
  }
  
  static final class LoggingHandler implements SubscriberExceptionHandler {
    static final LoggingHandler INSTANCE = new LoggingHandler();
    
    private static Logger logger(SubscriberExceptionContext param1SubscriberExceptionContext) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(EventBus.class.getName());
      stringBuilder.append(".");
      stringBuilder.append(param1SubscriberExceptionContext.getEventBus().identifier());
      return Logger.getLogger(stringBuilder.toString());
    }
    
    private static String message(SubscriberExceptionContext param1SubscriberExceptionContext) {
      Method method = param1SubscriberExceptionContext.getSubscriberMethod();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Exception thrown by subscriber method ");
      stringBuilder.append(method.getName());
      stringBuilder.append('(');
      stringBuilder.append(method.getParameterTypes()[0].getName());
      stringBuilder.append(')');
      stringBuilder.append(" on subscriber ");
      stringBuilder.append(param1SubscriberExceptionContext.getSubscriber());
      stringBuilder.append(" when dispatching event: ");
      stringBuilder.append(param1SubscriberExceptionContext.getEvent());
      return stringBuilder.toString();
    }
    
    public void handleException(Throwable param1Throwable, SubscriberExceptionContext param1SubscriberExceptionContext) {
      Logger logger = logger(param1SubscriberExceptionContext);
      if (logger.isLoggable(Level.SEVERE))
        logger.log(Level.SEVERE, message(param1SubscriberExceptionContext), param1Throwable); 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\eventbus\EventBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */