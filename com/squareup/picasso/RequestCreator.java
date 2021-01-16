package com.squareup.picasso;

import android.app.Notification;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.RemoteViews;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestCreator {
  private static final AtomicInteger nextId = new AtomicInteger();
  
  private final Request.Builder data;
  
  private boolean deferred;
  
  private Drawable errorDrawable;
  
  private int errorResId;
  
  private int memoryPolicy;
  
  private int networkPolicy;
  
  private boolean noFade;
  
  private final Picasso picasso;
  
  private Drawable placeholderDrawable;
  
  private int placeholderResId;
  
  private boolean setPlaceholder = true;
  
  private Object tag;
  
  RequestCreator() {
    this.picasso = null;
    this.data = new Request.Builder(null, 0, null);
  }
  
  RequestCreator(Picasso paramPicasso, Uri paramUri, int paramInt) {
    if (!paramPicasso.shutdown) {
      this.picasso = paramPicasso;
      this.data = new Request.Builder(paramUri, paramInt, paramPicasso.defaultBitmapConfig);
      return;
    } 
    throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
  }
  
  private Request createRequest(long paramLong) {
    int i = nextId.getAndIncrement();
    Request request1 = this.data.build();
    request1.id = i;
    request1.started = paramLong;
    boolean bool = this.picasso.loggingEnabled;
    if (bool)
      Utils.log("Main", "created", request1.plainId(), request1.toString()); 
    Request request2 = this.picasso.transformRequest(request1);
    if (request2 != request1) {
      request2.id = i;
      request2.started = paramLong;
      if (bool) {
        String str = request2.logId();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("into ");
        stringBuilder.append(request2);
        Utils.log("Main", "changed", str, stringBuilder.toString());
      } 
    } 
    return request2;
  }
  
  private Drawable getPlaceholderDrawable() {
    return (this.placeholderResId != 0) ? this.picasso.context.getResources().getDrawable(this.placeholderResId) : this.placeholderDrawable;
  }
  
  private void performRemoteViewInto(RemoteViewsAction paramRemoteViewsAction) {
    if (MemoryPolicy.shouldReadFromMemoryCache(this.memoryPolicy)) {
      Bitmap bitmap = this.picasso.quickMemoryCacheCheck(paramRemoteViewsAction.getKey());
      if (bitmap != null) {
        paramRemoteViewsAction.complete(bitmap, Picasso.LoadedFrom.MEMORY);
        return;
      } 
    } 
    int i = this.placeholderResId;
    if (i != 0)
      paramRemoteViewsAction.setImageResource(i); 
    this.picasso.enqueueAndSubmit(paramRemoteViewsAction);
  }
  
  public RequestCreator centerCrop() {
    this.data.centerCrop();
    return this;
  }
  
  public RequestCreator centerInside() {
    this.data.centerInside();
    return this;
  }
  
  public RequestCreator config(Bitmap.Config paramConfig) {
    this.data.config(paramConfig);
    return this;
  }
  
  public RequestCreator error(int paramInt) {
    if (paramInt != 0) {
      if (this.errorDrawable == null) {
        this.errorResId = paramInt;
        return this;
      } 
      throw new IllegalStateException("Error image already set.");
    } 
    throw new IllegalArgumentException("Error image resource invalid.");
  }
  
  public RequestCreator error(Drawable paramDrawable) {
    if (paramDrawable != null) {
      if (this.errorResId == 0) {
        this.errorDrawable = paramDrawable;
        return this;
      } 
      throw new IllegalStateException("Error image already set.");
    } 
    throw new IllegalArgumentException("Error image may not be null.");
  }
  
  public void fetch() {
    fetch(null);
  }
  
  public void fetch(Callback paramCallback) {
    long l = System.nanoTime();
    if (!this.deferred) {
      if (this.data.hasImage()) {
        StringBuilder stringBuilder;
        if (!this.data.hasPriority())
          this.data.priority(Picasso.Priority.LOW); 
        Request request = createRequest(l);
        String str = Utils.createKey(request, new StringBuilder());
        if (this.picasso.quickMemoryCacheCheck(str) != null) {
          if (this.picasso.loggingEnabled) {
            str = request.plainId();
            stringBuilder = new StringBuilder();
            stringBuilder.append("from ");
            stringBuilder.append(Picasso.LoadedFrom.MEMORY);
            Utils.log("Main", "completed", str, stringBuilder.toString());
          } 
          if (paramCallback != null)
            paramCallback.onSuccess(); 
        } else {
          FetchAction fetchAction = new FetchAction(this.picasso, (Request)stringBuilder, this.memoryPolicy, this.networkPolicy, this.tag, str, paramCallback);
          this.picasso.submit(fetchAction);
        } 
      } 
      return;
    } 
    throw new IllegalStateException("Fit cannot be used with fetch.");
  }
  
  public RequestCreator fit() {
    this.deferred = true;
    return this;
  }
  
  public Bitmap get() throws IOException {
    long l = System.nanoTime();
    Utils.checkNotMain();
    if (!this.deferred) {
      if (!this.data.hasImage())
        return null; 
      Request request = createRequest(l);
      String str = Utils.createKey(request, new StringBuilder());
      GetAction getAction = new GetAction(this.picasso, request, this.memoryPolicy, this.networkPolicy, this.tag, str);
      Picasso picasso = this.picasso;
      return BitmapHunter.forRequest(picasso, picasso.dispatcher, this.picasso.cache, this.picasso.stats, getAction).hunt();
    } 
    throw new IllegalStateException("Fit cannot be used with get.");
  }
  
  public void into(ImageView paramImageView) {
    into(paramImageView, null);
  }
  
  public void into(ImageView paramImageView, Callback paramCallback) {
    long l = System.nanoTime();
    Utils.checkMain();
    if (paramImageView != null) {
      StringBuilder stringBuilder;
      if (!this.data.hasImage()) {
        this.picasso.cancelRequest(paramImageView);
        if (this.setPlaceholder)
          PicassoDrawable.setPlaceholder(paramImageView, getPlaceholderDrawable()); 
        return;
      } 
      if (this.deferred)
        if (!this.data.hasSize()) {
          int i = paramImageView.getWidth();
          int j = paramImageView.getHeight();
          if (i == 0 || j == 0) {
            if (this.setPlaceholder)
              PicassoDrawable.setPlaceholder(paramImageView, getPlaceholderDrawable()); 
            this.picasso.defer(paramImageView, new DeferredRequestCreator(this, paramImageView, paramCallback));
            return;
          } 
          this.data.resize(i, j);
        } else {
          throw new IllegalStateException("Fit cannot be used with resize.");
        }  
      Request request = createRequest(l);
      String str = Utils.createKey(request);
      if (MemoryPolicy.shouldReadFromMemoryCache(this.memoryPolicy)) {
        Bitmap bitmap = this.picasso.quickMemoryCacheCheck(str);
        if (bitmap != null) {
          this.picasso.cancelRequest(paramImageView);
          PicassoDrawable.setBitmap(paramImageView, this.picasso.context, bitmap, Picasso.LoadedFrom.MEMORY, this.noFade, this.picasso.indicatorsEnabled);
          if (this.picasso.loggingEnabled) {
            String str1 = request.plainId();
            stringBuilder = new StringBuilder();
            stringBuilder.append("from ");
            stringBuilder.append(Picasso.LoadedFrom.MEMORY);
            Utils.log("Main", "completed", str1, stringBuilder.toString());
          } 
          if (paramCallback != null)
            paramCallback.onSuccess(); 
          return;
        } 
      } 
      if (this.setPlaceholder)
        PicassoDrawable.setPlaceholder((ImageView)stringBuilder, getPlaceholderDrawable()); 
      ImageViewAction imageViewAction = new ImageViewAction(this.picasso, (ImageView)stringBuilder, request, this.memoryPolicy, this.networkPolicy, this.errorResId, this.errorDrawable, str, this.tag, paramCallback, this.noFade);
      this.picasso.enqueueAndSubmit(imageViewAction);
      return;
    } 
    throw new IllegalArgumentException("Target must not be null.");
  }
  
  public void into(RemoteViews paramRemoteViews, int paramInt1, int paramInt2, Notification paramNotification) {
    long l = System.nanoTime();
    if (paramRemoteViews != null) {
      if (paramNotification != null) {
        if (!this.deferred) {
          if (this.placeholderDrawable == null && this.placeholderResId == 0 && this.errorDrawable == null) {
            Request request = createRequest(l);
            String str = Utils.createKey(request, new StringBuilder());
            performRemoteViewInto(new RemoteViewsAction.NotificationAction(this.picasso, request, paramRemoteViews, paramInt1, paramInt2, paramNotification, this.memoryPolicy, this.networkPolicy, str, this.tag, this.errorResId));
            return;
          } 
          throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
        } 
        throw new IllegalStateException("Fit cannot be used with RemoteViews.");
      } 
      throw new IllegalArgumentException("Notification must not be null.");
    } 
    throw new IllegalArgumentException("RemoteViews must not be null.");
  }
  
  public void into(RemoteViews paramRemoteViews, int paramInt, int[] paramArrayOfint) {
    long l = System.nanoTime();
    if (paramRemoteViews != null) {
      if (paramArrayOfint != null) {
        if (!this.deferred) {
          if (this.placeholderDrawable == null && this.placeholderResId == 0 && this.errorDrawable == null) {
            Request request = createRequest(l);
            String str = Utils.createKey(request, new StringBuilder());
            performRemoteViewInto(new RemoteViewsAction.AppWidgetAction(this.picasso, request, paramRemoteViews, paramInt, paramArrayOfint, this.memoryPolicy, this.networkPolicy, str, this.tag, this.errorResId));
            return;
          } 
          throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
        } 
        throw new IllegalStateException("Fit cannot be used with remote views.");
      } 
      throw new IllegalArgumentException("appWidgetIds must not be null.");
    } 
    throw new IllegalArgumentException("remoteViews must not be null.");
  }
  
  public void into(Target paramTarget) {
    long l = System.nanoTime();
    Utils.checkMain();
    if (paramTarget != null) {
      if (!this.deferred) {
        boolean bool = this.data.hasImage();
        Drawable drawable1 = null;
        Drawable drawable2 = null;
        if (!bool) {
          this.picasso.cancelRequest(paramTarget);
          drawable1 = drawable2;
          if (this.setPlaceholder)
            drawable1 = getPlaceholderDrawable(); 
          paramTarget.onPrepareLoad(drawable1);
          return;
        } 
        Request request = createRequest(l);
        String str = Utils.createKey(request);
        if (MemoryPolicy.shouldReadFromMemoryCache(this.memoryPolicy)) {
          Bitmap bitmap = this.picasso.quickMemoryCacheCheck(str);
          if (bitmap != null) {
            this.picasso.cancelRequest(paramTarget);
            paramTarget.onBitmapLoaded(bitmap, Picasso.LoadedFrom.MEMORY);
            return;
          } 
        } 
        if (this.setPlaceholder)
          drawable1 = getPlaceholderDrawable(); 
        paramTarget.onPrepareLoad(drawable1);
        TargetAction targetAction = new TargetAction(this.picasso, paramTarget, request, this.memoryPolicy, this.networkPolicy, this.errorDrawable, str, this.tag, this.errorResId);
        this.picasso.enqueueAndSubmit(targetAction);
        return;
      } 
      throw new IllegalStateException("Fit cannot be used with a Target.");
    } 
    throw new IllegalArgumentException("Target must not be null.");
  }
  
  public RequestCreator memoryPolicy(MemoryPolicy paramMemoryPolicy, MemoryPolicy... paramVarArgs) {
    if (paramMemoryPolicy != null) {
      int i = this.memoryPolicy;
      this.memoryPolicy = paramMemoryPolicy.index | i;
      if (paramVarArgs != null) {
        if (paramVarArgs.length > 0) {
          int j = paramVarArgs.length;
          i = 0;
          while (i < j) {
            paramMemoryPolicy = paramVarArgs[i];
            if (paramMemoryPolicy != null) {
              int k = this.memoryPolicy;
              this.memoryPolicy = paramMemoryPolicy.index | k;
              i++;
              continue;
            } 
            throw new IllegalArgumentException("Memory policy cannot be null.");
          } 
        } 
        return this;
      } 
      throw new IllegalArgumentException("Memory policy cannot be null.");
    } 
    throw new IllegalArgumentException("Memory policy cannot be null.");
  }
  
  public RequestCreator networkPolicy(NetworkPolicy paramNetworkPolicy, NetworkPolicy... paramVarArgs) {
    if (paramNetworkPolicy != null) {
      int i = this.networkPolicy;
      this.networkPolicy = paramNetworkPolicy.index | i;
      if (paramVarArgs != null) {
        if (paramVarArgs.length > 0) {
          int j = paramVarArgs.length;
          i = 0;
          while (i < j) {
            paramNetworkPolicy = paramVarArgs[i];
            if (paramNetworkPolicy != null) {
              int k = this.networkPolicy;
              this.networkPolicy = paramNetworkPolicy.index | k;
              i++;
              continue;
            } 
            throw new IllegalArgumentException("Network policy cannot be null.");
          } 
        } 
        return this;
      } 
      throw new IllegalArgumentException("Network policy cannot be null.");
    } 
    throw new IllegalArgumentException("Network policy cannot be null.");
  }
  
  public RequestCreator noFade() {
    this.noFade = true;
    return this;
  }
  
  public RequestCreator noPlaceholder() {
    if (this.placeholderResId == 0) {
      if (this.placeholderDrawable == null) {
        this.setPlaceholder = false;
        return this;
      } 
      throw new IllegalStateException("Placeholder image already set.");
    } 
    throw new IllegalStateException("Placeholder resource already set.");
  }
  
  public RequestCreator onlyScaleDown() {
    this.data.onlyScaleDown();
    return this;
  }
  
  public RequestCreator placeholder(int paramInt) {
    if (this.setPlaceholder) {
      if (paramInt != 0) {
        if (this.placeholderDrawable == null) {
          this.placeholderResId = paramInt;
          return this;
        } 
        throw new IllegalStateException("Placeholder image already set.");
      } 
      throw new IllegalArgumentException("Placeholder image resource invalid.");
    } 
    throw new IllegalStateException("Already explicitly declared as no placeholder.");
  }
  
  public RequestCreator placeholder(Drawable paramDrawable) {
    if (this.setPlaceholder) {
      if (this.placeholderResId == 0) {
        this.placeholderDrawable = paramDrawable;
        return this;
      } 
      throw new IllegalStateException("Placeholder image already set.");
    } 
    throw new IllegalStateException("Already explicitly declared as no placeholder.");
  }
  
  public RequestCreator priority(Picasso.Priority paramPriority) {
    this.data.priority(paramPriority);
    return this;
  }
  
  public RequestCreator resize(int paramInt1, int paramInt2) {
    this.data.resize(paramInt1, paramInt2);
    return this;
  }
  
  public RequestCreator resizeDimen(int paramInt1, int paramInt2) {
    Resources resources = this.picasso.context.getResources();
    return resize(resources.getDimensionPixelSize(paramInt1), resources.getDimensionPixelSize(paramInt2));
  }
  
  public RequestCreator rotate(float paramFloat) {
    this.data.rotate(paramFloat);
    return this;
  }
  
  public RequestCreator rotate(float paramFloat1, float paramFloat2, float paramFloat3) {
    this.data.rotate(paramFloat1, paramFloat2, paramFloat3);
    return this;
  }
  
  @Deprecated
  public RequestCreator skipMemoryCache() {
    return memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[] { MemoryPolicy.NO_STORE });
  }
  
  public RequestCreator stableKey(String paramString) {
    this.data.stableKey(paramString);
    return this;
  }
  
  public RequestCreator tag(Object paramObject) {
    if (paramObject != null) {
      if (this.tag == null) {
        this.tag = paramObject;
        return this;
      } 
      throw new IllegalStateException("Tag already set.");
    } 
    throw new IllegalArgumentException("Tag invalid.");
  }
  
  public RequestCreator transform(Transformation paramTransformation) {
    this.data.transform(paramTransformation);
    return this;
  }
  
  public RequestCreator transform(List<? extends Transformation> paramList) {
    this.data.transform(paramList);
    return this;
  }
  
  RequestCreator unfit() {
    this.deferred = false;
    return this;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\picasso\RequestCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */