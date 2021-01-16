package com.google.firebase.inappmessaging.display.internal;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;

@FirebaseAppScope
public class FiamImageLoader {
  private final Picasso picasso;
  
  @Inject
  FiamImageLoader(Picasso paramPicasso) {
    this.picasso = paramPicasso;
  }
  
  public void cancelTag(Class paramClass) {
    this.picasso.cancelTag(paramClass);
  }
  
  public FiamImageRequestCreator load(@Nullable String paramString) {
    return new FiamImageRequestCreator(this.picasso.load(paramString));
  }
  
  public static class FiamImageRequestCreator {
    private final RequestCreator mRequestCreator;
    
    public FiamImageRequestCreator(RequestCreator param1RequestCreator) {
      this.mRequestCreator = param1RequestCreator;
    }
    
    public void into(ImageView param1ImageView, Callback param1Callback) {
      this.mRequestCreator.into(param1ImageView, param1Callback);
    }
    
    public FiamImageRequestCreator placeholder(int param1Int) {
      this.mRequestCreator.placeholder(param1Int);
      return this;
    }
    
    public FiamImageRequestCreator tag(Class param1Class) {
      this.mRequestCreator.tag(param1Class);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\FiamImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */