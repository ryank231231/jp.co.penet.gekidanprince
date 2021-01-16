package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

public final class zad extends zaa {
  private WeakReference<ImageManager.OnImageLoadedListener> zanc;
  
  public zad(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri) {
    super(paramUri, 0);
    Asserts.checkNotNull(paramOnImageLoadedListener);
    this.zanc = new WeakReference<ImageManager.OnImageLoadedListener>(paramOnImageLoadedListener);
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof zad))
      return false; 
    if (this == paramObject)
      return true; 
    zad zad1 = (zad)paramObject;
    ImageManager.OnImageLoadedListener onImageLoadedListener = this.zanc.get();
    paramObject = zad1.zanc.get();
    return (paramObject != null && onImageLoadedListener != null && Objects.equal(paramObject, onImageLoadedListener) && Objects.equal(zad1.zamu, this.zamu));
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { this.zamu });
  }
  
  protected final void zaa(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    if (!paramBoolean2) {
      ImageManager.OnImageLoadedListener onImageLoadedListener = this.zanc.get();
      if (onImageLoadedListener != null)
        onImageLoadedListener.onImageLoaded(this.zamu.uri, paramDrawable, paramBoolean3); 
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\images\zad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */