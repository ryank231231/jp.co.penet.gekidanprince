package com.google.firebase.inappmessaging.internal;

import android.support.annotation.NonNull;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingClickListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayErrorListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingImpressionListener;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DeveloperListenerManager {
  private static final ThreadPoolExecutor CALLBACK_QUEUE_EXECUTOR;
  
  private static final int KEEP_ALIVE_TIME_SECONDS = 15;
  
  private static final int POOL_SIZE = 1;
  
  public static DeveloperListenerManager instance = new DeveloperListenerManager();
  
  private static BlockingQueue<Runnable> mCallbackQueue = new LinkedBlockingQueue<Runnable>();
  
  private Map<FirebaseInAppMessagingClickListener, ClicksExecutorAndListener> registeredClickListeners = new HashMap<FirebaseInAppMessagingClickListener, ClicksExecutorAndListener>();
  
  private Map<FirebaseInAppMessagingDisplayErrorListener, ErrorsExecutorAndListener> registeredErrorListeners = new HashMap<FirebaseInAppMessagingDisplayErrorListener, ErrorsExecutorAndListener>();
  
  private Map<FirebaseInAppMessagingImpressionListener, ImpressionExecutorAndListener> registeredImpressionListeners = new HashMap<FirebaseInAppMessagingImpressionListener, ImpressionExecutorAndListener>();
  
  static {
    CALLBACK_QUEUE_EXECUTOR = new ThreadPoolExecutor(1, 1, 15L, TimeUnit.SECONDS, mCallbackQueue, new FIAMThreadFactory("EventListeners-"));
    CALLBACK_QUEUE_EXECUTOR.allowCoreThreadTimeOut(true);
  }
  
  public void addClickListener(FirebaseInAppMessagingClickListener paramFirebaseInAppMessagingClickListener) {
    this.registeredClickListeners.put(paramFirebaseInAppMessagingClickListener, new ClicksExecutorAndListener(paramFirebaseInAppMessagingClickListener));
  }
  
  public void addClickListener(FirebaseInAppMessagingClickListener paramFirebaseInAppMessagingClickListener, Executor paramExecutor) {
    this.registeredClickListeners.put(paramFirebaseInAppMessagingClickListener, new ClicksExecutorAndListener(paramFirebaseInAppMessagingClickListener, paramExecutor));
  }
  
  public void addDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener paramFirebaseInAppMessagingDisplayErrorListener) {
    this.registeredErrorListeners.put(paramFirebaseInAppMessagingDisplayErrorListener, new ErrorsExecutorAndListener(paramFirebaseInAppMessagingDisplayErrorListener));
  }
  
  public void addDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener paramFirebaseInAppMessagingDisplayErrorListener, Executor paramExecutor) {
    this.registeredErrorListeners.put(paramFirebaseInAppMessagingDisplayErrorListener, new ErrorsExecutorAndListener(paramFirebaseInAppMessagingDisplayErrorListener, paramExecutor));
  }
  
  public void addImpressionListener(FirebaseInAppMessagingImpressionListener paramFirebaseInAppMessagingImpressionListener) {
    this.registeredImpressionListeners.put(paramFirebaseInAppMessagingImpressionListener, new ImpressionExecutorAndListener(paramFirebaseInAppMessagingImpressionListener));
  }
  
  public void addImpressionListener(FirebaseInAppMessagingImpressionListener paramFirebaseInAppMessagingImpressionListener, Executor paramExecutor) {
    this.registeredImpressionListeners.put(paramFirebaseInAppMessagingImpressionListener, new ImpressionExecutorAndListener(paramFirebaseInAppMessagingImpressionListener, paramExecutor));
  }
  
  public void displayErrorEncountered(InAppMessage paramInAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason paramInAppMessagingErrorReason) {
    for (ErrorsExecutorAndListener errorsExecutorAndListener : this.registeredErrorListeners.values())
      errorsExecutorAndListener.withExecutor(CALLBACK_QUEUE_EXECUTOR).execute(DeveloperListenerManager$$Lambda$2.lambdaFactory$(errorsExecutorAndListener, paramInAppMessage, paramInAppMessagingErrorReason)); 
  }
  
  public void impressionDetected(InAppMessage paramInAppMessage) {
    for (ImpressionExecutorAndListener impressionExecutorAndListener : this.registeredImpressionListeners.values())
      impressionExecutorAndListener.withExecutor(CALLBACK_QUEUE_EXECUTOR).execute(DeveloperListenerManager$$Lambda$1.lambdaFactory$(impressionExecutorAndListener, paramInAppMessage)); 
  }
  
  public void messageClicked(InAppMessage paramInAppMessage, Action paramAction) {
    for (ClicksExecutorAndListener clicksExecutorAndListener : this.registeredClickListeners.values())
      clicksExecutorAndListener.withExecutor(CALLBACK_QUEUE_EXECUTOR).execute(DeveloperListenerManager$$Lambda$3.lambdaFactory$(clicksExecutorAndListener, paramInAppMessage, paramAction)); 
  }
  
  public void removeClickListener(FirebaseInAppMessagingClickListener paramFirebaseInAppMessagingClickListener) {
    this.registeredClickListeners.remove(paramFirebaseInAppMessagingClickListener);
  }
  
  public void removeDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener paramFirebaseInAppMessagingDisplayErrorListener) {
    this.registeredErrorListeners.remove(paramFirebaseInAppMessagingDisplayErrorListener);
  }
  
  public void removeImpressionListener(FirebaseInAppMessagingImpressionListener paramFirebaseInAppMessagingImpressionListener) {
    this.registeredImpressionListeners.remove(paramFirebaseInAppMessagingImpressionListener);
  }
  
  private class ClicksExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingClickListener> {
    FirebaseInAppMessagingClickListener listener;
    
    public ClicksExecutorAndListener(FirebaseInAppMessagingClickListener param1FirebaseInAppMessagingClickListener) {
      super(null);
      this.listener = param1FirebaseInAppMessagingClickListener;
    }
    
    public ClicksExecutorAndListener(FirebaseInAppMessagingClickListener param1FirebaseInAppMessagingClickListener, Executor param1Executor) {
      super(param1Executor);
      this.listener = param1FirebaseInAppMessagingClickListener;
    }
    
    public FirebaseInAppMessagingClickListener getListener() {
      return this.listener;
    }
  }
  
  private class ErrorsExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingDisplayErrorListener> {
    FirebaseInAppMessagingDisplayErrorListener listener;
    
    public ErrorsExecutorAndListener(FirebaseInAppMessagingDisplayErrorListener param1FirebaseInAppMessagingDisplayErrorListener) {
      super(null);
      this.listener = param1FirebaseInAppMessagingDisplayErrorListener;
    }
    
    public ErrorsExecutorAndListener(FirebaseInAppMessagingDisplayErrorListener param1FirebaseInAppMessagingDisplayErrorListener, Executor param1Executor) {
      super(param1Executor);
      this.listener = param1FirebaseInAppMessagingDisplayErrorListener;
    }
    
    public FirebaseInAppMessagingDisplayErrorListener getListener() {
      return this.listener;
    }
  }
  
  private abstract class ExecutorAndListener<T> {
    private final Executor executor;
    
    public ExecutorAndListener(Executor param1Executor) {
      this.executor = param1Executor;
    }
    
    public abstract T getListener();
    
    public Executor withExecutor(Executor param1Executor) {
      Executor executor = this.executor;
      return (executor == null) ? param1Executor : executor;
    }
  }
  
  static class FIAMThreadFactory implements ThreadFactory {
    private final String mNameSuffix;
    
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    
    FIAMThreadFactory(@NonNull String param1String) {
      this.mNameSuffix = param1String;
    }
    
    public Thread newThread(@NonNull Runnable param1Runnable) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("FIAM-");
      stringBuilder.append(this.mNameSuffix);
      stringBuilder.append(this.threadNumber.getAndIncrement());
      param1Runnable = new Thread(param1Runnable, stringBuilder.toString());
      param1Runnable.setDaemon(false);
      param1Runnable.setPriority(9);
      return (Thread)param1Runnable;
    }
  }
  
  private class ImpressionExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingImpressionListener> {
    FirebaseInAppMessagingImpressionListener listener;
    
    public ImpressionExecutorAndListener(FirebaseInAppMessagingImpressionListener param1FirebaseInAppMessagingImpressionListener) {
      super(null);
      this.listener = param1FirebaseInAppMessagingImpressionListener;
    }
    
    public ImpressionExecutorAndListener(FirebaseInAppMessagingImpressionListener param1FirebaseInAppMessagingImpressionListener, Executor param1Executor) {
      super(param1Executor);
      this.listener = param1FirebaseInAppMessagingImpressionListener;
    }
    
    public FirebaseInAppMessagingImpressionListener getListener() {
      return this.listener;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\DeveloperListenerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */