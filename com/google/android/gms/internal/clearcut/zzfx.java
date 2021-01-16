package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class zzfx implements Cloneable {
  private Object value;
  
  private zzfv<?, ?> zzrp;
  
  private List<Object> zzrq = new ArrayList();
  
  private final byte[] toByteArray() throws IOException {
    byte[] arrayOfByte = new byte[zzen()];
    zza(zzfs.zzg(arrayOfByte));
    return arrayOfByte;
  }
  
  private final zzfx zzeq() {
    zzfx zzfx1 = new zzfx();
    try {
      Object object;
      zzfx1.zzrp = this.zzrp;
      if (this.zzrq == null) {
        zzfx1.zzrq = null;
      } else {
        zzfx1.zzrq.addAll(this.zzrq);
      } 
      if (this.value != null) {
        if (this.value instanceof zzfz) {
          object = ((zzfz)this.value).clone();
        } else if (this.value instanceof byte[]) {
          object = ((byte[])this.value).clone();
        } else {
          boolean bool = this.value instanceof byte[][];
          boolean bool1 = false;
          byte b = 0;
          if (bool) {
            object = this.value;
            byte[][] arrayOfByte = new byte[object.length][];
            zzfx1.value = arrayOfByte;
            while (b < object.length) {
              arrayOfByte[b] = (byte[])object[b].clone();
              b++;
            } 
          } else {
            if (this.value instanceof boolean[]) {
              object = ((boolean[])this.value).clone();
            } else if (this.value instanceof int[]) {
              object = ((int[])this.value).clone();
            } else if (this.value instanceof long[]) {
              object = ((long[])this.value).clone();
            } else if (this.value instanceof float[]) {
              object = ((float[])this.value).clone();
            } else if (this.value instanceof double[]) {
              object = ((double[])this.value).clone();
            } else {
              if (this.value instanceof zzfz[]) {
                object = this.value;
                zzfz[] arrayOfZzfz = new zzfz[object.length];
                zzfx1.value = arrayOfZzfz;
                for (b = bool1; b < object.length; b++)
                  arrayOfZzfz[b] = (zzfz)object[b].clone(); 
              } 
              return zzfx1;
            } 
            zzfx1.value = object;
          } 
          return zzfx1;
        } 
      } else {
        return zzfx1;
      } 
      zzfx1.value = object;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new AssertionError(cloneNotSupportedException);
    } 
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzfx))
      return false; 
    paramObject = paramObject;
    if (this.value != null && ((zzfx)paramObject).value != null) {
      zzfv<?, ?> zzfv1 = this.zzrp;
      if (zzfv1 != ((zzfx)paramObject).zzrp)
        return false; 
      if (!zzfv1.zzrk.isArray())
        return this.value.equals(((zzfx)paramObject).value); 
      Object object = this.value;
      return (object instanceof byte[]) ? Arrays.equals((byte[])object, (byte[])((zzfx)paramObject).value) : ((object instanceof int[]) ? Arrays.equals((int[])object, (int[])((zzfx)paramObject).value) : ((object instanceof long[]) ? Arrays.equals((long[])object, (long[])((zzfx)paramObject).value) : ((object instanceof float[]) ? Arrays.equals((float[])object, (float[])((zzfx)paramObject).value) : ((object instanceof double[]) ? Arrays.equals((double[])object, (double[])((zzfx)paramObject).value) : ((object instanceof boolean[]) ? Arrays.equals((boolean[])object, (boolean[])((zzfx)paramObject).value) : Arrays.deepEquals((Object[])object, (Object[])((zzfx)paramObject).value))))));
    } 
    List<Object> list = this.zzrq;
    if (list != null) {
      List<Object> list1 = ((zzfx)paramObject).zzrq;
      if (list1 != null)
        return list.equals(list1); 
    } 
    try {
      return Arrays.equals(toByteArray(), paramObject.toByteArray());
    } catch (IOException iOException) {
      throw new IllegalStateException(iOException);
    } 
  }
  
  public final int hashCode() {
    try {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    } catch (IOException iOException) {
      throw new IllegalStateException(iOException);
    } 
  }
  
  final void zza(zzfs paramzzfs) throws IOException {
    if (this.value == null) {
      Iterator iterator = this.zzrq.iterator();
      if (!iterator.hasNext())
        return; 
      iterator.next();
      throw new NoSuchMethodError();
    } 
    throw new NoSuchMethodError();
  }
  
  final int zzen() {
    if (this.value == null) {
      Iterator iterator = this.zzrq.iterator();
      if (!iterator.hasNext())
        return 0; 
      iterator.next();
      throw new NoSuchMethodError();
    } 
    throw new NoSuchMethodError();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzfx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */