package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class zaab {
  private final Map<BasePendingResult<?>, Boolean> zafj = Collections.synchronizedMap(new WeakHashMap<BasePendingResult<?>, Boolean>());
  
  private final Map<TaskCompletionSource<?>, Boolean> zafk = Collections.synchronizedMap(new WeakHashMap<TaskCompletionSource<?>, Boolean>());
  
  private final void zaa(boolean paramBoolean, Status paramStatus) {
    Map<BasePendingResult<?>, Boolean> map;
    synchronized (this.zafj) {
      Map<TaskCompletionSource<?>, Boolean> map1;
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      this((Map)this.zafj);
      synchronized (this.zafk) {
        map = new HashMap<BasePendingResult<?>, Boolean>();
        super((Map)this.zafk);
        for (Map.Entry<Object, Object> entry1 : hashMap.entrySet()) {
          if (paramBoolean || ((Boolean)entry1.getValue()).booleanValue())
            ((BasePendingResult)entry1.getKey()).zab(paramStatus); 
        } 
        for (Map.Entry<BasePendingResult<?>, Boolean> entry : map.entrySet()) {
          if (paramBoolean || ((Boolean)entry.getValue()).booleanValue())
            ((TaskCompletionSource)entry.getKey()).trySetException((Exception)new ApiException(paramStatus)); 
        } 
        return;
      } 
    } 
  }
  
  final void zaa(BasePendingResult<? extends Result> paramBasePendingResult, boolean paramBoolean) {
    this.zafj.put(paramBasePendingResult, Boolean.valueOf(paramBoolean));
    paramBasePendingResult.addStatusListener(new zaac(this, paramBasePendingResult));
  }
  
  final <TResult> void zaa(TaskCompletionSource<TResult> paramTaskCompletionSource, boolean paramBoolean) {
    this.zafk.put(paramTaskCompletionSource, Boolean.valueOf(paramBoolean));
    paramTaskCompletionSource.getTask().addOnCompleteListener(new zaad(this, paramTaskCompletionSource));
  }
  
  final boolean zaag() {
    return (!this.zafj.isEmpty() || !this.zafk.isEmpty());
  }
  
  public final void zaah() {
    zaa(false, GoogleApiManager.zahw);
  }
  
  public final void zaai() {
    zaa(true, zacp.zakw);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */