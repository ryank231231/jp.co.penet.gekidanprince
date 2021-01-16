package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public interface Target {
  void onBitmapFailed(Drawable paramDrawable);
  
  void onBitmapLoaded(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom);
  
  void onPrepareLoad(Drawable paramDrawable);
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\picasso\Target.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */