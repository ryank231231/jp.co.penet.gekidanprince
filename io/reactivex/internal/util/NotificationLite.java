package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.io.Serializable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public enum NotificationLite {
  COMPLETE;
  
  static {
    $VALUES = new NotificationLite[] { COMPLETE };
  }
  
  public static <T> boolean accept(Object paramObject, Observer<? super T> paramObserver) {
    if (paramObject == COMPLETE) {
      paramObserver.onComplete();
      return true;
    } 
    if (paramObject instanceof ErrorNotification) {
      paramObserver.onError(((ErrorNotification)paramObject).e);
      return true;
    } 
    paramObserver.onNext(paramObject);
    return false;
  }
  
  public static <T> boolean accept(Object paramObject, Subscriber<? super T> paramSubscriber) {
    if (paramObject == COMPLETE) {
      paramSubscriber.onComplete();
      return true;
    } 
    if (paramObject instanceof ErrorNotification) {
      paramSubscriber.onError(((ErrorNotification)paramObject).e);
      return true;
    } 
    paramSubscriber.onNext(paramObject);
    return false;
  }
  
  public static <T> boolean acceptFull(Object paramObject, Observer<? super T> paramObserver) {
    if (paramObject == COMPLETE) {
      paramObserver.onComplete();
      return true;
    } 
    if (paramObject instanceof ErrorNotification) {
      paramObserver.onError(((ErrorNotification)paramObject).e);
      return true;
    } 
    if (paramObject instanceof DisposableNotification) {
      paramObserver.onSubscribe(((DisposableNotification)paramObject).d);
      return false;
    } 
    paramObserver.onNext(paramObject);
    return false;
  }
  
  public static <T> boolean acceptFull(Object paramObject, Subscriber<? super T> paramSubscriber) {
    if (paramObject == COMPLETE) {
      paramSubscriber.onComplete();
      return true;
    } 
    if (paramObject instanceof ErrorNotification) {
      paramSubscriber.onError(((ErrorNotification)paramObject).e);
      return true;
    } 
    if (paramObject instanceof SubscriptionNotification) {
      paramSubscriber.onSubscribe(((SubscriptionNotification)paramObject).s);
      return false;
    } 
    paramSubscriber.onNext(paramObject);
    return false;
  }
  
  public static Object complete() {
    return COMPLETE;
  }
  
  public static Object disposable(Disposable paramDisposable) {
    return new DisposableNotification(paramDisposable);
  }
  
  public static Object error(Throwable paramThrowable) {
    return new ErrorNotification(paramThrowable);
  }
  
  public static Disposable getDisposable(Object paramObject) {
    return ((DisposableNotification)paramObject).d;
  }
  
  public static Throwable getError(Object paramObject) {
    return ((ErrorNotification)paramObject).e;
  }
  
  public static Subscription getSubscription(Object paramObject) {
    return ((SubscriptionNotification)paramObject).s;
  }
  
  public static <T> T getValue(Object paramObject) {
    return (T)paramObject;
  }
  
  public static boolean isComplete(Object paramObject) {
    boolean bool;
    if (paramObject == COMPLETE) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static boolean isDisposable(Object paramObject) {
    return paramObject instanceof DisposableNotification;
  }
  
  public static boolean isError(Object paramObject) {
    return paramObject instanceof ErrorNotification;
  }
  
  public static boolean isSubscription(Object paramObject) {
    return paramObject instanceof SubscriptionNotification;
  }
  
  public static <T> Object next(T paramT) {
    return paramT;
  }
  
  public static Object subscription(Subscription paramSubscription) {
    return new SubscriptionNotification(paramSubscription);
  }
  
  public String toString() {
    return "NotificationLite.Complete";
  }
  
  static final class DisposableNotification implements Serializable {
    private static final long serialVersionUID = -7482590109178395495L;
    
    final Disposable d;
    
    DisposableNotification(Disposable param1Disposable) {
      this.d = param1Disposable;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NotificationLite.Disposable[");
      stringBuilder.append(this.d);
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
  
  static final class ErrorNotification implements Serializable {
    private static final long serialVersionUID = -8759979445933046293L;
    
    final Throwable e;
    
    ErrorNotification(Throwable param1Throwable) {
      this.e = param1Throwable;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object instanceof ErrorNotification) {
        param1Object = param1Object;
        return ObjectHelper.equals(this.e, ((ErrorNotification)param1Object).e);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.e.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NotificationLite.Error[");
      stringBuilder.append(this.e);
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
  
  static final class SubscriptionNotification implements Serializable {
    private static final long serialVersionUID = -1322257508628817540L;
    
    final Subscription s;
    
    SubscriptionNotification(Subscription param1Subscription) {
      this.s = param1Subscription;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NotificationLite.Subscription[");
      stringBuilder.append(this.s);
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\interna\\util\NotificationLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */