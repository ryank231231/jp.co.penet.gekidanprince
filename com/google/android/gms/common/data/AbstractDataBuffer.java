package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {
  protected final DataHolder mDataHolder;
  
  @KeepForSdk
  protected AbstractDataBuffer(DataHolder paramDataHolder) {
    this.mDataHolder = paramDataHolder;
  }
  
  @Deprecated
  public final void close() {
    release();
  }
  
  public abstract T get(int paramInt);
  
  public int getCount() {
    DataHolder dataHolder = this.mDataHolder;
    return (dataHolder == null) ? 0 : dataHolder.getCount();
  }
  
  public Bundle getMetadata() {
    return this.mDataHolder.getMetadata();
  }
  
  @Deprecated
  public boolean isClosed() {
    DataHolder dataHolder = this.mDataHolder;
    return (dataHolder == null || dataHolder.isClosed());
  }
  
  public Iterator<T> iterator() {
    return new DataBufferIterator<T>(this);
  }
  
  public void release() {
    DataHolder dataHolder = this.mDataHolder;
    if (dataHolder != null)
      dataHolder.close(); 
  }
  
  public Iterator<T> singleRefIterator() {
    return new SingleRefDataBufferIterator<T>(this);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\data\AbstractDataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */