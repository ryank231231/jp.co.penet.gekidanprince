package com.squareup.picasso;

import android.graphics.Bitmap;

class GetAction extends Action<Void> {
  GetAction(Picasso paramPicasso, Request paramRequest, int paramInt1, int paramInt2, Object paramObject, String paramString) {
    super(paramPicasso, null, paramRequest, paramInt1, paramInt2, 0, null, paramString, paramObject, false);
  }
  
  void complete(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom) {}
  
  public void error() {}
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\picasso\GetAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */