package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class zzay extends zzfs {
  private final SSLSocketFactory zzkj;
  
  public zzay(zzft paramzzft) {
    super(paramzzft);
    if (Build.VERSION.SDK_INT < 19) {
      zzge zzge = new zzge();
    } else {
      paramzzft = null;
    } 
    this.zzkj = (SSLSocketFactory)paramzzft;
  }
  
  @WorkerThread
  private static byte[] zza(HttpURLConnection paramHttpURLConnection) throws IOException {
    InputStream inputStream1 = null;
    InputStream inputStream2 = inputStream1;
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      inputStream2 = inputStream1;
      this();
      inputStream2 = inputStream1;
      InputStream inputStream = paramHttpURLConnection.getInputStream();
      inputStream2 = inputStream;
      byte[] arrayOfByte = new byte[1024];
      while (true) {
        inputStream2 = inputStream;
        int i = inputStream.read(arrayOfByte);
        if (i > 0) {
          inputStream2 = inputStream;
          byteArrayOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        inputStream2 = inputStream;
        arrayOfByte = byteArrayOutputStream.toByteArray();
        return arrayOfByte;
      } 
    } finally {
      if (inputStream2 != null)
        inputStream2.close(); 
    } 
  }
  
  @WorkerThread
  @VisibleForTesting
  protected final HttpURLConnection zza(URL paramURL) throws IOException {
    URLConnection uRLConnection = paramURL.openConnection();
    if (uRLConnection instanceof HttpURLConnection) {
      SSLSocketFactory sSLSocketFactory = this.zzkj;
      if (sSLSocketFactory != null && uRLConnection instanceof HttpsURLConnection)
        ((HttpsURLConnection)uRLConnection).setSSLSocketFactory(sSLSocketFactory); 
      uRLConnection = uRLConnection;
      uRLConnection.setDefaultUseCaches(false);
      uRLConnection.setConnectTimeout(60000);
      uRLConnection.setReadTimeout(61000);
      uRLConnection.setInstanceFollowRedirects(false);
      uRLConnection.setDoInput(true);
      return (HttpURLConnection)uRLConnection;
    } 
    throw new IOException("Failed to obtain HTTP connection");
  }
  
  protected final boolean zzak() {
    return false;
  }
  
  public final boolean zzdl() {
    zzah();
    ConnectivityManager connectivityManager = (ConnectivityManager)super.getContext().getSystemService("connectivity");
    try {
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    } catch (SecurityException securityException) {
      securityException = null;
    } 
    return (securityException != null && securityException.isConnected());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */