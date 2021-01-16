package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zaj extends zal {
  private final SparseArray<zaa> zacv = new SparseArray();
  
  private zaj(LifecycleFragment paramLifecycleFragment) {
    super(paramLifecycleFragment);
    this.mLifecycleFragment.addCallback("AutoManageHelper", this);
  }
  
  public static zaj zaa(LifecycleActivity paramLifecycleActivity) {
    LifecycleFragment lifecycleFragment = getFragment(paramLifecycleActivity);
    zaj zaj1 = lifecycleFragment.<zaj>getCallbackOrNull("AutoManageHelper", zaj.class);
    return (zaj1 != null) ? zaj1 : new zaj(lifecycleFragment);
  }
  
  @Nullable
  private final zaa zab(int paramInt) {
    if (this.zacv.size() <= paramInt)
      return null; 
    SparseArray<zaa> sparseArray = this.zacv;
    return (zaa)sparseArray.get(sparseArray.keyAt(paramInt));
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    for (byte b = 0; b < this.zacv.size(); b++) {
      zaa zaa = zab(b);
      if (zaa != null) {
        paramPrintWriter.append(paramString).append("GoogleApiClient #").print(zaa.zacw);
        paramPrintWriter.println(":");
        zaa.zacx.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      } 
    } 
  }
  
  public void onStart() {
    super.onStart();
    boolean bool = this.mStarted;
    String str = String.valueOf(this.zacv);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 14);
    stringBuilder.append("onStart ");
    stringBuilder.append(bool);
    stringBuilder.append(" ");
    stringBuilder.append(str);
    Log.d("AutoManageHelper", stringBuilder.toString());
    if (this.zade.get() == null)
      for (byte b = 0; b < this.zacv.size(); b++) {
        zaa zaa = zab(b);
        if (zaa != null)
          zaa.zacx.connect(); 
      }  
  }
  
  public void onStop() {
    super.onStop();
    for (byte b = 0; b < this.zacv.size(); b++) {
      zaa zaa = zab(b);
      if (zaa != null)
        zaa.zacx.disconnect(); 
    } 
  }
  
  public final void zaa(int paramInt) {
    zaa zaa = (zaa)this.zacv.get(paramInt);
    this.zacv.remove(paramInt);
    if (zaa != null) {
      zaa.zacx.unregisterConnectionFailedListener(zaa);
      zaa.zacx.disconnect();
    } 
  }
  
  public final void zaa(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    Preconditions.checkNotNull(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (this.zacv.indexOfKey(paramInt) < 0) {
      bool = true;
    } else {
      bool = false;
    } 
    StringBuilder stringBuilder1 = new StringBuilder(54);
    stringBuilder1.append("Already managing a GoogleApiClient with id ");
    stringBuilder1.append(paramInt);
    Preconditions.checkState(bool, stringBuilder1.toString());
    zam zam = this.zade.get();
    boolean bool = this.mStarted;
    String str = String.valueOf(zam);
    StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(str).length() + 49);
    stringBuilder2.append("starting AutoManage for client ");
    stringBuilder2.append(paramInt);
    stringBuilder2.append(" ");
    stringBuilder2.append(bool);
    stringBuilder2.append(" ");
    stringBuilder2.append(str);
    Log.d("AutoManageHelper", stringBuilder2.toString());
    paramOnConnectionFailedListener = new zaa(this, paramInt, paramGoogleApiClient, paramOnConnectionFailedListener);
    this.zacv.put(paramInt, paramOnConnectionFailedListener);
    if (this.mStarted && zam == null) {
      String str1 = String.valueOf(paramGoogleApiClient);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 11);
      stringBuilder.append("connecting ");
      stringBuilder.append(str1);
      Log.d("AutoManageHelper", stringBuilder.toString());
      paramGoogleApiClient.connect();
    } 
  }
  
  protected final void zaa(ConnectionResult paramConnectionResult, int paramInt) {
    Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
    if (paramInt < 0) {
      Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
      return;
    } 
    zaa zaa = (zaa)this.zacv.get(paramInt);
    if (zaa != null) {
      zaa(paramInt);
      GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zaa.zacy;
      if (onConnectionFailedListener != null)
        onConnectionFailedListener.onConnectionFailed(paramConnectionResult); 
    } 
  }
  
  protected final void zao() {
    for (byte b = 0; b < this.zacv.size(); b++) {
      zaa zaa = zab(b);
      if (zaa != null)
        zaa.zacx.connect(); 
    } 
  }
  
  private final class zaa implements GoogleApiClient.OnConnectionFailedListener {
    public final int zacw;
    
    public final GoogleApiClient zacx;
    
    public final GoogleApiClient.OnConnectionFailedListener zacy;
    
    public zaa(zaj this$0, int param1Int, GoogleApiClient param1GoogleApiClient, GoogleApiClient.OnConnectionFailedListener param1OnConnectionFailedListener) {
      this.zacw = param1Int;
      this.zacx = param1GoogleApiClient;
      this.zacy = param1OnConnectionFailedListener;
      param1GoogleApiClient.registerConnectionFailedListener(this);
    }
    
    public final void onConnectionFailed(@NonNull ConnectionResult param1ConnectionResult) {
      String str = String.valueOf(param1ConnectionResult);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 27);
      stringBuilder.append("beginFailureResolution for ");
      stringBuilder.append(str);
      Log.d("AutoManageHelper", stringBuilder.toString());
      this.zacz.zab(param1ConnectionResult, this.zacw);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */