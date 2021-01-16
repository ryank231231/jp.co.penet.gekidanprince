package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.internal.base.zal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
  private static final Object zamg = new Object();
  
  private static HashSet<Uri> zamh = new HashSet<Uri>();
  
  private static ImageManager zami;
  
  private final Context mContext;
  
  private final Handler mHandler;
  
  private final ExecutorService zamj;
  
  private final zaa zamk;
  
  private final zak zaml;
  
  private final Map<zaa, ImageReceiver> zamm;
  
  private final Map<Uri, ImageReceiver> zamn;
  
  private final Map<Uri, Long> zamo;
  
  private ImageManager(Context paramContext, boolean paramBoolean) {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = (Handler)new zal(Looper.getMainLooper());
    this.zamj = Executors.newFixedThreadPool(4);
    this.zamk = null;
    this.zaml = new zak();
    this.zamm = new HashMap<zaa, ImageReceiver>();
    this.zamn = new HashMap<Uri, ImageReceiver>();
    this.zamo = new HashMap<Uri, Long>();
  }
  
  public static ImageManager create(Context paramContext) {
    if (zami == null)
      zami = new ImageManager(paramContext, false); 
    return zami;
  }
  
  private final Bitmap zaa(zab paramzab) {
    zaa zaa1 = this.zamk;
    return (zaa1 == null) ? null : (Bitmap)zaa1.get(paramzab);
  }
  
  private final void zaa(zaa paramzaa) {
    Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
    (new zac(this, paramzaa)).run();
  }
  
  public final void loadImage(ImageView paramImageView, int paramInt) {
    zaa(new zac(paramImageView, paramInt));
  }
  
  public final void loadImage(ImageView paramImageView, Uri paramUri) {
    zaa(new zac(paramImageView, paramUri));
  }
  
  public final void loadImage(ImageView paramImageView, Uri paramUri, int paramInt) {
    zac zac = new zac(paramImageView, paramUri);
    zac.zamw = paramInt;
    zaa(zac);
  }
  
  public final void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri) {
    zaa(new zad(paramOnImageLoadedListener, paramUri));
  }
  
  public final void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt) {
    zad zad = new zad(paramOnImageLoadedListener, paramUri);
    zad.zamw = paramInt;
    zaa(zad);
  }
  
  @KeepName
  private final class ImageReceiver extends ResultReceiver {
    private final Uri mUri;
    
    private final ArrayList<zaa> zamp;
    
    ImageReceiver(ImageManager this$0, Uri param1Uri) {
      super((Handler)new zal(Looper.getMainLooper()));
      this.mUri = param1Uri;
      this.zamp = new ArrayList<zaa>();
    }
    
    public final void onReceiveResult(int param1Int, Bundle param1Bundle) {
      ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor)param1Bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.zaf(this.zamq).execute(new ImageManager.zab(this.zamq, this.mUri, parcelFileDescriptor));
    }
    
    public final void zab(zaa param1zaa) {
      Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
      this.zamp.add(param1zaa);
    }
    
    public final void zac(zaa param1zaa) {
      Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
      this.zamp.remove(param1zaa);
    }
    
    public final void zace() {
      Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      intent.putExtra("com.google.android.gms.extras.uri", (Parcelable)this.mUri);
      intent.putExtra("com.google.android.gms.extras.resultReceiver", (Parcelable)this);
      intent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.zab(this.zamq).sendBroadcast(intent);
    }
  }
  
  public static interface OnImageLoadedListener {
    void onImageLoaded(Uri param1Uri, Drawable param1Drawable, boolean param1Boolean);
  }
  
  private static final class zaa extends LruCache<zab, Bitmap> {}
  
  private final class zab implements Runnable {
    private final Uri mUri;
    
    private final ParcelFileDescriptor zamr;
    
    public zab(ImageManager this$0, Uri param1Uri, ParcelFileDescriptor param1ParcelFileDescriptor) {
      this.mUri = param1Uri;
      this.zamr = param1ParcelFileDescriptor;
    }
    
    public final void run() {
      Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
      ParcelFileDescriptor parcelFileDescriptor = this.zamr;
      boolean bool = false;
      Bitmap bitmap = null;
      if (parcelFileDescriptor != null) {
        try {
          Bitmap bitmap1 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
          bitmap = bitmap1;
        } catch (OutOfMemoryError outOfMemoryError) {
          String str = String.valueOf(this.mUri);
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 34);
          stringBuilder.append("OOM while loading bitmap for uri: ");
          stringBuilder.append(str);
          Log.e("ImageManager", stringBuilder.toString(), outOfMemoryError);
          bool = true;
        } 
        try {
          this.zamr.close();
        } catch (IOException iOException) {
          Log.e("ImageManager", "closed failed", iOException);
        } 
      } else {
        bitmap = null;
        bool = false;
      } 
      CountDownLatch countDownLatch = new CountDownLatch(1);
      ImageManager.zag(this.zamq).post(new ImageManager.zad(this.zamq, this.mUri, bitmap, bool, countDownLatch));
      try {
        countDownLatch.await();
        return;
      } catch (InterruptedException interruptedException) {
        String str = String.valueOf(this.mUri);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 32);
        stringBuilder.append("Latch interrupted while posting ");
        stringBuilder.append(str);
        Log.w("ImageManager", stringBuilder.toString());
        return;
      } 
    }
  }
  
  private final class zac implements Runnable {
    private final zaa zams;
    
    public zac(ImageManager this$0, zaa param1zaa) {
      this.zams = param1zaa;
    }
    
    public final void run() {
      Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
      ImageManager.ImageReceiver imageReceiver1 = (ImageManager.ImageReceiver)ImageManager.zaa(this.zamq).get(this.zams);
      if (imageReceiver1 != null) {
        ImageManager.zaa(this.zamq).remove(this.zams);
        imageReceiver1.zac(this.zams);
      } 
      zab zab = this.zams.zamu;
      if (zab.uri == null) {
        this.zams.zaa(ImageManager.zab(this.zamq), ImageManager.zac(this.zamq), true);
        return;
      } 
      Bitmap bitmap = ImageManager.zaa(this.zamq, zab);
      if (bitmap != null) {
        this.zams.zaa(ImageManager.zab(this.zamq), bitmap, true);
        return;
      } 
      Long long_ = (Long)ImageManager.zad(this.zamq).get(zab.uri);
      if (long_ != null) {
        if (SystemClock.elapsedRealtime() - long_.longValue() < 3600000L) {
          this.zams.zaa(ImageManager.zab(this.zamq), ImageManager.zac(this.zamq), true);
          return;
        } 
        ImageManager.zad(this.zamq).remove(zab.uri);
      } 
      this.zams.zaa(ImageManager.zab(this.zamq), ImageManager.zac(this.zamq));
      ImageManager.ImageReceiver imageReceiver2 = (ImageManager.ImageReceiver)ImageManager.zae(this.zamq).get(zab.uri);
      null = imageReceiver2;
      if (imageReceiver2 == null) {
        null = new ImageManager.ImageReceiver(this.zamq, zab.uri);
        ImageManager.zae(this.zamq).put(zab.uri, null);
      } 
      null.zab(this.zams);
      if (!(this.zams instanceof zad))
        ImageManager.zaa(this.zamq).put(this.zams, null); 
      synchronized (ImageManager.zacc()) {
        if (!ImageManager.zacd().contains(zab.uri)) {
          ImageManager.zacd().add(zab.uri);
          null.zace();
        } 
        return;
      } 
    }
  }
  
  private final class zad implements Runnable {
    private final Bitmap mBitmap;
    
    private final Uri mUri;
    
    private final CountDownLatch zadq;
    
    private boolean zamt;
    
    public zad(ImageManager this$0, Uri param1Uri, Bitmap param1Bitmap, boolean param1Boolean, CountDownLatch param1CountDownLatch) {
      this.mUri = param1Uri;
      this.mBitmap = param1Bitmap;
      this.zamt = param1Boolean;
      this.zadq = param1CountDownLatch;
    }
    
    public final void run() {
      boolean bool;
      Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
      if (this.mBitmap != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (ImageManager.zah(this.zamq) != null) {
        if (this.zamt) {
          ImageManager.zah(this.zamq).evictAll();
          System.gc();
          this.zamt = false;
          ImageManager.zag(this.zamq).post(this);
          return;
        } 
        if (bool)
          ImageManager.zah(this.zamq).put(new zab(this.mUri), this.mBitmap); 
      } 
      null = (ImageManager.ImageReceiver)ImageManager.zae(this.zamq).remove(this.mUri);
      if (null != null) {
        ArrayList<zaa> arrayList = ImageManager.ImageReceiver.zaa(null);
        int i = arrayList.size();
        for (byte b = 0; b < i; b++) {
          zaa zaa = arrayList.get(b);
          if (bool) {
            zaa.zaa(ImageManager.zab(this.zamq), this.mBitmap, false);
          } else {
            ImageManager.zad(this.zamq).put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
            zaa.zaa(ImageManager.zab(this.zamq), ImageManager.zac(this.zamq), false);
          } 
          if (!(zaa instanceof zad))
            ImageManager.zaa(this.zamq).remove(zaa); 
        } 
      } 
      this.zadq.countDown();
      synchronized (ImageManager.zacc()) {
        ImageManager.zacd().remove(this.mUri);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\images\ImageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */