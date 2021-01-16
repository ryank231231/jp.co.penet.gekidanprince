package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zal;

@KeepForSdk
public final class ListenerHolder<L> {
  private final zaa zaji;
  
  private volatile L zajj;
  
  private final ListenerKey<L> zajk;
  
  @KeepForSdk
  ListenerHolder(@NonNull Looper paramLooper, @NonNull L paramL, @NonNull String paramString) {
    this.zaji = new zaa(this, paramLooper);
    this.zajj = (L)Preconditions.checkNotNull(paramL, "Listener must not be null");
    this.zajk = new ListenerKey<L>(paramL, Preconditions.checkNotEmpty(paramString));
  }
  
  @KeepForSdk
  public final void clear() {
    this.zajj = null;
  }
  
  @NonNull
  @KeepForSdk
  public final ListenerKey<L> getListenerKey() {
    return this.zajk;
  }
  
  @KeepForSdk
  public final boolean hasListener() {
    return (this.zajj != null);
  }
  
  @KeepForSdk
  public final void notifyListener(Notifier<? super L> paramNotifier) {
    Preconditions.checkNotNull(paramNotifier, "Notifier must not be null");
    Message message = this.zaji.obtainMessage(1, paramNotifier);
    this.zaji.sendMessage(message);
  }
  
  @KeepForSdk
  final void notifyListenerInternal(Notifier<? super L> paramNotifier) {
    L l = this.zajj;
    if (l == null) {
      paramNotifier.onNotifyListenerFailed();
      return;
    } 
    try {
      paramNotifier.notifyListener(l);
      return;
    } catch (RuntimeException runtimeException) {
      paramNotifier.onNotifyListenerFailed();
      throw runtimeException;
    } 
  }
  
  @KeepForSdk
  public static final class ListenerKey<L> {
    private final L zajj;
    
    private final String zajm;
    
    @KeepForSdk
    ListenerKey(L param1L, String param1String) {
      this.zajj = param1L;
      this.zajm = param1String;
    }
    
    public final boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (!(param1Object instanceof ListenerKey))
        return false; 
      param1Object = param1Object;
      return (this.zajj == ((ListenerKey)param1Object).zajj && this.zajm.equals(((ListenerKey)param1Object).zajm));
    }
    
    public final int hashCode() {
      return System.identityHashCode(this.zajj) * 31 + this.zajm.hashCode();
    }
  }
  
  @KeepForSdk
  public static interface Notifier<L> {
    @KeepForSdk
    void notifyListener(L param1L);
    
    @KeepForSdk
    void onNotifyListenerFailed();
  }
  
  private final class zaa extends zal {
    public zaa(ListenerHolder this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    public final void handleMessage(Message param1Message) {
      int i = param1Message.what;
      boolean bool = true;
      if (i != 1)
        bool = false; 
      Preconditions.checkArgument(bool);
      this.zajl.notifyListenerInternal((ListenerHolder.Notifier)param1Message.obj);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\ListenerHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */