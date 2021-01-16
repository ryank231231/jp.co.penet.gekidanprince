package com.squareup.picasso;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import java.io.IOException;
import java.io.InputStream;

class ContactsPhotoRequestHandler extends RequestHandler {
  private static final int ID_CONTACT = 3;
  
  private static final int ID_DISPLAY_PHOTO = 4;
  
  private static final int ID_LOOKUP = 1;
  
  private static final int ID_THUMBNAIL = 2;
  
  private static final UriMatcher matcher = new UriMatcher(-1);
  
  private final Context context;
  
  static {
    matcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
    matcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
    matcher.addURI("com.android.contacts", "contacts/#/photo", 2);
    matcher.addURI("com.android.contacts", "contacts/#", 3);
    matcher.addURI("com.android.contacts", "display_photo/#", 4);
  }
  
  ContactsPhotoRequestHandler(Context paramContext) {
    this.context = paramContext;
  }
  
  private InputStream getInputStream(Request paramRequest) throws IOException {
    StringBuilder stringBuilder;
    Uri uri1;
    ContentResolver contentResolver = this.context.getContentResolver();
    Uri uri3 = paramRequest.uri;
    Uri uri2 = uri3;
    switch (matcher.match(uri3)) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid uri: ");
        stringBuilder.append(uri3);
        throw new IllegalStateException(stringBuilder.toString());
      case 2:
      case 4:
        return contentResolver.openInputStream(uri3);
      case 1:
        uri3 = ContactsContract.Contacts.lookupContact(contentResolver, uri3);
        uri1 = uri3;
        if (uri3 == null)
          return null; 
        break;
      case 3:
        break;
    } 
    return (Build.VERSION.SDK_INT < 14) ? ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri1) : ContactPhotoStreamIcs.get(contentResolver, uri1);
  }
  
  public boolean canHandleRequest(Request paramRequest) {
    boolean bool;
    Uri uri = paramRequest.uri;
    if ("content".equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && matcher.match(paramRequest.uri) != -1) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public RequestHandler.Result load(Request paramRequest, int paramInt) throws IOException {
    InputStream inputStream = getInputStream(paramRequest);
    if (inputStream != null) {
      RequestHandler.Result result = new RequestHandler.Result(inputStream, Picasso.LoadedFrom.DISK);
    } else {
      inputStream = null;
    } 
    return (RequestHandler.Result)inputStream;
  }
  
  @TargetApi(14)
  private static class ContactPhotoStreamIcs {
    static InputStream get(ContentResolver param1ContentResolver, Uri param1Uri) {
      return ContactsContract.Contacts.openContactPhotoInputStream(param1ContentResolver, param1Uri, true);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\picasso\ContactsPhotoRequestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */