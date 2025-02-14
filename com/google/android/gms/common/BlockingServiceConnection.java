package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@KeepForSdk
public class BlockingServiceConnection implements ServiceConnection {
  private boolean zze = false;
  
  private final BlockingQueue<IBinder> zzf = new LinkedBlockingQueue<IBinder>();
  
  @KeepForSdk
  public IBinder getService() throws InterruptedException {
    Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
    if (!this.zze) {
      this.zze = true;
      return this.zzf.take();
    } 
    throw new IllegalStateException("Cannot call get on this connection more than once");
  }
  
  @KeepForSdk
  public IBinder getServiceWithTimeout(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, TimeoutException {
    Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
    if (!this.zze) {
      this.zze = true;
      IBinder iBinder = this.zzf.poll(paramLong, paramTimeUnit);
      if (iBinder != null)
        return iBinder; 
      throw new TimeoutException("Timed out waiting for the service connection");
    } 
    throw new IllegalStateException("Cannot call get on this connection more than once");
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    this.zzf.add(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\BlockingServiceConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */