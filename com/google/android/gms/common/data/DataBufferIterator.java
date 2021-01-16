package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

@KeepForSdk
public class DataBufferIterator<T> implements Iterator<T> {
  protected final DataBuffer<T> zalj;
  
  protected int zalk;
  
  public DataBufferIterator(DataBuffer<T> paramDataBuffer) {
    this.zalj = (DataBuffer<T>)Preconditions.checkNotNull(paramDataBuffer);
    this.zalk = -1;
  }
  
  public boolean hasNext() {
    return (this.zalk < this.zalj.getCount() - 1);
  }
  
  public T next() {
    if (hasNext()) {
      DataBuffer<T> dataBuffer = this.zalj;
      int j = this.zalk + 1;
      this.zalk = j;
      return dataBuffer.get(j);
    } 
    int i = this.zalk;
    StringBuilder stringBuilder = new StringBuilder(46);
    stringBuilder.append("Cannot advance the iterator beyond ");
    stringBuilder.append(i);
    throw new NoSuchElementException(stringBuilder.toString());
  }
  
  public void remove() {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\data\DataBufferIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */