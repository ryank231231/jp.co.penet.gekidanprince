package com.google.android.gms.internal.clearcut;

final class zzdf implements zzdn {
  private zzdn[] zzma;
  
  zzdf(zzdn... paramVarArgs) {
    this.zzma = paramVarArgs;
  }
  
  public final boolean zza(Class<?> paramClass) {
    zzdn[] arrayOfZzdn = this.zzma;
    int i = arrayOfZzdn.length;
    for (byte b = 0; b < i; b++) {
      if (arrayOfZzdn[b].zza(paramClass))
        return true; 
    } 
    return false;
  }
  
  public final zzdm zzb(Class<?> paramClass) {
    for (zzdn zzdn1 : this.zzma) {
      if (zzdn1.zza(paramClass))
        return zzdn1.zzb(paramClass); 
    } 
    String str = String.valueOf(paramClass.getName());
    if (str.length() != 0) {
      str = "No factory is available for message type: ".concat(str);
    } else {
      str = new String("No factory is available for message type: ");
    } 
    throw new UnsupportedOperationException(str);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */