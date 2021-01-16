package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

class ImageViewAction extends Action<ImageView> {
  Callback callback;
  
  ImageViewAction(Picasso paramPicasso, ImageView paramImageView, Request paramRequest, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString, Object paramObject, Callback paramCallback, boolean paramBoolean) {
    super(paramPicasso, paramImageView, paramRequest, paramInt1, paramInt2, paramInt3, paramDrawable, paramString, paramObject, paramBoolean);
    this.callback = paramCallback;
  }
  
  void cancel() {
    super.cancel();
    if (this.callback != null)
      this.callback = null; 
  }
  
  public void complete(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom) {
    if (paramBitmap != null) {
      ImageView imageView = this.target.get();
      if (imageView == null)
        return; 
      Context context = this.picasso.context;
      boolean bool = this.picasso.indicatorsEnabled;
      PicassoDrawable.setBitmap(imageView, context, paramBitmap, paramLoadedFrom, this.noFade, bool);
      Callback callback = this.callback;
      if (callback != null)
        callback.onSuccess(); 
      return;
    } 
    throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[] { this }));
  }
  
  public void error() {
    ImageView imageView = this.target.get();
    if (imageView == null)
      return; 
    if (this.errorResId != 0) {
      imageView.setImageResource(this.errorResId);
    } else if (this.errorDrawable != null) {
      imageView.setImageDrawable(this.errorDrawable);
    } 
    Callback callback = this.callback;
    if (callback != null)
      callback.onError(); 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\picasso\ImageViewAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */