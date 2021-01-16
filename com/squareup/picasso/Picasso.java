package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import android.widget.RemoteViews;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class Picasso {
  static final Handler HANDLER = new Handler(Looper.getMainLooper()) {
      public void handleMessage(Message param1Message) {
        List<BitmapHunter> list;
        int i = param1Message.what;
        if (i != 3) {
          Action action;
          int j = 0;
          int k = 0;
          if (i != 8) {
            if (i == 13) {
              List<Action> list1 = (List)param1Message.obj;
              j = list1.size();
              while (k < j) {
                action = list1.get(k);
                action.picasso.resumeAction(action);
                k++;
              } 
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Unknown handler message received: ");
              stringBuilder.append(((Message)action).what);
              throw new AssertionError(stringBuilder.toString());
            } 
          } else {
            list = (List)((Message)action).obj;
            i = list.size();
            for (k = j; k < i; k++) {
              BitmapHunter bitmapHunter = list.get(k);
              bitmapHunter.picasso.complete(bitmapHunter);
            } 
          } 
        } else {
          Action action = (Action)((Message)list).obj;
          if ((action.getPicasso()).loggingEnabled)
            Utils.log("Main", "canceled", action.request.logId(), "target got garbage collected"); 
          action.picasso.cancelExistingRequest(action.getTarget());
        } 
      }
    };
  
  static final String TAG = "Picasso";
  
  static volatile Picasso singleton = null;
  
  final Cache cache;
  
  private final CleanupThread cleanupThread;
  
  final Context context;
  
  final Bitmap.Config defaultBitmapConfig;
  
  final Dispatcher dispatcher;
  
  boolean indicatorsEnabled;
  
  private final Listener listener;
  
  volatile boolean loggingEnabled;
  
  final ReferenceQueue<Object> referenceQueue;
  
  private final List<RequestHandler> requestHandlers;
  
  private final RequestTransformer requestTransformer;
  
  boolean shutdown;
  
  final Stats stats;
  
  final Map<Object, Action> targetToAction;
  
  final Map<ImageView, DeferredRequestCreator> targetToDeferredRequestCreator;
  
  Picasso(Context paramContext, Dispatcher paramDispatcher, Cache paramCache, Listener paramListener, RequestTransformer paramRequestTransformer, List<RequestHandler> paramList, Stats paramStats, Bitmap.Config paramConfig, boolean paramBoolean1, boolean paramBoolean2) {
    byte b;
    this.context = paramContext;
    this.dispatcher = paramDispatcher;
    this.cache = paramCache;
    this.listener = paramListener;
    this.requestTransformer = paramRequestTransformer;
    this.defaultBitmapConfig = paramConfig;
    if (paramList != null) {
      b = paramList.size();
    } else {
      b = 0;
    } 
    ArrayList<ResourceRequestHandler> arrayList = new ArrayList(b + 7);
    arrayList.add(new ResourceRequestHandler(paramContext));
    if (paramList != null)
      arrayList.addAll(paramList); 
    arrayList.add(new ContactsPhotoRequestHandler(paramContext));
    arrayList.add(new MediaStoreRequestHandler(paramContext));
    arrayList.add(new ContentStreamRequestHandler(paramContext));
    arrayList.add(new AssetRequestHandler(paramContext));
    arrayList.add(new FileRequestHandler(paramContext));
    arrayList.add(new NetworkRequestHandler(paramDispatcher.downloader, paramStats));
    this.requestHandlers = Collections.unmodifiableList((List)arrayList);
    this.stats = paramStats;
    this.targetToAction = new WeakHashMap<Object, Action>();
    this.targetToDeferredRequestCreator = new WeakHashMap<ImageView, DeferredRequestCreator>();
    this.indicatorsEnabled = paramBoolean1;
    this.loggingEnabled = paramBoolean2;
    this.referenceQueue = new ReferenceQueue();
    this.cleanupThread = new CleanupThread(this.referenceQueue, HANDLER);
    this.cleanupThread.start();
  }
  
  private void cancelExistingRequest(Object paramObject) {
    Utils.checkMain();
    Action action = this.targetToAction.remove(paramObject);
    if (action != null) {
      action.cancel();
      this.dispatcher.dispatchCancel(action);
    } 
    if (paramObject instanceof ImageView) {
      paramObject = paramObject;
      paramObject = this.targetToDeferredRequestCreator.remove(paramObject);
      if (paramObject != null)
        paramObject.cancel(); 
    } 
  }
  
  private void deliverAction(Bitmap paramBitmap, LoadedFrom paramLoadedFrom, Action paramAction) {
    String str;
    if (paramAction.isCancelled())
      return; 
    if (!paramAction.willReplay())
      this.targetToAction.remove(paramAction.getTarget()); 
    if (paramBitmap != null) {
      if (paramLoadedFrom != null) {
        paramAction.complete(paramBitmap, paramLoadedFrom);
        if (this.loggingEnabled) {
          str = paramAction.request.logId();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("from ");
          stringBuilder.append(paramLoadedFrom);
          Utils.log("Main", "completed", str, stringBuilder.toString());
        } 
      } else {
        throw new AssertionError("LoadedFrom cannot be null.");
      } 
    } else {
      str.error();
      if (this.loggingEnabled)
        Utils.log("Main", "errored", ((Action)str).request.logId()); 
    } 
  }
  
  public static void setSingletonInstance(Picasso paramPicasso) {
    // Byte code:
    //   0: ldc com/squareup/picasso/Picasso
    //   2: monitorenter
    //   3: getstatic com/squareup/picasso/Picasso.singleton : Lcom/squareup/picasso/Picasso;
    //   6: ifnonnull -> 17
    //   9: aload_0
    //   10: putstatic com/squareup/picasso/Picasso.singleton : Lcom/squareup/picasso/Picasso;
    //   13: ldc com/squareup/picasso/Picasso
    //   15: monitorexit
    //   16: return
    //   17: new java/lang/IllegalStateException
    //   20: astore_0
    //   21: aload_0
    //   22: ldc_w 'Singleton instance already exists.'
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: aload_0
    //   29: athrow
    //   30: astore_0
    //   31: ldc com/squareup/picasso/Picasso
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	30	finally
    //   17	30	30	finally
    //   31	34	30	finally
  }
  
  public static Picasso with(Context paramContext) {
    // Byte code:
    //   0: getstatic com/squareup/picasso/Picasso.singleton : Lcom/squareup/picasso/Picasso;
    //   3: ifnonnull -> 43
    //   6: ldc com/squareup/picasso/Picasso
    //   8: monitorenter
    //   9: getstatic com/squareup/picasso/Picasso.singleton : Lcom/squareup/picasso/Picasso;
    //   12: ifnonnull -> 31
    //   15: new com/squareup/picasso/Picasso$Builder
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: aload_1
    //   25: invokevirtual build : ()Lcom/squareup/picasso/Picasso;
    //   28: putstatic com/squareup/picasso/Picasso.singleton : Lcom/squareup/picasso/Picasso;
    //   31: ldc com/squareup/picasso/Picasso
    //   33: monitorexit
    //   34: goto -> 43
    //   37: astore_0
    //   38: ldc com/squareup/picasso/Picasso
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    //   43: getstatic com/squareup/picasso/Picasso.singleton : Lcom/squareup/picasso/Picasso;
    //   46: areturn
    // Exception table:
    //   from	to	target	type
    //   9	31	37	finally
    //   31	34	37	finally
    //   38	41	37	finally
  }
  
  public boolean areIndicatorsEnabled() {
    return this.indicatorsEnabled;
  }
  
  public void cancelRequest(ImageView paramImageView) {
    cancelExistingRequest(paramImageView);
  }
  
  public void cancelRequest(RemoteViews paramRemoteViews, int paramInt) {
    cancelExistingRequest(new RemoteViewsAction.RemoteViewsTarget(paramRemoteViews, paramInt));
  }
  
  public void cancelRequest(Target paramTarget) {
    cancelExistingRequest(paramTarget);
  }
  
  public void cancelTag(Object paramObject) {
    Utils.checkMain();
    ArrayList<Action> arrayList = new ArrayList(this.targetToAction.values());
    int i = arrayList.size();
    for (byte b = 0; b < i; b++) {
      Action action = arrayList.get(b);
      if (action.getTag().equals(paramObject))
        cancelExistingRequest(action.getTarget()); 
    } 
  }
  
  void complete(BitmapHunter paramBitmapHunter) {
    byte b3;
    Action action = paramBitmapHunter.getAction();
    List<Action> list = paramBitmapHunter.getActions();
    byte b1 = 1;
    byte b2 = 0;
    if (list != null && !list.isEmpty()) {
      b3 = 1;
    } else {
      b3 = 0;
    } 
    int i = b1;
    if (action == null)
      if (b3) {
        i = b1;
      } else {
        i = 0;
      }  
    if (!i)
      return; 
    Uri uri = (paramBitmapHunter.getData()).uri;
    Exception exception = paramBitmapHunter.getException();
    Bitmap bitmap = paramBitmapHunter.getResult();
    LoadedFrom loadedFrom = paramBitmapHunter.getLoadedFrom();
    if (action != null)
      deliverAction(bitmap, loadedFrom, action); 
    if (b3) {
      i = list.size();
      for (b3 = b2; b3 < i; b3++)
        deliverAction(bitmap, loadedFrom, list.get(b3)); 
    } 
    Listener listener = this.listener;
    if (listener != null && exception != null)
      listener.onImageLoadFailed(this, uri, exception); 
  }
  
  void defer(ImageView paramImageView, DeferredRequestCreator paramDeferredRequestCreator) {
    this.targetToDeferredRequestCreator.put(paramImageView, paramDeferredRequestCreator);
  }
  
  void enqueueAndSubmit(Action<Object> paramAction) {
    Object object = paramAction.getTarget();
    if (object != null && this.targetToAction.get(object) != paramAction) {
      cancelExistingRequest(object);
      this.targetToAction.put(object, paramAction);
    } 
    submit(paramAction);
  }
  
  List<RequestHandler> getRequestHandlers() {
    return this.requestHandlers;
  }
  
  public StatsSnapshot getSnapshot() {
    return this.stats.createSnapshot();
  }
  
  public void invalidate(Uri paramUri) {
    if (paramUri != null) {
      this.cache.clearKeyUri(paramUri.toString());
      return;
    } 
    throw new IllegalArgumentException("uri == null");
  }
  
  public void invalidate(File paramFile) {
    if (paramFile != null) {
      invalidate(Uri.fromFile(paramFile));
      return;
    } 
    throw new IllegalArgumentException("file == null");
  }
  
  public void invalidate(String paramString) {
    if (paramString != null) {
      invalidate(Uri.parse(paramString));
      return;
    } 
    throw new IllegalArgumentException("path == null");
  }
  
  @Deprecated
  public boolean isDebugging() {
    boolean bool;
    if (areIndicatorsEnabled() && isLoggingEnabled()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isLoggingEnabled() {
    return this.loggingEnabled;
  }
  
  public RequestCreator load(int paramInt) {
    if (paramInt != 0)
      return new RequestCreator(this, null, paramInt); 
    throw new IllegalArgumentException("Resource ID must not be zero.");
  }
  
  public RequestCreator load(Uri paramUri) {
    return new RequestCreator(this, paramUri, 0);
  }
  
  public RequestCreator load(File paramFile) {
    return (paramFile == null) ? new RequestCreator(this, null, 0) : load(Uri.fromFile(paramFile));
  }
  
  public RequestCreator load(String paramString) {
    if (paramString == null)
      return new RequestCreator(this, null, 0); 
    if (paramString.trim().length() != 0)
      return load(Uri.parse(paramString)); 
    throw new IllegalArgumentException("Path must not be empty.");
  }
  
  public void pauseTag(Object paramObject) {
    this.dispatcher.dispatchPauseTag(paramObject);
  }
  
  Bitmap quickMemoryCacheCheck(String paramString) {
    Bitmap bitmap = this.cache.get(paramString);
    if (bitmap != null) {
      this.stats.dispatchCacheHit();
    } else {
      this.stats.dispatchCacheMiss();
    } 
    return bitmap;
  }
  
  void resumeAction(Action paramAction) {
    StringBuilder stringBuilder;
    Bitmap bitmap;
    if (MemoryPolicy.shouldReadFromMemoryCache(paramAction.memoryPolicy)) {
      bitmap = quickMemoryCacheCheck(paramAction.getKey());
    } else {
      bitmap = null;
    } 
    if (bitmap != null) {
      deliverAction(bitmap, LoadedFrom.MEMORY, paramAction);
      if (this.loggingEnabled) {
        String str = paramAction.request.logId();
        stringBuilder = new StringBuilder();
        stringBuilder.append("from ");
        stringBuilder.append(LoadedFrom.MEMORY);
        Utils.log("Main", "completed", str, stringBuilder.toString());
      } 
    } else {
      enqueueAndSubmit((Action)stringBuilder);
      if (this.loggingEnabled)
        Utils.log("Main", "resumed", ((Action)stringBuilder).request.logId()); 
    } 
  }
  
  public void resumeTag(Object paramObject) {
    this.dispatcher.dispatchResumeTag(paramObject);
  }
  
  @Deprecated
  public void setDebugging(boolean paramBoolean) {
    setIndicatorsEnabled(paramBoolean);
  }
  
  public void setIndicatorsEnabled(boolean paramBoolean) {
    this.indicatorsEnabled = paramBoolean;
  }
  
  public void setLoggingEnabled(boolean paramBoolean) {
    this.loggingEnabled = paramBoolean;
  }
  
  public void shutdown() {
    if (this != singleton) {
      if (this.shutdown)
        return; 
      this.cache.clear();
      this.cleanupThread.shutdown();
      this.stats.shutdown();
      this.dispatcher.shutdown();
      Iterator<DeferredRequestCreator> iterator = this.targetToDeferredRequestCreator.values().iterator();
      while (iterator.hasNext())
        ((DeferredRequestCreator)iterator.next()).cancel(); 
      this.targetToDeferredRequestCreator.clear();
      this.shutdown = true;
      return;
    } 
    throw new UnsupportedOperationException("Default singleton instance cannot be shutdown.");
  }
  
  void submit(Action paramAction) {
    this.dispatcher.dispatchSubmit(paramAction);
  }
  
  Request transformRequest(Request paramRequest) {
    Request request = this.requestTransformer.transformRequest(paramRequest);
    if (request != null)
      return request; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Request transformer ");
    stringBuilder.append(this.requestTransformer.getClass().getCanonicalName());
    stringBuilder.append(" returned null for ");
    stringBuilder.append(paramRequest);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public static class Builder {
    private Cache cache;
    
    private final Context context;
    
    private Bitmap.Config defaultBitmapConfig;
    
    private Downloader downloader;
    
    private boolean indicatorsEnabled;
    
    private Picasso.Listener listener;
    
    private boolean loggingEnabled;
    
    private List<RequestHandler> requestHandlers;
    
    private ExecutorService service;
    
    private Picasso.RequestTransformer transformer;
    
    public Builder(Context param1Context) {
      if (param1Context != null) {
        this.context = param1Context.getApplicationContext();
        return;
      } 
      throw new IllegalArgumentException("Context must not be null.");
    }
    
    public Builder addRequestHandler(RequestHandler param1RequestHandler) {
      if (param1RequestHandler != null) {
        if (this.requestHandlers == null)
          this.requestHandlers = new ArrayList<RequestHandler>(); 
        if (!this.requestHandlers.contains(param1RequestHandler)) {
          this.requestHandlers.add(param1RequestHandler);
          return this;
        } 
        throw new IllegalStateException("RequestHandler already registered.");
      } 
      throw new IllegalArgumentException("RequestHandler must not be null.");
    }
    
    public Picasso build() {
      Context context = this.context;
      if (this.downloader == null)
        this.downloader = Utils.createDefaultDownloader(context); 
      if (this.cache == null)
        this.cache = new LruCache(context); 
      if (this.service == null)
        this.service = new PicassoExecutorService(); 
      if (this.transformer == null)
        this.transformer = Picasso.RequestTransformer.IDENTITY; 
      Stats stats = new Stats(this.cache);
      return new Picasso(context, new Dispatcher(context, this.service, Picasso.HANDLER, this.downloader, this.cache, stats), this.cache, this.listener, this.transformer, this.requestHandlers, stats, this.defaultBitmapConfig, this.indicatorsEnabled, this.loggingEnabled);
    }
    
    @Deprecated
    public Builder debugging(boolean param1Boolean) {
      return indicatorsEnabled(param1Boolean);
    }
    
    public Builder defaultBitmapConfig(Bitmap.Config param1Config) {
      if (param1Config != null) {
        this.defaultBitmapConfig = param1Config;
        return this;
      } 
      throw new IllegalArgumentException("Bitmap config must not be null.");
    }
    
    public Builder downloader(Downloader param1Downloader) {
      if (param1Downloader != null) {
        if (this.downloader == null) {
          this.downloader = param1Downloader;
          return this;
        } 
        throw new IllegalStateException("Downloader already set.");
      } 
      throw new IllegalArgumentException("Downloader must not be null.");
    }
    
    public Builder executor(ExecutorService param1ExecutorService) {
      if (param1ExecutorService != null) {
        if (this.service == null) {
          this.service = param1ExecutorService;
          return this;
        } 
        throw new IllegalStateException("Executor service already set.");
      } 
      throw new IllegalArgumentException("Executor service must not be null.");
    }
    
    public Builder indicatorsEnabled(boolean param1Boolean) {
      this.indicatorsEnabled = param1Boolean;
      return this;
    }
    
    public Builder listener(Picasso.Listener param1Listener) {
      if (param1Listener != null) {
        if (this.listener == null) {
          this.listener = param1Listener;
          return this;
        } 
        throw new IllegalStateException("Listener already set.");
      } 
      throw new IllegalArgumentException("Listener must not be null.");
    }
    
    public Builder loggingEnabled(boolean param1Boolean) {
      this.loggingEnabled = param1Boolean;
      return this;
    }
    
    public Builder memoryCache(Cache param1Cache) {
      if (param1Cache != null) {
        if (this.cache == null) {
          this.cache = param1Cache;
          return this;
        } 
        throw new IllegalStateException("Memory cache already set.");
      } 
      throw new IllegalArgumentException("Memory cache must not be null.");
    }
    
    public Builder requestTransformer(Picasso.RequestTransformer param1RequestTransformer) {
      if (param1RequestTransformer != null) {
        if (this.transformer == null) {
          this.transformer = param1RequestTransformer;
          return this;
        } 
        throw new IllegalStateException("Transformer already set.");
      } 
      throw new IllegalArgumentException("Transformer must not be null.");
    }
  }
  
  private static class CleanupThread extends Thread {
    private final Handler handler;
    
    private final ReferenceQueue<Object> referenceQueue;
    
    CleanupThread(ReferenceQueue<Object> param1ReferenceQueue, Handler param1Handler) {
      this.referenceQueue = param1ReferenceQueue;
      this.handler = param1Handler;
      setDaemon(true);
      setName("Picasso-refQueue");
    }
    
    public void run() {
      Process.setThreadPriority(10);
      try {
        while (true) {
          Action.RequestWeakReference requestWeakReference = (Action.RequestWeakReference)this.referenceQueue.remove(1000L);
          Message message = this.handler.obtainMessage();
          if (requestWeakReference != null) {
            message.what = 3;
            message.obj = requestWeakReference.action;
            this.handler.sendMessage(message);
            continue;
          } 
          message.recycle();
        } 
      } catch (InterruptedException interruptedException) {
      
      } catch (Exception exception) {
        this.handler.post(new Runnable() {
              public void run() {
                throw new RuntimeException(e);
              }
            });
      } 
    }
    
    void shutdown() {
      interrupt();
    }
  }
  
  class null implements Runnable {
    public void run() {
      throw new RuntimeException(e);
    }
  }
  
  public static interface Listener {
    void onImageLoadFailed(Picasso param1Picasso, Uri param1Uri, Exception param1Exception);
  }
  
  public enum LoadedFrom {
    DISK,
    MEMORY(-16711936),
    NETWORK(-16711936);
    
    final int debugColor;
    
    static {
      $VALUES = new LoadedFrom[] { MEMORY, DISK, NETWORK };
    }
    
    LoadedFrom(int param1Int1) {
      this.debugColor = param1Int1;
    }
  }
  
  public enum Priority {
    HIGH(-16711936),
    LOW,
    NORMAL;
    
    static {
      $VALUES = new Priority[] { LOW, NORMAL, HIGH };
    }
  }
  
  public static interface RequestTransformer {
    public static final RequestTransformer IDENTITY = new RequestTransformer() {
        public Request transformRequest(Request param2Request) {
          return param2Request;
        }
      };
    
    Request transformRequest(Request param1Request);
  }
  
  static final class null implements RequestTransformer {
    public Request transformRequest(Request param1Request) {
      return param1Request;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\picasso\Picasso.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */