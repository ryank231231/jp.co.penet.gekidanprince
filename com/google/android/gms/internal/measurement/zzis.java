package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzis implements Cloneable {
  private Object value;
  
  private zziq<?, ?> zzanj;
  
  private List<zzix> zzank = new ArrayList<zzix>();
  
  private final byte[] toByteArray() throws IOException {
    byte[] arrayOfByte = new byte[zzja()];
    zza(zzin.zzl(arrayOfByte));
    return arrayOfByte;
  }
  
  private final zzis zzpf() {
    zzis zzis1 = new zzis();
    try {
      zzis1.zzanj = this.zzanj;
      if (this.zzank == null) {
        zzis1.zzank = null;
      } else {
        zzis1.zzank.addAll(this.zzank);
      } 
      if (this.value != null)
        if (this.value instanceof zziv) {
          zzis1.value = ((zziv)this.value).clone();
        } else if (this.value instanceof byte[]) {
          zzis1.value = ((byte[])this.value).clone();
        } else {
          boolean bool = this.value instanceof byte[][];
          boolean bool1 = false;
          byte b = 0;
          if (bool) {
            byte[][] arrayOfByte1 = (byte[][])this.value;
            byte[][] arrayOfByte2 = new byte[arrayOfByte1.length][];
            zzis1.value = arrayOfByte2;
            while (b < arrayOfByte1.length) {
              arrayOfByte2[b] = (byte[])arrayOfByte1[b].clone();
              b++;
            } 
          } else if (this.value instanceof boolean[]) {
            zzis1.value = ((boolean[])this.value).clone();
          } else if (this.value instanceof int[]) {
            zzis1.value = ((int[])this.value).clone();
          } else if (this.value instanceof long[]) {
            zzis1.value = ((long[])this.value).clone();
          } else if (this.value instanceof float[]) {
            zzis1.value = ((float[])this.value).clone();
          } else if (this.value instanceof double[]) {
            zzis1.value = ((double[])this.value).clone();
          } else if (this.value instanceof zziv[]) {
            zziv[] arrayOfZziv1 = (zziv[])this.value;
            zziv[] arrayOfZziv2 = new zziv[arrayOfZziv1.length];
            zzis1.value = arrayOfZziv2;
            for (b = bool1; b < arrayOfZziv1.length; b++)
              arrayOfZziv2[b] = (zziv)arrayOfZziv1[b].clone(); 
          } 
        }  
      return zzis1;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new AssertionError(cloneNotSupportedException);
    } 
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzis))
      return false; 
    paramObject = paramObject;
    if (this.value != null && ((zzis)paramObject).value != null) {
      zziq<?, ?> zziq1 = this.zzanj;
      if (zziq1 != ((zzis)paramObject).zzanj)
        return false; 
      if (!zziq1.zzane.isArray())
        return this.value.equals(((zzis)paramObject).value); 
      Object object = this.value;
      return (object instanceof byte[]) ? Arrays.equals((byte[])object, (byte[])((zzis)paramObject).value) : ((object instanceof int[]) ? Arrays.equals((int[])object, (int[])((zzis)paramObject).value) : ((object instanceof long[]) ? Arrays.equals((long[])object, (long[])((zzis)paramObject).value) : ((object instanceof float[]) ? Arrays.equals((float[])object, (float[])((zzis)paramObject).value) : ((object instanceof double[]) ? Arrays.equals((double[])object, (double[])((zzis)paramObject).value) : ((object instanceof boolean[]) ? Arrays.equals((boolean[])object, (boolean[])((zzis)paramObject).value) : Arrays.deepEquals((Object[])object, (Object[])((zzis)paramObject).value))))));
    } 
    List<zzix> list = this.zzank;
    if (list != null) {
      List<zzix> list1 = ((zzis)paramObject).zzank;
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
  
  final void zza(zzin paramzzin) throws IOException {
    if (this.value == null) {
      for (zzix zzix : this.zzank) {
        paramzzin.zzbl(zzix.tag);
        paramzzin.zzm(zzix.zzacg);
      } 
      return;
    } 
    throw new NoSuchMethodError();
  }
  
  final void zza(zzix paramzzix) throws IOException {
    zziv zziv;
    List<zzix> list = this.zzank;
    if (list != null) {
      list.add(paramzzix);
      return;
    } 
    Object object = this.value;
    if (object instanceof zziv) {
      byte[] arrayOfByte = paramzzix.zzacg;
      object = zzim.zzj(arrayOfByte, 0, arrayOfByte.length);
      int i = object.zzlb();
      if (i == arrayOfByte.length - zzin.zzak(i)) {
        zziv = ((zziv)this.value).zza((zzim)object);
        this.zzanj = this.zzanj;
        this.value = zziv;
        this.zzank = null;
        return;
      } 
      throw zziu.zzpg();
    } 
    if (!(object instanceof zziv[])) {
      if (!(object instanceof zzgh)) {
        if (object instanceof zzgh[]) {
          Collections.singletonList(zziv);
          throw new NoSuchMethodError();
        } 
        Collections.singletonList(zziv);
        throw new NoSuchMethodError();
      } 
      Collections.singletonList(zziv);
      throw new NoSuchMethodError();
    } 
    Collections.singletonList(zziv);
    throw new NoSuchMethodError();
  }
  
  final int zzja() {
    if (this.value == null) {
      Iterator<zzix> iterator = this.zzank.iterator();
      int i;
      for (i = 0; iterator.hasNext(); i += zzin.zzar(zzix.tag) + 0 + zzix.zzacg.length)
        zzix zzix = iterator.next(); 
      return i;
    } 
    throw new NoSuchMethodError();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */