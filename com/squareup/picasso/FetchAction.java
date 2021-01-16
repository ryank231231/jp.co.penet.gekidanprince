package com.squareup.picasso;

import android.graphics.Bitmap;

class FetchAction extends Action<Object> {
  private Callback callback;
  
  private final Object target = new Object();
  
  FetchAction(Picasso paramPicasso, Request paramRequest, int paramInt1, int paramInt2, Object paramObject, String paramString, Callback paramCallback) {
    super(paramPicasso, null, paramRequest, paramInt1, paramInt2, 0, null, paramString, paramObject, false);
    this.callback = paramCallback;
  }
  
  void cancel() {
    super.cancel();
    this.callback = null;
  }
  
  void complete(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom) {
    Callback callback = this.callback;
    if (callback != null)
      callback.onSuccess(); 
  }
  
  void error() {
    Callback callback = this.callback;
    if (callback != null)
      callback.onError(); 
  }
  
  Object getTarget() {
    return this.target;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\picasso\FetchAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */