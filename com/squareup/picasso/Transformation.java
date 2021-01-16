package com.squareup.picasso;

import android.graphics.Bitmap;

public interface Transformation {
  String key();
  
  Bitmap transform(Bitmap paramBitmap);
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\picasso\Transformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */