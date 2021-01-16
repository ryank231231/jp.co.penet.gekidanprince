package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class zzdg<MessageType extends zzdg<MessageType, BuilderType>, BuilderType extends zzdh<MessageType, BuilderType>> implements zzgh {
  private static boolean zzabn = false;
  
  protected int zzabm = 0;
  
  protected static <T> void zza(Iterable<T> paramIterable, List<? super T> paramList) {
    String str;
    zzfb.checkNotNull(paramIterable);
    if (paramIterable instanceof zzfq) {
      List<?> list = ((zzfq)paramIterable).zzng();
      paramIterable = (zzfq)paramList;
      int j = paramList.size();
      Iterator<?> iterator1 = list.iterator();
      while (iterator1.hasNext()) {
        list = (List<?>)iterator1.next();
        if (list == null) {
          int k = paramIterable.size();
          StringBuilder stringBuilder = new StringBuilder(37);
          stringBuilder.append("Element at index ");
          stringBuilder.append(k - j);
          stringBuilder.append(" is null.");
          str = stringBuilder.toString();
          for (k = paramIterable.size() - 1; k >= j; k--)
            paramIterable.remove(k); 
          throw new NullPointerException(str);
        } 
        if (list instanceof zzdp) {
          paramIterable.zzc((zzdp)list);
          continue;
        } 
        paramIterable.add(list);
      } 
      return;
    } 
    if (paramIterable instanceof zzgt) {
      str.addAll((Collection)paramIterable);
      return;
    } 
    if (str instanceof ArrayList && paramIterable instanceof Collection)
      ((ArrayList)str).ensureCapacity(str.size() + ((Collection)paramIterable).size()); 
    int i = str.size();
    Iterator<T> iterator = paramIterable.iterator();
    while (iterator.hasNext()) {
      T t = iterator.next();
      if (t == null) {
        int j = str.size();
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Element at index ");
        stringBuilder.append(j - i);
        stringBuilder.append(" is null.");
        String str1 = stringBuilder.toString();
        for (j = str.size() - 1; j >= i; j--)
          str.remove(j); 
        throw new NullPointerException(str1);
      } 
      str.add(t);
    } 
  }
  
  public final byte[] toByteArray() {
    try {
      byte[] arrayOfByte = new byte[zzly()];
      zzeg zzeg = zzeg.zzh(arrayOfByte);
      zzb(zzeg);
      zzeg.zzlk();
      return arrayOfByte;
    } catch (IOException iOException) {
      String str = getClass().getName();
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 62 + String.valueOf("byte array").length());
      stringBuilder.append("Serializing ");
      stringBuilder.append(str);
      stringBuilder.append(" to a ");
      stringBuilder.append("byte array");
      stringBuilder.append(" threw an IOException (should never happen).");
      throw new RuntimeException(stringBuilder.toString(), iOException);
    } 
  }
  
  public final zzdp zzjv() {
    try {
      zzdx zzdx = zzdp.zzt(zzly());
      zzb(zzdx.zzki());
      return zzdx.zzkh();
    } catch (IOException iOException) {
      String str = getClass().getName();
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 62 + String.valueOf("ByteString").length());
      stringBuilder.append("Serializing ");
      stringBuilder.append(str);
      stringBuilder.append(" to a ");
      stringBuilder.append("ByteString");
      stringBuilder.append(" threw an IOException (should never happen).");
      throw new RuntimeException(stringBuilder.toString(), iOException);
    } 
  }
  
  int zzjw() {
    throw new UnsupportedOperationException();
  }
  
  void zzn(int paramInt) {
    throw new UnsupportedOperationException();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */