package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.content.Context;
import com.google.firebase.inappmessaging.display.internal.PicassoErrorListener;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;
import java.io.IOException;

@Module
public class PicassoModule {
  @Provides
  @FirebaseAppScope
  Picasso providesFiamController(Application paramApplication, PicassoErrorListener paramPicassoErrorListener) {
    OkHttpClient okHttpClient = new OkHttpClient();
    okHttpClient.interceptors().add(new Interceptor() {
          public Response intercept(Interceptor.Chain param1Chain) throws IOException {
            return param1Chain.proceed(param1Chain.request().newBuilder().addHeader("Accept", "image/*").build());
          }
        });
    Picasso.Builder builder = new Picasso.Builder((Context)paramApplication);
    builder.listener((Picasso.Listener)paramPicassoErrorListener).downloader((Downloader)new OkHttpDownloader(okHttpClient));
    return builder.build();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\modules\PicassoModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */