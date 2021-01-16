package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

final class zze extends GmsClientSupervisor implements Handler.Callback {
  private final Handler mHandler;
  
  @GuardedBy("mConnectionStatus")
  private final HashMap<GmsClientSupervisor.zza, zzf> zzdu = new HashMap<GmsClientSupervisor.zza, zzf>();
  
  private final Context zzdv;
  
  private final ConnectionTracker zzdw;
  
  private final long zzdx;
  
  private final long zzdy;
  
  zze(Context paramContext) {
    this.zzdv = paramContext.getApplicationContext();
    this.mHandler = (Handler)new com.google.android.gms.internal.common.zze(paramContext.getMainLooper(), this);
    this.zzdw = ConnectionTracker.getInstance();
    this.zzdx = 5000L;
    this.zzdy = 300000L;
  }
  
  public final boolean handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return false;
      case 1:
        synchronized (this.zzdu) {
          GmsClientSupervisor.zza zza = (GmsClientSupervisor.zza)paramMessage.obj;
          zzf zzf = this.zzdu.get(zza);
          if (zzf != null && zzf.getState() == 3) {
            String str = String.valueOf(zza);
            int i = String.valueOf(str).length();
            StringBuilder stringBuilder = new StringBuilder();
            this(i + 47);
            stringBuilder.append("Timeout waiting for ServiceConnection callback ");
            stringBuilder.append(str);
            str = stringBuilder.toString();
            Exception exception = new Exception();
            this();
            Log.e("GmsClientSupervisor", str, exception);
            ComponentName componentName2 = zzf.getComponentName();
            ComponentName componentName1 = componentName2;
            if (componentName2 == null)
              componentName1 = zza.getComponentName(); 
            componentName2 = componentName1;
            if (componentName1 == null) {
              componentName2 = new ComponentName();
              this(zza.getPackage(), "unknown");
            } 
            zzf.onServiceDisconnected(componentName2);
          } 
          return true;
        } 
      case 0:
        break;
    } 
    synchronized (this.zzdu) {
      GmsClientSupervisor.zza zza = (GmsClientSupervisor.zza)paramMessage.obj;
      zzf zzf = this.zzdu.get(zza);
      if (zzf != null && zzf.zzr()) {
        if (zzf.isBound())
          zzf.zzf("GmsClientSupervisor"); 
        this.zzdu.remove(zza);
      } 
      return true;
    } 
  }
  
  protected final boolean zza(GmsClientSupervisor.zza paramzza, ServiceConnection paramServiceConnection, String paramString) {
    Preconditions.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    synchronized (this.zzdu) {
      zzf zzf1;
      String str;
      zzf zzf2 = this.zzdu.get(paramzza);
      if (zzf2 == null) {
        zzf2 = new zzf();
        this(this, paramzza);
        zzf2.zza(paramServiceConnection, paramString);
        zzf2.zze(paramString);
        this.zzdu.put(paramzza, zzf2);
        zzf1 = zzf2;
      } else {
        this.mHandler.removeMessages(0, zzf1);
        if (!zzf2.zza(paramServiceConnection)) {
          zzf2.zza(paramServiceConnection, paramString);
          switch (zzf2.getState()) {
            default:
              zzf1 = zzf2;
              bool = zzf1.isBound();
              return bool;
            case 2:
              zzf2.zze(paramString);
              zzf1 = zzf2;
              bool = zzf1.isBound();
              return bool;
            case 1:
              break;
          } 
          paramServiceConnection.onServiceConnected(zzf2.getComponentName(), zzf2.getBinder());
          zzf1 = zzf2;
          boolean bool = zzf1.isBound();
          return bool;
        } 
        IllegalStateException illegalStateException = new IllegalStateException();
        str = String.valueOf(zzf1);
        int i = String.valueOf(str).length();
        StringBuilder stringBuilder = new StringBuilder();
        this(i + 81);
        stringBuilder.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
        stringBuilder.append(str);
        this(stringBuilder.toString());
        throw illegalStateException;
      } 
      return str.isBound();
    } 
  }
  
  protected final void zzb(GmsClientSupervisor.zza paramzza, ServiceConnection paramServiceConnection, String paramString) {
    Preconditions.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    synchronized (this.zzdu) {
      zzf zzf = this.zzdu.get(paramzza);
      if (zzf != null) {
        Message message;
        if (zzf.zza(paramServiceConnection)) {
          zzf.zzb(paramServiceConnection, paramString);
          if (zzf.zzr()) {
            message = this.mHandler.obtainMessage(0, paramzza);
            this.mHandler.sendMessageDelayed(message, this.zzdx);
          } 
          return;
        } 
        IllegalStateException illegalStateException1 = new IllegalStateException();
        str = String.valueOf(message);
        int j = String.valueOf(str).length();
        StringBuilder stringBuilder1 = new StringBuilder();
        this(j + 76);
        stringBuilder1.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
        stringBuilder1.append(str);
        this(stringBuilder1.toString());
        throw illegalStateException1;
      } 
      IllegalStateException illegalStateException = new IllegalStateException();
      String str = String.valueOf(str);
      int i = String.valueOf(str).length();
      StringBuilder stringBuilder = new StringBuilder();
      this(i + 50);
      stringBuilder.append("Nonexistent connection status for service config: ");
      stringBuilder.append(str);
      this(stringBuilder.toString());
      throw illegalStateException;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */