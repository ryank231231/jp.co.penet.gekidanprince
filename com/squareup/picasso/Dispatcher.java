package com.squareup.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

class Dispatcher {
  static final int AIRPLANE_MODE_CHANGE = 10;
  
  private static final int AIRPLANE_MODE_OFF = 0;
  
  private static final int AIRPLANE_MODE_ON = 1;
  
  private static final int BATCH_DELAY = 200;
  
  private static final String DISPATCHER_THREAD_NAME = "Dispatcher";
  
  static final int HUNTER_BATCH_COMPLETE = 8;
  
  static final int HUNTER_COMPLETE = 4;
  
  static final int HUNTER_DECODE_FAILED = 6;
  
  static final int HUNTER_DELAY_NEXT_BATCH = 7;
  
  static final int HUNTER_RETRY = 5;
  
  static final int NETWORK_STATE_CHANGE = 9;
  
  static final int REQUEST_BATCH_RESUME = 13;
  
  static final int REQUEST_CANCEL = 2;
  
  static final int REQUEST_GCED = 3;
  
  static final int REQUEST_SUBMIT = 1;
  
  private static final int RETRY_DELAY = 500;
  
  static final int TAG_PAUSE = 11;
  
  static final int TAG_RESUME = 12;
  
  boolean airplaneMode;
  
  final List<BitmapHunter> batch;
  
  final Cache cache;
  
  final Context context;
  
  final DispatcherThread dispatcherThread = new DispatcherThread();
  
  final Downloader downloader;
  
  final Map<Object, Action> failedActions;
  
  final Handler handler;
  
  final Map<String, BitmapHunter> hunterMap;
  
  final Handler mainThreadHandler;
  
  final Map<Object, Action> pausedActions;
  
  final Set<Object> pausedTags;
  
  final NetworkBroadcastReceiver receiver;
  
  final boolean scansNetworkChanges;
  
  final ExecutorService service;
  
  final Stats stats;
  
  Dispatcher(Context paramContext, ExecutorService paramExecutorService, Handler paramHandler, Downloader paramDownloader, Cache paramCache, Stats paramStats) {
    this.dispatcherThread.start();
    Utils.flushStackLocalLeaks(this.dispatcherThread.getLooper());
    this.context = paramContext;
    this.service = paramExecutorService;
    this.hunterMap = new LinkedHashMap<String, BitmapHunter>();
    this.failedActions = new WeakHashMap<Object, Action>();
    this.pausedActions = new WeakHashMap<Object, Action>();
    this.pausedTags = new HashSet();
    this.handler = new DispatcherHandler(this.dispatcherThread.getLooper(), this);
    this.downloader = paramDownloader;
    this.mainThreadHandler = paramHandler;
    this.cache = paramCache;
    this.stats = paramStats;
    this.batch = new ArrayList<BitmapHunter>(4);
    this.airplaneMode = Utils.isAirplaneModeOn(this.context);
    this.scansNetworkChanges = Utils.hasPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE");
    this.receiver = new NetworkBroadcastReceiver(this);
    this.receiver.register();
  }
  
  private void batch(BitmapHunter paramBitmapHunter) {
    if (paramBitmapHunter.isCancelled())
      return; 
    this.batch.add(paramBitmapHunter);
    if (!this.handler.hasMessages(7))
      this.handler.sendEmptyMessageDelayed(7, 200L); 
  }
  
  private void flushFailedActions() {
    if (!this.failedActions.isEmpty()) {
      Iterator<Action> iterator = this.failedActions.values().iterator();
      while (iterator.hasNext()) {
        Action action = iterator.next();
        iterator.remove();
        if ((action.getPicasso()).loggingEnabled)
          Utils.log("Dispatcher", "replaying", action.getRequest().logId()); 
        performSubmit(action, false);
      } 
    } 
  }
  
  private void logBatch(List<BitmapHunter> paramList) {
    if (paramList == null || paramList.isEmpty())
      return; 
    if ((((BitmapHunter)paramList.get(0)).getPicasso()).loggingEnabled) {
      StringBuilder stringBuilder = new StringBuilder();
      for (BitmapHunter bitmapHunter : paramList) {
        if (stringBuilder.length() > 0)
          stringBuilder.append(", "); 
        stringBuilder.append(Utils.getLogIdsForHunter(bitmapHunter));
      } 
      Utils.log("Dispatcher", "delivered", stringBuilder.toString());
    } 
  }
  
  private void markForReplay(Action<Object> paramAction) {
    Object object = paramAction.getTarget();
    if (object != null) {
      paramAction.willReplay = true;
      this.failedActions.put(object, paramAction);
    } 
  }
  
  private void markForReplay(BitmapHunter paramBitmapHunter) {
    Action action = paramBitmapHunter.getAction();
    if (action != null)
      markForReplay(action); 
    List<Action> list = paramBitmapHunter.getActions();
    if (list != null) {
      byte b = 0;
      int i = list.size();
      while (b < i) {
        markForReplay(list.get(b));
        b++;
      } 
    } 
  }
  
  void dispatchAirplaneModeChange(boolean paramBoolean) {
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(10, paramBoolean, 0));
  }
  
  void dispatchCancel(Action paramAction) {
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(2, paramAction));
  }
  
  void dispatchComplete(BitmapHunter paramBitmapHunter) {
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(4, paramBitmapHunter));
  }
  
  void dispatchFailed(BitmapHunter paramBitmapHunter) {
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(6, paramBitmapHunter));
  }
  
  void dispatchNetworkStateChange(NetworkInfo paramNetworkInfo) {
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(9, paramNetworkInfo));
  }
  
  void dispatchPauseTag(Object paramObject) {
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(11, paramObject));
  }
  
  void dispatchResumeTag(Object paramObject) {
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(12, paramObject));
  }
  
  void dispatchRetry(BitmapHunter paramBitmapHunter) {
    Handler handler = this.handler;
    handler.sendMessageDelayed(handler.obtainMessage(5, paramBitmapHunter), 500L);
  }
  
  void dispatchSubmit(Action paramAction) {
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(1, paramAction));
  }
  
  void performAirplaneModeChange(boolean paramBoolean) {
    this.airplaneMode = paramBoolean;
  }
  
  void performBatchComplete() {
    ArrayList<BitmapHunter> arrayList = new ArrayList<BitmapHunter>(this.batch);
    this.batch.clear();
    Handler handler = this.mainThreadHandler;
    handler.sendMessage(handler.obtainMessage(8, arrayList));
    logBatch(arrayList);
  }
  
  void performCancel(Action paramAction) {
    String str = paramAction.getKey();
    BitmapHunter bitmapHunter = this.hunterMap.get(str);
    if (bitmapHunter != null) {
      bitmapHunter.detach(paramAction);
      if (bitmapHunter.cancel()) {
        this.hunterMap.remove(str);
        if ((paramAction.getPicasso()).loggingEnabled)
          Utils.log("Dispatcher", "canceled", paramAction.getRequest().logId()); 
      } 
    } 
    if (this.pausedTags.contains(paramAction.getTag())) {
      this.pausedActions.remove(paramAction.getTarget());
      if ((paramAction.getPicasso()).loggingEnabled)
        Utils.log("Dispatcher", "canceled", paramAction.getRequest().logId(), "because paused request got canceled"); 
    } 
    paramAction = this.failedActions.remove(paramAction.getTarget());
    if (paramAction != null && (paramAction.getPicasso()).loggingEnabled)
      Utils.log("Dispatcher", "canceled", paramAction.getRequest().logId(), "from replaying"); 
  }
  
  void performComplete(BitmapHunter paramBitmapHunter) {
    if (MemoryPolicy.shouldWriteToMemoryCache(paramBitmapHunter.getMemoryPolicy()))
      this.cache.set(paramBitmapHunter.getKey(), paramBitmapHunter.getResult()); 
    this.hunterMap.remove(paramBitmapHunter.getKey());
    batch(paramBitmapHunter);
    if ((paramBitmapHunter.getPicasso()).loggingEnabled)
      Utils.log("Dispatcher", "batched", Utils.getLogIdsForHunter(paramBitmapHunter), "for completion"); 
  }
  
  void performError(BitmapHunter paramBitmapHunter, boolean paramBoolean) {
    if ((paramBitmapHunter.getPicasso()).loggingEnabled) {
      String str2;
      String str1 = Utils.getLogIdsForHunter(paramBitmapHunter);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("for error");
      if (paramBoolean) {
        str2 = " (will replay)";
      } else {
        str2 = "";
      } 
      stringBuilder.append(str2);
      Utils.log("Dispatcher", "batched", str1, stringBuilder.toString());
    } 
    this.hunterMap.remove(paramBitmapHunter.getKey());
    batch(paramBitmapHunter);
  }
  
  void performNetworkStateChange(NetworkInfo paramNetworkInfo) {
    ExecutorService executorService = this.service;
    if (executorService instanceof PicassoExecutorService)
      ((PicassoExecutorService)executorService).adjustThreadCount(paramNetworkInfo); 
    if (paramNetworkInfo != null && paramNetworkInfo.isConnected())
      flushFailedActions(); 
  }
  
  void performPauseTag(Object paramObject) {
    if (!this.pausedTags.add(paramObject))
      return; 
    Iterator<BitmapHunter> iterator = this.hunterMap.values().iterator();
    while (iterator.hasNext()) {
      int i;
      BitmapHunter bitmapHunter = iterator.next();
      boolean bool = (bitmapHunter.getPicasso()).loggingEnabled;
      Action action = bitmapHunter.getAction();
      List<Action> list = bitmapHunter.getActions();
      if (list != null && !list.isEmpty()) {
        i = 1;
      } else {
        i = 0;
      } 
      if (action == null && !i)
        continue; 
      if (action != null && action.getTag().equals(paramObject)) {
        bitmapHunter.detach(action);
        this.pausedActions.put(action.getTarget(), action);
        if (bool) {
          String str = action.request.logId();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("because tag '");
          stringBuilder.append(paramObject);
          stringBuilder.append("' was paused");
          Utils.log("Dispatcher", "paused", str, stringBuilder.toString());
        } 
      } 
      if (i)
        for (i = list.size() - 1; i >= 0; i--) {
          action = list.get(i);
          if (action.getTag().equals(paramObject)) {
            bitmapHunter.detach(action);
            this.pausedActions.put(action.getTarget(), action);
            if (bool) {
              String str = action.request.logId();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("because tag '");
              stringBuilder.append(paramObject);
              stringBuilder.append("' was paused");
              Utils.log("Dispatcher", "paused", str, stringBuilder.toString());
            } 
          } 
        }  
      if (bitmapHunter.cancel()) {
        iterator.remove();
        if (bool)
          Utils.log("Dispatcher", "canceled", Utils.getLogIdsForHunter(bitmapHunter), "all actions paused"); 
      } 
    } 
  }
  
  void performResumeTag(Object paramObject) {
    if (!this.pausedTags.remove(paramObject))
      return; 
    ArrayList<Action> arrayList = null;
    Iterator<Action> iterator = this.pausedActions.values().iterator();
    while (iterator.hasNext()) {
      Action action = iterator.next();
      if (action.getTag().equals(paramObject)) {
        ArrayList<Action> arrayList1 = arrayList;
        if (arrayList == null)
          arrayList1 = new ArrayList(); 
        arrayList1.add(action);
        iterator.remove();
        arrayList = arrayList1;
      } 
    } 
    if (arrayList != null) {
      paramObject = this.mainThreadHandler;
      paramObject.sendMessage(paramObject.obtainMessage(13, arrayList));
    } 
  }
  
  void performRetry(BitmapHunter paramBitmapHunter) {
    boolean bool3;
    if (paramBitmapHunter.isCancelled())
      return; 
    boolean bool1 = this.service.isShutdown();
    boolean bool2 = false;
    if (bool1) {
      performError(paramBitmapHunter, false);
      return;
    } 
    NetworkInfo networkInfo = null;
    if (this.scansNetworkChanges)
      networkInfo = ((ConnectivityManager)Utils.<ConnectivityManager>getService(this.context, "connectivity")).getActiveNetworkInfo(); 
    if (networkInfo != null && networkInfo.isConnected()) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    bool1 = paramBitmapHunter.shouldRetry(this.airplaneMode, networkInfo);
    boolean bool4 = paramBitmapHunter.supportsReplay();
    if (!bool1) {
      bool1 = bool2;
      if (this.scansNetworkChanges) {
        bool1 = bool2;
        if (bool4)
          bool1 = true; 
      } 
      performError(paramBitmapHunter, bool1);
      if (bool1)
        markForReplay(paramBitmapHunter); 
      return;
    } 
    if (!this.scansNetworkChanges || bool3) {
      if ((paramBitmapHunter.getPicasso()).loggingEnabled)
        Utils.log("Dispatcher", "retrying", Utils.getLogIdsForHunter(paramBitmapHunter)); 
      if (paramBitmapHunter.getException() instanceof NetworkRequestHandler.ContentLengthException)
        paramBitmapHunter.networkPolicy |= NetworkPolicy.NO_CACHE.index; 
      paramBitmapHunter.future = this.service.submit(paramBitmapHunter);
      return;
    } 
    performError(paramBitmapHunter, bool4);
    if (bool4)
      markForReplay(paramBitmapHunter); 
  }
  
  void performSubmit(Action paramAction) {
    performSubmit(paramAction, true);
  }
  
  void performSubmit(Action paramAction, boolean paramBoolean) {
    if (this.pausedTags.contains(paramAction.getTag())) {
      this.pausedActions.put(paramAction.getTarget(), paramAction);
      if ((paramAction.getPicasso()).loggingEnabled) {
        String str = paramAction.request.logId();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("because tag '");
        stringBuilder.append(paramAction.getTag());
        stringBuilder.append("' is paused");
        Utils.log("Dispatcher", "paused", str, stringBuilder.toString());
      } 
      return;
    } 
    BitmapHunter bitmapHunter = this.hunterMap.get(paramAction.getKey());
    if (bitmapHunter != null) {
      bitmapHunter.attach(paramAction);
      return;
    } 
    if (this.service.isShutdown()) {
      if ((paramAction.getPicasso()).loggingEnabled)
        Utils.log("Dispatcher", "ignored", paramAction.request.logId(), "because shut down"); 
      return;
    } 
    bitmapHunter = BitmapHunter.forRequest(paramAction.getPicasso(), this, this.cache, this.stats, paramAction);
    bitmapHunter.future = this.service.submit(bitmapHunter);
    this.hunterMap.put(paramAction.getKey(), bitmapHunter);
    if (paramBoolean)
      this.failedActions.remove(paramAction.getTarget()); 
    if ((paramAction.getPicasso()).loggingEnabled)
      Utils.log("Dispatcher", "enqueued", paramAction.request.logId()); 
  }
  
  void shutdown() {
    ExecutorService executorService = this.service;
    if (executorService instanceof PicassoExecutorService)
      executorService.shutdown(); 
    this.downloader.shutdown();
    this.dispatcherThread.quit();
    Picasso.HANDLER.post(new Runnable() {
          public void run() {
            Dispatcher.this.receiver.unregister();
          }
        });
  }
  
  private static class DispatcherHandler extends Handler {
    private final Dispatcher dispatcher;
    
    public DispatcherHandler(Looper param1Looper, Dispatcher param1Dispatcher) {
      super(param1Looper);
      this.dispatcher = param1Dispatcher;
    }
    
    public void handleMessage(final Message msg) {
      Dispatcher dispatcher;
      int i = msg.what;
      boolean bool = false;
      switch (i) {
        default:
          Picasso.HANDLER.post(new Runnable() {
                public void run() {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("Unknown handler message received: ");
                  stringBuilder.append(msg.what);
                  throw new AssertionError(stringBuilder.toString());
                }
              });
          return;
        case 12:
          object = msg.obj;
          this.dispatcher.performResumeTag(object);
          return;
        case 11:
          object = ((Message)object).obj;
          this.dispatcher.performPauseTag(object);
          return;
        case 10:
          dispatcher = this.dispatcher;
          if (((Message)object).arg1 == 1)
            bool = true; 
          dispatcher.performAirplaneModeChange(bool);
          return;
        case 9:
          object = ((Message)object).obj;
          this.dispatcher.performNetworkStateChange((NetworkInfo)object);
          return;
        case 7:
          this.dispatcher.performBatchComplete();
          return;
        case 6:
          object = ((Message)object).obj;
          this.dispatcher.performError((BitmapHunter)object, false);
          return;
        case 5:
          object = ((Message)object).obj;
          this.dispatcher.performRetry((BitmapHunter)object);
          return;
        case 4:
          object = ((Message)object).obj;
          this.dispatcher.performComplete((BitmapHunter)object);
          return;
        case 2:
          object = ((Message)object).obj;
          this.dispatcher.performCancel((Action)object);
          return;
        case 1:
          break;
      } 
      Object object = ((Message)object).obj;
      this.dispatcher.performSubmit((Action)object);
    }
  }
  
  class null implements Runnable {
    public void run() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unknown handler message received: ");
      stringBuilder.append(msg.what);
      throw new AssertionError(stringBuilder.toString());
    }
  }
  
  static class DispatcherThread extends HandlerThread {
    DispatcherThread() {
      super("Picasso-Dispatcher", 10);
    }
  }
  
  static class NetworkBroadcastReceiver extends BroadcastReceiver {
    static final String EXTRA_AIRPLANE_STATE = "state";
    
    private final Dispatcher dispatcher;
    
    NetworkBroadcastReceiver(Dispatcher param1Dispatcher) {
      this.dispatcher = param1Dispatcher;
    }
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      if (param1Intent == null)
        return; 
      String str = param1Intent.getAction();
      if ("android.intent.action.AIRPLANE_MODE".equals(str)) {
        if (!param1Intent.hasExtra("state"))
          return; 
        this.dispatcher.dispatchAirplaneModeChange(param1Intent.getBooleanExtra("state", false));
      } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str)) {
        ConnectivityManager connectivityManager = Utils.<ConnectivityManager>getService(param1Context, "connectivity");
        this.dispatcher.dispatchNetworkStateChange(connectivityManager.getActiveNetworkInfo());
      } 
    }
    
    void register() {
      IntentFilter intentFilter = new IntentFilter();
      intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
      if (this.dispatcher.scansNetworkChanges)
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE"); 
      this.dispatcher.context.registerReceiver(this, intentFilter);
    }
    
    void unregister() {
      this.dispatcher.context.unregisterReceiver(this);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\picasso\Dispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */