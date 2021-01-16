package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public final class GmsClientEventManager implements Handler.Callback {
  private final Handler mHandler;
  
  private final Object mLock = new Object();
  
  private final GmsClientEventState zaok;
  
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zaol = new ArrayList<GoogleApiClient.ConnectionCallbacks>();
  
  @VisibleForTesting
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zaom = new ArrayList<GoogleApiClient.ConnectionCallbacks>();
  
  private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zaon = new ArrayList<GoogleApiClient.OnConnectionFailedListener>();
  
  private volatile boolean zaoo = false;
  
  private final AtomicInteger zaop = new AtomicInteger(0);
  
  private boolean zaoq = false;
  
  public GmsClientEventManager(Looper paramLooper, GmsClientEventState paramGmsClientEventState) {
    this.zaok = paramGmsClientEventState;
    this.mHandler = (Handler)new zal(paramLooper, this);
  }
  
  public final boolean areCallbacksEnabled() {
    return this.zaoo;
  }
  
  public final void disableCallbacks() {
    this.zaoo = false;
    this.zaop.incrementAndGet();
  }
  
  public final void enableCallbacks() {
    this.zaoo = true;
  }
  
  public final boolean handleMessage(Message paramMessage) {
    if (paramMessage.what == 1) {
      null = (GoogleApiClient.ConnectionCallbacks)paramMessage.obj;
      synchronized (this.mLock) {
        if (this.zaoo && this.zaok.isConnected() && this.zaol.contains(null))
          null.onConnected(this.zaok.getConnectionHint()); 
        return true;
      } 
    } 
    int i = paramMessage.what;
    StringBuilder stringBuilder = new StringBuilder(45);
    stringBuilder.append("Don't know how to handle message: ");
    stringBuilder.append(i);
    Log.wtf("GmsClientEvents", stringBuilder.toString(), new Exception());
    return false;
  }
  
  public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    Preconditions.checkNotNull(paramConnectionCallbacks);
    synchronized (this.mLock) {
      return this.zaol.contains(paramConnectionCallbacks);
    } 
  }
  
  public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    synchronized (this.mLock) {
      return this.zaon.contains(paramOnConnectionFailedListener);
    } 
  }
  
  @VisibleForTesting
  public final void onConnectionFailure(ConnectionResult paramConnectionResult) {
    boolean bool;
    Looper looper1 = Looper.myLooper();
    Looper looper2 = this.mHandler.getLooper();
    int i = 0;
    if (looper1 == looper2) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "onConnectionFailure must only be called on the Handler thread");
    this.mHandler.removeMessages(1);
    synchronized (this.mLock) {
      ArrayList<Object> arrayList = new ArrayList();
      this((Collection)this.zaon);
      int j = this.zaop.get();
      arrayList = arrayList;
      int k = arrayList.size();
      while (i < k) {
        GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)arrayList.get(i);
        int m = i + 1;
        onConnectionFailedListener = onConnectionFailedListener;
        if (!this.zaoo || this.zaop.get() != j)
          return; 
        i = m;
        if (this.zaon.contains(onConnectionFailedListener)) {
          onConnectionFailedListener.onConnectionFailed(paramConnectionResult);
          i = m;
        } 
      } 
      return;
    } 
  }
  
  @VisibleForTesting
  protected final void onConnectionSuccess() {
    synchronized (this.mLock) {
      onConnectionSuccess(this.zaok.getConnectionHint());
      return;
    } 
  }
  
  @VisibleForTesting
  public final void onConnectionSuccess(Bundle paramBundle) {
    boolean bool2;
    Looper looper1 = Looper.myLooper();
    Looper looper2 = this.mHandler.getLooper();
    boolean bool1 = true;
    if (looper1 == looper2) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "onConnectionSuccess must only be called on the Handler thread");
    synchronized (this.mLock) {
      if (!this.zaoq) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkState(bool2);
      this.mHandler.removeMessages(1);
      this.zaoq = true;
      if (this.zaom.size() == 0) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkState(bool2);
      ArrayList<Object> arrayList = new ArrayList();
      this((Collection)this.zaol);
      int i = this.zaop.get();
      arrayList = arrayList;
      int j = arrayList.size();
      int k = 0;
      while (k < j) {
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks)arrayList.get(k);
        int m = k + 1;
        connectionCallbacks = connectionCallbacks;
        if (this.zaoo && this.zaok.isConnected() && this.zaop.get() == i) {
          k = m;
          if (!this.zaom.contains(connectionCallbacks)) {
            connectionCallbacks.onConnected(paramBundle);
            k = m;
          } 
        } 
      } 
      this.zaom.clear();
      this.zaoq = false;
      return;
    } 
  }
  
  @VisibleForTesting
  public final void onUnintentionalDisconnection(int paramInt) {
    boolean bool;
    if (Looper.myLooper() == this.mHandler.getLooper()) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
    this.mHandler.removeMessages(1);
    synchronized (this.mLock) {
      this.zaoq = true;
      ArrayList<Object> arrayList = new ArrayList();
      this((Collection)this.zaol);
      int i = this.zaop.get();
      arrayList = arrayList;
      int j = arrayList.size();
      int k = 0;
      while (k < j) {
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks)arrayList.get(k);
        int m = k + 1;
        connectionCallbacks = connectionCallbacks;
        if (this.zaoo && this.zaop.get() == i) {
          k = m;
          if (this.zaol.contains(connectionCallbacks)) {
            connectionCallbacks.onConnectionSuspended(paramInt);
            k = m;
          } 
        } 
      } 
      this.zaom.clear();
      this.zaoq = false;
      return;
    } 
  }
  
  public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    Preconditions.checkNotNull(paramConnectionCallbacks);
    synchronized (this.mLock) {
      if (this.zaol.contains(paramConnectionCallbacks)) {
        String str = String.valueOf(paramConnectionCallbacks);
        int i = String.valueOf(str).length();
        StringBuilder stringBuilder = new StringBuilder();
        this(i + 62);
        stringBuilder.append("registerConnectionCallbacks(): listener ");
        stringBuilder.append(str);
        stringBuilder.append(" is already registered");
        Log.w("GmsClientEvents", stringBuilder.toString());
      } else {
        this.zaol.add(paramConnectionCallbacks);
      } 
      if (this.zaok.isConnected()) {
        null = this.mHandler;
        null.sendMessage(null.obtainMessage(1, paramConnectionCallbacks));
      } 
      return;
    } 
  }
  
  public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    synchronized (this.mLock) {
      StringBuilder stringBuilder;
      if (this.zaon.contains(paramOnConnectionFailedListener)) {
        String str = String.valueOf(paramOnConnectionFailedListener);
        int i = String.valueOf(str).length();
        stringBuilder = new StringBuilder();
        this(i + 67);
        stringBuilder.append("registerConnectionFailedListener(): listener ");
        stringBuilder.append(str);
        stringBuilder.append(" is already registered");
        Log.w("GmsClientEvents", stringBuilder.toString());
      } else {
        this.zaon.add(stringBuilder);
      } 
      return;
    } 
  }
  
  public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    Preconditions.checkNotNull(paramConnectionCallbacks);
    synchronized (this.mLock) {
      String str;
      if (!this.zaol.remove(paramConnectionCallbacks)) {
        str = String.valueOf(paramConnectionCallbacks);
        int i = String.valueOf(str).length();
        StringBuilder stringBuilder = new StringBuilder();
        this(i + 52);
        stringBuilder.append("unregisterConnectionCallbacks(): listener ");
        stringBuilder.append(str);
        stringBuilder.append(" not found");
        Log.w("GmsClientEvents", stringBuilder.toString());
      } else if (this.zaoq) {
        this.zaom.add(str);
      } 
      return;
    } 
  }
  
  public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    synchronized (this.mLock) {
      if (!this.zaon.remove(paramOnConnectionFailedListener)) {
        String str = String.valueOf(paramOnConnectionFailedListener);
        int i = String.valueOf(str).length();
        StringBuilder stringBuilder = new StringBuilder();
        this(i + 57);
        stringBuilder.append("unregisterConnectionFailedListener(): listener ");
        stringBuilder.append(str);
        stringBuilder.append(" not found");
        Log.w("GmsClientEvents", stringBuilder.toString());
      } 
      return;
    } 
  }
  
  @VisibleForTesting
  public static interface GmsClientEventState {
    Bundle getConnectionHint();
    
    boolean isConnected();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\GmsClientEventManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */