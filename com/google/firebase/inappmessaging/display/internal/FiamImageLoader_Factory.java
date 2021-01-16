package com.google.firebase.inappmessaging.display.internal;

import com.squareup.picasso.Picasso;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FiamImageLoader_Factory implements Factory<FiamImageLoader> {
  private final Provider<Picasso> picassoProvider;
  
  public FiamImageLoader_Factory(Provider<Picasso> paramProvider) {
    this.picassoProvider = paramProvider;
  }
  
  public static Factory<FiamImageLoader> create(Provider<Picasso> paramProvider) {
    return new FiamImageLoader_Factory(paramProvider);
  }
  
  public static FiamImageLoader newFiamImageLoader(Picasso paramPicasso) {
    return new FiamImageLoader(paramPicasso);
  }
  
  public FiamImageLoader get() {
    return new FiamImageLoader((Picasso)this.picassoProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\FiamImageLoader_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */