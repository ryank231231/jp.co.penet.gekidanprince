package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public abstract class zzas<MessageType extends zzas<MessageType, BuilderType>, BuilderType extends zzat<MessageType, BuilderType>> implements zzdo {
  private static boolean zzey = false;
  
  protected int zzex = 0;
  
  void zzf(int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  public final zzbb zzr() {
    try {
      zzbg zzbg = zzbb.zzk(zzas());
      zzb(zzbg.zzae());
      return zzbg.zzad();
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
  
  int zzs() {
    throw new UnsupportedOperationException();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */