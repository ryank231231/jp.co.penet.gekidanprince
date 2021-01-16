package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.NoSuchElementException;

@KeepForSdk
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
  private T zamf;
  
  public SingleRefDataBufferIterator(DataBuffer<T> paramDataBuffer) {
    super(paramDataBuffer);
  }
  
  public T next() {
    if (hasNext()) {
      this.zalk++;
      if (this.zalk == 0) {
        this.zamf = this.zalj.get(0);
        T t = this.zamf;
        if (!(t instanceof DataBufferRef)) {
          String str = String.valueOf(t.getClass());
          StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(str).length() + 44);
          stringBuilder1.append("DataBuffer reference of type ");
          stringBuilder1.append(str);
          stringBuilder1.append(" is not movable");
          throw new IllegalStateException(stringBuilder1.toString());
        } 
      } else {
        ((DataBufferRef)this.zamf).zag(this.zalk);
      } 
      return this.zamf;
    } 
    int i = this.zalk;
    StringBuilder stringBuilder = new StringBuilder(46);
    stringBuilder.append("Cannot advance the iterator beyond ");
    stringBuilder.append(i);
    throw new NoSuchElementException(stringBuilder.toString());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\data\SingleRefDataBufferIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */