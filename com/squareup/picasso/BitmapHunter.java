package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class BitmapHunter implements Runnable {
  private static final Object DECODE_LOCK = new Object();
  
  private static final RequestHandler ERRORING_HANDLER;
  
  private static final ThreadLocal<StringBuilder> NAME_BUILDER = new ThreadLocal<StringBuilder>() {
      protected StringBuilder initialValue() {
        return new StringBuilder("Picasso-");
      }
    };
  
  private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();
  
  Action action;
  
  List<Action> actions;
  
  final Cache cache;
  
  final Request data;
  
  final Dispatcher dispatcher;
  
  Exception exception;
  
  int exifRotation;
  
  Future<?> future;
  
  final String key;
  
  Picasso.LoadedFrom loadedFrom;
  
  final int memoryPolicy;
  
  int networkPolicy;
  
  final Picasso picasso;
  
  Picasso.Priority priority;
  
  final RequestHandler requestHandler;
  
  Bitmap result;
  
  int retryCount;
  
  final int sequence = SEQUENCE_GENERATOR.incrementAndGet();
  
  final Stats stats;
  
  static {
    ERRORING_HANDLER = new RequestHandler() {
        public boolean canHandleRequest(Request param1Request) {
          return true;
        }
        
        public RequestHandler.Result load(Request param1Request, int param1Int) throws IOException {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Unrecognized type of request: ");
          stringBuilder.append(param1Request);
          throw new IllegalStateException(stringBuilder.toString());
        }
      };
  }
  
  BitmapHunter(Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction, RequestHandler paramRequestHandler) {
    this.picasso = paramPicasso;
    this.dispatcher = paramDispatcher;
    this.cache = paramCache;
    this.stats = paramStats;
    this.action = paramAction;
    this.key = paramAction.getKey();
    this.data = paramAction.getRequest();
    this.priority = paramAction.getPriority();
    this.memoryPolicy = paramAction.getMemoryPolicy();
    this.networkPolicy = paramAction.getNetworkPolicy();
    this.requestHandler = paramRequestHandler;
    this.retryCount = paramRequestHandler.getRetryCount();
  }
  
  static Bitmap applyCustomTransformations(List<Transformation> paramList, Bitmap paramBitmap) {
    Bitmap bitmap;
    int i = paramList.size();
    byte b = 0;
    while (b < i) {
      final Transformation transformation = paramList.get(b);
      try {
        final StringBuilder builder;
        Bitmap bitmap1 = transformation.transform(paramBitmap);
        if (bitmap1 == null) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Transformation ");
          stringBuilder.append(transformation.key());
          stringBuilder.append(" returned null after ");
          stringBuilder.append(b);
          stringBuilder.append(" previous transformation(s).\n\nTransformation list:\n");
          Iterator<Transformation> iterator = paramList.iterator();
          while (iterator.hasNext()) {
            stringBuilder.append(((Transformation)iterator.next()).key());
            stringBuilder.append('\n');
          } 
          Picasso.HANDLER.post(new Runnable() {
                public void run() {
                  throw new NullPointerException(builder.toString());
                }
              });
          return null;
        } 
        if (bitmap1 == stringBuilder && stringBuilder.isRecycled()) {
          Picasso.HANDLER.post(new Runnable() {
                public void run() {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("Transformation ");
                  stringBuilder.append(transformation.key());
                  stringBuilder.append(" returned input Bitmap but recycled it.");
                  throw new IllegalStateException(stringBuilder.toString());
                }
              });
          return null;
        } 
        if (bitmap1 != stringBuilder && !stringBuilder.isRecycled()) {
          Picasso.HANDLER.post(new Runnable() {
                public void run() {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("Transformation ");
                  stringBuilder.append(transformation.key());
                  stringBuilder.append(" mutated input Bitmap but failed to recycle the original.");
                  throw new IllegalStateException(stringBuilder.toString());
                }
              });
          return null;
        } 
        b++;
        bitmap = bitmap1;
      } catch (RuntimeException runtimeException) {
        Picasso.HANDLER.post(new Runnable() {
              public void run() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Transformation ");
                stringBuilder.append(transformation.key());
                stringBuilder.append(" crashed with exception.");
                throw new RuntimeException(stringBuilder.toString(), e);
              }
            });
        return null;
      } 
    } 
    return bitmap;
  }
  
  private Picasso.Priority computeNewPriority() {
    byte b3;
    Picasso.Priority priority1 = Picasso.Priority.LOW;
    List<Action> list = this.actions;
    byte b1 = 1;
    byte b2 = 0;
    if (list != null && !list.isEmpty()) {
      b3 = 1;
    } else {
      b3 = 0;
    } 
    int i = b1;
    if (this.action == null)
      if (b3) {
        i = b1;
      } else {
        i = 0;
      }  
    if (!i)
      return priority1; 
    Action action = this.action;
    if (action != null)
      priority1 = action.getPriority(); 
    Picasso.Priority priority2 = priority1;
    if (b3) {
      i = this.actions.size();
      b3 = b2;
      while (true) {
        priority2 = priority1;
        if (b3 < i) {
          Picasso.Priority priority = ((Action)this.actions.get(b3)).getPriority();
          priority2 = priority1;
          if (priority.ordinal() > priority1.ordinal())
            priority2 = priority; 
          b3++;
          priority1 = priority2;
          continue;
        } 
        break;
      } 
    } 
    return priority2;
  }
  
  static Bitmap decodeStream(InputStream paramInputStream, Request paramRequest) throws IOException {
    byte[] arrayOfByte;
    MarkableInputStream markableInputStream = new MarkableInputStream(paramInputStream);
    long l = markableInputStream.savePosition(65536);
    BitmapFactory.Options options = RequestHandler.createBitmapOptions(paramRequest);
    boolean bool1 = RequestHandler.requiresInSampleSize(options);
    boolean bool2 = Utils.isWebPFile(markableInputStream);
    markableInputStream.reset(l);
    if (bool2) {
      arrayOfByte = Utils.toByteArray(markableInputStream);
      if (bool1) {
        BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, options);
        RequestHandler.calculateInSampleSize(paramRequest.targetWidth, paramRequest.targetHeight, options, paramRequest);
      } 
      return BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, options);
    } 
    if (bool1) {
      BitmapFactory.decodeStream((InputStream)arrayOfByte, null, options);
      RequestHandler.calculateInSampleSize(paramRequest.targetWidth, paramRequest.targetHeight, options, paramRequest);
      arrayOfByte.reset(l);
    } 
    Bitmap bitmap = BitmapFactory.decodeStream((InputStream)arrayOfByte, null, options);
    if (bitmap != null)
      return bitmap; 
    throw new IOException("Failed to decode stream.");
  }
  
  static BitmapHunter forRequest(Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction) {
    Request request = paramAction.getRequest();
    List<RequestHandler> list = paramPicasso.getRequestHandlers();
    int i = list.size();
    for (byte b = 0; b < i; b++) {
      RequestHandler requestHandler = list.get(b);
      if (requestHandler.canHandleRequest(request))
        return new BitmapHunter(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction, requestHandler); 
    } 
    return new BitmapHunter(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction, ERRORING_HANDLER);
  }
  
  private static boolean shouldResize(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (!paramBoolean || paramInt1 > paramInt3 || paramInt2 > paramInt4);
  }
  
  static Bitmap transformResult(Request paramRequest, Bitmap paramBitmap, int paramInt) {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    boolean bool1 = paramRequest.onlyScaleDown;
    Matrix matrix = new Matrix();
    boolean bool2 = paramRequest.needsMatrixTransform();
    int k = 0;
    int m = 0;
    if (bool2) {
      boolean bool3;
      int i3;
      int i1 = paramRequest.targetWidth;
      int i2 = paramRequest.targetHeight;
      float f = paramRequest.rotationDegrees;
      if (f != 0.0F)
        if (paramRequest.hasRotationPivot) {
          matrix.setRotate(f, paramRequest.rotationPivotX, paramRequest.rotationPivotY);
        } else {
          matrix.setRotate(f);
        }  
      if (paramRequest.centerCrop) {
        float f1 = i1;
        float f2 = i;
        float f3 = f1 / f2;
        float f4 = i2;
        float f5 = j;
        f = f4 / f5;
        if (f3 > f) {
          bool3 = (int)Math.ceil((f5 * f / f3));
          i3 = (j - bool3) / 2;
          f = f4 / bool3;
          k = i;
        } else {
          k = (int)Math.ceil((f2 * f3 / f));
          m = (i - k) / 2;
          f3 = f1 / k;
          bool3 = j;
          i3 = 0;
        } 
        if (shouldResize(bool1, i, j, i1, i2))
          matrix.preScale(f3, f); 
        j = i3;
        i3 = bool3;
        i = m;
        bool3 = j;
        m = k;
      } else {
        if (paramRequest.centerInside) {
          float f1 = i1 / i;
          f = i2 / j;
          if (f1 < f)
            f = f1; 
          if (shouldResize(bool1, i, j, i1, i2))
            matrix.preScale(f, f); 
        } else if ((i1 != 0 || i2 != 0) && (i1 != i || i2 != j)) {
          float f2;
          if (i1 != 0) {
            f2 = i1;
            f = i;
          } else {
            f2 = i2;
            f = j;
          } 
          float f1 = f2 / f;
          if (i2 != 0) {
            f = i2;
            f2 = j;
          } else {
            f = i1;
            f2 = i;
          } 
          f /= f2;
          if (shouldResize(bool1, i, j, i1, i2))
            matrix.preScale(f1, f); 
        } 
        m = i;
        i3 = j;
        bool3 = false;
        i = k;
      } 
      if (paramInt != 0)
        matrix.preRotate(paramInt); 
      Bitmap bitmap = Bitmap.createBitmap(paramBitmap, i, bool3, m, i3, matrix, true);
      if (bitmap != paramBitmap) {
        paramBitmap.recycle();
        paramBitmap = bitmap;
      } 
      return paramBitmap;
    } 
    m = i;
    int n = j;
    boolean bool = false;
    i = k;
  }
  
  static void updateThreadName(Request paramRequest) {
    String str = paramRequest.getName();
    StringBuilder stringBuilder = NAME_BUILDER.get();
    stringBuilder.ensureCapacity(str.length() + 8);
    stringBuilder.replace(8, stringBuilder.length(), str);
    Thread.currentThread().setName(stringBuilder.toString());
  }
  
  void attach(Action paramAction) {
    List<Action> list;
    boolean bool = this.picasso.loggingEnabled;
    Request request = paramAction.request;
    if (this.action == null) {
      this.action = paramAction;
      if (bool) {
        list = this.actions;
        if (list == null || list.isEmpty()) {
          Utils.log("Hunter", "joined", request.logId(), "to empty hunter");
          return;
        } 
        Utils.log("Hunter", "joined", request.logId(), Utils.getLogIdsForHunter(this, "to "));
      } 
      return;
    } 
    if (this.actions == null)
      this.actions = new ArrayList<Action>(3); 
    this.actions.add(list);
    if (bool)
      Utils.log("Hunter", "joined", request.logId(), Utils.getLogIdsForHunter(this, "to ")); 
    Picasso.Priority priority = list.getPriority();
    if (priority.ordinal() > this.priority.ordinal())
      this.priority = priority; 
  }
  
  boolean cancel() {
    // Byte code:
    //   0: aload_0
    //   1: getfield action : Lcom/squareup/picasso/Action;
    //   4: astore_1
    //   5: iconst_0
    //   6: istore_2
    //   7: iload_2
    //   8: istore_3
    //   9: aload_1
    //   10: ifnonnull -> 58
    //   13: aload_0
    //   14: getfield actions : Ljava/util/List;
    //   17: astore_1
    //   18: aload_1
    //   19: ifnull -> 33
    //   22: iload_2
    //   23: istore_3
    //   24: aload_1
    //   25: invokeinterface isEmpty : ()Z
    //   30: ifeq -> 58
    //   33: aload_0
    //   34: getfield future : Ljava/util/concurrent/Future;
    //   37: astore_1
    //   38: iload_2
    //   39: istore_3
    //   40: aload_1
    //   41: ifnull -> 58
    //   44: iload_2
    //   45: istore_3
    //   46: aload_1
    //   47: iconst_0
    //   48: invokeinterface cancel : (Z)Z
    //   53: ifeq -> 58
    //   56: iconst_1
    //   57: istore_3
    //   58: iload_3
    //   59: ireturn
  }
  
  void detach(Action paramAction) {
    boolean bool;
    if (this.action == paramAction) {
      this.action = null;
      bool = true;
    } else {
      List<Action> list = this.actions;
      if (list != null) {
        bool = list.remove(paramAction);
      } else {
        bool = false;
      } 
    } 
    if (bool && paramAction.getPriority() == this.priority)
      this.priority = computeNewPriority(); 
    if (this.picasso.loggingEnabled)
      Utils.log("Hunter", "removed", paramAction.request.logId(), Utils.getLogIdsForHunter(this, "from ")); 
  }
  
  Action getAction() {
    return this.action;
  }
  
  List<Action> getActions() {
    return this.actions;
  }
  
  Request getData() {
    return this.data;
  }
  
  Exception getException() {
    return this.exception;
  }
  
  String getKey() {
    return this.key;
  }
  
  Picasso.LoadedFrom getLoadedFrom() {
    return this.loadedFrom;
  }
  
  int getMemoryPolicy() {
    return this.memoryPolicy;
  }
  
  Picasso getPicasso() {
    return this.picasso;
  }
  
  Picasso.Priority getPriority() {
    return this.priority;
  }
  
  Bitmap getResult() {
    return this.result;
  }
  
  Bitmap hunt() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield memoryPolicy : I
    //   4: invokestatic shouldReadFromMemoryCache : (I)Z
    //   7: ifeq -> 75
    //   10: aload_0
    //   11: getfield cache : Lcom/squareup/picasso/Cache;
    //   14: aload_0
    //   15: getfield key : Ljava/lang/String;
    //   18: invokeinterface get : (Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   23: astore_1
    //   24: aload_1
    //   25: astore_2
    //   26: aload_1
    //   27: ifnull -> 77
    //   30: aload_0
    //   31: getfield stats : Lcom/squareup/picasso/Stats;
    //   34: invokevirtual dispatchCacheHit : ()V
    //   37: aload_0
    //   38: getstatic com/squareup/picasso/Picasso$LoadedFrom.MEMORY : Lcom/squareup/picasso/Picasso$LoadedFrom;
    //   41: putfield loadedFrom : Lcom/squareup/picasso/Picasso$LoadedFrom;
    //   44: aload_0
    //   45: getfield picasso : Lcom/squareup/picasso/Picasso;
    //   48: getfield loggingEnabled : Z
    //   51: ifeq -> 73
    //   54: ldc_w 'Hunter'
    //   57: ldc_w 'decoded'
    //   60: aload_0
    //   61: getfield data : Lcom/squareup/picasso/Request;
    //   64: invokevirtual logId : ()Ljava/lang/String;
    //   67: ldc_w 'from cache'
    //   70: invokestatic log : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_1
    //   74: areturn
    //   75: aconst_null
    //   76: astore_2
    //   77: aload_0
    //   78: getfield data : Lcom/squareup/picasso/Request;
    //   81: astore_1
    //   82: aload_0
    //   83: getfield retryCount : I
    //   86: ifne -> 99
    //   89: getstatic com/squareup/picasso/NetworkPolicy.OFFLINE : Lcom/squareup/picasso/NetworkPolicy;
    //   92: getfield index : I
    //   95: istore_3
    //   96: goto -> 104
    //   99: aload_0
    //   100: getfield networkPolicy : I
    //   103: istore_3
    //   104: aload_1
    //   105: iload_3
    //   106: putfield networkPolicy : I
    //   109: aload_0
    //   110: getfield requestHandler : Lcom/squareup/picasso/RequestHandler;
    //   113: aload_0
    //   114: getfield data : Lcom/squareup/picasso/Request;
    //   117: aload_0
    //   118: getfield networkPolicy : I
    //   121: invokevirtual load : (Lcom/squareup/picasso/Request;I)Lcom/squareup/picasso/RequestHandler$Result;
    //   124: astore #4
    //   126: aload #4
    //   128: ifnull -> 190
    //   131: aload_0
    //   132: aload #4
    //   134: invokevirtual getLoadedFrom : ()Lcom/squareup/picasso/Picasso$LoadedFrom;
    //   137: putfield loadedFrom : Lcom/squareup/picasso/Picasso$LoadedFrom;
    //   140: aload_0
    //   141: aload #4
    //   143: invokevirtual getExifOrientation : ()I
    //   146: putfield exifRotation : I
    //   149: aload #4
    //   151: invokevirtual getBitmap : ()Landroid/graphics/Bitmap;
    //   154: astore_1
    //   155: aload_1
    //   156: astore_2
    //   157: aload_1
    //   158: ifnonnull -> 190
    //   161: aload #4
    //   163: invokevirtual getStream : ()Ljava/io/InputStream;
    //   166: astore_1
    //   167: aload_1
    //   168: aload_0
    //   169: getfield data : Lcom/squareup/picasso/Request;
    //   172: invokestatic decodeStream : (Ljava/io/InputStream;Lcom/squareup/picasso/Request;)Landroid/graphics/Bitmap;
    //   175: astore_2
    //   176: aload_1
    //   177: invokestatic closeQuietly : (Ljava/io/InputStream;)V
    //   180: goto -> 190
    //   183: astore_2
    //   184: aload_1
    //   185: invokestatic closeQuietly : (Ljava/io/InputStream;)V
    //   188: aload_2
    //   189: athrow
    //   190: aload_2
    //   191: astore_1
    //   192: aload_2
    //   193: ifnull -> 404
    //   196: aload_0
    //   197: getfield picasso : Lcom/squareup/picasso/Picasso;
    //   200: getfield loggingEnabled : Z
    //   203: ifeq -> 222
    //   206: ldc_w 'Hunter'
    //   209: ldc_w 'decoded'
    //   212: aload_0
    //   213: getfield data : Lcom/squareup/picasso/Request;
    //   216: invokevirtual logId : ()Ljava/lang/String;
    //   219: invokestatic log : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_0
    //   223: getfield stats : Lcom/squareup/picasso/Stats;
    //   226: aload_2
    //   227: invokevirtual dispatchBitmapDecoded : (Landroid/graphics/Bitmap;)V
    //   230: aload_0
    //   231: getfield data : Lcom/squareup/picasso/Request;
    //   234: invokevirtual needsTransformation : ()Z
    //   237: ifne -> 249
    //   240: aload_2
    //   241: astore_1
    //   242: aload_0
    //   243: getfield exifRotation : I
    //   246: ifeq -> 404
    //   249: getstatic com/squareup/picasso/BitmapHunter.DECODE_LOCK : Ljava/lang/Object;
    //   252: astore #4
    //   254: aload #4
    //   256: monitorenter
    //   257: aload_0
    //   258: getfield data : Lcom/squareup/picasso/Request;
    //   261: invokevirtual needsMatrixTransform : ()Z
    //   264: ifne -> 276
    //   267: aload_2
    //   268: astore_1
    //   269: aload_0
    //   270: getfield exifRotation : I
    //   273: ifeq -> 319
    //   276: aload_0
    //   277: getfield data : Lcom/squareup/picasso/Request;
    //   280: aload_2
    //   281: aload_0
    //   282: getfield exifRotation : I
    //   285: invokestatic transformResult : (Lcom/squareup/picasso/Request;Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   288: astore_2
    //   289: aload_2
    //   290: astore_1
    //   291: aload_0
    //   292: getfield picasso : Lcom/squareup/picasso/Picasso;
    //   295: getfield loggingEnabled : Z
    //   298: ifeq -> 319
    //   301: ldc_w 'Hunter'
    //   304: ldc_w 'transformed'
    //   307: aload_0
    //   308: getfield data : Lcom/squareup/picasso/Request;
    //   311: invokevirtual logId : ()Ljava/lang/String;
    //   314: invokestatic log : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload_2
    //   318: astore_1
    //   319: aload_1
    //   320: astore_2
    //   321: aload_0
    //   322: getfield data : Lcom/squareup/picasso/Request;
    //   325: invokevirtual hasCustomTransformations : ()Z
    //   328: ifeq -> 376
    //   331: aload_0
    //   332: getfield data : Lcom/squareup/picasso/Request;
    //   335: getfield transformations : Ljava/util/List;
    //   338: aload_1
    //   339: invokestatic applyCustomTransformations : (Ljava/util/List;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   342: astore_1
    //   343: aload_1
    //   344: astore_2
    //   345: aload_0
    //   346: getfield picasso : Lcom/squareup/picasso/Picasso;
    //   349: getfield loggingEnabled : Z
    //   352: ifeq -> 376
    //   355: ldc_w 'Hunter'
    //   358: ldc_w 'transformed'
    //   361: aload_0
    //   362: getfield data : Lcom/squareup/picasso/Request;
    //   365: invokevirtual logId : ()Ljava/lang/String;
    //   368: ldc_w 'from custom transformations'
    //   371: invokestatic log : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   374: aload_1
    //   375: astore_2
    //   376: aload #4
    //   378: monitorexit
    //   379: aload_2
    //   380: astore_1
    //   381: aload_2
    //   382: ifnull -> 404
    //   385: aload_0
    //   386: getfield stats : Lcom/squareup/picasso/Stats;
    //   389: aload_2
    //   390: invokevirtual dispatchBitmapTransformed : (Landroid/graphics/Bitmap;)V
    //   393: aload_2
    //   394: astore_1
    //   395: goto -> 404
    //   398: astore_2
    //   399: aload #4
    //   401: monitorexit
    //   402: aload_2
    //   403: athrow
    //   404: aload_1
    //   405: areturn
    // Exception table:
    //   from	to	target	type
    //   167	176	183	finally
    //   257	267	398	finally
    //   269	276	398	finally
    //   276	289	398	finally
    //   291	317	398	finally
    //   321	343	398	finally
    //   345	374	398	finally
    //   376	379	398	finally
    //   399	402	398	finally
  }
  
  boolean isCancelled() {
    boolean bool;
    Future<?> future = this.future;
    if (future != null && future.isCancelled()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void run() {
    try {
      updateThreadName(this.data);
      if (this.picasso.loggingEnabled)
        Utils.log("Hunter", "executing", Utils.getLogIdsForHunter(this)); 
      this.result = hunt();
      if (this.result == null) {
        this.dispatcher.dispatchFailed(this);
      } else {
        this.dispatcher.dispatchComplete(this);
      } 
      Thread.currentThread().setName("Picasso-Idle");
    } catch (ResponseException responseException) {
      if (!responseException.localCacheOnly || responseException.responseCode != 504)
        this.exception = responseException; 
      this.dispatcher.dispatchFailed(this);
      Thread.currentThread().setName("Picasso-Idle");
    } catch (ContentLengthException contentLengthException) {
      this.exception = contentLengthException;
      this.dispatcher.dispatchRetry(this);
      Thread.currentThread().setName("Picasso-Idle");
    } catch (IOException iOException) {
      this.exception = iOException;
      this.dispatcher.dispatchRetry(this);
      Thread.currentThread().setName("Picasso-Idle");
    } catch (OutOfMemoryError outOfMemoryError) {
      StringWriter stringWriter = new StringWriter();
      this();
      StatsSnapshot statsSnapshot = this.stats.createSnapshot();
      PrintWriter printWriter = new PrintWriter();
      this(stringWriter);
      statsSnapshot.dump(printWriter);
      RuntimeException runtimeException = new RuntimeException();
      this(stringWriter.toString(), outOfMemoryError);
      this.exception = runtimeException;
      this.dispatcher.dispatchFailed(this);
      Thread.currentThread().setName("Picasso-Idle");
    } catch (Exception exception) {
      this.exception = exception;
      this.dispatcher.dispatchFailed(this);
      Thread.currentThread().setName("Picasso-Idle");
    } finally {
      Exception exception;
    } 
  }
  
  boolean shouldRetry(boolean paramBoolean, NetworkInfo paramNetworkInfo) {
    boolean bool;
    if (this.retryCount > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool)
      return false; 
    this.retryCount--;
    return this.requestHandler.shouldRetry(paramBoolean, paramNetworkInfo);
  }
  
  boolean supportsReplay() {
    return this.requestHandler.supportsReplay();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\picasso\BitmapHunter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */