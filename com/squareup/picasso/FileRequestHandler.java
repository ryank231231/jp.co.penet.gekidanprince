package com.squareup.picasso;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import java.io.IOException;

class FileRequestHandler extends ContentStreamRequestHandler {
  FileRequestHandler(Context paramContext) {
    super(paramContext);
  }
  
  static int getFileExifRotation(Uri paramUri) throws IOException {
    int i = (new ExifInterface(paramUri.getPath())).getAttributeInt("Orientation", 1);
    return (i != 3) ? ((i != 6) ? ((i != 8) ? 0 : 270) : 90) : 180;
  }
  
  public boolean canHandleRequest(Request paramRequest) {
    return "file".equals(paramRequest.uri.getScheme());
  }
  
  public RequestHandler.Result load(Request paramRequest, int paramInt) throws IOException {
    return new RequestHandler.Result(null, getInputStream(paramRequest), Picasso.LoadedFrom.DISK, getFileExifRotation(paramRequest.uri));
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\picasso\FileRequestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */